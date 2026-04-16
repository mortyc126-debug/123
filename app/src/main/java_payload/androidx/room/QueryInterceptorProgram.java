/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J\u001a\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0002R\u001c\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0019"}, d2={"Landroidx/room/QueryInterceptorProgram;", "Landroidx/sqlite/db/SupportSQLiteProgram;", "()V", "bindArgsCache", "", "", "getBindArgsCache$room_runtime_release", "()Ljava/util/List;", "bindBlob", "", "index", "", "value", "", "bindDouble", "", "bindLong", "", "bindNull", "bindString", "", "clearBindings", "close", "saveArgsToCache", "bindIndex", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
public final class QueryInterceptorProgram
implements SupportSQLiteProgram {
    private final List<Object> bindArgsCache = new ArrayList();

    private final void saveArgsToCache(int n, Object object) {
        int n2 = n - 1;
        if (n2 >= this.bindArgsCache.size() && (n = this.bindArgsCache.size()) <= n2) {
            while (true) {
                this.bindArgsCache.add(null);
                if (n == n2) break;
                ++n;
            }
        }
        this.bindArgsCache.set(n2, object);
    }

    @Override
    public void bindBlob(int n, byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"value");
        this.saveArgsToCache(n, byArray);
    }

    @Override
    public void bindDouble(int n, double d) {
        this.saveArgsToCache(n, d);
    }

    @Override
    public void bindLong(int n, long l) {
        this.saveArgsToCache(n, l);
    }

    @Override
    public void bindNull(int n) {
        this.saveArgsToCache(n, null);
    }

    @Override
    public void bindString(int n, String string2) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"value");
        this.saveArgsToCache(n, string2);
    }

    @Override
    public void clearBindings() {
        this.bindArgsCache.clear();
    }

    @Override
    public void close() {
    }

    public final List<Object> getBindArgsCache$room_runtime_release() {
        return this.bindArgsCache;
    }
}

