/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Path
 *  android.graphics.PathMeasure
 *  android.util.AttributeSet
 *  android.view.InflateException
 *  android.view.animation.Interpolator
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import androidx.vectordrawable.graphics.drawable.AndroidResources;
import org.xmlpull.v1.XmlPullParser;

public class PathInterpolatorCompat
implements Interpolator {
    public static final double EPSILON = 1.0E-5;
    public static final int MAX_NUM_POINTS = 3000;
    private static final float PRECISION = 0.002f;
    private float[] mX;
    private float[] mY;

    public PathInterpolatorCompat(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    public PathInterpolatorCompat(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        resources = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_PATH_INTERPOLATOR);
        this.parseInterpolatorFromTypeArray((TypedArray)resources, xmlPullParser);
        resources.recycle();
    }

    private void initCubic(float f, float f2, float f3, float f4) {
        Path path2 = new Path();
        path2.moveTo(0.0f, 0.0f);
        path2.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
        this.initPath(path2);
    }

    private void initPath(Path object) {
        PathMeasure pathMeasure = new PathMeasure(object, false);
        float f = pathMeasure.getLength();
        int n = Math.min(3000, (int)(f / 0.002f) + 1);
        if (n > 0) {
            int n2;
            this.mX = new float[n];
            this.mY = new float[n];
            object = new float[2];
            for (n2 = 0; n2 < n; ++n2) {
                pathMeasure.getPosTan((float)n2 * f / (float)(n - 1), (float[])object, null);
                this.mX[n2] = (float)object[0];
                this.mY[n2] = (float)object[1];
            }
            if (!((double)Math.abs(this.mX[0]) > 1.0E-5 || (double)Math.abs(this.mY[0]) > 1.0E-5 || (double)Math.abs(this.mX[n - 1] - 1.0f) > 1.0E-5 || (double)Math.abs(this.mY[n - 1] - 1.0f) > 1.0E-5)) {
                f = 0.0f;
                int n3 = 0;
                n2 = 0;
                while (n2 < n) {
                    float f2 = this.mX[n3];
                    if (!(f2 < f)) {
                        this.mX[n2] = f2;
                        f = f2;
                        ++n2;
                        ++n3;
                        continue;
                    }
                    throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + f2);
                }
                if (!pathMeasure.nextContour()) {
                    return;
                }
                throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
            }
            throw new IllegalArgumentException("The Path must start at (0,0) and end at (1,1) start: " + this.mX[0] + "," + this.mY[0] + " end:" + this.mX[n - 1] + "," + this.mY[n - 1]);
        }
        throw new IllegalArgumentException("The Path has a invalid length " + f);
    }

    private void initQuad(float f, float f2) {
        Path path2 = new Path();
        path2.moveTo(0.0f, 0.0f);
        path2.quadTo(f, f2, 1.0f, 1.0f);
        this.initPath(path2);
    }

    private void parseInterpolatorFromTypeArray(TypedArray object, XmlPullParser xmlPullParser) {
        block8: {
            block9: {
                block10: {
                    block7: {
                        block5: {
                            block6: {
                                if (!TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) break block5;
                                if ((xmlPullParser = PathParser.createPathFromPathData((String)(object = TypedArrayUtils.getNamedString(object, xmlPullParser, "pathData", 4)))) == null) break block6;
                                this.initPath((Path)xmlPullParser);
                                break block7;
                            }
                            throw new InflateException("The path is null, which is created from " + (String)object);
                        }
                        if (!TypedArrayUtils.hasAttribute(xmlPullParser, "controlX1")) break block8;
                        if (!TypedArrayUtils.hasAttribute(xmlPullParser, "controlY1")) break block9;
                        float f = TypedArrayUtils.getNamedFloat(object, xmlPullParser, "controlX1", 0, 0.0f);
                        float f2 = TypedArrayUtils.getNamedFloat(object, xmlPullParser, "controlY1", 1, 0.0f);
                        boolean bl = TypedArrayUtils.hasAttribute(xmlPullParser, "controlX2");
                        if (bl != TypedArrayUtils.hasAttribute(xmlPullParser, "controlY2")) break block10;
                        if (!bl) {
                            this.initQuad(f, f2);
                        } else {
                            this.initCubic(f, f2, TypedArrayUtils.getNamedFloat(object, xmlPullParser, "controlX2", 2, 0.0f), TypedArrayUtils.getNamedFloat(object, xmlPullParser, "controlY2", 3, 0.0f));
                        }
                    }
                    return;
                }
                throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
            }
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
        throw new InflateException("pathInterpolator requires the controlX1 attribute");
    }

    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int n = 0;
        int n2 = this.mX.length - 1;
        while (n2 - n > 1) {
            int n3 = (n + n2) / 2;
            if (f < this.mX[n3]) {
                n2 = n3;
                continue;
            }
            n = n3;
        }
        float f2 = this.mX[n2] - this.mX[n];
        if (f2 == 0.0f) {
            return this.mY[n];
        }
        f2 = (f - this.mX[n]) / f2;
        f = this.mY[n];
        return (this.mY[n2] - f) * f2 + f;
    }
}

