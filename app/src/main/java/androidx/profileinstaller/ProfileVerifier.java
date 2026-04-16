/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.PackageManager$PackageInfoFlags
 *  android.os.Build$VERSION
 *  com.google.common.util.concurrent.ListenableFuture
 */
package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.concurrent.futures.ResolvableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

public final class ProfileVerifier {
    private static final String CUR_PROFILES_BASE_DIR = "/data/misc/profiles/cur/0/";
    private static final String PROFILE_FILE_NAME = "primary.prof";
    private static final String PROFILE_INSTALLED_CACHE_FILE_NAME = "profileInstalled";
    private static final String REF_PROFILES_BASE_DIR = "/data/misc/profiles/ref/";
    private static final Object SYNC_OBJ;
    private static final String TAG = "ProfileVerifier";
    private static CompilationStatus sCompilationStatus;
    private static final ResolvableFuture<CompilationStatus> sFuture;

    static {
        sFuture = ResolvableFuture.create();
        SYNC_OBJ = new Object();
        sCompilationStatus = null;
    }

    private ProfileVerifier() {
    }

    public static ListenableFuture<CompilationStatus> getCompilationStatusAsync() {
        return sFuture;
    }

    private static long getPackageLastUpdateTime(Context context) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        if (Build.VERSION.SDK_INT >= 33) {
            return Api33Impl.getPackageInfo((PackageManager)packageManager, (Context)context).lastUpdateTime;
        }
        return packageManager.getPackageInfo((String)context.getPackageName(), (int)0).lastUpdateTime;
    }

    private static CompilationStatus setCompilationStatus(int n, boolean bl, boolean bl2) {
        sCompilationStatus = new CompilationStatus(n, bl, bl2);
        sFuture.set(sCompilationStatus);
        return sCompilationStatus;
    }

    public static CompilationStatus writeProfileVerification(Context context) {
        return ProfileVerifier.writeProfileVerification(context, false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static CompilationStatus writeProfileVerification(Context object, boolean bl) {
        if (!bl && sCompilationStatus != null) {
            return sCompilationStatus;
        }
        Object object2 = SYNC_OBJ;
        synchronized (object2) {
            long l;
            boolean bl2;
            long l2;
            boolean bl3;
            long l3;
            File file;
            Object object3;
            int n;
            block16: {
                if (!bl && sCompilationStatus != null) {
                    return sCompilationStatus;
                }
                n = Build.VERSION.SDK_INT;
                boolean bl4 = false;
                if (n < 28) return ProfileVerifier.setCompilationStatus(262144, false, false);
                if (Build.VERSION.SDK_INT == 30) return ProfileVerifier.setCompilationStatus(262144, false, false);
                object3 = new File(REF_PROFILES_BASE_DIR, object.getPackageName());
                file = new File((File)object3, PROFILE_FILE_NAME);
                l3 = file.length();
                bl3 = file.exists() && l3 > 0L;
                file = new File(CUR_PROFILES_BASE_DIR, object.getPackageName());
                object3 = new File(file, PROFILE_FILE_NAME);
                l2 = ((File)object3).length();
                boolean bl5 = ((File)object3).exists();
                bl2 = bl4;
                if (bl5) {
                    bl2 = bl4;
                    if (l2 > 0L) {
                        bl2 = true;
                    }
                }
                try {
                    l = ProfileVerifier.getPackageLastUpdateTime((Context)object);
                    file = new File(object.getFilesDir(), PROFILE_INSTALLED_CACHE_FILE_NAME);
                    bl4 = file.exists();
                    if (!bl4) break block16;
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    return ProfileVerifier.setCompilationStatus(65536, bl3, bl2);
                }
                try {
                    object = Cache.readFromFile(file);
                }
                catch (IOException iOException) {
                    return ProfileVerifier.setCompilationStatus(131072, bl3, bl2);
                }
            }
            object = null;
            n = object != null && ((Cache)object).mPackageLastUpdateTime == l && ((Cache)object).mResultCode != 2 ? ((Cache)object).mResultCode : (bl3 ? 1 : (bl2 ? 2 : 0));
            int n2 = n;
            if (bl) {
                n2 = n;
                if (bl2) {
                    n2 = n;
                    if (n != 1) {
                        n2 = 2;
                    }
                }
            }
            n = object != null && ((Cache)object).mResultCode == 2 && n2 == 1 && l3 < ((Cache)object).mInstalledCurrentProfileSize ? 3 : n2;
            object3 = new Cache(1, n, l, l2);
            if (object != null) {
                bl = ((Cache)object).equals(object3);
                n2 = n;
                if (bl) return ProfileVerifier.setCompilationStatus(n2, bl3, bl2);
            }
            try {
                ((Cache)object3).writeOnFile(file);
                n2 = n;
                return ProfileVerifier.setCompilationStatus(n2, bl3, bl2);
            }
            catch (IOException iOException) {
                n2 = 196608;
            }
            return ProfileVerifier.setCompilationStatus(n2, bl3, bl2);
        }
    }

    private static class Api33Impl {
        private Api33Impl() {
        }

        static PackageInfo getPackageInfo(PackageManager packageManager, Context context) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of((long)0L));
        }
    }

    static class Cache {
        private static final int SCHEMA = 1;
        final long mInstalledCurrentProfileSize;
        final long mPackageLastUpdateTime;
        final int mResultCode;
        final int mSchema;

        Cache(int n, int n2, long l, long l2) {
            this.mSchema = n;
            this.mResultCode = n2;
            this.mPackageLastUpdateTime = l;
            this.mInstalledCurrentProfileSize = l2;
        }

        static Cache readFromFile(File object) throws IOException {
            object = new DataInputStream(new FileInputStream((File)object));
            try {
                Cache cache2 = new Cache(((DataInputStream)object).readInt(), ((DataInputStream)object).readInt(), ((DataInputStream)object).readLong(), ((DataInputStream)object).readLong());
                return cache2;
            }
            finally {
                ((FilterInputStream)object).close();
            }
        }

        public boolean equals(Object object) {
            boolean bl = true;
            if (this == object) {
                return true;
            }
            if (object != null && object instanceof Cache) {
                object = (Cache)object;
                if (this.mResultCode != ((Cache)object).mResultCode || this.mPackageLastUpdateTime != ((Cache)object).mPackageLastUpdateTime || this.mSchema != ((Cache)object).mSchema || this.mInstalledCurrentProfileSize != ((Cache)object).mInstalledCurrentProfileSize) {
                    bl = false;
                }
                return bl;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(this.mResultCode, this.mPackageLastUpdateTime, this.mSchema, this.mInstalledCurrentProfileSize);
        }

        void writeOnFile(File file) throws IOException {
            file.delete();
            try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));){
                dataOutputStream.writeInt(this.mSchema);
                dataOutputStream.writeInt(this.mResultCode);
                dataOutputStream.writeLong(this.mPackageLastUpdateTime);
                dataOutputStream.writeLong(this.mInstalledCurrentProfileSize);
                return;
            }
        }
    }

    public static class CompilationStatus {
        public static final int RESULT_CODE_COMPILED_WITH_PROFILE = 1;
        public static final int RESULT_CODE_COMPILED_WITH_PROFILE_NON_MATCHING = 3;
        public static final int RESULT_CODE_ERROR_CACHE_FILE_EXISTS_BUT_CANNOT_BE_READ = 131072;
        public static final int RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE = 196608;
        private static final int RESULT_CODE_ERROR_CODE_BIT_SHIFT = 16;
        public static final int RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST = 65536;
        public static final int RESULT_CODE_ERROR_UNSUPPORTED_API_VERSION = 262144;
        public static final int RESULT_CODE_NO_PROFILE = 0;
        public static final int RESULT_CODE_PROFILE_ENQUEUED_FOR_COMPILATION = 2;
        private final boolean mHasCurrentProfile;
        private final boolean mHasReferenceProfile;
        final int mResultCode;

        CompilationStatus(int n, boolean bl, boolean bl2) {
            this.mResultCode = n;
            this.mHasCurrentProfile = bl2;
            this.mHasReferenceProfile = bl;
        }

        public int getProfileInstallResultCode() {
            return this.mResultCode;
        }

        public boolean hasProfileEnqueuedForCompilation() {
            return this.mHasCurrentProfile;
        }

        public boolean isCompiledWithProfile() {
            return this.mHasReferenceProfile;
        }

        @Retention(value=RetentionPolicy.SOURCE)
        public static @interface ResultCode {
        }
    }
}

