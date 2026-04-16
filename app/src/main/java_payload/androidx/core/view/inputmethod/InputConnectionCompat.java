/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ClipData
 *  android.content.ClipData$Item
 *  android.content.ClipDescription
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.os.ResultReceiver
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.View
 *  android.view.inputmethod.EditorInfo
 *  android.view.inputmethod.InputConnection
 *  android.view.inputmethod.InputConnectionWrapper
 *  android.view.inputmethod.InputContentInfo
 */
package androidx.core.view.inputmethod;

import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.view.inputmethod.InputConnectionCompat$$ExternalSyntheticLambda0;
import androidx.core.view.inputmethod.InputContentInfoCompat;

public final class InputConnectionCompat {
    private static final String COMMIT_CONTENT_ACTION = "androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
    private static final String COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";
    private static final String COMMIT_CONTENT_CONTENT_URI_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI";
    private static final String COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
    private static final String COMMIT_CONTENT_DESCRIPTION_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
    private static final String COMMIT_CONTENT_FLAGS_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
    private static final String COMMIT_CONTENT_FLAGS_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
    private static final String COMMIT_CONTENT_INTEROP_ACTION = "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
    private static final String COMMIT_CONTENT_LINK_URI_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
    private static final String COMMIT_CONTENT_LINK_URI_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
    private static final String COMMIT_CONTENT_OPTS_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
    private static final String COMMIT_CONTENT_OPTS_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
    private static final String COMMIT_CONTENT_RESULT_INTEROP_RECEIVER_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
    private static final String COMMIT_CONTENT_RESULT_RECEIVER_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
    private static final String EXTRA_INPUT_CONTENT_INFO = "androidx.core.view.extra.INPUT_CONTENT_INFO";
    public static final int INPUT_CONTENT_GRANT_READ_URI_PERMISSION = 1;
    private static final String LOG_TAG = "InputConnectionCompat";

    @Deprecated
    public InputConnectionCompat() {
    }

    public static boolean commitContent(InputConnection inputConnection, EditorInfo object, InputContentInfoCompat inputContentInfoCompat, int n, Bundle bundle) {
        boolean bl;
        if (Build.VERSION.SDK_INT >= 25) {
            return Api25Impl.commitContent(inputConnection, (InputContentInfo)inputContentInfoCompat.unwrap(), n, bundle);
        }
        switch (EditorInfoCompat.getProtocol(object)) {
            default: {
                return false;
            }
            case 3: 
            case 4: {
                bl = false;
                break;
            }
            case 2: {
                bl = true;
            }
        }
        Bundle bundle2 = new Bundle();
        object = bl ? COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY : COMMIT_CONTENT_CONTENT_URI_KEY;
        bundle2.putParcelable((String)object, (Parcelable)inputContentInfoCompat.getContentUri());
        object = bl ? COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY : COMMIT_CONTENT_DESCRIPTION_KEY;
        bundle2.putParcelable((String)object, (Parcelable)inputContentInfoCompat.getDescription());
        object = bl ? COMMIT_CONTENT_LINK_URI_INTEROP_KEY : COMMIT_CONTENT_LINK_URI_KEY;
        bundle2.putParcelable((String)object, (Parcelable)inputContentInfoCompat.getLinkUri());
        object = bl ? COMMIT_CONTENT_FLAGS_INTEROP_KEY : COMMIT_CONTENT_FLAGS_KEY;
        bundle2.putInt((String)object, n);
        object = bl ? COMMIT_CONTENT_OPTS_INTEROP_KEY : COMMIT_CONTENT_OPTS_KEY;
        bundle2.putParcelable((String)object, (Parcelable)bundle);
        object = bl ? COMMIT_CONTENT_INTEROP_ACTION : COMMIT_CONTENT_ACTION;
        return inputConnection.performPrivateCommand((String)object, bundle2);
    }

    private static OnCommitContentListener createOnCommitContentListenerUsingPerformReceiveContent(View view) {
        Preconditions.checkNotNull(view);
        return new InputConnectionCompat$$ExternalSyntheticLambda0(view);
    }

    public static InputConnection createWrapper(View view, InputConnection inputConnection, EditorInfo editorInfo) {
        return InputConnectionCompat.createWrapper(inputConnection, editorInfo, InputConnectionCompat.createOnCommitContentListenerUsingPerformReceiveContent(view));
    }

    @Deprecated
    public static InputConnection createWrapper(InputConnection inputConnection, EditorInfo editorInfo, OnCommitContentListener onCommitContentListener) {
        ObjectsCompat.requireNonNull(inputConnection, "inputConnection must be non-null");
        ObjectsCompat.requireNonNull(editorInfo, "editorInfo must be non-null");
        ObjectsCompat.requireNonNull(onCommitContentListener, "onCommitContentListener must be non-null");
        if (Build.VERSION.SDK_INT >= 25) {
            return new InputConnectionWrapper(inputConnection, false, onCommitContentListener){
                final OnCommitContentListener val$listener;
                {
                    this.val$listener = onCommitContentListener;
                    super(inputConnection, bl);
                }

                public boolean commitContent(InputContentInfo inputContentInfo, int n, Bundle bundle) {
                    if (this.val$listener.onCommitContent(InputContentInfoCompat.wrap(inputContentInfo), n, bundle)) {
                        return true;
                    }
                    return super.commitContent(inputContentInfo, n, bundle);
                }
            };
        }
        if (EditorInfoCompat.getContentMimeTypes(editorInfo).length == 0) {
            return inputConnection;
        }
        return new InputConnectionWrapper(inputConnection, false, onCommitContentListener){
            final OnCommitContentListener val$listener;
            {
                this.val$listener = onCommitContentListener;
                super(inputConnection, bl);
            }

            public boolean performPrivateCommand(String string2, Bundle bundle) {
                if (InputConnectionCompat.handlePerformPrivateCommand(string2, bundle, this.val$listener)) {
                    return true;
                }
                return super.performPrivateCommand(string2, bundle);
            }
        };
    }

