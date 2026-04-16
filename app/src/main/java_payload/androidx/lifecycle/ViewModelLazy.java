/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.Metadata
 *  kotlin.jvm.JvmClassMappingKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KClass
 */
package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003BA\b\u0007\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u00a2\u0006\u0002\u0010\rJ\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0012\u0010\u000e\u001a\u0004\u0018\u00018\u0000X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000fR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Landroidx/lifecycle/ViewModelLazy;", "VM", "Landroidx/lifecycle/ViewModel;", "Lkotlin/Lazy;", "viewModelClass", "Lkotlin/reflect/KClass;", "storeProducer", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelStore;", "factoryProducer", "Landroidx/lifecycle/ViewModelProvider$Factory;", "extrasProducer", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "cached", "Landroidx/lifecycle/ViewModel;", "value", "getValue", "()Landroidx/lifecycle/ViewModel;", "isInitialized", "", "lifecycle-viewmodel_release"}, k=1, mv={1, 8, 0}, xi=48)
public final class ViewModelLazy<VM extends ViewModel>
implements Lazy<VM> {
    private VM cached;
    private final Function0<CreationExtras> extrasProducer;
    private final Function0<ViewModelProvider.Factory> factoryProducer;
    private final Function0<ViewModelStore> storeProducer;
    private final KClass<VM> viewModelClass;

    public ViewModelLazy(KClass<VM> kClass, Function0<? extends ViewModelStore> function0, Function0<? extends ViewModelProvider.Factory> function02) {
        Intrinsics.checkNotNullParameter(kClass, (String)"viewModelClass");
        Intrinsics.checkNotNullParameter(function0, (String)"storeProducer");
        Intrinsics.checkNotNullParameter(function02, (String)"factoryProducer");
        this(kClass, function0, function02, null, 8, null);
    }

    public ViewModelLazy(KClass<VM> kClass, Function0<? extends ViewModelStore> function0, Function0<? extends ViewModelProvider.Factory> function02, Function0<? extends CreationExtras> function03) {
        Intrinsics.checkNotNullParameter(kClass, (String)"viewModelClass");
        Intrinsics.checkNotNullParameter(function0, (String)"storeProducer");
        Intrinsics.checkNotNullParameter(function02, (String)"factoryProducer");
        Intrinsics.checkNotNullParameter(function03, (String)"extrasProducer");
        this.viewModelClass = kClass;
        this.storeProducer = function0;
        this.factoryProducer = function02;
        this.extrasProducer = function03;
    }

    public /* synthetic */ ViewModelLazy(KClass kClass, Function0 function0, Function0 function02, Function0 function03, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 8) != 0) {
            function03 = 1.INSTANCE;
        }
        this(kClass, (Function0<? extends ViewModelStore>)function0, (Function0<? extends ViewModelProvider.Factory>)function02, (Function0<? extends CreationExtras>)function03);
    }

    public VM getValue() {
        Object object;
        block0: {
            object = this.cached;
            if (object != null) break block0;
            object = (ViewModelProvider.Factory)this.factoryProducer.invoke();
            ViewModelStore viewModelStore = (ViewModelStore)this.storeProducer.invoke();
            this.cached = object = new ViewModelProvider(viewModelStore, (ViewModelProvider.Factory)object, (CreationExtras)this.extrasProducer.invoke()).get(JvmClassMappingKt.getJavaClass(this.viewModelClass));
        }
        return object;
    }

    public boolean isInitialized() {
        boolean bl = this.cached != null;
        return bl;
    }
}

