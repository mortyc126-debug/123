/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 */
package kotlinx.coroutines.selects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectKt;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0011\u0010\t\u001a\u00028\u0000H\u0091@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0002J3\u0010\r\u001a\u00020\f*\u00020\u000e2\u001c\u0010\u000f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0010H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013JE\u0010\r\u001a\u00020\f\"\u0004\b\u0001\u0010\u0014*\b\u0012\u0004\u0012\u0002H\u00140\u00152\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0016H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017JY\u0010\r\u001a\u00020\f\"\u0004\b\u0001\u0010\u0018\"\u0004\b\u0002\u0010\u0014*\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u00140\u00192\u0006\u0010\u001a\u001a\u0002H\u00182\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0016H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bR\u001e\u0010\u0006\u001a\u0012\u0012\u000e\u0012\f0\bR\b\u0012\u0004\u0012\u00028\u00000\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2={"Lkotlinx/coroutines/selects/UnbiasedSelectImplementation;", "R", "Lkotlinx/coroutines/selects/SelectImplementation;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "clausesToRegister", "", "Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "doSelect", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shuffleAndRegisterClauses", "", "invoke", "Lkotlinx/coroutines/selects/SelectClause0;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", "param", "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public class UnbiasedSelectImplementation<R>
extends SelectImplementation<R> {
    private final List<SelectImplementation.ClauseData> clausesToRegister = new ArrayList();

    public UnbiasedSelectImplementation(CoroutineContext coroutineContext) {
        super(coroutineContext);
    }

    static /* synthetic */ <R> Object doSelect$suspendImpl(UnbiasedSelectImplementation<R> unbiasedSelectImplementation, Continuation<? super R> continuation) {
        super.shuffleAndRegisterClauses();
        return super.doSelect(continuation);
    }

    private final void shuffleAndRegisterClauses() {
        try {
            Collections.shuffle(this.clausesToRegister);
            for (SelectImplementation.ClauseData clauseData : (Iterable)this.clausesToRegister) {
                SelectImplementation.register$default(this, clauseData, false, 1, null);
            }
            return;
        }
        finally {
            this.clausesToRegister.clear();
        }
    }

    @Override
    public Object doSelect(Continuation<? super R> continuation) {
        return UnbiasedSelectImplementation.doSelect$suspendImpl(this, continuation);
    }

    @Override
    public void invoke(SelectClause0 selectClause0, Function1<? super Continuation<? super R>, ? extends Object> function1) {
        ((Collection)this.clausesToRegister).add(new SelectImplementation.ClauseData(this, selectClause0.getClauseObject(), selectClause0.getRegFunc(), selectClause0.getProcessResFunc(), SelectKt.getPARAM_CLAUSE_0(), function1, selectClause0.getOnCancellationConstructor()));
    }

    @Override
    public <Q> void invoke(SelectClause1<? extends Q> selectClause1, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        ((Collection)this.clausesToRegister).add(new SelectImplementation.ClauseData(this, selectClause1.getClauseObject(), selectClause1.getRegFunc(), selectClause1.getProcessResFunc(), null, function2, selectClause1.getOnCancellationConstructor()));
    }

    @Override
    public <P, Q> void invoke(SelectClause2<? super P, ? extends Q> selectClause2, P p, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        ((Collection)this.clausesToRegister).add(new SelectImplementation.ClauseData(this, selectClause2.getClauseObject(), selectClause2.getRegFunc(), selectClause2.getProcessResFunc(), p, function2, selectClause2.getOnCancellationConstructor()));
    }
}

