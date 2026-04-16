/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.fragment.app;

import android.view.View;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransitionCompat21;
import androidx.fragment.app.FragmentTransitionImpl;
import java.util.ArrayList;
import java.util.List;

class FragmentTransition {
    static final FragmentTransitionImpl PLATFORM_IMPL = new FragmentTransitionCompat21();
    static final FragmentTransitionImpl SUPPORT_IMPL = FragmentTransition.resolveSupportImpl();

    private FragmentTransition() {
    }

    static void callSharedElementStartEnd(Fragment object, Fragment object2, boolean bl, ArrayMap<String, View> arrayMap, boolean bl2) {
        object = bl ? ((Fragment)object2).getEnterTransitionCallback() : ((Fragment)object).getEnterTransitionCallback();
        if (object != null) {
            ArrayList<View> arrayList = new ArrayList<View>();
            object2 = new ArrayList();
            int n = arrayMap == null ? 0 : arrayMap.size();
            for (int i = 0; i < n; ++i) {
                ((ArrayList)object2).add((String)arrayMap.keyAt(i));
                arrayList.add((View)arrayMap.valueAt(i));
            }
            if (bl2) {
                ((SharedElementCallback)object).onSharedElementStart((List<String>)object2, arrayList, null);
            } else {
                ((SharedElementCallback)object).onSharedElementEnd((List<String>)object2, arrayList, null);
            }
        }
    }

    static String findKeyForValue(ArrayMap<String, String> arrayMap, String string2) {
        int n = arrayMap.size();
        for (int i = 0; i < n; ++i) {
            if (!string2.equals(arrayMap.valueAt(i))) continue;
            return (String)arrayMap.keyAt(i);
        }
        return null;
    }

    private static FragmentTransitionImpl resolveSupportImpl() {
        try {
            FragmentTransitionImpl fragmentTransitionImpl = (FragmentTransitionImpl)Class.forName("androidx.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            return fragmentTransitionImpl;
        }
        catch (Exception exception) {
            return null;
        }
    }

    static void retainValues(ArrayMap<String, String> arrayMap, ArrayMap<String, View> arrayMap2) {
        for (int i = arrayMap.size() - 1; i >= 0; --i) {
            if (arrayMap2.containsKey((String)arrayMap.valueAt(i))) continue;
            arrayMap.removeAt(i);
        }
    }

    static void setViewVisibility(ArrayList<View> arrayList, int n) {
        if (arrayList == null) {
            return;
        }
        for (int i = arrayList.size() - 1; i >= 0; --i) {
            arrayList.get(i).setVisibility(n);
        }
    }

    static boolean supportsTransition() {
        boolean bl = PLATFORM_IMPL != null || SUPPORT_IMPL != null;
        return bl;
    }
}

