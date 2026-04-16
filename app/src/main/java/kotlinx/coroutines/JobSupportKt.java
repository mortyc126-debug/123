/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.Empty;
import kotlinx.coroutines.Incomplete;
import kotlinx.coroutines.IncompleteStateBox;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u0010\u0010\r\u001a\u0004\u0018\u00010\u000e*\u0004\u0018\u00010\u000eH\u0000\u001a\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u0004\u0018\u00010\u000eH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u00018\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"COMPLETING_ALREADY", "Lkotlinx/coroutines/internal/Symbol;", "COMPLETING_RETRY", "COMPLETING_WAITING_CHILDREN", "EMPTY_ACTIVE", "Lkotlinx/coroutines/Empty;", "EMPTY_NEW", "FALSE", "", "RETRY", "SEALED", "TOO_LATE_TO_CANCEL", "TRUE", "boxIncomplete", "", "unboxState", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class JobSupportKt {
    private static final Symbol COMPLETING_ALREADY = new Symbol("COMPLETING_ALREADY");
    private static final Symbol COMPLETING_RETRY;
    public static final Symbol COMPLETING_WAITING_CHILDREN;
    private static final Empty EMPTY_ACTIVE;
    private static final Empty EMPTY_NEW;
    private static final int FALSE = 0;
    private static final int RETRY = -1;
    private static final Symbol SEALED;
    private static final Symbol TOO_LATE_TO_CANCEL;
    private static final int TRUE = 1;

    static {
        COMPLETING_WAITING_CHILDREN = new Symbol("COMPLETING_WAITING_CHILDREN");
        COMPLETING_RETRY = new Symbol("COMPLETING_RETRY");
        TOO_LATE_TO_CANCEL = new Symbol("TOO_LATE_TO_CANCEL");
        SEALED = new Symbol("SEALED");
        EMPTY_NEW = new Empty(false);
        EMPTY_ACTIVE = new Empty(true);
    }

    public static final /* synthetic */ Symbol access$getCOMPLETING_ALREADY$p() {
        return COMPLETING_ALREADY;
    }

    public static final /* synthetic */ Symbol access$getCOMPLETING_RETRY$p() {
        return COMPLETING_RETRY;
    }

    public static final /* synthetic */ Empty access$getEMPTY_ACTIVE$p() {
        return EMPTY_ACTIVE;
    }

    public static final /* synthetic */ Empty access$getEMPTY_NEW$p() {
        return EMPTY_NEW;
    }

    public static final /* synthetic */ Symbol access$getSEALED$p() {
        return SEALED;
    }

    public static final /* synthetic */ Symbol access$getTOO_LATE_TO_CANCEL$p() {
        return TOO_LATE_TO_CANCEL;
    }

    public static final Object boxIncomplete(Object object) {
        block0: {
            if (!(object instanceof Incomplete)) break block0;
            object = new IncompleteStateBox((Incomplete)object);
        }
        return object;
    }

    public static final Object unboxState(Object object) {
        Object object2;
        block3: {
            block2: {
                object2 = object instanceof IncompleteStateBox ? (IncompleteStateBox)object : null;
                if (object2 == null) break block2;
                Incomplete incomplete = ((IncompleteStateBox)object2).state;
                object2 = incomplete;
                if (incomplete != null) break block3;
            }
            object2 = object;
        }
        return object2;
    }
}

