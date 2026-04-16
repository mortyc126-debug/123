/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.R;
import java.lang.ref.WeakReference;

public final class ViewStubCompat
extends View {
    private OnInflateListener mInflateListener;
    private int mInflatedId;
    private WeakReference<View> mInflatedViewRef;
    private LayoutInflater mInflater;
    private int mLayoutResource = 0;

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        context = context.obtainStyledAttributes(attributeSet, R.styleable.ViewStubCompat, n, 0);
        this.mInflatedId = context.getResourceId(R.styleable.ViewStubCompat_android_inflatedId, -1);
        this.mLayoutResource = context.getResourceId(R.styleable.ViewStubCompat_android_layout, 0);
        this.setId(context.getResourceId(R.styleable.ViewStubCompat_android_id, -1));
        context.recycle();
        this.setVisibility(8);
        this.setWillNotDraw(true);
    }

    protected void dispatchDraw(Canvas canvas) {
    }

    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.mInflatedId;
    }

    public LayoutInflater getLayoutInflater() {
        return this.mInflater;
    }

    public int getLayoutResource() {
        return this.mLayoutResource;
    }

    public View inflate() {
        ViewParent viewParent = this.getParent();
        if (viewParent instanceof ViewGroup) {
            if (this.mLayoutResource != 0) {
                ViewGroup viewGroup = (ViewGroup)viewParent;
                viewParent = this.mInflater != null ? this.mInflater : LayoutInflater.from((Context)this.getContext());
                View view = viewParent.inflate(this.mLayoutResource, viewGroup, false);
                if (this.mInflatedId != -1) {
                    view.setId(this.mInflatedId);
                }
                int n = viewGroup.indexOfChild((View)this);
                viewGroup.removeViewInLayout((View)this);
                viewParent = this.getLayoutParams();
                if (viewParent != null) {
                    viewGroup.addView(view, n, (ViewGroup.LayoutParams)viewParent);
                } else {
                    viewGroup.addView(view, n);
                }
                this.mInflatedViewRef = new WeakReference<View>(view);
                if (this.mInflateListener != null) {
                    this.mInflateListener.onInflate(this, view);
                }
                return view;
            }
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
    }

    protected void onMeasure(int n, int n2) {
        this.setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int n) {
        this.mInflatedId = n;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.mInflater = layoutInflater;
    }

    public void setLayoutResource(int n) {
        this.mLayoutResource = n;
    }

    public void setOnInflateListener(OnInflateListener onInflateListener) {
        this.mInflateListener = onInflateListener;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void setVisibility(int n) {
        if (this.mInflatedViewRef != null) {
            View view = (View)this.mInflatedViewRef.get();
            if (view == null) throw new IllegalStateException("setVisibility called on un-referenced view");
            view.setVisibility(n);
            return;
        } else {
            super.setVisibility(n);
            if (n != 0 && n != 4) return;
            this.inflate();
        }
    }

    public static interface OnInflateListener {
        public void onInflate(ViewStubCompat var1, View var2);
    }
}

