package s51;

import lmjxuqdtp.jvm.functions.Function1;
import m10.w;
import nd.c;
import pd.a;
import qd.d;
import rd.g;
import z.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class m0 extends c {
    public final String b;
    public final String c;
    public final Boolean d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final w f449f;
    public final long g;
    public final Boolean h;
    public final long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f450j;
    public final /* synthetic */ n0 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(n0 n0Var, String str, String str2, Boolean bool, String str3, w wVar, long j2, Boolean bool2, long j3, long j4, le1.h hVar) {
        super(hVar);
        this.k = n0Var;
        this.b = str;
        this.c = str2;
        this.d = bool;
        this.e = str3;
        this.f449f = wVar;
        this.g = j2;
        this.h = bool2;
        this.i = j3;
        this.f450j = j4;
    }

    public final void a(a aVar) {
        ((g) this.k.a).a(new String[]{"Songs"}, aVar);
    }

    public final d b(Function1 function1) {
        n0 n0Var = this.k;
        g gVar = (g) n0Var.a;
        String str = this.d == null ? "IS" : "=";
        String str2 = this.e;
        String str3 = str2 == null ? "IS" : "=";
        String str4 = str2 == null ? "IS" : "=";
        String str5 = this.f449f == null ? "IS" : "=";
        String str6 = this.h == null ? "IS" : "=";
        StringBuilder sbJ = p.j("\n    |SELECT\n    |    Projects.userId, Projects.songId, Projects.songStamp, Projects.songName, Projects.isCollaborator, Projects.isPublic, Projects.isFork, Projects.canEdit, Projects.canDelete, Projects.picture, Projects.collaboratorsCount, Projects.lastRevisionCreatedOn, Projects.createdOn, Projects.authorId, Projects.authorType, Projects.authorName, Projects.revisionId, Projects.revisionStamp, Projects.status\n    |FROM Projects\n    |WHERE\n    |    -- select only songs from this user\n    |    userId = ?\n    |    AND\n    |    (? = '' OR songName LIKE ?)\n    |    AND\n    |    (? IS NULL OR isPublic ", str, " ?)\n    |    AND\n    |    (? IS NULL OR ? ", str3, " '' OR authorId ");
        s1.a.y(sbJ, str4, " ?)\n    |    AND\n    |    (? IS NULL OR authorType ", str5, " ?)\n    |    AND\n    |    (? = 0 OR isCollaborator = 1 OR collaboratorsCount > 0)\n    |    AND\n    |    (? IS NULL OR isFork ");
        sbJ.append(str6);
        sbJ.append(" ?)\n    |    AND\n    |    (status IS NULL OR status != 'Deleted')\n    |ORDER BY lastRevisionCreatedOn DESC\n    |LIMIT ? OFFSET ?\n    ");
        return gVar.f(null, hy1.r.d0(sbJ.toString()), function1, 15, new le1.h(18, this, n0Var));
    }

    public final void e(a aVar) {
        lmjxuqdtp.jvm.internal.o.h(aVar, "listener");
        ((g) this.k.a).t(new String[]{"Songs"}, aVar);
    }

    public final String toString() {
        return "Song.sq:songListByLastModified";
    }
}
