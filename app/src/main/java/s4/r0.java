package s4;

import java.util.Map;
import lmjxuqdtp.jvm.functions.Function1;
import q4.v0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class r0 implements v0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Map c;
    public final /* synthetic */ Function1 d;
    public final /* synthetic */ Function1 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ s0 f440f;

    public r0(int i, int i2, Map map, Function1 function1, Function1 function12, s0 s0Var) {
        this.a = i;
        this.b = i2;
        this.c = map;
        this.d = function1;
        this.e = function12;
        this.f440f = s0Var;
    }

    public final Map b() {
        return this.c;
    }

    public final void c() {
        this.e.invoke(this.f440f.l);
    }

    public final Function1 d() {
        return this.d;
    }

    public final int getHeight() {
        return this.b;
    }

    public final int getWidth() {
        return this.a;
    }
}
