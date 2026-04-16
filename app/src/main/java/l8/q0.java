package l8;

import amuvvoafs.text.TextUtils;
import com.gnacba.amuvvoafs.gms.internal.ads.b2;
import f3.f2;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpStatus;
import uc0.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class q0 {
    public static final ArrayList a = new ArrayList();
    public static final Pattern b = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    public static boolean a(String str, String str2) {
        b2 b2VarF;
        int iA;
        if (str == null) {
            return false;
        }
        switch (str) {
            case "audio/mp4a-latm":
                if (str2 != null && (b2VarF = f(str2)) != null && (iA = b2VarF.a()) != 0 && iA != 16) {
                }
                break;
        }
        return false;
    }

    public static String b(String str, String str2) {
        if (str != null && str2 != null) {
            String[] strArrE0 = o8.f0.e0(str);
            StringBuilder sb = new StringBuilder();
            for (String str3 : strArrE0) {
                if (str2.equals(d(str3))) {
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    sb.append(str3);
                }
            }
            if (sb.length() > 0) {
                return sb.toString();
            }
        }
        return null;
    }

    public static int c(String str, String str2) {
        b2 b2VarF;
        str.getClass();
        switch (str) {
            case "audio/eac3-joc":
                return 18;
            case "audio/vnd.dts.hd;profile=lbr":
                return 8;
            case "audio/vnd.dts":
                return 7;
            case "audio/mp4a-latm":
                if (str2 == null || (b2VarF = f(str2)) == null) {
                    return 0;
                }
                return b2VarF.a();
            case "audio/ac3":
                return 5;
            case "audio/ac4":
                return 17;
            case "audio/vnd.dts.uhd;profile=p2":
                return 30;
            case "audio/eac3":
                return 6;
            case "audio/mpeg":
                return 9;
            case "audio/opus":
                return 20;
            case "audio/vnd.dts.hd":
                return 8;
            case "audio/true-hd":
                return 14;
            default:
                return 0;
        }
    }

    public static String d(String str) {
        b2 b2VarF;
        String strE = null;
        if (str != null) {
            String strN = p.N(str.trim());
            if (strN.startsWith("avc1") || strN.startsWith("avc3")) {
                return "video/avc";
            }
            if (strN.startsWith("hev1") || strN.startsWith("hvc1")) {
                return "video/hevc";
            }
            if (strN.startsWith("dvav") || strN.startsWith("dva1") || strN.startsWith("dvhe") || strN.startsWith("dvh1")) {
                return "video/dolby-vision";
            }
            if (strN.startsWith("av01")) {
                return "video/av01";
            }
            if (strN.startsWith("vp9") || strN.startsWith("vp09")) {
                return "video/x-vnd.on2.vp9";
            }
            if (strN.startsWith("vp8") || strN.startsWith("vp08")) {
                return "video/x-vnd.on2.vp8";
            }
            if (strN.startsWith("mp4a")) {
                if (strN.startsWith("mp4a.") && (b2VarF = f(strN)) != null) {
                    strE = e(b2VarF.a);
                }
                return strE == null ? "audio/mp4a-latm" : strE;
            }
            if (strN.startsWith("mha1")) {
                return "audio/mha1";
            }
            if (strN.startsWith("mhm1")) {
                return "audio/mhm1";
            }
            if (strN.startsWith("ac-3") || strN.startsWith("dac3")) {
                return "audio/ac3";
            }
            if (strN.startsWith("ec-3") || strN.startsWith("dec3")) {
                return "audio/eac3";
            }
            if (strN.startsWith("ec+3")) {
                return "audio/eac3-joc";
            }
            if (strN.startsWith("ac-4") || strN.startsWith("dac4")) {
                return "audio/ac4";
            }
            if (strN.startsWith("dtsc")) {
                return "audio/vnd.dts";
            }
            if (strN.startsWith("dtse")) {
                return "audio/vnd.dts.hd;profile=lbr";
            }
            if (strN.startsWith("dtsh") || strN.startsWith("dtsl")) {
                return "audio/vnd.dts.hd";
            }
            if (strN.startsWith("dtsx")) {
                return "audio/vnd.dts.uhd;profile=p2";
            }
            if (strN.startsWith("opus")) {
                return "audio/opus";
            }
            if (strN.startsWith("vorbis")) {
                return "audio/vorbis";
            }
            if (strN.startsWith("flac")) {
                return "audio/flac";
            }
            if (strN.startsWith("stpp")) {
                return "application/ttml+xml";
            }
            if (strN.startsWith("wvtt")) {
                return "text/vtt";
            }
            if (strN.contains("cea708")) {
                return "application/cea-708";
            }
            if (strN.contains("eia608") || strN.contains("cea608")) {
                return "application/cea-608";
            }
            ArrayList arrayList = a;
            if (arrayList.size() > 0) {
                f2.y(arrayList.get(0));
                throw null;
            }
        }
        return null;
    }

    public static String e(int i) {
        if (i == 32) {
            return "video/mp4v-es";
        }
        if (i == 33) {
            return "video/avc";
        }
        if (i == 35) {
            return "video/hevc";
        }
        if (i == 64) {
            return "audio/mp4a-latm";
        }
        if (i == 163) {
            return "video/wvc1";
        }
        if (i == 177) {
            return "video/x-vnd.on2.vp9";
        }
        if (i == 221) {
            return "audio/vorbis";
        }
        if (i == 165) {
            return "audio/ac3";
        }
        if (i == 166) {
            return "audio/eac3";
        }
        switch (i) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case HttpStatus.SC_SWITCHING_PROTOCOLS /* 101 */:
                return "video/mpeg2";
            case HttpStatus.SC_PROCESSING /* 102 */:
            case 103:
            case 104:
                return "audio/mp4a-latm";
            case 105:
            case 107:
                return "audio/mpeg";
            case 106:
                return "video/mpeg";
            case 108:
                return "image/jpeg";
            default:
                switch (i) {
                    case 169:
                    case 172:
                        return "audio/vnd.dts";
                    case 170:
                    case 171:
                        return "audio/vnd.dts.hd";
                    case 173:
                        return "audio/opus";
                    case 174:
                        return "audio/ac4";
                    default:
                        return null;
                }
        }
    }

    public static b2 f(String str) {
        Matcher matcher = b.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String strGroup = matcher.group(1);
        strGroup.getClass();
        String strGroup2 = matcher.group(2);
        try {
            return new b2(Integer.parseInt(strGroup, 16), strGroup2 != null ? Integer.parseInt(strGroup2) : 0);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static String g(String str) {
        int iIndexOf;
        if (str == null || (iIndexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, iIndexOf);
    }

    public static int h(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (i(str)) {
            return 1;
        }
        if (l(str)) {
            return 2;
        }
        if (k(str)) {
            return 3;
        }
        if (j(str)) {
            return 4;
        }
        if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str)) {
            return 5;
        }
        if ("application/x-camera-motion".equals(str)) {
            return 6;
        }
        ArrayList arrayList = a;
        if (arrayList.size() <= 0) {
            return -1;
        }
        f2.y(arrayList.get(0));
        throw null;
    }

    public static boolean i(String str) {
        return "audio".equals(g(str));
    }

    public static boolean j(String str) {
        return "image".equals(g(str)) || "application/x-image-uri".equals(str);
    }

    public static boolean k(String str) {
        return "text".equals(g(str)) || "application/x-media3-cues".equals(str) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str);
    }

    public static boolean l(String str) {
        return "video".equals(g(str));
    }

    public static String m(String str) {
        String strN;
        if (str == null) {
            return null;
        }
        strN = p.N(str);
        strN.getClass();
        switch (strN) {
            case "video/x-mvhevc":
                return "video/mv-hevc";
            case "audio/x-flac":
                return "audio/flac";
            case "application/x-mpegurl":
                return "application/x-mpegURL";
            case "audio/x-wav":
                return "audio/wav";
            case "audio/mpeg-l1":
                return "audio/mpeg-L1";
            case "audio/mpeg-l2":
                return "audio/mpeg-L2";
            case "audio/mp3":
                return "audio/mpeg";
            default:
                return strN;
        }
    }
}
