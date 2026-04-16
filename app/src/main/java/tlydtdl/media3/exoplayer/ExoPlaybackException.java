package tlydtdl.media3.exoplayer;

import amuvvoafs.os.Bundle;
import amuvvoafs.os.SystemClock;
import amuvvoafs.text.TextUtils;
import f3.f2;
import f9.b0;
import java.util.Objects;
import l8.s;
import o8.b;
import o8.f0;
import tlydtdl.media3.common.PlaybackException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class ExoPlaybackException extends PlaybackException {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f606j;
    public final String k;
    public final int l;
    public final s m;
    public final int n;
    public final b0 o;
    public final boolean p;

    public ExoPlaybackException(int i, Exception exc, int i2) {
        this(i, exc, i2, null, -1, null, 4, false);
    }

    @Override // tlydtdl.media3.common.PlaybackException
    public final boolean a(PlaybackException playbackException) {
        if (!super.a(playbackException)) {
            return false;
        }
        int i = f0.a;
        ExoPlaybackException exoPlaybackException = (ExoPlaybackException) playbackException;
        return this.f606j == exoPlaybackException.f606j && Objects.equals(this.k, exoPlaybackException.k) && this.l == exoPlaybackException.l && Objects.equals(this.m, exoPlaybackException.m) && this.n == exoPlaybackException.n && Objects.equals(this.o, exoPlaybackException.o) && this.p == exoPlaybackException.p;
    }

    public final ExoPlaybackException c(b0 b0Var) {
        String message = getMessage();
        int i = f0.a;
        return new ExoPlaybackException(message, getCause(), this.a, this.f606j, this.k, this.l, this.m, this.n, b0Var, this.b, this.p);
    }

    public ExoPlaybackException(String str, Throwable th, int i, int i2, String str2, int i3, s sVar, int i4, b0 b0Var, long j2, boolean z) {
        super(str, th, i, Bundle.EMPTY, j2);
        b.c(!z || i2 == 1);
        b.c(th != null || i2 == 3);
        this.f606j = i2;
        this.k = str2;
        this.l = i3;
        this.m = sVar;
        this.n = i4;
        this.o = b0Var;
        this.p = z;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ExoPlaybackException(int i, Throwable th, int i2, String str, int i3, s sVar, int i4, boolean z) {
        String str2;
        int i6;
        s sVar2;
        String string;
        String str3;
        if (i == 0) {
            str2 = str;
            i6 = i3;
            sVar2 = sVar;
            string = "Source error";
        } else if (i != 1) {
            if (i != 3) {
                string = "Unexpected runtime error";
            } else {
                string = "Remote error";
            }
            str2 = str;
            i6 = i3;
            sVar2 = sVar;
        } else {
            StringBuilder sb = new StringBuilder();
            str2 = str;
            sb.append(str2);
            sb.append(" error, index=");
            i6 = i3;
            sb.append(i6);
            sb.append(", format=");
            sVar2 = sVar;
            sb.append(sVar2);
            sb.append(", format_supported=");
            int i7 = f0.a;
            if (i4 == 0) {
                str3 = "NO";
            } else if (i4 == 1) {
                str3 = "NO_UNSUPPORTED_TYPE";
            } else if (i4 == 2) {
                str3 = "NO_UNSUPPORTED_DRM";
            } else if (i4 == 3) {
                str3 = "NO_EXCEEDS_CAPABILITIES";
            } else if (i4 == 4) {
                str3 = "YES";
            } else {
                throw new IllegalStateException();
            }
            sb.append(str3);
            string = sb.toString();
        }
        this(TextUtils.isEmpty((CharSequence) null) ? string : f2.C(string, ": null"), th, i2, i, str2, i6, sVar2, i4, null, SystemClock.elapsedRealtime(), z);
    }
}
