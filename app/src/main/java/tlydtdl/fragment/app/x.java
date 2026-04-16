package tlydtdl.fragment.app;

import amuvvoafs.app.Activity;
import amuvvoafs.app.Dialog;
import amuvvoafs.content.Context;
import amuvvoafs.content.DialogInterface;
import amuvvoafs.os.Bundle;
import amuvvoafs.os.Handler;
import amuvvoafs.os.Looper;
import amuvvoafs.util.Log;
import amuvvoafs.view.LayoutInflater;
import amuvvoafs.view.View;
import amuvvoafs.view.ViewGroup;
import amuvvoafs.view.Window;
import f.n;
import o6.c;
import tlydtdl.lifecycle.i1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class x extends k0 implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public Handler a;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f595j;
    public Dialog l;
    public boolean m;
    public boolean n;
    public boolean o;
    public final s b = new s(0, this);
    public final t c = new t(this);
    public final u d = new u(this);
    public int e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f594f = 0;
    public boolean g = true;
    public boolean h = true;
    public int i = -1;
    public final v k = new v(this);
    public boolean p = false;

    @Override // tlydtdl.fragment.app.k0
    public final q0 createFragmentContainer() {
        return new w(this, super.createFragmentContainer());
    }

    public void l() {
        m(false, false);
    }

    public final void m(boolean z, boolean z2) {
        if (this.n) {
            return;
        }
        this.n = true;
        this.o = false;
        Dialog dialog = this.l;
        if (dialog != null) {
            dialog.setOnDismissListener((DialogInterface.OnDismissListener) null);
            this.l.dismiss();
            if (!z2) {
                if (Looper.myLooper() == this.a.getLooper()) {
                    onDismiss(this.l);
                } else {
                    this.a.post(this.b);
                }
            }
        }
        this.m = true;
        if (this.i >= 0) {
            k1 parentFragmentManager = getParentFragmentManager();
            int i = this.i;
            parentFragmentManager.getClass();
            if (i < 0) {
                throw new IllegalArgumentException(c.k(i, "Bad id: "));
            }
            parentFragmentManager.y(new i1(parentFragmentManager, i, 1), z);
            this.i = -1;
            return;
        }
        k1 parentFragmentManager2 = getParentFragmentManager();
        parentFragmentManager2.getClass();
        a aVar = new a(parentFragmentManager2);
        aVar.p = true;
        aVar.k(this);
        if (z) {
            aVar.i(true, true);
        } else {
            aVar.d();
        }
    }

    public Dialog n(Bundle bundle) {
        if (k1.N(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new n(requireContext(), this.f594f);
    }

    public final void o(int i) {
        if (k1.N(2)) {
            Log.d("FragmentManager", "Setting style and theme for DialogFragment " + this + " to 0, " + i);
        }
        this.e = 0;
        if (i != 0) {
            this.f594f = i;
        }
    }

    @Override // tlydtdl.fragment.app.k0
    public void onAttach(Context context) {
        super.onAttach(context);
        getViewLifecycleOwnerLiveData().f(this.k);
        if (this.o) {
            return;
        }
        this.n = false;
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // tlydtdl.fragment.app.k0
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new Handler();
        this.h = this.mContainerId == 0;
        if (bundle != null) {
            this.e = bundle.getInt("amuvvoafs:style", 0);
            this.f594f = bundle.getInt("amuvvoafs:theme", 0);
            this.g = bundle.getBoolean("amuvvoafs:cancelable", true);
            this.h = bundle.getBoolean("amuvvoafs:showsDialog", this.h);
            this.i = bundle.getInt("amuvvoafs:backStackId", -1);
        }
    }

    @Override // tlydtdl.fragment.app.k0
    public void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.l;
        if (dialog != null) {
            this.m = true;
            dialog.setOnDismissListener((DialogInterface.OnDismissListener) null);
            this.l.dismiss();
            if (!this.n) {
                onDismiss(this.l);
            }
            this.l = null;
            this.p = false;
        }
    }

    @Override // tlydtdl.fragment.app.k0
    public final void onDetach() {
        super.onDetach();
        if (!this.o && !this.n) {
            this.n = true;
        }
        getViewLifecycleOwnerLiveData().i(this.k);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (this.m) {
            return;
        }
        if (k1.N(3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        m(true, true);
    }

    @Override // tlydtdl.fragment.app.k0
    public final LayoutInflater onGetLayoutInflater(Bundle bundle) {
        LayoutInflater layoutInflaterOnGetLayoutInflater = super.onGetLayoutInflater(bundle);
        boolean z = this.h;
        if (z && !this.f595j) {
            if (z && !this.p) {
                try {
                    this.f595j = true;
                    Dialog dialogN = n(bundle);
                    this.l = dialogN;
                    if (this.h) {
                        p(dialogN, this.e);
                        Activity context = getContext();
                        if (context instanceof Activity) {
                            this.l.setOwnerActivity(context);
                        }
                        this.l.setCancelable(this.g);
                        this.l.setOnCancelListener(this.c);
                        this.l.setOnDismissListener(this.d);
                        this.p = true;
                    } else {
                        this.l = null;
                    }
                    this.f595j = false;
                } catch (Throwable th) {
                    this.f595j = false;
                    throw th;
                }
            }
            if (k1.N(2)) {
                Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
            }
            Dialog dialog = this.l;
            if (dialog != null) {
                return layoutInflaterOnGetLayoutInflater.cloneInContext(dialog.getContext());
            }
        } else if (k1.N(2)) {
            String str = "getting layout inflater for DialogFragment " + this;
            if (!this.h) {
                Log.d("FragmentManager", "mShowsDialog = false: " + str);
                return layoutInflaterOnGetLayoutInflater;
            }
            Log.d("FragmentManager", "mCreatingDialog = true: " + str);
        }
        return layoutInflaterOnGetLayoutInflater;
    }

    @Override // tlydtdl.fragment.app.k0
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Dialog dialog = this.l;
        if (dialog != null) {
            Bundle bundleOnSaveInstanceState = dialog.onSaveInstanceState();
            bundleOnSaveInstanceState.putBoolean("amuvvoafs:dialogShowing", false);
            bundle.putBundle("amuvvoafs:savedDialogState", bundleOnSaveInstanceState);
        }
        int i = this.e;
        if (i != 0) {
            bundle.putInt("amuvvoafs:style", i);
        }
        int i2 = this.f594f;
        if (i2 != 0) {
            bundle.putInt("amuvvoafs:theme", i2);
        }
        boolean z = this.g;
        if (!z) {
            bundle.putBoolean("amuvvoafs:cancelable", z);
        }
        boolean z2 = this.h;
        if (!z2) {
            bundle.putBoolean("amuvvoafs:showsDialog", z2);
        }
        int i3 = this.i;
        if (i3 != -1) {
            bundle.putInt("amuvvoafs:backStackId", i3);
        }
    }

    @Override // tlydtdl.fragment.app.k0
    public void onStart() {
        super.onStart();
        Dialog dialog = this.l;
        if (dialog != null) {
            this.m = false;
            dialog.show();
            View decorView = this.l.getWindow().getDecorView();
            i1.j(decorView, this);
            i1.k(decorView, this);
            y10.r.n0(decorView, this);
        }
    }

    @Override // tlydtdl.fragment.app.k0
    public void onStop() {
        super.onStop();
        Dialog dialog = this.l;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // tlydtdl.fragment.app.k0
    public final void onViewStateRestored(Bundle bundle) {
        Bundle bundle2;
        super.onViewStateRestored(bundle);
        if (this.l == null || bundle == null || (bundle2 = bundle.getBundle("amuvvoafs:savedDialogState")) == null) {
            return;
        }
        this.l.onRestoreInstanceState(bundle2);
    }

    public void p(Dialog dialog, int i) {
        if (i != 1 && i != 2) {
            if (i != 3) {
                return;
            }
            Window window = dialog.getWindow();
            if (window != null) {
                window.addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }

    @Override // tlydtdl.fragment.app.k0
    public final void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.performCreateView(layoutInflater, viewGroup, bundle);
        if (this.mView != null || this.l == null || bundle == null || (bundle2 = bundle.getBundle("amuvvoafs:savedDialogState")) == null) {
            return;
        }
        this.l.onRestoreInstanceState(bundle2);
    }

    public void q(k1 k1Var, String str) {
        this.n = false;
        this.o = true;
        k1Var.getClass();
        a aVar = new a(k1Var);
        aVar.p = true;
        aVar.e(0, this, str, 1);
        aVar.d();
    }
}
