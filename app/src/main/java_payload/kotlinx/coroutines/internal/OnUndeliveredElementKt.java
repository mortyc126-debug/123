/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.ExceptionsKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.functions.Function1
 */
package kotlinx.coroutines.internal;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.internal.UndeliveredElementException;

@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aI\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\b\u0000\u0010\u0004*\u0018\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u00052\u0006\u0010\u0006\u001a\u0002H\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0000\u00a2\u0006\u0002\u0010\t\u001a=\u0010\n\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0004*\u0018\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u00052\u0006\u0010\u0006\u001a\u0002H\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0000\u00a2\u0006\u0002\u0010\u000b\u001aC\u0010\f\u001a\u0004\u0018\u00010\r\"\u0004\b\u0000\u0010\u0004*\u0018\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u00052\u0006\u0010\u0006\u001a\u0002H\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0000\u00a2\u0006\u0002\u0010\u000f**\b\u0000\u0010\u0010\u001a\u0004\b\u0000\u0010\u0004\"\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00030\u00012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00030\u0001\u00a8\u0006\u0011"}, d2={"bindCancellationFun", "Lkotlin/Function1;", "", "", "E", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "element", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)Lkotlin/jvm/functions/Function1;", "callUndeliveredElement", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", "callUndeliveredElementCatchingException", "Lkotlinx/coroutines/internal/UndeliveredElementException;", "undeliveredElementException", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlinx/coroutines/internal/UndeliveredElementException;)Lkotlinx/coroutines/internal/UndeliveredElementException;", "OnUndeliveredElement", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class OnUndeliveredElementKt {
    public static final <E> Function1<Throwable, Unit> bindCancellationFun(Function1<? super E, Unit> function1, E e, CoroutineContext coroutineContext) {
        return (Function1)new Function1<Throwable, Unit>(function1, e, coroutineContext){
            final CoroutineContext $context;
            final E $element;
            final Function1<E, Unit> $this_bindCancellationFun;
            {
                this.$this_bindCancellationFun = function1;
                this.$element = e;
                this.$context = coroutineContext;
                super(1);
            }

            public final void invoke(Throwable throwable) {
                OnUndeliveredElementKt.callUndeliveredElement(this.$this_bindCancellationFun, this.$element, this.$context);
            }
        };
    }

    public static final <E> void callUndeliveredElement(Function1<? super E, Unit> object, E e, CoroutineContext coroutineContext) {
        if ((object = OnUndeliveredElementKt.callUndeliveredElementCatchingException(object, e, null)) != null) {
            CoroutineExceptionHandlerKt.handleCoroutineException(coroutineContext, (Throwable)object);
        }
    }

    public static final <E> UndeliveredElementException callUndeliveredElementCatchingException(Function1<? super E, Unit> function1, E e, UndeliveredElementException undeliveredElementException) {
        Throwable throwable2;
        block2: {
            try {
                function1.invoke(e);
            }
            catch (Throwable throwable2) {
                if (undeliveredElementException == null || undeliveredElementException.getCause() == throwable2) break block2;
                ExceptionsKt.addSuppressed((Throwable)undeliveredElementException, (Throwable)throwable2);
            }
            return undeliveredElementException;
        }
        return new UndeliveredElementException("Exception in undelivered element handler for " + e, throwable2);
    }

    public static /* synthetic */ UndeliveredElementException callUndeliveredElementCatchingException$default(Function1 function1, Object object, UndeliveredElementException undeliveredElementException, int n, Object object2) {
        if ((n & 2) != 0) {
            undeliveredElementException = null;
        }
        return OnUndeliveredElementKt.callUndeliveredElementCatchingException(function1, object, undeliveredElementException);
    }
}

