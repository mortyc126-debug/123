/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.webkit.JsResult
 */
package linker.resourcer.encoder;

import android.content.DialogInterface;
import android.webkit.JsResult;
import linker.resourcer.encoder.WebViewActivity;

public final class WebViewActivity$MyChrome$$ExternalSyntheticLambda0
implements DialogInterface.OnClickListener {
    public final JsResult f$0;

    public /* synthetic */ WebViewActivity$MyChrome$$ExternalSyntheticLambda0(JsResult jsResult) {
        this.f$0 = jsResult;
    }

    public final void onClick(DialogInterface dialogInterface, int n) {
        WebViewActivity.MyChrome.lambda$onJsConfirm$0(this.f$0, dialogInterface, n);
    }
}

