/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.internal.LimitedDispatcherKt;

@Metadata(d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0005R\u0012\u0010\u0003\u001a\u00020\u0000X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\f"}, d2={"Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "immediate", "getImmediate", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "limitedParallelism", "parallelism", "", "toString", "", "toStringInternalImpl", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public abstract class MainCoroutineDispatcher
extends CoroutineDispatcher {
    public abstract MainCoroutineDispatcher getImmediate();

    @Override
    public CoroutineDispatcher limitedParallelism(int n) {
        LimitedDispatcherKt.checkParallelism(n);
        return this;
    }

    @Override
    public String toString() {
        String string2;
        String string3 = string2 = this.toStringInternalImpl();
        if (string2 == null) {
            string3 = DebugStringsKt.getClassSimpleName((Object)this) + '@' + DebugStringsKt.getHexAddress((Object)this);
        }
        return string3;
    }

    protected final String toStringInternalImpl() {
        MainCoroutineDispatcher mainCoroutineDispatcher = Dispatchers.getMain();
        if (this == mainCoroutineDispatcher) {
            return "Dispatchers.Main";
        }
        try {
            mainCoroutineDispatcher = mainCoroutineDispatcher.getImmediate();
        }
        catch (UnsupportedOperationException unsupportedOperationException) {
            mainCoroutineDispatcher = null;
        }
        if (this == mainCoroutineDispatcher) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }
}

