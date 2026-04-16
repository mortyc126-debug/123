/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package androidx.sqlite.db;

import androidx.sqlite.db.SupportSQLiteProgram;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0005H&J\n\u0010\t\u001a\u0004\u0018\u00010\nH&\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u000b\u00c0\u0006\u0001"}, d2={"Landroidx/sqlite/db/SupportSQLiteStatement;", "Landroidx/sqlite/db/SupportSQLiteProgram;", "execute", "", "executeInsert", "", "executeUpdateDelete", "", "simpleQueryForLong", "simpleQueryForString", "", "sqlite_release"}, k=1, mv={1, 7, 1}, xi=48)
public interface SupportSQLiteStatement
extends SupportSQLiteProgram {
    public void execute();

    public long executeInsert();

    public int executeUpdateDelete();

    public long simpleQueryForLong();

    public String simpleQueryForString();
}

