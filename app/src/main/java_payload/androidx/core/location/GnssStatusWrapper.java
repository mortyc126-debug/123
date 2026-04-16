/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.GnssStatus
 *  android.os.Build$VERSION
 */
package androidx.core.location;

import android.location.GnssStatus;
import android.os.Build;
import androidx.core.location.GnssStatusCompat;
import androidx.core.util.Preconditions;

class GnssStatusWrapper
extends GnssStatusCompat {
    private final GnssStatus mWrapped;

    GnssStatusWrapper(Object object) {
        this.mWrapped = Preconditions.checkNotNull((GnssStatus)object);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof GnssStatusWrapper)) {
            return false;
        }
        object = (GnssStatusWrapper)object;
        return this.mWrapped.equals((Object)((GnssStatusWrapper)object).mWrapped);
    }

    @Override
    public float getAzimuthDegrees(int n) {
        return this.mWrapped.getAzimuthDegrees(n);
    }

    @Override
    public float getBasebandCn0DbHz(int n) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getBasebandCn0DbHz(this.mWrapped, n);
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public float getCarrierFrequencyHz(int n) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getCarrierFrequencyHz(this.mWrapped, n);
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public float getCn0DbHz(int n) {
        return this.mWrapped.getCn0DbHz(n);
    }

    @Override
    public int getConstellationType(int n) {
        return this.mWrapped.getConstellationType(n);
    }

    @Override
    public float getElevationDegrees(int n) {
        return this.mWrapped.getElevationDegrees(n);
    }

    @Override
    public int getSatelliteCount() {
        return this.mWrapped.getSatelliteCount();
    }

    @Override
    public int getSvid(int n) {
        return this.mWrapped.getSvid(n);
    }

    @Override
    public boolean hasAlmanacData(int n) {
        return this.mWrapped.hasAlmanacData(n);
    }

    @Override
    public boolean hasBasebandCn0DbHz(int n) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.hasBasebandCn0DbHz(this.mWrapped, n);
        }
        return false;
    }

    @Override
    public boolean hasCarrierFrequencyHz(int n) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.hasCarrierFrequencyHz(this.mWrapped, n);
        }
        return false;
    }

    @Override
    public boolean hasEphemerisData(int n) {
        return this.mWrapped.hasEphemerisData(n);
    }

    public int hashCode() {
        return this.mWrapped.hashCode();
    }

    @Override
    public boolean usedInFix(int n) {
        return this.mWrapped.usedInFix(n);
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static float getCarrierFrequencyHz(GnssStatus gnssStatus, int n) {
            return gnssStatus.getCarrierFrequencyHz(n);
        }

        static boolean hasCarrierFrequencyHz(GnssStatus gnssStatus, int n) {
            return gnssStatus.hasCarrierFrequencyHz(n);
        }
    }

    static class Api30Impl {
        private Api30Impl() {
        }

        static float getBasebandCn0DbHz(GnssStatus gnssStatus, int n) {
            return gnssStatus.getBasebandCn0DbHz(n);
        }

        static boolean hasBasebandCn0DbHz(GnssStatus gnssStatus, int n) {
            return gnssStatus.hasBasebandCn0DbHz(n);
        }
    }
}

