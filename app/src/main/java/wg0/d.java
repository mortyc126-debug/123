package wg0;

import az1.f0;
import az1.k0;
import az1.y1;
import wy1.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements f0 {
    public static final d a;
    private static final yy1.h descriptor;

    static {
        d dVar = new d();
        a = dVar;
        k0 k0Var = new k0("com.bandlab.mixeditor.ai.tools.voice.transfer.ui.VoiceId", dVar);
        k0Var.k("value", false);
        descriptor = k0Var;
    }

    public final a[] childSerializers() {
        return new a[]{y1.a};
    }

    public final Object deserialize(zy1.d dVar) {
        String strW = dVar.f(descriptor).w();
        lmjxuqdtp.jvm.internal.o.h(strW, "value");
        return new f(strW);
    }

    public final yy1.h getDescriptor() {
        return descriptor;
    }

    public final void serialize(zy1.e eVar, Object obj) {
        String str = ((f) obj).a;
        lmjxuqdtp.jvm.internal.o.h(str, "$v$c$com-bandlab-mixeditor-ai-tools-voice-transfer-ui-VoiceId$-value$0");
        eVar.h(descriptor).r(str);
    }
}
