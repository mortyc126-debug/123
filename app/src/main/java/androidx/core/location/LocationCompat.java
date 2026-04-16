/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.Location
 *  android.os.Build$VERSION
 *  android.os.Bundle
 */
package androidx.core.location;

import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public final class LocationCompat {
    public static final String EXTRA_BEARING_ACCURACY = "bearingAccuracy";
    public static final String EXTRA_IS_MOCK = "mockLocation";
    public static final String EXTRA_MSL_ALTITUDE = "androidx.core.location.extra.MSL_ALTITUDE";
    public static final String EXTRA_MSL_ALTITUDE_ACCURACY = "androidx.core.location.extra.MSL_ALTITUDE_ACCURACY";
    public static final String EXTRA_SPEED_ACCURACY = "speedAccuracy";
    public static final String EXTRA_VERTICAL_ACCURACY = "verticalAccuracy";
    private static Field sFieldsMaskField;
    private static Integer sHasBearingAccuracyMask;
    private static Integer sHasSpeedAccuracyMask;
    private static Integer sHasVerticalAccuracyMask;
    private static Method sSetIsFromMockProviderMethod;

    private LocationCompat() {
    }

    private static boolean containsExtra(Location location, String string2) {
        boolean bl = (location = location.getExtras()) != null && location.containsKey(string2);
        return bl;
    }

    public static float getBearingAccuracyDegrees(Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getBearingAccuracyDegrees(location);
        }
        if ((location = location.getExtras()) == null) {
            return 0.0f;
        }
        return location.getFloat(EXTRA_BEARING_ACCURACY, 0.0f);
    }

    public static long getElapsedRealtimeMillis(Location location) {
        return TimeUnit.NANOSECONDS.toMillis(location.getElapsedRealtimeNanos());
    }

    public static long getElapsedRealtimeNanos(Location location) {
        return location.getElapsedRealtimeNanos();
    }

    static Field getFieldsMaskField() throws NoSuchFieldException {
        if (sFieldsMaskField == null) {
            sFieldsMaskField = Location.class.getDeclaredField("mFieldsMask");
            sFieldsMaskField.setAccessible(true);
        }
        return sFieldsMaskField;
    }

    static int getHasBearingAccuracyMask() throws NoSuchFieldException, IllegalAccessException {
        if (sHasBearingAccuracyMask == null) {
            Field field = Location.class.getDeclaredField("HAS_BEARING_ACCURACY_MASK");
            field.setAccessible(true);
            sHasBearingAccuracyMask = field.getInt(null);
        }
        return sHasBearingAccuracyMask;
    }

    static int getHasSpeedAccuracyMask() throws NoSuchFieldException, IllegalAccessException {
        if (sHasSpeedAccuracyMask == null) {
            Field field = Location.class.getDeclaredField("HAS_SPEED_ACCURACY_MASK");
            field.setAccessible(true);
            sHasSpeedAccuracyMask = field.getInt(null);
        }
        return sHasSpeedAccuracyMask;
    }

    static int getHasVerticalAccuracyMask() throws NoSuchFieldException, IllegalAccessException {
        if (sHasVerticalAccuracyMask == null) {
            Field field = Location.class.getDeclaredField("HAS_VERTICAL_ACCURACY_MASK");
            field.setAccessible(true);
            sHasVerticalAccuracyMask = field.getInt(null);
        }
        return sHasVerticalAccuracyMask;
    }

    public static float getMslAltitudeAccuracyMeters(Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.getMslAltitudeAccuracyMeters(location);
        }
        return LocationCompat.getOrCreateExtras(location).getFloat(EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    public static double getMslAltitudeMeters(Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.getMslAltitudeMeters(location);
        }
        return LocationCompat.getOrCreateExtras(location).getDouble(EXTRA_MSL_ALTITUDE);
    }

    private static Bundle getOrCreateExtras(Location location) {
        Bundle bundle;
        Bundle bundle2 = bundle = location.getExtras();
        if (bundle == null) {
            location.setExtras(new Bundle());
            bundle2 = location.getExtras();
        }
        return bundle2;
    }

    private static Method getSetIsFromMockProviderMethod() throws NoSuchMethodException {
        if (sSetIsFromMockProviderMethod == null) {
            sSetIsFromMockProviderMethod = Location.class.getDeclaredMethod("setIsFromMockProvider", Boolean.TYPE);
            sSetIsFromMockProviderMethod.setAccessible(true);
        }
        return sSetIsFromMockProviderMethod;
    }

    public static float getSpeedAccuracyMetersPerSecond(Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getSpeedAccuracyMetersPerSecond(location);
        }
        if ((location = location.getExtras()) == null) {
            return 0.0f;
        }
        return location.getFloat(EXTRA_SPEED_ACCURACY, 0.0f);
    }

    public static float getVerticalAccuracyMeters(Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getVerticalAccuracyMeters(location);
        }
        if ((location = location.getExtras()) == null) {
            return 0.0f;
        }
        return location.getFloat(EXTRA_VERTICAL_ACCURACY, 0.0f);
    }

    public static boolean hasBearingAccuracy(Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.hasBearingAccuracy(location);
        }
        return LocationCompat.containsExtra(location, EXTRA_BEARING_ACCURACY);
    }

    public static boolean hasMslAltitude(Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.hasMslAltitude(location);
        }
        return LocationCompat.containsExtra(location, EXTRA_MSL_ALTITUDE);
    }

    public static boolean hasMslAltitudeAccuracy(Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.hasMslAltitudeAccuracy(location);
        }
        return LocationCompat.containsExtra(location, EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    public static boolean hasSpeedAccuracy(Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.hasSpeedAccuracy(location);
        }
        return LocationCompat.containsExtra(location, EXTRA_SPEED_ACCURACY);
    }

    public static boolean hasVerticalAccuracy(Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.hasVerticalAccuracy(location);
        }
        return LocationCompat.containsExtra(location, EXTRA_VERTICAL_ACCURACY);
    }

    public static boolean isMock(Location location) {
        return location.isFromMockProvider();
    }

    public static void removeBearingAccuracy(Location location) {
        if (Build.VERSION.SDK_INT >= 33) {
            Api33Impl.removeBearingAccuracy(location);
        } else if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.removeBearingAccuracy(location);
        } else if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.removeBearingAccuracy(location);
        } else if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.removeBearingAccuracy(location);
        } else {
            LocationCompat.removeExtra(location, EXTRA_BEARING_ACCURACY);
        }
    }

    private static void removeExtra(Location location, String string2) {
        Bundle bundle = location.getExtras();
        if (bundle != null) {
            bundle.remove(string2);
            if (bundle.isEmpty()) {
                location.setExtras(null);
            }
        }
    }

    public static void removeMslAltitude(Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.removeMslAltitude(location);
        } else {
            LocationCompat.removeExtra(location, EXTRA_MSL_ALTITUDE);
        }
    }

    public static void removeMslAltitudeAccuracy(Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.removeMslAltitudeAccuracy(location);
        } else {
            LocationCompat.removeExtra(location, EXTRA_MSL_ALTITUDE_ACCURACY);
        }
    }

    public static void removeSpeedAccuracy(Location location) {
        if (Build.VERSION.SDK_INT >= 33) {
            Api33Impl.removeSpeedAccuracy(location);
        } else if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.removeSpeedAccuracy(location);
        } else if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.removeSpeedAccuracy(location);
        } else if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.removeSpeedAccuracy(location);
        } else {
            LocationCompat.removeExtra(location, EXTRA_SPEED_ACCURACY);
        }
    }

    public static void removeVerticalAccuracy(Location location) {
        if (Build.VERSION.SDK_INT >= 33) {
            Api33Impl.removeVerticalAccuracy(location);
        } else if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.removeVerticalAccuracy(location);
        } else if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.removeVerticalAccuracy(location);
        } else if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.removeVerticalAccuracy(location);
        } else {
            LocationCompat.removeExtra(location, EXTRA_VERTICAL_ACCURACY);
        }
    }

    public static void setBearingAccuracyDegrees(Location location, float f) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.setBearingAccuracyDegrees(location, f);
        } else {
            LocationCompat.getOrCreateExtras(location).putFloat(EXTRA_BEARING_ACCURACY, f);
        }
    }

    public static void setMock(Location object, boolean bl) {
        try {
            LocationCompat.getSetIsFromMockProviderMethod().invoke(object, bl);
            return;
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new RuntimeException(invocationTargetException);
        }
        catch (IllegalAccessException illegalAccessException) {
            IllegalAccessError illegalAccessError = new IllegalAccessError();
            illegalAccessError.initCause(illegalAccessException);
            throw illegalAccessError;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            object = new NoSuchMethodError();
            ((Throwable)object).initCause(noSuchMethodException);
            throw object;
        }
    }

    public static void setMslAltitudeAccuracyMeters(Location location, float f) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.setMslAltitudeAccuracyMeters(location, f);
        } else {
            LocationCompat.getOrCreateExtras(location).putFloat(EXTRA_MSL_ALTITUDE_ACCURACY, f);
        }
    }

    public static void setMslAltitudeMeters(Location location, double d) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.setMslAltitudeMeters(location, d);
        } else {
            LocationCompat.getOrCreateExtras(location).putDouble(EXTRA_MSL_ALTITUDE, d);
        }
    }

    public static void setSpeedAccuracyMetersPerSecond(Location location, float f) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.setSpeedAccuracyMetersPerSecond(location, f);
        } else {
            LocationCompat.getOrCreateExtras(location).putFloat(EXTRA_SPEED_ACCURACY, f);
        }
    }

    public static void setVerticalAccuracyMeters(Location location, float f) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.setVerticalAccuracyMeters(location, f);
        } else {
            LocationCompat.getOrCreateExtras(location).putFloat(EXTRA_VERTICAL_ACCURACY, f);
        }
    }

    private static class Api26Impl {
        private Api26Impl() {
        }

        static float getBearingAccuracyDegrees(Location location) {
            return location.getBearingAccuracyDegrees();
        }

        static float getSpeedAccuracyMetersPerSecond(Location location) {
            return location.getSpeedAccuracyMetersPerSecond();
        }

        static float getVerticalAccuracyMeters(Location location) {
            return location.getVerticalAccuracyMeters();
        }

        static boolean hasBearingAccuracy(Location location) {
            return location.hasBearingAccuracy();
        }

        static boolean hasSpeedAccuracy(Location location) {
            return location.hasSpeedAccuracy();
        }

        static boolean hasVerticalAccuracy(Location location) {
            return location.hasVerticalAccuracy();
        }

        static void removeBearingAccuracy(Location object) {
            try {
                byte by = LocationCompat.getFieldsMaskField().getByte(object);
                byte by2 = (byte)(~LocationCompat.getHasBearingAccuracyMask() & by);
                LocationCompat.getFieldsMaskField().setByte(object, by2);
                return;
            }
            catch (IllegalAccessException illegalAccessException) {
                object = new IllegalAccessError();
                ((Throwable)object).initCause(illegalAccessException);
                throw object;
            }
            catch (NoSuchFieldException noSuchFieldException) {
                NoSuchFieldError noSuchFieldError = new NoSuchFieldError();
                noSuchFieldError.initCause(noSuchFieldException);
                throw noSuchFieldError;
            }
        }

        static void removeSpeedAccuracy(Location object) {
            try {
                byte by = LocationCompat.getFieldsMaskField().getByte(object);
                byte by2 = (byte)(~LocationCompat.getHasSpeedAccuracyMask() & by);
                LocationCompat.getFieldsMaskField().setByte(object, by2);
                return;
            }
            catch (IllegalAccessException illegalAccessException) {
                object = new IllegalAccessError();
                ((Throwable)object).initCause(illegalAccessException);
                throw object;
            }
            catch (NoSuchFieldException noSuchFieldException) {
                object = new NoSuchFieldError();
                ((Throwable)object).initCause(noSuchFieldException);
                throw object;
            }
        }

        /*
         * WARNING - void declaration
         */
        static void removeVerticalAccuracy(Location location) {
            void var0_3;
            try {
                byte by = LocationCompat.getFieldsMaskField().getByte(location);
                byte by2 = (byte)(~LocationCompat.getHasVerticalAccuracyMask() & by);
                LocationCompat.getFieldsMaskField().setByte(location, by2);
                return;
            }
            catch (IllegalAccessException illegalAccessException) {
            }
            catch (NoSuchFieldException noSuchFieldException) {
                // empty catch block
            }
            IllegalAccessError illegalAccessError = new IllegalAccessError();
            illegalAccessError.initCause((Throwable)var0_3);
            throw illegalAccessError;
        }

        static void setBearingAccuracyDegrees(Location location, float f) {
            location.setBearingAccuracyDegrees(f);
        }

        static void setSpeedAccuracyMetersPerSecond(Location location, float f) {
            location.setSpeedAccuracyMetersPerSecond(f);
        }

        static void setVerticalAccuracyMeters(Location location, float f) {
            location.setVerticalAccuracyMeters(f);
        }
    }

    private static class Api28Impl {
        private Api28Impl() {
        }

        static void removeBearingAccuracy(Location location) {
            if (!location.hasBearingAccuracy()) {
                return;
            }
            String string2 = location.getProvider();
            long l = location.getTime();
            long l2 = location.getElapsedRealtimeNanos();
            double d = location.getLatitude();
            double d2 = location.getLongitude();
            boolean bl = location.hasAltitude();
            double d3 = location.getAltitude();
            boolean bl2 = location.hasSpeed();
            float f = location.getSpeed();
            boolean bl3 = location.hasBearing();
            float f2 = location.getBearing();
            boolean bl4 = location.hasAccuracy();
            float f3 = location.getAccuracy();
            boolean bl5 = location.hasVerticalAccuracy();
            float f4 = location.getVerticalAccuracyMeters();
            boolean bl6 = location.hasSpeedAccuracy();
            float f5 = location.getSpeedAccuracyMetersPerSecond();
            Bundle bundle = location.getExtras();
            location.reset();
            location.setProvider(string2);
            location.setTime(l);
            location.setElapsedRealtimeNanos(l2);
            location.setLatitude(d);
            location.setLongitude(d2);
            if (bl) {
                location.setAltitude(d3);
            }
            if (bl2) {
                location.setSpeed(f);
            }
            if (bl3) {
                location.setBearing(f2);
            }
            if (bl4) {
                location.setAccuracy(f3);
            }
            if (bl5) {
                location.setVerticalAccuracyMeters(f4);
            }
            if (bl6) {
                location.setBearingAccuracyDegrees(f5);
            }
            if (bundle != null) {
                location.setExtras(bundle);
            }
        }

        static void removeSpeedAccuracy(Location location) {
            if (!location.hasSpeedAccuracy()) {
                return;
            }
            String string2 = location.getProvider();
            long l = location.getTime();
            long l2 = location.getElapsedRealtimeNanos();
            double d = location.getLatitude();
            double d2 = location.getLongitude();
            boolean bl = location.hasAltitude();
            double d3 = location.getAltitude();
            boolean bl2 = location.hasSpeed();
            float f = location.getSpeed();
            boolean bl3 = location.hasBearing();
            float f2 = location.getBearing();
            boolean bl4 = location.hasAccuracy();
            float f3 = location.getAccuracy();
            boolean bl5 = location.hasVerticalAccuracy();
            float f4 = location.getVerticalAccuracyMeters();
            boolean bl6 = location.hasBearingAccuracy();
            float f5 = location.getBearingAccuracyDegrees();
            Bundle bundle = location.getExtras();
            location.reset();
            location.setProvider(string2);
            location.setTime(l);
            location.setElapsedRealtimeNanos(l2);
            location.setLatitude(d);
            location.setLongitude(d2);
            if (bl) {
                location.setAltitude(d3);
            }
            if (bl2) {
                location.setSpeed(f);
            }
            if (bl3) {
                location.setBearing(f2);
            }
            if (bl4) {
                location.setAccuracy(f3);
            }
            if (bl5) {
                location.setVerticalAccuracyMeters(f4);
            }
            if (bl6) {
                location.setBearingAccuracyDegrees(f5);
            }
            if (bundle != null) {
                location.setExtras(bundle);
            }
        }

        static void removeVerticalAccuracy(Location location) {
            if (!location.hasVerticalAccuracy()) {
                return;
            }
            String string2 = location.getProvider();
            long l = location.getTime();
            long l2 = location.getElapsedRealtimeNanos();
            double d = location.getLatitude();
            double d2 = location.getLongitude();
            boolean bl = location.hasAltitude();
            double d3 = location.getAltitude();
            boolean bl2 = location.hasSpeed();
            float f = location.getSpeed();
            boolean bl3 = location.hasBearing();
            float f2 = location.getBearing();
            boolean bl4 = location.hasAccuracy();
            float f3 = location.getAccuracy();
            boolean bl5 = location.hasSpeedAccuracy();
            float f4 = location.getSpeedAccuracyMetersPerSecond();
            boolean bl6 = location.hasBearingAccuracy();
            float f5 = location.getBearingAccuracyDegrees();
            Bundle bundle = location.getExtras();
            location.reset();
            location.setProvider(string2);
            location.setTime(l);
            location.setElapsedRealtimeNanos(l2);
            location.setLatitude(d);
            location.setLongitude(d2);
            if (bl) {
                location.setAltitude(d3);
            }
            if (bl2) {
                location.setSpeed(f);
            }
            if (bl3) {
                location.setBearing(f2);
            }
            if (bl4) {
                location.setAccuracy(f3);
            }
            if (bl5) {
                location.setSpeedAccuracyMetersPerSecond(f4);
            }
            if (bl6) {
                location.setBearingAccuracyDegrees(f5);
            }
            if (bundle != null) {
                location.setExtras(bundle);
            }
        }
    }

    private static class Api29Impl {
        private Api29Impl() {
        }

        static void removeBearingAccuracy(Location location) {
            if (!location.hasBearingAccuracy()) {
                return;
            }
            double d = location.getElapsedRealtimeUncertaintyNanos();
            Api28Impl.removeBearingAccuracy(location);
            location.setElapsedRealtimeUncertaintyNanos(d);
        }

        static void removeSpeedAccuracy(Location location) {
            if (!location.hasSpeedAccuracy()) {
                return;
            }
            double d = location.getElapsedRealtimeUncertaintyNanos();
            Api28Impl.removeSpeedAccuracy(location);
            location.setElapsedRealtimeUncertaintyNanos(d);
        }

        static void removeVerticalAccuracy(Location location) {
            if (!location.hasVerticalAccuracy()) {
                return;
            }
            double d = location.getElapsedRealtimeUncertaintyNanos();
            Api28Impl.removeVerticalAccuracy(location);
            location.setElapsedRealtimeUncertaintyNanos(d);
        }
    }

    private static class Api33Impl {
        private Api33Impl() {
        }

        static void removeBearingAccuracy(Location location) {
            location.removeBearingAccuracy();
        }

        static void removeSpeedAccuracy(Location location) {
            location.removeSpeedAccuracy();
        }

        static void removeVerticalAccuracy(Location location) {
            location.removeVerticalAccuracy();
        }
    }

    private static class Api34Impl {
        private Api34Impl() {
        }

        static float getMslAltitudeAccuracyMeters(Location location) {
            return location.getMslAltitudeAccuracyMeters();
        }

        static double getMslAltitudeMeters(Location location) {
            return location.getMslAltitudeMeters();
        }

        static boolean hasMslAltitude(Location location) {
            return location.hasMslAltitude();
        }

        static boolean hasMslAltitudeAccuracy(Location location) {
            return location.hasMslAltitudeAccuracy();
        }

        static void removeMslAltitude(Location location) {
            location.removeMslAltitude();
        }

        static void removeMslAltitudeAccuracy(Location location) {
            location.removeMslAltitudeAccuracy();
        }

        static void setMslAltitudeAccuracyMeters(Location location, float f) {
            location.setMslAltitudeAccuracyMeters(f);
        }

        static void setMslAltitudeMeters(Location location, double d) {
            location.setMslAltitudeMeters(d);
        }
    }
}

