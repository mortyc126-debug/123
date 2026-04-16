package d5;

import java.util.ArrayList;
import lmjxuqdtp.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s implements Function0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ av1.g b;

    public /* synthetic */ s(av1.g gVar, int i) {
        this.a = i;
        this.b = gVar;
    }

    public final Object invoke() {
        Object obj;
        Object obj2;
        switch (this.a) {
            case 0:
                ArrayList arrayList = (ArrayList) this.b.f;
                if (arrayList.isEmpty()) {
                    obj = null;
                } else {
                    Object obj3 = arrayList.get(0);
                    float fE = ((u) obj3).a.e();
                    int iZ = ct1.b.z(arrayList);
                    int i = 1;
                    if (1 <= iZ) {
                        while (true) {
                            Object obj4 = arrayList.get(i);
                            float fE2 = ((u) obj4).a.e();
                            if (Float.compare(fE, fE2) < 0) {
                                obj3 = obj4;
                                fE = fE2;
                            }
                            if (i != iZ) {
                                i++;
                            }
                        }
                    }
                    obj = obj3;
                }
                u uVar = (u) obj;
                return Float.valueOf(uVar != null ? uVar.a.e() : 0.0f);
            default:
                ArrayList arrayList2 = (ArrayList) this.b.f;
                if (arrayList2.isEmpty()) {
                    obj2 = null;
                } else {
                    Object obj5 = arrayList2.get(0);
                    float fC = ((u) obj5).a.i.c();
                    int iZ2 = ct1.b.z(arrayList2);
                    int i2 = 1;
                    if (1 <= iZ2) {
                        while (true) {
                            Object obj6 = arrayList2.get(i2);
                            float fC2 = ((u) obj6).a.i.c();
                            if (Float.compare(fC, fC2) < 0) {
                                obj5 = obj6;
                                fC = fC2;
                            }
                            if (i2 != iZ2) {
                                i2++;
                            }
                        }
                    }
                    obj2 = obj5;
                }
                u uVar2 = (u) obj2;
                return Float.valueOf(uVar2 != null ? uVar2.a.i.c() : 0.0f);
        }
    }
}
