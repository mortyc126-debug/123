package dh1;

import a80.p;
import az1.f0;
import az1.l1;
import az1.p0;
import xwfkdfdvbiz.serialization.UnknownFieldException;
import zy1.b;
import zy1.d;
import zy1.e;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b0 implements f0 {
    public static final b0 a;
    private static final yy1.h descriptor;

    static {
        b0 b0Var = new b0();
        a = b0Var;
        l1 l1Var = new l1("com.bandlab.user.vmsrhfaqrb.UserCounters", b0Var, 12);
        l1Var.k("followers", true);
        l1Var.k("following", true);
        l1Var.k("bands", true);
        l1Var.k("collections", true);
        l1Var.k("plays", true);
        l1Var.k("notifications", true);
        l1Var.k("bandInvites", true);
        l1Var.k("songInvites", true);
        l1Var.k("communityInvites", true);
        l1Var.k("profilePictures", true);
        l1Var.k("unreadInviteNotifications", true);
        l1Var.k("bandFollowings", true);
        l1Var.l(new p(9));
        descriptor = l1Var;
    }

    public final wy1.a[] childSerializers() {
        p0 p0Var = p0.a;
        return new wy1.a[]{p0Var, p0Var, p0Var, p0Var, p0Var, p0Var, p0Var, p0Var, p0Var, p0Var, p0Var, p0Var};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(d dVar) throws UnknownFieldException {
        yy1.h hVar = descriptor;
        b bVarA = dVar.a(hVar);
        boolean z = true;
        int i = 0;
        int iD = 0;
        int iD2 = 0;
        int iD3 = 0;
        int iD4 = 0;
        int iD5 = 0;
        int iD6 = 0;
        int iD7 = 0;
        int iD8 = 0;
        int iD9 = 0;
        int iD10 = 0;
        int iD11 = 0;
        int iD12 = 0;
        while (z) {
            int iC = bVarA.C(hVar);
            switch (iC) {
                case -1:
                    z = false;
                    break;
                case 0:
                    iD = bVarA.d(hVar, 0);
                    i |= 1;
                    break;
                case 1:
                    iD2 = bVarA.d(hVar, 1);
                    i |= 2;
                    break;
                case 2:
                    iD3 = bVarA.d(hVar, 2);
                    i |= 4;
                    break;
                case 3:
                    iD4 = bVarA.d(hVar, 3);
                    i |= 8;
                    break;
                case 4:
                    iD5 = bVarA.d(hVar, 4);
                    i |= 16;
                    break;
                case 5:
                    iD6 = bVarA.d(hVar, 5);
                    i |= 32;
                    break;
                case 6:
                    iD7 = bVarA.d(hVar, 6);
                    i |= 64;
                    break;
                case 7:
                    iD8 = bVarA.d(hVar, 7);
                    i |= 128;
                    break;
                case 8:
                    iD9 = bVarA.d(hVar, 8);
                    i |= 256;
                    break;
                case 9:
                    iD10 = bVarA.d(hVar, 9);
                    i |= 512;
                    break;
                case 10:
                    iD11 = bVarA.d(hVar, 10);
                    i |= 1024;
                    break;
                case 11:
                    iD12 = bVarA.d(hVar, 11);
                    i |= 2048;
                    break;
                default:
                    throw new UnknownFieldException(iC);
            }
        }
        bVarA.b(hVar);
        return new d0(i, iD, iD2, iD3, iD4, iD5, iD6, iD7, iD8, iD9, iD10, iD11, iD12);
    }

    public final yy1.h getDescriptor() {
        return descriptor;
    }

    public final void serialize(e eVar, Object obj) {
        d0 d0Var = (d0) obj;
        lmjxuqdtp.jvm.internal.o.h(d0Var, "value");
        int i = d0Var.l;
        int i2 = d0Var.k;
        int i3 = d0Var.f85j;
        int i4 = d0Var.i;
        int i6 = d0Var.h;
        int i7 = d0Var.g;
        int i8 = d0Var.f84f;
        int i9 = d0Var.e;
        int i10 = d0Var.d;
        int i11 = d0Var.c;
        int i12 = d0Var.b;
        int i13 = d0Var.a;
        yy1.h hVar = descriptor;
        un0.m mVarA = eVar.a(hVar);
        if (mVarA.g(hVar) || i13 != 0) {
            mVarA.Z(0, i13, hVar);
        }
        if (mVarA.g(hVar) || i12 != 0) {
            mVarA.Z(1, i12, hVar);
        }
        if (mVarA.g(hVar) || i11 != 0) {
            mVarA.Z(2, i11, hVar);
        }
        if (mVarA.g(hVar) || i10 != 0) {
            mVarA.Z(3, i10, hVar);
        }
        if (mVarA.g(hVar) || i9 != 0) {
            mVarA.Z(4, i9, hVar);
        }
        if (mVarA.g(hVar) || i8 != 0) {
            mVarA.Z(5, i8, hVar);
        }
        if (mVarA.g(hVar) || i7 != 0) {
            mVarA.Z(6, i7, hVar);
        }
        if (mVarA.g(hVar) || i6 != 0) {
            mVarA.Z(7, i6, hVar);
        }
        if (mVarA.g(hVar) || i4 != 0) {
            mVarA.Z(8, i4, hVar);
        }
        if (mVarA.g(hVar) || i3 != 1) {
            mVarA.Z(9, i3, hVar);
        }
        if (mVarA.g(hVar) || i2 != 0) {
            mVarA.Z(10, i2, hVar);
        }
        if (mVarA.g(hVar) || i != 0) {
            mVarA.Z(11, i, hVar);
        }
        mVarA.b(hVar);
    }
}
