/*
 * Decompiled with CFR 0.152.
 */
package androidx.fragment.app;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelStore;
import java.util.Collection;
import java.util.Map;

@Deprecated
public class FragmentManagerNonConfig {
    private final Map<String, FragmentManagerNonConfig> mChildNonConfigs;
    private final Collection<Fragment> mFragments;
    private final Map<String, ViewModelStore> mViewModelStores;

    FragmentManagerNonConfig(Collection<Fragment> collection, Map<String, FragmentManagerNonConfig> map2, Map<String, ViewModelStore> map3) {
        this.mFragments = collection;
        this.mChildNonConfigs = map2;
        this.mViewModelStores = map3;
    }

    Map<String, FragmentManagerNonConfig> getChildNonConfigs() {
        return this.mChildNonConfigs;
    }

    Collection<Fragment> getFragments() {
        return this.mFragments;
    }

    Map<String, ViewModelStore> getViewModelStores() {
        return this.mViewModelStores;
    }

    boolean isRetaining(Fragment fragment) {
        if (this.mFragments == null) {
            return false;
        }
        return this.mFragments.contains(fragment);
    }
}

