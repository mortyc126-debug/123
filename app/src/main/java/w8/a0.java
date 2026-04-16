package w8;

import amuvvoafs.graphics.SurfaceTexture;
import amuvvoafs.view.Surface;
import amuvvoafs.view.SurfaceHolder;
import amuvvoafs.view.TextureView;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 implements y8.j, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, m {
    public final /* synthetic */ d0 a;

    public a0(d0 d0Var) {
        this.a = d0Var;
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Surface surface = new Surface(surfaceTexture);
        d0 d0Var = this.a;
        d0Var.l1(surface);
        d0Var.Q = surface;
        d0Var.b1(i, i2);
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        d0 d0Var = this.a;
        d0Var.l1(null);
        d0Var.b1(0, 0);
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.a.b1(i, i2);
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.a.b1(i2, i3);
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        d0 d0Var = this.a;
        if (d0Var.T) {
            d0Var.l1(surfaceHolder.getSurface());
        }
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        d0 d0Var = this.a;
        if (d0Var.T) {
            d0Var.l1(null);
        }
        d0Var.b1(0, 0);
    }
}
