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
package androidx.core.app.unusedapprestrictions;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;

public interface IUnusedAppRestrictionsBackportService
extends IInterface {
    public static final String DESCRIPTOR = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportService".replace('$', '.');

    public void isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback var1) throws RemoteException;

    public static class Default
    implements IUnusedAppRestrictionsBackportService {
        public IBinder asBinder() {
            return null;
        }

        @Override
        public void isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback) throws RemoteException {
        }
    }

    public static abstract class Stub
    extends Binder
    implements IUnusedAppRestrictionsBackportService {
        static final int TRANSACTION_isPermissionRevocationEnabledForApp = 1;

        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        public static IUnusedAppRestrictionsBackportService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterface != null && iInterface instanceof IUnusedAppRestrictionsBackportService) {
                return (IUnusedAppRestrictionsBackportService)iInterface;
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
            this.isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback.Stub.asInterface(parcel.readStrongBinder()));
            return true;
        }

        private static class Proxy
        implements IUnusedAppRestrictionsBackportService {
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
            public void isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken(DESCRIPTOR);
                    parcel.writeStrongInterface((IInterface)iUnusedAppRestrictionsBackportCallback);
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

