/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ClipData
 *  android.content.ClipData$Item
 *  android.content.ComponentName
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 */
package androidx.core.content;

import android.content.ClipData;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.content.IntentSanitizer$$ExternalSyntheticLambda0;
import androidx.core.content.IntentSanitizer$$ExternalSyntheticLambda1;
import androidx.core.content.IntentSanitizer$Builder$$ExternalSyntheticLambda0;
import androidx.core.content.IntentSanitizer$Builder$$ExternalSyntheticLambda1;
import androidx.core.content.IntentSanitizer$Builder$$ExternalSyntheticLambda10;
import androidx.core.content.IntentSanitizer$Builder$$ExternalSyntheticLambda11;
import androidx.core.content.IntentSanitizer$Builder$$ExternalSyntheticLambda12;
import androidx.core.content.IntentSanitizer$Builder$$ExternalSyntheticLambda13;
import androidx.core.content.IntentSanitizer$Builder$$ExternalSyntheticLambda14;
import androidx.core.content.IntentSanitizer$Builder$$ExternalSyntheticLambda15;
import androidx.core.content.IntentSanitizer$Builder$$ExternalSyntheticLambda16;
import androidx.core.content.IntentSanitizer$Builder$$ExternalSyntheticLambda17;
import androidx.core.content.IntentSanitizer$Builder$$ExternalSyntheticLambda18;
import androidx.core.content.IntentSanitizer$Builder$$ExternalSyntheticLambda2;
import androidx.core.content.IntentSanitizer$Builder$$ExternalSyntheticLambda3;
import androidx.core.content.IntentSanitizer$Builder$$ExternalSyntheticLambda4;
import androidx.core.content.IntentSanitizer$Builder$$ExternalSyntheticLambda5;
import androidx.core.content.IntentSanitizer$Builder$$ExternalSyntheticLambda6;
import androidx.core.content.IntentSanitizer$Builder$$ExternalSyntheticLambda7;
import androidx.core.content.IntentSanitizer$Builder$$ExternalSyntheticLambda8;
import androidx.core.content.IntentSanitizer$Builder$$ExternalSyntheticLambda9;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import androidx.core.util.Predicate;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class IntentSanitizer {
    private static final String TAG = "IntentSanitizer";
    private boolean mAllowAnyComponent;
    private boolean mAllowClipDataText;
    private boolean mAllowIdentifier;
    private boolean mAllowSelector;
    private boolean mAllowSourceBounds;
    private Predicate<String> mAllowedActions;
    private Predicate<String> mAllowedCategories;
    private Predicate<ClipData> mAllowedClipData;
    private Predicate<Uri> mAllowedClipDataUri;
    private Predicate<ComponentName> mAllowedComponents;
    private Predicate<Uri> mAllowedData;
    private Map<String, Predicate<Object>> mAllowedExtras;
    private int mAllowedFlags;
    private Predicate<String> mAllowedPackages;
    private Predicate<String> mAllowedTypes;

    private IntentSanitizer() {
    }

    static /* synthetic */ boolean access$1002(IntentSanitizer intentSanitizer, boolean bl) {
        intentSanitizer.mAllowClipDataText = bl;
        return bl;
    }

    static /* synthetic */ int access$102(IntentSanitizer intentSanitizer, int n) {
        intentSanitizer.mAllowedFlags = n;
        return n;
    }

    static /* synthetic */ Predicate access$1102(IntentSanitizer intentSanitizer, Predicate predicate) {
        intentSanitizer.mAllowedClipDataUri = predicate;
        return predicate;
    }

    static /* synthetic */ Predicate access$1202(IntentSanitizer intentSanitizer, Predicate predicate) {
        intentSanitizer.mAllowedClipData = predicate;
        return predicate;
    }

    static /* synthetic */ boolean access$1302(IntentSanitizer intentSanitizer, boolean bl) {
        intentSanitizer.mAllowIdentifier = bl;
        return bl;
    }

    static /* synthetic */ boolean access$1402(IntentSanitizer intentSanitizer, boolean bl) {
        intentSanitizer.mAllowSelector = bl;
        return bl;
    }

    static /* synthetic */ boolean access$1502(IntentSanitizer intentSanitizer, boolean bl) {
        intentSanitizer.mAllowSourceBounds = bl;
        return bl;
    }

    static /* synthetic */ Predicate access$202(IntentSanitizer intentSanitizer, Predicate predicate) {
        intentSanitizer.mAllowedActions = predicate;
        return predicate;
    }

    static /* synthetic */ Predicate access$302(IntentSanitizer intentSanitizer, Predicate predicate) {
        intentSanitizer.mAllowedData = predicate;
        return predicate;
    }

    static /* synthetic */ Predicate access$402(IntentSanitizer intentSanitizer, Predicate predicate) {
        intentSanitizer.mAllowedTypes = predicate;
        return predicate;
    }

    static /* synthetic */ Predicate access$502(IntentSanitizer intentSanitizer, Predicate predicate) {
        intentSanitizer.mAllowedCategories = predicate;
        return predicate;
    }

    static /* synthetic */ Predicate access$602(IntentSanitizer intentSanitizer, Predicate predicate) {
        intentSanitizer.mAllowedPackages = predicate;
        return predicate;
    }

    static /* synthetic */ boolean access$702(IntentSanitizer intentSanitizer, boolean bl) {
        intentSanitizer.mAllowAnyComponent = bl;
        return bl;
    }

    static /* synthetic */ Predicate access$802(IntentSanitizer intentSanitizer, Predicate predicate) {
        intentSanitizer.mAllowedComponents = predicate;
        return predicate;
    }

    static /* synthetic */ Map access$902(IntentSanitizer intentSanitizer, Map map2) {
        intentSanitizer.mAllowedExtras = map2;
        return map2;
    }

    private static void checkOtherMembers(int n, ClipData.Item item, Consumer<String> consumer) {
        if (item.getHtmlText() != null || item.getIntent() != null) {
            consumer.accept("ClipData item at position " + n + " contains htmlText, textLinks or intent: " + item);
        }
    }

    static /* synthetic */ void lambda$sanitizeByFiltering$0(String string2) {
    }

    static /* synthetic */ void lambda$sanitizeByThrowing$1(String string2) {
        throw new SecurityException(string2);
    }

    private void putExtra(Intent intent, String string2, Object object) {
        block6: {
            block3: {
                block5: {
                    block4: {
                        block2: {
                            if (object != null) break block2;
                            intent.getExtras().putString(string2, null);
                            break block3;
                        }
                        if (!(object instanceof Parcelable)) break block4;
                        intent.putExtra(string2, (Parcelable)object);
                        break block3;
                    }
                    if (!(object instanceof Parcelable[])) break block5;
                    intent.putExtra(string2, (Parcelable[])object);
                    break block3;
                }
                if (!(object instanceof Serializable)) break block6;
                intent.putExtra(string2, (Serializable)object);
            }
            return;
        }
        throw new IllegalArgumentException("Unsupported type " + object.getClass());
    }

    static void sanitizeClipData(Intent intent, Intent intent2, Predicate<ClipData> object, boolean bl, Predicate<Uri> predicate, Consumer<String> consumer) {
        block20: {
            ClipData clipData;
            block19: {
                clipData = intent.getClipData();
                if (clipData == null) {
                    return;
                }
                intent = null;
                if (object == null || !object.test((ClipData)clipData)) break block19;
                intent2.setClipData(clipData);
                break block20;
            }
            for (int i = 0; i < clipData.getItemCount(); ++i) {
                Uri uri;
                block22: {
                    Uri uri2;
                    block21: {
                        ClipData.Item item = clipData.getItemAt(i);
                        if (Build.VERSION.SDK_INT >= 31) {
                            Api31Impl.checkOtherMembers(i, item, consumer);
                        } else {
                            IntentSanitizer.checkOtherMembers(i, item, consumer);
                        }
                        uri2 = null;
                        if (bl) {
                            object = item.getText();
                        } else {
                            object = uri2;
                            if (item.getText() != null) {
                                consumer.accept("Item text cannot contain value. Item position: " + i + ". Text: " + item.getText());
                                object = uri2;
                            }
                        }
                        uri = null;
                        if (predicate == null) {
                            uri2 = uri;
                            if (item.getUri() != null) {
                                consumer.accept("Item URI is not allowed. Item position: " + i + ". URI: " + item.getUri());
                                uri2 = uri;
                            }
                        } else if (item.getUri() != null && !predicate.test(item.getUri())) {
                            consumer.accept("Item URI is not allowed. Item position: " + i + ". URI: " + item.getUri());
                            uri2 = uri;
                        } else {
                            uri2 = item.getUri();
                        }
                        if (object != null) break block21;
                        uri = intent;
                        if (uri2 == null) break block22;
                    }
                    if (intent == null) {
                        uri = new ClipData(clipData.getDescription(), new ClipData.Item((CharSequence)object, null, uri2));
                    } else {
                        intent.addItem(new ClipData.Item((CharSequence)object, null, uri2));
                        uri = intent;
                    }
                }
                intent = uri;
            }
            if (intent != null) {
                intent2.setClipData((ClipData)intent);
            }
        }
    }

    public Intent sanitize(Intent intent, Consumer<String> consumer) {
        Bundle bundle;
        Intent intent2 = new Intent();
        Object object = intent.getComponent();
        if (this.mAllowAnyComponent && object == null || this.mAllowedComponents.test((ComponentName)object)) {
            intent2.setComponent((ComponentName)object);
        } else {
            consumer.accept("Component is not allowed: " + object);
            intent2.setComponent(new ComponentName("android", "java.lang.Void"));
        }
        object = intent.getPackage();
        if (object != null && !this.mAllowedPackages.test((String)object)) {
            consumer.accept("Package is not allowed: " + (String)object);
        } else {
            intent2.setPackage((String)object);
        }
        if ((this.mAllowedFlags | intent.getFlags()) == this.mAllowedFlags) {
            intent2.setFlags(intent.getFlags());
        } else {
            intent2.setFlags(this.mAllowedFlags & intent.getFlags());
            consumer.accept("The intent contains flags that are not allowed: 0x" + Integer.toHexString(intent.getFlags() & ~this.mAllowedFlags));
        }
        object = intent.getAction();
        if (object != null && !this.mAllowedActions.test((String)object)) {
            consumer.accept("Action is not allowed: " + (String)object);
        } else {
            intent2.setAction((String)object);
        }
        object = intent.getData();
        if (object != null && !this.mAllowedData.test((Uri)object)) {
            consumer.accept("Data is not allowed: " + object);
        } else {
            intent2.setData((Uri)object);
        }
        object = intent.getType();
        if (object != null && !this.mAllowedTypes.test((String)object)) {
            consumer.accept("Type is not allowed: " + (String)object);
        } else {
            intent2.setDataAndType(intent2.getData(), (String)object);
        }
        object = intent.getCategories();
        if (object != null) {
            Iterator iterator2 = object.iterator();
            while (iterator2.hasNext()) {
                object = (String)iterator2.next();
                if (this.mAllowedCategories.test((String)object)) {
                    intent2.addCategory((String)object);
                    continue;
                }
                consumer.accept("Category is not allowed: " + (String)object);
            }
        }
        if ((bundle = intent.getExtras()) != null) {
            for (String string2 : bundle.keySet()) {
                if (string2.equals("android.intent.extra.STREAM") && (this.mAllowedFlags & 1) == 0) {
                    consumer.accept("Allowing Extra Stream requires also allowing at least  FLAG_GRANT_READ_URI_PERMISSION Flag.");
                    continue;
                }
                if (string2.equals("output") && (~this.mAllowedFlags & 3) != 0) {
                    consumer.accept("Allowing Extra Output requires also allowing FLAG_GRANT_READ_URI_PERMISSION and FLAG_GRANT_WRITE_URI_PERMISSION Flags.");
                    continue;
                }
                object = bundle.get(string2);
                Predicate<Object> predicate = this.mAllowedExtras.get(string2);
                if (predicate != null && predicate.test(object)) {
                    this.putExtra(intent2, string2, object);
                    continue;
                }
                consumer.accept("Extra is not allowed. Key: " + string2 + ". Value: " + object);
            }
        }
        IntentSanitizer.sanitizeClipData(intent, intent2, this.mAllowedClipData, this.mAllowClipDataText, this.mAllowedClipDataUri, consumer);
        if (Build.VERSION.SDK_INT >= 29) {
            if (this.mAllowIdentifier) {
                Api29Impl.setIdentifier(intent2, Api29Impl.getIdentifier(intent));
            } else if (Api29Impl.getIdentifier(intent) != null) {
                consumer.accept("Identifier is not allowed: " + Api29Impl.getIdentifier(intent));
            }
        }
        if (this.mAllowSelector) {
            intent2.setSelector(intent.getSelector());
        } else if (intent.getSelector() != null) {
            consumer.accept("Selector is not allowed: " + intent.getSelector());
        }
        if (this.mAllowSourceBounds) {
            intent2.setSourceBounds(intent.getSourceBounds());
        } else if (intent.getSourceBounds() != null) {
            consumer.accept("SourceBounds is not allowed: " + intent.getSourceBounds());
        }
        return intent2;
    }

    public Intent sanitizeByFiltering(Intent intent) {
        return this.sanitize(intent, new IntentSanitizer$$ExternalSyntheticLambda0());
    }

    public Intent sanitizeByThrowing(Intent intent) {
        return this.sanitize(intent, new IntentSanitizer$$ExternalSyntheticLambda1());
    }

    private static class Api29Impl {
        private Api29Impl() {
        }

        static String getIdentifier(Intent intent) {
            return intent.getIdentifier();
        }

        static Intent setIdentifier(Intent intent, String string2) {
            return intent.setIdentifier(string2);
        }
    }

    private static class Api31Impl {
        private Api31Impl() {
        }

        static void checkOtherMembers(int n, ClipData.Item item, Consumer<String> consumer) {
            if (item.getHtmlText() != null || item.getIntent() != null || item.getTextLinks() != null) {
                consumer.accept("ClipData item at position " + n + " contains htmlText, textLinks or intent: " + item);
            }
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    public static final class Builder {
        private static final int HISTORY_STACK_FLAGS = 2112614400;
        private static final int RECEIVER_FLAGS = 2015363072;
        private boolean mAllowAnyComponent;
        private boolean mAllowClipDataText = false;
        private boolean mAllowIdentifier;
        private boolean mAllowSelector;
        private boolean mAllowSomeComponents;
        private boolean mAllowSourceBounds;
        private Predicate<String> mAllowedActions = new IntentSanitizer$Builder$$ExternalSyntheticLambda11();
        private Predicate<String> mAllowedCategories;
        private Predicate<ClipData> mAllowedClipData;
        private Predicate<Uri> mAllowedClipDataUri;
        private Predicate<ComponentName> mAllowedComponents;
        private Predicate<Uri> mAllowedData = new IntentSanitizer$Builder$$ExternalSyntheticLambda12();
        private Map<String, Predicate<Object>> mAllowedExtras;
        private int mAllowedFlags;
        private Predicate<String> mAllowedPackages;
        private Predicate<String> mAllowedTypes = new IntentSanitizer$Builder$$ExternalSyntheticLambda13();

        public static /* synthetic */ boolean $r8$lambda$f9aU52V4hLVPTW2v-TcMiSk5YDc(ComponentName componentName, Object object) {
            return componentName.equals(object);
        }

        public static /* synthetic */ boolean $r8$lambda$yzjFOqRUGseo4jtNtyZsqFTIwRc(String string2, Object object) {
            return string2.equals(object);
        }

        public Builder() {
            this.mAllowedCategories = new IntentSanitizer$Builder$$ExternalSyntheticLambda14();
            this.mAllowedPackages = new IntentSanitizer$Builder$$ExternalSyntheticLambda15();
            this.mAllowedComponents = new IntentSanitizer$Builder$$ExternalSyntheticLambda16();
            this.mAllowedExtras = new HashMap<String, Predicate<Object>>();
            this.mAllowedClipDataUri = new IntentSanitizer$Builder$$ExternalSyntheticLambda17();
            this.mAllowedClipData = new IntentSanitizer$Builder$$ExternalSyntheticLambda18();
        }

        static /* synthetic */ boolean lambda$allowAnyComponent$10(ComponentName componentName) {
            return true;
        }

        static /* synthetic */ boolean lambda$allowClipDataUriWithAuthority$11(String string2, Uri uri) {
            return string2.equals(uri.getAuthority());
        }

        static /* synthetic */ boolean lambda$allowComponentWithPackage$9(String string2, ComponentName componentName) {
            return string2.equals(componentName.getPackageName());
        }

        static /* synthetic */ boolean lambda$allowDataWithAuthority$8(String string2, Uri uri) {
            return string2.equals(uri.getAuthority());
        }

        static /* synthetic */ boolean lambda$allowExtra$12(Object object) {
            return true;
        }

        static /* synthetic */ boolean lambda$allowExtra$13(Class clazz, Predicate predicate, Object object) {
            boolean bl = clazz.isInstance(object) && predicate.test(clazz.cast(object));
            return bl;
        }

        static /* synthetic */ boolean lambda$allowExtra$14(Object object) {
            return false;
        }

        static /* synthetic */ boolean lambda$allowExtraOutput$16(String string2, Uri uri) {
            return string2.equals(uri.getAuthority());
        }

        static /* synthetic */ boolean lambda$allowExtraStreamUriWithAuthority$15(String string2, Uri uri) {
            return string2.equals(uri.getAuthority());
        }

        static /* synthetic */ boolean lambda$new$0(String string2) {
            return false;
        }

        static /* synthetic */ boolean lambda$new$1(Uri uri) {
            return false;
        }

        static /* synthetic */ boolean lambda$new$2(String string2) {
            return false;
        }

        static /* synthetic */ boolean lambda$new$3(String string2) {
            return false;
        }

        static /* synthetic */ boolean lambda$new$4(String string2) {
            return false;
        }

        static /* synthetic */ boolean lambda$new$5(ComponentName componentName) {
            return false;
        }

        static /* synthetic */ boolean lambda$new$6(Uri uri) {
            return false;
        }

        static /* synthetic */ boolean lambda$new$7(ClipData clipData) {
            return false;
        }

        public Builder allowAction(Predicate<String> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowedActions = this.mAllowedActions.or(predicate);
            return this;
        }

        public Builder allowAction(String string2) {
            Preconditions.checkNotNull(string2);
            Objects.requireNonNull(string2);
            this.allowAction(new IntentSanitizer$Builder$$ExternalSyntheticLambda2(string2));
            return this;
        }

        public Builder allowAnyComponent() {
            this.mAllowAnyComponent = true;
            this.mAllowedComponents = new IntentSanitizer$Builder$$ExternalSyntheticLambda4();
            return this;
        }

        public Builder allowCategory(Predicate<String> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowedCategories = this.mAllowedCategories.or(predicate);
            return this;
        }

        public Builder allowCategory(String string2) {
            Preconditions.checkNotNull(string2);
            Objects.requireNonNull(string2);
            return this.allowCategory(new IntentSanitizer$Builder$$ExternalSyntheticLambda2(string2));
        }

        public Builder allowClipData(Predicate<ClipData> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowedClipData = this.mAllowedClipData.or(predicate);
            return this;
        }

        public Builder allowClipDataText() {
            this.mAllowClipDataText = true;
            return this;
        }

        public Builder allowClipDataUri(Predicate<Uri> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowedClipDataUri = this.mAllowedClipDataUri.or(predicate);
            return this;
        }

        public Builder allowClipDataUriWithAuthority(String string2) {
            Preconditions.checkNotNull(string2);
            return this.allowClipDataUri(new IntentSanitizer$Builder$$ExternalSyntheticLambda1(string2));
        }

        public Builder allowComponent(ComponentName componentName) {
            Preconditions.checkNotNull(componentName);
            Objects.requireNonNull(componentName);
            return this.allowComponent(new IntentSanitizer$Builder$$ExternalSyntheticLambda9(componentName));
        }

        public Builder allowComponent(Predicate<ComponentName> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowSomeComponents = true;
            this.mAllowedComponents = this.mAllowedComponents.or(predicate);
            return this;
        }

        public Builder allowComponentWithPackage(String string2) {
            Preconditions.checkNotNull(string2);
            return this.allowComponent(new IntentSanitizer$Builder$$ExternalSyntheticLambda6(string2));
        }

        public Builder allowData(Predicate<Uri> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowedData = this.mAllowedData.or(predicate);
            return this;
        }

        public Builder allowDataWithAuthority(String string2) {
            Preconditions.checkNotNull(string2);
            this.allowData(new IntentSanitizer$Builder$$ExternalSyntheticLambda7(string2));
            return this;
        }

        public Builder allowExtra(String string2, Predicate<Object> predicate) {
            IntentSanitizer$Builder$$ExternalSyntheticLambda0 intentSanitizer$Builder$$ExternalSyntheticLambda0;
            Preconditions.checkNotNull(string2);
            Preconditions.checkNotNull(predicate);
            IntentSanitizer$Builder$$ExternalSyntheticLambda0 intentSanitizer$Builder$$ExternalSyntheticLambda02 = intentSanitizer$Builder$$ExternalSyntheticLambda0 = this.mAllowedExtras.get(string2);
            if (intentSanitizer$Builder$$ExternalSyntheticLambda0 == null) {
                intentSanitizer$Builder$$ExternalSyntheticLambda02 = new IntentSanitizer$Builder$$ExternalSyntheticLambda0();
            }
            predicate = intentSanitizer$Builder$$ExternalSyntheticLambda02.or(predicate);
            this.mAllowedExtras.put(string2, predicate);
            return this;
        }

        public Builder allowExtra(String string2, Class<?> clazz) {
            return this.allowExtra(string2, clazz, new IntentSanitizer$Builder$$ExternalSyntheticLambda10());
        }

        public <T> Builder allowExtra(String string2, Class<T> clazz, Predicate<T> predicate) {
            Preconditions.checkNotNull(string2);
            Preconditions.checkNotNull(clazz);
            Preconditions.checkNotNull(predicate);
            return this.allowExtra(string2, new IntentSanitizer$Builder$$ExternalSyntheticLambda5(clazz, predicate));
        }

        public Builder allowExtraOutput(Predicate<Uri> predicate) {
            this.allowExtra("output", Uri.class, predicate);
            return this;
        }

        public Builder allowExtraOutput(String string2) {
            this.allowExtra("output", Uri.class, new IntentSanitizer$Builder$$ExternalSyntheticLambda8(string2));
            return this;
        }

        public Builder allowExtraStream(Predicate<Uri> predicate) {
            this.allowExtra("android.intent.extra.STREAM", Uri.class, predicate);
            return this;
        }

        public Builder allowExtraStreamUriWithAuthority(String string2) {
            Preconditions.checkNotNull(string2);
            this.allowExtra("android.intent.extra.STREAM", Uri.class, new IntentSanitizer$Builder$$ExternalSyntheticLambda3(string2));
            return this;
        }

        public Builder allowFlags(int n) {
            this.mAllowedFlags |= n;
            return this;
        }

        public Builder allowHistoryStackFlags() {
            this.mAllowedFlags |= 0x7DEBF000;
            return this;
        }

        public Builder allowIdentifier() {
            this.mAllowIdentifier = true;
            return this;
        }

        public Builder allowPackage(Predicate<String> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowedPackages = this.mAllowedPackages.or(predicate);
            return this;
        }

        public Builder allowPackage(String string2) {
            Preconditions.checkNotNull(string2);
            Objects.requireNonNull(string2);
            return this.allowPackage(new IntentSanitizer$Builder$$ExternalSyntheticLambda2(string2));
        }

        public Builder allowReceiverFlags() {
            this.mAllowedFlags |= 0x78200000;
            return this;
        }

        public Builder allowSelector() {
            this.mAllowSelector = true;
            return this;
        }

        public Builder allowSourceBounds() {
            this.mAllowSourceBounds = true;
            return this;
        }

        public Builder allowType(Predicate<String> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowedTypes = this.mAllowedTypes.or(predicate);
            return this;
        }

        public Builder allowType(String string2) {
            Preconditions.checkNotNull(string2);
            Objects.requireNonNull(string2);
            return this.allowType(new IntentSanitizer$Builder$$ExternalSyntheticLambda2(string2));
        }

        public IntentSanitizer build() {
            if (this.mAllowAnyComponent && this.mAllowSomeComponents || !this.mAllowAnyComponent && !this.mAllowSomeComponents) {
                throw new SecurityException("You must call either allowAnyComponent or one or more of the allowComponent methods; but not both.");
            }
            IntentSanitizer intentSanitizer = new IntentSanitizer();
            IntentSanitizer.access$102(intentSanitizer, this.mAllowedFlags);
            IntentSanitizer.access$202(intentSanitizer, this.mAllowedActions);
            IntentSanitizer.access$302(intentSanitizer, this.mAllowedData);
            IntentSanitizer.access$402(intentSanitizer, this.mAllowedTypes);
            IntentSanitizer.access$502(intentSanitizer, this.mAllowedCategories);
            IntentSanitizer.access$602(intentSanitizer, this.mAllowedPackages);
            IntentSanitizer.access$702(intentSanitizer, this.mAllowAnyComponent);
            IntentSanitizer.access$802(intentSanitizer, this.mAllowedComponents);
            IntentSanitizer.access$902(intentSanitizer, this.mAllowedExtras);
            IntentSanitizer.access$1002(intentSanitizer, this.mAllowClipDataText);
            IntentSanitizer.access$1102(intentSanitizer, this.mAllowedClipDataUri);
            IntentSanitizer.access$1202(intentSanitizer, this.mAllowedClipData);
            IntentSanitizer.access$1302(intentSanitizer, this.mAllowIdentifier);
            IntentSanitizer.access$1402(intentSanitizer, this.mAllowSelector);
            IntentSanitizer.access$1502(intentSanitizer, this.mAllowSourceBounds);
            return intentSanitizer;
        }
    }
}

