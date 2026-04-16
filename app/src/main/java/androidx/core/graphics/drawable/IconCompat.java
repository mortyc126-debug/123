/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.content.Context
 *  android.content.Intent
 *  android.content.Intent$ShortcutIconResource
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapShader
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.drawable.AdaptiveIconDrawable
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Icon
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  android.util.Log
 */
package androidx.core.graphics.drawable;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

public class IconCompat
extends CustomVersionedParcelable {
    private static final float ADAPTIVE_ICON_INSET_FACTOR = 0.25f;
    private static final int AMBIENT_SHADOW_ALPHA = 30;
    private static final float BLUR_FACTOR = 0.010416667f;
    static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    private static final float DEFAULT_VIEW_PORT_SCALE = 0.6666667f;
    static final String EXTRA_INT1 = "int1";
    static final String EXTRA_INT2 = "int2";
    static final String EXTRA_OBJ = "obj";
    static final String EXTRA_STRING1 = "string1";
    static final String EXTRA_TINT_LIST = "tint_list";
    static final String EXTRA_TINT_MODE = "tint_mode";
    static final String EXTRA_TYPE = "type";
    private static final float ICON_DIAMETER_FACTOR = 0.9166667f;
    private static final int KEY_SHADOW_ALPHA = 61;
    private static final float KEY_SHADOW_OFFSET_FACTOR = 0.020833334f;
    private static final String TAG = "IconCompat";
    public static final int TYPE_ADAPTIVE_BITMAP = 5;
    public static final int TYPE_BITMAP = 1;
    public static final int TYPE_DATA = 3;
    public static final int TYPE_RESOURCE = 2;
    public static final int TYPE_UNKNOWN = -1;
    public static final int TYPE_URI = 4;
    public static final int TYPE_URI_ADAPTIVE_BITMAP = 6;
    public byte[] mData = null;
    public int mInt1 = 0;
    public int mInt2 = 0;
    Object mObj1;
    public Parcelable mParcelable = null;
    public String mString1;
    public ColorStateList mTintList = null;
    PorterDuff.Mode mTintMode = DEFAULT_TINT_MODE;
    public String mTintModeStr = null;
    public int mType = -1;

    public IconCompat() {
    }

    IconCompat(int n) {
        this.mType = n;
    }

    public static IconCompat createFromBundle(Bundle bundle) {
        int n = bundle.getInt(EXTRA_TYPE);
        IconCompat iconCompat = new IconCompat(n);
        iconCompat.mInt1 = bundle.getInt(EXTRA_INT1);
        iconCompat.mInt2 = bundle.getInt(EXTRA_INT2);
        iconCompat.mString1 = bundle.getString(EXTRA_STRING1);
        if (bundle.containsKey(EXTRA_TINT_LIST)) {
            iconCompat.mTintList = (ColorStateList)bundle.getParcelable(EXTRA_TINT_LIST);
        }
        if (bundle.containsKey(EXTRA_TINT_MODE)) {
            iconCompat.mTintMode = PorterDuff.Mode.valueOf((String)bundle.getString(EXTRA_TINT_MODE));
        }
        switch (n) {
            default: {
                Log.w((String)TAG, (String)("Unknown type " + n));
                return null;
            }
            case 3: {
                iconCompat.mObj1 = bundle.getByteArray(EXTRA_OBJ);
                break;
            }
            case 2: 
            case 4: 
            case 6: {
                iconCompat.mObj1 = bundle.getString(EXTRA_OBJ);
                break;
            }
            case -1: 
            case 1: 
            case 5: {
                iconCompat.mObj1 = bundle.getParcelable(EXTRA_OBJ);
            }
        }
        return iconCompat;
    }

    public static IconCompat createFromIcon(Context context, Icon icon) {
        Preconditions.checkNotNull(icon);
        return Api23Impl.createFromIcon(context, icon);
    }

    public static IconCompat createFromIcon(Icon icon) {
        return Api23Impl.createFromIconInner(icon);
    }

    public static IconCompat createFromIconOrNullIfZeroResId(Icon icon) {
        if (Api23Impl.getType(icon) == 2 && Api23Impl.getResId(icon) == 0) {
            return null;
        }
        return Api23Impl.createFromIconInner(icon);
    }

    static Bitmap createLegacyIconFromAdaptiveIcon(Bitmap bitmap, boolean bl) {
        int n = (int)((float)Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap bitmap2 = Bitmap.createBitmap((int)n, (int)n, (Bitmap.Config)Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint(3);
        float f = (float)n * 0.5f;
        float f2 = 0.9166667f * f;
        if (bl) {
            float f3 = (float)n * 0.010416667f;
            paint.setColor(0);
            paint.setShadowLayer(f3, 0.0f, (float)n * 0.020833334f, 0x3D000000);
            canvas.drawCircle(f, f, f2, paint);
            paint.setShadowLayer(f3, 0.0f, 0.0f, 0x1E000000);
            canvas.drawCircle(f, f, f2, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Matrix matrix = new Matrix();
        matrix.setTranslate((float)(-(bitmap.getWidth() - n)) / 2.0f, (float)(-(bitmap.getHeight() - n)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader((Shader)bitmapShader);
        canvas.drawCircle(f, f, f2, paint);
        canvas.setBitmap(null);
        return bitmap2;
    }

    public static IconCompat createWithAdaptiveBitmap(Bitmap bitmap) {
        ObjectsCompat.requireNonNull(bitmap);
        IconCompat iconCompat = new IconCompat(5);
        iconCompat.mObj1 = bitmap;
        return iconCompat;
    }

    public static IconCompat createWithAdaptiveBitmapContentUri(Uri uri) {
        ObjectsCompat.requireNonNull(uri);
        return IconCompat.createWithAdaptiveBitmapContentUri(uri.toString());
    }

    public static IconCompat createWithAdaptiveBitmapContentUri(String string2) {
        ObjectsCompat.requireNonNull(string2);
        IconCompat iconCompat = new IconCompat(6);
        iconCompat.mObj1 = string2;
        return iconCompat;
    }

    public static IconCompat createWithBitmap(Bitmap bitmap) {
        ObjectsCompat.requireNonNull(bitmap);
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.mObj1 = bitmap;
        return iconCompat;
    }

    public static IconCompat createWithContentUri(Uri uri) {
        ObjectsCompat.requireNonNull(uri);
        return IconCompat.createWithContentUri(uri.toString());
    }

    public static IconCompat createWithContentUri(String string2) {
        ObjectsCompat.requireNonNull(string2);
        IconCompat iconCompat = new IconCompat(4);
        iconCompat.mObj1 = string2;
        return iconCompat;
    }

    public static IconCompat createWithData(byte[] byArray, int n, int n2) {
        ObjectsCompat.requireNonNull(byArray);
        IconCompat iconCompat = new IconCompat(3);
        iconCompat.mObj1 = byArray;
        iconCompat.mInt1 = n;
        iconCompat.mInt2 = n2;
        return iconCompat;
    }

    public static IconCompat createWithResource(Context context, int n) {
        ObjectsCompat.requireNonNull(context);
        return IconCompat.createWithResource(context.getResources(), context.getPackageName(), n);
    }

    public static IconCompat createWithResource(Resources resources, String string2, int n) {
        ObjectsCompat.requireNonNull(string2);
        if (n != 0) {
            IconCompat iconCompat = new IconCompat(2);
            iconCompat.mInt1 = n;
            if (resources != null) {
                try {
                    iconCompat.mObj1 = resources.getResourceName(n);
                }
                catch (Resources.NotFoundException notFoundException) {
                    throw new IllegalArgumentException("Icon resource cannot be found");
                }
            } else {
                iconCompat.mObj1 = string2;
            }
            iconCompat.mString1 = string2;
            return iconCompat;
        }
        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }

    static Resources getResources(Context context, String string2) {
        block4: {
            if ("android".equals(string2)) {
                return Resources.getSystem();
            }
            PackageManager packageManager = context.getPackageManager();
            try {
                context = packageManager.getApplicationInfo(string2, 8192);
                if (context == null) break block4;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                Log.e((String)TAG, (String)String.format("Unable to find pkg=%s for icon", string2), (Throwable)nameNotFoundException);
                return null;
            }
            context = packageManager.getResourcesForApplication((ApplicationInfo)context);
            return context;
        }
        return null;
    }

    private Drawable loadDrawableInner(Context context) {
        switch (this.mType) {
            default: {
                break;
            }
            case 6: {
                InputStream inputStream = this.getUriInputStream(context);
                if (inputStream == null) break;
                if (Build.VERSION.SDK_INT >= 26) {
                    return Api26Impl.createAdaptiveIconDrawable(null, (Drawable)new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream((InputStream)inputStream)));
                }
                return new BitmapDrawable(context.getResources(), IconCompat.createLegacyIconFromAdaptiveIcon(BitmapFactory.decodeStream((InputStream)inputStream), false));
            }
            case 5: {
                return new BitmapDrawable(context.getResources(), IconCompat.createLegacyIconFromAdaptiveIcon((Bitmap)this.mObj1, false));
            }
            case 4: {
                InputStream inputStream = this.getUriInputStream(context);
                if (inputStream == null) break;
                return new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream((InputStream)inputStream));
            }
            case 3: {
                return new BitmapDrawable(context.getResources(), BitmapFactory.decodeByteArray((byte[])((byte[])this.mObj1), (int)this.mInt1, (int)this.mInt2));
            }
            case 2: {
                String string2;
                String string3 = string2 = this.getResPackage();
                if (TextUtils.isEmpty((CharSequence)string2)) {
                    string3 = context.getPackageName();
                }
                string3 = IconCompat.getResources(context, string3);
                try {
                    context = ResourcesCompat.getDrawable((Resources)string3, this.mInt1, context.getTheme());
                    return context;
                }
                catch (RuntimeException runtimeException) {
                    Log.e((String)TAG, (String)String.format("Unable to load resource 0x%08x from pkg=%s", this.mInt1, this.mObj1), (Throwable)runtimeException);
                    break;
                }
            }
            case 1: {
                return new BitmapDrawable(context.getResources(), (Bitmap)this.mObj1);
            }
        }
        return null;
    }

    private static String typeToString(int n) {
        switch (n) {
            default: {
                return "UNKNOWN";
            }
            case 6: {
                return "URI_MASKABLE";
            }
            case 5: {
                return "BITMAP_MASKABLE";
            }
            case 4: {
                return "URI";
            }
            case 3: {
                return "DATA";
            }
            case 2: {
                return "RESOURCE";
            }
            case 1: 
        }
        return "BITMAP";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void addToShortcutIntent(Intent intent, Drawable drawable2, Context context) {
        int n;
        this.checkResource(context);
        switch (this.mType) {
            default: {
                throw new IllegalArgumentException("Icon type not supported for intent shortcuts");
            }
            case 5: {
                context = IconCompat.createLegacyIconFromAdaptiveIcon((Bitmap)this.mObj1, true);
                break;
            }
            case 2: {
                try {
                    context = context.createPackageContext(this.getResPackage(), 0);
                    if (drawable2 == null) {
                        intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", (Parcelable)Intent.ShortcutIconResource.fromContext((Context)context, (int)this.mInt1));
                        return;
                    }
                    Drawable drawable3 = ContextCompat.getDrawable(context, this.mInt1);
                    if (drawable3.getIntrinsicWidth() > 0 && drawable3.getIntrinsicHeight() > 0) {
                        context = Bitmap.createBitmap((int)drawable3.getIntrinsicWidth(), (int)drawable3.getIntrinsicHeight(), (Bitmap.Config)Bitmap.Config.ARGB_8888);
                    } else {
                        n = ((ActivityManager)context.getSystemService("activity")).getLauncherLargeIconSize();
                        context = Bitmap.createBitmap((int)n, (int)n, (Bitmap.Config)Bitmap.Config.ARGB_8888);
                    }
                    drawable3.setBounds(0, 0, context.getWidth(), context.getHeight());
                    Canvas canvas = new Canvas((Bitmap)context);
                    drawable3.draw(canvas);
                    break;
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    throw new IllegalArgumentException("Can't find package " + this.mObj1, nameNotFoundException);
                }
            }
            case 1: {
                Bitmap bitmap = (Bitmap)this.mObj1;
                context = bitmap;
                if (drawable2 == null) break;
                context = bitmap.copy(bitmap.getConfig(), true);
            }
        }
        if (drawable2 != null) {
            int n2 = context.getWidth();
            n = context.getHeight();
            drawable2.setBounds(n2 / 2, n / 2, n2, n);
            drawable2.draw(new Canvas((Bitmap)context));
        }
        intent.putExtra("android.intent.extra.shortcut.ICON", (Parcelable)context);
    }

    public void checkResource(Context context) {
        if (this.mType == 2 && this.mObj1 != null) {
            String string2 = (String)this.mObj1;
            if (!string2.contains(":")) {
                return;
            }
            String string3 = string2.split(":", -1)[1];
            String string4 = string3.split("/", -1)[0];
            String string5 = string3.split("/", -1)[1];
            String string6 = string2.split(":", -1)[0];
            if ("0_resource_name_obfuscated".equals(string5)) {
                Log.i((String)TAG, (String)"Found obfuscated resource, not trying to update resource id for it");
                return;
            }
            string3 = this.getResPackage();
            int n = IconCompat.getResources(context, string3).getIdentifier(string5, string4, string6);
            if (this.mInt1 != n) {
                Log.i((String)TAG, (String)("Id has changed for " + string3 + " " + string2));
                this.mInt1 = n;
            }
        }
    }

    public Bitmap getBitmap() {
        if (this.mType == -1) {
            if (this.mObj1 instanceof Bitmap) {
                return (Bitmap)this.mObj1;
            }
            return null;
        }
        if (this.mType == 1) {
            return (Bitmap)this.mObj1;
        }
        if (this.mType == 5) {
            return IconCompat.createLegacyIconFromAdaptiveIcon((Bitmap)this.mObj1, true);
        }
        throw new IllegalStateException("called getBitmap() on " + this);
    }

    public int getResId() {
        if (this.mType == -1) {
            return Api23Impl.getResId(this.mObj1);
        }
        if (this.mType == 2) {
            return this.mInt1;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String getResPackage() {
        if (this.mType == -1) {
            return Api23Impl.getResPackage(this.mObj1);
        }
        if (this.mType == 2) {
            if (this.mString1 != null && !TextUtils.isEmpty((CharSequence)this.mString1)) {
                return this.mString1;
            }
            return ((String)this.mObj1).split(":", -1)[0];
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int getType() {
        if (this.mType == -1) {
            return Api23Impl.getType(this.mObj1);
        }
        return this.mType;
    }

    public Uri getUri() {
        if (this.mType == -1) {
            return Api23Impl.getUri(this.mObj1);
        }
        if (this.mType != 4 && this.mType != 6) {
            throw new IllegalStateException("called getUri() on " + this);
        }
        return Uri.parse((String)((String)this.mObj1));
    }

    public InputStream getUriInputStream(Context object) {
        Uri uri = this.getUri();
        String string2 = uri.getScheme();
        if (!"content".equals(string2) && !"file".equals(string2)) {
            try {
                object = new File((String)this.mObj1);
                object = new FileInputStream((File)object);
                return object;
            }
            catch (FileNotFoundException fileNotFoundException) {
                Log.w((String)TAG, (String)("Unable to load image from path: " + uri), (Throwable)fileNotFoundException);
            }
        } else {
            try {
                object = object.getContentResolver().openInputStream(uri);
                return object;
            }
            catch (Exception exception) {
                Log.w((String)TAG, (String)("Unable to load image from URI: " + uri), (Throwable)exception);
            }
        }
        return null;
    }

    public Drawable loadDrawable(Context context) {
        this.checkResource(context);
        return Api23Impl.loadDrawable(this.toIcon(context), context);
    }

    @Override
    public void onPostParceling() {
        this.mTintMode = PorterDuff.Mode.valueOf((String)this.mTintModeStr);
        switch (this.mType) {
            default: {
                break;
            }
            case 3: {
                this.mObj1 = this.mData;
                break;
            }
            case 2: 
            case 4: 
            case 6: {
                this.mObj1 = new String(this.mData, Charset.forName("UTF-16"));
                if (this.mType != 2 || this.mString1 != null) break;
                this.mString1 = ((String)this.mObj1).split(":", -1)[0];
                break;
            }
            case 1: 
            case 5: {
                if (this.mParcelable != null) {
                    this.mObj1 = this.mParcelable;
                    break;
                }
                this.mObj1 = this.mData;
                this.mType = 3;
                this.mInt1 = 0;
                this.mInt2 = this.mData.length;
                break;
            }
            case -1: {
                if (this.mParcelable != null) {
                    this.mObj1 = this.mParcelable;
                    break;
                }
                throw new IllegalArgumentException("Invalid icon");
            }
        }
    }

    @Override
    public void onPreParceling(boolean bl) {
        this.mTintModeStr = this.mTintMode.name();
        switch (this.mType) {
            default: {
                break;
            }
            case 4: 
            case 6: {
                this.mData = this.mObj1.toString().getBytes(Charset.forName("UTF-16"));
                break;
            }
            case 3: {
                this.mData = (byte[])this.mObj1;
                break;
            }
            case 2: {
                this.mData = ((String)this.mObj1).getBytes(Charset.forName("UTF-16"));
                break;
            }
            case 1: 
            case 5: {
                if (bl) {
                    Bitmap bitmap = (Bitmap)this.mObj1;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 90, (OutputStream)byteArrayOutputStream);
                    this.mData = byteArrayOutputStream.toByteArray();
                    break;
                }
                this.mParcelable = (Parcelable)this.mObj1;
                break;
            }
            case -1: {
                if (!bl) {
                    this.mParcelable = (Parcelable)this.mObj1;
                    break;
                }
                throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
            }
        }
    }

    public IconCompat setTint(int n) {
        return this.setTintList(ColorStateList.valueOf((int)n));
    }

    public IconCompat setTintList(ColorStateList colorStateList) {
        this.mTintList = colorStateList;
        return this;
    }

    public IconCompat setTintMode(PorterDuff.Mode mode) {
        this.mTintMode = mode;
        return this;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        switch (this.mType) {
            default: {
                throw new IllegalArgumentException("Invalid icon");
            }
            case 3: {
                bundle.putByteArray(EXTRA_OBJ, (byte[])this.mObj1);
                break;
            }
            case 2: 
            case 4: 
            case 6: {
                bundle.putString(EXTRA_OBJ, (String)this.mObj1);
                break;
            }
            case 1: 
            case 5: {
                bundle.putParcelable(EXTRA_OBJ, (Parcelable)((Bitmap)this.mObj1));
                break;
            }
            case -1: {
                bundle.putParcelable(EXTRA_OBJ, (Parcelable)this.mObj1);
            }
        }
        bundle.putInt(EXTRA_TYPE, this.mType);
        bundle.putInt(EXTRA_INT1, this.mInt1);
        bundle.putInt(EXTRA_INT2, this.mInt2);
        bundle.putString(EXTRA_STRING1, this.mString1);
        if (this.mTintList != null) {
            bundle.putParcelable(EXTRA_TINT_LIST, (Parcelable)this.mTintList);
        }
        if (this.mTintMode != DEFAULT_TINT_MODE) {
            bundle.putString(EXTRA_TINT_MODE, this.mTintMode.name());
        }
        return bundle;
    }

    @Deprecated
    public Icon toIcon() {
        return this.toIcon(null);
    }

    public Icon toIcon(Context context) {
        return Api23Impl.toIcon(this, context);
    }

    public String toString() {
        if (this.mType == -1) {
            return String.valueOf(this.mObj1);
        }
        StringBuilder stringBuilder = new StringBuilder("Icon(typ=").append(IconCompat.typeToString(this.mType));
        switch (this.mType) {
            default: {
                break;
            }
            case 4: 
            case 6: {
                stringBuilder.append(" uri=").append(this.mObj1);
                break;
            }
            case 3: {
                stringBuilder.append(" len=").append(this.mInt1);
                if (this.mInt2 == 0) break;
                stringBuilder.append(" off=").append(this.mInt2);
                break;
            }
            case 2: {
                stringBuilder.append(" pkg=").append(this.mString1).append(" id=").append(String.format("0x%08x", this.getResId()));
                break;
            }
            case 1: 
            case 5: {
                stringBuilder.append(" size=").append(((Bitmap)this.mObj1).getWidth()).append("x").append(((Bitmap)this.mObj1).getHeight());
            }
        }
        if (this.mTintList != null) {
            stringBuilder.append(" tint=");
            stringBuilder.append(this.mTintList);
        }
        if (this.mTintMode != DEFAULT_TINT_MODE) {
            stringBuilder.append(" mode=").append(this.mTintMode);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static IconCompat createFromIcon(Context object, Icon icon) {
            switch (Api23Impl.getType(icon)) {
                default: {
                    object = new IconCompat(-1);
                    object.mObj1 = icon;
                    return object;
                }
                case 6: {
                    return IconCompat.createWithAdaptiveBitmapContentUri(Api23Impl.getUri(icon));
                }
                case 4: {
                    return IconCompat.createWithContentUri(Api23Impl.getUri(icon));
                }
                case 2: 
            }
            String string2 = Api23Impl.getResPackage(icon);
            try {
                object = IconCompat.createWithResource(IconCompat.getResources(object, string2), string2, Api23Impl.getResId(icon));
                return object;
            }
            catch (Resources.NotFoundException notFoundException) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        }

        static IconCompat createFromIconInner(Object object) {
            Preconditions.checkNotNull(object);
            switch (Api23Impl.getType(object)) {
                default: {
                    IconCompat iconCompat = new IconCompat(-1);
                    iconCompat.mObj1 = object;
                    return iconCompat;
                }
                case 6: {
                    return IconCompat.createWithAdaptiveBitmapContentUri(Api23Impl.getUri(object));
                }
                case 4: {
                    return IconCompat.createWithContentUri(Api23Impl.getUri(object));
                }
                case 2: 
            }
            return IconCompat.createWithResource(null, Api23Impl.getResPackage(object), Api23Impl.getResId(object));
        }

        static int getResId(Object object) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.getResId(object);
            }
            try {
                int n = (Integer)object.getClass().getMethod("getResId", new Class[0]).invoke(object, new Object[0]);
                return n;
            }
            catch (NoSuchMethodException noSuchMethodException) {
                Log.e((String)IconCompat.TAG, (String)"Unable to get icon resource", (Throwable)noSuchMethodException);
                return 0;
            }
            catch (InvocationTargetException invocationTargetException) {
                Log.e((String)IconCompat.TAG, (String)"Unable to get icon resource", (Throwable)invocationTargetException);
                return 0;
            }
            catch (IllegalAccessException illegalAccessException) {
                Log.e((String)IconCompat.TAG, (String)"Unable to get icon resource", (Throwable)illegalAccessException);
                return 0;
            }
        }

        static String getResPackage(Object object) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.getResPackage(object);
            }
            try {
                object = (String)object.getClass().getMethod("getResPackage", new Class[0]).invoke(object, new Object[0]);
                return object;
            }
            catch (NoSuchMethodException noSuchMethodException) {
                Log.e((String)IconCompat.TAG, (String)"Unable to get icon package", (Throwable)noSuchMethodException);
                return null;
            }
            catch (InvocationTargetException invocationTargetException) {
                Log.e((String)IconCompat.TAG, (String)"Unable to get icon package", (Throwable)invocationTargetException);
                return null;
            }
            catch (IllegalAccessException illegalAccessException) {
                Log.e((String)IconCompat.TAG, (String)"Unable to get icon package", (Throwable)illegalAccessException);
                return null;
            }
        }

        static int getType(Object object) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.getType(object);
            }
            try {
                int n = (Integer)object.getClass().getMethod("getType", new Class[0]).invoke(object, new Object[0]);
                return n;
            }
            catch (NoSuchMethodException noSuchMethodException) {
                Log.e((String)IconCompat.TAG, (String)("Unable to get icon type " + object), (Throwable)noSuchMethodException);
                return -1;
            }
            catch (InvocationTargetException invocationTargetException) {
                Log.e((String)IconCompat.TAG, (String)("Unable to get icon type " + object), (Throwable)invocationTargetException);
                return -1;
            }
            catch (IllegalAccessException illegalAccessException) {
                Log.e((String)IconCompat.TAG, (String)("Unable to get icon type " + object), (Throwable)illegalAccessException);
                return -1;
            }
        }

        static Uri getUri(Object object) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.getUri(object);
            }
            try {
                object = (Uri)object.getClass().getMethod("getUri", new Class[0]).invoke(object, new Object[0]);
                return object;
            }
            catch (NoSuchMethodException noSuchMethodException) {
                Log.e((String)IconCompat.TAG, (String)"Unable to get icon uri", (Throwable)noSuchMethodException);
                return null;
            }
            catch (InvocationTargetException invocationTargetException) {
                Log.e((String)IconCompat.TAG, (String)"Unable to get icon uri", (Throwable)invocationTargetException);
                return null;
            }
            catch (IllegalAccessException illegalAccessException) {
                Log.e((String)IconCompat.TAG, (String)"Unable to get icon uri", (Throwable)illegalAccessException);
                return null;
            }
        }

        static Drawable loadDrawable(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }

        /*
         * Unable to fully structure code
         * Could not resolve type clashes
         */
        static Icon toIcon(IconCompat var0, Context var1_1) {
            switch (var0.mType) {
                default: {
                    throw new IllegalArgumentException("Unknown type");
                }
                case 6: {
                    if (Build.VERSION.SDK_INT < 30) ** GOTO lbl8
                    var1_1 /* !! */  = Api30Impl.createWithAdaptiveBitmapContentUri(var0.getUri());
                    ** GOTO lbl28
lbl8:
                    // 1 sources

                    if (var1_1 /* !! */  == null) ** GOTO lbl13
                    if ((var1_1 /* !! */  = var0.getUriInputStream(var1_1 /* !! */ )) == null) ** GOTO lbl12
                    var1_1 /* !! */  = Build.VERSION.SDK_INT >= 26 ? Api26Impl.createWithAdaptiveBitmap(BitmapFactory.decodeStream((InputStream)var1_1 /* !! */ )) : Icon.createWithBitmap((Bitmap)IconCompat.createLegacyIconFromAdaptiveIcon(BitmapFactory.decodeStream((InputStream)var1_1 /* !! */ ), false));
                    ** GOTO lbl28
lbl12:
                    // 1 sources

                    throw new IllegalStateException("Cannot load adaptive icon from uri: " + var0.getUri());
lbl13:
                    // 1 sources

                    throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + var0.getUri());
                }
                case 5: {
                    var1_1 /* !! */  = Build.VERSION.SDK_INT >= 26 ? Api26Impl.createWithAdaptiveBitmap((Bitmap)var0.mObj1) : Icon.createWithBitmap((Bitmap)IconCompat.createLegacyIconFromAdaptiveIcon((Bitmap)var0.mObj1, false));
                    ** GOTO lbl28
                }
                case 4: {
                    var1_1 /* !! */  = Icon.createWithContentUri((String)((String)var0.mObj1));
                    ** GOTO lbl28
                }
                case 3: {
                    var1_1 /* !! */  = Icon.createWithData((byte[])((byte[])var0.mObj1), (int)var0.mInt1, (int)var0.mInt2);
                    ** GOTO lbl28
                }
                case 2: {
                    var1_1 /* !! */  = Icon.createWithResource((String)var0.getResPackage(), (int)var0.mInt1);
                    ** GOTO lbl28
                }
                case 1: {
                    var1_1 /* !! */  = Icon.createWithBitmap((Bitmap)((Bitmap)var0.mObj1));
lbl28:
                    // 7 sources

                    if (var0.mTintList != null) {
                        var1_1 /* !! */ .setTintList(var0.mTintList);
                    }
                    if (var0.mTintMode != IconCompat.DEFAULT_TINT_MODE) {
                        var1_1 /* !! */ .setTintMode(var0.mTintMode);
                    }
                    return var1_1 /* !! */ ;
                }
                case -1: 
            }
            return (Icon)var0.mObj1;
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static Drawable createAdaptiveIconDrawable(Drawable drawable2, Drawable drawable3) {
            return new AdaptiveIconDrawable(drawable2, drawable3);
        }

        static Icon createWithAdaptiveBitmap(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap((Bitmap)bitmap);
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static int getResId(Object object) {
            return ((Icon)object).getResId();
        }

        static String getResPackage(Object object) {
            return ((Icon)object).getResPackage();
        }

        static int getType(Object object) {
            return ((Icon)object).getType();
        }

        static Uri getUri(Object object) {
            return ((Icon)object).getUri();
        }
    }

    static class Api30Impl {
        private Api30Impl() {
        }

        static Icon createWithAdaptiveBitmapContentUri(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri((Uri)uri);
        }
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface IconType {
    }
}

