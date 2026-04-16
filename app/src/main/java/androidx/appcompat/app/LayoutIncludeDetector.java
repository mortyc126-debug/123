/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.AttributeSet
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.appcompat.app;

import android.util.AttributeSet;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Deque;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class LayoutIncludeDetector {
    private final Deque<WeakReference<XmlPullParser>> mXmlParserStack = new ArrayDeque<WeakReference<XmlPullParser>>();

    LayoutIncludeDetector() {
    }

    private static boolean isParserOutdated(XmlPullParser xmlPullParser) {
        boolean bl = true;
        if (xmlPullParser != null) {
            try {
                int n;
                if (xmlPullParser.getEventType() != 3 && (n = xmlPullParser.getEventType()) != 1) {
                    bl = false;
                }
            }
            catch (XmlPullParserException xmlPullParserException) {
                return true;
            }
        }
        return bl;
    }

    private static XmlPullParser popOutdatedAttrHolders(Deque<WeakReference<XmlPullParser>> deque) {
        while (!deque.isEmpty()) {
            XmlPullParser xmlPullParser = (XmlPullParser)deque.peek().get();
            if (LayoutIncludeDetector.isParserOutdated(xmlPullParser)) {
                deque.pop();
                continue;
            }
            return xmlPullParser;
        }
        return null;
    }

    private static boolean shouldInheritContext(XmlPullParser xmlPullParser, XmlPullParser xmlPullParser2) {
        if (xmlPullParser2 != null && xmlPullParser != xmlPullParser2) {
            try {
                if (xmlPullParser2.getEventType() == 2) {
                    boolean bl = "include".equals(xmlPullParser2.getName());
                    return bl;
                }
            }
            catch (XmlPullParserException xmlPullParserException) {
                // empty catch block
            }
        }
        return false;
    }

    boolean detect(AttributeSet attributeSet) {
        if (attributeSet instanceof XmlPullParser && (attributeSet = (XmlPullParser)attributeSet).getDepth() == 1) {
            XmlPullParser xmlPullParser = LayoutIncludeDetector.popOutdatedAttrHolders(this.mXmlParserStack);
            this.mXmlParserStack.push(new WeakReference<AttributeSet>(attributeSet));
            if (LayoutIncludeDetector.shouldInheritContext((XmlPullParser)attributeSet, xmlPullParser)) {
                return true;
            }
        }
        return false;
    }
}

