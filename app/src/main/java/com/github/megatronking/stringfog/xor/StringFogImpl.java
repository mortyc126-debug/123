package com.github.megatronking.stringfog.xor;

import com.github.megatronking.stringfog.IStringFog;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes3.dex */
public final class StringFogImpl implements IStringFog {
    @Override // com.github.megatronking.stringfog.IStringFog
    public byte[] encrypt(String data, byte[] key) {
        return xor(data.getBytes(StandardCharsets.UTF_8), key);
    }

    @Override // com.github.megatronking.stringfog.IStringFog
    public String decrypt(byte[] data, byte[] key) {
        return new String(xor(data, key), StandardCharsets.UTF_8);
    }

    @Override // com.github.megatronking.stringfog.IStringFog
    public boolean shouldFog(String data) {
        return true;
    }

    private static byte[] xor(byte[] data, byte[] key) {
        int len = data.length;
        int lenKey = key.length;
        int i = 0;
        int j2 = 0;
        while (i < len) {
            if (j2 >= lenKey) {
                j2 = 0;
            }
            data[i] = (byte) (data[i] ^ key[j2]);
            i++;
            j2++;
        }
        return data;
    }
}
