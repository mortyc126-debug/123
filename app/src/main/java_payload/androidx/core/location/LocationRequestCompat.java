/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.LocationRequest
 *  android.location.LocationRequest$Builder
 *  android.os.Build$VERSION
 */
package androidx.core.location;

import android.location.LocationRequest;
import android.os.Build;
import androidx.core.util.Preconditions;
import androidx.core.util.TimeUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class LocationRequestCompat {
    private static final long IMPLICIT_MIN_UPDATE_INTERVAL = -1L;
    public static final long PASSIVE_INTERVAL = Long.MAX_VALUE;
    public static final int QUALITY_BALANCED_POWER_ACCURACY = 102;
    public static final int QUALITY_HIGH_ACCURACY = 100;
    public static final int QUALITY_LOW_POWER = 104;
    final long mDurationMillis;
    final long mIntervalMillis;
    final long mMaxUpdateDelayMillis;
    final int mMaxUpdates;
    final float mMinUpdateDistanceMeters;
    final long mMinUpdateIntervalMillis;
    final int mQuality;

    LocationRequestCompat(long l, int n, long l2, int n2, long l3, float f, long l4) {
        this.mIntervalMillis = l;
        this.mQuality = n;
        this.mMinUpdateIntervalMillis = l3;
        this.mDurationMillis = l2;
        this.mMaxUpdates = n2;
        this.mMinUpdateDistanceMeters = f;
        this.mMaxUpdateDelayMillis = l4;
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (this == object) {
            return true;
        }
        if (!(object instanceof LocationRequestCompat)) {
            return false;
        }
        object = (LocationRequestCompat)object;
        if (this.mQuality != ((LocationRequestCompat)object).mQuality || this.mIntervalMillis != ((LocationRequestCompat)object).mIntervalMillis || this.mMinUpdateIntervalMillis != ((LocationRequestCompat)object).mMinUpdateIntervalMillis || this.mDurationMillis != ((LocationRequestCompat)object).mDurationMillis || this.mMaxUpdates != ((LocationRequestCompat)object).mMaxUpdates || Float.compare(((LocationRequestCompat)object).mMinUpdateDistanceMeters, this.mMinUpdateDistanceMeters) != 0 || this.mMaxUpdateDelayMillis != ((LocationRequestCompat)object).mMaxUpdateDelayMillis) {
            bl = false;
        }
        return bl;
    }

    public long getDurationMillis() {
        return this.mDurationMillis;
    }

    public long getIntervalMillis() {
        return this.mIntervalMillis;
    }

    public long getMaxUpdateDelayMillis() {
        return this.mMaxUpdateDelayMillis;
    }

    public int getMaxUpdates() {
        return this.mMaxUpdates;
    }

    public float getMinUpdateDistanceMeters() {
        return this.mMinUpdateDistanceMeters;
    }

    public long getMinUpdateIntervalMillis() {
        if (this.mMinUpdateIntervalMillis == -1L) {
            return this.mIntervalMillis;
        }
        return this.mMinUpdateIntervalMillis;
    }

    public int getQuality() {
        return this.mQuality;
    }

    public int hashCode() {
        return (this.mQuality * 31 + (int)(this.mIntervalMillis ^ this.mIntervalMillis >>> 32)) * 31 + (int)(this.mMinUpdateIntervalMillis ^ this.mMinUpdateIntervalMillis >>> 32);
    }

    public LocationRequest toLocationRequest() {
        return Api31Impl.toLocationRequest(this);
    }

    public LocationRequest toLocationRequest(String string2) {
        if (Build.VERSION.SDK_INT >= 31) {
            return this.toLocationRequest();
        }
        return (LocationRequest)Api19Impl.toLocationRequest(this, string2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Request[");
        if (this.mIntervalMillis != Long.MAX_VALUE) {
            stringBuilder.append("@");
            TimeUtils.formatDuration(this.mIntervalMillis, stringBuilder);
            switch (this.mQuality) {
                default: {
                    break;
                }
                case 104: {
                    stringBuilder.append(" LOW_POWER");
                    break;
                }
                case 102: {
                    stringBuilder.append(" BALANCED");
                    break;
                }
                case 100: {
                    stringBuilder.append(" HIGH_ACCURACY");
                    break;
                }
            }
        } else {
            stringBuilder.append("PASSIVE");
        }
        if (this.mDurationMillis != Long.MAX_VALUE) {
            stringBuilder.append(", duration=");
            TimeUtils.formatDuration(this.mDurationMillis, stringBuilder);
        }
        if (this.mMaxUpdates != Integer.MAX_VALUE) {
            stringBuilder.append(", maxUpdates=").append(this.mMaxUpdates);
        }
        if (this.mMinUpdateIntervalMillis != -1L && this.mMinUpdateIntervalMillis < this.mIntervalMillis) {
            stringBuilder.append(", minUpdateInterval=");
            TimeUtils.formatDuration(this.mMinUpdateIntervalMillis, stringBuilder);
        }
        if ((double)this.mMinUpdateDistanceMeters > 0.0) {
            stringBuilder.append(", minUpdateDistance=").append(this.mMinUpdateDistanceMeters);
        }
        if (this.mMaxUpdateDelayMillis / 2L > this.mIntervalMillis) {
            stringBuilder.append(", maxUpdateDelay=");
            TimeUtils.formatDuration(this.mMaxUpdateDelayMillis, stringBuilder);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    private static class Api19Impl {
        private static Method sCreateFromDeprecatedProviderMethod;
        private static Class<?> sLocationRequestClass;
        private static Method sSetExpireInMethod;
        private static Method sSetFastestIntervalMethod;
        private static Method sSetNumUpdatesMethod;
        private static Method sSetQualityMethod;

        private Api19Impl() {
        }

        public static Object toLocationRequest(LocationRequestCompat locationRequestCompat, String object) {
            block14: {
                if (sLocationRequestClass == null) {
                    sLocationRequestClass = Class.forName("android.location.LocationRequest");
                }
                if (sCreateFromDeprecatedProviderMethod == null) {
                    sCreateFromDeprecatedProviderMethod = sLocationRequestClass.getDeclaredMethod("createFromDeprecatedProvider", String.class, Long.TYPE, Float.TYPE, Boolean.TYPE);
                    sCreateFromDeprecatedProviderMethod.setAccessible(true);
                }
                if ((object = sCreateFromDeprecatedProviderMethod.invoke(null, object, locationRequestCompat.getIntervalMillis(), Float.valueOf(locationRequestCompat.getMinUpdateDistanceMeters()), false)) != null) break block14;
                return null;
            }
            try {
                if (sSetQualityMethod == null) {
                    sSetQualityMethod = sLocationRequestClass.getDeclaredMethod("setQuality", Integer.TYPE);
                    sSetQualityMethod.setAccessible(true);
                }
                sSetQualityMethod.invoke(object, locationRequestCompat.getQuality());
                if (sSetFastestIntervalMethod == null) {
                    sSetFastestIntervalMethod = sLocationRequestClass.getDeclaredMethod("setFastestInterval", Long.TYPE);
                    sSetFastestIntervalMethod.setAccessible(true);
                }
                sSetFastestIntervalMethod.invoke(object, locationRequestCompat.getMinUpdateIntervalMillis());
                if (locationRequestCompat.getMaxUpdates() < Integer.MAX_VALUE) {
                    if (sSetNumUpdatesMethod == null) {
                        sSetNumUpdatesMethod = sLocationRequestClass.getDeclaredMethod("setNumUpdates", Integer.TYPE);
                        sSetNumUpdatesMethod.setAccessible(true);
                    }
                    sSetNumUpdatesMethod.invoke(object, locationRequestCompat.getMaxUpdates());
                }
                if (locationRequestCompat.getDurationMillis() < Long.MAX_VALUE) {
                    if (sSetExpireInMethod == null) {
                        sSetExpireInMethod = sLocationRequestClass.getDeclaredMethod("setExpireIn", Long.TYPE);
                        sSetExpireInMethod.setAccessible(true);
                    }
                    sSetExpireInMethod.invoke(object, locationRequestCompat.getDurationMillis());
                }
                return object;
            }
            catch (ClassNotFoundException classNotFoundException) {
            }
            catch (IllegalAccessException illegalAccessException) {
            }
            catch (InvocationTargetException invocationTargetException) {
            }
            catch (NoSuchMethodException noSuchMethodException) {
                // empty catch block
            }
            return null;
        }
    }

    private static class Api31Impl {
        private Api31Impl() {
        }

        public static LocationRequest toLocationRequest(LocationRequestCompat locationRequestCompat) {
            return new LocationRequest.Builder(locationRequestCompat.getIntervalMillis()).setQuality(locationRequestCompat.getQuality()).setMinUpdateIntervalMillis(locationRequestCompat.getMinUpdateIntervalMillis()).setDurationMillis(locationRequestCompat.getDurationMillis()).setMaxUpdates(locationRequestCompat.getMaxUpdates()).setMinUpdateDistanceMeters(locationRequestCompat.getMinUpdateDistanceMeters()).setMaxUpdateDelayMillis(locationRequestCompat.getMaxUpdateDelayMillis()).build();
        }
    }

    public static final class Builder {
        private long mDurationMillis;
        private long mIntervalMillis;
        private long mMaxUpdateDelayMillis;
        private int mMaxUpdates;
        private float mMinUpdateDistanceMeters;
        private long mMinUpdateIntervalMillis;
        private int mQuality;

        public Builder(long l) {
            this.setIntervalMillis(l);
            this.mQuality = 102;
            this.mDurationMillis = Long.MAX_VALUE;
            this.mMaxUpdates = Integer.MAX_VALUE;
            this.mMinUpdateIntervalMillis = -1L;
            this.mMinUpdateDistanceMeters = 0.0f;
            this.mMaxUpdateDelayMillis = 0L;
        }

        public Builder(LocationRequestCompat locationRequestCompat) {
            this.mIntervalMillis = locationRequestCompat.mIntervalMillis;
            this.mQuality = locationRequestCompat.mQuality;
            this.mDurationMillis = locationRequestCompat.mDurationMillis;
            this.mMaxUpdates = locationRequestCompat.mMaxUpdates;
            this.mMinUpdateIntervalMillis = locationRequestCompat.mMinUpdateIntervalMillis;
            this.mMinUpdateDistanceMeters = locationRequestCompat.mMinUpdateDistanceMeters;
            this.mMaxUpdateDelayMillis = locationRequestCompat.mMaxUpdateDelayMillis;
        }

        public LocationRequestCompat build() {
            boolean bl = this.mIntervalMillis != Long.MAX_VALUE || this.mMinUpdateIntervalMillis != -1L;
            Preconditions.checkState(bl, "passive location requests must have an explicit minimum update interval");
            return new LocationRequestCompat(this.mIntervalMillis, this.mQuality, this.mDurationMillis, this.mMaxUpdates, Math.min(this.mMinUpdateIntervalMillis, this.mIntervalMillis), this.mMinUpdateDistanceMeters, this.mMaxUpdateDelayMillis);
        }

        public Builder clearMinUpdateIntervalMillis() {
            this.mMinUpdateIntervalMillis = -1L;
            return this;
        }

        public Builder setDurationMillis(long l) {
            this.mDurationMillis = Preconditions.checkArgumentInRange(l, 1L, Long.MAX_VALUE, "durationMillis");
            return this;
        }

        public Builder setIntervalMillis(long l) {
            this.mIntervalMillis = Preconditions.checkArgumentInRange(l, 0L, Long.MAX_VALUE, "intervalMillis");
            return this;
        }

        public Builder setMaxUpdateDelayMillis(long l) {
            this.mMaxUpdateDelayMillis = l;
            this.mMaxUpdateDelayMillis = Preconditions.checkArgumentInRange(l, 0L, Long.MAX_VALUE, "maxUpdateDelayMillis");
            return this;
        }

        public Builder setMaxUpdates(int n) {
            this.mMaxUpdates = Preconditions.checkArgumentInRange(n, 1, Integer.MAX_VALUE, "maxUpdates");
            return this;
        }

        public Builder setMinUpdateDistanceMeters(float f) {
            this.mMinUpdateDistanceMeters = f;
            this.mMinUpdateDistanceMeters = Preconditions.checkArgumentInRange(f, 0.0f, Float.MAX_VALUE, "minUpdateDistanceMeters");
            return this;
        }

        public Builder setMinUpdateIntervalMillis(long l) {
            this.mMinUpdateIntervalMillis = Preconditions.checkArgumentInRange(l, 0L, Long.MAX_VALUE, "minUpdateIntervalMillis");
            return this;
        }

        public Builder setQuality(int n) {
            boolean bl = n == 104 || n == 102 || n == 100;
            Preconditions.checkArgument(bl, "quality must be a defined QUALITY constant, not %d", n);
            this.mQuality = n;
            return this;
        }
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface Quality {
    }
}

