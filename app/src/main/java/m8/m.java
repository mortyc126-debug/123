package m8;

import tlydtdl.media3.common.audio.AudioProcessor$UnhandledAudioFormatException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends i {
    @Override // m8.i
    public final f a(f fVar) throws AudioProcessor$UnhandledAudioFormatException {
        int i = fVar.c;
        if (i == 3 || i == 2 || i == 268435456 || i == 21 || i == 1342177280 || i == 22 || i == 1610612736 || i == 4) {
            return i != 2 ? new f(fVar.a, fVar.b, 2) : f.e;
        }
        throw new AudioProcessor$UnhandledAudioFormatException(fVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    @Override // m8.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void queueInput(java.nio.ByteBuffer r12) {
        /*
            Method dump skipped, instruction units count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.m.queueInput(java.nio.ByteBuffer):void");
    }
}
