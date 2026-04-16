/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.ColorMatrix
 *  android.graphics.ColorMatrixColorFilter
 *  android.graphics.Outline
 *  android.graphics.Path
 *  android.graphics.Path$Direction
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.LayerDrawable
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewOutlineProvider
 *  android.widget.ImageView
 */
package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.R;

public class ImageFilterView
extends AppCompatImageView {
    private float mCrossfade = 0.0f;
    private ImageMatrix mImageMatrix = new ImageMatrix();
    LayerDrawable mLayer;
    Drawable[] mLayers;
    private boolean mOverlay = true;
    private Path mPath;
    RectF mRect;
    private float mRound = Float.NaN;
    private float mRoundPercent = 0.0f;
    ViewOutlineProvider mViewOutlineProvider;

    public ImageFilterView(Context context) {
        super(context);
        this.init(context, null);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(context, attributeSet);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            attributeSet = this.getContext().obtainStyledAttributes(attributeSet, R.styleable.ImageFilterView);
            int n = attributeSet.getIndexCount();
            context = attributeSet.getDrawable(R.styleable.ImageFilterView_altSrc);
            for (int i = 0; i < n; ++i) {
                int n2 = attributeSet.getIndex(i);
                if (n2 == R.styleable.ImageFilterView_crossfade) {
                    this.mCrossfade = attributeSet.getFloat(n2, 0.0f);
                    continue;
                }
                if (n2 == R.styleable.ImageFilterView_warmth) {
                    this.setWarmth(attributeSet.getFloat(n2, 0.0f));
                    continue;
                }
                if (n2 == R.styleable.ImageFilterView_saturation) {
                    this.setSaturation(attributeSet.getFloat(n2, 0.0f));
                    continue;
                }
                if (n2 == R.styleable.ImageFilterView_contrast) {
                    this.setContrast(attributeSet.getFloat(n2, 0.0f));
                    continue;
                }
                if (n2 == R.styleable.ImageFilterView_round) {
                    this.setRound(attributeSet.getDimension(n2, 0.0f));
                    continue;
                }
                if (n2 == R.styleable.ImageFilterView_roundPercent) {
                    this.setRoundPercent(attributeSet.getFloat(n2, 0.0f));
                    continue;
                }
                if (n2 != R.styleable.ImageFilterView_overlay) continue;
                this.setOverlay(attributeSet.getBoolean(n2, this.mOverlay));
            }
            attributeSet.recycle();
            if (context != null) {
                this.mLayers = new Drawable[2];
                this.mLayers[0] = this.getDrawable();
                this.mLayers[1] = context;
                this.mLayer = new LayerDrawable(this.mLayers);
                this.mLayer.getDrawable(1).setAlpha((int)(this.mCrossfade * 255.0f));
                super.setImageDrawable((Drawable)this.mLayer);
            }
        }
    }

    private void setOverlay(boolean bl) {
        this.mOverlay = bl;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (false) {
            canvas.restore();
        }
    }

    public float getBrightness() {
        return this.mImageMatrix.mBrightness;
    }

    public float getContrast() {
        return this.mImageMatrix.mContrast;
    }

    public float getCrossfade() {
        return this.mCrossfade;
    }

    public float getRound() {
        return this.mRound;
    }

    public float getRoundPercent() {
        return this.mRoundPercent;
    }

    public float getSaturation() {
        return this.mImageMatrix.mSaturation;
    }

    public float getWarmth() {
        return this.mImageMatrix.mWarmth;
    }

    public void setBrightness(float f) {
        this.mImageMatrix.mBrightness = f;
        this.mImageMatrix.updateMatrix(this);
    }

    public void setContrast(float f) {
        this.mImageMatrix.mContrast = f;
        this.mImageMatrix.updateMatrix(this);
    }

    public void setCrossfade(float f) {
        this.mCrossfade = f;
        if (this.mLayers != null) {
            if (!this.mOverlay) {
                this.mLayer.getDrawable(0).setAlpha((int)((1.0f - this.mCrossfade) * 255.0f));
            }
            this.mLayer.getDrawable(1).setAlpha((int)(this.mCrossfade * 255.0f));
            super.setImageDrawable((Drawable)this.mLayer);
        }
    }

    public void setRound(float f) {
        if (Float.isNaN(f)) {
            this.mRound = f;
            f = this.mRoundPercent;
            this.mRoundPercent = -1.0f;
            this.setRoundPercent(f);
            return;
        }
        boolean bl = this.mRound != f;
        this.mRound = f;
        if (this.mRound != 0.0f) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            if (this.mRect == null) {
                this.mRect = new RectF();
            }
            if (this.mViewOutlineProvider == null) {
                this.mViewOutlineProvider = new ViewOutlineProvider(this){
                    final ImageFilterView this$0;
                    {
                        this.this$0 = imageFilterView;
                    }

                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, this.this$0.getWidth(), this.this$0.getHeight(), this.this$0.mRound);
                    }
                };
                this.setOutlineProvider(this.mViewOutlineProvider);
            }
            this.setClipToOutline(true);
            int n = this.getWidth();
            int n2 = this.getHeight();
            this.mRect.set(0.0f, 0.0f, (float)n, (float)n2);
            this.mPath.reset();
            this.mPath.addRoundRect(this.mRect, this.mRound, this.mRound, Path.Direction.CW);
        } else {
            this.setClipToOutline(false);
        }
        if (bl) {
            this.invalidateOutline();
        }
    }

    public void setRoundPercent(float f) {
        boolean bl = this.mRoundPercent != f;
        this.mRoundPercent = f;
        if (this.mRoundPercent != 0.0f) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            if (this.mRect == null) {
                this.mRect = new RectF();
            }
            if (this.mViewOutlineProvider == null) {
                this.mViewOutlineProvider = new ViewOutlineProvider(this){
                    final ImageFilterView this$0;
                    {
                        this.this$0 = imageFilterView;
                    }

                    public void getOutline(View view, Outline outline) {
                        int n = this.this$0.getWidth();
                        int n2 = this.this$0.getHeight();
                        outline.setRoundRect(0, 0, n, n2, (float)Math.min(n, n2) * this.this$0.mRoundPercent / 2.0f);
                    }
                };
                this.setOutlineProvider(this.mViewOutlineProvider);
            }
            this.setClipToOutline(true);
            int n = this.getWidth();
            int n2 = this.getHeight();
            f = (float)Math.min(n, n2) * this.mRoundPercent / 2.0f;
            this.mRect.set(0.0f, 0.0f, (float)n, (float)n2);
            this.mPath.reset();
            this.mPath.addRoundRect(this.mRect, f, f, Path.Direction.CW);
        } else {
            this.setClipToOutline(false);
        }
        if (bl) {
            this.invalidateOutline();
        }
    }

    public void setSaturation(float f) {
        this.mImageMatrix.mSaturation = f;
        this.mImageMatrix.updateMatrix(this);
    }

    public void setWarmth(float f) {
        this.mImageMatrix.mWarmth = f;
        this.mImageMatrix.updateMatrix(this);
    }

    static class ImageMatrix {
        float[] m = new float[20];
        float mBrightness = 1.0f;
        ColorMatrix mColorMatrix = new ColorMatrix();
        float mContrast = 1.0f;
        float mSaturation = 1.0f;
        ColorMatrix mTmpColorMatrix = new ColorMatrix();
        float mWarmth = 1.0f;

        ImageMatrix() {
        }

        private void brightness(float f) {
            this.m[0] = f;
            this.m[1] = 0.0f;
            this.m[2] = 0.0f;
            this.m[3] = 0.0f;
            this.m[4] = 0.0f;
            this.m[5] = 0.0f;
            this.m[6] = f;
            this.m[7] = 0.0f;
            this.m[8] = 0.0f;
            this.m[9] = 0.0f;
            this.m[10] = 0.0f;
            this.m[11] = 0.0f;
            this.m[12] = f;
            this.m[13] = 0.0f;
            this.m[14] = 0.0f;
            this.m[15] = 0.0f;
            this.m[16] = 0.0f;
            this.m[17] = 0.0f;
            this.m[18] = 1.0f;
            this.m[19] = 0.0f;
        }

        private void saturation(float f) {
            float f2 = 1.0f - f;
            float f3 = 0.2999f * f2;
            float f4 = 0.587f * f2;
            f2 = 0.114f * f2;
            this.m[0] = f3 + f;
            this.m[1] = f4;
            this.m[2] = f2;
            this.m[3] = 0.0f;
            this.m[4] = 0.0f;
            this.m[5] = f3;
            this.m[6] = f4 + f;
            this.m[7] = f2;
            this.m[8] = 0.0f;
            this.m[9] = 0.0f;
            this.m[10] = f3;
            this.m[11] = f4;
            this.m[12] = f2 + f;
            this.m[13] = 0.0f;
            this.m[14] = 0.0f;
            this.m[15] = 0.0f;
            this.m[16] = 0.0f;
            this.m[17] = 0.0f;
            this.m[18] = 1.0f;
            this.m[19] = 0.0f;
        }

        private void warmth(float f) {
            float f2;
            float f3;
            if (f <= 0.0f) {
                f = 0.01f;
            }
            if ((f = 5000.0f / f / 100.0f) > 66.0f) {
                f3 = f - 60.0f;
                f2 = (float)Math.pow(f3, -0.13320475816726685) * 329.69873f;
                f3 = (float)Math.pow(f3, 0.07551484555006027) * 288.12216f;
            } else {
                f3 = (float)Math.log(f) * 99.4708f - 161.11957f;
                f2 = 255.0f;
            }
            f = f < 66.0f ? (f > 19.0f ? (float)Math.log(f - 10.0f) * 138.51773f - 305.0448f : 0.0f) : 255.0f;
            float f4 = Math.min(255.0f, Math.max(f2, 0.0f));
            float f5 = Math.min(255.0f, Math.max(f3, 0.0f));
            float f6 = Math.min(255.0f, Math.max(f, 0.0f));
            f = 5000.0f / 100.0f;
            if (f > 66.0f) {
                f3 = f - 60.0f;
                f2 = (float)Math.pow(f3, -0.13320475816726685) * 329.69873f;
                f3 = (float)Math.pow(f3, 0.07551484555006027) * 288.12216f;
            } else {
                f3 = (float)Math.log(f) * 99.4708f - 161.11957f;
                f2 = 255.0f;
            }
            f = f < 66.0f ? (f > 19.0f ? (float)Math.log(f - 10.0f) * 138.51773f - 305.0448f : 0.0f) : 255.0f;
            f2 = Math.min(255.0f, Math.max(f2, 0.0f));
            f3 = Math.min(255.0f, Math.max(f3, 0.0f));
            f = Math.min(255.0f, Math.max(f, 0.0f));
            f2 = f4 / f2;
            f3 = f5 / f3;
            f = f6 / f;
            this.m[0] = f2;
            this.m[1] = 0.0f;
            this.m[2] = 0.0f;
            this.m[3] = 0.0f;
            this.m[4] = 0.0f;
            this.m[5] = 0.0f;
            this.m[6] = f3;
            this.m[7] = 0.0f;
            this.m[8] = 0.0f;
            this.m[9] = 0.0f;
            this.m[10] = 0.0f;
            this.m[11] = 0.0f;
            this.m[12] = f;
            this.m[13] = 0.0f;
            this.m[14] = 0.0f;
            this.m[15] = 0.0f;
            this.m[16] = 0.0f;
            this.m[17] = 0.0f;
            this.m[18] = 1.0f;
            this.m[19] = 0.0f;
        }

        void updateMatrix(ImageView imageView) {
            this.mColorMatrix.reset();
            boolean bl = false;
            if (this.mSaturation != 1.0f) {
                this.saturation(this.mSaturation);
                this.mColorMatrix.set(this.m);
                bl = true;
            }
            if (this.mContrast != 1.0f) {
                this.mTmpColorMatrix.setScale(this.mContrast, this.mContrast, this.mContrast, 1.0f);
                this.mColorMatrix.postConcat(this.mTmpColorMatrix);
                bl = true;
            }
            if (this.mWarmth != 1.0f) {
                this.warmth(this.mWarmth);
                this.mTmpColorMatrix.set(this.m);
                this.mColorMatrix.postConcat(this.mTmpColorMatrix);
                bl = true;
            }
            if (this.mBrightness != 1.0f) {
                this.brightness(this.mBrightness);
                this.mTmpColorMatrix.set(this.m);
                this.mColorMatrix.postConcat(this.mTmpColorMatrix);
                bl = true;
            }
            if (bl) {
                imageView.setColorFilter((ColorFilter)new ColorMatrixColorFilter(this.mColorMatrix));
            } else {
                imageView.clearColorFilter();
            }
        }
    }
}

