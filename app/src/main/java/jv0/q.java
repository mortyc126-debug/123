package jv0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class q {
    public static final q b;
    public static final q c;
    public static final q d;
    public static final q e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final q f247f;
    public static final q g;
    public static final q h;
    public static final q i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final q f248j;
    public static final q k;
    public static final q l;
    public static final q m;
    public static final q n;
    public static final q o;
    public static final q p;
    public static final q q;
    public static final q r;
    public static final q s;
    public static final /* synthetic */ q[] t;
    public final String a;

    static {
        q qVar = new q("AutoBeat", 0, "smart-tools-layer");
        b = qVar;
        q qVar2 = new q("Extend", 1, "smart-tools-extend");
        c = qVar2;
        q qVar3 = new q("Recompose", 2, "smart-tools-recompose");
        d = qVar3;
        q qVar4 = new q("VoiceChanger", 3, "voice-changer");
        e = qVar4;
        q qVar5 = new q("AutoPitch", 4, "autopitch");
        f247f = qVar5;
        q qVar6 = new q("MembershipEffects", 5, "membership-effects");
        g = qVar6;
        q qVar7 = new q("ExtendedFxChain", 6, "extended-fx-chain");
        h = qVar7;
        q qVar8 = new q("TrackStudio32", 7, "32-track-studio");
        i = qVar8;
        q qVar9 = new q("AutoSlice", 8, "auto-slice");
        f248j = qVar9;
        q qVar10 = new q("Normalize", 9, "normalize");
        k = qVar10;
        q qVar11 = new q("MembershipInstruments", 10, "membership-instruments");
        l = qVar11;
        q qVar12 = new q("GroupTracks", 11, "group-tracks");
        q qVar13 = new q("Comping", 12, "comping");
        m = qVar13;
        q qVar14 = new q("SoundsUploads", 13, "sounds-uploads");
        q qVar15 = new q("SoundsTokens", 14, "sounds-tokens");
        n = qVar15;
        q qVar16 = new q("Palette", 15, "palette");
        q qVar17 = new q("Mastering", 16, "mastering");
        q qVar18 = new q("Splitter", 17, "splitter");
        q qVar19 = new q("VoiceCleaner", 18, "voice-cleaner");
        o = qVar19;
        q qVar20 = new q("AudioToMidi", 19, "audio-to-midi");
        p = qVar20;
        q qVar21 = new q("AutoMix", 20, "automix");
        q = qVar21;
        q qVar22 = new q("AdditionalFreeBeats", 21, "additional-beat-claims");
        q qVar23 = new q("BeatsForMembersOnly", 22, "members-only-beats");
        q qVar24 = new q("AdsFreeExperience", 23, "ads-free-experience");
        q qVar25 = new q("Distro", 24, "distro");
        r = qVar25;
        q qVar26 = new q("FanReach", 25, "fan-reach");
        q qVar27 = new q("Opportunities", 26, "opportunities");
        q qVar28 = new q("BandLabVerified", 27, "bandlab-verified");
        q qVar29 = new q("Pages", 28, "pages");
        q qVar30 = new q("IndustryConnect", 29, "industry-connect");
        q qVar31 = new q("Publishing", 30, "publishing");
        q qVar32 = new q("Licensing", 31, "licensing");
        q qVar33 = new q("MultipleProfilePictures", 32, "multiple-profile-pictures");
        q qVar34 = new q("ProfileViews", 33, "profile-views");
        q qVar35 = new q("AdFreeExperience", 34, "ad-free-experience");
        q qVar36 = new q("LyricsTranscriber", 35, "transcribe-lyrics");
        s = qVar36;
        q[] qVarArr = {qVar, qVar2, qVar3, qVar4, qVar5, qVar6, qVar7, qVar8, qVar9, qVar10, qVar11, qVar12, qVar13, qVar14, qVar15, qVar16, qVar17, qVar18, qVar19, qVar20, qVar21, qVar22, qVar23, qVar24, qVar25, qVar26, qVar27, qVar28, qVar29, qVar30, qVar31, qVar32, qVar33, qVar34, qVar35, qVar36};
        t = qVarArr;
        qg.a.j(qVarArr);
    }

    public q(String str, int i2, String str2) {
        this.a = str2;
    }

    public static q valueOf(String str) {
        return (q) Enum.valueOf(q.class, str);
    }

    public static q[] values() {
        return (q[]) t.clone();
    }
}
