/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work.impl.model;

import android.os.Build;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0004\u001c\u001d\u001e\u001fB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0004H\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0004H\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u0004H\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u0004H\u0007J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000fH\u0007J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0011H\u0007J\u0016\u0010\u0018\u001a\u00020\u000b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0013H\u0007\u00a8\u0006 "}, d2={"Landroidx/work/impl/model/WorkTypeConverters;", "", "()V", "backoffPolicyToInt", "", "backoffPolicy", "Landroidx/work/BackoffPolicy;", "byteArrayToSetOfTriggers", "", "Landroidx/work/Constraints$ContentUriTrigger;", "bytes", "", "intToBackoffPolicy", "value", "intToNetworkType", "Landroidx/work/NetworkType;", "intToOutOfQuotaPolicy", "Landroidx/work/OutOfQuotaPolicy;", "intToState", "Landroidx/work/WorkInfo$State;", "networkTypeToInt", "networkType", "outOfQuotaPolicyToInt", "policy", "setOfTriggersToByteArray", "triggers", "stateToInt", "state", "BackoffPolicyIds", "NetworkTypeIds", "OutOfPolicyIds", "StateIds", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public final class WorkTypeConverters {
    public static final WorkTypeConverters INSTANCE = new WorkTypeConverters();

    private WorkTypeConverters() {
    }

    @JvmStatic
    public static final int backoffPolicyToInt(BackoffPolicy backoffPolicy) {
        int n;
        Intrinsics.checkNotNullParameter((Object)((Object)backoffPolicy), (String)"backoffPolicy");
        switch (WhenMappings.$EnumSwitchMapping$1[backoffPolicy.ordinal()]) {
            default: {
                throw new NoWhenBranchMatchedException();
            }
            case 2: {
                n = 1;
                break;
            }
            case 1: {
                n = 0;
            }
        }
        return n;
    }

    /*
     * Exception decompiling
     */
    @JvmStatic
    public static final Set<Constraints.ContentUriTrigger> byteArrayToSetOfTriggers(byte[] var0) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 4 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    @JvmStatic
    public static final BackoffPolicy intToBackoffPolicy(int n) {
        BackoffPolicy backoffPolicy;
        switch (n) {
            default: {
                throw new IllegalArgumentException("Could not convert " + n + " to BackoffPolicy");
            }
            case 1: {
                backoffPolicy = BackoffPolicy.LINEAR;
                break;
            }
            case 0: {
                backoffPolicy = BackoffPolicy.EXPONENTIAL;
            }
        }
        return backoffPolicy;
    }

    @JvmStatic
    public static final NetworkType intToNetworkType(int n) {
        block8: {
            NetworkType networkType;
            switch (n) {
                default: {
                    if (Build.VERSION.SDK_INT >= 30 && n == 5) {
                        return NetworkType.TEMPORARILY_UNMETERED;
                    }
                    break block8;
                }
                case 4: {
                    networkType = NetworkType.METERED;
                    break;
                }
                case 3: {
                    networkType = NetworkType.NOT_ROAMING;
                    break;
                }
                case 2: {
                    networkType = NetworkType.UNMETERED;
                    break;
                }
                case 1: {
                    networkType = NetworkType.CONNECTED;
                    break;
                }
                case 0: {
                    networkType = NetworkType.NOT_REQUIRED;
                }
            }
            return networkType;
        }
        throw new IllegalArgumentException("Could not convert " + n + " to NetworkType");
    }

    @JvmStatic
    public static final OutOfQuotaPolicy intToOutOfQuotaPolicy(int n) {
        OutOfQuotaPolicy outOfQuotaPolicy;
        switch (n) {
            default: {
                throw new IllegalArgumentException("Could not convert " + n + " to OutOfQuotaPolicy");
            }
            case 1: {
                outOfQuotaPolicy = OutOfQuotaPolicy.DROP_WORK_REQUEST;
                break;
            }
            case 0: {
                outOfQuotaPolicy = OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
            }
        }
        return outOfQuotaPolicy;
    }

    @JvmStatic
    public static final WorkInfo.State intToState(int n) {
        WorkInfo.State state;
        switch (n) {
            default: {
                throw new IllegalArgumentException("Could not convert " + n + " to State");
            }
            case 5: {
                state = WorkInfo.State.CANCELLED;
                break;
            }
            case 4: {
                state = WorkInfo.State.BLOCKED;
                break;
            }
            case 3: {
                state = WorkInfo.State.FAILED;
                break;
            }
            case 2: {
                state = WorkInfo.State.SUCCEEDED;
                break;
            }
            case 1: {
                state = WorkInfo.State.RUNNING;
                break;
            }
            case 0: {
                state = WorkInfo.State.ENQUEUED;
            }
        }
        return state;
    }

    @JvmStatic
    public static final int networkTypeToInt(NetworkType networkType) {
        block8: {
            int n;
            Intrinsics.checkNotNullParameter((Object)((Object)networkType), (String)"networkType");
            switch (WhenMappings.$EnumSwitchMapping$2[networkType.ordinal()]) {
                default: {
                    if (Build.VERSION.SDK_INT >= 30 && networkType == NetworkType.TEMPORARILY_UNMETERED) {
                        n = 5;
                        break;
                    }
                    break block8;
                }
                case 5: {
                    n = 4;
                    break;
                }
                case 4: {
                    n = 3;
                    break;
                }
                case 3: {
                    n = 2;
                    break;
                }
                case 2: {
                    n = 1;
                    break;
                }
                case 1: {
                    n = 0;
                }
            }
            return n;
        }
        throw new IllegalArgumentException("Could not convert " + (Object)((Object)networkType) + " to int");
    }

    @JvmStatic
    public static final int outOfQuotaPolicyToInt(OutOfQuotaPolicy outOfQuotaPolicy) {
        int n;
        Intrinsics.checkNotNullParameter((Object)((Object)outOfQuotaPolicy), (String)"policy");
        switch (WhenMappings.$EnumSwitchMapping$3[outOfQuotaPolicy.ordinal()]) {
            default: {
                throw new NoWhenBranchMatchedException();
            }
            case 2: {
                n = 1;
                break;
            }
            case 1: {
                n = 0;
            }
        }
        return n;
    }

    /*
     * Exception decompiling
     */
    @JvmStatic
    public static final byte[] setOfTriggersToByteArray(Set<Constraints.ContentUriTrigger> var0) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    @JvmStatic
    public static final int stateToInt(WorkInfo.State state) {
        int n;
        Intrinsics.checkNotNullParameter((Object)((Object)state), (String)"state");
        switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
            default: {
                throw new NoWhenBranchMatchedException();
            }
            case 6: {
                n = 5;
                break;
            }
            case 5: {
                n = 4;
                break;
            }
            case 4: {
                n = 3;
                break;
            }
            case 3: {
                n = 2;
                break;
            }
            case 2: {
                n = 1;
                break;
            }
            case 1: {
                n = 0;
            }
        }
        return n;
    }

    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c2\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Landroidx/work/impl/model/WorkTypeConverters$BackoffPolicyIds;", "", "()V", "EXPONENTIAL", "", "LINEAR", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
    private static final class BackoffPolicyIds {
        public static final int EXPONENTIAL = 0;
        public static final BackoffPolicyIds INSTANCE = new BackoffPolicyIds();
        public static final int LINEAR = 1;

        private BackoffPolicyIds() {
        }
    }

    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c2\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Landroidx/work/impl/model/WorkTypeConverters$NetworkTypeIds;", "", "()V", "CONNECTED", "", "METERED", "NOT_REQUIRED", "NOT_ROAMING", "TEMPORARILY_UNMETERED", "UNMETERED", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
    private static final class NetworkTypeIds {
        public static final int CONNECTED = 1;
        public static final NetworkTypeIds INSTANCE = new NetworkTypeIds();
        public static final int METERED = 4;
        public static final int NOT_REQUIRED = 0;
        public static final int NOT_ROAMING = 3;
        public static final int TEMPORARILY_UNMETERED = 5;
        public static final int UNMETERED = 2;

        private NetworkTypeIds() {
        }
    }

    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c2\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Landroidx/work/impl/model/WorkTypeConverters$OutOfPolicyIds;", "", "()V", "DROP_WORK_REQUEST", "", "RUN_AS_NON_EXPEDITED_WORK_REQUEST", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
    private static final class OutOfPolicyIds {
        public static final int DROP_WORK_REQUEST = 1;
        public static final OutOfPolicyIds INSTANCE = new OutOfPolicyIds();
        public static final int RUN_AS_NON_EXPEDITED_WORK_REQUEST = 0;

        private OutOfPolicyIds() {
        }
    }

    @Metadata(d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Landroidx/work/impl/model/WorkTypeConverters$StateIds;", "", "()V", "BLOCKED", "", "CANCELLED", "COMPLETED_STATES", "", "ENQUEUED", "FAILED", "RUNNING", "SUCCEEDED", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class StateIds {
        public static final int BLOCKED = 4;
        public static final int CANCELLED = 5;
        public static final String COMPLETED_STATES = "(2, 3, 5)";
        public static final int ENQUEUED = 0;
        public static final int FAILED = 3;
        public static final StateIds INSTANCE = new StateIds();
        public static final int RUNNING = 1;
        public static final int SUCCEEDED = 2;

        private StateIds() {
        }
    }

    @Metadata(k=3, mv={1, 8, 0}, xi=48)
    public final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;
        public static final int[] $EnumSwitchMapping$1;
        public static final int[] $EnumSwitchMapping$2;
        public static final int[] $EnumSwitchMapping$3;

        static {
            int[] nArray = new int[WorkInfo.State.values().length];
            try {
                nArray[WorkInfo.State.ENQUEUED.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[WorkInfo.State.RUNNING.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[WorkInfo.State.SUCCEEDED.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[WorkInfo.State.FAILED.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[WorkInfo.State.BLOCKED.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[WorkInfo.State.CANCELLED.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
            nArray = new int[BackoffPolicy.values().length];
            try {
                nArray[BackoffPolicy.EXPONENTIAL.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[BackoffPolicy.LINEAR.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$1 = nArray;
            nArray = new int[NetworkType.values().length];
            try {
                nArray[NetworkType.NOT_REQUIRED.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[NetworkType.CONNECTED.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[NetworkType.UNMETERED.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[NetworkType.NOT_ROAMING.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[NetworkType.METERED.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$2 = nArray;
            nArray = new int[OutOfQuotaPolicy.values().length];
            try {
                nArray[OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[OutOfQuotaPolicy.DROP_WORK_REQUEST.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$3 = nArray;
        }
    }
}

