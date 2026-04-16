/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work.impl.workers;

import androidx.work.Logger;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.model.WorkTagDao;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u001a/\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0002\u00a2\u0006\u0002\u0010\t\u001a.\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"TAG", "", "workSpecRow", "workSpec", "Landroidx/work/impl/model/WorkSpec;", "name", "systemId", "", "tags", "(Landroidx/work/impl/model/WorkSpec;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Ljava/lang/String;", "workSpecRows", "workNameDao", "Landroidx/work/impl/model/WorkNameDao;", "workTagDao", "Landroidx/work/impl/model/WorkTagDao;", "systemIdInfoDao", "Landroidx/work/impl/model/SystemIdInfoDao;", "workSpecs", "", "work-runtime_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class DiagnosticsWorkerKt {
    private static final String TAG;

    static {
        String string2 = Logger.tagWithPrefix("DiagnosticsWrkr");
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"tagWithPrefix(\"DiagnosticsWrkr\")");
        TAG = string2;
    }

    public static final /* synthetic */ String access$getTAG$p() {
        return TAG;
    }

    public static final /* synthetic */ String access$workSpecRows(WorkNameDao workNameDao, WorkTagDao workTagDao, SystemIdInfoDao systemIdInfoDao, List list) {
        return DiagnosticsWorkerKt.workSpecRows(workNameDao, workTagDao, systemIdInfoDao, list);
    }

    private static final String workSpecRow(WorkSpec object, String string2, Integer n, String string3) {
        object = new StringBuilder().append('\n').append(((WorkSpec)object).id).append("\t ").append(((WorkSpec)object).workerClassName).append("\t ").append(n).append("\t ").append(((WorkSpec)object).state.name());
        object = ((StringBuilder)object).append("\t ");
        object = ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).append("\t ");
        return ((StringBuilder)object).append(string3).append('\t').toString();
    }

    private static final String workSpecRows(WorkNameDao object, WorkTagDao workTagDao, SystemIdInfoDao systemIdInfoDao, List<WorkSpec> object2) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl = false;
        Object object3 = "Job Id";
        stringBuilder.append("\n Id \t Class Name\t " + "Job Id" + "\t State\t Unique Name\t Tags\t");
        Iterator iterator2 = ((Iterable)object2).iterator();
        object2 = object3;
        while (iterator2.hasNext()) {
            WorkSpec workSpec = (WorkSpec)iterator2.next();
            object3 = systemIdInfoDao.getSystemIdInfo(WorkSpecKt.generationalId(workSpec));
            object3 = object3 != null ? Integer.valueOf(((SystemIdInfo)object3).systemId) : null;
            stringBuilder.append(DiagnosticsWorkerKt.workSpecRow(workSpec, CollectionsKt.joinToString$default((Iterable)object.getNamesForWorkSpecId(workSpec.id), (CharSequence)",", null, null, (int)0, null, null, (int)62, null), (Integer)object3, CollectionsKt.joinToString$default((Iterable)workTagDao.getTagsForWorkSpecId(workSpec.id), (CharSequence)",", null, null, (int)0, null, null, (int)62, null)));
        }
        object = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"StringBuilder().apply(builderAction).toString()");
        return object;
    }
}