    static boolean handlePerformPrivateCommand(String string2, Bundle bundle, OnCommitContentListener onCommitContentListener) {
        block18: {
            boolean bl;
            ResultReceiver resultReceiver;
            int n;
            int n2;
            block15: {
                block17: {
                    block16: {
                        n2 = 0;
                        if (bundle == null) {
                            return false;
                        }
                        if (!TextUtils.equals((CharSequence)COMMIT_CONTENT_ACTION, (CharSequence)string2)) break block16;
                        n = 0;
                        break block17;
                    }
                    if (!TextUtils.equals((CharSequence)COMMIT_CONTENT_INTEROP_ACTION, (CharSequence)string2)) break block18;
                    n = 1;
                }
                string2 = null;
                boolean bl2 = false;
                Object object = n != 0 ? COMMIT_CONTENT_RESULT_INTEROP_RECEIVER_KEY : COMMIT_CONTENT_RESULT_RECEIVER_KEY;
                try {
                    resultReceiver = (ResultReceiver)bundle.getParcelable((String)object);
                    object = n != 0 ? COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY : COMMIT_CONTENT_CONTENT_URI_KEY;
                    string2 = resultReceiver;
                }
                catch (Throwable throwable) {
                    if (string2 != null) {
                        string2.send(0, null);
                    }
                    throw throwable;
                }
                Uri uri = (Uri)bundle.getParcelable((String)object);
                object = n != 0 ? COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY : COMMIT_CONTENT_DESCRIPTION_KEY;
                string2 = resultReceiver;
                ClipDescription clipDescription = (ClipDescription)bundle.getParcelable((String)object);
                object = n != 0 ? COMMIT_CONTENT_LINK_URI_INTEROP_KEY : COMMIT_CONTENT_LINK_URI_KEY;
                string2 = resultReceiver;
                Uri uri2 = (Uri)bundle.getParcelable((String)object);
                object = n != 0 ? COMMIT_CONTENT_FLAGS_INTEROP_KEY : COMMIT_CONTENT_FLAGS_KEY;
                string2 = resultReceiver;
                int n3 = bundle.getInt((String)object);
                object = n != 0 ? COMMIT_CONTENT_OPTS_INTEROP_KEY : COMMIT_CONTENT_OPTS_KEY;
                string2 = resultReceiver;
                bundle = (Bundle)bundle.getParcelable((String)object);
                bl = bl2;
                if (uri == null) break block15;
                bl = bl2;
                if (clipDescription == null) break block15;
                string2 = resultReceiver;
                string2 = resultReceiver;
                object = new InputContentInfoCompat(uri, clipDescription, uri2);
                string2 = resultReceiver;
                bl = onCommitContentListener.onCommitContent((InputContentInfoCompat)object, n3, bundle);
            }
            if (resultReceiver != null) {
                n = n2;
                if (bl) {
                    n = 1;
                }
                resultReceiver.send(n, null);
            }
            return bl;
        }
        return false;
    }

    static /* synthetic */ boolean lambda$createOnCommitContentListenerUsingPerformReceiveContent$0(View view, InputContentInfoCompat inputContentInfoCompat, int n, Bundle bundle) {
        Bundle bundle2 = bundle;
        int n2 = Build.VERSION.SDK_INT;
        boolean bl = false;
        Bundle bundle3 = bundle2;
        if (n2 >= 25) {
            bundle3 = bundle2;
            if ((n & 1) != 0) {
                try {
                    inputContentInfoCompat.requestPermission();
                }
                catch (Exception exception) {
                    Log.w((String)LOG_TAG, (String)"Can't insert content from IME; requestPermission() failed", (Throwable)exception);
                    return false;
                }
                bundle2 = (Parcelable)inputContentInfoCompat.unwrap();
                bundle3 = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle3.putParcelable(EXTRA_INPUT_CONTENT_INFO, (Parcelable)bundle2);
            }
        }
        if (ViewCompat.performReceiveContent(view, new ContentInfoCompat.Builder(new ClipData(inputContentInfoCompat.getDescription(), new ClipData.Item(inputContentInfoCompat.getContentUri())), 2).setLinkUri(inputContentInfoCompat.getLinkUri()).setExtras(bundle3).build()) == null) {
            bl = true;
        }
        return bl;
    }

    static class Api25Impl {
        private Api25Impl() {
        }

        static boolean commitContent(InputConnection inputConnection, InputContentInfo inputContentInfo, int n, Bundle bundle) {
            return inputConnection.commitContent(inputContentInfo, n, bundle);
        }
    }

    public static interface OnCommitContentListener {
        public boolean onCommitContent(InputContentInfoCompat var1, int var2, Bundle var3);
    }
}

