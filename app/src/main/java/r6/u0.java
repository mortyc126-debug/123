package r6;

import amuvvoafs.content.Context;
import amuvvoafs.content.res.TypedArray;
import amuvvoafs.os.Build;
import amuvvoafs.util.AttributeSet;
import amuvvoafs.util.Log;
import amuvvoafs.view.View;
import amuvvoafs.view.WindowInsets;
import amuvvoafs.view.accessibility.AccessibilityEvent;
import amuvvoafs.view.accessibility.AccessibilityManager;
import com.google.android.material.R;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.WeakHashMap;
import w6.i;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class u0 {
    public static WeakHashMap a;
    public static Field b;
    public static boolean c;
    public static final int[] d = {R.layout.r_vt30xk, R.layout.r_6jfvq6, R.layout.r_98s211, R.layout.r_ecnlj2, R.layout.r_e8xgfq, R.layout.r_kcb29v, R.layout.r_oioi82, R.layout.r_xtei7u, R.layout.r_dsiyz1, R.layout.r_o7vd5r, R.layout.r_vlr4jt, R.layout.r_7ssfp6, R.layout.r_u8kx9i, R.layout.r_kwxnbj, R.layout.r_kuh83k, R.layout.r_gwppeu, R.layout.r_d26upf, R.layout.r_ce5sh7, R.layout.r_jy0iep, R.layout.r_d857mj, R.layout.r_ki8lq4, R.layout.r_fm8soh, R.layout.r_593pgv, R.layout.r_bagj9k, R.layout.r_hfg19p, R.layout.r_6rmomn, R.layout.r_guopcg, R.layout.r_ngof3y, R.layout.r_zfdl0f, R.layout.r_0uqpmj, R.layout.r_1qhgfw, R.layout.r_4wfplb};
    public static final f0 e = new f0();

    /* JADX INFO: renamed from: f */
    public static final i0 f398f = new i0();

    public static z0 a(View view) {
        if (a == null) {
            a = new WeakHashMap();
        }
        z0 z0Var = (z0) a.get(view);
        if (z0Var != null) {
            return z0Var;
        }
        z0 z0Var2 = new z0(view);
        a.put(view, z0Var2);
        return z0Var2;
    }

    public static void b(z1 z1Var, View view) {
        int i = Build.VERSION.SDK_INT;
        WindowInsets windowInsetsF = z1Var.f();
        if (windowInsetsF != null) {
            WindowInsets windowInsetsA = i >= 30 ? r0.a(view, windowInsetsF) : j0.a(view, windowInsetsF);
            if (windowInsetsA.equals(windowInsetsF)) {
                return;
            }
            z1.g(view, windowInsetsA);
        }
    }

    public static View.AccessibilityDelegate c(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return q0.a(view);
        }
        if (c) {
            return null;
        }
        if (b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                c = true;
                return null;
            }
        }
        try {
            Object obj = b.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            c = true;
            return null;
        }
    }

    public static CharSequence d(View view) {
        Object tag;
        if (Build.VERSION.SDK_INT >= 28) {
            tag = p0.a(view);
        } else {
            tag = view.getTag(2131428600);
            if (!CharSequence.class.isInstance(tag)) {
                tag = null;
            }
        }
        return (CharSequence) tag;
    }

    public static ArrayList e(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(2131428597);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(2131428597, arrayList2);
        return arrayList2;
    }

    public static String[] f(q.t tVar) {
        return Build.VERSION.SDK_INT >= 31 ? s0.a(tVar) : (String[]) tVar.getTag(2131428604);
    }

    public static void g(View view, int i) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z = d(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i);
                if (z) {
                    accessibilityEventObtain.getText().add(d(view));
                    if (view.getImportantForAccessibility() == 0) {
                        view.setImportantForAccessibility(1);
                    }
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i != 32) {
                if (view.getParent() != null) {
                    try {
                        view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i);
                        return;
                    } catch (AbstractMethodError e2) {
                        Log.e("ViewCompat", view.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e2);
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
            view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.setEventType(32);
            accessibilityEventObtain2.setContentChangeTypes(i);
            accessibilityEventObtain2.setSource(view);
            view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.getText().add(d(view));
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
        }
    }

    public static g h(View view, g gVar) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + gVar + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return s0.b(view, gVar);
        }
        i iVar = (i) view.getTag(2131428603);
        v vVar = e;
        if (iVar == null) {
            if (view instanceof v) {
                vVar = (v) view;
            }
            return vVar.a(gVar);
        }
        g gVarA = i.a(view, gVar);
        if (gVarA == null) {
            return null;
        }
        if (view instanceof v) {
            vVar = (v) view;
        }
        return vVar.a(gVarA);
    }

    public static void i(View view, int i) {
        ArrayList arrayListE = e(view);
        for (int i2 = 0; i2 < arrayListE.size(); i2++) {
            if (((s6.b) arrayListE.get(i2)).a() == i) {
                arrayListE.remove(i2);
                return;
            }
        }
    }

    public static void j(View view, s6.b bVar, s6.l lVar) {
        s6.b bVar2 = new s6.b(null, bVar.b, null, lVar, bVar.c);
        View.AccessibilityDelegate accessibilityDelegateC = c(view);
        b bVar3 = accessibilityDelegateC == null ? null : accessibilityDelegateC instanceof a ? ((a) accessibilityDelegateC).a : new b(accessibilityDelegateC);
        if (bVar3 == null) {
            bVar3 = new b();
        }
        l(view, bVar3);
        i(view, bVar2.a());
        e(view).add(bVar2);
        g(view, 0);
    }

    public static void k(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            q0.b(view, context, iArr, attributeSet, typedArray, i, 0);
        }
    }

    public static void l(View view, b bVar) {
        if (bVar == null && (c(view) instanceof a)) {
            bVar = new b();
        }
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        view.setAccessibilityDelegate(bVar == null ? null : bVar.b);
    }

    public static void m(View view, CharSequence charSequence) {
        new h0(2131428600, CharSequence.class, 8, 28).f(view, charSequence);
        i0 i0Var = f398f;
        if (charSequence == null) {
            i0Var.a.remove(view);
            view.removeOnAttachStateChangeListener(i0Var);
            view.getViewTreeObserver().removeOnGlobalLayoutListener(i0Var);
        } else {
            i0Var.a.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(i0Var);
            if (view.isAttachedToWindow()) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(i0Var);
            }
        }
    }

    public static void n(View view, tlydtdl.datastore.preferences.protobuf.k kVar) {
        if (Build.VERSION.SDK_INT >= 30) {
            g1.h(view, kVar);
        } else {
            d1.l(view, kVar);
        }
    }
}
