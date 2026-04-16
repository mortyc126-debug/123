package bh;

import a4.q;
import amuvvoafs.os.Bundle;
import amuvvoafs.os.Parcel;
import com.bandlab.bandlab.utils.debug.DebugUtils;
import com.bandlab.bandlab.utils.debug.TaggedException;
import com.facebook.s;
import com.gnacba.amuvvoafs.gms.internal.ads.pt;
import com.gnacba.amuvvoafs.gms.internal.ads.zr1;
import com.gnacba.amuvvoafs.gms.internal.play_billing.k1;
import com.ironsource.i9;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import kotlin.io.encoding.Base64;
import ld1.d;
import lg.e;
import md1.g;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.commons.net.finger.FingerClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.imap.IMAP;
import org.apache.commons.net.nntp.NNTP;
import org.apache.commons.net.tftp.TFTP;
import org.apache.commons.net.whois.WhoisClient;
import org.apache.http.HttpStatus;
import st.w0;
import tlydtdl.compose.foundation.layout.m;
import z.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class j {
    public static void A(yp1.b bVar, Bundle bundle, String str) {
        bVar.getClass();
        bundle.putLong(str, System.currentTimeMillis());
    }

    public static int B(int i, int i2, int i3) {
        return zr1.x(i) + i2 + i3;
    }

    public static int C(int i, int i2, int i3, int i4) {
        return k1.S(i) + i2 + i3 + i4;
    }

    public static int D(int i, int i2, int i3) {
        return k1.S(i) + i2 + i3;
    }

    public static /* synthetic */ String E(int i) {
        switch (i) {
            case 1:
                return "CLIENT_UPLOAD_ELIGIBILITY_UNKNOWN";
            case 2:
                return "CLIENT_UPLOAD_ELIGIBLE";
            case 3:
                return "MEASUREMENT_SERVICE_NOT_ENABLED";
            case 4:
                return "ANDROID_TOO_OLD";
            case 5:
                return "NON_PLAY_MODE";
            case 6:
                return "SDK_TOO_OLD";
            case 7:
                return "MISSING_JOB_SCHEDULER";
            case 8:
                return "NOT_ENABLED_IN_MANIFEST";
            case 9:
                return "CLIENT_FLAG_OFF";
            case 10:
                return "SERVICE_FLAG_OFF";
            case 11:
                return "PINNED_TO_SERVICE_UPLOAD";
            case 12:
                return "MISSING_SGTM_SERVER_URL";
            default:
                throw null;
        }
    }

    public static /* synthetic */ String F(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "null" : "VIDEO" : "NATIVE_DISPLAY" : "HTML_DISPLAY";
    }

    public static final int a(int i) {
        s sVar = s.a;
        w0.x0();
        return p.k(i) + s.i;
    }

    public static int b(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
                return 7;
            case 7:
                return 8;
            case 8:
                return 9;
            default:
                switch (i) {
                    case 20:
                        return 10;
                    case 21:
                        return 11;
                    case 22:
                        return 12;
                    default:
                        return 0;
                }
        }
    }

    public static int c(int i) {
        if (i == 90) {
            return 81;
        }
        if (i == 91) {
            return 82;
        }
        if (i == 93) {
            return 84;
        }
        if (i == 94) {
            return 85;
        }
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
                return 7;
            case 7:
                return 8;
            case 8:
                return 9;
            case 9:
                return 10;
            case 10:
                return 11;
            case 11:
                return 12;
            case 12:
                return 13;
            case 13:
                return 14;
            case 14:
                return 15;
            case 15:
                return 16;
            case 16:
                return 17;
            case 17:
                return 18;
            case 18:
                return 19;
            case 19:
                return 20;
            case 20:
                return 21;
            case 21:
                return 22;
            case 22:
                return 23;
            case 23:
                return 24;
            case 24:
                return 25;
            case 25:
                return 26;
            case 26:
                return 27;
            case 27:
                return 28;
            case 28:
                return 29;
            case 29:
                return 30;
            case 30:
                return 31;
            case 31:
                return 32;
            case 32:
                return 33;
            case 33:
                return 34;
            case 34:
                return 35;
            case 35:
                return 36;
            case 36:
                return 37;
            case 37:
                return 38;
            case 38:
                return 39;
            case 39:
                return 40;
            case 40:
                return 41;
            case 41:
                return 42;
            case 42:
                return 43;
            case WhoisClient.DEFAULT_PORT /* 43 */:
                return 44;
            case 44:
                return 45;
            case 45:
                return 46;
            case 46:
                return 47;
            case 47:
                return 48;
            case m.g /* 48 */:
                return 49;
            case 49:
                return 50;
            case 50:
                return 51;
            case 51:
                return 52;
            case 52:
                return 53;
            case 53:
                return 54;
            case 54:
                return 55;
            case 55:
                return 56;
            case 56:
                return 57;
            case 57:
                return 58;
            case 58:
                return 59;
            case 59:
                return 60;
            case 60:
                return 61;
            case 61:
                return 62;
            case 62:
                return 63;
            case 63:
                return 64;
            case 64:
                return 65;
            case 65:
                return 66;
            case 66:
                return 67;
            case 67:
                return 68;
            case 68:
                return 69;
            case TFTP.DEFAULT_PORT /* 69 */:
                return 70;
            case 70:
                return 71;
            case 71:
                return 72;
            case 72:
                return 73;
            case 73:
                return 74;
            case 74:
                return 75;
            case 75:
                return 76;
            case Base64.mimeLineLength /* 76 */:
                return 77;
            case 77:
                return 78;
            case 78:
                return 79;
            case FingerClient.DEFAULT_PORT /* 79 */:
                return 80;
            default:
                switch (i) {
                    case 96:
                        return 87;
                    case 97:
                        return 88;
                    case 98:
                        return 89;
                    case 99:
                        return 90;
                    case 100:
                        return 91;
                    case HttpStatus.SC_SWITCHING_PROTOCOLS /* 101 */:
                        return 92;
                    case HttpStatus.SC_PROCESSING /* 102 */:
                        return 83;
                    case 103:
                        return 86;
                    case 104:
                        return 93;
                    case 105:
                        return 94;
                    case 106:
                        return 95;
                    case 107:
                        return 96;
                    case 108:
                        return 97;
                    case 109:
                        return 98;
                    case 110:
                        return 99;
                    case 111:
                        return 100;
                    case 112:
                        return HttpStatus.SC_SWITCHING_PROTOCOLS;
                    case 113:
                        return HttpStatus.SC_PROCESSING;
                    case 114:
                        return 103;
                    case 115:
                        return 104;
                    case 116:
                        return 105;
                    case 117:
                        return 106;
                    case 118:
                        return 107;
                    case NNTP.DEFAULT_PORT /* 119 */:
                        return 108;
                    case FTPReply.SERVICE_NOT_READY /* 120 */:
                        return 109;
                    case 121:
                        return 110;
                    case 122:
                        return 111;
                    case 123:
                        return 112;
                    case 124:
                        return 113;
                    case FTPReply.DATA_CONNECTION_ALREADY_OPEN /* 125 */:
                        return 114;
                    case WebSocketProtocol.PAYLOAD_SHORT /* 126 */:
                        return 117;
                    case 127:
                        return NNTP.DEFAULT_PORT;
                    case 128:
                        return FTPReply.SERVICE_NOT_READY;
                    case 129:
                        return 121;
                    case 130:
                        return 122;
                    case 131:
                        return 123;
                    case 132:
                        return 124;
                    case 133:
                        return FTPReply.DATA_CONNECTION_ALREADY_OPEN;
                    case 134:
                        return WebSocketProtocol.PAYLOAD_SHORT;
                    case 135:
                        return 127;
                    case 136:
                        return 128;
                    case 137:
                        return 129;
                    case 138:
                        return 130;
                    case 139:
                        return 131;
                    case 140:
                        return 132;
                    case 141:
                        return 133;
                    case 142:
                        return 134;
                    case IMAP.DEFAULT_PORT /* 143 */:
                        return 135;
                    case 144:
                        return 136;
                    case 145:
                        return 115;
                    case 146:
                        return 116;
                    case 147:
                        return 118;
                    case 148:
                        return 137;
                    case 149:
                        return 138;
                    default:
                        return 0;
                }
        }
    }

    public static /* synthetic */ int d(int i) {
        switch (i) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            case 7:
                return 6;
            case 8:
                return 7;
            case 9:
                return 8;
            case 10:
                return 9;
            case 11:
                return 10;
            case 12:
                return 11;
            case 13:
                return 12;
            case 14:
                return 13;
            case 15:
                return 14;
            case 16:
                return 15;
            case 17:
                return 16;
            case 18:
                return 17;
            case 19:
                return 18;
            case 20:
                return 19;
            case 21:
                return 20;
            case 22:
                return 21;
            case 23:
                return 22;
            case 24:
                return 23;
            case 25:
                return 24;
            case 26:
                return 25;
            case 27:
                return 26;
            case 28:
                return 27;
            case 29:
                return 28;
            case 30:
                return 29;
            case 31:
                return 30;
            case 32:
                return 31;
            case 33:
                return 32;
            case 34:
                return 33;
            case 35:
                return 34;
            case 36:
                return 35;
            case 37:
                return 36;
            case 38:
                return 37;
            case 39:
                return 38;
            case 40:
                return 39;
            case 41:
                return 40;
            case 42:
                return 41;
            case WhoisClient.DEFAULT_PORT /* 43 */:
                return 42;
            case 44:
                return 43;
            case 45:
                return 44;
            case 46:
                return 45;
            case 47:
                return 46;
            case m.g /* 48 */:
                return 47;
            case 49:
                return 48;
            case 50:
                return 49;
            case 51:
                return 50;
            case 52:
                return 51;
            case 53:
                return 52;
            case 54:
                return 53;
            case 55:
                return 54;
            case 56:
                return 55;
            case 57:
                return 56;
            case 58:
                return 57;
            case 59:
                return 58;
            case 60:
                return 59;
            case 61:
                return 60;
            case 62:
                return 61;
            case 63:
                return 62;
            case 64:
                return 63;
            case 65:
                return 64;
            case 66:
                return 65;
            case 67:
                return 66;
            case 68:
                return 67;
            case TFTP.DEFAULT_PORT /* 69 */:
                return 68;
            case 70:
                return 69;
            case 71:
                return 70;
            case 72:
                return 71;
            case 73:
                return 72;
            case 74:
                return 73;
            case 75:
                return 74;
            case Base64.mimeLineLength /* 76 */:
                return 75;
            case 77:
                return 76;
            case 78:
                return 77;
            case FingerClient.DEFAULT_PORT /* 79 */:
                return 78;
            case 80:
                return 79;
            case 81:
                return 90;
            case 82:
                return 91;
            case 83:
                return HttpStatus.SC_PROCESSING;
            case 84:
                return 93;
            case 85:
                return 94;
            case 86:
                return 103;
            case 87:
                return 96;
            case 88:
                return 97;
            case 89:
                return 98;
            case 90:
                return 99;
            case 91:
                return 100;
            case 92:
                return HttpStatus.SC_SWITCHING_PROTOCOLS;
            case 93:
                return 104;
            case 94:
                return 105;
            case 95:
                return 106;
            case 96:
                return 107;
            case 97:
                return 108;
            case 98:
                return 109;
            case 99:
                return 110;
            case 100:
                return 111;
            case HttpStatus.SC_SWITCHING_PROTOCOLS /* 101 */:
                return 112;
            case HttpStatus.SC_PROCESSING /* 102 */:
                return 113;
            case 103:
                return 114;
            case 104:
                return 115;
            case 105:
                return 116;
            case 106:
                return 117;
            case 107:
                return 118;
            case 108:
                return NNTP.DEFAULT_PORT;
            case 109:
                return FTPReply.SERVICE_NOT_READY;
            case 110:
                return 121;
            case 111:
                return 122;
            case 112:
                return 123;
            case 113:
                return 124;
            case 114:
                return FTPReply.DATA_CONNECTION_ALREADY_OPEN;
            case 115:
                return 145;
            case 116:
                return 146;
            case 117:
                return WebSocketProtocol.PAYLOAD_SHORT;
            case 118:
                return 147;
            case NNTP.DEFAULT_PORT /* 119 */:
                return 127;
            case FTPReply.SERVICE_NOT_READY /* 120 */:
                return 128;
            case 121:
                return 129;
            case 122:
                return 130;
            case 123:
                return 131;
            case 124:
                return 132;
            case FTPReply.DATA_CONNECTION_ALREADY_OPEN /* 125 */:
                return 133;
            case WebSocketProtocol.PAYLOAD_SHORT /* 126 */:
                return 134;
            case 127:
                return 135;
            case 128:
                return 136;
            case 129:
                return 137;
            case 130:
                return 138;
            case 131:
                return 139;
            case 132:
                return 140;
            case 133:
                return 141;
            case 134:
                return 142;
            case 135:
                return IMAP.DEFAULT_PORT;
            case 136:
                return 144;
            case 137:
                return 148;
            case 138:
                return 149;
            default:
                throw null;
        }
    }

    public static /* synthetic */ String e(int i) {
        if (i == 1) {
            return "htmlDisplay";
        }
        if (i == 2) {
            return "nativeDisplay";
        }
        if (i == 3) {
            return "video";
        }
        throw null;
    }

    public static /* synthetic */ String f(int i) {
        if (i == 1) {
            return "beginToRender";
        }
        if (i == 2) {
            return "definedByJavascript";
        }
        if (i == 3) {
            return "onePixel";
        }
        if (i == 4) {
            return "unspecified";
        }
        throw null;
    }

    public static /* synthetic */ int g(int i) {
        switch (i) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            case 7:
                return 6;
            case 8:
                return 7;
            case 9:
                return 8;
            case 10:
                return 20;
            case 11:
                return 21;
            case 12:
                return 22;
            default:
                throw null;
        }
    }

    public static int h(int i, int i2, int i3) {
        int i4 = i / i2;
        return i4 + i4 + i3;
    }

    public static int i(int i, int i2, int i3, int i4) {
        return zr1.x(i) + i2 + i3 + i4;
    }

    public static int j(int i, int i2, int i3, int i4, int i6) {
        return Math.max(((i * i2) / i3) + i4, i6);
    }

    public static int k(int i, String str) {
        return String.valueOf(str).length() + i;
    }

    public static int l(Set set, int i, int i2) {
        return (set.hashCode() + i) * i2;
    }

    public static long m() {
        return new Date().getTime();
    }

    public static q n(int i, int i2, tlydtdl.compose.runtime.s sVar, d dVar) {
        dVar.getClass();
        return g.f0(new ld1.q(i), sVar, i2);
    }

    public static bq1.a o(Parcel parcel) {
        bq1.a aVarM4 = bq1.b.m4(parcel.readStrongBinder());
        parcel.recycle();
        return aVarM4;
    }

    public static String p(StringBuilder sb, int i, String str, int i2, String str2) {
        sb.append(str);
        sb.append(i);
        sb.append(str2);
        sb.append(i2);
        return sb.toString();
    }

    public static String q(StringBuilder sb, String str, int i, String str2) {
        sb.append(str);
        sb.append(i);
        sb.append(str2);
        return sb.toString();
    }

    public static StringBuilder r(String str, Exception exc) {
        i9.d().a(exc);
        return new StringBuilder(str);
    }

    public static StringBuilder s(String str, String str2, String str3, String str4, boolean z) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(z);
        sb.append(str4);
        return sb;
    }

    public static ArrayList t(Object obj) {
        e.O(obj);
        return new ArrayList();
    }

    public static HashMap u(String str, String str2) {
        HashMap map = new HashMap();
        map.put(str, str2);
        return map;
    }

    public static void v(int i, String str, String str2, String str3, StringBuilder sb) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(i);
    }

    public static void w(String str, TaggedException taggedException) {
        DebugUtils.handleThrowable(new IllegalStateException(str, taggedException));
    }

    public static void x(String str, String str2, String str3) {
        pt.r(str3, str2.concat(String.valueOf(str)));
    }

    public static void y(String str, String str2, String str3, StringBuilder sb, boolean z) {
        sb.append(z);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
    }

    public static void z(StringBuilder sb, String str, int i, String str2) {
        sb.append(str);
        sb.append(i);
        pt.r(str2, sb.toString());
    }
}
