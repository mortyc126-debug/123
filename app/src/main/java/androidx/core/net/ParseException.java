/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.net;

public class ParseException
extends RuntimeException {
    public final String response;

    ParseException(String string2) {
        super(string2);
        this.response = string2;
    }
}

