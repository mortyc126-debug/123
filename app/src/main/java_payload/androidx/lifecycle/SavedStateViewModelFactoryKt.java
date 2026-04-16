/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  kotlin.Metadata
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.lifecycle;

import android.app.Application;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a6\u0010\u0004\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00022\u0010\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001H\u0000\u001aI\u0010\t\u001a\u0002H\u0006\"\n\b\u0000\u0010\u0006*\u0004\u0018\u00010\n2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00052\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\"\u00020\u000eH\u0000\u00a2\u0006\u0002\u0010\u000f\"\u0018\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0018\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"ANDROID_VIEWMODEL_SIGNATURE", "", "Ljava/lang/Class;", "VIEWMODEL_SIGNATURE", "findMatchingConstructor", "Ljava/lang/reflect/Constructor;", "T", "modelClass", "signature", "newInstance", "Landroidx/lifecycle/ViewModel;", "constructor", "params", "", "", "(Ljava/lang/Class;Ljava/lang/reflect/Constructor;[Ljava/lang/Object;)Landroidx/lifecycle/ViewModel;", "lifecycle-viewmodel-savedstate_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class SavedStateViewModelFactoryKt {
    private static final List<Class<?>> ANDROID_VIEWMODEL_SIGNATURE = CollectionsKt.listOf((Object[])new Class[]{Application.class, SavedStateHandle.class});
    private static final List<Class<?>> VIEWMODEL_SIGNATURE = CollectionsKt.listOf(SavedStateHandle.class);

    public static final /* synthetic */ List access$getANDROID_VIEWMODEL_SIGNATURE$p() {
        return ANDROID_VIEWMODEL_SIGNATURE;
    }

    public static final /* synthetic */ List access$getVIEWMODEL_SIGNATURE$p() {
        return VIEWMODEL_SIGNATURE;
    }

    public static final <T> Constructor<T> findMatchingConstructor(Class<T> serializable, List<? extends Class<?>> list) {
        Intrinsics.checkNotNullParameter(serializable, (String)"modelClass");
        Intrinsics.checkNotNullParameter(list, (String)"signature");
        Constructor<?>[] constructorArray = ((Class)serializable).getConstructors();
        Intrinsics.checkNotNullExpressionValue(constructorArray, (String)"modelClass.constructors");
        for (Constructor<?> constructor : constructorArray) {
            Object object = constructor.getParameterTypes();
            Intrinsics.checkNotNullExpressionValue(object, (String)"constructor.parameterTypes");
            object = ArraysKt.toList((Object[])((Object[])object));
            if (Intrinsics.areEqual(list, object)) {
                Intrinsics.checkNotNull(constructor, (String)"null cannot be cast to non-null type java.lang.reflect.Constructor<T of androidx.lifecycle.SavedStateViewModelFactoryKt.findMatchingConstructor>");
                return constructor;
            }
            if (list.size() != object.size() || !object.containsAll((Collection)list)) continue;
            serializable = new StringBuilder().append("Class ").append(((Class)serializable).getSimpleName()).append(" must have parameters in the proper order: ");
            throw new UnsupportedOperationException(((StringBuilder)serializable).append(list).toString());
        }
        return null;
    }

    public static final <T extends ViewModel> T newInstance(Class<T> clazz, Constructor<T> object, Object ... objectArray) {
        Intrinsics.checkNotNullParameter(clazz, (String)"modelClass");
        Intrinsics.checkNotNullParameter(object, (String)"constructor");
        Intrinsics.checkNotNullParameter((Object)objectArray, (String)"params");
        try {
            object = (ViewModel)((Constructor)object).newInstance(Arrays.copyOf(objectArray, objectArray.length));
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new RuntimeException("An exception happened in constructor of " + clazz, invocationTargetException.getCause());
        }
        catch (InstantiationException instantiationException) {
            throw new RuntimeException("A " + clazz + " cannot be instantiated.", instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException("Failed to access " + clazz, illegalAccessException);
        }
        return (T)object;
    }
}

