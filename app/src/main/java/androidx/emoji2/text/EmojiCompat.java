/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.text.Editable
 *  android.view.KeyEvent
 *  android.view.inputmethod.EditorInfo
 *  android.view.inputmethod.InputConnection
 */
package androidx.emoji2.text;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.collection.ArraySet;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.DefaultEmojiCompatConfig;
import androidx.emoji2.text.DefaultGlyphChecker;
import androidx.emoji2.text.EmojiMetadata;
import androidx.emoji2.text.EmojiProcessor;
import androidx.emoji2.text.EmojiSpan;
import androidx.emoji2.text.MetadataRepo;
import androidx.emoji2.text.TypefaceEmojiSpan;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class EmojiCompat {
    private static final Object CONFIG_LOCK;
    public static final String EDITOR_INFO_METAVERSION_KEY = "android.support.text.emoji.emojiCompat_metadataVersion";
    public static final String EDITOR_INFO_REPLACE_ALL_KEY = "android.support.text.emoji.emojiCompat_replaceAll";
    static final int EMOJI_COUNT_UNLIMITED = Integer.MAX_VALUE;
    public static final int EMOJI_FALLBACK = 2;
    public static final int EMOJI_SUPPORTED = 1;
    public static final int EMOJI_UNSUPPORTED = 0;
    private static final Object INSTANCE_LOCK;
    public static final int LOAD_STATE_DEFAULT = 3;
    public static final int LOAD_STATE_FAILED = 2;
    public static final int LOAD_STATE_LOADING = 0;
    public static final int LOAD_STATE_SUCCEEDED = 1;
    public static final int LOAD_STRATEGY_DEFAULT = 0;
    public static final int LOAD_STRATEGY_MANUAL = 1;
    private static final String NOT_INITIALIZED_ERROR_TEXT = "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.";
    public static final int REPLACE_STRATEGY_ALL = 1;
    public static final int REPLACE_STRATEGY_DEFAULT = 0;
    public static final int REPLACE_STRATEGY_NON_EXISTENT = 2;
    private static volatile boolean sHasDoneDefaultConfigLookup;
    private static volatile EmojiCompat sInstance;
    final int[] mEmojiAsDefaultStyleExceptions;
    private final int mEmojiSpanIndicatorColor;
    private final boolean mEmojiSpanIndicatorEnabled;
    private final GlyphChecker mGlyphChecker;
    private final CompatInternal mHelper;
    private final Set<InitCallback> mInitCallbacks;
    private final ReadWriteLock mInitLock = new ReentrantReadWriteLock();
    private volatile int mLoadState = 3;
    private final Handler mMainHandler;
    private final int mMetadataLoadStrategy;
    final MetadataRepoLoader mMetadataLoader;
    final boolean mReplaceAll;
    final boolean mUseEmojiAsDefaultStyle;

    static {
        INSTANCE_LOCK = new Object();
        CONFIG_LOCK = new Object();
    }

    private EmojiCompat(Config config) {
        this.mReplaceAll = config.mReplaceAll;
        this.mUseEmojiAsDefaultStyle = config.mUseEmojiAsDefaultStyle;
        this.mEmojiAsDefaultStyleExceptions = config.mEmojiAsDefaultStyleExceptions;
        this.mEmojiSpanIndicatorEnabled = config.mEmojiSpanIndicatorEnabled;
        this.mEmojiSpanIndicatorColor = config.mEmojiSpanIndicatorColor;
        this.mMetadataLoader = config.mMetadataLoader;
        this.mMetadataLoadStrategy = config.mMetadataLoadStrategy;
        this.mGlyphChecker = config.mGlyphChecker;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mInitCallbacks = new ArraySet<InitCallback>();
        if (config.mInitCallbacks != null && !config.mInitCallbacks.isEmpty()) {
            this.mInitCallbacks.addAll(config.mInitCallbacks);
        }
        this.mHelper = new CompatInternal19(this);
        this.loadMetadata();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static EmojiCompat get() {
        Object object = INSTANCE_LOCK;
        synchronized (object) {
            EmojiCompat emojiCompat = sInstance;
            boolean bl = emojiCompat != null;
            Preconditions.checkState(bl, NOT_INITIALIZED_ERROR_TEXT);
            return emojiCompat;
        }
    }

    public static boolean handleDeleteSurroundingText(InputConnection inputConnection, Editable editable, int n, int n2, boolean bl) {
        return EmojiProcessor.handleDeleteSurroundingText(inputConnection, editable, n, n2, bl);
    }

    public static boolean handleOnKeyDown(Editable editable, int n, KeyEvent keyEvent) {
        return EmojiProcessor.handleOnKeyDown(editable, n, keyEvent);
    }

    public static EmojiCompat init(Context context) {
        return EmojiCompat.init(context, null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static EmojiCompat init(Context object, DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory object2) {
        if (sHasDoneDefaultConfigLookup) {
            return sInstance;
        }
        if (object2 == null) {
            object2 = new DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory(null);
        }
        object2 = ((DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory)object2).create((Context)object);
        object = CONFIG_LOCK;
        synchronized (object) {
            if (sHasDoneDefaultConfigLookup) return sInstance;
            if (object2 != null) {
                EmojiCompat.init((Config)object2);
            }
            sHasDoneDefaultConfigLookup = true;
            return sInstance;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static EmojiCompat init(Config config) {
        EmojiCompat emojiCompat;
        EmojiCompat emojiCompat2 = emojiCompat = sInstance;
        if (emojiCompat != null) return emojiCompat2;
        Object object = INSTANCE_LOCK;
        synchronized (object) {
            emojiCompat2 = emojiCompat = sInstance;
            if (emojiCompat != null) return emojiCompat2;
            sInstance = emojiCompat2 = new EmojiCompat(config);
            return emojiCompat2;
        }
    }

    public static boolean isConfigured() {
        boolean bl = sInstance != null;
        return bl;
    }

    private boolean isInitialized() {
        int n = this.getLoadState();
        boolean bl = true;
        if (n != 1) {
            bl = false;
        }
        return bl;
    }

    private void loadMetadata() {
        this.mInitLock.writeLock().lock();
        try {
            if (this.mMetadataLoadStrategy == 0) {
                this.mLoadState = 0;
            }
            if (this.getLoadState() == 0) {
                this.mHelper.loadMetadata();
            }
            return;
        }
        finally {
            this.mInitLock.writeLock().unlock();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static EmojiCompat reset(Config config) {
        Object object = INSTANCE_LOCK;
        synchronized (object) {
            EmojiCompat emojiCompat;
            sInstance = emojiCompat = new EmojiCompat(config);
            return emojiCompat;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static EmojiCompat reset(EmojiCompat emojiCompat) {
        Object object = INSTANCE_LOCK;
        synchronized (object) {
            sInstance = emojiCompat;
            return sInstance;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void skipDefaultConfigurationLookup(boolean bl) {
        Object object = CONFIG_LOCK;
        synchronized (object) {
            sHasDoneDefaultConfigLookup = bl;
            return;
        }
    }

    public String getAssetSignature() {
        Preconditions.checkState(this.isInitialized(), "Not initialized yet");
        return this.mHelper.getAssetSignature();
    }

    public int getEmojiMatch(CharSequence charSequence, int n) {
        Preconditions.checkState(this.isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(charSequence, "sequence cannot be null");
        return this.mHelper.getEmojiMatch(charSequence, n);
    }

    public int getEmojiSpanIndicatorColor() {
        return this.mEmojiSpanIndicatorColor;
    }

    public int getLoadState() {
        this.mInitLock.readLock().lock();
        try {
            int n = this.mLoadState;
            return n;
        }
        finally {
            this.mInitLock.readLock().unlock();
        }
    }

    @Deprecated
    public boolean hasEmojiGlyph(CharSequence charSequence) {
        Preconditions.checkState(this.isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(charSequence, "sequence cannot be null");
        return this.mHelper.hasEmojiGlyph(charSequence);
    }

    @Deprecated
    public boolean hasEmojiGlyph(CharSequence charSequence, int n) {
        Preconditions.checkState(this.isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(charSequence, "sequence cannot be null");
        return this.mHelper.hasEmojiGlyph(charSequence, n);
    }

    public boolean isEmojiSpanIndicatorEnabled() {
        return this.mEmojiSpanIndicatorEnabled;
    }

    public void load() {
        block6: {
            int n = this.mMetadataLoadStrategy;
            boolean bl = true;
            if (n != 1) {
                bl = false;
            }
            Preconditions.checkState(bl, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
            if (this.isInitialized()) {
                return;
            }
            this.mInitLock.writeLock().lock();
            n = this.mLoadState;
            if (n != 0) break block6;
            this.mInitLock.writeLock().unlock();
            return;
        }
        try {
            this.mLoadState = 0;
            this.mHelper.loadMetadata();
            return;
        }
        finally {
            this.mInitLock.writeLock().unlock();
        }
    }

    void onMetadataLoadFailed(Throwable throwable) {
        ArrayList<InitCallback> arrayList = new ArrayList<InitCallback>();
        this.mInitLock.writeLock().lock();
        this.mLoadState = 2;
        arrayList.addAll(this.mInitCallbacks);
        this.mInitCallbacks.clear();
        this.mMainHandler.post((Runnable)new ListenerDispatcher(arrayList, this.mLoadState, throwable));
        return;
        finally {
            this.mInitLock.writeLock().unlock();
        }
    }

    void onMetadataLoadSuccess() {
        ArrayList<InitCallback> arrayList = new ArrayList<InitCallback>();
        this.mInitLock.writeLock().lock();
        this.mLoadState = 1;
        arrayList.addAll(this.mInitCallbacks);
        this.mInitCallbacks.clear();
        this.mMainHandler.post((Runnable)new ListenerDispatcher(arrayList, this.mLoadState));
        return;
        finally {
            this.mInitLock.writeLock().unlock();
        }
    }

    public CharSequence process(CharSequence charSequence) {
        int n = charSequence == null ? 0 : charSequence.length();
        return this.process(charSequence, 0, n);
    }

    public CharSequence process(CharSequence charSequence, int n, int n2) {
        return this.process(charSequence, n, n2, Integer.MAX_VALUE);
    }

    public CharSequence process(CharSequence charSequence, int n, int n2, int n3) {
        return this.process(charSequence, n, n2, n3, 0);
    }

    public CharSequence process(CharSequence charSequence, int n, int n2, int n3, int n4) {
        Preconditions.checkState(this.isInitialized(), "Not initialized yet");
        Preconditions.checkArgumentNonnegative(n, "start cannot be negative");
        Preconditions.checkArgumentNonnegative(n2, "end cannot be negative");
        Preconditions.checkArgumentNonnegative(n3, "maxEmojiCount cannot be negative");
        boolean bl = true;
        boolean bl2 = n <= n2;
        Preconditions.checkArgument(bl2, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        bl2 = n <= charSequence.length();
        Preconditions.checkArgument(bl2, "start should be < than charSequence length");
        bl2 = n2 <= charSequence.length() ? bl : false;
        Preconditions.checkArgument(bl2, "end should be < than charSequence length");
        if (charSequence.length() != 0 && n != n2) {
            switch (n4) {
                default: {
                    bl2 = this.mReplaceAll;
                    break;
                }
                case 2: {
                    bl2 = false;
                    break;
                }
                case 1: {
                    bl2 = true;
                }
            }
            return this.mHelper.process(charSequence, n, n2, n3, bl2);
        }
        return charSequence;
    }

    public void registerInitCallback(InitCallback initCallback) {
        Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
        this.mInitLock.writeLock().lock();
        try {
            if (this.mLoadState != 1 && this.mLoadState != 2) {
                this.mInitCallbacks.add(initCallback);
            } else {
                Handler handler = this.mMainHandler;
                ListenerDispatcher listenerDispatcher = new ListenerDispatcher(initCallback, this.mLoadState);
                handler.post((Runnable)listenerDispatcher);
            }
            return;
        }
        finally {
            this.mInitLock.writeLock().unlock();
        }
    }

    public void unregisterInitCallback(InitCallback initCallback) {
        Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
        this.mInitLock.writeLock().lock();
        try {
            this.mInitCallbacks.remove(initCallback);
            return;
        }
        finally {
            this.mInitLock.writeLock().unlock();
        }
    }

    public void updateEditorInfo(EditorInfo editorInfo) {
        if (this.isInitialized() && editorInfo != null) {
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            this.mHelper.updateEditorInfoAttrs(editorInfo);
            return;
        }
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface CodepointSequenceMatchResult {
    }

    private static class CompatInternal {
        final EmojiCompat mEmojiCompat;

        CompatInternal(EmojiCompat emojiCompat) {
            this.mEmojiCompat = emojiCompat;
        }

        String getAssetSignature() {
            return "";
        }

        public int getEmojiMatch(CharSequence charSequence, int n) {
            return 0;
        }

        boolean hasEmojiGlyph(CharSequence charSequence) {
            return false;
        }

        boolean hasEmojiGlyph(CharSequence charSequence, int n) {
            return false;
        }

        void loadMetadata() {
            this.mEmojiCompat.onMetadataLoadSuccess();
        }

        CharSequence process(CharSequence charSequence, int n, int n2, int n3, boolean bl) {
            return charSequence;
        }

        void updateEditorInfoAttrs(EditorInfo editorInfo) {
        }
    }

    private static final class CompatInternal19
    extends CompatInternal {
        private volatile MetadataRepo mMetadataRepo;
        private volatile EmojiProcessor mProcessor;

        CompatInternal19(EmojiCompat emojiCompat) {
            super(emojiCompat);
        }

        @Override
        String getAssetSignature() {
            String string2;
            block0: {
                string2 = this.mMetadataRepo.getMetadataList().sourceSha();
                if (string2 != null) break block0;
                string2 = "";
            }
            return string2;
        }

        @Override
        public int getEmojiMatch(CharSequence charSequence, int n) {
            return this.mProcessor.getEmojiMatch(charSequence, n);
        }

        @Override
        boolean hasEmojiGlyph(CharSequence charSequence) {
            int n = this.mProcessor.getEmojiMatch(charSequence);
            boolean bl = true;
            if (n != 1) {
                bl = false;
            }
            return bl;
        }

        @Override
        boolean hasEmojiGlyph(CharSequence charSequence, int n) {
            n = this.mProcessor.getEmojiMatch(charSequence, n);
            boolean bl = true;
            if (n != 1) {
                bl = false;
            }
            return bl;
        }

        @Override
        void loadMetadata() {
            try {
                MetadataRepoLoaderCallback metadataRepoLoaderCallback = new MetadataRepoLoaderCallback(this){
                    final CompatInternal19 this$0;
                    {
                        this.this$0 = compatInternal19;
                    }

                    @Override
                    public void onFailed(Throwable throwable) {
                        this.this$0.mEmojiCompat.onMetadataLoadFailed(throwable);
                    }

                    @Override
                    public void onLoaded(MetadataRepo metadataRepo) {
                        this.this$0.onMetadataLoadSuccess(metadataRepo);
                    }
                };
                this.mEmojiCompat.mMetadataLoader.load(metadataRepoLoaderCallback);
            }
            catch (Throwable throwable) {
                this.mEmojiCompat.onMetadataLoadFailed(throwable);
            }
        }

        void onMetadataLoadSuccess(MetadataRepo metadataRepo) {
            if (metadataRepo == null) {
                this.mEmojiCompat.onMetadataLoadFailed(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.mMetadataRepo = metadataRepo;
            this.mProcessor = new EmojiProcessor(this.mMetadataRepo, new SpanFactory(), this.mEmojiCompat.mGlyphChecker, this.mEmojiCompat.mUseEmojiAsDefaultStyle, this.mEmojiCompat.mEmojiAsDefaultStyleExceptions);
            this.mEmojiCompat.onMetadataLoadSuccess();
        }

        @Override
        CharSequence process(CharSequence charSequence, int n, int n2, int n3, boolean bl) {
            return this.mProcessor.process(charSequence, n, n2, n3, bl);
        }

        @Override
        void updateEditorInfoAttrs(EditorInfo editorInfo) {
            editorInfo.extras.putInt(EmojiCompat.EDITOR_INFO_METAVERSION_KEY, this.mMetadataRepo.getMetadataVersion());
            editorInfo.extras.putBoolean(EmojiCompat.EDITOR_INFO_REPLACE_ALL_KEY, this.mEmojiCompat.mReplaceAll);
        }
    }

    public static abstract class Config {
        int[] mEmojiAsDefaultStyleExceptions;
        int mEmojiSpanIndicatorColor = -16711936;
        boolean mEmojiSpanIndicatorEnabled;
        GlyphChecker mGlyphChecker = new DefaultGlyphChecker();
        Set<InitCallback> mInitCallbacks;
        int mMetadataLoadStrategy = 0;
        final MetadataRepoLoader mMetadataLoader;
        boolean mReplaceAll;
        boolean mUseEmojiAsDefaultStyle;

        protected Config(MetadataRepoLoader metadataRepoLoader) {
            Preconditions.checkNotNull(metadataRepoLoader, "metadataLoader cannot be null.");
            this.mMetadataLoader = metadataRepoLoader;
        }

        protected final MetadataRepoLoader getMetadataRepoLoader() {
            return this.mMetadataLoader;
        }

        public Config registerInitCallback(InitCallback initCallback) {
            Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
            if (this.mInitCallbacks == null) {
                this.mInitCallbacks = new ArraySet<InitCallback>();
            }
            this.mInitCallbacks.add(initCallback);
            return this;
        }

        public Config setEmojiSpanIndicatorColor(int n) {
            this.mEmojiSpanIndicatorColor = n;
            return this;
        }

        public Config setEmojiSpanIndicatorEnabled(boolean bl) {
            this.mEmojiSpanIndicatorEnabled = bl;
            return this;
        }

        public Config setGlyphChecker(GlyphChecker glyphChecker) {
            Preconditions.checkNotNull(glyphChecker, "GlyphChecker cannot be null");
            this.mGlyphChecker = glyphChecker;
            return this;
        }

        public Config setMetadataLoadStrategy(int n) {
            this.mMetadataLoadStrategy = n;
            return this;
        }

        public Config setReplaceAll(boolean bl) {
            this.mReplaceAll = bl;
            return this;
        }

        public Config setUseEmojiAsDefaultStyle(boolean bl) {
            return this.setUseEmojiAsDefaultStyle(bl, null);
        }

        public Config setUseEmojiAsDefaultStyle(boolean bl, List<Integer> object) {
            this.mUseEmojiAsDefaultStyle = bl;
            if (this.mUseEmojiAsDefaultStyle && object != null) {
                this.mEmojiAsDefaultStyleExceptions = new int[object.size()];
                int n = 0;
                Iterator<Integer> iterator2 = object.iterator();
                while (iterator2.hasNext()) {
                    object = iterator2.next();
                    this.mEmojiAsDefaultStyleExceptions[n] = (Integer)object;
                    ++n;
                }
                Arrays.sort(this.mEmojiAsDefaultStyleExceptions);
            } else {
                this.mEmojiAsDefaultStyleExceptions = null;
            }
            return this;
        }

        public Config unregisterInitCallback(InitCallback initCallback) {
            Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
            if (this.mInitCallbacks != null) {
                this.mInitCallbacks.remove(initCallback);
            }
            return this;
        }
    }

    public static interface GlyphChecker {
        public boolean hasGlyph(CharSequence var1, int var2, int var3, int var4);
    }

    public static abstract class InitCallback {
        public void onFailed(Throwable throwable) {
        }

        public void onInitialized() {
        }
    }

    private static class ListenerDispatcher
    implements Runnable {
        private final List<InitCallback> mInitCallbacks;
        private final int mLoadState;
        private final Throwable mThrowable;

        ListenerDispatcher(InitCallback initCallback, int n) {
            this(Arrays.asList(Preconditions.checkNotNull(initCallback, "initCallback cannot be null")), n, null);
        }

        ListenerDispatcher(Collection<InitCallback> collection, int n) {
            this(collection, n, null);
        }

        ListenerDispatcher(Collection<InitCallback> collection, int n, Throwable throwable) {
            Preconditions.checkNotNull(collection, "initCallbacks cannot be null");
            this.mInitCallbacks = new ArrayList<InitCallback>(collection);
            this.mLoadState = n;
            this.mThrowable = throwable;
        }

        @Override
        public void run() {
            block5: {
                int n = this.mInitCallbacks.size();
                switch (this.mLoadState) {
                    default: {
                        break;
                    }
                    case 1: {
                        for (int i = 0; i < n; ++i) {
                            this.mInitCallbacks.get(i).onInitialized();
                        }
                        break block5;
                    }
                }
                for (int i = 0; i < n; ++i) {
                    this.mInitCallbacks.get(i).onFailed(this.mThrowable);
                }
            }
        }
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface LoadStrategy {
    }

    public static interface MetadataRepoLoader {
        public void load(MetadataRepoLoaderCallback var1);
    }

    public static abstract class MetadataRepoLoaderCallback {
        public abstract void onFailed(Throwable var1);

        public abstract void onLoaded(MetadataRepo var1);
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface ReplaceStrategy {
    }

    static class SpanFactory {
        SpanFactory() {
        }

        EmojiSpan createSpan(EmojiMetadata emojiMetadata) {
            return new TypefaceEmojiSpan(emojiMetadata);
        }
    }
}

