/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.KotlinNothingValueException
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function1
 */
package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u00002#\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007B\r\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0006\u0010\u0012\u001a\u00020\u0006J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0013\u0010\u0017\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0006\u0010\u0018\u001a\u00020\u0006R\t\u0010\u000b\u001a\u00020\fX\u0082\u0004R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2={"Lkotlinx/coroutines/ThreadState;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "job", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "_state", "Lkotlinx/atomicfu/AtomicInt;", "cancelHandle", "Lkotlinx/coroutines/DisposableHandle;", "targetThread", "Ljava/lang/Thread;", "kotlin.jvm.PlatformType", "clearInterrupt", "invalidState", "", "state", "", "invoke", "setup", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
final class ThreadState
implements Function1<Throwable, Unit> {
    private static final AtomicIntegerFieldUpdater _state$FU = AtomicIntegerFieldUpdater.newUpdater(ThreadState.class, "_state");
    @Volatile
    private volatile int _state;
    private DisposableHandle cancelHandle;
    private final Job job;
    private final Thread targetThread;

    public ThreadState(Job job2) {
        this.job = job2;
        this.targetThread = Thread.currentThread();
    }

    private final Void invalidState(int n) {
        throw new IllegalStateException(("Illegal state " + n).toString());
    }

    private final void loop$atomicfu(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Function1<? super Integer, Unit> function1, Object object) {
        while (true) {
            function1.invoke((Object)atomicIntegerFieldUpdater.get(object));
        }
    }

    public final void clearInterrupt() {
        Object object = _state$FU;
        block5: while (true) {
            int n = ((AtomicIntegerFieldUpdater)object).get(this);
            switch (n) {
                default: {
                    this.invalidState(n);
                    throw new KotlinNothingValueException();
                }
                case 3: {
                    Thread.interrupted();
                    return;
                }
                case 2: {
                    continue block5;
                }
                case 0: 
            }
            if (_state$FU.compareAndSet(this, n, 1)) break;
        }
        object = this.cancelHandle;
        if (object != null) {
            object.dispose();
        }
    }

    public void invoke(Throwable object) {
        int n;
        object = _state$FU;
        do {
            n = ((AtomicIntegerFieldUpdater)object).get(this);
            switch (n) {
                default: {
                    this.invalidState(n);
                    throw new KotlinNothingValueException();
                }
                case 1: 
                case 2: 
                case 3: {
                    return;
                }
                case 0: 
            }
        } while (!_state$FU.compareAndSet(this, n, 2));
        this.targetThread.interrupt();
        _state$FU.set(this, 3);
    }

    public final void setup() {
        int n;
        this.cancelHandle = this.job.invokeOnCompletion(true, true, (Function1<? super Throwable, Unit>)((Function1)this));
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _state$FU;
        do {
            n = atomicIntegerFieldUpdater.get(this);
            switch (n) {
                default: {
                    this.invalidState(n);
                    throw new KotlinNothingValueException();
                }
                case 2: 
                case 3: {
                    return;
                }
                case 0: 
            }
        } while (!_state$FU.compareAndSet(this, n, 0));
    }
}

