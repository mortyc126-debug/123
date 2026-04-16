/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 */
package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.internal.FastServiceLoader;
import kotlinx.coroutines.internal.MainDispatcherFactory;
import kotlinx.coroutines.internal.MainDispatchersKt;
import kotlinx.coroutines.internal.SystemPropsKt;

@Metadata(d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2={"Lkotlinx/coroutines/internal/MainDispatcherLoader;", "", "()V", "FAST_SERVICE_LOADER_ENABLED", "", "dispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "loadMainDispatcher", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public final class MainDispatcherLoader {
    private static final boolean FAST_SERVICE_LOADER_ENABLED;
    public static final MainDispatcherLoader INSTANCE;
    public static final MainCoroutineDispatcher dispatcher;

    static {
        INSTANCE = new MainDispatcherLoader();
        FAST_SERVICE_LOADER_ENABLED = SystemPropsKt.systemProp("kotlinx.coroutines.fast.service.loader", true);
        dispatcher = INSTANCE.loadMainDispatcher();
    }

    private MainDispatcherLoader() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final MainCoroutineDispatcher loadMainDispatcher() {
        try {
            Object object;
            Object object2 = FAST_SERVICE_LOADER_ENABLED ? FastServiceLoader.INSTANCE.loadMainDispatcherFactory$kotlinx_coroutines_core() : SequencesKt.toList((Sequence)SequencesKt.asSequence(ServiceLoader.load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader()).iterator()));
            Iterator iterator2 = ((Iterable)object2).iterator();
            if (!iterator2.hasNext()) {
                object = null;
            } else {
                object = iterator2.next();
                if (iterator2.hasNext()) {
                    int n = ((MainDispatcherFactory)object).getLoadPriority();
                    Object object3 = object;
                    do {
                        Object t = iterator2.next();
                        int n2 = ((MainDispatcherFactory)t).getLoadPriority();
                        object = object3;
                        int n3 = n;
                        if (n < n2) {
                            object = t;
                            n3 = n2;
                        }
                        object3 = object;
                        n = n3;
                    } while (iterator2.hasNext());
                }
            }
            object = (MainDispatcherFactory)object;
            if (object == null) return MainDispatchersKt.createMissingDispatcher$default(null, null, 3, null);
            object2 = MainDispatchersKt.tryCreateDispatcher((MainDispatcherFactory)object, object2);
            object = object2;
            if (object2 != null) return object;
            return MainDispatchersKt.createMissingDispatcher$default(null, null, 3, null);
        }
        catch (Throwable throwable) {
            return MainDispatchersKt.createMissingDispatcher$default(throwable, null, 2, null);
        }
    }
}

