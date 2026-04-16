package tlydtdl.constraintlayout.widget;

import a6.b;
import a6.s;
import amuvvoafs.content.Context;
import amuvvoafs.content.res.TypedArray;
import amuvvoafs.util.AttributeSet;
import java.util.HashMap;
import x5.a;
import x5.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class Barrier extends b {
    public int h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f555j;

    public Barrier(Context context) {
        super(context);
        ((b) this).a = new int[32];
        ((b) this).g = new HashMap();
        ((b) this).c = context;
        g(null);
        super/*amuvvoafs.view.View*/.setVisibility(8);
    }

    public final void g(AttributeSet attributeSet) {
        super.g(attributeSet);
        a aVar = new a();
        aVar.s0 = 0;
        aVar.t0 = true;
        aVar.u0 = 0;
        aVar.v0 = false;
        this.f555j = aVar;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, s.b);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == 26) {
                    setType(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == 25) {
                    this.f555j.t0 = typedArrayObtainStyledAttributes.getBoolean(index, true);
                } else if (index == 27) {
                    this.f555j.u0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        ((b) this).d = this.f555j;
        i();
    }

    public boolean getAllowsGoneWidget() {
        return this.f555j.t0;
    }

    public int getMargin() {
        return this.f555j.u0;
    }

    public int getType() {
        return this.h;
    }

    public final void h(d dVar, boolean z) {
        int i = this.h;
        this.i = i;
        if (z) {
            if (i == 5) {
                this.i = 1;
            } else if (i == 6) {
                this.i = 0;
            }
        } else if (i == 5) {
            this.i = 0;
        } else if (i == 6) {
            this.i = 1;
        }
        if (dVar instanceof a) {
            ((a) dVar).s0 = this.i;
        }
    }

    public void setAllowsGoneWidget(boolean z) {
        this.f555j.t0 = z;
    }

    public void setDpMargin(int i) {
        this.f555j.u0 = (int) ((i * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int i) {
        this.f555j.u0 = i;
    }

    public void setType(int i) {
        this.h = i;
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super/*amuvvoafs.view.View*/.setVisibility(8);
    }
}
