/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 */
package androidx.room.util;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000*\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u001a\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b\u001a\u0018\u0010\f\u001a\u0004\u0018\u00010\u00022\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000e\u001a\u0006\u0010\u000f\u001a\u00020\t\u001a\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0002\" \u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0005\u0012\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0011"}, d2={"EMPTY_STRING_ARRAY", "", "", "getEMPTY_STRING_ARRAY$annotations", "()V", "[Ljava/lang/String;", "appendPlaceholders", "", "builder", "Ljava/lang/StringBuilder;", "count", "", "joinIntoString", "input", "", "newStringBuilder", "splitToIntList", "room-runtime_release"}, k=2, mv={1, 7, 1}, xi=48)
public final class StringUtil {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];

    public static final void appendPlaceholders(StringBuilder stringBuilder, int n) {
        Intrinsics.checkNotNullParameter((Object)stringBuilder, (String)"builder");
        for (int i = 0; i < n; ++i) {
            stringBuilder.append("?");
            if (i >= n - 1) continue;
            stringBuilder.append(",");
        }
    }

    public static /* synthetic */ void getEMPTY_STRING_ARRAY$annotations() {
    }

    public static final String joinIntoString(List<Integer> object) {
        object = object != null ? CollectionsKt.joinToString$default((Iterable)((Iterable)object), (CharSequence)",", null, null, (int)0, null, null, (int)62, null) : null;
        return object;
    }

    public static final StringBuilder newStringBuilder() {
        return new StringBuilder();
    }

    public static final List<Integer> splitToIntList(String object) {
        if (object != null && (object = StringsKt.split$default((CharSequence)((CharSequence)object), (char[])new char[]{','}, (boolean)false, (int)0, (int)6, null)) != null) {
            object = (Iterable)object;
            Collection collection = new ArrayList();
            Iterator iterator2 = object.iterator();
            while (iterator2.hasNext()) {
                object = (String)iterator2.next();
                try {
                    object = Integer.parseInt((String)object);
                }
                catch (NumberFormatException numberFormatException) {
                    Log.e((String)"ROOM", (String)"Malformed integer list", (Throwable)numberFormatException);
                    object = null;
                    object = null;
                }
                if (object == null) continue;
                collection.add(object);
            }
            object = (List)collection;
        } else {
            object = null;
        }
        return object;
    }
}

