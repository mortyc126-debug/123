/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.lifecycle;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviderGetKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactory;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0004\u0016\u0017\u0018\u0019B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007B!\b\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ&\u0010\r\u001a\u0002H\u000e\"\b\b\u0000\u0010\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0011H\u0097\u0002\u00a2\u0006\u0002\u0010\u0012J.\u0010\r\u001a\u0002H\u000e\"\b\b\u0000\u0010\u000e*\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0011H\u0097\u0002\u00a2\u0006\u0002\u0010\u0015R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Landroidx/lifecycle/ViewModelProvider;", "", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "(Landroidx/lifecycle/ViewModelStoreOwner;)V", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "(Landroidx/lifecycle/ViewModelStoreOwner;Landroidx/lifecycle/ViewModelProvider$Factory;)V", "store", "Landroidx/lifecycle/ViewModelStore;", "defaultCreationExtras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Landroidx/lifecycle/ViewModelStore;Landroidx/lifecycle/ViewModelProvider$Factory;Landroidx/lifecycle/viewmodel/CreationExtras;)V", "get", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "key", "", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "AndroidViewModelFactory", "Factory", "NewInstanceFactory", "OnRequeryFactory", "lifecycle-viewmodel_release"}, k=1, mv={1, 8, 0}, xi=48)
public class ViewModelProvider {
    private final CreationExtras defaultCreationExtras;
    private final Factory factory;
    private final ViewModelStore store;

    public ViewModelProvider(ViewModelStore viewModelStore, Factory factory2) {
        Intrinsics.checkNotNullParameter((Object)viewModelStore, (String)"store");
        Intrinsics.checkNotNullParameter((Object)factory2, (String)"factory");
        this(viewModelStore, factory2, null, 4, null);
    }

    public ViewModelProvider(ViewModelStore viewModelStore, Factory factory2, CreationExtras creationExtras) {
        Intrinsics.checkNotNullParameter((Object)viewModelStore, (String)"store");
        Intrinsics.checkNotNullParameter((Object)factory2, (String)"factory");
        Intrinsics.checkNotNullParameter((Object)creationExtras, (String)"defaultCreationExtras");
        this.store = viewModelStore;
        this.factory = factory2;
        this.defaultCreationExtras = creationExtras;
    }

