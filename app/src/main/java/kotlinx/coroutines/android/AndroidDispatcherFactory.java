/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  kotlin.Metadata
 */
package kotlinx.coroutines.android;

import android.os.Looper;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.android.HandlerDispatcherKt;
import kotlinx.coroutines.internal.MainDispatcherFactory;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\r"}, d2={"Lkotlinx/coroutines/android/AndroidDispatcherFactory;", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "()V", "loadPriority", "", "getLoadPriority", "()I", "createDispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "allFactories", "", "hintOnError", "", "kotlinx-coroutines-android"}, k=1, mv={1, 8, 0}, xi=48)
public final class AndroidDispatcherFactory
implements MainDispatcherFactory {
    @Override
    public MainCoroutineDispatcher createDispatcher(List<? extends MainDispatcherFactory> looper) {
        looper = Looper.getMainLooper();
        if (looper != null) {
            return new HandlerContext(HandlerDispatcherKt.asHandler(looper, true), null, 2, null);
        }
        throw new IllegalStateException("The main looper is not available");
    }

    @Override
    public int getLoadPriority() {
        return 0x3FFFFFFF;
    }

    @Override
    public String hintOnError() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }
}

