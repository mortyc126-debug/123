package k30;

import com.gnacba.amuvvoafs.gms.internal.auth.h;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.internal.o;
import o6.c;
import s1.a;
import z.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends h implements e {
    public final String c;
    public final String d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f253f;
    public final boolean g;
    public final boolean h;
    public final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function0 f254j;

    public d(String str, String str2, String str3, String str4, boolean z, boolean z2, String str5, Function0 function0) {
        o.h(str2, "id");
        o.h(str4, "description");
        o.h(function0, "onClick");
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f253f = str4;
        this.g = z;
        this.h = z2;
        this.i = str5;
        this.f254j = function0;
    }

    public final String a() {
        return this.i;
    }

    public final Function0 b() {
        return this.f254j;
    }

    public final boolean c() {
        return this.h;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return o.c(this.c, dVar.c) && o.c(this.d, dVar.d) && o.c(this.e, dVar.e) && o.c(this.f253f, dVar.f253f) && this.g == dVar.g && this.h == dVar.h && o.c(this.i, dVar.i) && o.c(this.f254j, dVar.f254j);
    }

    public final String getDescription() {
        return this.f253f;
    }

    public final String getTitle() {
        return this.e;
    }

    public final int hashCode() {
        String str = this.c;
        int iD = a.d((str == null ? 0 : str.hashCode()) * 31, 31, this.d);
        String str2 = this.e;
        int iF = a.f(a.f(a.d((iD + (str2 == null ? 0 : str2.hashCode())) * 31, 31, this.f253f), 31, this.g), 31, this.h);
        String str3 = this.i;
        return this.f254j.hashCode() + ((iF + (str3 != null ? str3.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder sbJ = p.j("ShortNews(imageUrl=", this.c, ", id=", this.d, ", title=");
        a.y(sbJ, this.e, ", description=", this.f253f, ", isPinned=");
        c.C(sbJ, this.g, ", isUnread=", this.h, ", ctaText=");
        sbJ.append(this.i);
        sbJ.append(", onClick=");
        sbJ.append(this.f254j);
        sbJ.append(")");
        return sbJ.toString();
    }
}
