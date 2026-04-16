package tlydtdl.coordinatorlayout.widget;

import a0.o;
import amuvvoafs.content.Context;
import amuvvoafs.content.res.Resources;
import amuvvoafs.content.res.TypedArray;
import amuvvoafs.graphics.Canvas;
import amuvvoafs.graphics.Matrix;
import amuvvoafs.graphics.Rect;
import amuvvoafs.graphics.RectF;
import amuvvoafs.graphics.drawable.ColorDrawable;
import amuvvoafs.graphics.drawable.Drawable;
import amuvvoafs.os.Build;
import amuvvoafs.os.Parcelable;
import amuvvoafs.os.SystemClock;
import amuvvoafs.util.AttributeSet;
import amuvvoafs.util.Log;
import amuvvoafs.util.SparseArray;
import amuvvoafs.view.Gravity;
import amuvvoafs.view.MotionEvent;
import amuvvoafs.view.View;
import amuvvoafs.view.ViewGroup;
import b6.a;
import c6.b;
import c6.c;
import c6.e;
import c6.f;
import c6.g;
import c6.h;
import c6.i;
import com.gnacba.amuvvoafs.gms.internal.ads.da;
import com.gnacba.firebase.messaging.a0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;
import q1.x0;
import q6.d;
import r6.j0;
import r6.l0;
import r6.s;
import r6.t;
import r6.u0;
import r6.z1;
import sl0.z;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements s, t {
    public static final String t;
    public static final Class[] u;
    public static final ThreadLocal v;
    public static final h w;
    public static final d x;
    public final ArrayList a;
    public final a0 b;
    public final ArrayList c;
    public final ArrayList d;
    public final int[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f556f;
    public boolean g;
    public boolean h;
    public final int[] i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f557j;
    public View k;
    public f l;
    public boolean m;
    public z1 n;
    public boolean o;
    public Drawable p;
    public ViewGroup.OnHierarchyChangeListener q;
    public o r;
    public final da s;

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        t = r0 != null ? r0.getName() : null;
        w = new h(0);
        u = new Class[]{Context.class, AttributeSet.class};
        v = new ThreadLocal();
        x = new d();
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        CoordinatorLayout coordinatorLayout;
        Context context2;
        super(context, attributeSet, 2130969052);
        this.a = new ArrayList();
        this.b = new a0(3);
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new int[2];
        this.f556f = new int[2];
        this.s = new da();
        int[] iArr = a.a;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 2130969052, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            coordinatorLayout = this;
            context2 = context;
            coordinatorLayout.saveAttributeDataForStyleable(context2, iArr, attributeSet, typedArrayObtainStyledAttributes, 2130969052, 0);
        } else {
            coordinatorLayout = this;
            context2 = context;
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            Resources resources = context2.getResources();
            int[] intArray = resources.getIntArray(resourceId);
            coordinatorLayout.i = intArray;
            float f2 = resources.getDisplayMetrics().density;
            int length = intArray.length;
            for (int i = 0; i < length; i++) {
                coordinatorLayout.i[i] = (int) (r1[i] * f2);
            }
        }
        coordinatorLayout.p = typedArrayObtainStyledAttributes.getDrawable(1);
        typedArrayObtainStyledAttributes.recycle();
        x();
        super.setOnHierarchyChangeListener(new c6.d(this));
        WeakHashMap weakHashMap = u0.a;
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    public static Rect a() {
        Rect rect = (Rect) x.a();
        return rect == null ? new Rect() : rect;
    }

    public static void l(int i, Rect rect, Rect rect2, e eVar, int i2, int i3) {
        int i4 = eVar.c;
        if (i4 == 0) {
            i4 = 17;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i4, i);
        int i6 = eVar.d;
        if ((i6 & 7) == 0) {
            i6 |= 8388611;
        }
        if ((i6 & 112) == 0) {
            i6 |= 48;
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i6, i);
        int i7 = absoluteGravity & 7;
        int i8 = absoluteGravity & 112;
        int i9 = absoluteGravity2 & 7;
        int i10 = absoluteGravity2 & 112;
        int iWidth = i9 != 1 ? i9 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int iHeight = i10 != 16 ? i10 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i7 == 1) {
            iWidth -= i2 / 2;
        } else if (i7 != 5) {
            iWidth -= i2;
        }
        if (i8 == 16) {
            iHeight -= i3 / 2;
        } else if (i8 != 80) {
            iHeight -= i3;
        }
        rect2.set(iWidth, iHeight, i2 + iWidth, i3 + iHeight);
    }

    public static e n(View view) {
        e layoutParams = view.getLayoutParams();
        if (!layoutParams.b) {
            if (view instanceof c6.a) {
                b behavior = ((c6.a) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                layoutParams.b(behavior);
                layoutParams.b = true;
                return layoutParams;
            }
            c cVar = null;
            for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                cVar = (c) superclass.getAnnotation(c.class);
                if (cVar != null) {
                    break;
                }
            }
            if (cVar != null) {
                try {
                    layoutParams.b((b) cVar.value().getDeclaredConstructor(null).newInstance(null));
                } catch (Exception e) {
                    Log.e("CoordinatorLayout", "Default behavior class " + cVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e);
                }
            }
            layoutParams.b = true;
        }
        return layoutParams;
    }

    public static void v(View view, int i) {
        e layoutParams = view.getLayoutParams();
        int i2 = layoutParams.i;
        if (i2 != i) {
            WeakHashMap weakHashMap = u0.a;
            view.offsetLeftAndRight(i - i2);
            layoutParams.i = i;
        }
    }

    public static void w(View view, int i) {
        e layoutParams = view.getLayoutParams();
        int i2 = layoutParams.j;
        if (i2 != i) {
            WeakHashMap weakHashMap = u0.a;
            view.offsetTopAndBottom(i - i2);
            layoutParams.j = i;
        }
    }

    @Override // r6.s
    public final void b(View view, View view2, int i, int i2) {
        da daVar = this.s;
        if (i2 == 1) {
            daVar.b = i;
        } else {
            daVar.a = i;
        }
        this.k = view2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).getLayoutParams().getClass();
        }
    }

    @Override // r6.s
    public final void c(View view, int i) {
        da daVar = this.s;
        if (i == 1) {
            daVar.b = 0;
        } else {
            daVar.a = 0;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            e layoutParams = childAt.getLayoutParams();
            if (layoutParams.a(i)) {
                b bVar = layoutParams.a;
                if (bVar != null) {
                    bVar.u(this, childAt, view, i);
                }
                if (i == 0) {
                    layoutParams.m = false;
                } else if (i == 1) {
                    layoutParams.n = false;
                }
                layoutParams.o = false;
            }
        }
        this.k = null;
    }

    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof e) && super.checkLayoutParams(layoutParams);
    }

    @Override // r6.s
    public final void d(View view, int i, int i2, int[] iArr, int i3) {
        b bVar;
        int childCount = getChildCount();
        boolean z = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                e layoutParams = childAt.getLayoutParams();
                if (layoutParams.a(i3) && (bVar = layoutParams.a) != null) {
                    int[] iArr2 = this.e;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    bVar.o(this, childAt, view, i, i2, iArr2, i3);
                    iMax = i > 0 ? Math.max(iMax, iArr2[0]) : Math.min(iMax, iArr2[0]);
                    iMax2 = i2 > 0 ? Math.max(iMax2, iArr2[1]) : Math.min(iMax2, iArr2[1]);
                    z = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z) {
            p(1);
        }
    }

    public final boolean drawChild(Canvas canvas, View view, long j2) {
        b bVar = view.getLayoutParams().a;
        if (bVar != null) {
            bVar.getClass();
        }
        return super.drawChild(canvas, view, j2);
    }

    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.p;
        if ((drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState)) {
            invalidate();
        }
    }

    public final void e(e eVar, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin));
        rect.set(iMax, iMax2, i + iMax, i2 + iMax2);
    }

    @Override // r6.t
    public final void f(View view, int i, int i2, int i3, int i4, int i6, int[] iArr) {
        b bVar;
        int childCount = getChildCount();
        int iMax = 0;
        int iMax2 = 0;
        boolean z = false;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                e layoutParams = childAt.getLayoutParams();
                if (layoutParams.a(i6) && (bVar = layoutParams.a) != null) {
                    int[] iArr2 = this.e;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    bVar.p(this, childAt, i2, i3, i4, iArr2);
                    iMax = i3 > 0 ? Math.max(iMax, iArr2[0]) : Math.min(iMax, iArr2[0]);
                    iMax2 = i4 > 0 ? Math.max(iMax2, iArr2[1]) : Math.min(iMax2, iArr2[1]);
                    z = true;
                }
            }
        }
        iArr[0] = iArr[0] + iMax;
        iArr[1] = iArr[1] + iMax2;
        if (z) {
            p(1);
        }
    }

    @Override // r6.s
    public final void g(View view, int i, int i2, int i3, int i4, int i6) {
        f(view, i, i2, i3, i4, 0, this.f556f);
    }

    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new e();
    }

    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public final List<View> getDependencySortedChildren() {
        t();
        return Collections.unmodifiableList(this.a);
    }

    public final z1 getLastWindowInsets() {
        return this.n;
    }

    public int getNestedScrollAxes() {
        da daVar = this.s;
        return daVar.b | daVar.a;
    }

    public Drawable getStatusBarBackground() {
        return this.p;
    }

    public int getSuggestedMinimumHeight() {
        return Math.max(super/*amuvvoafs.view.View*/.getSuggestedMinimumHeight(), getPaddingBottom() + getPaddingTop());
    }

    public int getSuggestedMinimumWidth() {
        return Math.max(super/*amuvvoafs.view.View*/.getSuggestedMinimumWidth(), getPaddingRight() + getPaddingLeft());
    }

    @Override // r6.s
    public final boolean h(View view, View view2, int i, int i2) {
        View view3;
        int i3;
        int i4;
        int childCount = getChildCount();
        int i6 = 0;
        boolean z = false;
        while (i6 < childCount) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 8) {
                view3 = view;
                i3 = i;
                i4 = i2;
            } else {
                e layoutParams = childAt.getLayoutParams();
                b bVar = layoutParams.a;
                if (bVar != null) {
                    view3 = view;
                    i3 = i;
                    i4 = i2;
                    boolean zT = bVar.t(this, childAt, view3, i3, i4);
                    z |= zT;
                    if (i4 == 0) {
                        layoutParams.m = zT;
                    } else if (i4 == 1) {
                        layoutParams.n = zT;
                    }
                } else {
                    view3 = view;
                    i3 = i;
                    i4 = i2;
                    if (i4 == 0) {
                        layoutParams.m = false;
                    } else if (i4 == 1) {
                        layoutParams.n = false;
                    }
                }
            }
            i6++;
            view = view3;
            i = i3;
            i2 = i4;
        }
        return z;
    }

    public final void i(View view, Rect rect, boolean z) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            k(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public final ArrayList j(View view) {
        x0 x0Var = (x0) this.b.b;
        int i = x0Var.c;
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < i; i2++) {
            ArrayList arrayList2 = (ArrayList) x0Var.i(i2);
            if (arrayList2 != null && arrayList2.contains(view)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(x0Var.f(i2));
            }
        }
        ArrayList arrayList3 = this.d;
        arrayList3.clear();
        if (arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        return arrayList3;
    }

    public final void k(View view, Rect rect) {
        ThreadLocal threadLocal = i.a;
        rect.set(0, 0, view.getWidth(), view.getHeight());
        ThreadLocal threadLocal2 = i.a;
        Matrix matrix = (Matrix) threadLocal2.get();
        if (matrix == null) {
            matrix = new Matrix();
            threadLocal2.set(matrix);
        } else {
            matrix.reset();
        }
        i.a(this, view, matrix);
        ThreadLocal threadLocal3 = i.b;
        RectF rectF = (RectF) threadLocal3.get();
        if (rectF == null) {
            rectF = new RectF();
            threadLocal3.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    public final int m(int i) {
        int[] iArr = this.i;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        }
        if (i >= 0 && i < iArr.length) {
            return iArr[i];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
        return 0;
    }

    public final boolean o(View view, int i, int i2) {
        d dVar = x;
        Rect rectA = a();
        k(view, rectA);
        try {
            return rectA.contains(i, i2);
        } finally {
            rectA.setEmpty();
            dVar.c(rectA);
        }
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        u(false);
        if (this.m) {
            if (this.l == null) {
                this.l = new f(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.l);
        }
        if (this.n == null) {
            WeakHashMap weakHashMap = u0.a;
            if (getFitsSystemWindows()) {
                j0.c(this);
            }
        }
        this.h = true;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u(false);
        if (this.m && this.l != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.l);
        }
        View view = this.k;
        if (view != null) {
            c(view, 0);
        }
        this.h = false;
    }

    public final void onDraw(Canvas canvas) {
        super/*amuvvoafs.view.View*/.onDraw(canvas);
        if (!this.o || this.p == null) {
            return;
        }
        z1 z1Var = this.n;
        int iD = z1Var != null ? z1Var.d() : 0;
        if (iD > 0) {
            this.p.setBounds(0, 0, getWidth(), iD);
            this.p.draw(canvas);
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            u(true);
        }
        boolean zS = s(motionEvent, 0);
        if (actionMasked != 1 && actionMasked != 3) {
            return zS;
        }
        u(true);
        return zS;
    }

    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        b bVar;
        WeakHashMap weakHashMap = u0.a;
        int layoutDirection = getLayoutDirection();
        ArrayList arrayList = this.a;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            View view = (View) arrayList.get(i6);
            if (view.getVisibility() != 8 && ((bVar = view.getLayoutParams().a) == null || !bVar.l(this, view, layoutDirection))) {
                q(view, layoutDirection);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x018b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onMeasure(int r27, int r28) {
        /*
            Method dump skipped, instruction units count: 501
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    public final boolean onNestedFling(View view, float f2, float f3, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                e layoutParams = childAt.getLayoutParams();
                if (layoutParams.a(0)) {
                    b bVar = layoutParams.a;
                }
            }
        }
        return false;
    }

    public final boolean onNestedPreFling(View view, float f2, float f3) {
        b bVar;
        int childCount = getChildCount();
        boolean zN = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                e layoutParams = childAt.getLayoutParams();
                if (layoutParams.a(0) && (bVar = layoutParams.a) != null) {
                    zN |= bVar.n(view);
                }
            }
        }
        return zN;
    }

    public final void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        d(view, i, i2, iArr, 0);
    }

    public final void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        g(view, i, i2, i3, i4, 0);
    }

    public final void onNestedScrollAccepted(View view, View view2, int i) {
        b(view, view2, i, 0);
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof g)) {
            super/*amuvvoafs.view.View*/.onRestoreInstanceState(parcelable);
            return;
        }
        g gVar = (g) parcelable;
        super/*amuvvoafs.view.View*/.onRestoreInstanceState(gVar.a());
        SparseArray sparseArray = gVar.c;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            b bVar = n(childAt).a;
            if (id != -1 && bVar != null && (parcelable2 = (Parcelable) sparseArray.get(id)) != null) {
                bVar.r(childAt, parcelable2);
            }
        }
    }

    public final Parcelable onSaveInstanceState() {
        Parcelable parcelableS;
        g gVar = new g(super/*amuvvoafs.view.View*/.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            b bVar = childAt.getLayoutParams().a;
            if (id != -1 && bVar != null && (parcelableS = bVar.s(childAt)) != null) {
                sparseArray.append(id, parcelableS);
            }
        }
        gVar.c = sparseArray;
        return gVar;
    }

    public final boolean onStartNestedScroll(View view, View view2, int i) {
        return h(view, view2, i, 0);
    }

    public final void onStopNestedScroll(View view) {
        c(view, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015 A[PHI: r3
  0x0015: PHI (r3v4 boolean) = (r3v2 boolean), (r3v5 boolean) binds: [B:10:0x0022, B:5:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouchEvent(amuvvoafs.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r1.getActionMasked()
            amuvvoafs.view.View r3 = r0.f557j
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L17
            boolean r3 = r0.s(r1, r4)
            if (r3 == 0) goto L15
            goto L18
        L15:
            r6 = r5
            goto L2a
        L17:
            r3 = r5
        L18:
            amuvvoafs.view.View r6 = r0.f557j
            amuvvoafs.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            c6.e r6 = (c6.e) r6
            c6.b r6 = r6.a
            if (r6 == 0) goto L15
            amuvvoafs.view.View r7 = r0.f557j
            boolean r6 = r6.v(r0, r7, r1)
        L2a:
            amuvvoafs.view.View r7 = r0.f557j
            r8 = 0
            if (r7 != 0) goto L35
            boolean r1 = super/*amuvvoafs.view.View*/.onTouchEvent(r18)
            r6 = r6 | r1
            goto L48
        L35:
            if (r3 == 0) goto L48
            long r9 = amuvvoafs.os.SystemClock.uptimeMillis()
            r15 = 0
            r16 = 0
            r13 = 3
            r14 = 0
            r11 = r9
            amuvvoafs.view.MotionEvent r8 = amuvvoafs.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super/*amuvvoafs.view.View*/.onTouchEvent(r8)
        L48:
            if (r8 == 0) goto L4d
            r8.recycle()
        L4d:
            if (r2 == r4) goto L54
            r1 = 3
            if (r2 != r1) goto L53
            goto L54
        L53:
            return r6
        L54:
            r0.u(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(amuvvoafs.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void p(int r23) {
        /*
            Method dump skipped, instruction units count: 755
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.coordinatorlayout.widget.CoordinatorLayout.p(int):void");
    }

    public final void q(View view, int i) {
        Rect rectA;
        Rect rectA2;
        e layoutParams = view.getLayoutParams();
        View view2 = layoutParams.k;
        if (view2 == null && layoutParams.f != -1) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        d dVar = x;
        if (view2 != null) {
            rectA = a();
            rectA2 = a();
            try {
                k(view2, rectA);
                e eVar = (e) view.getLayoutParams();
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                l(i, rectA, rectA2, eVar, measuredWidth, measuredHeight);
                e(eVar, rectA2, measuredWidth, measuredHeight);
                view.layout(rectA2.left, rectA2.top, rectA2.right, rectA2.bottom);
                return;
            } finally {
                rectA.setEmpty();
                dVar.c(rectA);
                rectA2.setEmpty();
                dVar.c(rectA2);
            }
        }
        int i2 = layoutParams.e;
        if (i2 < 0) {
            e layoutParams2 = view.getLayoutParams();
            rectA = a();
            rectA.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin);
            if (this.n != null) {
                WeakHashMap weakHashMap = u0.a;
                if (getFitsSystemWindows() && !view.getFitsSystemWindows()) {
                    rectA.left = this.n.b() + rectA.left;
                    rectA.top = this.n.d() + rectA.top;
                    rectA.right -= this.n.c();
                    rectA.bottom -= this.n.a();
                }
            }
            rectA2 = a();
            int i3 = layoutParams2.c;
            if ((i3 & 7) == 0) {
                i3 |= 8388611;
            }
            if ((i3 & 112) == 0) {
                i3 |= 48;
            }
            Gravity.apply(i3, view.getMeasuredWidth(), view.getMeasuredHeight(), rectA, rectA2, i);
            view.layout(rectA2.left, rectA2.top, rectA2.right, rectA2.bottom);
            return;
        }
        e layoutParams3 = view.getLayoutParams();
        int i4 = layoutParams3.c;
        if (i4 == 0) {
            i4 = 8388661;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i4, i);
        int i6 = absoluteGravity & 7;
        int i7 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth2 = view.getMeasuredWidth();
        int measuredHeight2 = view.getMeasuredHeight();
        if (i == 1) {
            i2 = width - i2;
        }
        int iM = m(i2) - measuredWidth2;
        if (i6 == 1) {
            iM += measuredWidth2 / 2;
        } else if (i6 == 5) {
            iM += measuredWidth2;
        }
        int i8 = i7 != 16 ? i7 != 80 ? 0 : measuredHeight2 : measuredHeight2 / 2;
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin, Math.min(iM, ((width - getPaddingRight()) - measuredWidth2) - ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin, Math.min(i8, ((height - getPaddingBottom()) - measuredHeight2) - ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin));
        view.layout(iMax, iMax2, measuredWidth2 + iMax, measuredHeight2 + iMax2);
    }

    public final void r(View view, int i, int i2, int i3) {
        measureChildWithMargins(view, i, i2, i3, 0);
    }

    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        b bVar = view.getLayoutParams().a;
        if (bVar == null || !bVar.q(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    public final void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (!z || this.g) {
            return;
        }
        u(false);
        this.g = true;
    }

    public final boolean s(MotionEvent motionEvent, int i) {
        int actionMasked = motionEvent.getActionMasked();
        ArrayList arrayList = this.c;
        arrayList.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            arrayList.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i2) : i2));
        }
        h hVar = w;
        if (hVar != null) {
            Collections.sort(arrayList, hVar);
        }
        int size = arrayList.size();
        MotionEvent motionEventObtain = null;
        boolean zK = false;
        for (int i3 = 0; i3 < size; i3++) {
            View view = (View) arrayList.get(i3);
            b bVar = view.getLayoutParams().a;
            if (zK && actionMasked != 0) {
                if (bVar != null) {
                    if (motionEventObtain == null) {
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    }
                    if (i == 0) {
                        bVar.k(this, view, motionEventObtain);
                    } else if (i == 1) {
                        bVar.v(this, view, motionEventObtain);
                    }
                }
            } else if (!zK && bVar != null) {
                if (i == 0) {
                    zK = bVar.k(this, view, motionEvent);
                } else if (i == 1) {
                    zK = bVar.v(this, view, motionEvent);
                }
                if (zK) {
                    this.f557j = view;
                }
            }
        }
        arrayList.clear();
        return zK;
    }

    public void setFitsSystemWindows(boolean z) {
        super/*amuvvoafs.view.View*/.setFitsSystemWindows(z);
        x();
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.q = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.p = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.p.setState(getDrawableState());
                }
                Drawable drawable3 = this.p;
                WeakHashMap weakHashMap = u0.a;
                z.O(drawable3, getLayoutDirection());
                this.p.setVisible(getVisibility() == 0, false);
                this.p.setCallback(this);
            }
            WeakHashMap weakHashMap2 = u0.a;
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? getContext().getDrawable(i) : null);
    }

    public void setVisibility(int i) {
        super/*amuvvoafs.view.View*/.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.p;
        if (drawable == null || drawable.isVisible() == z) {
            return;
        }
        this.p.setVisible(z, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void t() {
        /*
            Method dump skipped, instruction units count: 402
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.coordinatorlayout.widget.CoordinatorLayout.t():void");
    }

    public final void u(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            b bVar = childAt.getLayoutParams().a;
            if (bVar != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    bVar.k(this, childAt, motionEventObtain);
                } else {
                    bVar.v(this, childAt, motionEventObtain);
                }
                motionEventObtain.recycle();
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).getLayoutParams().getClass();
        }
        this.f557j = null;
        this.g = false;
    }

    public final boolean verifyDrawable(Drawable drawable) {
        return super/*amuvvoafs.view.View*/.verifyDrawable(drawable) || drawable == this.p;
    }

    public final void x() {
        WeakHashMap weakHashMap = u0.a;
        if (!getFitsSystemWindows()) {
            l0.n(this, null);
            return;
        }
        if (this.r == null) {
            this.r = new o(13, this);
        }
        l0.n(this, this.r);
        setSystemUiVisibility(1280);
    }

    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e ? new e((e) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }
}
