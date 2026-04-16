/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.PriorityGoalRow;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.SolverVariableValues;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.Arrays;
import java.util.HashMap;

public class LinearSystem {
    public static long ARRAY_ROW_CREATION = 0L;
    public static final boolean DEBUG = false;
    private static final boolean DEBUG_CONSTRAINTS = false;
    public static final boolean FULL_DEBUG = false;
    public static final boolean MEASURE = false;
    public static long OPTIMIZED_ARRAY_ROW_CREATION = 0L;
    public static boolean OPTIMIZED_ENGINE = false;
    private static int POOL_SIZE = 0;
    static final boolean SIMPLIFY_SYNONYMS = false;
    private static final boolean USE_SYNONYMS = true;
    public static Metrics sMetrics;
    private int TABLE_SIZE;
    public boolean graphOptimizer = false;
    private boolean[] mAlreadyTestedCandidates;
    final Cache mCache;
    private Row mGoal;
    private int mMaxColumns = this.TABLE_SIZE = 32;
    private int mMaxRows;
    int mNumColumns = 1;
    int mNumRows = 0;
    private SolverVariable[] mPoolVariables;
    private int mPoolVariablesCount = 0;
    ArrayRow[] mRows = null;
    private Row mTempGoal;
    private HashMap<String, SolverVariable> mVariables = null;
    int mVariablesID = 0;
    public boolean newgraphOptimizer = false;

    static {
        POOL_SIZE = 1000;
        OPTIMIZED_ENGINE = true;
        ARRAY_ROW_CREATION = 0L;
        OPTIMIZED_ARRAY_ROW_CREATION = 0L;
    }

    public LinearSystem() {
        this.mAlreadyTestedCandidates = new boolean[this.TABLE_SIZE];
        this.mMaxRows = this.TABLE_SIZE;
        this.mPoolVariables = new SolverVariable[POOL_SIZE];
        this.mRows = new ArrayRow[this.TABLE_SIZE];
        this.releaseRows();
        this.mCache = new Cache();
        this.mGoal = new PriorityGoalRow(this.mCache);
        this.mTempGoal = OPTIMIZED_ENGINE ? new ValuesRow(this, this.mCache) : new ArrayRow(this.mCache);
    }

    private SolverVariable acquireSolverVariable(SolverVariable.Type object, String solverVariableArray) {
        SolverVariable solverVariable = this.mCache.solverVariablePool.acquire();
        if (solverVariable == null) {
            solverVariable = new SolverVariable((SolverVariable.Type)((Object)object), (String)solverVariableArray);
            solverVariable.setType((SolverVariable.Type)((Object)object), (String)solverVariableArray);
            object = solverVariable;
        } else {
            solverVariable.reset();
            solverVariable.setType((SolverVariable.Type)((Object)object), (String)solverVariableArray);
            object = solverVariable;
        }
        if (this.mPoolVariablesCount >= POOL_SIZE) {
            this.mPoolVariables = Arrays.copyOf(this.mPoolVariables, POOL_SIZE *= 2);
        }
        solverVariableArray = this.mPoolVariables;
        int n = this.mPoolVariablesCount;
        this.mPoolVariablesCount = n + 1;
        solverVariableArray[n] = object;
        return object;
    }

    private void addError(ArrayRow arrayRow) {
        arrayRow.addError(this, 0);
    }

    private final void addRow(ArrayRow arrayRow) {
        if (OPTIMIZED_ENGINE) {
            if (this.mRows[this.mNumRows] != null) {
                this.mCache.optimizedArrayRowPool.release(this.mRows[this.mNumRows]);
            }
        } else if (this.mRows[this.mNumRows] != null) {
            this.mCache.arrayRowPool.release(this.mRows[this.mNumRows]);
        }
        this.mRows[this.mNumRows] = arrayRow;
        arrayRow.variable.definitionId = this.mNumRows++;
        arrayRow.variable.updateReferencesWithNewDefinition(arrayRow);
    }

    private void addSingleError(ArrayRow arrayRow, int n) {
        this.addSingleError(arrayRow, n, 0);
    }

    private void computeValues() {
        for (int i = 0; i < this.mNumRows; ++i) {
            ArrayRow arrayRow = this.mRows[i];
            arrayRow.variable.computedValue = arrayRow.constantValue;
        }
    }

