/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.View
 *  android.view.ViewStructure
 *  android.view.autofill.AutofillId
 *  android.view.contentcapture.ContentCaptureSession
 */
package androidx.core.view.contentcapture;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewStructureCompat;
import java.util.List;
import java.util.Objects;

public class ContentCaptureSessionCompat {
    private static final String KEY_VIEW_TREE_APPEARED = "TREAT_AS_VIEW_TREE_APPEARED";
    private static final String KEY_VIEW_TREE_APPEARING = "TREAT_AS_VIEW_TREE_APPEARING";
    private final View mView;
    private final Object mWrappedObj;

    private ContentCaptureSessionCompat(ContentCaptureSession contentCaptureSession, View view) {
        this.mWrappedObj = contentCaptureSession;
        this.mView = view;
    }

    public static ContentCaptureSessionCompat toContentCaptureSessionCompat(ContentCaptureSession contentCaptureSession, View view) {
        return new ContentCaptureSessionCompat(contentCaptureSession, view);
    }

    public AutofillId newAutofillId(long l) {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.newAutofillId((ContentCaptureSession)this.mWrappedObj, Objects.requireNonNull(ViewCompat.getAutofillId(this.mView)).toAutofillId(), l);
        }
        return null;
    }

    public ViewStructureCompat newVirtualViewStructure(AutofillId autofillId, long l) {
        if (Build.VERSION.SDK_INT >= 29) {
            return ViewStructureCompat.toViewStructureCompat(Api29Impl.newVirtualViewStructure((ContentCaptureSession)this.mWrappedObj, autofillId, l));
        }
        return null;
    }

    public void notifyViewTextChanged(AutofillId autofillId, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.notifyViewTextChanged((ContentCaptureSession)this.mWrappedObj, autofillId, charSequence);
        }
    }

    public void notifyViewsAppeared(List<ViewStructure> viewStructure) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.notifyViewsAppeared((ContentCaptureSession)this.mWrappedObj, viewStructure);
        } else if (Build.VERSION.SDK_INT >= 29) {
            ViewStructure viewStructure2 = Api29Impl.newViewStructure((ContentCaptureSession)this.mWrappedObj, this.mView);
            Api23Impl.getExtras(viewStructure2).putBoolean(KEY_VIEW_TREE_APPEARING, true);
            Api29Impl.notifyViewAppeared((ContentCaptureSession)this.mWrappedObj, viewStructure2);
            for (int i = 0; i < viewStructure.size(); ++i) {
                Api29Impl.notifyViewAppeared((ContentCaptureSession)this.mWrappedObj, viewStructure.get(i));
            }
            viewStructure = Api29Impl.newViewStructure((ContentCaptureSession)this.mWrappedObj, this.mView);
            Api23Impl.getExtras(viewStructure).putBoolean(KEY_VIEW_TREE_APPEARED, true);
            Api29Impl.notifyViewAppeared((ContentCaptureSession)this.mWrappedObj, viewStructure);
        }
    }

    public void notifyViewsDisappeared(long[] object) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api29Impl.notifyViewsDisappeared((ContentCaptureSession)this.mWrappedObj, Objects.requireNonNull(ViewCompat.getAutofillId(this.mView)).toAutofillId(), object);
        } else if (Build.VERSION.SDK_INT >= 29) {
            ViewStructure viewStructure = Api29Impl.newViewStructure((ContentCaptureSession)this.mWrappedObj, this.mView);
            Api23Impl.getExtras(viewStructure).putBoolean(KEY_VIEW_TREE_APPEARING, true);
            Api29Impl.notifyViewAppeared((ContentCaptureSession)this.mWrappedObj, viewStructure);
            Api29Impl.notifyViewsDisappeared((ContentCaptureSession)this.mWrappedObj, Objects.requireNonNull(ViewCompat.getAutofillId(this.mView)).toAutofillId(), object);
            object = Api29Impl.newViewStructure((ContentCaptureSession)this.mWrappedObj, this.mView);
            Api23Impl.getExtras((ViewStructure)object).putBoolean(KEY_VIEW_TREE_APPEARED, true);
            Api29Impl.notifyViewAppeared((ContentCaptureSession)this.mWrappedObj, (ViewStructure)object);
        }
    }

    public ContentCaptureSession toContentCaptureSession() {
        return (ContentCaptureSession)this.mWrappedObj;
    }

    private static class Api23Impl {
        private Api23Impl() {
        }

        static Bundle getExtras(ViewStructure viewStructure) {
            return viewStructure.getExtras();
        }
    }

    private static class Api29Impl {
        private Api29Impl() {
        }

        static AutofillId newAutofillId(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long l) {
            return contentCaptureSession.newAutofillId(autofillId, l);
        }

        static ViewStructure newViewStructure(ContentCaptureSession contentCaptureSession, View view) {
            return contentCaptureSession.newViewStructure(view);
        }

        static ViewStructure newVirtualViewStructure(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long l) {
            return contentCaptureSession.newVirtualViewStructure(autofillId, l);
        }

        static void notifyViewAppeared(ContentCaptureSession contentCaptureSession, ViewStructure viewStructure) {
            contentCaptureSession.notifyViewAppeared(viewStructure);
        }

        public static void notifyViewTextChanged(ContentCaptureSession contentCaptureSession, AutofillId autofillId, CharSequence charSequence) {
            contentCaptureSession.notifyViewTextChanged(autofillId, charSequence);
        }

        static void notifyViewsDisappeared(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long[] lArray) {
            contentCaptureSession.notifyViewsDisappeared(autofillId, lArray);
        }
    }

    private static class Api34Impl {
        private Api34Impl() {
        }

        static void notifyViewsAppeared(ContentCaptureSession contentCaptureSession, List<ViewStructure> list) {
            contentCaptureSession.notifyViewsAppeared(list);
        }
    }
}

