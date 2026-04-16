/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work;

import androidx.work.InputMerger;
import androidx.work.ListenableWorker;
import androidx.work.WorkRequest;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00062\u00020\u0001:\u0002\u0005\u0006B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0007"}, d2={"Landroidx/work/OneTimeWorkRequest;", "Landroidx/work/WorkRequest;", "builder", "Landroidx/work/OneTimeWorkRequest$Builder;", "(Landroidx/work/OneTimeWorkRequest$Builder;)V", "Builder", "Companion", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public final class OneTimeWorkRequest
extends WorkRequest {
    public static final Companion Companion = new Companion(null);

    public OneTimeWorkRequest(Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        super(builder.getId$work_runtime_release(), builder.getWorkSpec$work_runtime_release(), builder.getTags$work_runtime_release());
    }

    @JvmStatic
    public static final OneTimeWorkRequest from(Class<? extends ListenableWorker> clazz) {
        return Companion.from(clazz);
    }

    @JvmStatic
    public static final List<OneTimeWorkRequest> from(List<? extends Class<? extends ListenableWorker>> list) {
        return Companion.from(list);
    }

    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\r\u0010\n\u001a\u00020\u0002H\u0010\u00a2\u0006\u0002\b\u000bJ\u0016\u0010\f\u001a\u00020\u00002\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u0004R\u0014\u0010\u0007\u001a\u00020\u00008PX\u0090\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2={"Landroidx/work/OneTimeWorkRequest$Builder;", "Landroidx/work/WorkRequest$Builder;", "Landroidx/work/OneTimeWorkRequest;", "workerClass", "Ljava/lang/Class;", "Landroidx/work/ListenableWorker;", "(Ljava/lang/Class;)V", "thisObject", "getThisObject$work_runtime_release", "()Landroidx/work/OneTimeWorkRequest$Builder;", "buildInternal", "buildInternal$work_runtime_release", "setInputMerger", "inputMerger", "Landroidx/work/InputMerger;", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class Builder
    extends WorkRequest.Builder<Builder, OneTimeWorkRequest> {
        public Builder(Class<? extends ListenableWorker> clazz) {
            Intrinsics.checkNotNullParameter(clazz, (String)"workerClass");
            super(clazz);
        }

        @Override
        public OneTimeWorkRequest buildInternal$work_runtime_release() {
            boolean bl = !this.getBackoffCriteriaSet$work_runtime_release() || !this.getWorkSpec$work_runtime_release().constraints.requiresDeviceIdle();
            if (bl) {
                return new OneTimeWorkRequest(this);
            }
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job".toString());
        }

        @Override
        public Builder getThisObject$work_runtime_release() {
            return this;
        }

        public final Builder setInputMerger(Class<? extends InputMerger> object) {
            Intrinsics.checkNotNullParameter(object, (String)"inputMerger");
            WorkSpec workSpec = this.getWorkSpec$work_runtime_release();
            object = ((Class)object).getName();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"inputMerger.name");
            workSpec.inputMergerClassName = object;
            return this;
        }
    }

    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006H\u0007J$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0014\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00060\bH\u0007\u00a8\u0006\n"}, d2={"Landroidx/work/OneTimeWorkRequest$Companion;", "", "()V", "from", "Landroidx/work/OneTimeWorkRequest;", "workerClass", "Ljava/lang/Class;", "Landroidx/work/ListenableWorker;", "", "workerClasses", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final OneTimeWorkRequest from(Class<? extends ListenableWorker> clazz) {
            Intrinsics.checkNotNullParameter(clazz, (String)"workerClass");
            return (OneTimeWorkRequest)new Builder(clazz).build();
        }

        @JvmStatic
        public final List<OneTimeWorkRequest> from(List<? extends Class<? extends ListenableWorker>> collection) {
            Intrinsics.checkNotNullParameter(collection, (String)"workerClasses");
            Object object = collection;
            collection = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object, (int)10));
            object = object.iterator();
            while (object.hasNext()) {
                collection.add((Class<ListenableWorker>)((Object)((OneTimeWorkRequest)new Builder((Class)object.next()).build())));
            }
            return collection;
        }
    }
}

