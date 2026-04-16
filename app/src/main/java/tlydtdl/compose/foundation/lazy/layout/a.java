package tlydtdl.compose.foundation.lazy.layout;

import com.braze.vmsrhfaqrb.cards.Card;
import java.io.File;
import java.util.Comparator;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Comparator {
    public final /* synthetic */ int a;

    public /* synthetic */ a(int i) {
        this.a = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                return o.i(((v1) obj2).a, ((v1) obj).a);
            case 1:
                return o.i(((q0) obj).getIndex(), ((q0) obj2).getIndex());
            case 2:
                return o.i(((tlydtdl.compose.runtime.q0) obj).b, ((tlydtdl.compose.runtime.q0) obj2).b);
            case 3:
                lx1.l lVar = (lx1.l) obj;
                lx1.l lVar2 = (lx1.l) obj2;
                return (((Number) lVar.b).intValue() - ((Number) lVar.a).intValue()) - (((Number) lVar2.b).intValue() - ((Number) lVar2.a).intValue());
            case 4:
                Card card = (Card) obj;
                Card card2 = (Card) obj2;
                o.h(card, "cardA");
                o.h(card2, "cardB");
                if (!card.isPinned() || card2.isPinned()) {
                    return (card.isPinned() || !card2.isPinned()) ? 0 : 1;
                }
                return -1;
            case 5:
                Card card3 = (Card) obj;
                Card card4 = (Card) obj2;
                o.h(card3, "cardA");
                o.h(card4, "cardB");
                if (i30.e.a(card3) < i30.e.a(card4)) {
                    return -1;
                }
                return i30.e.a(card3) > i30.e.a(card4) ? 1 : 0;
            case 6:
                Card card5 = (Card) obj;
                Card card6 = (Card) obj2;
                o.h(card5, "cardA");
                o.h(card6, "cardB");
                if (card5.getCreated() > card6.getCreated()) {
                    return -1;
                }
                return card5.getCreated() < card6.getCreated() ? 1 : 0;
            case 7:
                Integer num = (Integer) obj;
                Integer num2 = (Integer) obj2;
                if (num.intValue() == -1) {
                    return num2.intValue() == -1 ? 0 : -1;
                }
                if (num2.intValue() == -1) {
                    return 1;
                }
                return num.intValue() - num2.intValue();
            case 8:
                return ((j9.o) obj).a - ((j9.o) obj2).a;
            case 9:
                return Float.compare(((j9.o) obj).c, ((j9.o) obj2).c);
            case 10:
                return com.braze.triggers.utils.b.a((com.braze.triggers.actions.a) obj, (com.braze.triggers.actions.a) obj2);
            case 11:
                byte[] bArr = (byte[]) obj;
                byte[] bArr2 = (byte[]) obj2;
                if (bArr.length != bArr2.length) {
                    return bArr.length - bArr2.length;
                }
                for (int i = 0; i < bArr.length; i++) {
                    byte b = bArr[i];
                    byte b3 = bArr2[i];
                    if (b != b3) {
                        return b - b3;
                    }
                }
                return 0;
            case 12:
                return Long.compare(((File) obj2).lastModified(), ((File) obj).lastModified());
            case 13:
                return ((st1.q1) obj).a.compareTo(((st1.q1) obj2).a);
            case 14:
                s4.j0 j0Var = (s4.j0) obj;
                s4.j0 j0Var2 = (s4.j0) obj2;
                float f2 = j0Var.F.p.E;
                float f3 = j0Var2.F.p.E;
                return f2 == f3 ? o.i(j0Var.w(), j0Var2.w()) : Float.compare(f2, f3);
            case 15:
                sn1.e eVar = (sn1.e) obj2;
                o.g(eVar, "o2");
                return ((sn1.e) obj).b(eVar);
            case 16:
                return ((File) obj2).getName().compareTo(((File) obj).getName());
            default:
                String name = ((File) obj).getName();
                int i2 = vt1.a.f;
                return name.substring(0, i2).compareTo(((File) obj2).getName().substring(0, i2));
        }
    }

    public /* synthetic */ a(i30.e eVar) {
        this.a = 5;
    }
}
