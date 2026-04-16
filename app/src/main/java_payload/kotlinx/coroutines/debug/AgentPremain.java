/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.io.ByteStreamsKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.debug;

import java.io.InputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.debug.AgentPremain$$ExternalSyntheticLambda0;
import kotlinx.coroutines.debug.internal.AgentInstallationType;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;
import sun.misc.Signal;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c1\u0002\u0018\u00002\u00020\u0001:\u0001\fB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lkotlinx/coroutines/debug/AgentPremain;", "", "()V", "enableCreationStackTraces", "", "installSignalHandler", "", "premain", "args", "", "instrumentation", "Ljava/lang/instrument/Instrumentation;", "DebugProbesTransformer", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public final class AgentPremain {
    public static final AgentPremain INSTANCE;
    private static final boolean enableCreationStackTraces;

    public static /* synthetic */ void $r8$lambda$WCAflVvFictlq_GPLH_RKIlVunI(Signal signal) {
        AgentPremain.installSignalHandler$lambda$1(signal);
    }

    static {
        Object var2_1;
        Object object;
        block6: {
            block5: {
                INSTANCE = new AgentPremain();
                object = INSTANCE;
                var2_1 = null;
                object = Result.Companion;
                object = System.getProperty("kotlinx.coroutines.debug.enable.creation.stack.trace");
                if (object == null) break block5;
                object = Boolean.parseBoolean((String)object);
                break block6;
            }
            object = null;
        }
        try {
            object = Result.constructor-impl((Object)object);
        }
        catch (Throwable throwable) {
            object = Result.Companion;
            object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
        if (Result.isFailure-impl((Object)object)) {
            object = var2_1;
        }
        boolean bl = (object = (Boolean)object) != null ? ((Boolean)object).booleanValue() : DebugProbesImpl.INSTANCE.getEnableCreationStackTraces();
        enableCreationStackTraces = bl;
    }

    private AgentPremain() {
    }

    private final void installSignalHandler() {
        try {
            Signal signal = new Signal("TRAP");
            AgentPremain$$ExternalSyntheticLambda0 agentPremain$$ExternalSyntheticLambda0 = new AgentPremain$$ExternalSyntheticLambda0();
            Signal.handle(signal, agentPremain$$ExternalSyntheticLambda0);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private static final void installSignalHandler$lambda$1(Signal signal) {
        if (DebugProbesImpl.INSTANCE.isInstalled$kotlinx_coroutines_core()) {
            DebugProbesImpl.INSTANCE.dumpCoroutines(System.out);
        } else {
            System.out.println((Object)"Cannot perform coroutines dump, debug probes are disabled");
        }
    }

    @JvmStatic
    public static final void premain(String string2, Instrumentation instrumentation) {
        AgentInstallationType.INSTANCE.setInstalledStatically$kotlinx_coroutines_core(true);
        instrumentation.addTransformer(DebugProbesTransformer.INSTANCE);
        DebugProbesImpl.INSTANCE.setEnableCreationStackTraces(enableCreationStackTraces);
        DebugProbesImpl.INSTANCE.install();
        INSTANCE.installSignalHandler();
    }

    @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u000e"}, d2={"Lkotlinx/coroutines/debug/AgentPremain$DebugProbesTransformer;", "Ljava/lang/instrument/ClassFileTransformer;", "()V", "transform", "", "loader", "Ljava/lang/ClassLoader;", "className", "", "classBeingRedefined", "Ljava/lang/Class;", "protectionDomain", "Ljava/security/ProtectionDomain;", "classfileBuffer", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class DebugProbesTransformer
    implements ClassFileTransformer {
        public static final DebugProbesTransformer INSTANCE = new DebugProbesTransformer();

        private DebugProbesTransformer() {
        }

        @Override
        public byte[] transform(ClassLoader classLoader, String string2, Class<?> clazz, ProtectionDomain protectionDomain, byte[] byArray) {
            if (classLoader != null && Intrinsics.areEqual((Object)string2, (Object)"kotlin/coroutines/jvm/internal/DebugProbesKt")) {
                AgentInstallationType.INSTANCE.setInstalledStatically$kotlinx_coroutines_core(true);
                return ByteStreamsKt.readBytes((InputStream)classLoader.getResourceAsStream("DebugProbesKt.bin"));
            }
            return null;
        }
    }
}

