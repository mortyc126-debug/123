/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.util.Base64
 *  android.util.Xml
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import androidx.core.R;
import androidx.core.provider.FontRequest;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class FontResourcesParserCompat {
    private static final int DEFAULT_TIMEOUT_MILLIS = 500;
    public static final int FETCH_STRATEGY_ASYNC = 1;
    public static final int FETCH_STRATEGY_BLOCKING = 0;
    public static final int INFINITE_TIMEOUT_VALUE = -1;
    private static final int ITALIC = 1;
    private static final int NORMAL_WEIGHT = 400;

    private FontResourcesParserCompat() {
    }

    private static int getType(TypedArray typedArray, int n) {
        return Api21Impl.getType(typedArray, n);
    }

    public static FamilyResourceEntry parse(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int n;
        while ((n = xmlPullParser.next()) != 2 && n != 1) {
        }
        if (n == 2) {
            return FontResourcesParserCompat.readFamilies(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List<List<byte[]>> readCerts(Resources object, int n) {
        ArrayList<List<byte[]>> arrayList;
        block11: {
            TypedArray typedArray;
            block10: {
                block9: {
                    if (n == 0) {
                        return Collections.emptyList();
                    }
                    typedArray = object.obtainTypedArray(n);
                    if (typedArray.length() != 0) break block9;
                    object = Collections.emptyList();
                    typedArray.recycle();
                    return object;
                }
                arrayList = new ArrayList<List<byte[]>>();
                if (FontResourcesParserCompat.getType(typedArray, 0) != 1) break block10;
                n = 0;
                while (true) {
                    block12: {
                        if (n >= typedArray.length()) break block11;
                        int n2 = typedArray.getResourceId(n, 0);
                        if (n2 == 0) break block12;
                        arrayList.add(FontResourcesParserCompat.toByteArrayList(object.getStringArray(n2)));
                    }
                    ++n;
                }
            }
            try {
                arrayList.add(FontResourcesParserCompat.toByteArrayList(object.getStringArray(n)));
            }
            catch (Throwable throwable) {
                throw throwable;
            }
            finally {
                typedArray.recycle();
            }
        }
        return arrayList;
    }

    private static FamilyResourceEntry readFamilies(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return FontResourcesParserCompat.readFamily(xmlPullParser, resources);
        }
        FontResourcesParserCompat.skip(xmlPullParser);
        return null;
    }

    private static FamilyResourceEntry readFamily(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArray = resources.obtainAttributes(Xml.asAttributeSet((XmlPullParser)xmlPullParser), R.styleable.FontFamily);
        String string2 = typedArray.getString(R.styleable.FontFamily_fontProviderAuthority);
        String string3 = typedArray.getString(R.styleable.FontFamily_fontProviderPackage);
        String string4 = typedArray.getString(R.styleable.FontFamily_fontProviderQuery);
        int n = typedArray.getResourceId(R.styleable.FontFamily_fontProviderCerts, 0);
        int n2 = typedArray.getInteger(R.styleable.FontFamily_fontProviderFetchStrategy, 1);
        int n3 = typedArray.getInteger(R.styleable.FontFamily_fontProviderFetchTimeout, 500);
        Object object = typedArray.getString(R.styleable.FontFamily_fontProviderSystemFontFamily);
        typedArray.recycle();
        if (string2 != null && string3 != null && string4 != null) {
            while (xmlPullParser.next() != 3) {
                FontResourcesParserCompat.skip(xmlPullParser);
            }
            return new ProviderResourceEntry(new FontRequest(string2, string3, string4, FontResourcesParserCompat.readCerts(resources, n)), n2, n3, (String)object);
        }
        object = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() != 2) continue;
            if (xmlPullParser.getName().equals("font")) {
                object.add(FontResourcesParserCompat.readFont(xmlPullParser, resources));
                continue;
            }
            FontResourcesParserCompat.skip(xmlPullParser);
        }
        if (object.isEmpty()) {
            return null;
        }
        return new FontFamilyFilesResourceEntry(object.toArray(new FontFileResourceEntry[0]));
    }

    private static FontFileResourceEntry readFont(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int n = (resources = resources.obtainAttributes(Xml.asAttributeSet((XmlPullParser)xmlPullParser), R.styleable.FontFamilyFont)).hasValue(R.styleable.FontFamilyFont_fontWeight) ? R.styleable.FontFamilyFont_fontWeight : R.styleable.FontFamilyFont_android_fontWeight;
        int n2 = resources.getInt(n, 400);
        n = resources.hasValue(R.styleable.FontFamilyFont_fontStyle) ? R.styleable.FontFamilyFont_fontStyle : R.styleable.FontFamilyFont_android_fontStyle;
        boolean bl = 1 == resources.getInt(n, 0);
        n = resources.hasValue(R.styleable.FontFamilyFont_ttcIndex) ? R.styleable.FontFamilyFont_ttcIndex : R.styleable.FontFamilyFont_android_ttcIndex;
        int n3 = resources.hasValue(R.styleable.FontFamilyFont_fontVariationSettings) ? R.styleable.FontFamilyFont_fontVariationSettings : R.styleable.FontFamilyFont_android_fontVariationSettings;
        String string2 = resources.getString(n3);
        n3 = resources.getInt(n, 0);
        n = resources.hasValue(R.styleable.FontFamilyFont_font) ? R.styleable.FontFamilyFont_font : R.styleable.FontFamilyFont_android_font;
        int n4 = resources.getResourceId(n, 0);
        String string3 = resources.getString(n);
        resources.recycle();
        while (xmlPullParser.next() != 3) {
            FontResourcesParserCompat.skip(xmlPullParser);
        }
        return new FontFileResourceEntry(string3, n2, bl, string2, n3, n4);
    }

    private static void skip(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int n = 1;
        block4: while (n > 0) {
            switch (xmlPullParser.next()) {
                default: {
                    continue block4;
                }
                case 3: {
                    --n;
                    continue block4;
                }
                case 2: 
            }
            ++n;
        }
    }

    private static List<byte[]> toByteArrayList(String[] stringArray) {
        ArrayList<byte[]> arrayList = new ArrayList<byte[]>();
        int n = stringArray.length;
        for (int i = 0; i < n; ++i) {
            arrayList.add(Base64.decode((String)stringArray[i], (int)0));
        }
        return arrayList;
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static int getType(TypedArray typedArray, int n) {
            return typedArray.getType(n);
        }
    }

    public static interface FamilyResourceEntry {
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface FetchStrategy {
    }

    public static final class FontFamilyFilesResourceEntry
    implements FamilyResourceEntry {
        private final FontFileResourceEntry[] mEntries;

        public FontFamilyFilesResourceEntry(FontFileResourceEntry[] fontFileResourceEntryArray) {
            this.mEntries = fontFileResourceEntryArray;
        }

        public FontFileResourceEntry[] getEntries() {
            return this.mEntries;
        }
    }

    public static final class FontFileResourceEntry {
        private final String mFileName;
        private final boolean mItalic;
        private final int mResourceId;
        private final int mTtcIndex;
        private final String mVariationSettings;
        private final int mWeight;

        public FontFileResourceEntry(String string2, int n, boolean bl, String string3, int n2, int n3) {
            this.mFileName = string2;
            this.mWeight = n;
            this.mItalic = bl;
            this.mVariationSettings = string3;
            this.mTtcIndex = n2;
            this.mResourceId = n3;
        }

        public String getFileName() {
            return this.mFileName;
        }

        public int getResourceId() {
            return this.mResourceId;
        }

        public int getTtcIndex() {
            return this.mTtcIndex;
        }

        public String getVariationSettings() {
            return this.mVariationSettings;
        }

        public int getWeight() {
            return this.mWeight;
        }

        public boolean isItalic() {
            return this.mItalic;
        }
    }

    public static final class ProviderResourceEntry
    implements FamilyResourceEntry {
        private final FontRequest mRequest;
        private final int mStrategy;
        private final String mSystemFontFamilyName;
        private final int mTimeoutMs;

        public ProviderResourceEntry(FontRequest fontRequest, int n, int n2) {
            this(fontRequest, n, n2, null);
        }

        public ProviderResourceEntry(FontRequest fontRequest, int n, int n2, String string2) {
            this.mRequest = fontRequest;
            this.mStrategy = n;
            this.mTimeoutMs = n2;
            this.mSystemFontFamilyName = string2;
        }

        public int getFetchStrategy() {
            return this.mStrategy;
        }

        public FontRequest getRequest() {
            return this.mRequest;
        }

        public String getSystemFontFamilyName() {
            return this.mSystemFontFamilyName;
        }

        public int getTimeout() {
            return this.mTimeoutMs;
        }
    }
}

