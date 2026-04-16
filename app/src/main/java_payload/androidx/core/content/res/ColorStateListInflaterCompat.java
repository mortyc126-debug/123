/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Color
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.StateSet
 *  android.util.TypedValue
 *  android.util.Xml
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.R;
import androidx.core.content.res.CamColor;
import androidx.core.content.res.GrowingArrayUtils;
import androidx.core.math.MathUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class ColorStateListInflaterCompat {
    private static final ThreadLocal<TypedValue> sTempTypedValue = new ThreadLocal();

    private ColorStateListInflaterCompat() {
    }

    public static ColorStateList createFromXml(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException, IOException {
        int n;
        AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xmlPullParser);
        while ((n = xmlPullParser.next()) != 2 && n != 1) {
        }
        if (n == 2) {
            return ColorStateListInflaterCompat.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static ColorStateList createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        String string2 = xmlPullParser.getName();
        if (string2.equals("selector")) {
            return ColorStateListInflaterCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + string2);
    }

    private static TypedValue getTypedValue() {
        TypedValue typedValue;
        TypedValue typedValue2 = typedValue = sTempTypedValue.get();
        if (typedValue == null) {
            typedValue2 = new TypedValue();
            sTempTypedValue.set(typedValue2);
        }
        return typedValue2;
    }

    public static ColorStateList inflate(Resources resources, int n, Resources.Theme theme) {
        try {
            resources = ColorStateListInflaterCompat.createFromXml(resources, (XmlPullParser)resources.getXml(n), theme);
            return resources;
        }
        catch (Exception exception) {
            Log.e((String)"CSLCompat", (String)"Failed to inflate ColorStateList.", (Throwable)exception);
            return null;
        }
    }

    private static ColorStateList inflate(Resources object, XmlPullParser object2, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int n = object2.getDepth() + 1;
        Object object3 = new int[20][];
        int[] nArray = new int[((int[][])object3).length];
        int n2 = 0;
        while (true) {
            int n3;
            int n4 = n3 = object2.next();
            if (n3 == 1 || (n3 = object2.getDepth()) < n && n4 == 3) break;
            if (n4 != 2 || n3 > n || !object2.getName().equals("item")) continue;
            TypedArray typedArray = ColorStateListInflaterCompat.obtainAttributes(object, theme, attributeSet, R.styleable.ColorStateListItem);
            n3 = typedArray.getResourceId(R.styleable.ColorStateListItem_android_color, -1);
            if (n3 != -1 && !ColorStateListInflaterCompat.isColorInt(object, n3)) {
                try {
                    n3 = ColorStateListInflaterCompat.createFromXml(object, (XmlPullParser)object.getXml(n3), theme).getDefaultColor();
                }
                catch (Exception exception) {
                    n3 = typedArray.getColor(R.styleable.ColorStateListItem_android_color, -65281);
                }
            } else {
                n3 = typedArray.getColor(R.styleable.ColorStateListItem_android_color, -65281);
            }
            float f = 1.0f;
            if (typedArray.hasValue(R.styleable.ColorStateListItem_android_alpha)) {
                f = typedArray.getFloat(R.styleable.ColorStateListItem_android_alpha, 1.0f);
            } else if (typedArray.hasValue(R.styleable.ColorStateListItem_alpha)) {
                f = typedArray.getFloat(R.styleable.ColorStateListItem_alpha, 1.0f);
            }
            float f2 = Build.VERSION.SDK_INT >= 31 && typedArray.hasValue(R.styleable.ColorStateListItem_android_lStar) ? typedArray.getFloat(R.styleable.ColorStateListItem_android_lStar, -1.0f) : typedArray.getFloat(R.styleable.ColorStateListItem_lStar, -1.0f);
            typedArray.recycle();
            int n5 = 0;
            int n6 = attributeSet.getAttributeCount();
            int[] nArray2 = new int[n6];
            for (int i = 0; i < n6; ++i) {
                int n7 = attributeSet.getAttributeNameResource(i);
                int n8 = n5;
                if (n7 != 16843173) {
                    n8 = n5;
                    if (n7 != 16843551) {
                        n8 = n5;
                        if (n7 != R.attr.alpha) {
                            n8 = n5;
                            if (n7 != R.attr.lStar) {
                                n8 = attributeSet.getAttributeBooleanValue(i, false) ? n7 : -n7;
                                nArray2[n5] = n8;
                                n8 = n5 + 1;
                            }
                        }
                    }
                }
                n5 = n8;
            }
            nArray2 = StateSet.trimStateSet((int[])nArray2, (int)n5);
            nArray = GrowingArrayUtils.append(nArray, n2, ColorStateListInflaterCompat.modulateColorAlpha(n3, f, f2));
            object3 = GrowingArrayUtils.append(object3, n2, nArray2);
            ++n2;
        }
        object = new int[n2];
        object2 = new int[n2][];
        System.arraycopy(nArray, 0, object, 0, n2);
        System.arraycopy(object3, 0, object2, 0, n2);
        return new ColorStateList((int[][])object2, (int[])object);
    }

    private static boolean isColorInt(Resources resources, int n) {
        TypedValue typedValue = ColorStateListInflaterCompat.getTypedValue();
        boolean bl = true;
        resources.getValue(n, typedValue, true);
        if (typedValue.type < 28 || typedValue.type > 31) {
            bl = false;
        }
        return bl;
    }

    private static int modulateColorAlpha(int n, float f, float f2) {
        boolean bl = f2 >= 0.0f && f2 <= 100.0f;
        if (f == 1.0f && !bl) {
            return n;
        }
        int n2 = MathUtils.clamp((int)((float)Color.alpha((int)n) * f + 0.5f), 0, 255);
        int n3 = n;
        if (bl) {
            CamColor camColor = CamColor.fromColor(n);
            n3 = CamColor.toColor(camColor.getHue(), camColor.getChroma(), f2);
        }
        return 0xFFFFFF & n3 | n2 << 24;
    }

    private static TypedArray obtainAttributes(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] nArray) {
        resources = theme == null ? resources.obtainAttributes(attributeSet, nArray) : theme.obtainStyledAttributes(attributeSet, nArray, 0, 0);
        return resources;
    }
}

