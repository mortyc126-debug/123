/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.util.Log
 *  android.view.ViewGroup
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.fragment.app.strictmode;

import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.strictmode.FragmentReuseViolation;
import androidx.fragment.app.strictmode.FragmentStrictMode$$ExternalSyntheticLambda0;
import androidx.fragment.app.strictmode.FragmentStrictMode$$ExternalSyntheticLambda1;
import androidx.fragment.app.strictmode.FragmentTagUsageViolation;
import androidx.fragment.app.strictmode.GetRetainInstanceUsageViolation;
import androidx.fragment.app.strictmode.GetTargetFragmentRequestCodeUsageViolation;
import androidx.fragment.app.strictmode.GetTargetFragmentUsageViolation;
import androidx.fragment.app.strictmode.SetRetainInstanceUsageViolation;
import androidx.fragment.app.strictmode.SetTargetFragmentUsageViolation;
import androidx.fragment.app.strictmode.SetUserVisibleHintViolation;
import androidx.fragment.app.strictmode.Violation;
import androidx.fragment.app.strictmode.WrongFragmentContainerViolation;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003./0B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0004H\u0007J\u001a\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0007J \u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\"H\u0007J\u0018\u0010#\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010$\u001a\u00020%H\u0007J\u0018\u0010&\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0018\u0010'\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010(\u001a\u00020)H\u0002J0\u0010*\u001a\u00020%2\u0006\u0010\u0010\u001a\u00020\u00062\u000e\u0010+\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0,2\u000e\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120,H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u00061"}, d2={"Landroidx/fragment/app/strictmode/FragmentStrictMode;", "", "()V", "TAG", "", "defaultPolicy", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "getDefaultPolicy", "()Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "setDefaultPolicy", "(Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;)V", "getNearestPolicy", "fragment", "Landroidx/fragment/app/Fragment;", "handlePolicyViolation", "", "policy", "violation", "Landroidx/fragment/app/strictmode/Violation;", "logIfDebuggingEnabled", "onFragmentReuse", "previousFragmentId", "onFragmentTagUsage", "container", "Landroid/view/ViewGroup;", "onGetRetainInstanceUsage", "onGetTargetFragmentRequestCodeUsage", "onGetTargetFragmentUsage", "onPolicyViolation", "onSetRetainInstanceUsage", "onSetTargetFragmentUsage", "violatingFragment", "targetFragment", "requestCode", "", "onSetUserVisibleHint", "isVisibleToUser", "", "onWrongFragmentContainer", "runOnHostThread", "runnable", "Ljava/lang/Runnable;", "shouldHandlePolicyViolation", "fragmentClass", "Ljava/lang/Class;", "violationClass", "Flag", "OnViolationListener", "Policy", "fragment_release"}, k=1, mv={1, 6, 0}, xi=48)
public final class FragmentStrictMode {
    public static final FragmentStrictMode INSTANCE = new FragmentStrictMode();
    private static final String TAG = "FragmentStrictMode";
    private static Policy defaultPolicy = Policy.LAX;

    public static /* synthetic */ void $r8$lambda$3GEKar9k4mm28McDHO-XTHzF5lU(Policy policy, Violation violation) {
        FragmentStrictMode.handlePolicyViolation$lambda-0(policy, violation);
    }

    public static /* synthetic */ void $r8$lambda$ujbeN2H_kHMJp2XfgBvtZfltiz0(String string2, Violation violation) {
        FragmentStrictMode.handlePolicyViolation$lambda-1(string2, violation);
    }

    private FragmentStrictMode() {
    }

    private final Policy getNearestPolicy(Fragment object) {
        while (object != null) {
            if (((Fragment)object).isAdded()) {
                FragmentManager fragmentManager = ((Fragment)object).getParentFragmentManager();
                Intrinsics.checkNotNullExpressionValue((Object)fragmentManager, (String)"declaringFragment.parentFragmentManager");
                if (fragmentManager.getStrictModePolicy() != null) {
                    object = fragmentManager.getStrictModePolicy();
                    Intrinsics.checkNotNull((Object)object);
                    return object;
                }
            }
            object = ((Fragment)object).getParentFragment();
        }
        return defaultPolicy;
    }

    private final void handlePolicyViolation(Policy policy, Violation violation) {
        Fragment fragment = violation.getFragment();
        String string2 = fragment.getClass().getName();
        if (policy.getFlags$fragment_release().contains((Object)Flag.PENALTY_LOG)) {
            Log.d((String)TAG, (String)("Policy violation in " + string2), (Throwable)violation);
        }
        if (policy.getListener$fragment_release() != null) {
            this.runOnHostThread(fragment, new FragmentStrictMode$$ExternalSyntheticLambda0(policy, violation));
        }
        if (policy.getFlags$fragment_release().contains((Object)Flag.PENALTY_DEATH)) {
            this.runOnHostThread(fragment, new FragmentStrictMode$$ExternalSyntheticLambda1(string2, violation));
        }
    }

    private static final void handlePolicyViolation$lambda-0(Policy policy, Violation violation) {
        Intrinsics.checkNotNullParameter((Object)policy, (String)"$policy");
        Intrinsics.checkNotNullParameter((Object)violation, (String)"$violation");
        policy.getListener$fragment_release().onViolation(violation);
    }

    private static final void handlePolicyViolation$lambda-1(String string2, Violation violation) {
        Intrinsics.checkNotNullParameter((Object)violation, (String)"$violation");
        Log.e((String)TAG, (String)("Policy violation with PENALTY_DEATH in " + string2), (Throwable)violation);
        throw violation;
    }

    private final void logIfDebuggingEnabled(Violation violation) {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d((String)"FragmentManager", (String)("StrictMode violation in " + violation.getFragment().getClass().getName()), (Throwable)violation);
        }
    }

    @JvmStatic
    public static final void onFragmentReuse(Fragment fragment, String object) {
        Intrinsics.checkNotNullParameter((Object)fragment, (String)"fragment");
        Intrinsics.checkNotNullParameter((Object)object, (String)"previousFragmentId");
        Violation violation = new FragmentReuseViolation(fragment, (String)object);
        INSTANCE.logIfDebuggingEnabled(violation);
        object = INSTANCE.getNearestPolicy(fragment);
        if (((Policy)object).getFlags$fragment_release().contains((Object)Flag.DETECT_FRAGMENT_REUSE) && INSTANCE.shouldHandlePolicyViolation((Policy)object, fragment.getClass(), violation.getClass())) {
            INSTANCE.handlePolicyViolation((Policy)object, violation);
        }
    }

    @JvmStatic
    public static final void onFragmentTagUsage(Fragment fragment, ViewGroup object) {
        Intrinsics.checkNotNullParameter((Object)fragment, (String)"fragment");
        object = new FragmentTagUsageViolation(fragment, (ViewGroup)object);
        INSTANCE.logIfDebuggingEnabled((Violation)object);
        Policy policy = INSTANCE.getNearestPolicy(fragment);
        if (policy.getFlags$fragment_release().contains((Object)Flag.DETECT_FRAGMENT_TAG_USAGE) && INSTANCE.shouldHandlePolicyViolation(policy, fragment.getClass(), object.getClass())) {
            INSTANCE.handlePolicyViolation(policy, (Violation)object);
        }
    }

    @JvmStatic
    public static final void onGetRetainInstanceUsage(Fragment fragment) {
        Intrinsics.checkNotNullParameter((Object)fragment, (String)"fragment");
        Violation violation = new GetRetainInstanceUsageViolation(fragment);
        INSTANCE.logIfDebuggingEnabled(violation);
        Policy policy = INSTANCE.getNearestPolicy(fragment);
        if (policy.getFlags$fragment_release().contains((Object)Flag.DETECT_RETAIN_INSTANCE_USAGE) && INSTANCE.shouldHandlePolicyViolation(policy, fragment.getClass(), violation.getClass())) {
            INSTANCE.handlePolicyViolation(policy, violation);
        }
    }

    @JvmStatic
    public static final void onGetTargetFragmentRequestCodeUsage(Fragment fragment) {
        Intrinsics.checkNotNullParameter((Object)fragment, (String)"fragment");
        Violation violation = new GetTargetFragmentRequestCodeUsageViolation(fragment);
        INSTANCE.logIfDebuggingEnabled(violation);
        Policy policy = INSTANCE.getNearestPolicy(fragment);
        if (policy.getFlags$fragment_release().contains((Object)Flag.DETECT_TARGET_FRAGMENT_USAGE) && INSTANCE.shouldHandlePolicyViolation(policy, fragment.getClass(), violation.getClass())) {
            INSTANCE.handlePolicyViolation(policy, violation);
        }
    }

    @JvmStatic
    public static final void onGetTargetFragmentUsage(Fragment fragment) {
        Intrinsics.checkNotNullParameter((Object)fragment, (String)"fragment");
        Violation violation = new GetTargetFragmentUsageViolation(fragment);
        INSTANCE.logIfDebuggingEnabled(violation);
        Policy policy = INSTANCE.getNearestPolicy(fragment);
        if (policy.getFlags$fragment_release().contains((Object)Flag.DETECT_TARGET_FRAGMENT_USAGE) && INSTANCE.shouldHandlePolicyViolation(policy, fragment.getClass(), violation.getClass())) {
            INSTANCE.handlePolicyViolation(policy, violation);
        }
    }

    @JvmStatic
    public static final void onSetRetainInstanceUsage(Fragment fragment) {
        Intrinsics.checkNotNullParameter((Object)fragment, (String)"fragment");
        Violation violation = new SetRetainInstanceUsageViolation(fragment);
        INSTANCE.logIfDebuggingEnabled(violation);
        Policy policy = INSTANCE.getNearestPolicy(fragment);
        if (policy.getFlags$fragment_release().contains((Object)Flag.DETECT_RETAIN_INSTANCE_USAGE) && INSTANCE.shouldHandlePolicyViolation(policy, fragment.getClass(), violation.getClass())) {
            INSTANCE.handlePolicyViolation(policy, violation);
        }
    }

    @JvmStatic
    public static final void onSetTargetFragmentUsage(Fragment fragment, Fragment object, int n) {
        Intrinsics.checkNotNullParameter((Object)fragment, (String)"violatingFragment");
        Intrinsics.checkNotNullParameter((Object)object, (String)"targetFragment");
        Violation violation = new SetTargetFragmentUsageViolation(fragment, (Fragment)object, n);
        INSTANCE.logIfDebuggingEnabled(violation);
        object = INSTANCE.getNearestPolicy(fragment);
        if (((Policy)object).getFlags$fragment_release().contains((Object)Flag.DETECT_TARGET_FRAGMENT_USAGE) && INSTANCE.shouldHandlePolicyViolation((Policy)object, fragment.getClass(), violation.getClass())) {
            INSTANCE.handlePolicyViolation((Policy)object, violation);
        }
    }

    @JvmStatic
    public static final void onSetUserVisibleHint(Fragment fragment, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)fragment, (String)"fragment");
        Violation violation = new SetUserVisibleHintViolation(fragment, bl);
        INSTANCE.logIfDebuggingEnabled(violation);
        Policy policy = INSTANCE.getNearestPolicy(fragment);
        if (policy.getFlags$fragment_release().contains((Object)Flag.DETECT_SET_USER_VISIBLE_HINT) && INSTANCE.shouldHandlePolicyViolation(policy, fragment.getClass(), violation.getClass())) {
            INSTANCE.handlePolicyViolation(policy, violation);
        }
    }

    @JvmStatic
    public static final void onWrongFragmentContainer(Fragment fragment, ViewGroup object) {
        Intrinsics.checkNotNullParameter((Object)fragment, (String)"fragment");
        Intrinsics.checkNotNullParameter((Object)object, (String)"container");
        object = new WrongFragmentContainerViolation(fragment, (ViewGroup)object);
        INSTANCE.logIfDebuggingEnabled((Violation)object);
        Policy policy = INSTANCE.getNearestPolicy(fragment);
        if (policy.getFlags$fragment_release().contains((Object)Flag.DETECT_WRONG_FRAGMENT_CONTAINER) && INSTANCE.shouldHandlePolicyViolation(policy, fragment.getClass(), object.getClass())) {
            INSTANCE.handlePolicyViolation(policy, (Violation)object);
        }
    }

    private final void runOnHostThread(Fragment fragment, Runnable runnable2) {
        if (fragment.isAdded()) {
            fragment = fragment.getParentFragmentManager().getHost().getHandler();
            Intrinsics.checkNotNullExpressionValue((Object)fragment, (String)"fragment.parentFragmentManager.host.handler");
            if (Intrinsics.areEqual((Object)fragment.getLooper(), (Object)Looper.myLooper())) {
                runnable2.run();
            } else {
                fragment.post(runnable2);
            }
        } else {
            runnable2.run();
        }
    }

    private final boolean shouldHandlePolicyViolation(Policy object, Class<? extends Fragment> object2, Class<? extends Violation> clazz) {
        object2 = ((Class)object2).getName();
        if ((object = ((Policy)object).getMAllowedViolations$fragment_release().get(object2)) == null) {
            return true;
        }
        if (!Intrinsics.areEqual(clazz.getSuperclass(), Violation.class) && CollectionsKt.contains((Iterable)((Iterable)object), clazz.getSuperclass())) {
            return false;
        }
        return true ^ object.contains(clazz);
    }

    public final Policy getDefaultPolicy() {
        return defaultPolicy;
    }

    public final void onPolicyViolation(Violation violation) {
        Intrinsics.checkNotNullParameter((Object)violation, (String)"violation");
        this.logIfDebuggingEnabled(violation);
        Fragment fragment = violation.getFragment();
        Policy policy = this.getNearestPolicy(fragment);
        if (this.shouldHandlePolicyViolation(policy, fragment.getClass(), violation.getClass())) {
            this.handlePolicyViolation(policy, violation);
        }
    }

    public final void setDefaultPolicy(Policy policy) {
        Intrinsics.checkNotNullParameter((Object)policy, (String)"<set-?>");
        defaultPolicy = policy;
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2={"Landroidx/fragment/app/strictmode/FragmentStrictMode$Flag;", "", "(Ljava/lang/String;I)V", "PENALTY_LOG", "PENALTY_DEATH", "DETECT_FRAGMENT_REUSE", "DETECT_FRAGMENT_TAG_USAGE", "DETECT_RETAIN_INSTANCE_USAGE", "DETECT_SET_USER_VISIBLE_HINT", "DETECT_TARGET_FRAGMENT_USAGE", "DETECT_WRONG_FRAGMENT_CONTAINER", "fragment_release"}, k=1, mv={1, 6, 0}, xi=48)
    public static enum Flag {
        PENALTY_LOG,
        PENALTY_DEATH,
        DETECT_FRAGMENT_REUSE,
        DETECT_FRAGMENT_TAG_USAGE,
        DETECT_RETAIN_INSTANCE_USAGE,
        DETECT_SET_USER_VISIBLE_HINT,
        DETECT_TARGET_FRAGMENT_USAGE,
        DETECT_WRONG_FRAGMENT_CONTAINER;

    }

    @Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2={"Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;", "", "onViolation", "", "violation", "Landroidx/fragment/app/strictmode/Violation;", "fragment_release"}, k=1, mv={1, 6, 0}, xi=48)
    public static interface OnViolationListener {
        public void onViolation(Violation var1);
    }

    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00162\u00020\u0001:\u0002\u0015\u0016BA\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012 \u0010\u0007\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\n0\b\u00a2\u0006\u0002\u0010\rR\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R.\u0010\u0012\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\u00030\bX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2={"Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "", "flags", "", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Flag;", "listener", "Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;", "allowedViolations", "", "", "", "Ljava/lang/Class;", "Landroidx/fragment/app/strictmode/Violation;", "(Ljava/util/Set;Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;Ljava/util/Map;)V", "getFlags$fragment_release", "()Ljava/util/Set;", "getListener$fragment_release", "()Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;", "mAllowedViolations", "getMAllowedViolations$fragment_release", "()Ljava/util/Map;", "Builder", "Companion", "fragment_release"}, k=1, mv={1, 6, 0}, xi=48)
    public static final class Policy {
        public static final Companion Companion = new Companion(null);
        public static final Policy LAX = new Policy(SetsKt.emptySet(), null, MapsKt.emptyMap());
        private final Set<Flag> flags;
        private final OnViolationListener listener;
        private final Map<String, Set<Class<? extends Violation>>> mAllowedViolations;

        public Policy(Set<? extends Flag> object, OnViolationListener object22, Map<String, ? extends Set<Class<? extends Violation>>> object3) {
            Iterator iterator2;
            Intrinsics.checkNotNullParameter((Object)object, (String)"flags");
            Intrinsics.checkNotNullParameter((Object)iterator2, (String)"allowedViolations");
            this.flags = object;
            this.listener = object22;
            object = new LinkedHashMap();
            for (Map.Entry entry : iterator2.entrySet()) {
                object.put((String)entry.getKey(), (Set)entry.getValue());
            }
            this.mAllowedViolations = object;
        }

        public final Set<Flag> getFlags$fragment_release() {
            return this.flags;
        }

        public final OnViolationListener getListener$fragment_release() {
            return this.listener;
        }

        public final Map<String, Set<Class<? extends Violation>>> getMAllowedViolations$fragment_release() {
            return this.mAllowedViolations;
        }

        @Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J(\u0010\r\u001a\u00020\u00002\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000b2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000bH\u0007J \u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000bH\u0007J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0000H\u0007J\b\u0010\u0014\u001a\u00020\u0000H\u0007J\b\u0010\u0015\u001a\u00020\u0000H\u0007J\b\u0010\u0016\u001a\u00020\u0000H\u0007J\b\u0010\u0017\u001a\u00020\u0000H\u0007J\b\u0010\u0018\u001a\u00020\u0000H\u0007J\b\u0010\u0019\u001a\u00020\u0000H\u0007J\u0010\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\u001b\u001a\u00020\u0000H\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R(\u0010\b\u001a\u001c\u0012\u0004\u0012\u00020\n\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\u00040\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2={"Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy$Builder;", "", "()V", "flags", "", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Flag;", "listener", "Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;", "mAllowedViolations", "", "", "Ljava/lang/Class;", "Landroidx/fragment/app/strictmode/Violation;", "allowViolation", "fragmentClass", "Landroidx/fragment/app/Fragment;", "violationClass", "build", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "detectFragmentReuse", "detectFragmentTagUsage", "detectRetainInstanceUsage", "detectSetUserVisibleHint", "detectTargetFragmentUsage", "detectWrongFragmentContainer", "penaltyDeath", "penaltyListener", "penaltyLog", "fragment_release"}, k=1, mv={1, 6, 0}, xi=48)
        public static final class Builder {
            private final Set<Flag> flags = new LinkedHashSet();
            private OnViolationListener listener;
            private final Map<String, Set<Class<? extends Violation>>> mAllowedViolations = new LinkedHashMap();

            public final Builder allowViolation(Class<? extends Fragment> object, Class<? extends Violation> clazz) {
                Intrinsics.checkNotNullParameter(object, (String)"fragmentClass");
                Intrinsics.checkNotNullParameter(clazz, (String)"violationClass");
                object = ((Class)object).getName();
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"fragmentClassString");
                return this.allowViolation((String)object, clazz);
            }

            public final Builder allowViolation(String string2, Class<? extends Violation> clazz) {
                Set set;
                Intrinsics.checkNotNullParameter((Object)string2, (String)"fragmentClass");
                Intrinsics.checkNotNullParameter(clazz, (String)"violationClass");
                Set set2 = set = this.mAllowedViolations.get(string2);
                if (set == null) {
                    set2 = new LinkedHashSet();
                }
                set2.add(clazz);
                this.mAllowedViolations.put(string2, set2);
                return this;
            }

            public final Policy build() {
                if (this.listener == null && !this.flags.contains((Object)Flag.PENALTY_DEATH)) {
                    this.penaltyLog();
                }
                return new Policy(this.flags, this.listener, this.mAllowedViolations);
            }

            public final Builder detectFragmentReuse() {
                this.flags.add(Flag.DETECT_FRAGMENT_REUSE);
                return this;
            }

            public final Builder detectFragmentTagUsage() {
                this.flags.add(Flag.DETECT_FRAGMENT_TAG_USAGE);
                return this;
            }

            public final Builder detectRetainInstanceUsage() {
                this.flags.add(Flag.DETECT_RETAIN_INSTANCE_USAGE);
                return this;
            }

            public final Builder detectSetUserVisibleHint() {
                this.flags.add(Flag.DETECT_SET_USER_VISIBLE_HINT);
                return this;
            }

            public final Builder detectTargetFragmentUsage() {
                this.flags.add(Flag.DETECT_TARGET_FRAGMENT_USAGE);
                return this;
            }

            public final Builder detectWrongFragmentContainer() {
                this.flags.add(Flag.DETECT_WRONG_FRAGMENT_CONTAINER);
                return this;
            }

            public final Builder penaltyDeath() {
                this.flags.add(Flag.PENALTY_DEATH);
                return this;
            }

            public final Builder penaltyListener(OnViolationListener onViolationListener) {
                Intrinsics.checkNotNullParameter((Object)onViolationListener, (String)"listener");
                this.listener = onViolationListener;
                return this;
            }

            public final Builder penaltyLog() {
                this.flags.add(Flag.PENALTY_LOG);
                return this;
            }
        }

        @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2={"Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy$Companion;", "", "()V", "LAX", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "fragment_release"}, k=1, mv={1, 6, 0}, xi=48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }
}

