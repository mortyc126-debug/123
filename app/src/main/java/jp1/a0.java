package jp1;

import amuvvoafs.os.Parcel;
import com.gnacba.amuvvoafs.gms.internal.cast.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 extends p {
    public final h b;
    public final Class c;

    public a0(h hVar) {
        super("com.gnacba.amuvvoafs.gms.cast.framework.ISessionManagerListener", 0);
        this.b = hVar;
        this.c = c.class;
    }

    public final boolean w3(int i, Parcel parcel, Parcel parcel2) {
        Class cls = this.c;
        h hVar = this.b;
        switch (i) {
            case 1:
                bq1.b bVar = new bq1.b(hVar);
                parcel2.writeNoException();
                com.gnacba.amuvvoafs.gms.internal.cast.y.d(parcel2, bVar);
                return true;
            case 2:
                bq1.a aVarM4 = bq1.b.m4(parcel.readStrongBinder());
                com.gnacba.amuvvoafs.gms.internal.cast.y.b(parcel);
                f fVar = (f) bq1.b.n4(aVarM4);
                if (cls.isInstance(fVar) && hVar != null) {
                    hVar.o((f) cls.cast(fVar));
                }
                parcel2.writeNoException();
                return true;
            case 3:
                bq1.a aVarM42 = bq1.b.m4(parcel.readStrongBinder());
                String string = parcel.readString();
                com.gnacba.amuvvoafs.gms.internal.cast.y.b(parcel);
                f fVar2 = (f) bq1.b.n4(aVarM42);
                if (cls.isInstance(fVar2) && hVar != null) {
                    hVar.g((f) cls.cast(fVar2), string);
                }
                parcel2.writeNoException();
                return true;
            case 4:
                bq1.a aVarM43 = bq1.b.m4(parcel.readStrongBinder());
                int i2 = parcel.readInt();
                com.gnacba.amuvvoafs.gms.internal.cast.y.b(parcel);
                f fVar3 = (f) bq1.b.n4(aVarM43);
                if (cls.isInstance(fVar3) && hVar != null) {
                    hVar.k((f) cls.cast(fVar3), i2);
                }
                parcel2.writeNoException();
                return true;
            case 5:
                bq1.a aVarM44 = bq1.b.m4(parcel.readStrongBinder());
                com.gnacba.amuvvoafs.gms.internal.cast.y.b(parcel);
                f fVar4 = (f) bq1.b.n4(aVarM44);
                if (cls.isInstance(fVar4) && hVar != null) {
                    hVar.h((f) cls.cast(fVar4));
                }
                parcel2.writeNoException();
                return true;
            case 6:
                bq1.a aVarM45 = bq1.b.m4(parcel.readStrongBinder());
                int i3 = parcel.readInt();
                com.gnacba.amuvvoafs.gms.internal.cast.y.b(parcel);
                f fVar5 = (f) bq1.b.n4(aVarM45);
                if (cls.isInstance(fVar5) && hVar != null) {
                    hVar.d((f) cls.cast(fVar5), i3);
                }
                parcel2.writeNoException();
                return true;
            case 7:
                bq1.a aVarM46 = bq1.b.m4(parcel.readStrongBinder());
                String string2 = parcel.readString();
                com.gnacba.amuvvoafs.gms.internal.cast.y.b(parcel);
                f fVar6 = (f) bq1.b.n4(aVarM46);
                if (cls.isInstance(fVar6) && hVar != null) {
                    hVar.m((f) cls.cast(fVar6), string2);
                }
                parcel2.writeNoException();
                return true;
            case 8:
                bq1.a aVarM47 = bq1.b.m4(parcel.readStrongBinder());
                int i4 = com.gnacba.amuvvoafs.gms.internal.cast.y.a;
                boolean z = parcel.readInt() != 0;
                com.gnacba.amuvvoafs.gms.internal.cast.y.b(parcel);
                f fVar7 = (f) bq1.b.n4(aVarM47);
                if (cls.isInstance(fVar7) && hVar != null) {
                    hVar.i((f) cls.cast(fVar7), z);
                }
                parcel2.writeNoException();
                return true;
            case 9:
                bq1.a aVarM48 = bq1.b.m4(parcel.readStrongBinder());
                int i6 = parcel.readInt();
                com.gnacba.amuvvoafs.gms.internal.cast.y.b(parcel);
                f fVar8 = (f) bq1.b.n4(aVarM48);
                if (cls.isInstance(fVar8) && hVar != null) {
                    hVar.e((f) cls.cast(fVar8), i6);
                }
                parcel2.writeNoException();
                return true;
            case 10:
                bq1.a aVarM49 = bq1.b.m4(parcel.readStrongBinder());
                int i7 = parcel.readInt();
                com.gnacba.amuvvoafs.gms.internal.cast.y.b(parcel);
                f fVar9 = (f) bq1.b.n4(aVarM49);
                if (cls.isInstance(fVar9) && hVar != null) {
                    hVar.f((f) cls.cast(fVar9), i7);
                }
                parcel2.writeNoException();
                return true;
            case 11:
                parcel2.writeNoException();
                parcel2.writeInt(12451000);
                return true;
            default:
                return false;
        }
    }
}
