/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.Html
 *  android.text.Html$ImageGetter
 *  android.text.Html$TagHandler
 *  android.text.Spanned
 */
package androidx.core.text;

import android.text.Html;
import android.text.Spanned;

public final class HtmlCompat {
    public static final int FROM_HTML_MODE_COMPACT = 63;
    public static final int FROM_HTML_MODE_LEGACY = 0;
    public static final int FROM_HTML_OPTION_USE_CSS_COLORS = 256;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_BLOCKQUOTE = 32;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_DIV = 16;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_HEADING = 2;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_LIST = 8;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_LIST_ITEM = 4;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_PARAGRAPH = 1;
    public static final int TO_HTML_PARAGRAPH_LINES_CONSECUTIVE = 0;
    public static final int TO_HTML_PARAGRAPH_LINES_INDIVIDUAL = 1;

    private HtmlCompat() {
    }

    public static Spanned fromHtml(String string2, int n) {
        return Api24Impl.fromHtml(string2, n);
    }

    public static Spanned fromHtml(String string2, int n, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
        return Api24Impl.fromHtml(string2, n, imageGetter, tagHandler);
    }

    public static String toHtml(Spanned spanned, int n) {
        return Api24Impl.toHtml(spanned, n);
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static Spanned fromHtml(String string2, int n) {
            return Html.fromHtml((String)string2, (int)n);
        }

        static Spanned fromHtml(String string2, int n, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
            return Html.fromHtml((String)string2, (int)n, (Html.ImageGetter)imageGetter, (Html.TagHandler)tagHandler);
        }

        static String toHtml(Spanned spanned, int n) {
            return Html.toHtml((Spanned)spanned, (int)n);
        }
    }
}

