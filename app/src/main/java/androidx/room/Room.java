/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 */
package androidx.room;

import android.content.Context;
import androidx.room.RoomDatabase;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J8\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\b\b\u0000\u0010\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\t0\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0007J/\u0010\u0010\u001a\u0002H\t\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\u00112\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00110\u000e2\u0006\u0010\u0012\u001a\u00020\u0004H\u0007\u00a2\u0006\u0002\u0010\u0013J.\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\b\b\u0000\u0010\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\t0\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Landroidx/room/Room;", "", "()V", "CURSOR_CONV_SUFFIX", "", "LOG_TAG", "MASTER_TABLE_NAME", "databaseBuilder", "Landroidx/room/RoomDatabase$Builder;", "T", "Landroidx/room/RoomDatabase;", "context", "Landroid/content/Context;", "klass", "Ljava/lang/Class;", "name", "getGeneratedImplementation", "C", "suffix", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "inMemoryDatabaseBuilder", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
public final class Room {
    private static final String CURSOR_CONV_SUFFIX = "_CursorConverter";
    public static final Room INSTANCE = new Room();
    public static final String LOG_TAG = "ROOM";
    public static final String MASTER_TABLE_NAME = "room_master_table";

    private Room() {
    }

    @JvmStatic
    public static final <T extends RoomDatabase> RoomDatabase.Builder<T> databaseBuilder(Context context, Class<T> clazz, String string2) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter(clazz, (String)"klass");
        CharSequence charSequence = string2;
        boolean bl = charSequence == null || StringsKt.isBlank((CharSequence)charSequence);
        if (bl ^ true) {
            return new RoomDatabase.Builder<T>(context, clazz, string2);
        }
        throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder".toString());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @JvmStatic
    public static final <T, C> T getGeneratedImplementation(Class<C> clazz, String object) {
        Intrinsics.checkNotNullParameter(clazz, (String)"klass");
        Intrinsics.checkNotNullParameter((Object)object, (String)"suffix");
        Object object2 = clazz.getPackage();
        Intrinsics.checkNotNull((Object)object2);
        String string2 = ((Package)object2).getName();
        object2 = clazz.getCanonicalName();
        Intrinsics.checkNotNull((Object)object2);
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"fullPackage");
        int n = ((CharSequence)string2).length();
        int n2 = 0;
        n = n == 0 ? 1 : 0;
        if (n == 0) {
            object2 = ((String)object2).substring(string2.length() + 1);
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"this as java.lang.String).substring(startIndex)");
        }
        object2 = StringsKt.replace$default((String)object2, (char)'.', (char)'_', (boolean)false, (int)4, null) + (String)object;
        n = n2;
        try {
            if (((CharSequence)string2).length() == 0) {
                n = 1;
            }
            if (n != 0) {
                object = object2;
            } else {
                object = new StringBuilder();
                object = ((StringBuilder)object).append(string2).append('.').append((String)object2).toString();
            }
            object = Class.forName((String)object, true, clazz.getClassLoader());
            Intrinsics.checkNotNull(object, (String)"null cannot be cast to non-null type java.lang.Class<T of androidx.room.Room.getGeneratedImplementation>");
            object = ((Class)object).newInstance();
            return (T)object;
        }
        catch (InstantiationException instantiationException) {
            throw new RuntimeException("Failed to create an instance of " + clazz + ".canonicalName");
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException("Cannot access the constructor " + clazz + ".canonicalName");
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new RuntimeException("Cannot find implementation for " + clazz.getCanonicalName() + ". " + (String)object2 + " does not exist");
        }
    }

    @JvmStatic
    public static final <T extends RoomDatabase> RoomDatabase.Builder<T> inMemoryDatabaseBuilder(Context context, Class<T> clazz) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter(clazz, (String)"klass");
        return new RoomDatabase.Builder<T>(context, clazz, null);
    }
}

