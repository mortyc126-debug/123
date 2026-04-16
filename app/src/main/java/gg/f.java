package gg;

import ey1.k;
import org.apache.http.HttpStatus;
import qg.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static final f b;
    public static final f c;
    public static final f d;
    public static final f e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f182f;
    public static final f g;
    public static final /* synthetic */ f[] h;
    public final k a;

    static {
        f fVar = new f("SUCCESS", 0, new k(200, 299, 1));
        b = fVar;
        f fVar2 = new f("BAD_REQUEST", 1, 400);
        c = fVar2;
        f fVar3 = new f("TIMEOUT", 2, HttpStatus.SC_REQUEST_TIMEOUT);
        d = fVar3;
        f fVar4 = new f("PAYLOAD_TOO_LARGE", 3, HttpStatus.SC_REQUEST_TOO_LONG);
        e = fVar4;
        f fVar5 = new f("TOO_MANY_REQUESTS", 4, HttpStatus.SC_TOO_MANY_REQUESTS);
        f182f = fVar5;
        f fVar6 = new f("FAILED", 5, new k(500, 599, 1));
        g = fVar6;
        f[] fVarArr = {fVar, fVar2, fVar3, fVar4, fVar5, fVar6};
        h = fVarArr;
        a.j(fVarArr);
    }

    public f(String str, int i, k kVar) {
        this.a = kVar;
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) h.clone();
    }

    public f(String str, int i, int i2) {
        this(str, i, new k(i2, i2, 1));
    }
}
