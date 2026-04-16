/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Person
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ShortcutInfo
 *  android.content.pm.ShortcutInfo$Builder
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.os.PersistableBundle
 *  android.os.UserHandle
 *  android.text.TextUtils
 */
package androidx.core.content.pm;

import android.app.Person;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.text.TextUtils;
import androidx.collection.ArraySet;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.net.UriCompat;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShortcutInfoCompat {
    private static final String EXTRA_LOCUS_ID = "extraLocusId";
    private static final String EXTRA_LONG_LIVED = "extraLongLived";
    private static final String EXTRA_PERSON_ = "extraPerson_";
    private static final String EXTRA_PERSON_COUNT = "extraPersonCount";
    private static final String EXTRA_SLICE_URI = "extraSliceUri";
    public static final int SURFACE_LAUNCHER = 1;
    ComponentName mActivity;
    Set<String> mCategories;
    Context mContext;
    CharSequence mDisabledMessage;
    int mDisabledReason;
    int mExcludedSurfaces;
    PersistableBundle mExtras;
    boolean mHasKeyFieldsOnly;
    IconCompat mIcon;
    String mId;
    Intent[] mIntents;
    boolean mIsAlwaysBadged;
    boolean mIsCached;
    boolean mIsDeclaredInManifest;
    boolean mIsDynamic;
    boolean mIsEnabled = true;
    boolean mIsImmutable;
    boolean mIsLongLived;
    boolean mIsPinned;
    CharSequence mLabel;
    long mLastChangedTimestamp;
    LocusIdCompat mLocusId;
    CharSequence mLongLabel;
    String mPackageName;
    androidx.core.app.Person[] mPersons;
    int mRank;
    Bundle mTransientExtras;
    UserHandle mUser;

    ShortcutInfoCompat() {
    }

    private PersistableBundle buildLegacyExtrasBundle() {
        if (this.mExtras == null) {
            this.mExtras = new PersistableBundle();
        }
        if (this.mPersons != null && this.mPersons.length > 0) {
            this.mExtras.putInt(EXTRA_PERSON_COUNT, this.mPersons.length);
            for (int i = 0; i < this.mPersons.length; ++i) {
                this.mExtras.putPersistableBundle(EXTRA_PERSON_ + (i + 1), this.mPersons[i].toPersistableBundle());
            }
        }
        if (this.mLocusId != null) {
            this.mExtras.putString(EXTRA_LOCUS_ID, this.mLocusId.getId());
        }
        this.mExtras.putBoolean(EXTRA_LONG_LIVED, this.mIsLongLived);
        return this.mExtras;
    }

    static List<ShortcutInfoCompat> fromShortcuts(Context context, List<ShortcutInfo> object) {
        ArrayList<ShortcutInfoCompat> arrayList = new ArrayList<ShortcutInfoCompat>(object.size());
        object = object.iterator();
        while (object.hasNext()) {
            arrayList.add(new Builder(context, (ShortcutInfo)object.next()).build());
        }
        return arrayList;
    }

    static LocusIdCompat getLocusId(ShortcutInfo shortcutInfo) {
        if (Build.VERSION.SDK_INT >= 29) {
            if (shortcutInfo.getLocusId() == null) {
                return null;
            }
            return LocusIdCompat.toLocusIdCompat(shortcutInfo.getLocusId());
        }
        return ShortcutInfoCompat.getLocusIdFromExtra(shortcutInfo.getExtras());
    }

    private static LocusIdCompat getLocusIdFromExtra(PersistableBundle object) {
        Object var1_1 = null;
        if (object == null) {
            return null;
        }
        object = (object = object.getString(EXTRA_LOCUS_ID)) == null ? var1_1 : new LocusIdCompat((String)object);
        return object;
    }

    static boolean getLongLivedFromExtra(PersistableBundle persistableBundle) {
        if (persistableBundle != null && persistableBundle.containsKey(EXTRA_LONG_LIVED)) {
            return persistableBundle.getBoolean(EXTRA_LONG_LIVED);
        }
        return false;
    }

    static androidx.core.app.Person[] getPersonsFromExtra(PersistableBundle persistableBundle) {
        if (persistableBundle != null && persistableBundle.containsKey(EXTRA_PERSON_COUNT)) {
            int n = persistableBundle.getInt(EXTRA_PERSON_COUNT);
            androidx.core.app.Person[] personArray = new androidx.core.app.Person[n];
            for (int i = 0; i < n; ++i) {
                personArray[i] = androidx.core.app.Person.fromPersistableBundle(persistableBundle.getPersistableBundle(EXTRA_PERSON_ + (i + 1)));
            }
            return personArray;
        }
        return null;
    }

    Intent addToIntent(Intent intent) {
        intent.putExtra("android.intent.extra.shortcut.INTENT", (Parcelable)this.mIntents[this.mIntents.length - 1]).putExtra("android.intent.extra.shortcut.NAME", ((Object)this.mLabel).toString());
        if (this.mIcon != null) {
            Drawable drawable2 = null;
            Drawable drawable3 = null;
            if (this.mIsAlwaysBadged) {
                PackageManager packageManager = this.mContext.getPackageManager();
                Drawable drawable4 = drawable3;
                if (this.mActivity != null) {
                    try {
                        drawable4 = packageManager.getActivityIcon(this.mActivity);
                    }
                    catch (PackageManager.NameNotFoundException nameNotFoundException) {
                        drawable4 = drawable3;
                    }
                }
                drawable2 = drawable4;
                if (drawable4 == null) {
                    drawable2 = this.mContext.getApplicationInfo().loadIcon(packageManager);
                }
            }
            this.mIcon.addToShortcutIntent(intent, drawable2, this.mContext);
        }
        return intent;
    }

    public ComponentName getActivity() {
        return this.mActivity;
    }

    public Set<String> getCategories() {
        return this.mCategories;
    }

    public CharSequence getDisabledMessage() {
        return this.mDisabledMessage;
    }

    public int getDisabledReason() {
        return this.mDisabledReason;
    }

    public int getExcludedFromSurfaces() {
        return this.mExcludedSurfaces;
    }

    public PersistableBundle getExtras() {
        return this.mExtras;
    }

    public IconCompat getIcon() {
        return this.mIcon;
    }

    public String getId() {
        return this.mId;
    }

    public Intent getIntent() {
        return this.mIntents[this.mIntents.length - 1];
    }

    public Intent[] getIntents() {
        return Arrays.copyOf(this.mIntents, this.mIntents.length);
    }

    public long getLastChangedTimestamp() {
        return this.mLastChangedTimestamp;
    }

    public LocusIdCompat getLocusId() {
        return this.mLocusId;
    }

    public CharSequence getLongLabel() {
        return this.mLongLabel;
    }

    public String getPackage() {
        return this.mPackageName;
    }

    public int getRank() {
        return this.mRank;
    }

    public CharSequence getShortLabel() {
        return this.mLabel;
    }

    public Bundle getTransientExtras() {
        return this.mTransientExtras;
    }

    public UserHandle getUserHandle() {
        return this.mUser;
    }

    public boolean hasKeyFieldsOnly() {
        return this.mHasKeyFieldsOnly;
    }

    public boolean isCached() {
        return this.mIsCached;
    }

    public boolean isDeclaredInManifest() {
        return this.mIsDeclaredInManifest;
    }

    public boolean isDynamic() {
        return this.mIsDynamic;
    }

    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    public boolean isExcludedFromSurfaces(int n) {
        boolean bl = (this.mExcludedSurfaces & n) != 0;
        return bl;
    }

    public boolean isImmutable() {
        return this.mIsImmutable;
    }

    public boolean isPinned() {
        return this.mIsPinned;
    }

    public ShortcutInfo toShortcutInfo() {
        ShortcutInfo.Builder builder = new ShortcutInfo.Builder(this.mContext, this.mId).setShortLabel(this.mLabel).setIntents(this.mIntents);
        if (this.mIcon != null) {
            builder.setIcon(this.mIcon.toIcon(this.mContext));
        }
        if (!TextUtils.isEmpty((CharSequence)this.mLongLabel)) {
            builder.setLongLabel(this.mLongLabel);
        }
        if (!TextUtils.isEmpty((CharSequence)this.mDisabledMessage)) {
            builder.setDisabledMessage(this.mDisabledMessage);
        }
        if (this.mActivity != null) {
            builder.setActivity(this.mActivity);
        }
        if (this.mCategories != null) {
            builder.setCategories(this.mCategories);
        }
        builder.setRank(this.mRank);
        if (this.mExtras != null) {
            builder.setExtras(this.mExtras);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (this.mPersons != null && this.mPersons.length > 0) {
                Person[] personArray = new Person[this.mPersons.length];
                for (int i = 0; i < personArray.length; ++i) {
                    personArray[i] = this.mPersons[i].toAndroidPerson();
                }
                builder.setPersons(personArray);
            }
            if (this.mLocusId != null) {
                builder.setLocusId(this.mLocusId.toLocusId());
            }
            builder.setLongLived(this.mIsLongLived);
        } else {
            builder.setExtras(this.buildLegacyExtrasBundle());
        }
        if (Build.VERSION.SDK_INT >= 33) {
            Api33Impl.setExcludedFromSurfaces(builder, this.mExcludedSurfaces);
        }
        return builder.build();
    }

    private static class Api33Impl {
        private Api33Impl() {
        }

        static void setExcludedFromSurfaces(ShortcutInfo.Builder builder, int n) {
            builder.setExcludedFromSurfaces(n);
        }
    }

    public static class Builder {
        private Map<String, Map<String, List<String>>> mCapabilityBindingParams;
        private Set<String> mCapabilityBindings;
        private final ShortcutInfoCompat mInfo = new ShortcutInfoCompat();
        private boolean mIsConversation;
        private Uri mSliceUri;

        public Builder(Context object, ShortcutInfo shortcutInfo) {
            this.mInfo.mContext = object;
            this.mInfo.mId = shortcutInfo.getId();
            this.mInfo.mPackageName = shortcutInfo.getPackage();
            object = shortcutInfo.getIntents();
            this.mInfo.mIntents = Arrays.copyOf(object, ((Intent[])object).length);
            this.mInfo.mActivity = shortcutInfo.getActivity();
            this.mInfo.mLabel = shortcutInfo.getShortLabel();
            this.mInfo.mLongLabel = shortcutInfo.getLongLabel();
            this.mInfo.mDisabledMessage = shortcutInfo.getDisabledMessage();
            if (Build.VERSION.SDK_INT >= 28) {
                this.mInfo.mDisabledReason = shortcutInfo.getDisabledReason();
            } else {
                object = this.mInfo;
                int n = shortcutInfo.isEnabled() ? 0 : 3;
                object.mDisabledReason = n;
            }
            this.mInfo.mCategories = shortcutInfo.getCategories();
            this.mInfo.mPersons = ShortcutInfoCompat.getPersonsFromExtra(shortcutInfo.getExtras());
            this.mInfo.mUser = shortcutInfo.getUserHandle();
            this.mInfo.mLastChangedTimestamp = shortcutInfo.getLastChangedTimestamp();
            if (Build.VERSION.SDK_INT >= 30) {
                this.mInfo.mIsCached = shortcutInfo.isCached();
            }
            this.mInfo.mIsDynamic = shortcutInfo.isDynamic();
            this.mInfo.mIsPinned = shortcutInfo.isPinned();
            this.mInfo.mIsDeclaredInManifest = shortcutInfo.isDeclaredInManifest();
            this.mInfo.mIsImmutable = shortcutInfo.isImmutable();
            this.mInfo.mIsEnabled = shortcutInfo.isEnabled();
            this.mInfo.mHasKeyFieldsOnly = shortcutInfo.hasKeyFieldsOnly();
            this.mInfo.mLocusId = ShortcutInfoCompat.getLocusId(shortcutInfo);
            this.mInfo.mRank = shortcutInfo.getRank();
            this.mInfo.mExtras = shortcutInfo.getExtras();
        }

        public Builder(Context context, String string2) {
            this.mInfo.mContext = context;
            this.mInfo.mId = string2;
        }

        public Builder(ShortcutInfoCompat shortcutInfoCompat) {
            this.mInfo.mContext = shortcutInfoCompat.mContext;
            this.mInfo.mId = shortcutInfoCompat.mId;
            this.mInfo.mPackageName = shortcutInfoCompat.mPackageName;
            this.mInfo.mIntents = Arrays.copyOf(shortcutInfoCompat.mIntents, shortcutInfoCompat.mIntents.length);
            this.mInfo.mActivity = shortcutInfoCompat.mActivity;
            this.mInfo.mLabel = shortcutInfoCompat.mLabel;
            this.mInfo.mLongLabel = shortcutInfoCompat.mLongLabel;
            this.mInfo.mDisabledMessage = shortcutInfoCompat.mDisabledMessage;
            this.mInfo.mDisabledReason = shortcutInfoCompat.mDisabledReason;
            this.mInfo.mIcon = shortcutInfoCompat.mIcon;
            this.mInfo.mIsAlwaysBadged = shortcutInfoCompat.mIsAlwaysBadged;
            this.mInfo.mUser = shortcutInfoCompat.mUser;
            this.mInfo.mLastChangedTimestamp = shortcutInfoCompat.mLastChangedTimestamp;
            this.mInfo.mIsCached = shortcutInfoCompat.mIsCached;
            this.mInfo.mIsDynamic = shortcutInfoCompat.mIsDynamic;
            this.mInfo.mIsPinned = shortcutInfoCompat.mIsPinned;
            this.mInfo.mIsDeclaredInManifest = shortcutInfoCompat.mIsDeclaredInManifest;
            this.mInfo.mIsImmutable = shortcutInfoCompat.mIsImmutable;
            this.mInfo.mIsEnabled = shortcutInfoCompat.mIsEnabled;
            this.mInfo.mLocusId = shortcutInfoCompat.mLocusId;
            this.mInfo.mIsLongLived = shortcutInfoCompat.mIsLongLived;
            this.mInfo.mHasKeyFieldsOnly = shortcutInfoCompat.mHasKeyFieldsOnly;
            this.mInfo.mRank = shortcutInfoCompat.mRank;
            if (shortcutInfoCompat.mPersons != null) {
                this.mInfo.mPersons = Arrays.copyOf(shortcutInfoCompat.mPersons, shortcutInfoCompat.mPersons.length);
            }
            if (shortcutInfoCompat.mCategories != null) {
                this.mInfo.mCategories = new HashSet<String>(shortcutInfoCompat.mCategories);
            }
            if (shortcutInfoCompat.mExtras != null) {
                this.mInfo.mExtras = shortcutInfoCompat.mExtras;
            }
            this.mInfo.mExcludedSurfaces = shortcutInfoCompat.mExcludedSurfaces;
        }

        public Builder addCapabilityBinding(String string2) {
            if (this.mCapabilityBindings == null) {
                this.mCapabilityBindings = new HashSet<String>();
            }
            this.mCapabilityBindings.add(string2);
            return this;
        }

        public Builder addCapabilityBinding(String string2, String string3, List<String> list) {
            this.addCapabilityBinding(string2);
            if (!list.isEmpty()) {
                if (this.mCapabilityBindingParams == null) {
                    this.mCapabilityBindingParams = new HashMap<String, Map<String, List<String>>>();
                }
                if (this.mCapabilityBindingParams.get(string2) == null) {
                    this.mCapabilityBindingParams.put(string2, new HashMap());
                }
                this.mCapabilityBindingParams.get(string2).put(string3, list);
            }
            return this;
        }

        /*
         * WARNING - void declaration
         */
        public ShortcutInfoCompat build() {
            if (!TextUtils.isEmpty((CharSequence)this.mInfo.mLabel)) {
                if (this.mInfo.mIntents != null && this.mInfo.mIntents.length != 0) {
                    if (this.mIsConversation) {
                        if (this.mInfo.mLocusId == null) {
                            this.mInfo.mLocusId = new LocusIdCompat(this.mInfo.mId);
                        }
                        this.mInfo.mIsLongLived = true;
                    }
                    if (this.mCapabilityBindings != null) {
                        if (this.mInfo.mCategories == null) {
                            this.mInfo.mCategories = new HashSet<String>();
                        }
                        this.mInfo.mCategories.addAll(this.mCapabilityBindings);
                    }
                    if (this.mCapabilityBindingParams != null) {
                        if (this.mInfo.mExtras == null) {
                            this.mInfo.mExtras = new PersistableBundle();
                        }
                        for (String string2 : this.mCapabilityBindingParams.keySet()) {
                            Map<String, List<String>> map2 = this.mCapabilityBindingParams.get(string2);
                            Set<String> set = map2.keySet();
                            this.mInfo.mExtras.putStringArray(string2, set.toArray(new String[0]));
                            for (String string3 : map2.keySet()) {
                                void var1_7;
                                List<String> list = map2.get(string3);
                                PersistableBundle persistableBundle = this.mInfo.mExtras;
                                String string4 = string2 + "/" + string3;
                                String[] stringArray = new String[]{};
                                if (list != null) {
                                    String[] stringArray2 = list.toArray(stringArray);
                                }
                                persistableBundle.putStringArray(string4, (String[])var1_7);
                            }
                        }
                    }
                    if (this.mSliceUri != null) {
                        if (this.mInfo.mExtras == null) {
                            this.mInfo.mExtras = new PersistableBundle();
                        }
                        this.mInfo.mExtras.putString(ShortcutInfoCompat.EXTRA_SLICE_URI, UriCompat.toSafeString(this.mSliceUri));
                    }
                    return this.mInfo;
                }
                throw new IllegalArgumentException("Shortcut must have an intent");
            }
            throw new IllegalArgumentException("Shortcut must have a non-empty label");
        }

        public Builder setActivity(ComponentName componentName) {
            this.mInfo.mActivity = componentName;
            return this;
        }

        public Builder setAlwaysBadged() {
            this.mInfo.mIsAlwaysBadged = true;
            return this;
        }

        public Builder setCategories(Set<String> set) {
            ArraySet<String> arraySet = new ArraySet<String>();
            arraySet.addAll(set);
            this.mInfo.mCategories = arraySet;
            return this;
        }

        public Builder setDisabledMessage(CharSequence charSequence) {
            this.mInfo.mDisabledMessage = charSequence;
            return this;
        }

        public Builder setExcludedFromSurfaces(int n) {
            this.mInfo.mExcludedSurfaces = n;
            return this;
        }

        public Builder setExtras(PersistableBundle persistableBundle) {
            this.mInfo.mExtras = persistableBundle;
            return this;
        }

        public Builder setIcon(IconCompat iconCompat) {
            this.mInfo.mIcon = iconCompat;
            return this;
        }

        public Builder setIntent(Intent intent) {
            return this.setIntents(new Intent[]{intent});
        }

        public Builder setIntents(Intent[] intentArray) {
            this.mInfo.mIntents = intentArray;
            return this;
        }

        public Builder setIsConversation() {
            this.mIsConversation = true;
            return this;
        }

        public Builder setLocusId(LocusIdCompat locusIdCompat) {
            this.mInfo.mLocusId = locusIdCompat;
            return this;
        }

        public Builder setLongLabel(CharSequence charSequence) {
            this.mInfo.mLongLabel = charSequence;
            return this;
        }

        @Deprecated
        public Builder setLongLived() {
            this.mInfo.mIsLongLived = true;
            return this;
        }

        public Builder setLongLived(boolean bl) {
            this.mInfo.mIsLongLived = bl;
            return this;
        }

        public Builder setPerson(androidx.core.app.Person person) {
            return this.setPersons(new androidx.core.app.Person[]{person});
        }

        public Builder setPersons(androidx.core.app.Person[] personArray) {
            this.mInfo.mPersons = personArray;
            return this;
        }

        public Builder setRank(int n) {
            this.mInfo.mRank = n;
            return this;
        }

        public Builder setShortLabel(CharSequence charSequence) {
            this.mInfo.mLabel = charSequence;
            return this;
        }

        public Builder setSliceUri(Uri uri) {
            this.mSliceUri = uri;
            return this;
        }

        public Builder setTransientExtras(Bundle bundle) {
            this.mInfo.mTransientExtras = Preconditions.checkNotNull(bundle);
            return this;
        }
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface Surface {
    }
}

