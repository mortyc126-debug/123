package d5;

import java.util.ArrayList;
import java.util.List;
import q1.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements CharSequence {
    public final List a;
    public final String b;
    public final ArrayList c;
    public final ArrayList d;

    static {
        g4.d0 d0Var = f0.a;
    }

    public g(List list, String str) {
        ArrayList arrayList;
        ArrayList arrayList2;
        this.a = list;
        this.b = str;
        if (list != null) {
            int size = list.size();
            arrayList = null;
            arrayList2 = null;
            for (int i = 0; i < size; i++) {
                e eVar = (e) list.get(i);
                Object obj = eVar.a;
                if (obj instanceof h0) {
                    arrayList = arrayList == null ? new ArrayList() : arrayList;
                    arrayList.add(eVar);
                } else if (obj instanceof w) {
                    arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                    arrayList2.add(eVar);
                }
            }
        } else {
            arrayList = null;
            arrayList2 = null;
        }
        this.c = arrayList;
        this.d = arrayList2;
        List listE1 = arrayList2 != null ? mx1.o.e1(arrayList2, new f(0)) : null;
        if (listE1 == null || listE1.isEmpty()) {
            return;
        }
        int i2 = ((e) mx1.o.w0(listE1)).c;
        q1.y yVar = m.a;
        q1.y yVar2 = new q1.y(1);
        yVar2.a(i2);
        int size2 = listE1.size();
        for (int i3 = 1; i3 < size2; i3++) {
            e eVar2 = (e) listE1.get(i3);
            while (true) {
                if (yVar2.b != 0) {
                    int iD = yVar2.d();
                    int i4 = eVar2.b;
                    int i6 = eVar2.c;
                    if (i4 >= iD) {
                        yVar2.e(yVar2.b - 1);
                    } else if (i6 > iD) {
                        j5.a.a("Paragraph overlap not allowed, end " + i6 + " should be less than or equal to " + iD);
                    }
                }
            }
            yVar2.a(eVar2.c);
        }
    }

    public final List a(int i) {
        List list = this.a;
        if (list == null) {
            return mx1.t.a;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            e eVar = (e) obj;
            if ((eVar.a instanceof o) && i.b(0, i, eVar.b, eVar.c)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009e  */
    @Override // java.lang.CharSequence
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final d5.g subSequence(int r11, int r12) {
        /*
            r10 = this;
            r0 = 0
            if (r11 > r12) goto L5
            r1 = 1
            goto L6
        L5:
            r1 = r0
        L6:
            r2 = 41
            java.lang.String r3 = "start ("
            if (r1 != 0) goto L26
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            r1.append(r11)
            java.lang.String r4 = ") should be less or equal to end ("
            r1.append(r4)
            r1.append(r12)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            j5.a.a(r1)
        L26:
            java.lang.String r1 = r10.b
            if (r11 != 0) goto L31
            int r4 = r1.length()
            if (r12 != r4) goto L31
            return r10
        L31:
            java.lang.String r1 = r1.substring(r11, r12)
            java.lang.String r4 = "substring(...)"
            lmjxuqdtp.jvm.internal.o.g(r1, r4)
            d5.g r4 = d5.i.a
            if (r11 > r12) goto L3f
            goto L59
        L3f:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            r4.append(r11)
            java.lang.String r3 = ") should be less than or equal to end ("
            r4.append(r3)
            r4.append(r12)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            j5.a.a(r2)
        L59:
            java.util.List r2 = r10.a
            if (r2 != 0) goto L5e
            goto L9e
        L5e:
            java.util.ArrayList r3 = new java.util.ArrayList
            int r4 = r2.size()
            r3.<init>(r4)
            int r4 = r2.size()
        L6b:
            if (r0 >= r4) goto L98
            java.lang.Object r5 = r2.get(r0)
            d5.e r5 = (d5.e) r5
            int r6 = r5.b
            int r7 = r5.c
            boolean r6 = d5.i.b(r11, r12, r6, r7)
            if (r6 == 0) goto L95
            d5.e r6 = new d5.e
            java.lang.Object r8 = r5.a
            int r9 = r5.b
            int r9 = java.lang.Math.max(r11, r9)
            int r9 = r9 - r11
            int r7 = java.lang.Math.min(r12, r7)
            int r7 = r7 - r11
            java.lang.String r5 = r5.d
            r6.<init>(r5, r9, r7, r8)
            r3.add(r6)
        L95:
            int r0 = r0 + 1
            goto L6b
        L98:
            boolean r11 = r3.isEmpty()
            if (r11 == 0) goto L9f
        L9e:
            r3 = 0
        L9f:
            d5.g r11 = new d5.g
            r11.<init>(r3, r1)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: d5.g.subSequence(int, int):d5.g");
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        return this.b.charAt(i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.b, gVar.b) && lmjxuqdtp.jvm.internal.o.c(this.a, gVar.a);
    }

    public final int hashCode() {
        int iHashCode = this.b.hashCode() * 31;
        List list = this.a;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.b.length();
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.b;
    }

    public /* synthetic */ g(String str) {
        this(str, (List) mx1.t.a);
    }

    public g(String str, List list) {
        this(list.isEmpty() ? null : list, str);
    }
}
