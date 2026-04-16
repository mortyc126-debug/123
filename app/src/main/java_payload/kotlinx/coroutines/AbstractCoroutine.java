/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.jvm.functions.Function2
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.JobSupportKt;

@Metadata(d1={"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005B\u001d\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0002\u0010\u000bJ\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u001aH\u0014J\u0015\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0000\u00a2\u0006\u0002\b\u001eJ\r\u0010\u001f\u001a\u00020\u001aH\u0010\u00a2\u0006\u0002\b J\u0018\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\tH\u0014J\u0015\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00028\u0000H\u0014\u00a2\u0006\u0002\u0010&J\u0012\u0010'\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0004J\u001c\u0010(\u001a\u00020\u00162\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000*\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010&JM\u0010+\u001a\u00020\u0016\"\u0004\b\u0001\u0010,2\u0006\u0010+\u001a\u00020-2\u0006\u0010.\u001a\u0002H,2'\u0010/\u001a#\b\u0001\u0012\u0004\u0012\u0002H,\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u001800\u00a2\u0006\u0002\b1\u00f8\u0001\u0000\u00a2\u0006\u0002\u00102R\u0017\u0010\f\u001a\u00020\u0007\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00063"}, d2={"Lkotlinx/coroutines/AbstractCoroutine;", "T", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/CoroutineScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "initParentJob", "", "active", "(Lkotlin/coroutines/CoroutineContext;ZZ)V", "context", "getContext$annotations", "()V", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "getCoroutineContext", "isActive", "()Z", "afterResume", "", "state", "", "cancellationExceptionMessage", "", "handleOnCompletionException", "exception", "", "handleOnCompletionException$kotlinx_coroutines_core", "nameString", "nameString$kotlinx_coroutines_core", "onCancelled", "cause", "handled", "onCompleted", "value", "(Ljava/lang/Object;)V", "onCompletionInternal", "resumeWith", "result", "Lkotlin/Result;", "start", "R", "Lkotlinx/coroutines/CoroutineStart;", "receiver", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineStart;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public abstract class AbstractCoroutine<T>
extends JobSupport
implements Job,
Continuation<T>,
CoroutineScope {
    private final CoroutineContext context;

    public AbstractCoroutine(CoroutineContext coroutineContext, boolean bl, boolean bl2) {
        super(bl2);
        if (bl) {
            this.initParentJob((Job)coroutineContext.get((CoroutineContext.Key)Job.Key));
        }
        this.context = coroutineContext.plus((CoroutineContext)this);
    }

    public static /* synthetic */ void getContext$annotations() {
    }

    protected void afterResume(Object object) {
        this.afterCompletion(object);
    }

    @Override
    protected String cancellationExceptionMessage() {
        return DebugStringsKt.getClassSimpleName(this) + " was cancelled";
    }

    public final CoroutineContext getContext() {
        return this.context;
    }

    @Override
    public CoroutineContext getCoroutineContext() {
        return this.context;
    }

    @Override
    public final void handleOnCompletionException$kotlinx_coroutines_core(Throwable throwable) {
        CoroutineExceptionHandlerKt.handleCoroutineException(this.context, throwable);
    }

    @Override
    public boolean isActive() {
        return super.isActive();
    }

    @Override
    public String nameString$kotlinx_coroutines_core() {
        String string2 = CoroutineContextKt.getCoroutineName(this.context);
        if (string2 == null) {
            return super.nameString$kotlinx_coroutines_core();
        }
        return '\"' + string2 + "\":" + super.nameString$kotlinx_coroutines_core();
    }

    protected void onCancelled(Throwable throwable, boolean bl) {
    }

    protected void onCompleted(T t) {
    }

    @Override
    protected final void onCompletionInternal(Object object) {
        if (object instanceof CompletedExceptionally) {
            this.onCancelled(((CompletedExceptionally)object).cause, ((CompletedExceptionally)object).getHandled());
        } else {
            this.onCompleted(object);
        }
    }

    public final void resumeWith(Object object) {
        if ((object = this.makeCompletingOnce$kotlinx_coroutines_core(CompletionStateKt.toState$default(object, null, 1, null))) == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            return;
        }
        this.afterResume(object);
    }

    public final <R> void start(CoroutineStart coroutineStart, R r, Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        coroutineStart.invoke(function2, r, this);
    }
}

