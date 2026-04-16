/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.Buffer;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSession;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Packet;
import com.jcraft.jsch.Request;
import com.jcraft.jsch.RequestSftp;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;
import com.jcraft.jsch.SftpProgressMonitor;
import com.jcraft.jsch.SftpStatVFS;
import com.jcraft.jsch.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedOutputStream;
import java.util.Hashtable;
import java.util.Vector;

public class ChannelSftp
extends ChannelSession {
    public static final int APPEND = 2;
    private static final int LOCAL_MAXIMUM_PACKET_SIZE = 32768;
    private static final int LOCAL_WINDOW_SIZE_MAX = 0x200000;
    private static final int MAX_MSG_LENGTH = 262144;
    public static final int OVERWRITE = 0;
    public static final int RESUME = 1;
    private static final int SSH_FILEXFER_ATTR_ACMODTIME = 8;
    private static final int SSH_FILEXFER_ATTR_EXTENDED = Integer.MIN_VALUE;
    private static final int SSH_FILEXFER_ATTR_PERMISSIONS = 4;
    private static final int SSH_FILEXFER_ATTR_SIZE = 1;
    private static final int SSH_FILEXFER_ATTR_UIDGID = 2;
    private static final int SSH_FXF_APPEND = 4;
    private static final int SSH_FXF_CREAT = 8;
    private static final int SSH_FXF_EXCL = 32;
    private static final int SSH_FXF_READ = 1;
    private static final int SSH_FXF_TRUNC = 16;
    private static final int SSH_FXF_WRITE = 2;
    private static final byte SSH_FXP_ATTRS = 105;
    private static final byte SSH_FXP_CLOSE = 4;
    private static final byte SSH_FXP_DATA = 103;
    private static final byte SSH_FXP_EXTENDED = -56;
    private static final byte SSH_FXP_EXTENDED_REPLY = -55;
    private static final byte SSH_FXP_FSETSTAT = 10;
    private static final byte SSH_FXP_FSTAT = 8;
    private static final byte SSH_FXP_HANDLE = 102;
    private static final byte SSH_FXP_INIT = 1;
    private static final byte SSH_FXP_LSTAT = 7;
    private static final byte SSH_FXP_MKDIR = 14;
    private static final byte SSH_FXP_NAME = 104;
    private static final byte SSH_FXP_OPEN = 3;
    private static final byte SSH_FXP_OPENDIR = 11;
    private static final byte SSH_FXP_READ = 5;
    private static final byte SSH_FXP_READDIR = 12;
    private static final byte SSH_FXP_READLINK = 19;
    private static final byte SSH_FXP_REALPATH = 16;
    private static final byte SSH_FXP_REMOVE = 13;
    private static final byte SSH_FXP_RENAME = 18;
    private static final byte SSH_FXP_RMDIR = 15;
    private static final byte SSH_FXP_SETSTAT = 9;
    private static final byte SSH_FXP_STAT = 17;
    private static final byte SSH_FXP_STATUS = 101;
    private static final byte SSH_FXP_SYMLINK = 20;
    private static final byte SSH_FXP_VERSION = 2;
    private static final byte SSH_FXP_WRITE = 6;
    public static final int SSH_FX_BAD_MESSAGE = 5;
    public static final int SSH_FX_CONNECTION_LOST = 7;
    public static final int SSH_FX_EOF = 1;
    public static final int SSH_FX_FAILURE = 4;
    public static final int SSH_FX_NO_CONNECTION = 6;
    public static final int SSH_FX_NO_SUCH_FILE = 2;
    public static final int SSH_FX_OK = 0;
    public static final int SSH_FX_OP_UNSUPPORTED = 8;
    public static final int SSH_FX_PERMISSION_DENIED = 3;
    private static final String UTF8 = "UTF-8";
    private static final String file_separator = File.separator;
    private static final char file_separatorc = File.separatorChar;
    private static boolean fs_is_bs;
    private int[] ackid = new int[1];
    private Buffer buf;
    private int client_version = 3;
    private String cwd;
    private boolean extension_hardlink = false;
    private boolean extension_posix_rename = false;
    private boolean extension_statvfs = false;
    private Hashtable extensions = null;
    private String fEncoding = "UTF-8";
    private boolean fEncoding_is_utf8 = true;
    private String home;
    private boolean interactive = false;
    private InputStream io_in = null;
    private String lcwd;
    private Buffer obuf;
    private Packet opacket;
    private Packet packet;
    private RequestQueue rq;
    private int seq = 1;
    private int server_version = 3;
    private String version = String.valueOf(this.client_version);

    static {
        boolean bl = (byte)File.separatorChar == 92;
        fs_is_bs = bl;
    }

    public ChannelSftp() {
        this.rq = new RequestQueue(this, 16);
        this.setLocalWindowSizeMax(0x200000);
        this.setLocalWindowSize(0x200000);
        this.setLocalPacketSize(32768);
    }

    /*
     * Exception decompiling
     */
    private void _get(String var1_1, OutputStream var2_2, SftpProgressMonitor var3_8, int var4_9, long var5_10) throws SftpException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 17[TRYBLOCK] [17 : 266->280)] java.lang.Exception
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
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
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private SftpATTRS _lstat(String object) throws SftpException {
        try {
            this.sendLSTAT(Util.str2byte((String)object, this.fEncoding));
            object = new Header(this);
            object = this.header(this.buf, (Header)object);
            int n = ((Header)object).length;
            int n2 = ((Header)object).type;
            this.fill(this.buf, n);
            if (n2 == 105) {
                return SftpATTRS.getATTR(this.buf);
            }
            if (n2 == 101) {
                n2 = this.buf.getInt();
                this.throwStatusError(this.buf, n2);
            }
            object = new SftpException(4, "");
            throw object;
        }
        catch (Exception exception) {
            if (exception instanceof SftpException) {
                throw (SftpException)exception;
            }
            if (!(exception instanceof Throwable)) throw new SftpException(4, "");
            throw new SftpException(4, "", exception);
        }
    }

    private byte[] _realpath(String object) throws SftpException, IOException, Exception {
        this.sendREALPATH(Util.str2byte((String)object, this.fEncoding));
        object = new Header(this);
        object = this.header(this.buf, (Header)object);
        int n = ((Header)object).length;
        int n2 = ((Header)object).type;
        this.fill(this.buf, n);
        if (n2 != 101 && n2 != 104) {
            throw new SftpException(4, "");
        }
        if (n2 == 101) {
            n2 = this.buf.getInt();
            this.throwStatusError(this.buf, n2);
        }
        object = null;
        for (n2 = this.buf.getInt(); n2 > 0; --n2) {
            object = this.buf.getString();
            if (this.server_version <= 3) {
                this.buf.getString();
            }
            SftpATTRS.getATTR(this.buf);
        }
        return object;
    }

    private boolean _sendCLOSE(byte[] byArray, Header header) throws Exception {
        this.sendCLOSE(byArray);
        return this.checkStatus(null, header);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void _setStat(String object, SftpATTRS sftpATTRS) throws SftpException {
        try {
            this.sendSETSTAT(Util.str2byte((String)object, this.fEncoding), sftpATTRS);
            object = new Header(this);
            object = this.header(this.buf, (Header)object);
            int n = ((Header)object).length;
            int n2 = ((Header)object).type;
            this.fill(this.buf, n);
            if (n2 != 101) {
                object = new SftpException(4, "");
                throw object;
            }
            n2 = this.buf.getInt();
            if (n2 != 0) {
                this.throwStatusError(this.buf, n2);
            }
            return;
        }
        catch (Exception exception) {
            if (exception instanceof SftpException) {
                throw (SftpException)exception;
            }
            if (exception instanceof Throwable) {
                throw new SftpException(4, "", exception);
            }
            throw new SftpException(4, "");
        }
    }

    private SftpATTRS _stat(String string2) throws SftpException {
        return this._stat(Util.str2byte(string2, this.fEncoding));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private SftpATTRS _stat(byte[] object) throws SftpException {
        try {
            this.sendSTAT((byte[])object);
            Header header2 = new Header(this);
            header2 = this.header(this.buf, header2);
            int n = header2.length;
            int n2 = header2.type;
            this.fill(this.buf, n);
            if (n2 == 105) {
                return SftpATTRS.getATTR(this.buf);
            }
            if (n2 == 101) {
                n = this.buf.getInt();
                this.throwStatusError(this.buf, n);
            }
            SftpException sftpException = new SftpException(4, "");
            throw sftpException;
        }
        catch (Exception exception) {
            if (exception instanceof SftpException) {
                throw (SftpException)exception;
            }
            if (!(exception instanceof Throwable)) throw new SftpException(4, "");
            throw new SftpException(4, "", exception);
        }
    }

    private SftpStatVFS _statVFS(String string2) throws SftpException {
        return this._statVFS(Util.str2byte(string2, this.fEncoding));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private SftpStatVFS _statVFS(byte[] object) throws SftpException {
        if (!this.extension_statvfs) {
            throw new SftpException(8, "statvfs@openssh.com is not supported");
        }
        try {
            this.sendSTATVFS((byte[])object);
            Header header2 = new Header(this);
            header2 = this.header(this.buf, header2);
            int n = header2.length;
            int n2 = header2.type;
            this.fill(this.buf, n);
            if (n2 == 201) {
                return SftpStatVFS.getStatVFS(this.buf);
            }
            if (n2 == 101) {
                n = this.buf.getInt();
                this.throwStatusError(this.buf, n);
            }
            SftpException sftpException = new SftpException(4, "");
            throw sftpException;
        }
        catch (Exception exception) {
            if (exception instanceof SftpException) {
                throw (SftpException)exception;
            }
            if (!(exception instanceof Throwable)) throw new SftpException(4, "");
            throw new SftpException(4, "", exception);
        }
    }

    static /* synthetic */ int access$000(ChannelSftp channelSftp) {
        return channelSftp.seq;
    }

    static /* synthetic */ int access$100(ChannelSftp channelSftp, byte[] byArray, long l, byte[] byArray2, int n, int n2) throws Exception {
        return channelSftp.sendWRITE(byArray, l, byArray2, n, n2);
    }

    private boolean checkStatus(int[] nArray, Header header) throws IOException, SftpException {
        header = this.header(this.buf, header);
        int n = header.length;
        int n2 = header.type;
        if (nArray != null) {
            nArray[0] = header.rid;
        }
        this.fill(this.buf, n);
        if (n2 == 101) {
            n2 = this.buf.getInt();
            if (n2 != 0) {
                this.throwStatusError(this.buf, n2);
            }
            return true;
        }
        throw new SftpException(4, "");
    }

    private int fill(byte[] byArray, int n, int n2) throws IOException {
        int n3 = n2;
        n2 = n;
        while (n3 > 0) {
            int n4 = this.io_in.read(byArray, n2, n3);
            if (n4 > 0) {
                n2 += n4;
                n3 -= n4;
                continue;
            }
            throw new IOException("inputstream is closed");
        }
        return n2 - n;
    }

    private void fill(Buffer buffer, int n) throws IOException {
        buffer.reset();
        this.fill(buffer.buffer, 0, n);
        buffer.skip(n);
    }

    private String getCwd() throws SftpException {
        if (this.cwd == null) {
            this.cwd = this.getHome();
        }
        return this.cwd;
    }

    private Vector glob_local(String object) throws Exception {
        CharSequence charSequence;
        int n;
        Vector<String> vector = new Vector<String>();
        Object object2 = Util.str2byte((String)object, UTF8);
        int n2 = ((byte[])object2).length - 1;
        while (true) {
            n = --n2;
            if (n2 < 0) break;
            if (object2[n2] != 42 && object2[n2] != 63) continue;
            n = n2;
            if (fs_is_bs) break;
            n = n2;
            if (n2 <= 0) break;
            n = n2;
            if (object2[n2 - 1] != 92) break;
            n = --n2;
            if (n2 <= 0) break;
            n = n2;
            if (object2[n2 - 1] != 92) break;
            n2 = n2 - 1 - 1;
        }
        if (n < 0) {
            if (!fs_is_bs) {
                object = Util.unquote((String)object);
            }
            vector.addElement((String)object);
            return vector;
        }
        for (n2 = n; !(n2 < 0 || object2[n2] == file_separatorc || fs_is_bs && object2[n2] == 47); --n2) {
        }
        if (n2 < 0) {
            if (!fs_is_bs) {
                object = Util.unquote((String)object);
            }
            vector.addElement((String)object);
            return vector;
        }
        if (n2 == 0) {
            object = new byte[1];
            object[0] = (byte)file_separatorc;
        } else {
            object = new byte[n2];
            System.arraycopy(object2, 0, object, 0, n2);
        }
        byte[] byArray = new byte[((byte[])object2).length - n2 - 1];
        System.arraycopy(object2, n2 + 1, byArray, 0, byArray.length);
        try {
            object2 = new File;
            ((File)object2)(Util.byte2str((byte[])object, UTF8));
            object2 = ((File)object2).list();
            charSequence = new StringBuilder();
            charSequence = charSequence.append(Util.byte2str((byte[])object)).append(file_separator).toString();
            n2 = 0;
        }
        catch (Exception exception) {
            // empty catch block
        }
        while (true) {
            if (n2 < ((Object)object2).length) {
                if (Util.glob(byArray, Util.str2byte((String)object2[n2], UTF8))) {
                    object = new StringBuilder();
                    vector.addElement(((StringBuilder)object).append((String)charSequence).append((String)object2[n2]).toString());
                }
                ++n2;
                continue;
            }
            break;
        }
        return vector;
    }

    private Vector glob_remote(String object) throws Exception {
        Vector<String> vector = new Vector<String>();
        int n = 0;
        int n2 = ((String)object).lastIndexOf(47);
        if (n2 < 0) {
            vector.addElement(Util.unquote((String)object));
            return vector;
        }
        int n3 = n2 == 0 ? 1 : n2;
        Object object2 = ((String)object).substring(0, n3);
        Object object3 = ((String)object).substring(n2 + 1);
        String string2 = Util.unquote((String)object2);
        object2 = new byte[1][];
        if (!this.isPattern((String)object3, (byte[][])object2)) {
            object = string2;
            if (!string2.equals("/")) {
                object = string2 + "/";
            }
            vector.addElement((String)object + Util.unquote((String)object3));
            return vector;
        }
        Object object4 = object2[0];
        this.sendOPENDIR(Util.str2byte(string2, this.fEncoding));
        object = new Header(this);
        Object object5 = this.header(this.buf, (Header)object);
        n3 = ((Header)object5).length;
        int n4 = ((Header)object5).type;
        this.fill(this.buf, n3);
        if (n4 != 101 && n4 != 102) {
            throw new SftpException(4, "");
        }
        n3 = n;
        if (n4 == 101) {
            n3 = this.buf.getInt();
            this.throwStatusError(this.buf, n3);
        }
        object3 = this.buf.getString();
        object = null;
        while (true) {
            Header header;
            block16: {
                this.sendREADDIR((byte[])object3);
                header = this.header(this.buf, (Header)object5);
                n4 = header.length;
                n = header.type;
                if (n != 101 && n != 104) {
                    throw new SftpException(4, "");
                }
                if (n == 101) {
                    this.fill(this.buf, n4);
                    if (this._sendCLOSE((byte[])object3, header)) {
                        return vector;
                    }
                    return null;
                }
                this.buf.rewind();
                this.fill(this.buf.buffer, 0, 4);
                int n5 = n4 - 4;
                this.buf.reset();
                n = n3;
                n3 = n5;
                for (n4 = this.buf.getInt(); n4 > 0; --n4) {
                    if (n3 > 0) {
                        this.buf.shift();
                        n = this.buf.buffer.length > this.buf.index + n3 ? n3 : this.buf.buffer.length - this.buf.index;
                        n = this.io_in.read(this.buf.buffer, this.buf.index, n);
                        if (n <= 0) {
                            n3 = n;
                            break block16;
                        }
                        object5 = this.buf;
                        ((Buffer)object5).index += n;
                        n3 -= n;
                    }
                    byte[] byArray = this.buf.getString();
                    if (this.server_version <= 3) {
                        this.buf.getString();
                    }
                    SftpATTRS.getATTR(this.buf);
                    byte[] byArray2 = byArray;
                    object5 = null;
                    if (!this.fEncoding_is_utf8) {
                        object5 = Util.byte2str(byArray, this.fEncoding);
                        byArray2 = Util.str2byte((String)object5, UTF8);
                    }
                    if (!Util.glob((byte[])object4, byArray2)) continue;
                    if (object5 == null) {
                        object5 = Util.byte2str(byArray, this.fEncoding);
                    }
                    if (object == null && !((String)(object = string2)).endsWith("/")) {
                        object = (String)object + "/";
                    }
                    vector.addElement((String)object + (String)object5);
                }
                n3 = n;
            }
            object5 = header;
        }
    }

    private Header header(Buffer buffer, Header header) throws IOException {
        buffer.rewind();
        this.fill(buffer.buffer, 0, 9);
        header.length = buffer.getInt() - 5;
        header.type = buffer.getByte() & 0xFF;
        header.rid = buffer.getInt();
        return header;
    }

    private static boolean isLocalAbsolutePath(String string2) {
        return new File(string2).isAbsolute();
    }

    private boolean isPattern(String string2) {
        byte[][] byArray = null;
        return this.isPattern(string2, null);
    }

    private boolean isPattern(String object, byte[][] byArray) {
        object = Util.str2byte((String)object, UTF8);
        if (byArray != null) {
            byArray[0] = (byte[])object;
        }
        return this.isPattern((byte[])object);
    }

    private boolean isPattern(byte[] byArray) {
        int n = byArray.length;
        int n2 = 0;
        while (n2 < n) {
            if (byArray[n2] != 42 && byArray[n2] != 63) {
                int n3 = n2;
                if (byArray[n2] == 92) {
                    n3 = n2;
                    if (n2 + 1 < n) {
                        n3 = n2 + 1;
                    }
                }
                n2 = n3 + 1;
                continue;
            }
            return true;
        }
        return false;
    }

    private boolean isRemoteDir(String object) {
        block3: {
            try {
                this.sendSTAT(Util.str2byte((String)object, this.fEncoding));
                object = new Header(this);
                object = this.header(this.buf, (Header)object);
                int n = ((Header)object).length;
                int n2 = ((Header)object).type;
                this.fill(this.buf, n);
                if (n2 == 105) break block3;
                return false;
            }
            catch (Exception exception) {
                return false;
            }
        }
        boolean bl = SftpATTRS.getATTR(this.buf).isDir();
        return bl;
    }

    private String isUnique(String string2) throws SftpException, Exception {
        Object object = this.glob_remote(string2);
        if (((Vector)object).size() == 1) {
            string2 = (String)((Vector)object).elementAt(0);
            object = string2;
            return string2;
        }
        throw new SftpException(4, string2 + " is not unique: " + ((Vector)object).toString());
    }

    private String localAbsolutePath(String string2) {
        if (ChannelSftp.isLocalAbsolutePath(string2)) {
            return string2;
        }
        if (this.lcwd.endsWith(file_separator)) {
            return this.lcwd + string2;
        }
        return this.lcwd + file_separator + string2;
    }

    private void putHEAD(byte by, int n) throws Exception {
        this.putHEAD(this.buf, by, n);
    }

    private void putHEAD(Buffer buffer, byte by, int n) throws Exception {
        buffer.putByte((byte)94);
        buffer.putInt(this.recipient);
        buffer.putInt(n + 4);
        buffer.putInt(n);
        buffer.putByte(by);
    }

    private void read(byte[] byArray, int n, int n2) throws IOException, SftpException {
        while (n2 > 0) {
            int n3 = this.io_in.read(byArray, n, n2);
            if (n3 > 0) {
                n += n3;
                n2 -= n3;
                continue;
            }
            throw new SftpException(4, "");
        }
    }

    private String remoteAbsolutePath(String string2) throws SftpException {
        if (string2.charAt(0) == '/') {
            return string2;
        }
        String string3 = this.getCwd();
        if (string3.endsWith("/")) {
            return string3 + string2;
        }
        return string3 + "/" + string2;
    }

    private void sendCLOSE(byte[] byArray) throws Exception {
        this.sendPacketPath((byte)4, byArray);
    }

    private void sendFSTAT(byte[] byArray) throws Exception {
        this.sendPacketPath((byte)8, byArray);
    }

    private void sendHARDLINK(byte[] byArray, byte[] byArray2) throws Exception {
        this.sendPacketPath((byte)0, byArray, byArray2, "hardlink@openssh.com");
    }

    private void sendINIT() throws Exception {
        this.packet.reset();
        this.putHEAD((byte)1, 5);
        this.buf.putInt(3);
        this.getSession().write(this.packet, this, 9);
    }

    private void sendLSTAT(byte[] byArray) throws Exception {
        this.sendPacketPath((byte)7, byArray);
    }

    private void sendMKDIR(byte[] byArray, SftpATTRS sftpATTRS) throws Exception {
        this.packet.reset();
        int n = byArray.length;
        int n2 = sftpATTRS != null ? sftpATTRS.length() : 4;
        this.putHEAD((byte)14, n + 9 + n2);
        Object object = this.buf;
        n2 = this.seq;
        this.seq = n2 + 1;
        ((Buffer)object).putInt(n2);
        this.buf.putString(byArray);
        if (sftpATTRS != null) {
            sftpATTRS.dump(this.buf);
        } else {
            this.buf.putInt(0);
        }
        Session session = this.getSession();
        object = this.packet;
        n = byArray.length;
        n2 = sftpATTRS != null ? sftpATTRS.length() : 4;
        session.write((Packet)object, this, n + 9 + n2 + 4);
    }

    private void sendOPEN(byte[] byArray, int n) throws Exception {
        this.packet.reset();
        this.putHEAD((byte)3, byArray.length + 17);
        Buffer buffer = this.buf;
        int n2 = this.seq;
        this.seq = n2 + 1;
        buffer.putInt(n2);
        this.buf.putString(byArray);
        this.buf.putInt(n);
        this.buf.putInt(0);
        this.getSession().write(this.packet, this, byArray.length + 17 + 4);
    }

    private void sendOPENA(byte[] byArray) throws Exception {
        this.sendOPEN(byArray, 10);
    }

    private void sendOPENDIR(byte[] byArray) throws Exception {
        this.sendPacketPath((byte)11, byArray);
    }

    private void sendOPENR(byte[] byArray) throws Exception {
        this.sendOPEN(byArray, 1);
    }

    private void sendOPENW(byte[] byArray) throws Exception {
        this.sendOPEN(byArray, 26);
    }

    private void sendPacketPath(byte by, byte[] byArray) throws Exception {
        String string2 = null;
        this.sendPacketPath(by, byArray, (String)null);
    }

    private void sendPacketPath(byte by, byte[] byArray, String object) throws Exception {
        this.packet.reset();
        int n = byArray.length + 9;
        if (object == null) {
            this.putHEAD(by, n);
            object = this.buf;
            int n2 = this.seq;
            this.seq = n2 + 1;
            ((Buffer)object).putInt(n2);
        } else {
            this.putHEAD((byte)-56, n += ((String)object).length() + 4);
            Buffer buffer = this.buf;
            int n3 = this.seq;
            this.seq = n3 + 1;
            buffer.putInt(n3);
            this.buf.putString(Util.str2byte((String)object));
        }
        this.buf.putString(byArray);
        this.getSession().write(this.packet, this, n + 4);
    }

    private void sendPacketPath(byte by, byte[] byArray, byte[] byArray2) throws Exception {
        this.sendPacketPath(by, byArray, byArray2, null);
    }

    private void sendPacketPath(byte by, byte[] byArray, byte[] byArray2, String object) throws Exception {
        this.packet.reset();
        int n = byArray.length + 13 + byArray2.length;
        if (object == null) {
            this.putHEAD(by, n);
            object = this.buf;
            int n2 = this.seq;
            this.seq = n2 + 1;
            ((Buffer)object).putInt(n2);
        } else {
            this.putHEAD((byte)-56, n += ((String)object).length() + 4);
            Buffer buffer = this.buf;
            int n3 = this.seq;
            this.seq = n3 + 1;
            buffer.putInt(n3);
            this.buf.putString(Util.str2byte((String)object));
        }
        this.buf.putString(byArray);
        this.buf.putString(byArray2);
        this.getSession().write(this.packet, this, n + 4);
    }

    private void sendREAD(byte[] byArray, long l, int n) throws Exception {
        this.sendREAD(byArray, l, n, null);
    }

    private void sendREAD(byte[] byArray, long l, int n, RequestQueue requestQueue) throws Exception {
        this.packet.reset();
        this.putHEAD((byte)5, byArray.length + 21);
        Buffer buffer = this.buf;
        int n2 = this.seq;
        this.seq = n2 + 1;
        buffer.putInt(n2);
        this.buf.putString(byArray);
        this.buf.putLong(l);
        this.buf.putInt(n);
        this.getSession().write(this.packet, this, byArray.length + 21 + 4);
        if (requestQueue != null) {
            requestQueue.add(this.seq - 1, l, n);
        }
    }

    private void sendREADDIR(byte[] byArray) throws Exception {
        this.sendPacketPath((byte)12, byArray);
    }

    private void sendREADLINK(byte[] byArray) throws Exception {
        this.sendPacketPath((byte)19, byArray);
    }

    private void sendREALPATH(byte[] byArray) throws Exception {
        this.sendPacketPath((byte)16, byArray);
    }

    private void sendREMOVE(byte[] byArray) throws Exception {
        this.sendPacketPath((byte)13, byArray);
    }

    private void sendRENAME(byte[] byArray, byte[] byArray2) throws Exception {
        String string2 = this.extension_posix_rename ? "posix-rename@openssh.com" : null;
        this.sendPacketPath((byte)18, byArray, byArray2, string2);
    }

    private void sendRMDIR(byte[] byArray) throws Exception {
        this.sendPacketPath((byte)15, byArray);
    }

    private void sendSETSTAT(byte[] byArray, SftpATTRS sftpATTRS) throws Exception {
        this.packet.reset();
        this.putHEAD((byte)9, byArray.length + 9 + sftpATTRS.length());
        Buffer buffer = this.buf;
        int n = this.seq;
        this.seq = n + 1;
        buffer.putInt(n);
        this.buf.putString(byArray);
        sftpATTRS.dump(this.buf);
        this.getSession().write(this.packet, this, byArray.length + 9 + sftpATTRS.length() + 4);
    }

    private void sendSTAT(byte[] byArray) throws Exception {
        this.sendPacketPath((byte)17, byArray);
    }

    private void sendSTATVFS(byte[] byArray) throws Exception {
        this.sendPacketPath((byte)0, byArray, "statvfs@openssh.com");
    }

    private void sendSYMLINK(byte[] byArray, byte[] byArray2) throws Exception {
        this.sendPacketPath((byte)20, byArray, byArray2);
    }

    private int sendWRITE(byte[] byArray, long l, byte[] byArray2, int n, int n2) throws Exception {
        int n3 = n2;
        this.opacket.reset();
        if (this.obuf.buffer.length < this.obuf.index + 13 + 21 + byArray.length + n2 + 128) {
            n3 = this.obuf.buffer.length - (this.obuf.index + 13 + 21 + byArray.length + 128);
        }
        this.putHEAD(this.obuf, (byte)6, byArray.length + 21 + n3);
        Buffer buffer = this.obuf;
        n2 = this.seq;
        this.seq = n2 + 1;
        buffer.putInt(n2);
        this.obuf.putString(byArray);
        this.obuf.putLong(l);
        if (this.obuf.buffer != byArray2) {
            this.obuf.putString(byArray2, n, n3);
        } else {
            this.obuf.putInt(n3);
            this.obuf.skip(n3);
        }
        this.getSession().write(this.opacket, this, byArray.length + 21 + n3 + 4);
        return n3;
    }

    private void setCwd(String string2) {
        this.cwd = string2;
    }

    private void skip(long l) throws IOException {
        long l2;
        while (l > 0L && (l2 = this.io_in.skip(l)) > 0L) {
            l -= l2;
        }
    }

    private void throwStatusError(Buffer buffer, int n) throws SftpException {
        if (this.server_version >= 3 && buffer.getLength() >= 4) {
            throw new SftpException(n, Util.byte2str(buffer.getString(), UTF8));
        }
        throw new SftpException(n, "Failure");
    }

    /*
     * Exception decompiling
     */
    public void _put(InputStream var1_1, String var2_3, SftpProgressMonitor var3_4, int var4_5) throws SftpException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [22[UNCONDITIONALDOLOOP]], but top level block is 9[TRYBLOCK]
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
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void cd(String string2) throws SftpException {
        try {
            ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
            string2 = this.isUnique(this.remoteAbsolutePath(string2));
            Object object = this._realpath(string2);
            Object object2 = this._stat((byte[])object);
            int n = ((SftpATTRS)object2).getFlags();
            if ((n & 4) == 0) {
                object = new SftpException;
                object2 = new StringBuilder();
                ((SftpException)object)(4, ((StringBuilder)object2).append("Can't change directory: ").append(string2).toString());
                throw object;
            }
            if (((SftpATTRS)object2).isDir()) {
                this.setCwd(Util.byte2str((byte[])object, this.fEncoding));
                return;
            }
            object = new StringBuilder;
            ((StringBuilder)object)();
            object2 = new SftpException(4, ((StringBuilder)object).append("Can't change directory: ").append(string2).toString());
            throw object2;
        }
        catch (Exception exception) {
            if (exception instanceof SftpException) {
                throw (SftpException)exception;
            }
            if (exception instanceof Throwable) {
                throw new SftpException(4, "", exception);
            }
            throw new SftpException(4, "");
        }
    }

    public void chgrp(int n, String string2) throws SftpException {
        int n2;
        Vector vector;
        try {
            ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
            vector = this.glob_remote(this.remoteAbsolutePath(string2));
            n2 = vector.size();
        }
        catch (Exception exception) {
            if (!(exception instanceof SftpException)) {
                if (exception instanceof Throwable) {
                    throw new SftpException(4, "", exception);
                }
                throw new SftpException(4, "");
            }
            throw (SftpException)exception;
        }
        for (int i = 0; i < n2; ++i) {
            string2 = (String)vector.elementAt(i);
            Object object = string2;
            object = this._stat(string2);
            ((SftpATTRS)object).setFLAGS(0);
            ((SftpATTRS)object).setUIDGID(((SftpATTRS)object).uid, n);
            this._setStat(string2, (SftpATTRS)object);
            continue;
        }
        return;
    }

    public void chmod(int n, String string2) throws SftpException {
        int n2;
        Vector vector;
        try {
            ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
            vector = this.glob_remote(this.remoteAbsolutePath(string2));
            n2 = vector.size();
        }
        catch (Exception exception) {
            if (!(exception instanceof SftpException)) {
                if (exception instanceof Throwable) {
                    throw new SftpException(4, "", exception);
                }
                throw new SftpException(4, "");
            }
            throw (SftpException)exception;
        }
        for (int i = 0; i < n2; ++i) {
            string2 = (String)vector.elementAt(i);
            Object object = string2;
            object = this._stat(string2);
            ((SftpATTRS)object).setFLAGS(0);
            ((SftpATTRS)object).setPERMISSIONS(n);
            this._setStat(string2, (SftpATTRS)object);
            continue;
        }
        return;
    }

    public void chown(int n, String object) throws SftpException {
        int n2;
        try {
            ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
            object = this.glob_remote(this.remoteAbsolutePath((String)object));
            n2 = ((Vector)object).size();
        }
        catch (Exception exception) {
            if (!(exception instanceof SftpException)) {
                if (exception instanceof Throwable) {
                    throw new SftpException(4, "", exception);
                }
                throw new SftpException(4, "");
            }
            throw (SftpException)exception;
        }
        for (int i = 0; i < n2; ++i) {
            String string2 = (String)((Vector)object).elementAt(i);
            Object object2 = string2;
            object2 = this._stat(string2);
            ((SftpATTRS)object2).setFLAGS(0);
            ((SftpATTRS)object2).setUIDGID(n, ((SftpATTRS)object2).gid);
            this._setStat(string2, (SftpATTRS)object2);
            continue;
        }
        return;
    }

    @Override
    public void disconnect() {
        super.disconnect();
    }

    public void exit() {
        this.disconnect();
    }

    public InputStream get(String string2) throws SftpException {
        return this.get(string2, null, 0L);
    }

    public InputStream get(String string2, int n) throws SftpException {
        return this.get(string2, null, 0L);
    }

    public InputStream get(String string2, SftpProgressMonitor sftpProgressMonitor) throws SftpException {
        return this.get(string2, sftpProgressMonitor, 0L);
    }

    public InputStream get(String string2, SftpProgressMonitor sftpProgressMonitor, int n) throws SftpException {
        return this.get(string2, sftpProgressMonitor, 0L);
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public InputStream get(String object, SftpProgressMonitor sftpProgressMonitor, long l) throws SftpException {
        void var1_7;
        block17: {
            int n;
            block16: {
                byte[] byArray;
                block15: {
                    ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
                    object = this.remoteAbsolutePath((String)object);
                    String string2 = this.isUnique((String)object);
                    try {
                        byArray = Util.str2byte(string2, this.fEncoding);
                        object = this._stat(byArray);
                        if (sftpProgressMonitor == null) break block15;
                    }
                    catch (Exception exception) {}
                    sftpProgressMonitor.init(1, string2, "??", ((SftpATTRS)object).getSize());
                }
                this.sendOPENR(byArray);
                object = new Header(this);
                object = this.header(this.buf, (Header)object);
                int n2 = ((Header)object).length;
                n = ((Header)object).type;
                this.fill(this.buf, n2);
                if (n == 101 || n == 102) break block16;
                try {
                    object = new SftpException(4, "");
                    throw object;
                }
                catch (Exception exception) {}
                break block17;
            }
            if (n == 101) {
                n = this.buf.getInt();
                this.throwStatusError(this.buf, n);
            }
            object = this.buf.getString();
            this.rq.init();
            try {
                return new InputStream(this, l, sftpProgressMonitor, (byte[])object){
                    byte[] _data;
                    boolean closed;
                    Header header;
                    long offset;
                    int request_max;
                    long request_offset;
                    byte[] rest_byte;
                    int rest_length;
                    final ChannelSftp this$0;
                    final byte[] val$handle;
                    final SftpProgressMonitor val$monitor;
                    final long val$skip;
                    {
                        this.this$0 = channelSftp;
                        this.val$skip = l;
                        this.val$monitor = sftpProgressMonitor;
                        this.val$handle = byArray;
                        this.offset = this.val$skip;
                        this.closed = false;
                        this.rest_length = 0;
                        this._data = new byte[1];
                        this.rest_byte = new byte[1024];
                        this.header = new Header(this.this$0);
                        this.request_max = 1;
                        this.request_offset = this.offset;
                    }

                    @Override
                    public void close() throws IOException {
                        if (this.closed) {
                            return;
                        }
                        this.closed = true;
                        if (this.val$monitor != null) {
                            this.val$monitor.end();
                        }
                        this.this$0.rq.cancel(this.header, this.this$0.buf);
                        try {
                            this.this$0._sendCLOSE(this.val$handle, this.header);
                            return;
                        }
                        catch (Exception exception) {
                            throw new IOException("error");
                        }
                    }

                    @Override
                    public int read() throws IOException {
                        if (this.closed) {
                            return -1;
                        }
                        if (this.read(this._data, 0, 1) == -1) {
                            return -1;
                        }
                        return this._data[0] & 0xFF;
                    }

                    @Override
                    public int read(byte[] byArray) throws IOException {
                        if (this.closed) {
                            return -1;
                        }
                        return this.read(byArray, 0, byArray.length);
                    }

                    /*
                     * Enabled aggressive block sorting
                     * Enabled unnecessary exception pruning
                     * Enabled aggressive exception aggregation
                     */
                    @Override
                    public int read(byte[] byArray, int n, int n2) throws IOException {
                        RequestQueue.Request request;
                        int n4;
                        int n3;
                        block28: {
                            n3 = n2;
                            if (this.closed) {
                                return -1;
                            }
                            if (byArray == null) throw new NullPointerException();
                            if (n < 0) throw new IndexOutOfBoundsException();
                            if (n3 < 0) throw new IndexOutOfBoundsException();
                            if (n + n3 > byArray.length) throw new IndexOutOfBoundsException();
                            if (n3 == 0) {
                                return 0;
                            }
                            if (this.rest_length > 0) {
                                int n5;
                                int n6 = n5 = this.rest_length;
                                if (n5 > n3) {
                                    n6 = n2;
                                }
                                System.arraycopy(this.rest_byte, 0, byArray, n, n6);
                                if (n6 != this.rest_length) {
                                    System.arraycopy(this.rest_byte, n6, this.rest_byte, 0, this.rest_length - n6);
                                }
                                if (this.val$monitor != null && !this.val$monitor.count(n6)) {
                                    this.close();
                                    return -1;
                                }
                                this.rest_length -= n6;
                                return n6;
                            }
                            n2 = n3;
                            if (((ChannelSftp)this.this$0).buf.buffer.length - 13 < n3) {
                                n2 = ((ChannelSftp)this.this$0).buf.buffer.length - 13;
                            }
                            if (this.this$0.server_version == 0 && n2 > 1024) {
                                n2 = 1024;
                            }
                            this.this$0.rq.count();
                            n3 = ((ChannelSftp)this.this$0).buf.buffer.length - 13;
                            if (this.this$0.server_version == 0) {
                                n3 = 1024;
                            }
                            while (this.this$0.rq.count() < this.request_max) {
                                try {
                                    this.this$0.sendREAD(this.val$handle, this.request_offset, n3, this.this$0.rq);
                                }
                                catch (Exception exception) {
                                    throw new IOException("error");
                                }
                                this.request_offset += (long)n3;
                            }
                            this.header = this.this$0.header(this.this$0.buf, this.header);
                            this.rest_length = this.header.length;
                            n4 = this.header.type;
                            n3 = this.header.rid;
                            try {
                                request = this.this$0.rq.get(this.header.rid);
                                if (n4 != 101) {
                                    if (n4 != 103) throw new IOException("error");
                                }
                                if (n4 != 101) break block28;
                            }
                            catch (SftpException sftpException) {
                                throw new IOException("error: " + sftpException.toString());
                            }
                            catch (RequestQueue.OutOfOrderException outOfOrderException) {
                                this.request_offset = outOfOrderException.offset;
                                this.skip(this.header.length);
                                this.this$0.rq.cancel(this.header, this.this$0.buf);
                                return 0;
                            }
                            this.this$0.fill(this.this$0.buf, this.rest_length);
                            n = this.this$0.buf.getInt();
                            this.rest_length = 0;
                            if (n != 1) throw new IOException("error");
                            this.close();
                            return -1;
                        }
                        this.this$0.buf.rewind();
                        this.this$0.fill(((ChannelSftp)this.this$0).buf.buffer, 0, 4);
                        int n7 = this.this$0.buf.getInt();
                        this.rest_length -= 4;
                        int n8 = this.rest_length - n7;
                        this.offset += (long)n7;
                        if (n7 <= 0) return 0;
                        n3 = n4 = n7;
                        if (n4 > n2) {
                            n3 = n2;
                        }
                        if ((n3 = this.this$0.io_in.read(byArray, n, n3)) < 0) {
                            return -1;
                        }
                        this.rest_length = n = n7 - n3;
                        if (n > 0) {
                            if (this.rest_byte.length < n) {
                                this.rest_byte = new byte[n];
                            }
                            n2 = 0;
                            while (n > 0 && (n4 = this.this$0.io_in.read(this.rest_byte, n2, n)) > 0) {
                                n2 += n4;
                                n -= n4;
                            }
                        }
                        if (n8 > 0) {
                            this.this$0.io_in.skip(n8);
                        }
                        if ((long)n7 < request.length) {
                            long l;
                            ChannelSftp channelSftp;
                            this.this$0.rq.cancel(this.header, this.this$0.buf);
                            try {
                                channelSftp = this.this$0;
                                byArray = this.val$handle;
                                l = request.offset;
                            }
                            catch (Exception exception) {
                                // empty catch block
                                throw new IOException("error");
                            }
                            long l2 = n7;
                            try {
                                channelSftp.sendREAD(byArray, l + l2, (int)(request.length - (long)n7), this.this$0.rq);
                                this.request_offset = request.offset + request.length;
                            }
                            catch (Exception exception) {
                                throw new IOException("error");
                            }
                        }
                        if (this.request_max < this.this$0.rq.size()) {
                            ++this.request_max;
                        }
                        if (this.val$monitor == null) return n3;
                        if (this.val$monitor.count(n3)) return n3;
                        this.close();
                        return -1;
                    }
                };
            }
            catch (Exception exception) {
                break block17;
            }
            break block17;
            catch (Exception exception) {
                break block17;
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        if (var1_7 instanceof SftpException) {
            throw (SftpException)var1_7;
        }
        if (!(var1_7 instanceof Throwable)) throw new SftpException(4, "");
        throw new SftpException(4, "", (Throwable)var1_7);
    }

    public void get(String string2, OutputStream outputStream) throws SftpException {
        this.get(string2, outputStream, null, 0, 0L);
    }

    public void get(String string2, OutputStream outputStream, SftpProgressMonitor sftpProgressMonitor) throws SftpException {
        this.get(string2, outputStream, sftpProgressMonitor, 0, 0L);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void get(String string2, OutputStream outputStream, SftpProgressMonitor sftpProgressMonitor, int n, long l) throws SftpException {
        try {
            ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
            string2 = this.isUnique(this.remoteAbsolutePath(string2));
            if (sftpProgressMonitor != null) {
                sftpProgressMonitor.init(1, string2, "??", this._stat(string2).getSize());
                if (n == 1) {
                    sftpProgressMonitor.count(l);
                }
            }
            this._get(string2, outputStream, sftpProgressMonitor, n, l);
            return;
        }
        catch (Exception exception) {
            if (exception instanceof SftpException) {
                throw (SftpException)exception;
            }
            if (exception instanceof Throwable) {
                throw new SftpException(4, "", exception);
            }
            throw new SftpException(4, "");
        }
    }

    public void get(String string2, String string3) throws SftpException {
        this.get(string2, string3, null, 0);
    }

    public void get(String string2, String string3, SftpProgressMonitor sftpProgressMonitor) throws SftpException {
        this.get(string2, string3, sftpProgressMonitor, 0);
    }

    /*
     * Loose catch block
     */
    public void get(String object, String object2, SftpProgressMonitor object3, int n) throws SftpException {
        boolean bl;
        block88: {
            Object object4;
            Object object5;
            block77: {
                block95: {
                    boolean bl2;
                    int n2;
                    Object object6;
                    Object object7;
                    block80: {
                        block78: {
                            block79: {
                                bl = false;
                                object5 = null;
                                object7 = null;
                                ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
                                object6 = this.remoteAbsolutePath((String)object);
                                object4 = object = this.localAbsolutePath((String)object2);
                                object6 = this.glob_remote((String)object6);
                                object4 = object;
                                n2 = ((Vector)object6).size();
                                if (n2 == 0) break block77;
                                object4 = object;
                                object4 = object;
                                object2 = new File((String)object);
                                object4 = object;
                                bl2 = ((File)object2).isDirectory();
                                if (!bl2) break block78;
                                object2 = object;
                                object4 = object;
                                if (((String)object).endsWith(file_separator)) break block79;
                                object4 = object;
                                object4 = object;
                                object2 = new StringBuilder();
                                object4 = object;
                                object2 = ((StringBuilder)object2).append((String)object).append(file_separator).toString();
                            }
                            object4 = object2;
                            object4 = object2;
                            object = new StringBuffer((String)object2);
                            object4 = object2;
                            break block80;
                        }
                        if (n2 > 1) break block95;
                        object2 = null;
                        object4 = object;
                        object = object2;
                    }
                    bl = false;
                    object5 = object;
                    object2 = object7;
                    for (int i = 0; i < n2; ++i) {
                        String string2;
                        block81: {
                            boolean bl3;
                            block94: {
                                long l;
                                block93: {
                                    block92: {
                                        block91: {
                                            block89: {
                                                block90: {
                                                    block87: {
                                                        block82: {
                                                            block85: {
                                                                block86: {
                                                                    block84: {
                                                                        int n3;
                                                                        block83: {
                                                                            string2 = (String)((Vector)object6).elementAt(i);
                                                                            object = string2;
                                                                            object7 = this._stat(string2);
                                                                            bl3 = ((SftpATTRS)object7).isDir();
                                                                            if (bl3) break block81;
                                                                            object = null;
                                                                            if (!bl2) break block82;
                                                                            object2 = object;
                                                                            try {
                                                                                n3 = string2.lastIndexOf(47);
                                                                                if (n3 != -1) break block83;
                                                                                object2 = object;
                                                                            }
                                                                            catch (Exception exception) {
                                                                                break block88;
                                                                            }
                                                                            ((StringBuffer)object5).append(string2);
                                                                            break block84;
                                                                        }
                                                                        object2 = object;
                                                                        ((StringBuffer)object5).append(string2.substring(n3 + 1));
                                                                    }
                                                                    object2 = object;
                                                                    object2 = object = ((StringBuffer)object5).toString();
                                                                    if (((String)object).indexOf("..") == -1) break block85;
                                                                    object2 = object;
                                                                    object2 = object;
                                                                    Object object8 = new File((String)object4);
                                                                    object2 = object;
                                                                    object8 = ((File)object8).getCanonicalPath();
                                                                    object2 = object;
                                                                    object2 = object;
                                                                    Object object9 = new File((String)object);
                                                                    object2 = object;
                                                                    object9 = ((File)object9).getCanonicalPath();
                                                                    object2 = object;
                                                                    if (((String)object9).length() <= ((String)object8).length()) break block86;
                                                                    object2 = object;
                                                                    object9 = ((String)object9).substring(0, ((String)object8).length() + 1);
                                                                    object2 = object;
                                                                    object2 = object;
                                                                    StringBuilder stringBuilder = new StringBuilder();
                                                                    object2 = object;
                                                                    if (((String)object9).equals(stringBuilder.append((String)object8).append(file_separator).toString())) break block85;
                                                                }
                                                                object2 = object;
                                                                object2 = object;
                                                                object2 = object;
                                                                object3 = new StringBuilder();
                                                                object2 = object;
                                                                object4 = new SftpException(4, ((StringBuilder)object3).append("writing to an unexpected file ").append(string2).toString());
                                                                object2 = object;
                                                                throw object4;
                                                            }
                                                            object2 = object;
                                                            ((StringBuffer)object5).delete(((String)object4).length(), ((String)object).length());
                                                            break block87;
                                                        }
                                                        object = object4;
                                                    }
                                                    object2 = new File((String)object);
                                                    if (n != 1) break block89;
                                                    try {
                                                        long l2 = ((SftpATTRS)object7).getSize();
                                                        l = ((File)object2).length();
                                                        if (l > l2) break block90;
                                                        if (l == l2) {
                                                            return;
                                                        }
                                                    }
                                                    catch (Exception exception) {
                                                        object2 = object;
                                                        object = exception;
                                                        break block88;
                                                    }
                                                }
                                                object3 = new StringBuilder();
                                                object2 = new SftpException(4, ((StringBuilder)object3).append("failed to resume for ").append((String)object).toString());
                                                throw object2;
                                            }
                                            if (object3 != null) {
                                                l = ((SftpATTRS)object7).getSize();
                                                bl3 = bl;
                                                object3.init(1, string2, (String)object, l);
                                                if (n != 1) break block91;
                                                bl3 = bl;
                                                object3.count(((File)object2).length());
                                            }
                                        }
                                        object7 = null;
                                        bl3 = bl;
                                        try {
                                            bl = ((File)object2).exists();
                                            if (n != 0) break block92;
                                        }
                                        catch (Exception exception) {
                                            object3 = object;
                                            bl = bl3;
                                            object = exception;
                                            object2 = object3;
                                            break block88;
                                        }
                                        try {
                                            object2 = new FileOutputStream((String)object);
                                            break block93;
                                        }
                                        catch (Throwable throwable) {
                                            object3 = object7;
                                            break block94;
                                        }
                                    }
                                    object2 = new FileOutputStream((String)object, true);
                                }
                                object7 = new File((String)object);
                                l = ((File)object7).length();
                                this._get(string2, (OutputStream)object2, (SftpProgressMonitor)object3, n, l);
                                bl3 = bl;
                                ((FileOutputStream)object2).close();
                                object2 = object;
                                continue;
                                catch (Throwable throwable) {
                                    object4 = object2;
                                    object2 = throwable;
                                    object3 = object4;
                                }
                                break block94;
                                catch (Throwable throwable) {
                                    object3 = object2;
                                    object2 = throwable;
                                }
                                break block94;
                                catch (Throwable throwable) {
                                    object3 = object7;
                                }
                            }
                            if (object3 != null) {
                                bl3 = bl;
                                ((FileOutputStream)object3).close();
                            }
                            bl3 = bl;
                            throw object2;
                            catch (Exception exception) {
                                object2 = object;
                                object = exception;
                                break block88;
                            }
                        }
                        try {
                            object3 = new StringBuilder();
                            object = new SftpException(4, ((StringBuilder)object3).append("not supported to get directory ").append(string2).toString());
                            throw object;
                        }
                        catch (Exception exception) {
                            break block88;
                        }
                        catch (Exception exception) {
                            break block88;
                        }
                    }
                    return;
                }
                object4 = object;
                object4 = object;
                object2 = new SftpException(4, "Copying multiple files, but destination is missing or a file.");
                object4 = object;
                throw object2;
            }
            object4 = object;
            object4 = object;
            object2 = new SftpException(2, "No such file");
            object4 = object;
            try {
                throw object2;
            }
            catch (Exception exception) {
                object2 = object5;
            }
            break block88;
            catch (Exception exception) {
                object2 = object5;
                break block88;
            }
            catch (Exception exception) {
                object2 = object5;
            }
        }
        if (!bl && object2 != null && ((File)(object2 = new File((String)object2))).exists() && ((File)object2).length() == 0L) {
            ((File)object2).delete();
        }
        if (!(object instanceof SftpException)) {
            if (object instanceof Throwable) {
                throw new SftpException(4, "", (Throwable)object);
            }
            throw new SftpException(4, "");
        }
        throw (SftpException)object;
    }

    public int getBulkRequests() {
        return this.rq.size();
    }

    public String getExtension(String string2) {
        if (this.extensions == null) {
            return null;
        }
        return (String)this.extensions.get(string2);
    }

    public String getHome() throws SftpException {
        if (this.home == null) {
            try {
                ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
                this.home = Util.byte2str(this._realpath(""), this.fEncoding);
            }
            catch (Exception exception) {
                if (!(exception instanceof SftpException)) {
                    if (exception instanceof Throwable) {
                        throw new SftpException(4, "", exception);
                    }
                    throw new SftpException(4, "");
                }
                throw (SftpException)exception;
            }
        }
        return this.home;
    }

    public int getServerVersion() throws SftpException {
        if (this.isConnected()) {
            return this.server_version;
        }
        throw new SftpException(4, "The channel is not connected.");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void hardlink(String object, String string2) throws SftpException {
        if (!this.extension_hardlink) {
            throw new SftpException(8, "hardlink@openssh.com is not supported");
        }
        try {
            int n;
            ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
            String string3 = this.remoteAbsolutePath((String)object);
            String string4 = this.remoteAbsolutePath(string2);
            string2 = this.isUnique(string3);
            int n2 = 0;
            if (((String)object).charAt(0) != '/') {
                object = this.getCwd();
                n = ((String)object).length();
                if (!((String)object).endsWith("/")) {
                    n2 = 1;
                }
                object = string2.substring(n + n2);
            } else {
                object = string2;
            }
            if (this.isPattern(string4)) {
                object = new SftpException(4, string4);
                throw object;
            }
            string2 = Util.unquote(string4);
            this.sendHARDLINK(Util.str2byte((String)object, this.fEncoding), Util.str2byte(string2, this.fEncoding));
            object = new Header(this);
            object = this.header(this.buf, (Header)object);
            n = ((Header)object).length;
            n2 = ((Header)object).type;
            this.fill(this.buf, n);
            if (n2 != 101) {
                object = new SftpException(4, "");
                throw object;
            }
            n2 = this.buf.getInt();
            if (n2 == 0) {
                return;
            }
            this.throwStatusError(this.buf, n2);
            return;
        }
        catch (Exception exception) {
            if (exception instanceof SftpException) {
                throw (SftpException)exception;
            }
            if (exception instanceof Throwable) {
                throw new SftpException(4, "", exception);
            }
            throw new SftpException(4, "");
        }
    }

    @Override
    void init() {
    }

    public void lcd(String object) throws SftpException {
        if (new File((String)(object = this.localAbsolutePath((String)object))).isDirectory()) {
            try {
                Object object2 = new File((String)object);
                object = object2 = ((File)object2).getCanonicalPath();
            }
            catch (Exception exception) {
                // empty catch block
            }
            this.lcwd = object;
            return;
        }
        throw new SftpException(2, "No such directory");
    }

    public String lpwd() {
        return this.lcwd;
    }

    public Vector ls(String string2) throws SftpException {
        Vector vector = new Vector();
        this.ls(string2, new LsEntrySelector(this, vector){
            final ChannelSftp this$0;
            final Vector val$v;
            {
                this.this$0 = channelSftp;
                this.val$v = vector;
            }

            @Override
            public int select(LsEntry lsEntry) {
                this.val$v.addElement(lsEntry);
                return 0;
            }
        });
        return vector;
    }

    /*
     * Exception decompiling
     */
    public void ls(String var1_1, LsEntrySelector var2_6) throws SftpException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 13[TRYBLOCK] [13 : 188->200)] java.lang.Exception
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
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

    public SftpATTRS lstat(String object) throws SftpException {
        try {
            ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
            object = this._lstat(this.isUnique(this.remoteAbsolutePath((String)object)));
            return object;
        }
        catch (Exception exception) {
            if (!(exception instanceof SftpException)) {
                if (exception instanceof Throwable) {
                    throw new SftpException(4, "", exception);
                }
                throw new SftpException(4, "");
            }
            throw (SftpException)exception;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void mkdir(String object) throws SftpException {
        try {
            ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
            this.sendMKDIR(Util.str2byte(this.remoteAbsolutePath((String)object), this.fEncoding), null);
            object = new Header(this);
            object = this.header(this.buf, (Header)object);
            int n = ((Header)object).length;
            int n2 = ((Header)object).type;
            this.fill(this.buf, n);
            if (n2 != 101) {
                object = new SftpException(4, "");
                throw object;
            }
            n2 = this.buf.getInt();
            if (n2 == 0) {
                return;
            }
            this.throwStatusError(this.buf, n2);
            return;
        }
        catch (Exception exception) {
            if (exception instanceof SftpException) {
                throw (SftpException)exception;
            }
            if (exception instanceof Throwable) {
                throw new SftpException(4, "", exception);
            }
            throw new SftpException(4, "");
        }
    }

    public OutputStream put(String string2) throws SftpException {
        SftpProgressMonitor sftpProgressMonitor = null;
        return this.put(string2, (SftpProgressMonitor)null, 0);
    }

    public OutputStream put(String string2, int n) throws SftpException {
        SftpProgressMonitor sftpProgressMonitor = null;
        return this.put(string2, (SftpProgressMonitor)null, n);
    }

    public OutputStream put(String string2, SftpProgressMonitor sftpProgressMonitor, int n) throws SftpException {
        return this.put(string2, sftpProgressMonitor, n, 0L);
    }

    /*
     * Unable to fully structure code
     */
    public OutputStream put(String var1_1, SftpProgressMonitor var2_7, int var3_8, long var4_9) throws SftpException {
        block23: {
            block18: {
                block22: {
                    block21: {
                        block24: {
                            block20: {
                                block19: {
                                    ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
                                    var1_1 = this.remoteAbsolutePath((String)var1_1);
                                    var1_1 = this.isUnique((String)var1_1);
                                    try {
                                        if (this.isRemoteDir((String)var1_1)) break block18;
                                        var11_10 = Util.str2byte((String)var1_1, this.fEncoding);
                                        if (var3_8 != 1 && var3_8 != 2) break block19;
                                    }
                                    catch (Exception var1_3) {}
                                    try {
                                        var8_11 = this._stat(var11_10).getSize();
                                        break block20;
                                    }
                                    catch (Exception var10_12) {
                                        // empty catch block
                                    }
                                }
                                var8_11 = 0L;
                            }
                            if (var2_7 != null) {
                                var2_7.init(0, "-", (String)var1_1, -1L);
                            }
                            if (var3_8 != 0) ** GOTO lbl26
                            this.sendOPENW(var11_10);
                            break block24;
lbl26:
                            // 1 sources

                            this.sendOPENA(var11_10);
                        }
                        var1_1 = new Header(this);
                        var1_1 = this.header(this.buf, (Header)var1_1);
                        var7_14 = var1_1.length;
                        var6_15 = var1_1.type;
                        this.fill(this.buf, var7_14);
                        if (var6_15 == 101 || var6_15 == 102) break block21;
                        var1_1 = new SftpException(4, "");
                        throw var1_1;
                    }
                    if (var6_15 != 101) ** GOTO lbl42
                    var6_15 = this.buf.getInt();
                    this.throwStatusError(this.buf, var6_15);
lbl42:
                    // 2 sources

                    var1_1 = this.buf.getString();
                    if (var3_8 != 1 && var3_8 != 2) break block22;
                    var4_9 += var8_11;
                }
                try {
                    var1_1 = new OutputStream(this, (byte[])var1_1, new long[]{var4_9}, (SftpProgressMonitor)var2_7){
                        private int _ackid;
                        byte[] _data;
                        private int ackcount;
                        private int[] ackid;
                        private Header header;
                        private boolean init;
                        private boolean isClosed;
                        private int startid;
                        final ChannelSftp this$0;
                        final long[] val$_offset;
                        final byte[] val$handle;
                        final SftpProgressMonitor val$monitor;
                        private int writecount;
                        {
                            this.this$0 = channelSftp;
                            this.val$handle = byArray;
                            this.val$_offset = lArray;
                            this.val$monitor = sftpProgressMonitor;
                            this.init = true;
                            this.isClosed = false;
                            this.ackid = new int[1];
                            this.startid = 0;
                            this._ackid = 0;
                            this.ackcount = 0;
                            this.writecount = 0;
                            this.header = new Header(this.this$0);
                            this._data = new byte[1];
                        }

                        @Override
                        public void close() throws IOException {
                            if (this.isClosed) {
                                return;
                            }
                            this.flush();
                            if (this.val$monitor != null) {
                                this.val$monitor.end();
                            }
                            try {
                                this.this$0._sendCLOSE(this.val$handle, this.header);
                                this.isClosed = true;
                                return;
                            }
                            catch (Exception exception) {
                                throw new IOException(exception.toString());
                            }
                            catch (IOException iOException) {
                                throw iOException;
                            }
                        }

                        @Override
                        public void flush() throws IOException {
                            if (!this.isClosed) {
                                if (!this.init) {
                                    try {
                                        while (this.writecount > this.ackcount && this.this$0.checkStatus(null, this.header)) {
                                            ++this.ackcount;
                                        }
                                    }
                                    catch (SftpException sftpException) {
                                        throw new IOException(sftpException.toString());
                                    }
                                }
                                return;
                            }
                            throw new IOException("stream already closed");
                        }

                        @Override
                        public void write(int n) throws IOException {
                            this._data[0] = (byte)n;
                            this.write(this._data, 0, 1);
                        }

                        @Override
                        public void write(byte[] byArray) throws IOException {
                            this.write(byArray, 0, byArray.length);
                        }

                        /*
                         * Exception decompiling
                         */
                        @Override
                        public void write(byte[] var1_1, int var2_4, int var3_5) throws IOException {
                            /*
                             * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                             * 
                             * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[WHILELOOP]], but top level block is 1[TRYBLOCK]
                             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                             *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                             *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                             *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                             *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                             *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
                             *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
                             *     at org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:923)
                             *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1035)
                             *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
                             *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
                             *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
                             *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
                             *     at org.benf.cfr.reader.Main.main(Main.java:54)
                             */
                            throw new IllegalStateException("Decompilation failed");
                        }
                    };
                    return var1_1;
                }
                catch (Exception var1_2) {}
                break block23;
            }
            var2_7 = new StringBuilder();
            var10_13 = new SftpException(4, var2_7.append((String)var1_1).append(" is a directory").toString());
            throw var10_13;
            break block23;
            catch (Exception var1_4) {
                break block23;
            }
            catch (Exception var1_5) {
                // empty catch block
            }
        }
        if (!(var1_6 instanceof SftpException)) {
            if (var1_6 instanceof Throwable) {
                throw new SftpException(4, "", (Throwable)var1_6);
            }
            throw new SftpException(4, "");
        }
        throw (SftpException)var1_6;
    }

    public void put(InputStream inputStream, String string2) throws SftpException {
        this.put(inputStream, string2, null, 0);
    }

    public void put(InputStream inputStream, String string2, int n) throws SftpException {
        this.put(inputStream, string2, null, n);
    }

    public void put(InputStream inputStream, String string2, SftpProgressMonitor sftpProgressMonitor) throws SftpException {
        this.put(inputStream, string2, sftpProgressMonitor, 0);
    }

    public void put(InputStream object, String object2, SftpProgressMonitor sftpProgressMonitor, int n) throws SftpException {
        Object object3;
        block23: {
            Object object4;
            block20: {
                block21: {
                    block22: {
                        object3 = object2;
                        try {
                            ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
                            object3 = object2;
                        }
                        catch (Exception exception) {
                            if (exception instanceof SftpException) {
                                if (((SftpException)exception).id == 4 && this.isRemoteDir((String)object3)) {
                                    throw new SftpException(4, (String)object3 + " is a directory");
                                }
                                throw (SftpException)exception;
                            }
                            if (exception instanceof Throwable) {
                                throw new SftpException(4, exception.toString(), exception);
                            }
                            throw new SftpException(4, exception.toString());
                        }
                        object3 = object2 = this.remoteAbsolutePath((String)object2);
                        object4 = this.glob_remote((String)object2);
                        object3 = object2;
                        int n2 = ((Vector)object4).size();
                        if (n2 == 1) break block20;
                        object = object2;
                        if (n2 != 0) break block21;
                        object3 = object2;
                        if (!this.isPattern((String)object2)) break block22;
                        object3 = object2;
                        object3 = object2;
                        object = new SftpException(4, (String)object2);
                        object3 = object2;
                        throw object;
                    }
                    object3 = object2;
                    object = Util.unquote((String)object2);
                }
                object3 = object;
                object3 = object;
                object2 = new SftpException(4, ((Vector)object4).toString());
                object3 = object;
                throw object2;
            }
            object3 = object2;
            object4 = (String)((Vector)object4).elementAt(0);
            object3 = object2;
            object2 = (String)object4;
            object2 = object4;
            if (sftpProgressMonitor == null) break block23;
            object3 = object2;
            sftpProgressMonitor.init(0, "-", (String)object2, -1L);
        }
        object3 = object2;
        this._put((InputStream)object, (String)object2, sftpProgressMonitor, n);
    }

    public void put(String string2, String string3) throws SftpException {
        this.put(string2, string3, null, 0);
    }

    public void put(String string2, String string3, int n) throws SftpException {
        this.put(string2, string3, null, n);
    }

    public void put(String string2, String string3, SftpProgressMonitor sftpProgressMonitor) throws SftpException {
        this.put(string2, string3, sftpProgressMonitor, 0);
    }

    /*
     * Unable to fully structure code
     */
    public void put(String var1_1, String var2_9, SftpProgressMonitor var3_11, int var4_12) throws SftpException {
        block66: {
            block67: {
                block60: {
                    block58: {
                        block59: {
                            block55: {
                                block56: {
                                    block57: {
                                        ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
                                        var18_13 = this.localAbsolutePath((String)var1_1);
                                        var1_1 = var2_9 = this.remoteAbsolutePath((String)var2_9);
                                        var17_14 = this.glob_remote((String)var2_9);
                                        var1_1 = var2_9;
                                        var5_15 = var17_14.size();
                                        if (var5_15 == 1) break block55;
                                        var3_11 = var2_9;
                                        if (var5_15 != 0) break block56;
                                        var1_1 = var2_9;
                                        if (!this.isPattern((String)var2_9)) break block57;
                                        var1_1 = var2_9;
                                        var1_1 = var2_9;
                                        var3_11 = new SftpException(4, (String)var2_9);
                                        var1_1 = var2_9;
                                        throw var3_11;
                                    }
                                    var1_1 = var2_9;
                                    var3_11 = Util.unquote((String)var2_9);
                                }
                                var1_1 = var3_11;
                                var1_1 = var3_11;
                                var2_9 = new SftpException(4, var17_14.toString());
                                var1_1 = var3_11;
                                throw var2_9;
                            }
                            var1_1 = var2_9;
                            var17_14 = (String)var17_14.elementAt(0);
                            var1_1 = var2_9;
                            var1_1 = (String)var17_14;
                            var1_1 = var2_9 = var17_14;
                            var16_16 = this.isRemoteDir((String)var2_9);
                            var1_1 = var2_9;
                            var21_17 = this.glob_local((String)var18_13);
                            var1_1 = var2_9;
                            var9_18 = var21_17.size();
                            if (!var16_16) break block58;
                            var17_14 = var2_9;
                            var1_1 = var2_9;
                            if (var2_9.endsWith("/")) break block59;
                            var1_1 = var2_9;
                            var1_1 = var2_9;
                            var17_14 = new StringBuilder();
                            var1_1 = var2_9;
                            var17_14 = var17_14.append((String)var2_9).append("/").toString();
                        }
                        var1_1 = var17_14;
                        var2_9 = new StringBuffer((String)var17_14);
                        var1_1 = var17_14;
                        break block60;
                    }
                    if (var9_18 > 1) break block67;
                    var1_1 = var2_9;
                    var2_9 = null;
                }
                var17_14 = var2_9;
                for (var5_15 = 0; var5_15 < var9_18; ++var5_15) {
                    block65: {
                        block64: {
                            block62: {
                                block61: {
                                    block68: {
                                        try {
                                            var22_27 = (String)var21_17.elementAt(var5_15);
                                            var2_9 = var22_27;
                                            if (!var16_16) break block61;
                                        }
                                        catch (Exception var1_4) {
                                            break block66;
                                        }
                                        var6_19 = var7_20 = var22_27.lastIndexOf(ChannelSftp.file_separatorc);
                                        if (ChannelSftp.fs_is_bs) {
                                            var8_21 = var22_27.lastIndexOf(47);
                                            var6_19 = var7_20;
                                            if (var8_21 != -1) {
                                                var6_19 = var7_20;
                                                if (var8_21 > var7_20) {
                                                    var6_19 = var8_21;
                                                }
                                            }
                                        }
                                        if (var6_19 != -1) ** GOTO lbl98
                                        var17_14.append(var22_27);
                                        break block68;
lbl98:
                                        // 1 sources

                                        var17_14.append(var22_27.substring(var6_19 + 1));
                                    }
                                    var18_13 = var17_14.toString();
                                    var17_14.delete(var1_1.length(), var18_13.length());
                                    break block62;
                                }
                                var18_13 = var1_1;
                            }
                            var12_23 = var10_22 = 0L;
                            if (var4_12 == 1) {
                                block63: {
                                    try {
                                        var10_22 = var12_23 = this._stat((String)var18_13).getSize();
                                    }
                                    catch (Exception var2_10) {
                                        // empty catch block
                                    }
                                    var2_9 = new File(var22_27);
                                    var14_24 = var2_9.length();
                                    if (var14_24 < var10_22) break block63;
                                    var12_23 = var10_22;
                                    if (var14_24 == var10_22) {
                                        return;
                                    }
                                    break block64;
                                }
                                var1_1 = new StringBuilder();
                                var2_9 = new SftpException(4, var1_1.append("failed to resume for ").append((String)var18_13).toString());
                                throw var2_9;
                            }
                        }
                        if (var3_11 != null) {
                            var2_9 = new File(var22_27);
                            var3_11.init(0, var22_27, (String)var18_13, var2_9.length());
                            if (var4_12 != 1) break block65;
                            var3_11.count(var12_23);
                        }
                    }
                    var2_9 = null;
                    var20_26 = null;
                    var2_9 = var20_26;
                    var19_25 = new FileInputStream(var22_27);
                    var2_9 = var19_25;
                    this._put(var19_25, (String)var18_13, (SftpProgressMonitor)var3_11, var4_12);
                    var19_25.close();
                    continue;
                    catch (Throwable var1_2) {}
                    if (var2_9 == null) ** GOTO lbl153
                    var2_9.close();
lbl153:
                    // 2 sources

                    throw var1_1;
                }
                return;
            }
            var1_1 = var2_9;
            var1_1 = var2_9;
            try {
                var3_11 = new SftpException(4, "Copying multiple files, but the destination is missing or a file.");
                var1_1 = var2_9;
            }
            catch (Exception var1_5) {}
            throw var3_11;
            break block66;
            catch (Exception var1_6) {
                break block66;
            }
            catch (Exception var1_7) {
                // empty catch block
            }
        }
        if (!(var1_8 instanceof SftpException)) {
            if (var1_8 instanceof Throwable) {
                throw new SftpException(4, var1_8.toString(), (Throwable)var1_8);
            }
            throw new SftpException(4, var1_8.toString());
        }
        throw (SftpException)var1_8;
    }

    public String pwd() throws SftpException {
        return this.getCwd();
    }

    public void quit() {
        this.disconnect();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String readlink(String object) throws SftpException {
        try {
            if (this.server_version >= 3) {
                ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
                this.sendREADLINK(Util.str2byte(this.isUnique(this.remoteAbsolutePath((String)object)), this.fEncoding));
                object = new Header(this);
                object = this.header(this.buf, (Header)object);
                int n = ((Header)object).length;
                int n2 = ((Header)object).type;
                this.fill(this.buf, n);
                if (n2 != 101 && n2 != 104) {
                    object = new SftpException(4, "");
                    throw object;
                }
                if (n2 == 104) {
                    n = this.buf.getInt();
                    object = null;
                    for (n2 = 0; n2 < n; ++n2) {
                        object = this.buf.getString();
                        if (this.server_version <= 3) {
                            this.buf.getString();
                        }
                        SftpATTRS.getATTR(this.buf);
                    }
                    return Util.byte2str((byte[])object, this.fEncoding);
                }
                n2 = this.buf.getInt();
                this.throwStatusError(this.buf, n2);
                return null;
            }
            object = new SftpException(8, "The remote sshd is too old to support symlink operation.");
            throw object;
        }
        catch (Exception exception) {
            if (exception instanceof SftpException) {
                throw (SftpException)exception;
            }
            if (exception instanceof Throwable) {
                throw new SftpException(4, "", exception);
            }
            throw new SftpException(4, "");
        }
    }

    public String realpath(String string2) throws SftpException {
        try {
            string2 = Util.byte2str(this._realpath(this.remoteAbsolutePath(string2)), this.fEncoding);
            return string2;
        }
        catch (Exception exception) {
            if (!(exception instanceof SftpException)) {
                if (exception instanceof Throwable) {
                    throw new SftpException(4, "", exception);
                }
                throw new SftpException(4, "");
            }
            throw (SftpException)exception;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void rename(String object, String object2) throws SftpException {
        if (this.server_version < 2) {
            throw new SftpException(8, "The remote sshd is too old to support rename operation.");
        }
        try {
            ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
            Object object3 = this.remoteAbsolutePath((String)object);
            object = this.remoteAbsolutePath((String)object2);
            object2 = this.isUnique((String)object3);
            object3 = this.glob_remote((String)object);
            int n = ((Vector)object3).size();
            if (n >= 2) {
                object = new SftpException(4, ((Vector)object3).toString());
                throw object;
            }
            if (n == 1) {
                object = (String)((Vector)object3).elementAt(0);
                object3 = (String)object;
            } else {
                if (this.isPattern((String)object)) {
                    object2 = new SftpException(4, (String)object);
                    throw object2;
                }
                object = Util.unquote((String)object);
            }
            this.sendRENAME(Util.str2byte((String)object2, this.fEncoding), Util.str2byte((String)object, this.fEncoding));
            object = new Header(this);
            object = this.header(this.buf, (Header)object);
            n = ((Header)object).length;
            int n2 = ((Header)object).type;
            this.fill(this.buf, n);
            if (n2 != 101) {
                object = new SftpException(4, "");
                throw object;
            }
            n = this.buf.getInt();
            if (n == 0) {
                return;
            }
            this.throwStatusError(this.buf, n);
            return;
        }
        catch (Exception exception) {
            if (exception instanceof SftpException) {
                throw (SftpException)exception;
            }
            if (exception instanceof Throwable) {
                throw new SftpException(4, "", exception);
            }
            throw new SftpException(4, "");
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void rm(String object) throws SftpException {
        try {
            ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
            Vector vector = this.glob_remote(this.remoteAbsolutePath((String)object));
            int n = vector.size();
            object = new Header(this);
            for (int i = 0; i < n; ++i) {
                String string2;
                String string3 = string2 = (String)vector.elementAt(i);
                this.sendREMOVE(Util.str2byte(string2, this.fEncoding));
                object = this.header(this.buf, (Header)object);
                int n2 = ((Header)object).length;
                int n3 = ((Header)object).type;
                this.fill(this.buf, n2);
                if (n3 == 101) {
                    n2 = this.buf.getInt();
                    if (n2 == 0) continue;
                    this.throwStatusError(this.buf, n2);
                    continue;
                }
                object = new SftpException(4, "");
                throw object;
            }
            return;
        }
        catch (Exception exception) {
            if (exception instanceof SftpException) {
                throw (SftpException)exception;
            }
            if (exception instanceof Throwable) {
                throw new SftpException(4, "", exception);
            }
            throw new SftpException(4, "");
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void rmdir(String object) throws SftpException {
        try {
            ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
            Vector vector = this.glob_remote(this.remoteAbsolutePath((String)object));
            int n = vector.size();
            object = new Header(this);
            for (int i = 0; i < n; ++i) {
                String string2;
                String string3 = string2 = (String)vector.elementAt(i);
                this.sendRMDIR(Util.str2byte(string2, this.fEncoding));
                object = this.header(this.buf, (Header)object);
                int n2 = ((Header)object).length;
                int n3 = ((Header)object).type;
                this.fill(this.buf, n2);
                if (n3 == 101) {
                    n2 = this.buf.getInt();
                    if (n2 == 0) continue;
                    this.throwStatusError(this.buf, n2);
                    continue;
                }
                object = new SftpException(4, "");
                throw object;
            }
            return;
        }
        catch (Exception exception) {
            if (exception instanceof SftpException) {
                throw (SftpException)exception;
            }
            if (exception instanceof Throwable) {
                throw new SftpException(4, "", exception);
            }
            throw new SftpException(4, "");
        }
    }

    public void setBulkRequests(int n) throws JSchException {
        if (n > 0) {
            this.rq = new RequestQueue(this, n);
            return;
        }
        throw new JSchException("setBulkRequests: " + n + " must be greater than 0.");
    }

    public void setFilenameEncoding(String string2) throws SftpException {
        int n = this.getServerVersion();
        if (3 <= n && n <= 5 && !string2.equals(UTF8)) {
            throw new SftpException(4, "The encoding can not be changed for this sftp server.");
        }
        String string3 = string2;
        if (string2.equals(UTF8)) {
            string3 = UTF8;
        }
        this.fEncoding = string3;
        this.fEncoding_is_utf8 = this.fEncoding.equals(UTF8);
    }

    public void setMtime(String object, int n) throws SftpException {
        int n2;
        try {
            ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
            object = this.glob_remote(this.remoteAbsolutePath((String)object));
            n2 = ((Vector)object).size();
        }
        catch (Exception exception) {
            if (!(exception instanceof SftpException)) {
                if (exception instanceof Throwable) {
                    throw new SftpException(4, "", exception);
                }
                throw new SftpException(4, "");
            }
            throw (SftpException)exception;
        }
        for (int i = 0; i < n2; ++i) {
            String string2 = (String)((Vector)object).elementAt(i);
            Object object2 = string2;
            object2 = this._stat(string2);
            ((SftpATTRS)object2).setFLAGS(0);
            ((SftpATTRS)object2).setACMODTIME(((SftpATTRS)object2).getATime(), n);
            this._setStat(string2, (SftpATTRS)object2);
            continue;
        }
        return;
    }

    public void setStat(String object, SftpATTRS sftpATTRS) throws SftpException {
        int n;
        try {
            ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
            object = this.glob_remote(this.remoteAbsolutePath((String)object));
            n = ((Vector)object).size();
        }
        catch (Exception exception) {
            if (!(exception instanceof SftpException)) {
                if (exception instanceof Throwable) {
                    throw new SftpException(4, "", exception);
                }
                throw new SftpException(4, "");
            }
            throw (SftpException)exception;
        }
        for (int i = 0; i < n; ++i) {
            String string2;
            String string3 = string2 = (String)((Vector)object).elementAt(i);
            this._setStat(string2, sftpATTRS);
            continue;
        }
        return;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void start() throws JSchException {
        try {
            Object object = new PipedOutputStream();
            this.io.setOutputStream((OutputStream)object);
            Object object2 = new Channel.MyPipedInputStream((Channel)this, (PipedOutputStream)object, this.rmpsize);
            this.io.setInputStream((InputStream)object2);
            this.io_in = this.io.in;
            if (this.io_in == null) {
                object = new JSchException("channel is down");
                throw object;
            }
            object = new RequestSftp();
            ((Request)object).request(this.getSession(), this);
            this.buf = object = new Buffer(this.lmpsize);
            this.packet = object = new Packet(this.buf);
            this.obuf = object = new Buffer(this.rmpsize);
            this.opacket = object = new Packet(this.obuf);
            this.sendINIT();
            object = new Header(this);
            object = this.header(this.buf, (Header)object);
            int n = ((Header)object).length;
            if (n > 262144) {
                object = new StringBuilder();
                object2 = new SftpException(4, ((StringBuilder)object).append("Received message is too long: ").append(n).toString());
                throw object2;
            }
            int n2 = ((Header)object).type;
            this.server_version = ((Header)object).rid;
            object = new Hashtable();
            this.extensions = object;
            if (n > 0) {
                this.fill(this.buf, n);
                while (n > 0) {
                    object2 = this.buf.getString();
                    n2 = ((Object)object2).length;
                    object = this.buf.getString();
                    n = n - (n2 + 4) - (((Object)object).length + 4);
                    this.extensions.put(Util.byte2str((byte[])object2), Util.byte2str((byte[])object));
                }
            }
            if ((object = this.extensions.get("posix-rename@openssh.com")) != null && this.extensions.get("posix-rename@openssh.com").equals("1")) {
                this.extension_posix_rename = true;
            }
            if (this.extensions.get("statvfs@openssh.com") != null && this.extensions.get("statvfs@openssh.com").equals("2")) {
                this.extension_statvfs = true;
            }
            if (this.extensions.get("hardlink@openssh.com") != null && this.extensions.get("hardlink@openssh.com").equals("1")) {
                this.extension_hardlink = true;
            }
            object = new File(".");
            this.lcwd = ((File)object).getCanonicalPath();
            return;
        }
        catch (Exception exception) {
            if (exception instanceof JSchException) {
                throw (JSchException)exception;
            }
            if (exception instanceof Throwable) {
                throw new JSchException(exception.toString(), exception);
            }
            throw new JSchException(exception.toString());
        }
    }

    public SftpATTRS stat(String object) throws SftpException {
        try {
            ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
            object = this._stat(this.isUnique(this.remoteAbsolutePath((String)object)));
            return object;
        }
        catch (Exception exception) {
            if (!(exception instanceof SftpException)) {
                if (exception instanceof Throwable) {
                    throw new SftpException(4, "", exception);
                }
                throw new SftpException(4, "");
            }
            throw (SftpException)exception;
        }
    }

    public SftpStatVFS statVFS(String object) throws SftpException {
        try {
            ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
            object = this._statVFS(this.isUnique(this.remoteAbsolutePath((String)object)));
            return object;
        }
        catch (Exception exception) {
            if (!(exception instanceof SftpException)) {
                if (exception instanceof Throwable) {
                    throw new SftpException(4, "", exception);
                }
                throw new SftpException(4, "");
            }
            throw (SftpException)exception;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void symlink(String object, String string2) throws SftpException {
        if (this.server_version < 3) {
            throw new SftpException(8, "The remote sshd is too old to support symlink operation.");
        }
        try {
            int n;
            ((Channel.MyPipedInputStream)this.io_in).updateReadSide();
            String string3 = this.remoteAbsolutePath((String)object);
            String string4 = this.remoteAbsolutePath(string2);
            string2 = this.isUnique(string3);
            int n2 = 0;
            if (((String)object).charAt(0) != '/') {
                object = this.getCwd();
                n = ((String)object).length();
                if (!((String)object).endsWith("/")) {
                    n2 = 1;
                }
                object = string2.substring(n + n2);
            } else {
                object = string2;
            }
            if (this.isPattern(string4)) {
                object = new SftpException(4, string4);
                throw object;
            }
            string2 = Util.unquote(string4);
            this.sendSYMLINK(Util.str2byte((String)object, this.fEncoding), Util.str2byte(string2, this.fEncoding));
            object = new Header(this);
            object = this.header(this.buf, (Header)object);
            n = ((Header)object).length;
            n2 = ((Header)object).type;
            this.fill(this.buf, n);
            if (n2 != 101) {
                object = new SftpException(4, "");
                throw object;
            }
            n2 = this.buf.getInt();
            if (n2 == 0) {
                return;
            }
            this.throwStatusError(this.buf, n2);
            return;
        }
        catch (Exception exception) {
            if (exception instanceof SftpException) {
                throw (SftpException)exception;
            }
            if (exception instanceof Throwable) {
                throw new SftpException(4, "", exception);
            }
            throw new SftpException(4, "");
        }
    }

    public String version() {
        return this.version;
    }

    class Header {
        int length;
        int rid;
        final ChannelSftp this$0;
        int type;

        Header(ChannelSftp channelSftp) {
            this.this$0 = channelSftp;
        }
    }

    public class LsEntry
    implements Comparable {
        private SftpATTRS attrs;
        private String filename;
        private String longname;
        final ChannelSftp this$0;

        LsEntry(ChannelSftp channelSftp, String string2, String string3, SftpATTRS sftpATTRS) {
            this.this$0 = channelSftp;
            this.setFilename(string2);
            this.setLongname(string3);
            this.setAttrs(sftpATTRS);
        }

        public int compareTo(Object object) throws ClassCastException {
            if (object instanceof LsEntry) {
                return this.filename.compareTo(((LsEntry)object).getFilename());
            }
            throw new ClassCastException("a decendent of LsEntry must be given.");
        }

        public SftpATTRS getAttrs() {
            return this.attrs;
        }

        public String getFilename() {
            return this.filename;
        }

        public String getLongname() {
            return this.longname;
        }

        void setAttrs(SftpATTRS sftpATTRS) {
            this.attrs = sftpATTRS;
        }

        void setFilename(String string2) {
            this.filename = string2;
        }

        void setLongname(String string2) {
            this.longname = string2;
        }

        public String toString() {
            return this.longname;
        }
    }

    public static interface LsEntrySelector {
        public static final int BREAK = 1;
        public static final int CONTINUE = 0;

        public int select(LsEntry var1);
    }

    private class RequestQueue {
        int count;
        int head;
        Request[] rrq;
        final ChannelSftp this$0;

        RequestQueue(ChannelSftp channelSftp, int n) {
            this.this$0 = channelSftp;
            this.rrq = null;
            this.rrq = new Request[n];
            for (n = 0; n < this.rrq.length; ++n) {
                this.rrq[n] = new Request(this);
            }
            this.init();
        }

        void add(int n, long l, int n2) {
            int n3;
            if (this.count == 0) {
                this.head = 0;
            }
            int n4 = n3 = this.head + this.count;
            if (n3 >= this.rrq.length) {
                n4 = n3 - this.rrq.length;
            }
            this.rrq[n4].id = n;
            this.rrq[n4].offset = l;
            this.rrq[n4].length = n2;
            ++this.count;
        }

        void cancel(Header header, Buffer buffer) throws IOException {
            int n = this.count;
            for (int i = 0; i < n; ++i) {
                header = this.this$0.header(buffer, header);
                int n2 = header.length;
                for (int j = 0; j < this.rrq.length; ++j) {
                    if (this.rrq[j].id != header.rid) continue;
                    this.rrq[j].id = 0;
                    break;
                }
                this.this$0.skip(n2);
            }
            this.init();
        }

        int count() {
            return this.count;
        }

        Request get(int n) throws OutOfOrderException, SftpException {
            --this.count;
            int n2 = this.head++;
            if (this.head == this.rrq.length) {
                this.head = 0;
            }
            if (this.rrq[n2].id != n) {
                boolean bl;
                long l = this.getOffset();
                boolean bl2 = false;
                n2 = 0;
                while (true) {
                    bl = bl2;
                    if (n2 >= this.rrq.length) break;
                    if (this.rrq[n2].id == n) {
                        bl = true;
                        this.rrq[n2].id = 0;
                        break;
                    }
                    ++n2;
                }
                if (bl) {
                    throw new OutOfOrderException(this, l);
                }
                throw new SftpException(4, "RequestQueue: unknown request id " + n);
            }
            this.rrq[n2].id = 0;
            return this.rrq[n2];
        }

        long getOffset() {
            long l = Long.MAX_VALUE;
            for (int i = 0; i < this.rrq.length; ++i) {
                long l2;
                if (this.rrq[i].id == 0) {
                    l2 = l;
                } else {
                    l2 = l;
                    if (l > this.rrq[i].offset) {
                        l2 = this.rrq[i].offset;
                    }
                }
                l = l2;
            }
            return l;
        }

        void init() {
            this.count = 0;
            this.head = 0;
        }

        int size() {
            return this.rrq.length;
        }

        class OutOfOrderException
        extends Exception {
            long offset;
            final RequestQueue this$1;

            OutOfOrderException(RequestQueue requestQueue, long l) {
                this.this$1 = requestQueue;
                this.offset = l;
            }
        }

        class Request {
            int id;
            long length;
            long offset;
            final RequestQueue this$1;

            Request(RequestQueue requestQueue) {
                this.this$1 = requestQueue;
            }
        }
    }
}

