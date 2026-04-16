/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.SpannableStringBuilder
 *  android.text.SpannedString
 *  android.text.style.BackgroundColorSpan
 *  android.text.style.ForegroundColorSpan
 *  android.text.style.RelativeSizeSpan
 *  android.text.style.StrikethroughSpan
 *  android.text.style.StyleSpan
 *  android.text.style.SubscriptSpan
 *  android.text.style.SuperscriptSpan
 *  android.text.style.UnderlineSpan
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 */
package androidx.core.text;

import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a\"\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006H\u0086\b\u001a0\u0010\u0007\u001a\u00020\u0004*\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\t2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006H\u0086\b\u001a&\u0010\n\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006H\u0086\b\u001a0\u0010\b\u001a\u00020\u0004*\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\t2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006H\u0086\b\u001a.\u0010\u000b\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006H\u0086\b\u001a?\u0010\u000b\u001a\u00020\u0004*\u00020\u00042\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u000f\"\u00020\r2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006H\u0086\b\u00a2\u0006\u0002\u0010\u0010\u001a&\u0010\u0011\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006H\u0086\b\u001a.\u0010\u0012\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006H\u0086\b\u001a&\u0010\u0015\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006H\u0086\b\u001a&\u0010\u0016\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006H\u0086\b\u001a&\u0010\u0017\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006H\u0086\b\u001a&\u0010\u0018\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006H\u0086\b\u00a8\u0006\u0019"}, d2={"buildSpannedString", "Landroid/text/SpannedString;", "builderAction", "Lkotlin/Function1;", "Landroid/text/SpannableStringBuilder;", "", "Lkotlin/ExtensionFunctionType;", "backgroundColor", "color", "", "bold", "inSpans", "span", "", "spans", "", "(Landroid/text/SpannableStringBuilder;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Landroid/text/SpannableStringBuilder;", "italic", "scale", "proportion", "", "strikeThrough", "subscript", "superscript", "underline", "core-ktx_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class SpannableStringBuilderKt {
    public static final SpannableStringBuilder backgroundColor(SpannableStringBuilder spannableStringBuilder, int n, Function1<? super SpannableStringBuilder, Unit> function1) {
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(n);
        n = spannableStringBuilder.length();
        function1.invoke((Object)spannableStringBuilder);
        spannableStringBuilder.setSpan((Object)backgroundColorSpan, n, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder bold(SpannableStringBuilder spannableStringBuilder, Function1<? super SpannableStringBuilder, Unit> function1) {
        StyleSpan styleSpan = new StyleSpan(1);
        int n = spannableStringBuilder.length();
        function1.invoke((Object)spannableStringBuilder);
        spannableStringBuilder.setSpan((Object)styleSpan, n, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannedString buildSpannedString(Function1<? super SpannableStringBuilder, Unit> function1) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        function1.invoke((Object)spannableStringBuilder);
        return new SpannedString((CharSequence)spannableStringBuilder);
    }

    public static final SpannableStringBuilder color(SpannableStringBuilder spannableStringBuilder, int n, Function1<? super SpannableStringBuilder, Unit> function1) {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(n);
        n = spannableStringBuilder.length();
        function1.invoke((Object)spannableStringBuilder);
        spannableStringBuilder.setSpan((Object)foregroundColorSpan, n, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder inSpans(SpannableStringBuilder spannableStringBuilder, Object object, Function1<? super SpannableStringBuilder, Unit> function1) {
        int n = spannableStringBuilder.length();
        function1.invoke((Object)spannableStringBuilder);
        spannableStringBuilder.setSpan(object, n, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder inSpans(SpannableStringBuilder spannableStringBuilder, Object[] objectArray, Function1<? super SpannableStringBuilder, Unit> function1) {
        int n = spannableStringBuilder.length();
        function1.invoke((Object)spannableStringBuilder);
        int n2 = objectArray.length;
        for (int i = 0; i < n2; ++i) {
            spannableStringBuilder.setSpan(objectArray[i], n, spannableStringBuilder.length(), 17);
        }
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder italic(SpannableStringBuilder spannableStringBuilder, Function1<? super SpannableStringBuilder, Unit> function1) {
        StyleSpan styleSpan = new StyleSpan(2);
        int n = spannableStringBuilder.length();
        function1.invoke((Object)spannableStringBuilder);
        spannableStringBuilder.setSpan((Object)styleSpan, n, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder scale(SpannableStringBuilder spannableStringBuilder, float f, Function1<? super SpannableStringBuilder, Unit> function1) {
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(f);
        int n = spannableStringBuilder.length();
        function1.invoke((Object)spannableStringBuilder);
        spannableStringBuilder.setSpan((Object)relativeSizeSpan, n, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder strikeThrough(SpannableStringBuilder spannableStringBuilder, Function1<? super SpannableStringBuilder, Unit> function1) {
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        int n = spannableStringBuilder.length();
        function1.invoke((Object)spannableStringBuilder);
        spannableStringBuilder.setSpan((Object)strikethroughSpan, n, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder subscript(SpannableStringBuilder spannableStringBuilder, Function1<? super SpannableStringBuilder, Unit> function1) {
        SubscriptSpan subscriptSpan = new SubscriptSpan();
        int n = spannableStringBuilder.length();
        function1.invoke((Object)spannableStringBuilder);
        spannableStringBuilder.setSpan((Object)subscriptSpan, n, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder superscript(SpannableStringBuilder spannableStringBuilder, Function1<? super SpannableStringBuilder, Unit> function1) {
        SuperscriptSpan superscriptSpan = new SuperscriptSpan();
        int n = spannableStringBuilder.length();
        function1.invoke((Object)spannableStringBuilder);
        spannableStringBuilder.setSpan((Object)superscriptSpan, n, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannableStringBuilder underline(SpannableStringBuilder spannableStringBuilder, Function1<? super SpannableStringBuilder, Unit> function1) {
        UnderlineSpan underlineSpan = new UnderlineSpan();
        int n = spannableStringBuilder.length();
        function1.invoke((Object)spannableStringBuilder);
        spannableStringBuilder.setSpan((Object)underlineSpan, n, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }
}

