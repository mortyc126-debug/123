/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.widget.ListView
 */
package androidx.core.widget;

import android.widget.ListView;

@Deprecated
public final class ListViewCompat {
    private ListViewCompat() {
    }

    @Deprecated
    public static boolean canScrollList(ListView listView, int n) {
        return listView.canScrollList(n);
    }

    @Deprecated
    public static void scrollListBy(ListView listView, int n) {
        listView.scrollListBy(n);
    }
}

