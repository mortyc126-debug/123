/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Menu
 *  android.view.MenuItem
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.sequences.Sequence
 */
package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(d1={"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010)\n\u0002\b\u0003\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\u0002\u001a0\u0010\r\u001a\u00020\u000e*\u00020\u00032!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0010H\u0086\b\u001aE\u0010\u0013\u001a\u00020\u000e*\u00020\u000326\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0014H\u0086\b\u001a\u0015\u0010\u0016\u001a\u00020\u0002*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0007H\u0086\n\u001a\r\u0010\u0017\u001a\u00020\u000b*\u00020\u0003H\u0086\b\u001a\r\u0010\u0018\u001a\u00020\u000b*\u00020\u0003H\u0086\b\u001a\u0013\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a*\u00020\u0003H\u0086\u0002\u001a\u0015\u0010\u001b\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010\u001c\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0007H\u0086\b\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u0007*\u00020\u00038\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u001d"}, d2={"children", "Lkotlin/sequences/Sequence;", "Landroid/view/MenuItem;", "Landroid/view/Menu;", "getChildren", "(Landroid/view/Menu;)Lkotlin/sequences/Sequence;", "size", "", "getSize", "(Landroid/view/Menu;)I", "contains", "", "item", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function2;", "index", "get", "isEmpty", "isNotEmpty", "iterator", "", "minusAssign", "removeItemAt", "core-ktx_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class MenuKt {
    public static final boolean contains(Menu menu, MenuItem menuItem) {
        int n = menu.size();
        for (int i = 0; i < n; ++i) {
            if (!Intrinsics.areEqual((Object)menu.getItem(i), (Object)menuItem)) continue;
            return true;
        }
        return false;
    }

    public static final void forEach(Menu menu, Function1<? super MenuItem, Unit> function1) {
        int n = menu.size();
        for (int i = 0; i < n; ++i) {
            function1.invoke((Object)menu.getItem(i));
        }
    }

    public static final void forEachIndexed(Menu menu, Function2<? super Integer, ? super MenuItem, Unit> function2) {
        int n = menu.size();
        for (int i = 0; i < n; ++i) {
            function2.invoke((Object)i, (Object)menu.getItem(i));
        }
    }

    public static final MenuItem get(Menu menu, int n) {
        return menu.getItem(n);
    }

    public static final Sequence<MenuItem> getChildren(Menu menu) {
        return (Sequence)new Sequence<MenuItem>(menu){
            final Menu $this_children;
            {
                this.$this_children = menu;
            }

            public Iterator<MenuItem> iterator() {
                return MenuKt.iterator(this.$this_children);
            }
        };
    }

    public static final int getSize(Menu menu) {
        return menu.size();
    }

    public static final boolean isEmpty(Menu menu) {
        boolean bl = menu.size() == 0;
        return bl;
    }

    public static final boolean isNotEmpty(Menu menu) {
        boolean bl = menu.size() != 0;
        return bl;
    }

    public static final Iterator<MenuItem> iterator(Menu menu) {
        return new Iterator<MenuItem>(menu){
            final Menu $this_iterator;
            private int index;
            {
                this.$this_iterator = menu;
            }

            public boolean hasNext() {
                boolean bl = this.index < this.$this_iterator.size();
                return bl;
            }

            public MenuItem next() {
                Menu menu = this.$this_iterator;
                int n = this.index;
                this.index = n + 1;
                if ((menu = menu.getItem(n)) != null) {
                    return menu;
                }
                throw new IndexOutOfBoundsException();
            }

            public void remove() {
                Menu menu = this.$this_iterator;
                --this.index;
                MenuItem menuItem = menu.getItem(this.index);
                if (menuItem != null) {
                    menu.removeItem(menuItem.getItemId());
                    menuItem = Unit.INSTANCE;
                } else {
                    menuItem = null;
                }
                if (menuItem != null) {
                    return;
                }
                throw new IndexOutOfBoundsException();
            }
        };
    }

    public static final void minusAssign(Menu menu, MenuItem menuItem) {
        menu.removeItem(menuItem.getItemId());
    }

    public static final void removeItemAt(Menu menu, int n) {
        MenuItem menuItem = menu.getItem(n);
        if (menuItem != null) {
            menu.removeItem(menuItem.getItemId());
            menu = Unit.INSTANCE;
        } else {
            menu = null;
        }
        if (menu != null) {
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}

