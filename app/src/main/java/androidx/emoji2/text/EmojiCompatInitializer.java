/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package androidx.emoji2.text;

import android.content.Context;
import androidx.core.os.TraceCompat;
import androidx.emoji2.text.ConcurrencyHelpers;
import androidx.emoji2.text.DefaultEmojiCompatConfig;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.EmojiCompatInitializer$BackgroundDefaultLoader$$ExternalSyntheticLambda0;
import androidx.emoji2.text.FontRequestEmojiCompatConfig;
import androidx.emoji2.text.MetadataRepo;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public class EmojiCompatInitializer
implements Initializer<Boolean> {
    private static final long STARTUP_THREAD_CREATION_DELAY_MS = 500L;
    private static final String S_INITIALIZER_THREAD_NAME = "EmojiCompatInitializer";

    @Override
    public Boolean create(Context context) {
        EmojiCompat.init(new BackgroundDefaultConfig(context));
        this.delayUntilFirstResume(context);
        return true;
    }

    void delayUntilFirstResume(Context object) {
        object = ((LifecycleOwner)AppInitializer.getInstance((Context)object).initializeComponent(ProcessLifecycleInitializer.class)).getLifecycle();
        ((Lifecycle)object).addObserver(new DefaultLifecycleObserver(this, (Lifecycle)object){
            final EmojiCompatInitializer this$0;
            final Lifecycle val$lifecycle;
            {
                this.this$0 = emojiCompatInitializer;
                this.val$lifecycle = lifecycle;
            }

            @Override
            public void onResume(LifecycleOwner lifecycleOwner) {
                this.this$0.loadEmojiCompatAfterDelay();
                this.val$lifecycle.removeObserver(this);
            }
        });
    }

    @Override
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    void loadEmojiCompatAfterDelay() {
        ConcurrencyHelpers.mainHandlerAsync().postDelayed((Runnable)new LoadEmojiCompatRunnable(), 500L);
    }

    static class BackgroundDefaultConfig
    extends EmojiCompat.Config {
        protected BackgroundDefaultConfig(Context context) {
            super(new BackgroundDefaultLoader(context));
            this.setMetadataLoadStrategy(1);
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    static class BackgroundDefaultLoader
    implements EmojiCompat.MetadataRepoLoader {
        private final Context mContext;

        BackgroundDefaultLoader(Context context) {
            this.mContext = context.getApplicationContext();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        void doLoad(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback, ThreadPoolExecutor threadPoolExecutor) {
            try {
                EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback2 = DefaultEmojiCompatConfig.create(this.mContext);
                if (metadataRepoLoaderCallback2 != null) {
                    ((FontRequestEmojiCompatConfig)((Object)metadataRepoLoaderCallback2)).setLoadingExecutor(threadPoolExecutor);
                    EmojiCompat.MetadataRepoLoader metadataRepoLoader = ((EmojiCompat.Config)((Object)metadataRepoLoaderCallback2)).getMetadataRepoLoader();
                    metadataRepoLoaderCallback2 = new EmojiCompat.MetadataRepoLoaderCallback(this, metadataRepoLoaderCallback, threadPoolExecutor){
                        final BackgroundDefaultLoader this$0;
                        final ThreadPoolExecutor val$executor;
                        final EmojiCompat.MetadataRepoLoaderCallback val$loaderCallback;
                        {
                            this.this$0 = backgroundDefaultLoader;
                            this.val$loaderCallback = metadataRepoLoaderCallback;
                            this.val$executor = threadPoolExecutor;
                        }

                        @Override
                        public void onFailed(Throwable throwable) {
                            try {
                                this.val$loaderCallback.onFailed(throwable);
                                return;
                            }
                            finally {
                                this.val$executor.shutdown();
                            }
                        }

                        @Override
                        public void onLoaded(MetadataRepo metadataRepo) {
                            try {
                                this.val$loaderCallback.onLoaded(metadataRepo);
                                return;
                            }
                            finally {
                                this.val$executor.shutdown();
                            }
                        }
                    };
                    metadataRepoLoader.load(metadataRepoLoaderCallback2);
                    return;
                }
                metadataRepoLoaderCallback2 = new RuntimeException("EmojiCompat font provider not available on this device.");
                throw metadataRepoLoaderCallback2;
            }
            catch (Throwable throwable) {
                metadataRepoLoaderCallback.onFailed(throwable);
                threadPoolExecutor.shutdown();
            }
        }

        /* synthetic */ void lambda$load$0$androidx-emoji2-text-EmojiCompatInitializer$BackgroundDefaultLoader(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback, ThreadPoolExecutor threadPoolExecutor) {
            this.doLoad(metadataRepoLoaderCallback, threadPoolExecutor);
        }

        @Override
        public void load(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            ThreadPoolExecutor threadPoolExecutor = ConcurrencyHelpers.createBackgroundPriorityExecutor(EmojiCompatInitializer.S_INITIALIZER_THREAD_NAME);
            threadPoolExecutor.execute(new EmojiCompatInitializer$BackgroundDefaultLoader$$ExternalSyntheticLambda0(this, metadataRepoLoaderCallback, threadPoolExecutor));
        }
    }

    static class LoadEmojiCompatRunnable
    implements Runnable {
        LoadEmojiCompatRunnable() {
        }

        @Override
        public void run() {
            try {
                TraceCompat.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                if (EmojiCompat.isConfigured()) {
                    EmojiCompat.get().load();
                }
                return;
            }
            finally {
                TraceCompat.endSection();
            }
        }
    }
}

