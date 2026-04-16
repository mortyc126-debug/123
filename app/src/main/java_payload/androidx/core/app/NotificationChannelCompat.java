/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.NotificationChannel
 *  android.media.AudioAttributes
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.provider.Settings$System
 */
package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import androidx.core.util.Preconditions;

public class NotificationChannelCompat {
    public static final String DEFAULT_CHANNEL_ID = "miscellaneous";
    private static final int DEFAULT_LIGHT_COLOR = 0;
    private static final boolean DEFAULT_SHOW_BADGE = true;
    AudioAttributes mAudioAttributes;
    private boolean mBypassDnd;
    private boolean mCanBubble;
    String mConversationId;
    String mDescription;
    String mGroupId;
    final String mId;
    int mImportance;
    private boolean mImportantConversation;
    int mLightColor = 0;
    boolean mLights;
    private int mLockscreenVisibility;
    CharSequence mName;
    String mParentId;
    boolean mShowBadge = true;
    Uri mSound = Settings.System.DEFAULT_NOTIFICATION_URI;
    boolean mVibrationEnabled;
    long[] mVibrationPattern;

    NotificationChannelCompat(NotificationChannel notificationChannel) {
        this(Api26Impl.getId(notificationChannel), Api26Impl.getImportance(notificationChannel));
        this.mName = Api26Impl.getName(notificationChannel);
        this.mDescription = Api26Impl.getDescription(notificationChannel);
        this.mGroupId = Api26Impl.getGroup(notificationChannel);
        this.mShowBadge = Api26Impl.canShowBadge(notificationChannel);
        this.mSound = Api26Impl.getSound(notificationChannel);
        this.mAudioAttributes = Api26Impl.getAudioAttributes(notificationChannel);
        this.mLights = Api26Impl.shouldShowLights(notificationChannel);
        this.mLightColor = Api26Impl.getLightColor(notificationChannel);
        this.mVibrationEnabled = Api26Impl.shouldVibrate(notificationChannel);
        this.mVibrationPattern = Api26Impl.getVibrationPattern(notificationChannel);
        if (Build.VERSION.SDK_INT >= 30) {
            this.mParentId = Api30Impl.getParentChannelId(notificationChannel);
            this.mConversationId = Api30Impl.getConversationId(notificationChannel);
        }
        this.mBypassDnd = Api26Impl.canBypassDnd(notificationChannel);
        this.mLockscreenVisibility = Api26Impl.getLockscreenVisibility(notificationChannel);
        if (Build.VERSION.SDK_INT >= 29) {
            this.mCanBubble = Api29Impl.canBubble(notificationChannel);
        }
        if (Build.VERSION.SDK_INT >= 30) {
            this.mImportantConversation = Api30Impl.isImportantConversation(notificationChannel);
        }
    }

    NotificationChannelCompat(String string2, int n) {
        this.mId = Preconditions.checkNotNull(string2);
        this.mImportance = n;
        this.mAudioAttributes = Notification.AUDIO_ATTRIBUTES_DEFAULT;
    }

    public boolean canBubble() {
        return this.mCanBubble;
    }

    public boolean canBypassDnd() {
        return this.mBypassDnd;
    }

    public boolean canShowBadge() {
        return this.mShowBadge;
    }

    public AudioAttributes getAudioAttributes() {
        return this.mAudioAttributes;
    }

