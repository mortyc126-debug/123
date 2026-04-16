/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.Result$Companion
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function2
 */
package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.selects.SelectOldKt;
import kotlinx.coroutines.selects.UnbiasedSelectImplementation;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0001J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0001R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lkotlinx/coroutines/selects/UnbiasedSelectBuilderImpl;", "R", "Lkotlinx/coroutines/selects/UnbiasedSelectImplementation;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/Continuation;)V", "cont", "Lkotlinx/coroutines/CancellableContinuationImpl;", "handleBuilderException", "", "e", "", "initSelectResult", "", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public final class UnbiasedSelectBuilderImpl<R>
extends UnbiasedSelectImplementation<R> {
    private final CancellableContinuationImpl<R> cont;

    public UnbiasedSelectBuilderImpl(Continuation<? super R> continuation) {
        super(continuation.getContext());
        this.cont = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
    }

    public static final /* synthetic */ CancellableContinuationImpl access$getCont$p(UnbiasedSelectBuilderImpl unbiasedSelectBuilderImpl) {
        return unbiasedSelectBuilderImpl.cont;
    }

    public final void handleBuilderException(Throwable throwable) {
        Continuation continuation = this.cont;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable)));
    }

    public final Object initSelectResult() {
        if (this.cont.isCompleted()) {
            return this.cont.getResult();
        }
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(this.getContext()), null, CoroutineStart.UNDISPATCHED, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, null){
            int label;
            final UnbiasedSelectBuilderImpl<R> this$0;
            {
                this.this$0 = unbiasedSelectBuilderImpl;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> continuation) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /*
             * Loose catch block
             * WARNING - void declaration
             */
            public final Object invokeSuspend(Object object) {
                void var1_4;
                block8: {
                    Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        default: {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        case 1: {
                            try {
                                ResultKt.throwOnFailure((Object)object);
                                break;
                            }
                            catch (Throwable throwable) {
                                break block8;
                            }
                        }
                        case 0: {
                            ResultKt.throwOnFailure((Object)object);
                            UnbiasedSelectBuilderImpl<R> unbiasedSelectBuilderImpl = this.this$0;
                            object = (Continuation)this;
                            this.label = 1;
                            object = unbiasedSelectBuilderImpl.doSelect((Continuation<R>)object);
                            if (object != object2) break;
                            return object2;
                        }
                    }
                    SelectOldKt.access$resumeUndispatched(UnbiasedSelectBuilderImpl.access$getCont$p(this.this$0), object);
                    return Unit.INSTANCE;
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                }
                SelectOldKt.access$resumeUndispatchedWithException(UnbiasedSelectBuilderImpl.access$getCont$p(this.this$0), (Throwable)var1_4);
                return Unit.INSTANCE;
            }
        }, 1, null);
        return this.cont.getResult();
    }
}

