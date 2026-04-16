package es0;

import com.bandlab.mixeditor.settings.screen.StudioSettingsView;
import lmjxuqdtp.jvm.functions.Function2;
import lx1.b0;
import tlydtdl.compose.runtime.a0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u implements Function2 {
    public final /* synthetic */ int a;
    public final /* synthetic */ StudioSettingsView b;

    public /* synthetic */ u(StudioSettingsView studioSettingsView, int i, int i2) {
        this.a = i2;
        this.b = studioSettingsView;
    }

    public final Object invoke(Object obj, Object obj2) {
        int i = this.a;
        b0 b0Var = b0.a;
        StudioSettingsView studioSettingsView = this.b;
        tlydtdl.compose.runtime.m mVar = (tlydtdl.compose.runtime.m) obj;
        ((Integer) obj2).getClass();
        int i2 = StudioSettingsView.j;
        switch (i) {
            case 0:
                studioSettingsView.a(mVar, a0.B(1));
                break;
            default:
                studioSettingsView.a(mVar, a0.B(1));
                break;
        }
        return b0Var;
    }
}
