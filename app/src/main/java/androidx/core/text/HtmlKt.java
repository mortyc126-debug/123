/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.Html$ImageGetter
 *  android.text.Html$TagHandler
 *  android.text.Spanned
 *  kotlin.Metadata
 */
package androidx.core.text;

import android.text.Html;
import android.text.Spanned;
import androidx.core.text.HtmlCompat;
import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0086\b\u001a\u0017\u0010\t\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u0004H\u0086\b\u00a8\u0006\u000b"}, d2={"parseAsHtml", "Landroid/text/Spanned;", "", "flags", "", "imageGetter", "Landroid/text/Html$ImageGetter;", "tagHandler", "Landroid/text/Html$TagHandler;", "toHtml", "option", "core-ktx_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class HtmlKt {
    public static final Spanned parseAsHtml(String string2, int n, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
        return HtmlCompat.fromHtml(string2, n, imageGetter, tagHandler);
    }

    public static /* synthetic */ Spanned parseAsHtml$default(String string2, int n, Html.ImageGetter imageGetter, Html.TagHandler tagHandler, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = 0;
        }
        if ((n2 & 2) != 0) {
            imageGetter = null;
        }
        if ((n2 & 4) != 0) {
            tagHandler = null;
        }
        return HtmlCompat.fromHtml(string2, n, imageGetter, tagHandler);
    }

    public static final String toHtml(Spanned spanned, int n) {
        return HtmlCompat.toHtml(spanned, n);
    }

    public static /* synthetic */ String toHtml$default(Spanned spanned, int n, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = 0;
        }
        return HtmlCompat.toHtml(spanned, n);
    }
}

