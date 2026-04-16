/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  kotlin.Metadata
 *  kotlin.Pair
 */
package androidx.core.content;

import android.content.ContentValues;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1={"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2={"contentValuesOf", "Landroid/content/ContentValues;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Landroid/content/ContentValues;", "core-ktx_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class ContentValuesKt {
    public static final ContentValues contentValuesOf(Pair<String, ? extends Object> ... object) {
        ContentValues contentValues = new ContentValues(((Pair<String, ? extends Object>[])object).length);
        int n = ((Pair<String, ? extends Object>[])object).length;
        for (int i = 0; i < n; ++i) {
            Object object2 = object[i];
            String string2 = (String)object2.component1();
            if ((object2 = object2.component2()) == null) {
                contentValues.putNull(string2);
                continue;
            }
            if (object2 instanceof String) {
                contentValues.put(string2, (String)object2);
                continue;
            }
            if (object2 instanceof Integer) {
                contentValues.put(string2, (Integer)object2);
                continue;
            }
            if (object2 instanceof Long) {
                contentValues.put(string2, (Long)object2);
                continue;
            }
            if (object2 instanceof Boolean) {
                contentValues.put(string2, (Boolean)object2);
                continue;
            }
            if (object2 instanceof Float) {
                contentValues.put(string2, (Float)object2);
                continue;
            }
            if (object2 instanceof Double) {
                contentValues.put(string2, (Double)object2);
                continue;
            }
            if (object2 instanceof byte[]) {
                contentValues.put(string2, (byte[])object2);
                continue;
            }
            if (object2 instanceof Byte) {
                contentValues.put(string2, (Byte)object2);
                continue;
            }
            if (object2 instanceof Short) {
                contentValues.put(string2, (Short)object2);
                continue;
            }
            object = object2.getClass().getCanonicalName();
            throw new IllegalArgumentException("Illegal value type " + object + " for key \"" + string2 + '\"');
        }
        return contentValues;
    }
}

