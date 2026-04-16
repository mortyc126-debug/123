/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.Window$Callback
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.core.app;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.KeyEventDispatcher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001)B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J'\u0010\u0016\u001a\u0004\u0018\u0001H\u0017\"\b\b\u0000\u0010\u0017*\u00020\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0007H\u0017\u00a2\u0006\u0002\u0010\u0019J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001dH\u0015J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\bH\u0017J\u001d\u0010\"\u001a\u00020\u00122\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$H\u0004\u00a2\u0006\u0002\u0010&J\u001d\u0010'\u001a\u00020\u00122\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$H\u0002\u00a2\u0006\u0002\u0010&J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0017R(\u0010\u0005\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0004\u00a8\u0006*"}, d2={"Landroidx/core/app/ComponentActivity;", "Landroid/app/Activity;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/core/view/KeyEventDispatcher$Component;", "()V", "extraDataMap", "Landroidx/collection/SimpleArrayMap;", "Ljava/lang/Class;", "Landroidx/core/app/ComponentActivity$ExtraData;", "getExtraDataMap$annotations", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "getLifecycleRegistry$annotations", "dispatchKeyEvent", "", "event", "Landroid/view/KeyEvent;", "dispatchKeyShortcutEvent", "getExtraData", "T", "extraDataClass", "(Ljava/lang/Class;)Landroidx/core/app/ComponentActivity$ExtraData;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "putExtraData", "extraData", "shouldDumpInternalState", "args", "", "", "([Ljava/lang/String;)Z", "shouldSkipDump", "superDispatchKeyEvent", "ExtraData", "core_release"}, k=1, mv={1, 8, 0}, xi=48)
public class ComponentActivity
extends Activity
implements LifecycleOwner,
KeyEventDispatcher.Component {
    private final SimpleArrayMap<Class<? extends ExtraData>, ExtraData> extraDataMap = new SimpleArrayMap();
    private final LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    private static /* synthetic */ void getExtraDataMap$annotations() {
    }

    private static /* synthetic */ void getLifecycleRegistry$annotations() {
    }

    /*
     * Enabled aggressive block sorting
     */
    private final boolean shouldSkipDump(String[] object) {
        boolean bl;
        boolean bl2 = true;
        boolean bl3 = true;
        boolean bl4 = true;
        boolean bl5 = true;
        bl = object == null || (bl = ((Object)object).length == 0);
        if (bl) return false;
        switch (object[0]) {
            default: {
                return false;
            }
            case "--autofill": {
                if (Build.VERSION.SDK_INT < 26) return false;
                return bl5;
            }
            case "--contentcapture": {
                if (Build.VERSION.SDK_INT < 29) return false;
                return bl2;
            }
            case "--list-dumpables": 
            case "--dump-dumpable": {
                if (Build.VERSION.SDK_INT < 33) return false;
                return bl3;
            }
            case "--translation": 
        }
        if (Build.VERSION.SDK_INT < 31) return false;
        return bl4;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter((Object)keyEvent, (String)"event");
        View view = this.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue((Object)view, (String)"window.decorView");
        boolean bl = KeyEventDispatcher.dispatchBeforeHierarchy(view, keyEvent) ? true : KeyEventDispatcher.dispatchKeyEvent(this, view, (Window.Callback)this, keyEvent);
        return bl;
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter((Object)keyEvent, (String)"event");
        View view = this.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue((Object)view, (String)"window.decorView");
        boolean bl = KeyEventDispatcher.dispatchBeforeHierarchy(view, keyEvent) ? true : super.dispatchKeyShortcutEvent(keyEvent);
        return bl;
    }

    @Deprecated(message="Use {@link View#getTag(int)} with the window's decor view.")
    public <T extends ExtraData> T getExtraData(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, (String)"extraDataClass");
        return (T)this.extraDataMap.get(clazz);
    }

    @Override
    public Lifecycle getLifecycle() {
        return this.lifecycleRegistry;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ReportFragment.Companion.injectIfNeededIn(this);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter((Object)bundle, (String)"outState");
        this.lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
        super.onSaveInstanceState(bundle);
    }

    @Deprecated(message="Use {@link View#setTag(int, Object)} with the window's decor view.")
    public void putExtraData(ExtraData extraData) {
        Intrinsics.checkNotNullParameter((Object)extraData, (String)"extraData");
        this.extraDataMap.put(extraData.getClass(), extraData);
    }

    protected final boolean shouldDumpInternalState(String[] stringArray) {
        return this.shouldSkipDump(stringArray) ^ true;
    }

    @Override
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter((Object)keyEvent, (String)"event");
        return super.dispatchKeyEvent(keyEvent);
    }

    @Deprecated(message="Store the object you want to save directly by using\n      {@link View#setTag(int, Object)} with the window's decor view.")
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2={"Landroidx/core/app/ComponentActivity$ExtraData;", "", "()V", "core_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static class ExtraData {
    }
}

