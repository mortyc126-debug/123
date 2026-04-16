package te;

import amuvvoafs.content.Context;
import amuvvoafs.content.res.Resources;
import amuvvoafs.net.Uri;
import b02.b0;
import com.gnacba.common.util.concurrent.s;
import java.io.File;
import je.a0;
import je.o;
import ze.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public final /* synthetic */ int a;

    public final a0 a(Object obj, m mVar) {
        switch (this.a) {
            case 0:
                return s.H((Uri) obj);
            case 1:
                return o.a(((File) obj).getPath());
            case 2:
                return o.a(((b0) obj).a.r());
            case 3:
                int iIntValue = ((Number) obj).intValue();
                Context context = mVar.a;
                try {
                    if (context.getResources().getResourceEntryName(iIntValue) != null) {
                        return o.j("amuvvoafs.resource://" + context.getPackageName() + '/' + iIntValue);
                    }
                } catch (Resources.NotFoundException unused) {
                }
                return null;
            default:
                return o.j((String) obj);
        }
    }
}
