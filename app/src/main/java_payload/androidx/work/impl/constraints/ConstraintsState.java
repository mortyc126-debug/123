/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 */
package androidx.work.impl.constraints;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2={"Landroidx/work/impl/constraints/ConstraintsState;", "", "()V", "ConstraintsMet", "ConstraintsNotMet", "Landroidx/work/impl/constraints/ConstraintsState$ConstraintsMet;", "Landroidx/work/impl/constraints/ConstraintsState$ConstraintsNotMet;", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public abstract class ConstraintsState {
    private ConstraintsState() {
    }

    public /* synthetic */ ConstraintsState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2={"Landroidx/work/impl/constraints/ConstraintsState$ConstraintsMet;", "Landroidx/work/impl/constraints/ConstraintsState;", "()V", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class ConstraintsMet
    extends ConstraintsState {
        public static final ConstraintsMet INSTANCE = new ConstraintsMet();

        private ConstraintsMet() {
            super(null);
        }
    }

    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2={"Landroidx/work/impl/constraints/ConstraintsState$ConstraintsNotMet;", "Landroidx/work/impl/constraints/ConstraintsState;", "reason", "", "(I)V", "getReason", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class ConstraintsNotMet
    extends ConstraintsState {
        private final int reason;

        public ConstraintsNotMet(int n) {
            super(null);
            this.reason = n;
        }

        public static /* synthetic */ ConstraintsNotMet copy$default(ConstraintsNotMet constraintsNotMet, int n, int n2, Object object) {
            if ((n2 & 1) != 0) {
                n = constraintsNotMet.reason;
            }
            return constraintsNotMet.copy(n);
        }

        public final int component1() {
            return this.reason;
        }

        public final ConstraintsNotMet copy(int n) {
            return new ConstraintsNotMet(n);
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof ConstraintsNotMet)) {
                return false;
            }
            object = (ConstraintsNotMet)object;
            return this.reason == ((ConstraintsNotMet)object).reason;
        }

        public final int getReason() {
            return this.reason;
        }

        public int hashCode() {
            return Integer.hashCode(this.reason);
        }

        public String toString() {
            return "ConstraintsNotMet(reason=" + this.reason + ')';
        }
    }
}

