/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch.jce;

import com.jcraft.jsch.jce.SignatureECDSAN;

public class SignatureECDSA256
extends SignatureECDSAN {
    @Override
    String getName() {
        return "ecdsa-sha2-nistp256";
    }
}

