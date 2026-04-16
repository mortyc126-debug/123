/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.ext.SdkExtensions
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.annotation.AnnotationRetention
 *  kotlin.annotation.Retention
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.core.os;

import android.os.Build;
import android.os.ext.SdkExtensions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u0019\u001aB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\tH\u0007J\b\u0010\u000b\u001a\u00020\tH\u0007J\b\u0010\f\u001a\u00020\tH\u0007J\b\u0010\r\u001a\u00020\tH\u0007J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J\b\u0010\u0012\u001a\u00020\tH\u0007J\b\u0010\u0013\u001a\u00020\tH\u0007J\b\u0010\u0014\u001a\u00020\tH\u0007J\b\u0010\u0015\u001a\u00020\tH\u0007J\b\u0010\u0016\u001a\u00020\tH\u0007J\b\u0010\u0017\u001a\u00020\tH\u0007J\b\u0010\u0018\u001a\u00020\tH\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2={"Landroidx/core/os/BuildCompat;", "", "()V", "AD_SERVICES_EXTENSION_INT", "", "R_EXTENSION_INT", "S_EXTENSION_INT", "T_EXTENSION_INT", "isAtLeastN", "", "isAtLeastNMR1", "isAtLeastO", "isAtLeastOMR1", "isAtLeastP", "isAtLeastPreReleaseCodename", "codename", "", "buildCodename", "isAtLeastQ", "isAtLeastR", "isAtLeastS", "isAtLeastSv2", "isAtLeastT", "isAtLeastU", "isAtLeastV", "Api30Impl", "PrereleaseSdkCheck", "core_release"}, k=1, mv={1, 8, 0}, xi=48)
public final class BuildCompat {
    public static final int AD_SERVICES_EXTENSION_INT;
    public static final BuildCompat INSTANCE;
    public static final int R_EXTENSION_INT;
    public static final int S_EXTENSION_INT;
    public static final int T_EXTENSION_INT;

    static {
        INSTANCE = new BuildCompat();
        int n = Build.VERSION.SDK_INT;
        int n2 = 0;
        n = n >= 30 ? Api30Impl.INSTANCE.getExtensionVersion(30) : 0;
        R_EXTENSION_INT = n;
        n = Build.VERSION.SDK_INT >= 30 ? Api30Impl.INSTANCE.getExtensionVersion(31) : 0;
        S_EXTENSION_INT = n;
        n = Build.VERSION.SDK_INT >= 30 ? Api30Impl.INSTANCE.getExtensionVersion(33) : 0;
        T_EXTENSION_INT = n;
        n = Build.VERSION.SDK_INT >= 30 ? Api30Impl.INSTANCE.getExtensionVersion(1000000) : n2;
        AD_SERVICES_EXTENSION_INT = n;
    }

    private BuildCompat() {
    }

    @Deprecated(message="Android N is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 24`.", replaceWith=@ReplaceWith(expression="android.os.Build.VERSION.SDK_INT >= 24", imports={}))
    @JvmStatic
    public static final boolean isAtLeastN() {
        return true;
    }

    @Deprecated(message="Android N MR1 is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 25`.", replaceWith=@ReplaceWith(expression="android.os.Build.VERSION.SDK_INT >= 25", imports={}))
    @JvmStatic
    public static final boolean isAtLeastNMR1() {
        boolean bl = Build.VERSION.SDK_INT >= 25;
        return bl;
    }

    @Deprecated(message="Android O is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead use `Build.VERSION.SDK_INT >= 26`.", replaceWith=@ReplaceWith(expression="android.os.Build.VERSION.SDK_INT >= 26", imports={}))
    @JvmStatic
    public static final boolean isAtLeastO() {
        boolean bl = Build.VERSION.SDK_INT >= 26;
        return bl;
    }

    @Deprecated(message="Android O MR1 is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 27`.", replaceWith=@ReplaceWith(expression="android.os.Build.VERSION.SDK_INT >= 27", imports={}))
    @JvmStatic
    public static final boolean isAtLeastOMR1() {
        boolean bl = Build.VERSION.SDK_INT >= 27;
        return bl;
    }

    @Deprecated(message="Android P is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 28`.", replaceWith=@ReplaceWith(expression="android.os.Build.VERSION.SDK_INT >= 28", imports={}))
    @JvmStatic
    public static final boolean isAtLeastP() {
        boolean bl = Build.VERSION.SDK_INT >= 28;
        return bl;
    }

