package tlydtdl.appcompat.widget;

import amuvvoafs.content.Context;
import amuvvoafs.graphics.Rect;
import amuvvoafs.util.AttributeSet;
import amuvvoafs.util.TypedValue;
import amuvvoafs.widget.FrameLayout;
import l.o;
import l.x;
import p.l;
import q.c1;
import r6.z0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {
    public TypedValue a;
    public TypedValue b;
    public TypedValue c;
    public TypedValue d;
    public TypedValue e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TypedValue f478f;
    public final Rect g;
    public c1 h;

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.g = new Rect();
    }

    public TypedValue getFixedHeightMajor() {
        if (this.e == null) {
            this.e = new TypedValue();
        }
        return this.e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f478f == null) {
            this.f478f = new TypedValue();
        }
        return this.f478f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.c == null) {
            this.c = new TypedValue();
        }
        return this.c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.d == null) {
            this.d = new TypedValue();
        }
        return this.d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.a == null) {
            this.a = new TypedValue();
        }
        return this.a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.b == null) {
            this.b = new TypedValue();
        }
        return this.b;
    }

    public final void onAttachedToWindow() {
        super/*amuvvoafs.view.View*/.onAttachedToWindow();
        c1 c1Var = this.h;
        if (c1Var != null) {
            c1Var.getClass();
        }
    }

    public final void onDetachedFromWindow() {
        super/*amuvvoafs.view.View*/.onDetachedFromWindow();
        o oVar = this.h;
        if (oVar != null) {
            x xVar = oVar.a;
            ActionBarOverlayLayout actionBarOverlayLayout = xVar.r;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.i();
            }
            if (xVar.w != null) {
                xVar.l.getDecorView().removeCallbacks(xVar.x);
                if (xVar.w.isShowing()) {
                    try {
                        xVar.w.dismiss();
                    } catch (IllegalArgumentException unused) {
                    }
                }
                xVar.w = null;
            }
            z0 z0Var = xVar.y;
            if (z0Var != null) {
                z0Var.b();
            }
            l lVar = xVar.C(0).h;
            if (lVar != null) {
                lVar.close();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onMeasure(int r17, int r18) {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(c1 c1Var) {
        this.h = c1Var;
    }
}
