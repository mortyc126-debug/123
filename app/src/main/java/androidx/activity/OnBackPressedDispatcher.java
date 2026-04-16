/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.window.BackEvent
 *  android.window.OnBackAnimationCallback
 *  android.window.OnBackInvokedCallback
 *  android.window.OnBackInvokedDispatcher
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.ArrayDeque
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.activity;

import android.os.Build;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.BackEventCompat;
import androidx.activity.Cancellable;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher$Api33Impl$$ExternalSyntheticLambda0;
import androidx.core.util.Consumer;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0004)*+,B\u0013\b\u0017\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH\u0007J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\fH\u0007J\u0015\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\fH\u0001\u00a2\u0006\u0002\b\u001aJ\b\u0010\u001b\u001a\u00020\u0014H\u0007J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\b\u0010\n\u001a\u00020\u0007H\u0007J\b\u0010 \u001a\u00020\u0014H\u0003J\b\u0010!\u001a\u00020\u0014H\u0007J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0003J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0003J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u000eH\u0007J\u0010\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u0007H\u0003J\b\u0010(\u001a\u00020\u0014H\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2={"Landroidx/activity/OnBackPressedDispatcher;", "", "fallbackOnBackPressed", "Ljava/lang/Runnable;", "(Ljava/lang/Runnable;)V", "onHasEnabledCallbacksChanged", "Landroidx/core/util/Consumer;", "", "(Ljava/lang/Runnable;Landroidx/core/util/Consumer;)V", "backInvokedCallbackRegistered", "hasEnabledCallbacks", "inProgressCallback", "Landroidx/activity/OnBackPressedCallback;", "invokedDispatcher", "Landroid/window/OnBackInvokedDispatcher;", "onBackInvokedCallback", "Landroid/window/OnBackInvokedCallback;", "onBackPressedCallbacks", "Lkotlin/collections/ArrayDeque;", "addCallback", "", "onBackPressedCallback", "owner", "Landroidx/lifecycle/LifecycleOwner;", "addCancellableCallback", "Landroidx/activity/Cancellable;", "addCancellableCallback$activity_release", "dispatchOnBackCancelled", "dispatchOnBackProgressed", "backEvent", "Landroidx/activity/BackEventCompat;", "dispatchOnBackStarted", "onBackCancelled", "onBackPressed", "onBackProgressed", "onBackStarted", "setOnBackInvokedDispatcher", "invoker", "updateBackInvokedCallbackState", "shouldBeRegistered", "updateEnabledCallbacks", "Api33Impl", "Api34Impl", "LifecycleOnBackPressedCancellable", "OnBackPressedCancellable", "activity_release"}, k=1, mv={1, 8, 0}, xi=48)
public final class OnBackPressedDispatcher {
    private boolean backInvokedCallbackRegistered;
    private final Runnable fallbackOnBackPressed;
    private boolean hasEnabledCallbacks;
    private OnBackPressedCallback inProgressCallback;
    private OnBackInvokedDispatcher invokedDispatcher;
    private OnBackInvokedCallback onBackInvokedCallback;
    private final ArrayDeque<OnBackPressedCallback> onBackPressedCallbacks;
    private final Consumer<Boolean> onHasEnabledCallbacksChanged;

    public OnBackPressedDispatcher() {
        this(null, 1, null);
    }

    public OnBackPressedDispatcher(Runnable runnable2) {
        this(runnable2, null);
    }

