/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.Spannable
 *  android.text.SpannableString
 *  kotlin.Metadata
 *  kotlin.ranges.IntRange
 */
package androidx.core.text;

import android.text.Spannable;
import android.text.SpannableString;
import kotlin.Metadata;
import kotlin.ranges.IntRange;

@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\b\u001a%\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086\n\u001a\u001d\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0086\n\u001a\r\u0010\u000b\u001a\u00020\u0002*\u00020\fH\u0086\b\u00a8\u0006\r"}, d2={"clearSpans", "", "Landroid/text/Spannable;", "set", "start", "", "end", "span", "", "range", "Lkotlin/ranges/IntRange;", "toSpannable", "", "core-ktx_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class SpannableStringKt {
    public static final void clearSpans(Spannable spannable) {
        Object[] objectArray = (Object[])spannable;
        objectArray = objectArray.getSpans(0, objectArray.length(), Object.class);
        int n = objectArray.length;
        for (int i = 0; i < n; ++i) {
            spannable.removeSpan(objectArray[i]);
        }
    }

    public static final void set(Spannable spannable, int n, int n2, Object object) {
        spannable.setSpan(object, n, n2, 17);
    }

    public static final void set(Spannable spannable, IntRange intRange, Object object) {
        spannable.setSpan(object, intRange.getStart().intValue(), intRange.getEndInclusive().intValue(), 17);
    }

    public static final Spannable toSpannable(CharSequence charSequence) {
        return (Spannable)SpannableString.valueOf((CharSequence)charSequence);
    }
}

