/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.channels;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.BroadcastChannelImpl;
import kotlinx.coroutines.channels.BroadcastChannelKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.BufferedChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.channels.ConflatedBufferedChannel;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.TrySelectDetailedResult;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u000245B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0017\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010!H\u0010\u00a2\u0006\u0002\b\"J\u0012\u0010#\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016J\u001e\u0010&\u001a\u00020'2\n\u0010(\u001a\u0006\u0012\u0002\b\u00030\u00132\b\u0010)\u001a\u0004\u0018\u00010\rH\u0014J\u0016\u0010*\u001a\u00020'2\f\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0002J\u0019\u0010,\u001a\u00020'2\u0006\u0010)\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010-J\b\u0010.\u001a\u00020/H\u0016J&\u00100\u001a\b\u0012\u0004\u0012\u00020'012\u0006\u0010)\u001a\u00028\u0000H\u0016\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b2\u00103R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R6\u0010\u0011\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0013\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0012j\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0013\u0012\u0006\u0012\u0004\u0018\u00010\r`\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\u00028\u00008F\u00a2\u0006\f\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001c\u001a\u0004\u0018\u00018\u00008F\u00a2\u0006\f\u0012\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001b\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u00066"}, d2={"Lkotlinx/coroutines/channels/BroadcastChannelImpl;", "E", "Lkotlinx/coroutines/channels/BufferedChannel;", "Lkotlinx/coroutines/channels/BroadcastChannel;", "capacity", "", "(I)V", "getCapacity", "()I", "isClosedForSend", "", "()Z", "lastConflatedElement", "", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "onSendInternalResult", "Ljava/util/HashMap;", "Lkotlinx/coroutines/selects/SelectInstance;", "Lkotlin/collections/HashMap;", "subscribers", "", "value", "getValue$annotations", "()V", "getValue", "()Ljava/lang/Object;", "valueOrNull", "getValueOrNull$annotations", "getValueOrNull", "cancelImpl", "cause", "", "cancelImpl$kotlinx_coroutines_core", "close", "openSubscription", "Lkotlinx/coroutines/channels/ReceiveChannel;", "registerSelectForSend", "", "select", "element", "removeSubscriber", "s", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toString", "", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "SubscriberBuffered", "SubscriberConflated", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
public final class BroadcastChannelImpl<E>
extends BufferedChannel<E>
implements BroadcastChannel<E> {
    private final int capacity;
    private Object lastConflatedElement;
    private final ReentrantLock lock;
    private final HashMap<SelectInstance<?>, Object> onSendInternalResult;
    private List<? extends BufferedChannel<E>> subscribers;

    public BroadcastChannelImpl(int n) {
        block5: {
            block4: {
                int n2 = 0;
                super(0, null);
                this.capacity = n;
                if (this.capacity >= 1) break block4;
                n = n2;
                if (this.capacity != -1) break block5;
            }
            n = 1;
        }
        if (n != 0) {
            this.lock = new ReentrantLock();
            this.subscribers = CollectionsKt.emptyList();
            this.lastConflatedElement = BroadcastChannelKt.access$getNO_ELEMENT$p();
            this.onSendInternalResult = new HashMap();
            return;
        }
        throw new IllegalArgumentException(("BroadcastChannel capacity must be positive or Channel.CONFLATED, but " + this.capacity + " was specified").toString());
    }

    public static final /* synthetic */ HashMap access$getOnSendInternalResult$p(BroadcastChannelImpl broadcastChannelImpl) {
        return broadcastChannelImpl.onSendInternalResult;
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    public static /* synthetic */ void getValueOrNull$annotations() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void removeSubscriber(ReceiveChannel<? extends E> object) {
        Lock lock = this.lock;
        lock.lock();
        try {
            Iterable iterable2 = this.subscribers;
            Collection<Iterable> collection = new Collection<Iterable>();
            collection = collection;
            for (Iterable iterable2 : iterable2) {
                boolean bl = (BufferedChannel)((Object)iterable2) != object;
                if (!bl) continue;
                collection.add(iterable2);
            }
            this.subscribers = object = (List)collection;
            object = Unit.INSTANCE;
            return;
        }
        finally {
            lock.unlock();
        }
    }

    @Override
    public boolean cancelImpl$kotlinx_coroutines_core(Throwable throwable) {
        Lock lock = this.lock;
        lock.lock();
        try {
            Iterator iterator2 = ((Iterable)this.subscribers).iterator();
            while (iterator2.hasNext()) {
                ((BufferedChannel)iterator2.next()).cancelImpl$kotlinx_coroutines_core(throwable);
            }
            this.lastConflatedElement = BroadcastChannelKt.access$getNO_ELEMENT$p();
            boolean bl = super.cancelImpl$kotlinx_coroutines_core(throwable);
            return bl;
        }
        finally {
            lock.unlock();
        }
    }

    @Override
    public boolean close(Throwable throwable) {
        Lock lock = this.lock;
        lock.lock();
        try {
            Collection<Iterable> collection = ((Iterable)this.subscribers).iterator();
            while (collection.hasNext()) {
                ((BufferedChannel)collection.next()).close(throwable);
            }
            Iterable iterable2 = this.subscribers;
            collection = new Collection<Iterable>();
            collection = collection;
            for (Iterable iterable2 : iterable2) {
                if (!((BufferedChannel)((Object)iterable2)).hasElements$kotlinx_coroutines_core()) continue;
                collection.add(iterable2);
            }
            collection = (List)collection;
            this.subscribers = collection;
            boolean bl = super.close(throwable);
            return bl;
        }
        finally {
            lock.unlock();
        }
    }

    public final int getCapacity() {
        return this.capacity;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final E getValue() {
        Lock lock = this.lock;
        lock.lock();
        try {
            if (this.isClosedForSend()) {
                Throwable throwable;
                Throwable throwable2 = throwable = this.getCloseCause();
                if (throwable != null) throw throwable2;
                throwable2 = new IllegalStateException("This broadcast channel is closed");
                throw throwable2;
            }
            if (this.lastConflatedElement != BroadcastChannelKt.access$getNO_ELEMENT$p()) {
                Object object = this.lastConflatedElement;
                return (E)object;
            }
            IllegalStateException illegalStateException = new IllegalStateException("No value".toString());
            throw illegalStateException;
        }
        finally {
            lock.unlock();
        }
    }

    public final E getValueOrNull() {
        Object object;
        Lock lock;
        block6: {
            block5: {
                lock = this.lock;
                lock.lock();
                boolean bl = this.isClosedForReceive();
                object = null;
                if (!bl) break block5;
            }
            if (this.lastConflatedElement == BroadcastChannelKt.access$getNO_ELEMENT$p()) {
                break block6;
            }
            object = this.lastConflatedElement;
        }
        return (E)object;
        finally {
            lock.unlock();
        }
    }

    @Override
    public boolean isClosedForSend() {
        Lock lock = this.lock;
        lock.lock();
        try {
            boolean bl = super.isClosedForSend();
            return bl;
        }
        finally {
            lock.unlock();
        }
    }

    @Override
    public ReceiveChannel<E> openSubscription() {
        Lock lock = this.lock;
        lock.lock();
        try {
            ReceiveChannel receiveChannel = this.capacity == -1 ? new SubscriberConflated(this) : new SubscriberBuffered(this);
            receiveChannel = receiveChannel;
            if (this.isClosedForSend() && this.lastConflatedElement == BroadcastChannelKt.access$getNO_ELEMENT$p()) {
                receiveChannel.close(this.getCloseCause());
                receiveChannel = receiveChannel;
                return receiveChannel;
            }
            if (this.lastConflatedElement != BroadcastChannelKt.access$getNO_ELEMENT$p()) {
                ((BufferedChannel)receiveChannel).trySend-JP2dKIU(this.getValue());
            }
            this.subscribers = CollectionsKt.plus((Collection)this.subscribers, (Object)receiveChannel);
            return receiveChannel;
        }
        finally {
            lock.unlock();
        }
    }

    @Override
    protected void registerSelectForSend(SelectInstance<?> selectInstance, Object object) {
        Lock lock = this.lock;
        lock.lock();
        Object object2 = this.onSendInternalResult.remove(selectInstance);
        if (object2 != null) {
            selectInstance.selectInRegistrationPhase(object2);
            return;
        }
        object2 = Unit.INSTANCE;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(selectInstance.getContext()), null, CoroutineStart.UNDISPATCHED, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, object, selectInstance, null){
            final Object $element;
            final SelectInstance<?> $select;
            int label;
            final BroadcastChannelImpl<E> this$0;
            {
                this.this$0 = broadcastChannelImpl;
                this.$element = object;
                this.$select = selectInstance;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> continuation) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /*
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public final Object invokeSuspend(Object object) {
                SelectInstance<?> selectInstance;
                BroadcastChannelImpl<SelectInstance<?>> broadcastChannelImpl;
                boolean bl;
                int n;
                Object object2;
                block17: {
                    block16: {
                        object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        n = this.label;
                        bl = false;
                        switch (n) {
                            default: {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            case 1: {
                                try {
                                    ResultKt.throwOnFailure((Object)object);
                                    break;
                                }
                                catch (Throwable throwable) {
                                    break block16;
                                }
                            }
                            case 0: {
                                ResultKt.throwOnFailure((Object)object);
                                broadcastChannelImpl = this.this$0;
                                selectInstance = this.$element;
                                object = (Continuation)this;
                                this.label = 1;
                                object = broadcastChannelImpl.send(selectInstance, (Continuation<Unit>)object);
                                if (object != object2) break;
                                return object2;
                            }
                        }
                        n = 1;
                        break block17;
                        catch (Throwable throwable) {
                            // empty catch block
                        }
                    }
                    if (!this.this$0.isClosedForSend()) throw object;
                    if (!(object instanceof ClosedSendChannelException)) {
                        if (this.this$0.getSendException() != object) throw object;
                    }
                    n = 0;
                }
                object = BroadcastChannelImpl.access$getLock$p(this.this$0);
                broadcastChannelImpl = this.this$0;
                selectInstance = this.$select;
                object2 = (Lock)object;
                object2.lock();
                try {
                    if (DebugKt.getASSERTIONS_ENABLED()) {
                        if (BroadcastChannelImpl.access$getOnSendInternalResult$p(broadcastChannelImpl).get(selectInstance) == null) {
                            bl = true;
                        }
                        if (!bl) {
                            object = new AssertionError();
                            throw object;
                        }
                    }
                    Map map2 = BroadcastChannelImpl.access$getOnSendInternalResult$p(broadcastChannelImpl);
                    object = n != 0 ? Unit.INSTANCE : BufferedChannelKt.getCHANNEL_CLOSED();
                    map2.put(selectInstance, object);
                    Intrinsics.checkNotNull(selectInstance, (String)"null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
                    object = (SelectImplementation)selectInstance;
                    if (((SelectImplementation)selectInstance).trySelectDetailed(broadcastChannelImpl, Unit.INSTANCE) != TrySelectDetailedResult.REREGISTER) {
                        BroadcastChannelImpl.access$getOnSendInternalResult$p(broadcastChannelImpl).remove(selectInstance);
                    }
                    object = Unit.INSTANCE;
                    return Unit.INSTANCE;
                }
                finally {
                    object2.unlock();
                }
            }
        }, 1, null);
        return;
        finally {
            lock.unlock();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public Object send(E var1_1, Continuation<? super Unit> var2_3) {
        if (!(var2_3 instanceof send.1)) ** GOTO lbl-1000
        var3_4 = var2_3;
        if ((var3_4.label & -2147483648) != 0) {
            var3_4.label += -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            var3_4 = new ContinuationImpl(this, (Continuation<? super send.1>)var2_3){
                Object L$0;
                Object L$1;
                Object L$2;
                int label;
                Object result;
                final BroadcastChannelImpl<E> this$0;
                {
                    this.this$0 = broadcastChannelImpl;
                    super(continuation);
                }

                public final Object invokeSuspend(Object object) {
                    this.result = object;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.send(null, (Continuation<Unit>)((Continuation)this));
                }
            };
        }
        var2_3 = var3_4.result;
        var6_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (var3_4.label) {
            default: {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            case 1: {
                var5_6 = (Iterator)var3_4.L$2;
                var9_7 = var3_4.L$1;
                var7_8 = (BroadcastChannelImpl)var3_4.L$0;
                ResultKt.throwOnFailure((Object)var2_3);
                var1_1 /* !! */  = var6_5;
                var4_9 = var2_3;
                var8_10 = var2_3;
                var2_3 = var4_9;
                var4_9 = var9_7;
                var6_5 = var7_8;
                ** break;
            }
            case 0: 
        }
        ResultKt.throwOnFailure((Object)var2_3);
        var4_9 = this.lock;
        var4_9.lock();
        try {
            if (!this.isClosedForSend()) {
                if (this.capacity == -1) {
                    this.lastConflatedElement = var1_1 /* !! */ ;
                }
            } else {
                throw this.getSendException();
            }
            var5_6 = this.subscribers;
            var5_6 = ((Iterable)var5_6).iterator();
            var7_8 = this;
            var4_9 = var1_1 /* !! */ ;
            var1_1 /* !! */  = var6_5;
        }
        finally {
            var4_9.unlock();
        }
        while (var5_6.hasNext()) {
            var6_5 = (BufferedChannel)var5_6.next();
            var3_4.L$0 = var7_8;
            var3_4.L$1 = var4_9;
            var3_4.L$2 = var5_6;
            var3_4.label = 1;
            var8_10 = var6_5.sendBroadcast$kotlinx_coroutines_core(var4_9, (Continuation<? super Boolean>)var3_4);
            if (var8_10 == var1_1 /* !! */ ) {
                return var1_1 /* !! */ ;
            }
            var6_5 = var7_8;
lbl54:
            // 2 sources

            if (!((Boolean)var8_10).booleanValue() && var6_5.isClosedForSend()) {
                throw var6_5.getSendException();
            }
            var7_8 = var6_5;
        }
        return Unit.INSTANCE;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        CharSequence charSequence = this.lastConflatedElement != BroadcastChannelKt.access$getNO_ELEMENT$p() ? "CONFLATED_ELEMENT=" + this.lastConflatedElement + "; " : "";
        charSequence = stringBuilder.append((String)charSequence);
        charSequence = ((StringBuilder)charSequence).append("BROADCAST=<").append(super.toString());
        return ((StringBuilder)charSequence).append(">; SUBSCRIBERS=").append(CollectionsKt.joinToString$default((Iterable)this.subscribers, (CharSequence)";", (CharSequence)"<", (CharSequence)">", (int)0, null, null, (int)56, null)).toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public Object trySend-JP2dKIU(E object) {
        Lock lock = this.lock;
        lock.lock();
        try {
            if (this.isClosedForSend()) {
                Object object2 = super.trySend-JP2dKIU(object);
                return object2;
            }
            Iterator iterator2 = this.subscribers;
            boolean bl = iterator2 instanceof Collection;
            boolean bl2 = false;
            if (!bl || !((Collection)((Object)iterator2)).isEmpty()) {
                iterator2 = iterator2.iterator();
                while (iterator2.hasNext()) {
                    if (!((BufferedChannel)iterator2.next()).shouldSendSuspend$kotlinx_coroutines_core()) continue;
                    bl2 = true;
                    break;
                }
            }
            if (bl2) {
                Object object3 = ChannelResult.Companion.failure-PtdJZtk();
                return object3;
            }
            if (this.capacity == -1) {
                this.lastConflatedElement = object;
            }
            iterator2 = ((Iterable)this.subscribers).iterator();
            while (iterator2.hasNext()) {
                ((BufferedChannel)iterator2.next()).trySend-JP2dKIU(object);
            }
            Object object4 = ChannelResult.Companion.success-JP2dKIU(Unit.INSTANCE);
            return object4;
        }
        finally {
            lock.unlock();
        }
    }

    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0007"}, d2={"Lkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberBuffered;", "Lkotlinx/coroutines/channels/BufferedChannel;", "(Lkotlinx/coroutines/channels/BroadcastChannelImpl;)V", "cancelImpl", "", "cause", "", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
    private final class SubscriberBuffered
    extends BufferedChannel<E> {
        final BroadcastChannelImpl<E> this$0;

        public SubscriberBuffered(BroadcastChannelImpl broadcastChannelImpl) {
            this.this$0 = broadcastChannelImpl;
            super(broadcastChannelImpl.getCapacity(), null, 2, null);
        }

        public boolean cancelImpl(Throwable throwable) {
            Lock lock = this.this$0.lock;
            BroadcastChannelImpl broadcastChannelImpl = this.this$0;
            lock = lock;
            lock.lock();
            try {
                broadcastChannelImpl.removeSubscriber(this);
                boolean bl = super.cancelImpl$kotlinx_coroutines_core(throwable);
                return bl;
            }
            finally {
                lock.unlock();
            }
        }
    }

    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0007"}, d2={"Lkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberConflated;", "Lkotlinx/coroutines/channels/ConflatedBufferedChannel;", "(Lkotlinx/coroutines/channels/BroadcastChannelImpl;)V", "cancelImpl", "", "cause", "", "kotlinx-coroutines-core"}, k=1, mv={1, 8, 0}, xi=48)
    private final class SubscriberConflated
    extends ConflatedBufferedChannel<E> {
        final BroadcastChannelImpl<E> this$0;

        public SubscriberConflated(BroadcastChannelImpl broadcastChannelImpl) {
            this.this$0 = broadcastChannelImpl;
            super(1, BufferOverflow.DROP_OLDEST, null, 4, null);
        }

        public boolean cancelImpl(Throwable throwable) {
            this.this$0.removeSubscriber(this);
            return super.cancelImpl$kotlinx_coroutines_core(throwable);
        }
    }
}

