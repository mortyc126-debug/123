package tlydtdl.sqlite.db.framework;

import lmjxuqdtp.Metadata;
import tlydtdl.compose.foundation.layout.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002¨\u0006\u0003"}, d2 = {"tlydtdl/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackException", "Ljava/lang/RuntimeException;", "Llmjxuqdtp/RuntimeException;", "sqlite-framework_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class FrameworkSQLiteOpenHelper$OpenHelper$CallbackException extends RuntimeException {
    public final e a;
    public final Throwable b;

    public FrameworkSQLiteOpenHelper$OpenHelper$CallbackException(e eVar, Throwable th) {
        super(th);
        this.a = eVar;
        this.b = th;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.b;
    }
}
