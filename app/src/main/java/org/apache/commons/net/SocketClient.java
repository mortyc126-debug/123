package org.apache.commons.net;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.Charset;
import javax.net.ServerSocketFactory;
import javax.net.SocketFactory;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SocketClient {
    private static final int DEFAULT_CONNECT_TIMEOUT = 60000;
    public static final String NETASCII_EOL = "\r\n";
    private ProtocolCommandSupport commandSupport;
    private Proxy connProxy;
    private static final SocketFactory DEFAULT_SOCKET_FACTORY = SocketFactory.getDefault();
    private static final ServerSocketFactory DEFAULT_SERVER_SOCKET_FACTORY = ServerSocketFactory.getDefault();
    protected int connectTimeout = DEFAULT_CONNECT_TIMEOUT;
    private int receiveBufferSize = -1;
    private int sendBufferSize = -1;
    private Charset charset = Charset.defaultCharset();
    protected Socket _socket_ = null;
    protected String _hostname_ = null;
    protected InputStream _input_ = null;
    protected OutputStream _output_ = null;
    protected int _timeout_ = 0;
    protected int _defaultPort_ = 0;
    protected SocketFactory _socketFactory_ = DEFAULT_SOCKET_FACTORY;
    protected ServerSocketFactory _serverSocketFactory_ = DEFAULT_SERVER_SOCKET_FACTORY;

    private void _connect(InetAddress host, int port, InetAddress localAddr, int localPort) throws IOException {
        this._socket_ = this._socketFactory_.createSocket();
        if (this.receiveBufferSize != -1) {
            this._socket_.setReceiveBufferSize(this.receiveBufferSize);
        }
        if (this.sendBufferSize != -1) {
            this._socket_.setSendBufferSize(this.sendBufferSize);
        }
        if (localAddr != null) {
            this._socket_.bind(new InetSocketAddress(localAddr, localPort));
        }
        this._socket_.connect(new InetSocketAddress(host, port), this.connectTimeout);
        _connectAction_();
    }

    protected void _connectAction_() throws IOException {
        applySocketAttributes();
        this._input_ = this._socket_.getInputStream();
        this._output_ = this._socket_.getOutputStream();
    }

    public void addProtocolCommandListener(ProtocolCommandListener listener) {
        getCommandSupport().addProtocolCommandListener(listener);
    }

    protected void applySocketAttributes() throws SocketException {
        this._socket_.setSoTimeout(this._timeout_);
    }

    private void closeQuietly(Closeable close) {
        if (close != null) {
            try {
                close.close();
            } catch (IOException e) {
            }
        }
    }

    private void closeQuietly(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
            }
        }
    }

    public void connect(InetAddress host) throws IOException {
        this._hostname_ = null;
        connect(host, this._defaultPort_);
    }

    public void connect(InetAddress host, int port) throws IOException {
        this._hostname_ = null;
        _connect(host, port, null, -1);
    }

    public void connect(InetAddress host, int port, InetAddress localAddr, int localPort) throws IOException {
        this._hostname_ = null;
        _connect(host, port, localAddr, localPort);
    }

    public void connect(String hostname) throws IOException {
        connect(hostname, this._defaultPort_);
    }

    public void connect(String hostname, int port) throws IOException {
        this._hostname_ = hostname;
        _connect(InetAddress.getByName(hostname), port, null, -1);
    }

    public void connect(String hostname, int port, InetAddress localAddr, int localPort) throws IOException {
        this._hostname_ = hostname;
        _connect(InetAddress.getByName(hostname), port, localAddr, localPort);
    }

    protected void createCommandSupport() {
        this.commandSupport = new ProtocolCommandSupport(this);
    }

    public void disconnect() throws IOException {
        closeQuietly(this._socket_);
        closeQuietly(this._input_);
        closeQuietly(this._output_);
        this._socket_ = null;
        this._hostname_ = null;
        this._input_ = null;
        this._output_ = null;
    }

    protected void fireCommandSent(String command, String message) {
        if (getCommandSupport().getListenerCount() > 0) {
            getCommandSupport().fireCommandSent(command, message);
        }
    }

    protected void fireReplyReceived(int replyCode, String reply) {
        if (getCommandSupport().getListenerCount() > 0) {
            getCommandSupport().fireReplyReceived(replyCode, reply);
        }
    }

    public Charset getCharset() {
        return this.charset;
    }

    @Deprecated
    public String getCharsetName() {
        return this.charset.name();
    }

    protected ProtocolCommandSupport getCommandSupport() {
        return this.commandSupport;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public int getDefaultPort() {
        return this._defaultPort_;
    }

    public int getDefaultTimeout() {
        return this._timeout_;
    }

    public boolean getKeepAlive() throws SocketException {
        return this._socket_.getKeepAlive();
    }

    public InetAddress getLocalAddress() {
        return this._socket_.getLocalAddress();
    }

    public int getLocalPort() {
        return this._socket_.getLocalPort();
    }

    public Proxy getProxy() {
        return this.connProxy;
    }

    protected int getReceiveBufferSize() {
        return this.receiveBufferSize;
    }

    public InetAddress getRemoteAddress() {
        return this._socket_.getInetAddress();
    }

    public int getRemotePort() {
        return this._socket_.getPort();
    }

    protected int getSendBufferSize() {
        return this.sendBufferSize;
    }

    public ServerSocketFactory getServerSocketFactory() {
        return this._serverSocketFactory_;
    }

    public int getSoLinger() throws SocketException {
        return this._socket_.getSoLinger();
    }

    public int getSoTimeout() throws SocketException {
        return this._socket_.getSoTimeout();
    }

    public boolean getTcpNoDelay() throws SocketException {
        return this._socket_.getTcpNoDelay();
    }

    public boolean isAvailable() {
        if (!isConnected()) {
            return false;
        }
        try {
            if (this._socket_.getInetAddress() == null || this._socket_.getPort() == 0 || this._socket_.getRemoteSocketAddress() == null || this._socket_.isClosed() || this._socket_.isInputShutdown() || this._socket_.isOutputShutdown()) {
                return false;
            }
            this._socket_.getInputStream();
            this._socket_.getOutputStream();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean isConnected() {
        if (this._socket_ == null) {
            return false;
        }
        return this._socket_.isConnected();
    }

    public void removeProtocolCommandListener(ProtocolCommandListener listener) {
        getCommandSupport().removeProtocolCommandListener(listener);
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public void setDefaultPort(int port) {
        this._defaultPort_ = port;
    }

    public void setDefaultTimeout(int timeout) {
        this._timeout_ = timeout;
    }

    public void setKeepAlive(boolean keepAlive) throws SocketException {
        this._socket_.setKeepAlive(keepAlive);
    }

    public void setProxy(Proxy proxy) {
        setSocketFactory(new DefaultSocketFactory(proxy));
        this.connProxy = proxy;
    }

    public void setReceiveBufferSize(int size) throws SocketException {
        this.receiveBufferSize = size;
    }

    public void setSendBufferSize(int size) throws SocketException {
        this.sendBufferSize = size;
    }

    public void setServerSocketFactory(ServerSocketFactory factory) {
        if (factory == null) {
            this._serverSocketFactory_ = DEFAULT_SERVER_SOCKET_FACTORY;
        } else {
            this._serverSocketFactory_ = factory;
        }
    }

    public void setSocketFactory(SocketFactory factory) {
        if (factory == null) {
            this._socketFactory_ = DEFAULT_SOCKET_FACTORY;
        } else {
            this._socketFactory_ = factory;
        }
    }

    public void setSoLinger(boolean on, int val) throws SocketException {
        this._socket_.setSoLinger(on, val);
    }

    public void setSoTimeout(int timeout) throws SocketException {
        this._socket_.setSoTimeout(timeout);
    }

    public void setTcpNoDelay(boolean on) throws SocketException {
        this._socket_.setTcpNoDelay(on);
    }

    public boolean verifyRemote(Socket socket) {
        InetAddress host1 = socket.getInetAddress();
        InetAddress host2 = getRemoteAddress();
        return host1.equals(host2);
    }
}
