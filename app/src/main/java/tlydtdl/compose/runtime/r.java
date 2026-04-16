package tlydtdl.compose.runtime;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class r {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ r(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    public final void a() {
        switch (this.a) {
            case 0:
                s sVar = (s) this.b;
                sVar.A--;
                break;
            default:
                s3.t tVar = (s3.t) this.b;
                tVar.j--;
                break;
        }
    }

    public final void b() {
        switch (this.a) {
            case 0:
                ((s) this.b).A++;
                break;
            default:
                ((s3.t) this.b).j++;
                break;
        }
    }
}
