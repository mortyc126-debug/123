/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.jcraft.jzlib.ZStream
 */
package com.jcraft.jsch.jcraft;

import com.jcraft.jzlib.ZStream;

public class Compression
implements com.jcraft.jsch.Compression {
    private static final int BUF_SIZE = 4096;
    private final int buffer_margin;
    private byte[] inflated_buf;
    private ZStream stream;
    private byte[] tmpbuf = new byte[4096];
    private int type;

    public Compression() {
        this.buffer_margin = 52;
        this.stream = new ZStream();
    }

    @Override
    public byte[] compress(byte[] byArray, int n, int[] nArray) {
        byte[] byArray2;
        int n2;
        this.stream.next_in = byArray;
        this.stream.next_in_index = n;
        this.stream.avail_in = nArray[0] - n;
        do {
            this.stream.next_out = this.tmpbuf;
            this.stream.next_out_index = 0;
            this.stream.avail_out = 4096;
            n2 = this.stream.deflate(1);
            switch (n2) {
                default: {
                    System.err.println("compress: deflate returnd " + n2);
                    n2 = n;
                    byArray2 = byArray;
                    break;
                }
                case 0: {
                    n2 = 4096 - this.stream.avail_out;
                    byArray2 = byArray;
                    if (byArray.length < n + n2 + 52) {
                        byArray2 = new byte[(n + n2 + 52) * 2];
                        System.arraycopy(byArray, 0, byArray2, 0, byArray.length);
                    }
                    System.arraycopy(this.tmpbuf, 0, byArray2, n, n2);
                    n2 = n + n2;
                }
            }
            n = n2;
            byArray = byArray2;
        } while (this.stream.avail_out == 0);
        nArray[0] = n2;
        return byArray2;
    }

    @Override
    public void init(int n, int n2) {
        if (n == 1) {
            this.stream.deflateInit(n2);
            this.type = 1;
        } else if (n == 0) {
            this.stream.inflateInit();
            this.inflated_buf = new byte[4096];
            this.type = 0;
        }
    }

    @Override
    public byte[] uncompress(byte[] byArray, int n, int[] nArray) {
        byte[] byArray2;
        int n2 = 0;
        this.stream.next_in = byArray;
        this.stream.next_in_index = n;
        this.stream.avail_in = nArray[0];
        block4: while (true) {
            this.stream.next_out = this.tmpbuf;
            this.stream.next_out_index = 0;
            this.stream.avail_out = 4096;
            int n3 = this.stream.inflate(1);
            switch (n3) {
                default: {
                    System.err.println("uncompress: inflate returnd " + n3);
                    return null;
                }
                case 0: {
                    if (this.inflated_buf.length < n2 + 4096 - this.stream.avail_out) {
                        int n4;
                        n3 = n4 = this.inflated_buf.length * 2;
                        if (n4 < n2 + 4096 - this.stream.avail_out) {
                            n3 = n2 + 4096 - this.stream.avail_out;
                        }
                        byArray2 = new byte[n3];
                        System.arraycopy(this.inflated_buf, 0, byArray2, 0, n2);
                        this.inflated_buf = byArray2;
                    }
                    System.arraycopy(this.tmpbuf, 0, this.inflated_buf, n2, 4096 - this.stream.avail_out);
                    nArray[0] = n2 += 4096 - this.stream.avail_out;
                    continue block4;
                }
                case -5: 
            }
            break;
        }
        if (n2 > byArray.length - n) {
            byArray2 = new byte[n2 + n];
            System.arraycopy(byArray, 0, byArray2, 0, n);
            System.arraycopy(this.inflated_buf, 0, byArray2, n, n2);
            byArray = byArray2;
        } else {
            System.arraycopy(this.inflated_buf, 0, byArray, n, n2);
        }
        nArray[0] = n2;
        return byArray;
    }
}

