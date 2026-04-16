/*
 * Decompiled with CFR 0.152.
 */
package androidx.profileinstaller;

import java.util.Arrays;

public class ProfileVersion {
    public static final int MAX_SUPPORTED_SDK = 33;
    static final byte[] METADATA_V001_N;
    static final byte[] METADATA_V002;
    public static final int MIN_SUPPORTED_SDK = 24;
    static final byte[] V001_N;
    static final byte[] V005_O;
    static final byte[] V009_O_MR1;
    static final byte[] V010_P;
    static final byte[] V015_S;

    static {
        V015_S = new byte[]{48, 49, 53, 0};
        V010_P = new byte[]{48, 49, 48, 0};
        V009_O_MR1 = new byte[]{48, 48, 57, 0};
        V005_O = new byte[]{48, 48, 53, 0};
        V001_N = new byte[]{48, 48, 49, 0};
        METADATA_V001_N = new byte[]{48, 48, 49, 0};
        METADATA_V002 = new byte[]{48, 48, 50, 0};
    }

    private ProfileVersion() {
    }

    static String dexKeySeparator(byte[] byArray) {
        if (Arrays.equals(byArray, V001_N)) {
            return ":";
        }
        if (Arrays.equals(byArray, V005_O)) {
            return ":";
        }
        return "!";
    }
}

