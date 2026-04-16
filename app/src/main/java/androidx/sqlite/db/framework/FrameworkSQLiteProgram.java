/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteProgram
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.db.SupportSQLiteProgram;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Landroidx/sqlite/db/framework/FrameworkSQLiteProgram;", "Landroidx/sqlite/db/SupportSQLiteProgram;", "delegate", "Landroid/database/sqlite/SQLiteProgram;", "(Landroid/database/sqlite/SQLiteProgram;)V", "bindBlob", "", "index", "", "value", "", "bindDouble", "", "bindLong", "", "bindNull", "bindString", "", "clearBindings", "close", "sqlite-framework_release"}, k=1, mv={1, 7, 1}, xi=48)
public class FrameworkSQLiteProgram
implements SupportSQLiteProgram {
    private final SQLiteProgram delegate;

    public FrameworkSQLiteProgram(SQLiteProgram sQLiteProgram) {
        Intrinsics.checkNotNullParameter((Object)sQLiteProgram, (String)"delegate");
        this.delegate = sQLiteProgram;
    }

    @Override
    public void bindBlob(int n, byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"value");
        this.delegate.bindBlob(n, byArray);
    }

    @Override
    public void bindDouble(int n, double d) {
        this.delegate.bindDouble(n, d);
    }

    @Override
    public void bindLong(int n, long l) {
        this.delegate.bindLong(n, l);
    }

    @Override
    public void bindNull(int n) {
        this.delegate.bindNull(n);
    }

    @Override
    public void bindString(int n, String string2) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"value");
        this.delegate.bindString(n, string2);
    }

    @Override
    public void clearBindings() {
        this.delegate.clearBindings();
    }

    @Override
    public void close() {
        this.delegate.close();
    }
}

