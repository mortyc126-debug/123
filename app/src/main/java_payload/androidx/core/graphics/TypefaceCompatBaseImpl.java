/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Typeface
 *  android.os.CancellationSignal
 *  android.util.Log
 */
package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.graphics.WeightTypefaceApi14;
import androidx.core.provider.FontsContractCompat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

class TypefaceCompatBaseImpl {
    private static final int INVALID_KEY = 0;
    private static final String TAG = "TypefaceCompatBaseImpl";
    private ConcurrentHashMap<Long, FontResourcesParserCompat.FontFamilyFilesResourceEntry> mFontFamilies = new ConcurrentHashMap();

    TypefaceCompatBaseImpl() {
    }

    private void addFontFamily(Typeface typeface, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry) {
        long l = TypefaceCompatBaseImpl.getUniqueKey(typeface);
        if (l != 0L) {
            this.mFontFamilies.put(l, fontFamilyFilesResourceEntry);
        }
    }

    private FontResourcesParserCompat.FontFileResourceEntry findBestEntry(FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, int n) {
        return TypefaceCompatBaseImpl.findBestFont(fontFamilyFilesResourceEntry.getEntries(), n, new StyleExtractor<FontResourcesParserCompat.FontFileResourceEntry>(this){
            final TypefaceCompatBaseImpl this$0;
            {
                this.this$0 = typefaceCompatBaseImpl;
            }

            @Override
            public int getWeight(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
                return fontFileResourceEntry.getWeight();
            }

            @Override
            public boolean isItalic(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
                return fontFileResourceEntry.isItalic();
            }
        });
    }

    private FontResourcesParserCompat.FontFileResourceEntry findBestEntry(FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, int n, boolean bl) {
        return TypefaceCompatBaseImpl.findBestFont(fontFamilyFilesResourceEntry.getEntries(), n, bl, new StyleExtractor<FontResourcesParserCompat.FontFileResourceEntry>(this){
            final TypefaceCompatBaseImpl this$0;
            {
                this.this$0 = typefaceCompatBaseImpl;
            }

            @Override
            public int getWeight(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
                return fontFileResourceEntry.getWeight();
            }

            @Override
            public boolean isItalic(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
                return fontFileResourceEntry.isItalic();
            }
        });
    }

    private static <T> T findBestFont(T[] TArray, int n, StyleExtractor<T> styleExtractor) {
        int n2 = (n & 1) == 0 ? 400 : 700;
        boolean bl = (n & 2) != 0;
        return TypefaceCompatBaseImpl.findBestFont(TArray, n2, bl, styleExtractor);
    }

    private static <T> T findBestFont(T[] TArray, int n, boolean bl, StyleExtractor<T> styleExtractor) {
        T t = null;
        int n2 = Integer.MAX_VALUE;
        for (T t2 : TArray) {
            int n3;
            block4: {
                int n4;
                block3: {
                    n4 = Math.abs(styleExtractor.getWeight(t2) - n);
                    n3 = styleExtractor.isItalic(t2) == bl ? 0 : 1;
                    n4 = n4 * 2 + n3;
                    if (t == null) break block3;
                    n3 = n2;
                    if (n2 <= n4) break block4;
                }
                t = t2;
                n3 = n4;
            }
            n2 = n3;
        }
        return t;
    }

