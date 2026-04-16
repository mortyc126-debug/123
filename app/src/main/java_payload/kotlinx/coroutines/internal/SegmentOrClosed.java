/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmInline
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.Segment;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0081@\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0014\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u0010\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u00d6\u0003\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001\u00a2\u0006\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\u00028\u00008F\u00a2\u0006\f\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0088\u0001\u0004\u0092\u0001\u0004\u0018\u00010\u0003\u00f8\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2={"Lkotlinx/coroutines/internal/SegmentOrClosed;", "S", "Lkotlinx/coroutines/internal/Segment;", "", "value", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "isClosed", "", "isClosed-impl", "(Ljava/lang/Object;)Z", "segment", "getSegment$annotations", "()V", "getSegment-impl", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/Segment;", "equals", "other", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/Object;)I", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
@JvmInline
public final class SegmentOrClosed<S extends Segment<S>> {
    private final Object value;

    private /* synthetic */ SegmentOrClosed(Object object) {
        this.value = object;
    }

    public static final /* synthetic */ SegmentOrClosed box-impl(Object object) {
        return new SegmentOrClosed(object);
    }

    public static <S extends Segment<S>> Object constructor-impl(Object object) {
        return object;
    }

    public static boolean equals-impl(Object object, Object object2) {
        if (!(object2 instanceof SegmentOrClosed)) {
            return false;
        }
        return Intrinsics.areEqual((Object)object, (Object)((SegmentOrClosed)object2).unbox-impl());
    }

    public static final boolean equals-impl0(Object object, Object object2) {
        return Intrinsics.areEqual((Object)object, (Object)object2);
    }

    public static /* synthetic */ void getSegment$annotations() {
    }

    public static final S getSegment-impl(Object object) {
        if (object != ConcurrentLinkedListKt.access$getCLOSED$p()) {
            Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
            return (Segment)object;
        }
        throw new IllegalStateException("Does not contain segment".toString());
    }

    public static int hashCode-impl(Object object) {
        int n = object == null ? 0 : object.hashCode();
        return n;
    }

    public static final boolean isClosed-impl(Object object) {
        boolean bl = object == ConcurrentLinkedListKt.access$getCLOSED$p();
        return bl;
    }

    public static String toString-impl(Object object) {
        return "SegmentOrClosed(value=" + object + ')';
    }

    public boolean equals(Object object) {
        return SegmentOrClosed.equals-impl(this.value, object);
    }

    public int hashCode() {
        return SegmentOrClosed.hashCode-impl(this.value);
    }

    public String toString() {
        return SegmentOrClosed.toString-impl(this.value);
    }

    public final /* synthetic */ Object unbox-impl() {
        return this.value;
    }
}

