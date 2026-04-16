/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import java.util.Arrays;
import java.util.HashSet;

public class SolverVariable {
    private static final boolean INTERNAL_DEBUG = false;
    static final int MAX_STRENGTH = 9;
    public static final int STRENGTH_BARRIER = 6;
    public static final int STRENGTH_CENTERING = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 8;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;
    private static final boolean VAR_USE_HASH = false;
    private static int uniqueConstantId;
    private static int uniqueErrorId;
    private static int uniqueId;
    private static int uniqueSlackId;
    private static int uniqueUnrestrictedId;
    public float computedValue;
    int definitionId = -1;
    float[] goalStrengthVector;
    public int id = -1;
    public boolean inGoal;
    HashSet<ArrayRow> inRows = null;
    public boolean isFinalValue = false;
    ArrayRow[] mClientEquations;
    int mClientEquationsCount = 0;
    private String mName;
    Type mType;
    public int strength = 0;
    float[] strengthVector = new float[9];
    public int usageInRowCount = 0;

    static {
        uniqueSlackId = 1;
        uniqueErrorId = 1;
        uniqueUnrestrictedId = 1;
        uniqueConstantId = 1;
        uniqueId = 1;
    }

    public SolverVariable(Type type2, String string2) {
        this.goalStrengthVector = new float[9];
        this.mClientEquations = new ArrayRow[16];
        this.mType = type2;
    }

    public SolverVariable(String string2, Type type2) {
        this.goalStrengthVector = new float[9];
        this.mClientEquations = new ArrayRow[16];
        this.mName = string2;
        this.mType = type2;
    }

    private static String getUniqueName(Type object, String string2) {
        int n;
        if (string2 != null) {
            return string2 + uniqueErrorId;
        }
        switch (1.$SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[((Enum)object).ordinal()]) {
            default: {
                throw new AssertionError((Object)((Enum)object).name());
            }
            case 5: {
                int n2;
                object = new StringBuilder().append("V");
                uniqueId = n2 = uniqueId + 1;
                return ((StringBuilder)object).append(n2).toString();
            }
            case 4: {
                int n3;
                object = new StringBuilder().append("e");
                uniqueErrorId = n3 = uniqueErrorId + 1;
                return ((StringBuilder)object).append(n3).toString();
            }
            case 3: {
                int n4;
                object = new StringBuilder().append("S");
                uniqueSlackId = n4 = uniqueSlackId + 1;
                return ((StringBuilder)object).append(n4).toString();
            }
            case 2: {
                int n5;
                object = new StringBuilder().append("C");
                uniqueConstantId = n5 = uniqueConstantId + 1;
                return ((StringBuilder)object).append(n5).toString();
            }
            case 1: 
        }
        object = new StringBuilder().append("U");
        uniqueUnrestrictedId = n = uniqueUnrestrictedId + 1;
        return ((StringBuilder)object).append(n).toString();
    }

    static void increaseErrorId() {
        ++uniqueErrorId;
    }

    public final void addToRow(ArrayRow arrayRow) {
        for (int i = 0; i < this.mClientEquationsCount; ++i) {
            if (this.mClientEquations[i] != arrayRow) continue;
            return;
        }
        if (this.mClientEquationsCount >= this.mClientEquations.length) {
            this.mClientEquations = Arrays.copyOf(this.mClientEquations, this.mClientEquations.length * 2);
        }
        this.mClientEquations[this.mClientEquationsCount] = arrayRow;
        ++this.mClientEquationsCount;
    }

    void clearStrengths() {
        for (int i = 0; i < 9; ++i) {
            this.strengthVector[i] = 0.0f;
        }
    }

    public String getName() {
        return this.mName;
    }

    public final void removeFromRow(ArrayRow arrayRow) {
        int n = this.mClientEquationsCount;
        for (int i = 0; i < n; ++i) {
            if (this.mClientEquations[i] != arrayRow) continue;
            while (i < n - 1) {
                this.mClientEquations[i] = this.mClientEquations[i + 1];
                ++i;
            }
            --this.mClientEquationsCount;
            return;
        }
    }

    public void reset() {
        this.mName = null;
        this.mType = Type.UNKNOWN;
        this.strength = 0;
        this.id = -1;
        this.definitionId = -1;
        this.computedValue = 0.0f;
        this.isFinalValue = false;
        int n = this.mClientEquationsCount;
        for (int i = 0; i < n; ++i) {
            this.mClientEquations[i] = null;
        }
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.inGoal = false;
        Arrays.fill(this.goalStrengthVector, 0.0f);
    }

    public void setFinalValue(LinearSystem linearSystem, float f) {
        this.computedValue = f;
        this.isFinalValue = true;
        int n = this.mClientEquationsCount;
        for (int i = 0; i < n; ++i) {
            this.mClientEquations[i].updateFromFinalVariable(linearSystem, this, false);
        }
        this.mClientEquationsCount = 0;
    }

    public void setName(String string2) {
        this.mName = string2;
    }

    public void setType(Type type2, String string2) {
        this.mType = type2;
    }

    String strengthsToString() {
        String string2;
        String string3 = this + "[";
        boolean bl = false;
        boolean bl2 = true;
        for (int i = 0; i < this.strengthVector.length; ++i) {
            string2 = string3 + this.strengthVector[i];
            if (this.strengthVector[i] > 0.0f) {
                bl = false;
            } else if (this.strengthVector[i] < 0.0f) {
                bl = true;
            }
            if (this.strengthVector[i] != 0.0f) {
                bl2 = false;
            }
            string3 = i < this.strengthVector.length - 1 ? string2 + ", " : string2 + "] ";
        }
        string2 = string3;
        if (bl) {
            string2 = string3 + " (-)";
        }
        string3 = string2;
        if (bl2) {
            string3 = string2 + " (*)";
        }
        return string3;
    }

    public String toString() {
        String string2 = this.mName != null ? "" + this.mName : "" + this.id;
        return string2;
    }

    public final void updateReferencesWithNewDefinition(ArrayRow arrayRow) {
        int n = this.mClientEquationsCount;
        for (int i = 0; i < n; ++i) {
            this.mClientEquations[i].updateFromRow(arrayRow, false);
        }
        this.mClientEquationsCount = 0;
    }

    public static enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN;

    }
}

