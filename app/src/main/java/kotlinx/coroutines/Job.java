/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Element
 *  kotlin.coroutines.CoroutineContext$Element$DefaultImpls
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.sequences.Sequence
 */
package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.ChildJob;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.selects.SelectClause0;

@Metadata(d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 -2\u00020\u0001:\u0001-J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H'J\b\u0010\u0018\u001a\u00020\u0019H\u0017J\u0014\u0010\u0018\u001a\u00020\u00072\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH'J\u001a\u0010\u0018\u001a\u00020\u00192\u0010\b\u0002\u0010\u001a\u001a\n\u0018\u00010\u001cj\u0004\u0018\u0001`\u001dH&J\f\u0010\u001e\u001a\u00060\u001cj\u0002`\u001dH'JE\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00072\b\b\u0002\u0010\"\u001a\u00020\u00072'\u0010#\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u001b\u00a2\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00190$j\u0002`'H'J1\u0010\u001f\u001a\u00020 2'\u0010#\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u001b\u00a2\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00190$j\u0002`'H&J\u0011\u0010(\u001a\u00020\u0019H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010)J\u0011\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u0000H\u0097\u0002J\b\u0010,\u001a\u00020\u0007H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0012\u0010\t\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\bR\u0012\u0010\n\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0012\u0010\u000b\u001a\u00020\fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00008&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006."}, d2={"Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/CoroutineContext$Element;", "children", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "isActive", "", "()Z", "isCancelled", "isCompleted", "onJoin", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "parent", "getParent$annotations", "()V", "getParent", "()Lkotlinx/coroutines/Job;", "attachChild", "Lkotlinx/coroutines/ChildHandle;", "child", "Lkotlinx/coroutines/ChildJob;", "cancel", "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "getCancellationException", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plus", "other", "start", "Key", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public interface Job
extends CoroutineContext.Element {
    public static final Key Key = kotlinx.coroutines.Job$Key.$$INSTANCE;

    public ChildHandle attachChild(ChildJob var1);

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel();

    public void cancel(CancellationException var1);

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean cancel(Throwable var1);

    public CancellationException getCancellationException();

    public Sequence<Job> getChildren();

    public SelectClause0 getOnJoin();

    public Job getParent();

    public DisposableHandle invokeOnCompletion(Function1<? super Throwable, Unit> var1);

    public DisposableHandle invokeOnCompletion(boolean var1, boolean var2, Function1<? super Throwable, Unit> var3);

    public boolean isActive();

    public boolean isCancelled();

    public boolean isCompleted();

    public Object join(Continuation<? super Unit> var1);

    @Deprecated(level=DeprecationLevel.ERROR, message="Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    public Job plus(Job var1);

    public boolean start();

    @Metadata(k=3, mv={1, 8, 0}, xi=48)
    public static final class DefaultImpls {
        @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x")
        public static /* synthetic */ void cancel(Job job2) {
            job2.cancel(null);
        }

        public static /* synthetic */ void cancel$default(Job job2, CancellationException cancellationException, int n, Object object) {
            if (object == null) {
                if ((n & 1) != 0) {
                    cancellationException = null;
                }
                job2.cancel(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static /* synthetic */ boolean cancel$default(Job job2, Throwable throwable, int n, Object object) {
            if (object == null) {
                if ((n & 1) != 0) {
                    throwable = null;
                }
                return job2.cancel(throwable);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static <R> R fold(Job job2, R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return (R)CoroutineContext.Element.DefaultImpls.fold((CoroutineContext.Element)job2, r, function2);
        }

        public static <E extends CoroutineContext.Element> E get(Job job2, CoroutineContext.Key<E> key) {
            return (E)CoroutineContext.Element.DefaultImpls.get((CoroutineContext.Element)job2, key);
        }

        public static /* synthetic */ void getParent$annotations() {
        }

        public static /* synthetic */ DisposableHandle invokeOnCompletion$default(Job job2, boolean bl, boolean bl2, Function1 function1, int n, Object object) {
            if (object == null) {
                if ((n & 1) != 0) {
                    bl = false;
                }
                if ((n & 2) != 0) {
                    bl2 = true;
                }
                return job2.invokeOnCompletion(bl, bl2, (Function1<? super Throwable, Unit>)function1);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }

        public static CoroutineContext minusKey(Job job2, CoroutineContext.Key<?> key) {
            return CoroutineContext.Element.DefaultImpls.minusKey((CoroutineContext.Element)job2, key);
        }

        public static CoroutineContext plus(Job job2, CoroutineContext coroutineContext) {
            return CoroutineContext.Element.DefaultImpls.plus((CoroutineContext.Element)job2, (CoroutineContext)coroutineContext);
        }

        @Deprecated(level=DeprecationLevel.ERROR, message="Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        public static Job plus(Job job2, Job job3) {
            return job3;
        }
    }

    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lkotlinx/coroutines/Job$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/Job;", "()V", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class Key
    implements CoroutineContext.Key<Job> {
        static final Key $$INSTANCE = new Key();

        private Key() {
        }
    }
}

