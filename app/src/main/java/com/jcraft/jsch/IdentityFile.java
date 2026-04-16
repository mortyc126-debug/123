/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.Identity;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.KeyPair;
import java.io.UnsupportedEncodingException;

class IdentityFile
implements Identity {
    private String identity;
    private JSch jsch;
    private KeyPair kpair;

    private IdentityFile(JSch jSch, String string2, KeyPair keyPair) throws JSchException {
        this.jsch = jSch;
        this.identity = string2;
        this.kpair = keyPair;
    }

    static IdentityFile newInstance(String string2, String string3, JSch jSch) throws JSchException {
        return new IdentityFile(jSch, string2, KeyPair.load(jSch, string2, string3));
    }

    static IdentityFile newInstance(String string2, byte[] byArray, byte[] byArray2, JSch jSch) throws JSchException {
        return new IdentityFile(jSch, string2, KeyPair.load(jSch, byArray, byArray2));
    }

    @Override
    public void clear() {
        this.kpair.dispose();
        this.kpair = null;
    }

    @Override
    public boolean decrypt() {
        throw new RuntimeException("not implemented");
    }

    @Override
    public String getAlgName() {
        byte[] byArray = this.kpair.getKeyTypeName();
        try {
            String string2 = new String(byArray, "UTF-8");
            return string2;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return new String(byArray);
        }
    }

    public KeyPair getKeyPair() {
        return this.kpair;
    }

    @Override
    public String getName() {
        return this.identity;
    }

    @Override
    public byte[] getPublicKeyBlob() {
        return this.kpair.getPublicKeyBlob();
    }

    @Override
    public byte[] getSignature(byte[] byArray) {
        return this.kpair.getSignature(byArray);
    }

    @Override
    public boolean isEncrypted() {
        return this.kpair.isEncrypted();
    }

    @Override
    public boolean setPassphrase(byte[] byArray) throws JSchException {
        return this.kpair.decrypt(byArray);
    }
}

