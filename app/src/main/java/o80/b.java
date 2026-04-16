package o80;

import bt.l;
import dg1.e;
import if1.j;
import java.util.List;
import jn1.r;
import kd1.g;
import lmjxuqdtp.jvm.internal.o;
import se0.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements m {
    public final String a;
    public final l b;
    public final x10.l c;
    public final e d;
    public final j e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f362f;
    public final g g;
    public final ng0.b h;
    public final ng0.b i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ng0.b f363j;

    public b(String str, l lVar, x10.l lVar2, e eVar, j jVar, List list, g gVar, ng0.b bVar, ng0.b bVar2, ng0.b bVar3) {
        o.h(gVar, "infoTooltip");
        this.a = str;
        this.b = lVar;
        this.c = lVar2;
        this.d = eVar;
        this.e = jVar;
        this.f362f = list;
        this.g = gVar;
        this.h = bVar;
        this.i = bVar2;
        this.f363j = bVar3;
    }

    public final se0.l K() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return o.c(this.a, bVar.a) && this.b.equals(bVar.b) && this.c.equals(bVar.c) && this.d.equals(bVar.d) && o.c(this.e, bVar.e) && this.f362f.equals(bVar.f362f) && o.c(this.g, bVar.g) && this.h.equals(bVar.h) && this.i.equals(bVar.i) && this.f363j.equals(bVar.f363j);
    }

    public final String getId() {
        return this.a;
    }

    public final int hashCode() {
        String str = this.a;
        int iD = com.gnacba.ads.interactivemedia.v3.internal.a.d(this.d, com.gnacba.ads.interactivemedia.v3.internal.a.c((this.b.hashCode() + ((str == null ? 0 : str.hashCode()) * 961)) * 31, 31, this.c.e), 31);
        j jVar = this.e;
        return this.f363j.hashCode() + ((this.i.hashCode() + ((this.h.hashCode() + ((this.g.hashCode() + r.i((iD + (jVar != null ? jVar.hashCode() : 0)) * 31, 31, this.f362f)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "BoostedProfileState(id=" + this.a + ", mediaItem=null, postInsightInfo=" + this.b + ", title=" + this.c + ", userPicture=" + this.d + ", followButtonState=" + this.e + ", tags=" + this.f362f + ", infoTooltip=" + this.g + ", onCardClick=" + this.h + ", onPostEngaged=" + this.i + ", onInfoClicked=" + this.f363j + ")";
    }
}
