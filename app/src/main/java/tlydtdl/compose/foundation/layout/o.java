package tlydtdl.compose.foundation.layout;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class o extends t3.o implements s4.a0 {
    public float a;
    public boolean b;

    public final long Q0(long j2, boolean z) {
        int iRound;
        int iG = p5.a.g(j2);
        if (iG == Integer.MAX_VALUE || (iRound = Math.round(iG * this.a)) <= 0) {
            return 0L;
        }
        if (!z || m.v(iRound, j2, iG)) {
            return (((long) iRound) << 32) | (((long) iG) & 4294967295L);
        }
        return 0L;
    }

    public final long R0(long j2, boolean z) {
        int iRound;
        int iH = p5.a.h(j2);
        if (iH == Integer.MAX_VALUE || (iRound = Math.round(iH / this.a)) <= 0) {
            return 0L;
        }
        if (!z || m.v(iH, j2, iRound)) {
            return (((long) iH) << 32) | (((long) iRound) & 4294967295L);
        }
        return 0L;
    }

    public final long S0(long j2, boolean z) {
        int i = p5.a.i(j2);
        int iRound = Math.round(i * this.a);
        if (iRound <= 0) {
            return 0L;
        }
        if (!z || m.v(iRound, j2, i)) {
            return (((long) iRound) << 32) | (((long) i) & 4294967295L);
        }
        return 0L;
    }

    public final long T0(long j2, boolean z) {
        int iJ = p5.a.j(j2);
        int iRound = Math.round(iJ / this.a);
        if (iRound <= 0) {
            return 0L;
        }
        if (!z || m.v(iJ, j2, iRound)) {
            return (((long) iJ) << 32) | (((long) iRound) & 4294967295L);
        }
        return 0L;
    }

    @Override // s4.a0
    public final int maxIntrinsicHeight(q4.w wVar, q4.v vVar, int i) {
        return i != Integer.MAX_VALUE ? Math.round(i / this.a) : vVar.c(i);
    }

    @Override // s4.a0
    public final int maxIntrinsicWidth(q4.w wVar, q4.v vVar, int i) {
        return i != Integer.MAX_VALUE ? Math.round(i * this.a) : vVar.R(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00bf  */
    @Override // s4.a0
    /* JADX INFO: renamed from: measure-3p2s80s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final q4.v0 mo1789measure3p2s80s(q4.w0 r8, q4.t0 r9, long r10) {
        /*
            Method dump skipped, instruction units count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.foundation.layout.o.mo1789measure3p2s80s(q4.w0, q4.t0, long):q4.v0");
    }

    @Override // s4.a0
    public final int minIntrinsicHeight(q4.w wVar, q4.v vVar, int i) {
        return i != Integer.MAX_VALUE ? Math.round(i / this.a) : vVar.z(i);
    }

    @Override // s4.a0
    public final int minIntrinsicWidth(q4.w wVar, q4.v vVar, int i) {
        return i != Integer.MAX_VALUE ? Math.round(i * this.a) : vVar.M(i);
    }
}
