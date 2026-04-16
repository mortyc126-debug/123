/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch.jgss;

import com.jcraft.jsch.GSSContext;
import com.jcraft.jsch.JSchException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.ietf.jgss.GSSException;
import org.ietf.jgss.GSSManager;
import org.ietf.jgss.MessageProp;
import org.ietf.jgss.Oid;

public class GSSContextKrb5
implements GSSContext {
    private static final String pUseSubjectCredsOnly = "javax.security.auth.useSubjectCredsOnly";
    private static String useSubjectCredsOnly = GSSContextKrb5.getSystemProperty("javax.security.auth.useSubjectCredsOnly");
    private org.ietf.jgss.GSSContext context = null;

    private static String getSystemProperty(String string2) {
        try {
            string2 = System.getProperty(string2);
            return string2;
        }
        catch (Exception exception) {
            return null;
        }
    }

    private static void setSystemProperty(String string2, String string3) {
        try {
            System.setProperty(string2, string3);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    public void create(String charSequence, String string2) throws JSchException {
        GSSManager gSSManager;
        Oid oid;
        Oid oid2;
        try {
            oid2 = new Oid("1.2.840.113554.1.2.2");
            oid = new Oid("1.2.840.113554.1.2.2.1");
            gSSManager = GSSManager.getInstance();
            try {
                charSequence = InetAddress.getByName(string2).getCanonicalHostName();
                string2 = charSequence;
            }
            catch (UnknownHostException unknownHostException) {
                // empty catch block
            }
        }
        catch (GSSException gSSException) {
            throw new JSchException(gSSException.toString());
        }
        charSequence = new StringBuilder();
        this.context = gSSManager.createContext(gSSManager.createName(((StringBuilder)charSequence).append("host/").append(string2).toString(), oid), oid2, null, 0);
        this.context.requestMutualAuth(true);
        this.context.requestConf(true);
        this.context.requestInteg(true);
        this.context.requestCredDeleg(true);
        this.context.requestAnonymity(false);
    }

    @Override
    public void dispose() {
        try {
            this.context.dispose();
        }
        catch (GSSException gSSException) {
            // empty catch block
        }
    }

    @Override
    public byte[] getMIC(byte[] byArray, int n, int n2) {
        try {
            MessageProp messageProp = new MessageProp(0, true);
            byArray = this.context.getMIC(byArray, n, n2, messageProp);
            return byArray;
        }
        catch (GSSException gSSException) {
            return null;
        }
    }

    /*
     * Exception decompiling
     */
    @Override
    public byte[] init(byte[] var1_1, int var2_5, int var3_6) throws JSchException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 1[TRYBLOCK] [6 : 46->63)] java.lang.Throwable
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

    @Override
    public boolean isEstablished() {
        return this.context.isEstablished();
    }
}

