package d5;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Appendable {
    public final StringBuilder a;
    public final ArrayList b;
    public final ArrayList c;

    public d() {
        this.a = new StringBuilder(16);
        this.b = new ArrayList();
        this.c = new ArrayList();
        new ArrayList();
    }

    public final void a(String str, int i, int i2, String str2) {
        this.c.add(new c(str, i, i2, new j0(str2)));
    }

    @Override // java.lang.Appendable
    public final /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence) {
        e(charSequence);
        return this;
    }

    public final void b(h0 h0Var, int i, int i2) {
        this.c.add(new c(h0Var, i, i2, null, 8));
    }

    public final void c(g gVar) {
        StringBuilder sb = this.a;
        int length = sb.length();
        sb.append(gVar.b);
        List list = gVar.a;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                e eVar = (e) list.get(i);
                Object obj = eVar.a;
                this.c.add(new c(eVar.d, eVar.b + length, eVar.c + length, obj));
            }
        }
    }

    public final void d(g gVar, int i, int i2) {
        StringBuilder sb = this.a;
        int length = sb.length();
        sb.append((CharSequence) gVar.b, i, i2);
        List listA = i.a(gVar, i, i2, null);
        if (listA != null) {
            int size = listA.size();
            for (int i3 = 0; i3 < size; i3++) {
                e eVar = (e) listA.get(i3);
                Object obj = eVar.a;
                this.c.add(new c(eVar.d, eVar.b + length, eVar.c + length, obj));
            }
        }
    }

    public final void e(CharSequence charSequence) {
        if (charSequence instanceof g) {
            c((g) charSequence);
        } else {
            this.a.append(charSequence);
        }
    }

    public final void f(String str) {
        this.a.append(str);
    }

    public final void g() {
        ArrayList arrayList = this.b;
        if (arrayList.isEmpty()) {
            j5.a.c("Nothing to pop.");
        }
        ((c) arrayList.remove(arrayList.size() - 1)).c = this.a.length();
    }

    public final void h(int i) {
        ArrayList arrayList = this.b;
        if (i >= arrayList.size()) {
            j5.a.c(i + " should be less than " + arrayList.size());
        }
        while (arrayList.size() - 1 >= i) {
            g();
        }
    }

    public final int i(m mVar) {
        c cVar = new c(mVar, this.a.length(), 0, null, 12);
        this.b.add(cVar);
        this.c.add(cVar);
        return r7.size() - 1;
    }

    public final int j(String str, String str2) {
        c cVar = new c(new j0(str2), this.a.length(), 0, str, 4);
        this.b.add(cVar);
        this.c.add(cVar);
        return r7.size() - 1;
    }

    public final int k(h0 h0Var) {
        c cVar = new c(h0Var, this.a.length(), 0, null, 12);
        this.b.add(cVar);
        this.c.add(cVar);
        return r7.size() - 1;
    }

    public final g l() {
        StringBuilder sb = this.a;
        String string = sb.toString();
        ArrayList arrayList = this.c;
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add(((c) arrayList.get(i)).a(sb.length()));
        }
        return new g(string, arrayList2);
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i, int i2) {
        if (charSequence instanceof g) {
            d((g) charSequence, i, i2);
            return this;
        }
        this.a.append(charSequence, i, i2);
        return this;
    }

    @Override // java.lang.Appendable
    public final Appendable append(char c) {
        this.a.append(c);
        return this;
    }

    public d(g gVar) {
        this();
        c(gVar);
    }
}
