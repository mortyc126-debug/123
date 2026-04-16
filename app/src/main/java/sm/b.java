package sm;

import com.bandlab.audiocore.generated.MusicUtils;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static float a(float f2, String str, String str2) {
        if (str == null || str2 == null) {
            return f2;
        }
        return MusicUtils.limitTransposition(((int) f2) + MusicUtils.getTransposition(MusicUtils.parseKeySig(str), MusicUtils.parseKeySig(str2)));
    }
}
