/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.SpannableStringBuilder
 *  android.text.TextUtils
 *  android.view.inputmethod.EditorInfo
 */
package androidx.core.view.inputmethod;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import androidx.core.util.Preconditions;

public final class EditorInfoCompat {
    private static final String CONTENT_MIME_TYPES_INTEROP_KEY = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_MIME_TYPES_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_SELECTION_END_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END";
    private static final String CONTENT_SELECTION_HEAD_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD";
    private static final String CONTENT_SURROUNDING_TEXT_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT";
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final int IME_FLAG_FORCE_ASCII = Integer.MIN_VALUE;
    public static final int IME_FLAG_NO_PERSONALIZED_LEARNING = 0x1000000;
    static final int MAX_INITIAL_SELECTION_LENGTH = 1024;
    static final int MEMORY_EFFICIENT_TEXT_LENGTH = 2048;
    private static final String STYLUS_HANDWRITING_ENABLED_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.STYLUS_HANDWRITING_ENABLED";

    @Deprecated
    public EditorInfoCompat() {
    }

    public static String[] getContentMimeTypes(EditorInfo stringArray) {
        String[] stringArray2;
        if (Build.VERSION.SDK_INT >= 25) {
            stringArray = stringArray.contentMimeTypes;
            if (stringArray == null) {
                stringArray = EMPTY_STRING_ARRAY;
            }
            return stringArray;
        }
        if (stringArray.extras == null) {
            return EMPTY_STRING_ARRAY;
        }
        String[] stringArray3 = stringArray2 = stringArray.extras.getStringArray(CONTENT_MIME_TYPES_KEY);
        if (stringArray2 == null) {
            stringArray3 = stringArray.extras.getStringArray(CONTENT_MIME_TYPES_INTEROP_KEY);
        }
        if (stringArray3 == null) {
            stringArray3 = EMPTY_STRING_ARRAY;
        }
        return stringArray3;
    }

