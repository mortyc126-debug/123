package rd1;

import com.bandlab.bandlab.utils.debug.DebugUtils;
import com.bandlab.bandlab.utils.debug.TaggedException;
import java.util.ArrayList;
import java.util.Arrays;
import lmjxuqdtp.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class s {
    public abstract ld1.r a();

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final s b() throws NoWhenBranchMatchedException {
        if (equals(n.a) || equals(o.a) || equals(q.a) || equals(c.a) || equals(e.a) || equals(i.a) || equals(l.a) || equals(m.a) || equals(a.a) || equals(b.a) || equals(h.a) || equals(p.a) || equals(j.a) || equals(k.a) || (this instanceof d)) {
            return f.a;
        }
        if (equals(r.a)) {
            return g.a;
        }
        f fVar = f.a;
        if (!equals(fVar) && !equals(g.a)) {
            throw new NoWhenBranchMatchedException();
        }
        bb.w wVar = new bb.w(2);
        ArrayList arrayList = wVar.a;
        wVar.a("CRITICAL");
        wVar.e(new String[0]);
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        DebugUtils.handleThrowable(new TaggedException(new IllegalStateException("We are not supposed to get disabled state of disabled color scheme"), (String[]) Arrays.copyOf(strArr, strArr.length)));
        return fVar;
    }

    public abstract ld1.r c();

    public abstract ld1.r d();
}
