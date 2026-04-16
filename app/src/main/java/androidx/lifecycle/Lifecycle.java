/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.lifecycle;

import androidx.lifecycle.LifecycleObserver;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H'R\u0014\u0010\u0003\u001a\u00020\u00048gX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0014"}, d2={"Landroidx/lifecycle/Lifecycle;", "", "()V", "currentState", "Landroidx/lifecycle/Lifecycle$State;", "getCurrentState", "()Landroidx/lifecycle/Lifecycle$State;", "internalScopeRef", "Ljava/util/concurrent/atomic/AtomicReference;", "getInternalScopeRef", "()Ljava/util/concurrent/atomic/AtomicReference;", "setInternalScopeRef", "(Ljava/util/concurrent/atomic/AtomicReference;)V", "addObserver", "", "observer", "Landroidx/lifecycle/LifecycleObserver;", "removeObserver", "Event", "State", "lifecycle-common"}, k=1, mv={1, 8, 0}, xi=48)
public abstract class Lifecycle {
    private AtomicReference<Object> internalScopeRef = new AtomicReference();

    public abstract void addObserver(LifecycleObserver var1);

    public abstract State getCurrentState();

    public final AtomicReference<Object> getInternalScopeRef() {
        return this.internalScopeRef;
    }

    public abstract void removeObserver(LifecycleObserver var1);

    public final void setInternalScopeRef(AtomicReference<Object> atomicReference) {
        Intrinsics.checkNotNullParameter(atomicReference, (String)"<set-?>");
        this.internalScopeRef = atomicReference;
    }

    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000f"}, d2={"Landroidx/lifecycle/Lifecycle$Event;", "", "(Ljava/lang/String;I)V", "targetState", "Landroidx/lifecycle/Lifecycle$State;", "getTargetState", "()Landroidx/lifecycle/Lifecycle$State;", "ON_CREATE", "ON_START", "ON_RESUME", "ON_PAUSE", "ON_STOP", "ON_DESTROY", "ON_ANY", "Companion", "lifecycle-common"}, k=1, mv={1, 8, 0}, xi=48)
    public static enum Event {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        public static final Companion Companion;

        static {
            Companion = new Companion(null);
        }

        @JvmStatic
        public static final Event downFrom(State state) {
            return Companion.downFrom(state);
        }

        @JvmStatic
        public static final Event downTo(State state) {
            return Companion.downTo(state);
        }

        @JvmStatic
        public static final Event upFrom(State state) {
            return Companion.upFrom(state);
        }

        @JvmStatic
        public static final Event upTo(State state) {
            return Companion.upTo(state);
        }

        public final State getTargetState() {
            switch (WhenMappings.$EnumSwitchMapping$0[this.ordinal()]) {
                default: {
                    throw new IllegalArgumentException((Object)((Object)this) + " has no target state");
                }
                case 6: {
                    return State.DESTROYED;
                }
                case 5: {
                    return State.RESUMED;
                }
                case 3: 
                case 4: {
                    return State.STARTED;
                }
                case 1: 
                case 2: 
            }
            return State.CREATED;
        }

        @Metadata(d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\n"}, d2={"Landroidx/lifecycle/Lifecycle$Event$Companion;", "", "()V", "downFrom", "Landroidx/lifecycle/Lifecycle$Event;", "state", "Landroidx/lifecycle/Lifecycle$State;", "downTo", "upFrom", "upTo", "lifecycle-common"}, k=1, mv={1, 8, 0}, xi=48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public final Event downFrom(State enum_) {
                Intrinsics.checkNotNullParameter((Object)enum_, (String)"state");
                switch (WhenMappings.$EnumSwitchMapping$0[enum_.ordinal()]) {
                    default: {
                        enum_ = null;
                        break;
                    }
                    case 3: {
                        enum_ = ON_PAUSE;
                        break;
                    }
                    case 2: {
                        enum_ = ON_STOP;
                        break;
                    }
                    case 1: {
                        enum_ = ON_DESTROY;
                    }
                }
                return enum_;
            }

