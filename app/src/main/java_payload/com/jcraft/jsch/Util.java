/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.HASH;
import com.jcraft.jsch.JSchException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Vector;

class Util {
    private static final byte[] b64 = Util.str2byte("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=");
    private static String[] chars = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
    static final byte[] empty = Util.str2byte("");

    Util() {
    }

    static boolean array_equals(byte[] byArray, byte[] byArray2) {
        int n = byArray.length;
        if (n != byArray2.length) {
            return false;
        }
        for (int i = 0; i < n; ++i) {
            if (byArray[i] == byArray2[i]) continue;
            return false;
        }
        return true;
    }

    static String byte2str(byte[] byArray) {
        return Util.byte2str(byArray, 0, byArray.length, "UTF-8");
    }

    static String byte2str(byte[] byArray, int n, int n2) {
        return Util.byte2str(byArray, n, n2, "UTF-8");
    }

    static String byte2str(byte[] byArray, int n, int n2, String string2) {
        try {
            string2 = new String(byArray, n, n2, string2);
            return string2;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return new String(byArray, n, n2);
        }
    }

    static String byte2str(byte[] byArray, String string2) {
        return Util.byte2str(byArray, 0, byArray.length, string2);
    }

    static void bzero(byte[] byArray) {
        if (byArray == null) {
            return;
        }
        for (int i = 0; i < byArray.length; ++i) {
            byArray[i] = 0;
        }
    }

    static String checkTilde(String string2) {
        String string3 = string2;
        try {
            if (string2.startsWith("~")) {
                string3 = string2.replace("~", System.getProperty("user.home"));
            }
            string2 = string3;
        }
        catch (SecurityException securityException) {
            // empty catch block
        }
        return string2;
    }

    static Socket createSocket(String object, int n, int n2) throws JSchException {
        if (n2 == 0) {
            try {
                object = new Socket((String)object, n);
                return object;
            }
            catch (Exception exception) {
                String string2 = exception.toString();
                if (exception instanceof Throwable) {
                    throw new JSchException(string2, exception);
                }
                throw new JSchException(string2);
            }
        }
        Socket[] socketArray = new Socket[1];
        Exception[] exceptionArray = new Exception[1];
        String string3 = "";
        Thread thread = new Thread(new Runnable(socketArray, (String)object, n, exceptionArray){
            final String val$_host;
            final int val$_port;
            final Exception[] val$ee;
            final Socket[] val$sockp;
            {
                this.val$sockp = socketArray;
                this.val$_host = string2;
                this.val$_port = n;
                this.val$ee = exceptionArray;
            }

            @Override
            public void run() {
                this.val$sockp[0] = null;
                try {
                    Socket socket;
                    Socket[] socketArray = this.val$sockp;
                    socketArray[0] = socket = new Socket(this.val$_host, this.val$_port);
                }
                catch (Exception exception) {
                    this.val$ee[0] = exception;
                    if (this.val$sockp[0] != null && this.val$sockp[0].isConnected()) {
                        try {
                            this.val$sockp[0].close();
                        }
                        catch (Exception exception2) {
                            // empty catch block
                        }
                    }
                    this.val$sockp[0] = null;
                }
            }
        });
        thread.setName("Opening Socket " + (String)object);
        thread.start();
        long l = n2;
        try {
            thread.join(l);
            object = "timeout: ";
        }
        catch (InterruptedException interruptedException) {
            object = string3;
        }
        if (socketArray[0] != null && socketArray[0].isConnected()) {
            return socketArray[0];
        }
        object = (String)object + "socket is not established";
        if (exceptionArray[0] != null) {
            object = exceptionArray[0].toString();
        }
        thread.interrupt();
        throw new JSchException((String)object, exceptionArray[0]);
    }

    static String diffString(String string2, String[] stringArray) {
        String[] stringArray2 = Util.split(string2, ",");
        string2 = null;
        block0: for (int i = 0; i < stringArray2.length; ++i) {
            for (int j = 0; j < stringArray.length; ++j) {
                if (stringArray2[i].equals(stringArray[j])) continue block0;
            }
            string2 = string2 == null ? stringArray2[i] : string2 + "," + stringArray2[i];
        }
        return string2;
    }

