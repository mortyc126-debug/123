/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.GpsSatellite
 *  android.location.GpsStatus
 */
package androidx.core.location;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import androidx.core.location.GnssStatusCompat;
import androidx.core.util.Preconditions;
import java.util.Iterator;

class GpsStatusWrapper
extends GnssStatusCompat {
    private static final int BEIDOU_PRN_COUNT = 35;
    private static final int BEIDOU_PRN_OFFSET = 200;
    private static final int GLONASS_PRN_COUNT = 24;
    private static final int GLONASS_PRN_OFFSET = 64;
    private static final int GPS_PRN_COUNT = 32;
    private static final int GPS_PRN_OFFSET = 0;
    private static final int QZSS_SVID_MAX = 200;
    private static final int QZSS_SVID_MIN = 193;
    private static final int SBAS_PRN_MAX = 64;
    private static final int SBAS_PRN_MIN = 33;
    private static final int SBAS_PRN_OFFSET = -87;
    private Iterator<GpsSatellite> mCachedIterator;
    private int mCachedIteratorPosition;
    private GpsSatellite mCachedSatellite;
    private int mCachedSatelliteCount;
    private final GpsStatus mWrapped;

    GpsStatusWrapper(GpsStatus gpsStatus) {
        this.mWrapped = Preconditions.checkNotNull(gpsStatus);
        this.mCachedSatelliteCount = -1;
        this.mCachedIterator = this.mWrapped.getSatellites().iterator();
        this.mCachedIteratorPosition = -1;
        this.mCachedSatellite = null;
    }

    private static int getConstellationFromPrn(int n) {
        if (n > 0 && n <= 32) {
            return 1;
        }
        if (n >= 33 && n <= 64) {
            return 2;
        }
        if (n > 64 && n <= 88) {
            return 3;
        }
        if (n > 200 && n <= 235) {
            return 5;
        }
        if (n >= 193 && n <= 200) {
            return 4;
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private GpsSatellite getSatellite(int n) {
        GpsStatus gpsStatus = this.mWrapped;
        synchronized (gpsStatus) {
            if (n < this.mCachedIteratorPosition) {
                this.mCachedIterator = this.mWrapped.getSatellites().iterator();
                this.mCachedIteratorPosition = -1;
            }
            while (this.mCachedIteratorPosition < n) {
                ++this.mCachedIteratorPosition;
                if (!this.mCachedIterator.hasNext()) {
                    this.mCachedSatellite = null;
                    break;
                }
                this.mCachedSatellite = this.mCachedIterator.next();
            }
            GpsSatellite gpsSatellite = this.mCachedSatellite;
            return Preconditions.checkNotNull(gpsSatellite);
        }
    }

    private static int getSvidFromPrn(int n) {
        switch (GpsStatusWrapper.getConstellationFromPrn(n)) {
            default: {
                break;
            }
            case 5: {
                n -= 200;
                break;
            }
            case 3: {
                n -= 64;
                break;
            }
            case 2: {
                n += 87;
            }
        }
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof GpsStatusWrapper)) {
            return false;
        }
        object = (GpsStatusWrapper)object;
        return this.mWrapped.equals(((GpsStatusWrapper)object).mWrapped);
    }

    @Override
    public float getAzimuthDegrees(int n) {
        return this.getSatellite(n).getAzimuth();
    }

    @Override
    public float getBasebandCn0DbHz(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public float getCarrierFrequencyHz(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public float getCn0DbHz(int n) {
        return this.getSatellite(n).getSnr();
    }

    @Override
    public int getConstellationType(int n) {
        return GpsStatusWrapper.getConstellationFromPrn(this.getSatellite(n).getPrn());
    }

    @Override
    public float getElevationDegrees(int n) {
        return this.getSatellite(n).getElevation();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public int getSatelliteCount() {
        GpsStatus gpsStatus = this.mWrapped;
        synchronized (gpsStatus) {
            if (this.mCachedSatelliteCount != -1) return this.mCachedSatelliteCount;
            for (GpsSatellite gpsSatellite : this.mWrapped.getSatellites()) {
                ++this.mCachedSatelliteCount;
            }
            ++this.mCachedSatelliteCount;
            return this.mCachedSatelliteCount;
        }
    }

    @Override
    public int getSvid(int n) {
        return GpsStatusWrapper.getSvidFromPrn(this.getSatellite(n).getPrn());
    }

    @Override
    public boolean hasAlmanacData(int n) {
        return this.getSatellite(n).hasAlmanac();
    }

    @Override
    public boolean hasBasebandCn0DbHz(int n) {
        return false;
    }

    @Override
    public boolean hasCarrierFrequencyHz(int n) {
        return false;
    }

    @Override
    public boolean hasEphemerisData(int n) {
        return this.getSatellite(n).hasEphemeris();
    }

    public int hashCode() {
        return this.mWrapped.hashCode();
    }

    @Override
    public boolean usedInFix(int n) {
        return this.getSatellite(n).usedInFix();
    }
}

