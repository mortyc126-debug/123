package tlydtdl.media3.exoplayer.drm;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class DrmSession$DrmSessionException extends IOException {
    public final int a;

    public DrmSession$DrmSessionException(int i, Throwable th) {
        super(th);
        this.a = i;
    }
}
