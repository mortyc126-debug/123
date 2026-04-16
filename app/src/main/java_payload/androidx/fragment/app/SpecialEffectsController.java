/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import androidx.core.view.ViewCompat;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStateManager;
import androidx.fragment.app.SpecialEffectsControllerFactory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

abstract class SpecialEffectsController {
    private final ViewGroup mContainer;
    boolean mIsContainerPostponed = false;
    boolean mOperationDirectionIsPop = false;
    final ArrayList<Operation> mPendingOperations = new ArrayList();
    final ArrayList<Operation> mRunningOperations = new ArrayList();

    SpecialEffectsController(ViewGroup viewGroup) {
        this.mContainer = viewGroup;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void enqueue(Operation.State object, Operation.LifecycleImpact lifecycleImpact, FragmentStateManager fragmentStateManager) {
        ArrayList<Operation> arrayList = this.mPendingOperations;
        synchronized (arrayList) {
            CancellationSignal cancellationSignal = new CancellationSignal();
            Operation operation = this.findPendingOperation(fragmentStateManager.getFragment());
            if (operation != null) {
                operation.mergeWith((Operation.State)((Object)object), lifecycleImpact);
                return;
            }
            operation = new FragmentStateManagerOperation((Operation.State)((Object)object), lifecycleImpact, fragmentStateManager, cancellationSignal);
            this.mPendingOperations.add(operation);
            object = new Runnable(this, (FragmentStateManagerOperation)operation){
                final SpecialEffectsController this$0;
                final FragmentStateManagerOperation val$operation;
                {
                    this.this$0 = specialEffectsController;
                    this.val$operation = fragmentStateManagerOperation;
                }

                @Override
                public void run() {
                    if (this.this$0.mPendingOperations.contains(this.val$operation)) {
                        this.val$operation.getFinalState().applyState(this.val$operation.getFragment().mView);
                    }
                }
            };
            operation.addCompletionListener((Runnable)object);
            object = new Runnable(this, (FragmentStateManagerOperation)operation){
                final SpecialEffectsController this$0;
                final FragmentStateManagerOperation val$operation;
                {
                    this.this$0 = specialEffectsController;
                    this.val$operation = fragmentStateManagerOperation;
                }

                @Override
                public void run() {
                    this.this$0.mPendingOperations.remove(this.val$operation);
                    this.this$0.mRunningOperations.remove(this.val$operation);
                }
            };
            operation.addCompletionListener((Runnable)object);
            return;
        }
    }

    private Operation findPendingOperation(Fragment fragment) {
        for (Operation operation : this.mPendingOperations) {
            if (!operation.getFragment().equals(fragment) || operation.isCanceled()) continue;
            return operation;
        }
        return null;
    }

    private Operation findRunningOperation(Fragment fragment) {
        for (Operation operation : this.mRunningOperations) {
            if (!operation.getFragment().equals(fragment) || operation.isCanceled()) continue;
            return operation;
        }
        return null;
    }

    static SpecialEffectsController getOrCreateController(ViewGroup viewGroup, FragmentManager fragmentManager) {
        return SpecialEffectsController.getOrCreateController(viewGroup, fragmentManager.getSpecialEffectsControllerFactory());
    }

    static SpecialEffectsController getOrCreateController(ViewGroup viewGroup, SpecialEffectsControllerFactory object) {
        Object object2 = viewGroup.getTag(R.id.special_effects_controller_view_tag);
        if (object2 instanceof SpecialEffectsController) {
            return (SpecialEffectsController)object2;
        }
        object = object.createController(viewGroup);
        viewGroup.setTag(R.id.special_effects_controller_view_tag, object);
        return object;
    }

    private void updateFinalState() {
        for (Operation operation : this.mPendingOperations) {
            if (operation.getLifecycleImpact() != Operation.LifecycleImpact.ADDING) continue;
            operation.mergeWith(Operation.State.from(operation.getFragment().requireView().getVisibility()), Operation.LifecycleImpact.NONE);
        }
    }

    void enqueueAdd(Operation.State state, FragmentStateManager fragmentStateManager) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v((String)"FragmentManager", (String)("SpecialEffectsController: Enqueuing add operation for fragment " + fragmentStateManager.getFragment()));
        }
        this.enqueue(state, Operation.LifecycleImpact.ADDING, fragmentStateManager);
    }

    void enqueueHide(FragmentStateManager fragmentStateManager) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v((String)"FragmentManager", (String)("SpecialEffectsController: Enqueuing hide operation for fragment " + fragmentStateManager.getFragment()));
        }
        this.enqueue(Operation.State.GONE, Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    void enqueueRemove(FragmentStateManager fragmentStateManager) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v((String)"FragmentManager", (String)("SpecialEffectsController: Enqueuing remove operation for fragment " + fragmentStateManager.getFragment()));
        }
        this.enqueue(Operation.State.REMOVED, Operation.LifecycleImpact.REMOVING, fragmentStateManager);
    }

    void enqueueShow(FragmentStateManager fragmentStateManager) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v((String)"FragmentManager", (String)("SpecialEffectsController: Enqueuing show operation for fragment " + fragmentStateManager.getFragment()));
        }
        this.enqueue(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    abstract void executeOperations(List<Operation> var1, boolean var2);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void executePendingOperations() {
        if (this.mIsContainerPostponed) {
            return;
        }
        if (!ViewCompat.isAttachedToWindow((View)this.mContainer)) {
            this.forceCompleteAllOperations();
            this.mOperationDirectionIsPop = false;
            return;
        }
        ArrayList<Operation> arrayList = this.mPendingOperations;
        synchronized (arrayList) {
            if (!this.mPendingOperations.isEmpty()) {
                Serializable serializable = new ArrayList(this.mRunningOperations);
                this.mRunningOperations.clear();
                Iterator<Operation> iterator2 = ((ArrayList)serializable).iterator();
                while (iterator2.hasNext()) {
                    Operation operation = iterator2.next();
                    if (FragmentManager.isLoggingEnabled(2)) {
                        serializable = new StringBuilder();
                        Log.v((String)"FragmentManager", (String)((StringBuilder)serializable).append("SpecialEffectsController: Cancelling operation ").append(operation).toString());
                    }
                    operation.cancel();
                    if (operation.isComplete()) continue;
                    this.mRunningOperations.add(operation);
                }
                this.updateFinalState();
                serializable = new ArrayList(this.mPendingOperations);
                this.mPendingOperations.clear();
                this.mRunningOperations.addAll((Collection<Operation>)((Object)serializable));
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v((String)"FragmentManager", (String)"SpecialEffectsController: Executing pending operations");
                }
                iterator2 = ((ArrayList)serializable).iterator();
                while (iterator2.hasNext()) {
                    iterator2.next().onStart();
                }
                this.executeOperations((List<Operation>)((Object)serializable), this.mOperationDirectionIsPop);
                this.mOperationDirectionIsPop = false;
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v((String)"FragmentManager", (String)"SpecialEffectsController: Finished executing pending operations");
                }
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void forceCompleteAllOperations() {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v((String)"FragmentManager", (String)"SpecialEffectsController: Forcing all operations to complete");
        }
        boolean bl = ViewCompat.isAttachedToWindow((View)this.mContainer);
        ArrayList<Operation> arrayList = this.mPendingOperations;
        synchronized (arrayList) {
            StringBuilder stringBuilder;
            Operation operation;
            this.updateFinalState();
            Object object = this.mPendingOperations.iterator();
            while (object.hasNext()) {
                object.next().onStart();
            }
            object = new ArrayList(this.mRunningOperations);
            Iterator<Operation> iterator2 = ((ArrayList)object).iterator();
            while (iterator2.hasNext()) {
                operation = iterator2.next();
                if (FragmentManager.isLoggingEnabled(2)) {
                    object = new StringBuilder();
                    stringBuilder = ((StringBuilder)object).append("SpecialEffectsController: ");
                    if (bl) {
                        object = "";
                    } else {
                        object = new StringBuilder();
                        object = ((StringBuilder)object).append("Container ").append(this.mContainer).append(" is not attached to window. ").toString();
                    }
                    Log.v((String)"FragmentManager", (String)stringBuilder.append((String)object).append("Cancelling running operation ").append(operation).toString());
                }
                operation.cancel();
            }
            object = new ArrayList(this.mPendingOperations);
            iterator2 = ((ArrayList)object).iterator();
            while (iterator2.hasNext()) {
                operation = iterator2.next();
                if (FragmentManager.isLoggingEnabled(2)) {
                    object = new StringBuilder();
                    stringBuilder = ((StringBuilder)object).append("SpecialEffectsController: ");
                    if (bl) {
                        object = "";
                    } else {
                        object = new StringBuilder();
                        object = ((StringBuilder)object).append("Container ").append(this.mContainer).append(" is not attached to window. ").toString();
                    }
                    Log.v((String)"FragmentManager", (String)stringBuilder.append((String)object).append("Cancelling pending operation ").append(operation).toString());
                }
                operation.cancel();
            }
            return;
        }
    }

    void forcePostponedExecutePendingOperations() {
        if (this.mIsContainerPostponed) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v((String)"FragmentManager", (String)"SpecialEffectsController: Forcing postponed operations");
            }
            this.mIsContainerPostponed = false;
            this.executePendingOperations();
        }
    }

    Operation.LifecycleImpact getAwaitingCompletionLifecycleImpact(FragmentStateManager object) {
        Operation.LifecycleImpact lifecycleImpact = null;
        Operation operation = this.findPendingOperation(((FragmentStateManager)object).getFragment());
        if (operation != null) {
            lifecycleImpact = operation.getLifecycleImpact();
        }
        if ((object = this.findRunningOperation(((FragmentStateManager)object).getFragment())) != null && (lifecycleImpact == null || lifecycleImpact == Operation.LifecycleImpact.NONE)) {
            return ((Operation)object).getLifecycleImpact();
        }
        return lifecycleImpact;
    }

    public ViewGroup getContainer() {
        return this.mContainer;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void markPostponedState() {
        ArrayList<Operation> arrayList = this.mPendingOperations;
        synchronized (arrayList) {
            this.updateFinalState();
            this.mIsContainerPostponed = false;
            for (int i = this.mPendingOperations.size() - 1; i >= 0; --i) {
                Operation operation = this.mPendingOperations.get(i);
                Operation.State state = Operation.State.from(operation.getFragment().mView);
                if (operation.getFinalState() != Operation.State.VISIBLE || state == Operation.State.VISIBLE) continue;
                this.mIsContainerPostponed = operation.getFragment().isPostponed();
                break;
            }
            return;
        }
    }

    void updateOperationDirection(boolean bl) {
        this.mOperationDirectionIsPop = bl;
    }

    private static class FragmentStateManagerOperation
    extends Operation {
        private final FragmentStateManager mFragmentStateManager;

        FragmentStateManagerOperation(Operation.State state, Operation.LifecycleImpact lifecycleImpact, FragmentStateManager fragmentStateManager, CancellationSignal cancellationSignal) {
            super(state, lifecycleImpact, fragmentStateManager.getFragment(), cancellationSignal);
            this.mFragmentStateManager = fragmentStateManager;
        }

        @Override
        public void complete() {
            super.complete();
            this.mFragmentStateManager.moveToExpectedState();
        }

        @Override
        void onStart() {
            block6: {
                block5: {
                    if (this.getLifecycleImpact() != Operation.LifecycleImpact.ADDING) break block5;
                    Fragment fragment = this.mFragmentStateManager.getFragment();
                    View view = fragment.mView.findFocus();
                    if (view != null) {
                        fragment.setFocusedView(view);
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v((String)"FragmentManager", (String)("requestFocus: Saved focused view " + view + " for Fragment " + fragment));
                        }
                    }
                    if ((view = this.getFragment().requireView()).getParent() == null) {
                        this.mFragmentStateManager.addViewToContainer();
                        view.setAlpha(0.0f);
                    }
                    if (view.getAlpha() == 0.0f && view.getVisibility() == 0) {
                        view.setVisibility(4);
                    }
                    view.setAlpha(fragment.getPostOnViewCreatedAlpha());
                    break block6;
                }
                if (this.getLifecycleImpact() != Operation.LifecycleImpact.REMOVING) break block6;
                Fragment fragment = this.mFragmentStateManager.getFragment();
                View view = fragment.requireView();
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v((String)"FragmentManager", (String)("Clearing focus " + view.findFocus() + " on view " + view + " for Fragment " + fragment));
                }
                view.clearFocus();
            }
        }
    }

    static class Operation {
        private final List<Runnable> mCompletionListeners = new ArrayList<Runnable>();
        private State mFinalState;
        private final Fragment mFragment;
        private boolean mIsCanceled = false;
        private boolean mIsComplete = false;
        private LifecycleImpact mLifecycleImpact;
        private final HashSet<CancellationSignal> mSpecialEffectsSignals = new HashSet();

        Operation(State state, LifecycleImpact lifecycleImpact, Fragment fragment, CancellationSignal cancellationSignal) {
            this.mFinalState = state;
            this.mLifecycleImpact = lifecycleImpact;
            this.mFragment = fragment;
            cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener(this){
                final Operation this$0;
                {
                    this.this$0 = operation;
                }

                @Override
                public void onCancel() {
                    this.this$0.cancel();
                }
            });
        }

        final void addCompletionListener(Runnable runnable2) {
            this.mCompletionListeners.add(runnable2);
        }

        final void cancel() {
            if (this.isCanceled()) {
                return;
            }
            this.mIsCanceled = true;
            if (this.mSpecialEffectsSignals.isEmpty()) {
                this.complete();
            } else {
                Iterator<CancellationSignal> iterator2 = new ArrayList<CancellationSignal>(this.mSpecialEffectsSignals).iterator();
                while (iterator2.hasNext()) {
                    iterator2.next().cancel();
                }
            }
        }

        public void complete() {
            if (this.mIsComplete) {
                return;
            }
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v((String)"FragmentManager", (String)("SpecialEffectsController: " + this + " has called complete."));
            }
            this.mIsComplete = true;
            Iterator<Runnable> iterator2 = this.mCompletionListeners.iterator();
            while (iterator2.hasNext()) {
                iterator2.next().run();
            }
        }

        public final void completeSpecialEffect(CancellationSignal cancellationSignal) {
            if (this.mSpecialEffectsSignals.remove(cancellationSignal) && this.mSpecialEffectsSignals.isEmpty()) {
                this.complete();
            }
        }

        public State getFinalState() {
            return this.mFinalState;
        }

        public final Fragment getFragment() {
            return this.mFragment;
        }

        LifecycleImpact getLifecycleImpact() {
            return this.mLifecycleImpact;
        }

        final boolean isCanceled() {
            return this.mIsCanceled;
        }

        final boolean isComplete() {
            return this.mIsComplete;
        }

        public final void markStartedSpecialEffect(CancellationSignal cancellationSignal) {
            this.onStart();
            this.mSpecialEffectsSignals.add(cancellationSignal);
        }

        final void mergeWith(State state, LifecycleImpact lifecycleImpact) {
            switch (3.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact[lifecycleImpact.ordinal()]) {
                default: {
                    break;
                }
                case 3: {
                    if (this.mFinalState == State.REMOVED) break;
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v((String)"FragmentManager", (String)("SpecialEffectsController: For fragment " + this.mFragment + " mFinalState = " + (Object)((Object)this.mFinalState) + " -> " + (Object)((Object)state) + ". "));
                    }
                    this.mFinalState = state;
                    break;
                }
                case 2: {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v((String)"FragmentManager", (String)("SpecialEffectsController: For fragment " + this.mFragment + " mFinalState = " + (Object)((Object)this.mFinalState) + " -> REMOVED. mLifecycleImpact  = " + (Object)((Object)this.mLifecycleImpact) + " to REMOVING."));
                    }
                    this.mFinalState = State.REMOVED;
                    this.mLifecycleImpact = LifecycleImpact.REMOVING;
                    break;
                }
                case 1: {
                    if (this.mFinalState != State.REMOVED) break;
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v((String)"FragmentManager", (String)("SpecialEffectsController: For fragment " + this.mFragment + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + (Object)((Object)this.mLifecycleImpact) + " to ADDING."));
                    }
                    this.mFinalState = State.VISIBLE;
                    this.mLifecycleImpact = LifecycleImpact.ADDING;
                }
            }
        }

        void onStart() {
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Operation ");
            stringBuilder.append("{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append("} ");
            stringBuilder.append("{");
            stringBuilder.append("mFinalState = ");
            stringBuilder.append((Object)this.mFinalState);
            stringBuilder.append("} ");
            stringBuilder.append("{");
            stringBuilder.append("mLifecycleImpact = ");
            stringBuilder.append((Object)this.mLifecycleImpact);
            stringBuilder.append("} ");
            stringBuilder.append("{");
            stringBuilder.append("mFragment = ");
            stringBuilder.append(this.mFragment);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        static enum LifecycleImpact {
            NONE,
            ADDING,
            REMOVING;

        }

        static enum State {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;


            static State from(int n) {
                switch (n) {
                    default: {
                        throw new IllegalArgumentException("Unknown visibility " + n);
                    }
                    case 8: {
                        return GONE;
                    }
                    case 4: {
                        return INVISIBLE;
                    }
                    case 0: 
                }
                return VISIBLE;
            }

            static State from(View view) {
                if (view.getAlpha() == 0.0f && view.getVisibility() == 0) {
                    return INVISIBLE;
                }
                return State.from(view.getVisibility());
            }

            void applyState(View view) {
                switch (this) {
                    default: {
                        break;
                    }
                    case INVISIBLE: {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v((String)"FragmentManager", (String)("SpecialEffectsController: Setting view " + view + " to INVISIBLE"));
                        }
                        view.setVisibility(4);
                        break;
                    }
                    case GONE: {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v((String)"FragmentManager", (String)("SpecialEffectsController: Setting view " + view + " to GONE"));
                        }
                        view.setVisibility(8);
                        break;
                    }
                    case VISIBLE: {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v((String)"FragmentManager", (String)("SpecialEffectsController: Setting view " + view + " to VISIBLE"));
                        }
                        view.setVisibility(0);
                        break;
                    }
                    case REMOVED: {
                        ViewGroup viewGroup = (ViewGroup)view.getParent();
                        if (viewGroup == null) break;
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v((String)"FragmentManager", (String)("SpecialEffectsController: Removing view " + view + " from container " + viewGroup));
                        }
                        viewGroup.removeView(view);
                    }
                }
            }
        }
    }
}

