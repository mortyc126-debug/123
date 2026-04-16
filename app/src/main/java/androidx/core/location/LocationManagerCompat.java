/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.GnssMeasurementsEvent
 *  android.location.GnssMeasurementsEvent$Callback
 *  android.location.GnssStatus
 *  android.location.GnssStatus$Callback
 *  android.location.GpsStatus
 *  android.location.GpsStatus$Listener
 *  android.location.Location
 *  android.location.LocationListener
 *  android.location.LocationManager
 *  android.location.LocationRequest
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.CancellationSignal
 *  android.os.CancellationSignal$OnCancelListener
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.SystemClock
 */
package androidx.core.location;

import android.location.GnssMeasurementsEvent;
import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.collection.SimpleArrayMap;
import androidx.core.location.GnssStatusCompat;
import androidx.core.location.LocationCompat;
import androidx.core.location.LocationListenerCompat;
import androidx.core.location.LocationManagerCompat$$ExternalSyntheticLambda1;
import androidx.core.location.LocationManagerCompat$$ExternalSyntheticLambda2;
import androidx.core.location.LocationManagerCompat$Api30Impl$$ExternalSyntheticLambda0;
import androidx.core.location.LocationManagerCompat$CancellableLocationListener$$ExternalSyntheticLambda0;
import androidx.core.location.LocationManagerCompat$CancellableLocationListener$$ExternalSyntheticLambda1;
import androidx.core.location.LocationManagerCompat$GnssMeasurementsTransport$$ExternalSyntheticLambda0;
import androidx.core.location.LocationManagerCompat$GnssMeasurementsTransport$$ExternalSyntheticLambda1;
import androidx.core.location.LocationManagerCompat$GpsStatusTransport$$ExternalSyntheticLambda0;
import androidx.core.location.LocationManagerCompat$GpsStatusTransport$$ExternalSyntheticLambda1;
import androidx.core.location.LocationManagerCompat$GpsStatusTransport$$ExternalSyntheticLambda2;
import androidx.core.location.LocationManagerCompat$GpsStatusTransport$$ExternalSyntheticLambda3;
import androidx.core.location.LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda0;
import androidx.core.location.LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda1;
import androidx.core.location.LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda2;
import androidx.core.location.LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda3;
import androidx.core.location.LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda4;
import androidx.core.location.LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda5;
import androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport$$ExternalSyntheticLambda0;
import androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport$$ExternalSyntheticLambda1;
import androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport$$ExternalSyntheticLambda2;
import androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport$$ExternalSyntheticLambda3;
import androidx.core.location.LocationRequestCompat;
import androidx.core.os.CancellationSignal;
import androidx.core.os.ExecutorCompat;
import androidx.core.util.Consumer;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public final class LocationManagerCompat {
    private static final long GET_CURRENT_LOCATION_TIMEOUT_MS = 30000L;
    private static final long MAX_CURRENT_LOCATION_AGE_MS = 10000L;
    private static final long PRE_N_LOOPER_TIMEOUT_S = 5L;
    private static Field sContextField;
    private static Method sGnssRequestBuilderBuildMethod;
    private static Class<?> sGnssRequestBuilderClass;
    static final WeakHashMap<LocationListenerKey, WeakReference<LocationListenerTransport>> sLocationListeners;
    private static Method sRegisterGnssMeasurementsCallbackMethod;

    static {
        sLocationListeners = new WeakHashMap();
    }

    private LocationManagerCompat() {
    }

    public static void getCurrentLocation(LocationManager locationManager, String string2, android.os.CancellationSignal cancellationSignal, Executor object, Consumer<Location> consumer) {
        Location location;
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.getCurrentLocation(locationManager, string2, cancellationSignal, (Executor)object, consumer);
            return;
        }
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        if ((location = locationManager.getLastKnownLocation(string2)) != null && SystemClock.elapsedRealtime() - LocationCompat.getElapsedRealtimeMillis(location) < 10000L) {
            object.execute(new LocationManagerCompat$$ExternalSyntheticLambda1(consumer, location));
            return;
        }
        object = new CancellableLocationListener(locationManager, (Executor)object, consumer);
        locationManager.requestLocationUpdates(string2, 0L, 0.0f, (LocationListener)object, Looper.getMainLooper());
        if (cancellationSignal != null) {
            Objects.requireNonNull(object);
            cancellationSignal.setOnCancelListener((CancellationSignal.OnCancelListener)new LocationManagerCompat$$ExternalSyntheticLambda2((CancellableLocationListener)object));
        }
        ((CancellableLocationListener)object).startTimeout(30000L);
    }

    @Deprecated
    public static void getCurrentLocation(LocationManager locationManager, String string2, CancellationSignal cancellationSignal, Executor executor, Consumer<Location> consumer) {
        cancellationSignal = cancellationSignal != null ? (android.os.CancellationSignal)cancellationSignal.getCancellationSignalObject() : null;
        LocationManagerCompat.getCurrentLocation(locationManager, string2, (android.os.CancellationSignal)cancellationSignal, executor, consumer);
    }

    public static String getGnssHardwareModelName(LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getGnssHardwareModelName(locationManager);
        }
        return null;
    }

    public static int getGnssYearOfHardware(LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getGnssYearOfHardware(locationManager);
        }
        return 0;
    }

    public static boolean hasProvider(LocationManager locationManager, String string2) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.hasProvider(locationManager, string2);
        }
        boolean bl = locationManager.getAllProviders().contains(string2);
        boolean bl2 = true;
        if (bl) {
            return true;
        }
        try {
            locationManager = locationManager.getProvider(string2);
            if (locationManager == null) {
                bl2 = false;
            }
            return bl2;
        }
        catch (SecurityException securityException) {
            return false;
        }
    }

    public static boolean isLocationEnabled(LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.isLocationEnabled(locationManager);
        }
        boolean bl = locationManager.isProviderEnabled("network") || locationManager.isProviderEnabled("gps");
        return bl;
    }

    static /* synthetic */ void lambda$getCurrentLocation$0(Consumer consumer, Location location) {
        consumer.accept(location);
    }

    static /* synthetic */ Boolean lambda$registerGnssStatusCallback$1(LocationManager locationManager, GpsStatusTransport gpsStatusTransport) throws Exception {
        return locationManager.addGpsStatusListener((GpsStatus.Listener)gpsStatusTransport);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean registerGnssMeasurementsCallback(LocationManager locationManager, GnssMeasurementsEvent.Callback callback2, Handler handler) {
        if (Build.VERSION.SDK_INT > 30) {
            return Api24Impl.registerGnssMeasurementsCallback(locationManager, callback2, handler);
        }
        if (Build.VERSION.SDK_INT == 30) {
            return LocationManagerCompat.registerGnssMeasurementsCallbackOnR(locationManager, ExecutorCompat.create(handler), callback2);
        }
        SimpleArrayMap<GnssMeasurementsEvent.Callback, GnssMeasurementsEvent.Callback> simpleArrayMap = GnssListenersHolder.sGnssMeasurementListeners;
        synchronized (simpleArrayMap) {
            LocationManagerCompat.unregisterGnssMeasurementsCallback(locationManager, callback2);
            if (Api24Impl.registerGnssMeasurementsCallback(locationManager, callback2, handler)) {
                GnssListenersHolder.sGnssMeasurementListeners.put(callback2, callback2);
                return true;
            }
            return false;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean registerGnssMeasurementsCallback(LocationManager locationManager, Executor executor, GnssMeasurementsEvent.Callback callback2) {
        if (Build.VERSION.SDK_INT > 30) {
            return Api31Impl.registerGnssMeasurementsCallback(locationManager, executor, callback2);
        }
        if (Build.VERSION.SDK_INT == 30) {
            return LocationManagerCompat.registerGnssMeasurementsCallbackOnR(locationManager, executor, callback2);
        }
        SimpleArrayMap<GnssMeasurementsEvent.Callback, GnssMeasurementsEvent.Callback> simpleArrayMap = GnssListenersHolder.sGnssMeasurementListeners;
        synchronized (simpleArrayMap) {
            GnssMeasurementsTransport gnssMeasurementsTransport = new GnssMeasurementsTransport(callback2, executor);
            LocationManagerCompat.unregisterGnssMeasurementsCallback(locationManager, callback2);
            if (Api24Impl.registerGnssMeasurementsCallback(locationManager, gnssMeasurementsTransport)) {
                GnssListenersHolder.sGnssMeasurementListeners.put(callback2, gnssMeasurementsTransport);
                return true;
            }
            return false;
        }
    }

    private static boolean registerGnssMeasurementsCallbackOnR(LocationManager object, Executor executor, GnssMeasurementsEvent.Callback callback2) {
        if (Build.VERSION.SDK_INT == 30) {
            block12: {
                boolean bl;
                block11: {
                    boolean bl2 = false;
                    if (sGnssRequestBuilderClass == null) {
                        sGnssRequestBuilderClass = Class.forName("android.location.GnssRequest$Builder");
                    }
                    if (sGnssRequestBuilderBuildMethod == null) {
                        sGnssRequestBuilderBuildMethod = sGnssRequestBuilderClass.getDeclaredMethod("build", new Class[0]);
                        sGnssRequestBuilderBuildMethod.setAccessible(true);
                    }
                    if (sRegisterGnssMeasurementsCallbackMethod == null) {
                        sRegisterGnssMeasurementsCallbackMethod = LocationManager.class.getDeclaredMethod("registerGnssMeasurementsCallback", Class.forName("android.location.GnssRequest"), Executor.class, GnssMeasurementsEvent.Callback.class);
                        sRegisterGnssMeasurementsCallbackMethod.setAccessible(true);
                    }
                    object = sRegisterGnssMeasurementsCallbackMethod.invoke(object, sGnssRequestBuilderBuildMethod.invoke(sGnssRequestBuilderClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), new Object[0]), executor, callback2);
                    bl = bl2;
                    if (object == null) break block11;
                    try {
                        boolean bl3 = (Boolean)object;
                        bl = bl2;
                        if (!bl3) break block11;
                        bl = true;
                    }
                    catch (InstantiationException instantiationException) {
                        break block12;
                    }
                    catch (IllegalAccessException illegalAccessException) {
                        break block12;
                    }
                    catch (NoSuchMethodException noSuchMethodException) {
                        break block12;
                    }
                    catch (InvocationTargetException invocationTargetException) {
                        break block12;
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        // empty catch block
                    }
                }
                return bl;
            }
            return false;
        }
        throw new IllegalStateException();
    }

    private static boolean registerGnssStatusCallback(LocationManager locationManager, Handler handler, Executor executor, GnssStatusCompat.Callback callback2) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.registerGnssStatusCallback(locationManager, handler, executor, callback2);
        }
        return Api24Impl.registerGnssStatusCallback(locationManager, handler, executor, callback2);
    }

    public static boolean registerGnssStatusCallback(LocationManager locationManager, GnssStatusCompat.Callback callback2, Handler handler) {
        if (Build.VERSION.SDK_INT >= 30) {
            return LocationManagerCompat.registerGnssStatusCallback(locationManager, ExecutorCompat.create(handler), callback2);
        }
        return LocationManagerCompat.registerGnssStatusCallback(locationManager, new InlineHandlerExecutor(handler), callback2);
    }

    public static boolean registerGnssStatusCallback(LocationManager locationManager, Executor executor, GnssStatusCompat.Callback callback2) {
        Looper looper;
        if (Build.VERSION.SDK_INT >= 30) {
            return LocationManagerCompat.registerGnssStatusCallback(locationManager, null, executor, callback2);
        }
        Looper looper2 = looper = Looper.myLooper();
        if (looper == null) {
            looper2 = Looper.getMainLooper();
        }
        return LocationManagerCompat.registerGnssStatusCallback(locationManager, new Handler(looper2), executor, callback2);
    }

    static void registerLocationListenerTransport(LocationManager locationManager, LocationListenerTransport object) {
        if ((object = (object = sLocationListeners.put(((LocationListenerTransport)object).getKey(), new WeakReference<LocationListenerTransport>((LocationListenerTransport)object))) != null ? (LocationListenerTransport)((Reference)object).get() : null) != null) {
            ((LocationListenerTransport)object).unregister();
            locationManager.removeUpdates((LocationListener)object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void removeUpdates(LocationManager locationManager, LocationListenerCompat locationListenerCompat) {
        WeakHashMap<LocationListenerKey, WeakReference<LocationListenerTransport>> weakHashMap = sLocationListeners;
        synchronized (weakHashMap) {
            ArrayList<LocationListenerKey> arrayList;
            Object object = null;
            Iterator<WeakReference<LocationListenerTransport>> iterator2 = sLocationListeners.values().iterator();
            while (iterator2.hasNext()) {
                LocationListenerTransport locationListenerTransport = (LocationListenerTransport)iterator2.next().get();
                if (locationListenerTransport == null) continue;
                LocationListenerKey locationListenerKey = locationListenerTransport.getKey();
                arrayList = object;
                if (locationListenerKey.mListener == locationListenerCompat) {
                    arrayList = object;
                    if (object == null) {
                        arrayList = new ArrayList<LocationListenerKey>();
                    }
                    arrayList.add(locationListenerKey);
                    locationListenerTransport.unregister();
                    locationManager.removeUpdates((LocationListener)locationListenerTransport);
                }
                object = arrayList;
            }
            if (object != null) {
                arrayList = ((ArrayList)object).iterator();
                while (arrayList.hasNext()) {
                    object = (LocationListenerKey)arrayList.next();
                    sLocationListeners.remove(object);
                }
            }
        }
        locationManager.removeUpdates((LocationListener)locationListenerCompat);
    }

    public static void requestLocationUpdates(LocationManager locationManager, String string2, LocationRequestCompat locationRequestCompat, LocationListenerCompat locationListenerCompat, Looper looper) {
        if (Build.VERSION.SDK_INT >= 31) {
            Api31Impl.requestLocationUpdates(locationManager, string2, locationRequestCompat.toLocationRequest(), ExecutorCompat.create(new Handler(looper)), locationListenerCompat);
            return;
        }
        if (Api19Impl.tryRequestLocationUpdates(locationManager, string2, locationRequestCompat, locationListenerCompat, looper)) {
            return;
        }
        locationManager.requestLocationUpdates(string2, locationRequestCompat.getIntervalMillis(), locationRequestCompat.getMinUpdateDistanceMeters(), (LocationListener)locationListenerCompat, looper);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void requestLocationUpdates(LocationManager locationManager, String string2, LocationRequestCompat locationRequestCompat, Executor object, LocationListenerCompat object2) {
        if (Build.VERSION.SDK_INT >= 31) {
            Api31Impl.requestLocationUpdates(locationManager, string2, locationRequestCompat.toLocationRequest(), (Executor)object, object2);
            return;
        }
        if (Build.VERSION.SDK_INT >= 30 && Api30Impl.tryRequestLocationUpdates(locationManager, string2, locationRequestCompat, (Executor)object, object2)) {
            return;
        }
        if (Api19Impl.tryRequestLocationUpdates(locationManager, string2, locationRequestCompat, (LocationListenerTransport)(object2 = new LocationListenerTransport(new LocationListenerKey(string2, (LocationListenerCompat)object2), (Executor)object)))) {
            return;
        }
        object = sLocationListeners;
        synchronized (object) {
            locationManager.requestLocationUpdates(string2, locationRequestCompat.getIntervalMillis(), locationRequestCompat.getMinUpdateDistanceMeters(), (LocationListener)object2, Looper.getMainLooper());
            LocationManagerCompat.registerLocationListenerTransport(locationManager, (LocationListenerTransport)object2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void unregisterGnssMeasurementsCallback(LocationManager locationManager, GnssMeasurementsEvent.Callback callback2) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api24Impl.unregisterGnssMeasurementsCallback(locationManager, callback2);
            return;
        }
        SimpleArrayMap<GnssMeasurementsEvent.Callback, GnssMeasurementsEvent.Callback> simpleArrayMap = GnssListenersHolder.sGnssMeasurementListeners;
        synchronized (simpleArrayMap) {
            callback2 = GnssListenersHolder.sGnssMeasurementListeners.remove(callback2);
            if (callback2 == null) return;
            if (callback2 instanceof GnssMeasurementsTransport) {
                ((GnssMeasurementsTransport)callback2).unregister();
            }
            Api24Impl.unregisterGnssMeasurementsCallback(locationManager, callback2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void unregisterGnssStatusCallback(LocationManager locationManager, GnssStatusCompat.Callback object) {
        SimpleArrayMap<Object, Object> simpleArrayMap = GnssListenersHolder.sGnssStatusListeners;
        synchronized (simpleArrayMap) {
            object = GnssListenersHolder.sGnssStatusListeners.remove(object);
            if (object != null) {
                Api24Impl.unregisterGnssStatusCallback(locationManager, object);
            }
            return;
        }
    }

    static class Api19Impl {
        private static Class<?> sLocationRequestClass;
        private static Method sRequestLocationUpdatesLooperMethod;

        private Api19Impl() {
        }

        static boolean tryRequestLocationUpdates(LocationManager locationManager, String string2, LocationRequestCompat locationRequestCompat, LocationListenerCompat locationListenerCompat, Looper looper) {
            block9: {
                if (sLocationRequestClass == null) {
                    sLocationRequestClass = Class.forName("android.location.LocationRequest");
                }
                if (sRequestLocationUpdatesLooperMethod == null) {
                    sRequestLocationUpdatesLooperMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", sLocationRequestClass, LocationListener.class, Looper.class);
                    sRequestLocationUpdatesLooperMethod.setAccessible(true);
                }
                if ((string2 = locationRequestCompat.toLocationRequest(string2)) == null) break block9;
                try {
                    sRequestLocationUpdatesLooperMethod.invoke((Object)locationManager, string2, locationListenerCompat, looper);
                    return true;
                }
                catch (UnsupportedOperationException unsupportedOperationException) {
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
            }
            return false;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        static boolean tryRequestLocationUpdates(LocationManager locationManager, String object, LocationRequestCompat locationRequestCompat, LocationListenerTransport locationListenerTransport) {
            try {
                if (sLocationRequestClass == null) {
                    sLocationRequestClass = Class.forName("android.location.LocationRequest");
                }
                if (sRequestLocationUpdatesLooperMethod == null) {
                    sRequestLocationUpdatesLooperMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", sLocationRequestClass, LocationListener.class, Looper.class);
                    sRequestLocationUpdatesLooperMethod.setAccessible(true);
                }
                if ((locationRequestCompat = locationRequestCompat.toLocationRequest((String)object)) == null) return false;
                object = sLocationListeners;
                synchronized (object) {
                }
            }
            catch (UnsupportedOperationException unsupportedOperationException) {
                return false;
            }
            catch (ClassNotFoundException classNotFoundException) {
                return false;
            }
            catch (IllegalAccessException illegalAccessException) {
                return false;
            }
            catch (InvocationTargetException invocationTargetException) {
                return false;
            }
            catch (NoSuchMethodException noSuchMethodException) {
                // empty catch block
                return false;
            }
            {
                sRequestLocationUpdatesLooperMethod.invoke((Object)locationManager, locationRequestCompat, locationListenerTransport, Looper.getMainLooper());
                LocationManagerCompat.registerLocationListenerTransport(locationManager, locationListenerTransport);
                return true;
            }
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static boolean registerGnssMeasurementsCallback(LocationManager locationManager, GnssMeasurementsEvent.Callback callback2) {
            return locationManager.registerGnssMeasurementsCallback(callback2);
        }

        static boolean registerGnssMeasurementsCallback(LocationManager locationManager, GnssMeasurementsEvent.Callback callback2, Handler handler) {
            return locationManager.registerGnssMeasurementsCallback(callback2, handler);
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        static boolean registerGnssStatusCallback(LocationManager locationManager, Handler handler, Executor executor, GnssStatusCompat.Callback callback2) {
            boolean bl = handler != null;
            Preconditions.checkArgument(bl);
            SimpleArrayMap<Object, Object> simpleArrayMap = GnssListenersHolder.sGnssStatusListeners;
            synchronized (simpleArrayMap) {
                PreRGnssStatusTransport preRGnssStatusTransport = (PreRGnssStatusTransport)((Object)GnssListenersHolder.sGnssStatusListeners.get(callback2));
                if (preRGnssStatusTransport == null) {
                    preRGnssStatusTransport = new PreRGnssStatusTransport(callback2);
                } else {
                    preRGnssStatusTransport.unregister();
                }
                preRGnssStatusTransport.register(executor);
                if (locationManager.registerGnssStatusCallback((GnssStatus.Callback)preRGnssStatusTransport, handler)) {
                    GnssListenersHolder.sGnssStatusListeners.put(callback2, (Object)preRGnssStatusTransport);
                    return true;
                }
                return false;
            }
        }

        static void unregisterGnssMeasurementsCallback(LocationManager locationManager, GnssMeasurementsEvent.Callback callback2) {
            locationManager.unregisterGnssMeasurementsCallback(callback2);
        }

        static void unregisterGnssStatusCallback(LocationManager locationManager, Object object) {
            if (object instanceof PreRGnssStatusTransport) {
                ((PreRGnssStatusTransport)((Object)object)).unregister();
            }
            locationManager.unregisterGnssStatusCallback((GnssStatus.Callback)object);
        }
    }

    private static class Api28Impl {
        private Api28Impl() {
        }

        static String getGnssHardwareModelName(LocationManager locationManager) {
            return locationManager.getGnssHardwareModelName();
        }

        static int getGnssYearOfHardware(LocationManager locationManager) {
            return locationManager.getGnssYearOfHardware();
        }

        static boolean isLocationEnabled(LocationManager locationManager) {
            return locationManager.isLocationEnabled();
        }
    }

    private static class Api30Impl {
        private static Class<?> sLocationRequestClass;
        private static Method sRequestLocationUpdatesExecutorMethod;

        private Api30Impl() {
        }

        static void getCurrentLocation(LocationManager locationManager, String string2, android.os.CancellationSignal cancellationSignal, Executor executor, Consumer<Location> consumer) {
            Objects.requireNonNull(consumer);
            locationManager.getCurrentLocation(string2, cancellationSignal, executor, (java.util.function.Consumer)new LocationManagerCompat$Api30Impl$$ExternalSyntheticLambda0(consumer));
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public static boolean registerGnssStatusCallback(LocationManager locationManager, Handler object, Executor executor, GnssStatusCompat.Callback callback2) {
            SimpleArrayMap<Object, Object> simpleArrayMap = GnssListenersHolder.sGnssStatusListeners;
            synchronized (simpleArrayMap) {
                GnssStatusTransport gnssStatusTransport = (GnssStatusTransport)((Object)GnssListenersHolder.sGnssStatusListeners.get(callback2));
                object = gnssStatusTransport;
                if (gnssStatusTransport == null) {
                    object = new GnssStatusTransport(callback2);
                }
                if (locationManager.registerGnssStatusCallback(executor, (GnssStatus.Callback)object)) {
                    GnssListenersHolder.sGnssStatusListeners.put(callback2, object);
                    return true;
                }
                return false;
            }
        }

        public static boolean tryRequestLocationUpdates(LocationManager locationManager, String string2, LocationRequestCompat locationRequestCompat, Executor executor, LocationListenerCompat locationListenerCompat) {
            block10: {
                if (Build.VERSION.SDK_INT >= 30) {
                    if (sLocationRequestClass == null) {
                        sLocationRequestClass = Class.forName("android.location.LocationRequest");
                    }
                    if (sRequestLocationUpdatesExecutorMethod == null) {
                        sRequestLocationUpdatesExecutorMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", sLocationRequestClass, Executor.class, LocationListener.class);
                        sRequestLocationUpdatesExecutorMethod.setAccessible(true);
                    }
                    if ((string2 = locationRequestCompat.toLocationRequest(string2)) == null) break block10;
                    try {
                        sRequestLocationUpdatesExecutorMethod.invoke((Object)locationManager, string2, executor, locationListenerCompat);
                        return true;
                    }
                    catch (UnsupportedOperationException unsupportedOperationException) {
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
                }
            }
            return false;
        }
    }

    private static class Api31Impl {
        private Api31Impl() {
        }

        static boolean hasProvider(LocationManager locationManager, String string2) {
            return locationManager.hasProvider(string2);
        }

        static boolean registerGnssMeasurementsCallback(LocationManager locationManager, Executor executor, GnssMeasurementsEvent.Callback callback2) {
            return locationManager.registerGnssMeasurementsCallback(executor, callback2);
        }

        static void requestLocationUpdates(LocationManager locationManager, String string2, LocationRequest locationRequest, Executor executor, LocationListener locationListener) {
            locationManager.requestLocationUpdates(string2, locationRequest, executor, locationListener);
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    private static final class CancellableLocationListener
    implements LocationListener {
        private Consumer<Location> mConsumer;
        private final Executor mExecutor;
        private final LocationManager mLocationManager;
        private final Handler mTimeoutHandler;
        Runnable mTimeoutRunnable;
        private boolean mTriggered;

        CancellableLocationListener(LocationManager locationManager, Executor executor, Consumer<Location> consumer) {
            this.mLocationManager = locationManager;
            this.mExecutor = executor;
            this.mTimeoutHandler = new Handler(Looper.getMainLooper());
            this.mConsumer = consumer;
        }

        private void cleanup() {
            this.mConsumer = null;
            this.mLocationManager.removeUpdates((LocationListener)this);
            if (this.mTimeoutRunnable != null) {
                this.mTimeoutHandler.removeCallbacks(this.mTimeoutRunnable);
                this.mTimeoutRunnable = null;
            }
        }

        static /* synthetic */ void lambda$onLocationChanged$1(Consumer consumer, Location location) {
            consumer.accept(location);
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void cancel() {
            synchronized (this) {
                if (this.mTriggered) {
                    return;
                }
                this.mTriggered = true;
            }
            this.cleanup();
        }

        /* synthetic */ void lambda$startTimeout$0$androidx-core-location-LocationManagerCompat$CancellableLocationListener() {
            this.mTimeoutRunnable = null;
            Location location = null;
            this.onLocationChanged(null);
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void onLocationChanged(Location location) {
            synchronized (this) {
                if (this.mTriggered) {
                    return;
                }
                this.mTriggered = true;
            }
            Consumer<Location> consumer = this.mConsumer;
            this.mExecutor.execute(new LocationManagerCompat$CancellableLocationListener$$ExternalSyntheticLambda1(consumer, location));
            this.cleanup();
        }

        public void onProviderDisabled(String string2) {
            string2 = null;
            this.onLocationChanged(null);
        }

        public void onProviderEnabled(String string2) {
        }

        public void onStatusChanged(String string2, int n, Bundle bundle) {
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void startTimeout(long l) {
            synchronized (this) {
                if (this.mTriggered) {
                    return;
                }
                LocationManagerCompat$CancellableLocationListener$$ExternalSyntheticLambda0 locationManagerCompat$CancellableLocationListener$$ExternalSyntheticLambda0 = new LocationManagerCompat$CancellableLocationListener$$ExternalSyntheticLambda0(this);
                this.mTimeoutRunnable = locationManagerCompat$CancellableLocationListener$$ExternalSyntheticLambda0;
                this.mTimeoutHandler.postDelayed(this.mTimeoutRunnable, l);
                return;
            }
        }
    }

    private static class GnssListenersHolder {
        static final SimpleArrayMap<GnssMeasurementsEvent.Callback, GnssMeasurementsEvent.Callback> sGnssMeasurementListeners;
        static final SimpleArrayMap<Object, Object> sGnssStatusListeners;

        static {
            sGnssStatusListeners = new SimpleArrayMap();
            sGnssMeasurementListeners = new SimpleArrayMap();
        }

        private GnssListenersHolder() {
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    private static class GnssMeasurementsTransport
    extends GnssMeasurementsEvent.Callback {
        final GnssMeasurementsEvent.Callback mCallback;
        volatile Executor mExecutor;

        GnssMeasurementsTransport(GnssMeasurementsEvent.Callback callback2, Executor executor) {
            this.mCallback = callback2;
            this.mExecutor = executor;
        }

        /* synthetic */ void lambda$onGnssMeasurementsReceived$0$androidx-core-location-LocationManagerCompat$GnssMeasurementsTransport(Executor executor, GnssMeasurementsEvent gnssMeasurementsEvent) {
            if (this.mExecutor != executor) {
                return;
            }
            this.mCallback.onGnssMeasurementsReceived(gnssMeasurementsEvent);
        }

        /* synthetic */ void lambda$onStatusChanged$1$androidx-core-location-LocationManagerCompat$GnssMeasurementsTransport(Executor executor, int n) {
            if (this.mExecutor != executor) {
                return;
            }
            this.mCallback.onStatusChanged(n);
        }

        public void onGnssMeasurementsReceived(GnssMeasurementsEvent gnssMeasurementsEvent) {
            Executor executor = this.mExecutor;
            if (executor == null) {
                return;
            }
            executor.execute(new LocationManagerCompat$GnssMeasurementsTransport$$ExternalSyntheticLambda0(this, executor, gnssMeasurementsEvent));
        }

        public void onStatusChanged(int n) {
            Executor executor = this.mExecutor;
            if (executor == null) {
                return;
            }
            executor.execute(new LocationManagerCompat$GnssMeasurementsTransport$$ExternalSyntheticLambda1(this, executor, n));
        }

        public void unregister() {
            this.mExecutor = null;
        }
    }

    private static class GnssStatusTransport
    extends GnssStatus.Callback {
        final GnssStatusCompat.Callback mCallback;

        GnssStatusTransport(GnssStatusCompat.Callback callback2) {
            boolean bl = callback2 != null;
            Preconditions.checkArgument(bl, "invalid null callback");
            this.mCallback = callback2;
        }

        public void onFirstFix(int n) {
            this.mCallback.onFirstFix(n);
        }

        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            this.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(gnssStatus));
        }

        public void onStarted() {
            this.mCallback.onStarted();
        }

        public void onStopped() {
            this.mCallback.onStopped();
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    private static class GpsStatusTransport
    implements GpsStatus.Listener {
        final GnssStatusCompat.Callback mCallback;
        volatile Executor mExecutor;
        private final LocationManager mLocationManager;

        GpsStatusTransport(LocationManager locationManager, GnssStatusCompat.Callback callback2) {
            boolean bl = callback2 != null;
            Preconditions.checkArgument(bl, "invalid null callback");
            this.mLocationManager = locationManager;
            this.mCallback = callback2;
        }

        /* synthetic */ void lambda$onGpsStatusChanged$0$androidx-core-location-LocationManagerCompat$GpsStatusTransport(Executor executor) {
            if (this.mExecutor != executor) {
                return;
            }
            this.mCallback.onStarted();
        }

        /* synthetic */ void lambda$onGpsStatusChanged$1$androidx-core-location-LocationManagerCompat$GpsStatusTransport(Executor executor) {
            if (this.mExecutor != executor) {
                return;
            }
            this.mCallback.onStopped();
        }

        /* synthetic */ void lambda$onGpsStatusChanged$2$androidx-core-location-LocationManagerCompat$GpsStatusTransport(Executor executor, int n) {
            if (this.mExecutor != executor) {
                return;
            }
            this.mCallback.onFirstFix(n);
        }

        /* synthetic */ void lambda$onGpsStatusChanged$3$androidx-core-location-LocationManagerCompat$GpsStatusTransport(Executor executor, GnssStatusCompat gnssStatusCompat) {
            if (this.mExecutor != executor) {
                return;
            }
            this.mCallback.onSatelliteStatusChanged(gnssStatusCompat);
        }

        public void onGpsStatusChanged(int n) {
            Executor executor = this.mExecutor;
            if (executor == null) {
                return;
            }
            switch (n) {
                default: {
                    break;
                }
                case 4: {
                    GpsStatus gpsStatus = this.mLocationManager.getGpsStatus(null);
                    if (gpsStatus == null) break;
                    executor.execute(new LocationManagerCompat$GpsStatusTransport$$ExternalSyntheticLambda3(this, executor, GnssStatusCompat.wrap(gpsStatus)));
                    break;
                }
                case 3: {
                    GpsStatus gpsStatus = this.mLocationManager.getGpsStatus(null);
                    if (gpsStatus == null) break;
                    executor.execute(new LocationManagerCompat$GpsStatusTransport$$ExternalSyntheticLambda2(this, executor, gpsStatus.getTimeToFirstFix()));
                    break;
                }
                case 2: {
                    executor.execute(new LocationManagerCompat$GpsStatusTransport$$ExternalSyntheticLambda1(this, executor));
                    break;
                }
                case 1: {
                    executor.execute(new LocationManagerCompat$GpsStatusTransport$$ExternalSyntheticLambda0(this, executor));
                }
            }
        }

        public void register(Executor executor) {
            boolean bl = this.mExecutor == null;
            Preconditions.checkState(bl);
            this.mExecutor = executor;
        }

        public void unregister() {
            this.mExecutor = null;
        }
    }

    private static final class InlineHandlerExecutor
    implements Executor {
        private final Handler mHandler;

        InlineHandlerExecutor(Handler handler) {
            this.mHandler = Preconditions.checkNotNull(handler);
        }

        @Override
        public void execute(Runnable runnable2) {
            block4: {
                block3: {
                    block2: {
                        if (Looper.myLooper() != this.mHandler.getLooper()) break block2;
                        runnable2.run();
                        break block3;
                    }
                    if (!this.mHandler.post(Preconditions.checkNotNull(runnable2))) break block4;
                }
                return;
            }
            throw new RejectedExecutionException(this.mHandler + " is shutting down");
        }
    }

    private static class LocationListenerKey {
        final LocationListenerCompat mListener;
        final String mProvider;

        LocationListenerKey(String string2, LocationListenerCompat locationListenerCompat) {
            this.mProvider = ObjectsCompat.requireNonNull(string2, "invalid null provider");
            this.mListener = ObjectsCompat.requireNonNull(locationListenerCompat, "invalid null listener");
        }

        public boolean equals(Object object) {
            boolean bl = object instanceof LocationListenerKey;
            boolean bl2 = false;
            if (!bl) {
                return false;
            }
            object = (LocationListenerKey)object;
            bl = bl2;
            if (this.mProvider.equals(((LocationListenerKey)object).mProvider)) {
                bl = bl2;
                if (this.mListener.equals(((LocationListenerKey)object).mListener)) {
                    bl = true;
                }
            }
            return bl;
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.mProvider, this.mListener);
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    private static class LocationListenerTransport
    implements LocationListener {
        final Executor mExecutor;
        volatile LocationListenerKey mKey;

        LocationListenerTransport(LocationListenerKey locationListenerKey, Executor executor) {
            this.mKey = locationListenerKey;
            this.mExecutor = executor;
        }

        public LocationListenerKey getKey() {
            return ObjectsCompat.requireNonNull(this.mKey);
        }

        /* synthetic */ void lambda$onFlushComplete$2$androidx-core-location-LocationManagerCompat$LocationListenerTransport(int n) {
            LocationListenerKey locationListenerKey = this.mKey;
            if (locationListenerKey == null) {
                return;
            }
            locationListenerKey.mListener.onFlushComplete(n);
        }

        /* synthetic */ void lambda$onLocationChanged$0$androidx-core-location-LocationManagerCompat$LocationListenerTransport(Location location) {
            LocationListenerKey locationListenerKey = this.mKey;
            if (locationListenerKey == null) {
                return;
            }
            locationListenerKey.mListener.onLocationChanged(location);
        }

        /* synthetic */ void lambda$onLocationChanged$1$androidx-core-location-LocationManagerCompat$LocationListenerTransport(List list) {
            LocationListenerKey locationListenerKey = this.mKey;
            if (locationListenerKey == null) {
                return;
            }
            locationListenerKey.mListener.onLocationChanged(list);
        }

        /* synthetic */ void lambda$onProviderDisabled$5$androidx-core-location-LocationManagerCompat$LocationListenerTransport(String string2) {
            LocationListenerKey locationListenerKey = this.mKey;
            if (locationListenerKey == null) {
                return;
            }
            locationListenerKey.mListener.onProviderDisabled(string2);
        }

        /* synthetic */ void lambda$onProviderEnabled$4$androidx-core-location-LocationManagerCompat$LocationListenerTransport(String string2) {
            LocationListenerKey locationListenerKey = this.mKey;
            if (locationListenerKey == null) {
                return;
            }
            locationListenerKey.mListener.onProviderEnabled(string2);
        }

        /* synthetic */ void lambda$onStatusChanged$3$androidx-core-location-LocationManagerCompat$LocationListenerTransport(String string2, int n, Bundle bundle) {
            LocationListenerKey locationListenerKey = this.mKey;
            if (locationListenerKey == null) {
                return;
            }
            locationListenerKey.mListener.onStatusChanged(string2, n, bundle);
        }

        public void onFlushComplete(int n) {
            if (this.mKey == null) {
                return;
            }
            this.mExecutor.execute(new LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda1(this, n));
        }

        public void onLocationChanged(Location location) {
            if (this.mKey == null) {
                return;
            }
            this.mExecutor.execute(new LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda4(this, location));
        }

        public void onLocationChanged(List<Location> list) {
            if (this.mKey == null) {
                return;
            }
            this.mExecutor.execute(new LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda2(this, list));
        }

        public void onProviderDisabled(String string2) {
            if (this.mKey == null) {
                return;
            }
            this.mExecutor.execute(new LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda3(this, string2));
        }

        public void onProviderEnabled(String string2) {
            if (this.mKey == null) {
                return;
            }
            this.mExecutor.execute(new LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda0(this, string2));
        }

        public void onStatusChanged(String string2, int n, Bundle bundle) {
            if (this.mKey == null) {
                return;
            }
            this.mExecutor.execute(new LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda5(this, string2, n, bundle));
        }

        public void unregister() {
            this.mKey = null;
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    private static class PreRGnssStatusTransport
    extends GnssStatus.Callback {
        final GnssStatusCompat.Callback mCallback;
        volatile Executor mExecutor;

        PreRGnssStatusTransport(GnssStatusCompat.Callback callback2) {
            boolean bl = callback2 != null;
            Preconditions.checkArgument(bl, "invalid null callback");
            this.mCallback = callback2;
        }

        /* synthetic */ void lambda$onFirstFix$2$androidx-core-location-LocationManagerCompat$PreRGnssStatusTransport(Executor executor, int n) {
            if (this.mExecutor != executor) {
                return;
            }
            this.mCallback.onFirstFix(n);
        }

        /* synthetic */ void lambda$onSatelliteStatusChanged$3$androidx-core-location-LocationManagerCompat$PreRGnssStatusTransport(Executor executor, GnssStatus gnssStatus) {
            if (this.mExecutor != executor) {
                return;
            }
            this.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(gnssStatus));
        }

        /* synthetic */ void lambda$onStarted$0$androidx-core-location-LocationManagerCompat$PreRGnssStatusTransport(Executor executor) {
            if (this.mExecutor != executor) {
                return;
            }
            this.mCallback.onStarted();
        }

        /* synthetic */ void lambda$onStopped$1$androidx-core-location-LocationManagerCompat$PreRGnssStatusTransport(Executor executor) {
            if (this.mExecutor != executor) {
                return;
            }
            this.mCallback.onStopped();
        }

        public void onFirstFix(int n) {
            Executor executor = this.mExecutor;
            if (executor == null) {
                return;
            }
            executor.execute(new LocationManagerCompat$PreRGnssStatusTransport$$ExternalSyntheticLambda2(this, executor, n));
        }

        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            Executor executor = this.mExecutor;
            if (executor == null) {
                return;
            }
            executor.execute(new LocationManagerCompat$PreRGnssStatusTransport$$ExternalSyntheticLambda1(this, executor, gnssStatus));
        }

        public void onStarted() {
            Executor executor = this.mExecutor;
            if (executor == null) {
                return;
            }
            executor.execute(new LocationManagerCompat$PreRGnssStatusTransport$$ExternalSyntheticLambda0(this, executor));
        }

        public void onStopped() {
            Executor executor = this.mExecutor;
            if (executor == null) {
                return;
            }
            executor.execute(new LocationManagerCompat$PreRGnssStatusTransport$$ExternalSyntheticLambda3(this, executor));
        }

        public void register(Executor executor) {
            boolean bl = true;
            boolean bl2 = executor != null;
            Preconditions.checkArgument(bl2, "invalid null executor");
            bl2 = this.mExecutor == null ? bl : false;
            Preconditions.checkState(bl2);
            this.mExecutor = executor;
        }

        public void unregister() {
            this.mExecutor = null;
        }
    }
}

