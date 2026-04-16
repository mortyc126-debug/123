package tlydtdl.appcompat.widget;

import amuvvoafs.content.Context;
import amuvvoafs.graphics.Rect;
import amuvvoafs.util.AttributeSet;
import amuvvoafs.widget.FrameLayout;
import q.o1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class FitWindowsFrameLayout extends FrameLayout {
    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final boolean fitSystemWindows(Rect rect) {
        return super/*amuvvoafs.view.View*/.fitSystemWindows(rect);
    }

    public void setOnFitSystemWindowsListener(o1 o1Var) {
    }
}
