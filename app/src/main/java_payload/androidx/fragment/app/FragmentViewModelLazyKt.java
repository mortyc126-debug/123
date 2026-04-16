/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.LazyThreadSafetyMode
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KClass
 */
package androidx.fragment.app;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0010\b\n\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0087\b\u00f8\u0001\u0000\u001aF\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0010\b\n\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\u0010\b\n\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0087\b\u00f8\u0001\u0000\u001aJ\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007\u001aZ\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007\u001aD\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u000e\b\n\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00062\u0010\b\n\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0087\b\u00f8\u0001\u0000\u001aV\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u000e\b\n\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00062\u0010\b\n\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\u0010\b\n\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0087\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0012\u00b2\u0006\u0016\u0010\u0013\u001a\u00020\u0011\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003X\u008a\u0084\u0002\u00b2\u0006\u0016\u0010\u0013\u001a\u00020\u0011\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003X\u008a\u0084\u0002"}, d2={"activityViewModels", "Lkotlin/Lazy;", "VM", "Landroidx/lifecycle/ViewModel;", "Landroidx/fragment/app/Fragment;", "factoryProducer", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "extrasProducer", "Landroidx/lifecycle/viewmodel/CreationExtras;", "createViewModelLazy", "viewModelClass", "Lkotlin/reflect/KClass;", "storeProducer", "Landroidx/lifecycle/ViewModelStore;", "viewModels", "ownerProducer", "Landroidx/lifecycle/ViewModelStoreOwner;", "fragment-ktx_release", "owner"}, k=2, mv={1, 6, 0}, xi=48)
public final class FragmentViewModelLazyKt {
    public static final /* synthetic */ ViewModelStoreOwner access$viewModels$lambda-0(Lazy lazy) {
        return FragmentViewModelLazyKt.viewModels$lambda-0((Lazy<? extends ViewModelStoreOwner>)lazy);
    }

