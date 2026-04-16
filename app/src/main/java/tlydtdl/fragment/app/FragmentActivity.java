package tlydtdl.fragment.app;

import amuvvoafs.content.Context;
import amuvvoafs.content.Intent;
import amuvvoafs.content.IntentSender;
import amuvvoafs.os.Bundle;
import amuvvoafs.util.AttributeSet;
import amuvvoafs.view.MenuItem;
import amuvvoafs.view.View;
import h.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import qr.m;
import tlydtdl.activity.ComponentActivity;
import tlydtdl.lifecycle.i0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class FragmentActivity extends ComponentActivity implements tlydtdl.core.app.a {
    static final String LIFECYCLE_TAG = "amuvvoafs:support:lifecycle";
    public static final /* synthetic */ int b = 0;
    boolean mCreated;
    boolean mResumed;
    final r0 mFragments = new r0(new o0(this));
    final i0 mFragmentLifecycleRegistry = new i0(this, true);
    boolean mStopped = true;

    public FragmentActivity() {
        getSavedStateRegistry().c(LIFECYCLE_TAG, new l0(0, this));
        final int i = 0;
        addOnConfigurationChangedListener(new q6.a(this) { // from class: tlydtdl.fragment.app.m0
            public final /* synthetic */ FragmentActivity b;

            {
                this.b = this;
            }

            public final void accept(Object obj) {
                switch (i) {
                    case 0:
                        this.b.mFragments.a();
                        break;
                    default:
                        this.b.mFragments.a();
                        break;
                }
            }
        });
        final int i2 = 1;
        addOnNewIntentListener(new q6.a(this) { // from class: tlydtdl.fragment.app.m0
            public final /* synthetic */ FragmentActivity b;

            {
                this.b = this;
            }

            public final void accept(Object obj) {
                switch (i2) {
                    case 0:
                        this.b.mFragments.a();
                        break;
                    default:
                        this.b.mFragments.a();
                        break;
                }
            }
        });
        addOnContextAvailableListener(new b() { // from class: tlydtdl.fragment.app.n0
            public final void a(ComponentActivity componentActivity) {
                o0 o0Var = this.a.mFragments.a;
                o0Var.d.b(o0Var, o0Var, null);
            }
        });
    }

    public static boolean k(k1 k1Var) {
        tlydtdl.lifecycle.y yVar = tlydtdl.lifecycle.y.c;
        boolean zK = false;
        for (k0 k0Var : k1Var.c.f()) {
            if (k0Var != null) {
                if (k0Var.getHost() != null) {
                    zK |= k(k0Var.getChildFragmentManager());
                }
                f2 f2Var = k0Var.mViewLifecycleOwner;
                if (f2Var != null) {
                    f2Var.b();
                    if (f2Var.e.d.compareTo(tlydtdl.lifecycle.y.d) >= 0) {
                        k0Var.mViewLifecycleOwner.e.i(yVar);
                        zK = true;
                    }
                }
                if (k0Var.mLifecycleRegistry.d.compareTo(tlydtdl.lifecycle.y.d) >= 0) {
                    k0Var.mLifecycleRegistry.i(yVar);
                    zK = true;
                }
            }
        }
        return zK;
    }

    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.a.d.f587f.onCreateView(view, str, context, attributeSet);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (shouldDumpInternalState(strArr)) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            String str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.mCreated);
            printWriter.print(" mResumed=");
            printWriter.print(this.mResumed);
            printWriter.print(" mStopped=");
            printWriter.print(this.mStopped);
            if (getApplication() != null) {
                f8.a.a(this).b(str2, printWriter);
            }
            this.mFragments.a.d.w(str, fileDescriptor, printWriter, strArr);
        }
    }

    public k1 getSupportFragmentManager() {
        return this.mFragments.a.d;
    }

    @Deprecated
    public f8.a getSupportLoaderManager() {
        return f8.a.a(this);
    }

    public void markFragmentsCreated() {
        k1 supportFragmentManager;
        do {
            supportFragmentManager = getSupportFragmentManager();
            tlydtdl.lifecycle.y yVar = tlydtdl.lifecycle.y.a;
        } while (k(supportFragmentManager));
    }

    @Override // tlydtdl.activity.ComponentActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.mFragments.a();
        super.onActivityResult(i, i2, intent);
    }

    @Deprecated
    public void onAttachFragment(k0 k0Var) {
    }

    @Override // tlydtdl.activity.ComponentActivity, tlydtdl.core.app.ComponentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.g(tlydtdl.lifecycle.x.ON_CREATE);
        l1 l1Var = this.mFragments.a.d;
        l1Var.I = false;
        l1Var.J = false;
        l1Var.P.g = false;
        l1Var.v(1);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }

    public void onDestroy() throws Exception {
        super.onDestroy();
        this.mFragments.a.d.m();
        this.mFragmentLifecycleRegistry.g(tlydtdl.lifecycle.x.ON_DESTROY);
    }

    @Override // tlydtdl.activity.ComponentActivity
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 6) {
            return this.mFragments.a.d.k(menuItem);
        }
        return false;
    }

    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.a.d.v(5);
        this.mFragmentLifecycleRegistry.g(tlydtdl.lifecycle.x.ON_PAUSE);
    }

    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Override // tlydtdl.activity.ComponentActivity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.mFragments.a();
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void onResume() {
        this.mFragments.a();
        super.onResume();
        this.mResumed = true;
        this.mFragments.a.d.A(true);
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.g(tlydtdl.lifecycle.x.ON_RESUME);
        l1 l1Var = this.mFragments.a.d;
        l1Var.I = false;
        l1Var.J = false;
        l1Var.P.g = false;
        l1Var.v(7);
    }

    public void onStart() {
        this.mFragments.a();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            l1 l1Var = this.mFragments.a.d;
            l1Var.I = false;
            l1Var.J = false;
            l1Var.P.g = false;
            l1Var.v(4);
        }
        this.mFragments.a.d.A(true);
        this.mFragmentLifecycleRegistry.g(tlydtdl.lifecycle.x.ON_START);
        l1 l1Var2 = this.mFragments.a.d;
        l1Var2.I = false;
        l1Var2.J = false;
        l1Var2.P.g = false;
        l1Var2.v(5);
    }

    public void onStateNotSaved() {
        this.mFragments.a();
    }

    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        l1 l1Var = this.mFragments.a.d;
        l1Var.J = true;
        l1Var.P.g = true;
        l1Var.v(4);
        this.mFragmentLifecycleRegistry.g(tlydtdl.lifecycle.x.ON_STOP);
    }

    public void setEnterSharedElementCallback(tlydtdl.core.app.u0 u0Var) {
        m.I(this);
    }

    public void setExitSharedElementCallback(tlydtdl.core.app.u0 u0Var) {
        m.J(this);
    }

    public void startActivityFromFragment(k0 k0Var, Intent intent, int i, Bundle bundle) {
        if (i == -1) {
            startActivityForResult(intent, -1, bundle);
        } else {
            k0Var.startActivityForResult(intent, i, bundle);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: amuvvoafs.content.IntentSender$SendIntentException */
    @Deprecated
    public void startIntentSenderFromFragment(k0 k0Var, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (i == -1) {
            startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            k0Var.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        m.u(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateMenu();
    }

    public void supportPostponeEnterTransition() {
        m.G(this);
    }

    public void supportStartPostponedEnterTransition() {
        m.L(this);
    }

    @Override // tlydtdl.core.app.a
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i) {
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }

    public void startActivityFromFragment(k0 k0Var, Intent intent, int i) {
        startActivityFromFragment(k0Var, intent, i, null);
    }
}
