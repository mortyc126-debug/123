/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 *  android.os.Handler
 */
package androidx.core.provider;

import android.graphics.Typeface;
import android.os.Handler;
import androidx.core.provider.CalleeHandler;
import androidx.core.provider.FontRequestWorker;
import androidx.core.provider.FontsContractCompat;

class CallbackWithHandler {
    private final FontsContractCompat.FontRequestCallback mCallback;
    private final Handler mCallbackHandler;

    CallbackWithHandler(FontsContractCompat.FontRequestCallback fontRequestCallback) {
        this.mCallback = fontRequestCallback;
        this.mCallbackHandler = CalleeHandler.create();
    }

    CallbackWithHandler(FontsContractCompat.FontRequestCallback fontRequestCallback, Handler handler) {
        this.mCallback = fontRequestCallback;
        this.mCallbackHandler = handler;
    }

    private void onTypefaceRequestFailed(int n) {
        FontsContractCompat.FontRequestCallback fontRequestCallback = this.mCallback;
        this.mCallbackHandler.post(new Runnable(){
            final CallbackWithHandler this$0;
            final FontsContractCompat.FontRequestCallback val$callback;
            final int val$reason;
            {
                this.this$0 = callbackWithHandler;
                this.val$callback = fontRequestCallback;
                this.val$reason = n;
            }

            @Override
            public void run() {
                this.val$callback.onTypefaceRequestFailed(this.val$reason);
            }
        });
    }

    private void onTypefaceRetrieved(Typeface typeface) {
        FontsContractCompat.FontRequestCallback fontRequestCallback = this.mCallback;
        this.mCallbackHandler.post(new Runnable(){
            final CallbackWithHandler this$0;
            final FontsContractCompat.FontRequestCallback val$callback;
            final Typeface val$typeface;
            {
                this.this$0 = callbackWithHandler;
                this.val$callback = fontRequestCallback;
                this.val$typeface = typeface;
            }

            @Override
            public void run() {
                this.val$callback.onTypefaceRetrieved(this.val$typeface);
            }
        });
    }

    void onTypefaceResult(FontRequestWorker.TypefaceResult typefaceResult) {
        if (typefaceResult.isSuccess()) {
            this.onTypefaceRetrieved(typefaceResult.mTypeface);
        } else {
            this.onTypefaceRequestFailed(typefaceResult.mResult);
        }
    }
}

