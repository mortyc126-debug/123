/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  android.database.CursorWrapper
 *  android.database.MatrixCursor
 *  android.os.Build$VERSION
 *  android.util.Log
 *  kotlin.Metadata
 *  kotlin.collections.ArraysKt
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 */
package androidx.room.util;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.MatrixCursor;
import android.os.Build;
import android.util.Log;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a#\u0010\u0003\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010\n\u001a\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007\u001a)\u0010\r\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0010\u001a/\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u0012*\u00020\u00012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u00120\u0014H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0016"}, d2={"copyAndClose", "Landroid/database/Cursor;", "c", "findColumnIndexBySuffix", "", "cursor", "name", "", "columnNames", "", "([Ljava/lang/String;Ljava/lang/String;)I", "getColumnIndex", "getColumnIndexOrThrow", "wrapMappedColumns", "mapping", "", "(Landroid/database/Cursor;[Ljava/lang/String;[I)Landroid/database/Cursor;", "useCursor", "R", "block", "Lkotlin/Function1;", "(Landroid/database/Cursor;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "room-runtime_release"}, k=2, mv={1, 7, 1}, xi=48)
public final class CursorUtil {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final Cursor copyAndClose(Cursor object) {
        MatrixCursor matrixCursor;
        Intrinsics.checkNotNullParameter((Object)object, (String)"c");
        Closeable closeable = (Closeable)object;
        try {
            Cursor cursor = (Cursor)closeable;
            matrixCursor = new MatrixCursor(cursor.getColumnNames(), cursor.getCount());
            while (cursor.moveToNext()) {
                Object[] objectArray = new Object[cursor.getColumnCount()];
                int n = object.getColumnCount();
                block13: for (int i = 0; i < n; ++i) {
                    block14: {
                        switch (cursor.getType(i)) {
                            default: {
                                break block14;
                            }
                            case 4: {
                                objectArray[i] = cursor.getBlob(i);
                                continue block13;
                            }
                            case 3: {
                                objectArray[i] = cursor.getString(i);
                                continue block13;
                            }
                            case 2: {
                                objectArray[i] = cursor.getDouble(i);
                                continue block13;
                            }
                            case 1: {
                                objectArray[i] = cursor.getLong(i);
                                continue block13;
                            }
                            case 0: {
                                objectArray[i] = null;
                            }
                        }
                        continue;
                    }
                    object = new IllegalStateException();
                    throw object;
                }
                matrixCursor.addRow(objectArray);
            }
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
                throw throwable2;
            }
        }
        CloseableKt.closeFinally((Closeable)closeable, null);
        return (Cursor)matrixCursor;
    }

    private static final int findColumnIndexBySuffix(Cursor stringArray, String string2) {
        if (Build.VERSION.SDK_INT > 25) {
            return -1;
        }
        boolean bl = ((CharSequence)string2).length() == 0;
        if (bl) {
            return -1;
        }
        stringArray = stringArray.getColumnNames();
        Intrinsics.checkNotNullExpressionValue((Object)stringArray, (String)"columnNames");
        return CursorUtil.findColumnIndexBySuffix(stringArray, string2);
    }

    public static final int findColumnIndexBySuffix(String[] stringArray, String string2) {
        Intrinsics.checkNotNullParameter((Object)stringArray, (String)"columnNames");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"name");
        String string3 = '.' + string2;
        String string4 = '.' + string2 + '`';
        int n = 0;
        int n2 = stringArray.length;
        int n3 = 0;
        while (n3 < n2) {
            String string5 = stringArray[n3];
            if (string5.length() >= string2.length() + 2) {
                if (StringsKt.endsWith$default((String)string5, (String)string3, (boolean)false, (int)2, null)) {
                    return n;
                }
                if (string5.charAt(0) == '`' && StringsKt.endsWith$default((String)string5, (String)string4, (boolean)false, (int)2, null)) {
                    return n;
                }
            }
            ++n3;
            ++n;
        }
        return -1;
    }

    public static final int getColumnIndex(Cursor cursor, String string2) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"c");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"name");
        int n = cursor.getColumnIndex(string2);
        if (n >= 0) {
            return n;
        }
        n = cursor.getColumnIndex('`' + string2 + '`');
        if (n < 0) {
            n = CursorUtil.findColumnIndexBySuffix(cursor, string2);
        }
        return n;
    }

    public static final int getColumnIndexOrThrow(Cursor object, String string2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"c");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"name");
        int n = CursorUtil.getColumnIndex((Cursor)object, string2);
        if (n >= 0) {
            return n;
        }
        try {
            object = object.getColumnNames();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"c.columnNames");
            object = ArraysKt.joinToString$default((Object[])object, null, null, null, (int)0, null, null, (int)63, null);
        }
        catch (Exception exception) {
            Log.d((String)"RoomCursorUtil", (String)"Cannot collect column names for debug purposes", (Throwable)exception);
            object = "unknown";
        }
        throw new IllegalArgumentException("column '" + string2 + "' does not exist. Available columns: " + (String)object);
    }

    public static final <R> R useCursor(Cursor object, Function1<? super Cursor, ? extends R> object2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        Intrinsics.checkNotNullParameter(object2, (String)"block");
        object = (Closeable)object;
        try {
            object2 = object2.invoke(object);
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                InlineMarker.finallyStart((int)1);
                CloseableKt.closeFinally((Closeable)object, (Throwable)throwable);
                InlineMarker.finallyEnd((int)1);
                throw throwable2;
            }
        }
        InlineMarker.finallyStart((int)1);
        CloseableKt.closeFinally((Closeable)object, null);
        InlineMarker.finallyEnd((int)1);
        return (R)object2;
    }

    public static final Cursor wrapMappedColumns(Cursor cursor, String[] stringArray, int[] nArray) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        Intrinsics.checkNotNullParameter((Object)stringArray, (String)"columnNames");
        Intrinsics.checkNotNullParameter((Object)nArray, (String)"mapping");
        boolean bl = stringArray.length == nArray.length;
        if (bl) {
            return (Cursor)new CursorWrapper(cursor, stringArray, nArray){
                final String[] $columnNames;
                final int[] $mapping;
                {
                    this.$columnNames = stringArray;
                    this.$mapping = nArray;
                    super(cursor);
                }

                public int getColumnIndex(String string2) {
                    Intrinsics.checkNotNullParameter((Object)string2, (String)"columnName");
                    String[] stringArray = this.$columnNames;
                    int[] nArray = this.$mapping;
                    int n = 0;
                    int n2 = stringArray.length;
                    int n3 = 0;
                    while (n3 < n2) {
                        if (StringsKt.equals((String)stringArray[n3], (String)string2, (boolean)true)) {
                            return nArray[n];
                        }
                        ++n3;
                        ++n;
                    }
                    return super.getColumnIndex(string2);
                }
            };
        }
        throw new IllegalStateException("Expected columnNames.length == mapping.length".toString());
    }
}

