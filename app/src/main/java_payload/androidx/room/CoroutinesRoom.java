/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.CancellationSignal
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.ContinuationInterceptor
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.room;

import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.CoroutinesRoomKt;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.TransactionElement;
import androidx.sqlite.db.SupportSQLiteCompat;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2={"Landroidx/room/CoroutinesRoom;", "", "()V", "Companion", "room-ktx_release"}, k=1, mv={1, 7, 1}, xi=48)
public final class CoroutinesRoom {
    public static final Companion Companion = new Companion(null);

    private CoroutinesRoom() {
    }

    @JvmStatic
    public static final <R> Flow<R> createFlow(RoomDatabase roomDatabase, boolean bl, String[] stringArray, Callable<R> callable) {
        return Companion.createFlow(roomDatabase, bl, stringArray, callable);
    }

    @JvmStatic
    public static final <R> Object execute(RoomDatabase roomDatabase, boolean bl, CancellationSignal cancellationSignal, Callable<R> callable, Continuation<? super R> continuation) {
        return Companion.execute(roomDatabase, bl, cancellationSignal, callable, continuation);
    }

    @JvmStatic
    public static final <R> Object execute(RoomDatabase roomDatabase, boolean bl, Callable<R> callable, Continuation<? super R> continuation) {
        return Companion.execute(roomDatabase, bl, callable, continuation);
    }

