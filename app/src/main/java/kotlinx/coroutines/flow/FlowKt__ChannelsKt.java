/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 */
package kotlinx.coroutines.flow;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.ChannelAsFlow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.internal.ChannelFlowKt;

@Metadata(d1={"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u001a\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001a/\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u001a9\u0010\u000b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001a$\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0012\u001a\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2={"asFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "Lkotlinx/coroutines/channels/BroadcastChannel;", "consumeAsFlow", "Lkotlinx/coroutines/channels/ReceiveChannel;", "emitAll", "", "Lkotlinx/coroutines/flow/FlowCollector;", "channel", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitAllImpl", "consume", "", "emitAllImpl$FlowKt__ChannelsKt", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "produceIn", "scope", "Lkotlinx/coroutines/CoroutineScope;", "receiveAsFlow", "kotlinx-coroutines-core"}, k=5, mv={1, 8, 0}, xi=48, xs="kotlinx/coroutines/flow/FlowKt")
final class FlowKt__ChannelsKt {
    public static final /* synthetic */ Object access$emitAllImpl$FlowKt__ChannelsKt(FlowCollector flowCollector, ReceiveChannel receiveChannel, boolean bl, Continuation continuation) {
        return FlowKt__ChannelsKt.emitAllImpl$FlowKt__ChannelsKt(flowCollector, receiveChannel, bl, (Continuation<? super Unit>)continuation);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="'BroadcastChannel' is obsolete and all corresponding operators are deprecated in the favour of StateFlow and SharedFlow")
    public static final <T> Flow<T> asFlow(BroadcastChannel<T> broadcastChannel) {
        return new Flow<T>(broadcastChannel){
            final BroadcastChannel $this_asFlow$inlined;
            {
                this.$this_asFlow$inlined = broadcastChannel;
            }

            public Object collect(FlowCollector<? super T> object, Continuation<? super Unit> continuation) {
                if ((object = FlowKt.emitAll(object, this.$this_asFlow$inlined.openSubscription(), continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        };
    }

    public static final <T> Flow<T> consumeAsFlow(ReceiveChannel<? extends T> receiveChannel) {
        return new ChannelAsFlow(receiveChannel, true, null, 0, null, 28, null);
    }

    public static final <T> Object emitAll(FlowCollector<? super T> object, ReceiveChannel<? extends T> receiveChannel, Continuation<? super Unit> continuation) {
        if ((object = FlowKt__ChannelsKt.emitAllImpl$FlowKt__ChannelsKt(object, receiveChannel, true, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    /*
     * Exception decompiling
     */
    private static final <T> Object emitAllImpl$FlowKt__ChannelsKt(FlowCollector<? super T> var0, ReceiveChannel<? extends T> var1_1, boolean var2_6, Continuation<? super Unit> var3_7) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [11[SWITCH], 15[CASE]], but top level block is 20[UNCONDITIONALDOLOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public static final <T> ReceiveChannel<T> produceIn(Flow<? extends T> flow2, CoroutineScope coroutineScope) {
        return ChannelFlowKt.asChannelFlow(flow2).produceImpl(coroutineScope);
    }

    public static final <T> Flow<T> receiveAsFlow(ReceiveChannel<? extends T> receiveChannel) {
        return new ChannelAsFlow(receiveChannel, false, null, 0, null, 28, null);
    }
}

