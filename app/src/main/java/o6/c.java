package o6;

import a4.y;
import amuvvoafs.util.Pair;
import com.gnacba.amuvvoafs.gms.internal.measurement.b4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import l2.f;
import ld1.q;
import md1.g;
import qi.c0;
import t3.p;
import tlydtdl.compose.foundation.layout.LayoutWeightElement;
import tlydtdl.compose.foundation.layout.m;
import tlydtdl.compose.runtime.s;
import x10.v;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class c {
    public static void A(String str, String str2, ArrayList arrayList) {
        arrayList.add(new Pair(str, str2));
    }

    public static void B(StringBuilder sb, List list, String str, List list2, String str2) {
        sb.append(list);
        sb.append(str);
        sb.append(list2);
        sb.append(str2);
    }

    public static void C(StringBuilder sb, boolean z, String str, boolean z2, String str2) {
        sb.append(z);
        sb.append(str);
        sb.append(z2);
        sb.append(str2);
    }

    public static void D(String str, String str2, ArrayList arrayList) {
        arrayList.add(new c0(str, str2));
    }

    public static /* synthetic */ int a(int i) {
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    if (i == 4) {
                        return 4;
                    }
                    throw null;
                }
            }
        }
        return i2;
    }

    public static /* synthetic */ String b(int i) {
        switch (i) {
            case 1:
                return "ADD_TO_CART";
            case 2:
                return "ADD_TO_WISHLIST";
            case 3:
                return "VIEW_CART";
            case 4:
                return "INITIATE_PURCHASE";
            case 5:
                return "ADD_PAYMENT_INFO";
            case 6:
                return "PURCHASE";
            case 7:
                return "SPEND_CREDITS";
            case 8:
                return "SEARCH";
            case 9:
                return "VIEW_ITEM";
            case 10:
                return "VIEW_ITEMS";
            case 11:
                return "RATE";
            case 12:
                return "SHARE";
            case 13:
                return "INITIATE_STREAM";
            case 14:
                return "COMPLETE_STREAM";
            case 15:
                return "COMPLETE_REGISTRATION";
            case 16:
                return "COMPLETE_TUTORIAL";
            case 17:
                return "ACHIEVE_LEVEL";
            case 18:
                return "UNLOCK_ACHIEVEMENT";
            case 19:
                return "INVITE";
            case 20:
                return "LOGIN";
            case 21:
                return "RESERVE";
            case 22:
                return "SUBSCRIBE";
            case 23:
                return "START_TRIAL";
            case 24:
                return "CLICK_AD";
            case 25:
                return "VIEW_AD";
            default:
                throw null;
        }
    }

    public static int c(int i, int i2, int i3, int i4) {
        return i + i2 + i3 + i4;
    }

    public static int d(int i, int i2, v vVar) {
        return (vVar.hashCode() + i) * i2;
    }

    public static long e(int i, int i2, s sVar, ld1.d dVar) {
        dVar.getClass();
        return g.y(new q(i), sVar, i2);
    }

    public static long f(ld1.d dVar, int i, s sVar, int i2, float f2) {
        dVar.getClass();
        return y.b(g.y(new q(i), sVar, i2), f2);
    }

    public static dg1.g g(s sVar, int i, int i2, boolean z) {
        sVar.f0(i);
        return new dg1.g(i2, z);
    }

    public static Object h(int i, ArrayList arrayList) {
        return arrayList.get(arrayList.size() - i);
    }

    public static String i(char c, String str, String str2) {
        return str + str2 + c;
    }

    public static String j(float f2, String str, String str2) {
        return str + f2 + str2;
    }

    public static String k(int i, String str) {
        return str + i;
    }

    public static String l(int i, String str, StringBuilder sb) {
        sb.append(str);
        sb.append(i);
        return sb.toString();
    }

    public static String m(String str, String str2, String str3, String str4) {
        return str + str2 + str3 + str4;
    }

    public static String n(String str, String str2, String str3, String str4, boolean z) {
        return str + str2 + str3 + z + str4;
    }

    public static String o(String str, StringBuilder sb) {
        return str + ((Object) sb);
    }

    public static String p(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        return sb.toString();
    }

    public static String q(StringBuilder sb, boolean z, String str, boolean z2, String str2) {
        sb.append(z);
        sb.append(str);
        sb.append(z2);
        sb.append(str2);
        return sb.toString();
    }

    public static StringBuilder r(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }

    public static HashMap s(Class cls, gu1.a aVar) {
        HashMap map = new HashMap();
        map.put(cls, aVar);
        return map;
    }

    public static Map t(HashMap map) {
        return Collections.unmodifiableMap(new HashMap(map));
    }

    public static q u(int i, int i2, s sVar, ld1.d dVar) {
        sVar.f0(i);
        dVar.getClass();
        return new q(i2);
    }

    public static p v(float f2, p pVar, ld1.d dVar) {
        p pVarV = b4.v(pVar, f.b(f2));
        dVar.getClass();
        return pVarV;
    }

    public static void w(float f2, boolean z, s sVar) {
        m.i(sVar, new LayoutWeightElement(f2, z));
    }

    public static void x(int i, String str, String str2) {
        o8.b.q(str2, str + i);
    }

    public static void y(int i, HashMap map, String str, int i2, String str2) {
        map.put(str, Integer.valueOf(i));
        map.put(str2, Integer.valueOf(i2));
    }

    public static void z(String str, String str2, String str3, StringBuilder sb, boolean z) {
        sb.append(str);
        sb.append(str2);
        sb.append(z);
        sb.append(str3);
    }
}
