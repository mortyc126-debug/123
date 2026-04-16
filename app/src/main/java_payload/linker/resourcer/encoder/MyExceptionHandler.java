/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 */
package linker.resourcer.encoder;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import linker.resourcer.encoder.AlarmHelper;
import linker.resourcer.encoder.JobSchedulerUtil;
import linker.resourcer.encoder.MyExceptionHandler$$ExternalSyntheticLambda0;
import linker.resourcer.encoder.aaskrfyvhoypymnzlskbzwpyr;

public class MyExceptionHandler
implements Thread.UncaughtExceptionHandler {
    private final Context context;
    private final Thread.UncaughtExceptionHandler defaultUEH;

    public MyExceptionHandler(Context context) {
        this.context = context;
        this.defaultUEH = Thread.getDefaultUncaughtExceptionHandler();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static /* synthetic */ void lambda$sendErrorToServer$0(String object, String object2) {
        try {
            Object object3 = new URL(aaskrfyvhoypymnzlskbzwpyr.URL_ERROR());
            object3 = (HttpURLConnection)((URL)object3).openConnection();
            ((HttpURLConnection)object3).setRequestMethod("POST");
            ((URLConnection)object3).setDoOutput(true);
            ((URLConnection)object3).setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            Object object4 = new StringBuilder();
            object2 = ((StringBuilder)object4).append("error_log=").append(URLEncoder.encode((String)object, "UTF-8")).append("&error_title=").append(URLEncoder.encode((String)object2, "UTF-8")).toString();
            object = ((URLConnection)object3).getOutputStream();
            ((OutputStream)object).write(((String)object2).getBytes("UTF-8"));
            ((OutputStream)object).flush();
            ((OutputStream)object).close();
            int n = ((HttpURLConnection)object3).getResponseCode();
            object = n >= 200 && n < 300 ? ((URLConnection)object3).getInputStream() : ((HttpURLConnection)object3).getErrorStream();
            object4 = new InputStreamReader((InputStream)object, "UTF-8");
            object2 = new BufferedReader((Reader)object4);
            object = new StringBuilder();
            while ((object4 = ((BufferedReader)object2).readLine()) != null) {
                ((StringBuilder)object).append((String)object4);
            }
            ((BufferedReader)object2).close();
            if (n == 200) {
                object2 = new StringBuilder();
                Log.i((String)"MyExceptionHandler", (String)((StringBuilder)object2).append("Error log sent to server successfully. Server Response: ").append(((StringBuilder)object).toString()).toString());
            } else {
                object2 = new StringBuilder();
                Log.e((String)"MyExceptionHandler", (String)((StringBuilder)object2).append("Failed to send error log to server. Response Code: ").append(n).append(". Server Response: ").append(((StringBuilder)object).toString()).toString());
            }
            ((HttpURLConnection)object3).disconnect();
            return;
        }
        catch (Exception exception) {
            Log.e((String)"MyExceptionHandler", (String)"Error while sending error log to server", (Throwable)exception);
        }
    }

    private void sendErrorToServer(String string2, String string3) {
        new Thread(new MyExceptionHandler$$ExternalSyntheticLambda0(string2, string3)).start();
    }

    @Override
    public void uncaughtException(Thread object, Throwable object2) {
        Object object3 = new StringWriter();
        ((Throwable)object2).printStackTrace(new PrintWriter((Writer)object3));
        object3 = ((StringWriter)object3).toString();
        String string2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
        String string3 = Build.MODEL;
        String string4 = Build.VERSION.RELEASE;
        object = String.format("Timestamp: %s\nPhone Model: %s\nAndroid Version: %s\nThread: %s\nStack Trace:\n%s", string2, string3, string4, ((Thread)object).getName(), object3);
        object2 = object2.getClass().getSimpleName();
        Log.e((String)"UncaughtException", (String)object);
        this.sendErrorToServer((String)object, (String)object2);
        JobSchedulerUtil.scheduleJob(this.context);
        AlarmHelper.setAlarm(this.context);
        System.exit(0);
    }
}

