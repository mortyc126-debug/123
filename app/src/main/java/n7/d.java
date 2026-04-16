package n7;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import tlydtdl.datastore.preferences.protobuf.InvalidProtocolBufferException;
import tlydtdl.datastore.preferences.protobuf.UninitializedMessageException;
import tlydtdl.datastore.preferences.protobuf.g0;
import tlydtdl.datastore.preferences.protobuf.j;
import tlydtdl.datastore.preferences.protobuf.l;
import tlydtdl.datastore.preferences.protobuf.o;
import tlydtdl.datastore.preferences.protobuf.p0;
import tlydtdl.datastore.preferences.protobuf.r0;
import tlydtdl.datastore.preferences.protobuf.t0;
import tlydtdl.datastore.preferences.protobuf.u;
import tlydtdl.datastore.preferences.protobuf.u0;
import tlydtdl.datastore.preferences.protobuf.v;
import tlydtdl.datastore.preferences.protobuf.w;
import z.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends w {
    private static final d DEFAULT_INSTANCE;
    private static volatile p0 PARSER = null;
    public static final int PREFERENCES_FIELD_NUMBER = 1;
    private g0 preferences_ = g0.b;

    static {
        d dVar = new d();
        DEFAULT_INSTANCE = dVar;
        w.j(d.class, dVar);
    }

    public static g0 l(d dVar) {
        g0 g0Var = dVar.preferences_;
        if (!g0Var.a) {
            dVar.preferences_ = g0Var.c();
        }
        return dVar.preferences_;
    }

    public static b n() {
        return (b) ((u) DEFAULT_INSTANCE.c(5));
    }

    public static d o(FileInputStream fileInputStream) throws InvalidProtocolBufferException {
        d dVar = DEFAULT_INSTANCE;
        j jVar = new j(fileInputStream);
        o oVarA = o.a();
        w wVarI = dVar.i();
        try {
            r0 r0Var = r0.c;
            r0Var.getClass();
            u0 u0VarA = r0Var.a(wVarI.getClass());
            l lVar = (l) jVar.b;
            if (lVar == null) {
                lVar = new l(jVar);
            }
            u0VarA.f(wVarI, lVar, oVarA);
            u0VarA.b(wVarI);
            if (w.f(wVarI, true)) {
                return (d) wVarI;
            }
            throw new InvalidProtocolBufferException(new UninitializedMessageException().getMessage());
        } catch (IOException e) {
            if (e.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e.getCause());
            }
            throw new InvalidProtocolBufferException(e.getMessage(), e);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e2.getCause());
            }
            throw e2;
        } catch (InvalidProtocolBufferException e3) {
            if (e3.a) {
                throw new InvalidProtocolBufferException(e3.getMessage(), e3);
            }
            throw e3;
        } catch (UninitializedMessageException e4) {
            throw new InvalidProtocolBufferException(e4.getMessage());
        }
    }

    @Override // tlydtdl.datastore.preferences.protobuf.w
    public final Object c(int i) {
        p0 vVar;
        switch (p.k(i)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new t0(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", c.a});
            case 3:
                return new d();
            case 4:
                return new b(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p0 p0Var = PARSER;
                if (p0Var != null) {
                    return p0Var;
                }
                synchronized (d.class) {
                    try {
                        vVar = PARSER;
                        if (vVar == null) {
                            vVar = new v();
                            PARSER = vVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return vVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final Map m() {
        return Collections.unmodifiableMap(this.preferences_);
    }
}
