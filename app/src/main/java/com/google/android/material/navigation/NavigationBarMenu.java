package com.google.android.material.navigation;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

/* JADX INFO: loaded from: classes3.dex */
public final class NavigationBarMenu extends MenuBuilder {
    private final int maxItemCount;
    private final Class<?> viewClass;

    public NavigationBarMenu(Context context, Class<?> viewClass, int maxItemCount) {
        super(context);
        this.viewClass = viewClass;
        this.maxItemCount = maxItemCount;
    }

    public int getMaxItemCount() {
        return this.maxItemCount;
    }

    public SubMenu addSubMenu(int group, int id, int categoryOrder, CharSequence title) {
        throw new UnsupportedOperationException(this.viewClass.getSimpleName() + " does not support submenus");
    }

    protected MenuItem addInternal(int group, int id, int categoryOrder, CharSequence title) {
        if (size() + 1 > this.maxItemCount) {
            String viewClassName = this.viewClass.getSimpleName();
            throw new IllegalArgumentException("Maximum number of items supported by " + viewClassName + " is " + this.maxItemCount + ". Limit can be checked with " + viewClassName + "#getMaxItemCount()");
        }
        stopDispatchingItemsChanged();
        MenuItemImpl menuItemImplAddInternal = super.addInternal(group, id, categoryOrder, title);
        if (menuItemImplAddInternal instanceof MenuItemImpl) {
            menuItemImplAddInternal.setExclusiveCheckable(true);
        }
        startDispatchingItemsChanged();
        return menuItemImplAddInternal;
    }
}
