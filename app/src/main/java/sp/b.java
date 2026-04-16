package sp;

import aw0.e;
import bp.d;
import com.bandlab.media.player.impl.r;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.internal.n;
import ny1.z;
import rp.g;
import tlydtdl.activity.ComponentActivity;
import tlydtdl.lifecycle.i1;
import tlydtdl.lifecycle.y;
import xu0.w;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements g {
    public final ComponentActivity a;
    public final e b;
    public final w c;

    public b(ComponentActivity componentActivity, e eVar, w wVar) {
        this.a = componentActivity;
        this.b = eVar;
        this.c = wVar;
    }

    public final d a() {
        return d.j;
    }

    public final rp.a b(Function1 function1) {
        e eVar = this.b;
        w wVar = this.c;
        ComponentActivity componentActivity = this.a;
        a aVar = new a(componentActivity, eVar, wVar);
        z.J(i1.g(componentActivity), i1.c(z10.d.l(new r(2, function1, n.class, "suspendConversion0", "registerCallback$suspendConversion0(Llmjxuqdtp/jvm/functions/Function1;Lcom/bandlab/auth/social/SocialLoginResult;Llmjxuqdtp/coroutines/Continuation;)Ljava/lang/Object;", 0, 13), aVar.b), componentActivity.getLifecycle(), y.d));
        return aVar;
    }
}
