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
 *  android.util.Pair
 *  android.view.ContentInfo
 *  android.view.ContentInfo$Builder
 */
package androidx.core.view;

import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.ContentInfo;
import androidx.core.util.Preconditions;
import androidx.core.view.ContentInfoCompat$Api31Impl$$ExternalSyntheticLambda0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public final class ContentInfoCompat {
    public static final int FLAG_CONVERT_TO_PLAIN_TEXT = 1;
    public static final int SOURCE_APP = 0;
    public static final int SOURCE_AUTOFILL = 4;
    public static final int SOURCE_CLIPBOARD = 1;
    public static final int SOURCE_DRAG_AND_DROP = 3;
    public static final int SOURCE_INPUT_METHOD = 2;
    public static final int SOURCE_PROCESS_TEXT = 5;
    private final Compat mCompat;

    ContentInfoCompat(Compat compat) {
        this.mCompat = compat;
    }

    static ClipData buildClipData(ClipDescription clipDescription, List<ClipData.Item> list) {
        clipDescription = new ClipData(new ClipDescription(clipDescription), list.get(0));
        for (int i = 1; i < list.size(); ++i) {
            clipDescription.addItem(list.get(i));
        }
        return clipDescription;
    }

    static String flagsToString(int n) {
        if ((n & 1) != 0) {
            return "FLAG_CONVERT_TO_PLAIN_TEXT";
        }
        return String.valueOf(n);
    }

    static Pair<ClipData, ClipData> partition(ClipData clipData, androidx.core.util.Predicate<ClipData.Item> predicate) {
        ArrayList<ClipData.Item> arrayList = null;
        ArrayList<ClipData.Item> arrayList2 = null;
        for (int i = 0; i < clipData.getItemCount(); ++i) {
            ClipData.Item item = clipData.getItemAt(i);
            if (predicate.test(item)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<ClipData.Item>();
                }
                arrayList.add(item);
                continue;
            }
            if (arrayList2 == null) {
                arrayList2 = new ArrayList<ClipData.Item>();
            }
            arrayList2.add(item);
        }
        if (arrayList == null) {
            return Pair.create(null, (Object)clipData);
        }
        if (arrayList2 == null) {
            return Pair.create((Object)clipData, null);
        }
        return Pair.create((Object)ContentInfoCompat.buildClipData(clipData.getDescription(), arrayList), (Object)ContentInfoCompat.buildClipData(clipData.getDescription(), arrayList2));
    }

    public static Pair<ContentInfo, ContentInfo> partition(ContentInfo contentInfo, Predicate<ClipData.Item> predicate) {
        return Api31Impl.partition(contentInfo, predicate);
    }

    static String sourceToString(int n) {
        switch (n) {
            default: {
                return String.valueOf(n);
            }
            case 5: {
                return "SOURCE_PROCESS_TEXT";
            }
            case 4: {
                return "SOURCE_AUTOFILL";
            }
            case 3: {
                return "SOURCE_DRAG_AND_DROP";
            }
            case 2: {
                return "SOURCE_INPUT_METHOD";
            }
            case 1: {
                return "SOURCE_CLIPBOARD";
            }
            case 0: 
        }
        return "SOURCE_APP";
    }

    public static ContentInfoCompat toContentInfoCompat(ContentInfo contentInfo) {
        return new ContentInfoCompat(new Compat31Impl(contentInfo));
    }

    public ClipData getClip() {
        return this.mCompat.getClip();
    }

    public Bundle getExtras() {
        return this.mCompat.getExtras();
    }

    public int getFlags() {
        return this.mCompat.getFlags();
    }

    public Uri getLinkUri() {
        return this.mCompat.getLinkUri();
    }

    public int getSource() {
        return this.mCompat.getSource();
    }

    public Pair<ContentInfoCompat, ContentInfoCompat> partition(androidx.core.util.Predicate<ClipData.Item> object) {
        ClipData clipData = this.mCompat.getClip();
        int n = clipData.getItemCount();
        ContentInfoCompat contentInfoCompat = null;
        if (n == 1) {
            boolean bl = object.test((ClipData.Item)clipData.getItemAt(0));
            object = bl ? this : null;
            if (!bl) {
                contentInfoCompat = this;
            }
            return Pair.create((Object)object, (Object)contentInfoCompat);
        }
        object = ContentInfoCompat.partition(clipData, object);
        if (((Pair)object).first == null) {
            return Pair.create(null, (Object)this);
        }
        if (((Pair)object).second == null) {
            return Pair.create((Object)this, null);
        }
        return Pair.create((Object)new Builder(this).setClip((ClipData)((Pair)object).first).build(), (Object)new Builder(this).setClip((ClipData)((Pair)object).second).build());
    }

    public ContentInfo toContentInfo() {
        return Objects.requireNonNull(this.mCompat.getWrapped());
    }

    public String toString() {
        return this.mCompat.toString();
    }

    private static final class Api31Impl {
        private Api31Impl() {
        }

        public static Pair<ContentInfo, ContentInfo> partition(ContentInfo pair, Predicate<ClipData.Item> object) {
            ClipData clipData = pair.getClip();
            int n = clipData.getItemCount();
            Object var4_4 = null;
            if (n == 1) {
                boolean bl = object.test((ClipData.Item)clipData.getItemAt(0));
                object = bl ? pair : null;
                if (bl) {
                    pair = var4_4;
                }
                return Pair.create(object, pair);
            }
            Objects.requireNonNull(object);
            object = ContentInfoCompat.partition(clipData, new ContentInfoCompat$Api31Impl$$ExternalSyntheticLambda0((Predicate)object));
            if (object.first == null) {
                return Pair.create(null, pair);
            }
            if (object.second == null) {
                return Pair.create(pair, null);
            }
            return Pair.create((Object)new ContentInfo.Builder(pair).setClip((ClipData)object.first).build(), (Object)new ContentInfo.Builder(pair).setClip((ClipData)object.second).build());
        }
    }

    public static final class Builder {
        private final BuilderCompat mBuilderCompat;

        public Builder(ClipData clipData, int n) {
            this.mBuilderCompat = Build.VERSION.SDK_INT >= 31 ? new BuilderCompat31Impl(clipData, n) : new BuilderCompatImpl(clipData, n);
        }

        public Builder(ContentInfoCompat contentInfoCompat) {
            this.mBuilderCompat = Build.VERSION.SDK_INT >= 31 ? new BuilderCompat31Impl(contentInfoCompat) : new BuilderCompatImpl(contentInfoCompat);
        }

        public ContentInfoCompat build() {
            return this.mBuilderCompat.build();
        }

        public Builder setClip(ClipData clipData) {
            this.mBuilderCompat.setClip(clipData);
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.mBuilderCompat.setExtras(bundle);
            return this;
        }

        public Builder setFlags(int n) {
            this.mBuilderCompat.setFlags(n);
            return this;
        }

        public Builder setLinkUri(Uri uri) {
            this.mBuilderCompat.setLinkUri(uri);
            return this;
        }

        public Builder setSource(int n) {
            this.mBuilderCompat.setSource(n);
            return this;
        }
    }

    private static interface BuilderCompat {
        public ContentInfoCompat build();

        public void setClip(ClipData var1);

        public void setExtras(Bundle var1);

        public void setFlags(int var1);

        public void setLinkUri(Uri var1);

        public void setSource(int var1);
    }

    private static final class BuilderCompat31Impl
    implements BuilderCompat {
        private final ContentInfo.Builder mPlatformBuilder;

        BuilderCompat31Impl(ClipData clipData, int n) {
            this.mPlatformBuilder = new ContentInfo.Builder(clipData, n);
        }

        BuilderCompat31Impl(ContentInfoCompat contentInfoCompat) {
            this.mPlatformBuilder = new ContentInfo.Builder(contentInfoCompat.toContentInfo());
        }

        @Override
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new Compat31Impl(this.mPlatformBuilder.build()));
        }

        @Override
        public void setClip(ClipData clipData) {
            this.mPlatformBuilder.setClip(clipData);
        }

        @Override
        public void setExtras(Bundle bundle) {
            this.mPlatformBuilder.setExtras(bundle);
        }

        @Override
        public void setFlags(int n) {
            this.mPlatformBuilder.setFlags(n);
        }

        @Override
        public void setLinkUri(Uri uri) {
            this.mPlatformBuilder.setLinkUri(uri);
        }

        @Override
        public void setSource(int n) {
            this.mPlatformBuilder.setSource(n);
        }
    }

    private static final class BuilderCompatImpl
    implements BuilderCompat {
        ClipData mClip;
        Bundle mExtras;
        int mFlags;
        Uri mLinkUri;
        int mSource;

        BuilderCompatImpl(ClipData clipData, int n) {
            this.mClip = clipData;
            this.mSource = n;
        }

        BuilderCompatImpl(ContentInfoCompat contentInfoCompat) {
            this.mClip = contentInfoCompat.getClip();
            this.mSource = contentInfoCompat.getSource();
            this.mFlags = contentInfoCompat.getFlags();
            this.mLinkUri = contentInfoCompat.getLinkUri();
            this.mExtras = contentInfoCompat.getExtras();
        }

        @Override
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new CompatImpl(this));
        }

        @Override
        public void setClip(ClipData clipData) {
            this.mClip = clipData;
        }

        @Override
        public void setExtras(Bundle bundle) {
            this.mExtras = bundle;
        }

        @Override
        public void setFlags(int n) {
            this.mFlags = n;
        }

        @Override
        public void setLinkUri(Uri uri) {
            this.mLinkUri = uri;
        }

        @Override
        public void setSource(int n) {
            this.mSource = n;
        }
    }

    private static interface Compat {
        public ClipData getClip();

        public Bundle getExtras();

        public int getFlags();

        public Uri getLinkUri();

        public int getSource();

        public ContentInfo getWrapped();
    }

    private static final class Compat31Impl
    implements Compat {
        private final ContentInfo mWrapped;

        Compat31Impl(ContentInfo contentInfo) {
            this.mWrapped = Preconditions.checkNotNull(contentInfo);
        }

        @Override
        public ClipData getClip() {
            return this.mWrapped.getClip();
        }

        @Override
        public Bundle getExtras() {
            return this.mWrapped.getExtras();
        }

        @Override
        public int getFlags() {
            return this.mWrapped.getFlags();
        }

        @Override
        public Uri getLinkUri() {
            return this.mWrapped.getLinkUri();
        }

        @Override
        public int getSource() {
            return this.mWrapped.getSource();
        }

        @Override
        public ContentInfo getWrapped() {
            return this.mWrapped;
        }

        public String toString() {
            return "ContentInfoCompat{" + this.mWrapped + "}";
        }
    }

    private static final class CompatImpl
    implements Compat {
        private final ClipData mClip;
        private final Bundle mExtras;
        private final int mFlags;
        private final Uri mLinkUri;
        private final int mSource;

        CompatImpl(BuilderCompatImpl builderCompatImpl) {
            this.mClip = Preconditions.checkNotNull(builderCompatImpl.mClip);
            this.mSource = Preconditions.checkArgumentInRange(builderCompatImpl.mSource, 0, 5, "source");
            this.mFlags = Preconditions.checkFlagsArgument(builderCompatImpl.mFlags, 1);
            this.mLinkUri = builderCompatImpl.mLinkUri;
            this.mExtras = builderCompatImpl.mExtras;
        }

        @Override
        public ClipData getClip() {
            return this.mClip;
        }

        @Override
        public Bundle getExtras() {
            return this.mExtras;
        }

        @Override
        public int getFlags() {
            return this.mFlags;
        }

        @Override
        public Uri getLinkUri() {
            return this.mLinkUri;
        }

        @Override
        public int getSource() {
            return this.mSource;
        }

        @Override
        public ContentInfo getWrapped() {
            return null;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder().append("ContentInfoCompat{clip=").append(this.mClip.getDescription()).append(", source=").append(ContentInfoCompat.sourceToString(this.mSource)).append(", flags=").append(ContentInfoCompat.flagsToString(this.mFlags));
            Object object = this.mLinkUri;
            String string2 = "";
            object = object == null ? "" : ", hasLinkUri(" + this.mLinkUri.toString().length() + ")";
            stringBuilder = stringBuilder.append((String)object);
            object = this.mExtras == null ? string2 : ", hasExtras";
            return stringBuilder.append((String)object).append("}").toString();
        }
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface Flags {
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface Source {
    }
}