            @JvmStatic
            public final Event downTo(State enum_) {
                Intrinsics.checkNotNullParameter((Object)enum_, (String)"state");
                switch (WhenMappings.$EnumSwitchMapping$0[enum_.ordinal()]) {
                    default: {
                        enum_ = null;
                        break;
                    }
                    case 4: {
                        enum_ = ON_DESTROY;
                        break;
                    }
                    case 2: {
                        enum_ = ON_PAUSE;
                        break;
                    }
                    case 1: {
                        enum_ = ON_STOP;
                    }
                }
                return enum_;
            }

            @JvmStatic
            public final Event upFrom(State enum_) {
                Intrinsics.checkNotNullParameter((Object)enum_, (String)"state");
                switch (WhenMappings.$EnumSwitchMapping$0[enum_.ordinal()]) {
                    default: {
                        enum_ = null;
                        break;
                    }
                    case 5: {
                        enum_ = ON_CREATE;
                        break;
                    }
                    case 2: {
                        enum_ = ON_RESUME;
                        break;
                    }
                    case 1: {
                        enum_ = ON_START;
                    }
                }
                return enum_;
            }

            @JvmStatic
            public final Event upTo(State enum_) {
                Intrinsics.checkNotNullParameter((Object)enum_, (String)"state");
                switch (WhenMappings.$EnumSwitchMapping$0[enum_.ordinal()]) {
                    default: {
                        enum_ = null;
                        break;
                    }
                    case 3: {
                        enum_ = ON_RESUME;
                        break;
                    }
                    case 2: {
                        enum_ = ON_START;
                        break;
                    }
                    case 1: {
                        enum_ = ON_CREATE;
                    }
                }
                return enum_;
            }

            @Metadata(k=3, mv={1, 8, 0}, xi=48)
            public final class WhenMappings {
                public static final int[] $EnumSwitchMapping$0;

                static {
                    int[] nArray = new int[State.values().length];
                    try {
                        nArray[State.CREATED.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError noSuchFieldError) {
                        // empty catch block
                    }
                    try {
                        nArray[State.STARTED.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError noSuchFieldError) {
                        // empty catch block
                    }
                    try {
                        nArray[State.RESUMED.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError noSuchFieldError) {
                        // empty catch block
                    }
                    try {
                        nArray[State.DESTROYED.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError noSuchFieldError) {
                        // empty catch block
                    }
                    try {
                        nArray[State.INITIALIZED.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError noSuchFieldError) {
                        // empty catch block
                    }
                    $EnumSwitchMapping$0 = nArray;
                }
            }
        }

        @Metadata(k=3, mv={1, 8, 0}, xi=48)
        public final class WhenMappings {
            public static final int[] $EnumSwitchMapping$0;

            static {
                int[] nArray = new int[Event.values().length];
                try {
                    nArray[Event.ON_CREATE.ordinal()] = 1;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[Event.ON_STOP.ordinal()] = 2;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[Event.ON_START.ordinal()] = 3;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[Event.ON_PAUSE.ordinal()] = 4;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[Event.ON_RESUME.ordinal()] = 5;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[Event.ON_DESTROY.ordinal()] = 6;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[Event.ON_ANY.ordinal()] = 7;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                $EnumSwitchMapping$0 = nArray;
            }
        }
    }

    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2={"Landroidx/lifecycle/Lifecycle$State;", "", "(Ljava/lang/String;I)V", "isAtLeast", "", "state", "DESTROYED", "INITIALIZED", "CREATED", "STARTED", "RESUMED", "lifecycle-common"}, k=1, mv={1, 8, 0}, xi=48)
    public static enum State {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;


        public final boolean isAtLeast(State state) {
            Intrinsics.checkNotNullParameter((Object)((Object)state), (String)"state");
            boolean bl = this.compareTo((Enum)state) >= 0;
            return bl;
        }
    }
}

