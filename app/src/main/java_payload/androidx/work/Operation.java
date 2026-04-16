/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.util.concurrent.ListenableFuture
 */
package androidx.work;

import androidx.lifecycle.LiveData;
import com.google.common.util.concurrent.ListenableFuture;

public interface Operation {
    public static final State.IN_PROGRESS IN_PROGRESS;
    public static final State.SUCCESS SUCCESS;

    static {
        SUCCESS = new State.SUCCESS();
        IN_PROGRESS = new State.IN_PROGRESS();
    }

    public ListenableFuture<State.SUCCESS> getResult();

    public LiveData<State> getState();

    public static abstract class State {
        State() {
        }

        public static final class FAILURE
        extends State {
            private final Throwable mThrowable;

            public FAILURE(Throwable throwable) {
                this.mThrowable = throwable;
            }

            public Throwable getThrowable() {
                return this.mThrowable;
            }

            public String toString() {
                return "FAILURE (" + this.mThrowable.getMessage() + ")";
            }
        }

        public static final class IN_PROGRESS
        extends State {
            private IN_PROGRESS() {
            }

            public String toString() {
                return "IN_PROGRESS";
            }
        }

        public static final class SUCCESS
        extends State {
            private SUCCESS() {
            }

            public String toString() {
                return "SUCCESS";
            }
        }
    }
}

