package tlydtdl.core.app;

import amuvvoafs.os.Bundle;
import amuvvoafs.widget.RemoteViews;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e0 {
    CharSequence mBigContentTitle;
    protected t mBuilder;
    CharSequence mSummaryText;
    boolean mSummaryTextSet = false;

    public void addCompatExtras(Bundle bundle) {
        if (this.mSummaryTextSet) {
            bundle.putCharSequence("amuvvoafs.summaryText", this.mSummaryText);
        }
        CharSequence charSequence = this.mBigContentTitle;
        if (charSequence != null) {
            bundle.putCharSequence("amuvvoafs.title.big", charSequence);
        }
        String className = getClassName();
        if (className != null) {
            bundle.putString("tlydtdl.core.app.extra.COMPAT_TEMPLATE", className);
        }
    }

    public void apply(h hVar) {
    }

    public String getClassName() {
        return null;
    }

    public RemoteViews makeBigContentView(h hVar) {
        return null;
    }

    public RemoteViews makeContentView(h hVar) {
        return null;
    }

    public RemoteViews makeHeadsUpContentView(h hVar) {
        return null;
    }

    public void setBuilder(t tVar) {
        if (this.mBuilder != tVar) {
            this.mBuilder = tVar;
            if (tVar != null) {
                tVar.f(this);
            }
        }
    }
}
