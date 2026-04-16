/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.AssetManager
 *  android.util.Log
 */
package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.util.Log;
import androidx.profileinstaller.DeviceProfileWriter;
import androidx.profileinstaller.ProfileInstallReceiver$$ExternalSyntheticLambda0;
import androidx.profileinstaller.ProfileInstaller$$ExternalSyntheticLambda0;
import androidx.profileinstaller.ProfileInstaller$$ExternalSyntheticLambda1;
import androidx.profileinstaller.ProfileVerifier;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

public class ProfileInstaller {
    public static final int DIAGNOSTIC_CURRENT_PROFILE_DOES_NOT_EXIST = 2;
    public static final int DIAGNOSTIC_CURRENT_PROFILE_EXISTS = 1;
    public static final int DIAGNOSTIC_PROFILE_IS_COMPRESSED = 5;
    public static final int DIAGNOSTIC_REF_PROFILE_DOES_NOT_EXIST = 4;
    public static final int DIAGNOSTIC_REF_PROFILE_EXISTS = 3;
    private static final DiagnosticsCallback EMPTY_DIAGNOSTICS = new DiagnosticsCallback(){

        @Override
        public void onDiagnosticReceived(int n, Object object) {
        }

        @Override
        public void onResultReceived(int n, Object object) {
        }
    };
    static final DiagnosticsCallback LOG_DIAGNOSTICS = new DiagnosticsCallback(){
        static final String TAG = "ProfileInstaller";

        @Override
        public void onDiagnosticReceived(int n, Object object) {
            object = "";
            switch (n) {
                default: {
                    break;
                }
                case 5: {
                    object = "DIAGNOSTIC_PROFILE_IS_COMPRESSED";
                    break;
                }
                case 4: {
                    object = "DIAGNOSTIC_REF_PROFILE_DOES_NOT_EXIST";
                    break;
                }
                case 3: {
                    object = "DIAGNOSTIC_REF_PROFILE_EXISTS";
                    break;
                }
                case 2: {
                    object = "DIAGNOSTIC_CURRENT_PROFILE_DOES_NOT_EXIST";
                    break;
                }
                case 1: {
                    object = "DIAGNOSTIC_CURRENT_PROFILE_EXISTS";
                }
            }
            Log.d((String)"ProfileInstaller", (String)object);
        }

        @Override
        public void onResultReceived(int n, Object object) {
            String string2 = "";
            switch (n) {
                default: {
                    break;
                }
                case 11: {
                    string2 = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                    break;
                }
                case 10: {
                    string2 = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                    break;
                }
                case 8: {
                    string2 = "RESULT_PARSE_EXCEPTION";
                    break;
                }
                case 7: {
                    string2 = "RESULT_IO_EXCEPTION";
                    break;
                }
                case 6: {
                    string2 = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                    break;
                }
                case 5: {
                    string2 = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                    break;
                }
                case 4: {
                    string2 = "RESULT_NOT_WRITABLE";
                    break;
                }
                case 3: {
                    string2 = "RESULT_UNSUPPORTED_ART_VERSION";
                    break;
                }
                case 2: {
                    string2 = "RESULT_ALREADY_INSTALLED";
                    break;
                }
                case 1: {
                    string2 = "RESULT_INSTALL_SUCCESS";
                }
            }
            switch (n) {
                default: {
                    Log.d((String)"ProfileInstaller", (String)string2);
                    break;
                }
                case 6: 
                case 7: 
                case 8: {
                    Log.e((String)"ProfileInstaller", (String)string2, (Throwable)((Throwable)object));
                }
            }
        }
    };
    private static final String PROFILE_BASE_DIR = "/data/misc/profiles/cur/0";
    private static final String PROFILE_FILE = "primary.prof";
    private static final String PROFILE_INSTALLER_SKIP_FILE_NAME = "profileinstaller_profileWrittenFor_lastUpdateTime.dat";
    private static final String PROFILE_META_LOCATION = "dexopt/baseline.profm";
    private static final String PROFILE_SOURCE_LOCATION = "dexopt/baseline.prof";
    public static final int RESULT_ALREADY_INSTALLED = 2;
    public static final int RESULT_BASELINE_PROFILE_NOT_FOUND = 6;
    public static final int RESULT_BENCHMARK_OPERATION_FAILURE = 15;
    public static final int RESULT_BENCHMARK_OPERATION_SUCCESS = 14;
    public static final int RESULT_BENCHMARK_OPERATION_UNKNOWN = 16;
    public static final int RESULT_DELETE_SKIP_FILE_SUCCESS = 11;
    public static final int RESULT_DESIRED_FORMAT_UNSUPPORTED = 5;
    public static final int RESULT_INSTALL_SKIP_FILE_SUCCESS = 10;
    public static final int RESULT_INSTALL_SUCCESS = 1;
    public static final int RESULT_IO_EXCEPTION = 7;
    public static final int RESULT_META_FILE_REQUIRED_BUT_NOT_FOUND = 9;
    public static final int RESULT_NOT_WRITABLE = 4;
    public static final int RESULT_PARSE_EXCEPTION = 8;
    public static final int RESULT_SAVE_PROFILE_SIGNALLED = 12;
    public static final int RESULT_SAVE_PROFILE_SKIPPED = 13;
    public static final int RESULT_UNSUPPORTED_ART_VERSION = 3;
    private static final String TAG = "ProfileInstaller";

    private ProfileInstaller() {
    }

