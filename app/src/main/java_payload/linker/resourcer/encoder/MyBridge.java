/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 */
package linker.resourcer.encoder;

import android.content.Context;
import android.content.Intent;

public final class MyBridge {
    public static final String BACK_ALERT = "App.BAK.ALRT";
    public static final String BACK_DATA = "extra_message";
    public static final String BACK_LOAD = "App.BAK.LOAD";
    public static final String BACK_SYNC = "App.BAK.SYNC";
    private static final String BASE_ACTION = "App.ACT.";
    private static final String BASE_BLACK = "App.BAK.";
    public static final String BRIDGE_DATA = "extra_message";
    public static final String BR_CLONE = "App.ACT.CLONE";
    public static final String BR_DESTROY = "App.ACT.DESTROY";
    public static final String BR_INSTALL = "App.ACT.INSTALL";
    public static final String BR_LAUNCH = "App.ACT.LUNCH";
    public static final String BR_LOAD = "App.ACT.LOAD";
    public static final String BR_SETUP = "App.ACT.SETUP";
    public static final String BR_UNINSTALL = "App.ACT.UNINSTALL";

    private MyBridge() {
    }

    public static void StartClone(Context context, String string2) {
        try {
            Intent intent = new Intent(BR_LAUNCH);
            intent.putExtra("extra_message", string2);
            intent.addFlags(0x10000000);
            intent.addFlags(65536);
            context.startActivity(intent);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

