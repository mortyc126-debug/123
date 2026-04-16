/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.ExceptionsKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.jvm.functions.Function2
 */
package kotlinx.coroutines;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.internal.CoroutineExceptionHandlerImpl_commonKt;

@Metadata(d1={"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a%\u0010\u0000\u001a\u00020\u00012\u001a\b\u0004\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003H\u0086\b\u001a\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0005H\u0007\u001a\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0000\u00a8\u0006\r"}, d2={"CoroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handler", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext;", "", "", "handleCoroutineException", "context", "exception", "handlerException", "originalException", "thrownException", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class CoroutineExceptionHandlerKt {
    public static final CoroutineExceptionHandler CoroutineExceptionHandler(Function2<? super CoroutineContext, ? super Throwable, Unit> function2) {
        return new CoroutineExceptionHandler(function2, CoroutineExceptionHandler.Key){
            final Function2<CoroutineContext, Throwable, Unit> $handler;
            {
                this.$handler = function2;
                super((CoroutineContext.Key)key);
            }

            public void handleException(CoroutineContext coroutineContext, Throwable throwable) {
                this.$handler.invoke((Object)coroutineContext, (Object)throwable);
            }
        };
    }

    public static final void handleCoroutineException(CoroutineContext coroutineContext, Throwable throwable) {
        block3: {
            CoroutineExceptionHandler coroutineExceptionHandler;
            try {
                coroutineExceptionHandler = (CoroutineExceptionHandler)coroutineContext.get((CoroutineContext.Key)CoroutineExceptionHandler.Key);
                if (coroutineExceptionHandler == null) break block3;
            }
            catch (Throwable throwable2) {
                CoroutineExceptionHandlerImpl_commonKt.handleUncaughtCoroutineException(coroutineContext, CoroutineExceptionHandlerKt.handlerException(throwable, throwable2));
                return;
            }
            coroutineExceptionHandler.handleException(coroutineContext, throwable);
            return;
        }
        CoroutineExceptionHandlerImpl_commonKt.handleUncaughtCoroutineException(coroutineContext, throwable);
    }

    public static final Throwable handlerException(Throwable throwable, Throwable throwable2) {
        if (throwable == throwable2) {
            return throwable;
        }
        throwable2 = new RuntimeException("Exception while trying to handle coroutine exception", throwable2);
        ExceptionsKt.addSuppressed((Throwable)throwable2, (Throwable)throwable);
        return throwable2;
    }
}

