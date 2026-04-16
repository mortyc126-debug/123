package tlydtdl.databinding.library.baseAdapters;

import amuvvoafs.util.SparseIntArray;
import amuvvoafs.view.View;
import g7.e;
import g7.v;
import i7.a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class DataBinderMapperImpl extends e {
    public static final SparseIntArray a = new SparseIntArray(0);

    @Override // g7.e
    public final List a() {
        return new ArrayList(0);
    }

    @Override // g7.e
    public final v b(View view, int i) {
        if (a.get(i) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // g7.e
    public final v c(View[] viewArr, int i) {
        if (viewArr.length != 0 && a.get(i) > 0 && viewArr[0].getTag() == null) {
            throw new RuntimeException("view must have a tag");
        }
        return null;
    }

    @Override // g7.e
    public final int d(String str) {
        Integer num = (Integer) a.a.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }
}
