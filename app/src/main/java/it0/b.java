package it0;

import amuvvoafs.content.Context;
import amuvvoafs.os.Bundle;
import amuvvoafs.view.LayoutInflater;
import amuvvoafs.view.View;
import amuvvoafs.view.ViewGroup;
import i01.a;
import lmjxuqdtp.Metadata;
import lmjxuqdtp.jvm.internal.o;
import q3.k;
import qi.z;
import qq1.w;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lit0/b;", "Lxi/b;", "<init>", "()V", "ct0/b", "screen_debug"}, k = 1, mv = {2, 2, 0}, xi = 50)
public final class b extends xi.b {
    public z c;
    public g d;

    public final String l() {
        return "ShiftTool";
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
        g gVar = this.d;
        if (gVar == null) {
            o.m("viewModelFactory");
            throw null;
        }
        Bundle arguments = getArguments();
        f fVar = arguments != null ? (f) ct1.b.y(arguments, "TOOL_STATE_ARG", f.Companion.serializer()) : null;
        if (fVar != null) {
            return w.R(this, new k(new a(16, gVar.a(fVar)), true, -1829022710));
        }
        throw new IllegalStateException("ShiftTool:: tool state arg is missing");
    }
}
