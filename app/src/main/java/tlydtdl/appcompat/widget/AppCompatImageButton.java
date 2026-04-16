package tlydtdl.appcompat.widget;

import amuvvoafs.content.Context;
import amuvvoafs.content.res.ColorStateList;
import amuvvoafs.graphics.Bitmap;
import amuvvoafs.graphics.PorterDuff;
import amuvvoafs.graphics.drawable.Drawable;
import amuvvoafs.graphics.drawable.RippleDrawable;
import amuvvoafs.net.Uri;
import amuvvoafs.util.AttributeSet;
import amuvvoafs.widget.ImageButton;
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
public class AppCompatImageButton extends ImageButton {
    public final n a;
    public final v b;
    public boolean c;

    public AppCompatImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130969481);
    }

    public final void drawableStateChanged() {
        super/*amuvvoafs.view.View*/.drawableStateChanged();
        n nVar = this.a;
        if (nVar != null) {
            nVar.a();
        }
        v vVar = this.b;
        if (vVar != null) {
            vVar.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        n nVar = this.a;
        if (nVar != null) {
            return nVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        n nVar = this.a;
        if (nVar != null) {
            return nVar.c();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        j jVar;
        v vVar = this.b;
        if (vVar == null || (jVar = vVar.b) == null) {
            return null;
        }
        return (ColorStateList) jVar.d;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        j jVar;
        v vVar = this.b;
        if (vVar == null || (jVar = vVar.b) == null) {
            return null;
        }
        return (PorterDuff.Mode) jVar.e;
    }

    public final boolean hasOverlappingRendering() {
        return !(this.b.a.getBackground() instanceof RippleDrawable) && super/*amuvvoafs.view.View*/.hasOverlappingRendering();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super/*amuvvoafs.view.View*/.setBackgroundDrawable(drawable);
        n nVar = this.a;
        if (nVar != null) {
            nVar.e();
        }
    }

    public void setBackgroundResource(int i) {
        super/*amuvvoafs.view.View*/.setBackgroundResource(i);
        n nVar = this.a;
        if (nVar != null) {
            nVar.f(i);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super/*amuvvoafs.widget.ImageView*/.setImageBitmap(bitmap);
        v vVar = this.b;
        if (vVar != null) {
            vVar.a();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        v vVar = this.b;
        if (vVar != null && drawable != null && !this.c) {
            vVar.c = drawable.getLevel();
        }
        super/*amuvvoafs.widget.ImageView*/.setImageDrawable(drawable);
        if (vVar != null) {
            vVar.a();
            if (this.c) {
                return;
            }
            ImageView imageView = vVar.a;
            if (imageView.getDrawable() != null) {
                imageView.getDrawable().setLevel(vVar.c);
            }
        }
    }

    public void setImageLevel(int i) {
        super/*amuvvoafs.widget.ImageView*/.setImageLevel(i);
        this.c = true;
    }

    public void setImageResource(int i) {
        v vVar = this.b;
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

    public void setImageURI(Uri uri) {
        super/*amuvvoafs.widget.ImageView*/.setImageURI(uri);
        v vVar = this.b;
        if (vVar != null) {
            vVar.a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        n nVar = this.a;
        if (nVar != null) {
            nVar.i(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        v vVar = this.b;
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
        v vVar = this.b;
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
    public AppCompatImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        v2.a(context);
        this.c = false;
        u2.a(getContext(), this);
        n nVar = new n(this);
        this.a = nVar;
        nVar.d(attributeSet, i);
        v vVar = new v(this);
        this.b = vVar;
        vVar.b(attributeSet, i);
    }
}
