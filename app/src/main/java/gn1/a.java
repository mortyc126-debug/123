package gn1;

import amuvvoafs.os.Bundle;
import amuvvoafs.os.OutcomeReceiver;
import amuvvoafs.util.Log;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements OutcomeReceiver {
    public final void onError(Throwable th) {
        String str;
        fn1.a aVar;
        Exception exc = (Exception) th;
        o.h(exc, "error");
        if (vn1.a.b(b.class)) {
            str = null;
        } else {
            try {
                str = b.b;
            } catch (Throwable th2) {
                vn1.a.a(b.class, th2);
                str = null;
            }
        }
        Log.d(str, "OUTCOME_RECEIVER_TRIGGER_FAILURE");
        if (vn1.a.b(b.class)) {
            aVar = null;
        } else {
            try {
                aVar = b.d;
            } catch (Throwable th3) {
                vn1.a.a(b.class, th3);
                aVar = null;
            }
        }
        if (aVar == null) {
            o.m("gpsDebugLogger");
            throw null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("gps_ara_failed_reason", exc.toString());
        aVar.a(bundle, "gps_ara_failed");
    }

    public final void onResult(Object obj) {
        String str;
        fn1.a aVar;
        o.h(obj, "result");
        if (vn1.a.b(b.class)) {
            str = null;
        } else {
            try {
                str = b.b;
            } catch (Throwable th) {
                vn1.a.a(b.class, th);
                str = null;
            }
        }
        Log.d(str, "OUTCOME_RECEIVER_TRIGGER_SUCCESS");
        if (vn1.a.b(b.class)) {
            aVar = null;
        } else {
            try {
                aVar = b.d;
            } catch (Throwable th2) {
                vn1.a.a(b.class, th2);
                aVar = null;
            }
        }
        if (aVar != null) {
            aVar.a((Bundle) null, "gps_ara_succeed");
        } else {
            o.m("gpsDebugLogger");
            throw null;
        }
    }
}
