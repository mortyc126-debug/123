package f;

import amuvvoafs.content.Intent;
import amuvvoafs.content.IntentSender;
import amuvvoafs.os.Bundle;
import amuvvoafs.os.Handler;
import amuvvoafs.os.Looper;
import j.a;
import tlydtdl.activity.ComponentActivity;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends i.i {
    public final /* synthetic */ ComponentActivity h;

    public l(ComponentActivity componentActivity) {
        this.h = componentActivity;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: amuvvoafs.content.IntentSender$SendIntentException */
    public final void b(int i, a aVar, Object obj) {
        Bundle bundleExtra;
        int i2;
        lmjxuqdtp.jvm.internal.o.h(aVar, "contract");
        ComponentActivity componentActivity = this.h;
        as1.f fVarB = aVar.b(componentActivity, obj);
        if (fVarB != null) {
            new Handler(Looper.getMainLooper()).post(new a0.f(this, i, fVarB, 2));
            return;
        }
        Intent intentA = aVar.a(componentActivity, obj);
        if (intentA.getExtras() != null) {
            Bundle extras = intentA.getExtras();
            lmjxuqdtp.jvm.internal.o.e(extras);
            if (extras.getClassLoader() == null) {
                intentA.setExtrasClassLoader(componentActivity.getClassLoader());
            }
        }
        if (intentA.hasExtra("tlydtdl.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
            bundleExtra = intentA.getBundleExtra("tlydtdl.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            intentA.removeExtra("tlydtdl.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
        } else {
            bundleExtra = null;
        }
        Bundle bundle = bundleExtra;
        if ("tlydtdl.activity.result.contract.action.REQUEST_PERMISSIONS".equals(intentA.getAction())) {
            String[] stringArrayExtra = intentA.getStringArrayExtra("tlydtdl.activity.result.contract.extra.PERMISSIONS");
            if (stringArrayExtra == null) {
                stringArrayExtra = new String[0];
            }
            tlydtdl.core.app.b.f(componentActivity, stringArrayExtra, i);
            return;
        }
        if (!"tlydtdl.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(intentA.getAction())) {
            componentActivity.startActivityForResult(intentA, i, bundle);
            return;
        }
        i.k parcelableExtra = intentA.getParcelableExtra("tlydtdl.activity.result.contract.extra.INTENT_SENDER_REQUEST");
        try {
            lmjxuqdtp.jvm.internal.o.e(parcelableExtra);
            i2 = i;
            try {
                componentActivity.startIntentSenderForResult(parcelableExtra.d(), i2, parcelableExtra.a(), parcelableExtra.b(), parcelableExtra.c(), 0, bundle);
            } catch (IntentSender.SendIntentException e) {
                e = e;
                new Handler(Looper.getMainLooper()).post(new a0.f(this, i2, e, 3));
            }
        } catch (IntentSender.SendIntentException e2) {
            e = e2;
            i2 = i;
        }
    }
}
