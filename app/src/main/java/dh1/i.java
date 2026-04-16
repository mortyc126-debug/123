package dh1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@aj.a(deserializable = true, serializable = true)
public final class i {
    public static final h Companion = new h();
    public final Boolean a;
    public final Boolean b;
    public final Boolean c;
    public final Boolean d;
    public final Boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Boolean f86f;
    public final Boolean g;
    public final Boolean h;
    public final Boolean i;

    public /* synthetic */ i(int i, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9) {
        if ((i & 1) == 0) {
            this.a = null;
        } else {
            this.a = bool;
        }
        if ((i & 2) == 0) {
            this.b = null;
        } else {
            this.b = bool2;
        }
        if ((i & 4) == 0) {
            this.c = null;
        } else {
            this.c = bool3;
        }
        if ((i & 8) == 0) {
            this.d = null;
        } else {
            this.d = bool4;
        }
        if ((i & 16) == 0) {
            this.e = null;
        } else {
            this.e = bool5;
        }
        if ((i & 32) == 0) {
            this.f86f = null;
        } else {
            this.f86f = bool6;
        }
        if ((i & 64) == 0) {
            this.g = null;
        } else {
            this.g = bool7;
        }
        if ((i & 128) == 0) {
            this.h = null;
        } else {
            this.h = bool8;
        }
        if ((i & 256) == 0) {
            this.i = null;
        } else {
            this.i = bool9;
        }
    }

    public static i a(i iVar, Boolean bool, int i) {
        Boolean bool2 = Boolean.TRUE;
        Boolean bool3 = iVar.a;
        Boolean bool4 = iVar.b;
        Boolean bool5 = iVar.c;
        if ((i & 8) != 0) {
            bool = iVar.d;
        }
        Boolean bool6 = bool;
        Boolean bool7 = (i & 16) != 0 ? iVar.e : bool2;
        Boolean bool8 = (i & 32) != 0 ? iVar.f86f : bool2;
        Boolean bool9 = (i & 64) != 0 ? iVar.g : bool2;
        Boolean bool10 = (i & 128) != 0 ? iVar.h : bool2;
        if ((i & 256) != 0) {
            bool2 = iVar.i;
        }
        iVar.getClass();
        return new i(bool3, bool4, bool5, bool6, bool7, bool8, bool9, bool10, bool2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, iVar.a) && lmjxuqdtp.jvm.internal.o.c(this.b, iVar.b) && lmjxuqdtp.jvm.internal.o.c(this.c, iVar.c) && lmjxuqdtp.jvm.internal.o.c(this.d, iVar.d) && lmjxuqdtp.jvm.internal.o.c(this.e, iVar.e) && lmjxuqdtp.jvm.internal.o.c(this.f86f, iVar.f86f) && lmjxuqdtp.jvm.internal.o.c(this.g, iVar.g) && lmjxuqdtp.jvm.internal.o.c(this.h, iVar.h) && lmjxuqdtp.jvm.internal.o.c(this.i, iVar.i);
    }

    public final int hashCode() {
        Boolean bool = this.a;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.b;
        int iHashCode2 = (iHashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.c;
        int iHashCode3 = (iHashCode2 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.d;
        int iHashCode4 = (iHashCode3 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.e;
        int iHashCode5 = (iHashCode4 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Boolean bool6 = this.f86f;
        int iHashCode6 = (iHashCode5 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        Boolean bool7 = this.g;
        int iHashCode7 = (iHashCode6 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
        Boolean bool8 = this.h;
        int iHashCode8 = (iHashCode7 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
        Boolean bool9 = this.i;
        return iHashCode8 + (bool9 != null ? bool9.hashCode() : 0);
    }

    public final String toString() {
        return "FirstTimeUXFlags(confirmedEmail=" + this.a + ", createdSong=" + this.b + ", createdBand=" + this.c + ", setPicture=" + this.d + ", setCustomUsername=" + this.e + ", setSkills=" + this.f86f + ", setGenres=" + this.g + ", setInspiredBy=" + this.h + ", usedStudio=" + this.i + ")";
    }

    public i(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9) {
        this.a = bool;
        this.b = bool2;
        this.c = bool3;
        this.d = bool4;
        this.e = bool5;
        this.f86f = bool6;
        this.g = bool7;
        this.h = bool8;
        this.i = bool9;
    }
}
