package zq0;

import b01.i;
import b01.r;
import mx1.t;
import so0.z0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends i {
    public final /* synthetic */ int b;
    public final vb0.a c;
    public final az1.d d;
    public final t e;

    /* JADX INFO: renamed from: f */
    public final b01.n f743f;
    public final r g;

    public a(vb0.a aVar, int i) {
        this.b = i;
        switch (i) {
            case 1:
                this.c = aVar;
                this.d = by1.b.d(z0.Companion.serializer());
                this.e = t.a;
                this.f743f = b01.n.a;
                this.g = r.a;
                break;
            default:
                this.c = aVar;
                this.d = by1.b.d(z0.Companion.serializer());
                this.e = t.a;
                this.f743f = b01.n.a;
                this.g = r.a;
                break;
        }
    }

    @Override // b01.i
    public final Object b() {
        switch (this.b) {
        }
        return this.e;
    }

    @Override // b01.i
    public final vb0.a c() {
        switch (this.b) {
        }
        return this.c;
    }

    @Override // b01.i
    public final String d() {
        switch (this.b) {
            case 0:
                return "artistPresetsCache";
            default:
                return "trendingPresetsCache";
        }
    }

    @Override // b01.i
    public final wy1.a e() {
        switch (this.b) {
        }
        return this.d;
    }

    @Override // b01.m
    public final b01.n f() {
        switch (this.b) {
        }
        return this.f743f;
    }

    @Override // b01.m
    public final b01.t g() {
        switch (this.b) {
        }
        return this.g;
    }
}
