/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Paint
 *  android.graphics.Paint$FontMetricsInt
 *  android.text.style.ReplacementSpan
 */
package androidx.emoji2.text;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiMetadata;

public abstract class EmojiSpan
extends ReplacementSpan {
    private short mHeight;
    private final EmojiMetadata mMetadata;
    private float mRatio = 1.0f;
    private final Paint.FontMetricsInt mTmpFontMetrics = new Paint.FontMetricsInt();
    private short mWidth = (short)-1;

    EmojiSpan(EmojiMetadata emojiMetadata) {
        this.mHeight = (short)-1;
        Preconditions.checkNotNull(emojiMetadata, "metadata cannot be null");
        this.mMetadata = emojiMetadata;
    }

    public final int getHeight() {
        return this.mHeight;
    }

    public final int getId() {
        return this.getMetadata().getId();
    }

    public final EmojiMetadata getMetadata() {
        return this.mMetadata;
    }

    final float getRatio() {
        return this.mRatio;
    }

    public int getSize(Paint paint, CharSequence charSequence, int n, int n2, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.mTmpFontMetrics);
        this.mRatio = (float)Math.abs(this.mTmpFontMetrics.descent - this.mTmpFontMetrics.ascent) * 1.0f / (float)this.mMetadata.getHeight();
        this.mHeight = (short)((float)this.mMetadata.getHeight() * this.mRatio);
        this.mWidth = (short)((float)this.mMetadata.getWidth() * this.mRatio);
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = this.mTmpFontMetrics.ascent;
            fontMetricsInt.descent = this.mTmpFontMetrics.descent;
            fontMetricsInt.top = this.mTmpFontMetrics.top;
            fontMetricsInt.bottom = this.mTmpFontMetrics.bottom;
        }
        return this.mWidth;
    }

    final int getWidth() {
        return this.mWidth;
    }
}

