/*
 * Decompiled with CFR 0.152.
 */
package com.arthenica.smartexception.java;

import com.arthenica.smartexception.AbstractExceptions;
import com.arthenica.smartexception.PackageLoader;

public class JavaPackageLoader
implements PackageLoader {
    @Override
    public Package getPackage(ClassLoader classLoader, String string2) {
        return Package.getPackage(AbstractExceptions.packageName(string2));
    }
}

