package hj;

import amuvvoafs.content.Context;
import amuvvoafs.graphics.Canvas;
import amuvvoafs.graphics.Paint;
import amuvvoafs.graphics.RectF;
import amuvvoafs.graphics.Typeface;
import amuvvoafs.graphics.drawable.Drawable;
import amuvvoafs.text.TextPaint;
import amuvvoafs.text.TextUtils;
import i6.b;
import lmjxuqdtp.jvm.internal.o;
import x10.v;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j2 {
    public final Context a;
    public final h2 b;
    public final Drawable c;
    public final Drawable d;
    public d3 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f199f;
    public final TextPaint g;
    public final TextPaint h;
    public final TextPaint i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f200j;
    public String k;
    public final RectF l;
    public b3 m;

    public j2(Context context, d3 d3Var, h2 h2Var, float f2, b3 b3Var) {
        o.h(d3Var, "verticalPosition");
        o.h(h2Var, "attrs");
        Typeface typeface = h2Var.c;
        float f3 = h2Var.d;
        o.h(b3Var, "initialState");
        ld1.r rVar = b3Var.g;
        this.a = context;
        this.b = h2Var;
        Drawable drawable = h2Var.m;
        this.c = drawable != null ? drawable.mutate() : null;
        Drawable drawable2 = h2Var.l;
        this.d = drawable2 != null ? drawable2.mutate() : null;
        this.e = d3Var;
        this.f199f = f2;
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(qg.a.p(context, rVar));
        Paint.Style style = Paint.Style.FILL;
        textPaint.setStyle(style);
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(h2Var.b);
        textPaint.setTypeface(h2Var.a);
        Paint.Align align = Paint.Align.LEFT;
        textPaint.setTextAlign(align);
        textPaint.setLinearText(true);
        this.g = textPaint;
        TextPaint textPaint2 = new TextPaint();
        textPaint2.setColor(h2Var.e);
        textPaint2.setStyle(style);
        textPaint2.setAntiAlias(true);
        textPaint2.setTextSize(f3);
        textPaint2.setTypeface(typeface);
        textPaint2.setTextAlign(align);
        textPaint2.setLinearText(true);
        this.h = textPaint2;
        TextPaint textPaint3 = new TextPaint();
        textPaint3.setColor(b.g(qg.a.p(context, rVar), 130));
        textPaint3.setStyle(style);
        textPaint3.setAntiAlias(true);
        textPaint3.setTextSize(f3);
        textPaint3.setTypeface(typeface);
        textPaint3.setTextAlign(align);
        textPaint3.setLinearText(true);
        this.i = textPaint3;
        String str = b3Var.c;
        this.f200j = str != null ? TextUtils.ellipsize(str, textPaint, this.f199f - (h2Var.f196f * 2), TextUtils.TruncateAt.END).toString() : null;
        this.l = new RectF();
        this.m = b3Var;
        c();
    }

    public final void a(Canvas canvas, RectF rectF) {
        o.h(rectF, "viewPort");
        if (rectF.left > this.f199f) {
            return;
        }
        boolean z = this.m.f188f;
        TextPaint textPaint = this.g;
        h2 h2Var = this.b;
        if (z) {
            String str = this.f200j;
            if (str != null) {
                canvas.drawText(str, h2Var.f196f, (h2Var.b / 3) + com.facebook.appevents.l.q(this.e), textPaint);
                return;
            }
            return;
        }
        String str2 = this.f200j;
        String str3 = this.k;
        if (str2 != null) {
            canvas.drawText(str2, h2Var.f196f, com.facebook.appevents.l.q(this.e) - (h2Var.f196f / 2), textPaint);
        }
        float fB = b();
        float fB2 = b();
        TextPaint textPaint2 = this.i;
        RectF rectF2 = this.l;
        canvas.drawRoundRect(rectF2, fB, fB2, textPaint2);
        if (str3 == null) {
            Drawable drawable = this.c;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        float fB3 = b() + rectF2.left + h2Var.h;
        float f2 = h2Var.g;
        float f3 = fB3 + f2;
        float f4 = rectF2.top + f2;
        TextPaint textPaint3 = this.h;
        canvas.drawText(str3, f3, f4 - textPaint3.ascent(), textPaint3);
        Drawable drawable2 = this.d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    public final float b() {
        h2 h2Var = this.b;
        float f2 = 2;
        return ((h2Var.g * f2) + h2Var.h) / f2;
    }

    public final void c() {
        int iP;
        float fMeasureText;
        int iG;
        Drawable drawable;
        v vVar = this.m.d;
        Context context = this.a;
        String strN = vVar != null ? x10.a.n(context, vVar) : null;
        float f2 = this.f199f;
        h2 h2Var = this.b;
        float f3 = h2Var.f196f;
        float f4 = h2Var.f196f;
        int i = h2Var.e;
        float f5 = h2Var.h;
        float f7 = h2Var.g;
        float f8 = 2;
        float fB = (((f2 - (f3 * f8)) - f5) - f7) - (b() * f8);
        TextPaint textPaint = this.h;
        String string = strN != null ? TextUtils.ellipsize(strN, textPaint, fB, TextUtils.TruncateAt.END).toString() : null;
        this.k = string;
        if (string == null) {
            iP = by1.b.P(h2Var.i.getWidth());
            i = h2Var.f197j;
            iG = h2Var.n;
            drawable = this.c;
            fMeasureText = 0.0f;
        } else {
            iP = by1.b.P(f5);
            fMeasureText = textPaint.measureText(string);
            textPaint.setColor(i);
            iG = b.g(qg.a.p(context, this.m.g), 130);
            drawable = this.d;
        }
        float fQ = (f4 / f8) + com.facebook.appevents.l.q(this.e);
        float f9 = (h2Var.g * f8) + h2Var.h + fQ;
        this.l.set(f4, fQ, (b() * f8) + f4 + iP + fMeasureText, f9);
        this.i.setColor(iG);
        int iP2 = by1.b.P(fQ + f7);
        int iP3 = by1.b.P(f9 - f7);
        int iP4 = by1.b.P(b() + f4);
        int i2 = iP + iP4;
        if (drawable != null) {
            drawable.setBounds(iP4, iP2, i2, iP3);
            drawable.setTint(i);
        }
    }
}
