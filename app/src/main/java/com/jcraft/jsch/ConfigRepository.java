/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

public interface ConfigRepository {
    public static final Config defaultConfig = new Config(){

        @Override
        public String getHostname() {
            return null;
        }

        @Override
        public int getPort() {
            return -1;
        }

        @Override
        public String getUser() {
            return null;
        }

        @Override
        public String getValue(String string2) {
            return null;
        }

        @Override
        public String[] getValues(String string2) {
            return null;
        }
    };
    public static final ConfigRepository nullConfig = new ConfigRepository(){

        @Override
        public Config getConfig(String string2) {
            return defaultConfig;
        }
    };

    public Config getConfig(String var1);

    public static interface Config {
        public String getHostname();

        public int getPort();

        public String getUser();

        public String getValue(String var1);

        public String[] getValues(String var1);
    }
}

