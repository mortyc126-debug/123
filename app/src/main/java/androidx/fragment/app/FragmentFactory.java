/*
 * Decompiled with CFR 0.152.
 */
package androidx.fragment.app;

import androidx.collection.SimpleArrayMap;
import androidx.fragment.app.Fragment;
import java.lang.reflect.InvocationTargetException;

public class FragmentFactory {
    private static final SimpleArrayMap<ClassLoader, SimpleArrayMap<String, Class<?>>> sClassCacheMap = new SimpleArrayMap();

    static boolean isFragmentClass(ClassLoader classLoader, String string2) {
        try {
            boolean bl = Fragment.class.isAssignableFrom(FragmentFactory.loadClass(classLoader, string2));
            return bl;
        }
        catch (ClassNotFoundException classNotFoundException) {
            return false;
        }
    }

    private static Class<?> loadClass(ClassLoader classLoader, String string2) throws ClassNotFoundException {
        Class<?> clazz = sClassCacheMap.get(classLoader);
        SimpleArrayMap<String, Class<Object>> simpleArrayMap = clazz;
        if (clazz == null) {
            simpleArrayMap = new SimpleArrayMap();
            sClassCacheMap.put(classLoader, simpleArrayMap);
        }
        Class<?> clazz2 = simpleArrayMap.get(string2);
        clazz = clazz2;
        if (clazz2 == null) {
            clazz = Class.forName(string2, false, classLoader);
            simpleArrayMap.put(string2, clazz);
        }
        return clazz;
    }

    public static Class<? extends Fragment> loadFragmentClass(ClassLoader object, String string2) {
        try {
            object = FragmentFactory.loadClass((ClassLoader)object, string2);
            return object;
        }
        catch (ClassCastException classCastException) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + string2 + ": make sure class is a valid subclass of Fragment", classCastException);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + string2 + ": make sure class name exists", classNotFoundException);
        }
    }

    public Fragment instantiate(ClassLoader object, String string2) {
        try {
            object = FragmentFactory.loadFragmentClass((ClassLoader)object, string2).getConstructor(new Class[0]).newInstance(new Object[0]);
            return object;
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + string2 + ": calling Fragment constructor caused an exception", invocationTargetException);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + string2 + ": could not find Fragment constructor", noSuchMethodException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + string2 + ": make sure class name exists, is public, and has an empty constructor that is public", illegalAccessException);
        }
        catch (InstantiationException instantiationException) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + string2 + ": make sure class name exists, is public, and has an empty constructor that is public", instantiationException);
        }
    }
}

