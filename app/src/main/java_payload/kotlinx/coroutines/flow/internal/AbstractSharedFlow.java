/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.Result$Companion
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.SubscriptionCountStateFlow;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u00060\u0003j\u0002`\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\r\u0010\u0017\u001a\u00028\u0000H\u0004\u00a2\u0006\u0002\u0010\u0018J\r\u0010\u0019\u001a\u00028\u0000H$\u00a2\u0006\u0002\u0010\u0018J\u001d\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000e2\u0006\u0010\u001b\u001a\u00020\tH$\u00a2\u0006\u0002\u0010\u001cJ\u001d\u0010\u001d\u001a\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001e0 H\u0084\bJ\u0015\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00028\u0000H\u0004\u00a2\u0006\u0002\u0010#R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0084\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R4\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u000e2\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u000e@BX\u0084\u000e\u00a2\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006$"}, d2={"Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "S", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "()V", "_subscriptionCount", "Lkotlinx/coroutines/flow/internal/SubscriptionCountStateFlow;", "<set-?>", "", "nCollectors", "getNCollectors", "()I", "nextIndex", "", "slots", "getSlots", "()[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "subscriptionCount", "Lkotlinx/coroutines/flow/StateFlow;", "getSubscriptionCount", "()Lkotlinx/coroutines/flow/StateFlow;", "allocateSlot", "()Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "createSlot", "createSlotArray", "size", "(I)[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "forEachSlotLocked", "", "block", "Lkotlin/Function1;", "freeSlot", "slot", "(Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;)V", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public abstract class AbstractSharedFlow<S extends AbstractSharedFlowSlot<?>> {
    private SubscriptionCountStateFlow _subscriptionCount;
    private int nCollectors;
    private int nextIndex;
    private S[] slots;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    protected final S allocateSlot() {
        int n;
        S s;
        // MONITORENTER : this
        Object object = this.slots;
        if (object == null) {
            object = this.createSlotArray(2);
            this.slots = object;
        } else if (this.nCollectors >= ((S[])object).length) {
            object = Arrays.copyOf(object, ((S[])object).length * 2);
            Intrinsics.checkNotNullExpressionValue(object, (String)"copyOf(this, newSize)");
            this.slots = (AbstractSharedFlowSlot[])object;
            object = (AbstractSharedFlowSlot[])object;
        }
        int n2 = this.nextIndex;
        do {
            S s2;
            s = s2 = object[n2];
            if (s2 == null) {
                object[n2] = s = this.createSlot();
            }
            n = ++n2;
            if (n2 >= ((S[])object).length) {
                n = 0;
            }
            Intrinsics.checkNotNull(s, (String)"null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
            n2 = n;
        } while (!((AbstractSharedFlowSlot)s).allocateLocked((AbstractSharedFlow)this));
        this.nextIndex = n;
        ++this.nCollectors;
        object = this._subscriptionCount;
        // MONITOREXIT : this
        if (object == null) return s;
        ((SubscriptionCountStateFlow)object).increment(1);
        return s;
    }

    protected abstract S createSlot();

    protected abstract S[] createSlotArray(int var1);

    protected final void forEachSlotLocked(Function1<? super S, Unit> function1) {
        if (this.nCollectors == 0) {
            return;
        }
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArray = this.slots;
        if (abstractSharedFlowSlotArray != null) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : abstractSharedFlowSlotArray) {
                if (abstractSharedFlowSlot == null) continue;
                function1.invoke((Object)abstractSharedFlowSlot);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected final void freeSlot(S object) {
        Continuation<Unit>[] continuationArray;
        int n;
        int n2;
        SubscriptionCountStateFlow subscriptionCountStateFlow;
        synchronized (this) {
            --this.nCollectors;
            subscriptionCountStateFlow = this._subscriptionCount;
            n2 = this.nCollectors;
            n = 0;
            if (n2 == 0) {
                this.nextIndex = 0;
            }
            Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
            continuationArray = ((AbstractSharedFlowSlot)object).freeLocked(this);
        }
        n2 = continuationArray.length;
        while (n < n2) {
            Continuation<Unit> continuation = continuationArray[n];
            if (continuation != null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.constructor-impl((Object)Unit.INSTANCE));
            }
            ++n;
        }
        if (subscriptionCountStateFlow != null) {
            subscriptionCountStateFlow.increment(-1);
        }
    }

    protected final int getNCollectors() {
        return this.nCollectors;
    }

    protected final S[] getSlots() {
        return this.slots;
    }

    public final StateFlow<Integer> getSubscriptionCount() {
        synchronized (this) {
            SubscriptionCountStateFlow subscriptionCountStateFlow;
            block4: {
                SubscriptionCountStateFlow subscriptionCountStateFlow2;
                subscriptionCountStateFlow = subscriptionCountStateFlow2 = this._subscriptionCount;
                if (subscriptionCountStateFlow2 != null) break block4;
                this._subscriptionCount = subscriptionCountStateFlow = new SubscriptionCountStateFlow(this.nCollectors);
            }
            return subscriptionCountStateFlow;
        }
    }
}

