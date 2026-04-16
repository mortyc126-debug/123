/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.Size
 *  android.util.SizeF
 *  android.util.SparseArray
 *  kotlin.Metadata
 *  kotlin.TuplesKt
 *  kotlin.collections.MapsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.core.os.BundleKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle$$ExternalSyntheticLambda0;
import androidx.savedstate.SavedStateRegistry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\t\u0018\u0000 *2\u00020\u0001:\u0002*+B\u001d\b\u0016\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u00a2\u0006\u0002\u0010\u0005B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J\u0011\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u0004H\u0087\u0002J\u001e\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0012\u001a\u00020\u0004H\u0087\u0002\u00a2\u0006\u0002\u0010\u0017J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0019\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J)\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0019\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u0002H\u0016H\u0007\u00a2\u0006\u0002\u0010\u001bJ1\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0019\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u0002H\u0016H\u0002\u00a2\u0006\u0002\u0010\u001eJ)\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00160 \"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u0002H\u0016H\u0007\u00a2\u0006\u0002\u0010!J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040#H\u0007J\u001d\u0010$\u001a\u0004\u0018\u0001H\u0016\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0012\u001a\u00020\u0004H\u0007\u00a2\u0006\u0002\u0010\u0017J\b\u0010\r\u001a\u00020\u000eH\u0007J&\u0010%\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0012\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u0001H\u0016H\u0087\u0002\u00a2\u0006\u0002\u0010'J\u0018\u0010(\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u000eH\u0007R\"\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2={"Landroidx/lifecycle/SavedStateHandle;", "", "initialState", "", "", "(Ljava/util/Map;)V", "()V", "flows", "", "Lkotlinx/coroutines/flow/MutableStateFlow;", "liveDatas", "Landroidx/lifecycle/SavedStateHandle$SavingStateLiveData;", "regular", "savedStateProvider", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "savedStateProviders", "clearSavedStateProvider", "", "key", "contains", "", "get", "T", "(Ljava/lang/String;)Ljava/lang/Object;", "getLiveData", "Landroidx/lifecycle/MutableLiveData;", "initialValue", "(Ljava/lang/String;Ljava/lang/Object;)Landroidx/lifecycle/MutableLiveData;", "getLiveDataInternal", "hasInitialValue", "(Ljava/lang/String;ZLjava/lang/Object;)Landroidx/lifecycle/MutableLiveData;", "getStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "(Ljava/lang/String;Ljava/lang/Object;)Lkotlinx/coroutines/flow/StateFlow;", "keys", "", "remove", "set", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "setSavedStateProvider", "provider", "Companion", "SavingStateLiveData", "lifecycle-viewmodel-savedstate_release"}, k=1, mv={1, 8, 0}, xi=48)
public final class SavedStateHandle {
    private static final Class<? extends Object>[] ACCEPTABLE_CLASSES;
    public static final Companion Companion;
    private static final String KEYS = "keys";
    private static final String VALUES = "values";
    private final Map<String, MutableStateFlow<Object>> flows;
    private final Map<String, SavingStateLiveData<?>> liveDatas;
    private final Map<String, Object> regular;
    private final SavedStateRegistry.SavedStateProvider savedStateProvider;
    private final Map<String, SavedStateRegistry.SavedStateProvider> savedStateProviders;

    public static /* synthetic */ Bundle $r8$lambda$aMir0GWwzPQviKVGE0DPm0kayew(SavedStateHandle savedStateHandle) {
        return SavedStateHandle.savedStateProvider$lambda$0(savedStateHandle);
    }

    static {
        Companion = new Companion(null);
        Class<Boolean> clazz = Boolean.TYPE;
        Class<Double> clazz2 = Double.TYPE;
        Class<Integer> clazz3 = Integer.TYPE;
        Class<Long> clazz4 = Long.TYPE;
        Class<Byte> clazz5 = Byte.TYPE;
        Class<Character> clazz6 = Character.TYPE;
        Class<Float> clazz7 = Float.TYPE;
        Class<Short> clazz8 = Short.TYPE;
        ACCEPTABLE_CLASSES = new Class[]{clazz, boolean[].class, clazz2, double[].class, clazz3, int[].class, clazz4, long[].class, String.class, String[].class, Binder.class, Bundle.class, clazz5, byte[].class, clazz6, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, clazz7, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, clazz8, short[].class, SparseArray.class, Size.class, SizeF.class};
    }

    public SavedStateHandle() {
        this.regular = new LinkedHashMap();
        this.savedStateProviders = new LinkedHashMap();
        this.liveDatas = new LinkedHashMap();
        this.flows = new LinkedHashMap();
        this.savedStateProvider = new SavedStateHandle$$ExternalSyntheticLambda0(this);
    }

