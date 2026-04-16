/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 */
package androidx.work.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.work.multiprocess.IWorkManagerImplCallback;

public interface IWorkManagerImpl
extends IInterface {
    public static final String DESCRIPTOR = "androidx$work$multiprocess$IWorkManagerImpl".replace('$', '.');

    public void cancelAllWork(IWorkManagerImplCallback var1) throws RemoteException;

    public void cancelAllWorkByTag(String var1, IWorkManagerImplCallback var2) throws RemoteException;

    public void cancelUniqueWork(String var1, IWorkManagerImplCallback var2) throws RemoteException;

    public void cancelWorkById(String var1, IWorkManagerImplCallback var2) throws RemoteException;

    public void enqueueContinuation(byte[] var1, IWorkManagerImplCallback var2) throws RemoteException;

    public void enqueueWorkRequests(byte[] var1, IWorkManagerImplCallback var2) throws RemoteException;

    public void queryWorkInfo(byte[] var1, IWorkManagerImplCallback var2) throws RemoteException;

    public void setForegroundAsync(byte[] var1, IWorkManagerImplCallback var2) throws RemoteException;

    public void setProgress(byte[] var1, IWorkManagerImplCallback var2) throws RemoteException;

    public void updateUniquePeriodicWorkRequest(String var1, byte[] var2, IWorkManagerImplCallback var3) throws RemoteException;

    public static class Default
    implements IWorkManagerImpl {
        public IBinder asBinder() {
            return null;
        }

        @Override
        public void cancelAllWork(IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }

        @Override
        public void cancelAllWorkByTag(String string2, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }

        @Override
        public void cancelUniqueWork(String string2, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }

        @Override
        public void cancelWorkById(String string2, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }

        @Override
        public void enqueueContinuation(byte[] byArray, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }

        @Override
        public void enqueueWorkRequests(byte[] byArray, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }

        @Override
        public void queryWorkInfo(byte[] byArray, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }

        @Override
        public void setForegroundAsync(byte[] byArray, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }

        @Override
        public void setProgress(byte[] byArray, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }

        @Override
        public void updateUniquePeriodicWorkRequest(String string2, byte[] byArray, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }
    }

    public static abstract class Stub
    extends Binder
    implements IWorkManagerImpl {
        static final int TRANSACTION_cancelAllWork = 7;
        static final int TRANSACTION_cancelAllWorkByTag = 5;
        static final int TRANSACTION_cancelUniqueWork = 6;
        static final int TRANSACTION_cancelWorkById = 4;
        static final int TRANSACTION_enqueueContinuation = 3;
        static final int TRANSACTION_enqueueWorkRequests = 1;
        static final int TRANSACTION_queryWorkInfo = 8;
        static final int TRANSACTION_setForegroundAsync = 10;
        static final int TRANSACTION_setProgress = 9;
        static final int TRANSACTION_updateUniquePeriodicWorkRequest = 2;

        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        public static IWorkManagerImpl asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterface != null && iInterface instanceof IWorkManagerImpl) {
                return (IWorkManagerImpl)iInterface;
            }
            return new Proxy(iBinder);
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
            String string2 = DESCRIPTOR;
            if (n >= 1 && n <= 0xFFFFFF) {
                parcel.enforceInterface(string2);
            }
            if (n == 1598968902) {
                parcel2.writeString(string2);
                return true;
            }
            switch (n) {
                default: {
                    return super.onTransact(n, parcel, parcel2, n2);
                }
                case 10: {
                    this.setForegroundAsync(parcel.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
                    break;
                }
                case 9: {
                    this.setProgress(parcel.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
                    break;
                }
                case 8: {
                    this.queryWorkInfo(parcel.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
                    break;
                }
                case 7: {
                    this.cancelAllWork(IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
                    break;
                }
                case 6: {
                    this.cancelUniqueWork(parcel.readString(), IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
                    break;
                }
                case 5: {
                    this.cancelAllWorkByTag(parcel.readString(), IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
                    break;
                }
                case 4: {
                    this.cancelWorkById(parcel.readString(), IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
                    break;
                }
                case 3: {
                    this.enqueueContinuation(parcel.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
                    break;
                }
                case 2: {
                    this.updateUniquePeriodicWorkRequest(parcel.readString(), parcel.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
                    break;
                }
                case 1: {
                    this.enqueueWorkRequests(parcel.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
                }
            }
            return true;
        }

        private static class Proxy
        implements IWorkManagerImpl {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override
            public void cancelAllWork(IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken(DESCRIPTOR);
                    parcel.writeStrongInterface((IInterface)iWorkManagerImplCallback);
                    this.mRemote.transact(7, parcel, null, 1);
                    return;
                }
                finally {
                    parcel.recycle();
                }
            }

            @Override
            public void cancelAllWorkByTag(String string2, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken(DESCRIPTOR);
                    parcel.writeString(string2);
                    parcel.writeStrongInterface((IInterface)iWorkManagerImplCallback);
                    this.mRemote.transact(5, parcel, null, 1);
                    return;
                }
                finally {
                    parcel.recycle();
                }
            }

            @Override
            public void cancelUniqueWork(String string2, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken(DESCRIPTOR);
                    parcel.writeString(string2);
                    parcel.writeStrongInterface((IInterface)iWorkManagerImplCallback);
                    this.mRemote.transact(6, parcel, null, 1);
                    return;
                }
                finally {
                    parcel.recycle();
                }
            }

            @Override
            public void cancelWorkById(String string2, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken(DESCRIPTOR);
                    parcel.writeString(string2);
                    parcel.writeStrongInterface((IInterface)iWorkManagerImplCallback);
                    this.mRemote.transact(4, parcel, null, 1);
                    return;
                }
                finally {
                    parcel.recycle();
                }
            }

            @Override
            public void enqueueContinuation(byte[] byArray, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken(DESCRIPTOR);
                    parcel.writeByteArray(byArray);
                    parcel.writeStrongInterface((IInterface)iWorkManagerImplCallback);
                    this.mRemote.transact(3, parcel, null, 1);
                    return;
                }
                finally {
                    parcel.recycle();
                }
            }

            @Override
            public void enqueueWorkRequests(byte[] byArray, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken(DESCRIPTOR);
                    parcel.writeByteArray(byArray);
                    parcel.writeStrongInterface((IInterface)iWorkManagerImplCallback);
                    this.mRemote.transact(1, parcel, null, 1);
                    return;
                }
                finally {
                    parcel.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            @Override
            public void queryWorkInfo(byte[] byArray, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken(DESCRIPTOR);
                    parcel.writeByteArray(byArray);
                    parcel.writeStrongInterface((IInterface)iWorkManagerImplCallback);
                    this.mRemote.transact(8, parcel, null, 1);
                    return;
                }
                finally {
                    parcel.recycle();
                }
            }

            @Override
            public void setForegroundAsync(byte[] byArray, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken(DESCRIPTOR);
                    parcel.writeByteArray(byArray);
                    parcel.writeStrongInterface((IInterface)iWorkManagerImplCallback);
                    this.mRemote.transact(10, parcel, null, 1);
                    return;
                }
                finally {
                    parcel.recycle();
                }
            }

            @Override
            public void setProgress(byte[] byArray, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken(DESCRIPTOR);
                    parcel.writeByteArray(byArray);
                    parcel.writeStrongInterface((IInterface)iWorkManagerImplCallback);
                    this.mRemote.transact(9, parcel, null, 1);
                    return;
                }
                finally {
                    parcel.recycle();
                }
            }

            @Override
            public void updateUniquePeriodicWorkRequest(String string2, byte[] byArray, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken(DESCRIPTOR);
                    parcel.writeString(string2);
                    parcel.writeByteArray(byArray);
                    parcel.writeStrongInterface((IInterface)iWorkManagerImplCallback);
                    this.mRemote.transact(2, parcel, null, 1);
                    return;
                }
                finally {
                    parcel.recycle();
                }
            }
        }
    }
}

