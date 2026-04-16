/*
 * Decompiled with CFR 0.152.
 */
package linker.resourcer.encoder;

import com.jcraft.jsch.ChannelShell;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.Properties;
import linker.resourcer.encoder.IRemoteShell;

public class SshShell
implements IRemoteShell {
    private ChannelShell channel;
    private Session session;
    private BufferedWriter shellInput;
    private BufferedReader shellOutput;

    public SshShell(String object, int n, String object2, String object3) throws Exception {
        Object object4 = new JSch();
        this.session = ((JSch)object4).getSession((String)object2, (String)object, n);
        this.session.setPassword((String)object3);
        object = new Properties();
        ((Properties)object).put("StrictHostKeyChecking", "no");
        this.session.setConfig((Properties)object);
        try {
            this.session.connect(10000);
        }
        catch (JSchException jSchException) {
            object = jSchException.getMessage() != null ? jSchException.getMessage().toLowerCase() : "";
            try {
                if (!((String)object).contains("auth fail") && !((String)object).contains("userauth fail")) {
                    if (!((String)object).contains("timeout")) {
                        if (!((String)object).contains("reject") && !((String)object).contains("hostkey")) {
                            object3 = new StringBuilder();
                            object = new Exception(((StringBuilder)object3).append("SSH_CONNECT_ERROR: ").append(jSchException.getMessage()).toString(), jSchException);
                            throw object;
                        }
                        object3 = new StringBuilder();
                        object = new Exception(((StringBuilder)object3).append("HOSTKEY_ERROR: ").append(jSchException.getMessage()).toString(), jSchException);
                        throw object;
                    }
                    object = new Exception(((StringBuilder)object3).append("TIMEOUT: ").append(jSchException.getMessage()).toString(), jSchException);
                    throw object;
                }
                super();
                object = new Exception(((StringBuilder)object3).append("AUTH_FAILED: ").append(jSchException.getMessage()).toString(), jSchException);
                throw object;
            }
            catch (ConnectException connectException) {
                throw new Exception("CONNECTION_REFUSED: " + connectException.getMessage(), connectException);
            }
            catch (UnknownHostException unknownHostException) {
                throw new Exception("HOST_UNREACHABLE: " + unknownHostException.getMessage(), unknownHostException);
            }
        }
        this.channel = (ChannelShell)this.session.openChannel("shell");
        object = this.channel.getInputStream();
        object2 = this.channel.getOutputStream();
        this.channel.connect(5000);
        object3 = new OutputStreamWriter((OutputStream)object2);
        this.shellInput = object4 = new BufferedWriter((Writer)object3);
        object3 = new InputStreamReader((InputStream)object);
        this.shellOutput = object2 = new BufferedReader((Reader)object3);
    }

    @Override
    public void close() {
        try {
            if (this.shellInput != null) {
                this.shellInput.write("exit");
                this.shellInput.newLine();
                this.shellInput.flush();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        if (this.channel != null && this.channel.isConnected()) {
            this.channel.disconnect();
        }
        if (this.session != null && this.session.isConnected()) {
            this.session.disconnect();
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
                    CharSequence charSequence2 = new StringBuilder();
                    charSequence2 = charSequence2.append("___CMD_END___").append(System.currentTimeMillis()).toString();
                    this.shellInput.write((String)charSequence);
                    this.shellInput.newLine();
                    Object object = this.shellInput;
                    charSequence = new StringBuilder();
                    ((Writer)object).write(((StringBuilder)charSequence).append("echo ").append((String)charSequence2).toString());
                    this.shellInput.newLine();
                    this.shellInput.flush();
                    charSequence = new StringBuilder();
                    while ((object = this.shellOutput.readLine()) != null) {
                        if (((String)object).contains(charSequence2)) return ((StringBuilder)charSequence).toString().trim();
                        ((StringBuilder)charSequence).append((String)object).append("\n");
                    }
                    return ((StringBuilder)charSequence).toString().trim();
                }
                catch (Throwable throwable2) {
                    break block7;
                }
                catch (Exception exception) {
                    charSequence = new StringBuilder();
                    return ((StringBuilder)charSequence).append("ERROR: ").append(exception.getMessage()).toString();
                }
            }
            throw throwable2;
        }
    }
}

