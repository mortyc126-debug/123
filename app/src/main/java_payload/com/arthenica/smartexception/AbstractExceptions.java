/*
 * Decompiled with CFR 0.152.
 */
package com.arthenica.smartexception;

import com.arthenica.smartexception.PackageLoader;
import com.arthenica.smartexception.StackTraceElementSerializer;
import com.arthenica.smartexception.StackTraceElementWrapper;
import com.arthenica.smartexception.ThrowableWrapper;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractExceptions {
    public static final boolean DEFAULT_IGNORE_ALL_CAUSES = false;
    public static final int DEFAULT_MAX_DEPTH = 10;
    public static final boolean DEFAULT_PRINT_MODULE_NAME = true;
    public static final boolean DEFAULT_PRINT_PACKAGE_INFORMATION = false;
    public static final boolean DEFAULT_PRINT_SUPPRESSED_EXCEPTIONS = true;
    static final Set<String> groupPackageSet;
    static boolean ignoreAllCauses;
    static final Set<String> ignoreCausePackageSet;
    static final Set<String> ignorePackageSet;
    static boolean printModuleName;
    static boolean printPackageInformation;
    static boolean printSuppressedExceptions;
    static final Set<String> rootPackageSet;
    static StackTraceElementSerializer stackTraceElementSerializer;

    static {
        rootPackageSet = Collections.synchronizedSet(new HashSet());
        groupPackageSet = Collections.synchronizedSet(new HashSet());
        ignorePackageSet = Collections.synchronizedSet(new HashSet());
        ignoreCausePackageSet = Collections.synchronizedSet(new HashSet());
        ignoreAllCauses = false;
        printPackageInformation = false;
        printModuleName = true;
        printSuppressedExceptions = true;
    }

    public static int appendStackTraceGroupElement(StringBuilder stringBuilder, String string2, int n, StackTraceElement stackTraceElement, boolean bl, boolean bl2, String string3) {
        if (n > 0) {
            if (stackTraceElementSerializer != null) {
                stringBuilder.append(string3);
                if (n == 1) {
                    stringBuilder.append(stackTraceElementSerializer.toString(stackTraceElement, bl, bl2));
                } else {
                    stringBuilder.append(String.format("%s%s ... %d more", stackTraceElementSerializer.getModuleName(stackTraceElement), string2, n - 1));
                    if (bl2) {
                        stringBuilder.append(stackTraceElementSerializer.getPackageInformation(stackTraceElement));
                    }
                }
            } else {
                throw new IllegalArgumentException("Stack trace element serializer not initialized.");
            }
        }
        return 0;
    }

    public static void clearGroupPackages() {
        groupPackageSet.clear();
    }

    public static void clearIgnorePackages() {
        ignorePackageSet.clear();
        ignoreCausePackageSet.clear();
    }

    public static void clearRootPackages() {
        rootPackageSet.clear();
    }

    public static boolean containsCause(Throwable throwable, Class<?> clazz) {
        return AbstractExceptions.containsCause(throwable, clazz, null);
    }

    public static boolean containsCause(Throwable throwable, Class<?> clazz, String string2) {
        boolean bl = AbstractExceptions.searchCause(throwable, clazz, string2, 10) != null;
        return bl;
    }

    public static boolean containsPackage(String string2, Set<String> set) {
        boolean bl = AbstractExceptions.getContainingPackage(string2, set) != null;
        return bl;
    }

    public static String getAllMessages(Throwable throwable) {
        StringBuilder stringBuilder = new StringBuilder();
        AbstractExceptions.getAllMessages(throwable, stringBuilder);
        return stringBuilder.toString();
    }

    public static void getAllMessages(Throwable throwable, StringBuilder stringBuilder) {
        if (throwable != null) {
            String string2 = throwable.getMessage();
            if (!AbstractExceptions.isEmpty(string2)) {
                if (stringBuilder.length() != 0) {
                    stringBuilder.append(System.lineSeparator());
                    stringBuilder.append(" - Caused by: ");
                }
                stringBuilder.append(string2);
            }
            AbstractExceptions.getAllMessages(throwable.getCause(), stringBuilder);
        }
    }

    public static Throwable getCause(Throwable throwable) {
        return AbstractExceptions.getCause(throwable, 10);
    }

    public static Throwable getCause(Throwable throwable, int n) {
        if (throwable == null) {
            return null;
        }
        if (n <= 0) {
            return throwable;
        }
        Throwable throwable2 = throwable.getCause();
        if (throwable2 == null) {
            return throwable;
        }
        return AbstractExceptions.getCause(throwable2, n - 1);
    }

    public static String getContainingPackage(String string2, Set<String> object) {
        object = object.iterator();
        while (object.hasNext()) {
            String string3 = (String)object.next();
            if (!string2.startsWith(string3)) continue;
            return string3;
        }
        return null;
    }

    public static boolean getIgnoreAllCauses() {
        return ignoreAllCauses;
    }

    public static boolean getPrintModuleName() {
        return printModuleName;
    }

    public static boolean getPrintSuppressedExceptions() {
        return printSuppressedExceptions;
    }

    public static StackTraceElement[] getStackTrace(ThrowableWrapper stackTraceElementWrapperArray, int n) {
        ArrayList<StackTraceElement> arrayList = new ArrayList<StackTraceElement>();
        if (stackTraceElementWrapperArray != null) {
            stackTraceElementWrapperArray = stackTraceElementWrapperArray.getStackTrace();
            for (int i = 0; i < stackTraceElementWrapperArray.length && i < n; ++i) {
                arrayList.add(stackTraceElementWrapperArray[i].getStackTraceElement());
            }
        }
        return arrayList.toArray(new StackTraceElement[0]);
    }

    /*
     * WARNING - void declaration
     */
    public static StackTraceElement[] getStackTrace(ThrowableWrapper object2, Set<String> set, Set<String> set2) {
        ArrayList arrayList = new ArrayList();
        ArrayList<StackTraceElement> arrayList2 = new ArrayList<StackTraceElement>();
        if (object2 != null) {
            for (StackTraceElementWrapper stackTraceElementWrapper : ((ThrowableWrapper)object2).getStackTrace()) {
                void var2_4;
                void var1_3;
                String string2 = stackTraceElementWrapper.getStackTraceElement().getClassName();
                if (AbstractExceptions.isEmpty(string2)) continue;
                if (AbstractExceptions.containsPackage(string2, (Set<String>)var1_3)) {
                    arrayList.addAll(arrayList2);
                    arrayList.add(stackTraceElementWrapper.getStackTraceElement());
                    continue;
                }
                if (AbstractExceptions.containsPackage(string2, (Set<String>)var2_4)) continue;
                arrayList2.add(stackTraceElementWrapper.getStackTraceElement());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(arrayList2);
        }
        return arrayList.toArray(new StackTraceElement[0]);
    }

    public static StackTraceElementSerializer getStackTraceElementSerializer() {
        return stackTraceElementSerializer;
    }

    public static String getStackTraceString(ThrowableWrapper throwableWrapper) {
        return AbstractExceptions.getStackTraceString(throwableWrapper, rootPackageSet, groupPackageSet, ignorePackageSet, 0, ignoreAllCauses, printPackageInformation);
    }

    public static String getStackTraceString(ThrowableWrapper throwableWrapper, int n) {
        return AbstractExceptions.getStackTraceString(throwableWrapper, new HashSet<String>(), new HashSet<String>(), new HashSet<String>(), n, ignoreAllCauses, printPackageInformation);
    }

    public static String getStackTraceString(ThrowableWrapper throwableWrapper, int n, boolean bl) {
        return AbstractExceptions.getStackTraceString(throwableWrapper, new HashSet<String>(), new HashSet<String>(), new HashSet<String>(), n, bl, printPackageInformation);
    }

    public static String getStackTraceString(ThrowableWrapper throwableWrapper, int n, boolean bl, boolean bl2) {
        return AbstractExceptions.getStackTraceString(throwableWrapper, new HashSet<String>(), new HashSet<String>(), new HashSet<String>(), n, bl, bl2);
    }

    public static String getStackTraceString(ThrowableWrapper throwableWrapper, int n, boolean bl, boolean bl2, boolean bl3) {
        return AbstractExceptions.getStackTraceString(throwableWrapper, new HashSet<String>(), new HashSet<String>(), new HashSet<String>(), n, bl, bl2, printModuleName, bl3);
    }

    public static String getStackTraceString(ThrowableWrapper throwableWrapper, String string2) {
        return AbstractExceptions.getStackTraceString(throwableWrapper, Collections.singleton(string2), new HashSet<String>(), new HashSet<String>(), 0, ignoreAllCauses, printPackageInformation);
    }

    public static String getStackTraceString(ThrowableWrapper throwableWrapper, String string2, String string3) {
        return AbstractExceptions.getStackTraceString(throwableWrapper, Collections.singleton(string2), Collections.singleton(string3), new HashSet<String>(), 0, ignoreAllCauses, printPackageInformation);
    }

    public static String getStackTraceString(ThrowableWrapper throwableWrapper, String string2, boolean bl, boolean bl2, Set<String> set, Set<String> set2, Set<String> set3, int n, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        StringBuilder stringBuilder = new StringBuilder();
        if (throwableWrapper == null) {
            return "";
        }
        String string3 = throwableWrapper.getClassName();
        StackTraceElement[] stackTraceElementArray = n > 0 ? AbstractExceptions.getStackTrace(throwableWrapper, n) : AbstractExceptions.getStackTrace(throwableWrapper, set, set3);
        ThrowableWrapper[] throwableWrapperArray = throwableWrapper.getMessage();
        if (AbstractExceptions.isEmpty((String)throwableWrapperArray)) {
            throwableWrapperArray = throwableWrapper.getMessage();
        }
        if (bl) {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(string2);
            stringBuilder.append("Caused by: ");
        } else if (bl2) {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(string2);
            stringBuilder.append("Suppressed: ");
        }
        stringBuilder.append(string3);
        if (!AbstractExceptions.isEmpty((String)throwableWrapperArray)) {
            stringBuilder.append(": ");
            stringBuilder.append((String)throwableWrapperArray);
        }
        int n2 = stackTraceElementArray.length;
        String string4 = null;
        Object object = null;
        int n3 = 0;
        for (int i = 0; i < n2; ++i) {
            StackTraceElement stackTraceElement = stackTraceElementArray[i];
            String string5 = AbstractExceptions.getContainingPackage(stackTraceElement.getClassName(), set2);
            if (string5 != null) {
                if (!string5.equals(string4)) {
                    AbstractExceptions.appendStackTraceGroupElement(stringBuilder, string4, n3, (StackTraceElement)object, bl5, bl4, string2);
                    stringBuilder.append(System.lineSeparator());
                    stringBuilder.append(string2);
                    stringBuilder.append("\tat ");
                    string4 = string5;
                    object = stackTraceElement;
                    n3 = 1;
                    continue;
                }
                ++n3;
                continue;
            }
            n3 = AbstractExceptions.appendStackTraceGroupElement(stringBuilder, string4, n3, (StackTraceElement)object, bl5, bl4, string2);
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(string2);
            stringBuilder.append("\tat ");
            if (stackTraceElementSerializer != null) {
                stringBuilder.append(string2);
                stringBuilder.append(stackTraceElementSerializer.toString(stackTraceElement, bl5, bl4));
                string4 = null;
                continue;
            }
            throw new IllegalArgumentException("Stack trace element serializer not initialized.");
        }
        AbstractExceptions.appendStackTraceGroupElement(stringBuilder, string4, n3, object, bl5, bl4, string2);
        object = throwableWrapper.getSuppressed();
        if (object != null && ((ThrowableWrapper[])object).length > 0 && bl6) {
            n3 = ((ThrowableWrapper[])object).length;
            string4 = string3;
            string3 = throwableWrapperArray;
            throwableWrapperArray = object;
            for (n2 = 0; n2 < n3; ++n2) {
                stringBuilder.append(AbstractExceptions.getStackTraceString(throwableWrapperArray[n2], string2 + "\t", false, true, set, set2, set3, n, bl3, bl4, bl5, bl6));
            }
        } else {
            string4 = string3;
        }
        if ((throwableWrapper = throwableWrapper.getCause()) != null && !AbstractExceptions.containsPackage(string4, ignoreCausePackageSet) && !bl3) {
            stringBuilder.append(AbstractExceptions.getStackTraceString(throwableWrapper, string2, true, false, set, set2, set3, n, bl3, bl4, bl5, bl6));
        }
        return stringBuilder.toString();
    }

    public static String getStackTraceString(ThrowableWrapper throwableWrapper, Set<String> set, Set<String> set2, Set<String> set3) {
        return AbstractExceptions.getStackTraceString(throwableWrapper, set, set2, set3, 0, ignoreAllCauses, printPackageInformation);
    }

    public static String getStackTraceString(ThrowableWrapper throwableWrapper, Set<String> set, Set<String> set2, Set<String> set3, int n, boolean bl, boolean bl2) {
        return AbstractExceptions.getStackTraceString(throwableWrapper, set, set2, set3, n, bl, bl2, printModuleName);
    }

    public static String getStackTraceString(ThrowableWrapper throwableWrapper, Set<String> set, Set<String> set2, Set<String> set3, int n, boolean bl, boolean bl2, boolean bl3) {
        return AbstractExceptions.getStackTraceString(throwableWrapper, false, false, set, set2, set3, n, bl, bl2, bl3, printSuppressedExceptions);
    }

    public static String getStackTraceString(ThrowableWrapper throwableWrapper, Set<String> set, Set<String> set2, Set<String> set3, int n, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        return AbstractExceptions.getStackTraceString(throwableWrapper, false, false, set, set2, set3, n, bl, bl2, bl3, bl4);
    }

    public static String getStackTraceString(ThrowableWrapper throwableWrapper, Set<String> set, Set<String> set2, Set<String> set3, boolean bl) {
        return AbstractExceptions.getStackTraceString(throwableWrapper, set, set2, set3, 0, bl, printPackageInformation);
    }

    public static String getStackTraceString(ThrowableWrapper throwableWrapper, Set<String> set, Set<String> set2, Set<String> set3, boolean bl, boolean bl2) {
        return AbstractExceptions.getStackTraceString(throwableWrapper, set, set2, set3, 0, bl, bl2);
    }

    public static String getStackTraceString(ThrowableWrapper throwableWrapper, Set<String> set, Set<String> set2, Set<String> set3, boolean bl, boolean bl2, boolean bl3) {
        return AbstractExceptions.getStackTraceString(throwableWrapper, set, set2, set3, 0, bl, bl2, printModuleName, bl3);
    }

    public static String getStackTraceString(ThrowableWrapper throwableWrapper, boolean bl) {
        return AbstractExceptions.getStackTraceString(throwableWrapper, rootPackageSet, groupPackageSet, ignorePackageSet, 0, bl, printPackageInformation);
    }

    public static String getStackTraceString(ThrowableWrapper throwableWrapper, boolean bl, boolean bl2, Set<String> set, Set<String> set2, Set<String> set3, int n, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        return AbstractExceptions.getStackTraceString(throwableWrapper, "", bl, bl2, set, set2, set3, n, bl3, bl4, bl5, bl6);
    }

    public static boolean isEmpty(String string2) {
        boolean bl = true;
        if (string2 == null) {
            return true;
        }
        if (string2.trim().length() != 0) {
            bl = false;
        }
        return bl;
    }

    public static boolean isPrintPackageInformation() {
        return printPackageInformation;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String libraryName(Class<?> object) {
        if (object == null) return null;
        try {
            ClassLoader classLoader = ((Class)object).getClassLoader();
            Object object2 = new StringBuilder();
            object = classLoader.getResource(((StringBuilder)object2).append(((Class)object).getName().replace('.', '/')).append(".class").toString());
            if (object == null) return null;
            int n = ((String)(object = ((URL)object).toString())).lastIndexOf(33);
            if (n <= 0) return null;
            object2 = ((String)object).substring(0, n);
            n = ((String)object2).lastIndexOf(47);
            object = object2;
            if (n > 0) {
                object = ((String)object2).substring(n + 1);
            }
            n = ((String)object).lastIndexOf(92);
            object2 = object;
            if (n <= 0) return object2;
            return ((String)object).substring(n + 1);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static String packageInformation(String string2, String string3) {
        boolean bl = true;
        boolean bl2 = string2 != null;
        if (string3 == null) {
            bl = false;
        }
        if (!bl2 && !bl) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" [");
        if (bl2) {
            stringBuilder.append(string2);
        }
        if (bl) {
            if (bl2) {
                if (!string2.contains(string3)) {
                    stringBuilder.append(":");
                    stringBuilder.append(string3);
                }
            } else {
                stringBuilder.append(string3);
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static String packageName(String string2) {
        if (string2 == null) {
            return "";
        }
        int n = string2.lastIndexOf(".");
        if (n >= 0) {
            return string2.substring(0, n);
        }
        return "";
    }

    public static void registerGroupPackage(String string2) {
        groupPackageSet.add(string2);
    }

    public static void registerIgnorePackage(String string2, boolean bl) {
        ignorePackageSet.add(string2);
        if (bl) {
            ignoreCausePackageSet.add(string2);
        }
    }

    public static void registerRootPackage(String string2) {
        rootPackageSet.add(string2);
    }

    public static Throwable searchCause(Throwable throwable, Class<?> clazz) {
        return AbstractExceptions.searchCause(throwable, clazz, null, 10);
    }

    public static Throwable searchCause(Throwable throwable, Class<?> clazz, int n) {
        if (throwable == null) {
            return null;
        }
        if (throwable.getClass().equals(clazz)) {
            return throwable;
        }
        if (n <= 0) {
            return null;
        }
        if ((throwable = throwable.getCause()) == null) {
            return null;
        }
        return AbstractExceptions.searchCause(throwable, clazz, n - 1);
    }

    public static Throwable searchCause(Throwable throwable, Class<?> clazz, String string2) {
        return AbstractExceptions.searchCause(throwable, clazz, string2, 10);
    }

    public static Throwable searchCause(Throwable throwable, Class<?> clazz, String string2, int n) {
        if (throwable == null) {
            return null;
        }
        if (AbstractExceptions.isEmpty(string2) ? throwable.getClass().equals(clazz) : throwable.getClass().equals(clazz) && AbstractExceptions.getAllMessages(throwable).toLowerCase().contains(string2.toLowerCase())) {
            return throwable;
        }
        if (n <= 0) {
            return null;
        }
        if ((throwable = throwable.getCause()) == null) {
            return null;
        }
        return AbstractExceptions.searchCause(throwable, clazz, string2, n - 1);
    }

    public static void setIgnoreAllCauses(boolean bl) {
        ignoreAllCauses = bl;
    }

    public static void setPrintModuleName(boolean bl) {
        printModuleName = bl;
    }

    public static void setPrintPackageInformation(boolean bl) {
        printPackageInformation = bl;
    }

    public static void setPrintSuppressedExceptions(boolean bl) {
        printSuppressedExceptions = bl;
    }

    public static void setStackTraceElementSerializer(StackTraceElementSerializer stackTraceElementSerializer) {
        AbstractExceptions.stackTraceElementSerializer = stackTraceElementSerializer;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String version(PackageLoader object, Class<?> clazz, String string2) {
        try {
            Package package_ = clazz.getPackage();
            if (package_ != null) {
                return package_.getImplementationVersion();
            }
            if ((object = object.getPackage(clazz.getClassLoader(), string2)) == null) return null;
            return ((Package)object).getImplementationVersion();
        }
        catch (Exception exception) {
            // empty catch block
        }
        return null;
    }
}

