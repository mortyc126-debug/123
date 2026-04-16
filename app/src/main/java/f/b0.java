package f;

import com.bandlab.bandlab.feature.mixeditor.MixEditorActivity;
import lmjxuqdtp.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 extends w {
    public final /* synthetic */ int d;
    public final /* synthetic */ Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b0(int i, Object obj) {
        super(true);
        this.d = i;
        this.e = obj;
    }

    @Override // f.w
    public final void b() {
        switch (this.d) {
            case 0:
                ((Function1) this.e).invoke(this);
                break;
            default:
                MixEditorActivity mixEditorActivity = (MixEditorActivity) this.e;
                if (mixEditorActivity.u != null) {
                    mixEditorActivity.y().l.t();
                }
                break;
        }
    }
}
