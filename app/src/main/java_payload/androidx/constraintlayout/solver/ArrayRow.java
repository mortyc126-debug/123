/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayLinkedVariables;
import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.ArrayList;

public class ArrayRow
implements LinearSystem.Row {
    private static final boolean DEBUG = false;
    private static final boolean FULL_NEW_CHECK = false;
    float constantValue = 0.0f;
    boolean isSimpleDefinition = false;
    boolean used = false;
    SolverVariable variable = null;
    public ArrayRowVariables variables;
    ArrayList<SolverVariable> variablesToUpdate = new ArrayList();

    public ArrayRow() {
    }

    public ArrayRow(Cache cache2) {
        this.variables = new ArrayLinkedVariables(this, cache2);
    }

    private boolean isNew(SolverVariable solverVariable, LinearSystem linearSystem) {
        int n = solverVariable.usageInRowCount;
        boolean bl = true;
        if (n > 1) {
            bl = false;
        }
        return bl;
    }

    private SolverVariable pickPivotInVariables(boolean[] blArray, SolverVariable solverVariable) {
        SolverVariable solverVariable2;
        block14: {
            float f = 0.0f;
            SolverVariable solverVariable3 = null;
            solverVariable2 = null;
            float f2 = 0.0f;
            int n = this.variables.getCurrentSize();
            for (int i = 0; i < n; ++i) {
                float f3;
                SolverVariable solverVariable4;
                SolverVariable solverVariable5;
                float f4;
                block10: {
                    SolverVariable solverVariable6;
                    float f5;
                    block12: {
                        block13: {
                            block11: {
                                f5 = this.variables.getVariableValue(i);
                                f4 = f;
                                solverVariable5 = solverVariable3;
                                solverVariable4 = solverVariable2;
                                f3 = f2;
                                if (!(f5 < 0.0f)) break block10;
                                solverVariable6 = this.variables.getVariable(i);
                                if (blArray == null) break block11;
                                f4 = f;
                                solverVariable5 = solverVariable3;
                                solverVariable4 = solverVariable2;
                                f3 = f2;
                                if (blArray[solverVariable6.id]) break block10;
                            }
                            f4 = f;
                            solverVariable5 = solverVariable3;
                            solverVariable4 = solverVariable2;
                            f3 = f2;
                            if (solverVariable6 == solverVariable) break block10;
                            if (!true) break block12;
                            if (solverVariable6.mType == SolverVariable.Type.SLACK) break block13;
                            f4 = f;
                            solverVariable5 = solverVariable3;
                            solverVariable4 = solverVariable2;
                            f3 = f2;
                            if (solverVariable6.mType != SolverVariable.Type.ERROR) break block10;
                        }
                        f4 = f;
                        solverVariable5 = solverVariable3;
                        solverVariable4 = solverVariable2;
                        f3 = f2;
                        if (f5 < f) {
                            f4 = f5;
                            solverVariable5 = solverVariable6;
                            solverVariable4 = solverVariable2;
                            f3 = f2;
                        }
                        break block10;
                    }
                    if (solverVariable6.mType == SolverVariable.Type.SLACK) {
                        f4 = f;
                        solverVariable5 = solverVariable3;
                        solverVariable4 = solverVariable2;
                        f3 = f2;
                        if (f5 < f2) {
                            f4 = f;
                            solverVariable5 = solverVariable3;
                            solverVariable4 = solverVariable6;
                            f3 = f5;
                        }
                    } else {
                        f4 = f;
                        solverVariable5 = solverVariable3;
                        solverVariable4 = solverVariable2;
                        f3 = f2;
                        if (solverVariable6.mType == SolverVariable.Type.ERROR) {
                            f4 = f;
                            solverVariable5 = solverVariable3;
                            solverVariable4 = solverVariable2;
                            f3 = f2;
                            if (f5 < f) {
                                f4 = f5;
                                solverVariable5 = solverVariable6;
                                f3 = f2;
                                solverVariable4 = solverVariable2;
                            }
                        }
                    }
                }
                f = f4;
                solverVariable3 = solverVariable5;
                solverVariable2 = solverVariable4;
                f2 = f3;
            }
            if (true) {
                return solverVariable3;
            }
            if (solverVariable3 == null) break block14;
            solverVariable2 = solverVariable3;
        }
        return solverVariable2;
    }

    public ArrayRow addError(LinearSystem linearSystem, int n) {
        this.variables.put(linearSystem.createErrorVariable(n, "ep"), 1.0f);
        this.variables.put(linearSystem.createErrorVariable(n, "em"), -1.0f);
        return this;
    }

    @Override
    public void addError(SolverVariable solverVariable) {
        float f = 1.0f;
        if (solverVariable.strength == 1) {
            f = 1.0f;
        } else if (solverVariable.strength == 2) {
            f = 1000.0f;
        } else if (solverVariable.strength == 3) {
            f = 1000000.0f;
        } else if (solverVariable.strength == 4) {
            f = 1.0E9f;
        } else if (solverVariable.strength == 5) {
            f = 1.0E12f;
        }
        this.variables.put(solverVariable, f);
    }

    ArrayRow addSingleError(SolverVariable solverVariable, int n) {
        this.variables.put(solverVariable, n);
        return this;
    }

    boolean chooseSubject(LinearSystem object) {
        boolean bl = false;
        if ((object = this.chooseSubjectInVariables((LinearSystem)object)) == null) {
            bl = true;
        } else {
            this.pivot((SolverVariable)object);
        }
        if (this.variables.getCurrentSize() == 0) {
            this.isSimpleDefinition = true;
        }
        return bl;
    }

    SolverVariable chooseSubjectInVariables(LinearSystem linearSystem) {
        SolverVariable solverVariable = null;
        SolverVariable solverVariable2 = null;
        float f = 0.0f;
        float f2 = 0.0f;
        boolean bl = false;
        boolean bl2 = false;
        int n = this.variables.getCurrentSize();
        for (int i = 0; i < n; ++i) {
            boolean bl3;
            float f3;
            float f4;
            SolverVariable solverVariable3;
            boolean bl4;
            SolverVariable solverVariable4;
            float f5 = this.variables.getVariableValue(i);
            SolverVariable solverVariable5 = this.variables.getVariable(i);
            if (solverVariable5.mType == SolverVariable.Type.UNRESTRICTED) {
                if (solverVariable2 == null) {
                    solverVariable4 = solverVariable5;
                    bl4 = this.isNew(solverVariable5, linearSystem);
                    solverVariable3 = solverVariable;
                    f4 = f5;
                    f3 = f2;
                    bl3 = bl2;
                } else if (f > f5) {
                    solverVariable4 = solverVariable5;
                    bl4 = this.isNew(solverVariable5, linearSystem);
                    solverVariable3 = solverVariable;
                    f4 = f5;
                    f3 = f2;
                    bl3 = bl2;
                } else {
                    solverVariable3 = solverVariable;
                    solverVariable4 = solverVariable2;
                    f4 = f;
                    f3 = f2;
                    bl4 = bl;
                    bl3 = bl2;
                    if (!bl) {
                        solverVariable3 = solverVariable;
                        solverVariable4 = solverVariable2;
                        f4 = f;
                        f3 = f2;
                        bl4 = bl;
                        bl3 = bl2;
                        if (this.isNew(solverVariable5, linearSystem)) {
                            bl4 = true;
                            solverVariable3 = solverVariable;
                            solverVariable4 = solverVariable5;
                            f4 = f5;
                            f3 = f2;
                            bl3 = bl2;
                        }
                    }
                }
            } else {
                solverVariable3 = solverVariable;
                solverVariable4 = solverVariable2;
                f4 = f;
                f3 = f2;
                bl4 = bl;
                bl3 = bl2;
                if (solverVariable2 == null) {
                    solverVariable3 = solverVariable;
                    solverVariable4 = solverVariable2;
                    f4 = f;
                    f3 = f2;
                    bl4 = bl;
                    bl3 = bl2;
                    if (f5 < 0.0f) {
                        if (solverVariable == null) {
                            solverVariable3 = solverVariable5;
                            bl3 = this.isNew(solverVariable5, linearSystem);
                            solverVariable4 = solverVariable2;
                            f4 = f;
                            f3 = f5;
                            bl4 = bl;
                        } else if (f2 > f5) {
                            solverVariable3 = solverVariable5;
                            bl3 = this.isNew(solverVariable5, linearSystem);
                            solverVariable4 = solverVariable2;
                            f4 = f;
                            f3 = f5;
                            bl4 = bl;
                        } else {
                            solverVariable3 = solverVariable;
                            solverVariable4 = solverVariable2;
                            f4 = f;
                            f3 = f2;
                            bl4 = bl;
                            bl3 = bl2;
                            if (!bl2) {
                                solverVariable3 = solverVariable;
                                solverVariable4 = solverVariable2;
                                f4 = f;
                                f3 = f2;
                                bl4 = bl;
                                bl3 = bl2;
                                if (this.isNew(solverVariable5, linearSystem)) {
                                    bl3 = true;
                                    bl4 = bl;
                                    f3 = f5;
                                    f4 = f;
                                    solverVariable4 = solverVariable2;
                                    solverVariable3 = solverVariable5;
                                }
                            }
                        }
                    }
                }
            }
            solverVariable = solverVariable3;
            solverVariable2 = solverVariable4;
            f = f4;
            f2 = f3;
            bl = bl4;
            bl2 = bl3;
        }
        if (solverVariable2 != null) {
            return solverVariable2;
        }
        return solverVariable;
    }

    @Override
    public void clear() {
        this.variables.clear();
        this.variable = null;
        this.constantValue = 0.0f;
    }

    ArrayRow createRowCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int n, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int n2) {
        if (solverVariable2 == solverVariable3) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable2, -2.0f);
            return this;
        }
        if (f == 0.5f) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            if (n > 0 || n2 > 0) {
                this.constantValue = -n + n2;
            }
        } else if (f <= 0.0f) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.constantValue = n;
        } else if (f >= 1.0f) {
            this.variables.put(solverVariable4, -1.0f);
            this.variables.put(solverVariable3, 1.0f);
            this.constantValue = -n2;
        } else {
            this.variables.put(solverVariable, (1.0f - f) * 1.0f);
            this.variables.put(solverVariable2, (1.0f - f) * -1.0f);
            this.variables.put(solverVariable3, -1.0f * f);
            this.variables.put(solverVariable4, f * 1.0f);
            if (n > 0 || n2 > 0) {
                this.constantValue = (float)(-n) * (1.0f - f) + (float)n2 * f;
            }
        }
        return this;
    }

    ArrayRow createRowDefinition(SolverVariable solverVariable, int n) {
        this.variable = solverVariable;
        solverVariable.computedValue = n;
        this.constantValue = n;
        this.isSimpleDefinition = true;
        return this;
    }

    ArrayRow createRowDimensionPercent(SolverVariable solverVariable, SolverVariable solverVariable2, float f) {
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, f);
        return this;
    }

    public ArrayRow createRowDimensionRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, 1.0f);
        this.variables.put(solverVariable3, f);
        this.variables.put(solverVariable4, -f);
        return this;
    }

    public ArrayRow createRowEqualDimension(float f, float f2, float f3, SolverVariable solverVariable, int n, SolverVariable solverVariable2, int n2, SolverVariable solverVariable3, int n3, SolverVariable solverVariable4, int n4) {
        if (f2 != 0.0f && f != f3) {
            f = f / f2 / (f3 / f2);
            this.constantValue = (float)(-n - n2) + (float)n3 * f + (float)n4 * f;
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, f);
            this.variables.put(solverVariable3, -f);
        } else {
            this.constantValue = -n - n2 + n3 + n4;
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
        }
        return this;
    }

    public ArrayRow createRowEqualMatchDimensions(float f, float f2, float f3, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        this.constantValue = 0.0f;
        if (f2 != 0.0f && f != f3) {
            if (f == 0.0f) {
                this.variables.put(solverVariable, 1.0f);
                this.variables.put(solverVariable2, -1.0f);
            } else if (f3 == 0.0f) {
                this.variables.put(solverVariable3, 1.0f);
                this.variables.put(solverVariable4, -1.0f);
            } else {
                f = f / f2 / (f3 / f2);
                this.variables.put(solverVariable, 1.0f);
                this.variables.put(solverVariable2, -1.0f);
                this.variables.put(solverVariable4, f);
                this.variables.put(solverVariable3, -f);
            }
        } else {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
        }
        return this;
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, int n) {
        if (n < 0) {
            this.constantValue = n * -1;
            this.variables.put(solverVariable, 1.0f);
        } else {
            this.constantValue = n;
            this.variables.put(solverVariable, -1.0f);
        }
        return this;
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, SolverVariable solverVariable2, int n) {
        int n2 = 0;
        int n3 = 0;
        if (n != 0) {
            n2 = n;
            n = n3;
            n3 = n2;
            if (n2 < 0) {
                n3 = n2 * -1;
                n = 1;
            }
            this.constantValue = n3;
            n2 = n;
        }
        if (n2 == 0) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
        } else {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
        }
        return this;
    }

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, int n, SolverVariable solverVariable2) {
        this.constantValue = n;
        this.variables.put(solverVariable, -1.0f);
        return this;
    }

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int n) {
        int n2 = 0;
        int n3 = 0;
        if (n != 0) {
            n2 = n;
            n = n3;
            n3 = n2;
            if (n2 < 0) {
                n3 = n2 * -1;
                n = 1;
            }
            this.constantValue = n3;
            n2 = n;
        }
        if (n2 == 0) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.variables.put(solverVariable3, 1.0f);
        } else {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, -1.0f);
        }
        return this;
    }

    public ArrayRow createRowLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int n) {
        int n2 = 0;
        int n3 = 0;
        if (n != 0) {
            n2 = n;
            n = n3;
            n3 = n2;
            if (n2 < 0) {
                n3 = n2 * -1;
                n = 1;
            }
            this.constantValue = n3;
            n2 = n;
        }
        if (n2 == 0) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
        } else {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, 1.0f);
        }
        return this;
    }

    public ArrayRow createRowWithAngle(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        this.variables.put(solverVariable3, 0.5f);
        this.variables.put(solverVariable4, 0.5f);
        this.variables.put(solverVariable, -0.5f);
        this.variables.put(solverVariable2, -0.5f);
        this.constantValue = -f;
        return this;
    }

    void ensurePositiveConstant() {
        if (this.constantValue < 0.0f) {
            this.constantValue *= -1.0f;
            this.variables.invert();
        }
    }

    @Override
    public SolverVariable getKey() {
        return this.variable;
    }

    @Override
    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] blArray) {
        return this.pickPivotInVariables(blArray, null);
    }

    boolean hasKeyVariable() {
        boolean bl = !(this.variable == null || this.variable.mType != SolverVariable.Type.UNRESTRICTED && this.constantValue < 0.0f);
        return bl;
    }

    boolean hasVariable(SolverVariable solverVariable) {
        return this.variables.contains(solverVariable);
    }

    @Override
    public void initFromRow(LinearSystem.Row row) {
        if (row instanceof ArrayRow) {
            row = (ArrayRow)row;
            this.variable = null;
            this.variables.clear();
            for (int i = 0; i < ((ArrayRow)row).variables.getCurrentSize(); ++i) {
                SolverVariable solverVariable = ((ArrayRow)row).variables.getVariable(i);
                float f = ((ArrayRow)row).variables.getVariableValue(i);
                this.variables.add(solverVariable, f, true);
            }
        }
    }

    @Override
    public boolean isEmpty() {
        boolean bl = this.variable == null && this.constantValue == 0.0f && this.variables.getCurrentSize() == 0;
        return bl;
    }

    public SolverVariable pickPivot(SolverVariable solverVariable) {
        return this.pickPivotInVariables(null, solverVariable);
    }

    void pivot(SolverVariable solverVariable) {
        if (this.variable != null) {
            this.variables.put(this.variable, -1.0f);
            this.variable = null;
        }
        float f = this.variables.remove(solverVariable, true) * -1.0f;
        this.variable = solverVariable;
        if (f == 1.0f) {
            return;
        }
        this.constantValue /= f;
        this.variables.divideByAmount(f);
    }

    public void reset() {
        this.variable = null;
        this.variables.clear();
        this.constantValue = 0.0f;
        this.isSimpleDefinition = false;
    }

    int sizeInBytes() {
        int n = 0;
        if (this.variable != null) {
            n = 0 + 4;
        }
        return n + 4 + 4 + this.variables.sizeInBytes();
    }

    String toReadableString() {
        String string2 = this.variable == null ? "" + "0" : "" + this.variable;
        Object object = string2 + " = ";
        boolean bl = false;
        string2 = object;
        if (this.constantValue != 0.0f) {
            string2 = (String)object + this.constantValue;
            bl = true;
        }
        int n = this.variables.getCurrentSize();
        for (int i = 0; i < n; ++i) {
            float f;
            float f2;
            object = this.variables.getVariable(i);
            if (object == null || (f2 = this.variables.getVariableValue(i)) == 0.0f) continue;
            String string3 = ((SolverVariable)object).toString();
            if (!bl) {
                object = string2;
                f = f2;
                if (f2 < 0.0f) {
                    object = string2 + "- ";
                    f = f2 * -1.0f;
                }
            } else if (f2 > 0.0f) {
                object = string2 + " + ";
                f = f2;
            } else {
                object = string2 + " - ";
                f = f2 * -1.0f;
            }
            string2 = f == 1.0f ? (String)object + string3 : (String)object + f + " " + string3;
            bl = true;
        }
        object = string2;
        if (!bl) {
            object = string2 + "0.0";
        }
        return object;
    }

    public String toString() {
        return this.toReadableString();
    }

    @Override
    public void updateFromFinalVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean bl) {
        if (!solverVariable.isFinalValue) {
            return;
        }
        float f = this.variables.get(solverVariable);
        this.constantValue += solverVariable.computedValue * f;
        this.variables.remove(solverVariable, bl);
        if (bl) {
            solverVariable.removeFromRow(this);
        }
    }

    @Override
    public void updateFromRow(ArrayRow arrayRow, boolean bl) {
        float f = this.variables.use(arrayRow, bl);
        this.constantValue += arrayRow.constantValue * f;
        if (bl) {
            arrayRow.variable.removeFromRow(this);
        }
    }

    @Override
    public void updateFromSystem(LinearSystem linearSystem) {
        if (linearSystem.mRows.length == 0) {
            return;
        }
        boolean bl = false;
        while (!bl) {
            int n = this.variables.getCurrentSize();
            for (int i = 0; i < n; ++i) {
                SolverVariable solverVariable = this.variables.getVariable(i);
                if (solverVariable.definitionId == -1 && !solverVariable.isFinalValue) continue;
                this.variablesToUpdate.add(solverVariable);
            }
            if (this.variablesToUpdate.size() > 0) {
                for (SolverVariable solverVariable : this.variablesToUpdate) {
                    if (solverVariable.isFinalValue) {
                        this.updateFromFinalVariable(linearSystem, solverVariable, true);
                        continue;
                    }
                    this.updateFromRow(linearSystem.mRows[solverVariable.definitionId], true);
                }
                this.variablesToUpdate.clear();
                continue;
            }
            bl = true;
        }
    }

    public static interface ArrayRowVariables {
        public void add(SolverVariable var1, float var2, boolean var3);

        public void clear();

        public boolean contains(SolverVariable var1);

        public void display();

        public void divideByAmount(float var1);

        public float get(SolverVariable var1);

        public int getCurrentSize();

        public SolverVariable getVariable(int var1);

        public float getVariableValue(int var1);

        public int indexOf(SolverVariable var1);

        public void invert();

        public void put(SolverVariable var1, float var2);

        public float remove(SolverVariable var1, boolean var2);

        public int sizeInBytes();

        public float use(ArrayRow var1, boolean var2);
    }
}

