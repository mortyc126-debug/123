/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.room.util;

import android.database.Cursor;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.io.Closeable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000H\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0002\u001a\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0002\u001a\"\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001a \u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0002\u001a\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0000\u00a8\u0006\u0017"}, d2={"readColumns", "", "", "Landroidx/room/util/TableInfo$Column;", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "tableName", "readForeignKeyFieldMappings", "", "Landroidx/room/util/TableInfo$ForeignKeyWithSequence;", "cursor", "Landroid/database/Cursor;", "readForeignKeys", "", "Landroidx/room/util/TableInfo$ForeignKey;", "readIndex", "Landroidx/room/util/TableInfo$Index;", "name", "unique", "", "readIndices", "readTableInfo", "Landroidx/room/util/TableInfo;", "room-runtime_release"}, k=2, mv={1, 7, 1}, xi=48)
public final class TableInfoKt {
    /*
     * Exception decompiling
     */
    private static final Map<String, TableInfo.Column> readColumns(SupportSQLiteDatabase var0, String var1_5) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [23[UNCONDITIONALDOLOOP]], but top level block is 17[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private static final List<TableInfo.ForeignKeyWithSequence> readForeignKeyFieldMappings(Cursor cursor) {
        int n = cursor.getColumnIndex("id");
        int n2 = cursor.getColumnIndex("seq");
        int n3 = cursor.getColumnIndex("from");
        int n4 = cursor.getColumnIndex("to");
        List list = CollectionsKt.createListBuilder();
        while (cursor.moveToNext()) {
            int n5 = cursor.getInt(n);
            int n6 = cursor.getInt(n2);
            String string2 = cursor.getString(n3);
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"cursor.getString(fromColumnIndex)");
            String string3 = cursor.getString(n4);
            Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"cursor.getString(toColumnIndex)");
            list.add(new TableInfo.ForeignKeyWithSequence(n5, n6, string2, string3));
        }
        return CollectionsKt.sorted((Iterable)CollectionsKt.build((List)list));
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    private static final Set<TableInfo.ForeignKey> readForeignKeys(SupportSQLiteDatabase object, String object2) {
        void var0_6;
        Closeable closeable;
        block45: {
            Set set;
            block43: {
                object = object.query("PRAGMA foreign_key_list(`" + (String)object2 + "`)");
                boolean bl = false;
                boolean bl2 = false;
                closeable = (Closeable)object;
                object2 = object;
                boolean bl3 = bl;
                Cursor cursor = (Cursor)closeable;
                boolean bl4 = false;
                object2 = object;
                bl3 = bl;
                int n = cursor.getColumnIndex("id");
                object2 = object;
                bl3 = bl;
                int n2 = cursor.getColumnIndex("seq");
                object2 = object;
                bl3 = bl;
                int n3 = cursor.getColumnIndex("table");
                object2 = object;
                bl3 = bl;
                int n4 = cursor.getColumnIndex("on_delete");
                object2 = object;
                bl3 = bl;
                int n5 = cursor.getColumnIndex("on_update");
                object2 = object;
                bl3 = bl;
                List<TableInfo.ForeignKeyWithSequence> list = TableInfoKt.readForeignKeyFieldMappings(cursor);
                object2 = object;
                bl3 = bl;
                cursor.moveToPosition(-1);
                object2 = object;
                bl3 = bl;
                set = SetsKt.createSetBuilder();
                while (true) {
                    Object object3;
                    Object object4;
                    Object object5;
                    Object object6;
                    Collection<String> collection;
                    block46: {
                        block44: {
                            object2 = object;
                            bl3 = bl2;
                            if (!cursor.moveToNext()) break block43;
                            object2 = object;
                            bl3 = bl2;
                            if (cursor.getInt(n2) != 0) continue;
                            object2 = object;
                            bl3 = bl2;
                            int n6 = cursor.getInt(n);
                            object2 = object;
                            bl3 = bl2;
                            object2 = object;
                            bl3 = bl2;
                            collection = new Collection<String>();
                            object2 = object;
                            bl3 = bl2;
                            object6 = (List)collection;
                            object2 = object;
                            bl3 = bl2;
                            object2 = object;
                            bl3 = bl2;
                            collection = new Collection<String>();
                            object2 = object;
                            bl3 = bl2;
                            object5 = (List)collection;
                            object2 = object;
                            bl3 = bl2;
                            object4 = list;
                            object2 = object;
                            bl3 = bl2;
                            object2 = object;
                            bl3 = bl2;
                            collection = new Collection<String>();
                            object2 = object;
                            bl3 = bl2;
                            collection = collection;
                            object2 = object;
                            bl3 = bl2;
                            object4 = object4.iterator();
                            while (true) {
                                object2 = object;
                                bl3 = bl2;
                                bl3 = object4.hasNext();
                                if (!bl3) break block44;
                                object2 = object4.next();
                                int n7 = ((TableInfo.ForeignKeyWithSequence)object2).getId();
                                if ((n7 = n7 == n6 ? 1 : 0) == 0) continue;
                                break;
                            }
                            catch (Throwable throwable) {
                                break block45;
                            }
                            {
                                collection.add((String)object2);
                                continue;
                            }
                        }
                        object2 = (List)collection;
                        object4 = (Iterable)object2;
                        bl3 = false;
                        object3 = object4.iterator();
                        collection = object5;
                        object2 = object6;
                        object6 = object4;
                        while (true) {
                            bl = object3.hasNext();
                            if (!bl) break block46;
                            object5 = (TableInfo.ForeignKeyWithSequence)object3.next();
                            object2.add(((TableInfo.ForeignKeyWithSequence)object5).getFrom());
                            collection.add(((TableInfo.ForeignKeyWithSequence)object5).getTo());
                            continue;
                            break;
                        }
                        catch (Throwable throwable) {
                            break block45;
                        }
                    }
                    object3 = cursor.getString(n3);
                    Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"cursor.getString(tableColumnIndex)");
                    object4 = cursor.getString(n4);
                    Intrinsics.checkNotNullExpressionValue((Object)object4, (String)"cursor.getString(onDeleteColumnIndex)");
                    object5 = cursor.getString(n5);
                    Intrinsics.checkNotNullExpressionValue((Object)object5, (String)"cursor.getString(onUpdateColumnIndex)");
                    object6 = new TableInfo.ForeignKey((String)object3, (String)object4, (String)object5, (List<String>)object2, (List<String>)collection);
                    set.add(object6);
                    continue;
                    break;
                }
                catch (Throwable throwable) {
                    break block45;
                }
            }
            try {
                object = SetsKt.build((Set)set);
            }
            catch (Throwable throwable) {
                break block45;
            }
            CloseableKt.closeFinally((Closeable)closeable, null);
            return object;
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        try {
            throw var0_6;
        }
        catch (Throwable throwable) {
            CloseableKt.closeFinally((Closeable)closeable, (Throwable)var0_6);
            throw throwable;
        }
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    private static final TableInfo.Index readIndex(SupportSQLiteDatabase object, String string2, boolean bl) {
        void var0_4;
        Closeable closeable;
        block24: {
            block22: {
                TreeMap treeMap;
                TreeMap treeMap2;
                Object object2;
                block23: {
                    String string3;
                    int n;
                    object = object.query("PRAGMA index_xinfo(`" + string2 + "`)");
                    closeable = (Closeable)object;
                    Object object3 = object;
                    object2 = (Cursor)closeable;
                    object3 = object;
                    int n2 = object2.getColumnIndex("seqno");
                    object3 = object;
                    int n3 = object2.getColumnIndex("cid");
                    object3 = object;
                    int n4 = object2.getColumnIndex("name");
                    object3 = object;
                    int n5 = object2.getColumnIndex("desc");
                    if (n2 == -1 || n3 == -1 || n4 == -1 || n5 == -1) break block22;
                    object3 = object;
                    object3 = object;
                    treeMap2 = new TreeMap();
                    object3 = object;
                    object3 = object;
                    treeMap = new TreeMap();
                    while (true) {
                        object3 = object;
                        boolean bl2 = object2.moveToNext();
                        if (!bl2) break block23;
                        if (object2.getInt(n3) < 0) continue;
                        n = object2.getInt(n2);
                        string3 = object2.getString(n4);
                        int n6 = object2.getInt(n5);
                        object3 = n6 > 0 ? "DESC" : "ASC";
                        break;
                    }
                    catch (Throwable throwable) {
                        break block24;
                    }
                    {
                        Map map2 = treeMap2;
                        Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"columnName");
                        map2.put(n, string3);
                        ((Map)treeMap).put(n, object3);
                        continue;
                    }
                }
                try {
                    object = treeMap2.values();
                    Intrinsics.checkNotNullExpressionValue((Object)object, (String)"columnsMap.values");
                    object = CollectionsKt.toList((Iterable)((Iterable)object));
                    object2 = treeMap.values();
                    Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"ordersMap.values");
                    object2 = CollectionsKt.toList((Iterable)((Iterable)object2));
                }
                catch (Throwable throwable) {}
                try {
                    object = new TableInfo.Index(string2, bl, (List<String>)object, (List<String>)object2);
                }
                catch (Throwable throwable) {
                    break block24;
                }
                CloseableKt.closeFinally((Closeable)closeable, null);
                return object;
                break block24;
            }
            CloseableKt.closeFinally((Closeable)closeable, null);
            return null;
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        try {
            throw var0_4;
        }
        catch (Throwable throwable) {
            CloseableKt.closeFinally((Closeable)closeable, (Throwable)var0_4);
            throw throwable;
        }
    }

    /*
     * Exception decompiling
     */
    private static final Set<TableInfo.Index> readIndices(SupportSQLiteDatabase var0, String var1_4) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [15[UNCONDITIONALDOLOOP]], but top level block is 10[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public static final TableInfo readTableInfo(SupportSQLiteDatabase supportSQLiteDatabase, String string2) {
        Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"database");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"tableName");
        return new TableInfo(string2, TableInfoKt.readColumns(supportSQLiteDatabase, string2), TableInfoKt.readForeignKeys(supportSQLiteDatabase, string2), TableInfoKt.readIndices(supportSQLiteDatabase, string2));
    }
}

