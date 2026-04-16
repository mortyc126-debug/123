/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.transition;

import android.view.View;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TransitionValues {
    final ArrayList<Transition> mTargetedTransitions;
    public final Map<String, Object> values = new HashMap<String, Object>();
    public View view;

    @Deprecated
    public TransitionValues() {
        this.mTargetedTransitions = new ArrayList();
    }

    public TransitionValues(View view) {
        this.mTargetedTransitions = new ArrayList();
        this.view = view;
    }

    public boolean equals(Object object) {
        return object instanceof TransitionValues && this.view == ((TransitionValues)object).view && ((Object)this.values).equals(((TransitionValues)object).values);
    }

    public int hashCode() {
        return this.view.hashCode() * 31 + ((Object)this.values).hashCode();
    }

    public String toString() {
        String string2 = "TransitionValues@" + Integer.toHexString(this.hashCode()) + ":\n";
        string2 = string2 + "    view = " + this.view + "\n";
        string2 = string2 + "    values:";
        for (String string3 : this.values.keySet()) {
            string2 = string2 + "    " + string3 + ": " + this.values.get(string3) + "\n";
        }
        return string2;
    }
}