    static boolean deleteProfileWrittenFor(File file) {
        return new File(file, PROFILE_INSTALLER_SKIP_FILE_NAME).delete();
    }

    static void deleteSkipFile(Context context, Executor executor, DiagnosticsCallback diagnosticsCallback) {
        ProfileInstaller.deleteProfileWrittenFor(context.getFilesDir());
        ProfileInstaller.result(executor, diagnosticsCallback, 11, null);
    }

    static void diagnostic(Executor executor, DiagnosticsCallback diagnosticsCallback, int n, Object object) {
        executor.execute(new ProfileInstaller$$ExternalSyntheticLambda1(diagnosticsCallback, n, object));
    }

    /*
     * Exception decompiling
     */
    static boolean hasAlreadyWrittenProfileForThisInstall(PackageInfo var0, File var1_3, DiagnosticsCallback var2_5) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
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

    static /* synthetic */ void lambda$diagnostic$1(DiagnosticsCallback diagnosticsCallback, int n, Object object) {
        diagnosticsCallback.onDiagnosticReceived(n, object);
    }

    static /* synthetic */ void lambda$result$0(DiagnosticsCallback diagnosticsCallback, int n, Object object) {
        diagnosticsCallback.onResultReceived(n, object);
    }

    /*
     * Loose catch block
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static void noteProfileWrittenFor(PackageInfo packageInfo, File object) {
        File file = new File((File)object, PROFILE_INSTALLER_SKIP_FILE_NAME);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        object = new DataOutputStream(fileOutputStream);
        ((DataOutputStream)object).writeLong(packageInfo.lastUpdateTime);
        ((FilterOutputStream)object).close();
        return;
        catch (Throwable throwable) {
            try {
                ((FilterOutputStream)object).close();
                throw throwable;
            }
            catch (Throwable throwable2) {
                try {
                    throwable.addSuppressed(throwable2);
                    throw throwable;
                }
                catch (IOException iOException) {
                    // empty catch block
                }
            }
        }
    }

    static void result(Executor executor, DiagnosticsCallback diagnosticsCallback, int n, Object object) {
        executor.execute(new ProfileInstaller$$ExternalSyntheticLambda0(diagnosticsCallback, n, object));
    }

    private static boolean transcodeAndWrite(AssetManager object, String string2, PackageInfo packageInfo, File file, String string3, Executor executor, DiagnosticsCallback diagnosticsCallback) {
        if (!((DeviceProfileWriter)(object = new DeviceProfileWriter((AssetManager)object, executor, diagnosticsCallback, string3, PROFILE_SOURCE_LOCATION, PROFILE_META_LOCATION, new File(new File(PROFILE_BASE_DIR, string2), PROFILE_FILE)))).deviceAllowsProfileInstallerAotWrites()) {
            return false;
        }
        boolean bl = ((DeviceProfileWriter)object).read().transcodeIfNeeded().write();
        if (bl) {
            ProfileInstaller.noteProfileWrittenFor(packageInfo, file);
        }
        return bl;
    }

    public static void writeProfile(Context context) {
        ProfileInstaller.writeProfile(context, new ProfileInstallReceiver$$ExternalSyntheticLambda0(), EMPTY_DIAGNOSTICS);
    }

    public static void writeProfile(Context context, Executor executor, DiagnosticsCallback diagnosticsCallback) {
        ProfileInstaller.writeProfile(context, executor, diagnosticsCallback, false);
    }

    static void writeProfile(Context context, Executor executor, DiagnosticsCallback diagnosticsCallback, boolean bl) {
        PackageInfo packageInfo;
        Context context2 = context.getApplicationContext();
        String string2 = context2.getPackageName();
        Object object = context2.getApplicationInfo();
        context2 = context2.getAssets();
        object = new File(object.sourceDir).getName();
        Object object2 = context.getPackageManager();
        try {
            packageInfo = object2.getPackageInfo(string2, 0);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            diagnosticsCallback.onResultReceived(7, (Object)nameNotFoundException);
            ProfileVerifier.writeProfileVerification(context, false);
            return;
        }
        object2 = context.getFilesDir();
        if (!bl && ProfileInstaller.hasAlreadyWrittenProfileForThisInstall(packageInfo, (File)object2, diagnosticsCallback)) {
            Log.d((String)TAG, (String)("Skipping profile installation for " + context.getPackageName()));
            ProfileVerifier.writeProfileVerification(context, false);
        } else {
            Log.d((String)TAG, (String)("Installing profile for " + context.getPackageName()));
            bl = ProfileInstaller.transcodeAndWrite((AssetManager)context2, string2, packageInfo, (File)object2, (String)object, executor, diagnosticsCallback) && bl;
            ProfileVerifier.writeProfileVerification(context, bl);
        }
    }

    static void writeSkipFile(Context context, Executor executor, DiagnosticsCallback diagnosticsCallback) {
        String string2 = context.getApplicationContext().getPackageName();
        PackageManager packageManager = context.getPackageManager();
        try {
            string2 = packageManager.getPackageInfo(string2, 0);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            ProfileInstaller.result(executor, diagnosticsCallback, 7, (Object)nameNotFoundException);
            return;
        }
        ProfileInstaller.noteProfileWrittenFor((PackageInfo)string2, context.getFilesDir());
        ProfileInstaller.result(executor, diagnosticsCallback, 10, null);
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface DiagnosticCode {
    }

    public static interface DiagnosticsCallback {
        public void onDiagnosticReceived(int var1, Object var2);

        public void onResultReceived(int var1, Object var2);
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface ResultCode {
    }
}

