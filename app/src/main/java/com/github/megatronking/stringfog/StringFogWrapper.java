package com.github.megatronking.stringfog;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes3.dex */
public final class StringFogWrapper implements IStringFog {
    private final IStringFog mStringFogImpl;

    public StringFogWrapper(String impl) {
        try {
            this.mStringFogImpl = (IStringFog) Class.forName(impl).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Stringfog implementation class not found: " + impl);
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new IllegalArgumentException("Stringfog implementation class create instance failed: " + e.getMessage());
        } catch (InstantiationException e3) {
            throw new IllegalArgumentException("Stringfog implementation class new instance failed: " + e3.getMessage());
        } catch (NoSuchMethodException e4) {
            e = e4;
            throw new IllegalArgumentException("Stringfog implementation class create instance failed: " + e.getMessage());
        } catch (InvocationTargetException e5) {
            e = e5;
            throw new IllegalArgumentException("Stringfog implementation class create instance failed: " + e.getMessage());
        }
    }

    @Override // com.github.megatronking.stringfog.IStringFog
    public byte[] encrypt(String data, byte[] key) {
        return this.mStringFogImpl == null ? data.getBytes() : this.mStringFogImpl.encrypt(data, key);
    }

    @Override // com.github.megatronking.stringfog.IStringFog
    public String decrypt(byte[] data, byte[] key) {
        return this.mStringFogImpl == null ? new String(data) : this.mStringFogImpl.decrypt(data, key);
    }

    @Override // com.github.megatronking.stringfog.IStringFog
    public boolean shouldFog(String data) {
        return this.mStringFogImpl != null && this.mStringFogImpl.shouldFog(data);
    }
}
