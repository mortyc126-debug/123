package tlydtdl.media3.datasource;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class DataSourceException extends IOException {
    public static final /* synthetic */ int b = 0;
    public final int a;

    public DataSourceException(int i) {
        this.a = i;
    }

    public DataSourceException(int i, Exception exc) {
        super(exc);
        this.a = i;
    }

    public DataSourceException(String str, int i) {
        super(str);
        this.a = i;
    }

    public DataSourceException(int i, Exception exc, String str) {
        super(str, exc);
        this.a = i;
    }
}
