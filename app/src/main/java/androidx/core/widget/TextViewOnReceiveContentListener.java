/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ClipData
 *  android.content.ClipData$Item
 *  android.content.Context
 *  android.text.Editable
 *  android.text.Selection
 *  android.text.Spannable
 *  android.text.Spanned
 *  android.util.Log
 *  android.view.View
 *  android.widget.TextView
 */
package androidx.core.widget;

import android.content.ClipData;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentListener;

public final class TextViewOnReceiveContentListener
implements OnReceiveContentListener {
    private static final String LOG_TAG = "ReceiveContent";

    private static CharSequence coerceToText(Context object, ClipData.Item item, int n) {
        if ((n & 1) != 0) {
            if ((object = item.coerceToText((Context)object)) instanceof Spanned) {
                object = object.toString();
            }
            return object;
        }
        return item.coerceToStyledText((Context)object);
    }

    private static void replaceSelection(Editable editable, CharSequence charSequence) {
        int n = Selection.getSelectionStart((CharSequence)editable);
        int n2 = Selection.getSelectionEnd((CharSequence)editable);
        int n3 = Math.max(0, Math.min(n, n2));
        n = Math.max(0, Math.max(n, n2));
        Selection.setSelection((Spannable)editable, (int)n);
        editable.replace(n3, n, charSequence);
    }

    @Override
    public ContentInfoCompat onReceiveContent(View view, ContentInfoCompat contentInfoCompat) {
        if (Log.isLoggable((String)LOG_TAG, (int)3)) {
            Log.d((String)LOG_TAG, (String)("onReceive: " + contentInfoCompat));
        }
        if (contentInfoCompat.getSource() == 2) {
            return contentInfoCompat;
        }
        ClipData clipData = contentInfoCompat.getClip();
        int n = contentInfoCompat.getFlags();
        contentInfoCompat = (TextView)view;
        view = (Editable)contentInfoCompat.getText();
        contentInfoCompat = contentInfoCompat.getContext();
        boolean bl = false;
        for (int i = 0; i < clipData.getItemCount(); ++i) {
            CharSequence charSequence = TextViewOnReceiveContentListener.coerceToText((Context)contentInfoCompat, clipData.getItemAt(i), n);
            boolean bl2 = bl;
            if (charSequence != null) {
                if (!bl) {
                    TextViewOnReceiveContentListener.replaceSelection((Editable)view, charSequence);
                    bl2 = true;
                } else {
                    view.insert(Selection.getSelectionEnd((CharSequence)view), (CharSequence)"\n");
                    view.insert(Selection.getSelectionEnd((CharSequence)view), charSequence);
                    bl2 = bl;
                }
            }
            bl = bl2;
        }
        return null;
    }
}

