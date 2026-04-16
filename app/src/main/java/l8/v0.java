package l8;

import amuvvoafs.os.Bundle;
import amuvvoafs.util.SparseBooleanArray;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class v0 {
    public static final v0 b;
    public static final String c;
    public final q a;

    static {
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        o8.b.h(!false);
        b = new v0(new q(sparseBooleanArray));
        int i = o8.f0.a;
        c = Integer.toString(0, 36);
    }

    public v0(q qVar) {
        this.a = qVar;
    }

    public static v0 b(Bundle bundle) {
        ArrayList integerArrayList = bundle.getIntegerArrayList(c);
        if (integerArrayList == null) {
            return b;
        }
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        for (int i = 0; i < integerArrayList.size(); i++) {
            int iIntValue = ((Integer) integerArrayList.get(i)).intValue();
            o8.b.h(!false);
            sparseBooleanArray.append(iIntValue, true);
        }
        o8.b.h(!false);
        return new v0(new q(sparseBooleanArray));
    }

    public final boolean a(int i) {
        return this.a.a.get(i);
    }

    public final Bundle c() {
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            q qVar = this.a;
            if (i >= qVar.a.size()) {
                bundle.putIntegerArrayList(c, arrayList);
                return bundle;
            }
            arrayList.add(Integer.valueOf(qVar.b(i)));
            i++;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof v0) {
            return this.a.equals(((v0) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
