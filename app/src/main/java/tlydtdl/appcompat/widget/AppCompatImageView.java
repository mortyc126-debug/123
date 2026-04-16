package tlydtdl.appcompat.widget;

import amuvvoafs.content.Context;
import amuvvoafs.content.res.ColorStateList;
import amuvvoafs.graphics.Bitmap;
import amuvvoafs.graphics.PorterDuff;
import amuvvoafs.graphics.drawable.Drawable;
import amuvvoafs.graphics.drawable.RippleDrawable;
import amuvvoafs.net.Uri;
import amuvvoafs.util.AttributeSet;
import amuvvoafs.widget.ImageView;
import bl1.j;
import q.h1;
import q.n;
import q.u2;
import q.v;
import q.v2;
import qg.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class AppCompatImageView extends ImageView {
    private final n mBackgroundTintHelper;
    private boolean mHasLevel;
    private final v mImageHelper;

    public AppCompatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        n nVar = this.mBackgroundTintHelper;
        if (nVar != null) {
            nVar.a();
        }
        v vVar = this.mImageHelper;
        if (vVar != null) {
            vVar.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        n nVar = this.mBackgroundTintHelper;
        if (nVar != null) {
            return nVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        n nVar = this.mBackgroundTintHelper;
        if (nVar != null) {
            return nVar.c();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        j jVar;
        v vVar = this.mImageHelper;
        if (vVar == null || (jVar = vVar.b) == null) {
            return null;
        }
        return (ColorStateList) jVar.d;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        j jVar;
        v vVar = this.mImageHelper;
        if (vVar == null || (jVar = vVar.b) == null) {
            return null;
        }
        return (PorterDuff.Mode) jVar.e;
    }

    public boolean hasOverlappingRendering() {
        return !(this.mImageHelper.a.getBackground() instanceof RippleDrawable) && super.hasOverlappingRendering();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super/*amuvvoafs.view.View*/.setBackgroundDrawable(drawable);
        n nVar = this.mBackgroundTintHelper;
        if (nVar != null) {
            nVar.e();
        }
    }

    public void setBackgroundResource(int i) {
        super/*amuvvoafs.view.View*/.setBackgroundResource(i);
        n nVar = this.mBackgroundTintHelper;
        if (nVar != null) {
            nVar.f(i);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        v vVar = this.mImageHelper;
        if (vVar != null) {
            vVar.a();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        v vVar = this.mImageHelper;
        if (vVar != null && drawable != null && !this.mHasLevel) {
            vVar.c = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        v vVar2 = this.mImageHelper;
        if (vVar2 != null) {
            vVar2.a();
            if (this.mHasLevel) {
                return;
            }
            v vVar3 = this.mImageHelper;
            ImageView imageView = vVar3.a;
            if (imageView.getDrawable() != null) {
                imageView.getDrawable().setLevel(vVar3.c);
            }
        }
    }

    public void setImageLevel(int i) {
        super.setImageLevel(i);
        this.mHasLevel = true;
    }

    public void setImageResource(int i) {
        v vVar = this.mImageHelper;
        if (vVar != null) {
            ImageView imageView = vVar.a;
            if (i != 0) {
                Drawable drawableR = a.r(imageView.getContext(), i);
                if (drawableR != null) {
                    h1.a(drawableR);
                }
                imageView.setImageDrawable(drawableR);
            } else {
                imageView.setImageDrawable((Drawable) null);
            }
            vVar.a();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        v vVar = this.mImageHelper;
        if (vVar != null) {
            vVar.a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        n nVar = this.mBackgroundTintHelper;
        if (nVar != null) {
            nVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        n nVar = this.mBackgroundTintHelper;
        if (nVar != null) {
            nVar.i(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        v vVar = this.mImageHelper;
        if (vVar != null) {
            if (vVar.b == null) {
                vVar.b = new j();
            }
            j jVar = vVar.b;
            jVar.d = colorStateList;
            jVar.c = true;
            vVar.a();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        v vVar = this.mImageHelper;
        if (vVar != null) {
            if (vVar.b == null) {
                vVar.b = new j();
            }
            j jVar = vVar.b;
            jVar.e = mode;
            jVar.b = true;
            vVar.a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        v2.a(context);
        this.mHasLevel = false;
        u2.a(getContext(), this);
        n nVar = new n(this);
        this.mBackgroundTintHelper = nVar;
        nVar.d(attributeSet, i);
        v vVar = new v(this);
        this.mImageHelper = vVar;
        vVar.b(attributeSet, i);
    }
}
