/*
 * Decompiled with CFR 0.152.
 */
package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.Utf8;
import androidx.emoji2.text.flatbuffer.Utf8Old$$ExternalSyntheticLambda0;
import androidx.emoji2.text.flatbuffer.Utf8Old$$ExternalSyntheticThreadLocal1;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.StandardCharsets;

public class Utf8Old
extends Utf8 {
    private static final ThreadLocal<Cache> CACHE = new Utf8Old$$ExternalSyntheticThreadLocal1(new Utf8Old$$ExternalSyntheticLambda0());

    static /* synthetic */ Cache lambda$static$0() {
        return new Cache();
    }

    @Override
    public String decodeUtf8(ByteBuffer object, int n, int n2) {
        CharsetDecoder charsetDecoder = Utf8Old.CACHE.get().decoder;
        charsetDecoder.reset();
        object = ((ByteBuffer)object).duplicate();
        ((ByteBuffer)object).position(n);
        ((ByteBuffer)object).limit(n + n2);
        try {
            object = charsetDecoder.decode((ByteBuffer)object).toString();
            return object;
        }
        catch (CharacterCodingException characterCodingException) {
            throw new IllegalArgumentException("Bad encoding", characterCodingException);
        }
    }

    @Override
    public void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        Cache cache2 = CACHE.get();
        if (cache2.lastInput != charSequence) {
            this.encodedLength(charSequence);
        }
        byteBuffer.put(cache2.lastOutput);
    }

    @Override
    public int encodedLength(CharSequence object) {
        Cache cache2 = CACHE.get();
        int n = (int)((float)object.length() * cache2.encoder.maxBytesPerChar());
        if (cache2.lastOutput == null || cache2.lastOutput.capacity() < n) {
            cache2.lastOutput = ByteBuffer.allocate(Math.max(128, n));
        }
        cache2.lastOutput.clear();
        cache2.lastInput = object;
        object = object instanceof CharBuffer ? (CharBuffer)object : CharBuffer.wrap((CharSequence)object);
        object = cache2.encoder.encode((CharBuffer)object, cache2.lastOutput, true);
        if (((CoderResult)object).isError()) {
            try {
                ((CoderResult)object).throwException();
            }
            catch (CharacterCodingException characterCodingException) {
                throw new IllegalArgumentException("bad character encoding", characterCodingException);
            }
        }
        cache2.lastOutput.flip();
        return cache2.lastOutput.remaining();
    }

    private static class Cache {
        final CharsetDecoder decoder;
        final CharsetEncoder encoder = StandardCharsets.UTF_8.newEncoder();
        CharSequence lastInput = null;
        ByteBuffer lastOutput = null;

        Cache() {
            this.decoder = StandardCharsets.UTF_8.newDecoder();
        }
    }
}

