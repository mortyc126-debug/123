/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.webkit.JsPromptResult
 *  android.widget.EditText
 */
package linker.resourcer.encoder;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import android.widget.EditText;
import linker.resourcer.encoder.yynnsnupqughbjmsvq;

public final class yynnsnupqughbjmsvq$MyChrome$$ExternalSyntheticLambda2
implements DialogInterface.OnClickListener {
    public final JsPromptResult f$0;
    public final EditText f$1;

    public /* synthetic */ yynnsnupqughbjmsvq$MyChrome$$ExternalSyntheticLambda2(JsPromptResult jsPromptResult, EditText editText) {
        this.f$0 = jsPromptResult;
        this.f$1 = editText;
    }

    public final void onClick(DialogInterface dialogInterface, int n) {
        yynnsnupqughbjmsvq.MyChrome.lambda$onJsPrompt$2(this.f$0, this.f$1, dialogInterface, n);
    }
}

