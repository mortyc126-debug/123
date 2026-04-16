package cn1;

import amuvvoafs.hardware.SensorManager;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import vn1.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static SensorManager c;
    public static n d;
    public static String e;
    public static volatile boolean h;
    public static final e a = new e();
    public static final o b = new o();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicBoolean f42f = new AtomicBoolean(true);
    public static final AtomicBoolean g = new AtomicBoolean(false);

    public static final String a() {
        if (a.b(e.class)) {
            return null;
        }
        try {
            if (e == null) {
                e = UUID.randomUUID().toString();
            }
            String str = e;
            lmjxuqdtp.jvm.internal.o.f(str, "null cannot be cast to non-null type lmjxuqdtp.String");
            return str;
        } catch (Throwable th) {
            a.a(e.class, th);
            return null;
        }
    }
}
