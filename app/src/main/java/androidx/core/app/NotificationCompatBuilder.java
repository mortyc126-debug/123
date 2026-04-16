/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Notification$Action
 *  android.app.Notification$Action$Builder
 *  android.app.Notification$BubbleMetadata
 *  android.app.Notification$Builder
 *  android.app.PendingIntent
 *  android.app.Person
 *  android.app.RemoteInput
 *  android.content.Context
 *  android.content.LocusId
 *  android.graphics.drawable.Icon
 *  android.media.AudioAttributes
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.widget.RemoteViews
 */
package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.LocusId;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.collection.ArraySet;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompatJellybean;
import androidx.core.app.Person;
import androidx.core.app.RemoteInput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class NotificationCompatBuilder
implements NotificationBuilderWithBuilderAccessor {
    private final List<Bundle> mActionExtrasList = new ArrayList<Bundle>();
    private RemoteViews mBigContentView;
    private final Notification.Builder mBuilder;
    private final NotificationCompat.Builder mBuilderCompat;
    private RemoteViews mContentView;
    private final Context mContext;
    private final Bundle mExtras = new Bundle();
    private int mGroupAlertBehavior;
    private RemoteViews mHeadsUpContentView;

    /*
     * WARNING - void declaration
     */
    NotificationCompatBuilder(NotificationCompat.Builder builder) {
        void var4_15;
        void var4_9;
        this.mBuilderCompat = builder;
        this.mContext = builder.mContext;
        this.mBuilder = Build.VERSION.SDK_INT >= 26 ? Api26Impl.createBuilder(builder.mContext, builder.mChannelId) : new Notification.Builder(builder.mContext);
        Notification notification = builder.mNotification;
        Notification.Builder object3 = this.mBuilder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, builder.mTickerView).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
        boolean bl = (notification.flags & 2) != 0;
        Notification.Builder builder2 = object3.setOngoing(bl);
        bl = (notification.flags & 8) != 0;
        Notification.Builder builder3 = builder2.setOnlyAlertOnce(bl);
        bl = (notification.flags & 0x10) != 0;
        Notification.Builder builder4 = builder3.setAutoCancel(bl).setDefaults(notification.defaults).setContentTitle(builder.mContentTitle).setContentText(builder.mContentText).setContentInfo(builder.mContentInfo).setContentIntent(builder.mContentIntent).setDeleteIntent(notification.deleteIntent);
        Object object = builder.mFullScreenIntent;
        bl = (notification.flags & 0x80) != 0;
        builder4.setFullScreenIntent((PendingIntent)object, bl).setNumber(builder.mNumber).setProgress(builder.mProgressMax, builder.mProgress, builder.mProgressIndeterminate);
        object = this.mBuilder;
        if (builder.mLargeIcon == null) {
            Object var4_7 = null;
        } else {
            Icon icon = builder.mLargeIcon.toIcon(this.mContext);
        }
        Api23Impl.setLargeIcon((Notification.Builder)object, (Icon)var4_9);
        this.mBuilder.setSubText(builder.mSubText).setUsesChronometer(builder.mUseChronometer).setPriority(builder.mPriority);
        if (builder.mStyle instanceof NotificationCompat.CallStyle) {
            Iterator iterator2 = ((NotificationCompat.CallStyle)builder.mStyle).getActionsListWithSystemActions().iterator();
            while (iterator2.hasNext()) {
                this.addAction((NotificationCompat.Action)iterator2.next());
            }
        } else {
            Iterator<NotificationCompat.Action> iterator3 = builder.mActions.iterator();
            while (iterator3.hasNext()) {
                this.addAction(iterator3.next());
            }
        }
        if (builder.mExtras != null) {
            this.mExtras.putAll(builder.mExtras);
        }
        this.mContentView = builder.mContentView;
        this.mBigContentView = builder.mBigContentView;
        this.mBuilder.setShowWhen(builder.mShowWhen);
        Api20Impl.setLocalOnly(this.mBuilder, builder.mLocalOnly);
        Api20Impl.setGroup(this.mBuilder, builder.mGroupKey);
        Api20Impl.setSortKey(this.mBuilder, builder.mSortKey);
        Api20Impl.setGroupSummary(this.mBuilder, builder.mGroupSummary);
        this.mGroupAlertBehavior = builder.mGroupAlertBehavior;
        Api21Impl.setCategory(this.mBuilder, builder.mCategory);
        Api21Impl.setColor(this.mBuilder, builder.mColor);
        Api21Impl.setVisibility(this.mBuilder, builder.mVisibility);
        Api21Impl.setPublicVersion(this.mBuilder, builder.mPublicVersion);
        Api21Impl.setSound(this.mBuilder, notification.sound, notification.audioAttributes);
        if (Build.VERSION.SDK_INT < 28) {
            List<String> list = NotificationCompatBuilder.combineLists(NotificationCompatBuilder.getPeople(builder.mPersonList), builder.mPeople);
        } else {
            ArrayList<String> arrayList = builder.mPeople;
        }
        if (var4_15 != null && !var4_15.isEmpty()) {
            object = var4_15.iterator();
            while (object.hasNext()) {
                String string2 = (String)object.next();
                Api21Impl.addPerson(this.mBuilder, string2);
            }
        }
        this.mHeadsUpContentView = builder.mHeadsUpContentView;
        if (builder.mInvisibleActions.size() > 0) {
            void var4_20;
            Object object2 = object = builder.getExtras().getBundle("android.car.EXTENSIONS");
            if (object == null) {
                Bundle bundle = new Bundle();
            }
            object = new Bundle((Bundle)var4_20);
            Bundle bundle = new Bundle();
            for (int i = 0; i < builder.mInvisibleActions.size(); ++i) {
                bundle.putBundle(Integer.toString(i), NotificationCompatJellybean.getBundleForAction(builder.mInvisibleActions.get(i)));
            }
            var4_20.putBundle("invisible_actions", bundle);
            object.putBundle("invisible_actions", bundle);
            builder.getExtras().putBundle("android.car.EXTENSIONS", (Bundle)var4_20);
            this.mExtras.putBundle("android.car.EXTENSIONS", (Bundle)object);
        }
        if (builder.mSmallIcon != null) {
            Api23Impl.setSmallIcon(this.mBuilder, builder.mSmallIcon);
        }
        this.mBuilder.setExtras(builder.mExtras);
        Api24Impl.setRemoteInputHistory(this.mBuilder, builder.mRemoteInputHistory);
        if (builder.mContentView != null) {
            Api24Impl.setCustomContentView(this.mBuilder, builder.mContentView);
        }
        if (builder.mBigContentView != null) {
            Api24Impl.setCustomBigContentView(this.mBuilder, builder.mBigContentView);
        }
        if (builder.mHeadsUpContentView != null) {
            Api24Impl.setCustomHeadsUpContentView(this.mBuilder, builder.mHeadsUpContentView);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.setBadgeIconType(this.mBuilder, builder.mBadgeIcon);
            Api26Impl.setSettingsText(this.mBuilder, builder.mSettingsText);
            Api26Impl.setShortcutId(this.mBuilder, builder.mShortcutId);
            Api26Impl.setTimeoutAfter(this.mBuilder, builder.mTimeout);
            Api26Impl.setGroupAlertBehavior(this.mBuilder, builder.mGroupAlertBehavior);
            if (builder.mColorizedSet) {
                Api26Impl.setColorized(this.mBuilder, builder.mColorized);
            }
            if (!TextUtils.isEmpty((CharSequence)builder.mChannelId)) {
                this.mBuilder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (Build.VERSION.SDK_INT >= 28) {
            for (Person person : builder.mPersonList) {
                Api28Impl.addPerson(this.mBuilder, person.toAndroidPerson());
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.setAllowSystemGeneratedContextualActions(this.mBuilder, builder.mAllowSystemGeneratedContextualActions);
            Api29Impl.setBubbleMetadata(this.mBuilder, NotificationCompat.BubbleMetadata.toPlatform(builder.mBubbleMetadata));
            if (builder.mLocusId != null) {
                Api29Impl.setLocusId(this.mBuilder, builder.mLocusId.toLocusId());
            }
        }
        if (Build.VERSION.SDK_INT >= 31 && builder.mFgsDeferBehavior != 0) {
            Api31Impl.setForegroundServiceBehavior(this.mBuilder, builder.mFgsDeferBehavior);
        }
        if (builder.mSilent) {
            this.mGroupAlertBehavior = this.mBuilderCompat.mGroupSummary ? 2 : 1;
            this.mBuilder.setVibrate(null);
            this.mBuilder.setSound(null);
            notification.defaults &= 0xFFFFFFFE;
            notification.defaults &= 0xFFFFFFFD;
            this.mBuilder.setDefaults(notification.defaults);
            if (Build.VERSION.SDK_INT >= 26) {
                if (TextUtils.isEmpty((CharSequence)this.mBuilderCompat.mGroupKey)) {
                    Api20Impl.setGroup(this.mBuilder, "silent");
                }
                Api26Impl.setGroupAlertBehavior(this.mBuilder, this.mGroupAlertBehavior);
            }
        }
    }

    private void addAction(NotificationCompat.Action action) {
        Object object = action.getIconCompat();
        object = object != null ? object.toIcon() : null;
        Notification.Action.Builder builder = Api23Impl.createBuilder((Icon)object, action.getTitle(), action.getActionIntent());
        if (action.getRemoteInputs() != null) {
            object = RemoteInput.fromCompat(action.getRemoteInputs());
            int n = ((android.app.RemoteInput[])object).length;
            for (int i = 0; i < n; ++i) {
                Api20Impl.addRemoteInput(builder, (android.app.RemoteInput)object[i]);
            }
        }
        object = action.getExtras() != null ? new Bundle(action.getExtras()) : new Bundle();
        object.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
        Api24Impl.setAllowGeneratedReplies(builder, action.getAllowGeneratedReplies());
        object.putInt("android.support.action.semanticAction", action.getSemanticAction());
        if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.setSemanticAction(builder, action.getSemanticAction());
        }
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.setContextual(builder, action.isContextual());
        }
        if (Build.VERSION.SDK_INT >= 31) {
            Api31Impl.setAuthenticationRequired(builder, action.isAuthenticationRequired());
        }
        object.putBoolean("android.support.action.showsUserInterface", action.getShowsUserInterface());
        Api20Impl.addExtras(builder, object);
        Api20Impl.addAction(this.mBuilder, Api20Impl.build(builder));
    }

    private static List<String> combineLists(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        ArraySet<String> arraySet = new ArraySet<String>(list.size() + list2.size());
        arraySet.addAll(list);
        arraySet.addAll(list2);
        return new ArrayList<String>(arraySet);
    }

    private static List<String> getPeople(List<Person> object) {
        if (object == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<String>(object.size());
        object = object.iterator();
        while (object.hasNext()) {
            arrayList.add(((Person)object.next()).resolveToLegacyUri());
        }
        return arrayList;
    }

    private void removeSoundAndVibration(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= 0xFFFFFFFE;
        notification.defaults &= 0xFFFFFFFD;
    }

    public Notification build() {
        NotificationCompat.Style style2 = this.mBuilderCompat.mStyle;
        if (style2 != null) {
            style2.apply(this);
        }
        RemoteViews remoteViews = style2 != null ? style2.makeContentView(this) : null;
        Notification notification = this.buildInternal();
        if (remoteViews != null) {
            notification.contentView = remoteViews;
        } else if (this.mBuilderCompat.mContentView != null) {
            notification.contentView = this.mBuilderCompat.mContentView;
        }
        if (style2 != null && (remoteViews = style2.makeBigContentView(this)) != null) {
            notification.bigContentView = remoteViews;
        }
        if (style2 != null && (remoteViews = this.mBuilderCompat.mStyle.makeHeadsUpContentView(this)) != null) {
            notification.headsUpContentView = remoteViews;
        }
        if (style2 != null && (remoteViews = NotificationCompat.getExtras(notification)) != null) {
            style2.addCompatExtras((Bundle)remoteViews);
        }
        return notification;
    }

    protected Notification buildInternal() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.mBuilder.build();
        }
        Notification notification = this.mBuilder.build();
        if (this.mGroupAlertBehavior != 0) {
            if (Api20Impl.getGroup(notification) != null && (notification.flags & 0x200) != 0 && this.mGroupAlertBehavior == 2) {
                this.removeSoundAndVibration(notification);
            }
            if (Api20Impl.getGroup(notification) != null && (notification.flags & 0x200) == 0 && this.mGroupAlertBehavior == 1) {
                this.removeSoundAndVibration(notification);
            }
        }
        return notification;
    }

    @Override
    public Notification.Builder getBuilder() {
        return this.mBuilder;
    }

    Context getContext() {
        return this.mContext;
    }

    static class Api20Impl {
        private Api20Impl() {
        }

        static Notification.Builder addAction(Notification.Builder builder, Notification.Action action) {
            return builder.addAction(action);
        }

        static Notification.Action.Builder addExtras(Notification.Action.Builder builder, Bundle bundle) {
            return builder.addExtras(bundle);
        }

        static Notification.Action.Builder addRemoteInput(Notification.Action.Builder builder, android.app.RemoteInput remoteInput) {
            return builder.addRemoteInput(remoteInput);
        }

        static Notification.Action build(Notification.Action.Builder builder) {
            return builder.build();
        }

        static Notification.Action.Builder createBuilder(int n, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(n, charSequence, pendingIntent);
        }

        static String getGroup(Notification notification) {
            return notification.getGroup();
        }

        static Notification.Builder setGroup(Notification.Builder builder, String string2) {
            return builder.setGroup(string2);
        }

        static Notification.Builder setGroupSummary(Notification.Builder builder, boolean bl) {
            return builder.setGroupSummary(bl);
        }

        static Notification.Builder setLocalOnly(Notification.Builder builder, boolean bl) {
            return builder.setLocalOnly(bl);
        }

        static Notification.Builder setSortKey(Notification.Builder builder, String string2) {
            return builder.setSortKey(string2);
        }
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static Notification.Builder addPerson(Notification.Builder builder, String string2) {
            return builder.addPerson(string2);
        }

        static Notification.Builder setCategory(Notification.Builder builder, String string2) {
            return builder.setCategory(string2);
        }

        static Notification.Builder setColor(Notification.Builder builder, int n) {
            return builder.setColor(n);
        }

        static Notification.Builder setPublicVersion(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        static Notification.Builder setSound(Notification.Builder builder, Uri uri, Object object) {
            return builder.setSound(uri, (AudioAttributes)object);
        }

        static Notification.Builder setVisibility(Notification.Builder builder, int n) {
            return builder.setVisibility(n);
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static Notification.Action.Builder createBuilder(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(icon, charSequence, pendingIntent);
        }

        static Notification.Builder setLargeIcon(Notification.Builder builder, Icon icon) {
            return builder.setLargeIcon(icon);
        }

        static Notification.Builder setSmallIcon(Notification.Builder builder, Object object) {
            return builder.setSmallIcon((Icon)object);
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static Notification.Action.Builder setAllowGeneratedReplies(Notification.Action.Builder builder, boolean bl) {
            return builder.setAllowGeneratedReplies(bl);
        }

        static Notification.Builder setCustomBigContentView(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomBigContentView(remoteViews);
        }

        static Notification.Builder setCustomContentView(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomContentView(remoteViews);
        }

        static Notification.Builder setCustomHeadsUpContentView(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomHeadsUpContentView(remoteViews);
        }

        static Notification.Builder setRemoteInputHistory(Notification.Builder builder, CharSequence[] charSequenceArray) {
            return builder.setRemoteInputHistory(charSequenceArray);
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static Notification.Builder createBuilder(Context context, String string2) {
            return new Notification.Builder(context, string2);
        }

        static Notification.Builder setBadgeIconType(Notification.Builder builder, int n) {
            return builder.setBadgeIconType(n);
        }

        static Notification.Builder setColorized(Notification.Builder builder, boolean bl) {
            return builder.setColorized(bl);
        }

        static Notification.Builder setGroupAlertBehavior(Notification.Builder builder, int n) {
            return builder.setGroupAlertBehavior(n);
        }

        static Notification.Builder setSettingsText(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSettingsText(charSequence);
        }

        static Notification.Builder setShortcutId(Notification.Builder builder, String string2) {
            return builder.setShortcutId(string2);
        }

        static Notification.Builder setTimeoutAfter(Notification.Builder builder, long l) {
            return builder.setTimeoutAfter(l);
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static Notification.Builder addPerson(Notification.Builder builder, android.app.Person person) {
            return builder.addPerson(person);
        }

        static Notification.Action.Builder setSemanticAction(Notification.Action.Builder builder, int n) {
            return builder.setSemanticAction(n);
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static Notification.Builder setAllowSystemGeneratedContextualActions(Notification.Builder builder, boolean bl) {
            return builder.setAllowSystemGeneratedContextualActions(bl);
        }

        static Notification.Builder setBubbleMetadata(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
            return builder.setBubbleMetadata(bubbleMetadata);
        }

        static Notification.Action.Builder setContextual(Notification.Action.Builder builder, boolean bl) {
            return builder.setContextual(bl);
        }

        static Notification.Builder setLocusId(Notification.Builder builder, Object object) {
            return builder.setLocusId((LocusId)object);
        }
    }

    static class Api31Impl {
        private Api31Impl() {
        }

        static Notification.Action.Builder setAuthenticationRequired(Notification.Action.Builder builder, boolean bl) {
            return builder.setAuthenticationRequired(bl);
        }

        static Notification.Builder setForegroundServiceBehavior(Notification.Builder builder, int n) {
            return builder.setForegroundServiceBehavior(n);
        }
    }
}

