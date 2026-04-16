/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Insets
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.view.DisplayCutout
 */
package androidx.core.view;

import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import androidx.core.util.ObjectsCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DisplayCutoutCompat {
    private final DisplayCutout mDisplayCutout;

    public DisplayCutoutCompat(Rect object, List<Rect> list) {
        object = Build.VERSION.SDK_INT >= 28 ? Api28Impl.createDisplayCutout(object, list) : null;
        this((DisplayCutout)object);
    }

    private DisplayCutoutCompat(DisplayCutout displayCutout) {
        this.mDisplayCutout = displayCutout;
    }

    public DisplayCutoutCompat(androidx.core.graphics.Insets insets, Rect rect, Rect rect2, Rect rect3, Rect rect4, androidx.core.graphics.Insets insets2) {
        this(DisplayCutoutCompat.constructDisplayCutout(insets, rect, rect2, rect3, rect4, insets2));
    }

    private static DisplayCutout constructDisplayCutout(androidx.core.graphics.Insets object, Rect rect, Rect rect2, Rect rect3, Rect rect4, androidx.core.graphics.Insets insets) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.createDisplayCutout(((androidx.core.graphics.Insets)object).toPlatformInsets(), rect, rect2, rect3, rect4, insets.toPlatformInsets());
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.createDisplayCutout(((androidx.core.graphics.Insets)object).toPlatformInsets(), rect, rect2, rect3, rect4);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            insets = new Rect(((androidx.core.graphics.Insets)object).left, ((androidx.core.graphics.Insets)object).top, ((androidx.core.graphics.Insets)object).right, ((androidx.core.graphics.Insets)object).bottom);
            object = new ArrayList();
            if (rect != null) {
                ((ArrayList)object).add(rect);
            }
            if (rect2 != null) {
                ((ArrayList)object).add(rect2);
            }
            if (rect3 != null) {
                ((ArrayList)object).add(rect3);
            }
            if (rect4 != null) {
                ((ArrayList)object).add(rect4);
            }
            return Api28Impl.createDisplayCutout((Rect)insets, (List<Rect>)object);
        }
        return null;
    }

    static DisplayCutoutCompat wrap(DisplayCutout object) {
        object = object == null ? null : new DisplayCutoutCompat((DisplayCutout)object);
        return object;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && this.getClass() == object.getClass()) {
            object = (DisplayCutoutCompat)object;
            return ObjectsCompat.equals(this.mDisplayCutout, ((DisplayCutoutCompat)object).mDisplayCutout);
        }
        return false;
    }

    public List<Rect> getBoundingRects() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getBoundingRects(this.mDisplayCutout);
        }
        return Collections.emptyList();
    }

    public int getSafeInsetBottom() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getSafeInsetBottom(this.mDisplayCutout);
        }
        return 0;
    }

    public int getSafeInsetLeft() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getSafeInsetLeft(this.mDisplayCutout);
        }
        return 0;
    }

    public int getSafeInsetRight() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getSafeInsetRight(this.mDisplayCutout);
        }
        return 0;
    }

    public int getSafeInsetTop() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getSafeInsetTop(this.mDisplayCutout);
        }
        return 0;
    }

    public androidx.core.graphics.Insets getWaterfallInsets() {
        if (Build.VERSION.SDK_INT >= 30) {
            return androidx.core.graphics.Insets.toCompatInsets(Api30Impl.getWaterfallInsets(this.mDisplayCutout));
        }
        return androidx.core.graphics.Insets.NONE;
    }

    public int hashCode() {
        int n = this.mDisplayCutout == null ? 0 : this.mDisplayCutout.hashCode();
        return n;
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.mDisplayCutout + "}";
    }

    DisplayCutout unwrap() {
        return this.mDisplayCutout;
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static DisplayCutout createDisplayCutout(Rect rect, List<Rect> list) {
            return new DisplayCutout(rect, list);
        }

        static List<Rect> getBoundingRects(DisplayCutout displayCutout) {
            return displayCutout.getBoundingRects();
        }

        static int getSafeInsetBottom(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetBottom();
        }

        static int getSafeInsetLeft(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetLeft();
        }

        static int getSafeInsetRight(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetRight();
        }

        static int getSafeInsetTop(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetTop();
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static DisplayCutout createDisplayCutout(Insets insets, Rect rect, Rect rect2, Rect rect3, Rect rect4) {
            return new DisplayCutout(insets, rect, rect2, rect3, rect4);
        }
    }

    static class Api30Impl {
        private Api30Impl() {
        }

        static DisplayCutout createDisplayCutout(Insets insets, Rect rect, Rect rect2, Rect rect3, Rect rect4, Insets insets2) {
            return new DisplayCutout(insets, rect, rect2, rect3, rect4, insets2);
        }

        static Insets getWaterfallInsets(DisplayCutout displayCutout) {
            return displayCutout.getWaterfallInsets();
        }
    }
}

