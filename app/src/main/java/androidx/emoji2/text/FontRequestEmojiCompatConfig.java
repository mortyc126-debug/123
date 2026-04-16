/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.database.ContentObserver
 *  android.graphics.Typeface
 *  android.net.Uri
 *  android.os.Handler
 *  android.os.SystemClock
 */
package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.os.TraceCompat;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.ConcurrencyHelpers;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.FontRequestEmojiCompatConfig$FontRequestMetadataLoader$$ExternalSyntheticLambda0;
import androidx.emoji2.text.FontRequestEmojiCompatConfig$FontRequestMetadataLoader$$ExternalSyntheticLambda1;
import androidx.emoji2.text.MetadataRepo;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

public class FontRequestEmojiCompatConfig
extends EmojiCompat.Config {
    private static final FontProviderHelper DEFAULT_FONTS_CONTRACT = new FontProviderHelper();

    public FontRequestEmojiCompatConfig(Context context, FontRequest fontRequest) {
        super(new FontRequestMetadataLoader(context, fontRequest, DEFAULT_FONTS_CONTRACT));
    }

    public FontRequestEmojiCompatConfig(Context context, FontRequest fontRequest, FontProviderHelper fontProviderHelper) {
        super(new FontRequestMetadataLoader(context, fontRequest, fontProviderHelper));
    }

    @Deprecated
    public FontRequestEmojiCompatConfig setHandler(Handler handler) {
        if (handler == null) {
            return this;
        }
        this.setLoadingExecutor(ConcurrencyHelpers.convertHandlerToExecutor(handler));
        return this;
    }

    public FontRequestEmojiCompatConfig setLoadingExecutor(Executor executor) {
        ((FontRequestMetadataLoader)this.getMetadataRepoLoader()).setExecutor(executor);
        return this;
    }

    public FontRequestEmojiCompatConfig setRetryPolicy(RetryPolicy retryPolicy) {
        ((FontRequestMetadataLoader)this.getMetadataRepoLoader()).setRetryPolicy(retryPolicy);
        return this;
    }

    public static class ExponentialBackoffRetryPolicy
    extends RetryPolicy {
        private long mRetryOrigin;
        private final long mTotalMs;

        public ExponentialBackoffRetryPolicy(long l) {
            this.mTotalMs = l;
        }

        @Override
        public long getRetryDelay() {
            if (this.mRetryOrigin == 0L) {
                this.mRetryOrigin = SystemClock.uptimeMillis();
                return 0L;
            }
            long l = SystemClock.uptimeMillis() - this.mRetryOrigin;
            if (l > this.mTotalMs) {
                return -1L;
            }
            return Math.min(Math.max(l, 1000L), this.mTotalMs - l);
        }
    }

    public static class FontProviderHelper {
        public Typeface buildTypeface(Context context, FontsContractCompat.FontInfo fontInfo) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.buildTypeface(context, null, new FontsContractCompat.FontInfo[]{fontInfo});
        }

        public FontsContractCompat.FontFamilyResult fetchFonts(Context context, FontRequest fontRequest) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.fetchFonts(context, null, fontRequest);
        }

        public void registerObserver(Context context, Uri uri, ContentObserver contentObserver) {
            context.getContentResolver().registerContentObserver(uri, false, contentObserver);
        }

        public void unregisterObserver(Context context, ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    private static class FontRequestMetadataLoader
    implements EmojiCompat.MetadataRepoLoader {
        private static final String S_TRACE_BUILD_TYPEFACE = "EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface";
        EmojiCompat.MetadataRepoLoaderCallback mCallback;
        private final Context mContext;
        private Executor mExecutor;
        private final FontProviderHelper mFontProviderHelper;
        private final Object mLock = new Object();
        private Handler mMainHandler;
        private Runnable mMainHandlerLoadCallback;
        private ThreadPoolExecutor mMyThreadPoolExecutor;
        private ContentObserver mObserver;
        private final FontRequest mRequest;
        private RetryPolicy mRetryPolicy;

        FontRequestMetadataLoader(Context context, FontRequest fontRequest, FontProviderHelper fontProviderHelper) {
            Preconditions.checkNotNull(context, "Context cannot be null");
            Preconditions.checkNotNull(fontRequest, "FontRequest cannot be null");
            this.mContext = context.getApplicationContext();
            this.mRequest = fontRequest;
            this.mFontProviderHelper = fontProviderHelper;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        private void cleanUp() {
            Object object = this.mLock;
            synchronized (object) {
                this.mCallback = null;
                if (this.mObserver != null) {
                    this.mFontProviderHelper.unregisterObserver(this.mContext, this.mObserver);
                    this.mObserver = null;
                }
                if (this.mMainHandler != null) {
                    this.mMainHandler.removeCallbacks(this.mMainHandlerLoadCallback);
                }
                this.mMainHandler = null;
                if (this.mMyThreadPoolExecutor != null) {
                    this.mMyThreadPoolExecutor.shutdown();
                }
                this.mExecutor = null;
                this.mMyThreadPoolExecutor = null;
                return;
            }
        }

        private FontsContractCompat.FontInfo retrieveFontInfo() {
            FontsContractCompat.FontInfo[] fontInfoArray;
            block3: {
                try {
                    fontInfoArray = this.mFontProviderHelper.fetchFonts(this.mContext, this.mRequest);
                    if (fontInfoArray.getStatusCode() != 0) break block3;
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    throw new RuntimeException("provider not found", nameNotFoundException);
                }
                if ((fontInfoArray = fontInfoArray.getFonts()) != null && fontInfoArray.length != 0) {
                    return fontInfoArray[0];
                }
                throw new RuntimeException("fetchFonts failed (empty result)");
            }
            throw new RuntimeException("fetchFonts failed (" + fontInfoArray.getStatusCode() + ")");
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        private void scheduleRetry(Uri object, long l) {
            Object object2 = this.mLock;
            synchronized (object2) {
                Object object3;
                Handler handler = object3 = this.mMainHandler;
                if (object3 == null) {
                    this.mMainHandler = handler = ConcurrencyHelpers.mainHandlerAsync();
                }
                if (this.mObserver == null) {
                    object3 = new ContentObserver(this, handler){
                        final FontRequestMetadataLoader this$0;
                        {
                            this.this$0 = fontRequestMetadataLoader;
                            super(handler);
                        }

                        public void onChange(boolean bl, Uri uri) {
                            this.this$0.loadInternal();
                        }
                    };
                    this.mObserver = object3;
                    this.mFontProviderHelper.registerObserver(this.mContext, (Uri)object, this.mObserver);
                }
                if (this.mMainHandlerLoadCallback == null) {
                    object = new FontRequestEmojiCompatConfig$FontRequestMetadataLoader$$ExternalSyntheticLambda1(this);
                    this.mMainHandlerLoadCallback = object;
                }
                handler.postDelayed(this.mMainHandlerLoadCallback, l);
                return;
            }
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Converted monitor instructions to comments
         * Lifted jumps to return sites
         */
        void createMetadata() {
            block25: {
                block26: {
                    block24: {
                        var4_1 = this.mLock;
                        // MONITORENTER : var4_1
                        if (this.mCallback == null) {
                            // MONITOREXIT : var4_1
                            return;
                        }
                        // MONITOREXIT : var4_1
                        var5_3 = this.retrieveFontInfo();
                        var1_5 = var5_3.getResultCode();
                        if (var1_5 != 2) break;
                        var4_1 = this.mLock;
                        // MONITORENTER : var4_1
                        if (this.mRetryPolicy == null || (var2_6 = this.mRetryPolicy.getRetryDelay()) < 0L) break block24;
                        this.scheduleRetry(var5_3.getUri(), var2_6);
                        // MONITOREXIT : var4_1
                        return;
                    }
                    // MONITOREXIT : var4_1
                    if (var1_5 != 0) ** GOTO lbl46
                    TraceCompat.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                    var4_1 = this.mFontProviderHelper.buildTypeface(this.mContext, (FontsContractCompat.FontInfo)var5_3);
                    var5_3 = TypefaceCompatUtil.mmap(this.mContext, null, var5_3.getUri());
                    if (var5_3 == null || var4_1 == null) break block25;
                    var5_3 = MetadataRepo.create((Typeface)var4_1, (ByteBuffer)var5_3);
                    TraceCompat.endSection();
                    var4_1 = this.mLock;
                    // MONITORENTER : var4_1
                    if (this.mCallback == null) break block26;
                    this.mCallback.onLoaded((MetadataRepo)var5_3);
                }
                // MONITOREXIT : var4_1
                this.cleanUp();
                return;
            }
            try {
                var4_1 = new RuntimeException("Unable to open file.");
                throw var4_1;
            }
            catch (Throwable var4_2) {
                try {
                    TraceCompat.endSection();
                    throw var4_2;
lbl46:
                    // 1 sources

                    var5_3 = new StringBuilder();
                    var4_1 = new RuntimeException(var5_3.append("fetchFonts result is not OK. (").append(var1_5).append(")").toString());
                    throw var4_1;
                }
                catch (Throwable var5_4) {
                    var4_1 = this.mLock;
                    // MONITORENTER : var4_1
                    if (this.mCallback != null) {
                        this.mCallback.onFailed(var5_4);
                    }
                    // MONITOREXIT : var4_1
                    this.cleanUp();
                }
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void load(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            Preconditions.checkNotNull(metadataRepoLoaderCallback, "LoaderCallback cannot be null");
            Object object = this.mLock;
            synchronized (object) {
                this.mCallback = metadataRepoLoaderCallback;
            }
            this.loadInternal();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        void loadInternal() {
            Object object = this.mLock;
            synchronized (object) {
                if (this.mCallback == null) {
                    return;
                }
                if (this.mExecutor == null) {
                    this.mMyThreadPoolExecutor = ConcurrencyHelpers.createBackgroundPriorityExecutor("emojiCompat");
                    this.mExecutor = this.mMyThreadPoolExecutor;
                }
                Executor executor = this.mExecutor;
                FontRequestEmojiCompatConfig$FontRequestMetadataLoader$$ExternalSyntheticLambda0 fontRequestEmojiCompatConfig$FontRequestMetadataLoader$$ExternalSyntheticLambda0 = new FontRequestEmojiCompatConfig$FontRequestMetadataLoader$$ExternalSyntheticLambda0(this);
                executor.execute(fontRequestEmojiCompatConfig$FontRequestMetadataLoader$$ExternalSyntheticLambda0);
                return;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void setExecutor(Executor executor) {
            Object object = this.mLock;
            synchronized (object) {
                this.mExecutor = executor;
                return;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void setRetryPolicy(RetryPolicy retryPolicy) {
            Object object = this.mLock;
            synchronized (object) {
                this.mRetryPolicy = retryPolicy;
                return;
            }
        }
    }

    public static abstract class RetryPolicy {
        public abstract long getRetryDelay();
    }
}

