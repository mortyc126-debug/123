package tp;

import bh.j;
import bp.d;
import com.facebook.FacebookException;
import com.facebook.FacebookSdkNotInitializedException;
import com.facebook.internal.i;
import com.facebook.login.u;
import com.facebook.login.y;
import java.util.List;
import lmjxuqdtp.jvm.functions.Function1;
import ny1.z;
import rp.a;
import rp.g;
import tlydtdl.activity.ComponentActivity;
import tlydtdl.lifecycle.i1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements g {
    public final ComponentActivity a;

    public c(ComponentActivity componentActivity) {
        this.a = componentActivity;
    }

    public final d a() {
        return d.i;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.facebook.FacebookException */
    public final a b(Function1 function1) throws FacebookException {
        List listC = ct1.b.C(new String[]{"email", "public_profile"});
        ComponentActivity componentActivity = this.a;
        b bVar = new b(componentActivity, listC);
        y yVar = (y) bVar.d.getValue();
        if (yVar == null) {
            bVar.c(new FacebookSdkNotInitializedException());
        } else {
            rs1.d dVar = new rs1.d(17, bVar);
            i iVar = bVar.e;
            if (iVar == null) {
                throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
            }
            int iA = j.a(1);
            u uVar = new u(yVar, dVar);
            iVar.a.put(Integer.valueOf(iA), uVar);
        }
        z.J(i1.g(componentActivity), i1.c(z10.d.l(new au1.b(4, function1, (qx1.d) null), bVar.c), componentActivity.getLifecycle(), tlydtdl.lifecycle.y.d));
        return bVar;
    }
}
