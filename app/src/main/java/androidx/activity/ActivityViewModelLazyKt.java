/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Lazy
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KClass
 */
package androidx.activity;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a1\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0010\b\n\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0087\b\u001aC\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0010\b\n\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\u0010\b\n\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0087\b\u00a8\u0006\n"}, d2={"viewModels", "Lkotlin/Lazy;", "VM", "Landroidx/lifecycle/ViewModel;", "Landroidx/activity/ComponentActivity;", "factoryProducer", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "extrasProducer", "Landroidx/lifecycle/viewmodel/CreationExtras;", "activity-ktx_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class ActivityViewModelLazyKt {
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Superseded by viewModels that takes a CreationExtras")
    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> viewModels(ComponentActivity componentActivity, Function0<? extends ViewModelProvider.Factory> function0) {
        if (function0 == null) {
            function0 = (Function0)new Function0<ViewModelProvider.Factory>(componentActivity){
                final ComponentActivity $this_viewModels;
                {
                    this.$this_viewModels = componentActivity;
                    super(0);
                }

                public final ViewModelProvider.Factory invoke() {
                    return this.$this_viewModels.getDefaultViewModelProviderFactory();
                }
            };
        }
        Intrinsics.reifiedOperationMarker((int)4, (String)"VM");
        KClass kClass = Reflection.getOrCreateKotlinClass(ViewModel.class);
        Function0 function02 = (Function0)new Function0<ViewModelStore>(componentActivity){
            final ComponentActivity $this_viewModels;
            {
                this.$this_viewModels = componentActivity;
                super(0);
            }

            public final ViewModelStore invoke() {
                return this.$this_viewModels.getViewModelStore();
            }
        };
        return new ViewModelLazy(kClass, (Function0<? extends ViewModelStore>)function02, (Function0<? extends ViewModelProvider.Factory>)function0, (Function0<? extends CreationExtras>)((Function0)new Function0<CreationExtras>(componentActivity){
            final ComponentActivity $this_viewModels;
            {
                this.$this_viewModels = componentActivity;
                super(0);
            }

            public final CreationExtras invoke() {
                return this.$this_viewModels.getDefaultViewModelCreationExtras();
            }
        }));
    }

    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> viewModels(ComponentActivity componentActivity, Function0<? extends CreationExtras> function0, Function0<? extends ViewModelProvider.Factory> function02) {
        if (function02 == null) {
            function02 = (Function0)new Function0<ViewModelProvider.Factory>(componentActivity){
                final ComponentActivity $this_viewModels;
                {
                    this.$this_viewModels = componentActivity;
                    super(0);
                }

                public final ViewModelProvider.Factory invoke() {
                    return this.$this_viewModels.getDefaultViewModelProviderFactory();
                }
            };
        }
        Intrinsics.reifiedOperationMarker((int)4, (String)"VM");
        KClass kClass = Reflection.getOrCreateKotlinClass(ViewModel.class);
        Function0 function03 = (Function0)new Function0<ViewModelStore>(componentActivity){
            final ComponentActivity $this_viewModels;
            {
                this.$this_viewModels = componentActivity;
                super(0);
            }

            public final ViewModelStore invoke() {
                return this.$this_viewModels.getViewModelStore();
            }
        };
        return new ViewModelLazy(kClass, (Function0<? extends ViewModelStore>)function03, (Function0<? extends ViewModelProvider.Factory>)function02, (Function0<? extends CreationExtras>)((Function0)new Function0<CreationExtras>(function0, componentActivity){
            final Function0<CreationExtras> $extrasProducer;
            final ComponentActivity $this_viewModels;
            {
                this.$extrasProducer = function0;
                this.$this_viewModels = componentActivity;
                super(0);
            }

            public final CreationExtras invoke() {
                Object object;
                block3: {
                    block2: {
                        object = this.$extrasProducer;
                        if (object == null) break block2;
                        CreationExtras creationExtras = (CreationExtras)object.invoke();
                        object = creationExtras;
                        if (creationExtras != null) break block3;
                    }
                    object = this.$this_viewModels.getDefaultViewModelCreationExtras();
                }
                return object;
            }
        }));
    }

    public static /* synthetic */ Lazy viewModels$default(ComponentActivity componentActivity, Function0 function0, int n, Object object) {
        if ((n & 1) != 0) {
            function0 = null;
        }
        if (function0 == null) {
            function0 = (Function0)new /* invalid duplicate definition of identical inner class */;
        }
        Intrinsics.reifiedOperationMarker((int)4, (String)"VM");
        KClass kClass = Reflection.getOrCreateKotlinClass(ViewModel.class);
        object = (Function0)new /* invalid duplicate definition of identical inner class */;
        return new ViewModelLazy(kClass, (Function0<? extends ViewModelStore>)object, (Function0<? extends ViewModelProvider.Factory>)function0, (Function0<? extends CreationExtras>)((Function0)new /* invalid duplicate definition of identical inner class */));
    }

    public static /* synthetic */ Lazy viewModels$default(ComponentActivity componentActivity, Function0 function0, Function0 function02, int n, Object object) {
        if ((n & 1) != 0) {
            function0 = null;
        }
        if ((n & 2) != 0) {
            function02 = null;
        }
        if (function02 == null) {
            function02 = (Function0)new /* invalid duplicate definition of identical inner class */;
        }
        Intrinsics.reifiedOperationMarker((int)4, (String)"VM");
        object = Reflection.getOrCreateKotlinClass(ViewModel.class);
        Function0 function03 = (Function0)new /* invalid duplicate definition of identical inner class */;
        return new ViewModelLazy(object, (Function0<? extends ViewModelStore>)((Function0<ViewModelStore>)((Function0<? extends ViewModelStore>)function03)), (Function0<? extends ViewModelProvider.Factory>)((Function0<ViewModelProvider.Factory>)((Function0<? extends ViewModelProvider.Factory>)function02)), (Function0<? extends CreationExtras>)((Function0<CreationExtras>)((Function0<? extends CreationExtras>)((Function0)new /* invalid duplicate definition of identical inner class */))));
    }
}

