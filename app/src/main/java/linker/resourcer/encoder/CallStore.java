/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.telecom.Call
 */
package linker.resourcer.encoder;

import android.telecom.Call;

public class CallStore {
    private static Call currentCall;

    public static Call getCurrentCall() {
        return currentCall;
    }

    public static void setCurrentCall(Call call) {
        currentCall = call;
    }
}

