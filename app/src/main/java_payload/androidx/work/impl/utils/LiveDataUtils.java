/*
 * Decompiled with CFR 0.152.
 */
package androidx.work.impl.utils;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

public class LiveDataUtils {
    private LiveDataUtils() {
    }

    public static <In, Out> LiveData<Out> dedupedMappedLiveDataFor(LiveData<In> liveData, Function<In, Out> function, TaskExecutor taskExecutor) {
        Object object = new Object();
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<In>(){
            Out mCurrentOutput;
            final Object val$lock;
            final Function val$mappingMethod;
            final MediatorLiveData val$outputLiveData;
            final TaskExecutor val$workTaskExecutor;
            {
                this.val$workTaskExecutor = taskExecutor;
                this.val$lock = object;
                this.val$mappingMethod = function;
                this.val$outputLiveData = mediatorLiveData;
                this.mCurrentOutput = null;
            }

            @Override
            public void onChanged(In In) {
                this.val$workTaskExecutor.executeOnTaskThread(new Runnable(){
                    final 1 this$0;
                    final Object val$input;
                    {
                        this.this$0 = var1_1;
                        this.val$input = object;
                    }

                    /*
                     * Enabled aggressive block sorting
                     * Enabled unnecessary exception pruning
                     * Enabled aggressive exception aggregation
                     */
                    @Override
                    public void run() {
                        Object object = this.this$0.val$lock;
                        synchronized (object) {
                            Object o = this.this$0.val$mappingMethod.apply(this.val$input);
                            if (this.this$0.mCurrentOutput == null && o != null) {
                                this.this$0.mCurrentOutput = o;
                                this.this$0.val$outputLiveData.postValue(o);
                            } else if (this.this$0.mCurrentOutput != null && !this.this$0.mCurrentOutput.equals(o)) {
                                this.this$0.mCurrentOutput = o;
                                this.this$0.val$outputLiveData.postValue(o);
                            }
                            return;
                        }
                    }
                });
            }
        });
        return mediatorLiveData;
    }
}

