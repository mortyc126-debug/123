/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Parcelable
 *  android.view.View
 *  android.view.View$OnLayoutChangeListener
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.widget.FrameLayout
 */
package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.collection.ArraySet;
import androidx.collection.LongSparseArray;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentViewHolder;
import androidx.viewpager2.adapter.StatefulAdapter;
import androidx.viewpager2.widget.ViewPager2;

public abstract class FragmentStateAdapter
extends RecyclerView.Adapter<FragmentViewHolder>
implements StatefulAdapter {
    private static final long GRACE_WINDOW_TIME_MS = 10000L;
    private static final String KEY_PREFIX_FRAGMENT = "f#";
    private static final String KEY_PREFIX_STATE = "s#";
    final FragmentManager mFragmentManager;
    private FragmentMaxLifecycleEnforcer mFragmentMaxLifecycleEnforcer;
    final LongSparseArray<Fragment> mFragments = new LongSparseArray();
    private boolean mHasStaleFragments = false;
    boolean mIsInGracePeriod = false;
    private final LongSparseArray<Integer> mItemIdToViewHolder;
    final Lifecycle mLifecycle;
    private final LongSparseArray<Fragment.SavedState> mSavedStates = new LongSparseArray();

    public FragmentStateAdapter(Fragment fragment) {
        this(fragment.getChildFragmentManager(), fragment.getLifecycle());
    }

    public FragmentStateAdapter(FragmentActivity fragmentActivity) {
        this(fragmentActivity.getSupportFragmentManager(), fragmentActivity.getLifecycle());
    }

    public FragmentStateAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        this.mItemIdToViewHolder = new LongSparseArray();
        this.mFragmentManager = fragmentManager;
        this.mLifecycle = lifecycle;
        super.setHasStableIds(true);
    }

    private static String createKey(String string2, long l) {
        return string2 + l;
    }

    private void ensureFragment(int n) {
        long l = this.getItemId(n);
        if (!this.mFragments.containsKey(l)) {
            Fragment fragment = this.createFragment(n);
            fragment.setInitialSavedState(this.mSavedStates.get(l));
            this.mFragments.put(l, fragment);
        }
    }

    private boolean isFragmentViewBound(long l) {
        boolean bl = this.mItemIdToViewHolder.containsKey(l);
        boolean bl2 = true;
        if (bl) {
            return true;
        }
        Fragment fragment = this.mFragments.get(l);
        if (fragment == null) {
            return false;
        }
        if ((fragment = fragment.getView()) == null) {
            return false;
        }
        if (fragment.getParent() == null) {
            bl2 = false;
        }
        return bl2;
    }

    private static boolean isValidKey(String string2, String string3) {
        boolean bl = string2.startsWith(string3) && string2.length() > string3.length();
        return bl;
    }

    private Long itemForViewHolder(int n) {
        Long l = null;
        for (int i = 0; i < this.mItemIdToViewHolder.size(); ++i) {
            Long l2 = l;
            if (this.mItemIdToViewHolder.valueAt(i) == n) {
                if (l == null) {
                    l2 = this.mItemIdToViewHolder.keyAt(i);
                } else {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
            }
            l = l2;
        }
        return l;
    }

    private static long parseIdFromKey(String string2, String string3) {
        return Long.parseLong(string2.substring(string3.length()));
    }

    private void removeFragment(long l) {
        ViewParent viewParent;
        Fragment fragment = this.mFragments.get(l);
        if (fragment == null) {
            return;
        }
        if (fragment.getView() != null && (viewParent = fragment.getView().getParent()) != null) {
            ((FrameLayout)viewParent).removeAllViews();
        }
        if (!this.containsItem(l)) {
            this.mSavedStates.remove(l);
        }
        if (!fragment.isAdded()) {
            this.mFragments.remove(l);
            return;
        }
        if (this.shouldDelayFragmentTransactions()) {
            this.mHasStaleFragments = true;
            return;
        }
        if (fragment.isAdded() && this.containsItem(l)) {
            this.mSavedStates.put(l, this.mFragmentManager.saveFragmentInstanceState(fragment));
        }
        this.mFragmentManager.beginTransaction().remove(fragment).commitNow();
        this.mFragments.remove(l);
    }

    private void scheduleGracePeriodEnd() {
        Handler handler = new Handler(Looper.getMainLooper());
        Runnable runnable2 = new Runnable(this){
            final FragmentStateAdapter this$0;
            {
                this.this$0 = fragmentStateAdapter;
            }

            @Override
            public void run() {
                this.this$0.mIsInGracePeriod = false;
                this.this$0.gcFragments();
            }
        };
        this.mLifecycle.addObserver(new LifecycleEventObserver(this, handler, runnable2){
            final FragmentStateAdapter this$0;
            final Handler val$handler;
            final Runnable val$runnable;
            {
                this.this$0 = fragmentStateAdapter;
                this.val$handler = handler;
                this.val$runnable = runnable2;
            }

            @Override
            public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    this.val$handler.removeCallbacks(this.val$runnable);
                    lifecycleOwner.getLifecycle().removeObserver(this);
                }
            }
        });
        handler.postDelayed(runnable2, 10000L);
    }

    private void scheduleViewAttach(Fragment fragment, FrameLayout frameLayout) {
        this.mFragmentManager.registerFragmentLifecycleCallbacks(new FragmentManager.FragmentLifecycleCallbacks(this, fragment, frameLayout){
            final FragmentStateAdapter this$0;
            final FrameLayout val$container;
            final Fragment val$fragment;
            {
                this.this$0 = fragmentStateAdapter;
                this.val$fragment = fragment;
                this.val$container = frameLayout;
            }

            @Override
            public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
                if (fragment == this.val$fragment) {
                    fragmentManager.unregisterFragmentLifecycleCallbacks(this);
                    this.this$0.addViewToContainer(view, this.val$container);
                }
            }
        }, false);
    }

    void addViewToContainer(View view, FrameLayout frameLayout) {
        if (frameLayout.getChildCount() <= 1) {
            if (view.getParent() == frameLayout) {
                return;
            }
            if (frameLayout.getChildCount() > 0) {
                frameLayout.removeAllViews();
            }
            if (view.getParent() != null) {
                ((ViewGroup)view.getParent()).removeView(view);
            }
            frameLayout.addView(view);
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    public boolean containsItem(long l) {
        boolean bl = l >= 0L && l < (long)this.getItemCount();
        return bl;
    }

    public abstract Fragment createFragment(int var1);

    void gcFragments() {
        if (this.mHasStaleFragments && !this.shouldDelayFragmentTransactions()) {
            long l;
            int n;
            Object object = new ArraySet();
            for (n = 0; n < this.mFragments.size(); ++n) {
                l = this.mFragments.keyAt(n);
                if (this.containsItem(l)) continue;
                object.add(l);
                this.mItemIdToViewHolder.remove(l);
            }
            if (!this.mIsInGracePeriod) {
                this.mHasStaleFragments = false;
                for (n = 0; n < this.mFragments.size(); ++n) {
                    l = this.mFragments.keyAt(n);
                    if (this.isFragmentViewBound(l)) continue;
                    object.add(l);
                }
            }
            object = object.iterator();
            while (object.hasNext()) {
                this.removeFragment((Long)object.next());
            }
            return;
        }
    }

    @Override
    public long getItemId(int n) {
        return n;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        boolean bl = this.mFragmentMaxLifecycleEnforcer == null;
        Preconditions.checkArgument(bl);
        this.mFragmentMaxLifecycleEnforcer = new FragmentMaxLifecycleEnforcer(this);
        this.mFragmentMaxLifecycleEnforcer.register(recyclerView);
    }

    @Override
    public final void onBindViewHolder(FragmentViewHolder fragmentViewHolder, int n) {
        long l = fragmentViewHolder.getItemId();
        int n2 = fragmentViewHolder.getContainer().getId();
        Long l2 = this.itemForViewHolder(n2);
        if (l2 != null && l2 != l) {
            this.removeFragment(l2);
            this.mItemIdToViewHolder.remove(l2);
        }
        this.mItemIdToViewHolder.put(l, n2);
        this.ensureFragment(n);
        l2 = fragmentViewHolder.getContainer();
        if (ViewCompat.isAttachedToWindow((View)l2)) {
            if (l2.getParent() == null) {
                l2.addOnLayoutChangeListener(new View.OnLayoutChangeListener(this, (FrameLayout)l2, fragmentViewHolder){
                    final FragmentStateAdapter this$0;
                    final FrameLayout val$container;
                    final FragmentViewHolder val$holder;
                    {
                        this.this$0 = fragmentStateAdapter;
                        this.val$container = frameLayout;
                        this.val$holder = fragmentViewHolder;
                    }

                    public void onLayoutChange(View view, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
                        if (this.val$container.getParent() != null) {
                            this.val$container.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
                            this.this$0.placeFragmentInViewHolder(this.val$holder);
                        }
                    }
                });
            } else {
                throw new IllegalStateException("Design assumption violated.");
            }
        }
        this.gcFragments();
    }

    @Override
    public final FragmentViewHolder onCreateViewHolder(ViewGroup viewGroup, int n) {
        return FragmentViewHolder.create(viewGroup);
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.mFragmentMaxLifecycleEnforcer.unregister(recyclerView);
        this.mFragmentMaxLifecycleEnforcer = null;
    }

    @Override
    public final boolean onFailedToRecycleView(FragmentViewHolder fragmentViewHolder) {
        return true;
    }

    @Override
    public final void onViewAttachedToWindow(FragmentViewHolder fragmentViewHolder) {
        this.placeFragmentInViewHolder(fragmentViewHolder);
        this.gcFragments();
    }

    @Override
    public final void onViewRecycled(FragmentViewHolder object) {
        if ((object = this.itemForViewHolder(((FragmentViewHolder)object).getContainer().getId())) != null) {
            this.removeFragment((Long)object);
            this.mItemIdToViewHolder.remove((Long)object);
        }
    }

    void placeFragmentInViewHolder(FragmentViewHolder fragmentViewHolder) {
        Fragment fragment = this.mFragments.get(fragmentViewHolder.getItemId());
        if (fragment != null) {
            FrameLayout frameLayout = fragmentViewHolder.getContainer();
            View view = fragment.getView();
            if (!fragment.isAdded() && view != null) {
                throw new IllegalStateException("Design assumption violated.");
            }
            if (fragment.isAdded() && view == null) {
                this.scheduleViewAttach(fragment, frameLayout);
                return;
            }
            if (fragment.isAdded() && view.getParent() != null) {
                if (view.getParent() != frameLayout) {
                    this.addViewToContainer(view, frameLayout);
                }
                return;
            }
            if (fragment.isAdded()) {
                this.addViewToContainer(view, frameLayout);
                return;
            }
            if (!this.shouldDelayFragmentTransactions()) {
                this.scheduleViewAttach(fragment, frameLayout);
                this.mFragmentManager.beginTransaction().add(fragment, "f" + fragmentViewHolder.getItemId()).setMaxLifecycle(fragment, Lifecycle.State.STARTED).commitNow();
                this.mFragmentMaxLifecycleEnforcer.updateFragmentMaxLifecycle(false);
            } else {
                if (this.mFragmentManager.isDestroyed()) {
                    return;
                }
                this.mLifecycle.addObserver(new LifecycleEventObserver(this, fragmentViewHolder){
                    final FragmentStateAdapter this$0;
                    final FragmentViewHolder val$holder;
                    {
                        this.this$0 = fragmentStateAdapter;
                        this.val$holder = fragmentViewHolder;
                    }

                    @Override
                    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                        if (this.this$0.shouldDelayFragmentTransactions()) {
                            return;
                        }
                        lifecycleOwner.getLifecycle().removeObserver(this);
                        if (ViewCompat.isAttachedToWindow((View)this.val$holder.getContainer())) {
                            this.this$0.placeFragmentInViewHolder(this.val$holder);
                        }
                    }
                });
            }
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    @Override
    public final void restoreState(Parcelable object) {
        if (this.mSavedStates.isEmpty() && this.mFragments.isEmpty()) {
            Bundle bundle = (Bundle)object;
            if (bundle.getClassLoader() == null) {
                bundle.setClassLoader(this.getClass().getClassLoader());
            }
            for (Object object2 : bundle.keySet()) {
                long l;
                if (FragmentStateAdapter.isValidKey((String)object2, KEY_PREFIX_FRAGMENT)) {
                    l = FragmentStateAdapter.parseIdFromKey((String)object2, KEY_PREFIX_FRAGMENT);
                    object2 = this.mFragmentManager.getFragment(bundle, (String)object2);
                    this.mFragments.put(l, (Fragment)object2);
                    continue;
                }
                if (FragmentStateAdapter.isValidKey((String)object2, KEY_PREFIX_STATE)) {
                    l = FragmentStateAdapter.parseIdFromKey((String)object2, KEY_PREFIX_STATE);
                    object2 = (Fragment.SavedState)bundle.getParcelable((String)object2);
                    if (!this.containsItem(l)) continue;
                    this.mSavedStates.put(l, (Fragment.SavedState)object2);
                    continue;
                }
                throw new IllegalArgumentException("Unexpected key in savedState: " + (String)object2);
            }
            if (!this.mFragments.isEmpty()) {
                this.mHasStaleFragments = true;
                this.mIsInGracePeriod = true;
                this.gcFragments();
                this.scheduleGracePeriodEnd();
            }
            return;
        }
        throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
    }

    @Override
    public final Parcelable saveState() {
        long l;
        int n;
        Bundle bundle = new Bundle(this.mFragments.size() + this.mSavedStates.size());
        for (n = 0; n < this.mFragments.size(); ++n) {
            l = this.mFragments.keyAt(n);
            Fragment fragment = this.mFragments.get(l);
            if (fragment == null || !fragment.isAdded()) continue;
            String string2 = FragmentStateAdapter.createKey(KEY_PREFIX_FRAGMENT, l);
            this.mFragmentManager.putFragment(bundle, string2, fragment);
        }
        for (n = 0; n < this.mSavedStates.size(); ++n) {
            l = this.mSavedStates.keyAt(n);
            if (!this.containsItem(l)) continue;
            bundle.putParcelable(FragmentStateAdapter.createKey(KEY_PREFIX_STATE, l), (Parcelable)this.mSavedStates.get(l));
        }
        return bundle;
    }

    @Override
    public final void setHasStableIds(boolean bl) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    boolean shouldDelayFragmentTransactions() {
        return this.mFragmentManager.isStateSaved();
    }

    private static abstract class DataSetChangeObserver
    extends RecyclerView.AdapterDataObserver {
        private DataSetChangeObserver() {
        }

        @Override
        public abstract void onChanged();

        @Override
        public final void onItemRangeChanged(int n, int n2) {
            this.onChanged();
        }

        @Override
        public final void onItemRangeChanged(int n, int n2, Object object) {
            this.onChanged();
        }

        @Override
        public final void onItemRangeInserted(int n, int n2) {
            this.onChanged();
        }

        @Override
        public final void onItemRangeMoved(int n, int n2, int n3) {
            this.onChanged();
        }

        @Override
        public final void onItemRangeRemoved(int n, int n2) {
            this.onChanged();
        }
    }

    class FragmentMaxLifecycleEnforcer {
        private RecyclerView.AdapterDataObserver mDataObserver;
        private LifecycleEventObserver mLifecycleObserver;
        private ViewPager2.OnPageChangeCallback mPageChangeCallback;
        private long mPrimaryItemId;
        private ViewPager2 mViewPager;
        final FragmentStateAdapter this$0;

        FragmentMaxLifecycleEnforcer(FragmentStateAdapter fragmentStateAdapter) {
            this.this$0 = fragmentStateAdapter;
            this.mPrimaryItemId = -1L;
        }

        private ViewPager2 inferViewPager(RecyclerView recyclerView) {
            if ((recyclerView = recyclerView.getParent()) instanceof ViewPager2) {
                return (ViewPager2)((Object)recyclerView);
            }
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + recyclerView);
        }

        void register(RecyclerView recyclerView) {
            this.mViewPager = this.inferViewPager(recyclerView);
            this.mPageChangeCallback = new ViewPager2.OnPageChangeCallback(this){
                final FragmentMaxLifecycleEnforcer this$1;
                {
                    this.this$1 = fragmentMaxLifecycleEnforcer;
                }

                @Override
                public void onPageScrollStateChanged(int n) {
                    this.this$1.updateFragmentMaxLifecycle(false);
                }

                @Override
                public void onPageSelected(int n) {
                    this.this$1.updateFragmentMaxLifecycle(false);
                }
            };
            this.mViewPager.registerOnPageChangeCallback(this.mPageChangeCallback);
            this.mDataObserver = new DataSetChangeObserver(this){
                final FragmentMaxLifecycleEnforcer this$1;
                {
                    this.this$1 = fragmentMaxLifecycleEnforcer;
                }

                @Override
                public void onChanged() {
                    this.this$1.updateFragmentMaxLifecycle(true);
                }
            };
            this.this$0.registerAdapterDataObserver(this.mDataObserver);
            this.mLifecycleObserver = new LifecycleEventObserver(this){
                final FragmentMaxLifecycleEnforcer this$1;
                {
                    this.this$1 = fragmentMaxLifecycleEnforcer;
                }

                @Override
                public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    this.this$1.updateFragmentMaxLifecycle(false);
                }
            };
            this.this$0.mLifecycle.addObserver(this.mLifecycleObserver);
        }

        void unregister(RecyclerView recyclerView) {
            this.inferViewPager(recyclerView).unregisterOnPageChangeCallback(this.mPageChangeCallback);
            this.this$0.unregisterAdapterDataObserver(this.mDataObserver);
            this.this$0.mLifecycle.removeObserver(this.mLifecycleObserver);
            this.mViewPager = null;
        }

        void updateFragmentMaxLifecycle(boolean bl) {
            if (this.this$0.shouldDelayFragmentTransactions()) {
                return;
            }
            if (this.mViewPager.getScrollState() != 0) {
                return;
            }
            if (!this.this$0.mFragments.isEmpty() && this.this$0.getItemCount() != 0) {
                int n = this.mViewPager.getCurrentItem();
                if (n >= this.this$0.getItemCount()) {
                    return;
                }
                long l = this.this$0.getItemId(n);
                if (l == this.mPrimaryItemId && !bl) {
                    return;
                }
                Fragment fragment = this.this$0.mFragments.get(l);
                if (fragment != null && fragment.isAdded()) {
                    this.mPrimaryItemId = l;
                    FragmentTransaction fragmentTransaction = this.this$0.mFragmentManager.beginTransaction();
                    fragment = null;
                    for (n = 0; n < this.this$0.mFragments.size(); ++n) {
                        l = this.this$0.mFragments.keyAt(n);
                        Fragment fragment2 = this.this$0.mFragments.valueAt(n);
                        if (!fragment2.isAdded()) continue;
                        if (l != this.mPrimaryItemId) {
                            fragmentTransaction.setMaxLifecycle(fragment2, Lifecycle.State.STARTED);
                        } else {
                            fragment = fragment2;
                        }
                        bl = l == this.mPrimaryItemId;
                        fragment2.setMenuVisibility(bl);
                    }
                    if (fragment != null) {
                        fragmentTransaction.setMaxLifecycle(fragment, Lifecycle.State.RESUMED);
                    }
                    if (!fragmentTransaction.isEmpty()) {
                        fragmentTransaction.commitNow();
                    }
                    return;
                }
                return;
            }
        }
    }
}