    public static ArrayRow createRowDimensionPercent(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, float f) {
        return linearSystem.createRow().createRowDimensionPercent(solverVariable, solverVariable2, f);
    }

    private SolverVariable createVariable(String string2, SolverVariable.Type object) {
        if (sMetrics != null) {
            Metrics metrics = sMetrics;
            ++metrics.variables;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            this.increaseTableSize();
        }
        object = this.acquireSolverVariable((SolverVariable.Type)((Object)object), null);
        ((SolverVariable)object).setName(string2);
        ++this.mVariablesID;
        ++this.mNumColumns;
        ((SolverVariable)object).id = this.mVariablesID;
        if (this.mVariables == null) {
            this.mVariables = new HashMap();
        }
        this.mVariables.put(string2, (SolverVariable)object);
        this.mCache.mIndexedVariables[this.mVariablesID] = object;
        return object;
    }

    private void displayRows() {
        this.displaySolverVariables();
        String string2 = "";
        for (int i = 0; i < this.mNumRows; ++i) {
            string2 = string2 + this.mRows[i];
            string2 = string2 + "\n";
        }
        string2 = string2 + this.mGoal + "\n";
        System.out.println(string2);
    }

    private void displaySolverVariables() {
        String string2 = "Display Rows (" + this.mNumRows + "x" + this.mNumColumns + ")\n";
        System.out.println(string2);
    }

    private int enforceBFS(Row object) throws Exception {
        int n;
        block14: {
            int n2;
            int n3 = 0;
            int n4 = 0;
            n = 0;
            while (true) {
                n2 = n4;
                if (n >= this.mNumRows) break;
                if (this.mRows[n].variable.mType != SolverVariable.Type.UNRESTRICTED && this.mRows[n].constantValue < 0.0f) {
                    n2 = 1;
                    break;
                }
                ++n;
            }
            n = n3;
            if (n2 == 0) break block14;
            n4 = 0;
            n2 = 0;
            while (true) {
                ArrayRow arrayRow;
                n = n2;
                if (n4 != 0) break;
                if (sMetrics != null) {
                    object = sMetrics;
                    ++((Metrics)object).bfs;
                }
                int n5 = n2 + 1;
                float f = Float.MAX_VALUE;
                n2 = 0;
                n3 = -1;
                n = -1;
                for (int i = 0; i < this.mNumRows; ++i) {
                    int n6;
                    int n7;
                    int n8;
                    float f2;
                    block16: {
                        block17: {
                            block15: {
                                arrayRow = this.mRows[i];
                                if (arrayRow.variable.mType != SolverVariable.Type.UNRESTRICTED) break block15;
                                f2 = f;
                                n8 = n2;
                                n7 = n3;
                                n6 = n;
                                break block16;
                            }
                            if (!arrayRow.isSimpleDefinition) break block17;
                            f2 = f;
                            n8 = n2;
                            n7 = n3;
                            n6 = n;
                            break block16;
                        }
                        f2 = f;
                        n8 = n2;
                        n7 = n3;
                        n6 = n;
                        if (!(arrayRow.constantValue < 0.0f)) break block16;
                        int n9 = 1;
                        while (true) {
                            int n10;
                            block19: {
                                float f3;
                                block18: {
                                    f2 = f;
                                    n8 = n2;
                                    n7 = n3;
                                    n6 = n;
                                    if (n9 >= this.mNumColumns) break;
                                    object = this.mCache.mIndexedVariables[n9];
                                    f3 = arrayRow.variables.get((SolverVariable)object);
                                    if (!(f3 <= 0.0f)) break block18;
                                    f2 = f;
                                    n6 = n2;
                                    n7 = n3;
                                    n10 = n;
                                    break block19;
                                }
                                n6 = 0;
                                n8 = n2;
                                n2 = n6;
                                while (true) {
                                    block21: {
                                        block20: {
                                            f2 = f;
                                            n6 = n8;
                                            n7 = n3;
                                            n10 = n;
                                            if (n2 >= 9) break;
                                            f2 = ((SolverVariable)object).strengthVector[n2] / f3;
                                            if (f2 < f && n2 == n8) break block20;
                                            n6 = n8;
                                            if (n2 <= n8) break block21;
                                        }
                                        f = f2;
                                        n3 = i;
                                        n = n9;
                                        n6 = n2;
                                    }
                                    ++n2;
                                    n8 = n6;
                                }
                            }
                            ++n9;
                            f = f2;
                            n2 = n6;
                            n3 = n7;
                            n = n10;
                        }
                    }
                    f = f2;
                    n2 = n8;
                    n3 = n7;
                    n = n6;
                }
                if (n3 != -1) {
                    arrayRow = this.mRows[n3];
                    arrayRow.variable.definitionId = -1;
                    if (sMetrics != null) {
                        object = sMetrics;
                        ++((Metrics)object).pivots;
                    }
                    arrayRow.pivot(this.mCache.mIndexedVariables[n]);
                    arrayRow.variable.definitionId = n3;
                    arrayRow.variable.updateReferencesWithNewDefinition(arrayRow);
                } else {
                    n4 = 1;
                }
                if (n5 > this.mNumColumns / 2) {
                    n4 = 1;
                }
                n2 = n5;
            }
        }
        return n;
    }

