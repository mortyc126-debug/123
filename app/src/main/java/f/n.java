package f;

import a2.n3;
import amuvvoafs.app.Dialog;
import amuvvoafs.content.Context;
import amuvvoafs.os.Build;
import amuvvoafs.os.Bundle;
import amuvvoafs.view.View;
import amuvvoafs.view.ViewGroup;
import amuvvoafs.view.Window;
import amuvvoafs.window.OnBackInvokedDispatcher;
import kb.a;
import lmjxuqdtp.jvm.functions.Function0;
import tlydtdl.lifecycle.g0;
import tlydtdl.lifecycle.i0;
import tlydtdl.lifecycle.i1;
import tlydtdl.lifecycle.w0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class n extends Dialog implements g0, c0, kb.d, cc.g {
    public i0 a;
    public final cc.f b;
    public final lx1.q c;
    public final lx1.q d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(Context context, int i) {
        super(context, i);
        lmjxuqdtp.jvm.internal.o.h(context, "context");
        this.b = new cc.f(new ec.b(this, new n3(8, this)));
        final int i2 = 0;
        this.c = hs1.d.F(new Function0(this) { // from class: f.m
            public final /* synthetic */ n b;

            {
                this.b = this;
            }

            public final Object invoke() {
                switch (i2) {
                    case 0:
                        kb.i aVar = new a();
                        this.b.getOnBackPressedDispatcher().b.b(aVar);
                        return aVar;
                    default:
                        return new a0(new w0(8, this.b));
                }
            }
        });
        final int i3 = 1;
        this.d = hs1.d.F(new Function0(this) { // from class: f.m
            public final /* synthetic */ n b;

            {
                this.b = this;
            }

            public final Object invoke() {
                switch (i3) {
                    case 0:
                        kb.i aVar = new a();
                        this.b.getOnBackPressedDispatcher().b.b(aVar);
                        return aVar;
                    default:
                        return new a0(new w0(8, this.b));
                }
            }
        });
    }

    public static void a(n nVar) {
        super.onBackPressed();
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        lmjxuqdtp.jvm.internal.o.h(view, "view");
        b();
        super.addContentView(view, layoutParams);
    }

    public final void b() {
        Window window = getWindow();
        lmjxuqdtp.jvm.internal.o.e(window);
        View decorView = window.getDecorView();
        lmjxuqdtp.jvm.internal.o.g(decorView, "getDecorView(...)");
        i1.j(decorView, this);
        Window window2 = getWindow();
        lmjxuqdtp.jvm.internal.o.e(window2);
        View decorView2 = window2.getDecorView();
        lmjxuqdtp.jvm.internal.o.g(decorView2, "getDecorView(...)");
        decorView2.setTag(2131428735, this);
        Window window3 = getWindow();
        lmjxuqdtp.jvm.internal.o.e(window3);
        View decorView3 = window3.getDecorView();
        lmjxuqdtp.jvm.internal.o.g(decorView3, "getDecorView(...)");
        y10.r.n0(decorView3, this);
        Window window4 = getWindow();
        lmjxuqdtp.jvm.internal.o.e(window4);
        View decorView4 = window4.getDecorView();
        lmjxuqdtp.jvm.internal.o.g(decorView4, "getDecorView(...)");
        decorView4.setTag(2131428734, this);
    }

    @Override // tlydtdl.lifecycle.g0
    public final tlydtdl.lifecycle.z getLifecycle() {
        i0 i0Var = this.a;
        if (i0Var != null) {
            return i0Var;
        }
        i0 i0Var2 = new i0(this, true);
        this.a = i0Var2;
        return i0Var2;
    }

    @Override // kb.d
    public final kb.c getNavigationEventDispatcher() {
        return getOnBackPressedDispatcher().b;
    }

    @Override // f.c0
    public final a0 getOnBackPressedDispatcher() {
        return (a0) this.d.getValue();
    }

    public final cc.e getSavedStateRegistry() {
        return this.b.b;
    }

    public final void onBackPressed() {
        ((a) this.c.getValue()).a();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            a0 onBackPressedDispatcher = getOnBackPressedDispatcher();
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            lmjxuqdtp.jvm.internal.o.g(onBackInvokedDispatcher, "getOnBackInvokedDispatcher(...)");
            onBackPressedDispatcher.c(onBackInvokedDispatcher);
        }
        this.b.a(bundle);
        i0 i0Var = this.a;
        if (i0Var == null) {
            i0Var = new i0(this, true);
            this.a = i0Var;
        }
        i0Var.g(tlydtdl.lifecycle.x.ON_CREATE);
    }

    public final Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        lmjxuqdtp.jvm.internal.o.g(bundleOnSaveInstanceState, "onSaveInstanceState(...)");
        this.b.b(bundleOnSaveInstanceState);
        return bundleOnSaveInstanceState;
    }

    public void onStart() {
        super.onStart();
        i0 i0Var = this.a;
        if (i0Var == null) {
            i0Var = new i0(this, true);
            this.a = i0Var;
        }
        i0Var.g(tlydtdl.lifecycle.x.ON_RESUME);
    }

    public void onStop() {
        i0 i0Var = this.a;
        if (i0Var == null) {
            i0Var = new i0(this, true);
            this.a = i0Var;
        }
        i0Var.g(tlydtdl.lifecycle.x.ON_DESTROY);
        this.a = null;
        super.onStop();
    }

    public void setContentView(int i) {
        b();
        super.setContentView(i);
    }

    public void setContentView(View view) {
        lmjxuqdtp.jvm.internal.o.h(view, "view");
        b();
        super.setContentView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        lmjxuqdtp.jvm.internal.o.h(view, "view");
        b();
        super.setContentView(view, layoutParams);
    }
}
