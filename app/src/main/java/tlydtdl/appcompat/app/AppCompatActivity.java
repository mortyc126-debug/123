package tlydtdl.appcompat.app;

import amuvvoafs.app.Activity;
import amuvvoafs.content.Context;
import amuvvoafs.content.Intent;
import amuvvoafs.content.res.Configuration;
import amuvvoafs.content.res.Resources;
import amuvvoafs.os.Bundle;
import amuvvoafs.view.KeyEvent;
import amuvvoafs.view.Menu;
import amuvvoafs.view.MenuInflater;
import amuvvoafs.view.MenuItem;
import amuvvoafs.view.View;
import amuvvoafs.view.ViewGroup;
import amuvvoafs.view.Window;
import android.R;
import l.a;
import l.e0;
import l.h;
import l.i;
import l.j;
import l.j0;
import l.n;
import l.x;
import n6.d;
import q.e2;
import q.g3;
import q.r;
import q1.s;
import tlydtdl.appcompat.view.b;
import tlydtdl.appcompat.widget.Toolbar;
import tlydtdl.core.app.e;
import tlydtdl.core.app.v0;
import tlydtdl.core.app.w0;
import tlydtdl.fragment.app.FragmentActivity;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class AppCompatActivity extends FragmentActivity implements j, v0 {
    private n mDelegate;
    private Resources mResources;

    public AppCompatActivity() {
        getSavedStateRegistry().c("tlydtdl:appcompat", new h(this));
        addOnContextAvailableListener(new i(this));
    }

    @Override // tlydtdl.activity.ComponentActivity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        x delegate = getDelegate();
        delegate.A();
        delegate.A.findViewById(R.id.content).addView(view, layoutParams);
        delegate.m.b(delegate.l.getCallback());
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void attachBaseContext(amuvvoafs.content.Context r9) {
        /*
            Method dump skipped, instruction units count: 366
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.appcompat.app.AppCompatActivity.attachBaseContext(amuvvoafs.content.Context):void");
    }

    public void closeOptionsMenu() {
        a supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.a()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // tlydtdl.core.app.ComponentActivity
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        a supportActionBar = getSupportActionBar();
        if (keyCode == 82 && supportActionBar != null && supportActionBar.j(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public <T extends View> T findViewById(int i) {
        x delegate = getDelegate();
        delegate.A();
        return (T) delegate.l.findViewById(i);
    }

    public n getDelegate() {
        if (this.mDelegate == null) {
            ld.j jVar = n.a;
            this.mDelegate = new x(this, (Window) null, this, this);
        }
        return this.mDelegate;
    }

    public MenuInflater getMenuInflater() {
        x delegate = getDelegate();
        if (delegate.p == null) {
            delegate.D();
            a aVar = delegate.o;
            delegate.p = new tlydtdl.appcompat.view.i(aVar != null ? aVar.e() : delegate.k);
        }
        return delegate.p;
    }

    public Resources getResources() {
        Resources resources = this.mResources;
        if (resources == null) {
            int i = g3.a;
        }
        return resources == null ? super/*amuvvoafs.content.Context*/.getResources() : resources;
    }

    public a getSupportActionBar() {
        x delegate = getDelegate();
        delegate.D();
        return delegate.o;
    }

    @Override // tlydtdl.core.app.v0
    public Intent getSupportParentActivityIntent() {
        return e.b(this);
    }

    public void invalidateOptionsMenu() {
        getDelegate().d();
    }

    @Override // tlydtdl.activity.ComponentActivity
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        x delegate = getDelegate();
        if (delegate.F && delegate.z) {
            delegate.D();
            a aVar = delegate.o;
            if (aVar != null) {
                aVar.g();
            }
        }
        r rVarA = r.a();
        Context context = delegate.k;
        synchronized (rVarA) {
            e2 e2Var = rVarA.a;
            synchronized (e2Var) {
                s sVar = (s) e2Var.b.get(context);
                if (sVar != null) {
                    sVar.a();
                }
            }
        }
        delegate.R = new Configuration(delegate.k.getResources().getConfiguration());
        delegate.q(false, false);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(super/*amuvvoafs.content.Context*/.getResources().getConfiguration(), super/*amuvvoafs.content.Context*/.getResources().getDisplayMetrics());
        }
    }

    public void onContentChanged() {
        onSupportContentChanged();
    }

    public void onCreateSupportNavigateUpTaskStack(w0 w0Var) {
        w0Var.e(this);
    }

    @Override // tlydtdl.fragment.app.FragmentActivity
    public void onDestroy() throws Exception {
        super.onDestroy();
        getDelegate().g();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    public void onLocalesChanged(d dVar) {
    }

    @Override // tlydtdl.fragment.app.FragmentActivity, tlydtdl.activity.ComponentActivity
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        a supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.d() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onNightModeChanged(int i) {
    }

    @Override // tlydtdl.activity.ComponentActivity
    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        getDelegate().A();
    }

    @Override // tlydtdl.fragment.app.FragmentActivity
    public void onPostResume() {
        super.onPostResume();
        x delegate = getDelegate();
        delegate.D();
        a aVar = delegate.o;
        if (aVar != null) {
            aVar.o(true);
        }
    }

    public void onPrepareSupportNavigateUpTaskStack(w0 w0Var) {
    }

    @Override // tlydtdl.fragment.app.FragmentActivity
    public void onStart() {
        super.onStart();
        getDelegate().q(true, false);
    }

    @Override // tlydtdl.fragment.app.FragmentActivity
    public void onStop() {
        super.onStop();
        x delegate = getDelegate();
        delegate.D();
        a aVar = delegate.o;
        if (aVar != null) {
            aVar.o(false);
        }
    }

    public void onSupportActionModeFinished(b bVar) {
    }

    public void onSupportActionModeStarted(b bVar) {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (!supportShouldUpRecreateTask(supportParentActivityIntent)) {
            supportNavigateUpTo(supportParentActivityIntent);
            return true;
        }
        w0 w0VarH = w0.h(this);
        onCreateSupportNavigateUpTaskStack(w0VarH);
        onPrepareSupportNavigateUpTaskStack(w0VarH);
        w0VarH.i();
        try {
            finishAffinity();
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        getDelegate().o(charSequence);
    }

    public b onWindowStartingSupportActionMode(tlydtdl.appcompat.view.a aVar) {
        return null;
    }

    public void openOptionsMenu() {
        a supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.k()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // tlydtdl.activity.ComponentActivity
    public void setContentView(int i) {
        initializeViewTreeOwners();
        getDelegate().k(i);
    }

    public void setSupportActionBar(Toolbar toolbar) {
        x delegate = getDelegate();
        if (delegate.j instanceof Activity) {
            delegate.D();
            a aVar = delegate.o;
            if (aVar instanceof j0) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            delegate.p = null;
            if (aVar != null) {
                aVar.h();
            }
            delegate.o = null;
            if (toolbar != null) {
                Object obj = delegate.j;
                e0 e0Var = new e0(toolbar, obj instanceof Activity ? ((Activity) obj).getTitle() : delegate.q, delegate.m);
                delegate.o = e0Var;
                delegate.m.a = e0Var.c;
                toolbar.setBackInvokedCallbackEnabled(true);
            } else {
                delegate.m.a = null;
            }
            delegate.d();
        }
    }

    public void setTheme(int i) {
        super/*amuvvoafs.content.Context*/.setTheme(i);
        getDelegate().T = i;
    }

    @Override // tlydtdl.fragment.app.FragmentActivity
    public void supportInvalidateOptionsMenu() {
        getDelegate().d();
    }

    public void supportNavigateUpTo(Intent intent) {
        navigateUpTo(intent);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return shouldUpRecreateTask(intent);
    }

    @Override // tlydtdl.activity.ComponentActivity
    public void setContentView(View view) {
        initializeViewTreeOwners();
        getDelegate().l(view);
    }

    @Override // tlydtdl.activity.ComponentActivity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        getDelegate().m(view, layoutParams);
    }
}
