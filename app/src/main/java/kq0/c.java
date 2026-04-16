package kq0;

import java.util.ArrayList;
import java.util.Map;
import ky1.a0;
import mq0.l;
import ny1.b2;
import ny1.r2;
import ny1.z;
import v2.p;
import x10.a;
import zi.i;
import zi.k;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public final a0 a;
    public final p b;
    public final k c;
    public final k d;
    public final r2 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b2 f269f;
    public final b2 g;
    public final r2 h;
    public final ArrayList i;

    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object, java.util.Map] */
    public c(i iVar, a0 a0Var) {
        this.a = a0Var;
        this.b = z10.d.L(iVar, "preset_prompt", a0Var, (String) null, 12);
        k kVarA = iVar.a("is_generating", Boolean.FALSE, null);
        this.c = kVarA;
        k kVarA2 = iVar.a("is_hidden", Boolean.TRUE, null);
        this.d = kVarA2;
        r2 r2VarC = z.c((Object) null);
        this.e = r2VarC;
        this.f269f = a.L(kVarA, a0Var);
        this.g = a.L(kVarA2, a0Var);
        this.h = r2VarC;
        ?? r5 = d.a;
        ArrayList arrayList = new ArrayList(r5.size());
        for (Map.Entry entry : r5.entrySet()) {
            arrayList.add(new l((String) entry.getKey(), (String) entry.getValue()));
        }
        this.i = arrayList;
    }

    public final void a(boolean z) {
        k kVar = this.c;
        ((Boolean) kVar.e).getClass();
        kVar.a(Boolean.valueOf(z));
    }

    public final void b(boolean z) {
        k kVar = this.d;
        ((Boolean) kVar.e).getClass();
        kVar.a(Boolean.valueOf(z));
    }
}
