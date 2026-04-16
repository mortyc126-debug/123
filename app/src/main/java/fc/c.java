package fc;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public interface c extends AutoCloseable {
    byte[] getBlob(int i);

    int getColumnCount();

    String getColumnName(int i);

    long getLong(int i);

    boolean isNull(int i);

    void l(int i, long j2);

    void m(int i, byte[] bArr);

    String m0(int i);

    void n(int i);

    void reset();

    void w(int i, String str);

    boolean w0();
}
