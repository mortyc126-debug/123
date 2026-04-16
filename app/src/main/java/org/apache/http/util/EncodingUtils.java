package org.apache.http.util;

import java.io.UnsupportedEncodingException;
import org.apache.http.aaskrfyvhoypymnzlskbzwpyr;

/* JADX INFO: loaded from: classes2.dex */
public final class EncodingUtils {
    public static String getString(byte[] data, int offset, int length, String charset) {
        Args.notNull(data, "Input");
        Args.notEmpty(charset, "Charset");
        try {
            return new String(data, offset, length, charset);
        } catch (UnsupportedEncodingException e) {
            return new String(data, offset, length);
        }
    }

    public static String getString(byte[] data, String charset) {
        Args.notNull(data, "Input");
        return getString(data, 0, data.length, charset);
    }

    public static byte[] getBytes(String data, String charset) {
        Args.notNull(data, "Input");
        Args.notEmpty(charset, "Charset");
        try {
            return data.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            return data.getBytes();
        }
    }

    public static byte[] getAsciiBytes(String data) {
        Args.notNull(data, "Input");
        return data.getBytes(aaskrfyvhoypymnzlskbzwpyr.ASCII);
    }

    public static String getAsciiString(byte[] data, int offset, int length) {
        Args.notNull(data, "Input");
        return new String(data, offset, length, aaskrfyvhoypymnzlskbzwpyr.ASCII);
    }

    public static String getAsciiString(byte[] data) {
        Args.notNull(data, "Input");
        return getAsciiString(data, 0, data.length);
    }

    private EncodingUtils() {
    }
}
