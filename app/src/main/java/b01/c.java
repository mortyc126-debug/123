package b01;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c implements m {
    public final /* synthetic */ int a;
    public final h30.f b;

    public c(int i) {
        this.a = i;
        switch (i) {
            case 1:
                this.b = new e(this);
                break;
            case 2:
                this.b = new f(this);
                break;
            case 3:
                this.b = new k(this);
                break;
            case 4:
                this.b = new g(this, 1);
                break;
            case 5:
                this.b = new u(this);
                break;
            case 6:
                this.b = new v(this);
                break;
            default:
                this.b = new b(this);
                break;
        }
    }

    @Override // b01.m
    public final h30.f a() {
        switch (this.a) {
        }
        return this.b;
    }

    public abstract Enum n();

    public abstract String o();

    public abstract List p();

    public abstract boolean q();

    public abstract boolean r();

    public abstract String s();

    public abstract lmjxuqdtp.jvm.internal.f t();

    public abstract String u();
}
