/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.ContinuationInterceptor
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.room;

import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.room.TransactionElement;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.ThreadContextElementKt;

@Metadata(d1={"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u001a9\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b*\u00020\b2\u001c\u0010\f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2={"acquireTransactionThread", "Lkotlin/coroutines/ContinuationInterceptor;", "Ljava/util/concurrent/Executor;", "controlJob", "Lkotlinx/coroutines/Job;", "(Ljava/util/concurrent/Executor;Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createTransactionContext", "Lkotlin/coroutines/CoroutineContext;", "Landroidx/room/RoomDatabase;", "(Landroidx/room/RoomDatabase;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTransaction", "R", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Landroidx/room/RoomDatabase;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "room-ktx_release"}, k=2, mv={1, 7, 1}, xi=48)
public final class RoomDatabaseKt {
    public static final /* synthetic */ Object access$acquireTransactionThread(Executor executor, Job job2, Continuation continuation) {
        return RoomDatabaseKt.acquireTransactionThread(executor, job2, (Continuation<? super ContinuationInterceptor>)continuation);
    }

    public static final /* synthetic */ Object access$createTransactionContext(RoomDatabase roomDatabase, Continuation continuation) {
        return RoomDatabaseKt.createTransactionContext(roomDatabase, (Continuation<? super CoroutineContext>)continuation);
    }

    private static final Object acquireTransactionThread(Executor object, Job job2, Continuation<? super ContinuationInterceptor> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        cancellableContinuation.invokeOnCancellation((Function1<Throwable, Unit>)((Function1)new Function1<Throwable, Unit>(job2){
            final Job $controlJob;
            {
                this.$controlJob = job2;
                super(1);
            }

            public final void invoke(Throwable throwable) {
                Job.DefaultImpls.cancel$default(this.$controlJob, null, 1, null);
            }
        }));
        try {
            Runnable runnable2 = new Runnable(cancellableContinuation, job2){
                final CancellableContinuation<ContinuationInterceptor> $continuation;
                final Job $controlJob;
                {
                    this.$continuation = cancellableContinuation;
                    this.$controlJob = job2;
                }

                public final void run() {
                    BuildersKt.runBlocking$default(null, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this.$continuation, this.$controlJob, null){
                        final CancellableContinuation<ContinuationInterceptor> $continuation;
                        final Job $controlJob;
                        private Object L$0;
                        int label;
                        {
                            this.$continuation = cancellableContinuation;
                            this.$controlJob = job2;
                            super(2, continuation);
                        }

                        public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                            object2 = new /* invalid duplicate definition of identical inner class */;
                            object2.L$0 = object;
                            return object2;
                        }

                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        public final Object invokeSuspend(Object object) {
                            Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                default: {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                case 1: {
                                    ResultKt.throwOnFailure((Object)object);
                                    break;
                                }
                                case 0: {
                                    ResultKt.throwOnFailure((Object)object);
                                    CoroutineScope coroutineScope = (CoroutineScope)this.L$0;
                                    object = this.$continuation;
                                    Object object3 = Result.Companion;
                                    object3 = coroutineScope.getCoroutineContext().get((CoroutineContext.Key)ContinuationInterceptor.Key);
                                    Intrinsics.checkNotNull((Object)object3);
                                    object.resumeWith(Result.constructor-impl((Object)object3));
                                    object3 = this.$controlJob;
                                    object = (Continuation)this;
                                    this.label = 1;
                                    if (object3.join((Continuation<? super Unit>)object) != object2) break;
                                    return object2;
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }, 1, null);
                }
            };
            object.execute(runnable2);
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            cancellableContinuation.cancel(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", rejectedExecutionException));
        }
        object = cancellableContinuationImpl.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return object;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private static final Object createTransactionContext(RoomDatabase var0, Continuation<? super CoroutineContext> var1_1) {
        if (!(var1_1 instanceof createTransactionContext.1)) ** GOTO lbl-1000
        var2_2 /* !! */  = var1_1;
        if ((var2_2 /* !! */ .label & -2147483648) != 0) {
            var2_2 /* !! */ .label += -2147483648;
            var1_1 = var2_2 /* !! */ ;
        } else lbl-1000:
        // 2 sources

        {
            var1_1 = new ContinuationImpl((Continuation<? super createTransactionContext.1>)var1_1){
                Object L$0;
                Object L$1;
                int label;
                Object result;

                public final Object invokeSuspend(Object object) {
                    this.result = object;
                    this.label |= Integer.MIN_VALUE;
                    return RoomDatabaseKt.access$createTransactionContext(null, (Continuation)this);
                }
            };
        }
        var2_2 /* !! */  = var1_1.result;
        var4_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (var1_1.label) {
            default: {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            case 1: {
                var0 = (CompletableJob)var1_1.L$1;
                var1_1 = (RoomDatabase)var1_1.L$0;
                ResultKt.throwOnFailure((Object)var2_2 /* !! */ );
                break;
            }
            case 0: {
                ResultKt.throwOnFailure((Object)var2_2 /* !! */ );
                var2_2 /* !! */  = JobKt.Job$default(null, 1, null);
                var3_4 /* !! */  = (Job)var1_1.getContext().get((CoroutineContext.Key)Job.Key);
                if (var3_4 /* !! */  != null) {
                    var3_4 /* !! */ .invokeOnCompletion((Function1<? super Throwable, Unit>)((Function1)new Function1<Throwable, Unit>((CompletableJob)var2_2 /* !! */ ){
                        final CompletableJob $controlJob;
                        {
                            this.$controlJob = completableJob;
                            super(1);
                        }

                        public final void invoke(Throwable throwable) {
                            Job.DefaultImpls.cancel$default((Job)this.$controlJob, null, 1, null);
                        }
                    }));
                }
                var5_5 = var0.getTransactionExecutor();
                var3_4 /* !! */  = (Job)var2_2 /* !! */ ;
                var1_1.L$0 = var0;
                var1_1.L$1 = var2_2 /* !! */ ;
                var1_1.label = 1;
                if ((var3_4 /* !! */  = RoomDatabaseKt.acquireTransactionThread(var5_5, (Job)var3_4 /* !! */ , (Continuation<? super ContinuationInterceptor>)var1_1)) == var4_3) {
                    return var4_3;
                }
                var1_1 = var0;
                var0 = var2_2 /* !! */ ;
                var2_2 /* !! */  = var3_4 /* !! */ ;
            }
        }
        var3_4 /* !! */  = (ContinuationInterceptor)var2_2 /* !! */ ;
        var2_2 /* !! */  = new TransactionElement((Job)var0, var3_4 /* !! */ );
        var0 = ThreadContextElementKt.asContextElement(var1_1.getSuspendingTransactionId(), Boxing.boxInt((int)System.identityHashCode(var0)));
        return var3_4 /* !! */ .plus((CoroutineContext)var2_2 /* !! */ ).plus((CoroutineContext)var0);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final <R> Object withTransaction(RoomDatabase var0, Function1<? super Continuation<? super R>, ? extends Object> var1_1, Continuation<? super R> var2_2) {
        block8: {
            block9: {
                if (!(var2_2 /* !! */  instanceof withTransaction.1)) ** GOTO lbl-1000
                var3_3 = var2_2 /* !! */ ;
                if ((var3_3.label & -2147483648) != 0) {
                    var3_3.label += -2147483648;
                    var2_2 /* !! */  = var3_3;
                } else lbl-1000:
                // 2 sources

                {
                    var2_2 /* !! */  = new ContinuationImpl(var2_2 /* !! */ ){
                        Object L$0;
                        Object L$1;
                        int label;
                        Object result;

                        public final Object invokeSuspend(Object object) {
                            this.result = object;
                            this.label |= Integer.MIN_VALUE;
                            return RoomDatabaseKt.withTransaction(null, null, (Continuation)this);
                        }
                    };
                }
                var3_3 = var2_2 /* !! */ .result;
                var4_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (var2_2 /* !! */ .label) {
                    default: {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    case 2: {
                        ResultKt.throwOnFailure((Object)var3_3);
                        var0 /* !! */  = var3_3;
                        break block8;
                    }
                    case 1: {
                        var1_1 /* !! */  = (Function1)var2_2 /* !! */ .L$1;
                        var0 /* !! */  = (RoomDatabase)var2_2 /* !! */ .L$0;
                        ResultKt.throwOnFailure((Object)var3_3);
                        break;
                    }
                    case 0: {
                        ResultKt.throwOnFailure((Object)var3_3);
                        var3_3 = (TransactionElement)var2_2 /* !! */ .getContext().get((CoroutineContext.Key)TransactionElement.Key);
                        if (var3_3 == null || (var3_3 = var3_3.getTransactionDispatcher$room_ktx_release()) == null) ** GOTO lbl28
                        var3_3 = (CoroutineContext)var3_3;
                        break block9;
lbl28:
                        // 1 sources

                        var2_2 /* !! */ .L$0 = var0 /* !! */ ;
                        var2_2 /* !! */ .L$1 = var1_1 /* !! */ ;
                        var2_2 /* !! */ .label = 1;
                        var3_3 = RoomDatabaseKt.createTransactionContext(var0 /* !! */ , var2_2 /* !! */ );
                        if (var3_3 != var4_4) break;
                        return var4_4;
                    }
                }
                var3_3 = (CoroutineContext)var3_3;
            }
            var0 /* !! */  = (Function2)new Function2<CoroutineScope, Continuation<? super R>, Object>(var0 /* !! */ , var1_1 /* !! */ , null){
                final Function1<Continuation<? super R>, Object> $block;
                final RoomDatabase $this_withTransaction;
                private Object L$0;
                int label;
                {
                    this.$this_withTransaction = roomDatabase;
                    this.$block = function1;
                    super(2, continuation);
                }

                public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                    object2 = new /* invalid duplicate definition of identical inner class */;
                    object2.L$0 = object;
                    return object2;
                }

                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
                    return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /*
                 * Loose catch block
                 * WARNING - void declaration
                 */
                public final Object invokeSuspend(Object object) {
                    void var1_5;
                    TransactionElement transactionElement;
                    block17: {
                        Object object2;
                        block16: {
                            Object object3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                default: {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                case 1: {
                                    object2 = this;
                                    transactionElement = (TransactionElement)object2.L$0;
                                    try {
                                        ResultKt.throwOnFailure((Object)object);
                                        object2 = object;
                                        break;
                                    }
                                    catch (Throwable throwable) {
                                        break block16;
                                    }
                                }
                                case 0: {
                                    ResultKt.throwOnFailure((Object)object);
                                    transactionElement = ((CoroutineScope)this.L$0).getCoroutineContext().get((CoroutineContext.Key)TransactionElement.Key);
                                    Intrinsics.checkNotNull((Object)transactionElement);
                                    transactionElement.acquire();
                                    this.$this_withTransaction.beginTransaction();
                                    object2 = this.$block;
                                    this.L$0 = transactionElement;
                                    this.label = 1;
                                    object2 = object2.invoke((Object)((Object)this));
                                    if (object2 != object3) break;
                                    return object3;
                                }
                            }
                            try {
                                this.$this_withTransaction.setTransactionSuccessful();
                            }
                            catch (Throwable throwable) {
                                object2 = this;
                                break block16;
                            }
                            try {
                                this.$this_withTransaction.endTransaction();
                                transactionElement.release();
                                return object2;
                            }
                            catch (Throwable throwable) {}
                            break block17;
                            catch (Throwable throwable) {
                                object2 = this;
                            }
                        }
                        try {
                            void var4_10;
                            object2.$this_withTransaction.endTransaction();
                            throw var4_10;
                        }
                        catch (Throwable throwable) {}
                        break block17;
                        catch (Throwable throwable) {
                            // empty catch block
                        }
                    }
                    transactionElement.release();
                    throw var1_5;
                }
            };
            var2_2 /* !! */ .L$0 = null;
            var2_2 /* !! */ .L$1 = null;
            var2_2 /* !! */ .label = 2;
            var1_1 /* !! */  = BuildersKt.withContext((CoroutineContext)var3_3, var0 /* !! */ , var2_2 /* !! */ );
            var0 /* !! */  = var1_1 /* !! */ ;
            if (var1_1 /* !! */  == var4_4) {
                return var4_4;
            }
        }
        return var0 /* !! */ ;
    }
}

