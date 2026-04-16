package qs0;

import kotlin.jvm.internal.IntCompanionObject;
import rs0.j;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends sx1.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public j f390j;
    public /* synthetic */ Object k;
    public final /* synthetic */ d l;
    public int m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar, sx1.c cVar) {
        super(cVar);
        this.l = dVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.k = obj;
        this.m |= IntCompanionObject.MIN_VALUE;
        return this.l.b(this);
    }
}
