package tlydtdl.compose.runtime;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public interface d1 extends e1, f3 {
    @Override // tlydtdl.compose.runtime.f3
    default Object getValue() {
        return Float.valueOf(((j1) this).h());
    }

    @Override // tlydtdl.compose.runtime.e1
    default void setValue(Object obj) {
        ((j1) this).i(((Number) obj).floatValue());
    }
}