    public static CharSequence getInitialSelectedText(EditorInfo object, int n) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getInitialSelectedText((EditorInfo)object, n);
        }
        if (((EditorInfo)object).extras == null) {
            return null;
        }
        int n2 = Math.min(((EditorInfo)object).initialSelStart, ((EditorInfo)object).initialSelEnd);
        int n3 = Math.max(((EditorInfo)object).initialSelStart, ((EditorInfo)object).initialSelEnd);
        int n4 = ((EditorInfo)object).extras.getInt(CONTENT_SELECTION_HEAD_KEY);
        int n5 = ((EditorInfo)object).extras.getInt(CONTENT_SELECTION_END_KEY);
        if (((EditorInfo)object).initialSelStart >= 0 && ((EditorInfo)object).initialSelEnd >= 0 && n5 - n4 == n3 - n2) {
            object = ((EditorInfo)object).extras.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY);
            if (object == null) {
                return null;
            }
            object = (n & 1) != 0 ? object.subSequence(n4, n5) : TextUtils.substring((CharSequence)object, (int)n4, (int)n5);
            return object;
        }
        return null;
    }

    public static CharSequence getInitialTextAfterCursor(EditorInfo object, int n, int n2) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getInitialTextAfterCursor(object, n, n2);
        }
        if (object.extras == null) {
            return null;
        }
        CharSequence charSequence = object.extras.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY);
        if (charSequence == null) {
            return null;
        }
        int n3 = object.extras.getInt(CONTENT_SELECTION_END_KEY);
        n = Math.min(n, charSequence.length() - n3);
        object = (n2 & 1) != 0 ? charSequence.subSequence(n3, n3 + n) : TextUtils.substring((CharSequence)charSequence, (int)n3, (int)(n3 + n));
        return object;
    }

    public static CharSequence getInitialTextBeforeCursor(EditorInfo object, int n, int n2) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getInitialTextBeforeCursor(object, n, n2);
        }
        if (object.extras == null) {
            return null;
        }
        CharSequence charSequence = object.extras.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY);
        if (charSequence == null) {
            return null;
        }
        int n3 = object.extras.getInt(CONTENT_SELECTION_HEAD_KEY);
        n = Math.min(n, n3);
        object = (n2 & 1) != 0 ? charSequence.subSequence(n3 - n, n3) : TextUtils.substring((CharSequence)charSequence, (int)(n3 - n), (int)n3);
        return object;
    }

    static int getProtocol(EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 25) {
            return 1;
        }
        if (editorInfo.extras == null) {
            return 0;
        }
        boolean bl = editorInfo.extras.containsKey(CONTENT_MIME_TYPES_KEY);
        boolean bl2 = editorInfo.extras.containsKey(CONTENT_MIME_TYPES_INTEROP_KEY);
        if (bl && bl2) {
            return 4;
        }
        if (bl) {
            return 3;
        }
        if (bl2) {
            return 2;
        }
        return 0;
    }

    private static boolean isCutOnSurrogate(CharSequence charSequence, int n, int n2) {
        switch (n2) {
            default: {
                return false;
            }
            case 1: {
                return Character.isHighSurrogate(charSequence.charAt(n));
            }
            case 0: 
        }
        return Character.isLowSurrogate(charSequence.charAt(n));
    }

    private static boolean isPasswordInputType(int n) {
        boolean bl = (n &= 0xFFF) == 129 || n == 225 || n == 18;
        return bl;
    }

    public static boolean isStylusHandwritingEnabled(EditorInfo editorInfo) {
        if (editorInfo.extras == null) {
            return false;
        }
        return editorInfo.extras.getBoolean(STYLUS_HANDWRITING_ENABLED_KEY);
    }

    public static void setContentMimeTypes(EditorInfo editorInfo, String[] stringArray) {
        if (Build.VERSION.SDK_INT >= 25) {
            editorInfo.contentMimeTypes = stringArray;
        } else {
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            editorInfo.extras.putStringArray(CONTENT_MIME_TYPES_KEY, stringArray);
            editorInfo.extras.putStringArray(CONTENT_MIME_TYPES_INTEROP_KEY, stringArray);
        }
    }

    public static void setInitialSurroundingSubText(EditorInfo editorInfo, CharSequence charSequence, int n) {
        Preconditions.checkNotNull(charSequence);
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.setInitialSurroundingSubText(editorInfo, charSequence, n);
            return;
        }
        int n2 = editorInfo.initialSelStart > editorInfo.initialSelEnd ? editorInfo.initialSelEnd - n : editorInfo.initialSelStart - n;
        int n3 = editorInfo.initialSelStart > editorInfo.initialSelEnd ? editorInfo.initialSelStart - n : editorInfo.initialSelEnd - n;
        int n4 = charSequence.length();
        if (n >= 0 && n2 >= 0 && n3 <= n4) {
            if (EditorInfoCompat.isPasswordInputType(editorInfo.inputType)) {
                EditorInfoCompat.setSurroundingText(editorInfo, null, 0, 0);
                return;
            }
            if (n4 <= 2048) {
                EditorInfoCompat.setSurroundingText(editorInfo, charSequence, n2, n3);
                return;
            }
            EditorInfoCompat.trimLongSurroundingText(editorInfo, charSequence, n2, n3);
            return;
        }
        EditorInfoCompat.setSurroundingText(editorInfo, null, 0, 0);
    }

    public static void setInitialSurroundingText(EditorInfo editorInfo, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.setInitialSurroundingSubText(editorInfo, charSequence, 0);
        } else {
            EditorInfoCompat.setInitialSurroundingSubText(editorInfo, charSequence, 0);
        }
    }

    public static void setStylusHandwritingEnabled(EditorInfo editorInfo, boolean bl) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putBoolean(STYLUS_HANDWRITING_ENABLED_KEY, bl);
    }

    private static void setSurroundingText(EditorInfo editorInfo, CharSequence charSequence, int n, int n2) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        charSequence = charSequence != null ? new SpannableStringBuilder(charSequence) : null;
        editorInfo.extras.putCharSequence(CONTENT_SURROUNDING_TEXT_KEY, charSequence);
        editorInfo.extras.putInt(CONTENT_SELECTION_HEAD_KEY, n);
        editorInfo.extras.putInt(CONTENT_SELECTION_END_KEY, n2);
    }

    private static void trimLongSurroundingText(EditorInfo editorInfo, CharSequence charSequence, int n, int n2) {
        int n3 = n2 - n;
        int n4 = n3 > 1024 ? 0 : n3;
        int n5 = charSequence.length();
        int n6 = 2048 - n4;
        int n7 = Math.min(n5 - n2, n6 - Math.min(n, (int)((double)n6 * 0.8)));
        int n8 = Math.min(n, n6 - n7);
        int n9 = n - n8;
        n5 = n8;
        n6 = n9;
        if (EditorInfoCompat.isCutOnSurrogate(charSequence, n - n8, 0)) {
            n6 = n9 + 1;
            n5 = n8 - 1;
        }
        n = n7;
        if (EditorInfoCompat.isCutOnSurrogate(charSequence, n2 + n7 - 1, 1)) {
            n = n7 - 1;
        }
        charSequence = n4 != n3 ? TextUtils.concat((CharSequence[])new CharSequence[]{charSequence.subSequence(n6, n6 + n5), charSequence.subSequence(n2, n2 + n)}) : charSequence.subSequence(n6, n6 + (n5 + n4 + n));
        n = 0 + n5;
        EditorInfoCompat.setSurroundingText(editorInfo, charSequence, n, n + n4);
    }

    private static class Api30Impl {
        private Api30Impl() {
        }

        static CharSequence getInitialSelectedText(EditorInfo editorInfo, int n) {
            return editorInfo.getInitialSelectedText(n);
        }

        static CharSequence getInitialTextAfterCursor(EditorInfo editorInfo, int n, int n2) {
            return editorInfo.getInitialTextAfterCursor(n, n2);
        }

        static CharSequence getInitialTextBeforeCursor(EditorInfo editorInfo, int n, int n2) {
            return editorInfo.getInitialTextBeforeCursor(n, n2);
        }

        static void setInitialSurroundingSubText(EditorInfo editorInfo, CharSequence charSequence, int n) {
            editorInfo.setInitialSurroundingSubText(charSequence, n);
        }
    }
}

