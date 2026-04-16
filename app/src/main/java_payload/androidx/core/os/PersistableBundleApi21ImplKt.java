/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.PersistableBundle
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.core.os;

import android.os.PersistableBundle;
import androidx.core.os.PersistableBundleApi22ImplKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c3\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0007\u00a8\u0006\r"}, d2={"Landroidx/core/os/PersistableBundleApi21ImplKt;", "", "()V", "createPersistableBundle", "Landroid/os/PersistableBundle;", "capacity", "", "putValue", "", "persistableBundle", "key", "", "value", "core-ktx_release"}, k=1, mv={1, 8, 0}, xi=48)
final class PersistableBundleApi21ImplKt {
    public static final PersistableBundleApi21ImplKt INSTANCE = new PersistableBundleApi21ImplKt();

    private PersistableBundleApi21ImplKt() {
    }

    @JvmStatic
    public static final PersistableBundle createPersistableBundle(int n) {
        return new PersistableBundle(n);
    }

    @JvmStatic
    public static final void putValue(PersistableBundle object, String string2, Object object2) {
        block13: {
            Class<?> clazz;
            block14: {
                block3: {
                    block12: {
                        block11: {
                            block10: {
                                block9: {
                                    block8: {
                                        block7: {
                                            block6: {
                                                block5: {
                                                    block4: {
                                                        block2: {
                                                            if (object2 != null) break block2;
                                                            object.putString(string2, null);
                                                            break block3;
                                                        }
                                                        if (!(object2 instanceof Boolean)) break block4;
                                                        PersistableBundleApi22ImplKt.putBoolean(object, string2, (Boolean)object2);
                                                        break block3;
                                                    }
                                                    if (!(object2 instanceof Double)) break block5;
                                                    object.putDouble(string2, ((Number)object2).doubleValue());
                                                    break block3;
                                                }
                                                if (!(object2 instanceof Integer)) break block6;
                                                object.putInt(string2, ((Number)object2).intValue());
                                                break block3;
                                            }
                                            if (!(object2 instanceof Long)) break block7;
                                            object.putLong(string2, ((Number)object2).longValue());
                                            break block3;
                                        }
                                        if (!(object2 instanceof String)) break block8;
                                        object.putString(string2, (String)object2);
                                        break block3;
                                    }
                                    if (!(object2 instanceof boolean[])) break block9;
                                    PersistableBundleApi22ImplKt.putBooleanArray(object, string2, (boolean[])object2);
                                    break block3;
                                }
                                if (!(object2 instanceof double[])) break block10;
                                object.putDoubleArray(string2, (double[])object2);
                                break block3;
                            }
                            if (!(object2 instanceof int[])) break block11;
                            object.putIntArray(string2, (int[])object2);
                            break block3;
                        }
                        if (!(object2 instanceof long[])) break block12;
                        object.putLongArray(string2, (long[])object2);
                        break block3;
                    }
                    if (!(object2 instanceof Object[])) break block13;
                    clazz = object2.getClass().getComponentType();
                    Intrinsics.checkNotNull(clazz);
                    if (!String.class.isAssignableFrom(clazz)) break block14;
                    Intrinsics.checkNotNull((Object)object2, (String)"null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                    object.putStringArray(string2, (String[])object2);
                }
                return;
            }
            object = clazz.getCanonicalName();
            throw new IllegalArgumentException("Illegal value array type " + (String)object + " for key \"" + string2 + '\"');
        }
        object = object2.getClass().getCanonicalName();
        throw new IllegalArgumentException("Illegal value type " + (String)object + " for key \"" + string2 + '\"');
    }
}

