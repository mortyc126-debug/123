package cg0;

import com.bandlab.audiocore.generated.AutoPitchData;
import com.bandlab.audiocore.generated.AuxData;
import com.bandlab.audiocore.generated.EffectData;
import com.bandlab.audiocore.generated.MusicUtils;
import com.bandlab.audiocore.generated.Scale;
import com.bandlab.audiocore.generated.Tonic;
import hs1.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import lmjxuqdtp.jvm.internal.o;
import md1.b1;
import mx1.t;
import okhttp3.HttpUrl;
import y11.j0;
import y11.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static final AuxData a = new AuxData(HttpUrl.FRAGMENT_ENCODE_SET, 0.0f);

    public static final ArrayList a(ArrayList arrayList, List list) {
        String slug;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            EffectData effectData = (EffectData) it.next();
            if (effectData.getBypass()) {
                slug = null;
            } else if (list.contains(effectData.getSlug())) {
                String slug2 = effectData.getSlug();
                ArrayList enumParams = effectData.getEnumParams();
                o.g(enumParams, "getEnumParams(...)");
                slug = b1.j(slug2, "_", mx1.o.E0(enumParams, "_", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new bt0.a(20), 30));
            } else {
                slug = effectData.getSlug();
            }
            if (slug != null) {
                arrayList2.add(slug);
            }
        }
        return arrayList2;
    }

    public static final AutoPitchData b(j0 j0Var) {
        String strA;
        Tonic tonicSlugToTonic;
        Scale scaleSlugToScale;
        o.h(j0Var, "<this>");
        boolean z = j0Var.a;
        float f2 = j0Var.c;
        t tVar = j0Var.b;
        if (tVar == null) {
            tVar = t.a;
        }
        ArrayList arrayList = new ArrayList((Collection) tVar);
        String str = j0Var.d;
        if (str == null || (strA = d.L(str)) == null) {
            strA = p.b.a();
        }
        String str2 = strA;
        String str3 = j0Var.f;
        if (str3 == null || (tonicSlugToTonic = MusicUtils.slugToTonic(str3)) == null) {
            tonicSlugToTonic = Tonic.UNDEFINED;
        }
        Tonic tonic = tonicSlugToTonic;
        String str4 = j0Var.e;
        if (str4 == null || (scaleSlugToScale = MusicUtils.slugToScale(str4)) == null) {
            scaleSlugToScale = Scale.UNDEFINED;
        }
        return new AutoPitchData(z, f2, arrayList, str2, tonic, scaleSlugToScale, j0Var.g, j0Var.h, j0Var.i);
    }

    public static final j0 c(AutoPitchData autoPitchData) {
        boolean bypass = autoPitchData.getBypass();
        ArrayList targetNotes = autoPitchData.getTargetNotes();
        float responseTime = autoPitchData.getResponseTime();
        String slug = autoPitchData.getSlug();
        Tonic tonic = autoPitchData.getTonic();
        o.g(tonic, "getTonic(...)");
        String str = MusicUtils.tonicToSlug(tonic);
        o.g(str, "tonicToSlug(...)");
        Scale scale = autoPitchData.getScale();
        o.g(scale, "getScale(...)");
        String strScaleToSlug = MusicUtils.scaleToSlug(scale);
        o.g(strScaleToSlug, "scaleToSlug(...)");
        String version = autoPitchData.getVersion();
        o.g(version, "getVersion(...)");
        return new j0(bypass, targetNotes, responseTime, slug, strScaleToSlug, str, version, autoPitchData.getMix(), autoPitchData.getAlgorithm());
    }
}
