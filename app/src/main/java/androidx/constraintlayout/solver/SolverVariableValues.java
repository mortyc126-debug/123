/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.Arrays;

public class SolverVariableValues
implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    private static final boolean HASH = true;
    private static float epsilon = 0.001f;
    private int HASH_SIZE = 16;
    private final int NONE;
    private int SIZE = 16;
    int head = -1;
    int[] keys = new int[this.SIZE];
    protected final Cache mCache;
    int mCount = 0;
    private final ArrayRow mRow;
    int[] next;
    int[] nextKeys = new int[this.SIZE];
    int[] previous;
    float[] values;
    int[] variables = new int[this.SIZE];

    SolverVariableValues(ArrayRow arrayRow, Cache cache2) {
        this.NONE = -1;
        this.values = new float[this.SIZE];
        this.previous = new int[this.SIZE];
        this.next = new int[this.SIZE];
        this.mRow = arrayRow;
        this.mCache = cache2;
        this.clear();
    }

    private void addToHashMap(SolverVariable solverVariable, int n) {
        int n2;
        int n3 = solverVariable.id % this.HASH_SIZE;
        int n4 = n2 = this.keys[n3];
        if (n2 == -1) {
            this.keys[n3] = n;
        } else {
            while (this.nextKeys[n4] != -1) {
                n4 = this.nextKeys[n4];
            }
            this.nextKeys[n4] = n;
        }
        this.nextKeys[n] = -1;
    }

    private void addVariable(int n, SolverVariable solverVariable, float f) {
        this.variables[n] = solverVariable.id;
        this.values[n] = f;
        this.previous[n] = -1;
        this.next[n] = -1;
        solverVariable.addToRow(this.mRow);
        ++solverVariable.usageInRowCount;
        ++this.mCount;
    }

    private void displayHash() {
        for (int i = 0; i < this.HASH_SIZE; ++i) {
            if (this.keys[i] == -1) continue;
            String string2 = this.hashCode() + " hash [" + i + "] => ";
            int n = this.keys[i];
            boolean bl = false;
            while (!bl) {
                string2 = string2 + " " + this.variables[n];
                if (this.nextKeys[n] != -1) {
                    n = this.nextKeys[n];
                    continue;
                }
                bl = true;
            }
            System.out.println(string2);
        }
    }

    private int findEmptySlot() {
        for (int i = 0; i < this.SIZE; ++i) {
            if (this.variables[i] != -1) continue;
            return i;
        }
        return -1;
    }

    private void increaseSize() {
        int n = this.SIZE * 2;
        this.variables = Arrays.copyOf(this.variables, n);
        this.values = Arrays.copyOf(this.values, n);
        this.previous = Arrays.copyOf(this.previous, n);
        this.next = Arrays.copyOf(this.next, n);
        this.nextKeys = Arrays.copyOf(this.nextKeys, n);
        for (int i = this.SIZE; i < n; ++i) {
            this.variables[i] = -1;
            this.nextKeys[i] = -1;
        }
        this.SIZE = n;
    }

    private void insertVariable(int n, SolverVariable solverVariable, float f) {
        int n2 = this.findEmptySlot();
        this.addVariable(n2, solverVariable, f);
        if (n != -1) {
            this.previous[n2] = n;
            this.next[n2] = this.next[n];
            this.next[n] = n2;
        } else {
            this.previous[n2] = -1;
            if (this.mCount > 0) {
                this.next[n2] = this.head;
                this.head = n2;
            } else {
                this.next[n2] = -1;
            }
        }
        if (this.next[n2] != -1) {
            this.previous[this.next[n2]] = n2;
        }
        this.addToHashMap(solverVariable, n2);
    }

    private void removeFromHashMap(SolverVariable solverVariable) {
        int n = solverVariable.id % this.HASH_SIZE;
        int n2 = this.keys[n];
        if (n2 == -1) {
            return;
        }
        int n3 = solverVariable.id;
        int n4 = n2;
        if (this.variables[n2] == n3) {
            this.keys[n] = this.nextKeys[n2];
            this.nextKeys[n2] = -1;
        } else {
            while (this.nextKeys[n4] != -1 && this.variables[this.nextKeys[n4]] != n3) {
                n4 = this.nextKeys[n4];
            }
            n2 = this.nextKeys[n4];
            if (n2 != -1 && this.variables[n2] == n3) {
                this.nextKeys[n4] = this.nextKeys[n2];
                this.nextKeys[n2] = -1;
            }
        }
    }

    @Override
    public void add(SolverVariable solverVariable, float f, boolean bl) {
        if (f > -epsilon && f < epsilon) {
            return;
        }
        int n = this.indexOf(solverVariable);
        if (n == -1) {
            this.put(solverVariable, f);
        } else {
            float[] fArray = this.values;
            fArray[n] = fArray[n] + f;
            if (this.values[n] > -epsilon && this.values[n] < epsilon) {
                this.values[n] = 0.0f;
                this.remove(solverVariable, bl);
            }
        }
    }

    @Override
    public void clear() {
        int n;
        int n2 = this.mCount;
        for (n = 0; n < n2; ++n) {
            SolverVariable solverVariable = this.getVariable(n);
            if (solverVariable == null) continue;
            solverVariable.removeFromRow(this.mRow);
        }
        for (n = 0; n < this.SIZE; ++n) {
            this.variables[n] = -1;
            this.nextKeys[n] = -1;
        }
        for (n = 0; n < this.HASH_SIZE; ++n) {
            this.keys[n] = -1;
        }
        this.mCount = 0;
        this.head = -1;
    }

    @Override
    public boolean contains(SolverVariable solverVariable) {
        boolean bl = this.indexOf(solverVariable) != -1;
        return bl;
    }

    @Override
    public void display() {
        int n = this.mCount;
        System.out.print("{ ");
        for (int i = 0; i < n; ++i) {
            SolverVariable solverVariable = this.getVariable(i);
            if (solverVariable == null) continue;
            System.out.print(solverVariable + " = " + this.getVariableValue(i) + " ");
        }
        System.out.println(" }");
    }

    @Override
    public void divideByAmount(float f) {
        int n = this.mCount;
        int n2 = this.head;
        for (int i = 0; i < n; ++i) {
            float[] fArray = this.values;
            fArray[n2] = fArray[n2] / f;
            if ((n2 = this.next[n2]) == -1) break;
        }
    }

    @Override
    public float get(SolverVariable solverVariable) {
        int n = this.indexOf(solverVariable);
        if (n != -1) {
            return this.values[n];
        }
        return 0.0f;
    }

    @Override
    public int getCurrentSize() {
        return this.mCount;
    }

    @Override
    public SolverVariable getVariable(int n) {
        int n2 = this.mCount;
        if (n2 == 0) {
            return null;
        }
        int n3 = this.head;
        for (int i = 0; i < n2; ++i) {
            if (i == n && n3 != -1) {
                return this.mCache.mIndexedVariables[this.variables[n3]];
            }
            if ((n3 = this.next[n3]) == -1) break;
        }
        return null;
    }

    @Override
    public float getVariableValue(int n) {
        int n2 = this.mCount;
        int n3 = this.head;
        for (int i = 0; i < n2; ++i) {
            if (i == n) {
                return this.values[n3];
            }
            if ((n3 = this.next[n3]) == -1) break;
        }
        return 0.0f;
    }

    @Override
    public int indexOf(SolverVariable solverVariable) {
        if (this.mCount == 0) {
            return -1;
        }
        int n = solverVariable.id;
        int n2 = this.HASH_SIZE;
        int n3 = this.keys[n % n2];
        if (n3 == -1) {
            return -1;
        }
        n2 = n3;
        if (this.variables[n3] == n) {
            return n3;
        }
        while (this.nextKeys[n2] != -1 && this.variables[this.nextKeys[n2]] != n) {
            n2 = this.nextKeys[n2];
        }
        if (this.nextKeys[n2] == -1) {
            return -1;
        }
        if (this.variables[this.nextKeys[n2]] == n) {
            return this.nextKeys[n2];
        }
        return -1;
    }

    @Override
    public void invert() {
        int n = this.mCount;
        int n2 = this.head;
        for (int i = 0; i < n; ++i) {
            float[] fArray = this.values;
            fArray[n2] = fArray[n2] * -1.0f;
            if ((n2 = this.next[n2]) == -1) break;
        }
    }

    @Override
    public void put(SolverVariable solverVariable, float f) {
        if (f > -epsilon && f < epsilon) {
            this.remove(solverVariable, true);
            return;
        }
        if (this.mCount == 0) {
            this.addVariable(0, solverVariable, f);
            this.addToHashMap(solverVariable, 0);
            this.head = 0;
        } else {
            int n = this.indexOf(solverVariable);
            if (n != -1) {
                this.values[n] = f;
            } else {
                int n2;
                if (this.mCount + 1 >= this.SIZE) {
                    this.increaseSize();
                }
                int n3 = this.mCount;
                int n4 = -1;
                n = this.head;
                int n5 = 0;
                while (true) {
                    n2 = n4;
                    if (n5 >= n3) break;
                    if (this.variables[n] == solverVariable.id) {
                        this.values[n] = f;
                        return;
                    }
                    if (this.variables[n] < solverVariable.id) {
                        n4 = n;
                    }
                    if ((n = this.next[n]) == -1) {
                        n2 = n4;
                        break;
                    }
                    ++n5;
                }
                this.insertVariable(n2, solverVariable, f);
            }
        }
    }

    @Override
    public float remove(SolverVariable solverVariable, boolean bl) {
        int n = this.indexOf(solverVariable);
        if (n == -1) {
            return 0.0f;
        }
        this.removeFromHashMap(solverVariable);
        float f = this.values[n];
        if (this.head == n) {
            this.head = this.next[n];
        }
        this.variables[n] = -1;
        if (this.previous[n] != -1) {
            this.next[this.previous[n]] = this.next[n];
        }
        if (this.next[n] != -1) {
            this.previous[this.next[n]] = this.previous[n];
        }
        --this.mCount;
        --solverVariable.usageInRowCount;
        if (bl) {
            solverVariable.removeFromRow(this.mRow);
        }
        return f;
    }

    @Override
    public int sizeInBytes() {
        return 0;
    }

    public String toString() {
        String string2 = this.hashCode() + " { ";
        int n = this.mCount;
        for (int i = 0; i < n; ++i) {
            SolverVariable solverVariable = this.getVariable(i);
            if (solverVariable == null) continue;
            string2 = string2 + solverVariable + " = " + this.getVariableValue(i) + " ";
            int n2 = this.indexOf(solverVariable);
            string2 = string2 + "[p: ";
            string2 = this.previous[n2] != -1 ? string2 + this.mCache.mIndexedVariables[this.variables[this.previous[n2]]] : string2 + "none";
            string2 = string2 + ", n: ";
            string2 = this.next[n2] != -1 ? string2 + this.mCache.mIndexedVariables[this.variables[this.next[n2]]] : string2 + "none";
            string2 = string2 + "]";
        }
        return string2 + " }";
    }

    @Override
    public float use(ArrayRow object, boolean bl) {
        float f = this.get(((ArrayRow)object).variable);
        this.remove(((ArrayRow)object).variable, bl);
        object = (SolverVariableValues)((ArrayRow)object).variables;
        int n = ((SolverVariableValues)object).getCurrentSize();
        int n2 = ((SolverVariableValues)object).head;
        int n3 = 0;
        n2 = 0;
        while (n3 < n) {
            int n4 = n3;
            if (((SolverVariableValues)object).variables[n2] != -1) {
                float f2 = ((SolverVariableValues)object).values[n2];
                this.add(this.mCache.mIndexedVariables[((SolverVariableValues)object).variables[n2]], f2 * f, bl);
                n4 = n3 + 1;
            }
            ++n2;
            n3 = n4;
        }
        return f;
    }
}

