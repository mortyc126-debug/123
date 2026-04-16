/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.ExceptionsKt
 *  kotlin.Metadata
 *  kotlin.coroutines.CoroutineContext
 */
package kotlinx.coroutines.internal;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.internal.CoroutineExceptionHandlerImplKt;
import kotlinx.coroutines.internal.DiagnosticCoroutineContextException;
import kotlinx.coroutines.internal.ExceptionSuccessfullyProcessed;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u00a8\u0006\u0006"}, d2={"handleUncaughtCoroutineException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class CoroutineExceptionHandlerImpl_commonKt {
    public static final void handleUncaughtCoroutineException(CoroutineContext coroutineContext, Throwable throwable) {
        for (CoroutineExceptionHandler coroutineExceptionHandler : CoroutineExceptionHandlerImplKt.getPlatformExceptionHandlers()) {
            try {
                coroutineExceptionHandler.handleException(coroutineContext, throwable);
            }
            catch (Throwable throwable2) {
                CoroutineExceptionHandlerImplKt.propagateExceptionFinalResort(CoroutineExceptionHandlerKt.handlerException(throwable, throwable2));
            }
            catch (ExceptionSuccessfullyProcessed exceptionSuccessfullyProcessed) {
                return;
            }
        }
        try {
            Object object = new DiagnosticCoroutineContextException(coroutineContext);
            ExceptionsKt.addSuppressed((Throwable)throwable, (Throwable)((Throwable)object));
        }
        catch (Throwable throwable3) {
            // empty catch block
        }
        CoroutineExceptionHandlerImplKt.propagateExceptionFinalResort(throwable);
    }
}

