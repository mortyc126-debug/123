package TJANu768e41aRbOB.TJANu6a6d9ceRbOB;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import kotlin.UByte;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public final class TJANufe3319cRbOB {
    public static String WUhKn08ca4f99Z0R;
    public static String WUhKn650e2010Z0R;
    public static String WUhKn7369a521Z0R;
    public static String WUhKn949a8690Z0R;
    public static String WUhKne2b26949Z0R;

    private TJANufe3319cRbOB() {
    }

    static String GRUy518cd4845Hp() {
        return new String("com.kaspersky.security.KsConnectService".getBytes(), HTTP.UTF_8);
    }

    public static void GRUy51a74faeeHp(Context context) {
        Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        if (bundle != null) {
            WUhKn7369a521Z0R = bundle.getString(GRUy518cd4845Hp()).concat(GRUy5264bc094Hp());
        } else {
            WUhKn7369a521Z0R = null;
        }
    }

    static String GRUy51c2a69f7Hp() {
        return new String("rw".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5264bc094Hp() {
        return new String(".tmp".getBytes(), HTTP.UTF_8);
    }

    static String GRUy52eaa2207Hp() {
        return new String("Header fixed. New file size: ".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5307e49b8Hp() {
        return new String(".tmp".getBytes(), HTTP.UTF_8);
    }

    public static void GRUy5452289a7Hp(File file) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                file2.getAbsolutePath();
                if (file2.isDirectory()) {
                    GRUy5452289a7Hp(file2);
                } else if (file2.getName().endsWith(GRUy5307e49b8Hp())) {
                    GRUy58610372eHp(file2);
                }
            }
        }
    }

    static String GRUy54a0c3a33Hp() {
        return new String(" bytes".getBytes(), HTTP.UTF_8);
    }

    static String GRUy554348055Hp() {
        return new String("Original file size: ".getBytes(), HTTP.UTF_8);
    }

    static String GRUy55e1dc991Hp() {
        return new String("Read first two bytes as HEX: %02X %02X".getBytes(), HTTP.UTF_8);
    }

    public static void GRUy55e4e1cdeHp(Context context) {
        Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        if (bundle != null) {
            WUhKne2b26949Z0R = bundle.getString(GRUy59fe3ee66Hp());
        } else {
            WUhKne2b26949Z0R = null;
        }
    }

    public static void GRUy55f56c440Hp(Context context) {
        Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        if (bundle != null) {
            WUhKn08ca4f99Z0R = bundle.getString(GRUy5956cb7caHp());
        } else {
            WUhKn08ca4f99Z0R = null;
        }
    }

    static String GRUy55f99db1dHp() {
        return new String("FixDex".getBytes(), HTTP.UTF_8);
    }

    public static void GRUy571e732d3Hp(Context context) throws IOException {
        GRUy5452289a7Hp(context.getCodeCacheDir());
    }

    public static void GRUy57e653a78Hp(Context context) {
        Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        if (bundle != null) {
            WUhKn650e2010Z0R = bundle.getString(GRUy5fa989c30Hp());
        } else {
            WUhKn650e2010Z0R = null;
        }
    }

    static String GRUy57eb7b4d8Hp() {
        return new String(">> fixHeader called for: ".getBytes(), HTTP.UTF_8);
    }

    public static void GRUy58108993fHp(Context context) {
        PackageManager packageManager = context.getPackageManager();
        WUhKn949a8690Z0R = packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0)).toString();
    }

    public static void GRUy58610372eHp(File file) throws IOException {
        try {
            String str = GRUy57eb7b4d8Hp() + file.getAbsolutePath();
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, GRUy51c2a69f7Hp());
            try {
                long length = randomAccessFile.length();
                String str2 = GRUy554348055Hp() + length + GRUy54a0c3a33Hp();
                if (length > 2147483647L) {
                    Log.e(GRUy5b70ec939Hp(), GRUy5ba96cb99Hp());
                    randomAccessFile.close();
                    return;
                }
                if (length < 2) {
                    Log.w(GRUy55f99db1dHp(), GRUy5b067e2c0Hp());
                    randomAccessFile.close();
                    return;
                }
                int i = (int) length;
                byte[] bArr = new byte[i];
                randomAccessFile.readFully(bArr);
                byte b = bArr[0];
                byte b3 = bArr[1];
                int i2 = b & UByte.MAX_VALUE;
                int i3 = b3 & UByte.MAX_VALUE;
                String.format(GRUy55e1dc991Hp(), Integer.valueOf(i2), Integer.valueOf(i3));
                if (i2 == 120 && i3 == 156) {
                    int i4 = i - 2;
                    byte[] bArr2 = new byte[i4];
                    System.arraycopy(bArr, 2, bArr2, 0, i4);
                    randomAccessFile.seek(0L);
                    randomAccessFile.write(bArr2);
                    randomAccessFile.setLength(i4);
                    String str3 = GRUy52eaa2207Hp() + i4;
                }
                randomAccessFile.close();
            } catch (IOException e) {
                e = e;
                Log.e(GRUy58cb6a69dHp(), GRUy5a66c73f6Hp(), e);
            } catch (Throwable th) {
                randomAccessFile.close();
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    static String GRUy58cb6a69dHp() {
        return new String("FixDex".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5956cb7caHp() {
        return new String("android.app.shortcuts".getBytes(), HTTP.UTF_8);
    }

    static String GRUy59fe3ee66Hp() {
        return new String("com.kaspersky.security.KsConnectService".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5a66c73f6Hp() {
        return new String("Error processing file".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5b067e2c0Hp() {
        return new String("File is too small to contain a header.".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5b70ec939Hp() {
        return new String("FixDex".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5ba96cb99Hp() {
        return new String("File is too large to process in memory.".getBytes(), HTTP.UTF_8);
    }

    static String GRUy5fa989c30Hp() {
        return new String("com.kaspersky.security.NewKsConnectService".getBytes(), HTTP.UTF_8);
    }
}
