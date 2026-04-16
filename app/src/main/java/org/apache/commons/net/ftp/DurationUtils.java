package org.apache.commons.net.ftp;

import java.time.Duration;

/* JADX INFO: loaded from: classes2.dex */
class DurationUtils {
    DurationUtils() {
    }

    static boolean isPositive(Duration duration) {
        return (duration == null || duration.isNegative() || duration.isZero()) ? false : true;
    }

    static int toMillisInt(Duration duration) {
        long millis = duration.toMillis();
        return (int) (millis > 0 ? Math.min(millis, 2147483647L) : Math.max(millis, -2147483648L));
    }

    static Duration zeroIfNull(Duration controlIdle) {
        return controlIdle == null ? Duration.ZERO : controlIdle;
    }
}
