/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J-\u0010\u0007\u001a\u00020\b\"\u000e\b\u0000\u0010\t\u0018\u0001*\u00060\u0001j\u0002`\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\b0\fH\u0086\bJ\u0010\u0010\r\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\nH\u0014J\u0006\u0010\u000e\u001a\u00020\u000fJ\r\u0010\u0010\u001a\u00020\bH\u0000\u00a2\u0006\u0002\b\u0011R\u0011\u0010\u0003\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0005\u00a8\u0006\u0012"}, d2={"Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "()V", "isEmpty", "", "()Z", "isRemoved", "forEach", "", "T", "Lkotlinx/coroutines/internal/Node;", "block", "Lkotlin/Function1;", "nextIfRemoved", "remove", "", "validate", "validate$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public class LockFreeLinkedListHead
extends LockFreeLinkedListNode {
    public final /* synthetic */ <T extends LockFreeLinkedListNode> void forEach(Function1<? super T, Unit> function1) {
        Object object = this.getNext();
        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        object = (LockFreeLinkedListNode)object;
        while (!Intrinsics.areEqual((Object)object, (Object)this)) {
            Intrinsics.reifiedOperationMarker((int)3, (String)"T");
            if (object instanceof LockFreeLinkedListNode) {
                function1.invoke(object);
            }
            object = ((LockFreeLinkedListNode)object).getNextNode();
        }
    }

    public final boolean isEmpty() {
        boolean bl = this.getNext() == this;
        return bl;
    }

    @Override
    public boolean isRemoved() {
        return false;
    }

    @Override
    protected LockFreeLinkedListNode nextIfRemoved() {
        return null;
    }

    public final Void remove() {
        throw new IllegalStateException("head cannot be removed".toString());
    }

    public final void validate$kotlinx_coroutines_core() {
        Object object = this;
        Object object2 = this.getNext();
        Intrinsics.checkNotNull((Object)object2, (String)"null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        object2 = (LockFreeLinkedListNode)object2;
        while (!Intrinsics.areEqual((Object)object2, (Object)this)) {
            LockFreeLinkedListNode lockFreeLinkedListNode = ((LockFreeLinkedListNode)object2).getNextNode();
            ((LockFreeLinkedListNode)object2).validateNode$kotlinx_coroutines_core((LockFreeLinkedListNode)object, lockFreeLinkedListNode);
            object = object2;
            object2 = lockFreeLinkedListNode;
        }
        object2 = this.getNext();
        Intrinsics.checkNotNull((Object)object2, (String)"null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        this.validateNode$kotlinx_coroutines_core((LockFreeLinkedListNode)object, (LockFreeLinkedListNode)object2);
    }
}

