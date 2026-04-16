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
package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.room.IMultiInstanceInvalidationCallback;

public interface IMultiInstanceInvalidationService
extends IInterface {
    public static final String DESCRIPTOR = "androidx.room.IMultiInstanceInvalidationService";

    public void broadcastInvalidation(int var1, String[] var2) throws RemoteException;

    public int registerCallback(IMultiInstanceInvalidationCallback var1, String var2) throws RemoteException;

    public void unregisterCallback(IMultiInstanceInvalidationCallback var1, int var2) throws RemoteException;

    public static class Default
    implements IMultiInstanceInvalidationService {
        public IBinder asBinder() {
            return null;
        }

        @Override
        public void broadcastInvalidation(int n, String[] stringArray) throws RemoteException {
        }

        @Override
        public int registerCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String string2) throws RemoteException {
            return 0;
        }

        @Override
        public void unregisterCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int n) throws RemoteException {
        }
    }

    public static abstract class Stub
    extends Binder
    implements IMultiInstanceInvalidationService {
        static final int TRANSACTION_broadcastInvalidation = 3;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_unregisterCallback = 2;

        public Stub() {
            this.attachInterface(this, IMultiInstanceInvalidationService.DESCRIPTOR);
        }

        public static IMultiInstanceInvalidationService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface(IMultiInstanceInvalidationService.DESCRIPTOR);
            if (iInterface != null && iInterface instanceof IMultiInstanceInvalidationService) {
                return (IMultiInstanceInvalidationService)iInterface;
            }
            return new Proxy(iBinder);
        }

        public IBinder asBinder() {
            return this;
        }

        /*
         * Exception decompiling
         */
        public boolean onTransact(int var1_1, Parcel var2_2, Parcel var3_3, int var4_4) throws RemoteException {
            /*
             * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
             * 
             * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[CASE]], but top level block is 3[SWITCH]
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
             *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
             *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
             *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
             *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
             *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
             *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
             *     at org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:923)
             *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1035)
             *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
             *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
             *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
             *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
             *     at org.benf.cfr.reader.Main.main(Main.java:54)
             */
            throw new IllegalStateException("Decompilation failed");
        }

        private static class Proxy
        implements IMultiInstanceInvalidationService {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override
            public void broadcastInvalidation(int n, String[] stringArray) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken(IMultiInstanceInvalidationService.DESCRIPTOR);
                    parcel.writeInt(n);
                    parcel.writeStringArray(stringArray);
                    this.mRemote.transact(3, parcel, null, 1);
                    return;
                }
                finally {
                    parcel.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IMultiInstanceInvalidationService.DESCRIPTOR;
            }

            @Override
            public int registerCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken(IMultiInstanceInvalidationService.DESCRIPTOR);
                    parcel.writeStrongInterface((IInterface)iMultiInstanceInvalidationCallback);
                    parcel.writeString(string2);
                    this.mRemote.transact(1, parcel, parcel2, 0);
                    parcel2.readException();
                    int n = parcel2.readInt();
                    return n;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void unregisterCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int n) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken(IMultiInstanceInvalidationService.DESCRIPTOR);
                    parcel.writeStrongInterface((IInterface)iMultiInstanceInvalidationCallback);
                    parcel.writeInt(n);
                    this.mRemote.transact(2, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }
        }
    }
}