    public SavedStateHandle(Map<String, ? extends Object> map2) {
        Intrinsics.checkNotNullParameter(map2, (String)"initialState");
        this.regular = new LinkedHashMap();
        this.savedStateProviders = new LinkedHashMap();
        this.liveDatas = new LinkedHashMap();
        this.flows = new LinkedHashMap();
        this.savedStateProvider = new SavedStateHandle$$ExternalSyntheticLambda0(this);
        this.regular.putAll(map2);
    }

    @JvmStatic
    public static final SavedStateHandle createHandle(Bundle bundle, Bundle bundle2) {
        return Companion.createHandle(bundle, bundle2);
    }

    private final <T> MutableLiveData<T> getLiveDataInternal(String string2, boolean bl, T object) {
        MutableLiveData mutableLiveData = this.liveDatas.get(string2);
        mutableLiveData = mutableLiveData instanceof MutableLiveData ? (MutableLiveData)mutableLiveData : null;
        if (mutableLiveData != null) {
            return mutableLiveData;
        }
        if (this.regular.containsKey(string2)) {
            object = new SavingStateLiveData<Object>(this, string2, this.regular.get(string2));
        } else if (bl) {
            this.regular.put(string2, object);
            object = new SavingStateLiveData<T>(this, string2, object);
        } else {
            object = new SavingStateLiveData(this, string2);
        }
        this.liveDatas.put(string2, (SavingStateLiveData<?>)object);
        return (MutableLiveData)object;
    }

