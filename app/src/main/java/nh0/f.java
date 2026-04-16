package nh0;

import amuvvoafs.app.Dialog;
import amuvvoafs.graphics.drawable.ColorDrawable;
import amuvvoafs.os.Bundle;
import amuvvoafs.view.Window;
import ky1.b0;
import ky1.c0;
import ky1.l1;
import ky1.s;
import lmjxuqdtp.Metadata;
import lmjxuqdtp.jvm.internal.o;
import okhttp3.HttpUrl;
import q3.k;
import qq1.w;
import qx1.i;
import tlydtdl.lifecycle.i1;
import v2.p;
import xi.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006²\u0006\u000e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\nX\u008a\u0084\u0002"}, d2 = {"Lnh0/f;", "Lxi/a;", "<init>", "()V", "Lnh0/i;", "viewModel", "dialog_debug"}, k = 1, mv = {2, 2, 0}, xi = 50)
public abstract class f extends a {
    public final s r = new s();

    /* JADX WARN: Multi-variable type inference failed */
    public final Dialog n(Bundle bundle) {
        String string;
        Bundle arguments = getArguments();
        String string2 = arguments != null ? arguments.getString("text_arg") : null;
        if (bundle != null && (string = bundle.getString("text_arg")) != null) {
            string2 = string;
        } else if (string2 == null) {
            string2 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        s();
        c0.F(i1.g(this), (i) null, (b0) null, new nc0.d(this, string2, (qx1.d) null, 3), 3);
        Dialog dialog = new Dialog(requireContext());
        dialog.requestWindowFeature(1);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
        }
        Window window2 = dialog.getWindow();
        if (window2 != null) {
            window2.setBackgroundDrawable(new ColorDrawable(0));
        }
        dialog.setContentView(w.Q(this, xf1.a.b, new k(new mw0.b(8, this), true, -518335308)));
        return dialog;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSaveInstanceState(Bundle bundle) {
        i iVar;
        p pVarA;
        o.h(bundle, "outState");
        super/*tlydtdl.fragment.app.x*/.onSaveInstanceState(bundle);
        l1 l1Var = this.r;
        String strK = null;
        if (!l1Var.g()) {
            l1Var = null;
        }
        if (l1Var != null && (iVar = (i) l1Var.E()) != null && (pVarA = iVar.a()) != null) {
            strK = he1.d.k(pVarA);
        }
        bundle.putString("text_arg", strK);
    }

    public abstract i r(String str);

    public abstract void s();
}
