/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.text.Spannable
 *  android.text.SpannableString
 *  android.text.method.LinkMovementMethod
 *  android.text.style.URLSpan
 *  android.text.util.Linkify
 *  android.text.util.Linkify$MatchFilter
 *  android.text.util.Linkify$TransformFilter
 *  android.webkit.WebView
 *  android.widget.TextView
 */
package androidx.core.text.util;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.core.text.util.FindAddress;
import androidx.core.text.util.LinkifyCompat$$ExternalSyntheticLambda0;
import androidx.core.util.PatternsCompat;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LinkifyCompat {
    private static final Comparator<LinkSpec> COMPARATOR;
    private static final String[] EMPTY_STRING;

    static {
        EMPTY_STRING = new String[0];
        COMPARATOR = new LinkifyCompat$$ExternalSyntheticLambda0();
    }

    private LinkifyCompat() {
    }

    private static void addLinkMovementMethod(TextView textView) {
        if (!(textView.getMovementMethod() instanceof LinkMovementMethod) && textView.getLinksClickable()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public static void addLinks(TextView textView, Pattern pattern, String string2) {
        if (LinkifyCompat.shouldAddLinksFallbackToFramework()) {
            Linkify.addLinks((TextView)textView, (Pattern)pattern, (String)string2);
            return;
        }
        LinkifyCompat.addLinks(textView, pattern, string2, null, null, null);
    }

    public static void addLinks(TextView textView, Pattern pattern, String string2, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        if (LinkifyCompat.shouldAddLinksFallbackToFramework()) {
            Linkify.addLinks((TextView)textView, (Pattern)pattern, (String)string2, (Linkify.MatchFilter)matchFilter, (Linkify.TransformFilter)transformFilter);
            return;
        }
        LinkifyCompat.addLinks(textView, pattern, string2, null, matchFilter, transformFilter);
    }

    public static void addLinks(TextView textView, Pattern pattern, String string2, String[] stringArray, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        if (LinkifyCompat.shouldAddLinksFallbackToFramework()) {
            Api24Impl.addLinks(textView, pattern, string2, stringArray, matchFilter, transformFilter);
            return;
        }
        SpannableString spannableString = SpannableString.valueOf((CharSequence)textView.getText());
        if (LinkifyCompat.addLinks((Spannable)spannableString, pattern, string2, stringArray, matchFilter, transformFilter)) {
            textView.setText((CharSequence)spannableString);
            LinkifyCompat.addLinkMovementMethod(textView);
        }
    }

    public static boolean addLinks(Spannable spannable, int n) {
        if (LinkifyCompat.shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks((Spannable)spannable, (int)n);
        }
        if (n == 0) {
            return false;
        }
        Object object = (Linkify.MatchFilter)spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int i = ((URLSpan[])object).length - 1; i >= 0; --i) {
            spannable.removeSpan((Object)object[i]);
        }
        if ((n & 4) != 0) {
            Linkify.addLinks((Spannable)spannable, (int)4);
        }
        ArrayList<LinkSpec> arrayList = new ArrayList<LinkSpec>();
        if ((n & 1) != 0) {
            Pattern object2 = PatternsCompat.AUTOLINK_WEB_URL;
            object = Linkify.sUrlMatchFilter;
            LinkifyCompat.gatherLinks(arrayList, spannable, object2, new String[]{"http://", "https://", "rtsp://"}, (Linkify.MatchFilter)object, null);
        }
        if ((n & 2) != 0) {
            LinkifyCompat.gatherLinks(arrayList, spannable, PatternsCompat.AUTOLINK_EMAIL_ADDRESS, new String[]{"mailto:"}, null, null);
        }
        if ((n & 8) != 0) {
            LinkifyCompat.gatherMapLinks(arrayList, spannable);
        }
        LinkifyCompat.pruneOverlaps(arrayList, spannable);
        if (arrayList.size() == 0) {
            return false;
        }
        for (LinkSpec linkSpec : arrayList) {
            if (linkSpec.frameworkAddedSpan != null) continue;
            LinkifyCompat.applyLink(linkSpec.url, linkSpec.start, linkSpec.end, spannable);
        }
        return true;
    }

    public static boolean addLinks(Spannable spannable, Pattern pattern, String string2) {
        if (LinkifyCompat.shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks((Spannable)spannable, (Pattern)pattern, (String)string2);
        }
        return LinkifyCompat.addLinks(spannable, pattern, string2, null, null, null);
    }

    public static boolean addLinks(Spannable spannable, Pattern pattern, String string2, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        if (LinkifyCompat.shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks((Spannable)spannable, (Pattern)pattern, (String)string2, (Linkify.MatchFilter)matchFilter, (Linkify.TransformFilter)transformFilter);
        }
        return LinkifyCompat.addLinks(spannable, pattern, string2, null, matchFilter, transformFilter);
    }

    public static boolean addLinks(Spannable spannable, Pattern object, String object2, String[] object3, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        int n;
        String[] stringArray;
        block11: {
            block10: {
                if (LinkifyCompat.shouldAddLinksFallbackToFramework()) {
                    return Api24Impl.addLinks(spannable, (Pattern)object, (String)object2, object3, matchFilter, transformFilter);
                }
                stringArray = object2;
                if (object2 == null) {
                    stringArray = "";
                }
                if (object3 == null) break block10;
                object2 = object3;
                if (((String[])object3).length >= 1) break block11;
            }
            object2 = EMPTY_STRING;
        }
        String[] stringArray2 = new String[((String[])object2).length + 1];
        stringArray2[0] = stringArray.toLowerCase(Locale.ROOT);
        for (n = 0; n < ((String[])object2).length; ++n) {
            object3 = object2[n];
            object3 = object3 == null ? "" : object3.toLowerCase(Locale.ROOT);
            stringArray2[n + 1] = object3;
        }
        boolean bl = false;
        object2 = ((Pattern)object).matcher((CharSequence)spannable);
        while (((Matcher)object2).find()) {
            int n2 = ((Matcher)object2).start();
            n = ((Matcher)object2).end();
            object = ((Matcher)object2).group(0);
            boolean bl2 = true;
            if (matchFilter != null) {
                bl2 = matchFilter.acceptMatch((CharSequence)spannable, n2, n);
            }
            boolean bl3 = bl;
            if (bl2) {
                bl3 = bl;
                if (object != null) {
                    LinkifyCompat.applyLink(LinkifyCompat.makeUrl((String)object, stringArray2, (Matcher)object2, transformFilter), n2, n, spannable);
                    bl3 = true;
                }
            }
            bl = bl3;
        }
        return bl;
    }

    public static boolean addLinks(TextView textView, int n) {
        if (LinkifyCompat.shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks((TextView)textView, (int)n);
        }
        if (n == 0) {
            return false;
        }
        CharSequence charSequence = textView.getText();
        if (charSequence instanceof Spannable) {
            if (LinkifyCompat.addLinks((Spannable)charSequence, n)) {
                LinkifyCompat.addLinkMovementMethod(textView);
                return true;
            }
        } else if (LinkifyCompat.addLinks((Spannable)(charSequence = SpannableString.valueOf((CharSequence)charSequence)), n)) {
            LinkifyCompat.addLinkMovementMethod(textView);
            textView.setText(charSequence);
            return true;
        }
        return false;
    }

    private static void applyLink(String string2, int n, int n2, Spannable spannable) {
        spannable.setSpan((Object)new URLSpan(string2), n, n2, 33);
    }

    private static String findAddress(String string2) {
        if (Build.VERSION.SDK_INT >= 28) {
            return WebView.findAddress((String)string2);
        }
        return FindAddress.findAddress(string2);
    }

    private static void gatherLinks(ArrayList<LinkSpec> arrayList, Spannable spannable, Pattern object, String[] stringArray, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        Matcher matcher = ((Pattern)object).matcher((CharSequence)spannable);
        while (matcher.find()) {
            int n = matcher.start();
            int n2 = matcher.end();
            String string2 = matcher.group(0);
            if (matchFilter != null && !matchFilter.acceptMatch((CharSequence)spannable, n, n2) || string2 == null) continue;
            object = new LinkSpec();
            ((LinkSpec)object).url = LinkifyCompat.makeUrl(string2, stringArray, matcher, transformFilter);
            ((LinkSpec)object).start = n;
            ((LinkSpec)object).end = n2;
            arrayList.add((LinkSpec)object);
        }
    }

    private static void gatherMapLinks(ArrayList<LinkSpec> arrayList, Spannable object) {
        object = object.toString();
        int n = 0;
        while (true) {
            CharSequence charSequence = LinkifyCompat.findAddress((String)object);
            if (charSequence == null) break;
            int n2 = ((String)object).indexOf((String)charSequence);
            if (n2 < 0) break;
            LinkSpec linkSpec = new LinkSpec();
            int n3 = n2 + ((String)charSequence).length();
            linkSpec.start = n + n2;
            linkSpec.end = n + n3;
            object = ((String)object).substring(n3);
            n += n3;
            try {
                try {
                    String string2 = URLEncoder.encode((String)charSequence, "UTF-8");
                    charSequence = new StringBuilder();
                    linkSpec.url = ((StringBuilder)charSequence).append("geo:0,0?q=").append(string2).toString();
                    arrayList.add(linkSpec);
                }
                catch (UnsupportedEncodingException unsupportedEncodingException) {
                }
                continue;
            }
            catch (UnsupportedOperationException unsupportedOperationException) {
                // empty catch block
            }
            break;
        }
    }

    static /* synthetic */ int lambda$static$0(LinkSpec linkSpec, LinkSpec linkSpec2) {
        if (linkSpec.start < linkSpec2.start) {
            return -1;
        }
        if (linkSpec.start > linkSpec2.start) {
            return 1;
        }
        return Integer.compare(linkSpec2.end, linkSpec.end);
    }

    private static String makeUrl(String string2, String[] stringArray, Matcher object, Linkify.TransformFilter transformFilter) {
        int n;
        String string3 = string2;
        if (transformFilter != null) {
            string3 = transformFilter.transformUrl((Matcher)object, string2);
        }
        int n2 = 0;
        int n3 = stringArray.length;
        int n4 = 0;
        while (true) {
            n = n2;
            string2 = string3;
            if (n4 >= n3) break;
            object = stringArray[n4];
            if (string3.regionMatches(true, 0, (String)object, 0, ((String)object).length())) {
                n = n4 = 1;
                string2 = string3;
                if (string3.regionMatches(false, 0, (String)object, 0, ((String)object).length())) break;
                string2 = (String)object + string3.substring(((String)object).length());
                n = n4;
                break;
            }
            ++n4;
        }
        object = string2;
        if (n == 0) {
            object = string2;
            if (stringArray.length > 0) {
                object = stringArray[0] + string2;
            }
        }
        return object;
    }

    private static void pruneOverlaps(ArrayList<LinkSpec> arrayList, Spannable spannable) {
        LinkSpec linkSpec;
        int n = spannable.length();
        for (URLSpan uRLSpan : (URLSpan[])spannable.getSpans(0, n, URLSpan.class)) {
            linkSpec = new LinkSpec();
            linkSpec.frameworkAddedSpan = uRLSpan;
            linkSpec.start = spannable.getSpanStart((Object)uRLSpan);
            linkSpec.end = spannable.getSpanEnd((Object)uRLSpan);
            arrayList.add(linkSpec);
        }
        Collections.sort(arrayList, COMPARATOR);
        int n2 = arrayList.size();
        n = 0;
        while (n < n2 - 1) {
            linkSpec = arrayList.get(n);
            LinkSpec linkSpec2 = arrayList.get(n + 1);
            int n3 = -1;
            if (linkSpec.start <= linkSpec2.start && linkSpec.end > linkSpec2.start) {
                if (linkSpec2.end <= linkSpec.end) {
                    n3 = n + 1;
                } else if (linkSpec.end - linkSpec.start > linkSpec2.end - linkSpec2.start) {
                    n3 = n + 1;
                } else if (linkSpec.end - linkSpec.start < linkSpec2.end - linkSpec2.start) {
                    n3 = n;
                }
                if (n3 != -1) {
                    linkSpec = arrayList.get((int)n3).frameworkAddedSpan;
                    if (linkSpec != null) {
                        spannable.removeSpan((Object)linkSpec);
                    }
                    arrayList.remove(n3);
                    --n2;
                    continue;
                }
            }
            ++n;
        }
    }

    private static boolean shouldAddLinksFallbackToFramework() {
        boolean bl = Build.VERSION.SDK_INT >= 28;
        return bl;
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static void addLinks(TextView textView, Pattern pattern, String string2, String[] stringArray, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
            Linkify.addLinks((TextView)textView, (Pattern)pattern, (String)string2, (String[])stringArray, (Linkify.MatchFilter)matchFilter, (Linkify.TransformFilter)transformFilter);
        }

        static boolean addLinks(Spannable spannable, Pattern pattern, String string2, String[] stringArray, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
            return Linkify.addLinks((Spannable)spannable, (Pattern)pattern, (String)string2, (String[])stringArray, (Linkify.MatchFilter)matchFilter, (Linkify.TransformFilter)transformFilter);
        }
    }

    private static class LinkSpec {
        int end;
        URLSpan frameworkAddedSpan;
        int start;
        String url;

        LinkSpec() {
        }
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface LinkifyMask {
    }
}

