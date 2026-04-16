package ld;

import cn1.k;
import com.gnacba.amuvvoafs.gms.measurement.internal.j3;
import gt1.d;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import lmjxuqdtp.jvm.internal.o;
import v8.c1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements Executor {
    public final /* synthetic */ int a;
    public final Executor b;
    public final ArrayDeque c;
    public Runnable d;
    public final Object e;

    public j(Executor executor, int i) {
        this.a = i;
        switch (i) {
            case 1:
                o.h(executor, "executor");
                this.b = executor;
                this.c = new ArrayDeque();
                this.e = new Object();
                break;
            default:
                this.b = executor;
                this.c = new ArrayDeque();
                this.e = new Object();
                break;
        }
    }

    public final void a() {
        switch (this.a) {
            case 0:
                Runnable runnable = (Runnable) this.c.poll();
                this.d = runnable;
                if (runnable != null) {
                    this.b.execute(runnable);
                    return;
                }
                return;
            case 1:
                synchronized (this.e) {
                    Object objPoll = this.c.poll();
                    Runnable runnable2 = (Runnable) objPoll;
                    this.d = runnable2;
                    if (objPoll != null) {
                        this.b.execute(runnable2);
                    }
                    break;
                }
                return;
            default:
                synchronized (this.e) {
                    try {
                        Runnable runnable3 = (Runnable) this.c.poll();
                        this.d = runnable3;
                        if (runnable3 != null) {
                            this.b.execute(runnable3);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return;
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.a) {
            case 0:
                synchronized (this.e) {
                    try {
                        this.c.add(new j3(this, runnable, false, 3));
                        if (this.d == null) {
                            a();
                        }
                    } finally {
                    }
                    break;
                }
                return;
            case 1:
                o.h(runnable, "command");
                synchronized (this.e) {
                    this.c.offer(new c1(2, runnable, this));
                    if (this.d == null) {
                        a();
                    }
                    break;
                }
                return;
            default:
                synchronized (this.e) {
                    try {
                        this.c.add(new k(15, this, runnable));
                        if (this.d == null) {
                            a();
                        }
                    } finally {
                    }
                    break;
                }
                return;
        }
    }

    public j(d dVar) {
        this.a = 2;
        this.e = new Object();
        this.c = new ArrayDeque();
        this.b = dVar;
    }
}
