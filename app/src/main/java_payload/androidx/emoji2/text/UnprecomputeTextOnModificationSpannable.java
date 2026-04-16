/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.text.PrecomputedText
 *  android.text.Spannable
 *  android.text.SpannableString
 *  android.text.Spanned
 */
package androidx.emoji2.text;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import androidx.core.text.PrecomputedTextCompat;
import java.util.stream.IntStream;

class UnprecomputeTextOnModificationSpannable
implements Spannable {
    private Spannable mDelegate;
    private boolean mSafeToWrite = false;

    UnprecomputeTextOnModificationSpannable(Spannable spannable) {
        this.mDelegate = spannable;
    }

    UnprecomputeTextOnModificationSpannable(Spanned spanned) {
        this.mDelegate = new SpannableString((CharSequence)spanned);
    }

    UnprecomputeTextOnModificationSpannable(CharSequence charSequence) {
        this.mDelegate = new SpannableString(charSequence);
    }

    private void ensureSafeWrites() {
        Spannable spannable = this.mDelegate;
        if (!this.mSafeToWrite && UnprecomputeTextOnModificationSpannable.precomputedTextDetector().isPrecomputedText((CharSequence)spannable)) {
            this.mDelegate = new SpannableString((CharSequence)spannable);
        }
        this.mSafeToWrite = true;
    }

    static PrecomputedTextDetector precomputedTextDetector() {
        PrecomputedTextDetector precomputedTextDetector = Build.VERSION.SDK_INT < 28 ? new PrecomputedTextDetector() : new PrecomputedTextDetector_28();
        return precomputedTextDetector;
    }

    public char charAt(int n) {
        return this.mDelegate.charAt(n);
    }

    public IntStream chars() {
        return CharSequenceHelper_API24.chars((CharSequence)this.mDelegate);
    }

    public IntStream codePoints() {
        return CharSequenceHelper_API24.codePoints((CharSequence)this.mDelegate);
    }

    public int getSpanEnd(Object object) {
        return this.mDelegate.getSpanEnd(object);
    }

    public int getSpanFlags(Object object) {
        return this.mDelegate.getSpanFlags(object);
    }

    public int getSpanStart(Object object) {
        return this.mDelegate.getSpanStart(object);
    }

    public <T> T[] getSpans(int n, int n2, Class<T> clazz) {
        return this.mDelegate.getSpans(n, n2, clazz);
    }

    Spannable getUnwrappedSpannable() {
        return this.mDelegate;
    }

    public int length() {
        return this.mDelegate.length();
    }

    public int nextSpanTransition(int n, int n2, Class clazz) {
        return this.mDelegate.nextSpanTransition(n, n2, clazz);
    }

    public void removeSpan(Object object) {
        this.ensureSafeWrites();
        this.mDelegate.removeSpan(object);
    }

    public void setSpan(Object object, int n, int n2, int n3) {
        this.ensureSafeWrites();
        this.mDelegate.setSpan(object, n, n2, n3);
    }

    public CharSequence subSequence(int n, int n2) {
        return this.mDelegate.subSequence(n, n2);
    }

    public String toString() {
        return this.mDelegate.toString();
    }

    private static class CharSequenceHelper_API24 {
        private CharSequenceHelper_API24() {
        }

        static IntStream chars(CharSequence charSequence) {
            return charSequence.chars();
        }

        static IntStream codePoints(CharSequence charSequence) {
            return charSequence.codePoints();
        }
    }

    static class PrecomputedTextDetector {
        PrecomputedTextDetector() {
        }

        boolean isPrecomputedText(CharSequence charSequence) {
            return charSequence instanceof PrecomputedTextCompat;
        }
    }

    static class PrecomputedTextDetector_28
    extends PrecomputedTextDetector {
        PrecomputedTextDetector_28() {
        }

        @Override
        boolean isPrecomputedText(CharSequence charSequence) {
            boolean bl = charSequence instanceof PrecomputedText || charSequence instanceof PrecomputedTextCompat;
            return bl;
        }
    }
}

