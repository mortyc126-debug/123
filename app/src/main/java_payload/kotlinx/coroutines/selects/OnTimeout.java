/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.TypeIntrinsics
 */
package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.selects.OnTimeout;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectClause0Impl;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002R\u0017\u0010\u0005\u001a\u00020\u00068F\u00a2\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lkotlinx/coroutines/selects/OnTimeout;", "", "timeMillis", "", "(J)V", "selectClause", "Lkotlinx/coroutines/selects/SelectClause0;", "getSelectClause$annotations", "()V", "getSelectClause", "()Lkotlinx/coroutines/selects/SelectClause0;", "register", "", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "ignoredParam", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
final class OnTimeout {
    private final long timeMillis;

    public OnTimeout(long l) {
        this.timeMillis = l;
    }

    public static final /* synthetic */ void access$register(OnTimeout onTimeout, SelectInstance selectInstance, Object object) {
        onTimeout.register(selectInstance, object);
    }

    public static /* synthetic */ void getSelectClause$annotations() {
    }

    private final void register(SelectInstance<?> selectInstance, Object object) {
        if (this.timeMillis <= 0L) {
            selectInstance.selectInRegistrationPhase(Unit.INSTANCE);
            return;
        }
        object = new Runnable(selectInstance, this){
            final SelectInstance $select$inlined;
            final OnTimeout this$0;
            {
                this.$select$inlined = selectInstance;
                this.this$0 = onTimeout;
            }

            public final void run() {
                this.$select$inlined.trySelect(this.this$0, Unit.INSTANCE);
            }
        };
        Intrinsics.checkNotNull(selectInstance, (String)"null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        SelectImplementation selectImplementation = (SelectImplementation)selectInstance;
        selectImplementation = selectInstance.getContext();
        selectInstance.disposeOnCompletion(DelayKt.getDelay((CoroutineContext)selectImplementation).invokeOnTimeout(this.timeMillis, (Runnable)object, (CoroutineContext)selectImplementation));
    }

    public final SelectClause0 getSelectClause() {
        selectClause.1 var1_1 = selectClause.1.INSTANCE;
        Intrinsics.checkNotNull((Object)((Object)var1_1), (String)"null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new SelectClause0Impl(this, (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)((Object)var1_1), (int)3), null, 4, null);
    }
}

