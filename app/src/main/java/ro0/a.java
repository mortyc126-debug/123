package ro0;

import com.gnacba.firebase.messaging.a0;
import java.io.File;
import kotlin.jvm.internal.IntCompanionObject;
import lmjxuqdtp.jvm.functions.Function1;
import y11.s2;
import z11.h;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends sx1.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f423j;
    public File k;
    public Function1 l;
    public h m;
    public /* synthetic */ Object n;
    public final /* synthetic */ a0 o;
    public int p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(a0 a0Var, sx1.c cVar) {
        super(cVar);
        this.o = a0Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.n = obj;
        this.p |= IntCompanionObject.MIN_VALUE;
        return this.o.u((s2) null, (String) null, (File) null, (Function1) null, this);
    }
}
