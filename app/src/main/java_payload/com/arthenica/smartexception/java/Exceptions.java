/*
 * Decompiled with CFR 0.152.
 */
package com.arthenica.smartexception.java;

import com.arthenica.smartexception.AbstractExceptions;
import com.arthenica.smartexception.ClassLoader;
import com.arthenica.smartexception.PackageLoader;
import com.arthenica.smartexception.StackTraceElementSerializer;
import com.arthenica.smartexception.ThrowableWrapper;
import com.arthenica.smartexception.java.JavaClassLoader;
import com.arthenica.smartexception.java.JavaPackageLoader;
import com.arthenica.smartexception.java.JavaStackTraceElementSerializer;
import java.util.Set;

public class Exceptions {
    static ClassLoader classLoader;
    static PackageLoader packageLoader;

    static {
        packageLoader = new JavaPackageLoader();
        classLoader = new JavaClassLoader();
        AbstractExceptions.setStackTraceElementSerializer(new JavaStackTraceElementSerializer());
    }

    public static void clearGroupPackages() {
        AbstractExceptions.clearGroupPackages();
    }

    public static void clearIgnorePackages() {
        AbstractExceptions.clearIgnorePackages();
    }

    public static void clearRootPackages() {
        AbstractExceptions.clearRootPackages();
    }

    public static boolean containsCause(Throwable throwable, Class<?> clazz) {
        return AbstractExceptions.containsCause(throwable, clazz);
    }

    public static boolean containsCause(Throwable throwable, Class<?> clazz, String string2) {
        return AbstractExceptions.containsCause(throwable, clazz, string2);
    }

    public static String getAllMessages(Throwable throwable) {
        return AbstractExceptions.getAllMessages(throwable);
    }

    public static Throwable getCause(Throwable throwable) {
        return AbstractExceptions.getCause(throwable);
    }

    public static Throwable getCause(Throwable throwable, int n) {
        return AbstractExceptions.getCause(throwable, n);
    }

    public static boolean getIgnoreAllCauses() {
        return AbstractExceptions.getIgnoreAllCauses();
    }

    public static boolean getPrintSuppressedExceptions() {
        return AbstractExceptions.getPrintSuppressedExceptions();
    }

    public static StackTraceElementSerializer getStackTraceElementSerializer() {
        return AbstractExceptions.getStackTraceElementSerializer();
    }

    public static String getStackTraceString(Throwable throwable) {
        return AbstractExceptions.getStackTraceString(new ThrowableWrapper(throwable));
    }

    public static String getStackTraceString(Throwable throwable, int n) {
        return AbstractExceptions.getStackTraceString(new ThrowableWrapper(throwable), n);
    }

    public static String getStackTraceString(Throwable throwable, int n, boolean bl) {
        return AbstractExceptions.getStackTraceString(new ThrowableWrapper(throwable), n, bl);
    }

    public static String getStackTraceString(Throwable throwable, int n, boolean bl, boolean bl2) {
        return AbstractExceptions.getStackTraceString(new ThrowableWrapper(throwable), n, bl, bl2);
    }

    public static String getStackTraceString(Throwable throwable, int n, boolean bl, boolean bl2, boolean bl3) {
        return AbstractExceptions.getStackTraceString(new ThrowableWrapper(throwable), n, bl, bl2, bl3);
    }

    public static String getStackTraceString(Throwable throwable, String string2) {
        return AbstractExceptions.getStackTraceString(new ThrowableWrapper(throwable), string2);
    }

    public static String getStackTraceString(Throwable throwable, String string2, String string3) {
        return AbstractExceptions.getStackTraceString(new ThrowableWrapper(throwable), string2, string3);
    }

    public static String getStackTraceString(Throwable throwable, Set<String> set, Set<String> set2, Set<String> set3) {
        return AbstractExceptions.getStackTraceString(new ThrowableWrapper(throwable), set, set2, set3);
    }

    public static String getStackTraceString(Throwable throwable, Set<String> set, Set<String> set2, Set<String> set3, boolean bl) {
        return AbstractExceptions.getStackTraceString(new ThrowableWrapper(throwable), set, set2, set3, bl);
    }

    public static String getStackTraceString(Throwable throwable, Set<String> set, Set<String> set2, Set<String> set3, boolean bl, boolean bl2) {
        return AbstractExceptions.getStackTraceString(new ThrowableWrapper(throwable), set, set2, set3, bl, bl2);
    }

    public static String getStackTraceString(Throwable throwable, Set<String> set, Set<String> set2, Set<String> set3, boolean bl, boolean bl2, boolean bl3) {
        return AbstractExceptions.getStackTraceString(new ThrowableWrapper(throwable), set, set2, set3, bl, bl2, bl3);
    }

    public static String getStackTraceString(Throwable throwable, boolean bl) {
        return AbstractExceptions.getStackTraceString(new ThrowableWrapper(throwable), bl);
    }

    public static boolean isPrintPackageInformation() {
        return AbstractExceptions.isPrintPackageInformation();
    }

    public static void registerGroupPackage(String string2) {
        AbstractExceptions.registerGroupPackage(string2);
    }

    public static void registerIgnorePackage(String string2, boolean bl) {
        AbstractExceptions.registerIgnorePackage(string2, bl);
    }

    public static void registerRootPackage(String string2) {
        AbstractExceptions.registerRootPackage(string2);
    }

    public static Throwable searchCause(Throwable throwable, Class<?> clazz) {
        return AbstractExceptions.searchCause(throwable, clazz);
    }

    public static Throwable searchCause(Throwable throwable, Class<?> clazz, int n) {
        return AbstractExceptions.searchCause(throwable, clazz, n);
    }

    public static Throwable searchCause(Throwable throwable, Class<?> clazz, String string2) {
        return AbstractExceptions.searchCause(throwable, clazz, string2);
    }

    public static Throwable searchCause(Throwable throwable, Class<?> clazz, String string2, int n) {
        return AbstractExceptions.searchCause(throwable, clazz, string2, n);
    }

    public static void setIgnoreAllCauses(boolean bl) {
        AbstractExceptions.setIgnoreAllCauses(bl);
    }

    public static void setPrintPackageInformation(boolean bl) {
        AbstractExceptions.setPrintPackageInformation(bl);
    }

    public static void setPrintSuppressedExceptions(boolean bl) {
        AbstractExceptions.setPrintSuppressedExceptions(bl);
    }

    public static void setStackTraceElementSerializer(StackTraceElementSerializer stackTraceElementSerializer) {
        AbstractExceptions.setStackTraceElementSerializer(stackTraceElementSerializer);
    }
}

