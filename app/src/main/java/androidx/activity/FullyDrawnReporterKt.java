/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.InlineMarker
 */
package androidx.activity;

import androidx.activity.FullyDrawnReporter;
import androidx.activity.FullyDrawnReporterKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;

@Metadata(d1={"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u001c\u0010\u0003\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\b"}, d2={"reportWhenComplete", "", "Landroidx/activity/FullyDrawnReporter;", "reporter", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Landroidx/activity/FullyDrawnReporter;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "activity_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class FullyDrawnReporterKt {
    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final Object reportWhenComplete(FullyDrawnReporter var0, Function1<? super Continuation<? super Unit>, ? extends Object> var1_1, Continuation<? super Unit> var2_5) {
        block11: {
            if (!(var2_5 /* !! */  instanceof reportWhenComplete.1)) ** GOTO lbl-1000
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
                        return FullyDrawnReporterKt.reportWhenComplete(null, null, (Continuation<? super Unit>)((Continuation)this));
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
                    var0 = (FullyDrawnReporter)var2_5 /* !! */ .L$0;
                    try {
                        ResultKt.throwOnFailure((Object)var4_7);
                        break;
                    }
                    catch (Throwable var1_2) {
                        break block11;
                    }
                }
                case 0: {
                    ResultKt.throwOnFailure((Object)var4_7);
                    var0.addReporter();
                    if (var0.isFullyDrawnReported()) {
                        return Unit.INSTANCE;
                    }
                    var2_5 /* !! */ .L$0 = var0;
                    var2_5 /* !! */ .label = 1;
                    var1_1 /* !! */  = var1_1 /* !! */ .invoke(var2_5 /* !! */ );
                    if (var1_1 /* !! */  != var3_6 /* !! */ ) break;
                    return var3_6 /* !! */ ;
                }
            }
            InlineMarker.finallyStart((int)1);
            var0.removeReporter();
            InlineMarker.finallyEnd((int)1);
            return Unit.INSTANCE;
            catch (Throwable var1_3) {
                // empty catch block
            }
        }
        InlineMarker.finallyStart((int)1);
        var0.removeReporter();
        InlineMarker.finallyEnd((int)1);
        throw var1_4;
    }

    private static final Object reportWhenComplete$$forInline(FullyDrawnReporter fullyDrawnReporter, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) {
        fullyDrawnReporter.addReporter();
        if (fullyDrawnReporter.isFullyDrawnReported()) {
            return Unit.INSTANCE;
        }
        try {
            function1.invoke(continuation);
            return Unit.INSTANCE;
        }
        finally {
            InlineMarker.finallyStart((int)1);
            fullyDrawnReporter.removeReporter();
            InlineMarker.finallyEnd((int)1);
        }
    }
}

