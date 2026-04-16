/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 */
package androidx.core.view.inputmethod;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;

public final class InputConnectionCompat$$ExternalSyntheticLambda0
implements InputConnectionCompat.OnCommitContentListener {
    public final View f$0;

    public /* synthetic */ InputConnectionCompat$$ExternalSyntheticLambda0(View view) {
        this.f$0 = view;
    }

    @Override
    public final boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int n, Bundle bundle) {
        return InputConnectionCompat.lambda$createOnCommitContentListenerUsingPerformReceiveContent$0(this.f$0, inputContentInfoCompat, n, bundle);
    }
}