    private static final Bundle savedStateProvider$lambda$0(SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter((Object)savedStateHandle, (String)"this$0");
        for (Map.Entry object2 : MapsKt.toMap(savedStateHandle.savedStateProviders).entrySet()) {
            savedStateHandle.set((String)object2.getKey(), ((SavedStateRegistry.SavedStateProvider)object2.getValue()).saveState());
        }
        Object object = savedStateHandle.regular.keySet();
        ArrayList<String> arrayList = new ArrayList<String>(object.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        object = object.iterator();
        while (object.hasNext()) {
            String string2 = (String)object.next();
            arrayList.add(string2);
            arrayList2.add(savedStateHandle.regular.get(string2));
        }
        return BundleKt.bundleOf(TuplesKt.to((Object)KEYS, arrayList), TuplesKt.to((Object)VALUES, (Object)arrayList2));
    }

    public final void clearSavedStateProvider(String string2) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"key");
        this.savedStateProviders.remove(string2);
    }

    public final boolean contains(String string2) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"key");
        return this.regular.containsKey(string2);
    }

    public final <T> T get(String object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"key");
        try {
            Object object2;
            object = object2 = this.regular.get(object);
        }
        catch (ClassCastException classCastException) {
            this.remove((String)object);
            object = null;
        }
        return (T)object;
    }

    public final <T> MutableLiveData<T> getLiveData(String object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"key");
        object = this.getLiveDataInternal((String)object, false, null);
        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<T of androidx.lifecycle.SavedStateHandle.getLiveData>");
        return object;
    }

    public final <T> MutableLiveData<T> getLiveData(String string2, T t) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"key");
        return this.getLiveDataInternal(string2, true, t);
    }

    public final <T> StateFlow<T> getStateFlow(String object, T object2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"key");
        Map<String, MutableStateFlow<Object>> map2 = this.flows;
        MutableStateFlow<Object> mutableStateFlow = map2.get(object);
        if (mutableStateFlow == null) {
            if (!this.regular.containsKey(object)) {
                this.regular.put((String)object, object2);
            }
            object2 = StateFlowKt.MutableStateFlow(this.regular.get(object));
            this.flows.put((String)object, (MutableStateFlow<Object>)object2);
            map2.put((String)object, (MutableStateFlow<Object>)object2);
        } else {
            object2 = mutableStateFlow;
        }
        object = FlowKt.asStateFlow((MutableStateFlow)object2);
        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlinx.coroutines.flow.StateFlow<T of androidx.lifecycle.SavedStateHandle.getStateFlow>");
        return object;
    }

    public final Set<String> keys() {
        return SetsKt.plus((Set)SetsKt.plus(this.regular.keySet(), (Iterable)this.savedStateProviders.keySet()), (Iterable)this.liveDatas.keySet());
    }

    public final <T> T remove(String string2) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"key");
        Object object = this.regular.remove(string2);
        SavingStateLiveData<?> savingStateLiveData = this.liveDatas.remove(string2);
        if (savingStateLiveData != null) {
            savingStateLiveData.detach();
        }
        this.flows.remove(string2);
        return (T)object;
    }

    public final SavedStateRegistry.SavedStateProvider savedStateProvider() {
        return this.savedStateProvider;
    }

    public final <T> void set(String object, T t) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"key");
        if (Companion.validateValue(t)) {
            MutableLiveData mutableLiveData = this.liveDatas.get(object);
            mutableLiveData = mutableLiveData instanceof MutableLiveData ? (MutableLiveData)mutableLiveData : null;
            if (mutableLiveData != null) {
                mutableLiveData.setValue(t);
            } else {
                this.regular.put((String)object, t);
            }
            object = this.flows.get(object);
            if (object != null) {
                object.setValue(t);
            }
            return;
        }
        object = new StringBuilder().append("Can't put value with type ");
        Intrinsics.checkNotNull(t);
        throw new IllegalArgumentException(((StringBuilder)object).append(t.getClass()).append(" into saved state").toString());
    }

    public final void setSavedStateProvider(String string2, SavedStateRegistry.SavedStateProvider savedStateProvider) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"key");
        Intrinsics.checkNotNullParameter((Object)savedStateProvider, (String)"provider");
        this.savedStateProviders.put(string2, savedStateProvider);
    }

    @Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0007R \u0010\u0003\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\u00050\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Landroidx/lifecycle/SavedStateHandle$Companion;", "", "()V", "ACCEPTABLE_CLASSES", "", "Ljava/lang/Class;", "[Ljava/lang/Class;", "KEYS", "", "VALUES", "createHandle", "Landroidx/lifecycle/SavedStateHandle;", "restoredState", "Landroid/os/Bundle;", "defaultState", "validateValue", "", "value", "lifecycle-viewmodel-savedstate_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final SavedStateHandle createHandle(Bundle object, Bundle object2) {
            if (object == null) {
                if (object2 == null) {
                    object = new SavedStateHandle();
                } else {
                    object = new HashMap();
                    for (String string2 : object2.keySet()) {
                        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"key");
                        object.put(string2, object2.get(string2));
                    }
                    object = new SavedStateHandle((Map<String, ? extends Object>)object);
                }
                return object;
            }
            object2 = object.getParcelableArrayList(SavedStateHandle.KEYS);
            ArrayList arrayList = object.getParcelableArrayList(SavedStateHandle.VALUES);
            int n = object2 != null && arrayList != null && ((ArrayList)object2).size() == arrayList.size() ? 1 : 0;
            if (n != 0) {
                Map map2 = new LinkedHashMap();
                int n2 = ((ArrayList)object2).size();
                for (n = 0; n < n2; ++n) {
                    object = ((ArrayList)object2).get(n);
                    Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                    map2.put((String)object, arrayList.get(n));
                }
                return new SavedStateHandle(map2);
            }
            throw new IllegalStateException("Invalid bundle passed as restored state".toString());
        }

        public final boolean validateValue(Object object) {
            if (object == null) {
                return true;
            }
            for (Class clazz : ACCEPTABLE_CLASSES) {
                Intrinsics.checkNotNull((Object)clazz);
                if (!clazz.isInstance(object)) continue;
                return true;
            }
            return false;
        }
    }

    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B!\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\bB\u0019\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\u000bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\rR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Landroidx/lifecycle/SavedStateHandle$SavingStateLiveData;", "T", "Landroidx/lifecycle/MutableLiveData;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "key", "", "value", "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;Ljava/lang/Object;)V", "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;)V", "detach", "", "setValue", "(Ljava/lang/Object;)V", "lifecycle-viewmodel-savedstate_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class SavingStateLiveData<T>
    extends MutableLiveData<T> {
        private SavedStateHandle handle;
        private String key;

        public SavingStateLiveData(SavedStateHandle savedStateHandle, String string2) {
            Intrinsics.checkNotNullParameter((Object)string2, (String)"key");
            this.key = string2;
            this.handle = savedStateHandle;
        }

        public SavingStateLiveData(SavedStateHandle savedStateHandle, String string2, T t) {
            Intrinsics.checkNotNullParameter((Object)string2, (String)"key");
            super(t);
            this.key = string2;
            this.handle = savedStateHandle;
        }

        public final void detach() {
            this.handle = null;
        }

        @Override
        public void setValue(T t) {
            Object object = this.handle;
            if (object != null) {
                ((SavedStateHandle)object).regular.put(this.key, t);
                object = (MutableStateFlow)((SavedStateHandle)object).flows.get(this.key);
                if (object != null) {
                    object.setValue(t);
                }
            }
            super.setValue(t);
        }
    }
}

