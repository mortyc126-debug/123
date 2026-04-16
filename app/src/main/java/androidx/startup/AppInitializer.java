/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Bundle
 */
package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.startup.InitializationProvider;
import androidx.startup.Initializer;
import androidx.startup.R;
import androidx.startup.StartupException;
import androidx.tracing.Trace;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class AppInitializer {
    private static final String SECTION_NAME = "Startup";
    private static volatile AppInitializer sInstance;
    private static final Object sLock;
    final Context mContext;
    final Set<Class<? extends Initializer<?>>> mDiscovered;
    final Map<Class<?>, Object> mInitialized;

    static {
        sLock = new Object();
    }

    AppInitializer(Context context) {
        this.mContext = context.getApplicationContext();
        this.mDiscovered = new HashSet();
        this.mInitialized = new HashMap();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private <T> T doInitialize(Class<? extends Initializer<?>> var1_1, Set<Class<?>> var2_4) {
        block10: {
            if (!Trace.isEnabled()) ** GOTO lbl4
            Trace.beginSection(var1_1.getSimpleName());
lbl4:
            // 2 sources

            if (!var2_4.contains(var1_1)) {
                if (this.mInitialized.containsKey(var1_1)) break block10;
                var2_4.add(var1_1);
            }
            ** GOTO lbl-1000
            {
                catch (Throwable var1_3) {
                    throw var1_3;
                }
                try {
                    var3_5 /* !! */  = (Initializer)var1_1.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    var4_6 = var3_5 /* !! */ .dependencies();
                    if (!var4_6.isEmpty()) {
                        var5_7 = var4_6.iterator();
                        while (var5_7.hasNext()) {
                            var4_6 = var5_7.next();
                            if (this.mInitialized.containsKey(var4_6)) continue;
                            this.doInitialize((Class<? extends Initializer<?>>)var4_6, (Set<Class<?>>)var2_4);
                        }
                    }
                    var3_5 /* !! */  = var3_5 /* !! */ .create(this.mContext);
                    var2_4.remove(var1_1);
                    this.mInitialized.put((Class<?>)var1_1, var3_5 /* !! */ );
                    var1_1 = var3_5 /* !! */ ;
                    return (T)var1_1;
                }
                catch (Throwable var1_2) {}
                ** try [egrp 2[TRYBLOCK] [6 : 174->196)] { 
lbl32:
                // 1 sources

                var2_4 = new StartupException(var1_2);
                throw var2_4;
lbl34:
                // 1 sources

                finally {
                    Trace.endSection();
                }
            }
        }
        var1_1 = this.mInitialized.get(var1_1);
        return (T)var1_1;
lbl-1000:
        // 1 sources

        {
            var1_1 = String.format("Cannot initialize %s. Cycle detected.", new Object[]{var1_1.getName()});
            var2_4 = new IllegalStateException((String)var1_1);
            throw var2_4;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static AppInitializer getInstance(Context context) {
        if (sInstance != null) return sInstance;
        Object object = sLock;
        synchronized (object) {
            AppInitializer appInitializer;
            if (sInstance != null) return sInstance;
            sInstance = appInitializer = new AppInitializer(context);
            return sInstance;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static void setDelegate(AppInitializer appInitializer) {
        Object object = sLock;
        synchronized (object) {
            sInstance = appInitializer;
            return;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void discoverAndInitialize() {
        Throwable throwable2222222;
        block4: {
            Trace.beginSection(SECTION_NAME);
            ComponentName componentName = new ComponentName(this.mContext.getPackageName(), InitializationProvider.class.getName());
            this.discoverAndInitialize(this.mContext.getPackageManager().getProviderInfo((ComponentName)componentName, (int)128).metaData);
            {
                catch (Throwable throwable2222222) {
                    break block4;
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {}
                {
                    StartupException startupException = new StartupException(nameNotFoundException);
                    throw startupException;
                }
            }
            Trace.endSection();
            return;
        }
        Trace.endSection();
        throw throwable2222222;
    }

    void discoverAndInitialize(Bundle object) {
        String string2 = this.mContext.getString(R.string.androidx_startup);
        if (object != null) {
            try {
                HashSet hashSet = new HashSet();
                for (Object object2 : object.keySet()) {
                    if (!string2.equals(object.getString((String)object2, null)) || !Initializer.class.isAssignableFrom((Class<?>)(object2 = Class.forName((String)object2)))) continue;
                    this.mDiscovered.add((Class<Initializer<?>>)object2);
                }
                object = this.mDiscovered.iterator();
                while (object.hasNext()) {
                    this.doInitialize((Class)object.next(), hashSet);
                }
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new StartupException(classNotFoundException);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    <T> T doInitialize(Class<? extends Initializer<?>> clazz) {
        Object object = sLock;
        synchronized (object) {
            HashSet<Class<?>> hashSet;
            HashSet<Class<Object>> hashSet2 = hashSet = this.mInitialized.get(clazz);
            if (hashSet == null) {
                hashSet2 = new HashSet<Class<Object>>();
                hashSet2 = this.doInitialize(clazz, hashSet2);
            }
            return (T)hashSet2;
        }
    }

    public <T> T initializeComponent(Class<? extends Initializer<T>> clazz) {
        return this.doInitialize(clazz);
    }

    public boolean isEagerlyInitialized(Class<? extends Initializer<?>> clazz) {
        return this.mDiscovered.contains(clazz);
    }
}

