/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 */
package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public interface INotificationSideChannel
extends IInterface {
    public static final String DESCRIPTOR = "android$support$v4$app$INotificationSideChannel".replace('$', '.');

    public void cancel(String var1, int var2, String var3) throws RemoteException;

    public void cancelAll(String var1) throws RemoteException;

    public void notify(String var1, int var2, String var3, Notification var4) throws RemoteException;

    public static class Default
    implements INotificationSideChannel {
        public IBinder asBinder() {
            return null;
        }

        @Override
        public void cancel(String string2, int n, String string3) throws RemoteException {
        }

        @Override
        public void cancelAll(String string2) throws RemoteException {
        }

        @Override
        public void notify(String string2, int n, String string3, Notification notification) throws RemoteException {
        }
    }

    public static abstract class Stub
    extends Binder
    implements INotificationSideChannel {
        static final int TRANSACTION_cancel = 2;
        static final int TRANSACTION_cancelAll = 3;
        static final int TRANSACTION_notify = 1;

        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        public static INotificationSideChannel asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterface != null && iInterface instanceof INotificationSideChannel) {
                return (INotificationSideChannel)iInterface;
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
                case 3: {
                    this.cancelAll(parcel.readString());
                    break;
                }
                case 2: {
                    this.cancel(parcel.readString(), parcel.readInt(), parcel.readString());
                    break;
                }
                case 1: {
                    this.notify(parcel.readString(), parcel.readInt(), parcel.readString(), (Notification)_Parcel.readTypedObject(parcel, Notification.CREATOR));
                }
            }
            return true;
        }

        private static class Proxy
        implements INotificationSideChannel {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override
            public void cancel(String string2, int n, String string3) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken(DESCRIPTOR);
                    parcel.writeString(string2);
                    parcel.writeInt(n);
                    parcel.writeString(string3);
                    this.mRemote.transact(2, parcel, null, 1);
                    return;
                }
                finally {
                    parcel.recycle();
                }
            }

            @Override
            public void cancelAll(String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken(DESCRIPTOR);
                    parcel.writeString(string2);
                    this.mRemote.transact(3, parcel, null, 1);
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
            public void notify(String string2, int n, String string3, Notification notification) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken(DESCRIPTOR);
                    parcel.writeString(string2);
                    parcel.writeInt(n);
                    parcel.writeString(string3);
                    _Parcel.writeTypedObject(parcel, (Parcelable)notification, 0);
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

