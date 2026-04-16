/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work.impl.utils;

import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.impl.model.WorkTypeConverters;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\t\u00a8\u0006\n"}, d2={"bindings", "", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "count", "", "toRawQuery", "Landroidx/sqlite/db/SupportSQLiteQuery;", "Landroidx/work/WorkQuery;", "work-runtime_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class RawQueries {
    private static final void bindings(StringBuilder stringBuilder, int n) {
        if (n <= 0) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<String>(n);
        for (int i = 0; i < n; ++i) {
            arrayList.add("?");
        }
        stringBuilder.append(CollectionsKt.joinToString$default((Iterable)arrayList, (CharSequence)",", null, null, (int)0, null, null, (int)62, null));
    }

    public static final SupportSQLiteQuery toRawQuery(WorkQuery list) {
        Object object;
        Intrinsics.checkNotNullParameter((Object)list, (String)"<this>");
        List list2 = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder("SELECT * FROM workspec");
        Object object2 = " WHERE";
        Object object3 = ((WorkQuery)((Object)list)).getStates();
        Intrinsics.checkNotNullExpressionValue(object3, (String)"states");
        if (((Collection)object3).isEmpty() ^ true) {
            object2 = ((WorkQuery)((Object)list)).getStates();
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"states");
            object3 = (Iterable)object2;
            object2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object3, (int)10));
            object3 = object3.iterator();
            while (object3.hasNext()) {
                object = (WorkInfo.State)((Object)object3.next());
                Intrinsics.checkNotNull(object);
                object2.add(WorkTypeConverters.stateToInt(object));
            }
            object2 = (List)object2;
            stringBuilder.append(" WHERE" + " state IN (");
            RawQueries.bindings(stringBuilder, object2.size());
            stringBuilder.append(")");
            list2.addAll((Collection)object2);
            object2 = " AND";
        }
        object = ((WorkQuery)((Object)list)).getIds();
        Intrinsics.checkNotNullExpressionValue(object, (String)"ids");
        object3 = object2;
        if (((Collection)object).isEmpty() ^ true) {
            object3 = ((WorkQuery)((Object)list)).getIds();
            Intrinsics.checkNotNullExpressionValue(object3, (String)"ids");
            object = (Iterable)object3;
            object3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(object, (int)10));
            object = object.iterator();
            while (object.hasNext()) {
                object3.add((String)((UUID)object.next()).toString());
            }
            stringBuilder.append((String)object2 + " id IN (");
            RawQueries.bindings(stringBuilder, ((WorkQuery)((Object)list)).getIds().size());
            stringBuilder.append(")");
            list2.addAll((Collection)object3);
            object3 = " AND";
        }
        object = ((WorkQuery)((Object)list)).getTags();
        Intrinsics.checkNotNullExpressionValue(object, (String)"tags");
        object2 = object3;
        if (((Collection)object).isEmpty() ^ true) {
            stringBuilder.append(object3 + " id IN (SELECT work_spec_id FROM worktag WHERE tag IN (");
            RawQueries.bindings(stringBuilder, ((WorkQuery)((Object)list)).getTags().size());
            stringBuilder.append("))");
            object2 = ((WorkQuery)((Object)list)).getTags();
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"tags");
            list2.addAll((Collection)object2);
            object2 = " AND";
        }
        object3 = ((WorkQuery)((Object)list)).getUniqueWorkNames();
        Intrinsics.checkNotNullExpressionValue(object3, (String)"uniqueWorkNames");
        if (((Collection)object3).isEmpty() ^ true) {
            stringBuilder.append((String)object2 + " id IN (SELECT work_spec_id FROM workname WHERE name IN (");
            RawQueries.bindings(stringBuilder, ((WorkQuery)((Object)list)).getUniqueWorkNames().size());
            stringBuilder.append("))");
            list = ((WorkQuery)((Object)list)).getUniqueWorkNames();
            Intrinsics.checkNotNullExpressionValue(list, (String)"uniqueWorkNames");
            list2.addAll((Collection)list);
        }
        stringBuilder.append(";");
        list = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"builder.toString()");
        return new SimpleSQLiteQuery((String)((Object)list), ((Collection)list2).toArray(new Object[0]));
    }
}

