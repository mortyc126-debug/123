package hj;

import amuvvoafs.content.Context;
import amuvvoafs.graphics.Paint;
import amuvvoafs.graphics.Path;
import amuvvoafs.text.TextPaint;
import i6.b;
import ld1.q;
import st.w0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g0 {
    public final Paint a;
    public final float b;
    public final Paint c;
    public final Paint d;
    public final Paint e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f194f;
    public final Paint g;
    public final TextPaint h;
    public final Paint i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f195j;
    public final int k;
    public final float l;
    public final int m;
    public final Path n;

    public g0(Context context, float f2, Paint paint) {
        this.a = paint;
        float f3 = 12 * f2;
        this.b = f3;
        Paint paint2 = new Paint();
        paint2.setColor(qg.a.p(context, w0.N()));
        paint2.setStrokeWidth(f3);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint2.setStrokeCap(cap);
        this.c = paint2;
        Paint paint3 = new Paint();
        paint3.setColor(qg.a.p(context, w0.N()));
        float f4 = 8 * f2;
        paint3.setStrokeWidth(f4);
        paint3.setStrokeCap(cap);
        paint3.setAlpha(51);
        this.d = paint3;
        Paint paint4 = new Paint();
        paint4.setColor(qg.a.p(context, w0.K()));
        paint4.setStrokeWidth(f4);
        paint4.setStrokeCap(cap);
        this.e = paint4;
        Paint paint5 = new Paint();
        paint5.setStrokeWidth(f4);
        paint5.setStrokeCap(cap);
        this.f194f = paint5;
        Paint paint6 = new Paint();
        paint6.setColor(qg.a.p(context, w0.N()));
        paint6.setStyle(Paint.Style.STROKE);
        float f5 = 2;
        float f7 = f5 * f2;
        paint6.setStrokeWidth(f7);
        this.g = paint6;
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(qg.a.p(context, w0.K()));
        textPaint.setTextSize(14 * f2);
        textPaint.setTypeface(as.a.b(context));
        textPaint.setFontFeatureSettings("tnum");
        this.h = textPaint;
        Paint paint7 = new Paint();
        ld1.r.Companion.getClass();
        paint7.setColor(qg.a.p(context, new q(2131100883)));
        float f8 = 4 * f2;
        paint7.setShadowLayer(f8, 0.0f, f7, b.g(qg.a.p(context, w0.K()), 40));
        this.i = paint7;
        this.f195j = (int) f4;
        this.k = (int) (16 * f2);
        this.l = f8;
        this.m = (int) (20 * f2);
        Path path = new Path();
        path.lineTo(f4, 0.0f);
        path.lineTo(f4 / f5, f8);
        path.close();
        this.n = path;
    }
}
