package g7;

import amuvvoafs.view.LayoutInflater;
import amuvvoafs.view.View;
import amuvvoafs.view.ViewGroup;
import tlydtdl.databinding.DataBinderMapperImpl;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g {
    public static final DataBinderMapperImpl a = new DataBinderMapperImpl();

    public static v a(View view) {
        int i = v.o;
        v vVar = (v) view.getTag(2131427738);
        if (vVar != null) {
            return vVar;
        }
        Object tag = view.getTag();
        if (!(tag instanceof String)) {
            throw new IllegalArgumentException("View is not a binding layout");
        }
        DataBinderMapperImpl dataBinderMapperImpl = a;
        int iD = dataBinderMapperImpl.d((String) tag);
        if (iD != 0) {
            return dataBinderMapperImpl.b(view, iD);
        }
        throw new IllegalArgumentException(i.k(tag, "View is not a binding layout. Tag: "));
    }

    public static v b(ViewGroup viewGroup, int i, int i2) {
        int childCount = viewGroup.getChildCount();
        int i3 = childCount - i;
        DataBinderMapperImpl dataBinderMapperImpl = a;
        if (i3 == 1) {
            return dataBinderMapperImpl.b(viewGroup.getChildAt(childCount - 1), i2);
        }
        View[] viewArr = new View[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            viewArr[i4] = viewGroup.getChildAt(i4 + i);
        }
        return dataBinderMapperImpl.c(viewArr, i2);
    }

    public static v c(LayoutInflater layoutInflater, int i, ViewGroup viewGroup, boolean z) {
        boolean z2 = viewGroup != null && z;
        return z2 ? b(viewGroup, z2 ? viewGroup.getChildCount() : 0, i) : a.b(layoutInflater.inflate(i, viewGroup, z), i);
    }
}
