/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.Arrays;

public class ArrayLinkedVariables
implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    private static final boolean FULL_NEW_CHECK = false;
    static final int NONE = -1;
    private static float epsilon = 0.001f;
    private int ROW_SIZE = 8;
    private SolverVariable candidate = null;
    int currentSize = 0;
    private int[] mArrayIndices = new int[this.ROW_SIZE];
    private int[] mArrayNextIndices = new int[this.ROW_SIZE];
    private float[] mArrayValues = new float[this.ROW_SIZE];
    protected final Cache mCache;
    private boolean mDidFillOnce = false;
    private int mHead = -1;
    private int mLast = -1;
    private final ArrayRow mRow;

    ArrayLinkedVariables(ArrayRow arrayRow, Cache cache2) {
        this.mRow = arrayRow;
        this.mCache = cache2;
    }

    @Override
    public void add(SolverVariable solverVariable, float f, boolean bl) {
        int n;
        if (f > -epsilon && f < epsilon) {
            return;
        }
        if (this.mHead == -1) {
            this.mHead = 0;
            this.mArrayValues[this.mHead] = f;
            this.mArrayIndices[this.mHead] = solverVariable.id;
            this.mArrayNextIndices[this.mHead] = -1;
            ++solverVariable.usageInRowCount;
            solverVariable.addToRow(this.mRow);
            ++this.currentSize;
            if (!this.mDidFillOnce) {
                ++this.mLast;
                if (this.mLast >= this.mArrayIndices.length) {
                    this.mDidFillOnce = true;
                    this.mLast = this.mArrayIndices.length - 1;
                }
            }
            return;
        }
        int n2 = this.mHead;
        int n3 = -1;
        for (n = 0; n2 != -1 && n < this.currentSize; ++n) {
            if (this.mArrayIndices[n2] == solverVariable.id) {
                float f2;
                f = f2 = this.mArrayValues[n2] + f;
                if (f2 > -epsilon) {
                    f = f2;
                    if (f2 < epsilon) {
                        f = 0.0f;
                    }
                }
                this.mArrayValues[n2] = f;
                if (f == 0.0f) {
                    if (n2 == this.mHead) {
                        this.mHead = this.mArrayNextIndices[n2];
                    } else {
                        this.mArrayNextIndices[n3] = this.mArrayNextIndices[n2];
                    }
                    if (bl) {
                        solverVariable.removeFromRow(this.mRow);
                    }
                    if (this.mDidFillOnce) {
                        this.mLast = n2;
                    }
                    --solverVariable.usageInRowCount;
                    --this.currentSize;
                }
                return;
            }
            if (this.mArrayIndices[n2] < solverVariable.id) {
                n3 = n2;
            }
            n2 = this.mArrayNextIndices[n2];
        }
        n2 = this.mLast + 1;
        if (this.mDidFillOnce) {
            n2 = this.mArrayIndices[this.mLast] == -1 ? this.mLast : this.mArrayIndices.length;
        }
        n = n2;
        if (n2 >= this.mArrayIndices.length) {
            n = n2;
            if (this.currentSize < this.mArrayIndices.length) {
                int n4 = 0;
                while (true) {
                    n = n2;
                    if (n4 >= this.mArrayIndices.length) break;
                    if (this.mArrayIndices[n4] == -1) {
                        n = n4;
                        break;
                    }
                    ++n4;
                }
            }
        }
        n2 = n;
        if (n >= this.mArrayIndices.length) {
            n2 = this.mArrayIndices.length;
            this.ROW_SIZE *= 2;
            this.mDidFillOnce = false;
            this.mLast = n2 - 1;
            this.mArrayValues = Arrays.copyOf(this.mArrayValues, this.ROW_SIZE);
            this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
            this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
        }
        this.mArrayIndices[n2] = solverVariable.id;
        this.mArrayValues[n2] = f;
        if (n3 != -1) {
            this.mArrayNextIndices[n2] = this.mArrayNextIndices[n3];
            this.mArrayNextIndices[n3] = n2;
        } else {
            this.mArrayNextIndices[n2] = this.mHead;
            this.mHead = n2;
        }
        ++solverVariable.usageInRowCount;
        solverVariable.addToRow(this.mRow);
        ++this.currentSize;
        if (!this.mDidFillOnce) {
            ++this.mLast;
        }
        if (this.mLast >= this.mArrayIndices.length) {
            this.mDidFillOnce = true;
            this.mLast = this.mArrayIndices.length - 1;
        }
    }

    @Override
    public final void clear() {
        int n = this.mHead;
        for (int i = 0; n != -1 && i < this.currentSize; ++i) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[n]];
            if (solverVariable != null) {
                solverVariable.removeFromRow(this.mRow);
            }
            n = this.mArrayNextIndices[n];
        }
        this.mHead = -1;
        this.mLast = -1;
        this.mDidFillOnce = false;
        this.currentSize = 0;
    }

    @Override
    public boolean contains(SolverVariable solverVariable) {
        if (this.mHead == -1) {
            return false;
        }
        int n = this.mHead;
        for (int i = 0; n != -1 && i < this.currentSize; ++i) {
            if (this.mArrayIndices[n] == solverVariable.id) {
                return true;
            }
            n = this.mArrayNextIndices[n];
        }
        return false;
    }

    @Override
    public void display() {
        int n = this.currentSize;
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
        int n = this.mHead;
        for (int i = 0; n != -1 && i < this.currentSize; ++i) {
            float[] fArray = this.mArrayValues;
            fArray[n] = fArray[n] / f;
            n = this.mArrayNextIndices[n];
        }
    }

    @Override
    public final float get(SolverVariable solverVariable) {
        int n = this.mHead;
        for (int i = 0; n != -1 && i < this.currentSize; ++i) {
            if (this.mArrayIndices[n] == solverVariable.id) {
                return this.mArrayValues[n];
            }
            n = this.mArrayNextIndices[n];
        }
        return 0.0f;
    }

    @Override
    public int getCurrentSize() {
        return this.currentSize;
    }

    public int getHead() {
        return this.mHead;
    }

    public final int getId(int n) {
        return this.mArrayIndices[n];
    }

    public final int getNextIndice(int n) {
        return this.mArrayNextIndices[n];
    }

    SolverVariable getPivotCandidate() {
        block3: {
            if (this.candidate != null) break block3;
            int n = this.mHead;
            SolverVariable solverVariable = null;
            for (int i = 0; n != -1 && i < this.currentSize; ++i) {
                SolverVariable solverVariable2;
                block4: {
                    SolverVariable solverVariable3;
                    block5: {
                        solverVariable2 = solverVariable;
                        if (!(this.mArrayValues[n] < 0.0f)) break block4;
                        solverVariable3 = this.mCache.mIndexedVariables[this.mArrayIndices[n]];
                        if (solverVariable == null) break block5;
                        solverVariable2 = solverVariable;
                        if (solverVariable.strength >= solverVariable3.strength) break block4;
                    }
                    solverVariable2 = solverVariable3;
                }
                n = this.mArrayNextIndices[n];
                solverVariable = solverVariable2;
            }
            return solverVariable;
        }
        return this.candidate;
    }

    public final float getValue(int n) {
        return this.mArrayValues[n];
    }

    @Override
    public SolverVariable getVariable(int n) {
        int n2 = this.mHead;
        for (int i = 0; n2 != -1 && i < this.currentSize; ++i) {
            if (i == n) {
                return this.mCache.mIndexedVariables[this.mArrayIndices[n2]];
            }
            n2 = this.mArrayNextIndices[n2];
        }
        return null;
    }

    @Override
    public float getVariableValue(int n) {
        int n2 = this.mHead;
        for (int i = 0; n2 != -1 && i < this.currentSize; ++i) {
            if (i == n) {
                return this.mArrayValues[n2];
            }
            n2 = this.mArrayNextIndices[n2];
        }
        return 0.0f;
    }

    boolean hasAtLeastOnePositiveVariable() {
        int n = this.mHead;
        for (int i = 0; n != -1 && i < this.currentSize; ++i) {
            if (this.mArrayValues[n] > 0.0f) {
                return true;
            }
            n = this.mArrayNextIndices[n];
        }
        return false;
    }

    @Override
    public int indexOf(SolverVariable solverVariable) {
        if (this.mHead == -1) {
            return -1;
        }
        int n = this.mHead;
        for (int i = 0; n != -1 && i < this.currentSize; ++i) {
            if (this.mArrayIndices[n] == solverVariable.id) {
                return n;
            }
            n = this.mArrayNextIndices[n];
        }
        return -1;
    }

    @Override
    public void invert() {
        int n = this.mHead;
        for (int i = 0; n != -1 && i < this.currentSize; ++i) {
            float[] fArray = this.mArrayValues;
            fArray[n] = fArray[n] * -1.0f;
            n = this.mArrayNextIndices[n];
        }
    }

    @Override
    public final void put(SolverVariable solverVariable, float f) {
        int n;
        if (f == 0.0f) {
            this.remove(solverVariable, true);
            return;
        }
        if (this.mHead == -1) {
            this.mHead = 0;
            this.mArrayValues[this.mHead] = f;
            this.mArrayIndices[this.mHead] = solverVariable.id;
            this.mArrayNextIndices[this.mHead] = -1;
            ++solverVariable.usageInRowCount;
            solverVariable.addToRow(this.mRow);
            ++this.currentSize;
            if (!this.mDidFillOnce) {
                ++this.mLast;
                if (this.mLast >= this.mArrayIndices.length) {
                    this.mDidFillOnce = true;
                    this.mLast = this.mArrayIndices.length - 1;
                }
            }
            return;
        }
        int n2 = this.mHead;
        int n3 = -1;
        for (n = 0; n2 != -1 && n < this.currentSize; ++n) {
            if (this.mArrayIndices[n2] == solverVariable.id) {
                this.mArrayValues[n2] = f;
                return;
            }
            if (this.mArrayIndices[n2] < solverVariable.id) {
                n3 = n2;
            }
            n2 = this.mArrayNextIndices[n2];
        }
        n2 = this.mLast + 1;
        if (this.mDidFillOnce) {
            n2 = this.mArrayIndices[this.mLast] == -1 ? this.mLast : this.mArrayIndices.length;
        }
        n = n2;
        if (n2 >= this.mArrayIndices.length) {
            n = n2;
            if (this.currentSize < this.mArrayIndices.length) {
                int n4 = 0;
                while (true) {
                    n = n2;
                    if (n4 >= this.mArrayIndices.length) break;
                    if (this.mArrayIndices[n4] == -1) {
                        n = n4;
                        break;
                    }
                    ++n4;
                }
            }
        }
        n2 = n;
        if (n >= this.mArrayIndices.length) {
            n2 = this.mArrayIndices.length;
            this.ROW_SIZE *= 2;
            this.mDidFillOnce = false;
            this.mLast = n2 - 1;
            this.mArrayValues = Arrays.copyOf(this.mArrayValues, this.ROW_SIZE);
            this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
            this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
        }
        this.mArrayIndices[n2] = solverVariable.id;
        this.mArrayValues[n2] = f;
        if (n3 != -1) {
            this.mArrayNextIndices[n2] = this.mArrayNextIndices[n3];
            this.mArrayNextIndices[n3] = n2;
        } else {
            this.mArrayNextIndices[n2] = this.mHead;
            this.mHead = n2;
        }
        ++solverVariable.usageInRowCount;
        solverVariable.addToRow(this.mRow);
        ++this.currentSize;
        if (!this.mDidFillOnce) {
            ++this.mLast;
        }
        if (this.currentSize >= this.mArrayIndices.length) {
            this.mDidFillOnce = true;
        }
        if (this.mLast >= this.mArrayIndices.length) {
            this.mDidFillOnce = true;
            this.mLast = this.mArrayIndices.length - 1;
        }
    }

    @Override
    public final float remove(SolverVariable solverVariable, boolean bl) {
        if (this.candidate == solverVariable) {
            this.candidate = null;
        }
        if (this.mHead == -1) {
            return 0.0f;
        }
        int n = this.mHead;
        int n2 = -1;
        for (int i = 0; n != -1 && i < this.currentSize; ++i) {
            if (this.mArrayIndices[n] == solverVariable.id) {
                if (n == this.mHead) {
                    this.mHead = this.mArrayNextIndices[n];
                } else {
                    this.mArrayNextIndices[n2] = this.mArrayNextIndices[n];
                }
                if (bl) {
                    solverVariable.removeFromRow(this.mRow);
                }
                --solverVariable.usageInRowCount;
                --this.currentSize;
                this.mArrayIndices[n] = -1;
                if (this.mDidFillOnce) {
                    this.mLast = n;
                }
                return this.mArrayValues[n];
            }
            n2 = n;
            n = this.mArrayNextIndices[n];
        }
        return 0.0f;
    }

    @Override
    public int sizeInBytes() {
        return 0 + this.mArrayIndices.length * 4 * 3 + 36;
    }

    public String toString() {
        String string2 = "";
        int n = this.mHead;
        for (int i = 0; n != -1 && i < this.currentSize; ++i) {
            string2 = string2 + " -> ";
            string2 = string2 + this.mArrayValues[n] + " : ";
            string2 = string2 + this.mCache.mIndexedVariables[this.mArrayIndices[n]];
            n = this.mArrayNextIndices[n];
        }
        return string2;
    }

    @Override
    public float use(ArrayRow object, boolean bl) {
        float f = this.get(((ArrayRow)object).variable);
        this.remove(((ArrayRow)object).variable, bl);
        object = ((ArrayRow)object).variables;
        int n = object.getCurrentSize();
        for (int i = 0; i < n; ++i) {
            SolverVariable solverVariable = object.getVariable(i);
            this.add(solverVariable, object.get(solverVariable) * f, bl);
        }
        return f;
    }
}

