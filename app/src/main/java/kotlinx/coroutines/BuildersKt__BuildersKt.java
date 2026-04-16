/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.ContinuationInterceptor
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.jvm.functions.Function2
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.BlockingCoroutine;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.ThreadLocalEventLoop;

@Metadata(d1={"\u0000\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aT\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032'\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005\u00a2\u0006\u0002\b\t\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u00a2\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2={"runBlocking", "T", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=5, mv={1, 8, 0}, xi=48, xs="kotlinx/coroutines/BuildersKt")
final class BuildersKt__BuildersKt {
    public static final <T> T runBlocking(CoroutineContext object, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) throws InterruptedException {
        ContinuationInterceptor continuationInterceptor;
        Thread thread;
        block5: {
            block7: {
                block6: {
                    block4: {
                        thread = Thread.currentThread();
                        continuationInterceptor = (ContinuationInterceptor)object.get((CoroutineContext.Key)ContinuationInterceptor.Key);
                        if (continuationInterceptor != null) break block4;
                        continuationInterceptor = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
                        object = CoroutineContextKt.newCoroutineContext(GlobalScope.INSTANCE, object.plus((CoroutineContext)continuationInterceptor));
                        break block5;
                    }
                    boolean bl = continuationInterceptor instanceof EventLoop;
                    ContinuationInterceptor continuationInterceptor2 = null;
                    continuationInterceptor = bl ? (EventLoop)continuationInterceptor : null;
                    if (continuationInterceptor == null) break block6;
                    if (continuationInterceptor.shouldBeProcessedFromContext()) {
                        continuationInterceptor2 = continuationInterceptor;
                    }
                    continuationInterceptor = continuationInterceptor2;
                    if (continuationInterceptor2 != null) break block7;
                }
                continuationInterceptor = ThreadLocalEventLoop.INSTANCE.currentOrNull$kotlinx_coroutines_core();
            }
            object = CoroutineContextKt.newCoroutineContext(GlobalScope.INSTANCE, (CoroutineContext)object);
        }
        object = new BlockingCoroutine((CoroutineContext)object, thread, (EventLoop)continuationInterceptor);
        ((AbstractCoroutine)object).start(CoroutineStart.DEFAULT, object, function2);
        return ((BlockingCoroutine)object).joinBlocking();
    }

    public static /* synthetic */ Object runBlocking$default(CoroutineContext coroutineContext, Function2 function2, int n, Object object) throws InterruptedException {
        if ((n & 1) != 0) {
            coroutineContext = (CoroutineContext)EmptyCoroutineContext.INSTANCE;
        }
        return BuildersKt.runBlocking(coroutineContext, function2);
    }
}

