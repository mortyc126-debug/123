package org.apache.commons.net.smtp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import org.apache.commons.net.MalformedServerReplyException;
import org.apache.commons.net.ProtocolCommandListener;
import org.apache.commons.net.ProtocolCommandSupport;
import org.apache.commons.net.SocketClient;
import org.apache.commons.net.io.CRLFLineReader;
import org.apache.commons.net.util.NetConstants;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes2.dex */
public class SMTP extends SocketClient {
    private static final String DEFAULT_ENCODING = "ISO-8859-1";
    public static final int DEFAULT_PORT = 25;
    protected ProtocolCommandSupport _commandSupport_;
    protected final String encoding;
    private boolean newReplyString;
    BufferedReader reader;
    private int replyCode;
    private final ArrayList<String> replyLines;
    private String replyString;
    BufferedWriter writer;

    public SMTP() {
        this("ISO-8859-1");
    }

    public SMTP(String encoding) {
        setDefaultPort(25);
        this.replyLines = new ArrayList<>();
        this.newReplyString = false;
        this.replyString = null;
        this._commandSupport_ = new ProtocolCommandSupport(this);
        this.encoding = encoding;
    }

    @Override // org.apache.commons.net.SocketClient
    protected void _connectAction_() throws IOException {
        super._connectAction_();
        this.reader = new CRLFLineReader(new InputStreamReader(this._input_, this.encoding));
        this.writer = new BufferedWriter(new OutputStreamWriter(this._output_, this.encoding));
        getReply();
    }

    public int data() throws IOException {
        return sendCommand(3);
    }

    @Override // org.apache.commons.net.SocketClient
    public void disconnect() throws IOException {
        super.disconnect();
        this.reader = null;
        this.writer = null;
        this.replyString = null;
        this.replyLines.clear();
        this.newReplyString = false;
    }

    public int expn(String name) throws IOException {
        return sendCommand(9, name);
    }

    @Override // org.apache.commons.net.SocketClient
    protected ProtocolCommandSupport getCommandSupport() {
        return this._commandSupport_;
    }

    public int getReply() throws IOException {
        this.newReplyString = true;
        this.replyLines.clear();
        String line = this.reader.readLine();
        if (line == null) {
            throw new SMTPConnectionClosedException("Connection closed without indication.");
        }
        int length = line.length();
        if (length >= 3) {
            try {
                String code = line.substring(0, 3);
                this.replyCode = Integer.parseInt(code);
                this.replyLines.add(line);
                if (length > 3 && line.charAt(3) == '-') {
                    while (true) {
                        String line2 = this.reader.readLine();
                        if (line2 == null) {
                            throw new SMTPConnectionClosedException("Connection closed without indication.");
                        }
                        this.replyLines.add(line2);
                        if (line2.length() >= 4 && line2.charAt(3) != '-' && Character.isDigit(line2.charAt(0))) {
                            break;
                        }
                    }
                }
                fireReplyReceived(this.replyCode, getReplyString());
                if (this.replyCode == 421) {
                    throw new SMTPConnectionClosedException("SMTP response 421 received.  Server closed connection.");
                }
                return this.replyCode;
            } catch (NumberFormatException e) {
                throw new MalformedServerReplyException("Could not parse response code.\nServer Reply: " + line);
            }
        }
        throw new MalformedServerReplyException("Truncated server reply: " + line);
    }

    public int getReplyCode() {
        return this.replyCode;
    }

    public String getReplyString() {
        if (!this.newReplyString) {
            return this.replyString;
        }
        StringBuilder buffer = new StringBuilder();
        for (String line : this.replyLines) {
            buffer.append(line);
            buffer.append(SocketClient.NETASCII_EOL);
        }
        this.newReplyString = false;
        this.replyString = buffer.toString();
        return this.replyString;
    }

    public String[] getReplyStrings() {
        return (String[]) this.replyLines.toArray(NetConstants.EMPTY_STRING_ARRAY);
    }

    public int helo(String hostname) throws IOException {
        return sendCommand(0, hostname);
    }

    public int help() throws IOException {
        return sendCommand(10);
    }

    public int help(String command) throws IOException {
        return sendCommand(10, command);
    }

    public int mail(String reversePath) throws IOException {
        return sendCommand(1, reversePath, false);
    }

    public int noop() throws IOException {
        return sendCommand(11);
    }

    public int quit() throws IOException {
        return sendCommand(13);
    }

    public int rcpt(String forwardPath) throws IOException {
        return sendCommand(2, forwardPath, false);
    }

    public void removeProtocolCommandistener(ProtocolCommandListener listener) {
        removeProtocolCommandListener(listener);
    }

    public int rset() throws IOException {
        return sendCommand(7);
    }

    public int saml(String reversePath) throws IOException {
        return sendCommand(6, reversePath);
    }

    public int send(String reversePath) throws IOException {
        return sendCommand(4, reversePath);
    }

    public int sendCommand(int command) throws IOException {
        return sendCommand(command, (String) null);
    }

    public int sendCommand(int command, String args) throws IOException {
        return sendCommand(SMTPCommand.getCommand(command), args);
    }

    private int sendCommand(int command, String args, boolean includeSpace) throws IOException {
        return sendCommand(SMTPCommand.getCommand(command), args, includeSpace);
    }

    public int sendCommand(String command) throws IOException {
        return sendCommand(command, (String) null);
    }

    public int sendCommand(String command, String args) throws IOException {
        return sendCommand(command, args, true);
    }

    private int sendCommand(String command, String args, boolean includeSpace) throws IOException {
        StringBuilder __commandBuffer = new StringBuilder();
        __commandBuffer.append(command);
        if (args != null) {
            if (includeSpace) {
                __commandBuffer.append(TokenParser.SP);
            }
            __commandBuffer.append(args);
        }
        __commandBuffer.append(SocketClient.NETASCII_EOL);
        String message = __commandBuffer.toString();
        this.writer.write(message);
        this.writer.flush();
        fireCommandSent(command, message);
        return getReply();
    }

    public int soml(String reversePath) throws IOException {
        return sendCommand(5, reversePath);
    }

    public int turn() throws IOException {
        return sendCommand(12);
    }

    public int vrfy(String user) throws IOException {
        return sendCommand(8, user);
    }
}
