/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmInline
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0081@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0016\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003\u00a2\u0006\u0004\b\t\u0010\nJ$\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u000eH\u0086\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0086\u0002\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0088\u0001\u0003\u0092\u0001\u0004\u0018\u00010\u0002\u00f8\u0001\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001d"}, d2={"Lkotlinx/coroutines/internal/InlineList;", "E", "", "holder", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "equals", "", "other", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "forEachReversed", "", "action", "Lkotlin/Function1;", "forEachReversed-impl", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "hashCode", "", "hashCode-impl", "(Ljava/lang/Object;)I", "plus", "element", "plus-FjFbRPM", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
@JvmInline
public final class InlineList<E> {
    private final Object holder;

    private /* synthetic */ InlineList(Object object) {
        this.holder = object;
    }

    public static final /* synthetic */ InlineList box-impl(Object object) {
        return new InlineList(object);
    }

    public static <E> Object constructor-impl(Object object) {
        return object;
    }

    public static /* synthetic */ Object constructor-impl$default(Object object, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            object = null;
        }
        return InlineList.constructor-impl(object);
    }

    public static boolean equals-impl(Object object, Object object2) {
        if (!(object2 instanceof InlineList)) {
            return false;
        }
        return Intrinsics.areEqual((Object)object, (Object)((InlineList)object2).unbox-impl());
    }

    public static final boolean equals-impl0(Object object, Object object2) {
        return Intrinsics.areEqual((Object)object, (Object)object2);
    }

    public static final void forEachReversed-impl(Object object, Function1<? super E, Unit> function1) {
        if (object == null) {
            return;
        }
        if (!(object instanceof ArrayList)) {
            function1.invoke(object);
        } else {
            Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            object = (ArrayList)object;
            for (int i = ((ArrayList)object).size() - 1; -1 < i; --i) {
                function1.invoke(((ArrayList)object).get(i));
            }
        }
    }

    public static int hashCode-impl(Object object) {
        int n = object == null ? 0 : object.hashCode();
        return n;
    }

    public static final Object plus-FjFbRPM(Object object, E e) {
        if (DebugKt.getASSERTIONS_ENABLED() && !(e instanceof List ^ true)) {
            throw new AssertionError();
        }
        if (object == null) {
            object = InlineList.constructor-impl(e);
        } else if (object instanceof ArrayList) {
            Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ((ArrayList)object).add(e);
            object = InlineList.constructor-impl(object);
        } else {
            ArrayList<Object> arrayList = new ArrayList<Object>(4);
            arrayList.add(object);
            arrayList.add(e);
            object = InlineList.constructor-impl(arrayList);
        }
        return object;
    }

    public static String toString-impl(Object object) {
        return "InlineList(holder=" + object + ')';
    }

    public boolean equals(Object object) {
        return InlineList.equals-impl(this.holder, object);
    }

    public int hashCode() {
        return InlineList.hashCode-impl(this.holder);
    }

    public String toString() {
        return InlineList.toString-impl(this.holder);
    }

    public final /* synthetic */ Object unbox-impl() {
        return this.holder;
    }
}

