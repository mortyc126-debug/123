/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.Point
 *  android.graphics.PointF
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Region
 *  android.graphics.Region$Op
 *  kotlin.Metadata
 */
package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import kotlin.Metadata;

@Metadata(d1={"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\u0000\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\f\u001a\r\u0010\u0004\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\u0004\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\u0007\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\u0007\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\b\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\b\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\t\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\t\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0011*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u0012\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0005H\u0086\n\u001a\r\u0010\u0016\u001a\u00020\u0001*\u00020\u0003H\u0086\b\u001a\r\u0010\u0017\u001a\u00020\u0003*\u00020\u0001H\u0086\b\u001a\r\u0010\u0018\u001a\u00020\u0011*\u00020\u0001H\u0086\b\u001a\r\u0010\u0018\u001a\u00020\u0011*\u00020\u0003H\u0086\b\u001a\u0015\u0010\u0019\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\u0086\b\u001a\u0015\u0010\u001c\u001a\u00020\u0011*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u001c\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u00a8\u0006\u001d"}, d2={"and", "Landroid/graphics/Rect;", "r", "Landroid/graphics/RectF;", "component1", "", "", "component2", "component3", "component4", "contains", "", "p", "Landroid/graphics/Point;", "Landroid/graphics/PointF;", "minus", "xy", "Landroid/graphics/Region;", "or", "plus", "times", "factor", "toRect", "toRectF", "toRegion", "transform", "m", "Landroid/graphics/Matrix;", "xor", "core-ktx_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class RectKt {
    public static final Rect and(Rect rect, Rect rect2) {
        rect = new Rect(rect);
        rect.intersect(rect2);
        return rect;
    }

    public static final RectF and(RectF rectF, RectF rectF2) {
        rectF = new RectF(rectF);
        rectF.intersect(rectF2);
        return rectF;
    }

    public static final float component1(RectF rectF) {
        return rectF.left;
    }

    public static final int component1(Rect rect) {
        return rect.left;
    }

    public static final float component2(RectF rectF) {
        return rectF.top;
    }

    public static final int component2(Rect rect) {
        return rect.top;
    }

    public static final float component3(RectF rectF) {
        return rectF.right;
    }

    public static final int component3(Rect rect) {
        return rect.right;
    }

    public static final float component4(RectF rectF) {
        return rectF.bottom;
    }

    public static final int component4(Rect rect) {
        return rect.bottom;
    }

    public static final boolean contains(Rect rect, Point point) {
        return rect.contains(point.x, point.y);
    }

    public static final boolean contains(RectF rectF, PointF pointF) {
        return rectF.contains(pointF.x, pointF.y);
    }

    public static final Rect minus(Rect rect, int n) {
        rect = new Rect(rect);
        rect.offset(-n, -n);
        return rect;
    }

    public static final Rect minus(Rect rect, Point point) {
        rect = new Rect(rect);
        rect.offset(-point.x, -point.y);
        return rect;
    }

    public static final RectF minus(RectF rectF, float f) {
        rectF = new RectF(rectF);
        rectF.offset(-f, -f);
        return rectF;
    }

    public static final RectF minus(RectF rectF, PointF pointF) {
        rectF = new RectF(rectF);
        rectF.offset(-pointF.x, -pointF.y);
        return rectF;
    }

    public static final Region minus(Rect rect, Rect rect2) {
        rect = new Region(rect);
        rect.op(rect2, Region.Op.DIFFERENCE);
        return rect;
    }

    public static final Region minus(RectF rectF, RectF rectF2) {
        Rect rect = new Rect();
        rectF.roundOut(rect);
        rectF = new Region(rect);
        rect = new Rect();
        rectF2.roundOut(rect);
        rectF.op(rect, Region.Op.DIFFERENCE);
        return rectF;
    }

    public static final Rect or(Rect rect, Rect rect2) {
        rect = new Rect(rect);
        rect.union(rect2);
        return rect;
    }

    public static final RectF or(RectF rectF, RectF rectF2) {
        rectF = new RectF(rectF);
        rectF.union(rectF2);
        return rectF;
    }

    public static final Rect plus(Rect rect, int n) {
        rect = new Rect(rect);
        rect.offset(n, n);
        return rect;
    }

    public static final Rect plus(Rect rect, Point point) {
        rect = new Rect(rect);
        rect.offset(point.x, point.y);
        return rect;
    }

    public static final Rect plus(Rect rect, Rect rect2) {
        rect = new Rect(rect);
        rect.union(rect2);
        return rect;
    }

    public static final RectF plus(RectF rectF, float f) {
        rectF = new RectF(rectF);
        rectF.offset(f, f);
        return rectF;
    }

    public static final RectF plus(RectF rectF, PointF pointF) {
        rectF = new RectF(rectF);
        rectF.offset(pointF.x, pointF.y);
        return rectF;
    }

    public static final RectF plus(RectF rectF, RectF rectF2) {
        rectF = new RectF(rectF);
        rectF.union(rectF2);
        return rectF;
    }

    public static final Rect times(Rect rect, int n) {
        rect = new Rect(rect);
        rect.top *= n;
        rect.left *= n;
        rect.right *= n;
        rect.bottom *= n;
        return rect;
    }

    public static final RectF times(RectF rectF, float f) {
        rectF = new RectF(rectF);
        rectF.top *= f;
        rectF.left *= f;
        rectF.right *= f;
        rectF.bottom *= f;
        return rectF;
    }

    public static final RectF times(RectF rectF, int n) {
        float f = n;
        rectF = new RectF(rectF);
        rectF.top *= f;
        rectF.left *= f;
        rectF.right *= f;
        rectF.bottom *= f;
        return rectF;
    }

    public static final Rect toRect(RectF rectF) {
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return rect;
    }

    public static final RectF toRectF(Rect rect) {
        return new RectF(rect);
    }

    public static final Region toRegion(Rect rect) {
        return new Region(rect);
    }

    public static final Region toRegion(RectF rectF) {
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return new Region(rect);
    }

    public static final RectF transform(RectF rectF, Matrix matrix) {
        matrix.mapRect(rectF);
        return rectF;
    }

    public static final Region xor(Rect rect, Rect rect2) {
        rect = new Region(rect);
        rect.op(rect2, Region.Op.XOR);
        return rect;
    }

    public static final Region xor(RectF rectF, RectF rectF2) {
        Rect rect = new Rect();
        rectF.roundOut(rect);
        rect = new Region(rect);
        rectF = new Rect();
        rectF2.roundOut((Rect)rectF);
        rect.op((Rect)rectF, Region.Op.XOR);
        return rect;
    }
}

