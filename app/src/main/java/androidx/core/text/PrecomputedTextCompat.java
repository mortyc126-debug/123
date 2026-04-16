/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.text.PrecomputedText
 *  android.text.PrecomputedText$Params
 *  android.text.PrecomputedText$Params$Builder
 *  android.text.Spannable
 *  android.text.SpannableString
 *  android.text.TextDirectionHeuristic
 *  android.text.TextDirectionHeuristics
 *  android.text.TextPaint
 *  android.text.TextUtils
 *  android.text.style.MetricAffectingSpan
 */
package androidx.core.text;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class PrecomputedTextCompat
implements Spannable {
    private static final char LINE_FEED = '\n';
    private static Executor sExecutor;
    private static final Object sLock;
    private final int[] mParagraphEnds;
    private final Params mParams;
    private final Spannable mText;
    private final PrecomputedText mWrapped;

    static {
        sLock = new Object();
        sExecutor = null;
    }

    private PrecomputedTextCompat(PrecomputedText precomputedText, Params params) {
        this.mText = Api28Impl.castToSpannable(precomputedText);
        this.mParams = params;
        params = null;
        this.mParagraphEnds = null;
        if (Build.VERSION.SDK_INT >= 29) {
            params = precomputedText;
        }
        this.mWrapped = params;
    }

    private PrecomputedTextCompat(CharSequence charSequence, Params params, int[] nArray) {
        this.mText = new SpannableString(charSequence);
        this.mParams = params;
        this.mParagraphEnds = nArray;
        this.mWrapped = null;
    }

    /*
     * Exception decompiling
     */
    public static PrecomputedTextCompat create(CharSequence var0, Params var1_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [8[WHILELOOP]], but top level block is 3[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Future<PrecomputedTextCompat> getTextFuture(CharSequence object, Params object2, Executor object3) {
        object2 = new PrecomputedTextFutureTask((Params)object2, (CharSequence)object);
        object = object3;
        if (object3 == null) {
            object3 = sLock;
            synchronized (object3) {
                if (sExecutor == null) {
                    sExecutor = Executors.newFixedThreadPool(1);
                }
                object = sExecutor;
            }
        }
        object.execute((Runnable)object2);
        return object2;
    }

    public char charAt(int n) {
        return this.mText.charAt(n);
    }

    public int getParagraphCount() {
        if (Build.VERSION.SDK_INT >= 29) {
            return this.mWrapped.getParagraphCount();
        }
        return this.mParagraphEnds.length;
    }

    public int getParagraphEnd(int n) {
        Preconditions.checkArgumentInRange(n, 0, this.getParagraphCount(), "paraIndex");
        if (Build.VERSION.SDK_INT >= 29) {
            return this.mWrapped.getParagraphEnd(n);
        }
        return this.mParagraphEnds[n];
    }

    public int getParagraphStart(int n) {
        int n2 = this.getParagraphCount();
        int n3 = 0;
        Preconditions.checkArgumentInRange(n, 0, n2, "paraIndex");
        if (Build.VERSION.SDK_INT >= 29) {
            return this.mWrapped.getParagraphStart(n);
        }
        n = n == 0 ? n3 : this.mParagraphEnds[n - 1];
        return n;
    }

    public Params getParams() {
        return this.mParams;
    }

    public PrecomputedText getPrecomputedText() {
        if (this.mText instanceof PrecomputedText) {
            return (PrecomputedText)this.mText;
        }
        return null;
    }

    public int getSpanEnd(Object object) {
        return this.mText.getSpanEnd(object);
    }

    public int getSpanFlags(Object object) {
        return this.mText.getSpanFlags(object);
    }

    public int getSpanStart(Object object) {
        return this.mText.getSpanStart(object);
    }

    public <T> T[] getSpans(int n, int n2, Class<T> clazz) {
        if (Build.VERSION.SDK_INT >= 29) {
            return this.mWrapped.getSpans(n, n2, clazz);
        }
        return this.mText.getSpans(n, n2, clazz);
    }

    public int length() {
        return this.mText.length();
    }

    public int nextSpanTransition(int n, int n2, Class clazz) {
        return this.mText.nextSpanTransition(n, n2, clazz);
    }

    public void removeSpan(Object object) {
        if (!(object instanceof MetricAffectingSpan)) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.mWrapped.removeSpan(object);
            } else {
                this.mText.removeSpan(object);
            }
            return;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    public void setSpan(Object object, int n, int n2, int n3) {
        if (!(object instanceof MetricAffectingSpan)) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.mWrapped.setSpan(object, n, n2, n3);
            } else {
                this.mText.setSpan(object, n, n2, n3);
            }
            return;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    public CharSequence subSequence(int n, int n2) {
        return this.mText.subSequence(n, n2);
    }

    public String toString() {
        return this.mText.toString();
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static Spannable castToSpannable(PrecomputedText precomputedText) {
            return precomputedText;
        }
    }

    public static final class Params {
        private final int mBreakStrategy;
        private final int mHyphenationFrequency;
        private final TextPaint mPaint;
        private final TextDirectionHeuristic mTextDir;
        final PrecomputedText.Params mWrapped;

        public Params(PrecomputedText.Params params) {
            this.mPaint = params.getTextPaint();
            this.mTextDir = params.getTextDirection();
            this.mBreakStrategy = params.getBreakStrategy();
            this.mHyphenationFrequency = params.getHyphenationFrequency();
            if (Build.VERSION.SDK_INT < 29) {
                params = null;
            }
            this.mWrapped = params;
        }

        Params(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int n, int n2) {
            this.mWrapped = Build.VERSION.SDK_INT >= 29 ? new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(n).setHyphenationFrequency(n2).setTextDirection(textDirectionHeuristic).build() : null;
            this.mPaint = textPaint;
            this.mTextDir = textDirectionHeuristic;
            this.mBreakStrategy = n;
            this.mHyphenationFrequency = n2;
        }

        public boolean equals(Object object) {
            boolean bl = true;
            if (object == this) {
                return true;
            }
            if (!(object instanceof Params)) {
                return false;
            }
            if (!this.equalsWithoutTextDirection((Params)(object = (Params)object))) {
                return false;
            }
            if (this.mTextDir != ((Params)object).getTextDirection()) {
                bl = false;
            }
            return bl;
        }

        public boolean equalsWithoutTextDirection(Params params) {
            if (this.mBreakStrategy != params.getBreakStrategy()) {
                return false;
            }
            if (this.mHyphenationFrequency != params.getHyphenationFrequency()) {
                return false;
            }
            if (this.mPaint.getTextSize() != params.getTextPaint().getTextSize()) {
                return false;
            }
            if (this.mPaint.getTextScaleX() != params.getTextPaint().getTextScaleX()) {
                return false;
            }
            if (this.mPaint.getTextSkewX() != params.getTextPaint().getTextSkewX()) {
                return false;
            }
            if (this.mPaint.getLetterSpacing() != params.getTextPaint().getLetterSpacing()) {
                return false;
            }
            if (!TextUtils.equals((CharSequence)this.mPaint.getFontFeatureSettings(), (CharSequence)params.getTextPaint().getFontFeatureSettings())) {
                return false;
            }
            if (this.mPaint.getFlags() != params.getTextPaint().getFlags()) {
                return false;
            }
            if (!this.mPaint.getTextLocales().equals((Object)params.getTextPaint().getTextLocales())) {
                return false;
            }
            return !(this.mPaint.getTypeface() == null ? params.getTextPaint().getTypeface() != null : !this.mPaint.getTypeface().equals((Object)params.getTextPaint().getTypeface()));
        }

        public int getBreakStrategy() {
            return this.mBreakStrategy;
        }

        public int getHyphenationFrequency() {
            return this.mHyphenationFrequency;
        }

        public TextDirectionHeuristic getTextDirection() {
            return this.mTextDir;
        }

        public TextPaint getTextPaint() {
            return this.mPaint;
        }

        public int hashCode() {
            return ObjectsCompat.hash(Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Float.valueOf(this.mPaint.getLetterSpacing()), this.mPaint.getFlags(), this.mPaint.getTextLocales(), this.mPaint.getTypeface(), this.mPaint.isElegantTextHeight(), this.mTextDir, this.mBreakStrategy, this.mHyphenationFrequency);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{");
            stringBuilder.append("textSize=" + this.mPaint.getTextSize());
            stringBuilder.append(", textScaleX=" + this.mPaint.getTextScaleX());
            stringBuilder.append(", textSkewX=" + this.mPaint.getTextSkewX());
            stringBuilder.append(", letterSpacing=" + this.mPaint.getLetterSpacing());
            stringBuilder.append(", elegantTextHeight=" + this.mPaint.isElegantTextHeight());
            stringBuilder.append(", textLocale=" + this.mPaint.getTextLocales());
            stringBuilder.append(", typeface=" + this.mPaint.getTypeface());
            if (Build.VERSION.SDK_INT >= 26) {
                stringBuilder.append(", variationSettings=" + this.mPaint.getFontVariationSettings());
            }
            stringBuilder.append(", textDir=" + this.mTextDir);
            stringBuilder.append(", breakStrategy=" + this.mBreakStrategy);
            stringBuilder.append(", hyphenationFrequency=" + this.mHyphenationFrequency);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        public static class Builder {
            private int mBreakStrategy;
            private int mHyphenationFrequency;
            private final TextPaint mPaint;
            private TextDirectionHeuristic mTextDir;

            public Builder(TextPaint textPaint) {
                this.mPaint = textPaint;
                this.mBreakStrategy = 1;
                this.mHyphenationFrequency = 1;
                this.mTextDir = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }

            public Params build() {
                return new Params(this.mPaint, this.mTextDir, this.mBreakStrategy, this.mHyphenationFrequency);
            }

            public Builder setBreakStrategy(int n) {
                this.mBreakStrategy = n;
                return this;
            }

            public Builder setHyphenationFrequency(int n) {
                this.mHyphenationFrequency = n;
                return this;
            }

            public Builder setTextDirection(TextDirectionHeuristic textDirectionHeuristic) {
                this.mTextDir = textDirectionHeuristic;
                return this;
            }
        }
    }

    private static class PrecomputedTextFutureTask
    extends FutureTask<PrecomputedTextCompat> {
        PrecomputedTextFutureTask(Params params, CharSequence charSequence) {
            super(new PrecomputedTextCallback(params, charSequence));
        }

        private static class PrecomputedTextCallback
        implements Callable<PrecomputedTextCompat> {
            private Params mParams;
            private CharSequence mText;

            PrecomputedTextCallback(Params params, CharSequence charSequence) {
                this.mParams = params;
                this.mText = charSequence;
            }

            @Override
            public PrecomputedTextCompat call() throws Exception {
                return PrecomputedTextCompat.create(this.mText, this.mParams);
            }
        }
    }
}

