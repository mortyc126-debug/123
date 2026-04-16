package TJANu601f538RbOB.TJANu28ebd7fRbOB.TJANu221acc9RbOB;

import TJANu768e41aRbOB.TJANu6a6d9ceRbOB.TJANu548902cRbOB;
import TJANu768e41aRbOB.TJANu6a6d9ceRbOB.TJANufe3319cRbOB;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Base64;
import android.util.Log;
import dalvik.system.BaseDexClassLoader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.zip.Inflater;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import kotlin.UByte;
import kotlin.jvm.internal.IntCompanionObject;
import okhttp3.HttpUrl;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: a.java */
/* JADX INFO: loaded from: classes.dex */
public class TJANu357b19bRbOB extends Application {
    private static Context WUhKna59e942fZ0R = null;
    public static final String WUhKndba2a861Z0R = "geo_state.dat";
    private WeakReference WUhKn608e4b45Z0R;
    private Class<?> WUhKn9c3e35deZ0R;

    static String GRUy50195ce4fHp() {
        return new String("mApplication".getBytes(), HTTP.UTF_8);
    }

    static String GRUy501a7c368Hp() {
        return new String("Assets listed".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5034cec0bHp() {
        return new String("android.app.ActivityThread".getBytes(), HTTP.UTF_8);
    }

    static String GRUy50519d0ceHp() {
        return new String("currentActivityThread".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5076f0d29Hp() {
        return new String(":".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5081d4f4eHp() {
        return new String("android.app.LoadedApk".getBytes(), HTTP.UTF_8);
    }

    static String GRUy50cd55ed0Hp() {
        return new String("DeviceID".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5167e0e81Hp() {
        return new String("eProtect_app".getBytes(), HTTP.UTF_8);
    }

    static String GRUy517e6acabHp() {
        return new String("android.app.LoadedApk".getBytes(), HTTP.UTF_8);
    }

    static String GRUy51b3cd5c3Hp() {
        return new String("Failed to list assets".getBytes(), HTTP.UTF_8);
    }

    static String GRUy51bafcbd1Hp() {
        return new String(".vex".getBytes(), HTTP.UTF_8);
    }

    public static String GRUy520eddca5Hp(String str, boolean z) {
        char[] cArr = {12293, 12294};
        try {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                sb.append((char) (str.charAt(i) ^ cArr[i % cArr.length]));
            }
            return sb.toString();
        } catch (Exception e) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }

    private void GRUy520eddca5Hp(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
        }
    }

    private void GRUy520eddca5Hp(File file) {
        for (File file2 : file.listFiles()) {
            file2.delete();
        }
        file.delete();
    }

    private static byte[] GRUy520eddca5Hp(byte[] bArr) {
        if (bArr.length == 16) {
            return bArr;
        }
        byte[] bArr2 = new byte[16];
        if (bArr.length < 16) {
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        } else {
            System.arraycopy(bArr, 0, bArr2, 0, 16);
        }
        return bArr2;
    }

    public static byte[] GRUy520eddca5Hp(byte[] bArr, byte[] bArr2) {
        return bArr.length == 0 ? bArr : GRUy520eddca5Hp(GRUy520eddca5Hp(GRUy520eddca5Hp(bArr, false), GRUy520eddca5Hp(GRUy520eddca5Hp(bArr2), false)), true);
    }

    private static byte[] GRUy520eddca5Hp(int[] iArr, boolean z) {
        int i;
        int length = iArr.length << 2;
        if (z) {
            i = iArr[iArr.length - 1];
            int i2 = length - 4;
            if (i < i2 - 3 || i > i2) {
                return (byte[]) null;
            }
        } else {
            i = length;
        }
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) (iArr[i3 >>> 2] >>> ((i3 & 3) << 3));
        }
        return bArr;
    }

    private static int[] GRUy520eddca5Hp(byte[] bArr, boolean z) {
        int[] iArr;
        int length = (bArr.length & 3) == 0 ? bArr.length >>> 2 : (bArr.length >>> 2) + 1;
        if (z) {
            iArr = new int[length + 1];
            iArr[length] = bArr.length;
        } else {
            iArr = new int[length];
        }
        int length2 = bArr.length;
        for (int i = 0; i < length2; i++) {
            int i2 = i >>> 2;
            iArr[i2] = iArr[i2] | ((bArr[i] & UByte.MAX_VALUE) << ((i & 3) << 3));
        }
        return iArr;
    }

    private static int[] GRUy520eddca5Hp(int[] iArr, int[] iArr2) {
        int length = iArr.length - 1;
        if (length >= 1) {
            int iGRUy520eddca5Hp = iArr[0];
            for (int i = ((52 / (length + 1)) + 6) * (-1640531527); i != 0; i += 1640531527) {
                int i2 = (i >>> 2) & 3;
                int i3 = length;
                while (i3 > 0) {
                    iGRUy520eddca5Hp = iArr[i3] - GRUy520eddca5Hp(i, iGRUy520eddca5Hp, iArr[i3 - 1], i3, i2, iArr2);
                    iArr[i3] = iGRUy520eddca5Hp;
                    i3--;
                }
                iGRUy520eddca5Hp = iArr[0] - GRUy520eddca5Hp(i, iGRUy520eddca5Hp, iArr[length], i3, i2, iArr2);
                iArr[0] = iGRUy520eddca5Hp;
            }
        }
        return iArr;
    }

    static String GRUy52d38d6d7Hp() {
        return new String("DeviceLock".getBytes(), HTTP.UTF_8);
    }

    static String GRUy52f151306Hp() {
        return new String("Geo banned".getBytes(), HTTP.UTF_8);
    }

    public static void GRUy53238e6bfHp(Context context) {
        String strGRUy5a1847512Hp = GRUy5a1847512Hp();
        Log.d(strGRUy5a1847512Hp, GRUy5fd8521b9Hp());
        AssetManager assets = context.getAssets();
        try {
            String[] list = assets.list(HttpUrl.FRAGMENT_ENCODE_SET);
            Log.d(strGRUy5a1847512Hp, GRUy501a7c368Hp());
            if (list != null) {
                File codeCacheDir = context.getCodeCacheDir();
                for (String str : list) {
                    Log.d(strGRUy5a1847512Hp, GRUy5915c1d09Hp() + str);
                    if (str.endsWith(GRUy51bafcbd1Hp())) {
                        try {
                            Log.d(strGRUy5a1847512Hp, GRUy560151be6Hp());
                            InputStream inputStreamOpen = assets.open(str);
                            FileOutputStream fileOutputStream = new FileOutputStream(new File(codeCacheDir, str));
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int i = inputStreamOpen.read(bArr);
                                if (i == -1) {
                                    break;
                                } else {
                                    fileOutputStream.write(bArr, 0, i);
                                }
                            }
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            inputStreamOpen.close();
                            Log.d(strGRUy5a1847512Hp, GRUy5d2853f98Hp());
                        } catch (IOException unused) {
                        }
                        Log.e(strGRUy5a1847512Hp, GRUy5a605e671Hp());
                    }
                }
                Log.d(strGRUy5a1847512Hp, GRUy57ff5a6caHp());
                return;
            }
        } catch (IOException unused2) {
        }
        Log.e(strGRUy5a1847512Hp, GRUy51b3cd5c3Hp());
    }

    private int GRUy53244cc15Hp(Context context) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(context.getFilesDir(), WUhKndba2a861Z0R));
            int i = fileInputStream.read();
            fileInputStream.close();
            return i;
        } catch (Exception unused) {
            return 0;
        }
    }

