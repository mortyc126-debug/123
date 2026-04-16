/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.app.Fragment
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LifecycleRegistryOwner;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0017\u0018\u0000 \u00172\u00020\u0001:\u0003\u0016\u0017\u0018B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2={"Landroidx/lifecycle/ReportFragment;", "Landroid/app/Fragment;", "()V", "processListener", "Landroidx/lifecycle/ReportFragment$ActivityInitializationListener;", "dispatch", "", "event", "Landroidx/lifecycle/Lifecycle$Event;", "dispatchCreate", "listener", "dispatchResume", "dispatchStart", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "setProcessListener", "ActivityInitializationListener", "Companion", "LifecycleCallbacks", "lifecycle-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public class ReportFragment
extends Fragment {
    public static final Companion Companion = new Companion(null);
    private static final String REPORT_FRAGMENT_TAG = "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag";
    private ActivityInitializationListener processListener;

    private final void dispatch(Lifecycle.Event event) {
        if (Build.VERSION.SDK_INT < 29) {
            Companion companion = Companion;
            Activity activity = this.getActivity();
            Intrinsics.checkNotNullExpressionValue((Object)activity, (String)"activity");
            companion.dispatch$lifecycle_runtime_release(activity, event);
        }
    }

    @JvmStatic
    public static final void dispatch$lifecycle_runtime_release(Activity activity, Lifecycle.Event event) {
        Companion.dispatch$lifecycle_runtime_release(activity, event);
    }

    private final void dispatchCreate(ActivityInitializationListener activityInitializationListener) {
        if (activityInitializationListener != null) {
            activityInitializationListener.onCreate();
        }
    }

    private final void dispatchResume(ActivityInitializationListener activityInitializationListener) {
        if (activityInitializationListener != null) {
            activityInitializationListener.onResume();
        }
    }

    private final void dispatchStart(ActivityInitializationListener activityInitializationListener) {
        if (activityInitializationListener != null) {
            activityInitializationListener.onStart();
        }
    }

    public static final ReportFragment get(Activity activity) {
        return Companion.get(activity);
    }

    @JvmStatic
    public static final void injectIfNeededIn(Activity activity) {
        Companion.injectIfNeededIn(activity);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.dispatchCreate(this.processListener);
        this.dispatch(Lifecycle.Event.ON_CREATE);
    }

    public void onDestroy() {
        super.onDestroy();
        this.dispatch(Lifecycle.Event.ON_DESTROY);
        this.processListener = null;
    }

    public void onPause() {
        super.onPause();
        this.dispatch(Lifecycle.Event.ON_PAUSE);
    }

    public void onResume() {
        super.onResume();
        this.dispatchResume(this.processListener);
        this.dispatch(Lifecycle.Event.ON_RESUME);
    }

    public void onStart() {
        super.onStart();
        this.dispatchStart(this.processListener);
        this.dispatch(Lifecycle.Event.ON_START);
    }

    public void onStop() {
        super.onStop();
        this.dispatch(Lifecycle.Event.ON_STOP);
    }

    public final void setProcessListener(ActivityInitializationListener activityInitializationListener) {
        this.processListener = activityInitializationListener;
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0006\u00c0\u0006\u0001"}, d2={"Landroidx/lifecycle/ReportFragment$ActivityInitializationListener;", "", "onCreate", "", "onResume", "onStart", "lifecycle-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static interface ActivityInitializationListener {
        public void onCreate();

        public void onResume();

        public void onStart();
    }

    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001d\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0001\u00a2\u0006\u0002\b\u0011J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u0006*\u00020\u00078GX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0013"}, d2={"Landroidx/lifecycle/ReportFragment$Companion;", "", "()V", "REPORT_FRAGMENT_TAG", "", "reportFragment", "Landroidx/lifecycle/ReportFragment;", "Landroid/app/Activity;", "get$annotations", "(Landroid/app/Activity;)V", "get", "(Landroid/app/Activity;)Landroidx/lifecycle/ReportFragment;", "dispatch", "", "activity", "event", "Landroidx/lifecycle/Lifecycle$Event;", "dispatch$lifecycle_runtime_release", "injectIfNeededIn", "lifecycle-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void get$annotations(Activity activity) {
        }

        @JvmStatic
        public final void dispatch$lifecycle_runtime_release(Activity object, Lifecycle.Event event) {
            Intrinsics.checkNotNullParameter((Object)object, (String)"activity");
            Intrinsics.checkNotNullParameter((Object)((Object)event), (String)"event");
            if (object instanceof LifecycleRegistryOwner) {
                ((LifecycleRegistry)((LifecycleRegistryOwner)object).getLifecycle()).handleLifecycleEvent(event);
                return;
            }
            if (object instanceof LifecycleOwner && (object = ((LifecycleOwner)object).getLifecycle()) instanceof LifecycleRegistry) {
                ((LifecycleRegistry)object).handleLifecycleEvent(event);
            }
        }

        public final ReportFragment get(Activity activity) {
            Intrinsics.checkNotNullParameter((Object)activity, (String)"<this>");
            activity = activity.getFragmentManager();
            activity = activity.findFragmentByTag(ReportFragment.REPORT_FRAGMENT_TAG);
            Intrinsics.checkNotNull((Object)activity, (String)"null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            return (ReportFragment)activity;
        }

        @JvmStatic
        public final void injectIfNeededIn(Activity activity) {
            Intrinsics.checkNotNullParameter((Object)activity, (String)"activity");
            if (Build.VERSION.SDK_INT >= 29) {
                LifecycleCallbacks.Companion.registerIn(activity);
            }
            if ((activity = activity.getFragmentManager()).findFragmentByTag(ReportFragment.REPORT_FRAGMENT_TAG) == null) {
                activity.beginTransaction().add((Fragment)new ReportFragment(), ReportFragment.REPORT_FRAGMENT_TAG).commit();
                activity.executePendingTransactions();
            }
        }
    }

    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0001\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0017"}, d2={"Landroidx/lifecycle/ReportFragment$LifecycleCallbacks;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "()V", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "bundle", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityPostCreated", "savedInstanceState", "onActivityPostResumed", "onActivityPostStarted", "onActivityPreDestroyed", "onActivityPrePaused", "onActivityPreStopped", "onActivityResumed", "onActivitySaveInstanceState", "onActivityStarted", "onActivityStopped", "Companion", "lifecycle-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class LifecycleCallbacks
    implements Application.ActivityLifecycleCallbacks {
        public static final Companion Companion = new Companion(null);

        @JvmStatic
        public static final void registerIn(Activity activity) {
            Companion.registerIn(activity);
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            Intrinsics.checkNotNullParameter((Object)activity, (String)"activity");
        }

        public void onActivityDestroyed(Activity activity) {
            Intrinsics.checkNotNullParameter((Object)activity, (String)"activity");
        }

        public void onActivityPaused(Activity activity) {
            Intrinsics.checkNotNullParameter((Object)activity, (String)"activity");
        }

        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            Intrinsics.checkNotNullParameter((Object)activity, (String)"activity");
            Companion.dispatch$lifecycle_runtime_release(activity, Lifecycle.Event.ON_CREATE);
        }

        public void onActivityPostResumed(Activity activity) {
            Intrinsics.checkNotNullParameter((Object)activity, (String)"activity");
            Companion.dispatch$lifecycle_runtime_release(activity, Lifecycle.Event.ON_RESUME);
        }

        public void onActivityPostStarted(Activity activity) {
            Intrinsics.checkNotNullParameter((Object)activity, (String)"activity");
            Companion.dispatch$lifecycle_runtime_release(activity, Lifecycle.Event.ON_START);
        }

        public void onActivityPreDestroyed(Activity activity) {
            Intrinsics.checkNotNullParameter((Object)activity, (String)"activity");
            Companion.dispatch$lifecycle_runtime_release(activity, Lifecycle.Event.ON_DESTROY);
        }

        public void onActivityPrePaused(Activity activity) {
            Intrinsics.checkNotNullParameter((Object)activity, (String)"activity");
            Companion.dispatch$lifecycle_runtime_release(activity, Lifecycle.Event.ON_PAUSE);
        }

        public void onActivityPreStopped(Activity activity) {
            Intrinsics.checkNotNullParameter((Object)activity, (String)"activity");
            Companion.dispatch$lifecycle_runtime_release(activity, Lifecycle.Event.ON_STOP);
        }

        public void onActivityResumed(Activity activity) {
            Intrinsics.checkNotNullParameter((Object)activity, (String)"activity");
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            Intrinsics.checkNotNullParameter((Object)activity, (String)"activity");
            Intrinsics.checkNotNullParameter((Object)bundle, (String)"bundle");
        }

        public void onActivityStarted(Activity activity) {
            Intrinsics.checkNotNullParameter((Object)activity, (String)"activity");
        }

        public void onActivityStopped(Activity activity) {
            Intrinsics.checkNotNullParameter((Object)activity, (String)"activity");
        }

        @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2={"Landroidx/lifecycle/ReportFragment$LifecycleCallbacks$Companion;", "", "()V", "registerIn", "", "activity", "Landroid/app/Activity;", "lifecycle-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public final void registerIn(Activity activity) {
                Intrinsics.checkNotNullParameter((Object)activity, (String)"activity");
                activity.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new LifecycleCallbacks());
            }
        }
    }
}