    public /* synthetic */ OnBackPressedDispatcher(Runnable runnable2, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            runnable2 = null;
        }
        this(runnable2);
    }

    public OnBackPressedDispatcher(Runnable runnable2, Consumer<Boolean> consumer) {
        this.fallbackOnBackPressed = runnable2;
        this.onHasEnabledCallbacksChanged = consumer;
        this.onBackPressedCallbacks = new ArrayDeque();
        if (Build.VERSION.SDK_INT >= 33) {
            runnable2 = Build.VERSION.SDK_INT >= 34 ? Api34Impl.INSTANCE.createOnBackAnimationCallback((Function1<? super BackEventCompat, Unit>)((Function1)new Function1<BackEventCompat, Unit>(this){
                final OnBackPressedDispatcher this$0;
                {
                    this.this$0 = onBackPressedDispatcher;
                    super(1);
                }

                public final void invoke(BackEventCompat backEventCompat) {
                    Intrinsics.checkNotNullParameter((Object)backEventCompat, (String)"backEvent");
                    this.this$0.onBackStarted(backEventCompat);
                }
            }), (Function1<? super BackEventCompat, Unit>)((Function1)new Function1<BackEventCompat, Unit>(this){
                final OnBackPressedDispatcher this$0;
                {
                    this.this$0 = onBackPressedDispatcher;
                    super(1);
                }

                public final void invoke(BackEventCompat backEventCompat) {
                    Intrinsics.checkNotNullParameter((Object)backEventCompat, (String)"backEvent");
                    this.this$0.onBackProgressed(backEventCompat);
                }
            }), (Function0<Unit>)((Function0)new Function0<Unit>(this){
                final OnBackPressedDispatcher this$0;
                {
                    this.this$0 = onBackPressedDispatcher;
                    super(0);
                }

                public final void invoke() {
                    this.this$0.onBackPressed();
                }
            }), (Function0<Unit>)((Function0)new Function0<Unit>(this){
                final OnBackPressedDispatcher this$0;
                {
                    this.this$0 = onBackPressedDispatcher;
                    super(0);
                }

                public final void invoke() {
                    this.this$0.onBackCancelled();
                }
            })) : Api33Impl.INSTANCE.createOnBackInvokedCallback((Function0<Unit>)((Function0)new Function0<Unit>(this){
                final OnBackPressedDispatcher this$0;
                {
                    this.this$0 = onBackPressedDispatcher;
                    super(0);
                }

                public final void invoke() {
                    this.this$0.onBackPressed();
                }
            }));
            this.onBackInvokedCallback = runnable2;
        }
    }

    public static final /* synthetic */ void access$updateEnabledCallbacks(OnBackPressedDispatcher onBackPressedDispatcher) {
        onBackPressedDispatcher.updateEnabledCallbacks();
    }

    private final void onBackCancelled() {
        Object object;
        block2: {
            object = (List)this.onBackPressedCallbacks;
            ListIterator listIterator = object.listIterator(object.size());
            while (listIterator.hasPrevious()) {
                object = listIterator.previous();
                if (!((OnBackPressedCallback)object).isEnabled()) continue;
                break block2;
            }
            object = null;
        }
        object = (OnBackPressedCallback)object;
        this.inProgressCallback = null;
        if (object != null) {
            ((OnBackPressedCallback)object).handleOnBackCancelled();
            return;
        }
    }

    private final void onBackProgressed(BackEventCompat backEventCompat) {
        Object object;
        block2: {
            object = (List)this.onBackPressedCallbacks;
            ListIterator listIterator = object.listIterator(object.size());
            while (listIterator.hasPrevious()) {
                object = listIterator.previous();
                if (!((OnBackPressedCallback)object).isEnabled()) continue;
                break block2;
            }
            object = null;
        }
        object = (OnBackPressedCallback)object;
        if (object != null) {
            ((OnBackPressedCallback)object).handleOnBackProgressed(backEventCompat);
            return;
        }
    }

    private final void onBackStarted(BackEventCompat backEventCompat) {
        Object object;
        block2: {
            object = (List)this.onBackPressedCallbacks;
            ListIterator listIterator = object.listIterator(object.size());
            while (listIterator.hasPrevious()) {
                object = listIterator.previous();
                if (!((OnBackPressedCallback)object).isEnabled()) continue;
                break block2;
            }
            object = null;
        }
        this.inProgressCallback = object = (OnBackPressedCallback)object;
        if (object != null) {
            ((OnBackPressedCallback)object).handleOnBackStarted(backEventCompat);
            return;
        }
    }

    private final void updateBackInvokedCallbackState(boolean bl) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.invokedDispatcher;
        OnBackInvokedCallback onBackInvokedCallback = this.onBackInvokedCallback;
        if (onBackInvokedDispatcher != null && onBackInvokedCallback != null) {
            if (bl && !this.backInvokedCallbackRegistered) {
                Api33Impl api33Impl = Api33Impl.INSTANCE;
                api33Impl.registerOnBackInvokedCallback(onBackInvokedDispatcher, 0, onBackInvokedCallback);
                this.backInvokedCallbackRegistered = true;
            } else if (!bl && this.backInvokedCallbackRegistered) {
                Api33Impl api33Impl = Api33Impl.INSTANCE;
                api33Impl.unregisterOnBackInvokedCallback(onBackInvokedDispatcher, onBackInvokedCallback);
                this.backInvokedCallbackRegistered = false;
            }
        }
    }

    private final void updateEnabledCallbacks() {
        boolean bl = this.hasEnabledCallbacks;
        Consumer<Boolean> consumer = (Iterable)this.onBackPressedCallbacks;
        boolean bl2 = consumer instanceof Collection;
        boolean bl3 = false;
        if (!bl2 || !((Collection)((Object)consumer)).isEmpty()) {
            consumer = consumer.iterator();
            while (consumer.hasNext()) {
                if (!((OnBackPressedCallback)consumer.next()).isEnabled()) continue;
                bl3 = true;
                break;
            }
        }
        this.hasEnabledCallbacks = bl3;
        if (bl3 != bl) {
            consumer = this.onHasEnabledCallbacksChanged;
            if (consumer != null) {
                consumer.accept(bl3);
            }
            if (Build.VERSION.SDK_INT >= 33) {
                this.updateBackInvokedCallbackState(bl3);
            }
        }
    }

    public final void addCallback(OnBackPressedCallback onBackPressedCallback) {
        Intrinsics.checkNotNullParameter((Object)onBackPressedCallback, (String)"onBackPressedCallback");
        this.addCancellableCallback$activity_release(onBackPressedCallback);
    }

    public final void addCallback(LifecycleOwner object, OnBackPressedCallback onBackPressedCallback) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"owner");
        Intrinsics.checkNotNullParameter((Object)onBackPressedCallback, (String)"onBackPressedCallback");
        object = object.getLifecycle();
        if (((Lifecycle)object).getCurrentState() == Lifecycle.State.DESTROYED) {
            return;
        }
        onBackPressedCallback.addCancellable(new LifecycleOnBackPressedCancellable(this, (Lifecycle)object, onBackPressedCallback));
        this.updateEnabledCallbacks();
        onBackPressedCallback.setEnabledChangedCallback$activity_release((Function0<Unit>)((Function0)new Function0<Unit>((Object)this){

            public final void invoke() {
                OnBackPressedDispatcher.access$updateEnabledCallbacks((OnBackPressedDispatcher)this.receiver);
            }
        }));
    }

    public final Cancellable addCancellableCallback$activity_release(OnBackPressedCallback onBackPressedCallback) {
        Intrinsics.checkNotNullParameter((Object)onBackPressedCallback, (String)"onBackPressedCallback");
        this.onBackPressedCallbacks.add((Object)onBackPressedCallback);
        OnBackPressedCancellable onBackPressedCancellable = new OnBackPressedCancellable(this, onBackPressedCallback);
        onBackPressedCallback.addCancellable(onBackPressedCancellable);
        this.updateEnabledCallbacks();
        onBackPressedCallback.setEnabledChangedCallback$activity_release((Function0<Unit>)((Function0)new Function0<Unit>((Object)this){

            public final void invoke() {
                OnBackPressedDispatcher.access$updateEnabledCallbacks((OnBackPressedDispatcher)this.receiver);
            }
        }));
        return onBackPressedCancellable;
    }

    public final void dispatchOnBackCancelled() {
        this.onBackCancelled();
    }

    public final void dispatchOnBackProgressed(BackEventCompat backEventCompat) {
        Intrinsics.checkNotNullParameter((Object)backEventCompat, (String)"backEvent");
        this.onBackProgressed(backEventCompat);
    }

    public final void dispatchOnBackStarted(BackEventCompat backEventCompat) {
        Intrinsics.checkNotNullParameter((Object)backEventCompat, (String)"backEvent");
        this.onBackStarted(backEventCompat);
    }

    public final boolean hasEnabledCallbacks() {
        return this.hasEnabledCallbacks;
    }

    public final void onBackPressed() {
        Object object;
        block3: {
            object = (List)this.onBackPressedCallbacks;
            ListIterator listIterator = object.listIterator(object.size());
            while (listIterator.hasPrevious()) {
                object = listIterator.previous();
                if (!((OnBackPressedCallback)object).isEnabled()) continue;
                break block3;
            }
            object = null;
        }
        object = (OnBackPressedCallback)object;
        this.inProgressCallback = null;
        if (object != null) {
            ((OnBackPressedCallback)object).handleOnBackPressed();
            return;
        }
        object = this.fallbackOnBackPressed;
        if (object != null) {
            object.run();
        }
    }

    public final void setOnBackInvokedDispatcher(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        Intrinsics.checkNotNullParameter((Object)onBackInvokedDispatcher, (String)"invoker");
        this.invokedDispatcher = onBackInvokedDispatcher;
        this.updateBackInvokedCallbackState(this.hasEnabledCallbacks);
    }

    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u00c1\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007J \u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0001H\u0007J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001H\u0007\u00a8\u0006\u000e"}, d2={"Landroidx/activity/OnBackPressedDispatcher$Api33Impl;", "", "()V", "createOnBackInvokedCallback", "Landroid/window/OnBackInvokedCallback;", "onBackInvoked", "Lkotlin/Function0;", "", "registerOnBackInvokedCallback", "dispatcher", "priority", "", "callback", "unregisterOnBackInvokedCallback", "activity_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class Api33Impl {
        public static final Api33Impl INSTANCE = new Api33Impl();

        public static /* synthetic */ void $r8$lambda$tzBBo0FLedRCWSI6_icF8qhF74s(Function0 function0) {
            Api33Impl.createOnBackInvokedCallback$lambda$0(function0);
        }

        private Api33Impl() {
        }

        private static final void createOnBackInvokedCallback$lambda$0(Function0 function0) {
            Intrinsics.checkNotNullParameter((Object)function0, (String)"$onBackInvoked");
            function0.invoke();
        }

        public final OnBackInvokedCallback createOnBackInvokedCallback(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, (String)"onBackInvoked");
            return new OnBackPressedDispatcher$Api33Impl$$ExternalSyntheticLambda0(function0);
        }

        public final void registerOnBackInvokedCallback(Object object, int n, Object object2) {
            Intrinsics.checkNotNullParameter((Object)object, (String)"dispatcher");
            Intrinsics.checkNotNullParameter((Object)object2, (String)"callback");
            ((OnBackInvokedDispatcher)object).registerOnBackInvokedCallback(n, (OnBackInvokedCallback)object2);
        }

        public final void unregisterOnBackInvokedCallback(Object object, Object object2) {
            Intrinsics.checkNotNullParameter((Object)object, (String)"dispatcher");
            Intrinsics.checkNotNullParameter((Object)object2, (String)"callback");
            ((OnBackInvokedDispatcher)object).unregisterOnBackInvokedCallback((OnBackInvokedCallback)object2);
        }
    }

    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c1\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002Jj\u0010\u0003\u001a\u00020\u00042!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u00062!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0007\u00a8\u0006\u0010"}, d2={"Landroidx/activity/OnBackPressedDispatcher$Api34Impl;", "", "()V", "createOnBackAnimationCallback", "Landroid/window/OnBackInvokedCallback;", "onBackStarted", "Lkotlin/Function1;", "Landroidx/activity/BackEventCompat;", "Lkotlin/ParameterName;", "name", "backEvent", "", "onBackProgressed", "onBackInvoked", "Lkotlin/Function0;", "onBackCancelled", "activity_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class Api34Impl {
        public static final Api34Impl INSTANCE = new Api34Impl();

        private Api34Impl() {
        }

        public final OnBackInvokedCallback createOnBackAnimationCallback(Function1<? super BackEventCompat, Unit> function1, Function1<? super BackEventCompat, Unit> function12, Function0<Unit> function0, Function0<Unit> function02) {
            Intrinsics.checkNotNullParameter(function1, (String)"onBackStarted");
            Intrinsics.checkNotNullParameter(function12, (String)"onBackProgressed");
            Intrinsics.checkNotNullParameter(function0, (String)"onBackInvoked");
            Intrinsics.checkNotNullParameter(function02, (String)"onBackCancelled");
            return (OnBackInvokedCallback)new OnBackAnimationCallback(function1, function12, function0, function02){
                final Function0<Unit> $onBackCancelled;
                final Function0<Unit> $onBackInvoked;
                final Function1<BackEventCompat, Unit> $onBackProgressed;
                final Function1<BackEventCompat, Unit> $onBackStarted;
                {
                    this.$onBackStarted = function1;
                    this.$onBackProgressed = function12;
                    this.$onBackInvoked = function0;
                    this.$onBackCancelled = function02;
                }

                public void onBackCancelled() {
                    this.$onBackCancelled.invoke();
                }

                public void onBackInvoked() {
                    this.$onBackInvoked.invoke();
                }

                public void onBackProgressed(BackEvent backEvent) {
                    Intrinsics.checkNotNullParameter((Object)backEvent, (String)"backEvent");
                    this.$onBackProgressed.invoke((Object)new BackEventCompat(backEvent));
                }

                public void onBackStarted(BackEvent backEvent) {
                    Intrinsics.checkNotNullParameter((Object)backEvent, (String)"backEvent");
                    this.$onBackStarted.invoke((Object)new BackEventCompat(backEvent));
                }
            };
        }
    }

    @Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0002X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Landroidx/activity/OnBackPressedDispatcher$LifecycleOnBackPressedCancellable;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/activity/Cancellable;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "(Landroidx/activity/OnBackPressedDispatcher;Landroidx/lifecycle/Lifecycle;Landroidx/activity/OnBackPressedCallback;)V", "currentCancellable", "cancel", "", "onStateChanged", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "activity_release"}, k=1, mv={1, 8, 0}, xi=48)
    private final class LifecycleOnBackPressedCancellable
    implements LifecycleEventObserver,
    Cancellable {
        private Cancellable currentCancellable;
        private final Lifecycle lifecycle;
        private final OnBackPressedCallback onBackPressedCallback;
        final OnBackPressedDispatcher this$0;

        public LifecycleOnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, Lifecycle lifecycle, OnBackPressedCallback onBackPressedCallback) {
            Intrinsics.checkNotNullParameter((Object)lifecycle, (String)"lifecycle");
            Intrinsics.checkNotNullParameter((Object)onBackPressedCallback, (String)"onBackPressedCallback");
            this.this$0 = onBackPressedDispatcher;
            this.lifecycle = lifecycle;
            this.onBackPressedCallback = onBackPressedCallback;
            this.lifecycle.addObserver(this);
        }

        @Override
        public void cancel() {
            this.lifecycle.removeObserver(this);
            this.onBackPressedCallback.removeCancellable(this);
            Cancellable cancellable = this.currentCancellable;
            if (cancellable != null) {
                cancellable.cancel();
            }
            this.currentCancellable = null;
        }

        @Override
        public void onStateChanged(LifecycleOwner object, Lifecycle.Event event) {
            Intrinsics.checkNotNullParameter((Object)object, (String)"source");
            Intrinsics.checkNotNullParameter((Object)((Object)event), (String)"event");
            if (event == Lifecycle.Event.ON_START) {
                this.currentCancellable = this.this$0.addCancellableCallback$activity_release(this.onBackPressedCallback);
            } else if (event == Lifecycle.Event.ON_STOP) {
                object = this.currentCancellable;
                if (object != null) {
                    object.cancel();
                }
            } else if (event == Lifecycle.Event.ON_DESTROY) {
                this.cancel();
            }
        }
    }

    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2={"Landroidx/activity/OnBackPressedDispatcher$OnBackPressedCancellable;", "Landroidx/activity/Cancellable;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "(Landroidx/activity/OnBackPressedDispatcher;Landroidx/activity/OnBackPressedCallback;)V", "cancel", "", "activity_release"}, k=1, mv={1, 8, 0}, xi=48)
    private final class OnBackPressedCancellable
    implements Cancellable {
        private final OnBackPressedCallback onBackPressedCallback;
        final OnBackPressedDispatcher this$0;

        public OnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, OnBackPressedCallback onBackPressedCallback) {
            Intrinsics.checkNotNullParameter((Object)onBackPressedCallback, (String)"onBackPressedCallback");
            this.this$0 = onBackPressedDispatcher;
            this.onBackPressedCallback = onBackPressedCallback;
        }

        @Override
        public void cancel() {
            this.this$0.onBackPressedCallbacks.remove((Object)this.onBackPressedCallback);
            if (Intrinsics.areEqual((Object)this.this$0.inProgressCallback, (Object)this.onBackPressedCallback)) {
                this.onBackPressedCallback.handleOnBackCancelled();
                this.this$0.inProgressCallback = null;
            }
            this.onBackPressedCallback.removeCancellable(this);
            Function0<Unit> function0 = this.onBackPressedCallback.getEnabledChangedCallback$activity_release();
            if (function0 != null) {
                function0.invoke();
            }
            this.onBackPressedCallback.setEnabledChangedCallback$activity_release(null);
        }
    }
}

