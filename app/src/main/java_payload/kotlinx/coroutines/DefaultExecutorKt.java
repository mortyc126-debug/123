/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.DefaultExecutor;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.internal.MainDispatchersKt;
import kotlinx.coroutines.internal.SystemPropsKt;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\b\u0010\u0006\u001a\u00020\u0001H\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2={"DefaultDelay", "Lkotlinx/coroutines/Delay;", "getDefaultDelay", "()Lkotlinx/coroutines/Delay;", "defaultMainDelayOptIn", "", "initializeDefaultDelay", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class DefaultExecutorKt {
    private static final Delay DefaultDelay;
    private static final boolean defaultMainDelayOptIn;

    static {
        defaultMainDelayOptIn = SystemPropsKt.systemProp("kotlinx.coroutines.main.delay", false);
        DefaultDelay = DefaultExecutorKt.initializeDefaultDelay();
    }

    public static final Delay getDefaultDelay() {
        return DefaultDelay;
    }

    private static final Delay initializeDefaultDelay() {
        if (!defaultMainDelayOptIn) {
            return DefaultExecutor.INSTANCE;
        }
        Object object = Dispatchers.getMain();
        object = !MainDispatchersKt.isMissing(object) && object instanceof Delay ? (Delay)object : (Delay)DefaultExecutor.INSTANCE;
        return object;
    }
}

