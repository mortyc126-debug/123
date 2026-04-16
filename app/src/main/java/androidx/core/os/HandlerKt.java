/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 */
package androidx.core.os;

import android.os.Handler;
import androidx.core.os.HandlerCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a1\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\b\u001a1\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\b\u00a8\u0006\f"}, d2={"postAtTime", "Ljava/lang/Runnable;", "Landroid/os/Handler;", "uptimeMillis", "", "token", "", "action", "Lkotlin/Function0;", "", "postDelayed", "delayInMillis", "core-ktx_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class HandlerKt {
    public static final Runnable postAtTime(Handler handler, long l, Object object, Function0<Unit> object2) {
        object2 = new Runnable((Function0<Unit>)object2){
            final Function0<Unit> $action;
            {
                this.$action = function0;
            }

            public final void run() {
                this.$action.invoke();
            }
        };
        handler.postAtTime(object2, object, l);
        return object2;
    }

    public static /* synthetic */ Runnable postAtTime$default(Handler handler, long l, Object object, Function0 object2, int n, Object object3) {
        if ((n & 2) != 0) {
            object = null;
        }
        object2 = new /* invalid duplicate definition of identical inner class */;
        handler.postAtTime((Runnable)object2, object, l);
        return object2;
    }

    public static final Runnable postDelayed(Handler handler, long l, Object object, Function0<Unit> object2) {
        object2 = new Runnable((Function0<Unit>)object2){
            final Function0<Unit> $action;
            {
                this.$action = function0;
            }

            public final void run() {
                this.$action.invoke();
            }
        };
        if (object == null) {
            handler.postDelayed(object2, l);
        } else {
            HandlerCompat.postDelayed(handler, object2, object, l);
        }
        return object2;
    }

    public static /* synthetic */ Runnable postDelayed$default(Handler handler, long l, Object object, Function0 object2, int n, Object object3) {
        if ((n & 2) != 0) {
            object = null;
        }
        object2 = new /* invalid duplicate definition of identical inner class */;
        if (object == null) {
            handler.postDelayed((Runnable)object2, l);
        } else {
            HandlerCompat.postDelayed(handler, (Runnable)object2, object, l);
        }
        return object2;
    }
}

