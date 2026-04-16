/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.AbstractCoroutineContextElement
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.ThreadContextElement;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0081\b\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0018B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\t\u001a\u00020\u0005H\u00c6\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0019"}, d2={"Lkotlinx/coroutines/CoroutineId;", "Lkotlinx/coroutines/ThreadContextElement;", "", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "id", "", "(J)V", "getId", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "toString", "updateThreadContext", "Key", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public final class CoroutineId
extends AbstractCoroutineContextElement
implements ThreadContextElement<String> {
    public static final Key Key = new Key(null);
    private final long id;

    public CoroutineId(long l) {
        super((CoroutineContext.Key)Key);
        this.id = l;
    }

    public static /* synthetic */ CoroutineId copy$default(CoroutineId coroutineId, long l, int n, Object object) {
        if ((n & 1) != 0) {
            l = coroutineId.id;
        }
        return coroutineId.copy(l);
    }

    public final long component1() {
        return this.id;
    }

    public final CoroutineId copy(long l) {
        return new CoroutineId(l);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof CoroutineId)) {
            return false;
        }
        object = (CoroutineId)object;
        return this.id == ((CoroutineId)object).id;
    }

    public final long getId() {
        return this.id;
    }

    public int hashCode() {
        return Long.hashCode(this.id);
    }

    @Override
    public void restoreThreadContext(CoroutineContext coroutineContext, String string2) {
        Thread.currentThread().setName(string2);
    }

    public String toString() {
        return "CoroutineId(" + this.id + ')';
    }

    @Override
    public String updateThreadContext(CoroutineContext object) {
        int n;
        Object object2;
        block5: {
            block4: {
                if ((object = (CoroutineName)object.get((CoroutineContext.Key)CoroutineName.Key)) == null) break block4;
                object = object2 = ((CoroutineName)((Object)object)).getName();
                if (object2 != null) break block5;
            }
            object = "coroutine";
        }
        object2 = Thread.currentThread();
        String string2 = ((Thread)object2).getName();
        int n2 = n = StringsKt.lastIndexOf$default((CharSequence)string2, (String)" @", (int)0, (boolean)false, (int)6, null);
        if (n < 0) {
            n2 = string2.length();
        }
        StringBuilder stringBuilder = new StringBuilder(((String)object).length() + n2 + 10);
        String string3 = string2.substring(0, n2);
        Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"this as java.lang.String\u2026ing(startIndex, endIndex)");
        stringBuilder.append(string3);
        stringBuilder.append(" @");
        stringBuilder.append((String)object);
        stringBuilder.append('#');
        stringBuilder.append(this.id);
        object = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"StringBuilder(capacity).\u2026builderAction).toString()");
        ((Thread)object2).setName((String)object);
        return string2;
    }

    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lkotlinx/coroutines/CoroutineId$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineId;", "()V", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class Key
    implements CoroutineContext.Key<CoroutineId> {
        private Key() {
        }

        public /* synthetic */ Key(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

