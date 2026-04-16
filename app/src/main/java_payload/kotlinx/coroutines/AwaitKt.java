/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 */
package kotlinx.coroutines;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.AwaitAll;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u0000*\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u001e\u0010\u0003\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004\"\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u001a%\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0004\"\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u001a\u001b\u0010\u0007\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\n0\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2={"awaitAll", "", "T", "deferreds", "", "Lkotlinx/coroutines/Deferred;", "([Lkotlinx/coroutines/Deferred;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinAll", "", "jobs", "Lkotlinx/coroutines/Job;", "([Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class AwaitKt {
    public static final <T> Object awaitAll(Collection<? extends Deferred<? extends T>> collection, Continuation<? super List<? extends T>> continuation) {
        if (collection.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        return new AwaitAll(collection.toArray(new Deferred[0])).await(continuation);
    }

    public static final <T> Object awaitAll(Deferred<? extends T>[] deferredArray, Continuation<? super List<? extends T>> continuation) {
        boolean bl = deferredArray.length == 0;
        if (bl) {
            return CollectionsKt.emptyList();
        }
        return new AwaitAll<T>(deferredArray).await(continuation);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final Object joinAll(Collection<? extends Job> var0, Continuation<? super Unit> var1_1) {
        if (!(var1_1 /* !! */  instanceof joinAll.3)) ** GOTO lbl-1000
        var2_2 /* !! */  = var1_1 /* !! */ ;
        if ((var2_2 /* !! */ .label & -2147483648) != 0) {
            var2_2 /* !! */ .label += -2147483648;
            var1_1 /* !! */  = var2_2 /* !! */ ;
        } else lbl-1000:
        // 2 sources

        {
            var1_1 /* !! */  = new ContinuationImpl(var1_1 /* !! */ ){
                Object L$0;
                int label;
                Object result;

                public final Object invokeSuspend(Object object) {
                    this.result = object;
                    this.label |= Integer.MIN_VALUE;
                    return AwaitKt.joinAll(null, (Continuation<? super Unit>)((Continuation)this));
                }
            };
        }
        var3_3 = var1_1 /* !! */ .result;
        var2_2 /* !! */  = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (var1_1 /* !! */ .label) {
            default: {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            case 1: {
                var0 = (Iterator)var1_1 /* !! */ .L$0;
                ResultKt.throwOnFailure((Object)var3_3);
                break;
            }
            case 0: {
                ResultKt.throwOnFailure((Object)var3_3);
                var0 = ((Iterable)var0).iterator();
            }
        }
        while (var0.hasNext()) {
            var3_3 = (Job)var0.next();
            var1_1 /* !! */ .L$0 = var0;
            var1_1 /* !! */ .label = 1;
            if (var3_3.join(var1_1 /* !! */ ) != var2_2 /* !! */ ) continue;
            return var2_2 /* !! */ ;
        }
        return Unit.INSTANCE;
    }

    /*
     * Exception decompiling
     */
    public static final Object joinAll(Job[] var0, Continuation<? super Unit> var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[SWITCH], 3[CASE]], but top level block is 4[WHILELOOP]
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
}

