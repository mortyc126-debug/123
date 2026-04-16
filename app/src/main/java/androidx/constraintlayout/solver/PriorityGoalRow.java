/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.Arrays;
import java.util.Comparator;

public class PriorityGoalRow
extends ArrayRow {
    private static final boolean DEBUG = false;
    static final int NOT_FOUND = -1;
    private static final float epsilon = 1.0E-4f;
    private int TABLE_SIZE = 128;
    GoalVariableAccessor accessor;
    private SolverVariable[] arrayGoals = new SolverVariable[this.TABLE_SIZE];
    Cache mCache;
    private int numGoals = 0;
    private SolverVariable[] sortArray = new SolverVariable[this.TABLE_SIZE];

    public PriorityGoalRow(Cache cache2) {
        super(cache2);
        this.accessor = new GoalVariableAccessor(this, this);
        this.mCache = cache2;
    }

    private final void addToGoal(SolverVariable solverVariable) {
        if (this.numGoals + 1 > this.arrayGoals.length) {
            this.arrayGoals = Arrays.copyOf(this.arrayGoals, this.arrayGoals.length * 2);
            this.sortArray = Arrays.copyOf(this.arrayGoals, this.arrayGoals.length * 2);
        }
        this.arrayGoals[this.numGoals] = solverVariable;
        ++this.numGoals;
        if (this.numGoals > 1 && this.arrayGoals[this.numGoals - 1].id > solverVariable.id) {
            int n;
            for (n = 0; n < this.numGoals; ++n) {
                this.sortArray[n] = this.arrayGoals[n];
            }
            Arrays.sort(this.sortArray, 0, this.numGoals, new Comparator<SolverVariable>(this){
                final PriorityGoalRow this$0;
                {
                    this.this$0 = priorityGoalRow;
                }

                @Override
                public int compare(SolverVariable solverVariable, SolverVariable solverVariable2) {
                    return solverVariable.id - solverVariable2.id;
                }
            });
            for (n = 0; n < this.numGoals; ++n) {
                this.arrayGoals[n] = this.sortArray[n];
            }
        }
        solverVariable.inGoal = true;
        solverVariable.addToRow(this);
    }

    private final void removeGoal(SolverVariable solverVariable) {
        for (int i = 0; i < this.numGoals; ++i) {
            if (this.arrayGoals[i] != solverVariable) continue;
            while (i < this.numGoals - 1) {
                this.arrayGoals[i] = this.arrayGoals[i + 1];
                ++i;
            }
            --this.numGoals;
            solverVariable.inGoal = false;
            return;
        }
    }

    @Override
    public void addError(SolverVariable solverVariable) {
        this.accessor.init(solverVariable);
        this.accessor.reset();
        solverVariable.goalStrengthVector[solverVariable.strength] = 1.0f;
        this.addToGoal(solverVariable);
    }

    @Override
    public void clear() {
        this.numGoals = 0;
        this.constantValue = 0.0f;
    }

    @Override
    public SolverVariable getPivotCandidate(LinearSystem object, boolean[] blArray) {
        int n = -1;
        for (int i = 0; i < this.numGoals; ++i) {
            int n2;
            object = this.arrayGoals[i];
            if (blArray[((SolverVariable)object).id]) {
                n2 = n;
            } else {
                this.accessor.init((SolverVariable)object);
                if (n == -1) {
                    n2 = n;
                    if (this.accessor.isNegative()) {
                        n2 = i;
                    }
                } else {
                    n2 = n;
                    if (this.accessor.isSmallerThan(this.arrayGoals[n])) {
                        n2 = i;
                    }
                }
            }
            n = n2;
        }
        if (n == -1) {
            return null;
        }
        return this.arrayGoals[n];
    }

    @Override
    public String toString() {
        String string2 = "" + " goal -> (" + this.constantValue + ") : ";
        for (int i = 0; i < this.numGoals; ++i) {
            SolverVariable solverVariable = this.arrayGoals[i];
            this.accessor.init(solverVariable);
            string2 = string2 + this.accessor + " ";
        }
        return string2;
    }

    @Override
    public void updateFromRow(ArrayRow arrayRow, boolean bl) {
        SolverVariable solverVariable = arrayRow.variable;
        if (solverVariable == null) {
            return;
        }
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
        int n = arrayRowVariables.getCurrentSize();
        for (int i = 0; i < n; ++i) {
            SolverVariable solverVariable2 = arrayRowVariables.getVariable(i);
            float f = arrayRowVariables.getVariableValue(i);
            this.accessor.init(solverVariable2);
            if (this.accessor.addToGoal(solverVariable, f)) {
                this.addToGoal(solverVariable2);
            }
            this.constantValue += arrayRow.constantValue * f;
        }
        this.removeGoal(solverVariable);
    }

    class GoalVariableAccessor
    implements Comparable {
        PriorityGoalRow row;
        final PriorityGoalRow this$0;
        SolverVariable variable;

        public GoalVariableAccessor(PriorityGoalRow priorityGoalRow, PriorityGoalRow priorityGoalRow2) {
            this.this$0 = priorityGoalRow;
            this.row = priorityGoalRow2;
        }

        public void add(SolverVariable solverVariable) {
            for (int i = 0; i < 9; ++i) {
                float[] fArray = this.variable.goalStrengthVector;
                fArray[i] = fArray[i] + solverVariable.goalStrengthVector[i];
                if (!(Math.abs(this.variable.goalStrengthVector[i]) < 1.0E-4f)) continue;
                this.variable.goalStrengthVector[i] = 0.0f;
            }
        }

        public boolean addToGoal(SolverVariable solverVariable, float f) {
            if (this.variable.inGoal) {
                boolean bl = true;
                for (int i = 0; i < 9; ++i) {
                    float[] fArray = this.variable.goalStrengthVector;
                    fArray[i] = fArray[i] + solverVariable.goalStrengthVector[i] * f;
                    if (Math.abs(this.variable.goalStrengthVector[i]) < 1.0E-4f) {
                        this.variable.goalStrengthVector[i] = 0.0f;
                        continue;
                    }
                    bl = false;
                }
                if (bl) {
                    this.this$0.removeGoal(this.variable);
                }
                return false;
            }
            for (int i = 0; i < 9; ++i) {
                float f2 = solverVariable.goalStrengthVector[i];
                if (f2 != 0.0f) {
                    float f3;
                    f2 = f3 = f * f2;
                    if (Math.abs(f3) < 1.0E-4f) {
                        f2 = 0.0f;
                    }
                    this.variable.goalStrengthVector[i] = f2;
                    continue;
                }
                this.variable.goalStrengthVector[i] = 0.0f;
            }
            return true;
        }

        public int compareTo(Object object) {
            object = (SolverVariable)object;
            return this.variable.id - ((SolverVariable)object).id;
        }

        public void init(SolverVariable solverVariable) {
            this.variable = solverVariable;
        }

        public final boolean isNegative() {
            for (int i = 8; i >= 0; --i) {
                float f = this.variable.goalStrengthVector[i];
                if (f > 0.0f) {
                    return false;
                }
                if (!(f < 0.0f)) continue;
                return true;
            }
            return false;
        }

        public final boolean isNull() {
            for (int i = 0; i < 9; ++i) {
                if (this.variable.goalStrengthVector[i] == 0.0f) continue;
                return false;
            }
            return true;
        }

        public final boolean isSmallerThan(SolverVariable solverVariable) {
            for (int i = 8; i >= 0; --i) {
                float f = this.variable.goalStrengthVector[i];
                float f2 = solverVariable.goalStrengthVector[i];
                if (f == f2) {
                    continue;
                }
                return f < f2;
            }
            return false;
        }

        public void reset() {
            Arrays.fill(this.variable.goalStrengthVector, 0.0f);
        }

        public String toString() {
            String string2;
            String string3 = string2 = "[ ";
            if (this.variable != null) {
                int n = 0;
                while (true) {
                    string3 = string2;
                    if (n >= 9) break;
                    string2 = string2 + this.variable.goalStrengthVector[n] + " ";
                    ++n;
                }
            }
            return string3 + "] " + this.variable;
        }
    }
}

