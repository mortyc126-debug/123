/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Lifecycling;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 42\u00020\u0001:\u000245B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001cH\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u001cH\u0002J\u0010\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020(H\u0003J\u0010\u0010)\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\u0010\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020\"2\u0006\u0010\n\u001a\u00020\u000bH\u0017J\u0010\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u00020\u000bH\u0002J\b\u00100\u001a\u00020\"H\u0002J\u0010\u00101\u001a\u00020\"2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u00102\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001cH\u0016J\b\u00103\u001a\u00020\"H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u001fj\b\u0012\u0004\u0012\u00020\u000b` X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00066"}, d2={"Landroidx/lifecycle/LifecycleRegistry;", "Landroidx/lifecycle/Lifecycle;", "provider", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;)V", "enforceMainThread", "", "(Landroidx/lifecycle/LifecycleOwner;Z)V", "addingObserverCounter", "", "state", "Landroidx/lifecycle/Lifecycle$State;", "currentState", "getCurrentState", "()Landroidx/lifecycle/Lifecycle$State;", "setCurrentState", "(Landroidx/lifecycle/Lifecycle$State;)V", "handlingEvent", "isSynced", "()Z", "lifecycleOwner", "Ljava/lang/ref/WeakReference;", "newEventOccurred", "observerCount", "getObserverCount", "()I", "observerMap", "Landroidx/arch/core/internal/FastSafeIterableMap;", "Landroidx/lifecycle/LifecycleObserver;", "Landroidx/lifecycle/LifecycleRegistry$ObserverWithState;", "parentStates", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "addObserver", "", "observer", "backwardPass", "calculateTargetState", "enforceMainThreadIfNeeded", "methodName", "", "forwardPass", "handleLifecycleEvent", "event", "Landroidx/lifecycle/Lifecycle$Event;", "markState", "moveToState", "next", "popParentState", "pushParentState", "removeObserver", "sync", "Companion", "ObserverWithState", "lifecycle-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public class LifecycleRegistry
extends Lifecycle {
    public static final Companion Companion = new Companion(null);
    private int addingObserverCounter;
    private final boolean enforceMainThread;
    private boolean handlingEvent;
    private final WeakReference<LifecycleOwner> lifecycleOwner;
    private boolean newEventOccurred;
    private FastSafeIterableMap<LifecycleObserver, ObserverWithState> observerMap;
    private ArrayList<Lifecycle.State> parentStates;
    private Lifecycle.State state;

    public LifecycleRegistry(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter((Object)lifecycleOwner, (String)"provider");
        this(lifecycleOwner, true);
    }

    private LifecycleRegistry(LifecycleOwner lifecycleOwner, boolean bl) {
        this.enforceMainThread = bl;
        this.observerMap = new FastSafeIterableMap();
        this.state = Lifecycle.State.INITIALIZED;
        this.parentStates = new ArrayList();
        this.lifecycleOwner = new WeakReference<LifecycleOwner>(lifecycleOwner);
    }

    public /* synthetic */ LifecycleRegistry(LifecycleOwner lifecycleOwner, boolean bl, DefaultConstructorMarker defaultConstructorMarker) {
        this(lifecycleOwner, bl);
    }

    private final void backwardPass(LifecycleOwner lifecycleOwner) {
        Iterator iterator2 = this.observerMap.descendingIterator();
        Intrinsics.checkNotNullExpressionValue(iterator2, (String)"observerMap.descendingIterator()");
        while (iterator2.hasNext() && !this.newEventOccurred) {
            Object object = iterator2.next();
            Intrinsics.checkNotNullExpressionValue(object, (String)"next()");
            LifecycleObserver lifecycleObserver = (LifecycleObserver)object.getKey();
            object = (ObserverWithState)object.getValue();
            while (((ObserverWithState)object).getState().compareTo((Enum)this.state) > 0 && !this.newEventOccurred && this.observerMap.contains(lifecycleObserver)) {
                Lifecycle.Event event = Lifecycle.Event.Companion.downFrom(((ObserverWithState)object).getState());
                if (event != null) {
                    this.pushParentState(event.getTargetState());
                    ((ObserverWithState)object).dispatchEvent(lifecycleOwner, event);
                    this.popParentState();
                    continue;
                }
                throw new IllegalStateException("no event down from " + (Object)((Object)((ObserverWithState)object).getState()));
            }
        }
    }

    private final Lifecycle.State calculateTargetState(LifecycleObserver object) {
        object = this.observerMap.ceil((LifecycleObserver)object);
        Lifecycle.State state = null;
        object = object != null && (object = (ObserverWithState)object.getValue()) != null ? ((ObserverWithState)object).getState() : null;
        if (((Collection)this.parentStates).isEmpty() ^ true) {
            state = this.parentStates.get(this.parentStates.size() - 1);
        }
        return Companion.min$lifecycle_runtime_release(Companion.min$lifecycle_runtime_release(this.state, (Lifecycle.State)((Object)object)), state);
    }

    @JvmStatic
    public static final LifecycleRegistry createUnsafe(LifecycleOwner lifecycleOwner) {
        return Companion.createUnsafe(lifecycleOwner);
    }

    private final void enforceMainThreadIfNeeded(String string2) {
        if (this.enforceMainThread && !ArchTaskExecutor.getInstance().isMainThread()) {
            throw new IllegalStateException(("Method " + string2 + " must be called on the main thread").toString());
        }
    }

    private final void forwardPass(LifecycleOwner lifecycleOwner) {
        Iterator iterator2 = this.observerMap.iteratorWithAdditions();
        Intrinsics.checkNotNullExpressionValue((Object)iterator2, (String)"observerMap.iteratorWithAdditions()");
        iterator2 = iterator2;
        while (iterator2.hasNext() && !this.newEventOccurred) {
            Object object = iterator2.next();
            LifecycleObserver lifecycleObserver = (LifecycleObserver)object.getKey();
            ObserverWithState observerWithState = (ObserverWithState)object.getValue();
            while (observerWithState.getState().compareTo((Enum)this.state) < 0 && !this.newEventOccurred && this.observerMap.contains(lifecycleObserver)) {
                this.pushParentState(observerWithState.getState());
                object = Lifecycle.Event.Companion.upFrom(observerWithState.getState());
                if (object != null) {
                    observerWithState.dispatchEvent(lifecycleOwner, (Lifecycle.Event)((Object)object));
                    this.popParentState();
                    continue;
                }
                throw new IllegalStateException("no event up from " + (Object)((Object)observerWithState.getState()));
            }
        }
    }

    private final boolean isSynced() {
        int n = this.observerMap.size();
        boolean bl = true;
        if (n == 0) {
            return true;
        }
        Object object = this.observerMap.eldest();
        Intrinsics.checkNotNull(object);
        object = ((ObserverWithState)object.getValue()).getState();
        Object object2 = this.observerMap.newest();
        Intrinsics.checkNotNull(object2);
        object2 = ((ObserverWithState)object2.getValue()).getState();
        if (object != object2 || this.state != object2) {
            bl = false;
        }
        return bl;
    }

    @JvmStatic
    public static final Lifecycle.State min$lifecycle_runtime_release(Lifecycle.State state, Lifecycle.State state2) {
        return Companion.min$lifecycle_runtime_release(state, state2);
    }

    private final void moveToState(Lifecycle.State state) {
        if (this.state == state) {
            return;
        }
        boolean bl = this.state != Lifecycle.State.INITIALIZED || state != Lifecycle.State.DESTROYED;
        if (bl) {
            this.state = state;
            if (!this.handlingEvent && this.addingObserverCounter == 0) {
                this.handlingEvent = true;
                this.sync();
                this.handlingEvent = false;
                if (this.state == Lifecycle.State.DESTROYED) {
                    this.observerMap = new FastSafeIterableMap();
                }
                return;
            }
            this.newEventOccurred = true;
            return;
        }
        throw new IllegalStateException(("no event down from " + (Object)((Object)this.state) + " in component " + this.lifecycleOwner.get()).toString());
    }

    private final void popParentState() {
        this.parentStates.remove(this.parentStates.size() - 1);
    }

    private final void pushParentState(Lifecycle.State state) {
        this.parentStates.add(state);
    }

    private final void sync() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner)this.lifecycleOwner.get();
        if (lifecycleOwner != null) {
            while (!this.isSynced()) {
                this.newEventOccurred = false;
                Lifecycle.State state = this.state;
                Map.Entry entry = this.observerMap.eldest();
                Intrinsics.checkNotNull(entry);
                if (state.compareTo((Enum)((ObserverWithState)entry.getValue()).getState()) < 0) {
                    this.backwardPass(lifecycleOwner);
                }
                entry = this.observerMap.newest();
                if (this.newEventOccurred || entry == null || this.state.compareTo((Enum)((ObserverWithState)entry.getValue()).getState()) <= 0) continue;
                this.forwardPass(lifecycleOwner);
            }
            this.newEventOccurred = false;
            return;
        }
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
    }

    @Override
    public void addObserver(LifecycleObserver lifecycleObserver) {
        Intrinsics.checkNotNullParameter((Object)lifecycleObserver, (String)"observer");
        this.enforceMainThreadIfNeeded("addObserver");
        Enum enum_ = this.state == Lifecycle.State.DESTROYED ? Lifecycle.State.DESTROYED : Lifecycle.State.INITIALIZED;
        ObserverWithState observerWithState = new ObserverWithState(lifecycleObserver, (Lifecycle.State)enum_);
        if (this.observerMap.putIfAbsent(lifecycleObserver, observerWithState) != null) {
            return;
        }
        LifecycleOwner lifecycleOwner = (LifecycleOwner)this.lifecycleOwner.get();
        if (lifecycleOwner == null) {
            return;
        }
        boolean bl = this.addingObserverCounter != 0 || this.handlingEvent;
        enum_ = this.calculateTargetState(lifecycleObserver);
        ++this.addingObserverCounter;
        while (observerWithState.getState().compareTo((Enum)enum_) < 0 && this.observerMap.contains(lifecycleObserver)) {
            this.pushParentState(observerWithState.getState());
            enum_ = Lifecycle.Event.Companion.upFrom(observerWithState.getState());
            if (enum_ != null) {
                observerWithState.dispatchEvent(lifecycleOwner, (Lifecycle.Event)enum_);
                this.popParentState();
                enum_ = this.calculateTargetState(lifecycleObserver);
                continue;
            }
            throw new IllegalStateException("no event up from " + (Object)((Object)observerWithState.getState()));
        }
        if (!bl) {
            this.sync();
        }
        --this.addingObserverCounter;
    }

    @Override
    public Lifecycle.State getCurrentState() {
        return this.state;
    }

    public int getObserverCount() {
        this.enforceMainThreadIfNeeded("getObserverCount");
        return this.observerMap.size();
    }

    public void handleLifecycleEvent(Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter((Object)((Object)event), (String)"event");
        this.enforceMainThreadIfNeeded("handleLifecycleEvent");
        this.moveToState(event.getTargetState());
    }

    @Deprecated(message="Override [currentState].")
    public void markState(Lifecycle.State state) {
        Intrinsics.checkNotNullParameter((Object)((Object)state), (String)"state");
        this.enforceMainThreadIfNeeded("markState");
        this.setCurrentState(state);
    }

    @Override
    public void removeObserver(LifecycleObserver lifecycleObserver) {
        Intrinsics.checkNotNullParameter((Object)lifecycleObserver, (String)"observer");
        this.enforceMainThreadIfNeeded("removeObserver");
        this.observerMap.remove(lifecycleObserver);
    }

    public void setCurrentState(Lifecycle.State state) {
        Intrinsics.checkNotNullParameter((Object)((Object)state), (String)"state");
        this.enforceMainThreadIfNeeded("setCurrentState");
        this.moveToState(state);
    }

    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u001f\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0001\u00a2\u0006\u0002\b\u000b\u00a8\u0006\f"}, d2={"Landroidx/lifecycle/LifecycleRegistry$Companion;", "", "()V", "createUnsafe", "Landroidx/lifecycle/LifecycleRegistry;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "min", "Landroidx/lifecycle/Lifecycle$State;", "state1", "state2", "min$lifecycle_runtime_release", "lifecycle-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final LifecycleRegistry createUnsafe(LifecycleOwner lifecycleOwner) {
            Intrinsics.checkNotNullParameter((Object)lifecycleOwner, (String)"owner");
            return new LifecycleRegistry(lifecycleOwner, false, null);
        }

        @JvmStatic
        public final Lifecycle.State min$lifecycle_runtime_release(Lifecycle.State state, Lifecycle.State state2) {
            block0: {
                Intrinsics.checkNotNullParameter((Object)((Object)state), (String)"state1");
                if (state2 == null || state2.compareTo((Enum)state) >= 0) break block0;
                state = state2;
            }
            return state;
        }
    }

    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0018"}, d2={"Landroidx/lifecycle/LifecycleRegistry$ObserverWithState;", "", "observer", "Landroidx/lifecycle/LifecycleObserver;", "initialState", "Landroidx/lifecycle/Lifecycle$State;", "(Landroidx/lifecycle/LifecycleObserver;Landroidx/lifecycle/Lifecycle$State;)V", "lifecycleObserver", "Landroidx/lifecycle/LifecycleEventObserver;", "getLifecycleObserver", "()Landroidx/lifecycle/LifecycleEventObserver;", "setLifecycleObserver", "(Landroidx/lifecycle/LifecycleEventObserver;)V", "state", "getState", "()Landroidx/lifecycle/Lifecycle$State;", "setState", "(Landroidx/lifecycle/Lifecycle$State;)V", "dispatchEvent", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "lifecycle-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class ObserverWithState {
        private LifecycleEventObserver lifecycleObserver;
        private Lifecycle.State state;

        public ObserverWithState(LifecycleObserver lifecycleObserver, Lifecycle.State state) {
            Intrinsics.checkNotNullParameter((Object)((Object)state), (String)"initialState");
            Intrinsics.checkNotNull((Object)lifecycleObserver);
            this.lifecycleObserver = Lifecycling.lifecycleEventObserver(lifecycleObserver);
            this.state = state;
        }

        public final void dispatchEvent(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Intrinsics.checkNotNullParameter((Object)((Object)event), (String)"event");
            Lifecycle.State state = event.getTargetState();
            this.state = Companion.min$lifecycle_runtime_release(this.state, state);
            LifecycleEventObserver lifecycleEventObserver = this.lifecycleObserver;
            Intrinsics.checkNotNull((Object)lifecycleOwner);
            lifecycleEventObserver.onStateChanged(lifecycleOwner, event);
            this.state = state;
        }

        public final LifecycleEventObserver getLifecycleObserver() {
            return this.lifecycleObserver;
        }

        public final Lifecycle.State getState() {
            return this.state;
        }

        public final void setLifecycleObserver(LifecycleEventObserver lifecycleEventObserver) {
            Intrinsics.checkNotNullParameter((Object)lifecycleEventObserver, (String)"<set-?>");
            this.lifecycleObserver = lifecycleEventObserver;
        }

        public final void setState(Lifecycle.State state) {
            Intrinsics.checkNotNullParameter((Object)((Object)state), (String)"<set-?>");
            this.state = state;
        }
    }
}

