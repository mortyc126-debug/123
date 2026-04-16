package gt0;

import amuvvoafs.content.Context;
import amuvvoafs.os.Bundle;
import amuvvoafs.view.LayoutInflater;
import amuvvoafs.view.View;
import amuvvoafs.view.ViewGroup;
import lmjxuqdtp.Metadata;
import lmjxuqdtp.jvm.internal.o;
import q3.k;
import qi.z;
import qq1.w;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lgt0/a;", "Lxi/b;", "<init>", "()V", "ex/f", "screen_debug"}, k = 1, mv = {2, 2, 0}, xi = 50)
public final class a extends xi.b {
    public z c;
    public h d;

    public final String l() {
        return "LoopTool";
    }

    public final z m() {
        z zVar = this.c;
        if (zVar != null) {
            return zVar;
        }
        o.m("screenTracker");
        throw null;
    }

    public final void onAttach(Context context) {
        o.h(context, "context");
        ch0.b.S(this);
        super.onAttach(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        o.h(layoutInflater, "inflater");
        return w.R(this, new k(new g81.b(8, this), true, 1738202544));
    }
}
