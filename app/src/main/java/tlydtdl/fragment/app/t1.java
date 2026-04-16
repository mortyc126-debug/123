package tlydtdl.fragment.app;

import amuvvoafs.content.res.Resources;
import amuvvoafs.os.BadParcelableException;
import amuvvoafs.os.Bundle;
import amuvvoafs.os.Parcelable;
import amuvvoafs.util.Log;
import amuvvoafs.util.SparseArray;
import amuvvoafs.view.LayoutInflater;
import amuvvoafs.view.View;
import amuvvoafs.view.ViewGroup;
import amuvvoafs.view.ViewParent;
import com.gnacba.amuvvoafs.gms.internal.ads.vi1;
import java.util.ArrayList;
import java.util.WeakHashMap;
import r6.j0;
import u7.b;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class t1 {
    public final vi1 a;
    public final u1 b;
    public final k0 c;
    public boolean d = false;
    public int e = -1;

    public t1(vi1 vi1Var, u1 u1Var, k0 k0Var) {
        this.a = vi1Var;
        this.b = u1Var;
        this.c = k0Var;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: tlydtdl.fragment.app.SuperNotCalledException */
    public final void a() throws SuperNotCalledException {
        boolean zN = k1.N(3);
        k0 k0Var = this.c;
        if (zN) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + k0Var);
        }
        Bundle bundle = k0Var.mSavedFragmentState;
        k0Var.performActivityCreated(bundle != null ? bundle.getBundle("savedInstanceState") : null);
        this.a.h(k0Var, false);
    }

    public final void b() {
        k0 k0Var;
        View view;
        View view2;
        k0 k0Var2 = this.c;
        View view3 = k0Var2.mContainer;
        while (true) {
            k0Var = null;
            if (view3 == null) {
                break;
            }
            Object tag = view3.getTag(2131427913);
            k0 k0Var3 = tag instanceof k0 ? (k0) tag : null;
            if (k0Var3 != null) {
                k0Var = k0Var3;
                break;
            } else {
                ViewParent parent = view3.getParent();
                view3 = parent instanceof View ? (View) parent : null;
            }
        }
        k0 parentFragment = k0Var2.getParentFragment();
        if (k0Var != null && !k0Var.equals(parentFragment)) {
            b.l(k0Var2, k0Var, k0Var2.mContainerId);
        }
        ArrayList arrayList = this.b.a;
        ViewGroup viewGroup = k0Var2.mContainer;
        int iIndexOfChild = -1;
        if (viewGroup != null) {
            int iIndexOf = arrayList.indexOf(k0Var2);
            int i = iIndexOf - 1;
            while (true) {
                if (i < 0) {
                    while (true) {
                        iIndexOf++;
                        if (iIndexOf >= arrayList.size()) {
                            break;
                        }
                        k0 k0Var4 = (k0) arrayList.get(iIndexOf);
                        if (k0Var4.mContainer == viewGroup && (view = k0Var4.mView) != null) {
                            iIndexOfChild = viewGroup.indexOfChild(view);
                            break;
                        }
                    }
                } else {
                    k0 k0Var5 = (k0) arrayList.get(i);
                    if (k0Var5.mContainer == viewGroup && (view2 = k0Var5.mView) != null) {
                        iIndexOfChild = viewGroup.indexOfChild(view2) + 1;
                        break;
                    }
                    i--;
                }
            }
        }
        k0Var2.mContainer.addView(k0Var2.mView, iIndexOfChild);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: tlydtdl.fragment.app.SuperNotCalledException */
    public final void c() throws SuperNotCalledException {
        boolean zN = k1.N(3);
        k0 k0Var = this.c;
        if (zN) {
            Log.d("FragmentManager", "moveto ATTACHED: " + k0Var);
        }
        k0 k0Var2 = k0Var.mTarget;
        t1 t1Var = null;
        u1 u1Var = this.b;
        if (k0Var2 != null) {
            t1 t1Var2 = (t1) u1Var.b.get(k0Var2.mWho);
            if (t1Var2 == null) {
                throw new IllegalStateException("Fragment " + k0Var + " declared target fragment " + k0Var.mTarget + " that does not belong to this FragmentManager!");
            }
            k0Var.mTargetWho = k0Var.mTarget.mWho;
            k0Var.mTarget = null;
            t1Var = t1Var2;
        } else {
            String str = k0Var.mTargetWho;
            if (str != null && (t1Var = (t1) u1Var.b.get(str)) == null) {
                StringBuilder sb = new StringBuilder("Fragment ");
                sb.append(k0Var);
                sb.append(" declared target fragment ");
                throw new IllegalStateException(i.p(sb, k0Var.mTargetWho, " that does not belong to this FragmentManager!"));
            }
        }
        if (t1Var != null) {
            t1Var.k();
        }
        k1 k1Var = k0Var.mFragmentManager;
        k0Var.mHost = k1Var.x;
        k0Var.mParentFragment = k1Var.z;
        vi1 vi1Var = this.a;
        vi1Var.n(k0Var, false);
        k0Var.performAttach();
        vi1Var.i(k0Var, false);
    }

    public final int d() {
        k0 k0Var = this.c;
        if (k0Var.mFragmentManager == null) {
            return k0Var.mState;
        }
        int iMin = this.e;
        int iOrdinal = k0Var.mMaxState.ordinal();
        if (iOrdinal == 1) {
            iMin = Math.min(iMin, 0);
        } else if (iOrdinal == 2) {
            iMin = Math.min(iMin, 1);
        } else if (iOrdinal == 3) {
            iMin = Math.min(iMin, 5);
        } else if (iOrdinal != 4) {
            iMin = Math.min(iMin, -1);
        }
        if (k0Var.mFromLayout) {
            if (k0Var.mInLayout) {
                iMin = Math.max(this.e, 2);
                View view = k0Var.mView;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.e < 4 ? Math.min(iMin, k0Var.mState) : Math.min(iMin, 1);
            }
        }
        if (k0Var.mInDynamicContainer && k0Var.mContainer == null) {
            iMin = Math.min(iMin, 4);
        }
        if (!k0Var.mAdded) {
            iMin = Math.min(iMin, 1);
        }
        ViewGroup viewGroup = k0Var.mContainer;
        if (viewGroup != null) {
            r rVarJ = r.j(viewGroup, k0Var.getParentFragmentManager());
            j2 j2VarG = rVarJ.g(k0Var);
            int i = j2VarG != null ? j2VarG.b : 0;
            j2 j2VarH = rVarJ.h(k0Var);
            i = j2VarH != null ? j2VarH.b : 0;
            int i2 = i == 0 ? -1 : k2.$EnumSwitchMapping$0[z.p.k(i)];
            if (i2 != -1 && i2 != 1) {
                i = i;
            }
        }
        if (i == 2) {
            iMin = Math.min(iMin, 6);
        } else if (i == 3) {
            iMin = Math.max(iMin, 3);
        } else if (k0Var.mRemoving) {
            iMin = k0Var.isInBackStack() ? Math.min(iMin, 1) : Math.min(iMin, -1);
        }
        if (k0Var.mDeferStart && k0Var.mState < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (k0Var.mTransitioning) {
            iMin = Math.max(iMin, 3);
        }
        if (k1.N(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + iMin + " for " + k0Var);
        }
        return iMin;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: tlydtdl.fragment.app.SuperNotCalledException */
    public final void e() throws SuperNotCalledException {
        boolean zN = k1.N(3);
        k0 k0Var = this.c;
        if (zN) {
            Log.d("FragmentManager", "moveto CREATED: " + k0Var);
        }
        Bundle bundle = k0Var.mSavedFragmentState;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        if (k0Var.mIsCreated) {
            k0Var.mState = 1;
            k0Var.restoreChildFragmentState();
        } else {
            vi1 vi1Var = this.a;
            vi1Var.o(k0Var, false);
            k0Var.performCreate(bundle2);
            vi1Var.j(k0Var, false);
        }
    }

    public final void f() {
        String resourceName;
        k0 k0Var = this.c;
        if (k0Var.mFromLayout) {
            return;
        }
        if (k1.N(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + k0Var);
        }
        Bundle bundle = k0Var.mSavedFragmentState;
        ViewGroup viewGroup = null;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        LayoutInflater layoutInflaterPerformGetLayoutInflater = k0Var.performGetLayoutInflater(bundle2);
        ViewGroup viewGroup2 = k0Var.mContainer;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i = k0Var.mContainerId;
            if (i != 0) {
                if (i == -1) {
                    throw new IllegalArgumentException(i.m("Cannot create fragment ", k0Var, " for a container view with no id"));
                }
                viewGroup = (ViewGroup) k0Var.mFragmentManager.y.b(i);
                if (viewGroup == null) {
                    if (!k0Var.mRestored && !k0Var.mInDynamicContainer) {
                        try {
                            resourceName = k0Var.getResources().getResourceName(k0Var.mContainerId);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(k0Var.mContainerId) + " (" + resourceName + ") for fragment " + k0Var);
                    }
                } else if (!(viewGroup instanceof FragmentContainerView)) {
                    b.k(k0Var, viewGroup);
                }
            }
        }
        k0Var.mContainer = viewGroup;
        k0Var.performCreateView(layoutInflaterPerformGetLayoutInflater, viewGroup, bundle2);
        if (k0Var.mView != null) {
            if (k1.N(3)) {
                Log.d("FragmentManager", "moveto VIEW_CREATED: " + k0Var);
            }
            k0Var.mView.setSaveFromParentEnabled(false);
            k0Var.mView.setTag(2131427913, k0Var);
            if (viewGroup != null) {
                b();
            }
            if (k0Var.mHidden) {
                k0Var.mView.setVisibility(8);
            }
            if (k0Var.mView.isAttachedToWindow()) {
                View view = k0Var.mView;
                WeakHashMap weakHashMap = r6.u0.a;
                j0.c(view);
            } else {
                View view2 = k0Var.mView;
                view2.addOnAttachStateChangeListener(new s1(view2));
            }
            k0Var.performViewCreated();
            this.a.t(k0Var, k0Var.mView, false);
            int visibility = k0Var.mView.getVisibility();
            k0Var.setPostOnViewCreatedAlpha(k0Var.mView.getAlpha());
            if (k0Var.mContainer != null && visibility == 0) {
                View viewFindFocus = k0Var.mView.findFocus();
                if (viewFindFocus != null) {
                    k0Var.setFocusedView(viewFindFocus);
                    if (k1.N(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + k0Var);
                    }
                }
                k0Var.mView.setAlpha(0.0f);
            }
        }
        k0Var.mState = 2;
    }

    public final void g() throws Exception {
        k0 k0VarB;
        boolean zN = k1.N(3);
        k0 k0Var = this.c;
        if (zN) {
            Log.d("FragmentManager", "movefrom CREATED: " + k0Var);
        }
        boolean zIsChangingConfigurations = true;
        boolean z = k0Var.mRemoving && !k0Var.isInBackStack();
        u1 u1Var = this.b;
        if (z && !k0Var.mBeingSaved) {
            u1Var.i(null, k0Var.mWho);
        }
        if (!z) {
            o1 o1Var = u1Var.d;
            if (!((o1Var.b.containsKey(k0Var.mWho) && o1Var.e) ? o1Var.f589f : true)) {
                String str = k0Var.mTargetWho;
                if (str != null && (k0VarB = u1Var.b(str)) != null && k0VarB.mRetainInstance) {
                    k0Var.mTarget = k0VarB;
                }
                k0Var.mState = 0;
                return;
            }
        }
        s0 s0Var = k0Var.mHost;
        if (s0Var instanceof tlydtdl.lifecycle.w1) {
            zIsChangingConfigurations = u1Var.d.f589f;
        } else {
            FragmentActivity fragmentActivity = s0Var.b;
            if (fragmentActivity != null) {
                zIsChangingConfigurations = true ^ fragmentActivity.isChangingConfigurations();
            }
        }
        if ((z && !k0Var.mBeingSaved) || zIsChangingConfigurations) {
            u1Var.d.f(k0Var, false);
        }
        k0Var.performDestroy();
        this.a.k(k0Var, false);
        for (t1 t1Var : u1Var.d()) {
            if (t1Var != null) {
                k0 k0Var2 = t1Var.c;
                if (k0Var.mWho.equals(k0Var2.mTargetWho)) {
                    k0Var2.mTarget = k0Var;
                    k0Var2.mTargetWho = null;
                }
            }
        }
        String str2 = k0Var.mTargetWho;
        if (str2 != null) {
            k0Var.mTarget = u1Var.b(str2);
        }
        u1Var.h(this);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: tlydtdl.fragment.app.SuperNotCalledException */
    public final void h() throws SuperNotCalledException {
        View view;
        boolean zN = k1.N(3);
        k0 k0Var = this.c;
        if (zN) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + k0Var);
        }
        ViewGroup viewGroup = k0Var.mContainer;
        if (viewGroup != null && (view = k0Var.mView) != null) {
            viewGroup.removeView(view);
        }
        k0Var.performDestroyView();
        this.a.u(k0Var, false);
        k0Var.mContainer = null;
        k0Var.mView = null;
        k0Var.mViewLifecycleOwner = null;
        k0Var.mViewLifecycleOwnerLiveData.j(null);
        k0Var.mInLayout = false;
    }

    public final void i() throws Exception {
        boolean zN = k1.N(3);
        k0 k0Var = this.c;
        if (zN) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + k0Var);
        }
        k0Var.performDetach();
        this.a.l(k0Var, false);
        k0Var.mState = -1;
        k0Var.mHost = null;
        k0Var.mParentFragment = null;
        k0Var.mFragmentManager = null;
        if (!k0Var.mRemoving || k0Var.isInBackStack()) {
            o1 o1Var = this.b.d;
            if (!((o1Var.b.containsKey(k0Var.mWho) && o1Var.e) ? o1Var.f589f : true)) {
                return;
            }
        }
        if (k1.N(3)) {
            Log.d("FragmentManager", "initState called for fragment: " + k0Var);
        }
        k0Var.initState();
    }

    public final void j() {
        k0 k0Var = this.c;
        if (k0Var.mFromLayout && k0Var.mInLayout && !k0Var.mPerformedCreateView) {
            if (k1.N(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + k0Var);
            }
            Bundle bundle = k0Var.mSavedFragmentState;
            Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
            k0Var.performCreateView(k0Var.performGetLayoutInflater(bundle2), null, bundle2);
            View view = k0Var.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                k0Var.mView.setTag(2131427913, k0Var);
                if (k0Var.mHidden) {
                    k0Var.mView.setVisibility(8);
                }
                k0Var.performViewCreated();
                this.a.t(k0Var, k0Var.mView, false);
                k0Var.mState = 2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:155:0x01ae, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void k() {
        /*
            Method dump skipped, instruction units count: 666
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.fragment.app.t1.k():void");
    }

    public final void l(ClassLoader classLoader) {
        k0 k0Var = this.c;
        Bundle bundle = k0Var.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        if (k0Var.mSavedFragmentState.getBundle("savedInstanceState") == null) {
            k0Var.mSavedFragmentState.putBundle("savedInstanceState", new Bundle());
        }
        try {
            k0Var.mSavedViewState = k0Var.mSavedFragmentState.getSparseParcelableArray("viewState");
            k0Var.mSavedViewRegistryState = k0Var.mSavedFragmentState.getBundle("viewRegistryState");
            r1 parcelable = k0Var.mSavedFragmentState.getParcelable("state");
            if (parcelable != null) {
                k0Var.mTargetWho = parcelable.m;
                k0Var.mTargetRequestCode = parcelable.n;
                Boolean bool = k0Var.mSavedUserVisibleHint;
                if (bool != null) {
                    k0Var.mUserVisibleHint = bool.booleanValue();
                    k0Var.mSavedUserVisibleHint = null;
                } else {
                    k0Var.mUserVisibleHint = parcelable.o;
                }
            }
            if (k0Var.mUserVisibleHint) {
                return;
            }
            k0Var.mDeferStart = true;
        } catch (BadParcelableException e) {
            throw new IllegalStateException("Failed to restore view hierarchy state for fragment " + k0Var, e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: tlydtdl.fragment.app.SuperNotCalledException */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m() throws tlydtdl.fragment.app.SuperNotCalledException {
        /*
            r6 = this;
            r0 = 3
            boolean r0 = tlydtdl.fragment.app.k1.N(r0)
            java.lang.String r1 = "FragmentManager"
            tlydtdl.fragment.app.k0 r2 = r6.c
            if (r0 == 0) goto L1c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "moveto RESUMED: "
            r0.<init>(r3)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            amuvvoafs.util.Log.d(r1, r0)
        L1c:
            amuvvoafs.view.View r0 = r2.getFocusedView()
            if (r0 == 0) goto L78
            amuvvoafs.view.View r3 = r2.mView
            if (r0 != r3) goto L27
            goto L31
        L27:
            amuvvoafs.view.ViewParent r3 = r0.getParent()
        L2b:
            if (r3 == 0) goto L78
            amuvvoafs.view.View r4 = r2.mView
            if (r3 != r4) goto L73
        L31:
            boolean r3 = r0.requestFocus()
            r4 = 2
            boolean r4 = tlydtdl.fragment.app.k1.N(r4)
            if (r4 == 0) goto L78
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "requestFocus: Restoring focused view "
            r4.<init>(r5)
            r4.append(r0)
            java.lang.String r0 = " "
            r4.append(r0)
            if (r3 == 0) goto L50
            java.lang.String r0 = "succeeded"
            goto L52
        L50:
            java.lang.String r0 = "failed"
        L52:
            r4.append(r0)
            java.lang.String r0 = " on Fragment "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = " resulting in focused view "
            r4.append(r0)
            amuvvoafs.view.View r0 = r2.mView
            amuvvoafs.view.View r0 = r0.findFocus()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            amuvvoafs.util.Log.v(r1, r0)
            goto L78
        L73:
            amuvvoafs.view.ViewParent r3 = r3.getParent()
            goto L2b
        L78:
            r0 = 0
            r2.setFocusedView(r0)
            r2.performResume()
            com.gnacba.amuvvoafs.gms.internal.ads.vi1 r1 = r6.a
            r3 = 0
            r1.p(r2, r3)
            tlydtdl.fragment.app.u1 r1 = r6.b
            java.lang.String r3 = r2.mWho
            r1.i(r0, r3)
            r2.mSavedFragmentState = r0
            r2.mSavedViewState = r0
            r2.mSavedViewRegistryState = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.fragment.app.t1.m():void");
    }

    public final Bundle n() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        k0 k0Var = this.c;
        if (k0Var.mState == -1 && (bundle = k0Var.mSavedFragmentState) != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable("state", new r1(k0Var));
        if (k0Var.mState > 0) {
            Bundle bundle3 = new Bundle();
            k0Var.performSaveInstanceState(bundle3);
            if (!bundle3.isEmpty()) {
                bundle2.putBundle("savedInstanceState", bundle3);
            }
            this.a.q(k0Var, bundle3, false);
            Bundle bundle4 = new Bundle();
            k0Var.mSavedStateRegistryController.b(bundle4);
            if (!bundle4.isEmpty()) {
                bundle2.putBundle("registryState", bundle4);
            }
            Bundle bundleC0 = k0Var.mChildFragmentManager.c0();
            if (!bundleC0.isEmpty()) {
                bundle2.putBundle("childFragmentManager", bundleC0);
            }
            if (k0Var.mView != null) {
                o();
            }
            SparseArray<Parcelable> sparseArray = k0Var.mSavedViewState;
            if (sparseArray != null) {
                bundle2.putSparseParcelableArray("viewState", sparseArray);
            }
            Bundle bundle5 = k0Var.mSavedViewRegistryState;
            if (bundle5 != null) {
                bundle2.putBundle("viewRegistryState", bundle5);
            }
        }
        Bundle bundle6 = k0Var.mArguments;
        if (bundle6 != null) {
            bundle2.putBundle("arguments", bundle6);
        }
        return bundle2;
    }

    public final void o() {
        k0 k0Var = this.c;
        if (k0Var.mView == null) {
            return;
        }
        if (k1.N(2)) {
            Log.v("FragmentManager", "Saving view state for fragment " + k0Var + " with view " + k0Var.mView);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        k0Var.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            k0Var.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        k0Var.mViewLifecycleOwner.f582f.b(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        k0Var.mSavedViewRegistryState = bundle;
    }

    public t1(vi1 vi1Var, u1 u1Var, ClassLoader classLoader, a1 a1Var, Bundle bundle) {
        this.a = vi1Var;
        this.b = u1Var;
        k0 k0VarA = bundle.getParcelable("state").a(a1Var);
        this.c = k0VarA;
        k0VarA.mSavedFragmentState = bundle;
        Bundle bundle2 = bundle.getBundle("arguments");
        if (bundle2 != null) {
            bundle2.setClassLoader(classLoader);
        }
        k0VarA.setArguments(bundle2);
        if (k1.N(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + k0VarA);
        }
    }

    public t1(vi1 vi1Var, u1 u1Var, k0 k0Var, Bundle bundle) {
        this.a = vi1Var;
        this.b = u1Var;
        this.c = k0Var;
        k0Var.mSavedViewState = null;
        k0Var.mSavedViewRegistryState = null;
        k0Var.mBackStackNesting = 0;
        k0Var.mInLayout = false;
        k0Var.mAdded = false;
        k0 k0Var2 = k0Var.mTarget;
        k0Var.mTargetWho = k0Var2 != null ? k0Var2.mWho : null;
        k0Var.mTarget = null;
        k0Var.mSavedFragmentState = bundle;
        k0Var.mArguments = bundle.getBundle("arguments");
    }
}
