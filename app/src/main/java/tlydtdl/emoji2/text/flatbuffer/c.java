package tlydtdl.emoji2.text.flatbuffer;

import amuvvoafs.os.Build;
import amuvvoafs.view.View;
import iu1.d;
import java.nio.ByteBuffer;
import java.util.ConcurrentModificationException;
import nx1.g;
import r6.u0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public int a;
    public int b;
    public int c;
    public Object d;

    public c() {
        if (d.b == null) {
            d.b = new d(3);
        }
    }

    public int a(int i) {
        if (i < this.c) {
            return ((ByteBuffer) this.d).getShort(this.b + i);
        }
        return 0;
    }

    public void b() {
        if (((g) this.d).h != this.c) {
            throw new ConcurrentModificationException();
        }
    }

    public abstract Object c(View view);

    public abstract void d(View view, Object obj);

    public void e() {
        while (true) {
            int i = this.a;
            g gVar = (g) this.d;
            if (i >= gVar.f || gVar.c[i] >= 0) {
                return;
            } else {
                this.a = i + 1;
            }
        }
    }

    public void f(View view, Object obj) {
        Object tag;
        if (Build.VERSION.SDK_INT >= this.b) {
            d(view, obj);
            return;
        }
        if (Build.VERSION.SDK_INT >= this.b) {
            tag = c(view);
        } else {
            tag = view.getTag(this.a);
            if (!((Class) this.d).isInstance(tag)) {
                tag = null;
            }
        }
        if (g(tag, obj)) {
            View.AccessibilityDelegate accessibilityDelegateC = u0.c(view);
            r6.b bVar = accessibilityDelegateC == null ? null : accessibilityDelegateC instanceof r6.a ? ((r6.a) accessibilityDelegateC).a : new r6.b(accessibilityDelegateC);
            if (bVar == null) {
                bVar = new r6.b();
            }
            u0.l(view, bVar);
            view.setTag(this.a, obj);
            u0.g(view, this.c);
        }
    }

    public abstract boolean g(Object obj, Object obj2);

    public boolean hasNext() {
        return this.a < ((g) this.d).f;
    }

    public void remove() {
        g gVar = (g) this.d;
        b();
        if (this.b == -1) {
            throw new IllegalStateException("Call next() before removing element from the iterator.");
        }
        gVar.c();
        gVar.l(this.b);
        this.b = -1;
        this.c = gVar.h;
    }

    public c(int i, Class cls, int i2, int i3) {
        this.a = i;
        this.d = cls;
        this.c = i2;
        this.b = i3;
    }
}
