/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ProviderInfo
 *  android.content.res.Resources
 *  android.graphics.Typeface
 *  android.net.Uri
 *  android.os.CancellationSignal
 *  android.os.Handler
 *  android.provider.BaseColumns
 */
package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.provider.BaseColumns;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.provider.CallbackWithHandler;
import androidx.core.provider.FontProvider;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontRequestWorker;
import androidx.core.provider.RequestExecutor;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.Executor;

public class FontsContractCompat {
    @Deprecated
    public static final String PARCEL_FONT_RESULTS = "font_results";
    @Deprecated
    static final int RESULT_CODE_PROVIDER_NOT_FOUND = -1;
    @Deprecated
    static final int RESULT_CODE_WRONG_CERTIFICATES = -2;

    private FontsContractCompat() {
    }

    public static Typeface buildTypeface(Context context, CancellationSignal cancellationSignal, FontInfo[] fontInfoArray) {
        return TypefaceCompat.createFromFontInfo(context, cancellationSignal, fontInfoArray, 0);
    }

    public static FontFamilyResult fetchFonts(Context context, CancellationSignal cancellationSignal, FontRequest fontRequest) throws PackageManager.NameNotFoundException {
        return FontProvider.getFontFamilyResult(context, fontRequest, cancellationSignal);
    }

    @Deprecated
    public static Typeface getFontSync(Context context, FontRequest fontRequest, ResourcesCompat.FontCallback object, Handler handler, boolean bl, int n, int n2) {
        object = new TypefaceCompat.ResourcesCallbackAdapter((ResourcesCompat.FontCallback)object);
        return FontsContractCompat.requestFont(context, fontRequest, n2, bl, n, ResourcesCompat.FontCallback.getHandler(handler), (FontRequestCallback)object);
    }

    @Deprecated
    public static ProviderInfo getProvider(PackageManager packageManager, FontRequest fontRequest, Resources resources) throws PackageManager.NameNotFoundException {
        return FontProvider.getProvider(packageManager, fontRequest, resources);
    }

    @Deprecated
    public static Map<Uri, ByteBuffer> prepareFontData(Context context, FontInfo[] fontInfoArray, CancellationSignal cancellationSignal) {
        return TypefaceCompatUtil.readFontInfoIntoByteBuffer(context, fontInfoArray, cancellationSignal);
    }

    public static Typeface requestFont(Context context, FontRequest fontRequest, int n, boolean bl, int n2, Handler object, FontRequestCallback fontRequestCallback) {
        object = new CallbackWithHandler(fontRequestCallback, (Handler)object);
        if (bl) {
            return FontRequestWorker.requestFontSync(context, fontRequest, (CallbackWithHandler)object, n, n2);
        }
        return FontRequestWorker.requestFontAsync(context, fontRequest, n, null, (CallbackWithHandler)object);
    }

    public static void requestFont(Context context, FontRequest fontRequest, FontRequestCallback object, Handler object2) {
        object = new CallbackWithHandler((FontRequestCallback)object);
        object2 = RequestExecutor.createHandlerExecutor(object2);
        FontRequestWorker.requestFontAsync(context.getApplicationContext(), fontRequest, 0, (Executor)object2, (CallbackWithHandler)object);
    }

    @Deprecated
    public static void resetCache() {
        FontRequestWorker.resetTypefaceCache();
    }

    public static void resetTypefaceCache() {
        FontRequestWorker.resetTypefaceCache();
    }

    public static final class Columns
    implements BaseColumns {
        public static final String FILE_ID = "file_id";
        public static final String ITALIC = "font_italic";
        public static final String RESULT_CODE = "result_code";
        public static final int RESULT_CODE_FONT_NOT_FOUND = 1;
        public static final int RESULT_CODE_FONT_UNAVAILABLE = 2;
        public static final int RESULT_CODE_MALFORMED_QUERY = 3;
        public static final int RESULT_CODE_OK = 0;
        public static final String TTC_INDEX = "font_ttc_index";
        public static final String VARIATION_SETTINGS = "font_variation_settings";
        public static final String WEIGHT = "font_weight";
    }

    public static class FontFamilyResult {
        public static final int STATUS_OK = 0;
        public static final int STATUS_UNEXPECTED_DATA_PROVIDED = 2;
        public static final int STATUS_WRONG_CERTIFICATES = 1;
        private final FontInfo[] mFonts;
        private final int mStatusCode;

        @Deprecated
        public FontFamilyResult(int n, FontInfo[] fontInfoArray) {
            this.mStatusCode = n;
            this.mFonts = fontInfoArray;
        }

        static FontFamilyResult create(int n, FontInfo[] fontInfoArray) {
            return new FontFamilyResult(n, fontInfoArray);
        }

        public FontInfo[] getFonts() {
            return this.mFonts;
        }

        public int getStatusCode() {
            return this.mStatusCode;
        }
    }

    public static class FontInfo {
        private final boolean mItalic;
        private final int mResultCode;
        private final int mTtcIndex;
        private final Uri mUri;
        private final int mWeight;

        @Deprecated
        public FontInfo(Uri uri, int n, int n2, boolean bl, int n3) {
            this.mUri = Preconditions.checkNotNull(uri);
            this.mTtcIndex = n;
            this.mWeight = n2;
            this.mItalic = bl;
            this.mResultCode = n3;
        }

        static FontInfo create(Uri uri, int n, int n2, boolean bl, int n3) {
            return new FontInfo(uri, n, n2, bl, n3);
        }

        public int getResultCode() {
            return this.mResultCode;
        }

        public int getTtcIndex() {
            return this.mTtcIndex;
        }

        public Uri getUri() {
            return this.mUri;
        }

        public int getWeight() {
            return this.mWeight;
        }

        public boolean isItalic() {
            return this.mItalic;
        }
    }

    public static class FontRequestCallback {
        public static final int FAIL_REASON_FONT_LOAD_ERROR = -3;
        public static final int FAIL_REASON_FONT_NOT_FOUND = 1;
        public static final int FAIL_REASON_FONT_UNAVAILABLE = 2;
        public static final int FAIL_REASON_MALFORMED_QUERY = 3;
        public static final int FAIL_REASON_PROVIDER_NOT_FOUND = -1;
        public static final int FAIL_REASON_SECURITY_VIOLATION = -4;
        public static final int FAIL_REASON_WRONG_CERTIFICATES = -2;
        @Deprecated
        public static final int RESULT_OK = 0;
        static final int RESULT_SUCCESS = 0;

        public void onTypefaceRequestFailed(int n) {
        }

        public void onTypefaceRetrieved(Typeface typeface) {
        }

        @Retention(value=RetentionPolicy.SOURCE)
        public static @interface FontRequestFailReason {
        }
    }
}

