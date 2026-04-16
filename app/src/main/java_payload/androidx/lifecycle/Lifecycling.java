/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 */
package androidx.lifecycle;

import androidx.lifecycle.ClassesInfoCache;
import androidx.lifecycle.CompositeGeneratedAdaptersObserver;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.DefaultLifecycleObserverAdapter;
import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.ReflectiveGenericLifecycleObserver;
import androidx.lifecycle.SingleGeneratedAdapterObserver;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\r\u001a\u00020\f2\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u0001H\u0002J\u001e\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000b2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\u0014\u0010\u0015\u001a\u00020\u00042\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\bH\u0002J\u0016\u0010\u0016\u001a\u00020\u00172\f\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\bH\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u0001H\u0007J\u0014\u0010\u001a\u001a\u00020\u00042\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R,\u0010\t\u001a \u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\n0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2={"Landroidx/lifecycle/Lifecycling;", "", "()V", "GENERATED_CALLBACK", "", "REFLECTIVE_CALLBACK", "callbackCache", "", "Ljava/lang/Class;", "classToAdapters", "", "Ljava/lang/reflect/Constructor;", "Landroidx/lifecycle/GeneratedAdapter;", "createGeneratedAdapter", "constructor", "object", "generatedConstructor", "klass", "getAdapterName", "", "className", "getObserverConstructorType", "isLifecycleParent", "", "lifecycleEventObserver", "Landroidx/lifecycle/LifecycleEventObserver;", "resolveObserverCallbackType", "lifecycle-common"}, k=1, mv={1, 8, 0}, xi=48)
public final class Lifecycling {
    private static final int GENERATED_CALLBACK = 2;
    public static final Lifecycling INSTANCE = new Lifecycling();
    private static final int REFLECTIVE_CALLBACK = 1;
    private static final Map<Class<?>, Integer> callbackCache = new HashMap();
    private static final Map<Class<?>, List<Constructor<? extends GeneratedAdapter>>> classToAdapters = new HashMap();

    private Lifecycling() {
    }

