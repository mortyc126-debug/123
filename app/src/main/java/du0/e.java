package du0;

import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public final f a;
    public final LinkedHashSet b;

    public e(f fVar, LinkedHashSet linkedHashSet) {
        this.a = fVar;
        this.b = linkedHashSet;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.a == eVar.a && this.b.equals(eVar.b);
    }

    public final int hashCode() {
        return Boolean.hashCode(true) + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "KeyboardLayoutState(selected=" + this.a + ", options=" + this.b + ", enabled=true)";
    }
}
