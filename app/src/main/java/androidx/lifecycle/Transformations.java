/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Function
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.FunctionAdapter
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$BooleanRef
 */
package androidx.lifecycle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1={"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0007\u001aB\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u001c\u0010\u0005\u001a\u0018\u0012\t\u0012\u0007H\u0002\u00a2\u0006\u0002\b\u0007\u0012\t\u0012\u0007H\u0004\u00a2\u0006\u0002\b\u00070\u0006H\u0007\u001a8\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\tH\u0007\u001aJ\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00012$\u0010\u0005\u001a \u0012\t\u0012\u0007H\u0002\u00a2\u0006\u0002\b\u0007\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\u0001\u00a2\u0006\u0002\b\u00070\u0006H\u0007\u001a>\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00010\tH\u0007\u00a8\u0006\f"}, d2={"distinctUntilChanged", "Landroidx/lifecycle/LiveData;", "X", "map", "Y", "transform", "Lkotlin/Function1;", "Lkotlin/jvm/JvmSuppressWildcards;", "mapFunction", "Landroidx/arch/core/util/Function;", "switchMap", "switchMapFunction", "lifecycle-livedata_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class Transformations {
    public static final <X> LiveData<X> distinctUntilChanged(LiveData<X> liveData) {
        Intrinsics.checkNotNullParameter(liveData, (String)"<this>");
        MediatorLiveData<X> mediatorLiveData = new MediatorLiveData<X>();
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        if (liveData.isInitialized()) {
            mediatorLiveData.setValue(liveData.getValue());
            booleanRef.element = false;
        }
        mediatorLiveData.addSource(liveData, new Observer(new Function1<X, Unit>(mediatorLiveData, booleanRef){
            final Ref.BooleanRef $firstTime;
            final MediatorLiveData<X> $outputLiveData;
            {
                this.$outputLiveData = mediatorLiveData;
                this.$firstTime = booleanRef;
                super(1);
            }

            public final void invoke(X x) {
                T t = this.$outputLiveData.getValue();
                if (this.$firstTime.element || t == null && x != null || t != null && !Intrinsics.areEqual(t, x)) {
                    this.$firstTime.element = false;
                    this.$outputLiveData.setValue(x);
                }
            }
        }){
            private final Function1 function;
            {
                Intrinsics.checkNotNullParameter((Object)function1, (String)"function");
                this.function = function1;
            }

            public final boolean equals(Object object) {
                boolean bl;
                boolean bl2 = object instanceof Observer;
                boolean bl3 = bl = false;
                if (bl2) {
                    bl3 = bl;
                    if (object instanceof FunctionAdapter) {
                        bl3 = Intrinsics.areEqual(this.getFunctionDelegate(), (Object)((FunctionAdapter)object).getFunctionDelegate());
                    }
                }
                return bl3;
            }

            public final Function<?> getFunctionDelegate() {
                return (Function)this.function;
            }

            public final int hashCode() {
                return this.getFunctionDelegate().hashCode();
            }

            public final /* synthetic */ void onChanged(Object object) {
                this.function.invoke(object);
            }
        });
        return mediatorLiveData;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use kotlin functions, instead of outdated arch core Functions")
    public static final /* synthetic */ LiveData map(LiveData liveData, androidx.arch.core.util.Function function) {
        Intrinsics.checkNotNullParameter((Object)liveData, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)function, (String)"mapFunction");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new /* invalid duplicate definition of identical inner class */);
        return mediatorLiveData;
    }

    public static final <X, Y> LiveData<Y> map(LiveData<X> liveData, Function1<X, Y> function1) {
        Intrinsics.checkNotNullParameter(liveData, (String)"<this>");
        Intrinsics.checkNotNullParameter(function1, (String)"transform");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new /* invalid duplicate definition of identical inner class */);
        return mediatorLiveData;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use kotlin functions, instead of outdated arch core Functions")
    public static final /* synthetic */ LiveData switchMap(LiveData liveData, androidx.arch.core.util.Function function) {
        Intrinsics.checkNotNullParameter((Object)liveData, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)function, (String)"switchMapFunction");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>(function, mediatorLiveData){
            final MediatorLiveData<Y> $result;
            final androidx.arch.core.util.Function<X, LiveData<Y>> $switchMapFunction;
            private LiveData<Y> liveData;
            {
                this.$switchMapFunction = function;
                this.$result = mediatorLiveData;
            }

            public final LiveData<Y> getLiveData() {
                return this.liveData;
            }

            public void onChanged(X object) {
                LiveData<Y> liveData = this.$switchMapFunction.apply(object);
                if (this.liveData == liveData) {
                    return;
                }
                if (this.liveData != null) {
                    object = this.$result;
                    LiveData<Y> liveData2 = this.liveData;
                    Intrinsics.checkNotNull(liveData2);
                    ((MediatorLiveData)object).removeSource(liveData2);
                }
                this.liveData = liveData;
                if (this.liveData != null) {
                    object = this.$result;
                    liveData = this.liveData;
                    Intrinsics.checkNotNull(liveData);
                    ((MediatorLiveData)object).addSource(liveData, new /* invalid duplicate definition of identical inner class */);
                }
            }

            public final void setLiveData(LiveData<Y> liveData) {
                this.liveData = liveData;
            }
        });
        return mediatorLiveData;
    }

    public static final <X, Y> LiveData<Y> switchMap(LiveData<X> liveData, Function1<X, LiveData<Y>> function1) {
        Intrinsics.checkNotNullParameter(liveData, (String)"<this>");
        Intrinsics.checkNotNullParameter(function1, (String)"transform");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>(function1, mediatorLiveData){
            final MediatorLiveData<Y> $result;
            final Function1<X, LiveData<Y>> $transform;
            private LiveData<Y> liveData;
            {
                this.$transform = function1;
                this.$result = mediatorLiveData;
            }

            public final LiveData<Y> getLiveData() {
                return this.liveData;
            }

            public void onChanged(X object) {
                LiveData<Y> liveData = (LiveData<Y>)this.$transform.invoke(object);
                if (this.liveData == liveData) {
                    return;
                }
                if (this.liveData != null) {
                    MediatorLiveData<Y> mediatorLiveData = this.$result;
                    object = this.liveData;
                    Intrinsics.checkNotNull(object);
                    mediatorLiveData.removeSource(object);
                }
                this.liveData = liveData;
                if (this.liveData != null) {
                    object = this.$result;
                    liveData = this.liveData;
                    Intrinsics.checkNotNull(liveData);
                    ((MediatorLiveData)object).addSource(liveData, new /* invalid duplicate definition of identical inner class */);
                }
            }

            public final void setLiveData(LiveData<Y> liveData) {
                this.liveData = liveData;
            }
        });
        return mediatorLiveData;
    }
}