    private String getDisplaySize(int n) {
        int n2 = n * 4 / 1024 / 1024;
        if (n2 > 0) {
            return "" + n2 + " Mb";
        }
        n2 = n * 4 / 1024;
        if (n2 > 0) {
            return "" + n2 + " Kb";
        }
        return "" + n * 4 + " bytes";
    }

    private String getDisplayStrength(int n) {
        if (n == 1) {
            return "LOW";
        }
        if (n == 2) {
            return "MEDIUM";
        }
        if (n == 3) {
            return "HIGH";
        }
        if (n == 4) {
            return "HIGHEST";
        }
        if (n == 5) {
            return "EQUALITY";
        }
        if (n == 8) {
            return "FIXED";
        }
        if (n == 6) {
            return "BARRIER";
        }
        return "NONE";
    }

    public static Metrics getMetrics() {
        return sMetrics;
    }

    private void increaseTableSize() {
        this.TABLE_SIZE *= 2;
        this.mRows = Arrays.copyOf(this.mRows, this.TABLE_SIZE);
        this.mCache.mIndexedVariables = Arrays.copyOf(this.mCache.mIndexedVariables, this.TABLE_SIZE);
        this.mAlreadyTestedCandidates = new boolean[this.TABLE_SIZE];
        this.mMaxColumns = this.TABLE_SIZE;
        this.mMaxRows = this.TABLE_SIZE;
        if (sMetrics != null) {
            Metrics metrics = sMetrics;
            ++metrics.tableSizeIncrease;
            LinearSystem.sMetrics.lastTableSize = LinearSystem.sMetrics.maxTableSize = Math.max(LinearSystem.sMetrics.maxTableSize, (long)this.TABLE_SIZE);
        }
    }

    private final int optimize(Row row, boolean bl) {
        int n;
        int n2;
        Object object;
        if (sMetrics != null) {
            object = sMetrics;
            ++((Metrics)object).optimize;
        }
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        while (true) {
            n2 = n3;
            n = n4;
            if (n5 >= this.mNumColumns) break;
            this.mAlreadyTestedCandidates[n5] = false;
            ++n5;
        }
        while (n2 == 0) {
            if (sMetrics != null) {
                object = sMetrics;
                ++((Metrics)object).iterations;
            }
            if ((n4 = n + 1) >= this.mNumColumns * 2) {
                return n4;
            }
            if (row.getKey() != null) {
                this.mAlreadyTestedCandidates[row.getKey().id] = true;
            }
            if ((object = row.getPivotCandidate(this, this.mAlreadyTestedCandidates)) != null) {
                if (this.mAlreadyTestedCandidates[((SolverVariable)object).id]) {
                    return n4;
                }
                this.mAlreadyTestedCandidates[((SolverVariable)object).id] = true;
            }
            if (object != null) {
                ArrayRow arrayRow;
                float f = Float.MAX_VALUE;
                n5 = -1;
                for (n = 0; n < this.mNumRows; ++n) {
                    float f2;
                    arrayRow = this.mRows[n];
                    if (arrayRow.variable.mType == SolverVariable.Type.UNRESTRICTED) {
                        f2 = f;
                        n3 = n5;
                    } else if (arrayRow.isSimpleDefinition) {
                        f2 = f;
                        n3 = n5;
                    } else {
                        f2 = f;
                        n3 = n5;
                        if (arrayRow.hasVariable((SolverVariable)object)) {
                            float f3 = arrayRow.variables.get((SolverVariable)object);
                            f2 = f;
                            n3 = n5;
                            if (f3 < 0.0f) {
                                f3 = -arrayRow.constantValue / f3;
                                f2 = f;
                                n3 = n5;
                                if (f3 < f) {
                                    f2 = f3;
                                    n3 = n;
                                }
                            }
                        }
                    }
                    f = f2;
                    n5 = n3;
                }
                if (n5 > -1) {
                    arrayRow = this.mRows[n5];
                    arrayRow.variable.definitionId = -1;
                    if (sMetrics != null) {
                        Metrics metrics = sMetrics;
                        ++metrics.pivots;
                    }
                    arrayRow.pivot((SolverVariable)object);
                    arrayRow.variable.definitionId = n5;
                    arrayRow.variable.updateReferencesWithNewDefinition(arrayRow);
                }
            } else {
                n2 = 1;
            }
            n = n4;
        }
        return n;
    }

