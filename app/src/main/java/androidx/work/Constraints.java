/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work;

import android.net.Uri;
import androidx.work.NetworkType;
import androidx.work.impl.utils.DurationApi26Impl;
import java.time.Duration;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0003!\"#B/\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\bB9\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\nB]\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\u0002\u0010\u0011B\u000f\b\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0000\u00a2\u0006\u0002\u0010\u0013J\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0097\u0002J\b\u0010\u001c\u001a\u00020\u0005H\u0007J\b\u0010\u001d\u001a\u00020\u001eH\u0017J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010\t\u001a\u00020\u0005H\u0007J\u0006\u0010\u0007\u001a\u00020\u0005J\b\u0010\u001f\u001a\u00020 H\u0017R\u0016\u0010\r\u001a\u00020\f8GX\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\f8GX\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8GX\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u0006\u001a\u00020\u00058\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00058\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00058\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2={"Landroidx/work/Constraints;", "", "requiredNetworkType", "Landroidx/work/NetworkType;", "requiresCharging", "", "requiresBatteryNotLow", "requiresStorageNotLow", "(Landroidx/work/NetworkType;ZZZ)V", "requiresDeviceIdle", "(Landroidx/work/NetworkType;ZZZZ)V", "contentTriggerUpdateDelayMillis", "", "contentTriggerMaxDelayMillis", "contentUriTriggers", "", "Landroidx/work/Constraints$ContentUriTrigger;", "(Landroidx/work/NetworkType;ZZZZJJLjava/util/Set;)V", "other", "(Landroidx/work/Constraints;)V", "getContentTriggerMaxDelayMillis", "()J", "getContentTriggerUpdateDelayMillis", "getContentUriTriggers", "()Ljava/util/Set;", "getRequiredNetworkType", "()Landroidx/work/NetworkType;", "equals", "hasContentUriTriggers", "hashCode", "", "toString", "", "Builder", "Companion", "ContentUriTrigger", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public final class Constraints {
    public static final Companion Companion = new Companion(null);
    public static final Constraints NONE = new Constraints(null, false, false, false, 15, null);
    private final long contentTriggerMaxDelayMillis;
    private final long contentTriggerUpdateDelayMillis;
    private final Set<ContentUriTrigger> contentUriTriggers;
    private final NetworkType requiredNetworkType;
    private final boolean requiresBatteryNotLow;
    private final boolean requiresCharging;
    private final boolean requiresDeviceIdle;
    private final boolean requiresStorageNotLow;

    public Constraints(Constraints constraints) {
        Intrinsics.checkNotNullParameter((Object)constraints, (String)"other");
        this.requiresCharging = constraints.requiresCharging;
        this.requiresDeviceIdle = constraints.requiresDeviceIdle;
        this.requiredNetworkType = constraints.requiredNetworkType;
        this.requiresBatteryNotLow = constraints.requiresBatteryNotLow;
        this.requiresStorageNotLow = constraints.requiresStorageNotLow;
        this.contentUriTriggers = constraints.contentUriTriggers;
        this.contentTriggerUpdateDelayMillis = constraints.contentTriggerUpdateDelayMillis;
        this.contentTriggerMaxDelayMillis = constraints.contentTriggerMaxDelayMillis;
    }

    public Constraints(NetworkType networkType, boolean bl, boolean bl2, boolean bl3) {
        Intrinsics.checkNotNullParameter((Object)((Object)networkType), (String)"requiredNetworkType");
        this(networkType, bl, false, bl2, bl3);
    }

    public /* synthetic */ Constraints(NetworkType networkType, boolean bl, boolean bl2, boolean bl3, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            networkType = NetworkType.NOT_REQUIRED;
        }
        if ((n & 2) != 0) {
            bl = false;
        }
        if ((n & 4) != 0) {
            bl2 = false;
        }
        if ((n & 8) != 0) {
            bl3 = false;
        }
        this(networkType, bl, bl2, bl3);
    }

    public Constraints(NetworkType networkType, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        Intrinsics.checkNotNullParameter((Object)((Object)networkType), (String)"requiredNetworkType");
        this(networkType, bl, bl2, bl3, bl4, -1L, 0L, null, 192, null);
    }

    public /* synthetic */ Constraints(NetworkType networkType, boolean bl, boolean bl2, boolean bl3, boolean bl4, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            networkType = NetworkType.NOT_REQUIRED;
        }
        boolean bl5 = false;
        if ((n & 2) != 0) {
            bl = false;
        }
        if ((n & 4) != 0) {
            bl2 = false;
        }
        if ((n & 8) != 0) {
            bl3 = false;
        }
        if ((n & 0x10) != 0) {
            bl4 = bl5;
        }
        this(networkType, bl, bl2, bl3, bl4);
    }

    public Constraints(NetworkType networkType, boolean bl, boolean bl2, boolean bl3, boolean bl4, long l, long l2, Set<ContentUriTrigger> set) {
        Intrinsics.checkNotNullParameter((Object)((Object)networkType), (String)"requiredNetworkType");
        Intrinsics.checkNotNullParameter(set, (String)"contentUriTriggers");
        this.requiredNetworkType = networkType;
        this.requiresCharging = bl;
        this.requiresDeviceIdle = bl2;
        this.requiresBatteryNotLow = bl3;
        this.requiresStorageNotLow = bl4;
        this.contentTriggerUpdateDelayMillis = l;
        this.contentTriggerMaxDelayMillis = l2;
        this.contentUriTriggers = set;
    }

    public /* synthetic */ Constraints(NetworkType networkType, boolean bl, boolean bl2, boolean bl3, boolean bl4, long l, long l2, Set set, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            networkType = NetworkType.NOT_REQUIRED;
        }
        boolean bl5 = false;
        if ((n & 2) != 0) {
            bl = false;
        }
        if ((n & 4) != 0) {
            bl2 = false;
        }
        if ((n & 8) != 0) {
            bl3 = false;
        }
        if ((n & 0x10) != 0) {
            bl4 = bl5;
        }
        long l3 = -1L;
        if ((n & 0x20) != 0) {
            l = -1L;
        }
        if ((n & 0x40) != 0) {
            l2 = l3;
        }
        if ((n & 0x80) != 0) {
            set = SetsKt.emptySet();
        }
        this(networkType, bl, bl2, bl3, bl4, l, l2, set);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl = false;
        if (object != null && Intrinsics.areEqual(this.getClass(), object.getClass())) {
            object = (Constraints)object;
            if (this.requiresCharging != ((Constraints)object).requiresCharging) {
                return false;
            }
            if (this.requiresDeviceIdle != ((Constraints)object).requiresDeviceIdle) {
                return false;
            }
            if (this.requiresBatteryNotLow != ((Constraints)object).requiresBatteryNotLow) {
                return false;
            }
            if (this.requiresStorageNotLow != ((Constraints)object).requiresStorageNotLow) {
                return false;
            }
            if (this.contentTriggerUpdateDelayMillis != ((Constraints)object).contentTriggerUpdateDelayMillis) {
                return false;
            }
            if (this.contentTriggerMaxDelayMillis != ((Constraints)object).contentTriggerMaxDelayMillis) {
                return false;
            }
            if (this.requiredNetworkType == ((Constraints)object).requiredNetworkType) {
                bl = Intrinsics.areEqual(this.contentUriTriggers, ((Constraints)object).contentUriTriggers);
            }
            return bl;
        }
        return false;
    }

    public final long getContentTriggerMaxDelayMillis() {
        return this.contentTriggerMaxDelayMillis;
    }

    public final long getContentTriggerUpdateDelayMillis() {
        return this.contentTriggerUpdateDelayMillis;
    }

    public final Set<ContentUriTrigger> getContentUriTriggers() {
        return this.contentUriTriggers;
    }

    public final NetworkType getRequiredNetworkType() {
        return this.requiredNetworkType;
    }

    public final boolean hasContentUriTriggers() {
        boolean bl = ((Collection)this.contentUriTriggers).isEmpty();
        boolean bl2 = true;
        if (!(bl ^ true)) {
            bl2 = false;
        }
        return bl2;
    }

    public int hashCode() {
        return ((((((this.requiredNetworkType.hashCode() * 31 + this.requiresCharging) * 31 + this.requiresDeviceIdle) * 31 + this.requiresBatteryNotLow) * 31 + this.requiresStorageNotLow) * 31 + (int)(this.contentTriggerUpdateDelayMillis ^ this.contentTriggerUpdateDelayMillis >>> 32)) * 31 + (int)(this.contentTriggerMaxDelayMillis ^ this.contentTriggerMaxDelayMillis >>> 32)) * 31 + ((Object)this.contentUriTriggers).hashCode();
    }

    public final boolean requiresBatteryNotLow() {
        return this.requiresBatteryNotLow;
    }

    public final boolean requiresCharging() {
        return this.requiresCharging;
    }

    public final boolean requiresDeviceIdle() {
        return this.requiresDeviceIdle;
    }

    public final boolean requiresStorageNotLow() {
        return this.requiresStorageNotLow;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder().append("Constraints{requiredNetworkType=").append((Object)this.requiredNetworkType);
        stringBuilder = stringBuilder.append(", requiresCharging=").append(this.requiresCharging);
        stringBuilder = stringBuilder.append(", requiresDeviceIdle=").append(this.requiresDeviceIdle);
        stringBuilder = stringBuilder.append(", requiresBatteryNotLow=").append(this.requiresBatteryNotLow);
        stringBuilder = stringBuilder.append(", requiresStorageNotLow=").append(this.requiresStorageNotLow);
        stringBuilder = stringBuilder.append(", contentTriggerUpdateDelayMillis=").append(this.contentTriggerUpdateDelayMillis);
        stringBuilder = stringBuilder.append(", contentTriggerMaxDelayMillis=").append(this.contentTriggerMaxDelayMillis);
        stringBuilder = stringBuilder.append(", contentUriTriggers=").append(this.contentUriTriggers);
        return stringBuilder.append(", }").toString();
    }

    @Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u000f\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0007J\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\nJ\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\fH\u0007J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\fJ\u0010\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0018\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"H\u0007J\u0010\u0010#\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0018\u0010#\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"H\u0007R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2={"Landroidx/work/Constraints$Builder;", "", "()V", "constraints", "Landroidx/work/Constraints;", "(Landroidx/work/Constraints;)V", "contentUriTriggers", "", "Landroidx/work/Constraints$ContentUriTrigger;", "requiredNetworkType", "Landroidx/work/NetworkType;", "requiresBatteryNotLow", "", "requiresCharging", "requiresDeviceIdle", "requiresStorageNotLow", "triggerContentMaxDelay", "", "triggerContentUpdateDelay", "addContentUriTrigger", "uri", "Landroid/net/Uri;", "triggerForDescendants", "build", "setRequiredNetworkType", "networkType", "setRequiresBatteryNotLow", "setRequiresCharging", "setRequiresDeviceIdle", "setRequiresStorageNotLow", "setTriggerContentMaxDelay", "duration", "Ljava/time/Duration;", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "setTriggerContentUpdateDelay", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class Builder {
        private Set<ContentUriTrigger> contentUriTriggers;
        private NetworkType requiredNetworkType;
        private boolean requiresBatteryNotLow;
        private boolean requiresCharging;
        private boolean requiresDeviceIdle;
        private boolean requiresStorageNotLow;
        private long triggerContentMaxDelay;
        private long triggerContentUpdateDelay;

        public Builder() {
            this.requiredNetworkType = NetworkType.NOT_REQUIRED;
            this.triggerContentUpdateDelay = -1L;
            this.triggerContentMaxDelay = -1L;
            this.contentUriTriggers = new LinkedHashSet();
        }

        public Builder(Constraints constraints) {
            Intrinsics.checkNotNullParameter((Object)constraints, (String)"constraints");
            this.requiredNetworkType = NetworkType.NOT_REQUIRED;
            this.triggerContentUpdateDelay = -1L;
            this.triggerContentMaxDelay = -1L;
            this.contentUriTriggers = new LinkedHashSet();
            this.requiresCharging = constraints.requiresCharging();
            boolean bl = constraints.requiresDeviceIdle();
            this.requiresDeviceIdle = bl;
            this.requiredNetworkType = constraints.getRequiredNetworkType();
            this.requiresBatteryNotLow = constraints.requiresBatteryNotLow();
            this.requiresStorageNotLow = constraints.requiresStorageNotLow();
            this.triggerContentUpdateDelay = constraints.getContentTriggerUpdateDelayMillis();
            this.triggerContentMaxDelay = constraints.getContentTriggerMaxDelayMillis();
            this.contentUriTriggers = CollectionsKt.toMutableSet((Iterable)constraints.getContentUriTriggers());
        }

        public final Builder addContentUriTrigger(Uri uri, boolean bl) {
            Intrinsics.checkNotNullParameter((Object)uri, (String)"uri");
            this.contentUriTriggers.add(new ContentUriTrigger(uri, bl));
            return this;
        }

        public final Constraints build() {
            Set set = CollectionsKt.toSet((Iterable)this.contentUriTriggers);
            long l = this.triggerContentUpdateDelay;
            long l2 = this.triggerContentMaxDelay;
            boolean bl = this.requiresCharging;
            boolean bl2 = this.requiresDeviceIdle;
            NetworkType networkType = this.requiredNetworkType;
            boolean bl3 = this.requiresBatteryNotLow;
            boolean bl4 = this.requiresStorageNotLow;
            return new Constraints(networkType, bl, bl2, bl3, bl4, l, l2, set);
        }

        public final Builder setRequiredNetworkType(NetworkType networkType) {
            Intrinsics.checkNotNullParameter((Object)((Object)networkType), (String)"networkType");
            this.requiredNetworkType = networkType;
            return this;
        }

        public final Builder setRequiresBatteryNotLow(boolean bl) {
            this.requiresBatteryNotLow = bl;
            return this;
        }

        public final Builder setRequiresCharging(boolean bl) {
            this.requiresCharging = bl;
            return this;
        }

        public final Builder setRequiresDeviceIdle(boolean bl) {
            this.requiresDeviceIdle = bl;
            return this;
        }

        public final Builder setRequiresStorageNotLow(boolean bl) {
            this.requiresStorageNotLow = bl;
            return this;
        }

        public final Builder setTriggerContentMaxDelay(long l, TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"timeUnit");
            this.triggerContentMaxDelay = timeUnit.toMillis(l);
            return this;
        }

        public final Builder setTriggerContentMaxDelay(Duration duration) {
            Intrinsics.checkNotNullParameter((Object)duration, (String)"duration");
            this.triggerContentMaxDelay = DurationApi26Impl.toMillisCompat(duration);
            return this;
        }

        public final Builder setTriggerContentUpdateDelay(long l, TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"timeUnit");
            this.triggerContentUpdateDelay = timeUnit.toMillis(l);
            return this;
        }

        public final Builder setTriggerContentUpdateDelay(Duration duration) {
            Intrinsics.checkNotNullParameter((Object)duration, (String)"duration");
            this.triggerContentUpdateDelay = DurationApi26Impl.toMillisCompat(duration);
            return this;
        }
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2={"Landroidx/work/Constraints$Companion;", "", "()V", "NONE", "Landroidx/work/Constraints;", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0013\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2={"Landroidx/work/Constraints$ContentUriTrigger;", "", "uri", "Landroid/net/Uri;", "isTriggeredForDescendants", "", "(Landroid/net/Uri;Z)V", "()Z", "getUri", "()Landroid/net/Uri;", "equals", "other", "hashCode", "", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class ContentUriTrigger {
        private final boolean isTriggeredForDescendants;
        private final Uri uri;

        public ContentUriTrigger(Uri uri, boolean bl) {
            Intrinsics.checkNotNullParameter((Object)uri, (String)"uri");
            this.uri = uri;
            this.isTriggeredForDescendants = bl;
        }

        public boolean equals(Object object) {
            Class<?> clazz;
            if (this == object) {
                return true;
            }
            Class<?> clazz2 = this.getClass();
            if (!Intrinsics.areEqual(clazz2, clazz = object != null ? object.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type androidx.work.Constraints.ContentUriTrigger");
            clazz = (ContentUriTrigger)object;
            if (!Intrinsics.areEqual((Object)this.uri, (Object)((ContentUriTrigger)object).uri)) {
                return false;
            }
            return this.isTriggeredForDescendants == ((ContentUriTrigger)object).isTriggeredForDescendants;
        }

        public final Uri getUri() {
            return this.uri;
        }

        public int hashCode() {
            return this.uri.hashCode() * 31 + Boolean.hashCode(this.isTriggeredForDescendants);
        }

        public final boolean isTriggeredForDescendants() {
            return this.isTriggeredForDescendants;
        }
    }
}

