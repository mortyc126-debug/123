package hr0;

import amuvvoafs.view.View;
import amuvvoafs.widget.FrameLayout;
import amuvvoafs.widget.LinearLayout;
import amuvvoafs.widget.ProgressBar;
import amuvvoafs.widget.TextView;
import com.bandlab.mixeditor.full.screen.progress.ui.StudioLoadingAnimatedIndicatorView;
import g7.v;
import mr.c4;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends v {
    public long A;
    public final TextView u;
    public final FrameLayout v;
    public final ProgressBar w;
    public th0.a x;
    public final LinearLayout y;
    public final StudioLoadingAnimatedIndicatorView z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(View view) {
        super(5, view, null);
        Object[] objArrP = v.p(view, 5, null, null);
        TextView textView = (TextView) objArrP[3];
        FrameLayout frameLayout = (FrameLayout) objArrP[0];
        ProgressBar progressBar = (ProgressBar) objArrP[2];
        this.u = textView;
        this.v = frameLayout;
        this.w = progressBar;
        this.A = -1L;
        LinearLayout linearLayout = (LinearLayout) objArrP[1];
        this.y = linearLayout;
        linearLayout.setTag((Object) null);
        StudioLoadingAnimatedIndicatorView studioLoadingAnimatedIndicatorView = (StudioLoadingAnimatedIndicatorView) objArrP[4];
        this.z = studioLoadingAnimatedIndicatorView;
        studioLoadingAnimatedIndicatorView.setTag((Object) null);
        this.u.setTag((Object) null);
        this.v.setTag((Object) null);
        this.w.setTag((Object) null);
        x(view);
        n();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    @Override // g7.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i() {
        /*
            Method dump skipped, instruction units count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: hr0.a.i():void");
    }

    @Override // g7.v
    public final boolean m() {
        synchronized (this) {
            try {
                return this.A != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // g7.v
    public final void n() {
        synchronized (this) {
            this.A = 64L;
        }
        s();
    }

    @Override // g7.v
    public final boolean q(int i, int i2, Object obj) {
        if (i == 0) {
            int i3 = c4.a;
            if (i2 != 0) {
                return false;
            }
            synchronized (this) {
                this.A |= 1;
            }
            return true;
        }
        if (i == 1) {
            int i4 = c4.a;
            if (i2 != 0) {
                return false;
            }
            synchronized (this) {
                this.A |= 2;
            }
            return true;
        }
        if (i == 2) {
            int i6 = c4.a;
            if (i2 != 0) {
                return false;
            }
            synchronized (this) {
                this.A |= 4;
            }
            return true;
        }
        if (i == 3) {
            int i7 = c4.a;
            if (i2 != 0) {
                return false;
            }
            synchronized (this) {
                this.A |= 8;
            }
            return true;
        }
        if (i != 4) {
            return false;
        }
        int i8 = c4.a;
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.A |= 16;
        }
        return true;
    }

    @Override // g7.v
    public final boolean y(int i, Object obj) {
        int i2 = c4.a;
        return false;
    }
}
