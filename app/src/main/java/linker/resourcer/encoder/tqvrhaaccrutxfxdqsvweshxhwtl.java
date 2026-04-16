/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningServiceInfo
 *  android.content.ComponentName
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.RectF
 *  android.provider.Settings$Secure
 *  android.text.TextUtils$SimpleStringSplitter
 */
package linker.resourcer.encoder;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.provider.Settings;
import android.text.TextUtils;

public class tqvrhaaccrutxfxdqsvweshxhwtl {
    public static boolean isServiceRunning(Context object, Class<?> clazz) {
        for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager)object.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE)) {
            if (!clazz.getName().equals(runningServiceInfo.service.getClassName())) continue;
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean is_Access_Enabled(Context context, Class<?> object) {
        try {
            ComponentName componentName = new ComponentName(context, (Class)object);
            object = Settings.Secure.getString((ContentResolver)context.getContentResolver(), (String)"enabled_accessibility_services");
            if (object == null) {
                return false;
            }
            context = new TextUtils.SimpleStringSplitter(':');
            context.setString((String)object);
            while (context.hasNext()) {
                boolean bl;
                object = ComponentName.unflattenFromString((String)context.next());
                if (object == null || !(bl = object.equals((Object)componentName))) continue;
                return true;
            }
            return false;
        }
        catch (Exception exception) {
            // empty catch block
        }
        return false;
    }

    public static Bitmap scaleCenterCrop(Bitmap bitmap, int n, int n2) {
        int n3 = bitmap.getWidth();
        int n4 = bitmap.getHeight();
        float f = Math.max((float)n2 / (float)n3, (float)n / (float)n4);
        float f2 = (float)n3 * f;
        f = (float)n4 * f;
        float f3 = ((float)n2 - f2) / 2.0f;
        float f4 = ((float)n - f) / 2.0f;
        RectF rectF = new RectF(f3, f4, f3 + f2, f4 + f);
        Bitmap bitmap2 = Bitmap.createBitmap((int)n2, (int)n, (Bitmap.Config)bitmap.getConfig());
        new Canvas(bitmap2).drawBitmap(bitmap, null, rectF, null);
        return bitmap2;
    }
}

