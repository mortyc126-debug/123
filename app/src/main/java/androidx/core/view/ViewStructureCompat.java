/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.ViewStructure
 */
package androidx.core.view;

import android.view.ViewStructure;

public class ViewStructureCompat {
    private final Object mWrappedObj;

    private ViewStructureCompat(ViewStructure viewStructure) {
        this.mWrappedObj = viewStructure;
    }

    public static ViewStructureCompat toViewStructureCompat(ViewStructure viewStructure) {
        return new ViewStructureCompat(viewStructure);
    }

    public void setClassName(String string2) {
        Api23Impl.setClassName((ViewStructure)this.mWrappedObj, string2);
    }

    public void setContentDescription(CharSequence charSequence) {
        Api23Impl.setContentDescription((ViewStructure)this.mWrappedObj, charSequence);
    }

    public void setDimens(int n, int n2, int n3, int n4, int n5, int n6) {
        Api23Impl.setDimens((ViewStructure)this.mWrappedObj, n, n2, n3, n4, n5, n6);
    }

    public void setText(CharSequence charSequence) {
        Api23Impl.setText((ViewStructure)this.mWrappedObj, charSequence);
    }

    public ViewStructure toViewStructure() {
        return (ViewStructure)this.mWrappedObj;
    }

    private static class Api23Impl {
        private Api23Impl() {
        }

        static void setClassName(ViewStructure viewStructure, String string2) {
            viewStructure.setClassName(string2);
        }

        static void setContentDescription(ViewStructure viewStructure, CharSequence charSequence) {
            viewStructure.setContentDescription(charSequence);
        }

        static void setDimens(ViewStructure viewStructure, int n, int n2, int n3, int n4, int n5, int n6) {
            viewStructure.setDimens(n, n2, n3, n4, n5, n6);
        }

        static void setText(ViewStructure viewStructure, CharSequence charSequence) {
            viewStructure.setText(charSequence);
        }
    }
}

