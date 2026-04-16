/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.sqlite.util;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\u0010\u001a\u00020\u000fR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\r8\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Landroidx/sqlite/util/ProcessLock;", "", "name", "", "lockDir", "Ljava/io/File;", "processLock", "", "(Ljava/lang/String;Ljava/io/File;Z)V", "lockChannel", "Ljava/nio/channels/FileChannel;", "lockFile", "threadLock", "Ljava/util/concurrent/locks/Lock;", "lock", "", "unlock", "Companion", "sqlite-framework_release"}, k=1, mv={1, 7, 1}, xi=48)
public final class ProcessLock {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "SupportSQLiteLock";
    private static final Map<String, Lock> threadLocksMap = new HashMap();
    private FileChannel lockChannel;
    private final File lockFile;
    private final boolean processLock;
    private final Lock threadLock;

    public ProcessLock(String string2, File object, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"name");
        Intrinsics.checkNotNullParameter((Object)object, (String)"lockDir");
        this.processLock = bl;
        this.lockFile = new File((File)object, string2 + ".lck");
        object = Companion;
        string2 = this.lockFile.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"lockFile.absolutePath");
        this.threadLock = ((Companion)object).getThreadLock(string2);
    }

    public static /* synthetic */ void lock$default(ProcessLock processLock, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            bl = processLock.processLock;
        }
        processLock.lock(bl);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void lock(boolean bl) {
        this.threadLock.lock();
        if (!bl) return;
        try {
            Object object = this.lockFile.getParentFile();
            if (object != null) {
                ((File)object).mkdirs();
            }
            object = new FileOutputStream(this.lockFile);
            object = ((FileOutputStream)object).getChannel();
            ((FileChannel)object).lock();
            this.lockChannel = object;
            return;
        }
        catch (IOException iOException) {
            this.lockChannel = null;
            Log.w((String)TAG, (String)"Unable to grab file lock.", (Throwable)iOException);
        }
    }

    public final void unlock() {
        block3: {
            FileChannel fileChannel = this.lockChannel;
            if (fileChannel == null) break block3;
            try {
                fileChannel.close();
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
        this.threadLock.unlock();
    }

    @Metadata(d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Landroidx/sqlite/util/ProcessLock$Companion;", "", "()V", "TAG", "", "threadLocksMap", "", "Ljava/util/concurrent/locks/Lock;", "getThreadLock", "key", "sqlite-framework_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Lock getThreadLock(String object) {
            Map map2 = threadLocksMap;
            synchronized (map2) {
                block6: {
                    Object object2;
                    block5: {
                        Map map3 = threadLocksMap;
                        object2 = map3.get(object);
                        if (object2 != null) break block5;
                        object2 = new Object();
                        object2 = (Lock)object2;
                        map3.put(object, object2);
                        object = object2;
                        break block6;
                    }
                    object = object2;
                }
                object = (Lock)object;
                return object;
            }
        }
    }
}

