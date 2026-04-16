/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.util.Log
 *  android.view.View
 */
package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class DividerItemDecoration
extends RecyclerView.ItemDecoration {
    private static final int[] ATTRS = new int[]{16843284};
    public static final int HORIZONTAL = 0;
    private static final String TAG = "DividerItem";
    public static final int VERTICAL = 1;
    private final Rect mBounds = new Rect();
    private Drawable mDivider;
    private int mOrientation;

    public DividerItemDecoration(Context context, int n) {
        context = context.obtainStyledAttributes(ATTRS);
        this.mDivider = context.getDrawable(0);
        if (this.mDivider == null) {
            Log.w((String)TAG, (String)"@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        context.recycle();
        this.setOrientation(n);
    }

    private void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        int n;
        int n2;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            n2 = recyclerView.getPaddingTop();
            n = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), n2, recyclerView.getWidth() - recyclerView.getPaddingRight(), n);
        } else {
            n2 = 0;
            n = recyclerView.getHeight();
        }
        int n3 = recyclerView.getChildCount();
        for (int i = 0; i < n3; ++i) {
            View view = recyclerView.getChildAt(i);
            recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(view, this.mBounds);
            int n4 = this.mBounds.right + Math.round(view.getTranslationX());
            int n5 = this.mDivider.getIntrinsicWidth();
            this.mDivider.setBounds(n4 - n5, n2, n4, n);
            this.mDivider.draw(canvas);
        }
        canvas.restore();
    }

    private void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int n;
        int n2;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            n2 = recyclerView.getPaddingLeft();
            n = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(n2, recyclerView.getPaddingTop(), n, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            n2 = 0;
            n = recyclerView.getWidth();
        }
        int n3 = recyclerView.getChildCount();
        for (int i = 0; i < n3; ++i) {
            View view = recyclerView.getChildAt(i);
            recyclerView.getDecoratedBoundsWithMargins(view, this.mBounds);
            int n4 = this.mBounds.bottom + Math.round(view.getTranslationY());
            int n5 = this.mDivider.getIntrinsicHeight();
            this.mDivider.setBounds(n2, n4 - n5, n, n4);
            this.mDivider.draw(canvas);
        }
        canvas.restore();
    }

    public Drawable getDrawable() {
        return this.mDivider;
    }

    @Override
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.mDivider == null) {
            rect.set(0, 0, 0, 0);
            return;
        }
        if (this.mOrientation == 1) {
            rect.set(0, 0, 0, this.mDivider.getIntrinsicHeight());
        } else {
            rect.set(0, 0, this.mDivider.getIntrinsicWidth(), 0);
        }
    }

    @Override
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getLayoutManager() != null && this.mDivider != null) {
            if (this.mOrientation == 1) {
                this.drawVertical(canvas, recyclerView);
            } else {
                this.drawHorizontal(canvas, recyclerView);
            }
            return;
        }
    }

    public void setDrawable(Drawable drawable2) {
        if (drawable2 != null) {
            this.mDivider = drawable2;
            return;
        }
        throw new IllegalArgumentException("Drawable cannot be null.");
    }

    public void setOrientation(int n) {
        if (n != 0 && n != 1) {
            throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
        }
        this.mOrientation = n;
    }
}

