package hf;

import amuvvoafs.graphics.Bitmap;
import amuvvoafs.graphics.drawable.Drawable;
import amuvvoafs.media.MediaDataSource;
import gf.o;
import java.nio.ByteBuffer;
import je.a0;
import je.u;
import oe.a;
import oe.c;
import oe.d;
import oe.g;
import ze.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements oe.f {
    public final /* synthetic */ int a;

    public final g a(Object obj, m mVar, u uVar) {
        switch (this.a) {
            case 0:
                return new e((MediaDataSource) obj, mVar, 0);
            case 1:
                a0 a0Var = (a0) obj;
                Bitmap.Config[] configArr = o.a;
                if (lmjxuqdtp.jvm.internal.o.c(a0Var.c, "file") && lmjxuqdtp.jvm.internal.o.c(mx1.o.y0(je.o.g(a0Var)), "android_asset")) {
                    return new a(a0Var, mVar, 0);
                }
                return null;
            case 2:
                return new e((Bitmap) obj, mVar, 1);
            case 3:
                return new e((byte[]) obj, mVar, 2);
            case 4:
                return new e((ByteBuffer) obj, mVar, 3);
            case 5:
                a0 a0Var2 = (a0) obj;
                if (lmjxuqdtp.jvm.internal.o.c(a0Var2.c, "content")) {
                    return new c(a0Var2, mVar);
                }
                return null;
            case 6:
                a0 a0Var3 = (a0) obj;
                if (lmjxuqdtp.jvm.internal.o.c(a0Var3.c, "data")) {
                    return new a(a0Var3, mVar, 1);
                }
                return null;
            case 7:
                return new d((Drawable) obj, mVar);
            case 8:
                a0 a0Var4 = (a0) obj;
                String str = a0Var4.c;
                if ((str != null && !str.equals("file")) || a0Var4.e == null) {
                    return null;
                }
                Bitmap.Config[] configArr2 = o.a;
                if (lmjxuqdtp.jvm.internal.o.c(a0Var4.c, "file") && lmjxuqdtp.jvm.internal.o.c(mx1.o.y0(je.o.g(a0Var4)), "android_asset")) {
                    return null;
                }
                return new a(a0Var4, mVar, 2);
            case 9:
                a0 a0Var5 = (a0) obj;
                if (lmjxuqdtp.jvm.internal.o.c(a0Var5.c, "jar:file")) {
                    return new a(a0Var5, mVar, 3);
                }
                return null;
            default:
                a0 a0Var6 = (a0) obj;
                if (lmjxuqdtp.jvm.internal.o.c(a0Var6.c, "amuvvoafs.resource")) {
                    return new a(a0Var6, mVar, 4);
                }
                return null;
        }
    }
}
