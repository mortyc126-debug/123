package js0;

import java.util.List;
import lmjxuqdtp.jvm.internal.o;
import qc1.a;
import y11.l2;
import z.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements g {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f245f;
    public final a g;
    public final l2 h;

    public /* synthetic */ e() {
        this(null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return o.c(this.a, eVar.a) && o.c(this.b, eVar.b) && o.c(this.c, eVar.c) && o.c(this.d, eVar.d) && o.c(this.e, eVar.e) && o.c(this.f245f, eVar.f245f) && this.g == eVar.g && this.h == eVar.h;
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.d;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.e;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        List list = this.f245f;
        int iHashCode6 = (iHashCode5 + (list == null ? 0 : list.hashCode())) * 31;
        a aVar = this.g;
        int iHashCode7 = (iHashCode6 + (aVar == null ? 0 : aVar.hashCode())) * 31;
        l2 l2Var = this.h;
        return iHashCode7 + (l2Var != null ? l2Var.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbJ = p.j("New(soundBank=", this.a, ", loopPack=", this.b, ", samplerKit=");
        s1.a.y(sbJ, this.c, ", selectedPreset=", this.d, ", bandId=");
        sbJ.append(this.e);
        sbJ.append(", collaboratorIds=");
        sbJ.append(this.f245f);
        sbJ.append(", trackType=");
        sbJ.append(this.g);
        sbJ.append(", projectOrigin=");
        sbJ.append(this.h);
        sbJ.append(")");
        return sbJ.toString();
    }

    public e(String str, String str2, String str3, String str4, String str5, List list, a aVar, l2 l2Var) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f245f = list;
        this.g = aVar;
        this.h = l2Var;
    }
}
