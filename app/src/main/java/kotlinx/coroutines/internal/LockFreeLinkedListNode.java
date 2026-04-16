/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference0Impl
 */
package kotlinx.coroutines.internal;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.AtomicOp;
import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.Removed;

@Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001:\u00010B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0000j\u0002`\u000fJ%\u0010\u0017\u001a\u00020\t2\n\u0010\u0016\u001a\u00060\u0000j\u0002`\u000f2\u000e\b\u0004\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0019H\u0086\bJ \u0010\u001a\u001a\u00020\t2\n\u0010\u0016\u001a\u00060\u0000j\u0002`\u000f2\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u000fH\u0001J\u0012\u0010\u001b\u001a\u00020\t2\n\u0010\u0016\u001a\u00060\u0000j\u0002`\u000fJ\u001b\u0010\u001c\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0082\u0010J\u0019\u0010\u001f\u001a\u00060\u0000j\u0002`\u000f2\n\u0010 \u001a\u00060\u0000j\u0002`\u000fH\u0082\u0010J\u0014\u0010!\u001a\u00020\u00152\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u000fH\u0002J%\u0010\"\u001a\u00020#2\n\u0010\u0016\u001a\u00060\u0000j\u0002`\u000f2\u000e\b\u0004\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0019H\u0081\bJ\u0010\u0010$\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u000fH\u0014J\b\u0010%\u001a\u00020\tH\u0016J\u0010\u0010&\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u000fH\u0001J\b\u0010'\u001a\u00020\u0007H\u0002J\b\u0010(\u001a\u00020)H\u0016J(\u0010*\u001a\u00020+2\n\u0010\u0016\u001a\u00060\u0000j\u0002`\u000f2\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u000f2\u0006\u0010,\u001a\u00020#H\u0001J%\u0010-\u001a\u00020\u00152\n\u0010.\u001a\u00060\u0000j\u0002`\u000f2\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u000fH\u0000\u00a2\u0006\u0002\b/R\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004R\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004X\u0082\u0004R\u0011\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004X\u0082\u0004R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0015\u0010\u000e\u001a\u00060\u0000j\u0002`\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0012\u001a\u00060\u0000j\u0002`\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011\u00a8\u00061"}, d2={"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "", "()V", "_next", "Lkotlinx/atomicfu/AtomicRef;", "_prev", "_removedRef", "Lkotlinx/coroutines/internal/Removed;", "isRemoved", "", "()Z", "next", "getNext", "()Ljava/lang/Object;", "nextNode", "Lkotlinx/coroutines/internal/Node;", "getNextNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "prevNode", "getPrevNode", "addLast", "", "node", "addLastIf", "condition", "Lkotlin/Function0;", "addNext", "addOneIfEmpty", "correctPrev", "op", "Lkotlinx/coroutines/internal/OpDescriptor;", "findPrevNonRemoved", "current", "finishAdd", "makeCondAddOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "nextIfRemoved", "remove", "removeOrNext", "removed", "toString", "", "tryCondAddNext", "", "condAdd", "validateNode", "prev", "validateNode$kotlinx_coroutines_core", "CondAddOp", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public class LockFreeLinkedListNode {
    private static final AtomicReferenceFieldUpdater _next$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next");
    private static final AtomicReferenceFieldUpdater _prev$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev");
    private static final AtomicReferenceFieldUpdater _removedRef$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef");
    @Volatile
    private volatile Object _next = this;
    @Volatile
    private volatile Object _prev = this;
    @Volatile
    private volatile Object _removedRef;

    /*
     * Unable to fully structure code
     */
    private final LockFreeLinkedListNode correctPrev(OpDescriptor var1_1) {
        block0: while (true) {
            var2_2 = var4_4 = (LockFreeLinkedListNode)LockFreeLinkedListNode._prev$FU.get(this);
            var3_3 = null;
            while (true) {
                if ((var5_5 = LockFreeLinkedListNode._next$FU.get(var2_2)) == this) {
                    if (var4_4 == var2_2) {
                        return var2_2;
                    }
                    if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(LockFreeLinkedListNode._prev$FU, this, var4_4, var2_2)) continue block0;
                    return var2_2;
                }
                if (this.isRemoved()) {
                    return null;
                }
                if (var5_5 == var1_1) {
                    return var2_2;
                }
                if (var5_5 instanceof OpDescriptor) {
                    ((OpDescriptor)var5_5).perform(var2_2);
                    continue block0;
                }
                if (var5_5 instanceof Removed) {
                    if (var3_3 != null) {
                        if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(LockFreeLinkedListNode._next$FU, var3_3, var2_2, ((Removed)var5_5).ref)) ** break;
                        continue block0;
                        var2_2 = var3_3;
                        var3_3 = null;
                        continue;
                    }
                    var2_2 = (LockFreeLinkedListNode)LockFreeLinkedListNode._prev$FU.get(var2_2);
                    continue;
                }
                var3_3 = var2_2;
                Intrinsics.checkNotNull(var5_5, (String)"null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
                var2_2 = (LockFreeLinkedListNode)var5_5;
            }
            break;
        }
    }

    private final LockFreeLinkedListNode findPrevNonRemoved(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.isRemoved()) {
            lockFreeLinkedListNode = (LockFreeLinkedListNode)_prev$FU.get(lockFreeLinkedListNode);
        }
        return lockFreeLinkedListNode;
    }

    private final void finishAdd(LockFreeLinkedListNode lockFreeLinkedListNode) {
        LockFreeLinkedListNode lockFreeLinkedListNode2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _prev$FU;
        do {
            lockFreeLinkedListNode2 = (LockFreeLinkedListNode)atomicReferenceFieldUpdater.get(lockFreeLinkedListNode);
            if (this.getNext() == lockFreeLinkedListNode) continue;
            return;
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_prev$FU, lockFreeLinkedListNode, lockFreeLinkedListNode2, this));
        if (this.isRemoved()) {
            lockFreeLinkedListNode.correctPrev(null);
        }
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function1, Object object) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(object));
        }
    }

    private final Removed removed() {
        Removed removed;
        Removed removed2 = removed = (Removed)_removedRef$FU.get(this);
        if (removed == null) {
            removed2 = new Removed(this);
            _removedRef$FU.lazySet(this, removed2);
        }
        return removed2;
    }

    public final void addLast(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (!this.getPrevNode().addNext(lockFreeLinkedListNode, this)) {
        }
    }

    public final boolean addLastIf(LockFreeLinkedListNode lockFreeLinkedListNode, Function0<Boolean> object) {
        object = new CondAddOp(lockFreeLinkedListNode, (Function0<Boolean>)object){
            final Function0<Boolean> $condition;
            {
                this.$condition = function0;
                super(lockFreeLinkedListNode);
            }

            public Object prepare(LockFreeLinkedListNode object) {
                object = (Boolean)this.$condition.invoke() != false ? null : LockFreeLinkedListKt.getCONDITION_FALSE();
                return object;
            }
        };
        block4: while (true) {
            switch (this.getPrevNode().tryCondAddNext(lockFreeLinkedListNode, this, (CondAddOp)object)) {
                default: {
                    continue block4;
                }
                case 2: {
                    return false;
                }
                case 1: 
            }
            break;
        }
        return true;
    }

    public final boolean addNext(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
        _prev$FU.lazySet(lockFreeLinkedListNode, this);
        _next$FU.lazySet(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_next$FU, this, lockFreeLinkedListNode2, lockFreeLinkedListNode)) {
            return false;
        }
        lockFreeLinkedListNode.finishAdd(lockFreeLinkedListNode2);
        return true;
    }

    public final boolean addOneIfEmpty(LockFreeLinkedListNode lockFreeLinkedListNode) {
        _prev$FU.lazySet(lockFreeLinkedListNode, this);
        _next$FU.lazySet(lockFreeLinkedListNode, this);
        do {
            if (this.getNext() == this) continue;
            return false;
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_next$FU, this, this, lockFreeLinkedListNode));
        lockFreeLinkedListNode.finishAdd(this);
        return true;
    }

    public final Object getNext() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _next$FU;
        Object v;
        while ((v = atomicReferenceFieldUpdater.get(this)) instanceof OpDescriptor) {
            ((OpDescriptor)v).perform(this);
        }
        return v;
    }

    public final LockFreeLinkedListNode getNextNode() {
        return LockFreeLinkedListKt.unwrap(this.getNext());
    }

    public final LockFreeLinkedListNode getPrevNode() {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        LockFreeLinkedListNode lockFreeLinkedListNode2 = lockFreeLinkedListNode = this.correctPrev(null);
        if (lockFreeLinkedListNode == null) {
            lockFreeLinkedListNode2 = this.findPrevNonRemoved((LockFreeLinkedListNode)_prev$FU.get(this));
        }
        return lockFreeLinkedListNode2;
    }

    public boolean isRemoved() {
        return this.getNext() instanceof Removed;
    }

    public final CondAddOp makeCondAddOp(LockFreeLinkedListNode lockFreeLinkedListNode, Function0<Boolean> function0) {
        return new /* invalid duplicate definition of identical inner class */;
    }

    protected LockFreeLinkedListNode nextIfRemoved() {
        Object object = this.getNext();
        boolean bl = object instanceof Removed;
        LockFreeLinkedListNode lockFreeLinkedListNode = null;
        object = bl ? (Removed)object : null;
        if (object != null) {
            lockFreeLinkedListNode = ((Removed)object).ref;
        }
        return lockFreeLinkedListNode;
    }

    public boolean remove() {
        boolean bl = this.removeOrNext() == null;
        return bl;
    }

    public final LockFreeLinkedListNode removeOrNext() {
        Removed removed;
        Object object;
        do {
            if ((object = this.getNext()) instanceof Removed) {
                return ((Removed)object).ref;
            }
            if (object == this) {
                return (LockFreeLinkedListNode)object;
            }
            Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_next$FU, this, object, removed = ((LockFreeLinkedListNode)object).removed()));
        ((LockFreeLinkedListNode)object).correctPrev(null);
        return null;
    }

    public String toString() {
        return new PropertyReference0Impl(this){

            public Object get() {
                return DebugStringsKt.getClassSimpleName(this.receiver);
            }
        } + '@' + DebugStringsKt.getHexAddress(this);
    }

    public final int tryCondAddNext(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2, CondAddOp condAddOp) {
        _prev$FU.lazySet(lockFreeLinkedListNode, this);
        _next$FU.lazySet(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        condAddOp.oldNext = lockFreeLinkedListNode2;
        if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_next$FU, this, lockFreeLinkedListNode2, condAddOp)) {
            return 0;
        }
        int n = condAddOp.perform(this) == null ? 1 : 2;
        return n;
    }

    public final void validateNode$kotlinx_coroutines_core(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
        boolean bl;
        boolean bl2 = DebugKt.getASSERTIONS_ENABLED();
        boolean bl3 = true;
        if (bl2 && !(bl = lockFreeLinkedListNode == _prev$FU.get(this))) {
            throw new AssertionError();
        }
        if (DebugKt.getASSERTIONS_ENABLED() && !(bl = lockFreeLinkedListNode2 == _next$FU.get(this) ? bl3 : false)) {
            throw new AssertionError();
        }
    }

    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b!\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0011\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003\u00a2\u0006\u0002\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\u0002j\u0002`\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "newNode", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "oldNext", "complete", "", "affected", "failure", "", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
    public static abstract class CondAddOp
    extends AtomicOp<LockFreeLinkedListNode> {
        public final LockFreeLinkedListNode newNode;
        public LockFreeLinkedListNode oldNext;

        public CondAddOp(LockFreeLinkedListNode lockFreeLinkedListNode) {
            this.newNode = lockFreeLinkedListNode;
        }

        @Override
        public void complete(LockFreeLinkedListNode lockFreeLinkedListNode, Object object) {
            boolean bl = object == null;
            if ((object = bl ? this.newNode : this.oldNext) != null && AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_next$FU, lockFreeLinkedListNode, this, object) && bl) {
                object = this.newNode;
                lockFreeLinkedListNode = this.oldNext;
                Intrinsics.checkNotNull((Object)lockFreeLinkedListNode);
                ((LockFreeLinkedListNode)object).finishAdd(lockFreeLinkedListNode);
            }
        }
    }
}