    public /* synthetic */ ViewModelProvider(ViewModelStore viewModelStore, Factory factory2, CreationExtras creationExtras, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            creationExtras = CreationExtras.Empty.INSTANCE;
        }
        this(viewModelStore, factory2, creationExtras);
    }

    public ViewModelProvider(ViewModelStoreOwner viewModelStoreOwner) {
        Intrinsics.checkNotNullParameter((Object)viewModelStoreOwner, (String)"owner");
        this(viewModelStoreOwner.getViewModelStore(), AndroidViewModelFactory.Companion.defaultFactory$lifecycle_viewmodel_release(viewModelStoreOwner), ViewModelProviderGetKt.defaultCreationExtras(viewModelStoreOwner));
    }

    public ViewModelProvider(ViewModelStoreOwner viewModelStoreOwner, Factory factory2) {
        Intrinsics.checkNotNullParameter((Object)viewModelStoreOwner, (String)"owner");
        Intrinsics.checkNotNullParameter((Object)factory2, (String)"factory");
        ViewModelStore viewModelStore = viewModelStoreOwner.getViewModelStore();
        this(viewModelStore, factory2, ViewModelProviderGetKt.defaultCreationExtras(viewModelStoreOwner));
    }

    public <T extends ViewModel> T get(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, (String)"modelClass");
        String string2 = clazz.getCanonicalName();
        if (string2 != null) {
            return this.get("androidx.lifecycle.ViewModelProvider.DefaultKey:" + string2, clazz);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public <T extends ViewModel> T get(String object, Class<T> object2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"key");
        Intrinsics.checkNotNullParameter(object2, (String)"modelClass");
        Object object3 = this.store.get((String)object);
        if (((Class)object2).isInstance(object3)) {
            object = this.factory;
            object = object instanceof OnRequeryFactory ? (OnRequeryFactory)object : null;
            if (object != null) {
                Intrinsics.checkNotNull((Object)object3);
                ((OnRequeryFactory)object).onRequery((ViewModel)object3);
            }
            Intrinsics.checkNotNull((Object)object3, (String)"null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
            return (T)object3;
        }
        object3 = new MutableCreationExtras(this.defaultCreationExtras);
        ((MutableCreationExtras)object3).set(NewInstanceFactory.VIEW_MODEL_KEY, object);
        try {
            object2 = object3 = this.factory.create(object2, (CreationExtras)object3);
        }
        catch (AbstractMethodError abstractMethodError) {
            object2 = this.factory.create(object2);
        }
        this.store.put((String)object, (ViewModel)object2);
        return (T)object2;
    }

    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005B\u0019\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ%\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\rH\u0016\u00a2\u0006\u0002\u0010\u000eJ-\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\r2\u0006\u0010\u000f\u001a\u00020\u0004H\u0002\u00a2\u0006\u0002\u0010\u0010J-\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016\u00a2\u0006\u0002\u0010\u0013R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Landroidx/lifecycle/ViewModelProvider$AndroidViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "()V", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "unused", "", "(Landroid/app/Application;I)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app", "(Ljava/lang/Class;Landroid/app/Application;)Landroidx/lifecycle/ViewModel;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "Companion", "lifecycle-viewmodel_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static class AndroidViewModelFactory
    extends NewInstanceFactory {
        public static final CreationExtras.Key<Application> APPLICATION_KEY;
        public static final Companion Companion;
        public static final String DEFAULT_KEY = "androidx.lifecycle.ViewModelProvider.DefaultKey";
        private static AndroidViewModelFactory sInstance;
        private final Application application;

        static {
            Companion = new Companion(null);
            APPLICATION_KEY = Companion.ApplicationKeyImpl.INSTANCE;
        }

        public AndroidViewModelFactory() {
            this(null, 0);
        }

        public AndroidViewModelFactory(Application application) {
            Intrinsics.checkNotNullParameter((Object)application, (String)"application");
            this(application, 0);
        }

        private AndroidViewModelFactory(Application application, int n) {
            this.application = application;
        }

        private final <T extends ViewModel> T create(Class<T> object, Application object2) {
            block6: {
                block5: {
                    if (!AndroidViewModel.class.isAssignableFrom((Class<?>)object)) break block5;
                    try {
                        object2 = (ViewModel)object.getConstructor(Application.class).newInstance(object2);
                    }
                    catch (InvocationTargetException invocationTargetException) {
                        throw new RuntimeException("Cannot create an instance of " + object, invocationTargetException);
                    }
                    catch (InstantiationException instantiationException) {
                        throw new RuntimeException("Cannot create an instance of " + object, instantiationException);
                    }
                    catch (IllegalAccessException illegalAccessException) {
                        throw new RuntimeException("Cannot create an instance of " + object, illegalAccessException);
                    }
                    catch (NoSuchMethodException noSuchMethodException) {
                        throw new RuntimeException("Cannot create an instance of " + object, noSuchMethodException);
                    }
                    Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"{\n                try {\n\u2026          }\n            }");
                    object = object2;
                    break block6;
                }
                object = super.create(object);
            }
            return (T)object;
        }

        @JvmStatic
        public static final AndroidViewModelFactory getInstance(Application application) {
            return Companion.getInstance(application);
        }

        @Override
        public <T extends ViewModel> T create(Class<T> clazz) {
            Intrinsics.checkNotNullParameter(clazz, (String)"modelClass");
            if (this.application != null) {
                return this.create(clazz, this.application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        @Override
        public <T extends ViewModel> T create(Class<T> clazz, CreationExtras creationExtras) {
            block5: {
                block3: {
                    block4: {
                        block2: {
                            Intrinsics.checkNotNullParameter(clazz, (String)"modelClass");
                            Intrinsics.checkNotNullParameter((Object)creationExtras, (String)"extras");
                            if (this.application == null) break block2;
                            clazz = this.create(clazz);
                            break block3;
                        }
                        if ((creationExtras = creationExtras.get(APPLICATION_KEY)) == null) break block4;
                        clazz = this.create(clazz, (Application)creationExtras);
                        break block3;
                    }
                    if (AndroidViewModel.class.isAssignableFrom(clazz)) break block5;
                    clazz = super.create(clazz);
                }
                return (T)clazz;
            }
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        }

        @Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000\u00a2\u0006\u0002\b\u000eJ\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0005H\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0080T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Landroidx/lifecycle/ViewModelProvider$AndroidViewModelFactory$Companion;", "", "()V", "APPLICATION_KEY", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "Landroid/app/Application;", "DEFAULT_KEY", "", "sInstance", "Landroidx/lifecycle/ViewModelProvider$AndroidViewModelFactory;", "defaultFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "defaultFactory$lifecycle_viewmodel_release", "getInstance", "application", "ApplicationKeyImpl", "lifecycle-viewmodel_release"}, k=1, mv={1, 8, 0}, xi=48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Factory defaultFactory$lifecycle_viewmodel_release(ViewModelStoreOwner object) {
                Intrinsics.checkNotNullParameter((Object)object, (String)"owner");
                object = object instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory)object).getDefaultViewModelProviderFactory() : (Factory)NewInstanceFactory.Companion.getInstance();
                return object;
            }

            @JvmStatic
            public final AndroidViewModelFactory getInstance(Application object) {
                Intrinsics.checkNotNullParameter((Object)object, (String)"application");
                if (sInstance == null) {
                    sInstance = new AndroidViewModelFactory((Application)object);
                }
                object = sInstance;
                Intrinsics.checkNotNull((Object)object);
                return object;
            }

            @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c2\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Landroidx/lifecycle/ViewModelProvider$AndroidViewModelFactory$Companion$ApplicationKeyImpl;", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "Landroid/app/Application;", "()V", "lifecycle-viewmodel_release"}, k=1, mv={1, 8, 0}, xi=48)
            private static final class ApplicationKeyImpl
            implements CreationExtras.Key<Application> {
                public static final ApplicationKeyImpl INSTANCE = new ApplicationKeyImpl();

                private ApplicationKeyImpl() {
                }
            }
        }
    }

    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ%\u0010\u0002\u001a\u0002H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H\u0016\u00a2\u0006\u0002\u0010\u0007J-\u0010\u0002\u001a\u0002H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00062\u0006\u0010\b\u001a\u00020\tH\u0016\u00a2\u0006\u0002\u0010\n\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\f\u00c0\u0006\u0001"}, d2={"Landroidx/lifecycle/ViewModelProvider$Factory;", "", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "Companion", "lifecycle-viewmodel_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static interface Factory {
        public static final Companion Companion = Companion.$$INSTANCE;

        @JvmStatic
        public static Factory from(ViewModelInitializer<?> ... viewModelInitializerArray) {
            return Companion.from(viewModelInitializerArray);
        }

        default public <T extends ViewModel> T create(Class<T> clazz) {
            Intrinsics.checkNotNullParameter(clazz, (String)"modelClass");
            throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
        }

        default public <T extends ViewModel> T create(Class<T> clazz, CreationExtras creationExtras) {
            Intrinsics.checkNotNullParameter(clazz, (String)"modelClass");
            Intrinsics.checkNotNullParameter((Object)creationExtras, (String)"extras");
            return this.create(clazz);
        }

        @Metadata(d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\u001a\u0010\u0005\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006\"\u0006\u0012\u0002\b\u00030\u0007H\u0007\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2={"Landroidx/lifecycle/ViewModelProvider$Factory$Companion;", "", "()V", "from", "Landroidx/lifecycle/ViewModelProvider$Factory;", "initializers", "", "Landroidx/lifecycle/viewmodel/ViewModelInitializer;", "([Landroidx/lifecycle/viewmodel/ViewModelInitializer;)Landroidx/lifecycle/ViewModelProvider$Factory;", "lifecycle-viewmodel_release"}, k=1, mv={1, 8, 0}, xi=48)
        public static final class Companion {
            static final Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            @JvmStatic
            public final Factory from(ViewModelInitializer<?> ... viewModelInitializerArray) {
                Intrinsics.checkNotNullParameter(viewModelInitializerArray, (String)"initializers");
                return new InitializerViewModelFactory(Arrays.copyOf(viewModelInitializerArray, viewModelInitializerArray.length));
            }
        }
    }

    @Metadata(d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u0002H\u0004\"\b\b\u0000\u0010\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0007H\u0016\u00a2\u0006\u0002\u0010\b\u00a8\u0006\n"}, d2={"Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "()V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Companion", "lifecycle-viewmodel_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static class NewInstanceFactory
    implements Factory {
        public static final Companion Companion = new Companion(null);
        public static final CreationExtras.Key<String> VIEW_MODEL_KEY = Companion.ViewModelKeyImpl.INSTANCE;
        private static NewInstanceFactory sInstance;

        public static final NewInstanceFactory getInstance() {
            return Companion.getInstance();
        }

        @Override
        public <T extends ViewModel> T create(Class<T> clazz) {
            Object object;
            Intrinsics.checkNotNullParameter(clazz, (String)"modelClass");
            try {
                object = clazz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(object, (String)"{\n                modelC\u2026wInstance()\n            }");
                object = (ViewModel)object;
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new RuntimeException("Cannot create an instance of " + clazz, illegalAccessException);
            }
            catch (InstantiationException instantiationException) {
                throw new RuntimeException("Cannot create an instance of " + clazz, instantiationException);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                throw new RuntimeException("Cannot create an instance of " + clazz, noSuchMethodException);
            }
            return object;
        }

        @Metadata(d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\fB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00078GX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory$Companion;", "", "()V", "VIEW_MODEL_KEY", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "", "instance", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "getInstance$annotations", "getInstance", "()Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "sInstance", "ViewModelKeyImpl", "lifecycle-viewmodel_release"}, k=1, mv={1, 8, 0}, xi=48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public static /* synthetic */ void getInstance$annotations() {
            }

            public final NewInstanceFactory getInstance() {
                if (sInstance == null) {
                    sInstance = new NewInstanceFactory();
                }
                NewInstanceFactory newInstanceFactory = sInstance;
                Intrinsics.checkNotNull((Object)newInstanceFactory);
                return newInstanceFactory;
            }

            @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c2\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory$Companion$ViewModelKeyImpl;", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "", "()V", "lifecycle-viewmodel_release"}, k=1, mv={1, 8, 0}, xi=48)
            private static final class ViewModelKeyImpl
            implements CreationExtras.Key<String> {
                public static final ViewModelKeyImpl INSTANCE = new ViewModelKeyImpl();

                private ViewModelKeyImpl() {
                }
            }
        }
    }

    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2={"Landroidx/lifecycle/ViewModelProvider$OnRequeryFactory;", "", "()V", "onRequery", "", "viewModel", "Landroidx/lifecycle/ViewModel;", "lifecycle-viewmodel_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static class OnRequeryFactory {
        public void onRequery(ViewModel viewModel2) {
            Intrinsics.checkNotNullParameter((Object)viewModel2, (String)"viewModel");
        }
    }
}

