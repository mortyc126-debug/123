/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.util.concurrent.ListenableFuture
 */
package androidx.work.impl;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.work.Operation;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;

public class OperationImpl
implements Operation {
    private final SettableFuture<Operation.State.SUCCESS> mOperationFuture;
    private final MutableLiveData<Operation.State> mOperationState = new MutableLiveData();

    public OperationImpl() {
        this.mOperationFuture = SettableFuture.create();
        this.markState(Operation.IN_PROGRESS);
    }

    @Override
    public ListenableFuture<Operation.State.SUCCESS> getResult() {
        return this.mOperationFuture;
    }

    @Override
    public LiveData<Operation.State> getState() {
        return this.mOperationState;
    }

    public void markState(Operation.State state) {
        this.mOperationState.postValue(state);
        if (state instanceof Operation.State.SUCCESS) {
            this.mOperationFuture.set((Operation.State.SUCCESS)state);
        } else if (state instanceof Operation.State.FAILURE) {
            state = (Operation.State.FAILURE)state;
            this.mOperationFuture.setException(((Operation.State.FAILURE)state).getThrowable());
        }
    }
}

