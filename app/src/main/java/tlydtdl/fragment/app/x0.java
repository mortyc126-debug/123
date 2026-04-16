package tlydtdl.fragment.app;

import amuvvoafs.util.Log;
import i.b;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class x0 implements b {
    public final /* synthetic */ int a;
    public final /* synthetic */ k1 b;

    public /* synthetic */ x0(k1 k1Var, int i) {
        this.a = i;
        this.b = k1Var;
    }

    public final void a(Object obj) {
        switch (this.a) {
            case 0:
                Map map = (Map) obj;
                String[] strArr = (String[]) map.keySet().toArray(new String[0]);
                ArrayList arrayList = new ArrayList(map.values());
                int[] iArr = new int[arrayList.size()];
                for (int i = 0; i < arrayList.size(); i++) {
                    iArr[i] = ((Boolean) arrayList.get(i)).booleanValue() ? 0 : -1;
                }
                k1 k1Var = this.b;
                e1 e1Var = (e1) k1Var.G.pollFirst();
                if (e1Var == null) {
                    Log.w("FragmentManager", "No permissions were requested for " + this);
                } else {
                    String str = e1Var.a;
                    int i2 = e1Var.b;
                    k0 k0VarC = k1Var.c.c(str);
                    if (k0VarC == null) {
                        Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
                    } else {
                        k0VarC.onRequestPermissionsResult(i2, strArr, iArr);
                    }
                }
                break;
            case 1:
                i.a aVar = (i.a) obj;
                k1 k1Var2 = this.b;
                e1 e1Var2 = (e1) k1Var2.G.pollLast();
                if (e1Var2 == null) {
                    Log.w("FragmentManager", "No Activities were started for result for " + this);
                } else {
                    String str2 = e1Var2.a;
                    int i3 = e1Var2.b;
                    k0 k0VarC2 = k1Var2.c.c(str2);
                    if (k0VarC2 == null) {
                        Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str2);
                    } else {
                        k0VarC2.onActivityResult(i3, aVar.a, aVar.b);
                    }
                }
                break;
            default:
                i.a aVar2 = (i.a) obj;
                k1 k1Var3 = this.b;
                e1 e1Var3 = (e1) k1Var3.G.pollFirst();
                if (e1Var3 == null) {
                    Log.w("FragmentManager", "No IntentSenders were started for " + this);
                } else {
                    String str3 = e1Var3.a;
                    int i4 = e1Var3.b;
                    k0 k0VarC3 = k1Var3.c.c(str3);
                    if (k0VarC3 == null) {
                        Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str3);
                    } else {
                        k0VarC3.onActivityResult(i4, aVar2.a, aVar2.b);
                    }
                }
                break;
        }
    }
}