    private boolean GRUy534aee01cHp(String str) {
        try {
            getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    static String GRUy534ea4542Hp() {
        return new String("android.app.LoadedApk".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5350ed0fdHp() {
        return "mClassLoader";
    }

    static String GRUy53a367c3eHp() {
        return new String("android.app.LoadedApk".getBytes(), HTTP.UTF_8);
    }

    static String GRUy540401470Hp() {
        return new String("android.app.ActivityThread".getBytes(), HTTP.UTF_8);
    }

    static String GRUy54079468bHp() {
        return new String("cvjdnlsf".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5456e8f18Hp() {
        return new String("mBoundApplication".getBytes(), HTTP.UTF_8);
    }

    static String GRUy54a122818Hp() {
        return new String(".vex".getBytes(), HTTP.UTF_8);
    }

    static String GRUy54c8c9c7cHp() {
        return new String("android.app.ActivityThread$AppBindData".getBytes(), HTTP.UTF_8);
    }

    static String GRUy54ea3ccf4Hp() {
        return new String("android.app.ActivityThread".getBytes(), HTTP.UTF_8);
    }

    static String GRUy54efa6946Hp() {
        return new String("mph_odex".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5511a4c32Hp() {
        return new String("VName".getBytes(), HTTP.UTF_8);
    }

    static String GRUy552f8577bHp() {
        return new String("classes.dex".getBytes(), HTTP.UTF_8);
    }

    static String GRUy555abdbe1Hp() {
        return new String("currentActivityThread".getBytes(), HTTP.UTF_8);
    }

    static String GRUy557f39c1cHp() {
        return new String("appInfo".getBytes(), HTTP.UTF_8);
    }

    static String GRUy55c9ab88dHp() {
        return new String("AntiPirate".getBytes(), HTTP.UTF_8);
    }

    static String GRUy560151be6Hp() {
        return new String("Copying file".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5670eb0a1Hp() {
        return new String("/".getBytes(), HTTP.UTF_8);
    }

    static String GRUy56749047aHp() {
        return new String("Toast".getBytes(), HTTP.UTF_8);
    }

    static String GRUy568be7bcfHp() {
        return new String("android.app.Instrumentation".getBytes(), HTTP.UTF_8);
    }

    static String GRUy56a7987a5Hp() {
        return new String("android.app.ActivityThread$AppBindData".getBytes(), HTTP.UTF_8);
    }

    static String GRUy56ab29b32Hp() {
        return new String("Hooks".getBytes(), HTTP.UTF_8);
    }

    static String GRUy56ae7202bHp() {
        return new String("android.app.ActivityThread".getBytes(), HTTP.UTF_8);
    }

    static String GRUy56ec63613Hp() {
        return new String("mInitialApplication".getBytes(), HTTP.UTF_8);
    }

    static String GRUy57370d5e0Hp() {
        return new String("mInitialApplication".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5783da044Hp() {
        return new String("android.app.ActivityThread".getBytes(), HTTP.UTF_8);
    }

    static String GRUy57a589aacHp() {
        return new String("java.util.zip.InflaterInputStream".getBytes(), HTTP.UTF_8);
    }

    static String GRUy57ff5a6caHp() {
        return new String("Finished copying assets".getBytes(), HTTP.UTF_8);
    }

    static String GRUy58f12a89dHp() {
        return new String("android.app.ActivityThread".getBytes(), HTTP.UTF_8);
    }

    public static Context GRUy58f9c982fHp() {
        return WUhKna59e942fZ0R;
    }

    static String GRUy5915c1d09Hp() {
        return new String("Processing: ".getBytes(), HTTP.UTF_8);
    }

    static String GRUy59439da65Hp() {
        return new String("Name".getBytes(), HTTP.UTF_8);
    }

    static String GRUy595ae967bHp() {
        return new String("mPackages".getBytes(), HTTP.UTF_8);
    }

    static String GRUy59b4640bdHp() {
        return new String("mAllApplications".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5a1654234Hp() {
        String strEncodeToString = HttpUrl.FRAGMENT_ENCODE_SET;
        try {
            for (Signature signature : WUhKna59e942fZ0R.getPackageManager().getPackageInfo(WUhKna59e942fZ0R.getPackageName(), 64).signatures) {
                MessageDigest messageDigest = MessageDigest.getInstance(GRUy5e6fa6481Hp());
                messageDigest.update(signature.toByteArray());
                strEncodeToString = Base64.encodeToString(messageDigest.digest(), 0);
            }
        } catch (PackageManager.NameNotFoundException e) {
        } catch (NoSuchAlgorithmException e2) {
        }
        return strEncodeToString.trim();
    }

    static String GRUy5a1847512Hp() {
        return new String("VEX_COPY".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5a4e9e2c5Hp() {
        return new String("makeApplication".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5a605e671Hp() {
        return new String("Error copying file".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5bb610b55Hp() {
        return new String("eProtect_app".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5bf7e983aHp() {
        return new String("SignChecker".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5c5fb563bHp() {
        return new String("android.app.ActivityThread".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5cac5c540Hp() {
        return new String("info".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5caf9a926Hp() {
        return new String("cvjdnlsf".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5d2853f98Hp() {
        return new String("File copied successfully".getBytes(), HTTP.UTF_8);
    }

    public static String GRUy5d3bcd88dHp(Context context, String str) {
        StringBuilder sb = new StringBuilder(str);
        File[] fileArrListFiles = context.getCodeCacheDir().listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                if (file.getName().endsWith(GRUy54a122818Hp())) {
                    sb.append(GRUy5076f0d29Hp());
                    sb.append(file.getAbsolutePath());
                }
            }
        }
        return sb.toString();
    }

    static String GRUy5d3f83595Hp() {
        return new String("DES".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5daeaf8f4Hp() {
        return new String("android_id".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5e15521e2Hp() {
        return new String("rqxncrj".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5e6fa6481Hp() {
        return new String("SHA".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5ef73b297Hp() {
        return new String("VCode".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5f12e6ea1Hp() {
        return new String("Package".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5f1675fd7Hp() {
        return new String("mApplicationInfo".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5f696bfe4Hp() {
        return new String("hl".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5f99d6033Hp() {
        return new String("AntiMod".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5fbb473c2Hp() {
        return new String("Signature".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5fd01baebHp() {
        return new String("DES".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5fd8521b9Hp() {
        return new String("Start copyVexAssets".getBytes(), HTTP.UTF_8);
    }

    public Object a(String str, Object obj, String str2) {
        try {
            Field declaredField = Class.forName(str).getDeclaredField(str2);
            if (!declaredField.isAccessible()) {
                declaredField.setAccessible(true);
            }
            return declaredField.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return (Object) null;
        }
    }

    public Object a(String str, String str2, Object obj, Class[] clsArr, Object[] objArr) {
        try {
            return Class.forName(str).getMethod(str2, clsArr).invoke(obj, objArr);
        } catch (Exception e) {
            e.printStackTrace();
            return (Object) null;
        }
    }

    public Object a(String str, String str2, Class[] clsArr, Object[] objArr) {
        Object obj = (Object) null;
        try {
            return Class.forName(str).getMethod(str2, clsArr).invoke((Object) null, objArr);
        } catch (Exception e) {
            e.printStackTrace();
            return obj;
        }
    }

    public SecretKey a(TJANu6a4b1c7RbOB tJANu6a4b1c7RbOB) throws Exception {
        return SecretKeyFactory.getInstance(GRUy5fd01baebHp()).generateSecret(tJANu6a4b1c7RbOB);
    }

    public void a() throws Exception {
        this.WUhKn9c3e35deZ0R = Class.forName(GRUy517e6acabHp());
        this.WUhKn608e4b45Z0R = (WeakReference) ((Map) a(GRUy56ae7202bHp(), a(GRUy58f12a89dHp(), GRUy555abdbe1Hp(), new Class[0], new Object[0]), GRUy595ae967bHp())).get(getPackageName());
        String[] list = getAssets().list(GRUy5caf9a926Hp());
        for (int i = 0; i < list.length; i++) {
            if (list[i].endsWith(GRUy5f696bfe4Hp())) {
                a(list[i]);
            }
        }
        try {
            Bundle bundle = ((PackageItemInfo) getPackageManager().getApplicationInfo(getPackageName(), 128)).metaData;
            if (bundle != null && bundle.containsKey(GRUy5167e0e81Hp())) {
                String string = bundle.getString(GRUy5bb610b55Hp());
                Object objA = a(GRUy5034cec0bHp(), GRUy50519d0ceHp(), new Class[0], new Object[0]);
                Object objA2 = a(GRUy5c5fb563bHp(), objA, GRUy5456e8f18Hp());
                Object objA3 = a(GRUy56a7987a5Hp(), objA2, GRUy5cac5c540Hp());
                a(GRUy5081d4f4eHp(), GRUy50195ce4fHp(), objA3, (Object) null);
                ((ArrayList) a(GRUy540401470Hp(), objA, GRUy59b4640bdHp())).remove(a(GRUy5783da044Hp(), objA, GRUy56ec63613Hp()));
                ((ApplicationInfo) a(GRUy534ea4542Hp(), objA3, GRUy5f1675fd7Hp())).className = string;
                ((ApplicationInfo) a(GRUy54c8c9c7cHp(), objA2, GRUy557f39c1cHp())).className = string;
                Application application = (Application) a(GRUy53a367c3eHp(), GRUy5a4e9e2c5Hp(), objA3, new Class[]{Boolean.TYPE, Class.forName(GRUy568be7bcfHp())}, new Object[]{new Boolean(false), (Object) null});
                a(GRUy54ea3ccf4Hp(), GRUy57370d5e0Hp(), objA, application);
                application.onCreate();
            }
        } catch (PackageManager.NameNotFoundException e) {
        }
    }

    public void a(String str) throws Exception {
        TJANu5e59cf0RbOB tJANu5e59cf0RbOB;
        File dir = getDir(GRUy54efa6946Hp(), 0);
        File file = new File(getCodeCacheDir(), GRUy552f8577bHp());
        a(getAssets().open(new StringBuffer().append(new StringBuffer().append(GRUy54079468bHp()).append(GRUy5670eb0a1Hp()).toString()).append(str).toString()), file);
        if (getClassLoader() != null) {
            String absolutePath = file.getAbsolutePath();
            GRUy53238e6bfHp(this);
            makeCacheReadOnly();
            tJANu5e59cf0RbOB = new TJANu5e59cf0RbOB(this, GRUy5d3bcd88dHp(this, absolutePath), dir.getAbsolutePath(), getApplicationInfo().nativeLibraryDir, getClassLoader());
        } else {
            String absolutePath2 = file.getAbsolutePath();
            GRUy53238e6bfHp(this);
            makeCacheReadOnly();
            tJANu5e59cf0RbOB = new TJANu5e59cf0RbOB(this, GRUy5d3bcd88dHp(this, absolutePath2), dir.getAbsolutePath(), getApplicationInfo().nativeLibraryDir, getClassLoader());
        }
        GRUy520eddca5Hp(dir.getAbsoluteFile());
        GRUy520eddca5Hp(file.getParentFile());
        Field declaredField = this.WUhKn9c3e35deZ0R.getDeclaredField(GRUy5350ed0fdHp());
        declaredField.setAccessible(true);
        declaredField.set(this.WUhKn608e4b45Z0R.get(), tJANu5e59cf0RbOB);
    }

    public void a(String str, String str2, Object obj, Object obj2) {
        try {
            Field declaredField = Class.forName(str).getDeclaredField(str2);
            if (!declaredField.isAccessible()) {
                declaredField.setAccessible(true);
            }
            declaredField.set(obj, obj2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean a(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        TJANu2d3ec0dRbOB tJANu2d3ec0dRbOB;
        FileOutputStream fileOutputStream2 = (FileOutputStream) null;
        TJANu2d3ec0dRbOB tJANu2d3ec0dRbOB2 = (TJANu2d3ec0dRbOB) null;
        File parentFile = file.getParentFile();
        if (!parentFile.exists() && parentFile.isDirectory()) {
            parentFile.mkdirs();
        }
        if (file.exists()) {
            file.delete();
        }
        try {
            tJANu2d3ec0dRbOB = new TJANu2d3ec0dRbOB(this, inputStream);
            try {
                FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                try {
                    TJANud6aefc5RbOB tJANud6aefc5RbOB = new TJANud6aefc5RbOB(this);
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i = tJANu2d3ec0dRbOB.read(bArr);
                        if (i == -1) {
                            byte[] bArrF = tJANud6aefc5RbOB.f();
                            fileOutputStream3.write(bArrF, 0, bArrF.length);
                            fileOutputStream3.flush();
                            GRUy520eddca5Hp(inputStream);
                            GRUy520eddca5Hp(tJANu2d3ec0dRbOB);
                            GRUy520eddca5Hp(fileOutputStream3);
                            return true;
                        }
                        tJANud6aefc5RbOB.a(bArr, 0, i);
                    }
                } catch (Exception e) {
                    fileOutputStream = fileOutputStream3;
                    GRUy520eddca5Hp(inputStream);
                    GRUy520eddca5Hp(tJANu2d3ec0dRbOB);
                    GRUy520eddca5Hp(fileOutputStream);
                    return false;
                }
            } catch (Exception e2) {
                fileOutputStream = fileOutputStream2;
            }
        } catch (Exception e3) {
            fileOutputStream = fileOutputStream2;
            tJANu2d3ec0dRbOB = tJANu2d3ec0dRbOB2;
        }
    }

    public byte[] a(SecretKey secretKey, byte[] bArr) throws Exception {
        Cipher cipher = Cipher.getInstance(GRUy5d3f83595Hp());
        cipher.init(2, secretKey);
        return cipher.doFinal(Base64.encode(bArr, 0));
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        boolean z;
        super.attachBaseContext(context);
        TJANufe3319cRbOB.GRUy55f56c440Hp(context);
        TJANufe3319cRbOB.GRUy58108993fHp(context);
        int iGRUy53244cc15Hp = GRUy53244cc15Hp(context);
        if (iGRUy53244cc15Hp != 1) {
            if (iGRUy53244cc15Hp == 2) {
                throw new RuntimeException(GRUy52f151306Hp());
            }
            TJANu548902cRbOB.GRUy5a7166b60Hp();
        }
        try {
            WUhKna59e942fZ0R = context;
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            JSONObject jSONObject = new JSONObject(z(getAssets().open(GRUy5e15521e2Hp())));
            if (jSONObject.getBoolean(GRUy5f99d6033Hp())) {
                z = (((String) getPackageManager().getApplicationLabel(getApplicationInfo())).equals(jSONObject.getString(GRUy59439da65Hp())) && getPackageName().equals(jSONObject.getString(GRUy5f12e6ea1Hp()))) ? false : true;
                if (!packageInfo.versionName.equals(jSONObject.getString(GRUy5511a4c32Hp())) || packageInfo.versionCode != jSONObject.getInt(GRUy5ef73b297Hp())) {
                    z = true;
                }
            } else {
                z = false;
            }
            if (jSONObject.getBoolean(GRUy5bf7e983aHp()) && !jSONObject.getString(GRUy5fbb473c2Hp()).equals(GRUy5a1654234Hp())) {
                z = true;
            }
            if (jSONObject.getBoolean(GRUy52d38d6d7Hp()) && !c().equals(jSONObject.getString(GRUy50cd55ed0Hp()))) {
                z = true;
            }
            if (jSONObject.getBoolean(GRUy55c9ab88dHp())) {
                JSONArray jSONArray = jSONObject.getJSONArray(GRUy56ab29b32Hp());
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (GRUy534aee01cHp(jSONArray.getString(i))) {
                        z = true;
                    }
                }
            }
            if (jSONObject.getBoolean(GRUy56749047aHp())) {
            }
            x(z);
        } catch (Exception e) {
        }
    }

    public TJANu6a4b1c7RbOB b(byte[] bArr) throws Exception {
        return new TJANu6a4b1c7RbOB(this, bArr);
    }

    public String c() {
        try {
            return Settings.Secure.getString(getContentResolver(), GRUy5daeaf8f4Hp());
        } catch (Exception e) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }

    public void makeCacheReadOnly() {
        File codeCacheDir = getCodeCacheDir();
        codeCacheDir.setReadOnly();
        File[] fileArrListFiles = codeCacheDir.listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                file.setReadOnly();
            }
        }
    }

    void x(boolean z) {
        if (z) {
            return;
        }
        try {
            a();
        } catch (Exception e) {
            System.exit(1);
        }
    }

    public String y(InputStream inputStream) {
        try {
            TJANud6aefc5RbOB tJANud6aefc5RbOB = new TJANud6aefc5RbOB(this);
            byte[] bArr = new byte[8192];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    return new String(tJANud6aefc5RbOB.f());
                }
                tJANud6aefc5RbOB.a(bArr, 0, i);
            }
        } catch (Exception e) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }

    public String z(InputStream inputStream) {
        try {
            InputStream inputStream2 = (InputStream) Class.forName(GRUy57a589aacHp()).getConstructor(InputStream.class).newInstance(inputStream);
            TJANud6aefc5RbOB tJANud6aefc5RbOB = new TJANud6aefc5RbOB(this);
            byte[] bArr = new byte[8192];
            while (true) {
                int i = inputStream2.read(bArr);
                if (i == -1) {
                    return new String(tJANud6aefc5RbOB.f());
                }
                tJANud6aefc5RbOB.a(bArr, 0, i);
            }
        } catch (Exception e) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }

    private static int GRUy520eddca5Hp(int i, int i2, int i3, int i4, int i6, int[] iArr) {
        return (((i3 >>> 5) ^ (i2 << 2)) + ((i2 >>> 3) ^ (i3 << 4))) ^ ((i ^ i2) + (iArr[(i4 & 3) ^ i6] ^ i3));
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x03c1, code lost:
    
        if (r2 == (-1)) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x03c3, code lost:
    
        r5.write(r2 | ((r6 & 3) << 6));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String GRUy520eddca5Hp(java.lang.String r10, int r11) {
        /*
            Method dump skipped, instruction units count: 979
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: TJANu601f538RbOB.TJANu28ebd7fRbOB.TJANu221acc9RbOB.TJANu357b19bRbOB.GRUy520eddca5Hp(java.lang.String, int):java.lang.String");
    }

    /* JADX INFO: compiled from: a.java */
    public class TJANud6aefc5RbOB extends TJANuacb6e46RbOB {
        protected int WUhKna50d2530Z0R;
        protected byte[] WUhKnc7085d0aZ0R;
        private final TJANu357b19bRbOB this$0;

        static String GRUy526d9d0adHp() {
            return new String(" ".getBytes(), HTTP.UTF_8);
        }

        static TJANu357b19bRbOB GRUy5ec67d35aHp(TJANud6aefc5RbOB tJANud6aefc5RbOB) {
            return tJANud6aefc5RbOB.this$0;
        }

        public void x() {
        }

        public TJANud6aefc5RbOB(TJANu357b19bRbOB tJANu357b19bRbOB) {
            this(tJANu357b19bRbOB, 32);
        }

        public TJANud6aefc5RbOB(TJANu357b19bRbOB tJANu357b19bRbOB, int i) {
            super(tJANu357b19bRbOB);
            this.this$0 = tJANu357b19bRbOB;
            if (i < 0) {
                throw new IllegalArgumentException(new StringBuffer().append(GRUy526d9d0adHp()).append(i).toString());
            }
            this.WUhKnc7085d0aZ0R = new byte[i];
        }

        private void GRUy520eddca5Hp(int i) {
            if (i - this.WUhKnc7085d0aZ0R.length > 0) {
                GRUy534aee01cHp(i);
            }
        }

        private void GRUy534aee01cHp(int i) {
            int length = this.WUhKnc7085d0aZ0R.length << 1;
            if (length - i < 0) {
                length = i;
            }
            if (length < 0) {
                if (i < 0) {
                    throw new OutOfMemoryError();
                }
                length = IntCompanionObject.MAX_VALUE;
            }
            this.WUhKnc7085d0aZ0R = Arrays.copyOf(this.WUhKnc7085d0aZ0R, length);
        }

        @Override // TJANu601f538RbOB.TJANu28ebd7fRbOB.TJANu221acc9RbOB.TJANu357b19bRbOB.TJANuacb6e46RbOB
        public synchronized void c(int i) {
            GRUy520eddca5Hp(this.WUhKna50d2530Z0R + 1);
            this.WUhKnc7085d0aZ0R[this.WUhKna50d2530Z0R] = (byte) i;
            this.WUhKna50d2530Z0R++;
        }

        public synchronized void c(byte[] bArr, int i, int i2) {
            if (i >= 0) {
                if (i <= bArr.length && i2 >= 0 && (i + i2) - bArr.length <= 0) {
                    GRUy520eddca5Hp(this.WUhKna50d2530Z0R + i2);
                    System.arraycopy(bArr, i, this.WUhKnc7085d0aZ0R, this.WUhKna50d2530Z0R, i2);
                    this.WUhKna50d2530Z0R += i2;
                }
            }
            throw new IndexOutOfBoundsException();
        }

        public synchronized void d(OutputStream outputStream) throws IOException {
            outputStream.write(this.WUhKnc7085d0aZ0R, 0, this.WUhKna50d2530Z0R);
        }

        public synchronized void e() {
            this.WUhKna50d2530Z0R = 0;
        }

        public synchronized byte[] f() {
            return Arrays.copyOf(this.WUhKnc7085d0aZ0R, this.WUhKna50d2530Z0R);
        }

        public synchronized int g() {
            return this.WUhKna50d2530Z0R;
        }

        public synchronized String toString() {
            return new String(this.WUhKnc7085d0aZ0R, 0, this.WUhKna50d2530Z0R);
        }

        public synchronized String toString(String str) throws UnsupportedEncodingException {
            return new String(this.WUhKnc7085d0aZ0R, 0, this.WUhKna50d2530Z0R, str);
        }

        @Deprecated
        public synchronized String toString(int i) {
            return new String(this.WUhKnc7085d0aZ0R, i, 0, this.WUhKna50d2530Z0R);
        }
    }

    /* JADX INFO: compiled from: a.java */
    public abstract class TJANuacb6e46RbOB {
        private final TJANu357b19bRbOB this$0;

        static TJANu357b19bRbOB GRUy5ec67d35aHp(TJANuacb6e46RbOB tJANuacb6e46RbOB) {
            return tJANuacb6e46RbOB.this$0;
        }

        public abstract void c(int i) throws IOException;

        public void c(byte[] bArr) throws IOException {
            a(bArr, 0, bArr.length);
        }

        public void a(byte[] bArr, int i, int i2) throws IOException {
            if (bArr == null) {
                throw new NullPointerException();
            }
            if (i < 0 || i > bArr.length || i2 < 0 || i + i2 > bArr.length || i + i2 < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (i2 == 0) {
                return;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                c(bArr[i + i3]);
            }
        }

        public TJANuacb6e46RbOB(TJANu357b19bRbOB tJANu357b19bRbOB) {
            this.this$0 = tJANu357b19bRbOB;
        }
    }

    /* JADX INFO: compiled from: a.java */
    public class TJANu5e59cf0RbOB extends BaseDexClassLoader {
        private final TJANu357b19bRbOB this$0;

        static TJANu357b19bRbOB GRUy5ec67d35aHp(TJANu5e59cf0RbOB tJANu5e59cf0RbOB) {
            return tJANu5e59cf0RbOB.this$0;
        }

        public TJANu5e59cf0RbOB(TJANu357b19bRbOB tJANu357b19bRbOB, String str, String str2, String str3, ClassLoader classLoader) {
            super(str, new File(str2), str3, classLoader);
            this.this$0 = tJANu357b19bRbOB;
        }
    }

    /* JADX INFO: compiled from: a.java */
    public class TJANu6a4b1c7RbOB implements KeySpec {
        private static final byte[][] WUhKn7a4d694bZ0R = {new byte[]{1, 1, 1, 1, 1, 1, 1, 1}, new byte[]{-2, -2, -2, -2, -2, -2, -2, -2}, new byte[]{31, 31, 31, 31, 14, 14, 14, 14}, new byte[]{-32, -32, -32, -32, -15, -15, -15, -15}, new byte[]{1, -2, 1, -2, 1, -2, 1, -2}, new byte[]{31, -32, 31, -32, 14, -15, 14, -15}, new byte[]{1, -32, 1, -32, 1, -15, 1, -15}, new byte[]{31, -2, 31, -2, 14, -2, 14, -2}, new byte[]{1, 31, 1, 31, 1, 14, 1, 14}, new byte[]{-32, -2, -32, -2, -15, -2, -15, -2}, new byte[]{-2, 1, -2, 1, -2, 1, -2, 1}, new byte[]{-32, 31, -32, 31, -15, 14, -15, 14}, new byte[]{-32, 1, -32, 1, -15, 1, -15, 1}, new byte[]{-2, 31, -2, 31, -2, 14, -2, 14}, new byte[]{31, 1, 31, 1, 14, 1, 14, 1}, new byte[]{-2, -32, -2, -32, -2, -15, -2, -15}};
        public static final int WUhKncc0b60eeZ0R = 8;
        private byte[] WUhKn065c84d6Z0R;
        private final TJANu357b19bRbOB this$0;

        static TJANu357b19bRbOB GRUy5ec67d35aHp(TJANu6a4b1c7RbOB tJANu6a4b1c7RbOB) {
            return tJANu6a4b1c7RbOB.this$0;
        }

        public TJANu6a4b1c7RbOB(TJANu357b19bRbOB tJANu357b19bRbOB, byte[] bArr) throws InvalidKeyException {
            this(tJANu357b19bRbOB, bArr, 0);
        }

        public TJANu6a4b1c7RbOB(TJANu357b19bRbOB tJANu357b19bRbOB, byte[] bArr, int i) throws InvalidKeyException {
            this.this$0 = tJANu357b19bRbOB;
            if (bArr.length - i < 8) {
                throw new InvalidKeyException(HttpUrl.FRAGMENT_ENCODE_SET);
            }
            this.WUhKn065c84d6Z0R = new byte[8];
            System.arraycopy(bArr, i, this.WUhKn065c84d6Z0R, 0, 8);
        }

        public byte[] getKey() {
            return (byte[]) this.WUhKn065c84d6Z0R.clone();
        }

        public boolean isParityAdjusted(byte[] bArr, int i) throws InvalidKeyException {
            if (bArr == null) {
                throw new InvalidKeyException(HttpUrl.FRAGMENT_ENCODE_SET);
            }
            if (bArr.length - i < 8) {
                throw new InvalidKeyException(HttpUrl.FRAGMENT_ENCODE_SET);
            }
            int i2 = 0;
            while (i2 < 8) {
                int i3 = i + 1;
                if ((Integer.bitCount(bArr[i] & UByte.MAX_VALUE) & 1) == 0) {
                    return false;
                }
                i2++;
                i = i3;
            }
            return true;
        }

        public boolean isWeak(byte[] bArr, int i) throws InvalidKeyException {
            if (bArr == null) {
                throw new InvalidKeyException(HttpUrl.FRAGMENT_ENCODE_SET);
            }
            if (bArr.length - i < 8) {
                throw new InvalidKeyException(HttpUrl.FRAGMENT_ENCODE_SET);
            }
            for (int i2 = 0; i2 < WUhKn7a4d694bZ0R.length; i2++) {
                boolean z = true;
                for (int i3 = 0; i3 < 8 && z; i3++) {
                    if (WUhKn7a4d694bZ0R[i2][i3] != bArr[i3 + i]) {
                        z = false;
                    }
                }
                if (z) {
                    return z;
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: a.java */
    public class TJANu2d3ec0dRbOB extends FilterInputStream {
        boolean WUhKn0e95d254Z0R;
        private byte[] WUhKn1d55f459Z0R;
        private boolean WUhKn7e5444d6Z0R;
        private boolean WUhKn9345ca5fZ0R;
        protected int WUhKna33c0cdbZ0R;
        private byte[] WUhKnc15d23bfZ0R;
        protected byte[] WUhKnc7085d0aZ0R;
        protected Inflater WUhKnd4d45763Z0R;
        private final TJANu357b19bRbOB this$0;

        static TJANu357b19bRbOB GRUy5ec67d35aHp(TJANu2d3ec0dRbOB tJANu2d3ec0dRbOB) {
            return tJANu2d3ec0dRbOB.this$0;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i) {
        }

        private void GRUy518803272Hp() throws IOException {
            if (this.WUhKn9345ca5fZ0R) {
                throw new IOException(HttpUrl.FRAGMENT_ENCODE_SET);
            }
        }

        public TJANu2d3ec0dRbOB(TJANu357b19bRbOB tJANu357b19bRbOB, InputStream inputStream, Inflater inflater, int i) {
            super(inputStream);
            this.this$0 = tJANu357b19bRbOB;
            this.WUhKn9345ca5fZ0R = false;
            this.WUhKn7e5444d6Z0R = false;
            this.WUhKn0e95d254Z0R = false;
            this.WUhKn1d55f459Z0R = new byte[1];
            this.WUhKnc15d23bfZ0R = new byte[512];
            if (inputStream == null || inflater == null) {
                throw new NullPointerException();
            }
            if (i <= 0) {
                throw new IllegalArgumentException(HttpUrl.FRAGMENT_ENCODE_SET);
            }
            this.WUhKnd4d45763Z0R = inflater;
            this.WUhKnc7085d0aZ0R = new byte[i];
        }

        public TJANu2d3ec0dRbOB(TJANu357b19bRbOB tJANu357b19bRbOB, InputStream inputStream, Inflater inflater) {
            this(tJANu357b19bRbOB, inputStream, inflater, 512);
        }

        public TJANu2d3ec0dRbOB(TJANu357b19bRbOB tJANu357b19bRbOB, InputStream inputStream) {
            this(tJANu357b19bRbOB, inputStream, new Inflater());
            this.WUhKn0e95d254Z0R = true;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            GRUy518803272Hp();
            if (read(this.WUhKn1d55f459Z0R, 0, 1) == -1) {
                return -1;
            }
            return Byte.toUnsignedInt(this.WUhKn1d55f459Z0R[0]);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x002d, code lost:
        
            r2.WUhKn7e5444d6Z0R = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:
        
            return -1;
         */
        @Override // java.io.FilterInputStream, java.io.InputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int read(byte[] r3, int r4, int r5) throws java.io.IOException {
            /*
                r2 = this;
                r2.GRUy518803272Hp()
                if (r3 != 0) goto Lb
                java.lang.NullPointerException r0 = new java.lang.NullPointerException
                r0.<init>()
                throw r0
            Lb:
                if (r4 < 0) goto L13
                if (r5 < 0) goto L13
                int r0 = r3.length
                int r0 = r0 - r4
                if (r5 <= r0) goto L19
            L13:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                r0.<init>()
                throw r0
            L19:
                if (r5 != 0) goto L3d
                r0 = 0
            L1c:
                return r0
            L1d:
                java.util.zip.Inflater r0 = r2.WUhKnd4d45763Z0R     // Catch: java.util.zip.DataFormatException -> L46
                boolean r0 = r0.finished()     // Catch: java.util.zip.DataFormatException -> L46
                if (r0 != 0) goto L2d
                java.util.zip.Inflater r0 = r2.WUhKnd4d45763Z0R     // Catch: java.util.zip.DataFormatException -> L46
                boolean r0 = r0.needsDictionary()     // Catch: java.util.zip.DataFormatException -> L46
                if (r0 == 0) goto L32
            L2d:
                r0 = 1
                r2.WUhKn7e5444d6Z0R = r0     // Catch: java.util.zip.DataFormatException -> L46
                r0 = -1
                goto L1c
            L32:
                java.util.zip.Inflater r0 = r2.WUhKnd4d45763Z0R     // Catch: java.util.zip.DataFormatException -> L46
                boolean r0 = r0.needsInput()     // Catch: java.util.zip.DataFormatException -> L46
                if (r0 == 0) goto L3d
                r2.fill()     // Catch: java.util.zip.DataFormatException -> L46
            L3d:
                java.util.zip.Inflater r0 = r2.WUhKnd4d45763Z0R     // Catch: java.util.zip.DataFormatException -> L46
                int r0 = r0.inflate(r3, r4, r5)     // Catch: java.util.zip.DataFormatException -> L46
                if (r0 == 0) goto L1d
                goto L1c
            L46:
                r0 = move-exception
                java.lang.String r0 = r0.getMessage()
                java.util.zip.ZipException r1 = new java.util.zip.ZipException
                if (r0 == 0) goto L53
            L4f:
                r1.<init>(r0)
                throw r1
            L53:
                java.lang.String r0 = ""
                goto L4f
            */
            throw new UnsupportedOperationException("Method not decompiled: TJANu601f538RbOB.TJANu28ebd7fRbOB.TJANu221acc9RbOB.TJANu357b19bRbOB.TJANu2d3ec0dRbOB.read(byte[], int, int):int");
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int available() throws IOException {
            GRUy518803272Hp();
            return this.WUhKn7e5444d6Z0R ? 0 : 1;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j2) throws IOException {
            if (j2 < 0) {
                throw new IllegalArgumentException(HttpUrl.FRAGMENT_ENCODE_SET);
            }
            GRUy518803272Hp();
            int iMin = (int) Math.min(j2, IntCompanionObject.MAX_VALUE);
            int i = 0;
            while (true) {
                if (i >= iMin) {
                    break;
                }
                int length = iMin - i;
                if (length > this.WUhKnc15d23bfZ0R.length) {
                    length = this.WUhKnc15d23bfZ0R.length;
                }
                int i2 = read(this.WUhKnc15d23bfZ0R, 0, length);
                if (i2 == -1) {
                    this.WUhKn7e5444d6Z0R = true;
                    break;
                }
                i = i2 + i;
            }
            return i;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.WUhKn9345ca5fZ0R) {
                return;
            }
            if (this.WUhKn0e95d254Z0R) {
                this.WUhKnd4d45763Z0R.end();
            }
            ((FilterInputStream) this).in.close();
            this.WUhKn9345ca5fZ0R = true;
        }

        protected void fill() throws IOException {
            GRUy518803272Hp();
            this.WUhKna33c0cdbZ0R = ((FilterInputStream) this).in.read(this.WUhKnc7085d0aZ0R, 0, this.WUhKnc7085d0aZ0R.length);
            if (this.WUhKna33c0cdbZ0R == -1) {
                throw new EOFException(HttpUrl.FRAGMENT_ENCODE_SET);
            }
            this.WUhKnd4d45763Z0R.setInput(this.WUhKnc7085d0aZ0R, 0, this.WUhKna33c0cdbZ0R);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public boolean markSupported() {
            return false;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() throws IOException {
            throw new IOException(HttpUrl.FRAGMENT_ENCODE_SET);
        }
    }
}
