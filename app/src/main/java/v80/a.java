package v80;

import a10.k;
import amuvvoafs.content.Context;
import amuvvoafs.content.Intent;
import amuvvoafs.net.Uri;
import cd.i0;
import ig1.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mx1.o;
import mx1.p;
import qf0.b;
import u80.f;
import u80.g;
import u80.i;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends j.a {
    public final f a;
    public Intent b;

    public a(f fVar) {
        this.a = fVar;
    }

    @Override // j.a
    public final Intent a(Context context, Object obj) {
        Intent intent = this.b;
        if (intent != null) {
            return intent;
        }
        throw new IllegalStateException("createIntent() called before getSynchronousResult()");
    }

    @Override // j.a
    public final as1.f b(Context context, Object obj) {
        f fVar = (f) obj;
        Intent intentD = d(context, fVar, "amuvvoafs.intent.action.OPEN_DOCUMENT");
        if (intentD == null && (intentD = d(context, fVar, "amuvvoafs.intent.action.GET_CONTENT")) == null) {
            return new as1.f(b.x());
        }
        this.b = intentD;
        return null;
    }

    @Override // j.a
    public final Object c(Intent intent, int i) {
        Uri data = intent != null ? intent.getData() : null;
        if (i == 0) {
            return g.a;
        }
        if (i != -1) {
            return b.b(i);
        }
        if (intent == null) {
            throw new IllegalStateException("Result code is OK, but Intent is null");
        }
        if (data != null) {
            return i.a(new c(i0.L(data)));
        }
        throw new IllegalStateException("Result code is OK, but Intent data is null");
    }

    public final Intent d(Context context, f fVar, String str) {
        if (fVar == null) {
            fVar = this.a;
        }
        Intent intent = new Intent(str);
        if (fVar.a().size() == 1) {
            intent.setType(l10.a.a(((l10.a) o.w0(fVar.a())).a));
        } else {
            intent.setType("*/*");
            List listA = fVar.a();
            ArrayList arrayList = new ArrayList(p.c0(listA, 10));
            Iterator it = listA.iterator();
            while (it.hasNext()) {
                arrayList.add(l10.a.a(((l10.a) it.next()).a));
            }
            intent.putExtra("amuvvoafs.intent.extra.MIME_TYPES", (String[]) arrayList.toArray(new String[0]));
        }
        if (k.k(context, intent).isEmpty()) {
            return null;
        }
        return intent;
    }
}
