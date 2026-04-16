/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.InlineMarker
 */
package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u0000\u0016\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006H\u0087\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2={"synchronized", "T", "lock", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class Synchronized_commonKt {
    public static final <T> T synchronized(Object object, Function0<? extends T> object2) {
        synchronized (object) {
            try {
                object2 = object2.invoke();
                return (T)object2;
            }
            finally {
                InlineMarker.finallyStart((int)1);
                // MONITOREXIT @DISABLED, blocks:[1, 3] lbl7 : MonitorExitStatement: MONITOREXIT : var0
                InlineMarker.finallyEnd((int)1);
            }
        }
    }
}

