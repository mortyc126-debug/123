/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Typeface
 *  android.graphics.Typeface$CustomFallbackBuilder
 *  android.graphics.fonts.Font
 *  android.graphics.fonts.Font$Builder
 *  android.graphics.fonts.FontFamily
 *  android.graphics.fonts.FontFamily$Builder
 *  android.graphics.fonts.FontStyle
 *  android.os.CancellationSignal
 */
package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.graphics.TypefaceCompatBaseImpl;
import androidx.core.provider.FontsContractCompat;
import java.io.IOException;
import java.io.InputStream;

public class TypefaceCompatApi29Impl
extends TypefaceCompatBaseImpl {
    private Font findBaseFont(FontFamily fontFamily, int n) {
        int n2 = (n & 1) != 0 ? 700 : 400;
        n = (n & 2) != 0 ? 1 : 0;
        FontStyle fontStyle = new FontStyle(n2, n);
        Font font = fontFamily.getFont(0);
        n2 = TypefaceCompatApi29Impl.getMatchScore(fontStyle, font.getStyle());
        for (n = 1; n < fontFamily.getSize(); ++n) {
            Font font2 = fontFamily.getFont(n);
            int n3 = TypefaceCompatApi29Impl.getMatchScore(fontStyle, font2.getStyle());
            int n4 = n2;
            if (n3 < n2) {
                font = font2;
                n4 = n3;
            }
            n2 = n4;
        }
        return font;
    }

    private static int getMatchScore(FontStyle fontStyle, FontStyle fontStyle2) {
        int n = Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100;
        int n2 = fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2;
        return n + n2;
    }

    /*
     * WARNING - combined exceptions agressively - possible behaviour change.
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public Typeface createFromFontFamilyFilesResourceEntry(Context object, FontResourcesParserCompat.FontFamilyFilesResourceEntry object2, Resources resources, int n) {
        Object var1_2 = null;
        try {
            void var4_17;
            void var1_3;
            void var2_8;
            for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : var2_8.getEntries()) {
                try {
                    void var3_16;
                    Font.Builder builder = new Font.Builder((Resources)var3_16, fontFileResourceEntry.getResourceId());
                    builder = builder.setWeight(fontFileResourceEntry.getWeight());
                    int n2 = fontFileResourceEntry.isItalic() ? 1 : 0;
                    builder = builder.setSlant(n2).setTtcIndex(fontFileResourceEntry.getTtcIndex()).setFontVariationSettings(fontFileResourceEntry.getVariationSettings()).build();
                    if (var1_3 == null) {
                        FontFamily.Builder builder2;
                        FontFamily.Builder builder3 = builder2 = new FontFamily.Builder((Font)builder);
                        continue;
                    }
                    var1_3.addFont((Font)builder);
                }
                catch (IOException iOException) {
                    // empty catch block
                }
            }
            if (var1_3 == null) {
                return null;
            }
            FontFamily fontFamily = var1_3.build();
            Typeface.CustomFallbackBuilder customFallbackBuilder = new Typeface.CustomFallbackBuilder(fontFamily);
            return customFallbackBuilder.setStyle(this.findBaseFont(fontFamily, (int)var4_17).getStyle()).build();
        }
        catch (Exception exception) {
            return null;
        }
    }

    /*
     * Exception decompiling
     */
    @Override
    public Typeface createFromFontInfo(Context var1_1, CancellationSignal var2_4, FontsContractCompat.FontInfo[] var3_5, int var4_6) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
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

    @Override
    protected Typeface createFromInputStream(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override
    public Typeface createFromResourcesFontFile(Context context, Resources resources, int n, String string2, int n2) {
        try {
            context = new Font.Builder(resources, n);
            context = context.build();
            resources = new FontFamily.Builder((Font)context);
            resources = resources.build();
            string2 = new Typeface.CustomFallbackBuilder((FontFamily)resources);
            context = string2.setStyle(context.getStyle()).build();
            return context;
        }
        catch (Exception exception) {
            return null;
        }
    }

    @Override
    Typeface createWeightStyle(Context context, Typeface typeface, int n, boolean bl) {
        return Typeface.create((Typeface)typeface, (int)n, (boolean)bl);
    }

    @Override
    protected FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] fontInfoArray, int n) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}

