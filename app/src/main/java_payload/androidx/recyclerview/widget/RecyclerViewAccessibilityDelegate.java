/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.accessibility.AccessibilityEvent
 */
package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Map;
import java.util.WeakHashMap;

public class RecyclerViewAccessibilityDelegate
extends AccessibilityDelegateCompat {
    private final ItemDelegate mItemDelegate;
    final RecyclerView mRecyclerView;

    public RecyclerViewAccessibilityDelegate(RecyclerView object) {
        this.mRecyclerView = object;
        object = this.getItemDelegate();
        this.mItemDelegate = object != null && object instanceof ItemDelegate ? (ItemDelegate)object : new ItemDelegate(this);
    }

    public AccessibilityDelegateCompat getItemDelegate() {
        return this.mItemDelegate;
    }

    @Override
    public void onInitializeAccessibilityEvent(View object, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent((View)object, accessibilityEvent);
        if (object instanceof RecyclerView && !this.shouldIgnore() && ((RecyclerView)(object = (RecyclerView)object)).getLayoutManager() != null) {
            ((RecyclerView)object).getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
        }
    }

    @Override
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        if (!this.shouldIgnore() && this.mRecyclerView.getLayoutManager() != null) {
            this.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat);
        }
    }

    @Override
    public boolean performAccessibilityAction(View view, int n, Bundle bundle) {
        if (super.performAccessibilityAction(view, n, bundle)) {
            return true;
        }
        if (!this.shouldIgnore() && this.mRecyclerView.getLayoutManager() != null) {
            return this.mRecyclerView.getLayoutManager().performAccessibilityAction(n, bundle);
        }
        return false;
    }

    boolean shouldIgnore() {
        return this.mRecyclerView.hasPendingAdapterUpdates();
    }

    public static class ItemDelegate
    extends AccessibilityDelegateCompat {
        private Map<View, AccessibilityDelegateCompat> mOriginalItemDelegates = new WeakHashMap<View, AccessibilityDelegateCompat>();
        final RecyclerViewAccessibilityDelegate mRecyclerViewDelegate;

        public ItemDelegate(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
            this.mRecyclerViewDelegate = recyclerViewAccessibilityDelegate;
        }

        @Override
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(view);
            if (accessibilityDelegateCompat != null) {
                return accessibilityDelegateCompat.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override
        public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(view);
            if (accessibilityDelegateCompat != null) {
                return accessibilityDelegateCompat.getAccessibilityNodeProvider(view);
            }
            return super.getAccessibilityNodeProvider(view);
        }

        AccessibilityDelegateCompat getAndRemoveOriginalDelegateForItem(View view) {
            return this.mOriginalItemDelegates.remove(view);
        }

        @Override
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(view);
            if (accessibilityDelegateCompat != null) {
                accessibilityDelegateCompat.onInitializeAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (!this.mRecyclerViewDelegate.shouldIgnore() && this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager() != null) {
                this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
                AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(view);
                if (accessibilityDelegateCompat != null) {
                    accessibilityDelegateCompat.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                } else {
                    super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                }
            } else {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            }
        }

        @Override
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(view);
            if (accessibilityDelegateCompat != null) {
                accessibilityDelegateCompat.onPopulateAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(viewGroup);
            if (accessibilityDelegateCompat != null) {
                return accessibilityDelegateCompat.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override
        public boolean performAccessibilityAction(View view, int n, Bundle bundle) {
            if (!this.mRecyclerViewDelegate.shouldIgnore() && this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager() != null) {
                AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(view);
                if (accessibilityDelegateCompat != null ? accessibilityDelegateCompat.performAccessibilityAction(view, n, bundle) : super.performAccessibilityAction(view, n, bundle)) {
                    return true;
                }
                return this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(view, n, bundle);
            }
            return super.performAccessibilityAction(view, n, bundle);
        }

        void saveOriginalDelegate(View view) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = ViewCompat.getAccessibilityDelegate(view);
            if (accessibilityDelegateCompat != null && accessibilityDelegateCompat != this) {
                this.mOriginalItemDelegates.put(view, accessibilityDelegateCompat);
            }
        }

        @Override
        public void sendAccessibilityEvent(View view, int n) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(view);
            if (accessibilityDelegateCompat != null) {
                accessibilityDelegateCompat.sendAccessibilityEvent(view, n);
            } else {
                super.sendAccessibilityEvent(view, n);
            }
        }

        @Override
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(view);
            if (accessibilityDelegateCompat != null) {
                accessibilityDelegateCompat.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            } else {
                super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        }
    }
}

