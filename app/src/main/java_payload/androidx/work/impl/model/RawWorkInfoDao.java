/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package androidx.work.impl.model;

import androidx.lifecycle.LiveData;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.impl.model.WorkSpec;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'J\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\b2\u0006\u0010\u0005\u001a\u00020\u0006H'J\u001c\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\n2\u0006\u0010\u0005\u001a\u00020\u0006H'\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u000b\u00c0\u0006\u0001"}, d2={"Landroidx/work/impl/model/RawWorkInfoDao;", "", "getWorkInfoPojos", "", "Landroidx/work/impl/model/WorkSpec$WorkInfoPojo;", "query", "Landroidx/sqlite/db/SupportSQLiteQuery;", "getWorkInfoPojosFlow", "Lkotlinx/coroutines/flow/Flow;", "getWorkInfoPojosLiveData", "Landroidx/lifecycle/LiveData;", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public interface RawWorkInfoDao {
    public List<WorkSpec.WorkInfoPojo> getWorkInfoPojos(SupportSQLiteQuery var1);

    public Flow<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosFlow(SupportSQLiteQuery var1);

    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosLiveData(SupportSQLiteQuery var1);
}

