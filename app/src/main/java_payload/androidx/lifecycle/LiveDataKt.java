/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.lifecycle;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a@\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0004\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\b0\u0007H\u0087\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\t"}, d2={"observe", "Landroidx/lifecycle/Observer;", "T", "Landroidx/lifecycle/LiveData;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onChanged", "Lkotlin/Function1;", "", "lifecycle-livedata-core-ktx_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class LiveDataKt {
    @Deprecated(message="This extension method is not required when using Kotlin 1.4. You should remove \"import androidx.lifecycle.observe\"")
    public static final <T> Observer<T> observe(LiveData<T> liveData, LifecycleOwner lifecycleOwner, Function1<? super T, Unit> object) {
        Intrinsics.checkNotNullParameter(liveData, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)lifecycleOwner, (String)"owner");
        Intrinsics.checkNotNullParameter(object, (String)"onChanged");
        object = new Observer(object){
            final Function1<T, Unit> $onChanged;
            {
                this.$onChanged = function1;
            }

            public final void onChanged(T t) {
                this.$onChanged.invoke(t);
            }
        };
        liveData.observe(lifecycleOwner, (Observer<T>)object);
        return object;
    }
}

