/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  kotlin.Metadata
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function6
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work.impl;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.R;
import androidx.work.impl.Processor;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkLauncher;
import androidx.work.impl.WorkLauncherImpl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.WorkManagerImplExtKt;
import androidx.work.impl.background.greedy.GreedyScheduler;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\b\b\u001a\u00df\u0001\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0097\u0001\b\u0002\u0010\u0010\u001a\u0090\u0001\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0011j\u0002`\u0016H\u0007\u00a2\u0006\u0002\b\u0017\u001a>\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a\u00ae\u0001\u0010\u0019\u001a\u0090\u0001\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0011j\u0002`\u00162\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u001a\"\u00020\u0015\u00a2\u0006\u0002\u0010\u001b*\u00a0\u0002\u0010\u001c\"\u008c\u0001\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u00112\u008c\u0001\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0011\u00a8\u0006\u001d"}, d2={"TestWorkManagerImpl", "Landroidx/work/impl/WorkManagerImpl;", "context", "Landroid/content/Context;", "configuration", "Landroidx/work/Configuration;", "workTaskExecutor", "Landroidx/work/impl/utils/taskexecutor/TaskExecutor;", "createTestWorkManager", "WorkManagerImpl", "workDatabase", "Landroidx/work/impl/WorkDatabase;", "trackers", "Landroidx/work/impl/constraints/trackers/Trackers;", "processor", "Landroidx/work/impl/Processor;", "schedulersCreator", "Lkotlin/Function6;", "Lkotlin/ParameterName;", "name", "", "Landroidx/work/impl/Scheduler;", "Landroidx/work/impl/SchedulersCreator;", "createWorkManager", "createSchedulers", "schedulers", "", "([Landroidx/work/impl/Scheduler;)Lkotlin/jvm/functions/Function6;", "SchedulersCreator", "work-runtime_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class WorkManagerImplExtKt {
    public static final /* synthetic */ List access$createSchedulers(Context context, Configuration configuration2, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor) {
        return WorkManagerImplExtKt.createSchedulers(context, configuration2, taskExecutor, workDatabase, trackers, processor);
    }

    private static final List<Scheduler> createSchedulers(Context object, Configuration configuration2, TaskExecutor taskExecutor, WorkDatabase object2, Trackers trackers, Processor processor) {
        object2 = Schedulers.createBestAvailableBackgroundScheduler(object, (WorkDatabase)object2, configuration2);
        Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"createBestAvailableBackg\u2026kDatabase, configuration)");
        WorkLauncher workLauncher = new WorkLauncherImpl(processor, taskExecutor);
        object = new GreedyScheduler((Context)object, configuration2, trackers, processor, workLauncher, taskExecutor);
        return CollectionsKt.listOf((Object[])new Scheduler[]{object2, object});
    }

    public static final WorkManagerImpl createTestWorkManager(Context context, Configuration configuration2, TaskExecutor taskExecutor) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)configuration2, (String)"configuration");
        Intrinsics.checkNotNullParameter((Object)taskExecutor, (String)"workTaskExecutor");
        WorkDatabase.Companion companion = WorkDatabase.Companion;
        SerialExecutor serialExecutor = taskExecutor.getSerialTaskExecutor();
        Intrinsics.checkNotNullExpressionValue((Object)serialExecutor, (String)"workTaskExecutor.serialTaskExecutor");
        return WorkManagerImplExtKt.createWorkManager$default(context, configuration2, taskExecutor, companion.create(context, serialExecutor, configuration2.getClock(), true), null, null, null, 112, null);
    }

    public static final WorkManagerImpl createWorkManager(Context context, Configuration configuration2) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)configuration2, (String)"configuration");
        return WorkManagerImplExtKt.createWorkManager$default(context, configuration2, null, null, null, null, null, 124, null);
    }

    public static final WorkManagerImpl createWorkManager(Context context, Configuration configuration2, TaskExecutor taskExecutor) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)configuration2, (String)"configuration");
        Intrinsics.checkNotNullParameter((Object)taskExecutor, (String)"workTaskExecutor");
        return WorkManagerImplExtKt.createWorkManager$default(context, configuration2, taskExecutor, null, null, null, null, 120, null);
    }

    public static final WorkManagerImpl createWorkManager(Context context, Configuration configuration2, TaskExecutor taskExecutor, WorkDatabase workDatabase) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)configuration2, (String)"configuration");
        Intrinsics.checkNotNullParameter((Object)taskExecutor, (String)"workTaskExecutor");
        Intrinsics.checkNotNullParameter((Object)workDatabase, (String)"workDatabase");
        return WorkManagerImplExtKt.createWorkManager$default(context, configuration2, taskExecutor, workDatabase, null, null, null, 112, null);
    }

    public static final WorkManagerImpl createWorkManager(Context context, Configuration configuration2, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)configuration2, (String)"configuration");
        Intrinsics.checkNotNullParameter((Object)taskExecutor, (String)"workTaskExecutor");
        Intrinsics.checkNotNullParameter((Object)workDatabase, (String)"workDatabase");
        Intrinsics.checkNotNullParameter((Object)trackers, (String)"trackers");
        return WorkManagerImplExtKt.createWorkManager$default(context, configuration2, taskExecutor, workDatabase, trackers, null, null, 96, null);
    }

    public static final WorkManagerImpl createWorkManager(Context context, Configuration configuration2, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)configuration2, (String)"configuration");
        Intrinsics.checkNotNullParameter((Object)taskExecutor, (String)"workTaskExecutor");
        Intrinsics.checkNotNullParameter((Object)workDatabase, (String)"workDatabase");
        Intrinsics.checkNotNullParameter((Object)trackers, (String)"trackers");
        Intrinsics.checkNotNullParameter((Object)processor, (String)"processor");
        return WorkManagerImplExtKt.createWorkManager$default(context, configuration2, taskExecutor, workDatabase, trackers, processor, null, 64, null);
    }

    public static final WorkManagerImpl createWorkManager(Context context, Configuration configuration2, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor, Function6<? super Context, ? super Configuration, ? super TaskExecutor, ? super WorkDatabase, ? super Trackers, ? super Processor, ? extends List<? extends Scheduler>> object) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)configuration2, (String)"configuration");
        Intrinsics.checkNotNullParameter((Object)taskExecutor, (String)"workTaskExecutor");
        Intrinsics.checkNotNullParameter((Object)workDatabase, (String)"workDatabase");
        Intrinsics.checkNotNullParameter((Object)trackers, (String)"trackers");
        Intrinsics.checkNotNullParameter((Object)processor, (String)"processor");
        Intrinsics.checkNotNullParameter(object, (String)"schedulersCreator");
        object = (List)object.invoke((Object)context, (Object)configuration2, (Object)taskExecutor, (Object)workDatabase, (Object)trackers, (Object)processor);
        context = context.getApplicationContext();
        return new WorkManagerImpl(context, configuration2, taskExecutor, workDatabase, (List<Scheduler>)object, processor, trackers);
    }

    public static /* synthetic */ WorkManagerImpl createWorkManager$default(Context context, Configuration configuration2, TaskExecutor taskExecutor, WorkDatabase object, Trackers trackers, Processor processor, Function6 function6, int n, Object object2) {
        block4: {
            if ((n & 4) != 0) {
                taskExecutor = new WorkManagerTaskExecutor(configuration2.getTaskExecutor());
            }
            if ((n & 8) != 0) {
                object2 = WorkDatabase.Companion;
                Context context2 = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue((Object)context2, (String)"context.applicationContext");
                object = taskExecutor.getSerialTaskExecutor();
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"workTaskExecutor.serialTaskExecutor");
                object = ((WorkDatabase.Companion)object2).create(context2, (Executor)object, configuration2.getClock(), context.getResources().getBoolean(R.bool.workmanager_test_configuration));
            }
            if ((n & 0x10) != 0) {
                trackers = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue((Object)trackers, (String)"context.applicationContext");
                trackers = new Trackers((Context)trackers, taskExecutor, null, null, null, null, 60, null);
            }
            if ((n & 0x20) != 0) {
                processor = new Processor(context.getApplicationContext(), configuration2, taskExecutor, (WorkDatabase)object);
            }
            if ((n & 0x40) == 0) break block4;
            function6 = WorkManagerImpl.1.INSTANCE;
        }
        return WorkManagerImplExtKt.createWorkManager(context, configuration2, taskExecutor, (WorkDatabase)object, trackers, processor, (Function6<? super Context, ? super Configuration, ? super TaskExecutor, ? super WorkDatabase, ? super Trackers, ? super Processor, ? extends List<? extends Scheduler>>)function6);
    }

    public static final Function6<Context, Configuration, TaskExecutor, WorkDatabase, Trackers, Processor, List<Scheduler>> schedulers(Scheduler ... schedulerArray) {
        Intrinsics.checkNotNullParameter((Object)schedulerArray, (String)"schedulers");
        return (Function6)new Function6<Context, Configuration, TaskExecutor, WorkDatabase, Trackers, Processor, List<? extends Scheduler>>(schedulerArray){
            final Scheduler[] $schedulers;
            {
                this.$schedulers = schedulerArray;
                super(6);
            }

            public final List<Scheduler> invoke(Context context, Configuration configuration2, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor) {
                Intrinsics.checkNotNullParameter((Object)context, (String)"<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter((Object)configuration2, (String)"<anonymous parameter 1>");
                Intrinsics.checkNotNullParameter((Object)taskExecutor, (String)"<anonymous parameter 2>");
                Intrinsics.checkNotNullParameter((Object)workDatabase, (String)"<anonymous parameter 3>");
                Intrinsics.checkNotNullParameter((Object)trackers, (String)"<anonymous parameter 4>");
                Intrinsics.checkNotNullParameter((Object)processor, (String)"<anonymous parameter 5>");
                return ArraysKt.toList((Object[])this.$schedulers);
            }
        };
    }
}

