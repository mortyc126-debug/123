/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0019\u0010\u000e\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001H\u0082\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\u0005\u001a\u00020\u00068\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u0019\u0010\t\u001a\u00020\u0001*\u00020\u00018\u00c2\u0002X\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0019\u0010\f\u001a\u00020\u0001*\u00020\u00018\u00c2\u0002X\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u000f"}, d2={"DECISION_SHIFT", "", "INDEX_MASK", "NO_INDEX", "RESUMED", "RESUME_TOKEN", "Lkotlinx/coroutines/internal/Symbol;", "SUSPENDED", "UNDECIDED", "decision", "getDecision", "(I)I", "index", "getIndex", "decisionAndIndex", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class CancellableContinuationImplKt {
    private static final int DECISION_SHIFT = 29;
    private static final int INDEX_MASK = 0x1FFFFFFF;
    private static final int NO_INDEX = 0x1FFFFFFF;
    private static final int RESUMED = 2;
    public static final Symbol RESUME_TOKEN = new Symbol("RESUME_TOKEN");
    private static final int SUSPENDED = 1;
    private static final int UNDECIDED = 0;

    private static final int decisionAndIndex(int n, int n2) {
        return (n << 29) + n2;
    }

    private static final int getDecision(int n) {
        return n >> 29;
    }

    private static final int getIndex(int n) {
        return 0x1FFFFFFF & n;
    }
}

