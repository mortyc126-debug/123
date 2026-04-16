/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.LocusId
 *  android.os.Build$VERSION
 */
package androidx.core.content;

import android.content.LocusId;
import android.os.Build;
import androidx.core.util.Preconditions;

public final class LocusIdCompat {
    private final String mId;
    private final LocusId mWrapped;

    public LocusIdCompat(String string2) {
        this.mId = Preconditions.checkStringNotEmpty(string2, "id cannot be empty");
        this.mWrapped = Build.VERSION.SDK_INT >= 29 ? Api29Impl.create(string2) : null;
    }

    private String getSanitizedId() {
        int n = this.mId.length();
        return n + "_chars";
    }

    public static LocusIdCompat toLocusIdCompat(LocusId locusId) {
        Preconditions.checkNotNull(locusId, "locusId cannot be null");
        return new LocusIdCompat(Preconditions.checkStringNotEmpty(Api29Impl.getId(locusId), "id cannot be empty"));
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (LocusIdCompat)object;
        if (this.mId == null) {
            if (((LocusIdCompat)object).mId != null) {
                bl = false;
            }
            return bl;
        }
        return this.mId.equals(((LocusIdCompat)object).mId);
    }

    public String getId() {
        return this.mId;
    }

    public int hashCode() {
        int n = this.mId == null ? 0 : this.mId.hashCode();
        return 1 * 31 + n;
    }

    public LocusId toLocusId() {
        return this.mWrapped;
    }

    public String toString() {
        return "LocusIdCompat[" + this.getSanitizedId() + "]";
    }

    private static class Api29Impl {
        private Api29Impl() {
        }

        static LocusId create(String string2) {
            return new LocusId(string2);
        }

        static String getId(LocusId locusId) {
            return locusId.getId();
        }
    }
}

