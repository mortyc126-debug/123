/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work;

import androidx.work.Data;
import androidx.work.InputMerger;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u001e\u0010\f\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0002J\u0016\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0016\u00a8\u0006\u0011"}, d2={"Landroidx/work/ArrayCreatingInputMerger;", "Landroidx/work/InputMerger;", "()V", "concatenateArrayAndNonArray", "", "array", "obj", "valueClass", "Ljava/lang/Class;", "concatenateArrays", "array1", "array2", "createArrayFor", "merge", "Landroidx/work/Data;", "inputs", "", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public final class ArrayCreatingInputMerger
extends InputMerger {
    private final Object concatenateArrayAndNonArray(Object object, Object object2, Class<?> object3) {
        int n = Array.getLength(object);
        object3 = Array.newInstance(object3, n + 1);
        System.arraycopy(object, 0, object3, 0, n);
        Array.set(object3, n, object2);
        Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"newArray");
        return object3;
    }

    private final Object concatenateArrays(Object object, Object object2) {
        int n = Array.getLength(object);
        int n2 = Array.getLength(object2);
        Object object3 = object.getClass().getComponentType();
        Intrinsics.checkNotNull(object3);
        object3 = Array.newInstance(object3, n + n2);
        System.arraycopy(object, 0, object3, 0, n);
        System.arraycopy(object2, 0, object3, n, n2);
        Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"newArray");
        return object3;
    }

    private final Object createArrayFor(Object object, Class<?> object2) {
        object2 = Array.newInstance(object2, 1);
        Array.set(object2, 0, object);
        Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"newArray");
        return object2;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public Data merge(List<Data> object2) {
        Intrinsics.checkNotNullParameter((Object)object2, (String)"inputs");
        Data.Builder builder = new Data.Builder();
        Map map2 = new HashMap();
        Iterator iterator2 = object2.iterator();
        while (iterator2.hasNext()) {
            Map<String, Object> map3 = ((Data)iterator2.next()).getKeyValueMap();
            Intrinsics.checkNotNullExpressionValue(map3, (String)"input.keyValueMap");
            for (Map.Entry<String, Object> entry : map3.entrySet()) {
                block15: {
                    void var1_14;
                    String string2;
                    block13: {
                        Class<?> clazz;
                        void var1_9;
                        Class<Object> clazz2;
                        Object object;
                        block14: {
                            block12: {
                                block11: {
                                    block10: {
                                        string2 = entry.getKey();
                                        object = entry.getValue();
                                        if (object == null) break block10;
                                        clazz2 = object.getClass();
                                        Class<?> clazz3 = clazz2;
                                        if (clazz2 != null) break block11;
                                    }
                                    Class<String> clazz4 = String.class;
                                }
                                clazz2 = map2.get(string2);
                                Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"key");
                                if (clazz2 != null) break block12;
                                if (var1_9.isArray()) {
                                    Object object3 = object;
                                } else {
                                    Object object4 = this.createArrayFor(object, (Class<?>)var1_9);
                                }
                                break block13;
                            }
                            clazz = clazz2.getClass();
                            if (!Intrinsics.areEqual(clazz, (Object)var1_9)) break block14;
                            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"value");
                            Object object5 = this.concatenateArrays(clazz2, object);
                            break block13;
                        }
                        if (!Intrinsics.areEqual(clazz.getComponentType(), (Object)var1_9)) break block15;
                        Object object6 = this.concatenateArrayAndNonArray(clazz2, object, (Class<?>)var1_9);
                    }
                    Intrinsics.checkNotNullExpressionValue((Object)var1_14, (String)"if (existingValue == nul\u2026      }\n                }");
                    map2.put(string2, var1_14);
                    continue;
                }
                throw new IllegalArgumentException();
            }
        }
        builder.putAll(map2);
        Data data = builder.build();
        Intrinsics.checkNotNullExpressionValue((Object)data, (String)"output.build()");
        return data;
    }
}

