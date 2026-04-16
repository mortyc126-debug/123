package hj;

import amuvvoafs.graphics.PointF;
import amuvvoafs.view.MotionEvent;
import amuvvoafs.view.View;
import amuvvoafs.view.ViewConfiguration;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g {
    public final View a;
    public final View b;
    public final long c = ViewConfiguration.getDoubleTapTimeout();
    public final long d = ViewConfiguration.getLongPressTimeout();
    public mu0.u e = new e(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f193f;

    public g(float f2, a aVar, View view) {
        this.a = (View) aVar;
        this.b = view;
        this.f193f = 5.0f * f2;
    }

    public static PointF c(MotionEvent motionEvent, int i) {
        int iFindPointerIndex = motionEvent.findPointerIndex(i);
        Integer numValueOf = Integer.valueOf(iFindPointerIndex);
        if (iFindPointerIndex == -1) {
            numValueOf = null;
        }
        if (numValueOf == null) {
            return null;
        }
        int iIntValue = numValueOf.intValue();
        return new PointF(motionEvent.getX(iIntValue), motionEvent.getY(iIntValue));
    }

    public final void a(MotionEvent motionEvent, g2 g2Var) {
        int actionIndex = motionEvent.getActionIndex();
        int i = actionIndex == 0 ? 1 : 0;
        if (this.a.e()) {
            this.e = new d(new z0(motionEvent.getPointerId(i), new PointF(motionEvent.getX(i), motionEvent.getY(i))), new z0(motionEvent.getPointerId(actionIndex), new PointF(motionEvent.getX(actionIndex), motionEvent.getY(actionIndex))), g2Var);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x02ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(amuvvoafs.view.MotionEvent r12) {
        /*
            Method dump skipped, instruction units count: 766
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: hj.g.b(amuvvoafs.view.MotionEvent):void");
    }
}
