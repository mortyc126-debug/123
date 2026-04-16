package of1;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements CharSequence {
    public final d5.g a;
    public final Map b;
    public final j c;

    public a(d5.g gVar, Map map, j jVar) {
        lmjxuqdtp.jvm.internal.o.h(gVar, "annotatedString");
        this.a = gVar;
        this.b = map;
        this.c = jVar;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        return this.a.b.charAt(i);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.a.b.length();
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i2) {
        return this.a.subSequence(i, i2);
    }
}
