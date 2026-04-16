package s51;

import lmjxuqdtp.jvm.functions.Function1;
import nd.c;
import p90.f;
import pd.a;
import qd.d;
import qu0.p;
import rd.g;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class k0 extends c {
    public final /* synthetic */ int b = 0;
    public final String c;
    public final /* synthetic */ n0 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(n0 n0Var, String str, le1.h hVar) {
        super(hVar);
        lmjxuqdtp.jvm.internal.o.h(str, "userId");
        this.d = n0Var;
        this.c = str;
    }

    public final void a(a aVar) {
        switch (this.b) {
            case 0:
                ((g) this.d.a).a(new String[]{"Songs"}, aVar);
                break;
            default:
                ((g) this.d.a).a(new String[]{"Songs"}, aVar);
                break;
        }
    }

    public final d b(Function1 function1) {
        switch (this.b) {
            case 0:
                return ((g) this.d.a).f(-1240525950, "SELECT Songs.userId, Songs.songId, Songs.songStamp, Songs.song, Songs.songName, Songs.isCollaborator, Songs.isPublic, Songs.isFork, Songs.canEdit, Songs.canDelete, Songs.picture, Songs.collaboratorsCount, Songs.lastRevisionCreatedOn, Songs.createdOn, Songs.authorId, Songs.authorType, Songs.authorName, Songs.revisionId, Songs.revisionStamp, Songs.status FROM Songs\nWHERE userId = ?", function1, 1, new p(20, this));
            default:
                return ((g) this.d.a).f(-335818836, "SELECT COUNT(*) FROM Songs\nWHERE userId = ?", function1, 1, new lb.d(29, this));
        }
    }

    public final void e(a aVar) {
        switch (this.b) {
            case 0:
                lmjxuqdtp.jvm.internal.o.h(aVar, "listener");
                ((g) this.d.a).t(new String[]{"Songs"}, aVar);
                break;
            default:
                lmjxuqdtp.jvm.internal.o.h(aVar, "listener");
                ((g) this.d.a).t(new String[]{"Songs"}, aVar);
                break;
        }
    }

    public final String toString() {
        switch (this.b) {
            case 0:
                return "Song.sq:selectAllSongs";
            default:
                return "Song.sq:totalSongsCount";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(n0 n0Var, String str, f fVar) {
        super(fVar);
        this.d = n0Var;
        this.c = str;
    }
}