    @JvmStatic
    public static final boolean isAtLeastPreReleaseCodename(String string2, String string3) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"codename");
        Intrinsics.checkNotNullParameter((Object)string3, (String)"buildCodename");
        boolean bl = Intrinsics.areEqual((Object)"REL", (Object)string3);
        boolean bl2 = false;
        if (bl) {
            return false;
        }
        string3 = string3.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"this as java.lang.String).toUpperCase(Locale.ROOT)");
        string2 = string2.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"this as java.lang.String).toUpperCase(Locale.ROOT)");
        if (string3.compareTo(string2) >= 0) {
            bl2 = true;
        }
        return bl2;
    }

    @Deprecated(message="Android Q is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 29`.", replaceWith=@ReplaceWith(expression="android.os.Build.VERSION.SDK_INT >= 29", imports={}))
    @JvmStatic
    public static final boolean isAtLeastQ() {
        boolean bl = Build.VERSION.SDK_INT >= 29;
        return bl;
    }

    @Deprecated(message="Android R is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 30`.", replaceWith=@ReplaceWith(expression="android.os.Build.VERSION.SDK_INT >= 30", imports={}))
    @JvmStatic
    public static final boolean isAtLeastR() {
        boolean bl = Build.VERSION.SDK_INT >= 30;
        return bl;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Deprecated(message="Android S is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 31`.", replaceWith=@ReplaceWith(expression="android.os.Build.VERSION.SDK_INT >= 31", imports={}))
    @JvmStatic
    public static final boolean isAtLeastS() {
        if (Build.VERSION.SDK_INT >= 31) return true;
        if (Build.VERSION.SDK_INT < 30) return false;
        String string2 = Build.VERSION.CODENAME;
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"CODENAME");
        if (!BuildCompat.isAtLeastPreReleaseCodename("S", string2)) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Deprecated(message="Android Sv2 is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 32`.", replaceWith=@ReplaceWith(expression="android.os.Build.VERSION.SDK_INT >= 32", imports={}))
    @JvmStatic
    public static final boolean isAtLeastSv2() {
        if (Build.VERSION.SDK_INT >= 32) return true;
        if (Build.VERSION.SDK_INT < 31) return false;
        String string2 = Build.VERSION.CODENAME;
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"CODENAME");
        if (!BuildCompat.isAtLeastPreReleaseCodename("Sv2", string2)) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Deprecated(message="Android Tiramisu is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 33`.", replaceWith=@ReplaceWith(expression="android.os.Build.VERSION.SDK_INT >= 33", imports={}))
    @JvmStatic
    public static final boolean isAtLeastT() {
        if (Build.VERSION.SDK_INT >= 33) return true;
        if (Build.VERSION.SDK_INT < 32) return false;
        String string2 = Build.VERSION.CODENAME;
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"CODENAME");
        if (!BuildCompat.isAtLeastPreReleaseCodename("Tiramisu", string2)) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Deprecated(message="Android UpsideDownCase is a finalized release and this method is no longer necessary. It will be removed in a future release of this library. Instead, use `Build.VERSION.SDK_INT >= 34`.", replaceWith=@ReplaceWith(expression="android.os.Build.VERSION.SDK_INT >= 34", imports={}))
    @JvmStatic
    public static final boolean isAtLeastU() {
        if (Build.VERSION.SDK_INT >= 34) return true;
        if (Build.VERSION.SDK_INT < 33) return false;
        String string2 = Build.VERSION.CODENAME;
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"CODENAME");
        if (!BuildCompat.isAtLeastPreReleaseCodename("UpsideDownCake", string2)) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @JvmStatic
    public static final boolean isAtLeastV() {
        if (Build.VERSION.SDK_INT < 34) return false;
        String string2 = Build.VERSION.CODENAME;
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"CODENAME");
        if (!BuildCompat.isAtLeastPreReleaseCodename("VanillaIceCream", string2)) return false;
        return true;
    }

    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c3\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a8\u0006\u0006"}, d2={"Landroidx/core/os/BuildCompat$Api30Impl;", "", "()V", "getExtensionVersion", "", "extension", "core_release"}, k=1, mv={1, 8, 0}, xi=48)
    private static final class Api30Impl {
        public static final Api30Impl INSTANCE = new Api30Impl();

        private Api30Impl() {
        }

        public final int getExtensionVersion(int n) {
            return SdkExtensions.getExtensionVersion((int)n);
        }
    }

    @Retention(value=RetentionPolicy.CLASS)
    @Metadata(d1={"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2={"Landroidx/core/os/BuildCompat$PrereleaseSdkCheck;", "", "core_release"}, k=1, mv={1, 8, 0}, xi=48)
    @kotlin.annotation.Retention(value=AnnotationRetention.BINARY)
    public static @interface PrereleaseSdkCheck {
    }
}

