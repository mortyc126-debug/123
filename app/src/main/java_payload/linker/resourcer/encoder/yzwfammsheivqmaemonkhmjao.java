/*
 * Decompiled with CFR 0.152.
 */
package linker.resourcer.encoder;

import java.io.UnsupportedEncodingException;

public class yzwfammsheivqmaemonkhmjao {
    public String Command = null;
    public byte[] byt = null;

    public yzwfammsheivqmaemonkhmjao(byte[] byArray, byte[] byArray2) {
        try {
            String string2;
            this.Command = string2 = new String(byArray, "UTF-8");
            this.byt = byArray2;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
        }
    }
}

