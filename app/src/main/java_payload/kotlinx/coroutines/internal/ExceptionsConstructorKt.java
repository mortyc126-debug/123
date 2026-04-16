/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.TuplesKt
 *  kotlin.jvm.JvmClassMappingKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CopyableThrowable;
import kotlinx.coroutines.internal.ClassValueCtorCache;
import kotlinx.coroutines.internal.CtorCache;
import kotlinx.coroutines.internal.ExceptionsConstructorKt;
import kotlinx.coroutines.internal.FastServiceLoaderKt;
import kotlinx.coroutines.internal.WeakMapCtorCache;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a2\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\u0002`\u0007\"\b\b\u0000\u0010\b*\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\u0002\u001a.\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\u0002`\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u0002\u001a!\u0010\r\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\u00062\u0006\u0010\u000e\u001a\u0002H\bH\u0000\u00a2\u0006\u0002\u0010\u000f\u001a\u001b\u0010\u0010\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\n2\b\b\u0002\u0010\u0011\u001a\u00020\u0003H\u0082\u0010\u001a\u0018\u0010\u0012\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u0013\u001a\u00020\u0003H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000*(\b\u0002\u0010\u0014\"\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u00a8\u0006\u0015"}, d2={"ctorCache", "Lkotlinx/coroutines/internal/CtorCache;", "throwableFields", "", "createConstructor", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/Ctor;", "E", "clz", "Ljava/lang/Class;", "safeCtor", "block", "tryCopyException", "exception", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "fieldsCount", "accumulator", "fieldsCountOrDefault", "defaultValue", "Ctor", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class ExceptionsConstructorKt {
    private static final CtorCache ctorCache;
    private static final int throwableFields;

    static {
        CtorCache ctorCache;
        throwableFields = ExceptionsConstructorKt.fieldsCountOrDefault(Throwable.class, -1);
        try {
            ctorCache = FastServiceLoaderKt.getANDROID_DETECTED() ? (CtorCache)WeakMapCtorCache.INSTANCE : (CtorCache)ClassValueCtorCache.INSTANCE;
        }
        catch (Throwable throwable) {
            ctorCache = WeakMapCtorCache.INSTANCE;
        }
        ExceptionsConstructorKt.ctorCache = ctorCache;
    }

    public static final /* synthetic */ Function1 access$createConstructor(Class clazz) {
        return ExceptionsConstructorKt.createConstructor(clazz);
    }

    private static final <E extends Throwable> Function1<Throwable, Throwable> createConstructor(Class<E> object) {
        block18: {
            Function1 function1;
            block17: {
                Object object2;
                function1 = createConstructor.nullResult.1.INSTANCE;
                int n = throwableFields;
                int n2 = 0;
                if (n != ExceptionsConstructorKt.fieldsCountOrDefault(object, 0)) {
                    return function1;
                }
                Object object3 = object.getConstructors();
                Collection collection = new ArrayList(((Constructor<?>[])object3).length);
                int n3 = ((Constructor<?>[])object3).length;
                n = 0;
                while (true) {
                    object = null;
                    if (n >= n3) break;
                    object = object3[n];
                    object2 = object.getParameterTypes();
                    switch (((Class<?>[])object2).length) {
                        default: {
                            object = TuplesKt.to(null, (Object)-1);
                            break;
                        }
                        case 2: {
                            if (Intrinsics.areEqual((Object)object2[n2], String.class) && Intrinsics.areEqual((Object)object2[1], Throwable.class)) {
                                object = TuplesKt.to(ExceptionsConstructorKt.safeCtor((Function1<? super Throwable, ? extends Throwable>)((Function1)new Function1<Throwable, Throwable>(object){
                                    final Constructor<?> $constructor;
                                    {
                                        this.$constructor = constructor;
                                        super(1);
                                    }

                                    public final Throwable invoke(Throwable throwable) {
                                        throwable = this.$constructor.newInstance(throwable.getMessage(), throwable);
                                        Intrinsics.checkNotNull((Object)throwable, (String)"null cannot be cast to non-null type kotlin.Throwable");
                                        return throwable;
                                    }
                                })), (Object)3);
                                n2 = 0;
                                break;
                            }
                            object = TuplesKt.to(null, (Object)-1);
                            n2 = 0;
                            break;
                        }
                        case 1: {
                            object2 = object2[0];
                            if (Intrinsics.areEqual((Object)object2, String.class)) {
                                object = TuplesKt.to(ExceptionsConstructorKt.safeCtor((Function1<? super Throwable, ? extends Throwable>)((Function1)new Function1<Throwable, Throwable>(object){
                                    final Constructor<?> $constructor;
                                    {
                                        this.$constructor = constructor;
                                        super(1);
                                    }

                                    public final Throwable invoke(Throwable throwable) {
                                        Object object = this.$constructor.newInstance(throwable.getMessage());
                                        Intrinsics.checkNotNull(object, (String)"null cannot be cast to non-null type kotlin.Throwable");
                                        object = (Throwable)object;
                                        ((Throwable)object).initCause(throwable);
                                        return object;
                                    }
                                })), (Object)2);
                                n2 = 0;
                                break;
                            }
                            if (Intrinsics.areEqual((Object)object2, Throwable.class)) {
                                object = TuplesKt.to(ExceptionsConstructorKt.safeCtor((Function1<? super Throwable, ? extends Throwable>)((Function1)new Function1<Throwable, Throwable>(object){
                                    final Constructor<?> $constructor;
                                    {
                                        this.$constructor = constructor;
                                        super(1);
                                    }

                                    public final Throwable invoke(Throwable throwable) {
                                        throwable = this.$constructor.newInstance(throwable);
                                        Intrinsics.checkNotNull((Object)throwable, (String)"null cannot be cast to non-null type kotlin.Throwable");
                                        return throwable;
                                    }
                                })), (Object)1);
                                n2 = 0;
                                break;
                            }
                            object = TuplesKt.to(null, (Object)-1);
                            n2 = 0;
                            break;
                        }
                        case 0: {
                            object = ExceptionsConstructorKt.safeCtor((Function1<? super Throwable, ? extends Throwable>)((Function1)new Function1<Throwable, Throwable>(object){
                                final Constructor<?> $constructor;
                                {
                                    this.$constructor = constructor;
                                    super(1);
                                }

                                public final Throwable invoke(Throwable throwable) {
                                    Object object = this.$constructor.newInstance(new Object[0]);
                                    Intrinsics.checkNotNull(object, (String)"null cannot be cast to non-null type kotlin.Throwable");
                                    object = (Throwable)object;
                                    ((Throwable)object).initCause(throwable);
                                    return object;
                                }
                            }));
                            n2 = 0;
                            object = TuplesKt.to((Object)object, (Object)0);
                        }
                    }
                    collection.add(object);
                    ++n;
                }
                object2 = ((Iterable)(collection = (List)collection)).iterator();
                if (object2.hasNext()) {
                    object = object2.next();
                    if (object2.hasNext()) {
                        n = ((Number)((Pair)object).getSecond()).intValue();
                        collection = object;
                        do {
                            object3 = object2.next();
                            n3 = ((Number)((Pair)object3).getSecond()).intValue();
                            n2 = n;
                            object = collection;
                            if (n < n3) {
                                n2 = n3;
                                object = object3;
                            }
                            n = n2;
                            collection = object;
                        } while (object2.hasNext());
                    }
                }
                object = (Function1)object;
                if (object == null) break block17;
                collection = (Function1)object.getFirst();
                object = collection;
                if (collection != null) break block18;
            }
            object = function1;
        }
        return object;
    }

    private static final int fieldsCount(Class<?> clazz, int n) {
        do {
            Field[] fieldArray = clazz.getDeclaredFields();
            int n2 = 0;
            int n3 = fieldArray.length;
            for (int i = 0; i < n3; ++i) {
                int n4 = n2;
                if (Modifier.isStatic(fieldArray[i].getModifiers()) ^ true) {
                    n4 = n2 + 1;
                }
                n2 = n4;
            }
            n += n2;
        } while ((clazz = clazz.getSuperclass()) != null);
        return n;
    }

    static /* synthetic */ int fieldsCount$default(Class clazz, int n, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = 0;
        }
        return ExceptionsConstructorKt.fieldsCount(clazz, n);
    }

    private static final int fieldsCountOrDefault(Class<?> object, int n) {
        Object object2;
        JvmClassMappingKt.getKotlinClass(object);
        try {
            object2 = Result.Companion;
            object = Result.constructor-impl((Object)ExceptionsConstructorKt.fieldsCount$default(object, 0, 1, null));
        }
        catch (Throwable throwable) {
            object2 = Result.Companion;
            object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
        object2 = object;
        if (Result.isFailure-impl((Object)object)) {
            object2 = n;
        }
        return ((Number)object2).intValue();
    }

    private static final Function1<Throwable, Throwable> safeCtor(Function1<? super Throwable, ? extends Throwable> function1) {
        return (Function1)new Function1<Throwable, Throwable>(function1){
            final Function1<Throwable, Throwable> $block;
            {
                this.$block = function1;
                super(1);
            }

            public final Throwable invoke(Throwable object) {
                block3: {
                    Function1<Throwable, Throwable> function1 = this.$block;
                    Object var2_4 = null;
                    Object object2 = Result.Companion;
                    object2 = (Throwable)function1.invoke(object);
                    object = !Intrinsics.areEqual((Object)((Throwable)object).getMessage(), (Object)((Throwable)object2).getMessage()) && !Intrinsics.areEqual((Object)((Throwable)object2).getMessage(), (Object)((Throwable)object).toString()) ? null : object2;
                    try {
                        object = Result.constructor-impl((Object)object);
                    }
                    catch (Throwable throwable) {
                        object2 = Result.Companion;
                        object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
                    }
                    if (!Result.isFailure-impl((Object)object)) break block3;
                    object = var2_4;
                }
                return (Throwable)object;
            }
        };
    }

    public static final <E extends Throwable> E tryCopyException(E object) {
        if (object instanceof CopyableThrowable) {
            Object object2;
            try {
                object2 = Result.Companion;
                object = Result.constructor-impl(((CopyableThrowable)object).createCopy());
            }
            catch (Throwable throwable) {
                object = Result.Companion;
                object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
            }
            object2 = object;
            if (Result.isFailure-impl(object)) {
                object2 = null;
            }
            return (E)((Throwable)object2);
        }
        return (E)((Throwable)ctorCache.get(object.getClass()).invoke(object));
    }
}

