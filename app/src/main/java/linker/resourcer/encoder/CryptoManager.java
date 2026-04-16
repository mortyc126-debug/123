/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 */
package linker.resourcer.encoder;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import linker.resourcer.encoder.ConfigurationConstants;

public class CryptoManager {
    private static CryptoManager mp = null;

    private CryptoManager() {
    }

    private Cipher Get_Cifr(int n) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] byArray = this.getBytes(ConfigurationConstants.IV);
        cipher.init(n, this.Gnrat_Ky(), new IvParameterSpec(byArray));
        return cipher;
    }

    public static CryptoManager Getinstance() {
        synchronized (CryptoManager.class) {
            CryptoManager tcmypqsdhypcqijjdbpwgzrivmu2;
            if (mp == null) {
                mp = tcmypqsdhypcqijjdbpwgzrivmu2 = new CryptoManager();
            }
            tcmypqsdhypcqijjdbpwgzrivmu2 = mp;
            return tcmypqsdhypcqijjdbpwgzrivmu2;
        }
    }

    private Key Gnrat_Ky() throws Exception {
        return new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(ConfigurationConstants.PASSWORD.toCharArray(), this.getBytes(ConfigurationConstants.SALT), 65536, 128)).getEncoded(), "AES");
    }

    public String Dcrpt_Str(String string2) {
        try {
            Object object = Base64.decode((byte[])this.getBytes(string2), (int)2);
            object = new String(this.Get_Cifr(2).doFinal((byte[])object));
            return object;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return string2;
        }
    }

    public byte[] getBytes(String string2) throws UnsupportedEncodingException {
        return string2.getBytes("UTF-8");
    }
}

