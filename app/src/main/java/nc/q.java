package nc;

import amuvvoafs.content.res.ColorStateList;
import amuvvoafs.content.res.Resources;
import amuvvoafs.content.res.TypedArray;
import amuvvoafs.graphics.Canvas;
import amuvvoafs.graphics.ColorFilter;
import amuvvoafs.graphics.Matrix;
import amuvvoafs.graphics.PorterDuff;
import amuvvoafs.graphics.PorterDuffColorFilter;
import amuvvoafs.graphics.Rect;
import amuvvoafs.graphics.drawable.Drawable;
import amuvvoafs.util.AttributeSet;
import com.facebook.internal.t0;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import q1.f;
import sl0.z;
import uc0.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class q extends h {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final PorterDuff.Mode f340j = PorterDuff.Mode.SRC_IN;
    public o b;
    public PorterDuffColorFilter c;
    public ColorFilter d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f341f;
    public final float[] g;
    public final Matrix h;
    public final Rect i;

    public q() {
        this.f341f = true;
        this.g = new float[9];
        this.h = new Matrix();
        this.i = new Rect();
        this.b = new o();
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public final boolean canApplyTheme() {
        Drawable drawable = this.a;
        if (drawable == null) {
            return false;
        }
        drawable.canApplyTheme();
        return false;
    }

    public final void draw(Canvas canvas) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        Rect rect = this.i;
        copyBounds(rect);
        if (rect.width() <= 0 || rect.height() <= 0) {
            return;
        }
        PorterDuffColorFilter porterDuffColorFilter = this.d;
        if (porterDuffColorFilter == null) {
            porterDuffColorFilter = this.c;
        }
        Matrix matrix = this.h;
        canvas.getMatrix(matrix);
        float[] fArr = this.g;
        matrix.getValues(fArr);
        float fAbs = Math.abs(fArr[0]);
        float fAbs2 = Math.abs(fArr[4]);
        float fAbs3 = Math.abs(fArr[1]);
        float fAbs4 = Math.abs(fArr[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iWidth = (int) (rect.width() * fAbs);
        int iMin = Math.min(2048, iWidth);
        int iMin2 = Math.min(2048, (int) (rect.height() * fAbs2));
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(rect.left, rect.top);
        if (isAutoMirrored() && z.E(this) == 1) {
            canvas.translate(rect.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        rect.offsetTo(0, 0);
        this.b.b(iMin, iMin2);
        if (!this.f341f) {
            this.b.g(iMin, iMin2);
        } else if (!this.b.a()) {
            this.b.g(iMin, iMin2);
            this.b.f();
        }
        this.b.c(canvas, porterDuffColorFilter, rect);
        canvas.restoreToCount(iSave);
    }

    public final int getAlpha() {
        Drawable drawable = this.a;
        return drawable != null ? drawable.getAlpha() : this.b.b.getRootAlpha();
    }

    public final int getChangingConfigurations() {
        Drawable drawable = this.a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.b.getChangingConfigurations();
    }

    public final ColorFilter getColorFilter() {
        Drawable drawable = this.a;
        return drawable != null ? drawable.getColorFilter() : this.d;
    }

    public final Drawable.ConstantState getConstantState() {
        if (this.a != null) {
            return new p(this.a.getConstantState());
        }
        this.b.a = getChangingConfigurations();
        return this.b;
    }

    public final int getIntrinsicHeight() {
        Drawable drawable = this.a;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.b.b.i;
    }

    public final int getIntrinsicWidth() {
        Drawable drawable = this.a;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.b.b.h;
    }

    public final int getOpacity() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    public final void invalidateSelf() {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public final boolean isAutoMirrored() {
        Drawable drawable = this.a;
        return drawable != null ? drawable.isAutoMirrored() : this.b.e;
    }

    public final boolean isStateful() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (super.isStateful()) {
            return true;
        }
        o oVar = this.b;
        if (oVar == null) {
            return false;
        }
        if (oVar.d()) {
            return true;
        }
        ColorStateList colorStateList = this.b.c;
        return colorStateList != null && colorStateList.isStateful();
    }

    public final Drawable mutate() {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.e && super.mutate() == this) {
            this.b = new o(this.b);
            this.e = true;
        }
        return this;
    }

    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    public final boolean onStateChange(int[] iArr) {
        boolean z;
        PorterDuff.Mode mode;
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        o oVar = this.b;
        ColorStateList colorStateList = oVar.c;
        if (colorStateList == null || (mode = oVar.d) == null) {
            z = false;
        } else {
            this.c = a(colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (!oVar.d() || !oVar.e(iArr)) {
            return z;
        }
        invalidateSelf();
        return true;
    }

    public final void scheduleSelf(Runnable runnable, long j2) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j2);
        } else {
            super.scheduleSelf(runnable, j2);
        }
    }

    public final void setAlpha(int i) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else if (this.b.b.getRootAlpha() != i) {
            this.b.b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    public final void setAutoMirrored(boolean z) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setAutoMirrored(z);
        } else {
            this.b.e = z;
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.d = colorFilter;
            invalidateSelf();
        }
    }

    public final void setTint(int i) {
        Drawable drawable = this.a;
        if (drawable != null) {
            p.H(drawable, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
            return;
        }
        o oVar = this.b;
        if (oVar.c != colorStateList) {
            oVar.c = colorStateList;
            this.c = a(colorStateList, oVar.d);
            invalidateSelf();
        }
    }

    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setTintMode(mode);
            return;
        }
        o oVar = this.b;
        if (oVar.d != mode) {
            oVar.d = mode;
            this.c = a(oVar.c, mode);
            invalidateSelf();
        }
    }

    public final boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.a;
        return drawable != null ? drawable.setVisible(z, z2) : super.setVisible(z, z2);
    }

    public final void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
            return;
        }
        o oVar = this.b;
        oVar.b = new n();
        TypedArray typedArrayJ0 = t0.j0(resources, theme, attributeSet, a.a);
        o oVar2 = this.b;
        n nVar = oVar2.b;
        int iS = t0.S(typedArrayJ0, xmlPullParser, "tintMode", 6, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        if (iS == 3) {
            mode = PorterDuff.Mode.SRC_OVER;
        } else if (iS != 5) {
            if (iS != 9) {
                switch (iS) {
                    case 14:
                        mode = PorterDuff.Mode.MULTIPLY;
                        break;
                    case 15:
                        mode = PorterDuff.Mode.SCREEN;
                        break;
                    case 16:
                        mode = PorterDuff.Mode.ADD;
                        break;
                }
            } else {
                mode = PorterDuff.Mode.SRC_ATOP;
            }
        }
        oVar2.d = mode;
        ColorStateList colorStateListQ = t0.Q(typedArrayJ0, xmlPullParser, theme);
        if (colorStateListQ != null) {
            oVar2.c = colorStateListQ;
        }
        boolean z = oVar2.e;
        if (xmlPullParser.getAttributeValue("http://schemas.amuvvoafs.com/apk/res/amuvvoafs", "autoMirrored") != null) {
            z = typedArrayJ0.getBoolean(5, z);
        }
        oVar2.e = z;
        float f2 = nVar.j;
        if (xmlPullParser.getAttributeValue("http://schemas.amuvvoafs.com/apk/res/amuvvoafs", "viewportWidth") != null) {
            f2 = typedArrayJ0.getFloat(7, f2);
        }
        nVar.j = f2;
        float f3 = nVar.k;
        if (xmlPullParser.getAttributeValue("http://schemas.amuvvoafs.com/apk/res/amuvvoafs", "viewportHeight") != null) {
            f3 = typedArrayJ0.getFloat(8, f3);
        }
        nVar.k = f3;
        if (nVar.j <= 0.0f) {
            throw new XmlPullParserException(typedArrayJ0.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (f3 > 0.0f) {
            nVar.h = typedArrayJ0.getDimension(3, nVar.h);
            int i = 2;
            float dimension = typedArrayJ0.getDimension(2, nVar.i);
            nVar.i = dimension;
            if (nVar.h <= 0.0f) {
                throw new XmlPullParserException(typedArrayJ0.getPositionDescription() + "<vector> tag requires width > 0");
            }
            if (dimension > 0.0f) {
                float alpha = nVar.getAlpha();
                if (xmlPullParser.getAttributeValue("http://schemas.amuvvoafs.com/apk/res/amuvvoafs", "alpha") != null) {
                    alpha = typedArrayJ0.getFloat(4, alpha);
                }
                nVar.setAlpha(alpha);
                String string = typedArrayJ0.getString(0);
                if (string != null) {
                    nVar.m = string;
                    nVar.o.put(string, nVar);
                }
                typedArrayJ0.recycle();
                oVar.a = getChangingConfigurations();
                int i2 = 1;
                oVar.k = true;
                o oVar3 = this.b;
                n nVar2 = oVar3.b;
                ArrayDeque arrayDeque = new ArrayDeque();
                k kVar = nVar2.g;
                f fVar = nVar2.o;
                arrayDeque.push(kVar);
                int eventType = xmlPullParser.getEventType();
                int depth = xmlPullParser.getDepth() + 1;
                boolean z2 = true;
                while (eventType != i2 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
                    if (eventType == i) {
                        String name = xmlPullParser.getName();
                        k kVar2 = (k) arrayDeque.peek();
                        if (kVar2 != null) {
                            ArrayList arrayList = kVar2.b;
                            if ("path".equals(name)) {
                                j jVar = new j();
                                jVar.c(resources, xmlPullParser, attributeSet, theme);
                                arrayList.add(jVar);
                                if (jVar.getPathName() != null) {
                                    fVar.put(jVar.getPathName(), jVar);
                                }
                                oVar3.a = oVar3.a;
                                z2 = false;
                            } else if ("clip-path".equals(name)) {
                                i iVar = new i();
                                iVar.c(resources, xmlPullParser, attributeSet, theme);
                                arrayList.add(iVar);
                                if (iVar.getPathName() != null) {
                                    fVar.put(iVar.getPathName(), iVar);
                                }
                                oVar3.a = oVar3.a;
                            } else if ("group".equals(name)) {
                                k kVar3 = new k();
                                kVar3.c(resources, xmlPullParser, attributeSet, theme);
                                arrayList.add(kVar3);
                                arrayDeque.push(kVar3);
                                if (kVar3.getGroupName() != null) {
                                    fVar.put(kVar3.getGroupName(), kVar3);
                                }
                                oVar3.a = oVar3.a;
                            }
                        }
                    } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                        arrayDeque.pop();
                    }
                    eventType = xmlPullParser.next();
                    i2 = 1;
                    i = 2;
                }
                if (!z2) {
                    this.c = a(oVar.c, oVar.d);
                    return;
                }
                throw new XmlPullParserException("no path defined");
            }
            throw new XmlPullParserException(typedArrayJ0.getPositionDescription() + "<vector> tag requires height > 0");
        }
        throw new XmlPullParserException(typedArrayJ0.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    }

    public q(o oVar) {
        this.f341f = true;
        this.g = new float[9];
        this.h = new Matrix();
        this.i = new Rect();
        this.b = oVar;
        this.c = a(oVar.c, oVar.d);
    }
}
