package com.google.android.material.bottomsheet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes3.dex */
public class BottomSheetDragHandleView extends AppCompatImageView implements AccessibilityManager.AccessibilityStateChangeListener {
    private static final int DEF_STYLE_RES = R.style.Widget_Material3_BottomSheet_DragHandle;
    private final AccessibilityManager accessibilityManager;
    private boolean accessibilityServiceEnabled;
    private BottomSheetBehavior<?> bottomSheetBehavior;
    private final BottomSheetBehavior.BottomSheetCallback bottomSheetCallback;
    private final String clickFeedback;
    private final String clickToCollapseActionLabel;
    private boolean clickToExpand;
    private final String clickToExpandActionLabel;
    private boolean interactable;

    public BottomSheetDragHandleView(Context context) {
        this(context, null);
    }

    public BottomSheetDragHandleView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.bottomSheetDragHandleStyle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BottomSheetDragHandleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(MaterialThemeOverlay.wrap(context, attrs, defStyleAttr, DEF_STYLE_RES), attrs, defStyleAttr);
        this.clickToExpandActionLabel = getResources().getString(R.string.bottomsheet_action_expand);
        this.clickToCollapseActionLabel = getResources().getString(R.string.bottomsheet_action_collapse);
        this.clickFeedback = getResources().getString(R.string.bottomsheet_drag_handle_clicked);
        this.bottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() { // from class: com.google.android.material.bottomsheet.BottomSheetDragHandleView.1
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(View bottomSheet, int newState) {
                BottomSheetDragHandleView.this.onBottomSheetStateChanged(newState);
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(View bottomSheet, float slideOffset) {
            }
        };
        Context context2 = getContext();
        this.accessibilityManager = (AccessibilityManager) context2.getSystemService("accessibility");
        updateInteractableState();
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegateCompat() { // from class: com.google.android.material.bottomsheet.BottomSheetDragHandleView.2
            public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
                super.onPopulateAccessibilityEvent(host, event);
                if (event.getEventType() == 1) {
                    BottomSheetDragHandleView.this.expandOrCollapseBottomSheetIfPossible();
                }
            }
        });
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setBottomSheetBehavior(findParentBottomSheetBehavior());
        if (this.accessibilityManager != null) {
            this.accessibilityManager.addAccessibilityStateChangeListener(this);
            onAccessibilityStateChanged(this.accessibilityManager.isEnabled());
        }
    }

    protected void onDetachedFromWindow() {
        if (this.accessibilityManager != null) {
            this.accessibilityManager.removeAccessibilityStateChangeListener(this);
        }
        setBottomSheetBehavior(null);
        super.onDetachedFromWindow();
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public void onAccessibilityStateChanged(boolean enabled) {
        this.accessibilityServiceEnabled = enabled;
        updateInteractableState();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setBottomSheetBehavior(BottomSheetBehavior<?> behavior) {
        if (this.bottomSheetBehavior != null) {
            this.bottomSheetBehavior.removeBottomSheetCallback(this.bottomSheetCallback);
            this.bottomSheetBehavior.setAccessibilityDelegateView(null);
        }
        this.bottomSheetBehavior = behavior;
        if (this.bottomSheetBehavior != null) {
            this.bottomSheetBehavior.setAccessibilityDelegateView(this);
            onBottomSheetStateChanged(this.bottomSheetBehavior.getState());
            this.bottomSheetBehavior.addBottomSheetCallback(this.bottomSheetCallback);
        }
        updateInteractableState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void onBottomSheetStateChanged(int state) {
        if (state == 4) {
            this.clickToExpand = true;
        } else if (state == 3) {
            this.clickToExpand = false;
        }
        ViewCompat.replaceAccessibilityAction(this, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK, this.clickToExpand ? this.clickToExpandActionLabel : this.clickToCollapseActionLabel, new AccessibilityViewCommand() { // from class: com.google.android.material.bottomsheet.BottomSheetDragHandleView$$ExternalSyntheticLambda0
            public final boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                return this.f$0.m3xa7b4c95f(view, commandArguments);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onBottomSheetStateChanged$0$com-google-android-material-bottomsheet-BottomSheetDragHandleView, reason: not valid java name */
    /* synthetic */ boolean m3xa7b4c95f(View v, AccessibilityViewCommand.CommandArguments args) {
        return expandOrCollapseBottomSheetIfPossible();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateInteractableState() {
        this.interactable = this.accessibilityServiceEnabled && this.bottomSheetBehavior != null;
        ViewCompat.setImportantForAccessibility(this, this.bottomSheetBehavior == null ? 2 : 1);
        setClickable(this.interactable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean expandOrCollapseBottomSheetIfPossible() {
        boolean z = false;
        if (!this.interactable) {
            return false;
        }
        announceAccessibilityEvent(this.clickFeedback);
        if (!this.bottomSheetBehavior.isFitToContents() && !this.bottomSheetBehavior.shouldSkipHalfExpandedStateWhenDragging()) {
            z = true;
        }
        boolean canHalfExpand = z;
        int currentState = this.bottomSheetBehavior.getState();
        int nextState = 6;
        if (currentState == 4) {
            if (!canHalfExpand) {
                nextState = 3;
            }
        } else if (currentState == 3) {
            if (!canHalfExpand) {
                nextState = 4;
            }
        } else {
            nextState = this.clickToExpand ? 3 : 4;
        }
        this.bottomSheetBehavior.setState(nextState);
        return true;
    }

    private void announceAccessibilityEvent(String announcement) {
        if (this.accessibilityManager == null) {
            return;
        }
        AccessibilityEvent announce = AccessibilityEvent.obtain(Http2.INITIAL_MAX_FRAME_SIZE);
        announce.getText().add(announcement);
        this.accessibilityManager.sendAccessibilityEvent(announce);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.View] */
    private BottomSheetBehavior<?> findParentBottomSheetBehavior() {
        ?? r0 = this;
        while (true) {
            View parentView = getParentView(r0);
            r0 = parentView;
            if (parentView != null) {
                CoordinatorLayout.LayoutParams layoutParams = r0.getLayoutParams();
                if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                    CoordinatorLayout.Behavior<?> behavior = layoutParams.getBehavior();
                    if (behavior instanceof BottomSheetBehavior) {
                        return (BottomSheetBehavior) behavior;
                    }
                }
            } else {
                return null;
            }
        }
    }

    private static View getParentView(View view) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }
}
