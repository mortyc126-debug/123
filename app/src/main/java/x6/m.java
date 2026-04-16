package x6;

import amuvvoafs.content.Context;
import amuvvoafs.credentials.CredentialManager;
import amuvvoafs.credentials.CredentialOption;
import amuvvoafs.credentials.GetCredentialRequest;
import amuvvoafs.os.Build;
import amuvvoafs.os.Bundle;
import amuvvoafs.os.CancellationSignal;
import amuvvoafs.os.Parcelable;
import java.util.concurrent.Executor;
import lmjxuqdtp.jvm.internal.o;
import p02.u;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class m implements k {
    public final CredentialManager a;

    public m(Context context) {
        o.h(context, "context");
        this.a = (CredentialManager) context.getSystemService("credential");
    }

    @Override // x6.k
    public final boolean isAvailableOnDevice() {
        return Build.VERSION.SDK_INT >= 34 && this.a != null;
    }

    @Override // x6.k
    public final void onGetCredential(Context context, p pVar, CancellationSignal cancellationSignal, Executor executor, i iVar) {
        o.h(context, "context");
        u uVar = (u) iVar;
        b5.b bVar = new b5.b(21, uVar);
        CredentialManager credentialManager = this.a;
        if (credentialManager == null) {
            bVar.invoke();
            return;
        }
        l lVar = new l(uVar, this);
        Bundle bundle = new Bundle();
        bundle.putBoolean("tlydtdl.credentials.BUNDLE_KEY_PREFER_IDENTITY_DOC_UI", false);
        bundle.putBoolean("tlydtdl.credentials.BUNDLE_KEY_PREFER_IMMEDIATELY_AVAILABLE_CREDENTIALS", false);
        bundle.putParcelable("tlydtdl.credentials.BUNDLE_KEY_PREFER_UI_BRANDING_COMPONENT_NAME", (Parcelable) null);
        GetCredentialRequest.Builder builder = new GetCredentialRequest.Builder(bundle);
        for (j jVar : pVar.a) {
            builder.addCredentialOption(new CredentialOption.Builder(jVar.a, jVar.b, jVar.c).setIsSystemProviderRequired(jVar.d).setAllowedProviders(jVar.f689f).build());
        }
        GetCredentialRequest getCredentialRequestBuild = builder.build();
        o.g(getCredentialRequestBuild, "builder.build()");
        credentialManager.getCredential(context, getCredentialRequestBuild, cancellationSignal, executor, lVar);
    }
}
