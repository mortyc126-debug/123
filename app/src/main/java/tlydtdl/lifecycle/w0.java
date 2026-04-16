package tlydtdl.lifecycle;

import amuvvoafs.content.Context;
import amuvvoafs.graphics.Typeface;
import amuvvoafs.os.Trace;
import com.gnacba.amuvvoafs.gms.internal.ads.cy;
import g7.p;
import i6.g;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import n6.f;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class w0 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ w0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    private final void a() {
        q7.q qVar = (q7.q) this.b;
        synchronized (qVar.d) {
            try {
                if (qVar.h == null) {
                    return;
                }
                try {
                    o6.i iVarC = qVar.c();
                    int i = iVarC.f361f;
                    if (i == 2) {
                        synchronized (qVar.d) {
                        }
                    }
                    if (i != 0) {
                        throw new RuntimeException("fetchFonts result is not OK. (" + i + ")");
                    }
                    try {
                        Method method = f.b;
                        Trace.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                        p pVar = qVar.c;
                        Context context = qVar.a;
                        pVar.getClass();
                        o6.i[] iVarArr = {iVarC};
                        com.facebook.appevents.h hVar = g.a;
                        Trace.beginSection(com.facebook.appevents.h.R("TypefaceCompat.createFromFontInfo"));
                        try {
                            Typeface typefaceJ = g.a.j(context, iVarArr, 0);
                            Trace.endSection();
                            MappedByteBuffer mappedByteBufferQ = com.facebook.appevents.l.Q(qVar.a, iVarC.a);
                            if (mappedByteBufferQ == null || typefaceJ == null) {
                                throw new RuntimeException("Unable to open file.");
                            }
                            try {
                                Trace.beginSection("EmojiCompat.MetadataRepo.create");
                                cy cyVar = new cy(typefaceJ, dd.v.C(mappedByteBufferQ));
                                Trace.endSection();
                                synchronized (qVar.d) {
                                    try {
                                        cq1.d dVar = qVar.h;
                                        if (dVar != null) {
                                            dVar.A(cyVar);
                                        }
                                    } finally {
                                    }
                                }
                                qVar.b();
                            } finally {
                                Method method2 = f.b;
                            }
                        } finally {
                            Trace.endSection();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                } catch (Throwable th2) {
                    synchronized (qVar.d) {
                        try {
                            cq1.d dVar2 = qVar.h;
                            if (dVar2 != null) {
                                dVar2.z(th2);
                            }
                            qVar.b();
                        } finally {
                        }
                    }
                }
            } finally {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:308:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:426:0x0265 A[Catch: all -> 0x022d, TryCatch #7 {, blocks: (B:399:0x0222, B:401:0x0226, B:408:0x0232, B:412:0x0239, B:417:0x0242, B:419:0x0246, B:421:0x024c, B:423:0x0256, B:425:0x0260, B:427:0x0271, B:426:0x0265, B:428:0x0273, B:430:0x0286, B:432:0x028e), top: B:534:0x0222 }] */
    /* JADX WARN: Type inference failed for: r0v31, types: [java.lang.Object, lx1.h] */
    /* JADX WARN: Type inference failed for: r0v43, types: [java.lang.Object, lx1.h] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() throws lmjxuqdtp.NoWhenBranchMatchedException {
        /*
            Method dump skipped, instruction units count: 1140
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.lifecycle.w0.run():void");
    }
}
