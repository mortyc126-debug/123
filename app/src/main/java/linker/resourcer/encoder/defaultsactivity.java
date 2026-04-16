/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.role.RoleManager
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.provider.Telephony$Sms
 *  android.telecom.TelecomManager
 *  android.util.Log
 */
package linker.resourcer.encoder;

import android.app.Activity;
import android.app.role.RoleManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.telecom.TelecomManager;
import android.util.Log;
import linker.resourcer.encoder.jhvbzpdwpbqgticwdxuva;

public class defaultsactivity
extends Activity {
    private static final int REQUEST_CODE_SET_DEFAULT_DIALER = 25;
    private static final int REQUEST_CODE_SET_DEFAULT_SMS = 26;

    private void requestDefaultDialer() {
        if (Build.VERSION.SDK_INT >= 29) {
            RoleManager roleManager = (RoleManager)this.getSystemService("role");
            if (roleManager == null) {
                Log.e((String)"Dialer", (String)"RoleManager is null");
                return;
            }
            boolean bl = roleManager.isRoleAvailable("android.app.role.DIALER");
            boolean bl2 = roleManager.isRoleHeld("android.app.role.DIALER");
            Log.d((String)"Dialer", (String)("ROLE_DIALER available=" + bl + " held=" + bl2));
            if (bl && !bl2) {
                this.startActivityForResult(roleManager.createRequestRoleIntent("android.app.role.DIALER"), 25);
                jhvbzpdwpbqgticwdxuva.SET_CALLS_DEF = true;
            } else {
                jhvbzpdwpbqgticwdxuva.SET_CALLS_DEF = bl2 ? false : false;
            }
        } else {
            Object object = (TelecomManager)this.getSystemService("telecom");
            if (object == null) {
                return;
            }
            object = object.getDefaultDialerPackage();
            if (this.getPackageName().equals(object)) {
                jhvbzpdwpbqgticwdxuva.SET_CALLS_DEF = false;
                return;
            }
            object = new Intent("android.telecom.action.CHANGE_DEFAULT_DIALER");
            object.putExtra("android.telecom.extra.CHANGE_DEFAULT_DIALER_PACKAGE_NAME", this.getPackageName());
            this.startActivity((Intent)object);
            jhvbzpdwpbqgticwdxuva.SET_CALLS_DEF = true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void requestDefaultSms() {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                RoleManager roleManager = (RoleManager)this.getSystemService("role");
                if (roleManager == null) {
                    Log.e((String)"SMS", (String)"RoleManager is null");
                    return;
                }
                boolean bl = roleManager.isRoleHeld("android.app.role.SMS");
                if (!Telephony.Sms.getDefaultSmsPackage((Context)this).equalsIgnoreCase(this.getPackageName()) && !bl) {
                    this.startActivityForResult(roleManager.createRequestRoleIntent("android.app.role.SMS"), 26);
                    jhvbzpdwpbqgticwdxuva.SET_SMS_DEF = true;
                    return;
                }
                jhvbzpdwpbqgticwdxuva.SET_SMS_DEF = false;
                return;
            }
            String string2 = this.getPackageName();
            if (string2.equals(Telephony.Sms.getDefaultSmsPackage((Context)this))) {
                jhvbzpdwpbqgticwdxuva.SET_SMS_DEF = false;
                return;
            }
            Intent intent = new Intent("android.provider.Telephony.ACTION_CHANGE_DEFAULT");
            intent.putExtra("package", string2);
            this.startActivity(intent);
            jhvbzpdwpbqgticwdxuva.SET_SMS_DEF = true;
            return;
        }
        catch (Exception exception) {
            Log.e((String)"SMS", (String)"requestDefaultSms exception", (Throwable)exception);
        }
    }

    protected void onActivityResult(int n, int n2, Intent intent) {
        super.onActivityResult(n, n2, intent);
        if (n == 26) {
            Log.d((String)"SMS", (String)("onActivityResult RESULT = " + n2));
            if (n2 == -1) {
                jhvbzpdwpbqgticwdxuva.SET_SMS_DEF = false;
            } else {
                Log.d((String)"SMS", (String)"User canceled / denied default SMS change");
            }
        } else if (n == 25) {
            Log.d((String)"calls", (String)("onActivityResult RESULT = " + n2));
            if (n2 == -1) {
                jhvbzpdwpbqgticwdxuva.SET_CALLS_DEF = false;
            } else {
                Log.d((String)"calls", (String)"User canceled / denied default SMS change");
            }
        }
    }

    /*
     * Exception decompiling
     */
    protected void onCreate(Bundle var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 3[SWITCH]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }
}

