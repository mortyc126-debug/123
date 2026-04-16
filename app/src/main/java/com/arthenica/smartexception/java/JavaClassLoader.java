/*
 * Decompiled with CFR 0.152.
 */
package com.arthenica.smartexception.java;

import com.arthenica.smartexception.ClassLoader;

public class JavaClassLoader
implements ClassLoader {
    @Override
    public Class<?> loadClass(String object) {
        block14: {
            Class<?> clazz;
            block13: {
                clazz = Thread.currentThread().getContextClassLoader();
                if (clazz == null) break block13;
                try {
                    clazz = ((java.lang.ClassLoader)((Object)clazz)).loadClass((String)object);
                    return clazz;
                }
                catch (SecurityException securityException) {
                }
                catch (ClassNotFoundException classNotFoundException) {
                    // empty catch block
                }
            }
            clazz = java.lang.ClassLoader.getSystemClassLoader();
            if (clazz == null) break block14;
            try {
                clazz = ((java.lang.ClassLoader)((Object)clazz)).loadClass((String)object);
                return clazz;
            }
            catch (Error error) {
            }
            catch (IllegalStateException illegalStateException) {
            }
            catch (SecurityException securityException) {
            }
            catch (ClassNotFoundException classNotFoundException) {
                // empty catch block
            }
        }
        try {
            object = Class.forName((String)object);
            return object;
        }
        catch (LinkageError linkageError) {
        }
        catch (ClassNotFoundException classNotFoundException) {
            // empty catch block
        }
        return null;
    }
}

