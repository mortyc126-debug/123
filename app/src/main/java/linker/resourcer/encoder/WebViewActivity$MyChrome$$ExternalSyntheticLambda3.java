/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.webkit.JsPromptResult
 */
package linker.resourcer.encoder;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import linker.resourcer.encoder.WebViewActivity;

public final class WebViewActivity$MyChrome$$ExternalSyntheticLambda3
implements DialogInterface.OnClickListener {
    public final JsPromptResult f$0;

    public /* synthetic */ WebViewActivity$MyChrome$$ExternalSyntheticLambda3(JsPromptResult jsPromptResult) {
        this.f$0 = jsPromptResult;
    }

    public final void onClick(DialogInterface dialogInterface, int n) {
        WebViewActivity.MyChrome.lambda$onJsPrompt$3(this.f$0, dialogInterface, n);
    }
}

