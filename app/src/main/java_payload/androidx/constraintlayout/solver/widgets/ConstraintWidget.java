/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import androidx.constraintlayout.solver.widgets.analyzer.ChainRun;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ConstraintWidget {
    public static final int ANCHOR_BASELINE = 4;
    public static final int ANCHOR_BOTTOM = 3;
    public static final int ANCHOR_LEFT = 0;
    public static final int ANCHOR_RIGHT = 1;
    public static final int ANCHOR_TOP = 2;
    private static final boolean AUTOTAG_CENTER = false;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.0f;
    static final int DIMENSION_HORIZONTAL = 0;
    static final int DIMENSION_VERTICAL = 1;
    protected static final int DIRECT = 2;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    protected static final int SOLVER = 1;
    public static final int UNKNOWN = -1;
    private static final boolean USE_WRAP_DIMENSION_FOR_SPREAD = false;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    private static final int WRAP = -2;
    private boolean hasBaseline = false;
    public ChainRun horizontalChainRun;
    public HorizontalWidgetRun horizontalRun;
    private boolean inPlaceholder;
    public boolean[] isTerminalWidget;
    protected ArrayList<ConstraintAnchor> mAnchors;
    ConstraintAnchor mBaseline;
    int mBaselineDistance = 0;
    public ConstraintAnchor mBottom;
    boolean mBottomHasCentered;
    ConstraintAnchor mCenter;
    ConstraintAnchor mCenterX;
    ConstraintAnchor mCenterY;
    private float mCircleConstraintAngle = 0.0f;
    private Object mCompanionWidget;
    private int mContainerItemSkip = 0;
    private String mDebugName = null;
    public float mDimensionRatio = 0.0f;
    protected int mDimensionRatioSide = -1;
    int mDistToBottom;
    int mDistToLeft;
    int mDistToRight;
    int mDistToTop;
    boolean mGroupsToSolver = false;
    int mHeight = 0;
    float mHorizontalBiasPercent;
    boolean mHorizontalChainFixedPosition;
    int mHorizontalChainStyle = 0;
    ConstraintWidget mHorizontalNextWidget = null;
    public int mHorizontalResolution = -1;
    boolean mHorizontalWrapVisited;
    private boolean mInVirtuaLayout = false;
    public boolean mIsHeightWrapContent;
    private boolean[] mIsInBarrier;
    public boolean mIsWidthWrapContent;
    public ConstraintAnchor mLeft;
    boolean mLeftHasCentered;
    public ConstraintAnchor[] mListAnchors;
    public DimensionBehaviour[] mListDimensionBehaviors;
    protected ConstraintWidget[] mListNextMatchConstraintsWidget;
    public int mMatchConstraintDefaultHeight = 0;
    public int mMatchConstraintDefaultWidth = 0;
    public int mMatchConstraintMaxHeight = 0;
    public int mMatchConstraintMaxWidth = 0;
    public int mMatchConstraintMinHeight = 0;
    public int mMatchConstraintMinWidth = 0;
    public float mMatchConstraintPercentHeight = 1.0f;
    public float mMatchConstraintPercentWidth = 1.0f;
    private int[] mMaxDimension;
    protected int mMinHeight;
    protected int mMinWidth;
    protected ConstraintWidget[] mNextChainWidget;
    protected int mOffsetX = 0;
    protected int mOffsetY = 0;
    boolean mOptimizerMeasurable = false;
    public ConstraintWidget mParent = null;
    int mRelX = 0;
    int mRelY = 0;
    float mResolvedDimensionRatio = 1.0f;
    int mResolvedDimensionRatioSide = -1;
    boolean mResolvedHasRatio = false;
    public int[] mResolvedMatchConstraintDefault;
    public ConstraintAnchor mRight;
    boolean mRightHasCentered;
    public ConstraintAnchor mTop;
    boolean mTopHasCentered;
    private String mType = null;
    float mVerticalBiasPercent;
    boolean mVerticalChainFixedPosition;
    int mVerticalChainStyle = 0;
    ConstraintWidget mVerticalNextWidget = null;
    public int mVerticalResolution = -1;
    boolean mVerticalWrapVisited;
    private int mVisibility = 0;
    public float[] mWeight;
    int mWidth = 0;
    protected int mX = 0;
    protected int mY = 0;
    public boolean measured = false;
    public WidgetRun[] run = new WidgetRun[2];
    public ChainRun verticalChainRun;
    public VerticalWidgetRun verticalRun;
    public int[] wrapMeasure;

    static {
        DEFAULT_BIAS = 0.5f;
    }

    public ConstraintWidget() {
        this.horizontalRun = new HorizontalWidgetRun(this);
        this.verticalRun = new VerticalWidgetRun(this);
        this.isTerminalWidget = new boolean[]{true, true};
        this.wrapMeasure = new int[]{0, 0, 0, 0};
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        this.mCenter = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, this.mCenter};
        this.mAnchors = new ArrayList();
        this.mIsInBarrier = new boolean[2];
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mHorizontalBiasPercent = DEFAULT_BIAS;
        this.mVerticalBiasPercent = DEFAULT_BIAS;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.addAnchors();
    }

    public ConstraintWidget(int n, int n2) {
        this(0, 0, n, n2);
    }

    public ConstraintWidget(int n, int n2, int n3, int n4) {
        this.horizontalRun = new HorizontalWidgetRun(this);
        this.verticalRun = new VerticalWidgetRun(this);
        this.isTerminalWidget = new boolean[]{true, true};
        this.wrapMeasure = new int[]{0, 0, 0, 0};
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        this.mCenter = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, this.mCenter};
        this.mAnchors = new ArrayList();
        this.mIsInBarrier = new boolean[2];
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mHorizontalBiasPercent = DEFAULT_BIAS;
        this.mVerticalBiasPercent = DEFAULT_BIAS;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mX = n;
        this.mY = n2;
        this.mWidth = n3;
        this.mHeight = n4;
        this.addAnchors();
    }

    private void addAnchors() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    private void applyConstraints(LinearSystem linearSystem, boolean bl, boolean bl2, boolean bl3, boolean bl4, SolverVariable object, SolverVariable solverVariable, DimensionBehaviour object2, boolean bl5, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int n, int n2, int n3, int n4, float f, boolean bl6, boolean bl7, boolean bl8, boolean bl9, int n5, int n6, int n7, int n8, float f2, boolean bl10) {
        int n9;
        SolverVariable solverVariable2;
        SolverVariable solverVariable3;
        block105: {
            SolverVariable solverVariable4;
            block107: {
                block110: {
                    int n10;
                    SolverVariable solverVariable5;
                    block111: {
                        block114: {
                            block115: {
                                ConstraintWidget constraintWidget;
                                Object object3;
                                Object object4;
                                block112: {
                                    block113: {
                                        int n11;
                                        boolean bl11;
                                        boolean bl12;
                                        block109: {
                                            block108: {
                                                block106: {
                                                    solverVariable3 = linearSystem.createObjectVariable(constraintAnchor);
                                                    solverVariable2 = linearSystem.createObjectVariable(constraintAnchor2);
                                                    solverVariable5 = linearSystem.createObjectVariable(constraintAnchor.getTarget());
                                                    solverVariable4 = linearSystem.createObjectVariable(constraintAnchor2.getTarget());
                                                    if (LinearSystem.getMetrics() != null) {
                                                        object4 = LinearSystem.getMetrics();
                                                        ++((Metrics)object4).nonresolvedWidgets;
                                                    }
                                                    bl12 = constraintAnchor.isConnected();
                                                    bl11 = constraintAnchor2.isConnected();
                                                    boolean bl13 = this.mCenter.isConnected();
                                                    n11 = 0;
                                                    n10 = 0;
                                                    if (bl12) {
                                                        n10 = 0 + 1;
                                                    }
                                                    n9 = n10;
                                                    if (bl11) {
                                                        n9 = n10 + 1;
                                                    }
                                                    if (bl13) {
                                                        ++n9;
                                                    }
                                                    n10 = bl6 ? 3 : n5;
                                                    switch (object2) {
                                                        default: {
                                                            n5 = n11;
                                                            break;
                                                        }
                                                        case MATCH_CONSTRAINT: {
                                                            if (n10 == 4) {
                                                                n5 = 0;
                                                                break;
                                                            }
                                                            n5 = 1;
                                                            break;
                                                        }
                                                        case MATCH_PARENT: {
                                                            n5 = 0;
                                                            break;
                                                        }
                                                        case WRAP_CONTENT: {
                                                            n5 = 0;
                                                            break;
                                                        }
                                                        case FIXED: {
                                                            n5 = 0;
                                                        }
                                                    }
                                                    if (this.mVisibility == 8) {
                                                        n5 = 0;
                                                        n2 = 0;
                                                    } else {
                                                        n11 = n2;
                                                        n2 = n5;
                                                        n5 = n11;
                                                    }
                                                    if (bl10) {
                                                        if (!(bl12 || bl11 || bl13)) {
                                                            linearSystem.addEquality(solverVariable3, n);
                                                        } else if (bl12 && !bl11) {
                                                            linearSystem.addEquality(solverVariable3, solverVariable5, constraintAnchor.getMargin(), 8);
                                                        }
                                                    }
                                                    if (n2 == 0) {
                                                        if (bl5) {
                                                            linearSystem.addEquality(solverVariable2, solverVariable3, 0, 3);
                                                            if (n3 > 0) {
                                                                linearSystem.addGreaterThan(solverVariable2, solverVariable3, n3, 8);
                                                            }
                                                            if (n4 < Integer.MAX_VALUE) {
                                                                linearSystem.addLowerThan(solverVariable2, solverVariable3, n4, 8);
                                                            }
                                                        } else {
                                                            linearSystem.addEquality(solverVariable2, solverVariable3, n5, 8);
                                                        }
                                                        n = n8;
                                                        n8 = n2;
                                                    } else if (!(n9 == 2 || bl6 || n10 != 1 && n10 != 0)) {
                                                        n = n2 = Math.max(n7, n5);
                                                        if (n8 > 0) {
                                                            n = Math.min(n8, n2);
                                                        }
                                                        linearSystem.addEquality(solverVariable2, solverVariable3, n, 8);
                                                        n = n8;
                                                        n8 = 0;
                                                    } else {
                                                        n = n7 == -2 ? n5 : n7;
                                                        n4 = n8 == -2 ? n5 : n8;
                                                        n7 = n5;
                                                        if (n5 > 0) {
                                                            n7 = n5;
                                                            if (n10 != 1) {
                                                                n7 = 0;
                                                            }
                                                        }
                                                        n5 = n7;
                                                        if (n > 0) {
                                                            linearSystem.addGreaterThan(solverVariable2, solverVariable3, n, 8);
                                                            n5 = Math.max(n7, n);
                                                        }
                                                        n7 = n5;
                                                        if (n4 > 0) {
                                                            n7 = n8 = 1;
                                                            if (bl2) {
                                                                n7 = n8;
                                                                if (n10 == 1) {
                                                                    n7 = 0;
                                                                }
                                                            }
                                                            if (n7 != 0) {
                                                                linearSystem.addLowerThan(solverVariable2, solverVariable3, n4, 8);
                                                            }
                                                            n7 = Math.min(n5, n4);
                                                        }
                                                        if (n10 == 1) {
                                                            if (bl2) {
                                                                linearSystem.addEquality(solverVariable2, solverVariable3, n7, 8);
                                                            } else if (bl7) {
                                                                linearSystem.addEquality(solverVariable2, solverVariable3, n7, 5);
                                                                linearSystem.addLowerThan(solverVariable2, solverVariable3, n7, 8);
                                                            } else {
                                                                linearSystem.addEquality(solverVariable2, solverVariable3, n7, 5);
                                                                linearSystem.addLowerThan(solverVariable2, solverVariable3, n7, 8);
                                                            }
                                                            n7 = n;
                                                            n = n4;
                                                            n8 = n2;
                                                        } else if (n10 == 2) {
                                                            if (constraintAnchor.getType() != ConstraintAnchor.Type.TOP && constraintAnchor.getType() != ConstraintAnchor.Type.BOTTOM) {
                                                                object2 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.LEFT));
                                                                object3 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.RIGHT));
                                                                object4 = object2;
                                                            } else {
                                                                object4 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.TOP));
                                                                object2 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.BOTTOM));
                                                                object3 = object2;
                                                            }
                                                            linearSystem.addConstraint(linearSystem.createRow().createRowDimensionRatio(solverVariable2, solverVariable3, (SolverVariable)object3, (SolverVariable)object4, f2));
                                                            n8 = 0;
                                                            n7 = n;
                                                            n = n4;
                                                        } else {
                                                            n7 = n;
                                                            bl4 = true;
                                                            n8 = n2;
                                                            n = n4;
                                                        }
                                                    }
                                                    if (!bl10 || bl7) break block105;
                                                    if (bl12 || bl11 || bl13) break block106;
                                                    object = solverVariable4;
                                                    break block107;
                                                }
                                                if (!bl12 || bl11) break block108;
                                                object = solverVariable4;
                                                break block107;
                                            }
                                            if (bl12 || !bl11) break block109;
                                            linearSystem.addEquality(solverVariable2, solverVariable4, -constraintAnchor2.getMargin(), 8);
                                            if (bl2) {
                                                linearSystem.addGreaterThan(solverVariable3, (SolverVariable)object, 0, 5);
                                                object = solverVariable4;
                                            } else {
                                                object = solverVariable4;
                                            }
                                            break block107;
                                        }
                                        if (!bl12 || !bl11) break block110;
                                        int n12 = 0;
                                        n11 = 0;
                                        n4 = 4;
                                        n9 = 6;
                                        n5 = 5;
                                        constraintWidget = constraintAnchor.mTarget.mOwner;
                                        object3 = constraintAnchor2.mTarget.mOwner;
                                        object4 = this.getParent();
                                        if (n8 != 0) {
                                            if (n10 == 0) {
                                                if (n == 0 && n7 == 0) {
                                                    n = 1;
                                                    n5 = 8;
                                                    n4 = 8;
                                                    n2 = 0;
                                                } else {
                                                    n2 = 1;
                                                    n4 = 5;
                                                    n5 = 5;
                                                    n = n12;
                                                }
                                                if (!(constraintWidget instanceof Barrier) && !(object3 instanceof Barrier)) {
                                                    n6 = n11;
                                                } else {
                                                    n4 = 4;
                                                    n6 = n11;
                                                }
                                            } else if (n10 == 1) {
                                                n6 = 1;
                                                n5 = 8;
                                                n = 0;
                                                n2 = 1;
                                            } else if (n10 == 3) {
                                                if (this.mResolvedDimensionRatioSide == -1) {
                                                    n6 = 1;
                                                    n5 = 8;
                                                    n4 = 5;
                                                    if (bl8) {
                                                        n4 = 5;
                                                        n9 = 4;
                                                        if (bl2) {
                                                            n9 = 5;
                                                            n2 = 1;
                                                            n = 1;
                                                        } else {
                                                            n2 = 1;
                                                            n = 1;
                                                        }
                                                    } else {
                                                        n9 = 8;
                                                        n2 = 1;
                                                        n = 1;
                                                    }
                                                } else {
                                                    n11 = 1;
                                                    if (bl6) {
                                                        n = n6 != 2 && n6 != 1 ? 0 : 1;
                                                        if (n == 0) {
                                                            n5 = 8;
                                                            n4 = 5;
                                                        }
                                                        n2 = 1;
                                                        n = 1;
                                                        n6 = n11;
                                                    } else {
                                                        n5 = 5;
                                                        if (n > 0) {
                                                            n4 = 5;
                                                            n2 = 1;
                                                            n = 1;
                                                            n6 = n11;
                                                        } else if (n == 0 && n7 == 0) {
                                                            if (!bl8) {
                                                                n4 = 8;
                                                                n2 = 1;
                                                                n = 1;
                                                                n6 = n11;
                                                            } else {
                                                                n5 = constraintWidget != object4 && object3 != object4 ? 4 : 5;
                                                                n4 = 4;
                                                                n2 = 1;
                                                                n = 1;
                                                                n6 = n11;
                                                            }
                                                        } else {
                                                            n2 = 1;
                                                            n = 1;
                                                            n6 = n11;
                                                        }
                                                    }
                                                }
                                            } else {
                                                n2 = 0;
                                                n = 0;
                                                n6 = n11;
                                            }
                                        } else {
                                            n6 = 1;
                                            n = 0;
                                            n2 = 1;
                                        }
                                        if (n6 != 0 && solverVariable5 == solverVariable4 && constraintWidget != object4) {
                                            n11 = 0;
                                            n6 = 0;
                                        } else {
                                            n12 = 1;
                                            n11 = n6;
                                            n6 = n12;
                                        }
                                        if (n2 != 0) {
                                            if (this.mVisibility == 8) {
                                                n9 = 4;
                                            }
                                            linearSystem.addCentering(solverVariable3, solverVariable5, constraintAnchor.getMargin(), f, solverVariable4, solverVariable2, constraintAnchor2.getMargin(), n9);
                                        }
                                        if (this.mVisibility == 8) {
                                            return;
                                        }
                                        if (n11 != 0) {
                                            n2 = bl2 && solverVariable5 != solverVariable4 && n8 == 0 && (constraintWidget instanceof Barrier || object3 instanceof Barrier) ? 6 : n5;
                                            linearSystem.addGreaterThan(solverVariable3, solverVariable5, constraintAnchor.getMargin(), n2);
                                            linearSystem.addLowerThan(solverVariable2, solverVariable4, -constraintAnchor2.getMargin(), n2);
                                            n5 = n2;
                                        }
                                        object2 = solverVariable4;
                                        if (bl2 && bl9 && !(constraintWidget instanceof Barrier) && !(object3 instanceof Barrier)) {
                                            n6 = 1;
                                            n5 = 6;
                                            n2 = 6;
                                        } else {
                                            n2 = n4;
                                        }
                                        if (n6 == 0) break block111;
                                        n4 = n2;
                                        if (n == 0) break block112;
                                        if (!bl8) break block113;
                                        n4 = n2;
                                        if (!bl3) break block112;
                                    }
                                    n = n2;
                                    if (constraintWidget == object4 || object3 == object4) {
                                        n = 6;
                                    }
                                    if (constraintWidget instanceof Guideline || object3 instanceof Guideline) {
                                        n = 5;
                                    }
                                    if (constraintWidget instanceof Barrier || object3 instanceof Barrier) {
                                        n = 5;
                                    }
                                    if (bl8) {
                                        n = 5;
                                    }
                                    n4 = Math.max(n, n2);
                                }
                                n = n4;
                                if (!bl2) break block114;
                                n = n2 = Math.min(n5, n4);
                                if (!bl6) break block114;
                                n = n2;
                                if (bl8) break block114;
                                if (constraintWidget == object4) break block115;
                                n = n2;
                                if (object3 != object4) break block114;
                            }
                            n = 4;
                        }
                        linearSystem.addEquality(solverVariable3, solverVariable5, constraintAnchor.getMargin(), n);
                        linearSystem.addEquality(solverVariable2, (SolverVariable)object2, -constraintAnchor2.getMargin(), n);
                    }
                    if (bl2) {
                        n = 0;
                        if (object == solverVariable5) {
                            n = constraintAnchor.getMargin();
                        }
                        if (solverVariable5 != object) {
                            linearSystem.addGreaterThan(solverVariable3, (SolverVariable)object, n, 5);
                        }
                    }
                    if (bl2 && n8 != 0 && n3 == 0 && n7 == 0) {
                        if (n8 != 0 && n10 == 3) {
                            linearSystem.addGreaterThan(solverVariable2, solverVariable3, 0, 8);
                        } else {
                            linearSystem.addGreaterThan(solverVariable2, solverVariable3, 0, 5);
                        }
                    }
                    break block107;
                }
                object = solverVariable4;
            }
            if (bl2 && bl4) {
                n = 0;
                if (constraintAnchor2.mTarget != null) {
                    n = constraintAnchor2.getMargin();
                }
                if (solverVariable4 != solverVariable) {
                    linearSystem.addGreaterThan(solverVariable, solverVariable2, n, 5);
                }
            }
            return;
        }
        if (n9 < 2 && bl2 && bl4) {
            linearSystem.addGreaterThan(solverVariable3, (SolverVariable)object, 0, 8);
            n2 = !bl && this.mBaseline.mTarget != null ? 0 : 1;
            n = n2;
            if (!bl) {
                n = n2;
                if (this.mBaseline.mTarget != null) {
                    object = this.mBaseline.mTarget.mOwner;
                    n = ((ConstraintWidget)object).mDimensionRatio != 0.0f && ((ConstraintWidget)object).mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && ((ConstraintWidget)object).mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT ? 1 : 0;
                }
            }
            if (n != 0) {
                linearSystem.addGreaterThan(solverVariable, solverVariable2, 0, 8);
            }
        }
    }

    private boolean isChainHead(int n) {
        boolean bl = this.mListAnchors[n *= 2].mTarget != null && this.mListAnchors[n].mTarget.mTarget != this.mListAnchors[n] && this.mListAnchors[n + 1].mTarget != null && this.mListAnchors[n + 1].mTarget.mTarget == this.mListAnchors[n + 1];
        return bl;
    }

    boolean addFirst() {
        boolean bl = this instanceof VirtualLayout || this instanceof Guideline;
        return bl;
    }

    public void addToSolver(LinearSystem linearSystem) {
        SolverVariable solverVariable;
        int n;
        boolean bl;
        int n2;
        int n3;
        int n4;
        boolean bl2;
        boolean bl3;
        boolean bl4;
        boolean bl5;
        boolean bl6;
        boolean bl7;
        Object object;
        SolverVariable solverVariable2;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        SolverVariable solverVariable5;
        SolverVariable solverVariable6;
        block49: {
            int n5;
            int n6;
            block47: {
                block45: {
                    block48: {
                        block46: {
                            solverVariable6 = linearSystem.createObjectVariable(this.mLeft);
                            solverVariable5 = linearSystem.createObjectVariable(this.mRight);
                            solverVariable4 = linearSystem.createObjectVariable(this.mTop);
                            solverVariable3 = linearSystem.createObjectVariable(this.mBottom);
                            solverVariable2 = linearSystem.createObjectVariable(this.mBaseline);
                            if (LinearSystem.sMetrics != null) {
                                object = LinearSystem.sMetrics;
                                ++((Metrics)object).widgets;
                            }
                            if (this.horizontalRun.start.resolved && this.horizontalRun.end.resolved && this.verticalRun.start.resolved && this.verticalRun.end.resolved) {
                                if (LinearSystem.sMetrics != null) {
                                    object = LinearSystem.sMetrics;
                                    ++((Metrics)object).graphSolved;
                                }
                                linearSystem.addEquality(solverVariable6, this.horizontalRun.start.value);
                                linearSystem.addEquality(solverVariable5, this.horizontalRun.end.value);
                                linearSystem.addEquality(solverVariable4, this.verticalRun.start.value);
                                linearSystem.addEquality(solverVariable3, this.verticalRun.end.value);
                                linearSystem.addEquality(solverVariable2, this.verticalRun.baseline.value);
                                if (this.mParent != null) {
                                    boolean bl8 = this.mParent != null && this.mParent.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT;
                                    boolean bl9 = this.mParent != null && this.mParent.mListDimensionBehaviors[1] == DimensionBehaviour.WRAP_CONTENT;
                                    if (bl8 && this.isTerminalWidget[0] && !this.isInHorizontalChain()) {
                                        linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mRight), solverVariable5, 0, 8);
                                    }
                                    if (bl9 && this.isTerminalWidget[1] && !this.isInVerticalChain()) {
                                        linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mBottom), solverVariable3, 0, 8);
                                    }
                                }
                                return;
                            }
                            if (LinearSystem.sMetrics != null) {
                                object = LinearSystem.sMetrics;
                                ++((Metrics)object).linearSolved;
                            }
                            if (this.mParent != null) {
                                bl7 = this.mParent != null && this.mParent.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT;
                                bl6 = this.mParent != null && this.mParent.mListDimensionBehaviors[1] == DimensionBehaviour.WRAP_CONTENT;
                                if (this.isChainHead(0)) {
                                    ((ConstraintWidgetContainer)this.mParent).addChain(this, 0);
                                    bl5 = true;
                                } else {
                                    bl5 = this.isInHorizontalChain();
                                }
                                if (this.isChainHead(1)) {
                                    ((ConstraintWidgetContainer)this.mParent).addChain(this, 1);
                                    bl4 = true;
                                } else {
                                    bl4 = this.isInVerticalChain();
                                }
                                if (!bl5 && bl7 && this.mVisibility != 8 && this.mLeft.mTarget == null && this.mRight.mTarget == null) {
                                    linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mRight), solverVariable5, 0, 1);
                                }
                                if (!bl4 && bl6 && this.mVisibility != 8 && this.mTop.mTarget == null && this.mBottom.mTarget == null && this.mBaseline == null) {
                                    linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mBottom), solverVariable3, 0, 1);
                                }
                                bl3 = bl4;
                                bl2 = bl6;
                                bl4 = bl7;
                            } else {
                                bl5 = false;
                                bl3 = false;
                                bl4 = false;
                                bl2 = false;
                            }
                            n3 = n4 = this.mWidth;
                            if (n4 < this.mMinWidth) {
                                n3 = this.mMinWidth;
                            }
                            n2 = n4 = this.mHeight;
                            if (n4 < this.mMinHeight) {
                                n2 = this.mMinHeight;
                            }
                            bl7 = this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT;
                            bl6 = this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT;
                            bl = false;
                            this.mResolvedDimensionRatioSide = this.mDimensionRatioSide;
                            this.mResolvedDimensionRatio = this.mDimensionRatio;
                            n6 = this.mMatchConstraintDefaultWidth;
                            n5 = this.mMatchConstraintDefaultHeight;
                            if (!(this.mDimensionRatio > 0.0f) || this.mVisibility == 8) break block45;
                            bl = true;
                            n = n6;
                            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
                                n = n6;
                                if (n6 == 0) {
                                    n = 3;
                                }
                            }
                            n4 = n5;
                            if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
                                n4 = n5;
                                if (n5 == 0) {
                                    n4 = 3;
                                }
                            }
                            if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT || this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT || n != 3 || n4 != 3) break block46;
                            this.setupDimensionRatio(bl4, bl2, bl7, bl6);
                            bl7 = bl;
                            n6 = n;
                            n5 = n4;
                            break block47;
                        }
                        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT || n != 3) break block48;
                        this.mResolvedDimensionRatioSide = 0;
                        n6 = (int)(this.mResolvedDimensionRatio * (float)this.mHeight);
                        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
                            n = n2;
                            bl7 = false;
                            n5 = 4;
                            n3 = n4;
                            n2 = n6;
                            n4 = n;
                            n = n5;
                        } else {
                            n5 = n2;
                            bl7 = true;
                            n3 = n4;
                            n2 = n6;
                            n4 = n5;
                        }
                        break block49;
                    }
                    bl7 = bl;
                    n6 = n;
                    n5 = n4;
                    if (this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT) break block47;
                    bl7 = bl;
                    n6 = n;
                    n5 = n4;
                    if (n4 != 3) break block47;
                    this.mResolvedDimensionRatioSide = 1;
                    if (this.mDimensionRatioSide == -1) {
                        this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                    }
                    n5 = (int)(this.mResolvedDimensionRatio * (float)this.mWidth);
                    if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
                        n4 = n5;
                        bl7 = false;
                        n5 = 4;
                        n2 = n3;
                        n3 = n5;
                    } else {
                        bl7 = true;
                        n6 = n4;
                        n2 = n3;
                        n4 = n5;
                        n3 = n6;
                    }
                    break block49;
                }
                bl7 = bl;
            }
            n4 = n2;
            n = n6;
            n2 = n3;
            n3 = n5;
        }
        this.mResolvedMatchConstraintDefault[0] = n;
        this.mResolvedMatchConstraintDefault[1] = n3;
        this.mResolvedHasRatio = bl7;
        bl = bl7 && (this.mResolvedDimensionRatioSide == 0 || this.mResolvedDimensionRatioSide == -1);
        boolean bl10 = this.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT && this instanceof ConstraintWidgetContainer;
        if (bl10) {
            n2 = 0;
        }
        bl6 = !this.mCenter.isConnected();
        boolean bl11 = this.mIsInBarrier[0];
        boolean bl12 = this.mIsInBarrier[1];
        if (this.mHorizontalResolution != 2) {
            if (this.horizontalRun.start.resolved && this.horizontalRun.end.resolved) {
                linearSystem.addEquality(solverVariable6, this.horizontalRun.start.value);
                linearSystem.addEquality(solverVariable5, this.horizontalRun.end.value);
                if (this.mParent != null && bl4 && this.isTerminalWidget[0] && !this.isInHorizontalChain()) {
                    linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mRight), solverVariable5, 0, 8);
                }
            } else {
                object = this.mParent != null ? linearSystem.createObjectVariable(this.mParent.mRight) : null;
                solverVariable = this.mParent != null ? linearSystem.createObjectVariable(this.mParent.mLeft) : null;
                this.applyConstraints(linearSystem, true, bl4, bl2, this.isTerminalWidget[0], solverVariable, (SolverVariable)object, this.mListDimensionBehaviors[0], bl10, this.mLeft, this.mRight, this.mX, n2, this.mMinWidth, this.mMaxDimension[0], this.mHorizontalBiasPercent, bl, bl5, bl3, bl11, n, n3, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, bl6);
            }
        }
        n2 = 1;
        if (this.verticalRun.start.resolved && this.verticalRun.end.resolved) {
            n2 = this.verticalRun.start.value;
            linearSystem.addEquality(solverVariable4, n2);
            n2 = this.verticalRun.end.value;
            linearSystem.addEquality(solverVariable3, n2);
            linearSystem.addEquality(solverVariable2, this.verticalRun.baseline.value);
            if (this.mParent != null && !bl3 && bl2 && this.isTerminalWidget[1]) {
                linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mBottom), solverVariable3, 0, 8);
            }
            n2 = 0;
        }
        if (this.mVerticalResolution == 2) {
            n2 = 0;
        }
        if (n2 != 0) {
            bl = this.mListDimensionBehaviors[1] == DimensionBehaviour.WRAP_CONTENT && this instanceof ConstraintWidgetContainer;
            if (bl) {
                n4 = 0;
            }
            bl10 = bl7 && (this.mResolvedDimensionRatioSide == 1 || this.mResolvedDimensionRatioSide == -1);
            object = this.mParent != null ? linearSystem.createObjectVariable(this.mParent.mBottom) : null;
            solverVariable = this.mParent != null ? linearSystem.createObjectVariable(this.mParent.mTop) : null;
            if (this.mBaselineDistance > 0 || this.mVisibility == 8) {
                linearSystem.addEquality(solverVariable2, solverVariable4, this.getBaselineDistance(), 8);
                if (this.mBaseline.mTarget != null) {
                    linearSystem.addEquality(solverVariable2, linearSystem.createObjectVariable(this.mBaseline.mTarget), 0, 8);
                    bl6 = false;
                    if (bl2) {
                        linearSystem.addGreaterThan((SolverVariable)object, linearSystem.createObjectVariable(this.mBottom), 0, 5);
                    }
                } else if (this.mVisibility == 8) {
                    linearSystem.addEquality(solverVariable2, solverVariable4, 0, 8);
                }
            }
            this.applyConstraints(linearSystem, false, bl2, bl4, this.isTerminalWidget[1], solverVariable, (SolverVariable)object, this.mListDimensionBehaviors[1], bl, this.mTop, this.mBottom, this.mY, n4, this.mMinHeight, this.mMaxDimension[1], this.mVerticalBiasPercent, bl10, bl3, bl5, bl12, n3, n, this.mMatchConstraintMinHeight, this.mMatchConstraintMaxHeight, this.mMatchConstraintPercentHeight, bl6);
        }
        if (bl7) {
            if (this.mResolvedDimensionRatioSide == 1) {
                linearSystem.addRatio(solverVariable3, solverVariable4, solverVariable5, solverVariable6, this.mResolvedDimensionRatio, 8);
            } else {
                linearSystem.addRatio(solverVariable5, solverVariable6, solverVariable3, solverVariable4, this.mResolvedDimensionRatio, 8);
            }
        }
        if (this.mCenter.isConnected()) {
            linearSystem.addCenterPoint(this, this.mCenter.getTarget().getOwner(), (float)Math.toRadians(this.mCircleConstraintAngle + 90.0f), this.mCenter.getMargin());
        }
    }

    public boolean allowedInBarrier() {
        boolean bl = this.mVisibility != 8;
        return bl;
    }

    public void connect(ConstraintAnchor.Type type2, ConstraintWidget constraintWidget, ConstraintAnchor.Type type3) {
        this.connect(type2, constraintWidget, type3, 0);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void connect(ConstraintAnchor.Type object, ConstraintWidget object2, ConstraintAnchor.Type object3, int n) {
        int n2;
        ConstraintAnchor constraintAnchor;
        block34: {
            block36: {
                block35: {
                    block33: {
                        block27: {
                            block28: {
                                int n3;
                                block32: {
                                    int n4;
                                    block31: {
                                        ConstraintAnchor constraintAnchor2;
                                        block30: {
                                            block29: {
                                                if (object != ConstraintAnchor.Type.CENTER) break block27;
                                                if (object3 != ConstraintAnchor.Type.CENTER) break block28;
                                                ConstraintAnchor constraintAnchor3 = this.getAnchor(ConstraintAnchor.Type.LEFT);
                                                object3 = this.getAnchor(ConstraintAnchor.Type.RIGHT);
                                                constraintAnchor2 = this.getAnchor(ConstraintAnchor.Type.TOP);
                                                object = this.getAnchor(ConstraintAnchor.Type.BOTTOM);
                                                n3 = 0;
                                                n4 = 0;
                                                if (constraintAnchor3 == null) break block29;
                                                n = n3;
                                                if (constraintAnchor3.isConnected()) break block30;
                                            }
                                            if (object3 != null && ((ConstraintAnchor)object3).isConnected()) {
                                                n = n3;
                                            } else {
                                                this.connect(ConstraintAnchor.Type.LEFT, (ConstraintWidget)object2, ConstraintAnchor.Type.LEFT, 0);
                                                this.connect(ConstraintAnchor.Type.RIGHT, (ConstraintWidget)object2, ConstraintAnchor.Type.RIGHT, 0);
                                                n = 1;
                                            }
                                        }
                                        if (constraintAnchor2 == null) break block31;
                                        n3 = n4;
                                        if (constraintAnchor2.isConnected()) break block32;
                                    }
                                    if (object != null && ((ConstraintAnchor)object).isConnected()) {
                                        n3 = n4;
                                    } else {
                                        this.connect(ConstraintAnchor.Type.TOP, (ConstraintWidget)object2, ConstraintAnchor.Type.TOP, 0);
                                        this.connect(ConstraintAnchor.Type.BOTTOM, (ConstraintWidget)object2, ConstraintAnchor.Type.BOTTOM, 0);
                                        n3 = 1;
                                    }
                                }
                                if (n != 0 && n3 != 0) {
                                    this.getAnchor(ConstraintAnchor.Type.CENTER).connect(((ConstraintWidget)object2).getAnchor(ConstraintAnchor.Type.CENTER), 0);
                                    return;
                                }
                                if (n != 0) {
                                    this.getAnchor(ConstraintAnchor.Type.CENTER_X).connect(((ConstraintWidget)object2).getAnchor(ConstraintAnchor.Type.CENTER_X), 0);
                                    return;
                                }
                                if (n3 == 0) return;
                                this.getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(((ConstraintWidget)object2).getAnchor(ConstraintAnchor.Type.CENTER_Y), 0);
                                return;
                            }
                            if (object3 != ConstraintAnchor.Type.LEFT && object3 != ConstraintAnchor.Type.RIGHT) {
                                if (object3 != ConstraintAnchor.Type.TOP) {
                                    if (object3 != ConstraintAnchor.Type.BOTTOM) return;
                                }
                                this.connect(ConstraintAnchor.Type.TOP, (ConstraintWidget)object2, (ConstraintAnchor.Type)((Object)object3), 0);
                                this.connect(ConstraintAnchor.Type.BOTTOM, (ConstraintWidget)object2, (ConstraintAnchor.Type)((Object)object3), 0);
                                this.getAnchor(ConstraintAnchor.Type.CENTER).connect(((ConstraintWidget)object2).getAnchor((ConstraintAnchor.Type)((Object)object3)), 0);
                                return;
                            }
                            this.connect(ConstraintAnchor.Type.LEFT, (ConstraintWidget)object2, (ConstraintAnchor.Type)((Object)object3), 0);
                            this.connect(ConstraintAnchor.Type.RIGHT, (ConstraintWidget)object2, (ConstraintAnchor.Type)((Object)object3), 0);
                            this.getAnchor(ConstraintAnchor.Type.CENTER).connect(((ConstraintWidget)object2).getAnchor((ConstraintAnchor.Type)((Object)object3)), 0);
                            return;
                        }
                        if (object == ConstraintAnchor.Type.CENTER_X && (object3 == ConstraintAnchor.Type.LEFT || object3 == ConstraintAnchor.Type.RIGHT)) {
                            object = this.getAnchor(ConstraintAnchor.Type.LEFT);
                            object3 = ((ConstraintWidget)object2).getAnchor((ConstraintAnchor.Type)((Object)object3));
                            object2 = this.getAnchor(ConstraintAnchor.Type.RIGHT);
                            ((ConstraintAnchor)object).connect((ConstraintAnchor)object3, 0);
                            ((ConstraintAnchor)object2).connect((ConstraintAnchor)object3, 0);
                            this.getAnchor(ConstraintAnchor.Type.CENTER_X).connect((ConstraintAnchor)object3, 0);
                            return;
                        }
                        if (object == ConstraintAnchor.Type.CENTER_Y && (object3 == ConstraintAnchor.Type.TOP || object3 == ConstraintAnchor.Type.BOTTOM)) {
                            object = ((ConstraintWidget)object2).getAnchor((ConstraintAnchor.Type)((Object)object3));
                            this.getAnchor(ConstraintAnchor.Type.TOP).connect((ConstraintAnchor)object, 0);
                            this.getAnchor(ConstraintAnchor.Type.BOTTOM).connect((ConstraintAnchor)object, 0);
                            this.getAnchor(ConstraintAnchor.Type.CENTER_Y).connect((ConstraintAnchor)object, 0);
                            return;
                        }
                        if (object == ConstraintAnchor.Type.CENTER_X && object3 == ConstraintAnchor.Type.CENTER_X) {
                            this.getAnchor(ConstraintAnchor.Type.LEFT).connect(((ConstraintWidget)object2).getAnchor(ConstraintAnchor.Type.LEFT), 0);
                            this.getAnchor(ConstraintAnchor.Type.RIGHT).connect(((ConstraintWidget)object2).getAnchor(ConstraintAnchor.Type.RIGHT), 0);
                            this.getAnchor(ConstraintAnchor.Type.CENTER_X).connect(((ConstraintWidget)object2).getAnchor((ConstraintAnchor.Type)((Object)object3)), 0);
                            return;
                        }
                        if (object == ConstraintAnchor.Type.CENTER_Y && object3 == ConstraintAnchor.Type.CENTER_Y) {
                            this.getAnchor(ConstraintAnchor.Type.TOP).connect(((ConstraintWidget)object2).getAnchor(ConstraintAnchor.Type.TOP), 0);
                            this.getAnchor(ConstraintAnchor.Type.BOTTOM).connect(((ConstraintWidget)object2).getAnchor(ConstraintAnchor.Type.BOTTOM), 0);
                            this.getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(((ConstraintWidget)object2).getAnchor((ConstraintAnchor.Type)((Object)object3)), 0);
                            return;
                        }
                        constraintAnchor = this.getAnchor((ConstraintAnchor.Type)((Object)object));
                        if (!constraintAnchor.isValidConnection((ConstraintAnchor)(object2 = ((ConstraintWidget)object2).getAnchor((ConstraintAnchor.Type)((Object)object3))))) return;
                        if (object != ConstraintAnchor.Type.BASELINE) break block33;
                        object = this.getAnchor(ConstraintAnchor.Type.TOP);
                        object3 = this.getAnchor(ConstraintAnchor.Type.BOTTOM);
                        if (object != null) {
                            ((ConstraintAnchor)object).reset();
                        }
                        if (object3 != null) {
                            ((ConstraintAnchor)object3).reset();
                        }
                        n2 = 0;
                        break block34;
                    }
                    if (object == ConstraintAnchor.Type.TOP || object == ConstraintAnchor.Type.BOTTOM) break block35;
                    if (object != ConstraintAnchor.Type.LEFT && object != ConstraintAnchor.Type.RIGHT) break block36;
                    object3 = this.getAnchor(ConstraintAnchor.Type.CENTER);
                    if (((ConstraintAnchor)object3).getTarget() != object2) {
                        ((ConstraintAnchor)object3).reset();
                    }
                    object = this.getAnchor((ConstraintAnchor.Type)((Object)object)).getOpposite();
                    object3 = this.getAnchor(ConstraintAnchor.Type.CENTER_X);
                    n2 = n;
                    if (((ConstraintAnchor)object3).isConnected()) {
                        ((ConstraintAnchor)object).reset();
                        ((ConstraintAnchor)object3).reset();
                        n2 = n;
                    }
                    break block34;
                }
                object3 = this.getAnchor(ConstraintAnchor.Type.BASELINE);
                if (object3 != null) {
                    ((ConstraintAnchor)object3).reset();
                }
                if (((ConstraintAnchor)(object3 = this.getAnchor(ConstraintAnchor.Type.CENTER))).getTarget() != object2) {
                    ((ConstraintAnchor)object3).reset();
                }
                object = this.getAnchor((ConstraintAnchor.Type)((Object)object)).getOpposite();
                object3 = this.getAnchor(ConstraintAnchor.Type.CENTER_Y);
                if (((ConstraintAnchor)object3).isConnected()) {
                    ((ConstraintAnchor)object).reset();
                    ((ConstraintAnchor)object3).reset();
                }
            }
            n2 = n;
        }
        constraintAnchor.connect((ConstraintAnchor)object2, n2);
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int n) {
        if (constraintAnchor.getOwner() == this) {
            this.connect(constraintAnchor.getType(), constraintAnchor2.getOwner(), constraintAnchor2.getType(), n);
        }
    }

    public void connectCircularConstraint(ConstraintWidget constraintWidget, float f, int n) {
        this.immediateConnect(ConstraintAnchor.Type.CENTER, constraintWidget, ConstraintAnchor.Type.CENTER, n, 0);
        this.mCircleConstraintAngle = f;
    }

    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        this.mHorizontalResolution = constraintWidget.mHorizontalResolution;
        this.mVerticalResolution = constraintWidget.mVerticalResolution;
        this.mMatchConstraintDefaultWidth = constraintWidget.mMatchConstraintDefaultWidth;
        this.mMatchConstraintDefaultHeight = constraintWidget.mMatchConstraintDefaultHeight;
        this.mResolvedMatchConstraintDefault[0] = constraintWidget.mResolvedMatchConstraintDefault[0];
        this.mResolvedMatchConstraintDefault[1] = constraintWidget.mResolvedMatchConstraintDefault[1];
        this.mMatchConstraintMinWidth = constraintWidget.mMatchConstraintMinWidth;
        this.mMatchConstraintMaxWidth = constraintWidget.mMatchConstraintMaxWidth;
        this.mMatchConstraintMinHeight = constraintWidget.mMatchConstraintMinHeight;
        this.mMatchConstraintMaxHeight = constraintWidget.mMatchConstraintMaxHeight;
        this.mMatchConstraintPercentHeight = constraintWidget.mMatchConstraintPercentHeight;
        this.mIsWidthWrapContent = constraintWidget.mIsWidthWrapContent;
        this.mIsHeightWrapContent = constraintWidget.mIsHeightWrapContent;
        this.mResolvedDimensionRatioSide = constraintWidget.mResolvedDimensionRatioSide;
        this.mResolvedDimensionRatio = constraintWidget.mResolvedDimensionRatio;
        this.mMaxDimension = Arrays.copyOf(constraintWidget.mMaxDimension, constraintWidget.mMaxDimension.length);
        this.mCircleConstraintAngle = constraintWidget.mCircleConstraintAngle;
        this.hasBaseline = constraintWidget.hasBaseline;
        this.inPlaceholder = constraintWidget.inPlaceholder;
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mListDimensionBehaviors = Arrays.copyOf(this.mListDimensionBehaviors, 2);
        ConstraintWidget constraintWidget2 = this.mParent;
        Object var4_4 = null;
        constraintWidget2 = constraintWidget2 == null ? null : hashMap.get(constraintWidget.mParent);
        this.mParent = constraintWidget2;
        this.mWidth = constraintWidget.mWidth;
        this.mHeight = constraintWidget.mHeight;
        this.mDimensionRatio = constraintWidget.mDimensionRatio;
        this.mDimensionRatioSide = constraintWidget.mDimensionRatioSide;
        this.mX = constraintWidget.mX;
        this.mY = constraintWidget.mY;
        this.mRelX = constraintWidget.mRelX;
        this.mRelY = constraintWidget.mRelY;
        this.mOffsetX = constraintWidget.mOffsetX;
        this.mOffsetY = constraintWidget.mOffsetY;
        this.mBaselineDistance = constraintWidget.mBaselineDistance;
        this.mMinWidth = constraintWidget.mMinWidth;
        this.mMinHeight = constraintWidget.mMinHeight;
        this.mHorizontalBiasPercent = constraintWidget.mHorizontalBiasPercent;
        this.mVerticalBiasPercent = constraintWidget.mVerticalBiasPercent;
        this.mCompanionWidget = constraintWidget.mCompanionWidget;
        this.mContainerItemSkip = constraintWidget.mContainerItemSkip;
        this.mVisibility = constraintWidget.mVisibility;
        this.mDebugName = constraintWidget.mDebugName;
        this.mType = constraintWidget.mType;
        this.mDistToTop = constraintWidget.mDistToTop;
        this.mDistToLeft = constraintWidget.mDistToLeft;
        this.mDistToRight = constraintWidget.mDistToRight;
        this.mDistToBottom = constraintWidget.mDistToBottom;
        this.mLeftHasCentered = constraintWidget.mLeftHasCentered;
        this.mRightHasCentered = constraintWidget.mRightHasCentered;
        this.mTopHasCentered = constraintWidget.mTopHasCentered;
        this.mBottomHasCentered = constraintWidget.mBottomHasCentered;
        this.mHorizontalWrapVisited = constraintWidget.mHorizontalWrapVisited;
        this.mVerticalWrapVisited = constraintWidget.mVerticalWrapVisited;
        this.mOptimizerMeasurable = constraintWidget.mOptimizerMeasurable;
        this.mGroupsToSolver = constraintWidget.mGroupsToSolver;
        this.mHorizontalChainStyle = constraintWidget.mHorizontalChainStyle;
        this.mVerticalChainStyle = constraintWidget.mVerticalChainStyle;
        this.mHorizontalChainFixedPosition = constraintWidget.mHorizontalChainFixedPosition;
        this.mVerticalChainFixedPosition = constraintWidget.mVerticalChainFixedPosition;
        this.mWeight[0] = constraintWidget.mWeight[0];
        this.mWeight[1] = constraintWidget.mWeight[1];
        this.mListNextMatchConstraintsWidget[0] = constraintWidget.mListNextMatchConstraintsWidget[0];
        this.mListNextMatchConstraintsWidget[1] = constraintWidget.mListNextMatchConstraintsWidget[1];
        this.mNextChainWidget[0] = constraintWidget.mNextChainWidget[0];
        this.mNextChainWidget[1] = constraintWidget.mNextChainWidget[1];
        constraintWidget2 = constraintWidget.mHorizontalNextWidget == null ? null : hashMap.get(constraintWidget.mHorizontalNextWidget);
        this.mHorizontalNextWidget = constraintWidget2;
        constraintWidget = constraintWidget.mVerticalNextWidget == null ? var4_4 : hashMap.get(constraintWidget.mVerticalNextWidget);
        this.mVerticalNextWidget = constraintWidget;
    }

    public void createObjectVariables(LinearSystem linearSystem) {
        linearSystem.createObjectVariable(this.mLeft);
        linearSystem.createObjectVariable(this.mTop);
        linearSystem.createObjectVariable(this.mRight);
        linearSystem.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance > 0) {
            linearSystem.createObjectVariable(this.mBaseline);
        }
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type2) {
        switch (type2) {
            default: {
                throw new AssertionError((Object)type2.name());
            }
            case NONE: {
                return null;
            }
            case CENTER_Y: {
                return this.mCenterY;
            }
            case CENTER_X: {
                return this.mCenterX;
            }
            case CENTER: {
                return this.mCenter;
            }
            case BASELINE: {
                return this.mBaseline;
            }
            case BOTTOM: {
                return this.mBottom;
            }
            case RIGHT: {
                return this.mRight;
            }
            case TOP: {
                return this.mTop;
            }
            case LEFT: 
        }
        return this.mLeft;
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public float getBiasPercent(int n) {
        if (n == 0) {
            return this.mHorizontalBiasPercent;
        }
        if (n == 1) {
            return this.mVerticalBiasPercent;
        }
        return -1.0f;
    }

    public int getBottom() {
        return this.getY() + this.mHeight;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public DimensionBehaviour getDimensionBehaviour(int n) {
        if (n == 0) {
            return this.getHorizontalDimensionBehaviour();
        }
        if (n == 1) {
            return this.getVerticalDimensionBehaviour();
        }
        return null;
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public boolean getHasBaseline() {
        return this.hasBaseline;
    }

    public int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public float getHorizontalBiasPercent() {
        return this.mHorizontalBiasPercent;
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        Object object = null;
        Object object2 = null;
        if (this.isInHorizontalChain()) {
            Object object3 = this;
            while (true) {
                object = object2;
                if (object2 != null) break;
                object = object2;
                if (object3 == null) break;
                object = ((ConstraintWidget)object3).getAnchor(ConstraintAnchor.Type.LEFT);
                ConstraintAnchor constraintAnchor = null;
                object = object == null ? null : ((ConstraintAnchor)object).getTarget();
                if ((object = object == null ? null : ((ConstraintAnchor)object).getOwner()) == this.getParent()) {
                    object = object3;
                    break;
                }
                if (object != null) {
                    constraintAnchor = ((ConstraintWidget)object).getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
                }
                if (constraintAnchor != null && constraintAnchor.getOwner() != object3) {
                    object2 = object3;
                    continue;
                }
                object3 = object;
            }
        }
        return object;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public int getHorizontalMargin() {
        int n = 0;
        if (this.mLeft != null) {
            n = 0 + this.mLeft.mMargin;
        }
        int n2 = n;
        if (this.mRight != null) {
            n2 = n + this.mRight.mMargin;
        }
        return n2;
    }

    public int getLeft() {
        return this.getX();
    }

    public int getLength(int n) {
        if (n == 0) {
            return this.getWidth();
        }
        if (n == 1) {
            return this.getHeight();
        }
        return 0;
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public ConstraintWidget getNextChainMember(int n) {
        if (n == 0) {
            if (this.mRight.mTarget != null && this.mRight.mTarget.mTarget == this.mRight) {
                return this.mRight.mTarget.mOwner;
            }
        } else if (n == 1 && this.mBottom.mTarget != null && this.mBottom.mTarget.mTarget == this.mBottom) {
            return this.mBottom.mTarget.mOwner;
        }
        return null;
    }

    public int getOptimizerWrapHeight() {
        int n;
        int n2 = n = this.mHeight;
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            if (this.mMatchConstraintDefaultHeight == 1) {
                n = Math.max(this.mMatchConstraintMinHeight, n);
            } else if (this.mMatchConstraintMinHeight > 0) {
                this.mHeight = n = this.mMatchConstraintMinHeight;
            } else {
                n = 0;
            }
            n2 = n;
            if (this.mMatchConstraintMaxHeight > 0) {
                n2 = n;
                if (this.mMatchConstraintMaxHeight < n) {
                    n2 = this.mMatchConstraintMaxHeight;
                }
            }
        }
        return n2;
    }

    public int getOptimizerWrapWidth() {
        int n;
        int n2 = n = this.mWidth;
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
            if (this.mMatchConstraintDefaultWidth == 1) {
                n = Math.max(this.mMatchConstraintMinWidth, n);
            } else if (this.mMatchConstraintMinWidth > 0) {
                this.mWidth = n = this.mMatchConstraintMinWidth;
            } else {
                n = 0;
            }
            n2 = n;
            if (this.mMatchConstraintMaxWidth > 0) {
                n2 = n;
                if (this.mMatchConstraintMaxWidth < n) {
                    n2 = this.mMatchConstraintMaxWidth;
                }
            }
        }
        return n2;
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    public ConstraintWidget getPreviousChainMember(int n) {
        if (n == 0) {
            if (this.mLeft.mTarget != null && this.mLeft.mTarget.mTarget == this.mLeft) {
                return this.mLeft.mTarget.mOwner;
            }
        } else if (n == 1 && this.mTop.mTarget != null && this.mTop.mTarget.mTarget == this.mTop) {
            return this.mTop.mTarget.mOwner;
        }
        return null;
    }

    int getRelativePositioning(int n) {
        if (n == 0) {
            return this.mRelX;
        }
        if (n == 1) {
            return this.mRelY;
        }
        return 0;
    }

    public int getRight() {
        return this.getX() + this.mWidth;
    }

    protected int getRootX() {
        return this.mX + this.mOffsetX;
    }

    protected int getRootY() {
        return this.mY + this.mOffsetY;
    }

    public WidgetRun getRun(int n) {
        if (n == 0) {
            return this.horizontalRun;
        }
        if (n == 1) {
            return this.verticalRun;
        }
        return null;
    }

    public int getTop() {
        return this.getY();
    }

    public String getType() {
        return this.mType;
    }

    public float getVerticalBiasPercent() {
        return this.mVerticalBiasPercent;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        Object object = null;
        Object object2 = null;
        if (this.isInVerticalChain()) {
            Object object3 = this;
            while (true) {
                object = object2;
                if (object2 != null) break;
                object = object2;
                if (object3 == null) break;
                object = ((ConstraintWidget)object3).getAnchor(ConstraintAnchor.Type.TOP);
                ConstraintAnchor constraintAnchor = null;
                object = object == null ? null : ((ConstraintAnchor)object).getTarget();
                if ((object = object == null ? null : ((ConstraintAnchor)object).getOwner()) == this.getParent()) {
                    object = object3;
                    break;
                }
                if (object != null) {
                    constraintAnchor = ((ConstraintWidget)object).getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
                }
                if (constraintAnchor != null && constraintAnchor.getOwner() != object3) {
                    object2 = object3;
                    continue;
                }
                object3 = object;
            }
        }
        return object;
    }

    public int getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public int getVerticalMargin() {
        int n = 0;
        if (this.mLeft != null) {
            n = 0 + this.mTop.mMargin;
        }
        int n2 = n;
        if (this.mRight != null) {
            n2 = n + this.mBottom.mMargin;
        }
        return n2;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public int getX() {
        if (this.mParent != null && this.mParent instanceof ConstraintWidgetContainer) {
            return ((ConstraintWidgetContainer)this.mParent).mPaddingLeft + this.mX;
        }
        return this.mX;
    }

    public int getY() {
        if (this.mParent != null && this.mParent instanceof ConstraintWidgetContainer) {
            return ((ConstraintWidgetContainer)this.mParent).mPaddingTop + this.mY;
        }
        return this.mY;
    }

    public boolean hasBaseline() {
        return this.hasBaseline;
    }

    public void immediateConnect(ConstraintAnchor.Type type2, ConstraintWidget constraintWidget, ConstraintAnchor.Type type3, int n, int n2) {
        this.getAnchor(type2).connect(constraintWidget.getAnchor(type3), n, n2, true);
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public boolean isInHorizontalChain() {
        return this.mLeft.mTarget != null && this.mLeft.mTarget.mTarget == this.mLeft || this.mRight.mTarget != null && this.mRight.mTarget.mTarget == this.mRight;
    }

    public boolean isInPlaceholder() {
        return this.inPlaceholder;
    }

    public boolean isInVerticalChain() {
        return this.mTop.mTarget != null && this.mTop.mTarget.mTarget == this.mTop || this.mBottom.mTarget != null && this.mBottom.mTarget.mTarget == this.mBottom;
    }

    public boolean isInVirtualLayout() {
        return this.mInVirtuaLayout;
    }

    public boolean isRoot() {
        boolean bl = this.mParent == null;
        return bl;
    }

    public boolean isSpreadHeight() {
        boolean bl;
        block3: {
            block2: {
                if (this.mMatchConstraintDefaultHeight != 0 || this.mDimensionRatio != 0.0f || this.mMatchConstraintMinHeight != 0 || this.mMatchConstraintMaxHeight != 0) break block2;
                DimensionBehaviour[] dimensionBehaviourArray = this.mListDimensionBehaviors;
                bl = true;
                if (dimensionBehaviourArray[1] == DimensionBehaviour.MATCH_CONSTRAINT) break block3;
            }
            bl = false;
        }
        return bl;
    }

    public boolean isSpreadWidth() {
        boolean bl;
        int n = this.mMatchConstraintDefaultWidth;
        boolean bl2 = bl = false;
        if (n == 0) {
            bl2 = bl;
            if (this.mDimensionRatio == 0.0f) {
                bl2 = bl;
                if (this.mMatchConstraintMinWidth == 0) {
                    bl2 = bl;
                    if (this.mMatchConstraintMaxWidth == 0) {
                        bl2 = bl;
                        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
                            bl2 = true;
                        }
                    }
                }
            }
        }
        return bl2;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mHorizontalBiasPercent = DEFAULT_BIAS;
        this.mVerticalBiasPercent = DEFAULT_BIAS;
        this.mListDimensionBehaviors[0] = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors[1] = DimensionBehaviour.FIXED;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        this.mWeight[0] = -1.0f;
        this.mWeight[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMaxDimension[0] = Integer.MAX_VALUE;
        this.mMaxDimension[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedHasRatio = false;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mOptimizerMeasurable = false;
        this.mGroupsToSolver = false;
        this.isTerminalWidget[0] = true;
        this.isTerminalWidget[1] = true;
        this.mInVirtuaLayout = false;
        this.mIsInBarrier[0] = false;
        this.mIsInBarrier[1] = false;
    }

    public void resetAllConstraints() {
        this.resetAnchors();
        this.setVerticalBiasPercent(DEFAULT_BIAS);
        this.setHorizontalBiasPercent(DEFAULT_BIAS);
    }

    public void resetAnchor(ConstraintAnchor constraintAnchor) {
        if (this.getParent() != null && this.getParent() instanceof ConstraintWidgetContainer && ((ConstraintWidgetContainer)this.getParent()).handlesInternalConstraints()) {
            return;
        }
        ConstraintAnchor constraintAnchor2 = this.getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor constraintAnchor3 = this.getAnchor(ConstraintAnchor.Type.RIGHT);
        ConstraintAnchor constraintAnchor4 = this.getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor constraintAnchor5 = this.getAnchor(ConstraintAnchor.Type.BOTTOM);
        ConstraintAnchor constraintAnchor6 = this.getAnchor(ConstraintAnchor.Type.CENTER);
        ConstraintAnchor constraintAnchor7 = this.getAnchor(ConstraintAnchor.Type.CENTER_X);
        ConstraintAnchor constraintAnchor8 = this.getAnchor(ConstraintAnchor.Type.CENTER_Y);
        if (constraintAnchor == constraintAnchor6) {
            if (constraintAnchor2.isConnected() && constraintAnchor3.isConnected() && constraintAnchor2.getTarget() == constraintAnchor3.getTarget()) {
                constraintAnchor2.reset();
                constraintAnchor3.reset();
            }
            if (constraintAnchor4.isConnected() && constraintAnchor5.isConnected() && constraintAnchor4.getTarget() == constraintAnchor5.getTarget()) {
                constraintAnchor4.reset();
                constraintAnchor5.reset();
            }
            this.mHorizontalBiasPercent = 0.5f;
            this.mVerticalBiasPercent = 0.5f;
        } else if (constraintAnchor == constraintAnchor7) {
            if (constraintAnchor2.isConnected() && constraintAnchor3.isConnected() && constraintAnchor2.getTarget().getOwner() == constraintAnchor3.getTarget().getOwner()) {
                constraintAnchor2.reset();
                constraintAnchor3.reset();
            }
            this.mHorizontalBiasPercent = 0.5f;
        } else if (constraintAnchor == constraintAnchor8) {
            if (constraintAnchor4.isConnected() && constraintAnchor5.isConnected() && constraintAnchor4.getTarget().getOwner() == constraintAnchor5.getTarget().getOwner()) {
                constraintAnchor4.reset();
                constraintAnchor5.reset();
            }
            this.mVerticalBiasPercent = 0.5f;
        } else if (constraintAnchor != constraintAnchor2 && constraintAnchor != constraintAnchor3) {
            if ((constraintAnchor == constraintAnchor4 || constraintAnchor == constraintAnchor5) && constraintAnchor4.isConnected() && constraintAnchor4.getTarget() == constraintAnchor5.getTarget()) {
                constraintAnchor6.reset();
            }
        } else if (constraintAnchor2.isConnected() && constraintAnchor2.getTarget() == constraintAnchor3.getTarget()) {
            constraintAnchor6.reset();
        }
        constraintAnchor.reset();
    }

    public void resetAnchors() {
        ConstraintWidget constraintWidget = this.getParent();
        if (constraintWidget != null && constraintWidget instanceof ConstraintWidgetContainer && ((ConstraintWidgetContainer)this.getParent()).handlesInternalConstraints()) {
            return;
        }
        int n = this.mAnchors.size();
        for (int i = 0; i < n; ++i) {
            this.mAnchors.get(i).reset();
        }
    }

    public void resetSolverVariables(Cache cache2) {
        this.mLeft.resetSolverVariable(cache2);
        this.mTop.resetSolverVariable(cache2);
        this.mRight.resetSolverVariable(cache2);
        this.mBottom.resetSolverVariable(cache2);
        this.mBaseline.resetSolverVariable(cache2);
        this.mCenter.resetSolverVariable(cache2);
        this.mCenterX.resetSolverVariable(cache2);
        this.mCenterY.resetSolverVariable(cache2);
    }

    public void setBaselineDistance(int n) {
        this.mBaselineDistance = n;
        boolean bl = n > 0;
        this.hasBaseline = bl;
    }

    public void setCompanionWidget(Object object) {
        this.mCompanionWidget = object;
    }

    public void setContainerItemSkip(int n) {
        this.mContainerItemSkip = n >= 0 ? n : 0;
    }

    public void setDebugName(String string2) {
        this.mDebugName = string2;
    }

    public void setDebugSolverName(LinearSystem linearSystem, String string2) {
        this.mDebugName = string2;
        SolverVariable solverVariable = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable solverVariable2 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable solverVariable3 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable solverVariable4 = linearSystem.createObjectVariable(this.mBottom);
        solverVariable.setName(string2 + ".left");
        solverVariable2.setName(string2 + ".top");
        solverVariable3.setName(string2 + ".right");
        solverVariable4.setName(string2 + ".bottom");
        if (this.mBaselineDistance > 0) {
            linearSystem.createObjectVariable(this.mBaseline).setName(string2 + ".baseline");
        }
    }

    public void setDimension(int n, int n2) {
        this.mWidth = n;
        if (this.mWidth < this.mMinWidth) {
            this.mWidth = this.mMinWidth;
        }
        this.mHeight = n2;
        if (this.mHeight < this.mMinHeight) {
            this.mHeight = this.mMinHeight;
        }
    }

    public void setDimensionRatio(float f, int n) {
        this.mDimensionRatio = f;
        this.mDimensionRatioSide = n;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setDimensionRatio(String string2) {
        block13: {
            float f;
            int n;
            block15: {
                int n2;
                float f2;
                block14: {
                    float f3;
                    String string3;
                    if (string2 == null || string2.length() == 0) break block13;
                    n = -1;
                    float f4 = 0.0f;
                    f2 = 0.0f;
                    float f5 = 0.0f;
                    int n3 = string2.length();
                    int n4 = string2.indexOf(44);
                    if (n4 > 0 && n4 < n3 - 1) {
                        string3 = string2.substring(0, n4);
                        if (string3.equalsIgnoreCase("W")) {
                            n2 = 0;
                        } else {
                            n2 = n;
                            if (string3.equalsIgnoreCase("H")) {
                                n2 = 1;
                            }
                        }
                        n = n2;
                        n2 = ++n4;
                    } else {
                        n2 = 0;
                    }
                    n4 = string2.indexOf(58);
                    if (n4 < 0 || n4 >= n3 - 1) break block14;
                    string3 = string2.substring(n2, n4);
                    string2 = string2.substring(n4 + 1);
                    f = f4;
                    if (string3.length() <= 0) break block15;
                    f = f4;
                    if (string2.length() <= 0) break block15;
                    try {
                        f2 = Float.parseFloat(string3);
                        f3 = Float.parseFloat(string2);
                        f = f5;
                    }
                    catch (NumberFormatException numberFormatException) {
                        f = f4;
                    }
                    if (!(f2 > 0.0f)) break block15;
                    f = f5;
                    if (f3 > 0.0f) {
                        f = n == 1 ? Math.abs(f3 / f2) : Math.abs(f2 / f3);
                    }
                    break block15;
                }
                string2 = string2.substring(n2);
                f = f2;
                if (string2.length() > 0) {
                    try {
                        f = Float.parseFloat(string2);
                    }
                    catch (NumberFormatException numberFormatException) {
                        f = f2;
                    }
                }
            }
            if (f > 0.0f) {
                this.mDimensionRatio = f;
                this.mDimensionRatioSide = n;
            }
            return;
        }
        this.mDimensionRatio = 0.0f;
    }

    public void setFrame(int n, int n2, int n3) {
        if (n3 == 0) {
            this.setHorizontalDimension(n, n2);
        } else if (n3 == 1) {
            this.setVerticalDimension(n, n2);
        }
    }

    public void setFrame(int n, int n2, int n3, int n4) {
        int n5 = n3 - n;
        n3 = n4 - n2;
        this.mX = n;
        this.mY = n2;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        n = n5;
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED) {
            n = n5;
            if (n5 < this.mWidth) {
                n = this.mWidth;
            }
        }
        n2 = n3;
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED) {
            n2 = n3;
            if (n3 < this.mHeight) {
                n2 = this.mHeight;
            }
        }
        this.mWidth = n;
        this.mHeight = n2;
        if (this.mHeight < this.mMinHeight) {
            this.mHeight = this.mMinHeight;
        }
        if (this.mWidth < this.mMinWidth) {
            this.mWidth = this.mMinWidth;
        }
    }

    public void setGoneMargin(ConstraintAnchor.Type type2, int n) {
        switch (type2) {
            default: {
                break;
            }
            case BOTTOM: {
                this.mBottom.mGoneMargin = n;
                break;
            }
            case RIGHT: {
                this.mRight.mGoneMargin = n;
                break;
            }
            case TOP: {
                this.mTop.mGoneMargin = n;
                break;
            }
            case LEFT: {
                this.mLeft.mGoneMargin = n;
            }
        }
    }

    public void setHasBaseline(boolean bl) {
        this.hasBaseline = bl;
    }

    public void setHeight(int n) {
        this.mHeight = n;
        if (this.mHeight < this.mMinHeight) {
            this.mHeight = this.mMinHeight;
        }
    }

    public void setHeightWrapContent(boolean bl) {
        this.mIsHeightWrapContent = bl;
    }

    public void setHorizontalBiasPercent(float f) {
        this.mHorizontalBiasPercent = f;
    }

    public void setHorizontalChainStyle(int n) {
        this.mHorizontalChainStyle = n;
    }

    public void setHorizontalDimension(int n, int n2) {
        this.mX = n;
        this.mWidth = n2 - n;
        if (this.mWidth < this.mMinWidth) {
            this.mWidth = this.mMinWidth;
        }
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[0] = dimensionBehaviour;
    }

    public void setHorizontalMatchStyle(int n, int n2, int n3, float f) {
        this.mMatchConstraintDefaultWidth = n;
        this.mMatchConstraintMinWidth = n2;
        if (n3 == Integer.MAX_VALUE) {
            n3 = 0;
        }
        this.mMatchConstraintMaxWidth = n3;
        this.mMatchConstraintPercentWidth = f;
        if (f > 0.0f && f < 1.0f && this.mMatchConstraintDefaultWidth == 0) {
            this.mMatchConstraintDefaultWidth = 2;
        }
    }

    public void setHorizontalWeight(float f) {
        this.mWeight[0] = f;
    }

    protected void setInBarrier(int n, boolean bl) {
        this.mIsInBarrier[n] = bl;
    }

    public void setInPlaceholder(boolean bl) {
        this.inPlaceholder = bl;
    }

    public void setInVirtualLayout(boolean bl) {
        this.mInVirtuaLayout = bl;
    }

    public void setLength(int n, int n2) {
        if (n2 == 0) {
            this.setWidth(n);
        } else if (n2 == 1) {
            this.setHeight(n);
        }
    }

    public void setMaxHeight(int n) {
        this.mMaxDimension[1] = n;
    }

    public void setMaxWidth(int n) {
        this.mMaxDimension[0] = n;
    }

    public void setMinHeight(int n) {
        this.mMinHeight = n < 0 ? 0 : n;
    }

    public void setMinWidth(int n) {
        this.mMinWidth = n < 0 ? 0 : n;
    }

    public void setOffset(int n, int n2) {
        this.mOffsetX = n;
        this.mOffsetY = n2;
    }

    public void setOrigin(int n, int n2) {
        this.mX = n;
        this.mY = n2;
    }

    public void setParent(ConstraintWidget constraintWidget) {
        this.mParent = constraintWidget;
    }

    void setRelativePositioning(int n, int n2) {
        if (n2 == 0) {
            this.mRelX = n;
        } else if (n2 == 1) {
            this.mRelY = n;
        }
    }

    public void setType(String string2) {
        this.mType = string2;
    }

    public void setVerticalBiasPercent(float f) {
        this.mVerticalBiasPercent = f;
    }

    public void setVerticalChainStyle(int n) {
        this.mVerticalChainStyle = n;
    }

    public void setVerticalDimension(int n, int n2) {
        this.mY = n;
        this.mHeight = n2 - n;
        if (this.mHeight < this.mMinHeight) {
            this.mHeight = this.mMinHeight;
        }
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[1] = dimensionBehaviour;
    }

    public void setVerticalMatchStyle(int n, int n2, int n3, float f) {
        this.mMatchConstraintDefaultHeight = n;
        this.mMatchConstraintMinHeight = n2;
        if (n3 == Integer.MAX_VALUE) {
            n3 = 0;
        }
        this.mMatchConstraintMaxHeight = n3;
        this.mMatchConstraintPercentHeight = f;
        if (f > 0.0f && f < 1.0f && this.mMatchConstraintDefaultHeight == 0) {
            this.mMatchConstraintDefaultHeight = 2;
        }
    }

    public void setVerticalWeight(float f) {
        this.mWeight[1] = f;
    }

    public void setVisibility(int n) {
        this.mVisibility = n;
    }

    public void setWidth(int n) {
        this.mWidth = n;
        if (this.mWidth < this.mMinWidth) {
            this.mWidth = this.mMinWidth;
        }
    }

    public void setWidthWrapContent(boolean bl) {
        this.mIsWidthWrapContent = bl;
    }

    public void setX(int n) {
        this.mX = n;
    }

    public void setY(int n) {
        this.mY = n;
    }

    public void setupDimensionRatio(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        if (this.mResolvedDimensionRatioSide == -1) {
            if (bl3 && !bl4) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!bl3 && bl4) {
                this.mResolvedDimensionRatioSide = 1;
                if (this.mDimensionRatioSide == -1) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                }
            }
        }
        if (!(this.mResolvedDimensionRatioSide != 0 || this.mTop.isConnected() && this.mBottom.isConnected())) {
            this.mResolvedDimensionRatioSide = 1;
        } else if (!(this.mResolvedDimensionRatioSide != 1 || this.mLeft.isConnected() && this.mRight.isConnected())) {
            this.mResolvedDimensionRatioSide = 0;
        }
        if (!(this.mResolvedDimensionRatioSide != -1 || this.mTop.isConnected() && this.mBottom.isConnected() && this.mLeft.isConnected() && this.mRight.isConnected())) {
            if (this.mTop.isConnected() && this.mBottom.isConnected()) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mLeft.isConnected() && this.mRight.isConnected()) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            if (this.mMatchConstraintMinWidth > 0 && this.mMatchConstraintMinHeight == 0) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMinHeight > 0) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.mType;
        String string3 = "";
        string2 = string2 != null ? "type: " + this.mType + " " : "";
        stringBuilder = stringBuilder.append(string2);
        string2 = string3;
        if (this.mDebugName != null) {
            string2 = "id: " + this.mDebugName + " ";
        }
        return stringBuilder.append(string2).append("(").append(this.mX).append(", ").append(this.mY).append(") - (").append(this.mWidth).append(" x ").append(this.mHeight).append(")").toString();
    }

    public void updateFromRuns(boolean bl, boolean bl2) {
        int n;
        int n2;
        int n3;
        int n4;
        boolean bl3;
        boolean bl4;
        block15: {
            block14: {
                bl4 = bl & this.horizontalRun.isResolved();
                bl3 = bl2 & this.verticalRun.isResolved();
                n4 = this.horizontalRun.start.value;
                n3 = this.verticalRun.start.value;
                n2 = this.horizontalRun.end.value;
                int n5 = this.verticalRun.end.value;
                if (n2 - n4 < 0 || n5 - n3 < 0 || n4 == Integer.MIN_VALUE || n4 == Integer.MAX_VALUE || n3 == Integer.MIN_VALUE || n3 == Integer.MAX_VALUE || n2 == Integer.MIN_VALUE || n2 == Integer.MAX_VALUE || n5 == Integer.MIN_VALUE) break block14;
                n = n5;
                if (n5 != Integer.MAX_VALUE) break block15;
            }
            n4 = 0;
            n3 = 0;
            n2 = 0;
            n = 0;
        }
        n2 -= n4;
        n -= n3;
        if (bl4) {
            this.mX = n4;
        }
        if (bl3) {
            this.mY = n3;
        }
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (bl4) {
            n3 = n2;
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED) {
                n3 = n2;
                if (n2 < this.mWidth) {
                    n3 = this.mWidth;
                }
            }
            this.mWidth = n3;
            if (this.mWidth < this.mMinWidth) {
                this.mWidth = this.mMinWidth;
            }
        }
        if (bl3) {
            n3 = n;
            if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED) {
                n3 = n;
                if (n < this.mHeight) {
                    n3 = this.mHeight;
                }
            }
            this.mHeight = n3;
            if (this.mHeight < this.mMinHeight) {
                this.mHeight = this.mMinHeight;
            }
        }
    }

    public void updateFromSolver(LinearSystem linearSystem) {
        int n;
        int n2;
        int n3;
        int n4;
        block8: {
            block7: {
                int n5 = linearSystem.getObjectVariableValue(this.mLeft);
                n4 = linearSystem.getObjectVariableValue(this.mTop);
                n3 = linearSystem.getObjectVariableValue(this.mRight);
                int n6 = linearSystem.getObjectVariableValue(this.mBottom);
                n2 = n5;
                n = n3;
                if (this.horizontalRun.start.resolved) {
                    n2 = n5;
                    n = n3;
                    if (this.horizontalRun.end.resolved) {
                        n2 = this.horizontalRun.start.value;
                        n = this.horizontalRun.end.value;
                    }
                }
                n3 = n4;
                n5 = n6;
                if (this.verticalRun.start.resolved) {
                    n3 = n4;
                    n5 = n6;
                    if (this.verticalRun.end.resolved) {
                        n3 = this.verticalRun.start.value;
                        n5 = this.verticalRun.end.value;
                    }
                }
                if (n - n2 < 0 || n5 - n3 < 0 || n2 == Integer.MIN_VALUE || n2 == Integer.MAX_VALUE || n3 == Integer.MIN_VALUE || n3 == Integer.MAX_VALUE || n == Integer.MIN_VALUE || n == Integer.MAX_VALUE || n5 == Integer.MIN_VALUE) break block7;
                n4 = n3;
                n3 = n;
                n = n5;
                if (n5 != Integer.MAX_VALUE) break block8;
            }
            n2 = 0;
            n4 = 0;
            n3 = 0;
            n = 0;
        }
        this.setFrame(n2, n4, n3, n);
    }

    public static enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT;

    }
}

