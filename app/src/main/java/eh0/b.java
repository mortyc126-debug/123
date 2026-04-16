package eh0;

import org.apache.commons.net.ftp.FTPReply;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public final double a;
    public final float b = 20;
    public float c = FTPReply.SERVICE_NOT_READY;

    public b(int i) {
        this.a = Double.valueOf(i).doubleValue();
    }

    public final double a(float f2) {
        return (f2 / this.b) / (this.c / 60.0f);
    }

    public final float b(double d) {
        return this.b * ((float) (d * ((double) (this.c / 60.0f))));
    }
}
