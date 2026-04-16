/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.ConfigRepository;
import com.jcraft.jsch.Util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Hashtable;
import java.util.Vector;

public class OpenSSHConfig
implements ConfigRepository {
    private static final Hashtable keymap = new Hashtable();
    private final Hashtable config = new Hashtable();
    private final Vector hosts = new Vector();

    static {
        keymap.put("kex", "KexAlgorithms");
        keymap.put("server_host_key", "HostKeyAlgorithms");
        keymap.put("cipher.c2s", "Ciphers");
        keymap.put("cipher.s2c", "Ciphers");
        keymap.put("mac.c2s", "Macs");
        keymap.put("mac.s2c", "Macs");
        keymap.put("compression.s2c", "Compression");
        keymap.put("compression.c2s", "Compression");
        keymap.put("compression_level", "CompressionLevel");
        keymap.put("MaxAuthTries", "NumberOfPasswordPrompts");
    }

    OpenSSHConfig(Reader reader) throws IOException {
        this._parse(reader);
    }

    private void _parse(Reader vector) throws IOException {
        String[] stringArray;
        BufferedReader bufferedReader = new BufferedReader((Reader)((Object)vector));
        String string2 = "";
        vector = new Vector();
        while ((stringArray = bufferedReader.readLine()) != null) {
            if ((stringArray = stringArray.trim()).length() == 0 || stringArray.startsWith("#")) continue;
            stringArray = stringArray.split("[= \t]", 2);
            for (int i = 0; i < stringArray.length; ++i) {
                stringArray[i] = stringArray[i].trim();
            }
            if (stringArray.length <= 1) continue;
            if (stringArray[0].equals("Host")) {
                this.config.put(string2, vector);
                this.hosts.addElement(string2);
                string2 = stringArray[1];
                vector = new Vector<String[]>();
                continue;
            }
            vector.addElement(stringArray);
        }
        this.config.put(string2, vector);
        this.hosts.addElement(string2);
    }

    public static OpenSSHConfig parse(String object) throws IOException {
        object = new StringReader((String)object);
        try {
            OpenSSHConfig openSSHConfig = new OpenSSHConfig((Reader)object);
            return openSSHConfig;
        }
        finally {
            ((Reader)object).close();
        }
    }

    public static OpenSSHConfig parseFile(String object) throws IOException {
        object = new FileReader(Util.checkTilde((String)object));
        try {
            OpenSSHConfig openSSHConfig = new OpenSSHConfig((Reader)object);
            return openSSHConfig;
        }
        finally {
            ((Reader)object).close();
        }
    }

    @Override
    public ConfigRepository.Config getConfig(String string2) {
        return new MyConfig(this, string2);
    }

    class MyConfig
    implements ConfigRepository.Config {
        private Vector _configs;
        private String host;
        final OpenSSHConfig this$0;

        MyConfig(OpenSSHConfig openSSHConfig, String string2) {
            this.this$0 = openSSHConfig;
            this._configs = new Vector();
            this.host = string2;
            this._configs.addElement(openSSHConfig.config.get(""));
            byte[] byArray = Util.str2byte(string2);
            if (openSSHConfig.hosts.size() > 1) {
                for (int i = 1; i < openSSHConfig.hosts.size(); ++i) {
                    String[] stringArray = ((String)openSSHConfig.hosts.elementAt(i)).split("[ \t]");
                    for (int j = 0; j < stringArray.length; ++j) {
                        String string3;
                        boolean bl = false;
                        string2 = string3 = stringArray[j].trim();
                        if (string3.startsWith("!")) {
                            bl = true;
                            string2 = string3.substring(1).trim();
                        }
                        if (Util.glob(Util.str2byte(string2), byArray)) {
                            if (bl) continue;
                            this._configs.addElement(openSSHConfig.config.get((String)openSSHConfig.hosts.elementAt(i)));
                            continue;
                        }
                        if (!bl) continue;
                        this._configs.addElement(openSSHConfig.config.get((String)openSSHConfig.hosts.elementAt(i)));
                    }
                }
            }
        }

        private String find(String stringArray) {
            Object object = stringArray;
            if (keymap.get(stringArray) != null) {
                object = (String)keymap.get(stringArray);
            }
            String string2 = object.toUpperCase();
            stringArray = null;
            int n = 0;
            while (true) {
                object = stringArray;
                if (n >= this._configs.size()) break;
                Vector vector = (Vector)this._configs.elementAt(n);
                int n2 = 0;
                while (true) {
                    object = stringArray;
                    if (n2 >= vector.size()) break;
                    object = (String[])vector.elementAt(n2);
                    if (object[0].toUpperCase().equals(string2)) {
                        object = object[1];
                        break;
                    }
                    ++n2;
                }
                if (object != null) break;
                ++n;
                stringArray = object;
            }
            return object;
        }

        private String[] multiFind(String object) {
            String[] stringArray;
            String string2 = ((String)object).toUpperCase();
            object = new Vector();
            for (int i = 0; i < this._configs.size(); ++i) {
                stringArray = (Vector)this._configs.elementAt(i);
                for (int j = 0; j < stringArray.size(); ++j) {
                    Object object2 = (String[])stringArray.elementAt(j);
                    if (!object2[0].toUpperCase().equals(string2) || (object2 = object2[1]) == null) continue;
                    ((Vector)object).remove(object2);
                    ((Vector)object).addElement(object2);
                }
            }
            stringArray = new String[((Vector)object).size()];
            ((Vector)object).toArray(stringArray);
            return stringArray;
        }

        @Override
        public String getHostname() {
            return this.find("Hostname");
        }

        @Override
        public int getPort() {
            String string2 = this.find("Port");
            int n = -1;
            try {
                int n2;
                n = n2 = Integer.parseInt(string2);
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
            return n;
        }

        @Override
        public String getUser() {
            return this.find("User");
        }

        @Override
        public String getValue(String string2) {
            if (!string2.equals("compression.s2c") && !string2.equals("compression.c2s")) {
                return this.find(string2);
            }
            if ((string2 = this.find(string2)) != null && !string2.equals("no")) {
                return "zlib@openssh.com,zlib,none";
            }
            return "none,zlib@openssh.com,zlib";
        }

        @Override
        public String[] getValues(String string2) {
            return this.multiFind(string2);
        }
    }
}

