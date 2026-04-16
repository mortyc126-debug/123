package f;

import amuvvoafs.content.res.TypedArray;
import amuvvoafs.media.MediaDrm;
import amuvvoafs.media.MediaMetadataRetriever;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class w {
    public boolean b;
    public final ArrayList a = new ArrayList();
    public final CopyOnWriteArrayList c = new CopyOnWriteArrayList();

    public w(boolean z) {
        this.b = z;
    }

    public void a() {
    }

    public abstract void b();

    public void c(a aVar) {
    }

    public void d(a aVar) {
    }

    public final void e() throws Exception {
        boolean zIsTerminated;
        CopyOnWriteArrayList copyOnWriteArrayList = this.c;
        Iterator it = copyOnWriteArrayList.iterator();
        lmjxuqdtp.jvm.internal.o.g(it, "iterator(...)");
        while (it.hasNext()) {
            MediaDrm mediaDrm = (AutoCloseable) it.next();
            if (mediaDrm instanceof AutoCloseable) {
                ((AutoCloseable) mediaDrm).close();
            } else if (mediaDrm instanceof ExecutorService) {
                ExecutorService executorService = (ExecutorService) mediaDrm;
                if (executorService != ForkJoinPool.commonPool() && !(zIsTerminated = executorService.isTerminated())) {
                    executorService.shutdown();
                    boolean z = false;
                    while (!zIsTerminated) {
                        try {
                            zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
                        } catch (InterruptedException unused) {
                            if (!z) {
                                executorService.shutdownNow();
                                z = true;
                            }
                        }
                    }
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                }
            } else if (mediaDrm instanceof TypedArray) {
                ((TypedArray) mediaDrm).recycle();
            } else if (mediaDrm instanceof MediaMetadataRetriever) {
                ((MediaMetadataRetriever) mediaDrm).release();
            } else {
                if (!(mediaDrm instanceof MediaDrm)) {
                    throw new IllegalArgumentException();
                }
                mediaDrm.release();
            }
        }
        copyOnWriteArrayList.clear();
        ArrayList arrayList = this.a;
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((kb.e) it2.next()).f();
        }
        arrayList.clear();
    }

    public final void f(boolean z) {
        this.b = z;
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((kb.e) it.next()).g(z);
        }
    }
}