    private static long getUniqueKey(Typeface typeface) {
        if (typeface == null) {
            return 0L;
        }
        try {
            Field field = Typeface.class.getDeclaredField("native_instance");
            field.setAccessible(true);
            long l = ((Number)field.get(typeface)).longValue();
            return l;
        }
        catch (IllegalAccessException illegalAccessException) {
            Log.e((String)TAG, (String)"Could not retrieve font from family.", (Throwable)illegalAccessException);
            return 0L;
        }
        catch (NoSuchFieldException noSuchFieldException) {
            Log.e((String)TAG, (String)"Could not retrieve font from family.", (Throwable)noSuchFieldException);
            return 0L;
        }
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int n) {
        FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry = this.findBestEntry(fontFamilyFilesResourceEntry, n);
        if (fontFileResourceEntry == null) {
            return null;
        }
        context = TypefaceCompat.createFromResourcesFontFile(context, resources, fontFileResourceEntry.getResourceId(), fontFileResourceEntry.getFileName(), 0, n);
        this.addFontFamily((Typeface)context, fontFamilyFilesResourceEntry);
        return context;
    }

    Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int n, boolean bl) {
        FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry = this.findBestEntry(fontFamilyFilesResourceEntry, n, bl);
        if (fontFileResourceEntry == null) {
            return null;
        }
        context = TypefaceCompat.createFromResourcesFontFile(context, resources, fontFileResourceEntry.getResourceId(), fontFileResourceEntry.getFileName(), 0, 0);
        this.addFontFamily((Typeface)context, fontFamilyFilesResourceEntry);
        return context;
    }

    public Typeface createFromFontInfo(Context context, CancellationSignal object, FontsContractCompat.FontInfo[] object2, int n) {
        if (((FontsContractCompat.FontInfo[])object2).length < 1) {
            return null;
        }
        Object object3 = this.findBestInfo((FontsContractCompat.FontInfo[])object2, n);
        object2 = null;
        object = null;
        object3 = context.getContentResolver().openInputStream(((FontsContractCompat.FontInfo)object3).getUri());
        object = object3;
        object2 = object3;
        try {
            context = this.createFromInputStream(context, (InputStream)object3);
        }
        catch (Throwable throwable) {
            TypefaceCompatUtil.closeQuietly((Closeable)object);
            throw throwable;
        }
        catch (IOException iOException) {
            TypefaceCompatUtil.closeQuietly((Closeable)object2);
            return null;
        }
        TypefaceCompatUtil.closeQuietly((Closeable)object3);
        return context;
    }

    protected Typeface createFromInputStream(Context object, InputStream inputStream) {
        block6: {
            if ((object = TypefaceCompatUtil.getTempFile((Context)object)) == null) {
                return null;
            }
            boolean bl = TypefaceCompatUtil.copyToFile((File)object, inputStream);
            if (bl) break block6;
            ((File)object).delete();
            return null;
        }
        try {
            inputStream = Typeface.createFromFile((String)((File)object).getPath());
            return inputStream;
        }
        catch (Throwable throwable) {
            throw throwable;
        }
        catch (RuntimeException runtimeException) {
            return null;
        }
        finally {
            ((File)object).delete();
        }
    }

    public Typeface createFromResourcesFontFile(Context object, Resources resources, int n, String string2, int n2) {
        block6: {
            if ((object = TypefaceCompatUtil.getTempFile((Context)object)) == null) {
                return null;
            }
            boolean bl = TypefaceCompatUtil.copyToFile((File)object, resources, n);
            if (bl) break block6;
            ((File)object).delete();
            return null;
        }
        try {
            resources = Typeface.createFromFile((String)((File)object).getPath());
            return resources;
        }
        catch (Throwable throwable) {
            throw throwable;
        }
        catch (RuntimeException runtimeException) {
            return null;
        }
        finally {
            ((File)object).delete();
        }
    }

    Typeface createWeightStyle(Context context, Typeface typeface, int n, boolean bl) {
        Context context2 = null;
        try {
            context = WeightTypefaceApi14.createWeightStyle(this, context, typeface, n, bl);
        }
        catch (RuntimeException runtimeException) {
            context = context2;
        }
        context2 = context;
        if (context == null) {
            context2 = typeface;
        }
        return context2;
    }

    protected FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] fontInfoArray, int n) {
        return TypefaceCompatBaseImpl.findBestFont(fontInfoArray, n, new StyleExtractor<FontsContractCompat.FontInfo>(this){
            final TypefaceCompatBaseImpl this$0;
            {
                this.this$0 = typefaceCompatBaseImpl;
            }

            @Override
            public int getWeight(FontsContractCompat.FontInfo fontInfo) {
                return fontInfo.getWeight();
            }

            @Override
            public boolean isItalic(FontsContractCompat.FontInfo fontInfo) {
                return fontInfo.isItalic();
            }
        });
    }

    FontResourcesParserCompat.FontFamilyFilesResourceEntry getFontFamily(Typeface typeface) {
        long l = TypefaceCompatBaseImpl.getUniqueKey(typeface);
        if (l == 0L) {
            return null;
        }
        return this.mFontFamilies.get(l);
    }

    private static interface StyleExtractor<T> {
        public int getWeight(T var1);

        public boolean isItalic(T var1);
    }
}

