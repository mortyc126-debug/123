/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.room;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\u0012H$J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0017"}, d2={"Landroidx/room/SharedSQLiteStatement;", "", "database", "Landroidx/room/RoomDatabase;", "(Landroidx/room/RoomDatabase;)V", "lock", "Ljava/util/concurrent/atomic/AtomicBoolean;", "stmt", "Landroidx/sqlite/db/SupportSQLiteStatement;", "getStmt", "()Landroidx/sqlite/db/SupportSQLiteStatement;", "stmt$delegate", "Lkotlin/Lazy;", "acquire", "assertNotMainThread", "", "createNewStatement", "createQuery", "", "canUseCached", "", "release", "statement", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
public abstract class SharedSQLiteStatement {
    private final RoomDatabase database;
    private final AtomicBoolean lock;
    private final Lazy stmt$delegate;

    public SharedSQLiteStatement(RoomDatabase roomDatabase) {
        Intrinsics.checkNotNullParameter((Object)roomDatabase, (String)"database");
        this.database = roomDatabase;
        this.lock = new AtomicBoolean(false);
        this.stmt$delegate = LazyKt.lazy((Function0)((Function0)new Function0<SupportSQLiteStatement>(this){
            final SharedSQLiteStatement this$0;
            {
                this.this$0 = sharedSQLiteStatement;
                super(0);
            }

            public final SupportSQLiteStatement invoke() {
                return SharedSQLiteStatement.access$createNewStatement(this.this$0);
            }
        }));
    }

    public static final /* synthetic */ SupportSQLiteStatement access$createNewStatement(SharedSQLiteStatement sharedSQLiteStatement) {
        return sharedSQLiteStatement.createNewStatement();
    }

    private final SupportSQLiteStatement createNewStatement() {
        String string2 = this.createQuery();
        return this.database.compileStatement(string2);
    }

    private final SupportSQLiteStatement getStmt() {
        return (SupportSQLiteStatement)this.stmt$delegate.getValue();
    }

    private final SupportSQLiteStatement getStmt(boolean bl) {
        SupportSQLiteStatement supportSQLiteStatement = bl ? this.getStmt() : this.createNewStatement();
        return supportSQLiteStatement;
    }

    public SupportSQLiteStatement acquire() {
        this.assertNotMainThread();
        return this.getStmt(this.lock.compareAndSet(false, true));
    }

    protected void assertNotMainThread() {
        this.database.assertNotMainThread();
    }

    protected abstract String createQuery();

    public void release(SupportSQLiteStatement supportSQLiteStatement) {
        Intrinsics.checkNotNullParameter((Object)supportSQLiteStatement, (String)"statement");
        if (supportSQLiteStatement == this.getStmt()) {
            this.lock.set(false);
        }
    }
}

