/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.text.TextPaint
 */
package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.EmojiMetadata;
import androidx.emoji2.text.EmojiSpan;

public final class TypefaceEmojiSpan
extends EmojiSpan {
    private static Paint sDebugPaint;

    public TypefaceEmojiSpan(EmojiMetadata emojiMetadata) {
        super(emojiMetadata);
    }

    private static Paint getDebugPaint() {
        if (sDebugPaint == null) {
            sDebugPaint = new TextPaint();
            sDebugPaint.setColor(EmojiCompat.get().getEmojiSpanIndicatorColor());
            sDebugPaint.setStyle(Paint.Style.FILL);
        }
        return sDebugPaint;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int n, int n2, float f, int n3, int n4, int n5, Paint paint) {
        if (EmojiCompat.get().isEmojiSpanIndicatorEnabled()) {
            canvas.drawRect(f, (float)n3, f + (float)this.getWidth(), (float)n5, TypefaceEmojiSpan.getDebugPaint());
        }
        this.getMetadata().draw(canvas, f, n4, paint);
    }
}

