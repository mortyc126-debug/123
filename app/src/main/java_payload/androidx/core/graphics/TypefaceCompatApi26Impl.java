/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.content.res.Resources
 *  android.graphics.Typeface
 *  android.graphics.fonts.FontVariationAxis
 *  android.os.CancellationSignal
 *  android.util.Log
 */
package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.graphics.TypefaceCompatApi21Impl;
import androidx.core.graphics.WeightTypefaceApi26;
import androidx.core.provider.FontsContractCompat;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public class TypefaceCompatApi26Impl
extends TypefaceCompatApi21Impl {
    private static final String ABORT_CREATION_METHOD = "abortCreation";
    private static final String ADD_FONT_FROM_ASSET_MANAGER_METHOD = "addFontFromAssetManager";
    private static final String ADD_FONT_FROM_BUFFER_METHOD = "addFontFromBuffer";
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    private static final String FREEZE_METHOD = "freeze";
    private static final int RESOLVE_BY_FONT_TABLE = -1;
    private static final String TAG = "TypefaceCompatApi26Impl";
    protected final Method mAbortCreation;
    protected final Method mAddFontFromAssetManager;
    protected final Method mAddFontFromBuffer;
    protected final Method mCreateFromFamiliesWithDefault;
    protected final Class<?> mFontFamily;
    protected final Constructor<?> mFontFamilyCtor;
    protected final Method mFreeze;

    public TypefaceCompatApi26Impl() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Constructor<?> constructor;
        Class<?> clazz;
        block3: {
            try {
                clazz = this.obtainFontFamily();
                constructor = this.obtainFontFamilyCtor(clazz);
                method5 = this.obtainAddFontFromAssetManagerMethod(clazz);
                method4 = this.obtainAddFontFromBufferMethod(clazz);
                method3 = this.obtainFreezeMethod(clazz);
                method2 = this.obtainAbortCreationMethod(clazz);
                method = this.obtainCreateFromFamiliesWithDefaultMethod(clazz);
                break block3;
            }
            catch (NoSuchMethodException noSuchMethodException) {
            }
            catch (ClassNotFoundException classNotFoundException) {
                // empty catch block
            }
            Log.e((String)TAG, (String)("Unable to collect necessary methods for class " + method3.getClass().getName()), (Throwable)((Object)method3));
            clazz = null;
            constructor = null;
            method5 = null;
            method4 = null;
            method3 = null;
            method2 = null;
            method = null;
        }
        this.mFontFamily = clazz;
        this.mFontFamilyCtor = constructor;
        this.mAddFontFromAssetManager = method5;
        this.mAddFontFromBuffer = method4;
        this.mFreeze = method3;
        this.mAbortCreation = method2;
        this.mCreateFromFamiliesWithDefault = method;
    }

    private void abortCreation(Object object) {
        try {
            this.mAbortCreation.invoke(object, new Object[0]);
        }
        catch (InvocationTargetException invocationTargetException) {
        }
        catch (IllegalAccessException illegalAccessException) {
            // empty catch block
        }
    }

    private boolean addFontFromAssetManager(Context context, Object object, String string2, int n, int n2, int n3, FontVariationAxis[] fontVariationAxisArray) {
        try {
            boolean bl = (Boolean)this.mAddFontFromAssetManager.invoke(object, context.getAssets(), string2, 0, false, n, n2, n3, fontVariationAxisArray);
            return bl;
        }
        catch (InvocationTargetException invocationTargetException) {
        }
        catch (IllegalAccessException illegalAccessException) {
            // empty catch block
        }
        return false;
    }

    private boolean addFontFromBuffer(Object object, ByteBuffer byteBuffer, int n, int n2, int n3) {
        try {
            boolean bl = (Boolean)this.mAddFontFromBuffer.invoke(object, byteBuffer, n, null, n2, n3);
            return bl;
        }
        catch (InvocationTargetException invocationTargetException) {
        }
        catch (IllegalAccessException illegalAccessException) {
            // empty catch block
        }
        return false;
    }

    private boolean freeze(Object object) {
        try {
            boolean bl = (Boolean)this.mFreeze.invoke(object, new Object[0]);
            return bl;
        }
        catch (InvocationTargetException invocationTargetException) {
        }
        catch (IllegalAccessException illegalAccessException) {
            // empty catch block
        }
        return false;
    }

    private boolean isFontFamilyPrivateAPIAvailable() {
        if (this.mAddFontFromAssetManager == null) {
            Log.w((String)TAG, (String)"Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        boolean bl = this.mAddFontFromAssetManager != null;
        return bl;
    }

    private Object newFamily() {
        try {
            Object obj = this.mFontFamilyCtor.newInstance(new Object[0]);
            return obj;
        }
        catch (InvocationTargetException invocationTargetException) {
        }
        catch (InstantiationException instantiationException) {
        }
        catch (IllegalAccessException illegalAccessException) {
            // empty catch block
        }
        return null;
    }

    protected Typeface createFromFamiliesWithDefault(Object object) {
        try {
            Object object2 = Array.newInstance(this.mFontFamily, 1);
            Array.set(object2, 0, object);
            object = (Typeface)this.mCreateFromFamiliesWithDefault.invoke(null, object2, -1, -1);
            return object;
        }
        catch (InvocationTargetException invocationTargetException) {
        }
        catch (IllegalAccessException illegalAccessException) {
            // empty catch block
        }
        return null;
    }

    @Override
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFileResourceEntryArray, Resources object, int n) {
        if (!this.isFontFamilyPrivateAPIAvailable()) {
            return super.createFromFontFamilyFilesResourceEntry(context, (FontResourcesParserCompat.FontFamilyFilesResourceEntry)fontFileResourceEntryArray, (Resources)object, n);
        }
        object = this.newFamily();
        if (object == null) {
            return null;
        }
        for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : fontFileResourceEntryArray.getEntries()) {
            if (this.addFontFromAssetManager(context, object, fontFileResourceEntry.getFileName(), fontFileResourceEntry.getTtcIndex(), fontFileResourceEntry.getWeight(), fontFileResourceEntry.isItalic() ? 1 : 0, FontVariationAxis.fromFontVariationSettings((String)fontFileResourceEntry.getVariationSettings()))) continue;
            this.abortCreation(object);
            return null;
        }
        if (!this.freeze(object)) {
            return null;
        }
        return this.createFromFamiliesWithDefault(object);
    }

    /*
     * Exception decompiling
     */
    @Override
    public Typeface createFromFontInfo(Context var1_1, CancellationSignal var2_4, FontsContractCompat.FontInfo[] var3_6, int var4_7) {
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
    public Typeface createFromResourcesFontFile(Context context, Resources object, int n, String string2, int n2) {
        if (!this.isFontFamilyPrivateAPIAvailable()) {
            return super.createFromResourcesFontFile(context, (Resources)object, n, string2, n2);
        }
        object = this.newFamily();
        if (object == null) {
            return null;
        }
        if (!this.addFontFromAssetManager(context, object, string2, 0, -1, -1, null)) {
            this.abortCreation(object);
            return null;
        }
        if (!this.freeze(object)) {
            return null;
        }
        return this.createFromFamiliesWithDefault(object);
    }

    @Override
    Typeface createWeightStyle(Context context, Typeface typeface, int n, boolean bl) {
        Typeface typeface2;
        Typeface typeface3 = null;
        try {
            typeface3 = typeface2 = WeightTypefaceApi26.createWeightStyle(typeface, n, bl);
        }
        catch (RuntimeException runtimeException) {
            // empty catch block
        }
        typeface2 = typeface3;
        if (typeface3 == null) {
            typeface2 = super.createWeightStyle(context, typeface, n, bl);
        }
        return typeface2;
    }

    protected Method obtainAbortCreationMethod(Class<?> clazz) throws NoSuchMethodException {
        return clazz.getMethod(ABORT_CREATION_METHOD, new Class[0]);
    }

    protected Method obtainAddFontFromAssetManagerMethod(Class<?> clazz) throws NoSuchMethodException {
        return clazz.getMethod(ADD_FONT_FROM_ASSET_MANAGER_METHOD, AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class);
    }

    protected Method obtainAddFontFromBufferMethod(Class<?> clazz) throws NoSuchMethodException {
        return clazz.getMethod(ADD_FONT_FROM_BUFFER_METHOD, ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE);
    }

    protected Method obtainCreateFromFamiliesWithDefaultMethod(Class<?> genericDeclaration) throws NoSuchMethodException {
        genericDeclaration = Typeface.class.getDeclaredMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, Array.newInstance(genericDeclaration, 1).getClass(), Integer.TYPE, Integer.TYPE);
        ((Method)genericDeclaration).setAccessible(true);
        return genericDeclaration;
    }

    protected Class<?> obtainFontFamily() throws ClassNotFoundException {
        return Class.forName(FONT_FAMILY_CLASS);
    }

    protected Constructor<?> obtainFontFamilyCtor(Class<?> clazz) throws NoSuchMethodException {
        return clazz.getConstructor(new Class[0]);
    }

    protected Method obtainFreezeMethod(Class<?> clazz) throws NoSuchMethodException {
        return clazz.getMethod(FREEZE_METHOD, new Class[0]);
    }
}

