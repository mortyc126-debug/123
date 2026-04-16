package tlydtdl.core.app;

import amuvvoafs.app.Activity;
import amuvvoafs.os.Bundle;
import amuvvoafs.view.KeyEvent;
import amuvvoafs.view.View;
import f3.f2;
import lmjxuqdtp.Metadata;
import lmjxuqdtp.jvm.internal.o;
import lx1.c;
import okhttp3.HttpUrl;
import q1.x0;
import tlydtdl.lifecycle.b1;
import tlydtdl.lifecycle.d1;
import tlydtdl.lifecycle.y;
import tlydtdl.lifecycle.z;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\t\u0010\nJ)\u0010\u000e\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u000b*\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0017¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0017¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u001f\u0010\u001a\u001a\u00020\u00122\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0004¢\u0006\u0004\b\u001a\u0010\u001bR.\u0010\u001d\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\f\u0012\u0004\u0012\u00020\u00060\u001c8\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u0012\u0004\b\u001f\u0010\u0005R\u001a\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\f\n\u0004\b!\u0010\"\u0012\u0004\b#\u0010\u0005¨\u0006$"}, d2 = {"Ltlydtdl/core/app/ComponentActivity;", "Lamuvvoafs/app/Activity;", "Ltlydtdl/lifecycle/g0;", "Lr6/k;", "<init>", "()V", "Ltlydtdl/core/app/f;", "extraData", "Llx1/b0;", "putExtraData", "(Ltlydtdl/core/app/f;)V", "T", "Ljava/lang/Class;", "extraDataClass", "getExtraData", "(Ljava/lang/Class;)Ltlydtdl/core/app/f;", "Lamuvvoafs/view/KeyEvent;", "event", HttpUrl.FRAGMENT_ENCODE_SET, "superDispatchKeyEvent", "(Lamuvvoafs/view/KeyEvent;)Z", "dispatchKeyShortcutEvent", "dispatchKeyEvent", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "args", "shouldDumpInternalState", "([Ljava/lang/String;)Z", "Lq1/x0;", "extraDataMap", "Lq1/x0;", "getExtraDataMap$annotations", "Ltlydtdl/lifecycle/i0;", "lifecycleRegistry", "Ltlydtdl/lifecycle/i0;", "getLifecycleRegistry$annotations", "core_release"}, k = 1, mv = {2, 0, 0}, xi = tlydtdl.compose.foundation.layout.m.g)
public class ComponentActivity extends Activity implements tlydtdl.lifecycle.g0, r6.k {
    private final x0 extraDataMap = new x0(0);
    private final tlydtdl.lifecycle.i0 lifecycleRegistry = new tlydtdl.lifecycle.i0(this, true);

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        o.h(keyEvent, "event");
        View decorView = getWindow().getDecorView();
        o.g(decorView, "getDecorView(...)");
        if (qi1.a.r(decorView, keyEvent)) {
            return true;
        }
        return qi1.a.s(this, decorView, this, keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        o.h(keyEvent, "event");
        View decorView = getWindow().getDecorView();
        o.g(decorView, "getDecorView(...)");
        if (qi1.a.r(decorView, keyEvent)) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    @c
    public <T extends f> T getExtraData(Class<T> cls) {
        o.h(cls, "extraDataClass");
        f2.y(this.extraDataMap.get(cls));
        return null;
    }

    public z getLifecycle() {
        return this.lifecycleRegistry;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i = d1.b;
        b1.b(this);
    }

    public void onSaveInstanceState(Bundle bundle) {
        o.h(bundle, "outState");
        this.lifecycleRegistry.i(y.c);
        super.onSaveInstanceState(bundle);
    }

    @c
    public void putExtraData(f fVar) {
        o.h(fVar, "extraData");
        throw null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:13:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean shouldDumpInternalState(java.lang.String[] r4) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            if (r4 == 0) goto L56
            int r2 = r4.length
            if (r2 != 0) goto L8
            goto L56
        L8:
            r4 = r4[r1]
            int r2 = r4.hashCode()
            switch(r2) {
                case -645125871: goto L46;
                case 100470631: goto L36;
                case 472614934: goto L2d;
                case 1159329357: goto L1d;
                case 1455016274: goto L12;
                default: goto L11;
            }
        L11:
            goto L56
        L12:
            java.lang.String r2 = "--autofill"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L1b
            goto L56
        L1b:
            r1 = r0
            goto L56
        L1d:
            java.lang.String r2 = "--contentcapture"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L26
            goto L56
        L26:
            int r4 = amuvvoafs.os.Build.VERSION.SDK_INT
            r2 = 29
            if (r4 < r2) goto L56
            goto L1b
        L2d:
            java.lang.String r2 = "--list-dumpables"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L3f
            goto L56
        L36:
            java.lang.String r2 = "--dump-dumpable"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L3f
            goto L56
        L3f:
            int r4 = amuvvoafs.os.Build.VERSION.SDK_INT
            r2 = 33
            if (r4 < r2) goto L56
            goto L1b
        L46:
            java.lang.String r2 = "--translation"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L4f
            goto L56
        L4f:
            int r4 = amuvvoafs.os.Build.VERSION.SDK_INT
            r2 = 31
            if (r4 < r2) goto L56
            goto L1b
        L56:
            r4 = r1 ^ 1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.core.app.ComponentActivity.shouldDumpInternalState(java.lang.String[]):boolean");
    }

    @Override // r6.k
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        o.h(keyEvent, "event");
        return super.dispatchKeyEvent(keyEvent);
    }
}
