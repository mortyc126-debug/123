/*
 * Decompiled with CFR 0.152.
 */
package androidx.emoji2.text;

import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.EmojiCompatInitializer;
import java.util.concurrent.ThreadPoolExecutor;

public final class EmojiCompatInitializer$BackgroundDefaultLoader$$ExternalSyntheticLambda0
implements Runnable {
    public final EmojiCompatInitializer.BackgroundDefaultLoader f$0;
    public final EmojiCompat.MetadataRepoLoaderCallback f$1;
    public final ThreadPoolExecutor f$2;

    public /* synthetic */ EmojiCompatInitializer$BackgroundDefaultLoader$$ExternalSyntheticLambda0(EmojiCompatInitializer.BackgroundDefaultLoader backgroundDefaultLoader, EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback, ThreadPoolExecutor threadPoolExecutor) {
        this.f$0 = backgroundDefaultLoader;
        this.f$1 = metadataRepoLoaderCallback;
        this.f$2 = threadPoolExecutor;
    }

    @Override
    public final void run() {
        this.f$0.lambda$load$0$androidx-emoji2-text-EmojiCompatInitializer$BackgroundDefaultLoader(this.f$1, this.f$2);
    }
}