    @Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JJ\u0010\u0003\u001a\r\u0012\t\u0012\u0007H\u0005\u00a2\u0006\u0002\b\u00060\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000fH\u0007\u00a2\u0006\u0002\u0010\u0010J=\u0010\u0011\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000fH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J5\u0010\u0011\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000fH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2={"Landroidx/room/CoroutinesRoom$Companion;", "", "()V", "createFlow", "Lkotlinx/coroutines/flow/Flow;", "R", "Lkotlin/jvm/JvmSuppressWildcards;", "db", "Landroidx/room/RoomDatabase;", "inTransaction", "", "tableNames", "", "", "callable", "Ljava/util/concurrent/Callable;", "(Landroidx/room/RoomDatabase;Z[Ljava/lang/String;Ljava/util/concurrent/Callable;)Lkotlinx/coroutines/flow/Flow;", "execute", "cancellationSignal", "Landroid/os/CancellationSignal;", "(Landroidx/room/RoomDatabase;ZLandroid/os/CancellationSignal;Ljava/util/concurrent/Callable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroidx/room/RoomDatabase;ZLjava/util/concurrent/Callable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "room-ktx_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final <R> Flow<R> createFlow(RoomDatabase roomDatabase, boolean bl, String[] stringArray, Callable<R> callable) {
            Intrinsics.checkNotNullParameter((Object)roomDatabase, (String)"db");
            Intrinsics.checkNotNullParameter((Object)stringArray, (String)"tableNames");
            Intrinsics.checkNotNullParameter(callable, (String)"callable");
            return FlowKt.flow((Function2)new Function2<FlowCollector<R>, Continuation<? super Unit>, Object>(bl, roomDatabase, stringArray, callable, null){
                final Callable<R> $callable;
                final RoomDatabase $db;
                final boolean $inTransaction;
                final String[] $tableNames;
                private Object L$0;
                int label;
                {
                    this.$inTransaction = bl;
                    this.$db = roomDatabase;
                    this.$tableNames = stringArray;
                    this.$callable = callable;
                    super(2, continuation);
                }

                public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                    object2 = new /* invalid duplicate definition of identical inner class */;
                    object2.L$0 = object;
                    return object2;
                }

                public final Object invoke(FlowCollector<R> flowCollector, Continuation<? super Unit> continuation) {
                    return (this.create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
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
                            object = (FlowCollector)this.L$0;
                            object = (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this.$inTransaction, this.$db, object, this.$tableNames, this.$callable, null){
                                final FlowCollector<R> $$this$flow;
                                final Callable<R> $callable;
                                final RoomDatabase $db;
                                final boolean $inTransaction;
                                final String[] $tableNames;
                                private Object L$0;
                                int label;
                                {
                                    this.$inTransaction = bl;
                                    this.$db = roomDatabase;
                                    this.$$this$flow = flowCollector;
                                    this.$tableNames = stringArray;
                                    this.$callable = callable;
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

                                /*
                                 * WARNING - void declaration
                                 * Enabled aggressive block sorting
                                 */
                                public final Object invokeSuspend(Object object) {
                                    void var1_9;
                                    InvalidationTracker.Observer observer2;
                                    Channel channel;
                                    CoroutineScope coroutineScope;
                                    Object object2;
                                    block10: {
                                        void var1_7;
                                        block9: {
                                            ContinuationInterceptor continuationInterceptor;
                                            object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            switch (this.label) {
                                                default: {
                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                }
                                                case 1: {
                                                    ResultKt.throwOnFailure(object);
                                                    return Unit.INSTANCE;
                                                }
                                                case 0: 
                                            }
                                            ResultKt.throwOnFailure(object);
                                            coroutineScope = (CoroutineScope)this.L$0;
                                            channel = ChannelKt.Channel$default(-1, null, null, 6, null);
                                            observer2 = new InvalidationTracker.Observer(this.$tableNames, channel){
                                                final Channel<Unit> $observerChannel;
                                                {
                                                    this.$observerChannel = channel;
                                                    super(stringArray);
                                                }

                                                public void onInvalidated(Set<String> set) {
                                                    Intrinsics.checkNotNullParameter(set, (String)"tables");
                                                    this.$observerChannel.trySend-JP2dKIU(Unit.INSTANCE);
                                                }
                                            };
                                            channel.trySend-JP2dKIU(Unit.INSTANCE);
                                            TransactionElement transactionElement = (TransactionElement)coroutineScope.getCoroutineContext().get((CoroutineContext.Key)TransactionElement.Key);
                                            if (transactionElement == null) break block9;
                                            ContinuationInterceptor continuationInterceptor2 = continuationInterceptor = transactionElement.getTransactionDispatcher$room_ktx_release();
                                            if (continuationInterceptor != null) break block10;
                                        }
                                        if (this.$inTransaction) {
                                            CoroutineDispatcher coroutineDispatcher = CoroutinesRoomKt.getTransactionDispatcher(this.$db);
                                        } else {
                                            CoroutineDispatcher coroutineDispatcher = CoroutinesRoomKt.getQueryDispatcher(this.$db);
                                        }
                                        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor)var1_7;
                                    }
                                    Channel channel2 = ChannelKt.Channel$default(0, null, null, 7, null);
                                    BuildersKt.launch$default(coroutineScope, (CoroutineContext)var1_9, null, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this.$db, observer2, (Channel<Unit>)channel, this.$callable, channel2, null){
                                        final Callable<R> $callable;
                                        final RoomDatabase $db;
                                        final createFlow.observer.1 $observer;
                                        final Channel<Unit> $observerChannel;
                                        final Channel<R> $resultChannel;
                                        Object L$0;
                                        int label;
                                        {
                                            this.$db = roomDatabase;
                                            this.$observer = var2_2;
                                            this.$observerChannel = channel;
                                            this.$callable = callable;
                                            this.$resultChannel = channel2;
                                            super(2, continuation);
                                        }

                                        public final Continuation<Unit> create(Object object, Continuation<?> continuation) {
                                            return (Continuation)new /* invalid duplicate definition of identical inner class */;
                                        }

                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }

                                        /*
                                         * Exception decompiling
                                         */
                                        public final Object invokeSuspend(Object var1_1) {
                                            /*
                                             * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                                             * 
                                             * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [8[SWITCH], 12[CASE]], but top level block is 15[UNCONDITIONALDOLOOP]
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
                                             *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.CastExpression.dumpInner(CastExpression.java:114)
                                             *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                                             *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                                             *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                                             *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.StaticFunctionInvokation.dumpInner(StaticFunctionInvokation.java:143)
                                             *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                                             *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                                             *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                                             *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredExpressionStatement.dump(StructuredExpressionStatement.java:29)
                                             *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                                             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                                             *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.dump(Block.java:564)
                                             *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                                             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                                             *     at org.benf.cfr.reader.entities.attributes.AttributeCode.dump(AttributeCode.java:135)
                                             *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                                             *     at org.benf.cfr.reader.entities.Method.dump(Method.java:627)
                                             *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperAnonymousInner.dumpWithArgs(ClassFileDumperAnonymousInner.java:87)
                                             *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.ConstructorInvokationAnonymousInner.dumpInner(ConstructorInvokationAnonymousInner.java:82)
                                             *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                                             *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.CastExpression.dumpInner(CastExpression.java:114)
                                             *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                                             *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                                             *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                                             *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredAssignment.dump(StructuredAssignment.java:69)
                                             *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                                             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                                             *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.dump(Block.java:564)
                                             *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                                             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                                             *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredCase.dump(StructuredCase.java:94)
                                             *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                                             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                                             *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.dump(Block.java:564)
                                             *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                                             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                                             *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredSwitch.dump(StructuredSwitch.java:59)
                                             *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                                             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                                             *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.dump(Block.java:564)
                                             *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                                             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                                             *     at org.benf.cfr.reader.entities.attributes.AttributeCode.dump(AttributeCode.java:135)
                                             *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                                             *     at org.benf.cfr.reader.entities.Method.dump(Method.java:627)
                                             *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperAnonymousInner.dumpWithArgs(ClassFileDumperAnonymousInner.java:87)
                                             *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.ConstructorInvokationAnonymousInner.dumpInner(ConstructorInvokationAnonymousInner.java:82)
                                             *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                                             *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.CastExpression.dumpInner(CastExpression.java:114)
                                             *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                                             *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                                             *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                                             *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.StaticFunctionInvokation.dumpInner(StaticFunctionInvokation.java:143)
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
                                             *     at org.benf.cfr.reader.entities.ClassFile.dumpNamedInnerClasses(ClassFile.java:1161)
                                             *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperNormal.dump(ClassFileDumperNormal.java:71)
                                             *     at org.benf.cfr.reader.entities.ClassFile.dump(ClassFile.java:1167)
                                             *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:952)
                                             *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
                                             *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
                                             *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
                                             *     at org.benf.cfr.reader.Main.main(Main.java:54)
                                             */
                                            throw new IllegalStateException("Decompilation failed");
                                        }
                                    }, 2, null);
                                    FlowCollector<R> flowCollector = this.$$this$flow;
                                    ReceiveChannel receiveChannel = channel2;
                                    observer2 = (Continuation)this;
                                    this.label = 1;
                                    if (FlowKt.emitAll(flowCollector, receiveChannel, (Continuation<? super Unit>)observer2) != object2) return Unit.INSTANCE;
                                    return object2;
                                }
                            };
                            Continuation continuation = (Continuation)this;
                            this.label = 1;
                            if (CoroutineScopeKt.coroutineScope(object, continuation) != object2) break;
                            return object2;
                        }
                    }
                    return Unit.INSTANCE;
                }
            });
        }

        @JvmStatic
        public final <R> Object execute(RoomDatabase object, boolean bl, CancellationSignal cancellationSignal, Callable<R> callable, Continuation<? super R> continuation) {
            Object object2;
            TransactionElement transactionElement;
            block6: {
                block5: {
                    if (object.isOpen() && object.inTransaction()) {
                        return callable.call();
                    }
                    transactionElement = (TransactionElement)continuation.getContext().get((CoroutineContext.Key)TransactionElement.Key);
                    if (transactionElement == null) break block5;
                    object2 = transactionElement.getTransactionDispatcher$room_ktx_release();
                    transactionElement = object2;
                    if (object2 != null) break block6;
                }
                object = bl ? CoroutinesRoomKt.getTransactionDispatcher(object) : CoroutinesRoomKt.getQueryDispatcher(object);
                transactionElement = (ContinuationInterceptor)object;
            }
            object = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            ((CancellableContinuationImpl)object).initCancellability();
            object2 = (CancellableContinuation)object;
            object2.invokeOnCancellation((Function1<? super Throwable, Unit>)((Function1)new Function1<Throwable, Unit>(cancellationSignal, BuildersKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext)transactionElement, null, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(callable, object2, null){
                final Callable<R> $callable;
                final CancellableContinuation<R> $continuation;
                int label;
                {
                    this.$callable = callable;
                    this.$continuation = cancellableContinuation;
                    super(2, continuation);
                }

                public final Continuation<Unit> create(Object object, Continuation<?> continuation) {
                    return (Continuation)new /* invalid duplicate definition of identical inner class */;
                }

                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                    try {
                        R r = this.$callable.call();
                        Continuation continuation = this.$continuation;
                        object = Result.Companion;
                        continuation.resumeWith(Result.constructor-impl(r));
                    }
                    catch (Throwable throwable) {
                        Continuation continuation = this.$continuation;
                        object = Result.Companion;
                        continuation.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable)));
                    }
                    return Unit.INSTANCE;
                }
            }, 2, null)){
                final CancellationSignal $cancellationSignal;
                final Job $job;
                {
                    this.$cancellationSignal = cancellationSignal;
                    this.$job = job2;
                    super(1);
                }

                public final void invoke(Throwable throwable) {
                    SupportSQLiteCompat.Api16Impl.cancel(this.$cancellationSignal);
                    Job.DefaultImpls.cancel$default(this.$job, null, 1, null);
                }
            }));
            object = ((CancellableContinuationImpl)object).getResult();
            if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return object;
        }

        @JvmStatic
        public final <R> Object execute(RoomDatabase object, boolean bl, Callable<R> callable, Continuation<? super R> continuation) {
            TransactionElement transactionElement;
            block5: {
                block4: {
                    if (object.isOpen() && object.inTransaction()) {
                        return callable.call();
                    }
                    transactionElement = (TransactionElement)continuation.getContext().get((CoroutineContext.Key)TransactionElement.Key);
                    if (transactionElement == null) break block4;
                    ContinuationInterceptor continuationInterceptor = transactionElement.getTransactionDispatcher$room_ktx_release();
                    transactionElement = continuationInterceptor;
                    if (continuationInterceptor != null) break block5;
                }
                object = bl ? CoroutinesRoomKt.getTransactionDispatcher(object) : CoroutinesRoomKt.getQueryDispatcher(object);
                transactionElement = (ContinuationInterceptor)object;
            }
            return BuildersKt.withContext((CoroutineContext)transactionElement, (Function2)new Function2<CoroutineScope, Continuation<? super R>, Object>(callable, null){
                final Callable<R> $callable;
                int label;
                {
                    this.$callable = callable;
                    super(2, continuation);
                }

                public final Continuation<Unit> create(Object object, Continuation<?> continuation) {
                    return (Continuation)new /* invalid duplicate definition of identical inner class */;
                }

                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
                    return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                    return this.$callable.call();
                }
            }, continuation);
        }
    }
}

