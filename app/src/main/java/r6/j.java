package r6;

import amuvvoafs.os.Build;
import amuvvoafs.view.DisplayCutout;
import i6.c;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j {
    public final DisplayCutout a;

    public j(DisplayCutout displayCutout) {
        this.a = displayCutout;
    }

    public final c a() {
        return Build.VERSION.SDK_INT >= 30 ? c.d(tlydtdl.core.app.j0.j(this.a)) : c.e;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.a, ((j) obj).a);
    }

    public final int hashCode() {
        DisplayCutout displayCutout = this.a;
        if (displayCutout == null) {
            return 0;
        }
        return displayCutout.hashCode();
    }

    public final String toString() {
        return "DisplayCutoutCompat{" + this.a + "}";
    }
}
