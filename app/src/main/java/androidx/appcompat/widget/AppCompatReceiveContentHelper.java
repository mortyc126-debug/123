/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ClipData
 *  android.content.ClipboardManager
 *  android.content.ContextWrapper
 *  android.os.Build$VERSION
 *  android.text.Selection
 *  android.text.Spannable
 *  android.util.Log
 *  android.view.DragEvent
 *  android.view.View
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;

final class AppCompatReceiveContentHelper {
    private static final String LOG_TAG = "ReceiveContent";

    private AppCompatReceiveContentHelper() {
    }

    static boolean maybeHandleDragEventViaPerformReceiveContent(View view, DragEvent dragEvent) {
        if (Build.VERSION.SDK_INT < 31 && dragEvent.getLocalState() == null && ViewCompat.getOnReceiveContentMimeTypes(view) != null) {
            Activity activity = AppCompatReceiveContentHelper.tryGetActivity(view);
            if (activity == null) {
                Log.i((String)LOG_TAG, (String)("Can't handle drop: no activity: view=" + view));
                return false;
            }
            if (dragEvent.getAction() == 1) {
                return view instanceof TextView ^ true;
            }
            if (dragEvent.getAction() == 3) {
                boolean bl = view instanceof TextView ? OnDropApi24Impl.onDropForTextView(dragEvent, (TextView)view, activity) : OnDropApi24Impl.onDropForView(dragEvent, view, activity);
                return bl;
            }
            return false;
        }
        return false;
    }

    static boolean maybeHandleMenuActionViaPerformReceiveContent(TextView textView, int n) {
        int n2 = Build.VERSION.SDK_INT;
        int n3 = 0;
        if (n2 < 31 && ViewCompat.getOnReceiveContentMimeTypes((View)textView) != null && (n == 0x1020022 || n == 16908337)) {
            Object object = (ClipboardManager)textView.getContext().getSystemService("clipboard");
            object = object == null ? null : object.getPrimaryClip();
            if (object != null && object.getItemCount() > 0) {
                object = new ContentInfoCompat.Builder((ClipData)object, 1);
                n = n == 0x1020022 ? n3 : 1;
                ViewCompat.performReceiveContent((View)textView, ((ContentInfoCompat.Builder)object).setFlags(n).build());
            }
            return true;
        }
        return false;
    }

    static Activity tryGetActivity(View view) {
        view = view.getContext();
        while (view instanceof ContextWrapper) {
            if (view instanceof Activity) {
                return (Activity)view;
            }
            view = ((ContextWrapper)view).getBaseContext();
        }
        return null;
    }

    private static final class OnDropApi24Impl {
        private OnDropApi24Impl() {
        }

        static boolean onDropForTextView(DragEvent dragEvent, TextView textView, Activity object) {
            object.requestDragAndDropPermissions(dragEvent);
            int n = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
            textView.beginBatchEdit();
            try {
                Selection.setSelection((Spannable)((Spannable)textView.getText()), (int)n);
                object = new ContentInfoCompat.Builder(dragEvent.getClipData(), 3);
                ViewCompat.performReceiveContent((View)textView, ((ContentInfoCompat.Builder)object).build());
                return true;
            }
            finally {
                textView.endBatchEdit();
            }
        }

        static boolean onDropForView(DragEvent dragEvent, View view, Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            ViewCompat.performReceiveContent(view, new ContentInfoCompat.Builder(dragEvent.getClipData(), 3).build());
            return true;
        }
    }
}