    private final GeneratedAdapter createGeneratedAdapter(Constructor<? extends GeneratedAdapter> object, Object object2) {
        try {
            object = ((Constructor)object).newInstance(object2);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"{\n            constructo\u2026tance(`object`)\n        }");
            object = (GeneratedAdapter)object;
            return object;
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new RuntimeException(invocationTargetException);
        }
        catch (InstantiationException instantiationException) {
            throw new RuntimeException(instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(illegalAccessException);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final Constructor<? extends GeneratedAdapter> generatedConstructor(Class<?> genericDeclaration) {
        try {
            Object object = ((Class)genericDeclaration).getPackage();
            String string2 = ((Class)genericDeclaration).getCanonicalName();
            object = object != null ? ((Package)object).getName() : "";
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"fullPackage");
            boolean bl = ((CharSequence)object).length() == 0;
            if (!bl) {
                Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"name");
                string2 = string2.substring(((String)object).length() + 1);
                Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"this as java.lang.String).substring(startIndex)");
            }
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"if (fullPackage.isEmpty(\u2026g(fullPackage.length + 1)");
            string2 = Lifecycling.getAdapterName(string2);
            bl = ((CharSequence)object).length() == 0;
            if (bl) {
                object = string2;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                object = stringBuilder.append((String)object).append('.').append(string2).toString();
            }
            object = Class.forName((String)object);
            Intrinsics.checkNotNull(object, (String)"null cannot be cast to non-null type java.lang.Class<out androidx.lifecycle.GeneratedAdapter>");
            genericDeclaration = ((Class)object).getDeclaredConstructor(new Class[]{genericDeclaration});
            if (((AccessibleObject)((Object)genericDeclaration)).isAccessible()) return genericDeclaration;
            ((Constructor)genericDeclaration).setAccessible(true);
            return genericDeclaration;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new RuntimeException(noSuchMethodException);
        }
        catch (ClassNotFoundException classNotFoundException) {
            return null;
        }
    }

    @JvmStatic
    public static final String getAdapterName(String string2) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"className");
        return StringsKt.replace$default((String)string2, (String)".", (String)"_", (boolean)false, (int)4, null) + "_LifecycleAdapter";
    }

    private final int getObserverConstructorType(Class<?> clazz) {
        Integer n = callbackCache.get(clazz);
        if (n != null) {
            return n;
        }
        int n2 = this.resolveObserverCallbackType(clazz);
        callbackCache.put(clazz, n2);
        return n2;
    }

    private final boolean isLifecycleParent(Class<?> clazz) {
        boolean bl = clazz != null && LifecycleObserver.class.isAssignableFrom(clazz);
        return bl;
    }

    @JvmStatic
    public static final LifecycleEventObserver lifecycleEventObserver(Object object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"object");
        boolean bl = object instanceof LifecycleEventObserver;
        boolean bl2 = object instanceof DefaultLifecycleObserver;
        if (bl && bl2) {
            return new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver)object, (LifecycleEventObserver)object);
        }
        if (bl2) {
            return new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver)object, null);
        }
        if (bl) {
            return (LifecycleEventObserver)object;
        }
        Object object2 = object.getClass();
        if (INSTANCE.getObserverConstructorType((Class<?>)object2) == 2) {
            object2 = classToAdapters.get(object2);
            Intrinsics.checkNotNull((Object)object2);
            List list = (List)object2;
            int n = list.size();
            if (n == 1) {
                return new SingleGeneratedAdapterObserver(INSTANCE.createGeneratedAdapter((Constructor)list.get(0), object));
            }
            n = list.size();
            object2 = new GeneratedAdapter[n];
            for (int i = 0; i < n; ++i) {
                object2[i] = INSTANCE.createGeneratedAdapter((Constructor)list.get(i), object);
            }
            return new CompositeGeneratedAdaptersObserver((GeneratedAdapter[])object2);
        }
        return new ReflectiveGenericLifecycleObserver(object);
    }

    private final int resolveObserverCallbackType(Class<?> clazz) {
        if (clazz.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends GeneratedAdapter> constructor = this.generatedConstructor(clazz);
        if (constructor != null) {
            classToAdapters.put(clazz, CollectionsKt.listOf(constructor));
            return 2;
        }
        if (ClassesInfoCache.sInstance.hasLifecycleMethods(clazz)) {
            return 1;
        }
        constructor = clazz.getSuperclass();
        List<Constructor<? extends GeneratedAdapter>> list = null;
        if (this.isLifecycleParent((Class<?>)((Object)constructor))) {
            Intrinsics.checkNotNullExpressionValue(constructor, (String)"superclass");
            if (this.getObserverConstructorType((Class<?>)((Object)constructor)) == 1) {
                return 1;
            }
            constructor = classToAdapters.get(constructor);
            Intrinsics.checkNotNull((Object)constructor);
            list = new ArrayList((Collection)((Object)constructor));
        }
        Class<?>[] classArray = clazz.getInterfaces();
        Intrinsics.checkNotNullExpressionValue(classArray, (String)"klass.interfaces");
        for (Class<?> clazz2 : classArray) {
            if (!this.isLifecycleParent(clazz2)) {
                constructor = list;
            } else {
                Intrinsics.checkNotNullExpressionValue(clazz2, (String)"intrface");
                if (this.getObserverConstructorType(clazz2) == 1) {
                    return 1;
                }
                constructor = list;
                if (list == null) {
                    constructor = new ArrayList();
                }
                list = classToAdapters.get(clazz2);
                Intrinsics.checkNotNull(list);
                constructor.addAll(list);
            }
            list = constructor;
        }
        if (list != null) {
            classToAdapters.put(clazz, list);
            return 2;
        }
        return 1;
    }
}

