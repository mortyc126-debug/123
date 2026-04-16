/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.view;

import androidx.core.view.MenuProvider;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

public interface MenuHost {
    public void addMenuProvider(MenuProvider var1);

    public void addMenuProvider(MenuProvider var1, LifecycleOwner var2);

    public void addMenuProvider(MenuProvider var1, LifecycleOwner var2, Lifecycle.State var3);

    public void invalidateMenu();

    public void removeMenuProvider(MenuProvider var1);
}

