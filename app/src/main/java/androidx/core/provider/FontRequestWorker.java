/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.graphics.Typeface
 */
package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.provider.CallbackWithHandler;
import androidx.core.provider.FontProvider;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import androidx.core.provider.RequestExecutor;
import androidx.core.util.Consumer;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

class FontRequestWorker {
    private static final ExecutorService DEFAULT_EXECUTOR_SERVICE;
    static final Object LOCK;
    static final SimpleArrayMap<String, ArrayList<Consumer<TypefaceResult>>> PENDING_REPLIES;
    static final LruCache<String, Typeface> sTypefaceCache;

    static {
        sTypefaceCache = new LruCache(16);
        DEFAULT_EXECUTOR_SERVICE = RequestExecutor.createDefaultExecutor("fonts-androidx", 10, 10000);
        LOCK = new Object();
        PENDING_REPLIES = new SimpleArrayMap();
    }

    private FontRequestWorker() {
    }

    private static String createCacheId(FontRequest fontRequest, int n) {
        return fontRequest.getId() + "-" + n;
    }

    private static int getFontFamilyResultStatus(FontsContractCompat.FontFamilyResult fontInfoArray) {
        int n = fontInfoArray.getStatusCode();
        int n2 = -3;
        if (n != 0) {
            switch (fontInfoArray.getStatusCode()) {
                default: {
                    return -3;
                }
                case 1: 
            }
            return -2;
        }
        if ((fontInfoArray = fontInfoArray.getFonts()) != null && fontInfoArray.length != 0) {
            int n3 = fontInfoArray.length;
            for (n = 0; n < n3; ++n) {
                int n4 = fontInfoArray[n].getResultCode();
                if (n4 == 0) continue;
                n = n4 < 0 ? n2 : n4;
                return n;
            }
            return 0;
        }
        return 1;
    }

    static TypefaceResult getFontSync(String string2, Context context, FontRequest object, int n) {
        Typeface typeface = sTypefaceCache.get(string2);
        if (typeface != null) {
            return new TypefaceResult(typeface);
        }
        try {
            object = FontProvider.getFontFamilyResult(context, (FontRequest)object, null);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return new TypefaceResult(-1);
        }
        int n2 = FontRequestWorker.getFontFamilyResultStatus((FontsContractCompat.FontFamilyResult)object);
        if (n2 != 0) {
            return new TypefaceResult(n2);
        }
        if ((context = TypefaceCompat.createFromFontInfo(context, null, ((FontsContractCompat.FontFamilyResult)object).getFonts(), n)) != null) {
            sTypefaceCache.put(string2, (Typeface)context);
            return new TypefaceResult((Typeface)context);
        }
        return new TypefaceResult(-3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static Typeface requestFontAsync(Context object, FontRequest fontRequest, int n, Executor executor, CallbackWithHandler object2) {
        String string2 = FontRequestWorker.createCacheId(fontRequest, n);
        Object object3 = sTypefaceCache.get(string2);
        if (object3 != null) {
            ((CallbackWithHandler)object2).onTypefaceResult(new TypefaceResult((Typeface)object3));
            return object3;
        }
        object3 = new Consumer<TypefaceResult>((CallbackWithHandler)object2){
            final CallbackWithHandler val$callback;
            {
                this.val$callback = callbackWithHandler;
            }

            @Override
            public void accept(TypefaceResult typefaceResult) {
                TypefaceResult typefaceResult2 = typefaceResult;
                if (typefaceResult == null) {
                    typefaceResult2 = new TypefaceResult(-3);
                }
                this.val$callback.onTypefaceResult(typefaceResult2);
            }
        };
        object2 = LOCK;
        synchronized (object2) {
            ArrayList<Typeface> arrayList = PENDING_REPLIES.get(string2);
            if (arrayList != null) {
                arrayList.add((Typeface)object3);
                return null;
            }
            arrayList = new ArrayList<Typeface>();
            arrayList.add((Typeface)object3);
            PENDING_REPLIES.put(string2, arrayList);
        }
        object = new Callable<TypefaceResult>(){
            final Context val$context;
            final String val$id;
            final FontRequest val$request;
            final int val$style;
            {
                this.val$id = string2;
                this.val$context = context;
                this.val$request = fontRequest;
                this.val$style = n;
            }

            @Override
            public TypefaceResult call() {
                try {
                    TypefaceResult typefaceResult = FontRequestWorker.getFontSync(this.val$id, this.val$context, this.val$request, this.val$style);
                    return typefaceResult;
                }
                catch (Throwable throwable) {
                    return new TypefaceResult(-3);
                }
            }
        };
        if (executor == null) {
            executor = DEFAULT_EXECUTOR_SERVICE;
        }
        RequestExecutor.execute(executor, object, new Consumer<TypefaceResult>(string2){
            final String val$id;
            {
                this.val$id = string2;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void accept(TypefaceResult typefaceResult) {
                ArrayList<Consumer<TypefaceResult>> arrayList;
                Object object = LOCK;
                synchronized (object) {
                    arrayList = PENDING_REPLIES.get(this.val$id);
                    if (arrayList == null) {
                        return;
                    }
                    PENDING_REPLIES.remove(this.val$id);
                }
                int n = 0;
                while (n < arrayList.size()) {
                    arrayList.get(n).accept(typefaceResult);
                    ++n;
                }
                return;
            }
        });
        return null;
    }

    static Typeface requestFontSync(Context object, FontRequest fontRequest, CallbackWithHandler callbackWithHandler, int n, int n2) {
        String string2 = FontRequestWorker.createCacheId(fontRequest, n);
        Typeface typeface = sTypefaceCache.get(string2);
        if (typeface != null) {
            callbackWithHandler.onTypefaceResult(new TypefaceResult(typeface));
            return typeface;
        }
        if (n2 == -1) {
            object = FontRequestWorker.getFontSync(string2, object, fontRequest, n);
            callbackWithHandler.onTypefaceResult((TypefaceResult)object);
            return object.mTypeface;
        }
        object = new Callable<TypefaceResult>(){
            final Context val$context;
            final String val$id;
            final FontRequest val$request;
            final int val$style;
            {
                this.val$id = string2;
                this.val$context = context;
                this.val$request = fontRequest;
                this.val$style = n;
            }

            @Override
            public TypefaceResult call() {
                return FontRequestWorker.getFontSync(this.val$id, this.val$context, this.val$request, this.val$style);
            }
        };
        try {
            object = (TypefaceResult)RequestExecutor.submit(DEFAULT_EXECUTOR_SERVICE, object, n2);
            callbackWithHandler.onTypefaceResult((TypefaceResult)object);
            object = object.mTypeface;
            return object;
        }
        catch (InterruptedException interruptedException) {
            callbackWithHandler.onTypefaceResult(new TypefaceResult(-3));
            return null;
        }
    }

    static void resetTypefaceCache() {
        sTypefaceCache.evictAll();
    }

    static final class TypefaceResult {
        final int mResult;
        final Typeface mTypeface;

        TypefaceResult(int n) {
            this.mTypeface = null;
            this.mResult = n;
        }

        TypefaceResult(Typeface typeface) {
            this.mTypeface = typeface;
            this.mResult = 0;
        }

        boolean isSuccess() {
            boolean bl = this.mResult == 0;
            return bl;
        }
    }
}

