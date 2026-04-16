/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0002\u000e\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Landroidx/savedstate/Recreator;", "Landroidx/lifecycle/LifecycleEventObserver;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "(Landroidx/savedstate/SavedStateRegistryOwner;)V", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "reflectiveNew", "className", "", "Companion", "SavedStateProvider", "savedstate_release"}, k=1, mv={1, 8, 0}, xi=48)
public final class Recreator
implements LifecycleEventObserver {
    public static final String CLASSES_KEY = "classes_to_restore";
    public static final String COMPONENT_KEY = "androidx.savedstate.Restarter";
    public static final Companion Companion = new Companion(null);
    private final SavedStateRegistryOwner owner;

    public Recreator(SavedStateRegistryOwner savedStateRegistryOwner) {
        Intrinsics.checkNotNullParameter((Object)savedStateRegistryOwner, (String)"owner");
        this.owner = savedStateRegistryOwner;
    }

    private final void reflectiveNew(String string2) {
        Constructor<SavedStateRegistry.AutoRecreated> constructor;
        Object object;
        try {
            object = Class.forName(string2, false, Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry.AutoRecreated.class);
            Intrinsics.checkNotNullExpressionValue(object, (String)"{\n                Class.\u2026class.java)\n            }");
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new RuntimeException("Class " + string2 + " wasn't found", classNotFoundException);
        }
        try {
            constructor = ((Class)object).getDeclaredConstructor(new Class[0]);
            constructor.setAccessible(true);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new IllegalStateException("Class " + ((Class)object).getSimpleName() + " must have default constructor in order to be automatically recreated", noSuchMethodException);
        }
        try {
            object = constructor.newInstance(new Object[0]);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"{\n                constr\u2026wInstance()\n            }");
            object = (SavedStateRegistry.AutoRecreated)object;
            object.onRecreated(this.owner);
            return;
        }
        catch (Exception exception) {
            throw new RuntimeException("Failed to instantiate " + string2, exception);
        }
    }

    @Override
    public void onStateChanged(LifecycleOwner iterator2, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter((Object)iterator2, (String)"source");
        Intrinsics.checkNotNullParameter((Object)((Object)event), (String)"event");
        if (event == Lifecycle.Event.ON_CREATE) {
            iterator2.getLifecycle().removeObserver(this);
            iterator2 = this.owner.getSavedStateRegistry().consumeRestoredStateForKey(COMPONENT_KEY);
            if (iterator2 == null) {
                return;
            }
            if ((iterator2 = iterator2.getStringArrayList(CLASSES_KEY)) != null) {
                iterator2 = ((List)((Object)iterator2)).iterator();
                while (iterator2.hasNext()) {
                    this.reflectiveNew((String)iterator2.next());
                }
                return;
            }
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        throw new AssertionError((Object)"Next event must be ON_CREATE");
    }

    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Landroidx/savedstate/Recreator$Companion;", "", "()V", "CLASSES_KEY", "", "COMPONENT_KEY", "savedstate_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Landroidx/savedstate/Recreator$SavedStateProvider;", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "registry", "Landroidx/savedstate/SavedStateRegistry;", "(Landroidx/savedstate/SavedStateRegistry;)V", "classes", "", "", "add", "", "className", "saveState", "Landroid/os/Bundle;", "savedstate_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class SavedStateProvider
    implements SavedStateRegistry.SavedStateProvider {
        private final Set<String> classes;

        public SavedStateProvider(SavedStateRegistry savedStateRegistry) {
            Intrinsics.checkNotNullParameter((Object)savedStateRegistry, (String)"registry");
            this.classes = new LinkedHashSet();
            savedStateRegistry.registerSavedStateProvider(Recreator.COMPONENT_KEY, this);
        }

        public final void add(String string2) {
            Intrinsics.checkNotNullParameter((Object)string2, (String)"className");
            this.classes.add(string2);
        }

        @Override
        public Bundle saveState() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList(Recreator.CLASSES_KEY, new ArrayList(this.classes));
            return bundle;
        }
    }
}

