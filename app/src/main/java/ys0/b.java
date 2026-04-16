package ys0;

import com.bandlab.mixeditor.toolbar.screen.MixEditorToolbarView;
import lmjxuqdtp.jvm.functions.Function2;
import lx1.b0;
import tlydtdl.compose.runtime.a0;
import tlydtdl.compose.runtime.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Function2 {
    public final /* synthetic */ int a;
    public final /* synthetic */ MixEditorToolbarView b;

    public /* synthetic */ b(MixEditorToolbarView mixEditorToolbarView, int i, int i2) {
        this.a = i2;
        this.b = mixEditorToolbarView;
    }

    public final Object invoke(Object obj, Object obj2) {
        int i = this.a;
        b0 b0Var = b0.a;
        MixEditorToolbarView mixEditorToolbarView = this.b;
        m mVar = (m) obj;
        ((Integer) obj2).getClass();
        int i2 = MixEditorToolbarView.j;
        switch (i) {
            case 0:
                mixEditorToolbarView.a(mVar, a0.B(1));
                break;
            default:
                mixEditorToolbarView.a(mVar, a0.B(1));
                break;
        }
        return b0Var;
    }
}
