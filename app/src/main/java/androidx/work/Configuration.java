/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work;

import androidx.core.util.Consumer;
import androidx.work.Clock;
import androidx.work.ConfigurationKt;
import androidx.work.InputMergerFactory;
import androidx.work.NoOpInputMergerFactory;
import androidx.work.RunnableScheduler;
import androidx.work.SystemClock;
import androidx.work.WorkerFactory;
import androidx.work.impl.DefaultRunnableScheduler;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 62\u00020\u0001:\u0003567B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u001e\u001a\u00020\u001f8G\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010 R\u0011\u0010!\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\fR\u0013\u0010#\u001a\u00020\n8G\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\fR\u0011\u0010%\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\fR\u0013\u0010'\u001a\u00020\n8G\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\fR\u0011\u0010)\u001a\u00020*\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0019\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0019R\u0011\u0010/\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0014R\u0011\u00101\u001a\u000202\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u00104\u00a8\u00068"}, d2={"Landroidx/work/Configuration;", "", "builder", "Landroidx/work/Configuration$Builder;", "(Landroidx/work/Configuration$Builder;)V", "clock", "Landroidx/work/Clock;", "getClock", "()Landroidx/work/Clock;", "contentUriTriggerWorkersLimit", "", "getContentUriTriggerWorkersLimit", "()I", "defaultProcessName", "", "getDefaultProcessName", "()Ljava/lang/String;", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "initializationExceptionHandler", "Landroidx/core/util/Consumer;", "", "getInitializationExceptionHandler", "()Landroidx/core/util/Consumer;", "inputMergerFactory", "Landroidx/work/InputMergerFactory;", "getInputMergerFactory", "()Landroidx/work/InputMergerFactory;", "isUsingDefaultTaskExecutor", "", "()Z", "maxJobSchedulerId", "getMaxJobSchedulerId", "maxSchedulerLimit", "getMaxSchedulerLimit", "minJobSchedulerId", "getMinJobSchedulerId", "minimumLoggingLevel", "getMinimumLoggingLevel", "runnableScheduler", "Landroidx/work/RunnableScheduler;", "getRunnableScheduler", "()Landroidx/work/RunnableScheduler;", "schedulingExceptionHandler", "getSchedulingExceptionHandler", "taskExecutor", "getTaskExecutor", "workerFactory", "Landroidx/work/WorkerFactory;", "getWorkerFactory", "()Landroidx/work/WorkerFactory;", "Builder", "Companion", "Provider", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public final class Configuration {
    public static final Companion Companion = new Companion(null);
    public static final int MIN_SCHEDULER_LIMIT = 20;
    private final Clock clock;
    private final int contentUriTriggerWorkersLimit;
    private final String defaultProcessName;
    private final Executor executor;
    private final Consumer<Throwable> initializationExceptionHandler;
    private final InputMergerFactory inputMergerFactory;
    private final boolean isUsingDefaultTaskExecutor;
    private final int maxJobSchedulerId;
    private final int maxSchedulerLimit;
    private final int minJobSchedulerId;
    private final int minimumLoggingLevel;
    private final RunnableScheduler runnableScheduler;
    private final Consumer<Throwable> schedulingExceptionHandler;
    private final Executor taskExecutor;
    private final WorkerFactory workerFactory;

    public Configuration(Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        Object object = builder.getExecutor$work_runtime_release();
        boolean bl = false;
        Object object2 = object;
        if (object == null) {
            object2 = ConfigurationKt.access$createDefaultExecutor(false);
        }
        this.executor = object2;
        if (builder.getTaskExecutor$work_runtime_release() == null) {
            bl = true;
        }
        this.isUsingDefaultTaskExecutor = bl;
        object2 = object = builder.getTaskExecutor$work_runtime_release();
        if (object == null) {
            object2 = ConfigurationKt.access$createDefaultExecutor(true);
        }
        this.taskExecutor = object2;
        object2 = object = builder.getClock$work_runtime_release();
        if (object == null) {
            object2 = new SystemClock();
        }
        this.clock = object2;
        object2 = object = builder.getWorkerFactory$work_runtime_release();
        if (object == null) {
            object2 = WorkerFactory.getDefaultWorkerFactory();
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"getDefaultWorkerFactory()");
        }
        this.workerFactory = object2;
        object2 = object = builder.getInputMergerFactory$work_runtime_release();
        if (object == null) {
            object2 = NoOpInputMergerFactory.INSTANCE;
        }
        this.inputMergerFactory = object2;
        object2 = object = builder.getRunnableScheduler$work_runtime_release();
        if (object == null) {
            object2 = new DefaultRunnableScheduler();
        }
        this.runnableScheduler = object2;
        this.minimumLoggingLevel = builder.getLoggingLevel$work_runtime_release();
        this.minJobSchedulerId = builder.getMinJobSchedulerId$work_runtime_release();
        this.maxJobSchedulerId = builder.getMaxJobSchedulerId$work_runtime_release();
        this.maxSchedulerLimit = builder.getMaxSchedulerLimit$work_runtime_release();
        this.initializationExceptionHandler = builder.getInitializationExceptionHandler$work_runtime_release();
        this.schedulingExceptionHandler = builder.getSchedulingExceptionHandler$work_runtime_release();
        this.defaultProcessName = builder.getDefaultProcessName$work_runtime_release();
        this.contentUriTriggerWorkersLimit = builder.getContentUriTriggerWorkersLimit$work_runtime_release();
    }

    public final Clock getClock() {
        return this.clock;
    }

    public final int getContentUriTriggerWorkersLimit() {
        return this.contentUriTriggerWorkersLimit;
    }

    public final String getDefaultProcessName() {
        return this.defaultProcessName;
    }

    public final Executor getExecutor() {
        return this.executor;
    }

    public final Consumer<Throwable> getInitializationExceptionHandler() {
        return this.initializationExceptionHandler;
    }

    public final InputMergerFactory getInputMergerFactory() {
        return this.inputMergerFactory;
    }

    public final int getMaxJobSchedulerId() {
        return this.maxJobSchedulerId;
    }

    public final int getMaxSchedulerLimit() {
        return this.maxSchedulerLimit;
    }

    public final int getMinJobSchedulerId() {
        return this.minJobSchedulerId;
    }

    public final int getMinimumLoggingLevel() {
        return this.minimumLoggingLevel;
    }

    public final RunnableScheduler getRunnableScheduler() {
        return this.runnableScheduler;
    }

    public final Consumer<Throwable> getSchedulingExceptionHandler() {
        return this.schedulingExceptionHandler;
    }

    public final Executor getTaskExecutor() {
        return this.taskExecutor;
    }

    public final WorkerFactory getWorkerFactory() {
        return this.workerFactory;
    }

    public final boolean isUsingDefaultTaskExecutor() {
        return this.isUsingDefaultTaskExecutor;
    }

    @Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u000f\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010I\u001a\u00020\u0004J\u000e\u0010J\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010K\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010L\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u0013J\u000e\u0010N\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019J\u0014\u0010O\u001a\u00020\u00002\f\u0010P\u001a\b\u0012\u0004\u0012\u00020 0\u001fJ\u000e\u0010Q\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&J\u0016\u0010R\u001a\u00020\u00002\u0006\u00104\u001a\u00020\r2\u0006\u0010.\u001a\u00020\rJ\u000e\u0010S\u001a\u00020\u00002\u0006\u00101\u001a\u00020\rJ\u000e\u0010T\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\rJ\u000e\u0010U\u001a\u00020\u00002\u0006\u00107\u001a\u000208J\u0014\u0010V\u001a\u00020\u00002\f\u0010=\u001a\b\u0012\u0004\u0012\u00020 0\u001fJ\u000e\u0010W\u001a\u00020\u00002\u0006\u0010@\u001a\u00020\u0019J\u000e\u0010X\u001a\u00020\u00002\u0006\u0010C\u001a\u00020DR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\rX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u000f\"\u0004\b-\u0010\u0011R\u001a\u0010.\u001a\u00020\rX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u000f\"\u0004\b0\u0010\u0011R\u001a\u00101\u001a\u00020\rX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u000f\"\u0004\b3\u0010\u0011R\u001a\u00104\u001a\u00020\rX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u000f\"\u0004\b6\u0010\u0011R\u001c\u00107\u001a\u0004\u0018\u000108X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010=\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\"\"\u0004\b?\u0010$R\u001c\u0010@\u001a\u0004\u0018\u00010\u0019X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u001b\"\u0004\bB\u0010\u001dR\u001c\u0010C\u001a\u0004\u0018\u00010DX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H\u00a8\u0006Y"}, d2={"Landroidx/work/Configuration$Builder;", "", "()V", "configuration", "Landroidx/work/Configuration;", "(Landroidx/work/Configuration;)V", "clock", "Landroidx/work/Clock;", "getClock$work_runtime_release", "()Landroidx/work/Clock;", "setClock$work_runtime_release", "(Landroidx/work/Clock;)V", "contentUriTriggerWorkersLimit", "", "getContentUriTriggerWorkersLimit$work_runtime_release", "()I", "setContentUriTriggerWorkersLimit$work_runtime_release", "(I)V", "defaultProcessName", "", "getDefaultProcessName$work_runtime_release", "()Ljava/lang/String;", "setDefaultProcessName$work_runtime_release", "(Ljava/lang/String;)V", "executor", "Ljava/util/concurrent/Executor;", "getExecutor$work_runtime_release", "()Ljava/util/concurrent/Executor;", "setExecutor$work_runtime_release", "(Ljava/util/concurrent/Executor;)V", "initializationExceptionHandler", "Landroidx/core/util/Consumer;", "", "getInitializationExceptionHandler$work_runtime_release", "()Landroidx/core/util/Consumer;", "setInitializationExceptionHandler$work_runtime_release", "(Landroidx/core/util/Consumer;)V", "inputMergerFactory", "Landroidx/work/InputMergerFactory;", "getInputMergerFactory$work_runtime_release", "()Landroidx/work/InputMergerFactory;", "setInputMergerFactory$work_runtime_release", "(Landroidx/work/InputMergerFactory;)V", "loggingLevel", "getLoggingLevel$work_runtime_release", "setLoggingLevel$work_runtime_release", "maxJobSchedulerId", "getMaxJobSchedulerId$work_runtime_release", "setMaxJobSchedulerId$work_runtime_release", "maxSchedulerLimit", "getMaxSchedulerLimit$work_runtime_release", "setMaxSchedulerLimit$work_runtime_release", "minJobSchedulerId", "getMinJobSchedulerId$work_runtime_release", "setMinJobSchedulerId$work_runtime_release", "runnableScheduler", "Landroidx/work/RunnableScheduler;", "getRunnableScheduler$work_runtime_release", "()Landroidx/work/RunnableScheduler;", "setRunnableScheduler$work_runtime_release", "(Landroidx/work/RunnableScheduler;)V", "schedulingExceptionHandler", "getSchedulingExceptionHandler$work_runtime_release", "setSchedulingExceptionHandler$work_runtime_release", "taskExecutor", "getTaskExecutor$work_runtime_release", "setTaskExecutor$work_runtime_release", "workerFactory", "Landroidx/work/WorkerFactory;", "getWorkerFactory$work_runtime_release", "()Landroidx/work/WorkerFactory;", "setWorkerFactory$work_runtime_release", "(Landroidx/work/WorkerFactory;)V", "build", "setClock", "setContentUriTriggerWorkersLimit", "setDefaultProcessName", "processName", "setExecutor", "setInitializationExceptionHandler", "exceptionHandler", "setInputMergerFactory", "setJobSchedulerJobIdRange", "setMaxSchedulerLimit", "setMinimumLoggingLevel", "setRunnableScheduler", "setSchedulingExceptionHandler", "setTaskExecutor", "setWorkerFactory", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class Builder {
        private Clock clock;
        private int contentUriTriggerWorkersLimit;
        private String defaultProcessName;
        private Executor executor;
        private Consumer<Throwable> initializationExceptionHandler;
        private InputMergerFactory inputMergerFactory;
        private int loggingLevel;
        private int maxJobSchedulerId;
        private int maxSchedulerLimit;
        private int minJobSchedulerId;
        private RunnableScheduler runnableScheduler;
        private Consumer<Throwable> schedulingExceptionHandler;
        private Executor taskExecutor;
        private WorkerFactory workerFactory;

        public Builder() {
            this.loggingLevel = 4;
            this.maxJobSchedulerId = Integer.MAX_VALUE;
            this.maxSchedulerLimit = 20;
            this.contentUriTriggerWorkersLimit = ConfigurationKt.getDEFAULT_CONTENT_URI_TRIGGERS_WORKERS_LIMIT();
        }

        public Builder(Configuration configuration2) {
            Intrinsics.checkNotNullParameter((Object)configuration2, (String)"configuration");
            this.loggingLevel = 4;
            this.maxJobSchedulerId = Integer.MAX_VALUE;
            this.maxSchedulerLimit = 20;
            this.contentUriTriggerWorkersLimit = ConfigurationKt.getDEFAULT_CONTENT_URI_TRIGGERS_WORKERS_LIMIT();
            this.executor = configuration2.getExecutor();
            this.workerFactory = configuration2.getWorkerFactory();
            this.inputMergerFactory = configuration2.getInputMergerFactory();
            this.taskExecutor = configuration2.getTaskExecutor();
            this.clock = configuration2.getClock();
            this.loggingLevel = configuration2.getMinimumLoggingLevel();
            this.minJobSchedulerId = configuration2.getMinJobSchedulerId();
            this.maxJobSchedulerId = configuration2.getMaxJobSchedulerId();
            this.maxSchedulerLimit = configuration2.getMaxSchedulerLimit();
            this.runnableScheduler = configuration2.getRunnableScheduler();
            this.initializationExceptionHandler = configuration2.getInitializationExceptionHandler();
            this.schedulingExceptionHandler = configuration2.getSchedulingExceptionHandler();
            this.defaultProcessName = configuration2.getDefaultProcessName();
        }

        public final Configuration build() {
            return new Configuration(this);
        }

        public final Clock getClock$work_runtime_release() {
            return this.clock;
        }

        public final int getContentUriTriggerWorkersLimit$work_runtime_release() {
            return this.contentUriTriggerWorkersLimit;
        }

        public final String getDefaultProcessName$work_runtime_release() {
            return this.defaultProcessName;
        }

        public final Executor getExecutor$work_runtime_release() {
            return this.executor;
        }

        public final Consumer<Throwable> getInitializationExceptionHandler$work_runtime_release() {
            return this.initializationExceptionHandler;
        }

        public final InputMergerFactory getInputMergerFactory$work_runtime_release() {
            return this.inputMergerFactory;
        }

        public final int getLoggingLevel$work_runtime_release() {
            return this.loggingLevel;
        }

        public final int getMaxJobSchedulerId$work_runtime_release() {
            return this.maxJobSchedulerId;
        }

        public final int getMaxSchedulerLimit$work_runtime_release() {
            return this.maxSchedulerLimit;
        }

        public final int getMinJobSchedulerId$work_runtime_release() {
            return this.minJobSchedulerId;
        }

        public final RunnableScheduler getRunnableScheduler$work_runtime_release() {
            return this.runnableScheduler;
        }

        public final Consumer<Throwable> getSchedulingExceptionHandler$work_runtime_release() {
            return this.schedulingExceptionHandler;
        }

        public final Executor getTaskExecutor$work_runtime_release() {
            return this.taskExecutor;
        }

        public final WorkerFactory getWorkerFactory$work_runtime_release() {
            return this.workerFactory;
        }

        public final Builder setClock(Clock clock) {
            Intrinsics.checkNotNullParameter((Object)clock, (String)"clock");
            this.clock = clock;
            return this;
        }

        public final void setClock$work_runtime_release(Clock clock) {
            this.clock = clock;
        }

        public final Builder setContentUriTriggerWorkersLimit(int n) {
            this.contentUriTriggerWorkersLimit = Math.max(n, 0);
            return this;
        }

        public final void setContentUriTriggerWorkersLimit$work_runtime_release(int n) {
            this.contentUriTriggerWorkersLimit = n;
        }

        public final Builder setDefaultProcessName(String string2) {
            Intrinsics.checkNotNullParameter((Object)string2, (String)"processName");
            this.defaultProcessName = string2;
            return this;
        }

        public final void setDefaultProcessName$work_runtime_release(String string2) {
            this.defaultProcessName = string2;
        }

        public final Builder setExecutor(Executor executor) {
            Intrinsics.checkNotNullParameter((Object)executor, (String)"executor");
            this.executor = executor;
            return this;
        }

        public final void setExecutor$work_runtime_release(Executor executor) {
            this.executor = executor;
        }

        public final Builder setInitializationExceptionHandler(Consumer<Throwable> consumer) {
            Intrinsics.checkNotNullParameter(consumer, (String)"exceptionHandler");
            this.initializationExceptionHandler = consumer;
            return this;
        }

        public final void setInitializationExceptionHandler$work_runtime_release(Consumer<Throwable> consumer) {
            this.initializationExceptionHandler = consumer;
        }

        public final Builder setInputMergerFactory(InputMergerFactory inputMergerFactory) {
            Intrinsics.checkNotNullParameter((Object)inputMergerFactory, (String)"inputMergerFactory");
            this.inputMergerFactory = inputMergerFactory;
            return this;
        }

        public final void setInputMergerFactory$work_runtime_release(InputMergerFactory inputMergerFactory) {
            this.inputMergerFactory = inputMergerFactory;
        }

        public final Builder setJobSchedulerJobIdRange(int n, int n2) {
            boolean bl = n2 - n >= 1000;
            if (bl) {
                this.minJobSchedulerId = n;
                this.maxJobSchedulerId = n2;
                return this;
            }
            throw new IllegalArgumentException("WorkManager needs a range of at least 1000 job ids.".toString());
        }

        public final void setLoggingLevel$work_runtime_release(int n) {
            this.loggingLevel = n;
        }

        public final void setMaxJobSchedulerId$work_runtime_release(int n) {
            this.maxJobSchedulerId = n;
        }

        public final Builder setMaxSchedulerLimit(int n) {
            boolean bl = n >= 20;
            if (bl) {
                this.maxSchedulerLimit = Math.min(n, 50);
                return this;
            }
            throw new IllegalArgumentException("WorkManager needs to be able to schedule at least 20 jobs in JobScheduler.".toString());
        }

        public final void setMaxSchedulerLimit$work_runtime_release(int n) {
            this.maxSchedulerLimit = n;
        }

        public final void setMinJobSchedulerId$work_runtime_release(int n) {
            this.minJobSchedulerId = n;
        }

        public final Builder setMinimumLoggingLevel(int n) {
            this.loggingLevel = n;
            return this;
        }

        public final Builder setRunnableScheduler(RunnableScheduler runnableScheduler) {
            Intrinsics.checkNotNullParameter((Object)runnableScheduler, (String)"runnableScheduler");
            this.runnableScheduler = runnableScheduler;
            return this;
        }

        public final void setRunnableScheduler$work_runtime_release(RunnableScheduler runnableScheduler) {
            this.runnableScheduler = runnableScheduler;
        }

        public final Builder setSchedulingExceptionHandler(Consumer<Throwable> consumer) {
            Intrinsics.checkNotNullParameter(consumer, (String)"schedulingExceptionHandler");
            this.schedulingExceptionHandler = consumer;
            return this;
        }

        public final void setSchedulingExceptionHandler$work_runtime_release(Consumer<Throwable> consumer) {
            this.schedulingExceptionHandler = consumer;
        }

        public final Builder setTaskExecutor(Executor executor) {
            Intrinsics.checkNotNullParameter((Object)executor, (String)"taskExecutor");
            this.taskExecutor = executor;
            return this;
        }

        public final void setTaskExecutor$work_runtime_release(Executor executor) {
            this.taskExecutor = executor;
        }

        public final Builder setWorkerFactory(WorkerFactory workerFactory) {
            Intrinsics.checkNotNullParameter((Object)workerFactory, (String)"workerFactory");
            this.workerFactory = workerFactory;
            return this;
        }

        public final void setWorkerFactory$work_runtime_release(WorkerFactory workerFactory) {
            this.workerFactory = workerFactory;
        }
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2={"Landroidx/work/Configuration$Companion;", "", "()V", "MIN_SCHEDULER_LIMIT", "", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0006\u00c0\u0006\u0001"}, d2={"Landroidx/work/Configuration$Provider;", "", "workManagerConfiguration", "Landroidx/work/Configuration;", "getWorkManagerConfiguration", "()Landroidx/work/Configuration;", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static interface Provider {
        public Configuration getWorkManagerConfiguration();
    }
}

