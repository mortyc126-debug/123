/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.ExceptionsKt
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$ObjectRef
 */
package kotlinx.coroutines.flow;

import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ah\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012B\u0010\u0003\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0004\u00a2\u0006\u0002\b\r\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000e\u001a1\u0010\u000f\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0080@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011\u001a\u0019\u0010\u0012\u001a\u00020\u0013*\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u00a2\u0006\u0002\b\u0016\u001a\u001b\u0010\u0017\u001a\u00020\u0013*\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u0002\u00a2\u0006\u0002\b\u0019\u001ac\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\b\u0002\u0010\u001b\u001a\u00020\u001c23\b\u0002\u0010\u001d\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u001e\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001f\u001a}\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012W\u0010\u001d\u001aS\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u001c\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\f0!\u00a2\u0006\u0002\b\r\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010#\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006$"}, d2={"catch", "Lkotlinx/coroutines/flow/Flow;", "T", "action", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "catchImpl", "collector", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isCancellationCause", "", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "isCancellationCause$FlowKt__ErrorsKt", "isSameExceptionAs", "other", "isSameExceptionAs$FlowKt__ErrorsKt", "retry", "retries", "", "predicate", "Lkotlin/Function2;", "(Lkotlinx/coroutines/flow/Flow;JLkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "retryWhen", "Lkotlin/Function4;", "attempt", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k=5, mv={1, 8, 0}, xi=48, xs="kotlinx/coroutines/flow/FlowKt")
final class FlowKt__ErrorsKt {
    public static final <T> Flow<T> catch(Flow<? extends T> flow2, Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return new Flow<T>(flow2, function3){
            final Function3 $action$inlined;
            final Flow $this_catch$inlined;
            {
                this.$this_catch$inlined = flow2;
                this.$action$inlined = function3;
            }

            /*
             * Unable to fully structure code
             * Could not resolve type clashes
             */
            public Object collect(FlowCollector<? super T> var1_1, Continuation<? super Unit> var2_2) {
                block9: {
                    if (!(var2_2 /* !! */  instanceof catch$$inlined$unsafeFlow$1$1)) ** GOTO lbl-1000
                    var3_3 /* !! */  = var2_2 /* !! */ ;
                    if ((var3_3 /* !! */ .label & -2147483648) != 0) {
                        var3_3 /* !! */ .label += -2147483648;
                        var2_2 /* !! */  = var3_3 /* !! */ ;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var2_2 /* !! */  = new ContinuationImpl(this, var2_2 /* !! */ ){
                            Object L$0;
                            Object L$1;
                            int label;
                            Object result;
                            final catch$$inlined$unsafeFlow$1 this$0;
                            {
                                this.this$0 = var1_1;
                                super(continuation);
                            }

                            public final Object invokeSuspend(Object object) {
                                this.result = object;
                                this.label |= Integer.MIN_VALUE;
                                return this.this$0.collect(null, (Continuation<? super Unit>)((Continuation)this));
                            }
                        };
                    }
                    var4_4 /* !! */  = var2_2 /* !! */ .result;
                    var6_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (var2_2 /* !! */ .label) {
                        default: {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        case 2: {
                            ResultKt.throwOnFailure((Object)var4_4 /* !! */ );
                            break block9;
                        }
                        case 1: {
                            var1_1 = (FlowCollector)var2_2 /* !! */ .L$1;
                            var3_3 /* !! */  = var2_2 /* !! */ .L$0;
                            ResultKt.throwOnFailure(var4_4 /* !! */ );
                            break;
                        }
                        case 0: {
                            ResultKt.throwOnFailure((Object)var4_4 /* !! */ );
                            var3_3 /* !! */  = this;
                            var4_4 /* !! */  = var2_2 /* !! */ ;
                            var4_4 /* !! */  = var3_3 /* !! */ .$this_catch$inlined;
                            var2_2 /* !! */ .L$0 = var3_3 /* !! */ ;
                            var2_2 /* !! */ .L$1 = var1_1;
                            var2_2 /* !! */ .label = 1;
                            var5_6 = FlowKt.catchImpl(var4_4 /* !! */ , var1_1, var2_2 /* !! */ );
                            var4_4 /* !! */  = var5_6;
                            if (var5_6 != var6_5) break;
                            return var6_5;
                        }
                    }
                    var4_4 /* !! */  = (Throwable)var4_4 /* !! */ ;
                    if (var4_4 /* !! */  != null) {
                        var3_3 /* !! */  = var3_3 /* !! */ .$action$inlined;
                        var2_2 /* !! */ .L$0 = null;
                        var2_2 /* !! */ .L$1 = null;
                        var2_2 /* !! */ .label = 2;
                        InlineMarker.mark((int)6);
                        var1_1 = var3_3 /* !! */ .invoke(var1_1, var4_4 /* !! */ , var2_2 /* !! */ );
                        InlineMarker.mark((int)7);
                        if (var1_1 == var6_5) {
                            return var6_5;
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        };
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final <T> Object catchImpl(Flow<? extends T> var0, FlowCollector<? super T> var1_4, Continuation<? super Throwable> var2_5) {
        block13: {
            if (!(var2_5 /* !! */  instanceof catchImpl.1)) ** GOTO lbl-1000
            var3_6 /* !! */  = var2_5 /* !! */ ;
            if ((var3_6 /* !! */ .label & -2147483648) != 0) {
                var3_6 /* !! */ .label += -2147483648;
                var2_5 /* !! */  = var3_6 /* !! */ ;
            } else lbl-1000:
            // 2 sources

            {
                var2_5 /* !! */  = new ContinuationImpl(var2_5 /* !! */ ){
                    Object L$0;
                    int label;
                    Object result;

                    public final Object invokeSuspend(Object object) {
                        this.result = object;
                        this.label |= Integer.MIN_VALUE;
                        return FlowKt.catchImpl(null, null, (Continuation<? super Throwable>)((Continuation)this));
                    }
                };
            }
            var3_6 /* !! */  = var2_5 /* !! */ .result;
            var4_7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (var2_5 /* !! */ .label) {
                default: {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                case 1: {
                    var1_4 /* !! */  = (Ref.ObjectRef)var2_5 /* !! */ .L$0;
                    try {
                        ResultKt.throwOnFailure((Object)var3_6 /* !! */ );
                        break;
                    }
                    catch (Throwable var0_1) {
                        break block13;
                    }
                }
                case 0: {
                    ResultKt.throwOnFailure((Object)var3_6 /* !! */ );
                    var3_6 /* !! */  = new Ref.ObjectRef();
                    var5_8 = new FlowCollector(var1_4 /* !! */ , (Ref.ObjectRef<Throwable>)var3_6 /* !! */ ){
                        final FlowCollector<T> $collector;
                        final Ref.ObjectRef<Throwable> $fromDownstream;
                        {
                            this.$collector = flowCollector;
                            this.$fromDownstream = objectRef;
                        }

                        /*
                         * Unable to fully structure code
                         * Could not resolve type clashes
                         */
                        public final Object emit(T var1_1, Continuation<? super Unit> var2_5) {
                            block10: {
                                if (!(var2_5 /* !! */  instanceof catchImpl.emit.1)) ** GOTO lbl-1000
                                var3_6 /* !! */  = var2_5 /* !! */ ;
                                if ((var3_6 /* !! */ .label & -2147483648) != 0) {
                                    var3_6 /* !! */ .label += -2147483648;
                                    var2_5 /* !! */  = var3_6 /* !! */ ;
                                } else lbl-1000:
                                // 2 sources

                                {
                                    var2_5 /* !! */  = new ContinuationImpl(this, var2_5 /* !! */ ){
                                        Object L$0;
                                        int label;
                                        Object result;
                                        final catchImpl.2<T> this$0;
                                        {
                                            this.this$0 = var1_1;
                                            super(continuation);
                                        }

                                        public final Object invokeSuspend(Object object) {
                                            this.result = object;
                                            this.label |= Integer.MIN_VALUE;
                                            return this.this$0.emit(null, (Continuation<Unit>)((Continuation)this));
                                        }
                                    };
                                }
                                var4_7 = var2_5 /* !! */ .result;
                                var3_6 /* !! */  = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (var2_5 /* !! */ .label) {
                                    default: {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    case 1: {
                                        var2_5 /* !! */  = var2_5 /* !! */ .L$0;
                                        try {
                                            ResultKt.throwOnFailure(var4_7);
                                            break;
                                        }
                                        catch (Throwable var1_2) {
                                            break block10;
                                        }
                                    }
                                    case 0: {
                                        ResultKt.throwOnFailure((Object)var4_7);
                                        var4_7 = this.$collector;
                                        var2_5 /* !! */ .L$0 = this;
                                        var2_5 /* !! */ .label = 1;
                                        var1_1 /* !! */  = var4_7.emit(var1_1 /* !! */ , var2_5 /* !! */ );
                                        if (var1_1 /* !! */  != var3_6 /* !! */ ) break;
                                        return var3_6 /* !! */ ;
                                    }
                                }
                                return Unit.INSTANCE;
                                catch (Throwable var1_3) {
                                    var2_5 /* !! */  = this;
                                }
                            }
                            var2_5 /* !! */ .$fromDownstream.element = var1_4;
                            throw var1_4;
                        }
                    };
                    var1_4 /* !! */  = var5_8;
                    var2_5 /* !! */ .L$0 = var3_6 /* !! */ ;
                    var2_5 /* !! */ .label = 1;
                    var0 = var0.collect(var1_4 /* !! */ , (Continuation<? super Unit>)var2_5 /* !! */ );
                    if (var0 != var4_7) break;
                    return var4_7;
                }
            }
            return null;
            catch (Throwable var0_2) {
                var1_4 /* !! */  = var3_6 /* !! */ ;
            }
        }
        var1_4 /* !! */  = (Throwable)var1_4 /* !! */ .element;
        if (!FlowKt__ErrorsKt.isSameExceptionAs$FlowKt__ErrorsKt((Throwable)var0_3, (Throwable)var1_4 /* !! */ ) && !FlowKt__ErrorsKt.isCancellationCause$FlowKt__ErrorsKt((Throwable)var0_3, var2_5 /* !! */ .getContext())) {
            if (var1_4 /* !! */  == null) {
                return var0_3;
            }
            if (var0_3 instanceof CancellationException) {
                ExceptionsKt.addSuppressed((Throwable)var1_4 /* !! */ , (Throwable)var0_3);
                throw var1_4 /* !! */ ;
            }
            ExceptionsKt.addSuppressed((Throwable)var0_3, (Throwable)var1_4 /* !! */ );
            throw var0_3;
        }
        throw var0_3;
    }

    private static final boolean isCancellationCause$FlowKt__ErrorsKt(Throwable throwable, CoroutineContext object) {
        if ((object = (Job)object.get((CoroutineContext.Key)Job.Key)) != null && object.isCancelled()) {
            return FlowKt__ErrorsKt.isSameExceptionAs$FlowKt__ErrorsKt(throwable, object.getCancellationException());
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final boolean isSameExceptionAs$FlowKt__ErrorsKt(Throwable throwable, Throwable throwable2) {
        if (throwable2 == null) return false;
        if (DebugKt.getRECOVER_STACK_TRACES()) {
            throwable2 = StackTraceRecoveryKt.unwrapImpl(throwable2);
        }
        if (DebugKt.getRECOVER_STACK_TRACES()) {
            throwable = StackTraceRecoveryKt.unwrapImpl(throwable);
        }
        if (!Intrinsics.areEqual((Object)throwable2, (Object)throwable)) return false;
        return true;
    }

    public static final <T> Flow<T> retry(Flow<? extends T> flow2, long l, Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        boolean bl = l > 0L;
        if (bl) {
            return FlowKt.retryWhen(flow2, (Function4)new Function4<FlowCollector<? super T>, Throwable, Long, Continuation<? super Boolean>, Object>(l, function2, null){
                final Function2<Throwable, Continuation<? super Boolean>, Object> $predicate;
                final long $retries;
                long J$0;
                Object L$0;
                int label;
                {
                    this.$retries = l;
                    this.$predicate = function2;
                    super(4, continuation);
                }

                public final Object invoke(FlowCollector<? super T> object, Throwable throwable, long l, Continuation<? super Boolean> continuation) {
                    object = new /* invalid duplicate definition of identical inner class */;
                    object.L$0 = throwable;
                    object.J$0 = l;
                    return object.invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object function2) {
                    boolean bl;
                    block10: {
                        block9: {
                            Object object;
                            Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int n = this.label;
                            bl = true;
                            switch (n) {
                                default: {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                case 1: {
                                    ResultKt.throwOnFailure((Object)function2);
                                    object = function2;
                                    break;
                                }
                                case 0: {
                                    ResultKt.throwOnFailure((Object)function2);
                                    Throwable throwable = (Throwable)this.L$0;
                                    object = function2;
                                    if (this.J$0 < this.$retries) {
                                        object = this.$predicate;
                                        this.label = 1;
                                        if ((object = object.invoke((Object)throwable, (Object)((Object)this))) != object2) break;
                                        return object2;
                                    }
                                    break block9;
                                }
                            }
                            if (((Boolean)object).booleanValue()) break block10;
                            object = function2;
                        }
                        bl = false;
                    }
                    return Boxing.boxBoolean((boolean)bl);
                }
            });
        }
        throw new IllegalArgumentException(("Expected positive amount of retries, but had " + l).toString());
    }

    public static /* synthetic */ Flow retry$default(Flow flow2, long l, Function2 function2, int n, Object object) {
        if ((n & 1) != 0) {
            l = Long.MAX_VALUE;
        }
        if ((n & 2) != 0) {
            function2 = (Function2)new Function2<Throwable, Continuation<? super Boolean>, Object>(null){
                int label;

                public final Continuation<Unit> create(Object object, Continuation<?> continuation) {
                    return (Continuation)new /* invalid duplicate definition of identical inner class */;
                }

                public final Object invoke(Throwable throwable, Continuation<? super Boolean> continuation) {
                    return (this.create(throwable, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object object) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        default: {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        case 0: 
                    }
                    ResultKt.throwOnFailure((Object)object);
                    return Boxing.boxBoolean((boolean)true);
                }
            };
        }
        return FlowKt.retry(flow2, l, (Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object>)function2);
    }

    public static final <T> Flow<T> retryWhen(Flow<? extends T> flow2, Function4<? super FlowCollector<? super T>, ? super Throwable, ? super Long, ? super Continuation<? super Boolean>, ? extends Object> function4) {
        return new Flow<T>(flow2, function4){
            final Function4 $predicate$inlined;
            final Flow $this_retryWhen$inlined;
            {
                this.$this_retryWhen$inlined = flow2;
                this.$predicate$inlined = function4;
            }

            /*
             * Exception decompiling
             */
            public Object collect(FlowCollector<? super T> var1_1, Continuation<? super Unit> var2_2) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[SWITCH], 4[CASE]], but top level block is 5[DOLOOP]
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.dump(Method.java:598)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperAnonymousInner.dumpWithArgs(ClassFileDumperAnonymousInner.java:87)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.ConstructorInvokationAnonymousInner.dumpInner(ConstructorInvokationAnonymousInner.java:82)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredReturn.dump(StructuredReturn.java:60)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                 *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.dump(Block.java:564)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.dump(AttributeCode.java:135)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.entities.Method.dump(Method.java:627)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.AbstractClassFileDumper.dumpMethods(AbstractClassFileDumper.java:211)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperNormal.dump(ClassFileDumperNormal.java:70)
                 *     at org.benf.cfr.reader.entities.ClassFile.dump(ClassFile.java:1167)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:952)
                 *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
                 *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
                 *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
                 *     at org.benf.cfr.reader.Main.main(Main.java:54)
                 */
                throw new IllegalStateException("Decompilation failed");
            }
        };
    }
}

