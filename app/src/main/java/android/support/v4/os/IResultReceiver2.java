/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 */
package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public interface IResultReceiver2
extends IInterface {
    public static final String DESCRIPTOR = "android$support$v4$os$IResultReceiver2".replace('$', '.');

    public void send(int var1, Bundle var2) throws RemoteException;

    public static class Default
    implements IResultReceiver2 {
        public IBinder asBinder() {
            return null;
        }

        @Override
        public void send(int n, Bundle bundle) throws RemoteException {
        }
    }

    public static abstract class Stub
    extends Binder
    implements IResultReceiver2 {
        static final int TRANSACTION_send = 1;

        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        public static IResultReceiver2 asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterface != null && iInterface instanceof IResultReceiver2) {
                return (IResultReceiver2)iInterface;
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
                case 1: 
            }
            this.send(parcel.readInt(), (Bundle)_Parcel.readTypedObject(parcel, Bundle.CREATOR));
            return true;
        }

        private static class Proxy
        implements IResultReceiver2 {
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
            public void send(int n, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken(DESCRIPTOR);
                    parcel.writeInt(n);
                    _Parcel.writeTypedObject(parcel, (Parcelable)bundle, 0);
                    this.mRemote.transact(1, parcel, null, 1);
                    return;
                }
                finally {
                    parcel.recycle();
                }
            }
        }
    }

    public static class _Parcel {
        private static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return (T)creator.createFromParcel(parcel);
            }
            return null;
        }

        private static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t, int n) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, n);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}

