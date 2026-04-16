/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.channels;

import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.selects.SelectClause1;

@Metadata(d1={"\u0000>\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u001a\u001a\u0010\u0002\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0001\u001aC\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u0002H\t0\n2\u001d\u0010\u000b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u0004\u0012\u0004\u0012\u0002H\b0\f\u00a2\u0006\u0002\b\rH\u0087\b\u00a2\u0006\u0002\u0010\u000e\u001aP\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u0002H\t0\u00042\u001d\u0010\u000b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u0004\u0012\u0004\u0012\u0002H\b0\f\u00a2\u0006\u0002\b\rH\u0086\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0002\u0010\u000f\u001a5\u0010\u0010\u001a\u00020\u0003\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\n2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00030\fH\u0087H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012\u001a5\u0010\u0010\u001a\u00020\u0003\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00030\fH\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013\u001a$\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\t0\u0015\"\b\b\u0000\u0010\t*\u00020\u0016*\b\u0012\u0004\u0012\u0002H\t0\u0004H\u0007\u001a'\u0010\u0017\u001a\u0004\u0018\u0001H\t\"\b\b\u0000\u0010\t*\u00020\u0016*\b\u0012\u0004\u0012\u0002H\t0\u0004H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018\u001a'\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\t0\u001a\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2={"DEFAULT_CLOSE_MESSAGE", "", "cancelConsumed", "", "Lkotlinx/coroutines/channels/ReceiveChannel;", "cause", "", "consume", "R", "E", "Lkotlinx/coroutines/channels/BroadcastChannel;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "consumeEach", "action", "(Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onReceiveOrNull", "Lkotlinx/coroutines/selects/SelectClause1;", "", "receiveOrNull", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toList", "", "kotlinx-coroutines-core"}, k=5, mv={1, 8, 0}, xi=48, xs="kotlinx/coroutines/channels/ChannelsKt")
final class ChannelsKt__Channels_commonKt {
    public static final void cancelConsumed(ReceiveChannel<?> receiveChannel, Throwable throwable) {
        CancellationException cancellationException = null;
        CancellationException cancellationException2 = null;
        if (throwable != null) {
            if (throwable instanceof CancellationException) {
                cancellationException2 = (CancellationException)throwable;
            }
            cancellationException = cancellationException2;
            if (cancellationException2 == null) {
                cancellationException = ExceptionsKt.CancellationException("Channel was consumed, consumer had failed", throwable);
            }
        }
        receiveChannel.cancel(cancellationException);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    public static final <E, R> R consume(BroadcastChannel<E> object, Function1<? super ReceiveChannel<? extends E>, ? extends R> object2) {
        object = object.openSubscription();
        try {
            object2 = object2.invoke(object);
            return (R)object2;
        }
        finally {
            InlineMarker.finallyStart((int)1);
            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel)object, null, 1, null);
            InlineMarker.finallyEnd((int)1);
        }
    }

    public static final <E, R> R consume(ReceiveChannel<? extends E> receiveChannel, Function1<? super ReceiveChannel<? extends E>, ? extends R> object) {
        try {
            object = object.invoke(receiveChannel);
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                InlineMarker.finallyStart((int)1);
                ChannelsKt.cancelConsumed(receiveChannel, throwable);
                InlineMarker.finallyEnd((int)1);
                throw throwable2;
            }
        }
        InlineMarker.finallyStart((int)1);
        ChannelsKt.cancelConsumed(receiveChannel, null);
        InlineMarker.finallyEnd((int)1);
        return (R)object;
    }

    /*
     * Exception decompiling
     */
    @Deprecated(level=DeprecationLevel.WARNING, message="BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    public static final <E> Object consumeEach(BroadcastChannel<E> var0, Function1<? super E, Unit> var1_2, Continuation<? super Unit> var2_5) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 2[TRYBLOCK] [2 : 185->192)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
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

    /*
     * Exception decompiling
     */
    public static final <E> Object consumeEach(ReceiveChannel<? extends E> var0, Function1<? super E, Unit> var1_2, Continuation<? super Unit> var2_6) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 2[TRYBLOCK] [2 : 184->191)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
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

    @Deprecated(level=DeprecationLevel.WARNING, message="BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    private static final <E> Object consumeEach$$forInline(BroadcastChannel<E> object, Function1<? super E, Unit> unit, Continuation<? super Unit> object2) {
        object = object.openSubscription();
        try {
            ChannelIterator channelIterator = ((ReceiveChannel)object).iterator();
            while (true) {
                InlineMarker.mark((int)3);
                InlineMarker.mark((int)0);
                object2 = channelIterator.hasNext(null);
                InlineMarker.mark((int)1);
                if (!((Boolean)object2).booleanValue()) break;
                unit.invoke(channelIterator.next());
            }
            unit = Unit.INSTANCE;
            return Unit.INSTANCE;
        }
        finally {
            InlineMarker.finallyStart((int)1);
            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel)object, null, 1, null);
            InlineMarker.finallyEnd((int)1);
        }
    }

    private static final <E> Object consumeEach$$forInline(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Unit> unit, Continuation<? super Unit> object) {
        try {
            ChannelIterator<E> channelIterator = receiveChannel.iterator();
            while (true) {
                InlineMarker.mark((int)3);
                InlineMarker.mark((int)0);
                object = channelIterator.hasNext(null);
                InlineMarker.mark((int)1);
                if (!((Boolean)object).booleanValue()) break;
                unit.invoke(channelIterator.next());
            }
            unit = Unit.INSTANCE;
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                InlineMarker.finallyStart((int)1);
                ChannelsKt.cancelConsumed(receiveChannel, throwable);
                InlineMarker.finallyEnd((int)1);
                throw throwable2;
            }
        }
        InlineMarker.finallyStart((int)1);
        ChannelsKt.cancelConsumed(receiveChannel, null);
        InlineMarker.finallyEnd((int)1);
        return Unit.INSTANCE;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Deprecated in the favour of 'onReceiveCatching'")
    public static final /* synthetic */ SelectClause1 onReceiveOrNull(ReceiveChannel receiveChannel) {
        Intrinsics.checkNotNull((Object)receiveChannel, (String)"null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.onReceiveOrNull?>");
        return receiveChannel.getOnReceiveOrNull();
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Deprecated in the favour of 'receiveCatching'", replaceWith=@ReplaceWith(expression="receiveCatching().getOrNull()", imports={}))
    public static final /* synthetic */ Object receiveOrNull(ReceiveChannel receiveChannel, Continuation continuation) {
        Intrinsics.checkNotNull((Object)receiveChannel, (String)"null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.receiveOrNull?>");
        return receiveChannel.receiveOrNull(continuation);
    }

    /*
     * Exception decompiling
     */
    public static final <E> Object toList(ReceiveChannel<? extends E> var0, Continuation<? super List<? extends E>> var1_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 2[TRYBLOCK] [2 : 220->227)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
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
}

