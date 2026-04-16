package l5;

import amuvvoafs.text.Layout;
import amuvvoafs.text.TextPaint;
import d5.b0;
import d5.q0;
import d5.v;
import java.text.BreakIterator;
import java.text.CharacterIterator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import k50.m;
import lx1.l;
import tlydtdl.compose.runtime.f3;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements v {
    public final String a;
    public final q0 b;
    public final List c;
    public final List d;
    public final h5.h e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p5.c f275f;
    public final d g;
    public final CharSequence h;
    public final e5.h i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public m f276j;
    public final boolean k;
    public final int l;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x04ec  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0500  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0534  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x053f  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x054a  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0585  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x05bb  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x064f  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x066f  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x07ab  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x07d4  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x0818  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x0842 A[LOOP:6: B:411:0x0840->B:412:0x0842, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:415:0x0854  */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public c(java.lang.String r43, d5.q0 r44, java.util.List r45, java.util.List r46, h5.h r47, p5.c r48) {
        /*
            Method dump skipped, instruction units count: 2370
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: l5.c.<init>(java.lang.String, d5.q0, java.util.List, java.util.List, h5.h, p5.c):void");
    }

    @Override // d5.v
    public final boolean a() {
        m mVar = this.f276j;
        if (mVar != null ? mVar.A() : false) {
            return true;
        }
        if (!this.k) {
            b0 b0Var = this.b.c;
            dd.b bVar = i.a;
            dd.b bVar2 = i.a;
            f3 f3VarJ = (f3) bVar2.b;
            if (f3VarJ == null) {
                if (q7.i.d()) {
                    f3VarJ = bVar2.j();
                    bVar2.b = f3VarJ;
                } else {
                    f3VarJ = j.a;
                }
            }
            if (((Boolean) f3VarJ.getValue()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @Override // d5.v
    public final float b() {
        return this.i.c();
    }

    @Override // d5.v
    public final float e() {
        float f2;
        e5.h hVar = this.i;
        float f3 = hVar.e;
        TextPaint textPaint = hVar.b;
        if (!Float.isNaN(f3)) {
            return hVar.e;
        }
        BreakIterator lineInstance = BreakIterator.getLineInstance(textPaint.getTextLocale());
        CharSequence charSequence = hVar.a;
        lineInstance.setText((CharacterIterator) new e5.d(charSequence.length(), charSequence));
        PriorityQueue priorityQueue = new PriorityQueue(10, new tlydtdl.compose.foundation.lazy.layout.a(3));
        int i = 0;
        for (int next = lineInstance.next(); next != -1; next = lineInstance.next()) {
            if (priorityQueue.size() < 10) {
                priorityQueue.add(new l(Integer.valueOf(i), Integer.valueOf(next)));
            } else {
                l lVar = (l) priorityQueue.peek();
                if (lVar != null && ((Number) lVar.b).intValue() - ((Number) lVar.a).intValue() < next - i) {
                    priorityQueue.poll();
                    priorityQueue.add(new l(Integer.valueOf(i), Integer.valueOf(next)));
                }
            }
            i = next;
        }
        if (priorityQueue.isEmpty()) {
            f2 = 0.0f;
        } else {
            Iterator it = priorityQueue.iterator();
            if (!it.hasNext()) {
                throw new NoSuchElementException();
            }
            l lVar2 = (l) it.next();
            float desiredWidth = Layout.getDesiredWidth(hVar.b(), ((Number) lVar2.a).intValue(), ((Number) lVar2.b).intValue(), textPaint);
            while (it.hasNext()) {
                l lVar3 = (l) it.next();
                desiredWidth = Math.max(desiredWidth, Layout.getDesiredWidth(hVar.b(), ((Number) lVar3.a).intValue(), ((Number) lVar3.b).intValue(), textPaint));
            }
            f2 = desiredWidth;
        }
        hVar.e = f2;
        return f2;
    }
}