    public static final /* synthetic */ ViewModelStoreOwner access$viewModels$lambda-1(Lazy lazy) {
        return FragmentViewModelLazyKt.viewModels$lambda-1((Lazy<? extends ViewModelStoreOwner>)lazy);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Superseded by activityViewModels that takes a CreationExtras producer")
    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> activityViewModels(Fragment fragment, Function0<? extends ViewModelProvider.Factory> function0) {
        Function0 function02;
        Function0 function03;
        KClass kClass;
        block0: {
            Intrinsics.checkNotNullParameter((Object)fragment, (String)"<this>");
            Intrinsics.reifiedOperationMarker((int)4, (String)"VM");
            kClass = Reflection.getOrCreateKotlinClass(ViewModel.class);
            function03 = (Function0)new Function0<ViewModelStore>(fragment){
                final Fragment $this_activityViewModels;
                {
                    this.$this_activityViewModels = fragment;
                    super(0);
                }

                public final ViewModelStore invoke() {
                    ViewModelStore viewModelStore = this.$this_activityViewModels.requireActivity().getViewModelStore();
                    Intrinsics.checkNotNullExpressionValue((Object)viewModelStore, (String)"requireActivity().viewModelStore");
                    return viewModelStore;
                }
            };
            function02 = (Function0)new Function0<CreationExtras>(fragment){
                final Fragment $this_activityViewModels;
                {
                    this.$this_activityViewModels = fragment;
                    super(0);
                }

                public final CreationExtras invoke() {
                    CreationExtras creationExtras = this.$this_activityViewModels.requireActivity().getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue((Object)creationExtras, (String)"requireActivity().defaultViewModelCreationExtras");
                    return creationExtras;
                }
            };
            if (function0 != null) break block0;
            function0 = (Function0)new Function0<ViewModelProvider.Factory>(fragment){
                final Fragment $this_activityViewModels;
                {
                    this.$this_activityViewModels = fragment;
                    super(0);
                }

                public final ViewModelProvider.Factory invoke() {
                    ViewModelProvider.Factory factory2 = this.$this_activityViewModels.requireActivity().getDefaultViewModelProviderFactory();
                    Intrinsics.checkNotNullExpressionValue((Object)factory2, (String)"requireActivity().defaultViewModelProviderFactory");
                    return factory2;
                }
            };
        }
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, kClass, (Function0<? extends ViewModelStore>)function03, (Function0<? extends CreationExtras>)function02, (Function0<? extends ViewModelProvider.Factory>)function0);
    }

    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> activityViewModels(Fragment fragment, Function0<? extends CreationExtras> function0, Function0<? extends ViewModelProvider.Factory> function02) {
        Function0 function03;
        KClass kClass;
        block0: {
            Intrinsics.checkNotNullParameter((Object)fragment, (String)"<this>");
            Intrinsics.reifiedOperationMarker((int)4, (String)"VM");
            kClass = Reflection.getOrCreateKotlinClass(ViewModel.class);
            function03 = (Function0)new Function0<ViewModelStore>(fragment){
                final Fragment $this_activityViewModels;
                {
                    this.$this_activityViewModels = fragment;
                    super(0);
                }

                public final ViewModelStore invoke() {
                    ViewModelStore viewModelStore = this.$this_activityViewModels.requireActivity().getViewModelStore();
                    Intrinsics.checkNotNullExpressionValue((Object)viewModelStore, (String)"requireActivity().viewModelStore");
                    return viewModelStore;
                }
            };
            function0 = (Function0)new Function0<CreationExtras>(function0, fragment){
                final Function0<CreationExtras> $extrasProducer;
                final Fragment $this_activityViewModels;
                {
                    this.$extrasProducer = function0;
                    this.$this_activityViewModels = fragment;
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
                        object = this.$this_activityViewModels.requireActivity().getDefaultViewModelCreationExtras();
                        Intrinsics.checkNotNullExpressionValue(object, (String)"requireActivity().defaultViewModelCreationExtras");
                    }
                    return object;
                }
            };
            if (function02 != null) break block0;
            function02 = (Function0)new Function0<ViewModelProvider.Factory>(fragment){
                final Fragment $this_activityViewModels;
                {
                    this.$this_activityViewModels = fragment;
                    super(0);
                }

                public final ViewModelProvider.Factory invoke() {
                    ViewModelProvider.Factory factory2 = this.$this_activityViewModels.requireActivity().getDefaultViewModelProviderFactory();
                    Intrinsics.checkNotNullExpressionValue((Object)factory2, (String)"requireActivity().defaultViewModelProviderFactory");
                    return factory2;
                }
            };
        }
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, kClass, (Function0<? extends ViewModelStore>)function03, (Function0<? extends CreationExtras>)function0, (Function0<? extends ViewModelProvider.Factory>)function02);
    }

    public static /* synthetic */ Lazy activityViewModels$default(Fragment fragment, Function0 function0, int n, Object object) {
        Function0 function02;
        Function0 function03;
        block1: {
            if ((n & 1) != 0) {
                function0 = null;
            }
            Intrinsics.checkNotNullParameter((Object)fragment, (String)"<this>");
            Intrinsics.reifiedOperationMarker((int)4, (String)"VM");
            object = Reflection.getOrCreateKotlinClass(ViewModel.class);
            function03 = (Function0)new /* invalid duplicate definition of identical inner class */;
            function02 = (Function0)new /* invalid duplicate definition of identical inner class */;
            if (function0 != null) break block1;
            function0 = (Function0)new /* invalid duplicate definition of identical inner class */;
        }
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, object, (Function0<? extends ViewModelStore>)function03, (Function0<? extends CreationExtras>)function02, (Function0<? extends ViewModelProvider.Factory>)function0);
    }

    public static /* synthetic */ Lazy activityViewModels$default(Fragment fragment, Function0 function0, Function0 function02, int n, Object object) {
        KClass kClass;
        block2: {
            if ((n & 1) != 0) {
                function0 = null;
            }
            if ((n & 2) != 0) {
                function02 = null;
            }
            Intrinsics.checkNotNullParameter((Object)fragment, (String)"<this>");
            Intrinsics.reifiedOperationMarker((int)4, (String)"VM");
            kClass = Reflection.getOrCreateKotlinClass(ViewModel.class);
            object = (Function0)new /* invalid duplicate definition of identical inner class */;
            function0 = (Function0)new /* invalid duplicate definition of identical inner class */;
            if (function02 != null) break block2;
            function02 = (Function0)new /* invalid duplicate definition of identical inner class */;
        }
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, kClass, (Function0<? extends ViewModelStore>)object, (Function0<? extends CreationExtras>)function0, (Function0<? extends ViewModelProvider.Factory>)function02);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Superseded by createViewModelLazy that takes a CreationExtras producer")
    public static final /* synthetic */ Lazy createViewModelLazy(Fragment fragment, KClass kClass, Function0 function0, Function0 function02) {
        Intrinsics.checkNotNullParameter((Object)fragment, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)kClass, (String)"viewModelClass");
        Intrinsics.checkNotNullParameter((Object)function0, (String)"storeProducer");
        Function0 function03 = (Function0)new Function0<CreationExtras>(fragment){
            final Fragment $this_createViewModelLazy;
            {
                this.$this_createViewModelLazy = fragment;
                super(0);
            }

            public final CreationExtras invoke() {
                CreationExtras creationExtras = this.$this_createViewModelLazy.getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue((Object)creationExtras, (String)"defaultViewModelCreationExtras");
                return creationExtras;
            }
        };
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, kClass, (Function0<? extends ViewModelStore>)function0, (Function0<? extends CreationExtras>)function03, (Function0<? extends ViewModelProvider.Factory>)function02);
    }

    public static final <VM extends ViewModel> Lazy<VM> createViewModelLazy(Fragment fragment, KClass<VM> kClass, Function0<? extends ViewModelStore> function0, Function0<? extends CreationExtras> function02, Function0<? extends ViewModelProvider.Factory> function03) {
        Intrinsics.checkNotNullParameter((Object)fragment, (String)"<this>");
        Intrinsics.checkNotNullParameter(kClass, (String)"viewModelClass");
        Intrinsics.checkNotNullParameter(function0, (String)"storeProducer");
        Intrinsics.checkNotNullParameter(function02, (String)"extrasProducer");
        if (function03 == null) {
            function03 = (Function0)new Function0<ViewModelProvider.Factory>(fragment){
                final Fragment $this_createViewModelLazy;
                {
                    this.$this_createViewModelLazy = fragment;
                    super(0);
                }

                public final ViewModelProvider.Factory invoke() {
                    ViewModelProvider.Factory factory2 = this.$this_createViewModelLazy.getDefaultViewModelProviderFactory();
                    Intrinsics.checkNotNullExpressionValue((Object)factory2, (String)"defaultViewModelProviderFactory");
                    return factory2;
                }
            };
        }
        return new ViewModelLazy<VM>(kClass, function0, (Function0<? extends ViewModelProvider.Factory>)function03, function02);
    }

    public static /* synthetic */ Lazy createViewModelLazy$default(Fragment fragment, KClass kClass, Function0 function0, Function0 function02, int n, Object object) {
        if ((n & 4) != 0) {
            function02 = null;
        }
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, kClass, function0, function02);
    }

    public static /* synthetic */ Lazy createViewModelLazy$default(Fragment fragment, KClass kClass, Function0 function0, Function0 function02, Function0 function03, int n, Object object) {
        if ((n & 4) != 0) {
            function02 = (Function0)new Function0<CreationExtras>(fragment){
                final Fragment $this_createViewModelLazy;
                {
                    this.$this_createViewModelLazy = fragment;
                    super(0);
                }

                public final CreationExtras invoke() {
                    CreationExtras creationExtras = this.$this_createViewModelLazy.getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue((Object)creationExtras, (String)"defaultViewModelCreationExtras");
                    return creationExtras;
                }
            };
        }
        if ((n & 8) != 0) {
            function03 = null;
        }
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, kClass, (Function0<? extends ViewModelStore>)function0, (Function0<? extends CreationExtras>)function02, (Function0<? extends ViewModelProvider.Factory>)function03);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Superseded by viewModels that takes a CreationExtras producer")
    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> viewModels(Fragment fragment, Function0<? extends ViewModelStoreOwner> function0, Function0<? extends ViewModelProvider.Factory> function02) {
        Function0 function03;
        KClass kClass;
        block0: {
            Intrinsics.checkNotNullParameter((Object)fragment, (String)"<this>");
            Intrinsics.checkNotNullParameter(function0, (String)"ownerProducer");
            Lazy lazy = LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.NONE, (Function0)((Function0)new Function0<ViewModelStoreOwner>(function0){
                final Function0<ViewModelStoreOwner> $ownerProducer;
                {
                    this.$ownerProducer = function0;
                    super(0);
                }

                public final ViewModelStoreOwner invoke() {
                    return (ViewModelStoreOwner)this.$ownerProducer.invoke();
                }
            }));
            Intrinsics.reifiedOperationMarker((int)4, (String)"VM");
            kClass = Reflection.getOrCreateKotlinClass(ViewModel.class);
            function0 = (Function0)new Function0<ViewModelStore>((Lazy<? extends ViewModelStoreOwner>)lazy){
                final Lazy<ViewModelStoreOwner> $owner$delegate;
                {
                    this.$owner$delegate = lazy;
                    super(0);
                }

                public final ViewModelStore invoke() {
                    ViewModelStore viewModelStore = FragmentViewModelLazyKt.access$viewModels$lambda-0(this.$owner$delegate).getViewModelStore();
                    Intrinsics.checkNotNullExpressionValue((Object)viewModelStore, (String)"owner.viewModelStore");
                    return viewModelStore;
                }
            };
            function03 = (Function0)new Function0<CreationExtras>((Lazy<? extends ViewModelStoreOwner>)lazy){
                final Lazy<ViewModelStoreOwner> $owner$delegate;
                {
                    this.$owner$delegate = lazy;
                    super(0);
                }

                public final CreationExtras invoke() {
                    Object object = FragmentViewModelLazyKt.access$viewModels$lambda-0(this.$owner$delegate);
                    boolean bl = object instanceof HasDefaultViewModelProviderFactory;
                    CreationExtras creationExtras = null;
                    object = bl ? (HasDefaultViewModelProviderFactory)object : null;
                    if (object != null) {
                        creationExtras = object.getDefaultViewModelCreationExtras();
                    }
                    object = creationExtras;
                    if (creationExtras == null) {
                        object = CreationExtras.Empty.INSTANCE;
                    }
                    return object;
                }
            };
            if (function02 != null) break block0;
            function02 = (Function0)new Function0<ViewModelProvider.Factory>(fragment, (Lazy<? extends ViewModelStoreOwner>)lazy){
                final Lazy<ViewModelStoreOwner> $owner$delegate;
                final Fragment $this_viewModels;
                {
                    this.$this_viewModels = fragment;
                    this.$owner$delegate = lazy;
                    super(0);
                }

                public final ViewModelProvider.Factory invoke() {
                    Object object;
                    block3: {
                        block2: {
                            object = FragmentViewModelLazyKt.access$viewModels$lambda-0(this.$owner$delegate);
                            object = object instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory)object : null;
                            if (object == null) break block2;
                            ViewModelProvider.Factory factory2 = object.getDefaultViewModelProviderFactory();
                            object = factory2;
                            if (factory2 != null) break block3;
                        }
                        object = this.$this_viewModels.getDefaultViewModelProviderFactory();
                    }
                    Intrinsics.checkNotNullExpressionValue((Object)object, (String)"(owner as? HasDefaultVie\u2026tViewModelProviderFactory");
                    return object;
                }
            };
        }
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, kClass, (Function0<? extends ViewModelStore>)function0, (Function0<? extends CreationExtras>)function03, function02);
    }

    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> viewModels(Fragment fragment, Function0<? extends ViewModelStoreOwner> kClass, Function0<? extends CreationExtras> function0, Function0<? extends ViewModelProvider.Factory> function02) {
        Function0 function03;
        block0: {
            Intrinsics.checkNotNullParameter((Object)fragment, (String)"<this>");
            Intrinsics.checkNotNullParameter(kClass, (String)"ownerProducer");
            Lazy lazy = LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.NONE, (Function0)((Function0)new Function0<ViewModelStoreOwner>(kClass){
                final Function0<ViewModelStoreOwner> $ownerProducer;
                {
                    this.$ownerProducer = function0;
                    super(0);
                }

                public final ViewModelStoreOwner invoke() {
                    return (ViewModelStoreOwner)this.$ownerProducer.invoke();
                }
            }));
            Intrinsics.reifiedOperationMarker((int)4, (String)"VM");
            kClass = Reflection.getOrCreateKotlinClass(ViewModel.class);
            function03 = (Function0)new Function0<ViewModelStore>((Lazy<? extends ViewModelStoreOwner>)lazy){
                final Lazy<ViewModelStoreOwner> $owner$delegate;
                {
                    this.$owner$delegate = lazy;
                    super(0);
                }

                public final ViewModelStore invoke() {
                    ViewModelStore viewModelStore = FragmentViewModelLazyKt.access$viewModels$lambda-1(this.$owner$delegate).getViewModelStore();
                    Intrinsics.checkNotNullExpressionValue((Object)viewModelStore, (String)"owner.viewModelStore");
                    return viewModelStore;
                }
            };
            function0 = (Function0)new Function0<CreationExtras>(function0, (Lazy<? extends ViewModelStoreOwner>)lazy){
                final Function0<CreationExtras> $extrasProducer;
                final Lazy<ViewModelStoreOwner> $owner$delegate;
                {
                    this.$extrasProducer = function0;
                    this.$owner$delegate = lazy;
                    super(0);
                }

                public final CreationExtras invoke() {
                    Object object;
                    block5: {
                        CreationExtras creationExtras;
                        block4: {
                            object = this.$extrasProducer;
                            if (object == null) break block4;
                            creationExtras = (CreationExtras)object.invoke();
                            object = creationExtras;
                            if (creationExtras != null) break block5;
                        }
                        object = (object = FragmentViewModelLazyKt.access$viewModels$lambda-1(this.$owner$delegate)) instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory)object : null;
                        creationExtras = object != null ? object.getDefaultViewModelCreationExtras() : null;
                        object = creationExtras;
                        if (creationExtras == null) {
                            object = CreationExtras.Empty.INSTANCE;
                        }
                    }
                    return object;
                }
            };
            if (function02 != null) break block0;
            function02 = (Function0)new Function0<ViewModelProvider.Factory>(fragment, (Lazy<? extends ViewModelStoreOwner>)lazy){
                final Lazy<ViewModelStoreOwner> $owner$delegate;
                final Fragment $this_viewModels;
                {
                    this.$this_viewModels = fragment;
                    this.$owner$delegate = lazy;
                    super(0);
                }

                public final ViewModelProvider.Factory invoke() {
                    Object object;
                    block3: {
                        block2: {
                            object = FragmentViewModelLazyKt.access$viewModels$lambda-1(this.$owner$delegate);
                            object = object instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory)object : null;
                            if (object == null) break block2;
                            ViewModelProvider.Factory factory2 = object.getDefaultViewModelProviderFactory();
                            object = factory2;
                            if (factory2 != null) break block3;
                        }
                        object = this.$this_viewModels.getDefaultViewModelProviderFactory();
                    }
                    Intrinsics.checkNotNullExpressionValue((Object)object, (String)"(owner as? HasDefaultVie\u2026tViewModelProviderFactory");
                    return object;
                }
            };
        }
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, kClass, (Function0<? extends ViewModelStore>)function03, (Function0<? extends CreationExtras>)function0, function02);
    }

    public static /* synthetic */ Lazy viewModels$default(Fragment fragment, Function0 function0, Function0 function02, int n, Object object) {
        KClass kClass;
        block2: {
            if ((n & 1) != 0) {
                function0 = (Function0)new Function0<Fragment>(fragment){
                    final Fragment $this_viewModels;
                    {
                        this.$this_viewModels = fragment;
                        super(0);
                    }

                    public final Fragment invoke() {
                        return this.$this_viewModels;
                    }
                };
            }
            if ((n & 2) != 0) {
                function02 = null;
            }
            Intrinsics.checkNotNullParameter((Object)fragment, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)function0, (String)"ownerProducer");
            Lazy lazy = LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.NONE, (Function0)((Function0)new /* invalid duplicate definition of identical inner class */));
            Intrinsics.reifiedOperationMarker((int)4, (String)"VM");
            kClass = Reflection.getOrCreateKotlinClass(ViewModel.class);
            object = (Function0)new /* invalid duplicate definition of identical inner class */;
            function0 = (Function0)new /* invalid duplicate definition of identical inner class */;
            if (function02 != null) break block2;
            function02 = (Function0)new /* invalid duplicate definition of identical inner class */;
        }
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, kClass, (Function0<? extends ViewModelStore>)object, (Function0<? extends CreationExtras>)function0, (Function0<? extends ViewModelProvider.Factory>)function02);
    }

    public static /* synthetic */ Lazy viewModels$default(Fragment fragment, Function0 function0, Function0 function02, Function0 function03, int n, Object object) {
        block3: {
            if ((n & 1) != 0) {
                function0 = (Function0)new Function0<Fragment>(fragment){
                    final Fragment $this_viewModels;
                    {
                        this.$this_viewModels = fragment;
                        super(0);
                    }

                    public final Fragment invoke() {
                        return this.$this_viewModels;
                    }
                };
            }
            if ((n & 2) != 0) {
                function02 = null;
            }
            if ((n & 4) != 0) {
                function03 = null;
            }
            Intrinsics.checkNotNullParameter((Object)fragment, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)function0, (String)"ownerProducer");
            Lazy lazy = LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.NONE, (Function0)((Function0)new /* invalid duplicate definition of identical inner class */));
            Intrinsics.reifiedOperationMarker((int)4, (String)"VM");
            function0 = Reflection.getOrCreateKotlinClass(ViewModel.class);
            object = (Function0)new /* invalid duplicate definition of identical inner class */;
            function02 = (Function0)new /* invalid duplicate definition of identical inner class */;
            if (function03 != null) break block3;
            function03 = (Function0)new /* invalid duplicate definition of identical inner class */;
        }
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, function0, (Function0<? extends ViewModelStore>)object, (Function0<? extends CreationExtras>)function02, (Function0<? extends ViewModelProvider.Factory>)function03);
    }

    private static final ViewModelStoreOwner viewModels$lambda-0(Lazy<? extends ViewModelStoreOwner> lazy) {
        return (ViewModelStoreOwner)lazy.getValue();
    }

    private static final ViewModelStoreOwner viewModels$lambda-1(Lazy<? extends ViewModelStoreOwner> lazy) {
        return (ViewModelStoreOwner)lazy.getValue();
    }
}

