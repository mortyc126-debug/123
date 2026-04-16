/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetManager
 *  android.os.Build$VERSION
 */
package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.profileinstaller.DeviceProfileWriter$$ExternalSyntheticLambda0;
import androidx.profileinstaller.DexProfileData;
import androidx.profileinstaller.Encoding;
import androidx.profileinstaller.ProfileInstaller;
import androidx.profileinstaller.ProfileTranscoder;
import androidx.profileinstaller.ProfileVersion;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Executor;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class DeviceProfileWriter {
    private final String mApkName;
    private final AssetManager mAssetManager;
    private final File mCurProfile;
    private final byte[] mDesiredVersion;
    private boolean mDeviceSupportsAotProfile = false;
    private final ProfileInstaller.DiagnosticsCallback mDiagnostics;
    private final Executor mExecutor;
    private DexProfileData[] mProfile;
    private final String mProfileMetaSourceLocation;
    private final String mProfileSourceLocation;
    private byte[] mTranscodedProfile;

    public DeviceProfileWriter(AssetManager assetManager, Executor executor, ProfileInstaller.DiagnosticsCallback diagnosticsCallback, String string2, String string3, String string4, File file) {
        this.mAssetManager = assetManager;
        this.mExecutor = executor;
        this.mDiagnostics = diagnosticsCallback;
        this.mApkName = string2;
        this.mProfileSourceLocation = string3;
        this.mProfileMetaSourceLocation = string4;
        this.mCurProfile = file;
        this.mDesiredVersion = DeviceProfileWriter.desiredVersion();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private DeviceProfileWriter addMetadata(DexProfileData[] var1_1, byte[] var2_6) {
        var3_8 = this.openStreamFromAssets(this.mAssetManager, this.mProfileMetaSourceLocation);
        if (var3_8 == null) ** GOTO lbl19
        this.mProfile = ProfileTranscoder.readMeta(var3_8, ProfileTranscoder.readHeader(var3_8, ProfileTranscoder.MAGIC_PROFM), var2_6, var1_1);
        if (var3_8 == null) return this;
        var3_8.close();
        return this;
        catch (Throwable var1_2) {
            if (var3_8 == null) throw var1_2;
            try {
                var3_8.close();
                throw var1_2;
            }
            catch (Throwable var2_7) {
                try {
                    var1_2.addSuppressed(var2_7);
                    throw var1_2;
lbl19:
                    // 1 sources

                    if (var3_8 == null) return null;
                    var3_8.close();
                    return null;
                }
                catch (IllegalStateException var1_3) {
                    this.mProfile = null;
                    this.mDiagnostics.onResultReceived(8, var1_3);
                    return null;
                }
                catch (IOException var1_4) {
                    this.mDiagnostics.onResultReceived(7, var1_4);
                    return null;
                }
                catch (FileNotFoundException var1_5) {
                    this.mDiagnostics.onResultReceived(9, var1_5);
                }
            }
        }
        return null;
    }

    private void assertDeviceAllowsProfileInstallerAotWritesCalled() {
        if (this.mDeviceSupportsAotProfile) {
            return;
        }
        throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
    }

    private static byte[] desiredVersion() {
        if (Build.VERSION.SDK_INT > 33) {
            return null;
        }
        switch (Build.VERSION.SDK_INT) {
            default: {
                return null;
            }
            case 31: 
            case 32: 
            case 33: {
                return ProfileVersion.V015_S;
            }
            case 28: 
            case 29: 
            case 30: {
                return ProfileVersion.V010_P;
            }
            case 27: {
                return ProfileVersion.V009_O_MR1;
            }
            case 26: {
                return ProfileVersion.V005_O;
            }
            case 24: 
            case 25: 
        }
        return ProfileVersion.V001_N;
    }

    private InputStream getProfileInputStream(AssetManager object) {
        Object var2_4 = null;
        Object var3_5 = null;
        try {
            object = this.openStreamFromAssets((AssetManager)object, this.mProfileSourceLocation);
        }
        catch (IOException iOException) {
            this.mDiagnostics.onResultReceived(7, iOException);
            object = var2_4;
        }
        catch (FileNotFoundException fileNotFoundException) {
            this.mDiagnostics.onResultReceived(6, fileNotFoundException);
            object = var3_5;
        }
        return object;
    }

    private InputStream openStreamFromAssets(AssetManager object, String string2) throws IOException {
        block2: {
            Object var3_4 = null;
            try {
                object = object.openFd(string2).createInputStream();
            }
            catch (FileNotFoundException fileNotFoundException) {
                string2 = fileNotFoundException.getMessage();
                object = var3_4;
                if (string2 == null) break block2;
                object = var3_4;
                if (!string2.contains("compressed")) break block2;
                this.mDiagnostics.onDiagnosticReceived(5, null);
                object = var3_4;
            }
        }
        return object;
    }

    /*
     * Exception decompiling
     */
    private DexProfileData[] readProfileInternal(InputStream var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 2[TRYBLOCK] [4 : 57->70)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
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

    private static boolean requiresMetadata() {
        if (Build.VERSION.SDK_INT > 33) {
            return false;
        }
        switch (Build.VERSION.SDK_INT) {
            default: {
                return false;
            }
            case 31: 
            case 32: 
            case 33: {
                return true;
            }
            case 26: 
            case 27: 
            case 28: 
            case 29: 
            case 30: {
                return false;
            }
            case 24: 
            case 25: 
        }
        return true;
    }

    private void result(int n, Object object) {
        this.mExecutor.execute(new DeviceProfileWriter$$ExternalSyntheticLambda0(this, n, object));
    }

    public boolean deviceAllowsProfileInstallerAotWrites() {
        if (this.mDesiredVersion == null) {
            this.result(3, Build.VERSION.SDK_INT);
            return false;
        }
        if (!this.mCurProfile.canWrite()) {
            this.result(4, null);
            return false;
        }
        this.mDeviceSupportsAotProfile = true;
        return true;
    }

    /* synthetic */ void lambda$result$0$androidx-profileinstaller-DeviceProfileWriter(int n, Object object) {
        this.mDiagnostics.onResultReceived(n, object);
    }

    public DeviceProfileWriter read() {
        this.assertDeviceAllowsProfileInstallerAotWritesCalled();
        if (this.mDesiredVersion == null) {
            return this;
        }
        Object object = this.getProfileInputStream(this.mAssetManager);
        if (object != null) {
            this.mProfile = this.readProfileInternal((InputStream)object);
        }
        if (this.mProfile != null) {
            object = this.mProfile;
            if (DeviceProfileWriter.requiresMetadata() && (object = this.addMetadata((DexProfileData[])object, this.mDesiredVersion)) != null) {
                return object;
            }
        }
        return this;
    }

    /*
     * Loose catch block
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public DeviceProfileWriter transcodeIfNeeded() {
        ByteArrayOutputStream byteArrayOutputStream;
        block11: {
            DexProfileData[] dexProfileDataArray = this.mProfile;
            byte[] byArray = this.mDesiredVersion;
            if (dexProfileDataArray == null || byArray == null) return this;
            this.assertDeviceAllowsProfileInstallerAotWritesCalled();
            byteArrayOutputStream = new ByteArrayOutputStream();
            ProfileTranscoder.writeHeader(byteArrayOutputStream, byArray);
            if (ProfileTranscoder.transcodeAndWriteBody(byteArrayOutputStream, byArray, dexProfileDataArray)) break block11;
            this.mDiagnostics.onResultReceived(5, null);
            this.mProfile = null;
            byteArrayOutputStream.close();
            return this;
        }
        this.mTranscodedProfile = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        catch (Throwable throwable) {
            try {
                byteArrayOutputStream.close();
                throw throwable;
            }
            catch (Throwable throwable2) {
                try {
                    throwable.addSuppressed(throwable2);
                    throw throwable;
                }
                catch (IllegalStateException illegalStateException) {
                    this.mDiagnostics.onResultReceived(8, illegalStateException);
                }
                catch (IOException iOException) {
                    this.mDiagnostics.onResultReceived(7, iOException);
                }
            }
        }
        this.mProfile = null;
        return this;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean write() {
        Throwable throwable622222;
        block18: {
            block19: {
                byte[] byArray = this.mTranscodedProfile;
                if (byArray == null) {
                    return false;
                }
                this.assertDeviceAllowsProfileInstallerAotWritesCalled();
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
                FileOutputStream fileOutputStream = new FileOutputStream(this.mCurProfile);
                Encoding.writeAll(byteArrayInputStream, fileOutputStream);
                this.result(1, null);
                ((OutputStream)fileOutputStream).close();
                ((InputStream)byteArrayInputStream).close();
                this.mTranscodedProfile = null;
                this.mProfile = null;
                return true;
                catch (Throwable throwable2) {
                    try {
                        ((OutputStream)fileOutputStream).close();
                        throw throwable2;
                    }
                    catch (Throwable throwable3) {
                        try {
                            throwable2.addSuppressed(throwable3);
                            throw throwable2;
                        }
                        catch (Throwable throwable4) {
                            try {
                                ((InputStream)byteArrayInputStream).close();
                                throw throwable4;
                            }
                            catch (Throwable throwable5) {
                                try {
                                    throwable4.addSuppressed(throwable5);
                                    throw throwable4;
                                }
                                catch (Throwable throwable622222) {
                                    break block18;
                                }
                                catch (IOException iOException) {
                                    this.result(7, iOException);
                                    break block19;
                                }
                                catch (FileNotFoundException fileNotFoundException) {
                                    this.result(6, fileNotFoundException);
                                }
                            }
                        }
                    }
                }
            }
            this.mTranscodedProfile = null;
            this.mProfile = null;
            return false;
        }
        this.mTranscodedProfile = null;
        this.mProfile = null;
        throw throwable622222;
    }
}

