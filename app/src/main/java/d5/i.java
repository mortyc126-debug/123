package d5;

import java.util.ArrayList;
import java.util.List;
import okhttp3.HttpUrl;
import st.w0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {
    public static final g a = new g(HttpUrl.FRAGMENT_ENCODE_SET);

    public static final List a(g gVar, int i, int i2, com.bandlab.uikit.compose.bottomsheet.j0 j0Var) {
        List list;
        if (i == i2 || (list = gVar.a) == null) {
            return null;
        }
        if (i != 0 || i2 < gVar.b.length()) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                e eVar = (e) list.get(i3);
                if ((j0Var != null ? ((Boolean) j0Var.invoke(eVar.a)).booleanValue() : true) && b(i, i2, eVar.b, eVar.c)) {
                    arrayList.add(new e(eVar.d, w0.j(eVar.b, i, i2) - i, w0.j(eVar.c, i, i2) - i, (b) eVar.a));
                }
            }
            return arrayList;
        }
        if (j0Var == null) {
            return list;
        }
        ArrayList arrayList2 = new ArrayList(list.size());
        int size2 = list.size();
        for (int i4 = 0; i4 < size2; i4++) {
            Object obj = list.get(i4);
            if (((Boolean) j0Var.invoke(((e) obj).a)).booleanValue()) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    public static final boolean b(int i, int i2, int i3, int i4) {
        return ((i < i4) & (i3 < i2)) | (((i == i2) | (i3 == i4)) & (i == i3));
    }
}
