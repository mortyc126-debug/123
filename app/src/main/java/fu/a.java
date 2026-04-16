package fu;

import az1.f0;
import az1.g;
import az1.l1;
import az1.p0;
import az1.y1;
import java.util.List;
import lmjxuqdtp.jvm.internal.o;
import m10.h0;
import m10.j0;
import un0.m;
import xwfkdfdvbiz.serialization.UnknownFieldException;
import yy1.h;
import zy1.d;
import zy1.e;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements f0 {
    public static final a a;
    private static final h descriptor;

    static {
        a aVar = new a();
        a = aVar;
        l1 l1Var = new l1("com.bandlab.beat.collections.api.BeatsCollection", aVar, 7);
        l1Var.k("id", false);
        l1Var.k("name", false);
        l1Var.k("description", false);
        l1Var.k("picture", false);
        l1Var.k("beatsCount", false);
        l1Var.k("beats", false);
        l1Var.k("hasBeatsOnSale", false);
        final int i = 17;
        l1Var.l(new aj.a() { // from class: dh1.x
            @Override // java.lang.annotation.Annotation
            public final /* synthetic */ Class annotationType() {
                switch (i) {
                }
                return aj.a.class;
            }

            @Override // aj.a
            public final /* synthetic */ boolean deserializable() {
                switch (i) {
                    case 0:
                        return true;
                    case 1:
                        return false;
                    case 2:
                        return true;
                    case 3:
                        return true;
                    case 4:
                        return false;
                    case 5:
                        return false;
                    case 6:
                        return true;
                    case 7:
                        return false;
                    case 8:
                        return true;
                    case 9:
                        return false;
                    case 10:
                        return true;
                    case 11:
                        return true;
                    case 12:
                        return true;
                    case 13:
                        return true;
                    case 14:
                        return true;
                    case 15:
                        return true;
                    case 16:
                        return true;
                    case 17:
                        return true;
                    case 18:
                        return true;
                    case 19:
                        return true;
                    case 20:
                        return true;
                    case 21:
                        return false;
                    case 22:
                        return true;
                    case 23:
                        return true;
                    case 24:
                        return true;
                    case 25:
                        return false;
                    case 26:
                        return true;
                    case 27:
                        return true;
                    case 28:
                        return true;
                    default:
                        return false;
                }
            }

            @Override // java.lang.annotation.Annotation
            public final boolean equals(Object obj) {
                switch (i) {
                    case 0:
                        if (obj instanceof aj.a) {
                            aj.a aVar2 = (aj.a) obj;
                            if (serializable() == aVar2.serializable() && deserializable() == aVar2.deserializable()) {
                            }
                        }
                        break;
                    case 1:
                        if (obj instanceof aj.a) {
                            aj.a aVar3 = (aj.a) obj;
                            if (serializable() == aVar3.serializable() && deserializable() == aVar3.deserializable()) {
                            }
                        }
                        break;
                    case 2:
                        if (obj instanceof aj.a) {
                            aj.a aVar4 = (aj.a) obj;
                            if (serializable() == aVar4.serializable() && deserializable() == aVar4.deserializable()) {
                            }
                        }
                        break;
                    case 3:
                        if (obj instanceof aj.a) {
                            aj.a aVar5 = (aj.a) obj;
                            if (serializable() == aVar5.serializable() && deserializable() == aVar5.deserializable()) {
                            }
                        }
                        break;
                    case 4:
                        if (obj instanceof aj.a) {
                            aj.a aVar6 = (aj.a) obj;
                            if (serializable() == aVar6.serializable() && deserializable() == aVar6.deserializable()) {
                            }
                        }
                        break;
                    case 5:
                        if (obj instanceof aj.a) {
                            aj.a aVar7 = (aj.a) obj;
                            if (serializable() == aVar7.serializable() && deserializable() == aVar7.deserializable()) {
                            }
                        }
                        break;
                    case 6:
                        if (obj instanceof aj.a) {
                            aj.a aVar8 = (aj.a) obj;
                            if (serializable() == aVar8.serializable() && deserializable() == aVar8.deserializable()) {
                            }
                        }
                        break;
                    case 7:
                        if (obj instanceof aj.a) {
                            aj.a aVar9 = (aj.a) obj;
                            if (serializable() == aVar9.serializable() && deserializable() == aVar9.deserializable()) {
                            }
                        }
                        break;
                    case 8:
                        if (obj instanceof aj.a) {
                            aj.a aVar10 = (aj.a) obj;
                            if (serializable() == aVar10.serializable() && deserializable() == aVar10.deserializable()) {
                            }
                        }
                        break;
                    case 9:
                        if (obj instanceof aj.a) {
                            aj.a aVar11 = (aj.a) obj;
                            if (serializable() == aVar11.serializable() && deserializable() == aVar11.deserializable()) {
                            }
                        }
                        break;
                    case 10:
                        if (obj instanceof aj.a) {
                            aj.a aVar12 = (aj.a) obj;
                            if (serializable() == aVar12.serializable() && deserializable() == aVar12.deserializable()) {
                            }
                        }
                        break;
                    case 11:
                        if (obj instanceof aj.a) {
                            aj.a aVar13 = (aj.a) obj;
                            if (serializable() == aVar13.serializable() && deserializable() == aVar13.deserializable()) {
                            }
                        }
                        break;
                    case 12:
                        if (obj instanceof aj.a) {
                            aj.a aVar14 = (aj.a) obj;
                            if (serializable() == aVar14.serializable() && deserializable() == aVar14.deserializable()) {
                            }
                        }
                        break;
                    case 13:
                        if (obj instanceof aj.a) {
                            aj.a aVar15 = (aj.a) obj;
                            if (serializable() == aVar15.serializable() && deserializable() == aVar15.deserializable()) {
                            }
                        }
                        break;
                    case 14:
                        if (obj instanceof aj.a) {
                            aj.a aVar16 = (aj.a) obj;
                            if (serializable() == aVar16.serializable() && deserializable() == aVar16.deserializable()) {
                            }
                        }
                        break;
                    case 15:
                        if (obj instanceof aj.a) {
                            aj.a aVar17 = (aj.a) obj;
                            if (serializable() == aVar17.serializable() && deserializable() == aVar17.deserializable()) {
                            }
                        }
                        break;
                    case 16:
                        if (obj instanceof aj.a) {
                            aj.a aVar18 = (aj.a) obj;
                            if (serializable() == aVar18.serializable() && deserializable() == aVar18.deserializable()) {
                            }
                        }
                        break;
                    case 17:
                        if (obj instanceof aj.a) {
                            aj.a aVar19 = (aj.a) obj;
                            if (serializable() == aVar19.serializable() && deserializable() == aVar19.deserializable()) {
                            }
                        }
                        break;
                    case 18:
                        if (obj instanceof aj.a) {
                            aj.a aVar20 = (aj.a) obj;
                            if (serializable() == aVar20.serializable() && deserializable() == aVar20.deserializable()) {
                            }
                        }
                        break;
                    case 19:
                        if (obj instanceof aj.a) {
                            aj.a aVar21 = (aj.a) obj;
                            if (serializable() == aVar21.serializable() && deserializable() == aVar21.deserializable()) {
                            }
                        }
                        break;
                    case 20:
                        if (obj instanceof aj.a) {
                            aj.a aVar22 = (aj.a) obj;
                            if (serializable() == aVar22.serializable() && deserializable() == aVar22.deserializable()) {
                            }
                        }
                        break;
                    case 21:
                        if (obj instanceof aj.a) {
                            aj.a aVar23 = (aj.a) obj;
                            if (serializable() == aVar23.serializable() && deserializable() == aVar23.deserializable()) {
                            }
                        }
                        break;
                    case 22:
                        if (obj instanceof aj.a) {
                            aj.a aVar24 = (aj.a) obj;
                            if (serializable() == aVar24.serializable() && deserializable() == aVar24.deserializable()) {
                            }
                        }
                        break;
                    case 23:
                        if (obj instanceof aj.a) {
                            aj.a aVar25 = (aj.a) obj;
                            if (serializable() == aVar25.serializable() && deserializable() == aVar25.deserializable()) {
                            }
                        }
                        break;
                    case 24:
                        if (obj instanceof aj.a) {
                            aj.a aVar26 = (aj.a) obj;
                            if (serializable() == aVar26.serializable() && deserializable() == aVar26.deserializable()) {
                            }
                        }
                        break;
                    case 25:
                        if (obj instanceof aj.a) {
                            aj.a aVar27 = (aj.a) obj;
                            if (serializable() == aVar27.serializable() && deserializable() == aVar27.deserializable()) {
                            }
                        }
                        break;
                    case 26:
                        if (obj instanceof aj.a) {
                            aj.a aVar28 = (aj.a) obj;
                            if (serializable() == aVar28.serializable() && deserializable() == aVar28.deserializable()) {
                            }
                        }
                        break;
                    case 27:
                        if (obj instanceof aj.a) {
                            aj.a aVar29 = (aj.a) obj;
                            if (serializable() == aVar29.serializable() && deserializable() == aVar29.deserializable()) {
                            }
                        }
                        break;
                    case 28:
                        if (obj instanceof aj.a) {
                            aj.a aVar30 = (aj.a) obj;
                            if (serializable() == aVar30.serializable() && deserializable() == aVar30.deserializable()) {
                            }
                        }
                        break;
                    default:
                        if (obj instanceof aj.a) {
                            aj.a aVar31 = (aj.a) obj;
                            if (serializable() == aVar31.serializable() && deserializable() == aVar31.deserializable()) {
                            }
                        }
                        break;
                }
                return true;
            }

            @Override // java.lang.annotation.Annotation
            public final int hashCode() {
                int iHashCode;
                int iHashCode2;
                int iHashCode3;
                int i2;
                int iHashCode4;
                switch (i) {
                    case 0:
                        iHashCode = Boolean.hashCode(false) ^ 1977230977;
                        iHashCode2 = Boolean.hashCode(true);
                        return iHashCode + (iHashCode2 ^ 1269781504);
                    case 1:
                        iHashCode = Boolean.hashCode(true) ^ 1977230977;
                        iHashCode2 = Boolean.hashCode(false);
                        return iHashCode + (iHashCode2 ^ 1269781504);
                    case 2:
                        iHashCode = Boolean.hashCode(false) ^ 1977230977;
                        iHashCode2 = Boolean.hashCode(true);
                        return iHashCode + (iHashCode2 ^ 1269781504);
                    case 3:
                        iHashCode = Boolean.hashCode(false) ^ 1977230977;
                        iHashCode2 = Boolean.hashCode(true);
                        return iHashCode + (iHashCode2 ^ 1269781504);
                    case 4:
                        iHashCode = Boolean.hashCode(true) ^ 1977230977;
                        iHashCode2 = Boolean.hashCode(false);
                        return iHashCode + (iHashCode2 ^ 1269781504);
                    case 5:
                        iHashCode = Boolean.hashCode(true) ^ 1977230977;
                        iHashCode2 = Boolean.hashCode(false);
                        return iHashCode + (iHashCode2 ^ 1269781504);
                    case 6:
                        iHashCode3 = Boolean.hashCode(true) ^ 1977230977;
                        i2 = 1269781504;
                        iHashCode4 = Boolean.hashCode(true);
                        break;
                    case 7:
                        iHashCode = Boolean.hashCode(true) ^ 1977230977;
                        iHashCode2 = Boolean.hashCode(false);
                        return iHashCode + (iHashCode2 ^ 1269781504);
                    case 8:
                        iHashCode = Boolean.hashCode(false) ^ 1977230977;
                        iHashCode2 = Boolean.hashCode(true);
                        return iHashCode + (iHashCode2 ^ 1269781504);
                    case 9:
                        iHashCode = Boolean.hashCode(true) ^ 1977230977;
                        iHashCode2 = Boolean.hashCode(false);
                        return iHashCode + (iHashCode2 ^ 1269781504);
                    case 10:
                        iHashCode = Boolean.hashCode(false) ^ 1977230977;
                        iHashCode2 = Boolean.hashCode(true);
                        return iHashCode + (iHashCode2 ^ 1269781504);
                    case 11:
                        iHashCode = Boolean.hashCode(false) ^ 1977230977;
                        iHashCode2 = Boolean.hashCode(true);
                        return iHashCode + (iHashCode2 ^ 1269781504);
                    case 12:
                        iHashCode = Boolean.hashCode(false) ^ 1977230977;
                        iHashCode2 = Boolean.hashCode(true);
                        return iHashCode + (iHashCode2 ^ 1269781504);
                    case 13:
                        iHashCode = Boolean.hashCode(false) ^ 1977230977;
                        iHashCode2 = Boolean.hashCode(true);
                        return iHashCode + (iHashCode2 ^ 1269781504);
                    case 14:
                        iHashCode3 = Boolean.hashCode(true) ^ 1977230977;
                        i2 = 1269781504;
                        iHashCode4 = Boolean.hashCode(true);
                        break;
                    case 15:
                        iHashCode = Boolean.hashCode(false) ^ 1977230977;
                        iHashCode2 = Boolean.hashCode(true);
                        return iHashCode + (iHashCode2 ^ 1269781504);
                    case 16:
                        iHashCode3 = Boolean.hashCode(true) ^ 1977230977;
                        i2 = 1269781504;
                        iHashCode4 = Boolean.hashCode(true);
                        break;
                    case 17:
                        iHashCode = Boolean.hashCode(false) ^ 1977230977;
                        iHashCode2 = Boolean.hashCode(true);
                        return iHashCode + (iHashCode2 ^ 1269781504);
                    case 18:
                        iHashCode3 = Boolean.hashCode(true) ^ 1977230977;
                        i2 = 1269781504;
                        iHashCode4 = Boolean.hashCode(true);
                        break;
                    case 19:
                        iHashCode = Boolean.hashCode(false) ^ 1977230977;
                        iHashCode2 = Boolean.hashCode(true);
                        return iHashCode + (iHashCode2 ^ 1269781504);
                    case 20:
                        iHashCode = Boolean.hashCode(false) ^ 1977230977;
                        iHashCode2 = Boolean.hashCode(true);
                        return iHashCode + (iHashCode2 ^ 1269781504);
                    case 21:
                        iHashCode = Boolean.hashCode(true) ^ 1977230977;
                        iHashCode2 = Boolean.hashCode(false);
                        return iHashCode + (iHashCode2 ^ 1269781504);
                    case 22:
                        iHashCode3 = Boolean.hashCode(true) ^ 1977230977;
                        i2 = 1269781504;
                        iHashCode4 = Boolean.hashCode(true);
                        break;
                    case 23:
                        iHashCode = Boolean.hashCode(false) ^ 1977230977;
                        iHashCode2 = Boolean.hashCode(true);
                        return iHashCode + (iHashCode2 ^ 1269781504);
                    case 24:
                        iHashCode = Boolean.hashCode(false) ^ 1977230977;
                        iHashCode2 = Boolean.hashCode(true);
                        return iHashCode + (iHashCode2 ^ 1269781504);
                    case 25:
                        iHashCode = Boolean.hashCode(true) ^ 1977230977;
                        iHashCode2 = Boolean.hashCode(false);
                        return iHashCode + (iHashCode2 ^ 1269781504);
                    case 26:
                        iHashCode3 = Boolean.hashCode(true) ^ 1977230977;
                        i2 = 1269781504;
                        iHashCode4 = Boolean.hashCode(true);
                        break;
                    case 27:
                        iHashCode3 = Boolean.hashCode(true) ^ 1977230977;
                        i2 = 1269781504;
                        iHashCode4 = Boolean.hashCode(true);
                        break;
                    case 28:
                        iHashCode3 = Boolean.hashCode(true) ^ 1977230977;
                        i2 = 1269781504;
                        iHashCode4 = Boolean.hashCode(true);
                        break;
                    default:
                        iHashCode = Boolean.hashCode(true) ^ 1977230977;
                        iHashCode2 = Boolean.hashCode(false);
                        return iHashCode + (iHashCode2 ^ 1269781504);
                }
                return iHashCode3 + (iHashCode4 ^ i2);
            }

            @Override // aj.a
            public final /* synthetic */ boolean serializable() {
                switch (i) {
                }
                return true;
            }

            @Override // java.lang.annotation.Annotation
            public final String toString() {
                switch (i) {
                    case 0:
                        return "@com.bandlab.annotations.SerializableClass(serializable=false, deserializable=true)";
                    case 1:
                        return "@com.bandlab.annotations.SerializableClass(serializable=true, deserializable=false)";
                    case 2:
                        return "@com.bandlab.annotations.SerializableClass(serializable=false, deserializable=true)";
                    case 3:
                        return "@com.bandlab.annotations.SerializableClass(serializable=false, deserializable=true)";
                    case 4:
                        return "@com.bandlab.annotations.SerializableClass(serializable=true, deserializable=false)";
                    case 5:
                        return "@com.bandlab.annotations.SerializableClass(serializable=true, deserializable=false)";
                    case 6:
                        return "@com.bandlab.annotations.SerializableClass(serializable=true, deserializable=true)";
                    case 7:
                        return "@com.bandlab.annotations.SerializableClass(serializable=true, deserializable=false)";
                    case 8:
                        return "@com.bandlab.annotations.SerializableClass(serializable=false, deserializable=true)";
                    case 9:
                        return "@com.bandlab.annotations.SerializableClass(serializable=true, deserializable=false)";
                    case 10:
                        return "@com.bandlab.annotations.SerializableClass(serializable=false, deserializable=true)";
                    case 11:
                        return "@com.bandlab.annotations.SerializableClass(serializable=false, deserializable=true)";
                    case 12:
                        return "@com.bandlab.annotations.SerializableClass(serializable=false, deserializable=true)";
                    case 13:
                        return "@com.bandlab.annotations.SerializableClass(serializable=false, deserializable=true)";
                    case 14:
                        return "@com.bandlab.annotations.SerializableClass(serializable=true, deserializable=true)";
                    case 15:
                        return "@com.bandlab.annotations.SerializableClass(serializable=false, deserializable=true)";
                    case 16:
                        return "@com.bandlab.annotations.SerializableClass(serializable=true, deserializable=true)";
                    case 17:
                        return "@com.bandlab.annotations.SerializableClass(serializable=false, deserializable=true)";
                    case 18:
                        return "@com.bandlab.annotations.SerializableClass(serializable=true, deserializable=true)";
                    case 19:
                        return "@com.bandlab.annotations.SerializableClass(serializable=false, deserializable=true)";
                    case 20:
                        return "@com.bandlab.annotations.SerializableClass(serializable=false, deserializable=true)";
                    case 21:
                        return "@com.bandlab.annotations.SerializableClass(serializable=true, deserializable=false)";
                    case 22:
                        return "@com.bandlab.annotations.SerializableClass(serializable=true, deserializable=true)";
                    case 23:
                        return "@com.bandlab.annotations.SerializableClass(serializable=false, deserializable=true)";
                    case 24:
                        return "@com.bandlab.annotations.SerializableClass(serializable=false, deserializable=true)";
                    case 25:
                        return "@com.bandlab.annotations.SerializableClass(serializable=true, deserializable=false)";
                    case 26:
                        return "@com.bandlab.annotations.SerializableClass(serializable=true, deserializable=true)";
                    case 27:
                        return "@com.bandlab.annotations.SerializableClass(serializable=true, deserializable=true)";
                    case 28:
                        return "@com.bandlab.annotations.SerializableClass(serializable=true, deserializable=true)";
                    default:
                        return "@com.bandlab.annotations.SerializableClass(serializable=true, deserializable=false)";
                }
            }
        });
        descriptor = l1Var;
    }

    public final wy1.a[] childSerializers() {
        lx1.h[] hVarArr = c.h;
        wy1.a aVar = y1.a;
        return new wy1.a[]{aVar, by1.b.D(aVar), by1.b.D(aVar), by1.b.D(h0.a), by1.b.D(p0.a), by1.b.D((wy1.a) hVarArr[5].getValue()), by1.b.D(g.a)};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(d dVar) throws UnknownFieldException {
        h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        lx1.h[] hVarArr = c.h;
        int i = 0;
        String strA = null;
        String str = null;
        String str2 = null;
        j0 j0Var = null;
        Integer num = null;
        List list = null;
        Boolean bool = null;
        boolean z = true;
        while (z) {
            int iC = bVarA.C(hVar);
            switch (iC) {
                case -1:
                    z = false;
                    break;
                case 0:
                    strA = bVarA.A(hVar, 0);
                    i |= 1;
                    break;
                case 1:
                    str = (String) bVarA.E(hVar, 1, y1.a, str);
                    i |= 2;
                    break;
                case 2:
                    str2 = (String) bVarA.E(hVar, 2, y1.a, str2);
                    i |= 4;
                    break;
                case 3:
                    j0Var = (j0) bVarA.E(hVar, 3, h0.a, j0Var);
                    i |= 8;
                    break;
                case 4:
                    num = (Integer) bVarA.E(hVar, 4, p0.a, num);
                    i |= 16;
                    break;
                case 5:
                    list = (List) bVarA.E(hVar, 5, (wy1.a) hVarArr[5].getValue(), list);
                    i |= 32;
                    break;
                case 6:
                    bool = (Boolean) bVarA.E(hVar, 6, g.a, bool);
                    i |= 64;
                    break;
                default:
                    throw new UnknownFieldException(iC);
            }
        }
        bVarA.b(hVar);
        return new c(i, strA, str, str2, j0Var, num, list, bool);
    }

    public final h getDescriptor() {
        return descriptor;
    }

    public final void serialize(e eVar, Object obj) {
        c cVar = (c) obj;
        o.h(cVar, "value");
        h hVar = descriptor;
        m mVarA = eVar.a(hVar);
        lx1.h[] hVarArr = c.h;
        m mVar = mVarA;
        mVar.d0(hVar, 0, cVar.a);
        y1 y1Var = y1.a;
        mVar.p(hVar, 1, y1Var, cVar.b);
        mVar.p(hVar, 2, y1Var, cVar.c);
        mVar.p(hVar, 3, h0.a, cVar.d);
        mVar.p(hVar, 4, p0.a, cVar.e);
        mVar.p(hVar, 5, (wy1.a) hVarArr[5].getValue(), cVar.f134f);
        mVar.p(hVar, 6, g.a, cVar.g);
        mVarA.b(hVar);
    }
}
