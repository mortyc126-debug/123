package aq;

import bb.w;
import com.bandlab.audiocore.generated.AutoPitch;
import com.bandlab.audiocore.generated.AutoPitchData;
import com.bandlab.audiocore.generated.MusicUtils;
import com.bandlab.bandlab.utils.debug.DebugUtils;
import com.bandlab.bandlab.utils.debug.TaggedException;
import hy1.r;
import java.util.ArrayList;
import java.util.Arrays;
import lmjxuqdtp.jvm.internal.o;
import okhttp3.HttpUrl;
import y11.j0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public final ru1.c a;

    public d(ru1.c cVar) {
        this.a = cVar;
    }

    public final AutoPitchData a(String str) {
        ru1.c cVar = this.a;
        AutoPitchData autoPitchDataCreateData = AutoPitch.createData(cVar.p().a.toString(), MusicUtils.parseKeySig(str == null ? HttpUrl.FRAGMENT_ENCODE_SET : str));
        if (autoPitchDataCreateData != null) {
            s02.b bVar = s02.d.a;
            String str2 = "AutoPitch:: created an autoPitch object with key: " + str + " , version : " + cVar.p();
            bVar.getClass();
            s02.b.t(str2);
            return autoPitchDataCreateData;
        }
        String strC0 = r.c0("\n                Failed to create autoPitch.\n                desireVersion: " + cVar.p() + "\n                engine version: " + AutoPitch.getMaxSupportedVersion() + "\n                ");
        w wVar = new w(2);
        ArrayList arrayList = wVar.a;
        wVar.a("CRITICAL");
        wVar.e(new String[]{"AutoPitch::"});
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        DebugUtils.handleThrowable(new TaggedException(new IllegalStateException(strC0), (String[]) Arrays.copyOf(strArr, strArr.length)));
        return autoPitchDataCreateData;
    }

    public final j0 b(j0 j0Var) {
        o.h(j0Var, "autoPitch");
        AutoPitchData autoPitchDataSanitizeData = AutoPitch.sanitizeData(cg0.b.b(j0Var), MusicUtils.parseKeySig(HttpUrl.FRAGMENT_ENCODE_SET));
        j0 j0VarC = autoPitchDataSanitizeData != null ? cg0.b.c(autoPitchDataSanitizeData) : null;
        if (j0VarC != null) {
            s02.b bVar = s02.d.a;
            String str = "AutoPitch:: : sanitized autoPitch. version : " + j0VarC.g + ", key : null, slug : " + j0VarC.d;
            bVar.getClass();
            s02.b.t(str);
            return j0VarC;
        }
        String strC0 = r.c0("\n                Failed to sanitize autoPitch: " + cg0.b.b(j0Var) + "\n                engine version: " + AutoPitch.getMaxSupportedVersion() + "\n                ");
        w wVar = new w(2);
        ArrayList arrayList = wVar.a;
        wVar.a("CRITICAL");
        wVar.e(new String[]{"AutoPitch::"});
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        DebugUtils.handleThrowable(new TaggedException(new IllegalStateException(strC0), (String[]) Arrays.copyOf(strArr, strArr.length)));
        return j0VarC;
    }
}
