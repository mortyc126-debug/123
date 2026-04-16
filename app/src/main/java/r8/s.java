package r8;

import a80.d;
import amuvvoafs.database.SQLException;
import amuvvoafs.os.ConditionVariable;
import amuvvoafs.util.SparseArray;
import amuvvoafs.util.SparseBooleanArray;
import com.gnacba.amuvvoafs.gms.internal.cast.c1;
import com.gnacba.common.collect.q0;
import f3.f2;
import g4.d0;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import o8.b;
import tlydtdl.media3.database.DatabaseIOException;
import tlydtdl.media3.datasource.cache.Cache$CacheException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class s implements a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final HashSet f399j = new HashSet();
    public final File a;
    public final p b;
    public final d c;
    public final f d;
    public final HashMap e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Random f400f;
    public final boolean g;
    public long h;
    public Cache$CacheException i;

    public s(File file, p pVar, oe0.a aVar) {
        boolean zAdd;
        d dVar = new d();
        dVar.a = new HashMap();
        dVar.b = new SparseArray();
        dVar.c = new SparseBooleanArray();
        dVar.d = new SparseBooleanArray();
        k kVar = new k(aVar);
        File file2 = new File(file, "cached_content_index.exi");
        d4.a aVar2 = new d4.a();
        aVar2.b = null;
        aVar2.c = null;
        aVar2.d = new d0(file2);
        dVar.e = kVar;
        dVar.f = aVar2;
        f fVar = new f(aVar);
        synchronized (s.class) {
            zAdd = f399j.add(file.getAbsoluteFile());
        }
        if (!zAdd) {
            throw new IllegalStateException(f2.i(file, "Another SimpleCache instance uses the folder: "));
        }
        this.a = file;
        this.b = pVar;
        this.c = dVar;
        this.d = fVar;
        this.e = new HashMap();
        this.f400f = new Random();
        this.g = true;
        this.h = -1L;
        ConditionVariable conditionVariable = new ConditionVariable();
        new r(this, conditionVariable).start();
        conditionVariable.block();
    }

    public static void a(s sVar) {
        long j2;
        f fVar = sVar.d;
        d dVar = sVar.c;
        File file = sVar.a;
        if (!file.exists()) {
            try {
                e(file);
            } catch (Cache$CacheException e) {
                sVar.i = e;
                return;
            }
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            String str = "Failed to list cache directory files: " + file;
            b.m("SimpleCache", str);
            sVar.i = new Cache$CacheException(str);
            return;
        }
        int length = fileArrListFiles.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                j2 = -1;
                break;
            }
            File file2 = fileArrListFiles[i];
            String name = file2.getName();
            if (name.endsWith(".uid")) {
                try {
                    j2 = Long.parseLong(name.substring(0, name.indexOf(46)), 16);
                    break;
                } catch (NumberFormatException unused) {
                    b.m("SimpleCache", "Malformed UID file: " + file2);
                    file2.delete();
                }
            }
            i++;
        }
        sVar.h = j2;
        if (j2 == -1) {
            try {
                sVar.h = f(file);
            } catch (IOException e2) {
                String str2 = "Failed to create cache UID: " + file;
                b.n("SimpleCache", str2, e2);
                sVar.i = new Cache$CacheException(str2, e2);
                return;
            }
        }
        try {
            dVar.H(sVar.h);
            if (fVar != null) {
                fVar.b(sVar.h);
                HashMap mapA = fVar.a();
                sVar.h(file, true, fileArrListFiles, mapA);
                fVar.c(mapA.keySet());
            } else {
                sVar.h(file, true, fileArrListFiles, null);
            }
            c1 c1VarL = q0.o(((HashMap) dVar.a).keySet()).l();
            while (c1VarL.hasNext()) {
                dVar.J((String) c1VarL.next());
            }
            try {
                dVar.O();
            } catch (IOException e3) {
                b.n("SimpleCache", "Storing index file failed", e3);
            }
        } catch (IOException e4) {
            String str3 = "Failed to initialize cache indices: " + file;
            b.n("SimpleCache", str3, e4);
            sVar.i = new Cache$CacheException(str3, e4);
        }
    }

    public static void e(File file) throws Cache$CacheException {
        if (file.mkdirs() || file.isDirectory()) {
            return;
        }
        String str = "Failed to create cache directory: " + file;
        b.m("SimpleCache", str);
        throw new Cache$CacheException(str);
    }

    public static long f(File file) throws IOException {
        long jNextLong = new SecureRandom().nextLong();
        long jAbs = jNextLong == Long.MIN_VALUE ? 0L : Math.abs(jNextLong);
        File file2 = new File(file, f2.C(Long.toString(jAbs, 16), ".uid"));
        if (file2.createNewFile()) {
            return jAbs;
        }
        throw new IOException(f2.i(file2, "Failed to create UID file: "));
    }

    public final void b(t tVar) {
        String str = ((h) tVar).a;
        this.c.D(str).a(tVar);
        ArrayList arrayList = (ArrayList) this.e.get(str);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((p) arrayList.get(size)).b(this, tVar);
            }
        }
        this.b.b(this, tVar);
    }

    public final synchronized void c(String str, r7.a aVar) {
        d();
        d dVar = this.c;
        j jVarD = dVar.D(str);
        if (jVarD.b(aVar)) {
            ((l) dVar.e).p(jVarD);
        }
        try {
            this.c.O();
        } catch (IOException e) {
            throw new Cache$CacheException(e);
        }
    }

    public final synchronized void d() {
        Cache$CacheException cache$CacheException = this.i;
        if (cache$CacheException != null) {
            throw cache$CacheException;
        }
    }

    public final synchronized n g(String str) {
        j jVarW;
        jVarW = this.c.w(str);
        return jVarW != null ? jVarW.c() : n.c;
    }

    public final void h(File file, boolean z, File[] fileArr, Map map) {
        long j2;
        long j3;
        if (fileArr == null || fileArr.length == 0) {
            if (z) {
                return;
            }
            file.delete();
            return;
        }
        for (File file2 : fileArr) {
            String name = file2.getName();
            if (z && name.indexOf(46) == -1) {
                h(file2, false, file2.listFiles(), map);
            } else if (!z || (!name.startsWith("cached_content_index.exi") && !name.endsWith(".uid"))) {
                e eVar = map != null ? (e) map.remove(name) : null;
                if (eVar != null) {
                    j2 = eVar.a;
                    j3 = eVar.b;
                } else {
                    j2 = -1;
                    j3 = -9223372036854775807L;
                }
                t tVarB = t.b(file2, j2, j3, this.c);
                if (tVarB != null) {
                    b(tVarB);
                } else {
                    file2.delete();
                }
            }
        }
    }

    public final synchronized void i(t tVar) {
        j jVarW = this.c.w(((h) tVar).a);
        jVarW.getClass();
        jVarW.l(((h) tVar).b);
        this.c.J(jVarW.b);
        notifyAll();
    }

    public final void j(h hVar) {
        String str = hVar.a;
        long j2 = hVar.c;
        d dVar = this.c;
        j jVarW = dVar.w(str);
        if (jVarW == null || !jVarW.j(hVar)) {
            return;
        }
        f fVar = this.d;
        if (fVar != null) {
            File file = hVar.e;
            file.getClass();
            String name = file.getName();
            try {
                fVar.b.getClass();
                try {
                    fVar.a.getWritableDatabase().delete(fVar.b, "name = ?", new String[]{name});
                } catch (SQLException e) {
                    throw new DatabaseIOException(e);
                }
            } catch (IOException unused) {
                jn1.r.s("Failed to remove file index entry for: ", name, "SimpleCache");
            }
        }
        dVar.J(jVarW.b);
        ArrayList arrayList = (ArrayList) this.e.get(hVar.a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                p pVar = (p) arrayList.get(size);
                pVar.b.remove(hVar);
                pVar.c -= j2;
            }
        }
        p pVar2 = this.b;
        pVar2.b.remove(hVar);
        pVar2.c -= j2;
    }

    public final void k() {
        ArrayList arrayList = new ArrayList();
        Iterator it = Collections.unmodifiableCollection(((HashMap) this.c.a).values()).iterator();
        while (it.hasNext()) {
            for (h hVar : ((j) it.next()).e()) {
                File file = hVar.e;
                file.getClass();
                if (file.length() != hVar.c) {
                    arrayList.add(hVar);
                }
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            j((h) arrayList.get(i));
        }
    }

    public final synchronized t l(long j2, long j3, String str) {
        t tVarD;
        t tVarD2;
        d();
        j jVarW = this.c.w(str);
        if (jVarW == null) {
            tVarD2 = t.d(j2, j3, str);
        } else {
            while (true) {
                tVarD = jVarW.d(j2, j3);
                if (!((h) tVarD).d) {
                    break;
                }
                File file = ((h) tVarD).e;
                file.getClass();
                if (file.length() == ((h) tVarD).c) {
                    break;
                }
                k();
            }
            tVarD2 = tVarD;
        }
        if (((h) tVarD2).d) {
            return m(str, tVarD2);
        }
        if (this.c.D(str).i(j2, ((h) tVarD2).c)) {
            return tVarD2;
        }
        return null;
    }

    public final t m(String str, t tVar) {
        boolean z;
        long j2 = ((h) tVar).c;
        if (!this.g) {
            return tVar;
        }
        File file = ((h) tVar).e;
        file.getClass();
        String name = file.getName();
        long j3 = ((h) tVar).c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        f fVar = this.d;
        if (fVar != null) {
            try {
                fVar.d(j3, jCurrentTimeMillis, name);
            } catch (IOException unused) {
                b.q("SimpleCache", "Failed to update index with new touch timestamp.");
            }
            z = false;
        } else {
            z = true;
        }
        j jVarW = this.c.w(str);
        jVarW.getClass();
        t tVarK = jVarW.k(tVar, jCurrentTimeMillis, z);
        ArrayList arrayList = (ArrayList) this.e.get(((h) tVar).a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                p pVar = (p) arrayList.get(size);
                pVar.b.remove(tVar);
                pVar.c -= j2;
                pVar.b(this, tVarK);
            }
        }
        p pVar2 = this.b;
        pVar2.b.remove(tVar);
        pVar2.c -= j2;
        pVar2.b(this, tVarK);
        return tVarK;
    }
}
