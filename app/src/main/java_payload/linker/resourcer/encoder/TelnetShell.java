/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.net.telnet.TelnetClient
 */
package linker.resourcer.encoder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import linker.resourcer.encoder.IRemoteShell;
import org.apache.commons.net.telnet.TelnetClient;

public class TelnetShell
implements IRemoteShell {
    private BufferedWriter shellInput;
    private BufferedReader shellOutput;
    private TelnetClient telnet;

    public TelnetShell(String object, int n, String string2, String string3) throws Exception {
        try {
            Object object2;
            this.telnet = object2 = new TelnetClient();
            this.telnet.setDefaultTimeout(10000);
            this.telnet.connect((String)object, n);
            object = new OutputStreamWriter(this.telnet.getOutputStream());
            super((Writer)object);
            this.shellInput = object2;
            super(this.telnet.getInputStream());
            this.shellOutput = object = new BufferedReader((Reader)object2);
            this.login(string2, string3);
            return;
        }
        catch (SocketTimeoutException socketTimeoutException) {
            throw new Exception("TIMEOUT: " + socketTimeoutException.getMessage(), socketTimeoutException);
        }
        catch (ConnectException connectException) {
            throw new Exception("CONNECTION_REFUSED: " + connectException.getMessage(), connectException);
        }
        catch (UnknownHostException unknownHostException) {
            throw new Exception("HOST_UNREACHABLE: " + unknownHostException.getMessage(), unknownHostException);
        }
    }

    private void login(String string2, String string3) throws Exception {
        if (this.readUntilAny(10000L, "login:", "Login:", "Username:", "User:")) {
            this.writeLine(string2);
            if (this.readUntilAny(10000L, "Password:", "password:")) {
                this.writeLine(string3);
                if (this.readUntilAny(10000L, "#", "$", ">")) {
                    return;
                }
                throw new Exception("AUTH_FAILED_OR_NO_SHELL_PROMPT");
            }
            throw new Exception("PASSWORD_PROMPT_TIMEOUT");
        }
        throw new Exception("LOGIN_PROMPT_TIMEOUT");
    }

    /*
     * Unable to fully structure code
     */
    private boolean readUntilAny(long var1_1, String ... var3_2) throws IOException {
        var8_3 = System.currentTimeMillis();
        var10_4 = new StringBuilder();
        block2: while (true) {
            var6_7 = System.currentTimeMillis();
            var4_5 = 0;
            if (var6_7 - var8_3 >= var1_1) break;
            if (!this.shellOutput.ready()) {
                try {
                    Thread.sleep(50L);
                }
                catch (InterruptedException var11_9) {}
                continue;
            }
            var5_6 = this.shellOutput.read();
            if (var5_6 == -1) break;
            var10_4.append((char)var5_6);
            var12_10 = var10_4.toString();
            var5_6 = var3_2.length;
            while (true) {
                if (var4_5 < var5_6) ** break;
                continue block2;
                var11_8 = var3_2[var4_5];
                if (var11_8 != null && !var11_8.isEmpty() && var12_10.endsWith(var11_8)) {
                    return true;
                }
                ++var4_5;
            }
            break;
        }
        return false;
    }

    private void writeLine(String string2) throws IOException {
        this.shellInput.write(string2);
        this.shellInput.newLine();
        this.shellInput.flush();
    }

    @Override
    public void close() {
        try {
            this.writeLine("exit");
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            if (this.telnet != null && this.telnet.isConnected()) {
                this.telnet.disconnect();
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public String sendCommand(String charSequence) {
        synchronized (this) {
            Throwable throwable2;
            block7: {
                try {
                    String string2;
                    CharSequence charSequence2 = new StringBuilder();
                    charSequence2 = charSequence2.append("___CMD_END___").append(System.currentTimeMillis()).toString();
                    this.writeLine((String)charSequence);
                    charSequence = new StringBuilder();
                    this.writeLine(((StringBuilder)charSequence).append("echo ").append((String)charSequence2).toString());
                    charSequence = new StringBuilder();
                    while ((string2 = this.shellOutput.readLine()) != null) {
                        if (string2.contains(charSequence2)) return ((StringBuilder)charSequence).toString().trim();
                        ((StringBuilder)charSequence).append(string2).append("\n");
                    }
                    return ((StringBuilder)charSequence).toString().trim();
                }
                catch (Throwable throwable2) {
                    break block7;
                }
                catch (Exception exception) {
                    StringBuilder stringBuilder = new StringBuilder();
                    return stringBuilder.append("ERROR: ").append(exception.getMessage()).toString();
                }
            }
            throw throwable2;
        }
    }
}

