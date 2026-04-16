/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.room;

import androidx.room.RoomDatabase;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

@Metadata(d1={"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\f\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0007\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0006"}, d2={"transactionDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "Landroidx/room/RoomDatabase;", "getTransactionDispatcher", "(Landroidx/room/RoomDatabase;)Lkotlinx/coroutines/CoroutineDispatcher;", "getQueryDispatcher", "room-ktx_release"}, k=2, mv={1, 7, 1}, xi=48)
public final class CoroutinesRoomKt {
    public static final CoroutineDispatcher getQueryDispatcher(RoomDatabase object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        Map<String, Object> map2 = ((RoomDatabase)object).getBackingFieldMap();
        Object object2 = map2.get("QueryDispatcher");
        if (object2 == null) {
            object = ExecutorsKt.from(((RoomDatabase)object).getQueryExecutor());
            map2.put("QueryDispatcher", object);
        } else {
            object = object2;
        }
        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (CoroutineDispatcher)((Object)object);
    }

    public static final CoroutineDispatcher getTransactionDispatcher(RoomDatabase object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        Map<String, Object> map2 = ((RoomDatabase)object).getBackingFieldMap();
        Object object2 = map2.get("TransactionDispatcher");
        if (object2 == null) {
            object = ExecutorsKt.from(((RoomDatabase)object).getTransactionExecutor());
            map2.put("TransactionDispatcher", object);
        } else {
            object = object2;
        }
        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (CoroutineDispatcher)((Object)object);
    }
}

