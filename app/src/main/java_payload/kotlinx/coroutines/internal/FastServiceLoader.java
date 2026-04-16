/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.ExceptionsKt
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 */
package kotlinx.coroutines.internal;

import java.io.BufferedReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.internal.FastServiceLoaderKt;
import kotlinx.coroutines.internal.MainDispatcherFactory;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J!\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\t\u001a\u00020\u0004H\u0082\bJ1\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\bH\u0002\u00a2\u0006\u0002\u0010\u0010J*\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0012\"\u0004\b\u0000\u0010\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012H\u0000\u00a2\u0006\u0002\b\u0014J/\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0012\"\u0004\b\u0000\u0010\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\b2\u0006\u0010\r\u001a\u00020\u000eH\u0000\u00a2\u0006\u0002\b\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J,\u0010\u001d\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u001e*\u00020\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u0002H\u001e0!H\u0082\b\u00a2\u0006\u0002\u0010\"R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2={"Lkotlinx/coroutines/internal/FastServiceLoader;", "", "()V", "PREFIX", "", "createInstanceOf", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "baseClass", "Ljava/lang/Class;", "serviceClass", "getProviderInstance", "S", "name", "loader", "Ljava/lang/ClassLoader;", "service", "(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/Class;)Ljava/lang/Object;", "load", "", "loadMainDispatcherFactory", "loadMainDispatcherFactory$kotlinx_coroutines_core", "loadProviders", "loadProviders$kotlinx_coroutines_core", "parse", "url", "Ljava/net/URL;", "parseFile", "r", "Ljava/io/BufferedReader;", "use", "R", "Ljava/util/jar/JarFile;", "block", "Lkotlin/Function1;", "(Ljava/util/jar/JarFile;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public final class FastServiceLoader {
    public static final FastServiceLoader INSTANCE = new FastServiceLoader();
    private static final String PREFIX = "META-INF/services/";

    private FastServiceLoader() {
    }

    private final MainDispatcherFactory createInstanceOf(Class<MainDispatcherFactory> object, String string2) {
        try {
            object = ((Class)object).cast(Class.forName(string2, true, ((Class)object).getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        catch (ClassNotFoundException classNotFoundException) {
            object = null;
        }
        return object;
    }

    private final <S> S getProviderInstance(String object, ClassLoader classLoader, Class<S> clazz) {
        if (clazz.isAssignableFrom((Class<?>)(object = Class.forName((String)object, false, classLoader)))) {
            return clazz.cast(((Class)object).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        throw new IllegalArgumentException(("Expected service of class " + clazz + ", but found " + object).toString());
    }

    private final <S> List<S> load(Class<S> object, ClassLoader classLoader) {
        try {
            List<S> list = this.loadProviders$kotlinx_coroutines_core((Class<S>)object, classLoader);
            object = list;
        }
        catch (Throwable throwable) {
            object = CollectionsKt.toList((Iterable)ServiceLoader.load(object, classLoader));
        }
        return object;
    }

    /*
     * Exception decompiling
     */
    private final List<String> parse(URL var1_1) {
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

    private final List<String> parseFile(BufferedReader bufferedReader) {
        String string2;
        Set set = new LinkedHashSet();
        while (true) {
            int n;
            int n2;
            block4: {
                CharSequence charSequence;
                if ((charSequence = bufferedReader.readLine()) == null) {
                    return CollectionsKt.toList((Iterable)set);
                }
                string2 = ((Object)StringsKt.trim((CharSequence)StringsKt.substringBefore$default((String)charSequence, (String)"#", null, (int)2, null))).toString();
                charSequence = string2;
                n2 = 0;
                for (n = 0; n < charSequence.length(); ++n) {
                    char c = charSequence.charAt(n);
                    boolean bl = c == '.' || Character.isJavaIdentifierPart(c);
                    if (bl) continue;
                    n = 0;
                    break block4;
                }
                n = 1;
            }
            if (n == 0) break;
            n = n2;
            if (((CharSequence)string2).length() > 0) {
                n = 1;
            }
            if (n == 0) continue;
            set.add(string2);
        }
        throw new IllegalArgumentException(("Illegal service provider class name: " + string2).toString());
    }

    private final <R> R use(JarFile jarFile, Function1<? super JarFile, ? extends R> object) {
        try {
            object = object.invoke((Object)jarFile);
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                InlineMarker.finallyStart((int)1);
                try {
                    jarFile.close();
                }
                catch (Throwable throwable3) {
                    ExceptionsKt.addSuppressed((Throwable)throwable, (Throwable)throwable3);
                    throw throwable;
                }
                InlineMarker.finallyEnd((int)1);
                throw throwable2;
            }
        }
        InlineMarker.finallyStart((int)1);
        jarFile.close();
        InlineMarker.finallyEnd((int)1);
        return (R)object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final List<MainDispatcherFactory> loadMainDispatcherFactory$kotlinx_coroutines_core() {
        if (!FastServiceLoaderKt.getANDROID_DETECTED()) {
            return this.load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
        }
        try {
            Object object;
            ArrayList<Object> arrayList = new ArrayList<Object>(2);
            Object var2_2 = null;
            try {
                object = (MainDispatcherFactory)MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            catch (ClassNotFoundException classNotFoundException) {
                object = null;
            }
            if (object != null) {
                arrayList.add(object);
            }
            try {
                object = (MainDispatcherFactory)MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            catch (ClassNotFoundException classNotFoundException) {
                object = var2_2;
            }
            if (object == null) return arrayList;
            arrayList.add(object);
            return arrayList;
        }
        catch (Throwable throwable) {
            return this.load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
        }
    }

    public final <S> List<S> loadProviders$kotlinx_coroutines_core(Class<S> object, ClassLoader classLoader) {
        Collection<URL> collection = Collections.list(classLoader.getResources(PREFIX + ((Class)object).getName()));
        Intrinsics.checkNotNullExpressionValue(collection, (String)"list(this)");
        Iterator iterator2 = (List)collection;
        collection = new ArrayList();
        Object object2 = iterator2.iterator();
        while (object2.hasNext()) {
            iterator2 = (URL)object2.next();
            CollectionsKt.addAll(collection, (Iterable)INSTANCE.parse((URL)((Object)iterator2)));
        }
        collection = (List)collection;
        if (((Collection)(collection = CollectionsKt.toSet((Iterable)collection))).isEmpty() ^ true) {
            iterator2 = collection;
            collection = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)((Object)iterator2), (int)10));
            iterator2 = iterator2.iterator();
            while (iterator2.hasNext()) {
                object2 = (String)iterator2.next();
                collection.add((URL)INSTANCE.getProviderInstance((String)object2, classLoader, (Class<S>)object));
            }
            object = (List)collection;
            return object;
        }
        throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
    }
}

