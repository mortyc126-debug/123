package w8;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public interface l1 {
    static boolean a(int i, boolean z) {
        int i2 = i & 7;
        if (i2 != 4) {
            return z && i2 == 3;
        }
        return true;
    }

    static int b(int i, int i2, int i3, int i4) {
        return i | i2 | i3 | 128 | i4;
    }

    void clearListener();

    String getName();

    int getTrackType();

    void setListener(k1 k1Var);

    int supportsFormat(l8.s sVar);

    int supportsMixedMimeTypeAdaptation();
}