    static byte[] fromBase64(byte[] byArray, int n, int n2) throws JSchException {
        int n3;
        byte[] byArray2 = new byte[n2];
        int n4 = 0;
        int n5 = n;
        while (true) {
            n3 = n4;
            if (n5 >= n + n2) break;
            byArray2[n4] = (byte)(Util.val(byArray[n5]) << 2 | (Util.val(byArray[n5 + 1]) & 0x30) >>> 4);
            if (byArray[n5 + 2] == 61) {
                n3 = n4 + 1;
                break;
            }
            byArray2[n4 + 1] = (byte)((Util.val(byArray[n5 + 1]) & 0xF) << 4 | (Util.val(byArray[n5 + 2]) & 0x3C) >>> 2);
            if (byArray[n5 + 3] == 61) {
                n3 = n4 + 2;
                break;
            }
            byArray2[n4 + 2] = (byte)((Util.val(byArray[n5 + 2]) & 3) << 6 | Util.val(byArray[n5 + 3]) & 0x3F);
            n4 += 3;
            n5 += 4;
            continue;
            break;
        }
        try {
            byArray = new byte[n3];
            System.arraycopy(byArray2, 0, byArray, 0, n3);
            return byArray;
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            throw new JSchException("fromBase64: invalid base64 data", arrayIndexOutOfBoundsException);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static byte[] fromFile(String object) throws IOException {
        int n;
        object = Util.checkTilde((String)object);
        Object object2 = new File((String)object);
        object = new FileInputStream((String)object);
        try {
            object2 = new byte[(int)((File)object2).length()];
            n = 0;
        }
        catch (Throwable throwable) {
            ((FileInputStream)object).close();
            throw throwable;
        }
        while (true) {
            int n2;
            if ((n2 = ((FileInputStream)object).read((byte[])object2, n, ((Object)object2).length - n)) <= 0) {
                ((FileInputStream)object).close();
                ((FileInputStream)object).close();
                return object2;
            }
            n += n2;
        }
    }

    static String getFingerPrint(HASH object, byte[] object2) {
        object.init();
        object.update((byte[])object2, 0, ((byte[])object2).length);
        object = object.digest();
        object2 = new StringBuffer;
        ((StringBuffer)object2)();
        int n = 0;
        while (true) {
            if (n >= ((Object)object).length) break;
            int n2 = object[n] & 0xFF;
            ((StringBuffer)object2).append(chars[n2 >>> 4 & 0xF]);
            ((StringBuffer)object2).append(chars[n2 & 0xF]);
            if (n + 1 < ((Object)object).length) {
                ((StringBuffer)object2).append(":");
            }
            ++n;
            continue;
            break;
        }
        try {
            object = ((StringBuffer)object2).toString();
            return object;
        }
        catch (Exception exception) {
            return "???";
        }
    }

    private static boolean glob(byte[] byArray, int n, byte[] byArray2, int n2) {
        int n3;
        int n4 = byArray.length;
        if (n4 == 0) {
            return false;
        }
        int n5 = byArray2.length;
        int n6 = n;
        n = n2;
        n2 = n6;
        while (true) {
            n6 = n2;
            n3 = n;
            if (n2 >= n4) break;
            n6 = n2;
            n3 = n;
            if (n >= n5) break;
            if (byArray[n2] == 92) {
                if (n2 + 1 == n4) {
                    return false;
                }
                if (byArray[++n2] != byArray2[n]) {
                    return false;
                }
                n2 += Util.skipUTF8Char(byArray[n2]);
                n += Util.skipUTF8Char(byArray2[n]);
                continue;
            }
            if (byArray[n2] == 42) {
                while (n2 < n4 && byArray[n2] == 42) {
                    ++n2;
                }
                if (n4 == n2) {
                    return true;
                }
                n3 = byArray[n2];
                if (n3 == 63) {
                    while (n < n5) {
                        if (Util.glob(byArray, n2, byArray2, n)) {
                            return true;
                        }
                        n += Util.skipUTF8Char(byArray2[n]);
                    }
                    return false;
                }
                if (n3 == 92) {
                    if (n2 + 1 == n4) {
                        return false;
                    }
                    byte by = byArray[++n2];
                    while (n < n5) {
                        if (by == byArray2[n] && Util.glob(byArray, Util.skipUTF8Char(by) + n2, byArray2, Util.skipUTF8Char(byArray2[n]) + n)) {
                            return true;
                        }
                        n += Util.skipUTF8Char(byArray2[n]);
                    }
                    return false;
                }
                for (n6 = n; n6 < n5; n6 += Util.skipUTF8Char(byArray2[n6])) {
                    if (n3 != byArray2[n6] || !Util.glob(byArray, n2, byArray2, n6)) continue;
                    return true;
                }
                return false;
            }
            if (byArray[n2] == 63) {
                ++n2;
                n += Util.skipUTF8Char(byArray2[n]);
                continue;
            }
            if (byArray[n2] != byArray2[n]) {
                return false;
            }
            n6 = n2 + Util.skipUTF8Char(byArray[n2]);
            n3 = n + Util.skipUTF8Char(byArray2[n]);
            n2 = n6;
            n = n3;
            if (n3 < n5) continue;
            if (n6 >= n4) {
                return true;
            }
            n2 = n6;
            n = n3;
            if (byArray[n6] == 42) break;
        }
        if (n6 == n4 && n3 == n5) {
            return true;
        }
        if (n3 >= n5 && byArray[n6] == 42) {
            boolean bl;
            boolean bl2 = true;
            while (true) {
                bl = bl2;
                if (n6 >= n4) break;
                if (byArray[n6] != 42) {
                    bl = false;
                    break;
                }
                ++n6;
            }
            return bl;
        }
        return false;
    }

    static boolean glob(byte[] byArray, byte[] byArray2) {
        return Util.glob0(byArray, 0, byArray2, 0);
    }

    private static boolean glob0(byte[] byArray, int n, byte[] byArray2, int n2) {
        if (byArray2.length > 0 && byArray2[0] == 46) {
            if (byArray.length > 0 && byArray[0] == 46) {
                if (byArray.length == 2 && byArray[1] == 42) {
                    return true;
                }
                return Util.glob(byArray, n + 1, byArray2, n2 + 1);
            }
            return false;
        }
        return Util.glob(byArray, n, byArray2, n2);
    }

    static String quote(String object) {
        int n;
        int n2;
        byte[] byArray = Util.str2byte((String)object);
        int n3 = 0;
        for (n2 = 0; n2 < byArray.length; ++n2) {
            block10: {
                block9: {
                    byte by = byArray[n2];
                    if (by == 92 || by == 63) break block9;
                    n = n3;
                    if (by != 42) break block10;
                }
                n = n3 + 1;
            }
            n3 = n;
        }
        if (n3 == 0) {
            return object;
        }
        object = new byte[byArray.length + n3];
        n2 = 0;
        for (n = 0; n < byArray.length; ++n) {
            byte by;
            block12: {
                block11: {
                    by = byArray[n];
                    if (by == 92 || by == 63) break block11;
                    n3 = n2;
                    if (by != 42) break block12;
                }
                object[n2] = 92;
                n3 = n2 + 1;
            }
            object[n3] = by;
            n2 = n3 + 1;
        }
        return Util.byte2str((byte[])object);
    }

    private static int skipUTF8Char(byte by) {
        if ((byte)(by & 0x80) == 0) {
            return 1;
        }
        if ((byte)(by & 0xE0) == -64) {
            return 2;
        }
        if ((byte)(by & 0xF0) == -32) {
            return 3;
        }
        return 1;
    }

    static String[] split(String string2, String stringArray) {
        int n;
        if (string2 == null) {
            return null;
        }
        Object object = Util.str2byte(string2);
        Vector<String> vector = new Vector<String>();
        int n2 = 0;
        while ((n = string2.indexOf((String)stringArray, n2)) >= 0) {
            vector.addElement(Util.byte2str(object, n2, n - n2));
            n2 = n + 1;
        }
        vector.addElement(Util.byte2str(object, n2, ((byte[])object).length - n2));
        stringArray = new String[vector.size()];
        for (n2 = 0; n2 < stringArray.length; ++n2) {
            object = (String)vector.elementAt(n2);
            string2 = (String)object;
            stringArray[n2] = object;
        }
        return stringArray;
    }

    static byte[] str2byte(String string2) {
        return Util.str2byte(string2, "UTF-8");
    }

    static byte[] str2byte(String string2, String object) {
        if (string2 == null) {
            return null;
        }
        try {
            object = string2.getBytes((String)object);
            return object;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return string2.getBytes();
        }
    }

    static byte[] toBase64(byte[] byArray, int n, int n2) {
        int n3;
        byte[] byArray2 = new byte[n2 * 2];
        int n4 = n2 / 3 * 3 + n;
        int n5 = 0;
        for (n3 = n; n3 < n4; n3 += 3) {
            byte by = byArray[n3];
            int n6 = n5 + 1;
            byArray2[n5] = b64[by >>> 2 & 0x3F];
            by = byArray[n3];
            byte by2 = byArray[n3 + 1];
            n5 = n6 + 1;
            byArray2[n6] = b64[(by & 3) << 4 | by2 >>> 4 & 0xF];
            by2 = byArray[n3 + 1];
            by = byArray[n3 + 2];
            n6 = n5 + 1;
            byArray2[n5] = b64[(by2 & 0xF) << 2 | by >>> 6 & 3];
            n5 = byArray[n3 + 2];
            byArray2[n6] = b64[n5 & 0x3F];
            n5 = n6 + 1;
        }
        if ((n2 = n + n2 - n4) == 1) {
            n2 = byArray[n3];
            n = n5 + 1;
            byArray2[n5] = b64[n2 >>> 2 & 0x3F];
            n5 = byArray[n3];
            n2 = n + 1;
            byArray2[n] = b64[(n5 & 3) << 4 & 0x3F];
            n = n2 + 1;
            byArray2[n2] = 61;
            byArray2[n] = 61;
            ++n;
        } else {
            n = n5;
            if (n2 == 2) {
                n2 = byArray[n3];
                n = n5 + 1;
                byArray2[n5] = b64[n2 >>> 2 & 0x3F];
                n4 = byArray[n3];
                n5 = byArray[n3 + 1];
                n2 = n + 1;
                byArray2[n] = b64[(n4 & 3) << 4 | n5 >>> 4 & 0xF];
                n = byArray[n3 + 1];
                n5 = n2 + 1;
                byArray2[n2] = b64[(n & 0xF) << 2 & 0x3F];
                byArray2[n5] = 61;
                n = n5 + 1;
            }
        }
        byArray = new byte[n];
        System.arraycopy(byArray2, 0, byArray, 0, n);
        return byArray;
    }

    static String toHex(byte[] byArray) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < byArray.length; ++i) {
            String string2 = Integer.toHexString(byArray[i] & 0xFF);
            StringBuilder stringBuilder = new StringBuilder().append("0x");
            String string3 = string2.length() == 1 ? "0" : "";
            stringBuffer.append(stringBuilder.append(string3).append(string2).toString());
            if (i + 1 >= byArray.length) continue;
            stringBuffer.append(":");
        }
        return stringBuffer.toString();
    }

    static String unquote(String string2) {
        byte[] byArray;
        byte[] byArray2 = Util.str2byte(string2);
        if (byArray2.length == (byArray = Util.unquote(byArray2)).length) {
            return string2;
        }
        return Util.byte2str(byArray);
    }

    static byte[] unquote(byte[] byArray) {
        int n = byArray.length;
        int n2 = 0;
        while (n2 < n) {
            if (byArray[n2] == 92) {
                if (n2 + 1 == n) break;
                System.arraycopy(byArray, n2 + 1, byArray, n2, byArray.length - (n2 + 1));
                --n;
                ++n2;
                continue;
            }
            ++n2;
        }
        if (n == byArray.length) {
            return byArray;
        }
        byte[] byArray2 = new byte[n];
        System.arraycopy(byArray, 0, byArray2, 0, n);
        return byArray2;
    }

    private static byte val(byte by) {
        if (by == 61) {
            return 0;
        }
        for (int i = 0; i < b64.length; ++i) {
            if (by != b64[i]) continue;
            return (byte)i;
        }
        return 0;
    }
}

