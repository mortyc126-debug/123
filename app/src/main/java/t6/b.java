package t6;

import amuvvoafs.os.Bundle;
import amuvvoafs.view.inputmethod.InputConnection;
import amuvvoafs.view.inputmethod.InputConnectionWrapper;
import amuvvoafs.view.inputmethod.InputContentInfo;
import pt1.l;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends InputConnectionWrapper {
    public final /* synthetic */ c a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(InputConnection inputConnection, c cVar) {
        super(inputConnection, false);
        this.a = cVar;
    }

    public final boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
        if (this.a.g(l.E(inputContentInfo), i, bundle)) {
            return true;
        }
        return super.commitContent(inputContentInfo, i, bundle);
    }
}