    public String getConversationId() {
        return this.mConversationId;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getGroup() {
        return this.mGroupId;
    }

    public String getId() {
        return this.mId;
    }

    public int getImportance() {
        return this.mImportance;
    }

    public int getLightColor() {
        return this.mLightColor;
    }

    public int getLockscreenVisibility() {
        return this.mLockscreenVisibility;
    }

    public CharSequence getName() {
        return this.mName;
    }

    NotificationChannel getNotificationChannel() {
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        NotificationChannel notificationChannel = Api26Impl.createNotificationChannel(this.mId, this.mName, this.mImportance);
        Api26Impl.setDescription(notificationChannel, this.mDescription);
        Api26Impl.setGroup(notificationChannel, this.mGroupId);
        Api26Impl.setShowBadge(notificationChannel, this.mShowBadge);
        Api26Impl.setSound(notificationChannel, this.mSound, this.mAudioAttributes);
        Api26Impl.enableLights(notificationChannel, this.mLights);
        Api26Impl.setLightColor(notificationChannel, this.mLightColor);
        Api26Impl.setVibrationPattern(notificationChannel, this.mVibrationPattern);
        Api26Impl.enableVibration(notificationChannel, this.mVibrationEnabled);
        if (Build.VERSION.SDK_INT >= 30 && this.mParentId != null && this.mConversationId != null) {
            Api30Impl.setConversationId(notificationChannel, this.mParentId, this.mConversationId);
        }
        return notificationChannel;
    }

    public String getParentChannelId() {
        return this.mParentId;
    }

    public Uri getSound() {
        return this.mSound;
    }

    public long[] getVibrationPattern() {
        return this.mVibrationPattern;
    }

    public boolean isImportantConversation() {
        return this.mImportantConversation;
    }

    public boolean shouldShowLights() {
        return this.mLights;
    }

    public boolean shouldVibrate() {
        return this.mVibrationEnabled;
    }

    public Builder toBuilder() {
        return new Builder(this.mId, this.mImportance).setName(this.mName).setDescription(this.mDescription).setGroup(this.mGroupId).setShowBadge(this.mShowBadge).setSound(this.mSound, this.mAudioAttributes).setLightsEnabled(this.mLights).setLightColor(this.mLightColor).setVibrationEnabled(this.mVibrationEnabled).setVibrationPattern(this.mVibrationPattern).setConversationId(this.mParentId, this.mConversationId);
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static boolean canBypassDnd(NotificationChannel notificationChannel) {
            return notificationChannel.canBypassDnd();
        }

        static boolean canShowBadge(NotificationChannel notificationChannel) {
            return notificationChannel.canShowBadge();
        }

        static NotificationChannel createNotificationChannel(String string2, CharSequence charSequence, int n) {
            return new NotificationChannel(string2, charSequence, n);
        }

        static void enableLights(NotificationChannel notificationChannel, boolean bl) {
            notificationChannel.enableLights(bl);
        }

        static void enableVibration(NotificationChannel notificationChannel, boolean bl) {
            notificationChannel.enableVibration(bl);
        }

        static AudioAttributes getAudioAttributes(NotificationChannel notificationChannel) {
            return notificationChannel.getAudioAttributes();
        }

        static String getDescription(NotificationChannel notificationChannel) {
            return notificationChannel.getDescription();
        }

        static String getGroup(NotificationChannel notificationChannel) {
            return notificationChannel.getGroup();
        }

        static String getId(NotificationChannel notificationChannel) {
            return notificationChannel.getId();
        }

        static int getImportance(NotificationChannel notificationChannel) {
            return notificationChannel.getImportance();
        }

        static int getLightColor(NotificationChannel notificationChannel) {
            return notificationChannel.getLightColor();
        }

        static int getLockscreenVisibility(NotificationChannel notificationChannel) {
            return notificationChannel.getLockscreenVisibility();
        }

        static CharSequence getName(NotificationChannel notificationChannel) {
            return notificationChannel.getName();
        }

        static Uri getSound(NotificationChannel notificationChannel) {
            return notificationChannel.getSound();
        }

        static long[] getVibrationPattern(NotificationChannel notificationChannel) {
            return notificationChannel.getVibrationPattern();
        }

        static void setDescription(NotificationChannel notificationChannel, String string2) {
            notificationChannel.setDescription(string2);
        }

        static void setGroup(NotificationChannel notificationChannel, String string2) {
            notificationChannel.setGroup(string2);
        }

        static void setLightColor(NotificationChannel notificationChannel, int n) {
            notificationChannel.setLightColor(n);
        }

        static void setShowBadge(NotificationChannel notificationChannel, boolean bl) {
            notificationChannel.setShowBadge(bl);
        }

        static void setSound(NotificationChannel notificationChannel, Uri uri, AudioAttributes audioAttributes) {
            notificationChannel.setSound(uri, audioAttributes);
        }

        static void setVibrationPattern(NotificationChannel notificationChannel, long[] lArray) {
            notificationChannel.setVibrationPattern(lArray);
        }

        static boolean shouldShowLights(NotificationChannel notificationChannel) {
            return notificationChannel.shouldShowLights();
        }

        static boolean shouldVibrate(NotificationChannel notificationChannel) {
            return notificationChannel.shouldVibrate();
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static boolean canBubble(NotificationChannel notificationChannel) {
            return notificationChannel.canBubble();
        }
    }

    static class Api30Impl {
        private Api30Impl() {
        }

        static String getConversationId(NotificationChannel notificationChannel) {
            return notificationChannel.getConversationId();
        }

        static String getParentChannelId(NotificationChannel notificationChannel) {
            return notificationChannel.getParentChannelId();
        }

        static boolean isImportantConversation(NotificationChannel notificationChannel) {
            return notificationChannel.isImportantConversation();
        }

        static void setConversationId(NotificationChannel notificationChannel, String string2, String string3) {
            notificationChannel.setConversationId(string2, string3);
        }
    }

    public static class Builder {
        private final NotificationChannelCompat mChannel;

        public Builder(String string2, int n) {
            this.mChannel = new NotificationChannelCompat(string2, n);
        }

        public NotificationChannelCompat build() {
            return this.mChannel;
        }

        public Builder setConversationId(String string2, String string3) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.mChannel.mParentId = string2;
                this.mChannel.mConversationId = string3;
            }
            return this;
        }

        public Builder setDescription(String string2) {
            this.mChannel.mDescription = string2;
            return this;
        }

        public Builder setGroup(String string2) {
            this.mChannel.mGroupId = string2;
            return this;
        }

        public Builder setImportance(int n) {
            this.mChannel.mImportance = n;
            return this;
        }

        public Builder setLightColor(int n) {
            this.mChannel.mLightColor = n;
            return this;
        }

        public Builder setLightsEnabled(boolean bl) {
            this.mChannel.mLights = bl;
            return this;
        }

        public Builder setName(CharSequence charSequence) {
            this.mChannel.mName = charSequence;
            return this;
        }

        public Builder setShowBadge(boolean bl) {
            this.mChannel.mShowBadge = bl;
            return this;
        }

        public Builder setSound(Uri uri, AudioAttributes audioAttributes) {
            this.mChannel.mSound = uri;
            this.mChannel.mAudioAttributes = audioAttributes;
            return this;
        }

        public Builder setVibrationEnabled(boolean bl) {
            this.mChannel.mVibrationEnabled = bl;
            return this;
        }

        public Builder setVibrationPattern(long[] lArray) {
            NotificationChannelCompat notificationChannelCompat = this.mChannel;
            boolean bl = lArray != null && lArray.length > 0;
            notificationChannelCompat.mVibrationEnabled = bl;
            this.mChannel.mVibrationPattern = lArray;
            return this;
        }
    }
}

