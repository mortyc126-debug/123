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
import androidx.core.view.MenuHostHelper$$ExternalSyntheticLambda0;
import androidx.core.view.MenuHostHelper$$ExternalSyntheticLambda1;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class MenuHostHelper {
    private final CopyOnWriteArrayList<MenuProvider> mMenuProviders = new CopyOnWriteArrayList();
    private final Runnable mOnInvalidateMenuCallback;
    private final Map<MenuProvider, LifecycleContainer> mProviderToLifecycleContainers = new HashMap<MenuProvider, LifecycleContainer>();

    public MenuHostHelper(Runnable runnable2) {
        this.mOnInvalidateMenuCallback = runnable2;
    }

    public void addMenuProvider(MenuProvider menuProvider) {
        this.mMenuProviders.add(menuProvider);
        this.mOnInvalidateMenuCallback.run();
    }

    public void addMenuProvider(MenuProvider menuProvider, LifecycleOwner object) {
        this.addMenuProvider(menuProvider);
        object = object.getLifecycle();
        Object object2 = this.mProviderToLifecycleContainers.remove(menuProvider);
        if (object2 != null) {
            ((LifecycleContainer)object2).clearObservers();
        }
        object2 = new MenuHostHelper$$ExternalSyntheticLambda0(this, menuProvider);
        this.mProviderToLifecycleContainers.put(menuProvider, new LifecycleContainer((Lifecycle)object, (LifecycleEventObserver)object2));
    }

    public void addMenuProvider(MenuProvider menuProvider, LifecycleOwner object, Lifecycle.State object2) {
        object = object.getLifecycle();
        LifecycleContainer lifecycleContainer = this.mProviderToLifecycleContainers.remove(menuProvider);
        if (lifecycleContainer != null) {
            lifecycleContainer.clearObservers();
        }
        object2 = new MenuHostHelper$$ExternalSyntheticLambda1(this, (Lifecycle.State)((Object)object2), menuProvider);
        this.mProviderToLifecycleContainers.put(menuProvider, new LifecycleContainer((Lifecycle)object, (LifecycleEventObserver)object2));
    }

    /* synthetic */ void lambda$addMenuProvider$0$androidx-core-view-MenuHostHelper(MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.removeMenuProvider(menuProvider);
        }
    }

    /* synthetic */ void lambda$addMenuProvider$1$androidx-core-view-MenuHostHelper(Lifecycle.State state, MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.upTo(state)) {
            this.addMenuProvider(menuProvider);
        } else if (event == Lifecycle.Event.ON_DESTROY) {
            this.removeMenuProvider(menuProvider);
        } else if (event == Lifecycle.Event.downFrom(state)) {
            this.mMenuProviders.remove(menuProvider);
            this.mOnInvalidateMenuCallback.run();
        }
    }

    public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
        Iterator<MenuProvider> iterator2 = this.mMenuProviders.iterator();
        while (iterator2.hasNext()) {
            iterator2.next().onCreateMenu(menu, menuInflater);
        }
    }

    public void onMenuClosed(Menu menu) {
        Iterator<MenuProvider> iterator2 = this.mMenuProviders.iterator();
        while (iterator2.hasNext()) {
            iterator2.next().onMenuClosed(menu);
        }
    }

    public boolean onMenuItemSelected(MenuItem menuItem) {
        Iterator<MenuProvider> iterator2 = this.mMenuProviders.iterator();
        while (iterator2.hasNext()) {
            if (!iterator2.next().onMenuItemSelected(menuItem)) continue;
            return true;
        }
        return false;
    }

    public void onPrepareMenu(Menu menu) {
        Iterator<MenuProvider> iterator2 = this.mMenuProviders.iterator();
        while (iterator2.hasNext()) {
            iterator2.next().onPrepareMenu(menu);
        }
    }

    public void removeMenuProvider(MenuProvider object) {
        this.mMenuProviders.remove(object);
        object = this.mProviderToLifecycleContainers.remove(object);
        if (object != null) {
            ((LifecycleContainer)object).clearObservers();
        }
        this.mOnInvalidateMenuCallback.run();
    }

    private static class LifecycleContainer {
        final Lifecycle mLifecycle;
        private LifecycleEventObserver mObserver;

        LifecycleContainer(Lifecycle lifecycle, LifecycleEventObserver lifecycleEventObserver) {
            this.mLifecycle = lifecycle;
            this.mObserver = lifecycleEventObserver;
            this.mLifecycle.addObserver(lifecycleEventObserver);
        }

        void clearObservers() {
            this.mLifecycle.removeObserver(this.mObserver);
            this.mObserver = null;
        }
    }
}

