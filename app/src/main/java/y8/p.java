package y8;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public interface p {
    void onInvalidLatency(long j2);

    void onPositionAdvancing(long j2);

    void onPositionFramesMismatch(long j2, long j3, long j4, long j5);

    void onSystemTimeUsMismatch(long j2, long j3, long j4, long j5);

    void onUnderrun(int i, long j2);
}
