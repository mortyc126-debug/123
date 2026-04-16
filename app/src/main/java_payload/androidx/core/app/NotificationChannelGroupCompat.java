/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.NotificationChannel
 *  android.app.NotificationChannelGroup
 *  android.os.Build$VERSION
 */
package androidx.core.app;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.os.Build;
import androidx.core.app.NotificationChannelCompat;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NotificationChannelGroupCompat {
    private boolean mBlocked;
    private List<NotificationChannelCompat> mChannels = Collections.emptyList();
    String mDescription;
    final String mId;
    CharSequence mName;

    NotificationChannelGroupCompat(NotificationChannelGroup notificationChannelGroup) {
        this(notificationChannelGroup, Collections.emptyList());
    }

    NotificationChannelGroupCompat(NotificationChannelGroup notificationChannelGroup, List<NotificationChannel> list) {
        this(Api26Impl.getId(notificationChannelGroup));
        this.mName = Api26Impl.getName(notificationChannelGroup);
        if (Build.VERSION.SDK_INT >= 28) {
            this.mDescription = Api28Impl.getDescription(notificationChannelGroup);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            this.mBlocked = Api28Impl.isBlocked(notificationChannelGroup);
            this.mChannels = this.getChannelsCompat(Api26Impl.getChannels(notificationChannelGroup));
        } else {
            this.mChannels = this.getChannelsCompat(list);
        }
    }

    NotificationChannelGroupCompat(String string2) {
        this.mId = Preconditions.checkNotNull(string2);
    }

    private List<NotificationChannelCompat> getChannelsCompat(List<NotificationChannel> object) {
        ArrayList<NotificationChannelCompat> arrayList = new ArrayList<NotificationChannelCompat>();
        object = object.iterator();
        while (object.hasNext()) {
            NotificationChannel notificationChannel = (NotificationChannel)object.next();
            if (!this.mId.equals(Api26Impl.getGroup(notificationChannel))) continue;
            arrayList.add(new NotificationChannelCompat(notificationChannel));
        }
        return arrayList;
    }

    public List<NotificationChannelCompat> getChannels() {
        return this.mChannels;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getId() {
        return this.mId;
    }

    public CharSequence getName() {
        return this.mName;
    }

    NotificationChannelGroup getNotificationChannelGroup() {
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        NotificationChannelGroup notificationChannelGroup = Api26Impl.createNotificationChannelGroup(this.mId, this.mName);
        if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.setDescription(notificationChannelGroup, this.mDescription);
        }
        return notificationChannelGroup;
    }

    public boolean isBlocked() {
        return this.mBlocked;
    }

    public Builder toBuilder() {
        return new Builder(this.mId).setName(this.mName).setDescription(this.mDescription);
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static NotificationChannelGroup createNotificationChannelGroup(String string2, CharSequence charSequence) {
            return new NotificationChannelGroup(string2, charSequence);
        }

        static List<NotificationChannel> getChannels(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getChannels();
        }

        static String getGroup(NotificationChannel notificationChannel) {
            return notificationChannel.getGroup();
        }

        static String getId(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getId();
        }

        static CharSequence getName(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getName();
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static String getDescription(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getDescription();
        }

        static boolean isBlocked(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.isBlocked();
        }

        static void setDescription(NotificationChannelGroup notificationChannelGroup, String string2) {
            notificationChannelGroup.setDescription(string2);
        }
    }

    public static class Builder {
        final NotificationChannelGroupCompat mGroup;

        public Builder(String string2) {
            this.mGroup = new NotificationChannelGroupCompat(string2);
        }

        public NotificationChannelGroupCompat build() {
            return this.mGroup;
        }

        public Builder setDescription(String string2) {
            this.mGroup.mDescription = string2;
            return this;
        }

        public Builder setName(CharSequence charSequence) {
            this.mGroup.mName = charSequence;
            return this;
        }
    }
}

