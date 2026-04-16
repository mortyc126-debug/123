/*
 * Decompiled with CFR 0.152.
 */
package androidx.emoji2.text;

import androidx.emoji2.text.FontRequestEmojiCompatConfig;

public final class FontRequestEmojiCompatConfig$FontRequestMetadataLoader$$ExternalSyntheticLambda0
implements Runnable {
    public final FontRequestEmojiCompatConfig.FontRequestMetadataLoader f$0;

    public /* synthetic */ FontRequestEmojiCompatConfig$FontRequestMetadataLoader$$ExternalSyntheticLambda0(FontRequestEmojiCompatConfig.FontRequestMetadataLoader fontRequestMetadataLoader) {
        this.f$0 = fontRequestMetadataLoader;
    }

    @Override
    public final void run() {
        this.f$0.createMetadata();
    }
}

