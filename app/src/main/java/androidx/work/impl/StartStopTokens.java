/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work.impl;

import androidx.work.impl.StartStopToken;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\rJ\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Landroidx/work/impl/StartStopTokens;", "", "()V", "lock", "runs", "", "Landroidx/work/impl/model/WorkGenerationalId;", "Landroidx/work/impl/StartStopToken;", "contains", "", "id", "remove", "spec", "Landroidx/work/impl/model/WorkSpec;", "", "workSpecId", "", "tokenFor", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public final class StartStopTokens {
    private final Object lock = new Object();
    private final Map<WorkGenerationalId, StartStopToken> runs = new LinkedHashMap();

    public final boolean contains(WorkGenerationalId workGenerationalId) {
        Intrinsics.checkNotNullParameter((Object)workGenerationalId, (String)"id");
        Object object = this.lock;
        synchronized (object) {
            boolean bl = this.runs.containsKey(workGenerationalId);
            return bl;
        }
    }

    public final StartStopToken remove(WorkGenerationalId object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"id");
        Object object2 = this.lock;
        synchronized (object2) {
            object = this.runs.remove(object);
            return object;
        }
    }

    public final StartStopToken remove(WorkSpec workSpec) {
        Intrinsics.checkNotNullParameter((Object)workSpec, (String)"spec");
        return this.remove(WorkSpecKt.generationalId(workSpec));
    }

    public final List<StartStopToken> remove(String object52) {
        Intrinsics.checkNotNullParameter((Object)object52, (String)"workSpecId");
        Object object2 = this.lock;
        synchronized (object2) {
            Object object3 = this.runs;
            Object object4 = new LinkedHashMap();
            for (Map.Entry entry : object3.entrySet()) {
                if (!Intrinsics.areEqual((Object)((WorkGenerationalId)entry.getKey()).getWorkSpecId(), (Object)object52)) continue;
                ((HashMap)object4).put(entry.getKey(), entry.getValue());
            }
            object3 = (Map)object4;
            for (Object object52 : (Iterable)object3.keySet()) {
                this.runs.remove(object52);
            }
            object52 = CollectionsKt.toList((Iterable)object3.values());
            return object52;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final StartStopToken tokenFor(WorkGenerationalId object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"id");
        Object object2 = this.lock;
        synchronized (object2) {
            Map<WorkGenerationalId, StartStopToken> map2 = this.runs;
            StartStopToken startStopToken = map2.get(object);
            if (startStopToken != null) return startStopToken;
            startStopToken = new StartStopToken((WorkGenerationalId)object);
            map2.put((WorkGenerationalId)object, startStopToken);
            return startStopToken;
        }
    }

    public final StartStopToken tokenFor(WorkSpec workSpec) {
        Intrinsics.checkNotNullParameter((Object)workSpec, (String)"spec");
        return this.tokenFor(WorkSpecKt.generationalId(workSpec));
    }
}

