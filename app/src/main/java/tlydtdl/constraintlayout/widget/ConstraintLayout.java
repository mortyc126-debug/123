package tlydtdl.constraintlayout.widget;

import a6.b;
import a6.h;
import a6.o;
import a6.p;
import a6.q;
import a6.s;
import a6.t;
import amuvvoafs.content.Context;
import amuvvoafs.content.res.Resources;
import amuvvoafs.content.res.TypedArray;
import amuvvoafs.graphics.Canvas;
import amuvvoafs.graphics.Paint;
import amuvvoafs.util.AttributeSet;
import amuvvoafs.util.Log;
import amuvvoafs.util.SparseArray;
import amuvvoafs.view.View;
import amuvvoafs.view.ViewGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.IntCompanionObject;
import okhttp3.internal.http2.Http2Connection;
import org.apache.commons.net.ftp.FTPReply;
import tlydtdl.compose.foundation.layout.m;
import v5.c;
import x5.d;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {
    private static t sSharedValues;
    SparseArray<View> mChildrenByIds;
    private ArrayList<b> mConstraintHelpers;
    protected h mConstraintLayoutSpec;
    private o mConstraintSet;
    private int mConstraintSetId;
    private HashMap<String, Integer> mDesignIds;
    protected boolean mDirtyHierarchy;
    private int mLastMeasureHeight;
    int mLastMeasureHeightMode;
    int mLastMeasureHeightSize;
    private int mLastMeasureWidth;
    int mLastMeasureWidthMode;
    int mLastMeasureWidthSize;
    protected e mLayoutWidget;
    private int mMaxHeight;
    private int mMaxWidth;
    a6.e mMeasurer;
    private int mMinHeight;
    private int mMinWidth;
    private ArrayList<Object> mModifiers;
    private int mOnMeasureHeightMeasureSpec;
    private int mOnMeasureWidthMeasureSpec;
    private int mOptimizationLevel;
    private SparseArray<d> mTempMapIdToWidget;

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new e();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = IntCompanionObject.MAX_VALUE;
        this.mMaxHeight = IntCompanionObject.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = FTPReply.PATHNAME_CREATED;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new a6.e(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        a(attributeSet, 0, 0);
    }

    public static /* synthetic */ v5.d access$000(ConstraintLayout constraintLayout) {
        constraintLayout.getClass();
        return null;
    }

    private int getPaddingWidth() {
        int iMax = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int iMax2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        return iMax2 > 0 ? iMax2 : iMax;
    }

    public static t getSharedValues() {
        if (sSharedValues == null) {
            sSharedValues = new t();
        }
        return sSharedValues;
    }

    public final void a(AttributeSet attributeSet, int i, int i2) {
        e eVar = this.mLayoutWidget;
        eVar.f0 = this;
        a6.e eVar2 = this.mMeasurer;
        eVar.u0 = eVar2;
        eVar.s0.g = eVar2;
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, s.b, i, i2);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == 16) {
                    this.mMinWidth = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.mMinWidth);
                } else if (index == 17) {
                    this.mMinHeight = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.mMinHeight);
                } else if (index == 14) {
                    this.mMaxWidth = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                } else if (index == 15) {
                    this.mMaxHeight = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxHeight);
                } else if (index == 113) {
                    this.mOptimizationLevel = typedArrayObtainStyledAttributes.getInt(index, this.mOptimizationLevel);
                } else if (index == 56) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            parseLayoutDescription(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.mConstraintLayoutSpec = null;
                        }
                    }
                } else if (index == 34) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        o oVar = new o();
                        this.mConstraintSet = oVar;
                        oVar.g(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.mConstraintSet = null;
                    }
                    this.mConstraintSetId = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        e eVar3 = this.mLayoutWidget;
        eVar3.D0 = this.mOptimizationLevel;
        c.q = eVar3.W(512);
    }

    /* JADX WARN: Removed duplicated region for block: B:160:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01ac  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:160:0x02bb -> B:161:0x02bc). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void applyConstraintsFromLayoutParams(boolean r20, amuvvoafs.view.View r21, x5.d r22, a6.d r23, amuvvoafs.util.SparseArray<x5.d> r24) {
        /*
            Method dump skipped, instruction units count: 806
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.constraintlayout.widget.ConstraintLayout.applyConstraintsFromLayoutParams(boolean, amuvvoafs.view.View, x5.d, a6.d, amuvvoafs.util.SparseArray):void");
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a6.d;
    }

    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<b> arrayList = this.mConstraintHelpers;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i = 0; i < size; i++) {
                this.mConstraintHelpers.get(i).getClass();
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(",");
                    if (strArrSplit.length == 4) {
                        int i3 = Integer.parseInt(strArrSplit[0]);
                        int i4 = Integer.parseInt(strArrSplit[1]);
                        int i6 = Integer.parseInt(strArrSplit[2]);
                        int i7 = (int) ((i3 / 1080.0f) * width);
                        int i8 = (int) ((i4 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f2 = i7;
                        float f3 = i8;
                        float f4 = i7 + ((int) ((i6 / 1080.0f) * width));
                        canvas.drawLine(f2, f3, f4, f3, paint);
                        float f5 = i8 + ((int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height));
                        canvas.drawLine(f4, f3, f4, f5, paint);
                        canvas.drawLine(f4, f5, f2, f5, paint);
                        canvas.drawLine(f2, f5, f2, f3, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f2, f3, f4, f5, paint);
                        canvas.drawLine(f2, f5, f4, f3, paint);
                    }
                }
            }
        }
    }

    public boolean dynamicUpdateConstraints(int i, int i2) {
        if (this.mModifiers == null) {
            return false;
        }
        View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        Iterator<Object> it = this.mModifiers.iterator();
        while (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            Iterator it2 = this.mLayoutWidget.q0.iterator();
            if (it2.hasNext()) {
                View view = ((d) it2.next()).f0;
                view.getId();
                view.getLayoutParams();
                throw null;
            }
        }
        return false;
    }

    public final void e(d dVar, a6.d dVar2, SparseArray sparseArray, int i, int i2) {
        View view = (View) this.mChildrenByIds.get(i);
        d dVar3 = (d) sparseArray.get(i);
        if (dVar3 == null || view == null || !(view.getLayoutParams() instanceof a6.d)) {
            return;
        }
        dVar2.c0 = true;
        if (i2 == 6) {
            a6.d layoutParams = view.getLayoutParams();
            layoutParams.c0 = true;
            layoutParams.p0.E = true;
        }
        dVar.i(6).b(dVar3.i(i2), dVar2.D, dVar2.C, true);
        dVar.E = true;
        dVar.i(3).j();
        dVar.i(5).j();
    }

    public void forceLayout() {
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        super/*amuvvoafs.view.View*/.forceLayout();
    }

    public Object getDesignInformation(int i, Object obj) {
        if (i != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> map = this.mDesignIds;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.mDesignIds.get(str);
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.D0;
    }

    public String getSceneString() {
        int id;
        StringBuilder sb = new StringBuilder();
        if (this.mLayoutWidget.f688j == null) {
            int id2 = getId();
            if (id2 != -1) {
                this.mLayoutWidget.f688j = getContext().getResources().getResourceEntryName(id2);
            } else {
                this.mLayoutWidget.f688j = "parent";
            }
        }
        e eVar = this.mLayoutWidget;
        if (eVar.h0 == null) {
            eVar.h0 = eVar.f688j;
            Log.v("ConstraintLayout", " setDebugName " + this.mLayoutWidget.h0);
        }
        for (d dVar : this.mLayoutWidget.q0) {
            View view = dVar.f0;
            if (view != null) {
                if (dVar.f688j == null && (id = view.getId()) != -1) {
                    dVar.f688j = getContext().getResources().getResourceEntryName(id);
                }
                if (dVar.h0 == null) {
                    dVar.h0 = dVar.f688j;
                    Log.v("ConstraintLayout", " setDebugName " + dVar.h0);
                }
            }
        }
        this.mLayoutWidget.n(sb);
        return sb.toString();
    }

    public View getViewById(int i) {
        return (View) this.mChildrenByIds.get(i);
    }

    public final d getViewWidget(View view) {
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof a6.d) {
            return view.getLayoutParams().p0;
        }
        view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof a6.d) {
            return view.getLayoutParams().p0;
        }
        return null;
    }

    public boolean isRtl() {
        return (getContext().getApplicationInfo().flags & 4194304) != 0 && 1 == getLayoutDirection();
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            a6.d layoutParams = childAt.getLayoutParams();
            d dVar = layoutParams.p0;
            if (childAt.getVisibility() != 8 || layoutParams.d0 || layoutParams.e0 || zIsInEditMode) {
                int iR = dVar.r();
                int iS = dVar.s();
                childAt.layout(iR, iS, dVar.q() + iR, dVar.k() + iS);
            }
        }
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i7 = 0; i7 < size; i7++) {
                this.mConstraintHelpers.get(i7).getClass();
            }
        }
    }

    public void onMeasure(int i, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        d dVar;
        boolean zDynamicUpdateConstraints = this.mDirtyHierarchy | dynamicUpdateConstraints(i, i2);
        this.mDirtyHierarchy = zDynamicUpdateConstraints;
        boolean z4 = true;
        int i3 = 0;
        if (!zDynamicUpdateConstraints) {
            int childCount = getChildCount();
            int i4 = 0;
            while (true) {
                if (i4 >= childCount) {
                    break;
                }
                if (getChildAt(i4).isLayoutRequested()) {
                    this.mDirtyHierarchy = true;
                    break;
                }
                i4++;
            }
        }
        this.mOnMeasureWidthMeasureSpec = i;
        this.mOnMeasureHeightMeasureSpec = i2;
        this.mLayoutWidget.v0 = isRtl();
        if (this.mDirtyHierarchy) {
            this.mDirtyHierarchy = false;
            int childCount2 = getChildCount();
            int i6 = 0;
            while (true) {
                if (i6 >= childCount2) {
                    z = false;
                    break;
                } else {
                    if (getChildAt(i6).isLayoutRequested()) {
                        z = true;
                        break;
                    }
                    i6++;
                }
            }
            if (z) {
                boolean zIsInEditMode = isInEditMode();
                int childCount3 = getChildCount();
                for (int i7 = 0; i7 < childCount3; i7++) {
                    d viewWidget = getViewWidget(getChildAt(i7));
                    if (viewWidget != null) {
                        viewWidget.C();
                    }
                }
                Object obj = null;
                if (zIsInEditMode) {
                    for (int i8 = 0; i8 < childCount3; i8++) {
                        View childAt = getChildAt(i8);
                        try {
                            String resourceName = getResources().getResourceName(childAt.getId());
                            setDesignInformation(0, resourceName, Integer.valueOf(childAt.getId()));
                            int iIndexOf = resourceName.indexOf(47);
                            if (iIndexOf != -1) {
                                resourceName = resourceName.substring(iIndexOf + 1);
                            }
                            int id = childAt.getId();
                            if (id == 0) {
                                dVar = this.mLayoutWidget;
                            } else {
                                ConstraintLayout constraintLayoutFindViewById = (View) this.mChildrenByIds.get(id);
                                if (constraintLayoutFindViewById == null && (constraintLayoutFindViewById = findViewById(id)) != null && constraintLayoutFindViewById != this && constraintLayoutFindViewById.getParent() == this) {
                                    onViewAdded(constraintLayoutFindViewById);
                                }
                                dVar = constraintLayoutFindViewById == this ? this.mLayoutWidget : constraintLayoutFindViewById == null ? null : constraintLayoutFindViewById.getLayoutParams().p0;
                            }
                            dVar.h0 = resourceName;
                        } catch (Resources.NotFoundException unused) {
                        }
                    }
                }
                if (this.mConstraintSetId != -1) {
                    for (int i9 = 0; i9 < childCount3; i9++) {
                        getChildAt(i9).getId();
                    }
                }
                o oVar = this.mConstraintSet;
                if (oVar != null) {
                    oVar.a(this);
                }
                this.mLayoutWidget.q0.clear();
                int size = this.mConstraintHelpers.size();
                if (size > 0) {
                    int i10 = 0;
                    while (i10 < size) {
                        b bVar = this.mConstraintHelpers.get(i10);
                        HashMap map = bVar.g;
                        if (bVar.isInEditMode()) {
                            bVar.setIds(bVar.e);
                        }
                        i iVar = bVar.d;
                        if (iVar == null) {
                            z2 = z4;
                        } else {
                            iVar.r0 = i3;
                            Arrays.fill(iVar.q0, obj);
                            int i11 = i3;
                            while (i11 < bVar.b) {
                                int i12 = bVar.a[i11];
                                View viewById = getViewById(i12);
                                if (viewById == null) {
                                    String str = (String) map.get(Integer.valueOf(i12));
                                    z3 = z4;
                                    int iF = bVar.f(this, str);
                                    if (iF != 0) {
                                        bVar.a[i11] = iF;
                                        map.put(Integer.valueOf(iF), str);
                                        viewById = getViewById(iF);
                                    }
                                } else {
                                    z3 = z4;
                                }
                                if (viewById != null) {
                                    i iVar2 = bVar.d;
                                    d viewWidget2 = getViewWidget(viewById);
                                    iVar2.getClass();
                                    if (viewWidget2 != iVar2 && viewWidget2 != null) {
                                        int i13 = iVar2.r0 + 1;
                                        d[] dVarArr = iVar2.q0;
                                        if (i13 > dVarArr.length) {
                                            iVar2.q0 = (d[]) Arrays.copyOf(dVarArr, dVarArr.length * 2);
                                        }
                                        d[] dVarArr2 = iVar2.q0;
                                        int i14 = iVar2.r0;
                                        dVarArr2[i14] = viewWidget2;
                                        iVar2.r0 = i14 + 1;
                                    }
                                }
                                i11++;
                                z4 = z3;
                            }
                            z2 = z4;
                            bVar.d.S();
                        }
                        i10++;
                        z4 = z2;
                        i3 = 0;
                        obj = null;
                    }
                }
                for (int i15 = 0; i15 < childCount3; i15++) {
                    getChildAt(i15);
                }
                this.mTempMapIdToWidget.clear();
                this.mTempMapIdToWidget.put(0, this.mLayoutWidget);
                this.mTempMapIdToWidget.put(getId(), this.mLayoutWidget);
                for (int i16 = 0; i16 < childCount3; i16++) {
                    View childAt2 = getChildAt(i16);
                    this.mTempMapIdToWidget.put(childAt2.getId(), getViewWidget(childAt2));
                }
                for (int i17 = 0; i17 < childCount3; i17++) {
                    View childAt3 = getChildAt(i17);
                    d viewWidget3 = getViewWidget(childAt3);
                    if (viewWidget3 != null) {
                        a6.d layoutParams = childAt3.getLayoutParams();
                        e eVar = this.mLayoutWidget;
                        eVar.q0.add(viewWidget3);
                        d dVar2 = viewWidget3.T;
                        if (dVar2 != null) {
                            ((e) dVar2).q0.remove(viewWidget3);
                            viewWidget3.C();
                        }
                        viewWidget3.T = eVar;
                        applyConstraintsFromLayoutParams(zIsInEditMode, childAt3, viewWidget3, layoutParams, this.mTempMapIdToWidget);
                    }
                }
            }
            if (z) {
                e eVar2 = this.mLayoutWidget;
                eVar2.r0.K(eVar2);
            }
        }
        this.mLayoutWidget.w0.getClass();
        resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, i, i2);
        int iQ = this.mLayoutWidget.q();
        int iK = this.mLayoutWidget.k();
        e eVar3 = this.mLayoutWidget;
        resolveMeasuredDimension(i, i2, iQ, iK, eVar3.E0, eVar3.F0);
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        d viewWidget = getViewWidget(view);
        if ((view instanceof q) && !(viewWidget instanceof x5.h)) {
            a6.d layoutParams = view.getLayoutParams();
            x5.h hVar = new x5.h();
            layoutParams.p0 = hVar;
            layoutParams.d0 = true;
            hVar.S(layoutParams.V);
        }
        if (view instanceof b) {
            b bVar = (b) view;
            bVar.i();
            view.getLayoutParams().e0 = true;
            if (!this.mConstraintHelpers.contains(bVar)) {
                this.mConstraintHelpers.add(bVar);
            }
        }
        this.mChildrenByIds.put(view.getId(), view);
        this.mDirtyHierarchy = true;
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.mChildrenByIds.remove(view.getId());
        d viewWidget = getViewWidget(view);
        this.mLayoutWidget.q0.remove(viewWidget);
        viewWidget.C();
        this.mConstraintHelpers.remove(view);
        this.mDirtyHierarchy = true;
    }

    public void parseLayoutDescription(int i) {
        this.mConstraintLayoutSpec = new h(getContext(), i);
    }

    public void requestLayout() {
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        super/*amuvvoafs.view.View*/.requestLayout();
    }

    public void resolveMeasuredDimension(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        a6.e eVar = this.mMeasurer;
        int i6 = eVar.e;
        int iResolveSizeAndState = View.resolveSizeAndState(i3 + eVar.d, i, 0);
        int iResolveSizeAndState2 = View.resolveSizeAndState(i4 + i6, i2, 0) & 16777215;
        int iMin = Math.min(this.mMaxWidth, iResolveSizeAndState & 16777215);
        int iMin2 = Math.min(this.mMaxHeight, iResolveSizeAndState2);
        if (z) {
            iMin |= Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
        }
        if (z2) {
            iMin2 |= Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
        }
        setMeasuredDimension(iMin, iMin2);
        this.mLastMeasureWidth = iMin;
        this.mLastMeasureHeight = iMin2;
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x047e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0113 A[PHI: r6 r13
  0x0113: PHI (r6v3 boolean) = (r6v2 boolean), (r6v55 boolean) binds: [B:18:0x00ac, B:347:0x0113] A[DONT_GENERATE, DONT_INLINE]
  0x0113: PHI (r13v2 int) = (r13v1 int), (r13v31 int) binds: [B:18:0x00ac, B:347:0x0113] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void resolveSystem(x5.e r28, int r29, int r30, int r31) {
        /*
            Method dump skipped, instruction units count: 1579
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.constraintlayout.widget.ConstraintLayout.resolveSystem(x5.e, int, int, int):void");
    }

    public void setConstraintSet(o oVar) {
        this.mConstraintSet = oVar;
    }

    public void setDesignInformation(int i, Object obj, Object obj2) {
        if (i == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.mDesignIds == null) {
                this.mDesignIds = new HashMap<>();
            }
            String strSubstring = (String) obj;
            int iIndexOf = strSubstring.indexOf("/");
            if (iIndexOf != -1) {
                strSubstring = strSubstring.substring(iIndexOf + 1);
            }
            this.mDesignIds.put(strSubstring, (Integer) obj2);
        }
    }

    public void setId(int i) {
        this.mChildrenByIds.remove(getId());
        super/*amuvvoafs.view.View*/.setId(i);
        this.mChildrenByIds.put(getId(), this);
    }

    public void setMaxHeight(int i) {
        if (i == this.mMaxHeight) {
            return;
        }
        this.mMaxHeight = i;
        requestLayout();
    }

    public void setMaxWidth(int i) {
        if (i == this.mMaxWidth) {
            return;
        }
        this.mMaxWidth = i;
        requestLayout();
    }

    public void setMinHeight(int i) {
        if (i == this.mMinHeight) {
            return;
        }
        this.mMinHeight = i;
        requestLayout();
    }

    public void setMinWidth(int i) {
        if (i == this.mMinWidth) {
            return;
        }
        this.mMinWidth = i;
        requestLayout();
    }

    public void setOnConstraintsChanged(p pVar) {
        h hVar = this.mConstraintLayoutSpec;
        if (hVar != null) {
            hVar.getClass();
        }
    }

    public void setOptimizationLevel(int i) {
        this.mOptimizationLevel = i;
        e eVar = this.mLayoutWidget;
        eVar.D0 = i;
        c.q = eVar.W(512);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setSelfDimensionBehaviour(x5.e r9, int r10, int r11, int r12, int r13) {
        /*
            r8 = this;
            a6.e r0 = r8.mMeasurer
            int r1 = r0.e
            int r0 = r0.d
            int r2 = r8.getChildCount()
            r3 = 1
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = 2
            r6 = 0
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r10 == r7) goto L2f
            if (r10 == 0) goto L23
            if (r10 == r4) goto L1a
            r10 = r3
        L18:
            r11 = r6
            goto L38
        L1a:
            int r10 = r8.mMaxWidth
            int r10 = r10 - r0
            int r11 = java.lang.Math.min(r10, r11)
            r10 = r3
            goto L38
        L23:
            if (r2 != 0) goto L2d
            int r10 = r8.mMinWidth
            int r11 = java.lang.Math.max(r6, r10)
        L2b:
            r10 = r5
            goto L38
        L2d:
            r10 = r5
            goto L18
        L2f:
            if (r2 != 0) goto L2b
            int r10 = r8.mMinWidth
            int r11 = java.lang.Math.max(r6, r10)
            goto L2b
        L38:
            if (r12 == r7) goto L53
            if (r12 == 0) goto L4a
            if (r12 == r4) goto L41
            r5 = r3
        L3f:
            r13 = r6
            goto L5b
        L41:
            int r12 = r8.mMaxHeight
            int r12 = r12 - r1
            int r13 = java.lang.Math.min(r12, r13)
            r5 = r3
            goto L5b
        L4a:
            if (r2 != 0) goto L3f
            int r12 = r8.mMinHeight
            int r13 = java.lang.Math.max(r6, r12)
            goto L5b
        L53:
            if (r2 != 0) goto L5b
            int r12 = r8.mMinHeight
            int r13 = java.lang.Math.max(r6, r12)
        L5b:
            int r12 = r9.q()
            if (r11 != r12) goto L67
            int r12 = r9.k()
            if (r13 == r12) goto L6b
        L67:
            b02.n r12 = r9.s0
            r12.c = r3
        L6b:
            r9.Y = r6
            r9.Z = r6
            int r12 = r8.mMaxWidth
            int r12 = r12 - r0
            int[] r2 = r9.C
            r2[r6] = r12
            int r12 = r8.mMaxHeight
            int r12 = r12 - r1
            r2[r3] = r12
            r9.b0 = r6
            r9.c0 = r6
            r9.M(r10)
            r9.O(r11)
            r9.N(r5)
            r9.L(r13)
            int r10 = r8.mMinWidth
            int r10 = r10 - r0
            if (r10 >= 0) goto L93
            r9.b0 = r6
            goto L95
        L93:
            r9.b0 = r10
        L95:
            int r10 = r8.mMinHeight
            int r10 = r10 - r1
            if (r10 >= 0) goto L9d
            r9.c0 = r6
            return
        L9d:
            r9.c0 = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.constraintlayout.widget.ConstraintLayout.setSelfDimensionBehaviour(x5.e, int, int, int, int):void");
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX INFO: renamed from: generateDefaultLayoutParams, reason: merged with bridge method [inline-methods] */
    public a6.d m1791generateDefaultLayoutParams() {
        return new a6.d(-2, -2);
    }

    /* JADX INFO: renamed from: generateLayoutParams, reason: merged with bridge method [inline-methods] */
    public a6.d m1792generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        a6.d dVar = new a6.d(context, attributeSet);
        dVar.a = -1;
        dVar.b = -1;
        dVar.c = -1.0f;
        dVar.d = true;
        dVar.e = -1;
        dVar.f = -1;
        dVar.g = -1;
        dVar.h = -1;
        dVar.i = -1;
        dVar.j = -1;
        dVar.k = -1;
        dVar.l = -1;
        dVar.m = -1;
        dVar.n = -1;
        dVar.o = -1;
        dVar.p = -1;
        dVar.q = 0;
        dVar.r = 0.0f;
        dVar.s = -1;
        dVar.t = -1;
        dVar.u = -1;
        dVar.v = -1;
        dVar.w = IntCompanionObject.MIN_VALUE;
        dVar.x = IntCompanionObject.MIN_VALUE;
        dVar.y = IntCompanionObject.MIN_VALUE;
        dVar.z = IntCompanionObject.MIN_VALUE;
        dVar.A = IntCompanionObject.MIN_VALUE;
        dVar.B = IntCompanionObject.MIN_VALUE;
        dVar.C = IntCompanionObject.MIN_VALUE;
        dVar.D = 0;
        dVar.E = 0.5f;
        dVar.F = 0.5f;
        dVar.G = null;
        dVar.H = -1.0f;
        dVar.I = -1.0f;
        dVar.J = 0;
        dVar.K = 0;
        dVar.L = 0;
        dVar.M = 0;
        dVar.N = 0;
        dVar.O = 0;
        dVar.P = 0;
        dVar.Q = 0;
        dVar.R = 1.0f;
        dVar.S = 1.0f;
        dVar.T = -1;
        dVar.U = -1;
        dVar.V = -1;
        dVar.W = false;
        dVar.X = false;
        dVar.Y = null;
        dVar.Z = 0;
        dVar.a0 = true;
        dVar.b0 = true;
        dVar.c0 = false;
        dVar.d0 = false;
        dVar.e0 = false;
        dVar.f0 = -1;
        dVar.g0 = -1;
        dVar.h0 = -1;
        dVar.i0 = -1;
        dVar.j0 = IntCompanionObject.MIN_VALUE;
        dVar.k0 = IntCompanionObject.MIN_VALUE;
        dVar.l0 = 0.5f;
        dVar.p0 = new d();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.b);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            int i2 = a6.c.a.get(index);
            switch (i2) {
                case 1:
                    dVar.V = typedArrayObtainStyledAttributes.getInt(index, dVar.V);
                    break;
                case 2:
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, dVar.p);
                    dVar.p = resourceId;
                    if (resourceId == -1) {
                        dVar.p = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 3:
                    dVar.q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dVar.q);
                    break;
                case 4:
                    float f2 = typedArrayObtainStyledAttributes.getFloat(index, dVar.r) % 360.0f;
                    dVar.r = f2;
                    if (f2 < 0.0f) {
                        dVar.r = (360.0f - f2) % 360.0f;
                    }
                    break;
                case 5:
                    dVar.a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, dVar.a);
                    break;
                case 6:
                    dVar.b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, dVar.b);
                    break;
                case 7:
                    dVar.c = typedArrayObtainStyledAttributes.getFloat(index, dVar.c);
                    break;
                case 8:
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, dVar.e);
                    dVar.e = resourceId2;
                    if (resourceId2 == -1) {
                        dVar.e = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 9:
                    int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, dVar.f);
                    dVar.f = resourceId3;
                    if (resourceId3 == -1) {
                        dVar.f = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 10:
                    int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, dVar.g);
                    dVar.g = resourceId4;
                    if (resourceId4 == -1) {
                        dVar.g = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 11:
                    int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, dVar.h);
                    dVar.h = resourceId5;
                    if (resourceId5 == -1) {
                        dVar.h = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 12:
                    int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, dVar.i);
                    dVar.i = resourceId6;
                    if (resourceId6 == -1) {
                        dVar.i = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 13:
                    int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, dVar.j);
                    dVar.j = resourceId7;
                    if (resourceId7 == -1) {
                        dVar.j = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 14:
                    int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, dVar.k);
                    dVar.k = resourceId8;
                    if (resourceId8 == -1) {
                        dVar.k = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 15:
                    int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, dVar.l);
                    dVar.l = resourceId9;
                    if (resourceId9 == -1) {
                        dVar.l = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 16:
                    int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, dVar.m);
                    dVar.m = resourceId10;
                    if (resourceId10 == -1) {
                        dVar.m = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 17:
                    int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, dVar.s);
                    dVar.s = resourceId11;
                    if (resourceId11 == -1) {
                        dVar.s = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 18:
                    int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, dVar.t);
                    dVar.t = resourceId12;
                    if (resourceId12 == -1) {
                        dVar.t = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 19:
                    int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, dVar.u);
                    dVar.u = resourceId13;
                    if (resourceId13 == -1) {
                        dVar.u = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 20:
                    int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, dVar.v);
                    dVar.v = resourceId14;
                    if (resourceId14 == -1) {
                        dVar.v = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 21:
                    dVar.w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dVar.w);
                    break;
                case 22:
                    dVar.x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dVar.x);
                    break;
                case 23:
                    dVar.y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dVar.y);
                    break;
                case 24:
                    dVar.z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dVar.z);
                    break;
                case 25:
                    dVar.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dVar.A);
                    break;
                case 26:
                    dVar.B = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dVar.B);
                    break;
                case 27:
                    dVar.W = typedArrayObtainStyledAttributes.getBoolean(index, dVar.W);
                    break;
                case 28:
                    dVar.X = typedArrayObtainStyledAttributes.getBoolean(index, dVar.X);
                    break;
                case 29:
                    dVar.E = typedArrayObtainStyledAttributes.getFloat(index, dVar.E);
                    break;
                case 30:
                    dVar.F = typedArrayObtainStyledAttributes.getFloat(index, dVar.F);
                    break;
                case 31:
                    int i3 = typedArrayObtainStyledAttributes.getInt(index, 0);
                    dVar.L = i3;
                    if (i3 == 1) {
                        Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                    }
                    break;
                case 32:
                    int i4 = typedArrayObtainStyledAttributes.getInt(index, 0);
                    dVar.M = i4;
                    if (i4 == 1) {
                        Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                    }
                    break;
                case 33:
                    try {
                        dVar.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dVar.N);
                    } catch (Exception unused) {
                        if (typedArrayObtainStyledAttributes.getInt(index, dVar.N) == -2) {
                            dVar.N = -2;
                        }
                    }
                    break;
                case 34:
                    try {
                        dVar.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dVar.P);
                    } catch (Exception unused2) {
                        if (typedArrayObtainStyledAttributes.getInt(index, dVar.P) == -2) {
                            dVar.P = -2;
                        }
                    }
                    break;
                case 35:
                    dVar.R = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, dVar.R));
                    dVar.L = 2;
                    break;
                case 36:
                    try {
                        dVar.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dVar.O);
                    } catch (Exception unused3) {
                        if (typedArrayObtainStyledAttributes.getInt(index, dVar.O) == -2) {
                            dVar.O = -2;
                        }
                    }
                    break;
                case 37:
                    try {
                        dVar.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dVar.Q);
                    } catch (Exception unused4) {
                        if (typedArrayObtainStyledAttributes.getInt(index, dVar.Q) == -2) {
                            dVar.Q = -2;
                        }
                    }
                    break;
                case 38:
                    dVar.S = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, dVar.S));
                    dVar.M = 2;
                    break;
                default:
                    switch (i2) {
                        case 44:
                            o.j(dVar, typedArrayObtainStyledAttributes.getString(index));
                            break;
                        case 45:
                            dVar.H = typedArrayObtainStyledAttributes.getFloat(index, dVar.H);
                            break;
                        case 46:
                            dVar.I = typedArrayObtainStyledAttributes.getFloat(index, dVar.I);
                            break;
                        case 47:
                            dVar.J = typedArrayObtainStyledAttributes.getInt(index, 0);
                            break;
                        case m.g /* 48 */:
                            dVar.K = typedArrayObtainStyledAttributes.getInt(index, 0);
                            break;
                        case 49:
                            dVar.T = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, dVar.T);
                            break;
                        case 50:
                            dVar.U = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, dVar.U);
                            break;
                        case 51:
                            dVar.Y = typedArrayObtainStyledAttributes.getString(index);
                            break;
                        case 52:
                            int resourceId15 = typedArrayObtainStyledAttributes.getResourceId(index, dVar.n);
                            dVar.n = resourceId15;
                            if (resourceId15 == -1) {
                                dVar.n = typedArrayObtainStyledAttributes.getInt(index, -1);
                            }
                            break;
                        case 53:
                            int resourceId16 = typedArrayObtainStyledAttributes.getResourceId(index, dVar.o);
                            dVar.o = resourceId16;
                            if (resourceId16 == -1) {
                                dVar.o = typedArrayObtainStyledAttributes.getInt(index, -1);
                            }
                            break;
                        case 54:
                            dVar.D = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dVar.D);
                            break;
                        case 55:
                            dVar.C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dVar.C);
                            break;
                        default:
                            switch (i2) {
                                case 64:
                                    o.i(dVar, typedArrayObtainStyledAttributes, index, 0);
                                    break;
                                case 65:
                                    o.i(dVar, typedArrayObtainStyledAttributes, index, 1);
                                    break;
                                case 66:
                                    dVar.Z = typedArrayObtainStyledAttributes.getInt(index, dVar.Z);
                                    break;
                                case 67:
                                    dVar.d = typedArrayObtainStyledAttributes.getBoolean(index, dVar.d);
                                    break;
                            }
                            break;
                    }
                    break;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        dVar.a();
        return dVar;
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new e();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = IntCompanionObject.MAX_VALUE;
        this.mMaxHeight = IntCompanionObject.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = FTPReply.PATHNAME_CREATED;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new a6.e(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        a(attributeSet, i, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new e();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = IntCompanionObject.MAX_VALUE;
        this.mMaxHeight = IntCompanionObject.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = FTPReply.PATHNAME_CREATED;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new a6.e(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        a(attributeSet, i, i2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        a6.d dVar = new a6.d(layoutParams);
        dVar.a = -1;
        dVar.b = -1;
        dVar.c = -1.0f;
        dVar.d = true;
        dVar.e = -1;
        dVar.f = -1;
        dVar.g = -1;
        dVar.h = -1;
        dVar.i = -1;
        dVar.j = -1;
        dVar.k = -1;
        dVar.l = -1;
        dVar.m = -1;
        dVar.n = -1;
        dVar.o = -1;
        dVar.p = -1;
        dVar.q = 0;
        dVar.r = 0.0f;
        dVar.s = -1;
        dVar.t = -1;
        dVar.u = -1;
        dVar.v = -1;
        dVar.w = IntCompanionObject.MIN_VALUE;
        dVar.x = IntCompanionObject.MIN_VALUE;
        dVar.y = IntCompanionObject.MIN_VALUE;
        dVar.z = IntCompanionObject.MIN_VALUE;
        dVar.A = IntCompanionObject.MIN_VALUE;
        dVar.B = IntCompanionObject.MIN_VALUE;
        dVar.C = IntCompanionObject.MIN_VALUE;
        dVar.D = 0;
        dVar.E = 0.5f;
        dVar.F = 0.5f;
        dVar.G = null;
        dVar.H = -1.0f;
        dVar.I = -1.0f;
        dVar.J = 0;
        dVar.K = 0;
        dVar.L = 0;
        dVar.M = 0;
        dVar.N = 0;
        dVar.O = 0;
        dVar.P = 0;
        dVar.Q = 0;
        dVar.R = 1.0f;
        dVar.S = 1.0f;
        dVar.T = -1;
        dVar.U = -1;
        dVar.V = -1;
        dVar.W = false;
        dVar.X = false;
        dVar.Y = null;
        dVar.Z = 0;
        dVar.a0 = true;
        dVar.b0 = true;
        dVar.c0 = false;
        dVar.d0 = false;
        dVar.e0 = false;
        dVar.f0 = -1;
        dVar.g0 = -1;
        dVar.h0 = -1;
        dVar.i0 = -1;
        dVar.j0 = IntCompanionObject.MIN_VALUE;
        dVar.k0 = IntCompanionObject.MIN_VALUE;
        dVar.l0 = 0.5f;
        dVar.p0 = new d();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) dVar).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) dVar).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) dVar).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) dVar).bottomMargin = marginLayoutParams.bottomMargin;
            dVar.setMarginStart(marginLayoutParams.getMarginStart());
            dVar.setMarginEnd(marginLayoutParams.getMarginEnd());
        }
        if (!(layoutParams instanceof a6.d)) {
            return dVar;
        }
        a6.d dVar2 = (a6.d) layoutParams;
        dVar.a = dVar2.a;
        dVar.b = dVar2.b;
        dVar.c = dVar2.c;
        dVar.d = dVar2.d;
        dVar.e = dVar2.e;
        dVar.f = dVar2.f;
        dVar.g = dVar2.g;
        dVar.h = dVar2.h;
        dVar.i = dVar2.i;
        dVar.j = dVar2.j;
        dVar.k = dVar2.k;
        dVar.l = dVar2.l;
        dVar.m = dVar2.m;
        dVar.n = dVar2.n;
        dVar.o = dVar2.o;
        dVar.p = dVar2.p;
        dVar.q = dVar2.q;
        dVar.r = dVar2.r;
        dVar.s = dVar2.s;
        dVar.t = dVar2.t;
        dVar.u = dVar2.u;
        dVar.v = dVar2.v;
        dVar.w = dVar2.w;
        dVar.x = dVar2.x;
        dVar.y = dVar2.y;
        dVar.z = dVar2.z;
        dVar.A = dVar2.A;
        dVar.B = dVar2.B;
        dVar.C = dVar2.C;
        dVar.D = dVar2.D;
        dVar.E = dVar2.E;
        dVar.F = dVar2.F;
        dVar.G = dVar2.G;
        dVar.H = dVar2.H;
        dVar.I = dVar2.I;
        dVar.J = dVar2.J;
        dVar.K = dVar2.K;
        dVar.W = dVar2.W;
        dVar.X = dVar2.X;
        dVar.L = dVar2.L;
        dVar.M = dVar2.M;
        dVar.N = dVar2.N;
        dVar.P = dVar2.P;
        dVar.O = dVar2.O;
        dVar.Q = dVar2.Q;
        dVar.R = dVar2.R;
        dVar.S = dVar2.S;
        dVar.T = dVar2.T;
        dVar.U = dVar2.U;
        dVar.V = dVar2.V;
        dVar.a0 = dVar2.a0;
        dVar.b0 = dVar2.b0;
        dVar.c0 = dVar2.c0;
        dVar.d0 = dVar2.d0;
        dVar.f0 = dVar2.f0;
        dVar.g0 = dVar2.g0;
        dVar.h0 = dVar2.h0;
        dVar.i0 = dVar2.i0;
        dVar.j0 = dVar2.j0;
        dVar.k0 = dVar2.k0;
        dVar.l0 = dVar2.l0;
        dVar.Y = dVar2.Y;
        dVar.Z = dVar2.Z;
        dVar.p0 = dVar2.p0;
        return dVar;
    }
}
