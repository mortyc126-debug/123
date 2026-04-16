/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.Buffer;
import com.jcraft.jsch.ChannelAgentForwarding;
import com.jcraft.jsch.ChannelDirectTCPIP;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelForwardedTCPIP;
import com.jcraft.jsch.ChannelSession;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelShell;
import com.jcraft.jsch.ChannelSubsystem;
import com.jcraft.jsch.ChannelX11;
import com.jcraft.jsch.IO;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Packet;
import com.jcraft.jsch.RequestSignal;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.Util;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Vector;

public abstract class Channel
implements Runnable {
    static final int SSH_MSG_CHANNEL_OPEN_CONFIRMATION = 91;
    static final int SSH_MSG_CHANNEL_OPEN_FAILURE = 92;
    static final int SSH_MSG_CHANNEL_WINDOW_ADJUST = 93;
    static final int SSH_OPEN_ADMINISTRATIVELY_PROHIBITED = 1;
    static final int SSH_OPEN_CONNECT_FAILED = 2;
    static final int SSH_OPEN_RESOURCE_SHORTAGE = 4;
    static final int SSH_OPEN_UNKNOWN_CHANNEL_TYPE = 3;
    static int index = 0;
    private static Vector pool = new Vector();
    volatile boolean close = false;
    volatile int connectTimeout = 0;
    volatile boolean connected = false;
    volatile boolean eof_local = false;
    volatile boolean eof_remote = false;
    volatile int exitstatus = -1;
    int id;
    IO io = null;
    volatile int lmpsize = 16384;
    volatile int lwsize;
    volatile int lwsize_max;
    int notifyme = 0;
    volatile boolean open_confirmation = false;
    volatile int recipient = -1;
    volatile int reply = 0;
    volatile int rmpsize = 0;
    volatile long rwsize = 0L;
    private Session session;
    Thread thread = null;
    protected byte[] type = Util.str2byte("foo");

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    Channel() {
        this.lwsize = this.lwsize_max = 0x100000;
        Vector vector = pool;
        synchronized (vector) {
            int n = index;
            index = n + 1;
            this.id = n;
            pool.addElement(this);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static void del(Channel channel) {
        Vector vector = pool;
        synchronized (vector) {
            pool.removeElement(channel);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static void disconnect(Session session) {
        Channel[] channelArray;
        int n = 0;
        int n2 = 0;
        Vector vector = pool;
        synchronized (vector) {
            channelArray = new Channel[pool.size()];
            int n3 = 0;
            while (true) {
                n = n2;
                n = pool.size();
                if (n3 >= n) break;
                n = n2;
                try {
                    Channel channel = (Channel)pool.elementAt(n3);
                    n = n2;
                    Channel channel2 = channel;
                    n = n2;
                    Session session2 = channel.session;
                    n = n2;
                    if (session2 == session) {
                        channelArray[n2] = channel;
                        n = n2 + 1;
                    }
                    n2 = n;
                }
                catch (Exception exception) {
                    // empty catch block
                }
                ++n3;
            }
            n = n2;
        }
        n = 0;
        while (n < n2) {
            channelArray[n].disconnect();
            ++n;
        }
        return;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static Channel getChannel(int n, Session session) {
        Vector vector = pool;
        synchronized (vector) {
            int n2 = 0;
            while (n2 < pool.size()) {
                Channel channel;
                Channel channel2 = channel = (Channel)pool.elementAt(n2);
                if (channel.id == n && channel.session == session) {
                    return channel;
                }
                ++n2;
            }
            return null;
        }
    }

    static Channel getChannel(String string2) {
        if (string2.equals("session")) {
            return new ChannelSession();
        }
        if (string2.equals("shell")) {
            return new ChannelShell();
        }
        if (string2.equals("exec")) {
            return new ChannelExec();
        }
        if (string2.equals("x11")) {
            return new ChannelX11();
        }
        if (string2.equals("auth-agent@openssh.com")) {
            return new ChannelAgentForwarding();
        }
        if (string2.equals("direct-tcpip")) {
            return new ChannelDirectTCPIP();
        }
        if (string2.equals("forwarded-tcpip")) {
            return new ChannelForwardedTCPIP();
        }
        if (string2.equals("sftp")) {
            return new ChannelSftp();
        }
        if (string2.equals("subsystem")) {
            return new ChannelSubsystem();
        }
        return null;
    }

    void addRemoteWindowSize(long l) {
        synchronized (this) {
            this.rwsize += l;
            if (this.notifyme > 0) {
                this.notifyAll();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void close() {
        Packet packet;
        if (this.close) {
            return;
        }
        this.close = true;
        this.eof_remote = true;
        this.eof_local = true;
        int n = this.getRecipient();
        if (n == -1) {
            return;
        }
        try {
            Buffer buffer = new Buffer(100);
            packet = new Packet(buffer);
            packet.reset();
            buffer.putByte((byte)97);
            buffer.putInt(n);
            synchronized (this) {
            }
        }
        catch (Exception exception) {
            // empty catch block
            return;
        }
        {
            this.getSession().write(packet);
            return;
        }
    }

    public void connect() throws JSchException {
        this.connect(0);
    }

    public void connect(int n) throws JSchException {
        this.connectTimeout = n;
        try {
            this.sendChannelOpen();
            this.start();
            return;
        }
        catch (Exception exception) {
            this.connected = false;
            this.disconnect();
            if (exception instanceof JSchException) {
                throw (JSchException)exception;
            }
            throw new JSchException(exception.toString(), exception);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void disconnect() {
        if (!this.connected) {
            // MONITOREXIT : this
            Channel.del(this);
            return;
        }
        this.connected = false;
        // MONITOREXIT : this
        try {
            this.close();
            this.eof_local = true;
            this.eof_remote = true;
            this.thread = null;
            try {
                if (this.io == null) return;
                this.io.close();
                return;
            }
            catch (Exception exception) {
                // empty catch block
                return;
            }
        }
        finally {
            Channel.del(this);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void eof() {
        Packet packet;
        if (this.eof_local) {
            return;
        }
        this.eof_local = true;
        int n = this.getRecipient();
        if (n == -1) {
            return;
        }
        try {
            Buffer buffer = new Buffer(100);
            packet = new Packet(buffer);
            packet.reset();
            buffer.putByte((byte)96);
            buffer.putInt(n);
            synchronized (this) {
                if (this.close) return;
            }
        }
        catch (Exception exception) {
            // empty catch block
            return;
        }
        {
            this.getSession().write(packet);
            return;
        }
    }

    void eof_remote() {
        this.eof_remote = true;
        try {
            this.io.out_close();
        }
        catch (NullPointerException nullPointerException) {
            // empty catch block
        }
    }

    protected Packet genChannelOpenPacket() {
        Buffer buffer = new Buffer(100);
        Packet packet = new Packet(buffer);
        packet.reset();
        buffer.putByte((byte)90);
        buffer.putString(this.type);
        buffer.putInt(this.id);
        buffer.putInt(this.lwsize);
        buffer.putInt(this.lmpsize);
        return packet;
    }

    void getData(Buffer buffer) {
        this.setRecipient(buffer.getInt());
        this.setRemoteWindowSize(buffer.getUInt());
        this.setRemotePacketSize(buffer.getInt());
    }

    public int getExitStatus() {
        return this.exitstatus;
    }

    public InputStream getExtInputStream() throws IOException {
        int n;
        int n2 = 32768;
        try {
            n = Integer.parseInt(this.getSession().getConfig("max_input_buffer_size"));
        }
        catch (Exception exception) {
            n = n2;
        }
        MyPipedInputStream myPipedInputStream = new MyPipedInputStream(this, 32768, n);
        boolean bl = 32768 < n;
        this.io.setExtOutputStream(new PassiveOutputStream(this, myPipedInputStream, bl), false);
        return myPipedInputStream;
    }

    public int getId() {
        return this.id;
    }

    public InputStream getInputStream() throws IOException {
        int n = 32768;
        try {
            int n2;
            n = n2 = Integer.parseInt(this.getSession().getConfig("max_input_buffer_size"));
        }
        catch (Exception exception) {
            // empty catch block
        }
        MyPipedInputStream myPipedInputStream = new MyPipedInputStream(this, 32768, n);
        boolean bl = 32768 < n;
        this.io.setOutputStream(new PassiveOutputStream(this, myPipedInputStream, bl), false);
        return myPipedInputStream;
    }

    public OutputStream getOutputStream() throws IOException {
        return new OutputStream(this, this){
            byte[] b;
            private Buffer buffer;
            private boolean closed;
            private int dataLen;
            private Packet packet;
            final Channel this$0;
            final Channel val$channel;
            {
                this.this$0 = channel;
                this.val$channel = channel2;
                this.dataLen = 0;
                this.buffer = null;
                this.packet = null;
                this.closed = false;
                this.b = new byte[1];
            }

            private void init() throws IOException {
                synchronized (this) {
                    Object object;
                    block4: {
                        object = new Buffer(this.this$0.rmpsize);
                        this.buffer = object;
                        this.packet = object = new Packet(this.buffer);
                        int n = this.buffer.buffer.length;
                        if (n - 14 - 128 <= 0) break block4;
                        return;
                    }
                    this.buffer = null;
                    this.packet = null;
                    object = new IOException("failed to initialize the channel.");
                    throw object;
                }
            }

            @Override
            public void close() throws IOException {
                if (this.packet == null) {
                    try {
                        this.init();
                    }
                    catch (IOException iOException) {
                        return;
                    }
                }
                if (this.closed) {
                    return;
                }
                if (this.dataLen > 0) {
                    this.flush();
                }
                this.val$channel.eof();
                this.closed = true;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void flush() throws IOException {
                int n;
                if (this.closed) {
                    throw new IOException("Already closed");
                }
                if (this.dataLen == 0) {
                    return;
                }
                this.packet.reset();
                this.buffer.putByte((byte)94);
                this.buffer.putInt(this.this$0.recipient);
                this.buffer.putInt(this.dataLen);
                this.buffer.skip(this.dataLen);
                try {
                    n = this.dataLen;
                    this.dataLen = 0;
                    Channel channel = this.val$channel;
                    synchronized (channel) {
                        if (this.val$channel.close) break block7;
                    }
                }
                catch (Exception exception) {
                    this.close();
                    throw new IOException(exception.toString());
                }
                {
                    block7: {
                        this.this$0.getSession().write(this.packet, this.val$channel, n);
                    }
                    return;
                }
            }

            @Override
            public void write(int n) throws IOException {
                this.b[0] = (byte)n;
                this.write(this.b, 0, 1);
            }

            @Override
            public void write(byte[] byArray, int n, int n2) throws IOException {
                if (this.packet == null) {
                    this.init();
                }
                if (!this.closed) {
                    byte[] byArray2 = this.buffer.buffer;
                    int n3 = byArray2.length;
                    while (n2 > 0) {
                        int n4 = n2;
                        if (n2 > n3 - (this.dataLen + 14) - 128) {
                            n4 = n3 - (this.dataLen + 14) - 128;
                        }
                        if (n4 <= 0) {
                            this.flush();
                            continue;
                        }
                        System.arraycopy(byArray, n, byArray2, this.dataLen + 14, n4);
                        this.dataLen += n4;
                        n += n4;
                        n2 -= n4;
                    }
                    return;
                }
                throw new IOException("Already closed");
            }
        };
    }

    int getRecipient() {
        return this.recipient;
    }

    public Session getSession() throws JSchException {
        Session session = this.session;
        if (session != null) {
            return session;
        }
        throw new JSchException("session is not available");
    }

    void init() throws JSchException {
    }

    public boolean isClosed() {
        return this.close;
    }

    public boolean isConnected() {
        Session session = this.session;
        boolean bl = false;
        if (session != null) {
            boolean bl2 = bl;
            if (session.isConnected()) {
                bl2 = bl;
                if (this.connected) {
                    bl2 = true;
                }
            }
            return bl2;
        }
        return false;
    }

    public boolean isEOF() {
        return this.eof_remote;
    }

    @Override
    public void run() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    protected void sendChannelOpen() throws Exception {
        Session session = this.getSession();
        if (!session.isConnected()) throw new JSchException("session is down");
        session.write(this.genChannelOpenPacket());
        int n = 2000;
        long l = System.currentTimeMillis();
        long l2 = this.connectTimeout;
        if (l2 != 0L) {
            n = 1;
        }
        // MONITORENTER : this
        while (this.getRecipient() == -1 && session.isConnected() && n > 0) {
            long l3;
            if (l2 > 0L && (l3 = System.currentTimeMillis()) - l > l2) {
                n = 0;
                continue;
            }
            l3 = l2 == 0L ? 10L : l2;
            try {
                this.notifyme = 1;
                this.wait(l3);
            }
            catch (InterruptedException interruptedException) {
            }
            finally {
                this.notifyme = 0;
            }
            --n;
        }
        // MONITOREXIT : this
        if (!session.isConnected()) throw new JSchException("session is down");
        if (this.getRecipient() == -1) throw new JSchException("channel is not opened.");
        if (!this.open_confirmation) throw new JSchException("channel is not opened.");
        this.connected = true;
    }

    protected void sendOpenConfirmation() throws Exception {
        Buffer buffer = new Buffer(100);
        Packet packet = new Packet(buffer);
        packet.reset();
        buffer.putByte((byte)91);
        buffer.putInt(this.getRecipient());
        buffer.putInt(this.id);
        buffer.putInt(this.lwsize);
        buffer.putInt(this.lmpsize);
        this.getSession().write(packet);
    }

    protected void sendOpenFailure(int n) {
        try {
            Buffer buffer = new Buffer(100);
            Packet packet = new Packet(buffer);
            packet.reset();
            buffer.putByte((byte)92);
            buffer.putInt(this.getRecipient());
            buffer.putInt(n);
            buffer.putString(Util.str2byte("open failed"));
            buffer.putString(Util.empty);
            this.getSession().write(packet);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void sendSignal(String string2) throws Exception {
        RequestSignal requestSignal = new RequestSignal();
        requestSignal.setSignal(string2);
        requestSignal.request(this.getSession(), this);
    }

    void setExitStatus(int n) {
        this.exitstatus = n;
    }

    public void setExtOutputStream(OutputStream outputStream) {
        this.io.setExtOutputStream(outputStream, false);
    }

    public void setExtOutputStream(OutputStream outputStream, boolean bl) {
        this.io.setExtOutputStream(outputStream, bl);
    }

    public void setInputStream(InputStream inputStream) {
        this.io.setInputStream(inputStream, false);
    }

    public void setInputStream(InputStream inputStream, boolean bl) {
        this.io.setInputStream(inputStream, bl);
    }

    void setLocalPacketSize(int n) {
        this.lmpsize = n;
    }

    void setLocalWindowSize(int n) {
        this.lwsize = n;
    }

    void setLocalWindowSizeMax(int n) {
        this.lwsize_max = n;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.io.setOutputStream(outputStream, false);
    }

    public void setOutputStream(OutputStream outputStream, boolean bl) {
        this.io.setOutputStream(outputStream, bl);
    }

    void setRecipient(int n) {
        synchronized (this) {
            this.recipient = n;
            if (this.notifyme > 0) {
                this.notifyAll();
            }
            return;
        }
    }

    void setRemotePacketSize(int n) {
        this.rmpsize = n;
    }

    void setRemoteWindowSize(long l) {
        synchronized (this) {
            this.rwsize = l;
            return;
        }
    }

    void setSession(Session session) {
        this.session = session;
    }

    public void setXForwarding(boolean bl) {
    }

    public void start() throws JSchException {
    }

    void write(byte[] byArray) throws IOException {
        this.write(byArray, 0, byArray.length);
    }

    void write(byte[] byArray, int n, int n2) throws IOException {
        try {
            this.io.put(byArray, n, n2);
        }
        catch (NullPointerException nullPointerException) {
            // empty catch block
        }
    }

    void write_ext(byte[] byArray, int n, int n2) throws IOException {
        try {
            this.io.put_ext(byArray, n, n2);
        }
        catch (NullPointerException nullPointerException) {
            // empty catch block
        }
    }

    class MyPipedInputStream
    extends PipedInputStream {
        private int BUFFER_SIZE;
        private int max_buffer_size;
        final Channel this$0;

        MyPipedInputStream(Channel channel) throws IOException {
            this.this$0 = channel;
            this.max_buffer_size = this.BUFFER_SIZE = 1024;
        }

        MyPipedInputStream(Channel channel, int n) throws IOException {
            this.this$0 = channel;
            this.max_buffer_size = this.BUFFER_SIZE = 1024;
            this.buffer = new byte[n];
            this.BUFFER_SIZE = n;
            this.max_buffer_size = n;
        }

        MyPipedInputStream(Channel channel, int n, int n2) throws IOException {
            this(channel, n);
            this.max_buffer_size = n2;
        }

        MyPipedInputStream(Channel channel, PipedOutputStream pipedOutputStream) throws IOException {
            this.this$0 = channel;
            super(pipedOutputStream);
            this.max_buffer_size = this.BUFFER_SIZE = 1024;
        }

        MyPipedInputStream(Channel channel, PipedOutputStream pipedOutputStream, int n) throws IOException {
            this.this$0 = channel;
            super(pipedOutputStream);
            this.max_buffer_size = this.BUFFER_SIZE = 1024;
            this.buffer = new byte[n];
            this.BUFFER_SIZE = n;
        }

        private int freeSpace() {
            int n = 0;
            if (this.out < this.in) {
                n = this.buffer.length - this.in;
            } else if (this.in < this.out) {
                n = this.in == -1 ? this.buffer.length : this.out - this.in;
            }
            return n;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        void checkSpace(int n) throws IOException {
            synchronized (this) {
                int n2 = this.freeSpace();
                if (n2 < n) {
                    int n3 = this.buffer.length - n2;
                    n2 = this.buffer.length;
                    while (n2 - n3 < n) {
                        n2 *= 2;
                    }
                    int n4 = n2;
                    if (n2 > this.max_buffer_size) {
                        n4 = this.max_buffer_size;
                    }
                    if (n4 - n3 < n) {
                        return;
                    }
                    byte[] byArray = new byte[n4];
                    if (this.out < this.in) {
                        System.arraycopy(this.buffer, 0, byArray, 0, this.buffer.length);
                    } else if (this.in < this.out) {
                        if (this.in != -1) {
                            System.arraycopy(this.buffer, 0, byArray, 0, this.in);
                            System.arraycopy(this.buffer, this.out, byArray, byArray.length - (this.buffer.length - this.out), this.buffer.length - this.out);
                            this.out = byArray.length - (this.buffer.length - this.out);
                        }
                    } else if (this.in == this.out) {
                        System.arraycopy(this.buffer, 0, byArray, 0, this.buffer.length);
                        this.in = this.buffer.length;
                    }
                    this.buffer = byArray;
                } else if (this.buffer.length == n2 && n2 > this.BUFFER_SIZE) {
                    n = n2 /= 2;
                    if (n2 < this.BUFFER_SIZE) {
                        n = this.BUFFER_SIZE;
                    }
                    this.buffer = new byte[n];
                }
                return;
            }
        }

        public void updateReadSide() throws IOException {
            synchronized (this) {
                int n;
                block5: {
                    n = this.available();
                    if (n == 0) break block5;
                    return;
                }
                this.in = 0;
                this.out = 0;
                byte[] byArray = this.buffer;
                n = this.in;
                this.in = n + 1;
                byArray[n] = 0;
                this.read();
                return;
            }
        }
    }

    class PassiveInputStream
    extends MyPipedInputStream {
        PipedOutputStream out;
        final Channel this$0;

        PassiveInputStream(Channel channel, PipedOutputStream pipedOutputStream) throws IOException {
            this.this$0 = channel;
            super(channel, pipedOutputStream);
            this.out = pipedOutputStream;
        }

        PassiveInputStream(Channel channel, PipedOutputStream pipedOutputStream, int n) throws IOException {
            this.this$0 = channel;
            super(channel, pipedOutputStream, n);
            this.out = pipedOutputStream;
        }

        @Override
        public void close() throws IOException {
            if (this.out != null) {
                this.out.close();
            }
            this.out = null;
        }
    }

    class PassiveOutputStream
    extends PipedOutputStream {
        private MyPipedInputStream _sink;
        final Channel this$0;

        PassiveOutputStream(Channel channel, PipedInputStream pipedInputStream, boolean bl) throws IOException {
            this.this$0 = channel;
            super(pipedInputStream);
            this._sink = null;
            if (bl && pipedInputStream instanceof MyPipedInputStream) {
                this._sink = (MyPipedInputStream)pipedInputStream;
            }
        }

        @Override
        public void write(int n) throws IOException {
            if (this._sink != null) {
                this._sink.checkSpace(1);
            }
            super.write(n);
        }

        @Override
        public void write(byte[] byArray, int n, int n2) throws IOException {
            if (this._sink != null) {
                this._sink.checkSpace(n2);
            }
            super.write(byArray, n, n2);
        }
    }
}

