package org.apache.commons.net.telnet;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;

/* JADX INFO: loaded from: classes2.dex */
final class TelnetInputStream extends BufferedInputStream implements Runnable {
    private static final int EOF = -1;
    static final int STATE_CR = 8;
    static final int STATE_DATA = 0;
    static final int STATE_DO = 4;
    static final int STATE_DONT = 5;
    static final int STATE_IAC = 1;
    static final int STATE_IAC_SB = 9;
    static final int STATE_SB = 6;
    static final int STATE_SE = 7;
    static final int STATE_WILL = 2;
    static final int STATE_WONT = 3;
    private static final int WOULD_BLOCK = -2;
    private int bytesAvailable;
    private final TelnetClient client;
    private boolean hasReachedEOF;
    private IOException ioException;
    private volatile boolean isClosed;
    private final int[] queue;
    private int queueHead;
    private int queueTail;
    private boolean readIsWaiting;
    private int receiveState;
    private final int[] suboption;
    private int suboptionCount;
    private final Thread thread;
    private volatile boolean threaded;

    TelnetInputStream(InputStream input, TelnetClient client) {
        this(input, client, true);
    }

    TelnetInputStream(InputStream input, TelnetClient client, boolean readerThread) {
        super(input);
        this.client = client;
        this.receiveState = 0;
        this.isClosed = true;
        this.hasReachedEOF = false;
        this.queue = new int[2049];
        this.queueHead = 0;
        this.queueTail = 0;
        this.suboption = new int[client.maxSubnegotiationLength];
        this.bytesAvailable = 0;
        this.ioException = null;
        this.readIsWaiting = false;
        this.threaded = false;
        if (readerThread) {
            this.thread = new Thread(this);
        } else {
            this.thread = null;
        }
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        synchronized (this.queue) {
            if (this.threaded) {
                return this.bytesAvailable;
            }
            return this.bytesAvailable + super.available();
        }
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        synchronized (this.queue) {
            this.hasReachedEOF = true;
            this.isClosed = true;
            if (this.thread != null && this.thread.isAlive()) {
                this.thread.interrupt();
            }
            this.queue.notifyAll();
        }
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    private boolean processChar(int ch) throws InterruptedException {
        boolean bufferWasEmpty;
        synchronized (this.queue) {
            bufferWasEmpty = this.bytesAvailable == 0;
            while (this.bytesAvailable >= this.queue.length - 1) {
                if (!this.threaded) {
                    throw new IllegalStateException("Queue is full! Cannot process another character.");
                }
                this.queue.notify();
                try {
                    this.queue.wait();
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            if (this.readIsWaiting && this.threaded) {
                this.queue.notify();
            }
            this.queue[this.queueTail] = ch;
            this.bytesAvailable++;
            int i = this.queueTail + 1;
            this.queueTail = i;
            if (i >= this.queue.length) {
                this.queueTail = 0;
            }
        }
        return bufferWasEmpty;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        synchronized (this.queue) {
            while (this.ioException == null) {
                if (this.bytesAvailable == 0) {
                    if (this.hasReachedEOF) {
                        return -1;
                    }
                    if (this.threaded) {
                        this.queue.notify();
                        try {
                            this.readIsWaiting = true;
                            this.queue.wait();
                            this.readIsWaiting = false;
                        } catch (InterruptedException e) {
                            throw new InterruptedIOException("Fatal thread interruption during read.");
                        }
                    } else {
                        this.readIsWaiting = true;
                        boolean mayBlock = true;
                        do {
                            try {
                                int ch = read(mayBlock);
                                if (ch < 0 && ch != -2) {
                                    return ch;
                                }
                                if (ch != -2) {
                                    try {
                                        processChar(ch);
                                    } catch (InterruptedException e2) {
                                        if (this.isClosed) {
                                            return -1;
                                        }
                                    }
                                }
                                mayBlock = false;
                                if (super.available() <= 0) {
                                    break;
                                }
                            } catch (InterruptedIOException e3) {
                                synchronized (this.queue) {
                                    this.ioException = e3;
                                    this.queue.notifyAll();
                                    try {
                                        this.queue.wait(100L);
                                    } catch (InterruptedException e4) {
                                    }
                                    return -1;
                                }
                            }
                        } while (this.bytesAvailable < this.queue.length - 1);
                        this.readIsWaiting = false;
                    }
                } else {
                    int ch2 = this.queue[this.queueHead];
                    int i = this.queueHead + 1;
                    this.queueHead = i;
                    if (i >= this.queue.length) {
                        this.queueHead = 0;
                    }
                    this.bytesAvailable--;
                    if (this.bytesAvailable == 0 && this.threaded) {
                        this.queue.notify();
                    }
                    return ch2;
                }
            }
            IOException e5 = this.ioException;
            this.ioException = null;
            throw e5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x0108 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int read(boolean r7) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 370
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.net.telnet.TelnetInputStream.read(boolean):int");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] buffer) throws IOException {
        return read(buffer, 0, buffer.length);
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] buffer, int offset, int length) throws IOException {
        int offset2;
        if (length < 1) {
            return 0;
        }
        synchronized (this.queue) {
            if (length > this.bytesAvailable) {
                length = this.bytesAvailable;
            }
        }
        int i = read();
        int ch = i;
        if (i == -1) {
            return -1;
        }
        while (true) {
            offset2 = offset + 1;
            buffer[offset] = (byte) ch;
            length--;
            if (length <= 0) {
                break;
            }
            int i2 = read();
            ch = i2;
            if (i2 == -1) {
                break;
            }
            offset = offset2;
        }
        return offset2 - offset;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() throws java.lang.InterruptedException {
        /*
            r6 = this;
        L1:
            r0 = 1
            boolean r1 = r6.isClosed     // Catch: java.io.IOException -> L49
            if (r1 != 0) goto L48
            int r1 = r6.read(r0)     // Catch: java.lang.RuntimeException -> L24 java.io.InterruptedIOException -> L29 java.io.IOException -> L49
            r2 = r1
            if (r1 >= 0) goto Le
            goto L48
        Le:
            r1 = 0
            boolean r3 = r6.processChar(r2)     // Catch: java.lang.InterruptedException -> L16 java.io.IOException -> L49
            r1 = r3
            goto L1c
        L16:
            r3 = move-exception
            boolean r4 = r6.isClosed     // Catch: java.io.IOException -> L49
            if (r4 == 0) goto L1c
            goto L48
        L1c:
            if (r1 == 0) goto L23
            org.apache.commons.net.telnet.TelnetClient r3 = r6.client     // Catch: java.io.IOException -> L49
            r3.notifyInputListener()     // Catch: java.io.IOException -> L49
        L23:
            goto L1
        L24:
            r1 = move-exception
            super.close()     // Catch: java.io.IOException -> L49
            goto L48
        L29:
            r1 = move-exception
            int[] r2 = r6.queue     // Catch: java.io.IOException -> L49
            monitor-enter(r2)     // Catch: java.io.IOException -> L49
            r6.ioException = r1     // Catch: java.lang.Throwable -> L45
            int[] r3 = r6.queue     // Catch: java.lang.Throwable -> L45
            r3.notifyAll()     // Catch: java.lang.Throwable -> L45
            int[] r3 = r6.queue     // Catch: java.lang.InterruptedException -> L3c java.lang.Throwable -> L45
            r4 = 100
            r3.wait(r4)     // Catch: java.lang.InterruptedException -> L3c java.lang.Throwable -> L45
            goto L43
        L3c:
            r3 = move-exception
            boolean r4 = r6.isClosed     // Catch: java.lang.Throwable -> L45
            if (r4 == 0) goto L43
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L45
            goto L48
        L43:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L45
            goto L1
        L45:
            r3 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L45
            throw r3     // Catch: java.io.IOException -> L49
        L48:
            goto L55
        L49:
            r1 = move-exception
            int[] r2 = r6.queue
            monitor-enter(r2)
            r6.ioException = r1     // Catch: java.lang.Throwable -> L69
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L69
            org.apache.commons.net.telnet.TelnetClient r2 = r6.client
            r2.notifyInputListener()
        L55:
            int[] r3 = r6.queue
            monitor-enter(r3)
            r6.isClosed = r0     // Catch: java.lang.Throwable -> L66
            r6.hasReachedEOF = r0     // Catch: java.lang.Throwable -> L66
            int[] r0 = r6.queue     // Catch: java.lang.Throwable -> L66
            r0.notify()     // Catch: java.lang.Throwable -> L66
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L66
            r0 = 0
            r6.threaded = r0
            return
        L66:
            r0 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L66
            throw r0
        L69:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L69
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.net.telnet.TelnetInputStream.run():void");
    }

    void start() {
        if (this.thread == null) {
            return;
        }
        this.isClosed = false;
        int priority = Thread.currentThread().getPriority() + 1;
        if (priority > 10) {
            priority = 10;
        }
        this.thread.setPriority(priority);
        this.thread.setDaemon(true);
        this.thread.start();
        this.threaded = true;
    }
}
