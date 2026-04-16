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

public interface IUnusedAppRestrictionsBackportCallback
extends IInterface {
    public static final String DESCRIPTOR = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportCallback".replace('$', '.');

    public void onIsPermissionRevocationEnabledForAppResult(boolean var1, boolean var2) throws RemoteException;

    public static class Default
    implements IUnusedAppRestrictionsBackportCallback {
        public IBinder asBinder() {
            return null;
        }

        @Override
        public void onIsPermissionRevocationEnabledForAppResult(boolean bl, boolean bl2) throws RemoteException {
        }
    }

    public static abstract class Stub
    extends Binder
    implements IUnusedAppRestrictionsBackportCallback {
        static final int TRANSACTION_onIsPermissionRevocationEnabledForAppResult = 1;

        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        public static IUnusedAppRestrictionsBackportCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterface != null && iInterface instanceof IUnusedAppRestrictionsBackportCallback) {
                return (IUnusedAppRestrictionsBackportCallback)iInterface;
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
            n = parcel.readInt();
            boolean bl = false;
            boolean bl2 = n != 0;
            if (parcel.readInt() != 0) {
                bl = true;
            }
            this.onIsPermissionRevocationEnabledForAppResult(bl2, bl);
            return true;
        }

        private static class Proxy
        implements IUnusedAppRestrictionsBackportCallback {
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
            public void onIsPermissionRevocationEnabledForAppResult(boolean bl, boolean bl2) throws RemoteException {
                int n;
                Parcel parcel;
                block5: {
                    parcel = Parcel.obtain();
                    parcel.writeInterfaceToken(DESCRIPTOR);
                    int n2 = 0;
                    n = bl ? 1 : 0;
                    parcel.writeInt(n);
                    n = n2;
                    if (!bl2) break block5;
                    n = 1;
                }
                try {
                    parcel.writeInt(n);
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

