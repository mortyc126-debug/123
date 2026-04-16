package zi;

import bb.w;
import com.bandlab.bandlab.utils.debug.DebugUtils;
import com.bandlab.bandlab.utils.debug.TaggedException;
import com.gnacba.amuvvoafs.gms.internal.measurement.b4;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Locale;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.internal.o;
import lmjxuqdtp.time.l;
import md1.b1;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public final c a;
    public final y10.g b;
    public final lmjxuqdtp.time.e c;

    public a(c cVar, y10.g gVar, lmjxuqdtp.time.e eVar) {
        this.a = cVar;
        this.b = gVar;
        this.c = eVar;
    }

    public static String b(LocalDateTime localDateTime, FormatStyle formatStyle, FormatStyle formatStyle2) {
        DateTimeFormatter dateTimeFormatterOfLocalizedTime;
        String string;
        if (formatStyle != null && formatStyle2 != null) {
            dateTimeFormatterOfLocalizedTime = DateTimeFormatter.ofLocalizedDateTime(formatStyle, formatStyle2);
        } else if (formatStyle != null) {
            dateTimeFormatterOfLocalizedTime = DateTimeFormatter.ofLocalizedDate(formatStyle);
        } else {
            if (formatStyle2 == null) {
                throw new IllegalStateException("Both dateStyle and timeStyle are null");
            }
            dateTimeFormatterOfLocalizedTime = DateTimeFormatter.ofLocalizedTime(formatStyle2);
        }
        try {
            String str = localDateTime.format(dateTimeFormatterOfLocalizedTime);
            o.e(str);
            return str;
        } catch (Exception e) {
            String str2 = "Failed to format date with locale " + Locale.getDefault();
            w wVar = new w(2);
            ArrayList arrayList = wVar.a;
            wVar.a("CRITICAL");
            wVar.e(new String[]{"DateTimeFormatter"});
            TaggedException taggedException = new TaggedException(e, (String[]) arrayList.toArray(new String[arrayList.size()]));
            if (str2 == null) {
                str2 = HttpUrl.FRAGMENT_ENCODE_SET;
            }
            DebugUtils.handleThrowable(new IllegalStateException(str2, taggedException));
            try {
                string = localDateTime.format(dateTimeFormatterOfLocalizedTime.withLocale(Locale.ROOT));
            } catch (Exception e2) {
                w wVar2 = new w(2);
                ArrayList arrayList2 = wVar2.a;
                wVar2.a("CRITICAL");
                wVar2.e(new String[]{"DateTimeFormatter"});
                DebugUtils.handleThrowable(new IllegalStateException("Failed to format date time with Locale.ROOT", new TaggedException(e2, (String[]) arrayList2.toArray(new String[arrayList2.size()]))));
                string = localDateTime.toString();
            }
            o.e(string);
            return string;
        }
    }

    public static /* synthetic */ String c(a aVar, LocalDateTime localDateTime, int i) {
        FormatStyle formatStyle = FormatStyle.MEDIUM;
        FormatStyle formatStyle2 = FormatStyle.SHORT;
        if ((i & 1) != 0) {
            formatStyle = null;
        }
        if ((i & 2) != 0) {
            formatStyle2 = null;
        }
        aVar.getClass();
        return b(localDateTime, formatStyle, formatStyle2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public static final String e(a aVar, l lVar, y10.l lVar2, String str) throws NoWhenBranchMatchedException {
        y10.g gVar = aVar.b;
        LocalDateTime localDateTimeD = y10.g.d(lVar);
        int iOrdinal = lVar2.ordinal();
        if (iOrdinal == 0) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (iOrdinal == 1) {
            return str;
        }
        if (iOrdinal == 2) {
            LocalDateTime localDateTimeD2 = y10.g.d(lVar);
            FormatStyle formatStyle = FormatStyle.SHORT;
            return b1.j(str, ", ", c(aVar, localDateTimeD2, 1));
        }
        if (iOrdinal != 3) {
            throw new NoWhenBranchMatchedException();
        }
        FormatStyle formatStyle2 = FormatStyle.MEDIUM;
        return b1.j(str, ", ", c(aVar, localDateTimeD, 2));
    }

    public final s70.k a(l lVar) {
        o.h(lVar, "instant");
        return new s70.k(lVar, this.c, this.b, this);
    }

    public final String d(l lVar, y10.l lVar2) {
        o.h(lVar, "instant");
        o.h(lVar2, "tensePresentation");
        LocalDateTime localDateTimeD = y10.g.d(lVar);
        lmjxuqdtp.time.e eVar = this.c;
        boolean zH = b4.H(lVar, eVar.a());
        boolean zH2 = b4.H(lVar, eVar.a().b(b.c));
        y10.l lVar3 = y10.l.b;
        c cVar = this.a;
        return (lVar2 == lVar3 || !zH) ? (lVar2 == lVar3 || !zH2) ? b(localDateTimeD, FormatStyle.MEDIUM, lVar2.a) : e(this, lVar, lVar2, cVar.d(2132020683)) : e(this, lVar, lVar2, cVar.d(2132020371));
    }
}
