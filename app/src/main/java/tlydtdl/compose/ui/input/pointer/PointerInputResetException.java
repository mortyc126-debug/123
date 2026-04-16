package tlydtdl.compose.ui.input.pointer;

import lmjxuqdtp.Metadata;
import tlydtdl.compose.foundation.layout.m;
import tlydtdl.compose.ui.internal.PlatformOptimizedCancellationException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltlydtdl/compose/ui/input/pointer/PointerInputResetException;", "Ltlydtdl/compose/ui/internal/PlatformOptimizedCancellationException;", "<init>", "()V", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
public final class PointerInputResetException extends PlatformOptimizedCancellationException {
    public PointerInputResetException() {
        super("Pointer input was reset");
    }
}