    private void releaseRows() {
        if (OPTIMIZED_ENGINE) {
            for (int i = 0; i < this.mRows.length; ++i) {
                ArrayRow arrayRow = this.mRows[i];
                if (arrayRow != null) {
                    this.mCache.optimizedArrayRowPool.release(arrayRow);
                }
                this.mRows[i] = null;
            }
        } else {
            for (int i = 0; i < this.mRows.length; ++i) {
                ArrayRow arrayRow = this.mRows[i];
                if (arrayRow != null) {
                    this.mCache.arrayRowPool.release(arrayRow);
                }
                this.mRows[i] = null;
            }
        }
    }

    public void addCenterPoint(ConstraintWidget object, ConstraintWidget object2, float f, int n) {
        SolverVariable solverVariable = this.createObjectVariable(((ConstraintWidget)object).getAnchor(ConstraintAnchor.Type.LEFT));
        SolverVariable solverVariable2 = this.createObjectVariable(((ConstraintWidget)object).getAnchor(ConstraintAnchor.Type.TOP));
        SolverVariable solverVariable3 = this.createObjectVariable(((ConstraintWidget)object).getAnchor(ConstraintAnchor.Type.RIGHT));
        SolverVariable solverVariable4 = this.createObjectVariable(((ConstraintWidget)object).getAnchor(ConstraintAnchor.Type.BOTTOM));
        object = this.createObjectVariable(((ConstraintWidget)object2).getAnchor(ConstraintAnchor.Type.LEFT));
        SolverVariable solverVariable5 = this.createObjectVariable(((ConstraintWidget)object2).getAnchor(ConstraintAnchor.Type.TOP));
        SolverVariable solverVariable6 = this.createObjectVariable(((ConstraintWidget)object2).getAnchor(ConstraintAnchor.Type.RIGHT));
        object2 = this.createObjectVariable(((ConstraintWidget)object2).getAnchor(ConstraintAnchor.Type.BOTTOM));
        ArrayRow arrayRow = this.createRow();
        arrayRow.createRowWithAngle(solverVariable2, solverVariable4, solverVariable5, (SolverVariable)object2, (float)(Math.sin(f) * (double)n));
        this.addConstraint(arrayRow);
        object2 = this.createRow();
        ((ArrayRow)object2).createRowWithAngle(solverVariable, solverVariable3, (SolverVariable)object, solverVariable6, (float)(Math.cos(f) * (double)n));
        this.addConstraint((ArrayRow)object2);
    }

