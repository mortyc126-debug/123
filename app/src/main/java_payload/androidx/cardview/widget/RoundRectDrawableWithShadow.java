/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.LinearGradient
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.Path$FillType
 *  android.graphics.RadialGradient
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.drawable.Drawable
 */
package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.cardview.R;

class RoundRectDrawableWithShadow
extends Drawable {
    private static final double COS_45 = Math.cos(Math.toRadians(45.0));
    private static final float SHADOW_MULTIPLIER = 1.5f;
    static RoundRectHelper sRoundRectHelper;
    private boolean mAddPaddingForCorners = true;
    private ColorStateList mBackground;
    private final RectF mCardBounds;
    private float mCornerRadius;
    private Paint mCornerShadowPaint;
    private Path mCornerShadowPath;
    private boolean mDirty = true;
    private Paint mEdgeShadowPaint;
    private final int mInsetShadow;
    private Paint mPaint;
    private boolean mPrintedShadowClipWarning = false;
    private float mRawMaxShadowSize;
    private float mRawShadowSize;
    private final int mShadowEndColor;
    private float mShadowSize;
    private final int mShadowStartColor;

    RoundRectDrawableWithShadow(Resources resources, ColorStateList colorStateList, float f, float f2, float f3) {
        this.mShadowStartColor = resources.getColor(R.color.cardview_shadow_start_color);
        this.mShadowEndColor = resources.getColor(R.color.cardview_shadow_end_color);
        this.mInsetShadow = resources.getDimensionPixelSize(R.dimen.cardview_compat_inset_shadow);
        this.mPaint = new Paint(5);
        this.setBackground(colorStateList);
        this.mCornerShadowPaint = new Paint(5);
        this.mCornerShadowPaint.setStyle(Paint.Style.FILL);
        this.mCornerRadius = (int)(0.5f + f);
        this.mCardBounds = new RectF();
        this.mEdgeShadowPaint = new Paint(this.mCornerShadowPaint);
        this.mEdgeShadowPaint.setAntiAlias(false);
        this.setShadowSize(f2, f3);
    }

    private void buildComponents(Rect rect) {
        float f = this.mRawMaxShadowSize * 1.5f;
        this.mCardBounds.set((float)rect.left + this.mRawMaxShadowSize, (float)rect.top + f, (float)rect.right - this.mRawMaxShadowSize, (float)rect.bottom - f);
        this.buildShadowCorners();
    }

    private void buildShadowCorners() {
        RectF rectF = new RectF(-this.mCornerRadius, -this.mCornerRadius, this.mCornerRadius, this.mCornerRadius);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.mShadowSize, -this.mShadowSize);
        if (this.mCornerShadowPath == null) {
            this.mCornerShadowPath = new Path();
        } else {
            this.mCornerShadowPath.reset();
        }
        this.mCornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
        this.mCornerShadowPath.moveTo(-this.mCornerRadius, 0.0f);
        this.mCornerShadowPath.rLineTo(-this.mShadowSize, 0.0f);
        this.mCornerShadowPath.arcTo(rectF2, 180.0f, 90.0f, false);
        this.mCornerShadowPath.arcTo(rectF, 270.0f, -90.0f, false);
        this.mCornerShadowPath.close();
        float f = this.mCornerRadius / (this.mCornerRadius + this.mShadowSize);
        rectF = this.mCornerShadowPaint;
        float f2 = this.mCornerRadius;
        float f3 = this.mShadowSize;
        int n = this.mShadowStartColor;
        int n2 = this.mShadowStartColor;
        int n3 = this.mShadowEndColor;
        rectF2 = Shader.TileMode.CLAMP;
        rectF.setShader((Shader)new RadialGradient(0.0f, 0.0f, f3 + f2, new int[]{n, n2, n3}, new float[]{0.0f, f, 1.0f}, (Shader.TileMode)rectF2));
        rectF = this.mEdgeShadowPaint;
        float f4 = -this.mCornerRadius;
        f = this.mShadowSize;
        f2 = -this.mCornerRadius;
        f3 = this.mShadowSize;
        n2 = this.mShadowStartColor;
        n3 = this.mShadowStartColor;
        n = this.mShadowEndColor;
        rectF2 = Shader.TileMode.CLAMP;
        rectF.setShader((Shader)new LinearGradient(0.0f, f4 + f, 0.0f, f2 - f3, new int[]{n2, n3, n}, new float[]{0.0f, 0.5f, 1.0f}, (Shader.TileMode)rectF2));
        this.mEdgeShadowPaint.setAntiAlias(false);
    }

    static float calculateHorizontalPadding(float f, float f2, boolean bl) {
        if (bl) {
            return (float)((double)f + (1.0 - COS_45) * (double)f2);
        }
        return f;
    }

    static float calculateVerticalPadding(float f, float f2, boolean bl) {
        if (bl) {
            return (float)((double)(1.5f * f) + (1.0 - COS_45) * (double)f2);
        }
        return 1.5f * f;
    }

    private void drawShadow(Canvas canvas) {
        float f = -this.mCornerRadius - this.mShadowSize;
        float f2 = this.mCornerRadius + (float)this.mInsetShadow + this.mRawShadowSize / 2.0f;
        float f3 = this.mCardBounds.width();
        boolean bl = true;
        int n = f3 - f2 * 2.0f > 0.0f ? 1 : 0;
        if (!(this.mCardBounds.height() - f2 * 2.0f > 0.0f)) {
            bl = false;
        }
        int n2 = canvas.save();
        canvas.translate(this.mCardBounds.left + f2, this.mCardBounds.top + f2);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (n != 0) {
            canvas.drawRect(0.0f, f, this.mCardBounds.width() - f2 * 2.0f, -this.mCornerRadius, this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(n2);
        n2 = canvas.save();
        canvas.translate(this.mCardBounds.right - f2, this.mCardBounds.bottom - f2);
        canvas.rotate(180.0f);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (n != 0) {
            canvas.drawRect(0.0f, f, this.mCardBounds.width() - f2 * 2.0f, -this.mCornerRadius + this.mShadowSize, this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(n2);
        n = canvas.save();
        canvas.translate(this.mCardBounds.left + f2, this.mCardBounds.bottom - f2);
        canvas.rotate(270.0f);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (bl) {
            canvas.drawRect(0.0f, f, this.mCardBounds.height() - f2 * 2.0f, -this.mCornerRadius, this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(n);
        n = canvas.save();
        canvas.translate(this.mCardBounds.right - f2, this.mCardBounds.top + f2);
        canvas.rotate(90.0f);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (bl) {
            canvas.drawRect(0.0f, f, this.mCardBounds.height() - 2.0f * f2, -this.mCornerRadius, this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(n);
    }

    private void setBackground(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf((int)0);
        }
        this.mBackground = colorStateList;
        this.mPaint.setColor(this.mBackground.getColorForState(this.getState(), this.mBackground.getDefaultColor()));
    }

    private void setShadowSize(float f, float f2) {
        if (!(f < 0.0f)) {
            if (!(f2 < 0.0f)) {
                float f3 = this.toEven(f);
                float f4 = this.toEven(f2);
                f = f3;
                if (f3 > f4) {
                    f = f2 = f4;
                    if (!this.mPrintedShadowClipWarning) {
                        this.mPrintedShadowClipWarning = true;
                        f = f2;
                    }
                }
                if (this.mRawShadowSize == f && this.mRawMaxShadowSize == f4) {
                    return;
                }
                this.mRawShadowSize = f;
                this.mRawMaxShadowSize = f4;
                this.mShadowSize = (int)(1.5f * f + (float)this.mInsetShadow + 0.5f);
                this.mDirty = true;
                this.invalidateSelf();
                return;
            }
            throw new IllegalArgumentException("Invalid max shadow size " + f2 + ". Must be >= 0");
        }
        throw new IllegalArgumentException("Invalid shadow size " + f + ". Must be >= 0");
    }

    private int toEven(float f) {
        int n = (int)(0.5f + f);
        if (n % 2 == 1) {
            return n - 1;
        }
        return n;
    }

    public void draw(Canvas canvas) {
        if (this.mDirty) {
            this.buildComponents(this.getBounds());
            this.mDirty = false;
        }
        canvas.translate(0.0f, this.mRawShadowSize / 2.0f);
        this.drawShadow(canvas);
        canvas.translate(0.0f, -this.mRawShadowSize / 2.0f);
        sRoundRectHelper.drawRoundRect(canvas, this.mCardBounds, this.mCornerRadius, this.mPaint);
    }

    ColorStateList getColor() {
        return this.mBackground;
    }

    float getCornerRadius() {
        return this.mCornerRadius;
    }

    void getMaxShadowAndCornerPadding(Rect rect) {
        this.getPadding(rect);
    }

    float getMaxShadowSize() {
        return this.mRawMaxShadowSize;
    }

    float getMinHeight() {
        float f = Math.max(this.mRawMaxShadowSize, this.mCornerRadius + (float)this.mInsetShadow + this.mRawMaxShadowSize * 1.5f / 2.0f);
        return (this.mRawMaxShadowSize * 1.5f + (float)this.mInsetShadow) * 2.0f + f * 2.0f;
    }

    float getMinWidth() {
        float f = Math.max(this.mRawMaxShadowSize, this.mCornerRadius + (float)this.mInsetShadow + this.mRawMaxShadowSize / 2.0f);
        return (this.mRawMaxShadowSize + (float)this.mInsetShadow) * 2.0f + f * 2.0f;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        int n = (int)Math.ceil(RoundRectDrawableWithShadow.calculateVerticalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
        int n2 = (int)Math.ceil(RoundRectDrawableWithShadow.calculateHorizontalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
        rect.set(n2, n, n2, n);
        return true;
    }

    float getShadowSize() {
        return this.mRawShadowSize;
    }

    public boolean isStateful() {
        boolean bl = this.mBackground != null && this.mBackground.isStateful() || super.isStateful();
        return bl;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mDirty = true;
    }

    protected boolean onStateChange(int[] nArray) {
        int n = this.mBackground.getColorForState(nArray, this.mBackground.getDefaultColor());
        if (this.mPaint.getColor() == n) {
            return false;
        }
        this.mPaint.setColor(n);
        this.mDirty = true;
        this.invalidateSelf();
        return true;
    }

    void setAddPaddingForCorners(boolean bl) {
        this.mAddPaddingForCorners = bl;
        this.invalidateSelf();
    }

    public void setAlpha(int n) {
        this.mPaint.setAlpha(n);
        this.mCornerShadowPaint.setAlpha(n);
        this.mEdgeShadowPaint.setAlpha(n);
    }

    void setColor(ColorStateList colorStateList) {
        this.setBackground(colorStateList);
        this.invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    void setCornerRadius(float f) {
        if (!(f < 0.0f)) {
            if (this.mCornerRadius == (f = (float)((int)(0.5f + f)))) {
                return;
            }
            this.mCornerRadius = f;
            this.mDirty = true;
            this.invalidateSelf();
            return;
        }
        throw new IllegalArgumentException("Invalid radius " + f + ". Must be >= 0");
    }

    void setMaxShadowSize(float f) {
        this.setShadowSize(this.mRawShadowSize, f);
    }

    void setShadowSize(float f) {
        this.setShadowSize(f, this.mRawMaxShadowSize);
    }

    static interface RoundRectHelper {
        public void drawRoundRect(Canvas var1, RectF var2, float var3, Paint var4);
    }
}

