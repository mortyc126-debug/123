/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ChainHead;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;

class Chain {
    private static final boolean DEBUG = false;

    Chain() {
    }

    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int n) {
        ChainHead[] chainHeadArray;
        int n2;
        int n3;
        if (n == 0) {
            n3 = 0;
            n2 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArray = constraintWidgetContainer.mHorizontalChainsArray;
        } else {
            n3 = 2;
            n2 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArray = constraintWidgetContainer.mVerticalChainsArray;
        }
        for (int i = 0; i < n2; ++i) {
            ChainHead chainHead = chainHeadArray[i];
            chainHead.define();
            Chain.applyChainConstraints(constraintWidgetContainer, linearSystem, n, n3, chainHead);
        }
    }

    static void applyChainConstraints(ConstraintWidgetContainer object, LinearSystem linearSystem, int n, int n2, ChainHead object2) {
        block76: {
            SolverVariable solverVariable;
            Object object3;
            Object object4;
            int n3;
            int n4;
            Object object5;
            int n5;
            int n6;
            int n7;
            int n8;
            ConstraintWidget constraintWidget = ((ChainHead)object2).mFirst;
            ConstraintWidget constraintWidget2 = ((ChainHead)object2).mLast;
            Object object6 = ((ChainHead)object2).mFirstVisibleWidget;
            ConstraintWidget constraintWidget3 = ((ChainHead)object2).mLastVisibleWidget;
            Object object7 = ((ChainHead)object2).mHead;
            float f = ((ChainHead)object2).mTotalWeight;
            Object object8 = ((ChainHead)object2).mFirstMatchConstraintWidget;
            Object object9 = ((ChainHead)object2).mLastMatchConstraintWidget;
            int n9 = ((ConstraintWidgetContainer)object).mListDimensionBehaviors[n] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT ? 1 : 0;
            if (n == 0) {
                n8 = ((ConstraintWidget)object7).mHorizontalChainStyle == 0 ? 1 : 0;
                n7 = ((ConstraintWidget)object7).mHorizontalChainStyle;
                n6 = n8;
                n8 = n7 == 1 ? 1 : 0;
                n7 = ((ConstraintWidget)object7).mHorizontalChainStyle == 2 ? 1 : 0;
                n5 = 0;
                object5 = constraintWidget;
                n4 = n8;
                n8 = n5;
                n3 = n7;
            } else {
                n8 = ((ConstraintWidget)object7).mVerticalChainStyle == 0 ? 1 : 0;
                n7 = ((ConstraintWidget)object7).mVerticalChainStyle;
                n6 = n8;
                n8 = n7 == 1 ? 1 : 0;
                n7 = ((ConstraintWidget)object7).mVerticalChainStyle == 2 ? 1 : 0;
                n5 = 0;
                object5 = constraintWidget;
                n4 = n8;
                n3 = n7;
                n8 = n5;
            }
            while (n8 == 0) {
                object4 = ((ConstraintWidget)object5).mListAnchors[n2];
                n7 = 4;
                if (n3 != 0) {
                    n7 = 1;
                }
                int n10 = ((ConstraintAnchor)object4).getMargin();
                boolean bl = ((ConstraintWidget)object5).mListDimensionBehaviors[n] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && ((ConstraintWidget)object5).mResolvedMatchConstraintDefault[n] == 0;
                if (((ConstraintAnchor)object4).mTarget != null && object5 != constraintWidget) {
                    n10 += ((ConstraintAnchor)object4).mTarget.getMargin();
                }
                n5 = n7;
                if (n3 != 0) {
                    n5 = n7;
                    if (object5 != constraintWidget) {
                        n5 = n7;
                        if (object5 != object6) {
                            n5 = 5;
                        }
                    }
                }
                if (((ConstraintAnchor)object4).mTarget != null) {
                    if (object5 == object6) {
                        linearSystem.addGreaterThan(((ConstraintAnchor)object4).mSolverVariable, ((ConstraintAnchor)object4).mTarget.mSolverVariable, n10, 6);
                    } else {
                        linearSystem.addGreaterThan(((ConstraintAnchor)object4).mSolverVariable, ((ConstraintAnchor)object4).mTarget.mSolverVariable, n10, 8);
                    }
                    n7 = bl && n3 == 0 ? 5 : n5;
                    linearSystem.addEquality(((ConstraintAnchor)object4).mSolverVariable, ((ConstraintAnchor)object4).mTarget.mSolverVariable, n10, n7);
                }
                if (n9 != 0) {
                    if (((ConstraintWidget)object5).getVisibility() != 8 && ((ConstraintWidget)object5).mListDimensionBehaviors[n] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        linearSystem.addGreaterThan(((ConstraintWidget)object5).mListAnchors[n2 + 1].mSolverVariable, ((ConstraintWidget)object5).mListAnchors[n2].mSolverVariable, 0, 5);
                    }
                    linearSystem.addGreaterThan(((ConstraintWidget)object5).mListAnchors[n2].mSolverVariable, ((ConstraintWidgetContainer)object).mListAnchors[n2].mSolverVariable, 0, 8);
                }
                if ((object4 = ((ConstraintWidget)object5).mListAnchors[n2 + 1].mTarget) != null) {
                    object4 = ((ConstraintAnchor)object4).mOwner;
                    if (((ConstraintWidget)object4).mListAnchors[n2].mTarget == null || ((ConstraintWidget)object4).mListAnchors[n2].mTarget.mOwner != object5) {
                        object4 = null;
                    }
                } else {
                    object4 = null;
                }
                if (object4 != null) {
                    object5 = object4;
                    continue;
                }
                n8 = 1;
            }
            if (constraintWidget3 != null && constraintWidget2.mListAnchors[n2 + 1].mTarget != null) {
                object4 = constraintWidget3.mListAnchors[n2 + 1];
                n8 = constraintWidget3.mListDimensionBehaviors[n] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget3.mResolvedMatchConstraintDefault[n] == 0 ? 1 : 0;
                if (n8 != 0 && n3 == 0 && ((ConstraintAnchor)object4).mTarget.mOwner == object) {
                    linearSystem.addEquality(((ConstraintAnchor)object4).mSolverVariable, ((ConstraintAnchor)object4).mTarget.mSolverVariable, -((ConstraintAnchor)object4).getMargin(), 5);
                } else if (n3 != 0 && ((ConstraintAnchor)object4).mTarget.mOwner == object) {
                    linearSystem.addEquality(((ConstraintAnchor)object4).mSolverVariable, ((ConstraintAnchor)object4).mTarget.mSolverVariable, -((ConstraintAnchor)object4).getMargin(), 4);
                }
                linearSystem.addLowerThan(((ConstraintAnchor)object4).mSolverVariable, constraintWidget2.mListAnchors[n2 + 1].mTarget.mSolverVariable, -((ConstraintAnchor)object4).getMargin(), 6);
            }
            if (n9 != 0) {
                linearSystem.addGreaterThan(((ConstraintWidgetContainer)object).mListAnchors[n2 + 1].mSolverVariable, constraintWidget2.mListAnchors[n2 + 1].mSolverVariable, constraintWidget2.mListAnchors[n2 + 1].getMargin(), 8);
            }
            if ((object = ((ChainHead)object2).mWeightedMatchConstraintsWidgets) != null) {
                n7 = ((ArrayList)object).size();
                if (n7 > 1) {
                    object9 = null;
                    float f2 = 0.0f;
                    float f3 = f;
                    if (((ChainHead)object2).mHasUndefinedWeights) {
                        f3 = f;
                        if (!((ChainHead)object2).mHasComplexMatchWeights) {
                            f3 = ((ChainHead)object2).mWidgetsMatchCount;
                        }
                    }
                    object4 = object8;
                    for (n8 = 0; n8 < n7; ++n8) {
                        object8 = (ConstraintWidget)((ArrayList)object).get(n8);
                        f = ((ConstraintWidget)object8).mWeight[n];
                        if (f < 0.0f) {
                            if (((ChainHead)object2).mHasComplexMatchWeights) {
                                linearSystem.addEquality(((ConstraintWidget)object8).mListAnchors[n2 + 1].mSolverVariable, ((ConstraintWidget)object8).mListAnchors[n2].mSolverVariable, 0, 4);
                                continue;
                            }
                            f = 1.0f;
                        }
                        if (f == 0.0f) {
                            linearSystem.addEquality(((ConstraintWidget)object8).mListAnchors[n2 + 1].mSolverVariable, ((ConstraintWidget)object8).mListAnchors[n2].mSolverVariable, 0, 8);
                            continue;
                        }
                        if (object9 != null) {
                            object3 = ((ConstraintWidget)object9).mListAnchors[n2].mSolverVariable;
                            solverVariable = ((ConstraintWidget)object9).mListAnchors[n2 + 1].mSolverVariable;
                            SolverVariable solverVariable2 = ((ConstraintWidget)object8).mListAnchors[n2].mSolverVariable;
                            SolverVariable solverVariable3 = ((ConstraintWidget)object8).mListAnchors[n2 + 1].mSolverVariable;
                            object9 = linearSystem.createRow();
                            ((ArrayRow)object9).createRowEqualMatchDimensions(f2, f3, f, (SolverVariable)object3, solverVariable, solverVariable2, solverVariable3);
                            linearSystem.addConstraint((ArrayRow)object9);
                        }
                        object9 = object8;
                        f2 = f;
                    }
                    object = object5;
                } else {
                    object = object5;
                }
            } else {
                object4 = object5;
                object5 = object;
                object = object4;
                object = object5;
            }
            if (object6 != null && (object6 == constraintWidget3 || n3 != 0)) {
                object = constraintWidget.mListAnchors[n2];
                object2 = constraintWidget2.mListAnchors[n2 + 1];
                object = ((ConstraintAnchor)object).mTarget != null ? ((ConstraintAnchor)object).mTarget.mSolverVariable : null;
                object2 = ((ConstraintAnchor)object2).mTarget != null ? ((ConstraintAnchor)object2).mTarget.mSolverVariable : null;
                object4 = ((ConstraintWidget)object6).mListAnchors[n2];
                object5 = constraintWidget3.mListAnchors[n2 + 1];
                if (object != null && object2 != null) {
                    f = n == 0 ? ((ConstraintWidget)object7).mHorizontalBiasPercent : ((ConstraintWidget)object7).mVerticalBiasPercent;
                    n = ((ConstraintAnchor)object4).getMargin();
                    n8 = ((ConstraintAnchor)object5).getMargin();
                    linearSystem.addCentering(((ConstraintAnchor)object4).mSolverVariable, (SolverVariable)object, n, f, (SolverVariable)object2, ((ConstraintAnchor)object5).mSolverVariable, n8, 7);
                }
            } else if (n6 != 0 && object6 != null) {
                n5 = ((ChainHead)object2).mWidgetsMatchCount > 0 && ((ChainHead)object2).mWidgetsCount == ((ChainHead)object2).mWidgetsMatchCount ? 1 : 0;
                object2 = object6;
                object = object6;
                while (object2 != null) {
                    object5 = ((ConstraintWidget)object2).mNextChainWidget[n];
                    while (object5 != null && ((ConstraintWidget)object5).getVisibility() == 8) {
                        object5 = ((ConstraintWidget)object5).mNextChainWidget[n];
                    }
                    if (object5 != null || object2 == constraintWidget3) {
                        object8 = ((ConstraintWidget)object2).mListAnchors[n2];
                        solverVariable = ((ConstraintAnchor)object8).mSolverVariable;
                        object4 = ((ConstraintAnchor)object8).mTarget != null ? ((ConstraintAnchor)object8).mTarget.mSolverVariable : null;
                        if (object != object2) {
                            object4 = ((ConstraintWidget)object).mListAnchors[n2 + 1].mSolverVariable;
                        } else if (object2 == object6 && object == object2) {
                            object4 = constraintWidget.mListAnchors[n2].mTarget != null ? constraintWidget.mListAnchors[n2].mTarget.mSolverVariable : null;
                        }
                        object9 = null;
                        n9 = ((ConstraintAnchor)object8).getMargin();
                        n7 = ((ConstraintWidget)object2).mListAnchors[n2 + 1].getMargin();
                        if (object5 != null) {
                            object7 = ((ConstraintWidget)object5).mListAnchors[n2];
                            object9 = ((ConstraintAnchor)object7).mSolverVariable;
                            object8 = ((ConstraintWidget)object2).mListAnchors[n2 + 1].mSolverVariable;
                            object3 = object9;
                            object9 = object8;
                        } else {
                            object8 = constraintWidget2.mListAnchors[n2 + 1].mTarget;
                            if (object8 != null) {
                                object9 = ((ConstraintAnchor)object8).mSolverVariable;
                            }
                            object7 = ((ConstraintWidget)object2).mListAnchors[n2 + 1].mSolverVariable;
                            object3 = object9;
                            object9 = object7;
                            object7 = object8;
                        }
                        n8 = n7;
                        if (object7 != null) {
                            n8 = n7 + ((ConstraintAnchor)object7).getMargin();
                        }
                        n7 = n9;
                        if (object != null) {
                            n7 = n9 + ((ConstraintWidget)object).mListAnchors[n2 + 1].getMargin();
                        }
                        if (solverVariable != null && object4 != null && object3 != null && object9 != null) {
                            if (object2 == object6) {
                                n7 = ((ConstraintWidget)object6).mListAnchors[n2].getMargin();
                            }
                            if (object2 == constraintWidget3) {
                                n8 = constraintWidget3.mListAnchors[n2 + 1].getMargin();
                            }
                            n9 = n5 != 0 ? 8 : 5;
                            linearSystem.addCentering(solverVariable, (SolverVariable)object4, n7, 0.5f, (SolverVariable)object3, (SolverVariable)object9, n8, n9);
                        }
                    }
                    if (((ConstraintWidget)object2).getVisibility() != 8) {
                        object = object2;
                    }
                    object2 = object5;
                }
            } else if (n4 != 0 && object6 != null) {
                n8 = ((ChainHead)object2).mWidgetsMatchCount > 0 && ((ChainHead)object2).mWidgetsCount == ((ChainHead)object2).mWidgetsMatchCount ? 1 : 0;
                object5 = object6;
                object2 = object6;
                while (object5 != null) {
                    object = ((ConstraintWidget)object5).mNextChainWidget[n];
                    while (object != null && ((ConstraintWidget)object).getVisibility() == 8) {
                        object = ((ConstraintWidget)object).mNextChainWidget[n];
                    }
                    if (object5 != object6 && object5 != constraintWidget3 && object != null) {
                        if (object == constraintWidget3) {
                            object = null;
                        }
                        object9 = ((ConstraintWidget)object5).mListAnchors[n2];
                        object3 = ((ConstraintAnchor)object9).mSolverVariable;
                        if (((ConstraintAnchor)object9).mTarget != null) {
                            object4 = ((ConstraintAnchor)object9).mTarget.mSolverVariable;
                        }
                        solverVariable = ((ConstraintWidget)object2).mListAnchors[n2 + 1].mSolverVariable;
                        object4 = null;
                        n9 = ((ConstraintAnchor)object9).getMargin();
                        n5 = ((ConstraintWidget)object5).mListAnchors[n2 + 1].getMargin();
                        if (object != null) {
                            object8 = ((ConstraintWidget)object).mListAnchors[n2];
                            object9 = ((ConstraintAnchor)object8).mSolverVariable;
                            object4 = ((ConstraintAnchor)object8).mTarget != null ? ((ConstraintAnchor)object8).mTarget.mSolverVariable : null;
                            object7 = object4;
                            object4 = object9;
                        } else {
                            object9 = constraintWidget3.mListAnchors[n2];
                            if (object9 != null) {
                                object4 = ((ConstraintAnchor)object9).mSolverVariable;
                            }
                            object7 = ((ConstraintWidget)object5).mListAnchors[n2 + 1].mSolverVariable;
                            object8 = object9;
                        }
                        n7 = n5;
                        if (object8 != null) {
                            n7 = n5 + ((ConstraintAnchor)object8).getMargin();
                        }
                        n5 = n9;
                        if (object2 != null) {
                            n5 = n9 + ((ConstraintWidget)object2).mListAnchors[n2 + 1].getMargin();
                        }
                        n9 = n8 != 0 ? 8 : 4;
                        if (object3 != null && solverVariable != null && object4 != null && object7 != null) {
                            linearSystem.addCentering((SolverVariable)object3, solverVariable, n5, 0.5f, (SolverVariable)object4, (SolverVariable)object7, n7, n9);
                        }
                    }
                    if (((ConstraintWidget)object5).getVisibility() != 8) {
                        object2 = object5;
                    }
                    object5 = object;
                }
                object = ((ConstraintWidget)object6).mListAnchors[n2];
                object4 = constraintWidget.mListAnchors[n2].mTarget;
                object5 = constraintWidget3.mListAnchors[n2 + 1];
                object2 = constraintWidget2.mListAnchors[n2 + 1].mTarget;
                if (object4 != null) {
                    if (object6 != constraintWidget3) {
                        linearSystem.addEquality(((ConstraintAnchor)object).mSolverVariable, ((ConstraintAnchor)object4).mSolverVariable, ((ConstraintAnchor)object).getMargin(), 5);
                    } else if (object2 != null) {
                        linearSystem.addCentering(((ConstraintAnchor)object).mSolverVariable, ((ConstraintAnchor)object4).mSolverVariable, ((ConstraintAnchor)object).getMargin(), 0.5f, ((ConstraintAnchor)object5).mSolverVariable, ((ConstraintAnchor)object2).mSolverVariable, ((ConstraintAnchor)object5).getMargin(), 5);
                    }
                }
                if (object2 != null && object6 != constraintWidget3) {
                    linearSystem.addEquality(((ConstraintAnchor)object5).mSolverVariable, ((ConstraintAnchor)object2).mSolverVariable, -((ConstraintAnchor)object5).getMargin(), 5);
                }
            }
            if (n6 == 0 && n4 == 0 || object6 == null || object6 == constraintWidget3) break block76;
            object4 = ((ConstraintWidget)object6).mListAnchors[n2];
            object5 = constraintWidget3.mListAnchors[n2 + 1];
            object2 = ((ConstraintAnchor)object4).mTarget != null ? ((ConstraintAnchor)object4).mTarget.mSolverVariable : null;
            object = ((ConstraintAnchor)object5).mTarget != null ? ((ConstraintAnchor)object5).mTarget.mSolverVariable : null;
            if (constraintWidget2 != constraintWidget3) {
                object = constraintWidget2.mListAnchors[n2 + 1];
                object = ((ConstraintAnchor)object).mTarget != null ? ((ConstraintAnchor)object).mTarget.mSolverVariable : null;
            }
            if (object6 == constraintWidget3) {
                object4 = ((ConstraintWidget)object6).mListAnchors[n2];
                object5 = ((ConstraintWidget)object6).mListAnchors[n2 + 1];
                object6 = object4;
            } else {
                object6 = object4;
            }
            if (object2 != null && object != null) {
                n = ((ConstraintAnchor)object6).getMargin();
                object4 = constraintWidget3;
                if (constraintWidget3 == null) {
                    object4 = constraintWidget2;
                }
                n2 = ((ConstraintWidget)object4).mListAnchors[n2 + 1].getMargin();
                linearSystem.addCentering(((ConstraintAnchor)object6).mSolverVariable, (SolverVariable)object2, n, 0.5f, (SolverVariable)object, ((ConstraintAnchor)object5).mSolverVariable, n2, 5);
            }
        }
    }
}

