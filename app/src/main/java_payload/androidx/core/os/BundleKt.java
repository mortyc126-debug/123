/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcelable
 *  android.util.Size
 *  android.util.SizeF
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.core.os;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import androidx.core.os.BundleApi21ImplKt;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a;\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2={"bundleOf", "Landroid/os/Bundle;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Landroid/os/Bundle;", "core-ktx_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class BundleKt {
    public static final Bundle bundleOf() {
        return new Bundle(0);
    }

    public static final Bundle bundleOf(Pair<String, ? extends Object> ... object) {
        Bundle bundle = new Bundle(((Pair<String, ? extends Object>[])object).length);
        int n = ((Pair<String, ? extends Object>[])object).length;
        for (int i = 0; i < n; ++i) {
            Object object2 = object[i];
            String string2 = (String)object2.component1();
            if ((object2 = object2.component2()) == null) {
                bundle.putString(string2, null);
                continue;
            }
            if (object2 instanceof Boolean) {
                bundle.putBoolean(string2, ((Boolean)object2).booleanValue());
                continue;
            }
            if (object2 instanceof Byte) {
                bundle.putByte(string2, ((Number)object2).byteValue());
                continue;
            }
            if (object2 instanceof Character) {
                bundle.putChar(string2, ((Character)object2).charValue());
                continue;
            }
            if (object2 instanceof Double) {
                bundle.putDouble(string2, ((Number)object2).doubleValue());
                continue;
            }
            if (object2 instanceof Float) {
                bundle.putFloat(string2, ((Number)object2).floatValue());
                continue;
            }
            if (object2 instanceof Integer) {
                bundle.putInt(string2, ((Number)object2).intValue());
                continue;
            }
            if (object2 instanceof Long) {
                bundle.putLong(string2, ((Number)object2).longValue());
                continue;
            }
            if (object2 instanceof Short) {
                bundle.putShort(string2, ((Number)object2).shortValue());
                continue;
            }
            if (object2 instanceof Bundle) {
                bundle.putBundle(string2, (Bundle)object2);
                continue;
            }
            if (object2 instanceof CharSequence) {
                bundle.putCharSequence(string2, (CharSequence)object2);
                continue;
            }
            if (object2 instanceof Parcelable) {
                bundle.putParcelable(string2, (Parcelable)object2);
                continue;
            }
            if (object2 instanceof boolean[]) {
                bundle.putBooleanArray(string2, (boolean[])object2);
                continue;
            }
            if (object2 instanceof byte[]) {
                bundle.putByteArray(string2, (byte[])object2);
                continue;
            }
            if (object2 instanceof char[]) {
                bundle.putCharArray(string2, (char[])object2);
                continue;
            }
            if (object2 instanceof double[]) {
                bundle.putDoubleArray(string2, (double[])object2);
                continue;
            }
            if (object2 instanceof float[]) {
                bundle.putFloatArray(string2, (float[])object2);
                continue;
            }
            if (object2 instanceof int[]) {
                bundle.putIntArray(string2, (int[])object2);
                continue;
            }
            if (object2 instanceof long[]) {
                bundle.putLongArray(string2, (long[])object2);
                continue;
            }
            if (object2 instanceof short[]) {
                bundle.putShortArray(string2, (short[])object2);
                continue;
            }
            if (object2 instanceof Object[]) {
                Class<?> clazz = object2.getClass().getComponentType();
                Intrinsics.checkNotNull(clazz);
                if (Parcelable.class.isAssignableFrom(clazz)) {
                    Intrinsics.checkNotNull((Object)object2, (String)"null cannot be cast to non-null type kotlin.Array<android.os.Parcelable>");
                    bundle.putParcelableArray(string2, (Parcelable[])object2);
                    continue;
                }
                if (String.class.isAssignableFrom(clazz)) {
                    Intrinsics.checkNotNull((Object)object2, (String)"null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                    bundle.putStringArray(string2, (String[])object2);
                    continue;
                }
                if (CharSequence.class.isAssignableFrom(clazz)) {
                    Intrinsics.checkNotNull((Object)object2, (String)"null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence>");
                    bundle.putCharSequenceArray(string2, (CharSequence[])object2);
                    continue;
                }
                if (Serializable.class.isAssignableFrom(clazz)) {
                    bundle.putSerializable(string2, (Serializable)object2);
                    continue;
                }
                object = clazz.getCanonicalName();
                throw new IllegalArgumentException("Illegal value array type " + object + " for key \"" + string2 + '\"');
            }
            if (object2 instanceof Serializable) {
                bundle.putSerializable(string2, (Serializable)object2);
                continue;
            }
            if (object2 instanceof IBinder) {
                bundle.putBinder(string2, (IBinder)object2);
                continue;
            }
            if (object2 instanceof Size) {
                BundleApi21ImplKt.putSize(bundle, string2, (Size)object2);
                continue;
            }
            if (object2 instanceof SizeF) {
                BundleApi21ImplKt.putSizeF(bundle, string2, (SizeF)object2);
                continue;
            }
            object = object2.getClass().getCanonicalName();
            throw new IllegalArgumentException("Illegal value type " + object + " for key \"" + string2 + '\"');
        }
        return bundle;
    }
}

