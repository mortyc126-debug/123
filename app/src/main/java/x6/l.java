package x6;

import amuvvoafs.credentials.Credential;
import amuvvoafs.credentials.GetCredentialException;
import amuvvoafs.credentials.GetCredentialResponse;
import amuvvoafs.os.Bundle;
import amuvvoafs.os.OutcomeReceiver;
import amuvvoafs.util.Log;
import dd.v;
import lmjxuqdtp.jvm.internal.o;
import p02.u;
import tt1.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements OutcomeReceiver {
    public final /* synthetic */ u a;

    public l(u uVar, m mVar) {
        this.a = uVar;
    }

    public final void onError(Throwable th) {
        GetCredentialException getCredentialException = (GetCredentialException) th;
        o.h(getCredentialException, "error");
        Log.i("CredManProvService", "GetCredentialResponse error returned from framework");
        String type = getCredentialException.getType();
        o.g(type, "error.type");
        this.a.a(v.J(getCredentialException.getMessage(), type));
    }

    public final void onResult(Object obj) {
        GetCredentialResponse getCredentialResponseF = a.f(obj);
        o.h(getCredentialResponseF, "response");
        Log.i("CredManProvService", "GetCredentialResponse returned from framework");
        Credential credential = getCredentialResponseF.getCredential();
        o.g(credential, "response.credential");
        String type = credential.getType();
        o.g(type, "credential.type");
        Bundle data = credential.getData();
        o.g(data, "credential.data");
        this.a.b(new q(qh0.b.v(data, type)));
    }
}
