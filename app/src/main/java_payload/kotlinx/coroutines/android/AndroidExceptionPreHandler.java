/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  kotlin.Metadata
 *  kotlin.coroutines.AbstractCoroutineContextElement
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 */
package kotlinx.coroutines.android;

import android.os.Build;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lkotlinx/coroutines/android/AndroidExceptionPreHandler;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "()V", "_preHandler", "", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "preHandler", "Ljava/lang/reflect/Method;", "kotlinx-coroutines-android"}, k=1, mv={1, 8, 0}, xi=48)
public final class AndroidExceptionPreHandler
extends AbstractCoroutineContextElement
implements CoroutineExceptionHandler {
    private volatile Object _preHandler = this;

    public AndroidExceptionPreHandler() {
        super((CoroutineContext.Key)CoroutineExceptionHandler.Key);
    }

    private final Method preHandler() {
        Object object = this._preHandler;
        if (object != this) {
            return (Method)object;
        }
        object = null;
        boolean bl = false;
        Method method = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);
        boolean bl2 = bl;
        try {
            if (Modifier.isPublic(method.getModifiers())) {
                boolean bl3 = Modifier.isStatic(method.getModifiers());
                bl2 = bl;
                if (bl3) {
                    bl2 = true;
                }
            }
            if (bl2) {
                object = method;
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        this._preHandler = object;
        return object;
    }

    @Override
    public void handleException(CoroutineContext object, Throwable throwable) {
        int n = Build.VERSION.SDK_INT;
        n = 26 <= n && n < 28 ? 1 : 0;
        if (n != 0) {
            object = this.preHandler();
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = null;
            if ((object = object != null ? ((Method)object).invoke(null, new Object[0]) : null) instanceof Thread.UncaughtExceptionHandler) {
                uncaughtExceptionHandler = (Thread.UncaughtExceptionHandler)object;
            }
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), throwable);
            }
        }
    }
}