    public void addCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int n, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int n2, int n3) {
        ArrayRow arrayRow = this.createRow();
        arrayRow.createRowCentering(solverVariable, solverVariable2, n, f, solverVariable3, solverVariable4, n2);
        if (n3 != 8) {
            arrayRow.addError(this, n3);
        }
        this.addConstraint(arrayRow);
    }

    public void addConstraint(ArrayRow arrayRow) {
        Object object;
        if (arrayRow == null) {
            return;
        }
        if (sMetrics != null) {
            object = sMetrics;
            ++((Metrics)object).constraints;
            if (arrayRow.isSimpleDefinition) {
                object = sMetrics;
                ++((Metrics)object).simpleconstraints;
            }
        }
        if (this.mNumRows + 1 >= this.mMaxRows || this.mNumColumns + 1 >= this.mMaxColumns) {
            this.increaseTableSize();
        }
        boolean bl = false;
        boolean bl2 = false;
        if (!arrayRow.isSimpleDefinition) {
            arrayRow.updateFromSystem(this);
            if (arrayRow.isEmpty()) {
                return;
            }
            arrayRow.ensurePositiveConstant();
            bl = bl2;
            if (arrayRow.chooseSubject(this)) {
                arrayRow.variable = object = this.createExtraVariable();
                this.addRow(arrayRow);
                bl2 = true;
                this.mTempGoal.initFromRow(arrayRow);
                this.optimize(this.mTempGoal, true);
                bl = bl2;
                if (((SolverVariable)object).definitionId == -1) {
                    SolverVariable solverVariable;
                    if (arrayRow.variable == object && (solverVariable = arrayRow.pickPivot((SolverVariable)object)) != null) {
                        if (sMetrics != null) {
                            object = sMetrics;
                            ++((Metrics)object).pivots;
                        }
                        arrayRow.pivot(solverVariable);
                    }
                    if (!arrayRow.isSimpleDefinition) {
                        arrayRow.variable.updateReferencesWithNewDefinition(arrayRow);
                    }
                    --this.mNumRows;
                    bl = bl2;
                }
            }
            if (!arrayRow.hasKeyVariable()) {
                return;
            }
        }
        if (!bl) {
            this.addRow(arrayRow);
        }
    }

    public ArrayRow addEquality(SolverVariable solverVariable, SolverVariable solverVariable2, int n, int n2) {
        if (n2 == 8 && solverVariable2.isFinalValue && solverVariable.definitionId == -1) {
            solverVariable.setFinalValue(this, solverVariable2.computedValue + (float)n);
            return null;
        }
        ArrayRow arrayRow = this.createRow();
        arrayRow.createRowEquals(solverVariable, solverVariable2, n);
        if (n2 != 8) {
            arrayRow.addError(this, n2);
        }
        this.addConstraint(arrayRow);
        return arrayRow;
    }

    public void addEquality(SolverVariable solverVariable, int n) {
        if (solverVariable.definitionId == -1) {
            solverVariable.setFinalValue(this, n);
            return;
        }
        int n2 = solverVariable.definitionId;
        if (solverVariable.definitionId != -1) {
            ArrayRow arrayRow = this.mRows[n2];
            if (arrayRow.isSimpleDefinition) {
                arrayRow.constantValue = n;
            } else if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.isSimpleDefinition = true;
                arrayRow.constantValue = n;
            } else {
                arrayRow = this.createRow();
                arrayRow.createRowEquals(solverVariable, n);
                this.addConstraint(arrayRow);
            }
        } else {
            ArrayRow arrayRow = this.createRow();
            arrayRow.createRowDefinition(solverVariable, n);
            this.addConstraint(arrayRow);
        }
    }

    public void addGreaterBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int n, boolean bl) {
        ArrayRow arrayRow = this.createRow();
        SolverVariable solverVariable3 = this.createSlackVariable();
        solverVariable3.strength = 0;
        arrayRow.createRowGreaterThan(solverVariable, solverVariable2, solverVariable3, n);
        this.addConstraint(arrayRow);
    }

    public void addGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, int n, int n2) {
        ArrayRow arrayRow = this.createRow();
        SolverVariable solverVariable3 = this.createSlackVariable();
        solverVariable3.strength = 0;
        arrayRow.createRowGreaterThan(solverVariable, solverVariable2, solverVariable3, n);
        if (n2 != 8) {
            this.addSingleError(arrayRow, (int)(-1.0f * arrayRow.variables.get(solverVariable3)), n2);
        }
        this.addConstraint(arrayRow);
    }

    public void addLowerBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int n, boolean bl) {
        ArrayRow arrayRow = this.createRow();
        SolverVariable solverVariable3 = this.createSlackVariable();
        solverVariable3.strength = 0;
        arrayRow.createRowLowerThan(solverVariable, solverVariable2, solverVariable3, n);
        this.addConstraint(arrayRow);
    }

    public void addLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, int n, int n2) {
        ArrayRow arrayRow = this.createRow();
        SolverVariable solverVariable3 = this.createSlackVariable();
        solverVariable3.strength = 0;
        arrayRow.createRowLowerThan(solverVariable, solverVariable2, solverVariable3, n);
        if (n2 != 8) {
            this.addSingleError(arrayRow, (int)(-1.0f * arrayRow.variables.get(solverVariable3)), n2);
        }
        this.addConstraint(arrayRow);
    }

    public void addRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f, int n) {
        ArrayRow arrayRow = this.createRow();
        arrayRow.createRowDimensionRatio(solverVariable, solverVariable2, solverVariable3, solverVariable4, f);
        if (n != 8) {
            arrayRow.addError(this, n);
        }
        this.addConstraint(arrayRow);
    }

    void addSingleError(ArrayRow arrayRow, int n, int n2) {
        arrayRow.addSingleError(this.createErrorVariable(n2, null), n);
    }

    final void cleanupRows() {
        int n = 0;
        while (n < this.mNumRows) {
            ArrayRow arrayRow = this.mRows[n];
            if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.isSimpleDefinition = true;
            }
            int n2 = n;
            if (arrayRow.isSimpleDefinition) {
                arrayRow.variable.computedValue = arrayRow.constantValue;
                arrayRow.variable.removeFromRow(arrayRow);
                for (n2 = n; n2 < this.mNumRows - 1; ++n2) {
                    this.mRows[n2] = this.mRows[n2 + 1];
                }
                this.mRows[this.mNumRows - 1] = null;
                --this.mNumRows;
                n2 = n - 1;
            }
            n = n2 + 1;
        }
    }

    public SolverVariable createErrorVariable(int n, String object) {
        if (sMetrics != null) {
            Metrics metrics = sMetrics;
            ++metrics.errors;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            this.increaseTableSize();
        }
        object = this.acquireSolverVariable(SolverVariable.Type.ERROR, (String)object);
        ++this.mVariablesID;
        ++this.mNumColumns;
        ((SolverVariable)object).id = this.mVariablesID;
        ((SolverVariable)object).strength = n;
        this.mCache.mIndexedVariables[this.mVariablesID] = object;
        this.mGoal.addError((SolverVariable)object);
        return object;
    }

    public SolverVariable createExtraVariable() {
        Object object;
        if (sMetrics != null) {
            object = sMetrics;
            ++((Metrics)object).extravariables;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            this.increaseTableSize();
        }
        object = this.acquireSolverVariable(SolverVariable.Type.SLACK, null);
        ++this.mVariablesID;
        ++this.mNumColumns;
        ((SolverVariable)object).id = this.mVariablesID;
        this.mCache.mIndexedVariables[this.mVariablesID] = object;
        return object;
    }

    public SolverVariable createObjectVariable(Object object) {
        SolverVariable solverVariable;
        block7: {
            SolverVariable solverVariable2;
            block8: {
                if (object == null) {
                    return null;
                }
                if (this.mNumColumns + 1 >= this.mMaxColumns) {
                    this.increaseTableSize();
                }
                solverVariable = null;
                if (!(object instanceof ConstraintAnchor)) break block7;
                solverVariable2 = solverVariable = ((ConstraintAnchor)object).getSolverVariable();
                if (solverVariable == null) {
                    ((ConstraintAnchor)object).resetSolverVariable(this.mCache);
                    solverVariable2 = ((ConstraintAnchor)object).getSolverVariable();
                }
                if (solverVariable2.id == -1 || solverVariable2.id > this.mVariablesID) break block8;
                solverVariable = solverVariable2;
                if (this.mCache.mIndexedVariables[solverVariable2.id] != null) break block7;
            }
            if (solverVariable2.id != -1) {
                solverVariable2.reset();
            }
            ++this.mVariablesID;
            ++this.mNumColumns;
            solverVariable2.id = this.mVariablesID;
            solverVariable2.mType = SolverVariable.Type.UNRESTRICTED;
            this.mCache.mIndexedVariables[this.mVariablesID] = solverVariable2;
            solverVariable = solverVariable2;
        }
        return solverVariable;
    }

    public ArrayRow createRow() {
        ArrayRow arrayRow;
        if (OPTIMIZED_ENGINE) {
            arrayRow = this.mCache.optimizedArrayRowPool.acquire();
            if (arrayRow == null) {
                arrayRow = new ValuesRow(this, this.mCache);
                ++OPTIMIZED_ARRAY_ROW_CREATION;
            } else {
                arrayRow.reset();
            }
        } else {
            arrayRow = this.mCache.arrayRowPool.acquire();
            if (arrayRow == null) {
                arrayRow = new ArrayRow(this.mCache);
                ++ARRAY_ROW_CREATION;
            } else {
                arrayRow.reset();
            }
        }
        SolverVariable.increaseErrorId();
        return arrayRow;
    }

    public SolverVariable createSlackVariable() {
        Object object;
        if (sMetrics != null) {
            object = sMetrics;
            ++((Metrics)object).slackvariables;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            this.increaseTableSize();
        }
        object = this.acquireSolverVariable(SolverVariable.Type.SLACK, null);
        ++this.mVariablesID;
        ++this.mNumColumns;
        ((SolverVariable)object).id = this.mVariablesID;
        this.mCache.mIndexedVariables[this.mVariablesID] = object;
        return object;
    }

    public void displayReadableRows() {
        String string2;
        int n;
        this.displaySolverVariables();
        String string3 = "";
        for (n = 0; n < this.mVariablesID; ++n) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[n];
            string2 = string3;
            if (solverVariable != null) {
                string2 = string3;
                if (solverVariable.isFinalValue) {
                    string2 = string3 + " $[" + n + "] => " + solverVariable + " = " + solverVariable.computedValue + "\n";
                }
            }
            string3 = string2;
        }
        string3 = string3 + "\n\n #  ";
        for (n = 0; n < this.mNumRows; ++n) {
            string3 = string3 + this.mRows[n].toReadableString();
            string3 = string3 + "\n #  ";
        }
        string2 = string3;
        if (this.mGoal != null) {
            string2 = string3 + "Goal: " + this.mGoal + "\n";
        }
        System.out.println(string2);
    }

    void displaySystemInformations() {
        int n;
        int n2;
        int n3 = 0;
        for (n2 = 0; n2 < this.TABLE_SIZE; ++n2) {
            n = n3;
            if (this.mRows[n2] != null) {
                n = n3 + this.mRows[n2].sizeInBytes();
            }
            n3 = n;
        }
        n = 0;
        for (n2 = 0; n2 < this.mNumRows; ++n2) {
            int n4 = n;
            if (this.mRows[n2] != null) {
                n4 = n + this.mRows[n2].sizeInBytes();
            }
            n = n4;
        }
        System.out.println("Linear System -> Table size: " + this.TABLE_SIZE + " (" + this.getDisplaySize(this.TABLE_SIZE * this.TABLE_SIZE) + ") -- row sizes: " + this.getDisplaySize(n3) + ", actual size: " + this.getDisplaySize(n) + " rows: " + this.mNumRows + "/" + this.mMaxRows + " cols: " + this.mNumColumns + "/" + this.mMaxColumns + " " + 0 + " occupied cells, " + this.getDisplaySize(0));
    }

    public void displayVariablesReadableRows() {
        String string2;
        this.displaySolverVariables();
        String string3 = "";
        for (int i = 0; i < this.mNumRows; ++i) {
            string2 = string3;
            if (this.mRows[i].variable.mType == SolverVariable.Type.UNRESTRICTED) {
                string2 = string3 + this.mRows[i].toReadableString();
                string2 = string2 + "\n";
            }
            string3 = string2;
        }
        string2 = string3 + this.mGoal + "\n";
        System.out.println(string2);
    }

    public void fillMetrics(Metrics metrics) {
        sMetrics = metrics;
    }

    public Cache getCache() {
        return this.mCache;
    }

    Row getGoal() {
        return this.mGoal;
    }

    public int getMemoryUsed() {
        int n = 0;
        for (int i = 0; i < this.mNumRows; ++i) {
            int n2 = n;
            if (this.mRows[i] != null) {
                n2 = n + this.mRows[i].sizeInBytes();
            }
            n = n2;
        }
        return n;
    }

    public int getNumEquations() {
        return this.mNumRows;
    }

    public int getNumVariables() {
        return this.mVariablesID;
    }

    public int getObjectVariableValue(Object object) {
        if ((object = ((ConstraintAnchor)object).getSolverVariable()) != null) {
            return (int)(((SolverVariable)object).computedValue + 0.5f);
        }
        return 0;
    }

    ArrayRow getRow(int n) {
        return this.mRows[n];
    }

    float getValueFor(String object) {
        if ((object = this.getVariable((String)object, SolverVariable.Type.UNRESTRICTED)) == null) {
            return 0.0f;
        }
        return ((SolverVariable)object).computedValue;
    }

    SolverVariable getVariable(String string2, SolverVariable.Type type2) {
        SolverVariable solverVariable;
        if (this.mVariables == null) {
            this.mVariables = new HashMap();
        }
        SolverVariable solverVariable2 = solverVariable = this.mVariables.get(string2);
        if (solverVariable == null) {
            solverVariable2 = this.createVariable(string2, type2);
        }
        return solverVariable2;
    }

    public void minimize() throws Exception {
        Metrics metrics;
        if (sMetrics != null) {
            metrics = sMetrics;
            ++metrics.minimize;
        }
        if (!this.graphOptimizer && !this.newgraphOptimizer) {
            this.minimizeGoal(this.mGoal);
        } else {
            boolean bl;
            if (sMetrics != null) {
                metrics = sMetrics;
                ++metrics.graphOptimizer;
            }
            boolean bl2 = true;
            int n = 0;
            while (true) {
                bl = bl2;
                if (n >= this.mNumRows) break;
                if (!this.mRows[n].isSimpleDefinition) {
                    bl = false;
                    break;
                }
                ++n;
            }
            if (!bl) {
                this.minimizeGoal(this.mGoal);
            } else {
                if (sMetrics != null) {
                    metrics = sMetrics;
                    ++metrics.fullySolved;
                }
                this.computeValues();
            }
        }
    }

    void minimizeGoal(Row row) throws Exception {
        if (sMetrics != null) {
            Metrics metrics = sMetrics;
            ++metrics.minimizeGoal;
            LinearSystem.sMetrics.maxVariables = Math.max(LinearSystem.sMetrics.maxVariables, (long)this.mNumColumns);
            LinearSystem.sMetrics.maxRows = Math.max(LinearSystem.sMetrics.maxRows, (long)this.mNumRows);
        }
        this.enforceBFS(row);
        this.optimize(row, false);
        this.computeValues();
    }

    public void removeRow(ArrayRow arrayRow) {
        if (arrayRow.isSimpleDefinition && arrayRow.variable != null) {
            if (arrayRow.variable.definitionId != -1) {
                for (int i = arrayRow.variable.definitionId; i < this.mNumRows - 1; ++i) {
                    this.mRows[i] = this.mRows[i + 1];
                }
                --this.mNumRows;
            }
            arrayRow.variable.setFinalValue(this, arrayRow.constantValue);
        }
    }

    public void reset() {
        int n;
        for (n = 0; n < this.mCache.mIndexedVariables.length; ++n) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[n];
            if (solverVariable == null) continue;
            solverVariable.reset();
        }
        this.mCache.solverVariablePool.releaseAll((SolverVariable[])this.mPoolVariables, this.mPoolVariablesCount);
        this.mPoolVariablesCount = 0;
        Arrays.fill(this.mCache.mIndexedVariables, null);
        if (this.mVariables != null) {
            this.mVariables.clear();
        }
        this.mVariablesID = 0;
        this.mGoal.clear();
        this.mNumColumns = 1;
        for (n = 0; n < this.mNumRows; ++n) {
            this.mRows[n].used = false;
        }
        this.releaseRows();
        this.mNumRows = 0;
        this.mTempGoal = OPTIMIZED_ENGINE ? new ValuesRow(this, this.mCache) : new ArrayRow(this.mCache);
    }

    static interface Row {
        public void addError(SolverVariable var1);

        public void clear();

        public SolverVariable getKey();

        public SolverVariable getPivotCandidate(LinearSystem var1, boolean[] var2);

        public void initFromRow(Row var1);

        public boolean isEmpty();

        public void updateFromFinalVariable(LinearSystem var1, SolverVariable var2, boolean var3);

        public void updateFromRow(ArrayRow var1, boolean var2);

        public void updateFromSystem(LinearSystem var1);
    }

    class ValuesRow
    extends ArrayRow {
        final LinearSystem this$0;

        public ValuesRow(LinearSystem linearSystem, Cache cache2) {
            this.this$0 = linearSystem;
            this.variables = new SolverVariableValues(this, cache2);
        }
    }
}

