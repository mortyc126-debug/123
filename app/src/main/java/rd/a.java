package rd;

import amuvvoafs.database.Cursor;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public final Cursor a;

    public a(Cursor cursor) {
        o.h(cursor, "cursor");
        this.a = cursor;
    }

    public final Boolean a(int i) {
        Cursor cursor = this.a;
        if (cursor.isNull(i)) {
            return null;
        }
        return Boolean.valueOf(cursor.getLong(i) == 1);
    }

    public final Long b(int i) {
        Cursor cursor = this.a;
        if (cursor.isNull(i)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i));
    }

    public final String c(int i) {
        Cursor cursor = this.a;
        if (cursor.isNull(i)) {
            return null;
        }
        return cursor.getString(i);
    }

    public final qd.d d() {
        return new qd.d(Boolean.valueOf(this.a.moveToNext()));
    }
}
