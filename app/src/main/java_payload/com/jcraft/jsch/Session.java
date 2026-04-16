/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.Buffer;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelDirectTCPIP;
import com.jcraft.jsch.ChannelForwardedTCPIP;
import com.jcraft.jsch.ChannelSession;
import com.jcraft.jsch.ChannelX11;
import com.jcraft.jsch.Cipher;
import com.jcraft.jsch.Compression;
import com.jcraft.jsch.ConfigRepository;
import com.jcraft.jsch.HASH;
import com.jcraft.jsch.HostKey;
import com.jcraft.jsch.HostKeyRepository;
import com.jcraft.jsch.IO;
import com.jcraft.jsch.IdentityFile;
import com.jcraft.jsch.IdentityRepository;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.KeyExchange;
import com.jcraft.jsch.KnownHosts;
import com.jcraft.jsch.MAC;
import com.jcraft.jsch.Packet;
import com.jcraft.jsch.PortWatcher;
import com.jcraft.jsch.Proxy;
import com.jcraft.jsch.Random;
import com.jcraft.jsch.ServerSocketFactory;
import com.jcraft.jsch.Signature;
import com.jcraft.jsch.SocketFactory;
import com.jcraft.jsch.UserInfo;
import com.jcraft.jsch.Util;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;

public class Session
implements Runnable {
    private static final int PACKET_MAX_SIZE = 262144;
    static final int SSH_MSG_CHANNEL_CLOSE = 97;
    static final int SSH_MSG_CHANNEL_DATA = 94;
    static final int SSH_MSG_CHANNEL_EOF = 96;
    static final int SSH_MSG_CHANNEL_EXTENDED_DATA = 95;
    static final int SSH_MSG_CHANNEL_FAILURE = 100;
    static final int SSH_MSG_CHANNEL_OPEN = 90;
    static final int SSH_MSG_CHANNEL_OPEN_CONFIRMATION = 91;
    static final int SSH_MSG_CHANNEL_OPEN_FAILURE = 92;
    static final int SSH_MSG_CHANNEL_REQUEST = 98;
    static final int SSH_MSG_CHANNEL_SUCCESS = 99;
    static final int SSH_MSG_CHANNEL_WINDOW_ADJUST = 93;
    static final int SSH_MSG_DEBUG = 4;
    static final int SSH_MSG_DISCONNECT = 1;
    static final int SSH_MSG_GLOBAL_REQUEST = 80;
    static final int SSH_MSG_IGNORE = 2;
    static final int SSH_MSG_KEXDH_INIT = 30;
    static final int SSH_MSG_KEXDH_REPLY = 31;
    static final int SSH_MSG_KEXINIT = 20;
    static final int SSH_MSG_KEX_DH_GEX_GROUP = 31;
    static final int SSH_MSG_KEX_DH_GEX_INIT = 32;
    static final int SSH_MSG_KEX_DH_GEX_REPLY = 33;
    static final int SSH_MSG_KEX_DH_GEX_REQUEST = 34;
    static final int SSH_MSG_NEWKEYS = 21;
    static final int SSH_MSG_REQUEST_FAILURE = 82;
    static final int SSH_MSG_REQUEST_SUCCESS = 81;
    static final int SSH_MSG_SERVICE_ACCEPT = 6;
    static final int SSH_MSG_SERVICE_REQUEST = 5;
    static final int SSH_MSG_UNIMPLEMENTED = 3;
    static final int buffer_margin = 128;
    private static final byte[] keepalivemsg = Util.str2byte("keepalive@jcraft.com");
    private static final byte[] nomoresessions = Util.str2byte("no-more-sessions@openssh.com");
    static Random random;
    private byte[] Ec2s;
    private byte[] Es2c;
    private byte[] IVc2s;
    private byte[] IVs2c;
    private byte[] I_C;
    private byte[] I_S;
    private byte[] K_S;
    private byte[] MACc2s;
    private byte[] MACs2c;
    private byte[] V_C = Util.str2byte("SSH-2.0-JSCH-0.1.54");
    private byte[] V_S;
    boolean agent_forwarding = false;
    int auth_failures = 0;
    Buffer buf;
    private Cipher c2scipher;
    private int c2scipher_size = 8;
    private MAC c2smac;
    int[] compress_len;
    private Hashtable config = null;
    private Thread connectThread = null;
    protected boolean daemon_thread = false;
    private Compression deflater;
    private GlobalRequestReply grr;
    String[] guess = null;
    String host = "127.0.0.1";
    private String hostKeyAlias = null;
    private HostKey hostkey = null;
    private HostKeyRepository hostkeyRepository = null;
    private IdentityRepository identityRepository = null;
    InputStream in = null;
    private volatile boolean in_kex = false;
    private volatile boolean in_prompt = false;
    private Compression inflater;
    private IO io;
    private boolean isAuthed = false;
    private volatile boolean isConnected = false;
    JSch jsch;
    private long kex_start_time = 0L;
    private Object lock = new Object();
    int max_auth_tries = 6;
    String org_host = "127.0.0.1";
    OutputStream out = null;
    Packet packet;
    byte[] password = null;
    int port = 22;
    private Proxy proxy = null;
    private Cipher s2ccipher;
    private int s2ccipher_size = 8;
    private MAC s2cmac;
    private byte[] s2cmac_result1;
    private byte[] s2cmac_result2;
    private int seqi = 0;
    private int seqo = 0;
    private int serverAliveCountMax = 1;
    private int serverAliveInterval = 0;
    private byte[] session_id;
    private Socket socket;
    SocketFactory socket_factory = null;
    Runnable thread;
    private int timeout = 0;
    int[] uncompress_len = new int[1];
    private UserInfo userinfo;
    String username = null;
    boolean x11_forwarding = false;

    Session(JSch object, String string2, String string3, int n) throws JSchException {
        this.compress_len = new int[1];
        this.grr = new GlobalRequestReply(this);
        this.jsch = object;
        this.buf = new Buffer();
        this.packet = new Packet(this.buf);
        this.username = string2;
        this.host = string3;
        this.org_host = string3;
        this.port = n;
        this.applyConfig();
        if (this.username == null) {
            try {
                object = (String)System.getProperties().get("user.name");
                string2 = (String)object;
                this.username = object;
            }
            catch (SecurityException securityException) {
                // empty catch block
            }
        }
        if (this.username != null) {
            return;
        }
        throw new JSchException("username is not given.");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private int _setPortForwardingR(String charSequence, int n) throws JSchException {
        GlobalRequestReply globalRequestReply = this.grr;
        synchronized (globalRequestReply) {
            int n2;
            Buffer buffer = new Buffer(100);
            Object object = new Packet(buffer);
            charSequence = ChannelForwardedTCPIP.normalize((String)charSequence);
            this.grr.setThread(Thread.currentThread());
            this.grr.setPort(n);
            try {
                ((Packet)object).reset();
                buffer.putByte((byte)80);
                buffer.putString(Util.str2byte("tcpip-forward"));
                buffer.putByte((byte)1);
                buffer.putString(Util.str2byte((String)charSequence));
                buffer.putInt(n);
                this.write((Packet)object);
                n2 = this.grr.getReply();
            }
            catch (Exception exception) {
                this.grr.setThread(null);
                if (exception instanceof Throwable) {
                    object = new JSchException(exception.toString(), exception);
                    throw object;
                }
                object = new JSchException(exception.toString());
                throw object;
            }
            for (int i = 0; i < 10 && n2 == -1; ++i) {
                try {
                    Thread.sleep(1000L);
                }
                catch (Exception exception) {
                    // empty catch block
                }
                n2 = this.grr.getReply();
            }
            this.grr.setThread(null);
            if (n2 == 1) {
                return this.grr.getPort();
            }
            charSequence = new StringBuilder();
            object = new JSchException(((StringBuilder)charSequence).append("remote port forwarding failed for listen port ").append(n).toString());
            throw object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void _write(Packet packet) throws Exception {
        Object object = this.lock;
        synchronized (object) {
            this.encode(packet);
            if (this.io != null) {
                this.io.put(packet);
                ++this.seqo;
            }
            return;
        }
    }

    private void applyConfig() throws JSchException {
        String[] stringArray;
        String string2;
        int n;
        Object object;
        Object object2 = this.jsch.getConfigRepository();
        if (object2 == null) {
            return;
        }
        ConfigRepository.Config config = object2.getConfig(this.org_host);
        if (this.username == null && (object = config.getUser()) != null) {
            this.username = object;
        }
        if ((object = config.getHostname()) != null) {
            this.host = object;
        }
        if ((n = config.getPort()) != -1) {
            this.port = n;
        }
        this.checkConfig(config, "kex");
        this.checkConfig(config, "server_host_key");
        this.checkConfig(config, "cipher.c2s");
        this.checkConfig(config, "cipher.s2c");
        this.checkConfig(config, "mac.c2s");
        this.checkConfig(config, "mac.s2c");
        this.checkConfig(config, "compression.c2s");
        this.checkConfig(config, "compression.s2c");
        this.checkConfig(config, "compression_level");
        this.checkConfig(config, "StrictHostKeyChecking");
        this.checkConfig(config, "HashKnownHosts");
        this.checkConfig(config, "PreferredAuthentications");
        this.checkConfig(config, "MaxAuthTries");
        this.checkConfig(config, "ClearAllForwardings");
        object = config.getValue("HostKeyAlias");
        if (object != null) {
            this.setHostKeyAlias((String)object);
        }
        if ((string2 = config.getValue("UserKnownHostsFile")) != null) {
            object = new KnownHosts(this.jsch);
            ((KnownHosts)object).setKnownHosts(string2);
            this.setHostKeyRepository((HostKeyRepository)object);
        }
        if ((stringArray = config.getValues("IdentityFile")) != null) {
            if ((object2 = object2.getConfig("").getValues("IdentityFile")) != null) {
                for (n = 0; n < ((String[])object2).length; ++n) {
                    this.jsch.addIdentity(object2[n]);
                }
            } else {
                object2 = new String[]{};
            }
            if (stringArray.length - ((String[])object2).length > 0) {
                IdentityRepository.Wrapper wrapper = new IdentityRepository.Wrapper(this.jsch.getIdentityRepository(), true);
                for (n = 0; n < stringArray.length; ++n) {
                    block21: {
                        string2 = stringArray[n];
                        int n2 = 0;
                        while (true) {
                            object = string2;
                            if (n2 >= ((String[])object2).length) break block21;
                            if (string2.equals(object2[n2])) break;
                            ++n2;
                        }
                        object = null;
                    }
                    if (object == null) continue;
                    wrapper.add(IdentityFile.newInstance((String)object, null, this.jsch));
                }
                this.setIdentityRepository(wrapper);
            }
        }
        if ((object2 = config.getValue("ServerAliveInterval")) != null) {
            try {
                this.setServerAliveInterval(Integer.parseInt((String)object2));
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
        }
        if ((object2 = config.getValue("ConnectTimeout")) != null) {
            try {
                this.setTimeout(Integer.parseInt((String)object2));
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
        }
        if ((object2 = config.getValue("MaxAuthTries")) != null) {
            this.setConfig("MaxAuthTries", (String)object2);
        }
        if ((object2 = config.getValue("ClearAllForwardings")) != null) {
            this.setConfig("ClearAllForwardings", (String)object2);
        }
    }

    private void applyConfigChannel(ChannelSession channelSession) throws JSchException {
        Object object = this.jsch.getConfigRepository();
        if (object == null) {
            return;
        }
        ConfigRepository.Config config = object.getConfig(this.org_host);
        if ((object = config.getValue("ForwardAgent")) != null) {
            channelSession.setAgentForwarding(((String)object).equals("yes"));
        }
        if ((object = config.getValue("RequestTTY")) != null) {
            channelSession.setPty(((String)object).equals("yes"));
        }
    }

    static boolean checkCipher(String object) {
        try {
            object = (Cipher)Class.forName((String)object).newInstance();
            Cipher cipher = (Cipher)object;
            object.init(0, new byte[object.getBlockSize()], new byte[object.getIVSize()]);
            return true;
        }
        catch (Exception exception) {
            return false;
        }
    }

    private String[] checkCiphers(String stringArray) {
        if (stringArray != null && stringArray.length() != 0) {
            int n;
            if (JSch.getLogger().isEnabled(1)) {
                JSch.getLogger().log(1, "CheckCiphers: " + (String)stringArray);
            }
            String string2 = this.getConfig("cipher.c2s");
            String string3 = this.getConfig("cipher.s2c");
            Vector<String> vector = new Vector<String>();
            stringArray = Util.split((String)stringArray, ",");
            for (n = 0; n < stringArray.length; ++n) {
                String string4 = stringArray[n];
                if (string3.indexOf(string4) == -1 && string2.indexOf(string4) == -1 || Session.checkCipher(this.getConfig(string4))) continue;
                vector.addElement(string4);
            }
            if (vector.size() == 0) {
                return null;
            }
            stringArray = new String[vector.size()];
            System.arraycopy(vector.toArray(), 0, stringArray, 0, vector.size());
            if (JSch.getLogger().isEnabled(1)) {
                for (n = 0; n < stringArray.length; ++n) {
                    JSch.getLogger().log(1, stringArray[n] + " is not available.");
                }
            }
            return stringArray;
        }
        return null;
    }

    private void checkConfig(ConfigRepository.Config object, String string2) {
        if ((object = object.getValue(string2)) != null) {
            this.setConfig(string2, (String)object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void checkHost(String hostKeyArray, int n, KeyExchange object) throws JSchException {
        int n2;
        int n3;
        HostKeyRepository hostKeyRepository;
        String string2;
        byte[] byArray;
        String string3;
        block38: {
            String string4;
            block37: {
                block36: {
                    block35: {
                        string3 = this.getConfig("StrictHostKeyChecking");
                        if (this.hostKeyAlias != null) {
                            hostKeyArray = this.hostKeyAlias;
                        }
                        byArray = ((KeyExchange)object).getHostKey();
                        string2 = ((KeyExchange)object).getKeyType();
                        string4 = ((KeyExchange)object).getFingerPrint();
                        if (this.hostKeyAlias == null && n != 22) {
                            hostKeyArray = "[" + (String)hostKeyArray + "]:" + n;
                        }
                        hostKeyRepository = this.getHostKeyRepository();
                        this.hostkey = this.getConfig("HashKnownHosts").equals("yes") && hostKeyRepository instanceof KnownHosts ? ((KnownHosts)hostKeyRepository).createHashedHostKey((String)hostKeyArray, byArray) : new HostKey((String)hostKeyArray, byArray);
                        synchronized (hostKeyRepository) {
                            n3 = hostKeyRepository.check((String)hostKeyArray, byArray);
                        }
                        n2 = 0;
                        if (string3.equals("ask")) break block35;
                        n = n2;
                        if (!string3.equals("yes")) break block36;
                    }
                    n = n2;
                    if (n3 == 2) {
                        boolean bl;
                        String string5;
                        synchronized (hostKeyRepository) {
                            string5 = hostKeyRepository.getKnownHostsRepositoryID();
                        }
                        String string6 = string5;
                        if (string5 == null) {
                            string6 = "known_hosts";
                        }
                        if (this.userinfo != null) {
                            string6 = "WARNING: REMOTE HOST IDENTIFICATION HAS CHANGED!\nIT IS POSSIBLE THAT SOMEONE IS DOING SOMETHING NASTY!\nSomeone could be eavesdropping on you right now (man-in-the-middle attack)!\nIt is also possible that the " + string2 + " host key has just been changed.\n" + "The fingerprint for the " + string2 + " key sent by the remote host " + (String)hostKeyArray + " is\n" + string4 + ".\n" + "Please contact your system administrator.\n" + "Add correct host key in " + string6 + " to get rid of this message.";
                            if (string3.equals("ask")) {
                                bl = this.userinfo.promptYesNo(string6 + "\nDo you want to delete the old key and insert the new key?");
                            } else {
                                bl = false;
                                this.userinfo.showMessage(string6);
                            }
                        } else {
                            bl = false;
                        }
                        if (!bl) throw new JSchException("HostKey has been changed: " + (String)hostKeyArray);
                        synchronized (hostKeyRepository) {
                            hostKeyRepository.remove((String)hostKeyArray, ((KeyExchange)object).getKeyAlgorithName(), null);
                            n = 1;
                        }
                    }
                }
                if (string3.equals("ask")) break block37;
                n2 = n;
                if (!string3.equals("yes")) break block38;
            }
            n2 = n;
            if (n3 != 0) {
                n2 = n;
                if (n == 0) {
                    if (string3.equals("yes")) throw new JSchException("reject HostKey: " + this.host);
                    if (this.userinfo == null) {
                        if (n3 != 1) throw new JSchException("HostKey has been changed: " + this.host);
                        throw new JSchException("UnknownHostKey: " + this.host + ". " + string2 + " key fingerprint is " + string4);
                    }
                    if (!this.userinfo.promptYesNo("The authenticity of host '" + this.host + "' can't be established.\n" + string2 + " key fingerprint is " + string4 + ".\n" + "Are you sure you want to continue connecting?")) throw new JSchException("reject HostKey: " + this.host);
                    n2 = 1;
                }
            }
        }
        n = n2;
        if (string3.equals("no")) {
            n = n2;
            if (1 == n3) {
                n = 1;
            }
        }
        if (n3 == 0) {
            hostKeyArray = hostKeyRepository.getHostKey((String)hostKeyArray, ((KeyExchange)object).getKeyAlgorithName());
            object = Util.byte2str(Util.toBase64(byArray, 0, byArray.length));
            for (n2 = 0; n2 < hostKeyArray.length; ++n2) {
                if (!hostKeyArray[n3].getKey().equals(object) || !hostKeyArray[n2].getMarker().equals("@revoked")) continue;
                if (this.userinfo != null) {
                    this.userinfo.showMessage("The " + string2 + " host key for " + this.host + " is marked as revoked.\n" + "This could mean that a stolen key is being used to " + "impersonate this host.");
                }
                if (!JSch.getLogger().isEnabled(1)) throw new JSchException("revoked HostKey: " + this.host);
                JSch.getLogger().log(1, "Host '" + this.host + "' has provided revoked key.");
                throw new JSchException("revoked HostKey: " + this.host);
            }
        }
        if (n3 == 0 && JSch.getLogger().isEnabled(1)) {
            JSch.getLogger().log(1, "Host '" + this.host + "' is known and matches the " + string2 + " host key");
        }
        if (n != 0 && JSch.getLogger().isEnabled(2)) {
            JSch.getLogger().log(2, "Permanently added '" + this.host + "' (" + string2 + ") to the list of known hosts.");
        }
        if (n == 0) return;
        synchronized (hostKeyRepository) {
            hostKeyRepository.add(this.hostkey, this.userinfo);
            return;
        }
    }

    static boolean checkKex(Session session, String object) {
        try {
            object = (KeyExchange)Class.forName((String)object).newInstance();
            KeyExchange keyExchange = (KeyExchange)object;
            ((KeyExchange)object).init(session, null, null, null, null);
            return true;
        }
        catch (Exception exception) {
            return false;
        }
    }

    private String[] checkKexes(String stringArray) {
        if (stringArray != null && stringArray.length() != 0) {
            int n;
            if (JSch.getLogger().isEnabled(1)) {
                JSch.getLogger().log(1, "CheckKexes: " + (String)stringArray);
            }
            Vector<String> vector = new Vector<String>();
            stringArray = Util.split((String)stringArray, ",");
            for (n = 0; n < stringArray.length; ++n) {
                if (Session.checkKex(this, this.getConfig(stringArray[n]))) continue;
                vector.addElement(stringArray[n]);
            }
            if (vector.size() == 0) {
                return null;
            }
            stringArray = new String[vector.size()];
            System.arraycopy(vector.toArray(), 0, stringArray, 0, vector.size());
            if (JSch.getLogger().isEnabled(1)) {
                for (n = 0; n < stringArray.length; ++n) {
                    JSch.getLogger().log(1, stringArray[n] + " is not available.");
                }
            }
            return stringArray;
        }
        return null;
    }

    private String[] checkSignatures(String stringArray) {
        if (stringArray != null && stringArray.length() != 0) {
            int n;
            if (JSch.getLogger().isEnabled(1)) {
                JSch.getLogger().log(1, "CheckSignatures: " + (String)stringArray);
            }
            Vector<String> vector = new Vector<String>();
            stringArray = Util.split((String)stringArray, ",");
            for (n = 0; n < stringArray.length; ++n) {
                try {
                    Signature signature;
                    Signature signature2 = signature = (Signature)Class.forName(JSch.getConfig(stringArray[n])).newInstance();
                    signature.init();
                    continue;
                }
                catch (Exception exception) {
                    vector.addElement(stringArray[n]);
                }
            }
            if (vector.size() == 0) {
                return null;
            }
            stringArray = new String[vector.size()];
            System.arraycopy(vector.toArray(), 0, stringArray, 0, vector.size());
            if (JSch.getLogger().isEnabled(1)) {
                for (n = 0; n < stringArray.length; ++n) {
                    JSch.getLogger().log(1, stringArray[n] + " is not available.");
                }
            }
            return stringArray;
        }
        return null;
    }

    private byte[] expandKey(Buffer buffer, byte[] byArray, byte[] byArray2, byte[] byArray3, HASH hASH, int n) throws Exception {
        int n2 = hASH.getBlockSize();
        while (byArray3.length < n) {
            buffer.reset();
            buffer.putMPInt(byArray);
            buffer.putByte(byArray2);
            buffer.putByte(byArray3);
            hASH.update(buffer.buffer, 0, buffer.index);
            byte[] byArray4 = new byte[byArray3.length + n2];
            System.arraycopy(byArray3, 0, byArray4, 0, byArray3.length);
            System.arraycopy(hASH.digest(), 0, byArray4, byArray3.length, n2);
            Util.bzero(byArray3);
            byArray3 = byArray4;
        }
        return byArray3;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void initDeflater(String object) throws JSchException {
        if (((String)object).equals("none")) {
            this.deflater = null;
            return;
        }
        Object object2 = this.getConfig((String)object);
        if (object2 == null) return;
        if (!((String)object).equals("zlib")) {
            if (!this.isAuthed) return;
            if (!((String)object).equals("zlib@openssh.com")) return;
        }
        try {
            int n;
            int n2;
            try {
                object = (Compression)Class.forName((String)object2).newInstance();
                object2 = (Compression)object;
                this.deflater = object;
                n2 = 6;
            }
            catch (Exception exception) {
                throw new JSchException(exception.toString(), exception);
            }
            try {
                n = Integer.parseInt(this.getConfig("compression_level"));
            }
            catch (Exception exception) {
                n = n2;
            }
            {
                this.deflater.init(1, n);
                return;
            }
        }
        catch (NoClassDefFoundError noClassDefFoundError) {
            throw new JSchException(noClassDefFoundError.toString(), noClassDefFoundError);
        }
    }

    private void initInflater(String object) throws JSchException {
        if (((String)object).equals("none")) {
            this.inflater = null;
            return;
        }
        Object object2 = this.getConfig((String)object);
        if (object2 != null && (((String)object).equals("zlib") || this.isAuthed && ((String)object).equals("zlib@openssh.com"))) {
            try {
                object = (Compression)Class.forName((String)object2).newInstance();
                object2 = (Compression)object;
                this.inflater = object;
                this.inflater.init(0, 0);
            }
            catch (Exception exception) {
                throw new JSchException(exception.toString(), exception);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Forwarding parseForwarding(String object) throws JSchException {
        Object object2;
        int n;
        Object object3 = ((String)object).split(" ");
        if (((String[])object3).length > 1) {
            object = new Vector<String>();
            for (n = 0; n < ((String[])object3).length; ++n) {
                if (object3[n].length() == 0) continue;
                ((Vector)object).addElement(object3[n].trim());
            }
            object2 = new StringBuffer();
            for (n = 0; n < ((Vector)object).size(); ++n) {
                String string2 = (String)((Vector)object).elementAt(n);
                object3 = string2;
                ((StringBuffer)object2).append(string2);
                if (n + 1 >= ((Vector)object).size()) continue;
                ((StringBuffer)object2).append(":");
            }
            object = ((StringBuffer)object2).toString();
        }
        object2 = new Forwarding(this);
        try {
            block13: {
                block12: {
                    if (((String)object).lastIndexOf(":") == -1) {
                        object3 = new StringBuilder();
                        object2 = new JSchException(((StringBuilder)object3).append("parseForwarding: ").append((String)object).toString());
                        throw object2;
                    }
                    ((Forwarding)object2).hostport = Integer.parseInt(((String)object).substring(((String)object).lastIndexOf(":") + 1));
                    object3 = ((String)object).substring(0, ((String)object).lastIndexOf(":"));
                    if (((String)object3).lastIndexOf(":") == -1) {
                        object2 = new StringBuilder();
                        object3 = new JSchException(((StringBuilder)object2).append("parseForwarding: ").append((String)object).toString());
                        throw object3;
                    }
                    ((Forwarding)object2).host = ((String)object3).substring(((String)object3).lastIndexOf(":") + 1);
                    object = ((String)object3).substring(0, ((String)object3).lastIndexOf(":"));
                    n = ((String)object).lastIndexOf(":");
                    if (n == -1) {
                        ((Forwarding)object2).port = Integer.parseInt((String)object);
                        ((Forwarding)object2).bind_address = "127.0.0.1";
                        return object2;
                    }
                    ((Forwarding)object2).port = Integer.parseInt(((String)object).substring(((String)object).lastIndexOf(":") + 1));
                    object3 = ((String)object).substring(0, ((String)object).lastIndexOf(":"));
                    if (((String)object3).length() == 0) break block12;
                    object = object3;
                    if (!((String)object3).equals("*")) break block13;
                }
                object = "0.0.0.0";
            }
            object3 = object;
            if (((String)object).equals("localhost")) {
                object3 = "127.0.0.1";
            }
            ((Forwarding)object2).bind_address = object3;
            return object2;
        }
        catch (NumberFormatException numberFormatException) {
            throw new JSchException("parseForwarding: " + numberFormatException.toString());
        }
    }

    private KeyExchange receive_kexinit(Buffer object) throws Exception {
        int n = ((Buffer)object).getInt();
        if (n != ((Buffer)object).getLength()) {
            ((Buffer)object).getByte();
            this.I_S = new byte[((Buffer)object).index - 5];
        } else {
            this.I_S = new byte[n - 1 - ((Buffer)object).getByte()];
        }
        System.arraycopy(((Buffer)object).buffer, ((Buffer)object).s, this.I_S, 0, this.I_S.length);
        if (!this.in_kex) {
            this.send_kexinit();
        }
        this.guess = KeyExchange.guess(this.I_S, this.I_C);
        if (this.guess != null) {
            KeyExchange keyExchange;
            if (!this.isAuthed && (this.guess[2].equals("none") || this.guess[3].equals("none"))) {
                throw new JSchException("NONE Cipher should not be chosen before authentification is successed.");
            }
            try {
                keyExchange = (KeyExchange)Class.forName(this.getConfig(this.guess[0])).newInstance();
                object = keyExchange;
            }
            catch (Exception exception) {
                throw new JSchException(exception.toString(), exception);
            }
            keyExchange.init(this, this.V_S, this.V_C, this.I_S, this.I_C);
            return keyExchange;
        }
        throw new JSchException("Algorithm negotiation fail");
    }

    private void receive_newkeys(Buffer buffer, KeyExchange keyExchange) throws Exception {
        this.updateKeys(keyExchange);
        this.in_kex = false;
    }

    private void requestPortForwarding() throws JSchException {
        int n;
        if (this.getConfig("ClearAllForwardings").equals("yes")) {
            return;
        }
        String[] stringArray = this.jsch.getConfigRepository();
        if (stringArray == null) {
            return;
        }
        ConfigRepository.Config config = stringArray.getConfig(this.org_host);
        if ((stringArray = config.getValues("LocalForward")) != null) {
            for (n = 0; n < stringArray.length; ++n) {
                this.setPortForwardingL(stringArray[n]);
            }
        }
        if ((stringArray = config.getValues("RemoteForward")) != null) {
            for (n = 0; n < stringArray.length; ++n) {
                this.setPortForwardingR(stringArray[n]);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void send_kexinit() throws Exception {
        if (this.in_kex) {
            return;
        }
        Object object = this.getConfig("cipher.c2s");
        String string2 = this.getConfig("cipher.s2c");
        Object object2 = this.checkCiphers(this.getConfig("CheckCiphers"));
        String[] stringArray = object;
        String string3 = string2;
        if (object2 != null) {
            stringArray = object;
            string3 = string2;
            if (((String[])object2).length > 0) {
                stringArray = Util.diffString((String)object, object2);
                string3 = Util.diffString(string2, object2);
                if (stringArray == null || string3 == null) {
                    throw new JSchException("There are not any available ciphers.");
                }
            }
        }
        object = this.getConfig("kex");
        object2 = this.checkKexes(this.getConfig("CheckKexes"));
        string2 = object;
        if (object2 != null) {
            string2 = object;
            if (((String[])object2).length > 0 && (string2 = Util.diffString((String)object, object2)) == null) {
                throw new JSchException("There are not any available kexes.");
            }
        }
        object2 = this.getConfig("server_host_key");
        Object object3 = this.checkSignatures(this.getConfig("CheckSignatures"));
        object = object2;
        if (object3 != null) {
            object = object2;
            if (((String[])object3).length > 0 && (object = Util.diffString((String)object2, (String[])object3)) == null) {
                throw new JSchException("There are not any available sig algorithm.");
            }
        }
        this.in_kex = true;
        this.kex_start_time = System.currentTimeMillis();
        object3 = new Buffer();
        Packet packet = new Packet((Buffer)object3);
        packet.reset();
        ((Buffer)object3).putByte((byte)20);
        object2 = random;
        synchronized (object2) {
            random.fill(((Buffer)object3).buffer, ((Buffer)object3).index, 16);
            ((Buffer)object3).skip(16);
        }
        ((Buffer)object3).putString(Util.str2byte(string2));
        ((Buffer)object3).putString(Util.str2byte((String)object));
        ((Buffer)object3).putString(Util.str2byte((String)stringArray));
        ((Buffer)object3).putString(Util.str2byte(string3));
        ((Buffer)object3).putString(Util.str2byte(this.getConfig("mac.c2s")));
        ((Buffer)object3).putString(Util.str2byte(this.getConfig("mac.s2c")));
        ((Buffer)object3).putString(Util.str2byte(this.getConfig("compression.c2s")));
        ((Buffer)object3).putString(Util.str2byte(this.getConfig("compression.s2c")));
        ((Buffer)object3).putString(Util.str2byte(this.getConfig("lang.c2s")));
        ((Buffer)object3).putString(Util.str2byte(this.getConfig("lang.s2c")));
        ((Buffer)object3).putByte((byte)0);
        ((Buffer)object3).putInt(0);
        ((Buffer)object3).setOffSet(5);
        this.I_C = new byte[((Buffer)object3).getLength()];
        ((Buffer)object3).getByte(this.I_C);
        this.write(packet);
        if (JSch.getLogger().isEnabled(1)) {
            JSch.getLogger().log(1, "SSH_MSG_KEXINIT sent");
        }
    }

    private void send_newkeys() throws Exception {
        this.packet.reset();
        this.buf.putByte((byte)21);
        this.write(this.packet);
        if (JSch.getLogger().isEnabled(1)) {
            JSch.getLogger().log(1, "SSH_MSG_NEWKEYS sent");
        }
    }

    private void start_discard(Buffer buffer, Cipher object, MAC mAC, int n, int n2) throws JSchException, IOException {
        Object var6_6 = null;
        if (object.isCBC()) {
            object = var6_6;
            if (n != 262144) {
                object = var6_6;
                if (mAC != null) {
                    object = mAC;
                }
            }
            for (n = n2 - buffer.index; n > 0; n -= n2) {
                buffer.reset();
                n2 = n > buffer.buffer.length ? buffer.buffer.length : n;
                this.io.getByte(buffer.buffer, 0, n2);
                if (object == null) continue;
                object.update(buffer.buffer, 0, n2);
            }
            if (object != null) {
                object.doFinal(buffer.buffer, 0);
            }
            throw new JSchException("Packet corrupt");
        }
        throw new JSchException("Packet corrupt");
    }

    private void updateKeys(KeyExchange object) throws Exception {
        byte[] byArray = ((KeyExchange)object).getK();
        byte[] byArray2 = ((KeyExchange)object).getH();
        object = ((KeyExchange)object).getHash();
        if (this.session_id == null) {
            this.session_id = new byte[byArray2.length];
            System.arraycopy(byArray2, 0, this.session_id, 0, byArray2.length);
        }
        this.buf.reset();
        this.buf.putMPInt(byArray);
        this.buf.putByte(byArray2);
        this.buf.putByte((byte)65);
        this.buf.putByte(this.session_id);
        object.update(this.buf.buffer, 0, this.buf.index);
        this.IVc2s = object.digest();
        int n = this.buf.index - this.session_id.length - 1;
        Object object2 = this.buf.buffer;
        object2[n] = (byte)(object2[n] + 1);
        object.update(this.buf.buffer, 0, this.buf.index);
        this.IVs2c = object.digest();
        object2 = this.buf.buffer;
        object2[n] = (byte)(object2[n] + 1);
        object.update(this.buf.buffer, 0, this.buf.index);
        this.Ec2s = object.digest();
        object2 = this.buf.buffer;
        object2[n] = (byte)(object2[n] + 1);
        object.update(this.buf.buffer, 0, this.buf.index);
        this.Es2c = object.digest();
        object2 = this.buf.buffer;
        object2[n] = (byte)(object2[n] + 1);
        object.update(this.buf.buffer, 0, this.buf.index);
        this.MACc2s = object.digest();
        object2 = this.buf.buffer;
        object2[n] = (byte)(object2[n] + 1);
        object.update(this.buf.buffer, 0, this.buf.index);
        this.MACs2c = object.digest();
        try {
            object2 = (Cipher)Class.forName(this.getConfig(this.guess[3])).newInstance();
            Object object3 = (Cipher)object2;
            this.s2ccipher = object2;
            while (this.s2ccipher.getBlockSize() > this.Es2c.length) {
                this.buf.reset();
                this.buf.putMPInt(byArray);
                this.buf.putByte(byArray2);
                this.buf.putByte(this.Es2c);
                object.update(this.buf.buffer, 0, this.buf.index);
                object3 = object.digest();
                object2 = new byte[this.Es2c.length + ((Object)object3).length];
                System.arraycopy(this.Es2c, 0, object2, 0, this.Es2c.length);
                System.arraycopy(object3, 0, object2, this.Es2c.length, ((Object)object3).length);
                this.Es2c = object2;
            }
            this.s2ccipher.init(1, this.Es2c, this.IVs2c);
            this.s2ccipher_size = this.s2ccipher.getIVSize();
            object3 = (MAC)Class.forName(this.getConfig(this.guess[5])).newInstance();
            object2 = (MAC)object3;
            this.s2cmac = object3;
            this.MACs2c = this.expandKey(this.buf, byArray, byArray2, this.MACs2c, (HASH)object, this.s2cmac.getBlockSize());
            this.s2cmac.init(this.MACs2c);
            this.s2cmac_result1 = new byte[this.s2cmac.getBlockSize()];
            this.s2cmac_result2 = new byte[this.s2cmac.getBlockSize()];
            object3 = (Cipher)Class.forName(this.getConfig(this.guess[2])).newInstance();
            object2 = (Cipher)object3;
            this.c2scipher = object3;
            while (this.c2scipher.getBlockSize() > this.Ec2s.length) {
                this.buf.reset();
                this.buf.putMPInt(byArray);
                this.buf.putByte(byArray2);
                this.buf.putByte(this.Ec2s);
                object.update(this.buf.buffer, 0, this.buf.index);
                object2 = object.digest();
                object3 = new byte[this.Ec2s.length + ((byte[])object2).length];
                System.arraycopy(this.Ec2s, 0, object3, 0, this.Ec2s.length);
                System.arraycopy(object2, 0, object3, this.Ec2s.length, ((byte[])object2).length);
                this.Ec2s = (byte[])object3;
            }
            this.c2scipher.init(0, this.Ec2s, this.IVc2s);
            this.c2scipher_size = this.c2scipher.getIVSize();
            object3 = (MAC)Class.forName(this.getConfig(this.guess[4])).newInstance();
            object2 = (MAC)object3;
            this.c2smac = object3;
            this.MACc2s = this.expandKey(this.buf, byArray, byArray2, this.MACc2s, (HASH)object, this.c2smac.getBlockSize());
            this.c2smac.init(this.MACc2s);
            this.initDeflater(this.guess[6]);
            this.initInflater(this.guess[7]);
            return;
        }
        catch (Exception exception) {
            if (exception instanceof JSchException) {
                throw exception;
            }
            throw new JSchException(exception.toString(), exception);
        }
    }

    void addChannel(Channel channel) {
        channel.setSession(this);
    }

    public void connect() throws JSchException {
        this.connect(this.timeout);
    }

    /*
     * Exception decompiling
     */
    public void connect(int var1_1) throws JSchException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 43[TRYBLOCK] [144 : 2172->2175)] java.lang.Throwable
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

    public void delPortForwardingL(int n) throws JSchException {
        this.delPortForwardingL("127.0.0.1", n);
    }

    public void delPortForwardingL(String string2, int n) throws JSchException {
        PortWatcher.delPort(this, string2, n);
    }

    public void delPortForwardingR(int n) throws JSchException {
        this.delPortForwardingR(null, n);
    }

    public void delPortForwardingR(String string2, int n) throws JSchException {
        ChannelForwardedTCPIP.delPort(this, string2, n);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void disconnect() {
        block19: {
            if (!this.isConnected) {
                return;
            }
            if (JSch.getLogger().isEnabled(1)) {
                JSch.getLogger().log(1, "Disconnecting from " + this.host + " port " + this.port);
            }
            Channel.disconnect(this);
            this.isConnected = false;
            PortWatcher.delPort(this);
            ChannelForwardedTCPIP.delPort(this);
            ChannelX11.removeFakedCookie(this);
            Object object = this.lock;
            synchronized (object) {
                if (this.connectThread != null) {
                    Thread.yield();
                    this.connectThread.interrupt();
                    this.connectThread = null;
                }
            }
            this.thread = null;
            try {
                if (this.io != null) {
                    if (this.io.in != null) {
                        this.io.in.close();
                    }
                    if (this.io.out != null) {
                        this.io.out.close();
                    }
                    if (this.io.out_ext != null) {
                        this.io.out_ext.close();
                    }
                }
                if (this.proxy == null) {
                    if (this.socket != null) {
                        this.socket.close();
                    }
                    break block19;
                }
                Proxy proxy = this.proxy;
                synchronized (proxy) {
                    this.proxy.close();
                }
            }
            catch (Exception exception) {
                // empty catch block
                break block19;
            }
            {
                this.proxy = null;
            }
        }
        this.io = null;
        this.socket = null;
        this.jsch.removeSession(this);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void encode(Packet packet) throws Exception {
        Object object;
        if (this.deflater != null) {
            this.compress_len[0] = packet.buffer.index;
            packet.buffer.buffer = this.deflater.compress(packet.buffer.buffer, 5, this.compress_len);
            packet.buffer.index = this.compress_len[0];
        }
        if (this.c2scipher != null) {
            packet.padding(this.c2scipher_size);
            byte by = packet.buffer.buffer[4];
            object = random;
            synchronized (object) {
                random.fill(packet.buffer.buffer, packet.buffer.index - by, by);
            }
        } else {
            packet.padding(8);
        }
        if (this.c2smac != null) {
            this.c2smac.update(this.seqo);
            this.c2smac.update(packet.buffer.buffer, 0, packet.buffer.index);
            this.c2smac.doFinal(packet.buffer.buffer, packet.buffer.index);
        }
        if (this.c2scipher != null) {
            object = packet.buffer.buffer;
            this.c2scipher.update((byte[])object, 0, packet.buffer.index, (byte[])object, 0);
        }
        if (this.c2smac != null) {
            packet.buffer.skip(this.c2smac.getBlockSize());
        }
    }

    public String getClientVersion() {
        return Util.byte2str(this.V_C);
    }

    public String getConfig(String string2) {
        Object v;
        if (this.config != null && (v = this.config.get(string2)) instanceof String) {
            return (String)v;
        }
        if ((string2 = JSch.getConfig(string2)) instanceof String) {
            return string2;
        }
        return null;
    }

    public String getHost() {
        return this.host;
    }

    public HostKey getHostKey() {
        return this.hostkey;
    }

    public String getHostKeyAlias() {
        return this.hostKeyAlias;
    }

    public HostKeyRepository getHostKeyRepository() {
        if (this.hostkeyRepository == null) {
            return this.jsch.getHostKeyRepository();
        }
        return this.hostkeyRepository;
    }

    IdentityRepository getIdentityRepository() {
        if (this.identityRepository == null) {
            return this.jsch.getIdentityRepository();
        }
        return this.identityRepository;
    }

    public int getPort() {
        return this.port;
    }

    public String[] getPortForwardingL() throws JSchException {
        return PortWatcher.getPortForwarding(this);
    }

    public String[] getPortForwardingR() throws JSchException {
        return ChannelForwardedTCPIP.getPortForwarding(this);
    }

    public int getServerAliveCountMax() {
        return this.serverAliveCountMax;
    }

    public int getServerAliveInterval() {
        return this.serverAliveInterval;
    }

    public String getServerVersion() {
        return Util.byte2str(this.V_S);
    }

    byte[] getSessionId() {
        return this.session_id;
    }

    public Channel getStreamForwarder(String string2, int n) throws JSchException {
        ChannelDirectTCPIP channelDirectTCPIP = new ChannelDirectTCPIP();
        channelDirectTCPIP.init();
        this.addChannel(channelDirectTCPIP);
        channelDirectTCPIP.setHost(string2);
        channelDirectTCPIP.setPort(n);
        return channelDirectTCPIP;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public UserInfo getUserInfo() {
        return this.userinfo;
    }

    public String getUserName() {
        return this.username;
    }

    public boolean isConnected() {
        return this.isConnected;
    }

    public void noMoreSessionChannels() throws Exception {
        Buffer buffer = new Buffer();
        Packet packet = new Packet(buffer);
        packet.reset();
        buffer.putByte((byte)80);
        buffer.putString(nomoresessions);
        buffer.putByte((byte)0);
        this.write(packet);
    }

    public Channel openChannel(String object) throws JSchException {
        if (this.isConnected) {
            try {
                object = Channel.getChannel((String)object);
                this.addChannel((Channel)object);
                ((Channel)object).init();
                if (object instanceof ChannelSession) {
                    this.applyConfigChannel((ChannelSession)object);
                }
                return object;
            }
            catch (Exception exception) {
                return null;
            }
        }
        throw new JSchException("session is down");
    }

    public Buffer read(Buffer object) throws Exception {
        Object object2;
        int n;
        block18: {
            block17: {
                while (true) {
                    int n2;
                    ((Buffer)object).reset();
                    this.io.getByte(((Buffer)object).buffer, ((Buffer)object).index, this.s2ccipher_size);
                    ((Buffer)object).index += this.s2ccipher_size;
                    if (this.s2ccipher != null) {
                        this.s2ccipher.update(((Buffer)object).buffer, 0, this.s2ccipher_size, ((Buffer)object).buffer, 0);
                    }
                    if ((n2 = ((Buffer)object).buffer[0] << 24 & 0xFF000000 | ((Buffer)object).buffer[1] << 16 & 0xFF0000 | ((Buffer)object).buffer[2] << 8 & 0xFF00 | ((Buffer)object).buffer[3] & 0xFF) < 5 || n2 > 262144) {
                        this.start_discard((Buffer)object, this.s2ccipher, this.s2cmac, n2, 262144);
                    }
                    if (((Buffer)object).index + (n = n2 + 4 - this.s2ccipher_size) > ((Buffer)object).buffer.length) {
                        object2 = new byte[((Buffer)object).index + n];
                        System.arraycopy(((Buffer)object).buffer, 0, object2, 0, ((Buffer)object).index);
                        ((Buffer)object).buffer = object2;
                    }
                    if (n % this.s2ccipher_size != 0) {
                        object2 = "Bad packet length " + n;
                        if (JSch.getLogger().isEnabled(4)) {
                            JSch.getLogger().log(4, (String)object2);
                        }
                        this.start_discard((Buffer)object, this.s2ccipher, this.s2cmac, n2, 262144 - this.s2ccipher_size);
                    }
                    if (n > 0) {
                        this.io.getByte(((Buffer)object).buffer, ((Buffer)object).index, n);
                        ((Buffer)object).index += n;
                        if (this.s2ccipher != null) {
                            this.s2ccipher.update(((Buffer)object).buffer, this.s2ccipher_size, n, ((Buffer)object).buffer, this.s2ccipher_size);
                        }
                    }
                    if (this.s2cmac != null) {
                        this.s2cmac.update(this.seqi);
                        this.s2cmac.update(((Buffer)object).buffer, 0, ((Buffer)object).index);
                        this.s2cmac.doFinal(this.s2cmac_result1, 0);
                        this.io.getByte(this.s2cmac_result2, 0, this.s2cmac_result2.length);
                        if (!Arrays.equals(this.s2cmac_result1, this.s2cmac_result2)) {
                            if (n <= 262144) {
                                this.start_discard((Buffer)object, this.s2ccipher, this.s2cmac, n2, 262144 - n);
                                continue;
                            }
                            throw new IOException("MAC Error");
                        }
                    }
                    ++this.seqi;
                    if (this.inflater != null) {
                        n = ((Buffer)object).buffer[4];
                        this.uncompress_len[0] = ((Buffer)object).index - 5 - n;
                        object2 = this.inflater.uncompress(((Buffer)object).buffer, 5, this.uncompress_len);
                        if (object2 == null) {
                            System.err.println("fail in inflater");
                            break block17;
                        }
                        ((Buffer)object).buffer = object2;
                        ((Buffer)object).index = this.uncompress_len[0] + 5;
                    }
                    if ((n = ((Buffer)object).getCommand() & 0xFF) == 1) break block18;
                    if (n == 2) continue;
                    if (n == 3) {
                        ((Buffer)object).rewind();
                        ((Buffer)object).getInt();
                        ((Buffer)object).getShort();
                        n = ((Buffer)object).getInt();
                        if (!JSch.getLogger().isEnabled(1)) continue;
                        JSch.getLogger().log(1, "Received SSH_MSG_UNIMPLEMENTED for " + n);
                        continue;
                    }
                    if (n == 4) {
                        ((Buffer)object).rewind();
                        ((Buffer)object).getInt();
                        ((Buffer)object).getShort();
                        continue;
                    }
                    if (n != 93) break;
                    ((Buffer)object).rewind();
                    ((Buffer)object).getInt();
                    ((Buffer)object).getShort();
                    object2 = Channel.getChannel(((Buffer)object).getInt(), this);
                    if (object2 == null) continue;
                    object2.addRemoteWindowSize(((Buffer)object).getUInt());
                }
                if (n == 52) {
                    this.isAuthed = true;
                    if (this.inflater == null && this.deflater == null) {
                        this.initDeflater(this.guess[6]);
                        this.initInflater(this.guess[7]);
                    }
                }
            }
            ((Buffer)object).rewind();
            return object;
        }
        ((Buffer)object).rewind();
        ((Buffer)object).getInt();
        ((Buffer)object).getShort();
        n = ((Buffer)object).getInt();
        object2 = ((Buffer)object).getString();
        object = ((Buffer)object).getString();
        throw new JSchException("SSH_MSG_DISCONNECT: " + n + " " + Util.byte2str(object2) + " " + Util.byte2str((byte[])object));
    }

    public void rekey() throws Exception {
        this.send_kexinit();
    }

    /*
     * Exception decompiling
     */
    @Override
    public void run() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 23[TRYBLOCK] [26 : 813->816)] java.lang.Throwable
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

    public void sendIgnore() throws Exception {
        Buffer buffer = new Buffer();
        Packet packet = new Packet(buffer);
        packet.reset();
        buffer.putByte((byte)2);
        this.write(packet);
    }

    public void sendKeepAliveMsg() throws Exception {
        Buffer buffer = new Buffer();
        Packet packet = new Packet(buffer);
        packet.reset();
        buffer.putByte((byte)80);
        buffer.putString(keepalivemsg);
        buffer.putByte((byte)1);
        this.write(packet);
    }

    public void setClientVersion(String string2) {
        this.V_C = Util.str2byte(string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setConfig(String string2, String string3) {
        Object object = this.lock;
        synchronized (object) {
            if (this.config == null) {
                Hashtable hashtable;
                this.config = hashtable = new Hashtable();
            }
            this.config.put(string2, string3);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setConfig(Hashtable hashtable) {
        Object object = this.lock;
        synchronized (object) {
            Object object2;
            if (this.config == null) {
                object2 = new Hashtable();
                this.config = object2;
            }
            Enumeration enumeration = hashtable.keys();
            while (enumeration.hasMoreElements()) {
                object2 = (String)enumeration.nextElement();
                String string2 = (String)object2;
                Hashtable hashtable2 = this.config;
                String string3 = string2 = (String)hashtable.get(object2);
                hashtable2.put(object2, string2);
            }
            return;
        }
    }

    public void setConfig(Properties properties) {
        this.setConfig((Hashtable)properties);
    }

    public void setDaemonThread(boolean bl) {
        this.daemon_thread = bl;
    }

    public void setHost(String string2) {
        this.host = string2;
    }

    public void setHostKeyAlias(String string2) {
        this.hostKeyAlias = string2;
    }

    public void setHostKeyRepository(HostKeyRepository hostKeyRepository) {
        this.hostkeyRepository = hostKeyRepository;
    }

    public void setIdentityRepository(IdentityRepository identityRepository) {
        this.identityRepository = identityRepository;
    }

    public void setInputStream(InputStream inputStream) {
        this.in = inputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.out = outputStream;
    }

    public void setPassword(String string2) {
        if (string2 != null) {
            this.password = Util.str2byte(string2);
        }
    }

    public void setPassword(byte[] byArray) {
        if (byArray != null) {
            this.password = new byte[byArray.length];
            System.arraycopy(byArray, 0, this.password, 0, byArray.length);
        }
    }

    public void setPort(int n) {
        this.port = n;
    }

    public int setPortForwardingL(int n, String string2, int n2) throws JSchException {
        return this.setPortForwardingL("127.0.0.1", n, string2, n2);
    }

    public int setPortForwardingL(String object) throws JSchException {
        object = this.parseForwarding((String)object);
        return this.setPortForwardingL(((Forwarding)object).bind_address, ((Forwarding)object).port, ((Forwarding)object).host, ((Forwarding)object).hostport);
    }

    public int setPortForwardingL(String string2, int n, String string3, int n2) throws JSchException {
        return this.setPortForwardingL(string2, n, string3, n2, null);
    }

    public int setPortForwardingL(String string2, int n, String string3, int n2, ServerSocketFactory serverSocketFactory) throws JSchException {
        return this.setPortForwardingL(string2, n, string3, n2, serverSocketFactory, 0);
    }

    public int setPortForwardingL(String object, int n, String string2, int n2, ServerSocketFactory object2, int n3) throws JSchException {
        object2 = PortWatcher.addPort(this, (String)object, n, string2, n2, (ServerSocketFactory)object2);
        ((PortWatcher)object2).setConnectTimeout(n3);
        object = new Thread((Runnable)object2);
        ((Thread)object).setName("PortWatcher Thread for " + string2);
        if (this.daemon_thread) {
            ((Thread)object).setDaemon(this.daemon_thread);
        }
        ((Thread)object).start();
        return ((PortWatcher)object2).lport;
    }

    public int setPortForwardingR(String object) throws JSchException {
        object = this.parseForwarding((String)object);
        int n = this._setPortForwardingR(((Forwarding)object).bind_address, ((Forwarding)object).port);
        ChannelForwardedTCPIP.addPort(this, ((Forwarding)object).bind_address, ((Forwarding)object).port, n, ((Forwarding)object).host, ((Forwarding)object).hostport, null);
        return n;
    }

    public void setPortForwardingR(int n, String string2) throws JSchException {
        this.setPortForwardingR(null, n, string2, null);
    }

    public void setPortForwardingR(int n, String string2, int n2) throws JSchException {
        SocketFactory socketFactory = null;
        this.setPortForwardingR(null, n, string2, n2, null);
    }

    public void setPortForwardingR(int n, String string2, int n2, SocketFactory socketFactory) throws JSchException {
        this.setPortForwardingR(null, n, string2, n2, socketFactory);
    }

    public void setPortForwardingR(int n, String string2, Object[] objectArray) throws JSchException {
        this.setPortForwardingR(null, n, string2, objectArray);
    }

    public void setPortForwardingR(String string2, int n, String string3, int n2) throws JSchException {
        SocketFactory socketFactory = null;
        this.setPortForwardingR(string2, n, string3, n2, null);
    }

    public void setPortForwardingR(String string2, int n, String string3, int n2, SocketFactory socketFactory) throws JSchException {
        ChannelForwardedTCPIP.addPort(this, string2, n, this._setPortForwardingR(string2, n), string3, n2, socketFactory);
    }

    public void setPortForwardingR(String string2, int n, String string3, Object[] objectArray) throws JSchException {
        ChannelForwardedTCPIP.addPort(this, string2, n, this._setPortForwardingR(string2, n), string3, objectArray);
    }

    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }

    public void setServerAliveCountMax(int n) {
        this.serverAliveCountMax = n;
    }

    public void setServerAliveInterval(int n) throws JSchException {
        this.setTimeout(n);
        this.serverAliveInterval = n;
    }

    public void setSocketFactory(SocketFactory socketFactory) {
        this.socket_factory = socketFactory;
    }

    public void setTimeout(int n) throws JSchException {
        if (this.socket == null) {
            if (n >= 0) {
                this.timeout = n;
                return;
            }
            throw new JSchException("invalid timeout value");
        }
        try {
            this.socket.setSoTimeout(n);
            this.timeout = n;
            return;
        }
        catch (Exception exception) {
            if (exception instanceof Throwable) {
                throw new JSchException(exception.toString(), exception);
            }
            throw new JSchException(exception.toString());
        }
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userinfo = userInfo;
    }

    void setUserName(String string2) {
        this.username = string2;
    }

    public void setX11Cookie(String string2) {
        ChannelX11.setCookie(string2);
    }

    public void setX11Host(String string2) {
        ChannelX11.setHost(string2);
    }

    public void setX11Port(int n) {
        ChannelX11.setPort(n);
    }

    public void write(Packet packet) throws Exception {
        long l = this.getTimeout();
        while (this.in_kex) {
            if (l > 0L && System.currentTimeMillis() - this.kex_start_time > l && !this.in_prompt) {
                throw new JSchException("timeout in waiting for rekeying process.");
            }
            byte by = packet.buffer.getCommand();
            if (by == 20 || by == 21 || by == 30 || by == 31 || by == 31 || by == 32 || by == 33 || by == 34 || by == 1) break;
            try {
                Thread.sleep(10L);
            }
            catch (InterruptedException interruptedException) {}
        }
        this._write(packet);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    void write(Packet packet, Channel channel, int n) throws Exception {
        long l = this.getTimeout();
        int n2 = n;
        while (true) {
            int n3;
            block33: {
                block32: {
                    long l2;
                    block31: {
                        if (this.in_kex) {
                            if (l > 0L) {
                                if (System.currentTimeMillis() - this.kex_start_time > l) throw new JSchException("timeout in waiting for rekeying process.");
                            }
                            try {
                                Thread.sleep(10L);
                            }
                            catch (InterruptedException interruptedException) {}
                            continue;
                        }
                        // MONITORENTER : channel
                        l2 = channel.rwsize;
                        if (l2 < (long)n2) {
                            try {
                                channel.wait(100L);
                                n = ++channel.notifyme;
                            }
                            catch (Throwable throwable) {
                                --channel.notifyme;
                                throw throwable;
                            }
                            catch (InterruptedException interruptedException) {
                                n = channel.notifyme;
                            }
                            channel.notifyme = n - 1;
                        }
                        if (this.in_kex) {
                            // MONITOREXIT : channel
                            continue;
                        }
                        if (channel.rwsize < (long)n2) break block31;
                        channel.rwsize -= (long)n2;
                        // MONITOREXIT : channel
                        break block32;
                    }
                    // MONITOREXIT : channel
                    if (channel.close) throw new IOException("channel is broken");
                    if (!channel.isConnected()) throw new IOException("channel is broken");
                    n = 0;
                    int n4 = 0;
                    int n5 = 0;
                    byte by = 0;
                    int n6 = -1;
                    // MONITORENTER : channel
                    n3 = n2;
                    if (channel.rwsize > 0L) {
                        long l3;
                        l2 = l3 = channel.rwsize;
                        if (l3 > (long)n2) {
                            l2 = n2;
                        }
                        n = n5;
                        if (l2 != (long)n2) {
                            n6 = (int)l2;
                            n = this.c2scipher != null ? this.c2scipher_size : 8;
                            n3 = this.c2smac != null ? this.c2smac.getBlockSize() : 0;
                            n = packet.shift(n6, n, n3);
                        }
                        by = packet.buffer.getCommand();
                        n6 = channel.getRecipient();
                        n3 = (int)((long)n2 - l2);
                        channel.rwsize -= l2;
                        n2 = 1;
                        n4 = n;
                        n = n2;
                    }
                    // MONITOREXIT : channel
                    if (n != 0) {
                        this._write(packet);
                        if (n3 == 0) {
                            return;
                        }
                        packet.unshift(by, n6, n4, n3);
                    }
                    // MONITORENTER : channel
                    if (this.in_kex) {
                        // MONITOREXIT : channel
                        n2 = n3;
                        continue;
                    }
                    if (channel.rwsize < (long)n3) break block33;
                    channel.rwsize -= (long)n3;
                    // MONITOREXIT : channel
                }
                this._write(packet);
                return;
            }
            // MONITOREXIT : channel
            n2 = n3;
        }
    }

    private class Forwarding {
        String bind_address;
        String host;
        int hostport;
        int port;
        final Session this$0;

        private Forwarding(Session session) {
            this.this$0 = session;
            this.bind_address = null;
            this.port = -1;
            this.host = null;
            this.hostport = -1;
        }
    }

    private class GlobalRequestReply {
        private int port;
        private int reply;
        final Session this$0;
        private Thread thread;

        private GlobalRequestReply(Session session) {
            this.this$0 = session;
            this.thread = null;
            this.reply = -1;
            this.port = 0;
        }

        int getPort() {
            return this.port;
        }

        int getReply() {
            return this.reply;
        }

        Thread getThread() {
            return this.thread;
        }

        void setPort(int n) {
            this.port = n;
        }

        void setReply(int n) {
            this.reply = n;
        }

        void setThread(Thread thread) {
            this.thread = thread;
            this.reply = -1;
        }
    }
}

