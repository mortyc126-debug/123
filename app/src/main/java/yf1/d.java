package yf1;

import ld1.k;
import ld1.n;
import ld1.r;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements b {
    public final r a;
    public final r b;
    public final r c;
    public final r d;
    public final r e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final r f723f;
    public final r g;
    public final r h;
    public final r i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final r f724j;
    public final n k;
    public final r l;
    public final r m;
    public final r n;
    public final r o;
    public final r p;
    public final r q;

    public d(k kVar, k kVar2, r rVar, r rVar2, r rVar3, k kVar3, k kVar4, k kVar5, r rVar4, k kVar6, n nVar, k kVar7, r rVar5, k kVar8, r rVar6, k kVar9, r rVar7, int i, int i2, int i3, int i4) {
        kVar = (i & 16) != 0 ? null : kVar;
        kVar2 = (i2 & 4096) != 0 ? null : kVar2;
        k kVar10 = (i3 & 2) != 0 ? null : kVar3;
        k kVar11 = (i3 & 1024) != 0 ? null : kVar4;
        k kVar12 = (i3 & 2048) != 0 ? null : kVar5;
        k kVar13 = (i3 & 8192) != 0 ? null : kVar6;
        k kVar14 = (i4 & 16) != 0 ? null : kVar7;
        k kVar15 = (i4 & 64) != 0 ? null : kVar8;
        k kVar16 = (i4 & 256) == 0 ? kVar9 : null;
        this.a = kVar;
        this.b = kVar2;
        this.c = rVar;
        this.d = rVar2;
        this.e = rVar3;
        this.f723f = kVar10;
        this.g = kVar11;
        this.h = kVar12;
        this.i = rVar4;
        this.f724j = kVar13;
        this.k = nVar;
        this.l = kVar14;
        this.m = rVar5;
        this.n = kVar15;
        this.o = rVar6;
        this.p = kVar16;
        this.q = rVar7;
    }

    @Override // yf1.b
    public final r a() {
        return this.h;
    }

    @Override // yf1.b
    public final r b() {
        return this.d;
    }

    @Override // yf1.b
    public final r c() {
        return this.k;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return o.c(this.a, dVar.a) && o.c(this.b, dVar.b) && this.c.equals(dVar.c) && this.d.equals(dVar.d) && this.e.equals(dVar.e) && o.c(this.f723f, dVar.f723f) && o.c(this.g, dVar.g) && o.c(this.h, dVar.h) && this.i.equals(dVar.i) && o.c(this.f724j, dVar.f724j) && this.k.equals(dVar.k) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c(this.l, dVar.l) && o.c(this.m, dVar.m) && o.c(this.n, dVar.n) && o.c(this.o, dVar.o) && o.c(this.p, dVar.p) && o.c(this.q, dVar.q) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null) && o.c((Object) null, (Object) null);
    }

    public final int hashCode() {
        r rVar = this.a;
        int iHashCode = (rVar == null ? 0 : rVar.hashCode()) * (-955521279);
        r rVar2 = this.b;
        int iF = com.gnacba.ads.interactivemedia.v3.internal.a.f(this.e, com.gnacba.ads.interactivemedia.v3.internal.a.f(this.d, com.gnacba.ads.interactivemedia.v3.internal.a.f(this.c, (iHashCode + (rVar2 == null ? 0 : rVar2.hashCode())) * 961, -997072353), 31), 31);
        r rVar3 = this.f723f;
        int iHashCode2 = (iF + (rVar3 == null ? 0 : rVar3.hashCode())) * (-196513505);
        r rVar4 = this.g;
        int iHashCode3 = (iHashCode2 + (rVar4 == null ? 0 : rVar4.hashCode())) * 31;
        r rVar5 = this.h;
        int iF2 = com.gnacba.ads.interactivemedia.v3.internal.a.f(this.i, (iHashCode3 + (rVar5 == null ? 0 : rVar5.hashCode())) * 31, 31);
        r rVar6 = this.f724j;
        int iC = s1.a.c(this.k.a, (iF2 + (rVar6 == null ? 0 : rVar6.hashCode())) * 28629151, -844471871);
        r rVar7 = this.l;
        int iF3 = com.gnacba.ads.interactivemedia.v3.internal.a.f(this.m, (iC + (rVar7 == null ? 0 : rVar7.hashCode())) * 31, 31);
        r rVar8 = this.n;
        int iF4 = com.gnacba.ads.interactivemedia.v3.internal.a.f(this.o, (iF3 + (rVar8 == null ? 0 : rVar8.hashCode())) * 31, 31);
        r rVar9 = this.p;
        return com.gnacba.ads.interactivemedia.v3.internal.a.f(this.q, (iF4 + (rVar9 != null ? rVar9.hashCode() : 0)) * 31, -1935660287);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ThemeOverwrittenColors(borderContrast=null, borderIntense=null, borderIntenseSolid=null, borderInverted=null, borderNeutral=");
        sb.append(this.a);
        sb.append(", borderNeutralSolid=null, borderPermanentBlack=null, borderPermanentNeutralOndark=null, borderPermanentNeutralOnlight=null, borderPermanentWhite=null, external7digitalAlt1=null, external7digitalAlt2=null, externalAiAlt1=null, externalAiAlt2=null, externalAirbit=null, externalAmazonmusic=null, externalAmex=null, externalApplemusicAlt1=null, externalApplemusicAlt2=null, externalCakewalk=null, externalColor=null, externalDeezerAlt1=null, externalDeezerAlt2=null, externalDinersclub=null, externalDiscord=null, externalDiscover=null, externalFacebook=null, externalGoogle=null, externalGoogleAlt1=null, externalGoogleAlt2=null, externalGoogleAlt3=null, externalGoogleAlt4=null, externalGracenote=null, externalIheartradio=null, externalInstagram=null, externalInstagramAlt1=null, externalInstagramAlt2=null, externalInstagramAlt3=null, externalJcbAlt1=null, externalJcbAlt2=null, externalJcbAlt3=null, externalKkboxAlt1=null, externalKkboxAlt2=null, externalLinemusic=null, externalMastercardAlt1=null, externalMastercardAlt2=null, externalMastercardAlt3=null, externalMessengerAlt1=null, externalMessengerAlt2=null, externalMessengerAlt3=null, externalMessengerAlt4=null, externalMixcloud=null, externalPandoraAlt1=null, externalPandoraAlt2=null, externalPaypalAlt1=null, externalPaypalAlt2=null, externalPaypalAlt3=null, externalReddit=null, externalSoundcloud=null, externalSpotify=null, externalStripe=null, externalTidalAlt1=null, externalTidalAlt2=null, externalTiktok=null, externalTiktokAlt1=null, externalTiktokAlt2=null, externalTwitch=null, externalTwitter=null, externalUnionpayAlt1=null, externalUnionpayAlt2=null, externalUnionpayAlt3=null, externalVisa=null, externalWhatsapp=null, externalWindows=null, externalYoutube=null, externalZire=null, glyphsDisabled=");
        sb.append(this.b);
        sb.append(", glyphsError=null, glyphsInverted=");
        com.gnacba.ads.interactivemedia.v3.internal.a.q(sb, this.c, ", glyphsInvertedDisabled=null, glyphsInvertedSecondary=null, glyphsInvertedTertiary=null, glyphsLink=null, glyphsOverlay=null, glyphsOverlayDisabled=null, glyphsOverlaySecondary=null, glyphsOverlayTertiary=null, glyphsPermanentBlack=null, glyphsPermanentDisabledOndark=null, glyphsPermanentDisabledOnlight=null, glyphsPermanentSecondaryOndark=null, glyphsPermanentSecondaryOnlight=null, glyphsPermanentTertiaryOndark=null, glyphsPermanentTertiaryOnlight=null, glyphsPermanentWhite=null, glyphsPrimary=", this.d, ", glyphsSecondary=");
        com.gnacba.ads.interactivemedia.v3.internal.a.q(sb, this.e, ", glyphsTertiary=", this.f723f, ", overlayDimmerDefault=null, overlayDimmerSoft=null, overlayHighlighterDefault=null, overlayHighlighterSoft=null, overlaySurfaceInverted=null, overlaySurfaceModal=null, surfaceElevatedContrast=null, surfaceElevatedNeutral=null, surfaceInactiveContrast=");
        com.gnacba.ads.interactivemedia.v3.internal.a.q(sb, this.g, ", surfaceInactiveInverted=", this.h, ", surfaceInactiveNeutral=");
        com.gnacba.ads.interactivemedia.v3.internal.a.q(sb, this.i, ", surfaceInactiveNeutral2=", this.f724j, ", surfaceInactivePermanentBlack=null, surfaceInactivePermanentDarkNeutral=null, surfaceInactivePermanentTranslucentOndark=null, surfaceInactivePermanentWhite=null, surfaceInactiveScreen=");
        sb.append(this.k);
        sb.append(", surfaceInactiveScreen2=null, surfaceInactiveTranslucent=null, surfaceInactiveTransparent=null, surfaceInteractiveFaderFeedback=null, surfaceInteractiveFaderRested=null, surfaceInteractivePermanentBlackFeedback=null, surfaceInteractivePermanentBlackRested=null, surfaceInteractivePermanentSecondaryOndarkFeedback=null, surfaceInteractivePermanentSecondaryOndarkRested=null, surfaceInteractivePermanentSecondaryOnlightFeedback=null, surfaceInteractivePermanentSecondaryOnlightRested=null, surfaceInteractivePermanentTertiaryOndarkFeedback=null, surfaceInteractivePermanentTertiaryOndarkRested=null, surfaceInteractivePermanentTertiaryOnlightFeedback=null, surfaceInteractivePermanentTertiaryOnlightRested=null, surfaceInteractivePermanentWhiteFeedback=null, surfaceInteractivePermanentWhiteRested=null, surfaceInteractivePrimaryFeedback=");
        sb.append(this.l);
        sb.append(", surfaceInteractivePrimaryRested=");
        com.gnacba.ads.interactivemedia.v3.internal.a.q(sb, this.m, ", surfaceInteractiveSecondaryFeedback=", this.n, ", surfaceInteractiveSecondaryRested=");
        com.gnacba.ads.interactivemedia.v3.internal.a.q(sb, this.o, ", surfaceInteractiveTertiaryFeedback=", this.p, ", surfaceInteractiveTertiaryRested=");
        sb.append(this.q);
        sb.append(", tintBlue20=null, tintBlue50=null, tintBlueBase=null, tintBlueFeedback=null, tintBlueText=null, tintCyan20=null, tintCyan50=null, tintCyanBase=null, tintCyanFeedback=null, tintCyanText=null, tintGreen20=null, tintGreen50=null, tintGreenBase=null, tintGreenFeedback=null, tintGreenText=null, tintOrange20=null, tintOrange50=null, tintOrangeBase=null, tintOrangeFeedback=null, tintOrangeText=null, tintPink20=null, tintPink50=null, tintPinkBase=null, tintPinkFeedback=null, tintPinkText=null, tintPurple20=null, tintPurple50=null, tintPurpleBase=null, tintPurpleFeedback=null, tintPurpleText=null, tintRed20=null, tintRed50=null, tintRedBase=null, tintRedFeedback=null, tintRedText=null, tintYellow20=null, tintYellow50=null, tintYellowBase=null, tintYellowFeedback=null, tintYellowText=null)");
        return sb.toString();
    }
}
