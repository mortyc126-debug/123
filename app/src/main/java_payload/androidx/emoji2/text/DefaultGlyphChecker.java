/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Paint
 *  android.text.TextPaint
 */
package androidx.emoji2.text;

import android.graphics.Paint;
import android.text.TextPaint;
import androidx.core.graphics.PaintCompat;
import androidx.emoji2.text.EmojiCompat;

class DefaultGlyphChecker
implements EmojiCompat.GlyphChecker {
    private static final int PAINT_TEXT_SIZE = 10;
    private static final ThreadLocal<StringBuilder> sStringBuilder = new ThreadLocal();
    private final TextPaint mTextPaint = new TextPaint();

    DefaultGlyphChecker() {
        this.mTextPaint.setTextSize(10.0f);
    }

    private static StringBuilder getStringBuilder() {
        if (sStringBuilder.get() == null) {
            sStringBuilder.set(new StringBuilder());
        }
        return sStringBuilder.get();
    }

    @Override
    public boolean hasGlyph(CharSequence charSequence, int n, int n2, int n3) {
        StringBuilder stringBuilder = DefaultGlyphChecker.getStringBuilder();
        stringBuilder.setLength(0);
        while (n < n2) {
            stringBuilder.append(charSequence.charAt(n));
            ++n;
        }
        return PaintCompat.hasGlyph((Paint)this.mTextPaint, stringBuilder.toString());
    }
}

