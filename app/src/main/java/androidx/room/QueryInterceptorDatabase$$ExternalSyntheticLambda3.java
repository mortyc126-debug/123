/*
 * Decompiled with CFR 0.152.
 */
package androidx.room;

import androidx.room.QueryInterceptorDatabase;
import androidx.room.QueryInterceptorProgram;
import androidx.sqlite.db.SupportSQLiteQuery;

public final class QueryInterceptorDatabase$$ExternalSyntheticLambda3
implements Runnable {
    public final QueryInterceptorDatabase f$0;
    public final SupportSQLiteQuery f$1;
    public final QueryInterceptorProgram f$2;

    public /* synthetic */ QueryInterceptorDatabase$$ExternalSyntheticLambda3(QueryInterceptorDatabase queryInterceptorDatabase, SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        this.f$0 = queryInterceptorDatabase;
        this.f$1 = supportSQLiteQuery;
        this.f$2 = queryInterceptorProgram;
    }

    @Override
    public final void run() {
        QueryInterceptorDatabase.$r8$lambda$rBUkojwUw7EIsqAZ40YXCOpJQkc(this.f$0, this.f$1, this.f$2);
    }
}

