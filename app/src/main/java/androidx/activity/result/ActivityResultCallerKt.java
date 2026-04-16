/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 */
package androidx.activity.result;

import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultCallerKt$$ExternalSyntheticLambda0;
import androidx.activity.result.ActivityResultCallerKt$$ExternalSyntheticLambda1;
import androidx.activity.result.ActivityResultCallerLauncher;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aQ\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u00072\u0006\u0010\b\u001a\u0002H\u00032\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00020\n\u00a2\u0006\u0002\u0010\u000b\u001aY\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u00072\u0006\u0010\b\u001a\u0002H\u00032\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00020\n\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u000f"}, d2={"registerForActivityResult", "Landroidx/activity/result/ActivityResultLauncher;", "", "I", "O", "Landroidx/activity/result/ActivityResultCaller;", "contract", "Landroidx/activity/result/contract/ActivityResultContract;", "input", "callback", "Lkotlin/Function1;", "(Landroidx/activity/result/ActivityResultCaller;Landroidx/activity/result/contract/ActivityResultContract;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Landroidx/activity/result/ActivityResultLauncher;", "registry", "Landroidx/activity/result/ActivityResultRegistry;", "(Landroidx/activity/result/ActivityResultCaller;Landroidx/activity/result/contract/ActivityResultContract;Ljava/lang/Object;Landroidx/activity/result/ActivityResultRegistry;Lkotlin/jvm/functions/Function1;)Landroidx/activity/result/ActivityResultLauncher;", "activity-ktx_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class ActivityResultCallerKt {
    public static /* synthetic */ void $r8$lambda$7lLdjm1L5OSJIz1pWP4kzityPws(Function1 function1, Object object) {
        ActivityResultCallerKt.registerForActivityResult$lambda$1(function1, object);
    }

    public static /* synthetic */ void $r8$lambda$SjF4PZlnE9fmKbolD64Sz5ghy6c(Function1 function1, Object object) {
        ActivityResultCallerKt.registerForActivityResult$lambda$0(function1, object);
    }

    public static final <I, O> ActivityResultLauncher<Unit> registerForActivityResult(ActivityResultCaller activityResultCaller, ActivityResultContract<I, O> activityResultContract, I i, ActivityResultRegistry activityResultRegistry, Function1<? super O, Unit> function1) {
        return new ActivityResultCallerLauncher<I, O>(activityResultCaller.registerForActivityResult(activityResultContract, activityResultRegistry, new ActivityResultCallerKt$$ExternalSyntheticLambda1(function1)), activityResultContract, i);
    }

    public static final <I, O> ActivityResultLauncher<Unit> registerForActivityResult(ActivityResultCaller activityResultCaller, ActivityResultContract<I, O> activityResultContract, I i, Function1<? super O, Unit> function1) {
        return new ActivityResultCallerLauncher<I, O>(activityResultCaller.registerForActivityResult(activityResultContract, new ActivityResultCallerKt$$ExternalSyntheticLambda0(function1)), activityResultContract, i);
    }

    private static final void registerForActivityResult$lambda$0(Function1 function1, Object object) {
        function1.invoke(object);
    }

    private static final void registerForActivityResult$lambda$1(Function1 function1, Object object) {
        function1.invoke(object);
    }
}

