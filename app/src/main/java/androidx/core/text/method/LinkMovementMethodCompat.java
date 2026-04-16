/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.Layout
 *  android.text.Selection
 *  android.text.Spannable
 *  android.text.method.LinkMovementMethod
 *  android.text.method.Touch
 *  android.view.MotionEvent
 *  android.widget.TextView
 */
package androidx.core.text.method;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.core.os.BuildCompat;

public class LinkMovementMethodCompat
extends LinkMovementMethod {
    private static LinkMovementMethodCompat sInstance;

    private LinkMovementMethodCompat() {
    }

    public static LinkMovementMethodCompat getInstance() {
        if (sInstance == null) {
            sInstance = new LinkMovementMethodCompat();
        }
        return sInstance;
    }

    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        if (!BuildCompat.isAtLeastV()) {
            int n = motionEvent.getAction();
            boolean bl = true;
            if (n == 1 || n == 0) {
                int n2 = (int)motionEvent.getX();
                n = (int)motionEvent.getY();
                int n3 = textView.getTotalPaddingLeft();
                int n4 = textView.getTotalPaddingTop();
                n2 = n2 - n3 + textView.getScrollX();
                n = n - n4 + textView.getScrollY();
                Layout layout2 = textView.getLayout();
                if (n >= 0 && n <= layout2.getHeight()) {
                    if (!((float)n2 < layout2.getLineLeft(n = layout2.getLineForVertical(n))) && !((float)n2 > layout2.getLineRight(n))) {
                        bl = false;
                    }
                } else {
                    bl = true;
                }
                if (bl) {
                    Selection.removeSelection((Spannable)spannable);
                    return Touch.onTouchEvent((TextView)textView, (Spannable)spannable, (MotionEvent)motionEvent);
                }
            }
        }
        return super.onTouchEvent(textView, spannable, motionEvent);
    }
}

