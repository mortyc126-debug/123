/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.HostKey;
import com.jcraft.jsch.HostKeyRepository;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.MAC;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;
import com.jcraft.jsch.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Vector;

public class KnownHosts
implements HostKeyRepository {
    private static final String _known_hosts = "known_hosts";
    private static final byte[] cr;
    private static final byte[] space;
    private MAC hmacsha1 = null;
    private JSch jsch = null;
    private String known_hosts = null;
    private Vector pool = null;

    static {
        space = new byte[]{32};
        cr = Util.str2byte("\n");
    }

    KnownHosts(JSch jSch) {
        this.jsch = jSch;
        this.hmacsha1 = this.getHMACSHA1();
        this.pool = new Vector();
    }

    private void addInvalidLine(String object) throws JSchException {
        object = new HostKey((String)object, 6, null);
        this.pool.addElement(object);
    }

    private String deleteSubString(String string2, String string3) {
        int n;
        int n2 = 0;
        int n3 = string3.length();
        int n4 = string2.length();
        while (n2 < n4 && (n = string2.indexOf(44, n2)) != -1) {
            if (!string3.equals(string2.substring(n2, n))) {
                n2 = n + 1;
                continue;
            }
            return string2.substring(0, n2) + string2.substring(n + 1);
        }
        if (string2.endsWith(string3) && n4 - n2 == n3) {
            n2 = n3 == n4 ? 0 : n4 - n3 - 1;
            return string2.substring(0, n2);
        }
        return string2;
    }

    private MAC getHMACSHA1() {
        if (this.hmacsha1 == null) {
            try {
                MAC mAC;
                MAC mAC2 = mAC = (MAC)Class.forName(JSch.getConfig("hmac-sha1")).newInstance();
                this.hmacsha1 = mAC;
            }
            catch (Exception exception) {
                System.err.println("hmacsha1: " + exception);
            }
        }
        return this.hmacsha1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void add(HostKey object, UserInfo userInfo) {
        int n = ((HostKey)object).type;
        Object object2 = ((HostKey)object).getHost();
        Object object3 = ((HostKey)object).key;
        object3 = this.pool;
        synchronized (object3) {
            for (n = 0; n < this.pool.size(); ++n) {
                HostKey hostKey;
                HostKey hostKey2 = hostKey = (HostKey)this.pool.elementAt(n);
                if (!hostKey.isMatched((String)object2)) continue;
                int n2 = hostKey.type;
            }
        }
        this.pool.addElement(object);
        object = this.getKnownHostsRepositoryID();
        if (object == null) return;
        boolean bl = true;
        object2 = new File(Util.checkTilde((String)object));
        if (!((File)object2).exists()) {
            bl = false;
            if (userInfo != null) {
                boolean bl2 = userInfo.promptYesNo((String)object + " does not exist.\n" + "Are you sure you want to create it?");
                object2 = ((File)object2).getParentFile();
                bl = bl2;
                if (bl2) {
                    bl = bl2;
                    if (object2 != null) {
                        bl = bl2;
                        if (!((File)object2).exists()) {
                            bl = bl2 = userInfo.promptYesNo("The parent directory " + object2 + " does not exist.\n" + "Are you sure you want to create it?");
                            if (bl2) {
                                if (!((File)object2).mkdirs()) {
                                    userInfo.showMessage(object2 + " has not been created.");
                                    bl = false;
                                } else {
                                    userInfo.showMessage(object2 + " has been succesfully created.\nPlease check its access permission.");
                                    bl = bl2;
                                }
                            }
                        }
                    }
                }
                if (object2 == null) {
                    bl = false;
                }
            }
        }
        if (!bl) return;
        try {
            this.sync((String)object);
            return;
        }
        catch (Exception exception) {
            System.err.println("sync known_hosts: " + exception);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Override
    public int check(String string2, byte[] byArray) {
        HostKey hostKey;
        if (string2 == null) {
            return 1;
        }
        try {
            hostKey = new HostKey(string2, 0, byArray);
            Vector vector = this.pool;
        }
        catch (JSchException jSchException) {
            return 1;
        }
        int n = 0;
        int n2 = 1;
        while (true) {
            HostKey hostKey2;
            if (n >= this.pool.size()) {
                // MONITOREXIT : vector
                if (n2 != true) return n2;
                if (!string2.startsWith("[")) return n2;
                if (string2.indexOf("]:") <= 1) return n2;
                return this.check(string2.substring(1, string2.indexOf("]:")), byArray);
            }
            HostKey hostKey3 = hostKey2 = (HostKey)this.pool.elementAt(n);
            int n3 = n2;
            if (hostKey2.isMatched(string2)) {
                n3 = n2;
                if (hostKey2.type == hostKey.type) {
                    if (Util.array_equals(hostKey2.key, byArray)) {
                        // MONITOREXIT : vector
                        return 0;
                    }
                    n3 = 2;
                }
            }
            ++n;
            n2 = n3;
        }
    }

    HostKey createHashedHostKey(String object, byte[] byArray) throws JSchException {
        object = new HashedHostKey(this, (String)object, byArray);
        ((HashedHostKey)object).hash();
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    void dump(OutputStream outputStream) throws IOException {
        int n;
        block12: {
            try {
                Vector vector = this.pool;
                // MONITORENTER : vector
                n = 0;
                break block12;
            }
            catch (Exception exception) {
                System.err.println(exception);
            }
            return;
        }
        while (true) {
            if (n >= this.pool.size()) {
                // MONITOREXIT : vector
                return;
            }
            HostKey hostKey = (HostKey)this.pool.elementAt(n);
            Object object = hostKey;
            String string2 = hostKey.getMarker();
            object = hostKey.getHost();
            String string3 = hostKey.getType();
            String string4 = hostKey.getComment();
            if (string3.equals("UNKNOWN")) {
                outputStream.write(Util.str2byte((String)object));
                outputStream.write(cr);
            } else {
                if (string2.length() != 0) {
                    outputStream.write(Util.str2byte(string2));
                    outputStream.write(space);
                }
                outputStream.write(Util.str2byte((String)object));
                outputStream.write(space);
                outputStream.write(Util.str2byte(string3));
                outputStream.write(space);
                outputStream.write(Util.str2byte(hostKey.getKey()));
                if (string4 != null) {
                    outputStream.write(space);
                    outputStream.write(Util.str2byte(string4));
                }
                outputStream.write(cr);
            }
            ++n;
        }
    }

    @Override
    public HostKey[] getHostKey() {
        String string2 = null;
        return this.getHostKey(null, null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public HostKey[] getHostKey(String hostKeyArray, String string2) {
        Vector vector = this.pool;
        synchronized (vector) {
            Object object;
            int n;
            Object object2 = new ArrayList();
            for (n = 0; n < this.pool.size(); ++n) {
                object = (HostKey)this.pool.elementAt(n);
                if (((HostKey)object).type == 6 || hostKeyArray != null && (!((HostKey)object).isMatched((String)hostKeyArray) || string2 != null && !((HostKey)object).getType().equals(string2))) continue;
                ((ArrayList)object2).add(object);
            }
            object = new HostKey[((ArrayList)object2).size()];
            for (n = 0; n < ((ArrayList)object2).size(); ++n) {
                object[n] = (HostKey)((ArrayList)object2).get(n);
            }
            object2 = object;
            if (hostKeyArray != null) {
                object2 = object;
                if (hostKeyArray.startsWith("[")) {
                    object2 = object;
                    if (hostKeyArray.indexOf("]:") > 1) {
                        hostKeyArray = this.getHostKey(hostKeyArray.substring(1, hostKeyArray.indexOf("]:")), string2);
                        object2 = object;
                        if (hostKeyArray.length > 0) {
                            object2 = new HostKey[((Object)object).length + hostKeyArray.length];
                            System.arraycopy(object, 0, object2, 0, ((Object)object).length);
                            System.arraycopy(hostKeyArray, 0, object2, ((Object)object).length, hostKeyArray.length);
                        }
                    }
                }
            }
            return object2;
        }
    }

    String getKnownHostsFile() {
        return this.known_hosts;
    }

    @Override
    public String getKnownHostsRepositoryID() {
        return this.known_hosts;
    }

    @Override
    public void remove(String string2, String string3) {
        this.remove(string2, string3, null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void remove(String string2, String string3, byte[] byArray) {
        boolean bl = false;
        Vector vector = this.pool;
        synchronized (vector) {
            for (int i = 0; i < this.pool.size(); ++i) {
                boolean bl2;
                block13: {
                    Object object;
                    HostKey hostKey;
                    block12: {
                        hostKey = (HostKey)this.pool.elementAt(i);
                        object = hostKey;
                        if (string2 == null) break block12;
                        bl2 = bl;
                        if (!hostKey.isMatched(string2)) break block13;
                        if (string3 == null) break block12;
                        bl2 = bl;
                        if (!hostKey.getType().equals(string3)) break block13;
                        if (byArray == null) break block12;
                        bl2 = bl;
                        if (!Util.array_equals(byArray, hostKey.key)) break block13;
                    }
                    if (!(((String)(object = hostKey.getHost())).equals(string2) || hostKey instanceof HashedHostKey && ((HashedHostKey)hostKey).isHashed())) {
                        hostKey.host = this.deleteSubString((String)object, string2);
                    } else {
                        this.pool.removeElement(hostKey);
                    }
                    bl2 = true;
                }
                bl = bl2;
            }
        }
        if (!bl) return;
        try {
            this.sync();
            return;
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    /*
     * Exception decompiling
     */
    void setKnownHosts(InputStream var1_1) throws JSchException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 23[TRYBLOCK] [52, 51 : 885->894)] java.lang.Throwable
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

    void setKnownHosts(String string2) throws JSchException {
        try {
            this.known_hosts = string2;
            FileInputStream fileInputStream = new FileInputStream(Util.checkTilde(string2));
            this.setKnownHosts(fileInputStream);
        }
        catch (FileNotFoundException fileNotFoundException) {
            // empty catch block
        }
    }

    protected void sync() throws IOException {
        if (this.known_hosts != null) {
            this.sync(this.known_hosts);
        }
    }

    protected void sync(String string2) throws IOException {
        synchronized (this) {
            if (string2 == null) {
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(Util.checkTilde(string2));
            this.dump(fileOutputStream);
            fileOutputStream.close();
            return;
        }
    }

    class HashedHostKey
    extends HostKey {
        private static final String HASH_DELIM = "|";
        private static final String HASH_MAGIC = "|1|";
        byte[] hash;
        private boolean hashed;
        byte[] salt;
        final KnownHosts this$0;

        HashedHostKey(KnownHosts knownHosts, String string2, int n, byte[] byArray) throws JSchException {
            this(knownHosts, "", string2, n, byArray, null);
        }

        HashedHostKey(KnownHosts object, String string2, String string3, int n, byte[] byArray, String string4) throws JSchException {
            this.this$0 = object;
            super(string2, string3, n, byArray, string4);
            this.hashed = false;
            this.salt = null;
            this.hash = null;
            if (this.host.startsWith(HASH_MAGIC) && this.host.substring(HASH_MAGIC.length()).indexOf(HASH_DELIM) > 0) {
                string2 = this.host.substring(HASH_MAGIC.length());
                object = string2.substring(0, string2.indexOf(HASH_DELIM));
                string2 = string2.substring(string2.indexOf(HASH_DELIM) + 1);
                this.salt = Util.fromBase64(Util.str2byte((String)object), 0, ((String)object).length());
                this.hash = Util.fromBase64(Util.str2byte(string2), 0, string2.length());
                if (this.salt.length == 20 && this.hash.length == 20) {
                    this.hashed = true;
                } else {
                    this.salt = null;
                    this.hash = null;
                    return;
                }
            }
        }

        HashedHostKey(KnownHosts knownHosts, String string2, byte[] byArray) throws JSchException {
            this(knownHosts, string2, 0, byArray);
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        void hash() {
            block9: {
                Object object;
                if (this.hashed) {
                    return;
                }
                MAC mAC = this.this$0.getHMACSHA1();
                if (this.salt == null) {
                    object = Session.random;
                    synchronized (object) {
                        this.salt = new byte[mAC.getBlockSize()];
                        object.fill(this.salt, 0, this.salt.length);
                    }
                }
                try {
                    synchronized (mAC) {
                    }
                }
                catch (Exception exception) {
                    // empty catch block
                    break block9;
                }
                {
                    mAC.init(this.salt);
                    object = Util.str2byte(this.host);
                    mAC.update((byte[])object, 0, ((Object)object).length);
                    this.hash = new byte[mAC.getBlockSize()];
                    mAC.doFinal(this.hash, 0);
                }
            }
            this.host = HASH_MAGIC + Util.byte2str(Util.toBase64(this.salt, 0, this.salt.length)) + HASH_DELIM + Util.byte2str(Util.toBase64(this.hash, 0, this.hash.length));
            this.hashed = true;
        }

        boolean isHashed() {
            return this.hashed;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        boolean isMatched(String object) {
            if (!this.hashed) {
                return super.isMatched((String)object);
            }
            MAC mAC = this.this$0.getHMACSHA1();
            try {
                synchronized (mAC) {
                }
            }
            catch (Exception exception) {
                System.out.println(exception);
                return false;
            }
            {
                mAC.init(this.salt);
                object = Util.str2byte((String)object);
                mAC.update((byte[])object, 0, ((Object)object).length);
                object = new byte[mAC.getBlockSize()];
                mAC.doFinal((byte[])object, 0);
                return Util.array_equals(this.hash, (byte[])object);
            }
        }
    }
}

