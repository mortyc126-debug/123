/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Incomplete;
import kotlinx.coroutines.JobNode;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\r\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2={"Lkotlinx/coroutines/NodeList;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/Incomplete;", "()V", "isActive", "", "()Z", "list", "getList", "()Lkotlinx/coroutines/NodeList;", "getString", "", "state", "toString", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public final class NodeList
extends LockFreeLinkedListHead
implements Incomplete {
    @Override
    public NodeList getList() {
        return this;
    }

    public final String getString(String object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("List{");
        stringBuilder.append((String)object);
        stringBuilder.append("}[");
        boolean bl = true;
        LockFreeLinkedListHead lockFreeLinkedListHead = this;
        object = lockFreeLinkedListHead.getNext();
        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        object = (LockFreeLinkedListNode)object;
        while (!Intrinsics.areEqual((Object)object, (Object)lockFreeLinkedListHead)) {
            boolean bl2 = bl;
            if (object instanceof JobNode) {
                JobNode jobNode = (JobNode)object;
                if (bl) {
                    bl = false;
                } else {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(jobNode);
                bl2 = bl;
            }
            object = ((LockFreeLinkedListNode)object).getNextNode();
            bl = bl2;
        }
        stringBuilder.append("]");
        object = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"StringBuilder().apply(builderAction).toString()");
        return object;
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public String toString() {
        String string2 = DebugKt.getDEBUG() ? this.getString("Active") : super.toString();
        return string2;
    }
}

