package jp1;

import amuvvoafs.os.IBinder;
import amuvvoafs.os.Parcel;
import amuvvoafs.os.Parcelable;
import amuvvoafs.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.HttpUrl;
import st1.t1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends up1.a {
    public static final Parcelable.Creator<b> CREATOR;
    public static final d0 q = new d0(false);
    public static final e0 r = new e0(0);
    public static final kp1.a s;
    public final String a;
    public final ArrayList b;
    public final boolean c;
    public final ip1.j d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final kp1.a f240f;
    public final boolean g;
    public final double h;
    public final boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f241j;
    public final boolean k;
    public final List l;
    public final boolean m;
    public final boolean n;
    public final d0 o;
    public e0 p;

    static {
        new kp1.f(kp1.f.I, kp1.f.J, 10000L, (String) null, t1.N("smallIconDrawableResId"), t1.N("stopLiveStreamDrawableResId"), t1.N("pauseDrawableResId"), t1.N("playDrawableResId"), t1.N("skipNextDrawableResId"), t1.N("skipPrevDrawableResId"), t1.N("forwardDrawableResId"), t1.N("forward10DrawableResId"), t1.N("forward30DrawableResId"), t1.N("rewindDrawableResId"), t1.N("rewind10DrawableResId"), t1.N("rewind30DrawableResId"), t1.N("disconnectDrawableResId"), t1.N("notificationImageSizeDimenResId"), t1.N("castingToDeviceStringResId"), t1.N("stopLiveStreamStringResId"), t1.N("pauseStringResId"), t1.N("playStringResId"), t1.N("skipNextStringResId"), t1.N("skipPrevStringResId"), t1.N("forwardStringResId"), t1.N("forward10StringResId"), t1.N("forward30StringResId"), t1.N("rewindStringResId"), t1.N("rewind10StringResId"), t1.N("rewind30StringResId"), t1.N("disconnectStringResId"), (IBinder) null, false, false);
        s = new kp1.a("com.gnacba.amuvvoafs.gms.cast.framework.media.MediaIntentReceiver", (String) null, (IBinder) null, (kp1.f) null, false, false);
        CREATOR = new com.facebook.a(18);
    }

    public b(String str, ArrayList arrayList, boolean z, ip1.j jVar, boolean z2, kp1.a aVar, boolean z3, double d, boolean z4, boolean z5, boolean z6, ArrayList arrayList2, boolean z7, boolean z8, d0 d0Var, e0 e0Var) {
        this.a = true == TextUtils.isEmpty(str) ? HttpUrl.FRAGMENT_ENCODE_SET : str;
        int size = arrayList == null ? 0 : arrayList.size();
        ArrayList arrayList3 = new ArrayList(size);
        this.b = arrayList3;
        if (size > 0) {
            arrayList3.addAll(arrayList);
        }
        this.c = z;
        this.d = jVar == null ? new ip1.j() : jVar;
        this.e = z2;
        this.f240f = aVar;
        this.g = z3;
        this.h = d;
        this.i = z4;
        this.f241j = z5;
        this.k = z6;
        this.l = arrayList2;
        this.m = z7;
        this.n = z8;
        this.o = d0Var;
        this.p = e0Var;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int iJ0 = com.facebook.appevents.h.j0(20293, parcel);
        com.facebook.appevents.h.d0(parcel, 2, this.a);
        com.facebook.appevents.h.f0(parcel, 3, Collections.unmodifiableList(this.b));
        com.facebook.appevents.h.i0(parcel, 4, 4);
        parcel.writeInt(this.c ? 1 : 0);
        com.facebook.appevents.h.c0(parcel, 5, this.d, i);
        com.facebook.appevents.h.i0(parcel, 6, 4);
        parcel.writeInt(this.e ? 1 : 0);
        com.facebook.appevents.h.c0(parcel, 7, this.f240f, i);
        com.facebook.appevents.h.i0(parcel, 8, 4);
        parcel.writeInt(this.g ? 1 : 0);
        com.facebook.appevents.h.i0(parcel, 9, 8);
        parcel.writeDouble(this.h);
        com.facebook.appevents.h.i0(parcel, 10, 4);
        parcel.writeInt(this.i ? 1 : 0);
        com.facebook.appevents.h.i0(parcel, 11, 4);
        parcel.writeInt(this.f241j ? 1 : 0);
        com.facebook.appevents.h.i0(parcel, 12, 4);
        parcel.writeInt(this.k ? 1 : 0);
        com.facebook.appevents.h.f0(parcel, 13, Collections.unmodifiableList(this.l));
        com.facebook.appevents.h.i0(parcel, 14, 4);
        parcel.writeInt(this.m ? 1 : 0);
        com.facebook.appevents.h.i0(parcel, 15, 4);
        parcel.writeInt(0);
        com.facebook.appevents.h.i0(parcel, 16, 4);
        parcel.writeInt(this.n ? 1 : 0);
        com.facebook.appevents.h.c0(parcel, 17, this.o, i);
        com.facebook.appevents.h.c0(parcel, 18, this.p, i);
        com.facebook.appevents.h.k0(iJ0, parcel);
    }
}
