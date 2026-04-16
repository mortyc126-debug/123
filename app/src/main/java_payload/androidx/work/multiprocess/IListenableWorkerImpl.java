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

public interface IListenableWorkerImpl
extends IInterface {
    public static final String DESCRIPTOR = "androidx$work$multiprocess$IListenableWorkerImpl".replace('$', '.');

    public void interrupt(byte[] var1, IWorkManagerImplCallback var2) throws RemoteException;

    public void startWork(byte[] var1, IWorkManagerImplCallback var2) throws RemoteException;

    public static class Default
    implements IListenableWorkerImpl {
        public IBinder asBinder() {
            return null;
        }

        @Override
        public void interrupt(byte[] byArray, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }

        @Override
        public void startWork(byte[] byArray, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }
    }

    public static abstract class Stub
    extends Binder
    implements IListenableWorkerImpl {
        static final int TRANSACTION_interrupt = 2;
        static final int TRANSACTION_startWork = 1;

        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        public static IListenableWorkerImpl asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterface != null && iInterface instanceof IListenableWorkerImpl) {
                return (IListenableWorkerImpl)iInterface;
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
                case 2: {
                    this.interrupt(parcel.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
                    break;
                }
                case 1: {
                    this.startWork(parcel.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
                }
            }
            return true;
        }

        private static class Proxy
        implements IListenableWorkerImpl {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            @Override
            public void interrupt(byte[] byArray, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken(DESCRIPTOR);
                    parcel.writeByteArray(byArray);
                    parcel.writeStrongInterface((IInterface)iWorkManagerImplCallback);
                    this.mRemote.transact(2, parcel, null, 1);
                    return;
                }
                finally {
                    parcel.recycle();
                }
            }

            @Override
            public void startWork(byte[] byArray, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
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
        }
    }
}

