/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.RemoteInput
 *  android.app.RemoteInput$Builder
 *  android.content.ClipData
 *  android.content.ClipDescription
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 */
package androidx.core.app;

import android.app.RemoteInput;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class RemoteInput {
    public static final int EDIT_CHOICES_BEFORE_SENDING_AUTO = 0;
    public static final int EDIT_CHOICES_BEFORE_SENDING_DISABLED = 1;
    public static final int EDIT_CHOICES_BEFORE_SENDING_ENABLED = 2;
    private static final String EXTRA_DATA_TYPE_RESULTS_DATA = "android.remoteinput.dataTypeResultsData";
    public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
    private static final String EXTRA_RESULTS_SOURCE = "android.remoteinput.resultsSource";
    public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
    public static final int SOURCE_CHOICE = 1;
    public static final int SOURCE_FREE_FORM_INPUT = 0;
    private final boolean mAllowFreeFormTextInput;
    private final Set<String> mAllowedDataTypes;
    private final CharSequence[] mChoices;
    private final int mEditChoicesBeforeSending;
    private final Bundle mExtras;
    private final CharSequence mLabel;
    private final String mResultKey;

    RemoteInput(String string2, CharSequence charSequence, CharSequence[] charSequenceArray, boolean bl, int n, Bundle bundle, Set<String> set) {
        this.mResultKey = string2;
        this.mLabel = charSequence;
        this.mChoices = charSequenceArray;
        this.mAllowFreeFormTextInput = bl;
        this.mEditChoicesBeforeSending = n;
        this.mExtras = bundle;
        this.mAllowedDataTypes = set;
        if (this.getEditChoicesBeforeSending() == 2 && !this.getAllowFreeFormInput()) {
            throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
        }
    }

    /*
     * WARNING - void declaration
     */
    public static void addDataResultToIntent(RemoteInput remoteInput, Intent intent, Map<String, Uri> object2) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.addDataResultToIntent(remoteInput, intent, (Map<String, Uri>)object2);
        } else {
            Intent intent2;
            Intent intent3 = intent2 = RemoteInput.getClipDataIntentFromIntent(intent);
            if (intent2 == null) {
                intent3 = new Intent();
            }
            for (Map.Entry entry : object2.entrySet()) {
                void var2_7;
                String string2 = (String)entry.getKey();
                Uri uri = (Uri)entry.getValue();
                if (string2 == null) continue;
                Intent intent4 = intent2 = intent3.getBundleExtra(RemoteInput.getExtraResultsKeyForData(string2));
                if (intent2 == null) {
                    Bundle bundle = new Bundle();
                }
                var2_7.putString(remoteInput.getResultKey(), uri.toString());
                intent3.putExtra(RemoteInput.getExtraResultsKeyForData(string2), (Bundle)var2_7);
            }
            intent.setClipData(ClipData.newIntent((CharSequence)RESULTS_CLIP_LABEL, (Intent)intent3));
        }
    }

    public static void addResultsToIntent(RemoteInput[] remoteInputArray, Intent intent, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api20Impl.addResultsToIntent(RemoteInput.fromCompat(remoteInputArray), intent, bundle);
        } else {
            Object object = RemoteInput.getResultsFromIntent(intent);
            int n = RemoteInput.getResultsSource(intent);
            if (object != null) {
                object.putAll(bundle);
                bundle = object;
            }
            for (RemoteInput remoteInput : remoteInputArray) {
                object = RemoteInput.getDataResultsFromIntent(intent, remoteInput.getResultKey());
                Api20Impl.addResultsToIntent(RemoteInput.fromCompat(new RemoteInput[]{remoteInput}), intent, bundle);
                if (object == null) continue;
                RemoteInput.addDataResultToIntent(remoteInput, intent, (Map<String, Uri>)object);
            }
            RemoteInput.setResultsSource(intent, n);
        }
    }

    static android.app.RemoteInput fromCompat(RemoteInput remoteInput) {
        return Api20Impl.fromCompat(remoteInput);
    }

    static android.app.RemoteInput[] fromCompat(RemoteInput[] remoteInputArray) {
        if (remoteInputArray == null) {
            return null;
        }
        android.app.RemoteInput[] remoteInputArray2 = new android.app.RemoteInput[remoteInputArray.length];
        for (int i = 0; i < remoteInputArray.length; ++i) {
            remoteInputArray2[i] = RemoteInput.fromCompat(remoteInputArray[i]);
        }
        return remoteInputArray2;
    }

    static RemoteInput fromPlatform(android.app.RemoteInput remoteInput) {
        return Api20Impl.fromPlatform(remoteInput);
    }

    private static Intent getClipDataIntentFromIntent(Intent intent) {
        if ((intent = intent.getClipData()) == null) {
            return null;
        }
        ClipDescription clipDescription = intent.getDescription();
        if (!clipDescription.hasMimeType("text/vnd.android.intent")) {
            return null;
        }
        if (!((Object)clipDescription.getLabel()).toString().contentEquals(RESULTS_CLIP_LABEL)) {
            return null;
        }
        return intent.getItemAt(0).getIntent();
    }

    public static Map<String, Uri> getDataResultsFromIntent(Intent object, String string2) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getDataResultsFromIntent(object, string2);
        }
        Intent intent = RemoteInput.getClipDataIntentFromIntent(object);
        object = null;
        if (intent == null) {
            return null;
        }
        HashMap<String, Uri> hashMap = new HashMap<String, Uri>();
        for (String string3 : intent.getExtras().keySet()) {
            String string4;
            if (!string3.startsWith(EXTRA_DATA_TYPE_RESULTS_DATA) || (string4 = string3.substring(EXTRA_DATA_TYPE_RESULTS_DATA.length())).isEmpty() || (string3 = intent.getBundleExtra(string3).getString(string2)) == null || string3.isEmpty()) continue;
            hashMap.put(string4, Uri.parse((String)string3));
        }
        if (!hashMap.isEmpty()) {
            object = hashMap;
        }
        return object;
    }

    private static String getExtraResultsKeyForData(String string2) {
        return EXTRA_DATA_TYPE_RESULTS_DATA + string2;
    }

    public static Bundle getResultsFromIntent(Intent intent) {
        return Api20Impl.getResultsFromIntent(intent);
    }

    public static int getResultsSource(Intent intent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getResultsSource(intent);
        }
        if ((intent = RemoteInput.getClipDataIntentFromIntent(intent)) == null) {
            return 0;
        }
        return intent.getExtras().getInt(EXTRA_RESULTS_SOURCE, 0);
    }

    public static void setResultsSource(Intent intent, int n) {
        if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.setResultsSource(intent, n);
        } else {
            Intent intent2;
            Intent intent3 = intent2 = RemoteInput.getClipDataIntentFromIntent(intent);
            if (intent2 == null) {
                intent3 = new Intent();
            }
            intent3.putExtra(EXTRA_RESULTS_SOURCE, n);
            intent.setClipData(ClipData.newIntent((CharSequence)RESULTS_CLIP_LABEL, (Intent)intent3));
        }
    }

    public boolean getAllowFreeFormInput() {
        return this.mAllowFreeFormTextInput;
    }

    public Set<String> getAllowedDataTypes() {
        return this.mAllowedDataTypes;
    }

    public CharSequence[] getChoices() {
        return this.mChoices;
    }

    public int getEditChoicesBeforeSending() {
        return this.mEditChoicesBeforeSending;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public CharSequence getLabel() {
        return this.mLabel;
    }

    public String getResultKey() {
        return this.mResultKey;
    }

    public boolean isDataOnly() {
        boolean bl = !this.getAllowFreeFormInput() && (this.getChoices() == null || this.getChoices().length == 0) && this.getAllowedDataTypes() != null && !this.getAllowedDataTypes().isEmpty();
        return bl;
    }

    static class Api20Impl {
        private Api20Impl() {
        }

        static void addResultsToIntent(Object object, Intent intent, Bundle bundle) {
            android.app.RemoteInput.addResultsToIntent((android.app.RemoteInput[])((android.app.RemoteInput[])object), (Intent)intent, (Bundle)bundle);
        }

        public static android.app.RemoteInput fromCompat(RemoteInput remoteInput) {
            Object object;
            RemoteInput.Builder builder = new RemoteInput.Builder(remoteInput.getResultKey()).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras());
            if (Build.VERSION.SDK_INT >= 26 && (object = remoteInput.getAllowedDataTypes()) != null) {
                object = object.iterator();
                while (object.hasNext()) {
                    Api26Impl.setAllowDataType(builder, (String)object.next(), true);
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                Api29Impl.setEditChoicesBeforeSending(builder, remoteInput.getEditChoicesBeforeSending());
            }
            return builder.build();
        }

        static RemoteInput fromPlatform(Object object) {
            Object object2;
            android.app.RemoteInput remoteInput = (android.app.RemoteInput)object;
            object = new Builder(remoteInput.getResultKey()).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras());
            if (Build.VERSION.SDK_INT >= 26 && (object2 = Api26Impl.getAllowedDataTypes(remoteInput)) != null) {
                object2 = object2.iterator();
                while (object2.hasNext()) {
                    ((Builder)object).setAllowDataType((String)object2.next(), true);
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                ((Builder)object).setEditChoicesBeforeSending(Api29Impl.getEditChoicesBeforeSending(remoteInput));
            }
            return ((Builder)object).build();
        }

        static Bundle getResultsFromIntent(Intent intent) {
            return android.app.RemoteInput.getResultsFromIntent((Intent)intent);
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static void addDataResultToIntent(RemoteInput remoteInput, Intent intent, Map<String, Uri> map2) {
            android.app.RemoteInput.addDataResultToIntent((android.app.RemoteInput)RemoteInput.fromCompat(remoteInput), (Intent)intent, map2);
        }

        static Set<String> getAllowedDataTypes(Object object) {
            return ((android.app.RemoteInput)object).getAllowedDataTypes();
        }

        static Map<String, Uri> getDataResultsFromIntent(Intent intent, String string2) {
            return android.app.RemoteInput.getDataResultsFromIntent((Intent)intent, (String)string2);
        }

        static RemoteInput.Builder setAllowDataType(RemoteInput.Builder builder, String string2, boolean bl) {
            return builder.setAllowDataType(string2, bl);
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static int getResultsSource(Intent intent) {
            return android.app.RemoteInput.getResultsSource((Intent)intent);
        }

        static void setResultsSource(Intent intent, int n) {
            android.app.RemoteInput.setResultsSource((Intent)intent, (int)n);
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static int getEditChoicesBeforeSending(Object object) {
            return ((android.app.RemoteInput)object).getEditChoicesBeforeSending();
        }

        static RemoteInput.Builder setEditChoicesBeforeSending(RemoteInput.Builder builder, int n) {
            return builder.setEditChoicesBeforeSending(n);
        }
    }

    public static final class Builder {
        private boolean mAllowFreeFormTextInput = true;
        private final Set<String> mAllowedDataTypes = new HashSet<String>();
        private CharSequence[] mChoices;
        private int mEditChoicesBeforeSending = 0;
        private final Bundle mExtras = new Bundle();
        private CharSequence mLabel;
        private final String mResultKey;

        public Builder(String string2) {
            if (string2 != null) {
                this.mResultKey = string2;
                return;
            }
            throw new IllegalArgumentException("Result key can't be null");
        }

        public Builder addExtras(Bundle bundle) {
            if (bundle != null) {
                this.mExtras.putAll(bundle);
            }
            return this;
        }

        public RemoteInput build() {
            return new RemoteInput(this.mResultKey, this.mLabel, this.mChoices, this.mAllowFreeFormTextInput, this.mEditChoicesBeforeSending, this.mExtras, this.mAllowedDataTypes);
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public Builder setAllowDataType(String string2, boolean bl) {
            if (bl) {
                this.mAllowedDataTypes.add(string2);
            } else {
                this.mAllowedDataTypes.remove(string2);
            }
            return this;
        }

        public Builder setAllowFreeFormInput(boolean bl) {
            this.mAllowFreeFormTextInput = bl;
            return this;
        }

        public Builder setChoices(CharSequence[] charSequenceArray) {
            this.mChoices = charSequenceArray;
            return this;
        }

        public Builder setEditChoicesBeforeSending(int n) {
            this.mEditChoicesBeforeSending = n;
            return this;
        }

        public Builder setLabel(CharSequence charSequence) {
            this.mLabel = charSequence;
            return this;
        }
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface EditChoicesBeforeSending {
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface Source {
    }
}

