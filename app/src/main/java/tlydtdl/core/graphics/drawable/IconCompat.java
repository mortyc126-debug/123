package tlydtdl.core.graphics.drawable;

import amuvvoafs.content.Context;
import amuvvoafs.content.pm.ApplicationInfo;
import amuvvoafs.content.pm.PackageManager;
import amuvvoafs.content.res.ColorStateList;
import amuvvoafs.content.res.Resources;
import amuvvoafs.graphics.Bitmap;
import amuvvoafs.graphics.BitmapFactory;
import amuvvoafs.graphics.PorterDuff;
import amuvvoafs.graphics.drawable.Icon;
import amuvvoafs.net.Uri;
import amuvvoafs.os.Build;
import amuvvoafs.os.Parcelable;
import amuvvoafs.text.TextUtils;
import amuvvoafs.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import tk0.d;
import tlydtdl.core.app.j0;
import tlydtdl.versionedparcelable.CustomVersionedParcelable;
import un0.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {
    public static final PorterDuff.Mode k = PorterDuff.Mode.SRC_IN;
    public int a;
    public Object b;
    public byte[] c;
    public Parcelable d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f566f;
    public ColorStateList g;
    public PorterDuff.Mode h;
    public String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f567j;

    public IconCompat() {
        this.a = -1;
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f566f = 0;
        this.g = null;
        this.h = k;
        this.i = null;
    }

    public static IconCompat a(Bitmap bitmap) {
        bitmap.getClass();
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.b = bitmap;
        return iconCompat;
    }

    public static IconCompat b(Resources resources, String str, int i) {
        str.getClass();
        if (i == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.e = i;
        if (resources != null) {
            try {
                iconCompat.b = resources.getResourceName(i);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.b = str;
        }
        iconCompat.f567j = str;
        return iconCompat;
    }

    public static Resources d(Context context, String str) {
        if ("amuvvoafs".equals(str)) {
            return Resources.getSystem();
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 8192);
            if (applicationInfo != null) {
                return packageManager.getResourcesForApplication(applicationInfo);
            }
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("IconCompat", "Unable to find pkg=" + str + " for icon", e);
            return null;
        }
    }

    public final int c() {
        int i = this.a;
        if (i == -1) {
            return m.i0(this.b);
        }
        if (i == 2) {
            return this.e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public final Uri e() {
        int i = this.a;
        if (i == -1) {
            return m.l0(this.b);
        }
        if (i == 4 || i == 6) {
            return Uri.parse((String) this.b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public final InputStream f(Context context) {
        Uri uriE = e();
        String scheme = uriE.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(uriE);
            } catch (Exception e) {
                Log.w("IconCompat", "Unable to load image from URI: " + uriE, e);
                return null;
            }
        }
        try {
            return new FileInputStream(new File((String) this.b));
        } catch (FileNotFoundException e2) {
            Log.w("IconCompat", "Unable to load image from path: " + uriE, e2);
            return null;
        }
    }

    public final Icon g(Context context) {
        Icon iconCreateWithBitmap;
        String strJ0;
        int i = Build.VERSION.SDK_INT;
        switch (this.a) {
            case -1:
                return (Icon) this.b;
            case 0:
            default:
                throw new IllegalArgumentException("Unknown type");
            case 1:
                iconCreateWithBitmap = Icon.createWithBitmap((Bitmap) this.b);
                break;
            case 2:
                int i2 = this.a;
                if (i2 == -1) {
                    strJ0 = m.j0(this.b);
                } else {
                    if (i2 != 2) {
                        throw new IllegalStateException("called getResPackage() on " + this);
                    }
                    String str = this.f567j;
                    strJ0 = (str == null || TextUtils.isEmpty(str)) ? ((String) this.b).split(":", -1)[0] : this.f567j;
                }
                iconCreateWithBitmap = Icon.createWithResource(strJ0, this.e);
                break;
            case 3:
                iconCreateWithBitmap = Icon.createWithData((byte[]) this.b, this.e, this.f566f);
                break;
            case 4:
                iconCreateWithBitmap = Icon.createWithContentUri((String) this.b);
                break;
            case 5:
                iconCreateWithBitmap = d.B((Bitmap) this.b);
                break;
            case 6:
                if (i >= 30) {
                    iconCreateWithBitmap = j0.b(e());
                } else {
                    if (context == null) {
                        throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + e());
                    }
                    InputStream inputStreamF = f(context);
                    if (inputStreamF == null) {
                        throw new IllegalStateException("Cannot load adaptive icon from uri: " + e());
                    }
                    iconCreateWithBitmap = d.B(BitmapFactory.decodeStream(inputStreamF));
                }
                break;
        }
        ColorStateList colorStateList = this.g;
        if (colorStateList != null) {
            iconCreateWithBitmap.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = this.h;
        if (mode != k) {
            iconCreateWithBitmap.setTintMode(mode);
        }
        return iconCreateWithBitmap;
    }

    public final String toString() {
        String str;
        if (this.a == -1) {
            return String.valueOf(this.b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        switch (this.a) {
            case 1:
                str = "BITMAP";
                break;
            case 2:
                str = "RESOURCE";
                break;
            case 3:
                str = "DATA";
                break;
            case 4:
                str = "URI";
                break;
            case 5:
                str = "BITMAP_MASKABLE";
                break;
            case 6:
                str = "URI_MASKABLE";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        sb.append(str);
        switch (this.a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f567j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(c())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.e);
                if (this.f566f != 0) {
                    sb.append(" off=");
                    sb.append(this.f566f);
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.b);
                break;
        }
        if (this.g != null) {
            sb.append(" tint=");
            sb.append(this.g);
        }
        if (this.h != k) {
            sb.append(" mode=");
            sb.append(this.h);
        }
        sb.append(")");
        return sb.toString();
    }

    public IconCompat(int i) {
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f566f = 0;
        this.g = null;
        this.h = k;
        this.i = null;
        this.a = i;
    }
}
