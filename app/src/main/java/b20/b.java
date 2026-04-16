package b20;

import bb.w;
import com.bandlab.bandlab.utils.debug.DebugUtils;
import com.bandlab.bandlab.utils.debug.TaggedException;
import hy1.q;
import hy1.x;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public final String a(String str) {
        if (str == null || q.L0(str)) {
            w wVar = new w(2);
            ArrayList arrayList = wVar.a;
            wVar.a("CRITICAL");
            wVar.e(new String[0]);
            String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            DebugUtils.handleThrowable(new TaggedException(new IllegalStateException("Path should not be empty"), (String[]) Arrays.copyOf(strArr, strArr.length)));
            return "https://www.bandlab.com";
        }
        StringBuilder sb = new StringBuilder("https://www.bandlab.com");
        if (x.u0(str, "/", false)) {
            String strConcat = "Path should not start with /, path: ".concat(str);
            w wVar2 = new w(2);
            ArrayList arrayList2 = wVar2.a;
            wVar2.a("CRITICAL");
            wVar2.e(new String[0]);
            String[] strArr2 = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
            DebugUtils.handleThrowable(new TaggedException(new IllegalStateException(strConcat), (String[]) Arrays.copyOf(strArr2, strArr2.length)));
        } else {
            sb.append("/");
        }
        sb.append(str);
        return sb.toString();
    }
}
