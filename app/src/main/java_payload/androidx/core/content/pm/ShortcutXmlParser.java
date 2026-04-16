/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ActivityInfo
 *  android.content.res.XmlResourceParser
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.core.content.pm;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.XmlResourceParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ShortcutXmlParser {
    private static final String ATTR_SHORTCUT_ID = "shortcutId";
    private static final Object GET_INSTANCE_LOCK = new Object();
    private static final String META_DATA_APP_SHORTCUTS = "android.app.shortcuts";
    private static final String TAG = "ShortcutXmlParser";
    private static final String TAG_SHORTCUT = "shortcut";
    private static volatile ArrayList<String> sShortcutIds;

    private ShortcutXmlParser() {
    }

    private static String getAttributeValue(XmlPullParser xmlPullParser, String string2) {
        String string3;
        String string4 = string3 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", string2);
        if (string3 == null) {
            string4 = xmlPullParser.getAttributeValue(null, string2);
        }
        return string4;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static List<String> getShortcutIds(Context context) {
        if (sShortcutIds != null) return sShortcutIds;
        Object object = GET_INSTANCE_LOCK;
        synchronized (object) {
            if (sShortcutIds != null) return sShortcutIds;
            ArrayList arrayList = new ArrayList();
            sShortcutIds = arrayList;
            sShortcutIds.addAll(ShortcutXmlParser.parseShortcutIds(context));
            return sShortcutIds;
        }
    }

    private static XmlResourceParser getXmlResourceParser(Context context, ActivityInfo activityInfo) {
        if ((context = activityInfo.loadXmlMetaData(context.getPackageManager(), META_DATA_APP_SHORTCUTS)) != null) {
            return context;
        }
        throw new IllegalArgumentException("Failed to open android.app.shortcuts meta-data resource of " + activityInfo.name);
    }

    public static List<String> parseShortcutIds(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        int n;
        ArrayList<String> arrayList = new ArrayList<String>(1);
        while ((n = xmlPullParser.next()) != 1 && (n != 3 || xmlPullParser.getDepth() > 0)) {
            int n2 = xmlPullParser.getDepth();
            String string2 = xmlPullParser.getName();
            if (n != 2 || n2 != 2 || !TAG_SHORTCUT.equals(string2) || (string2 = ShortcutXmlParser.getAttributeValue(xmlPullParser, ATTR_SHORTCUT_ID)) == null) continue;
            arrayList.add(string2);
        }
        return arrayList;
    }

    /*
     * Exception decompiling
     */
    private static Set<String> parseShortcutIds(Context var0) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 9[WHILELOOP]
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
}

