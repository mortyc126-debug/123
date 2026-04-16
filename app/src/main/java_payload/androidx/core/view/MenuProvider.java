/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 */
package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public interface MenuProvider {
    public void onCreateMenu(Menu var1, MenuInflater var2);

    default public void onMenuClosed(Menu menu) {
    }

    public boolean onMenuItemSelected(MenuItem var1);

    default public void onPrepareMenu(Menu menu) {
    }
}

