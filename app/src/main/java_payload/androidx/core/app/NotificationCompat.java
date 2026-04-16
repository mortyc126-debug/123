/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Notification$Action
 *  android.app.Notification$Action$Builder
 *  android.app.Notification$BigPictureStyle
 *  android.app.Notification$BigTextStyle
 *  android.app.Notification$BubbleMetadata
 *  android.app.Notification$BubbleMetadata$Builder
 *  android.app.Notification$Builder
 *  android.app.Notification$CallStyle
 *  android.app.Notification$DecoratedCustomViewStyle
 *  android.app.Notification$InboxStyle
 *  android.app.Notification$MessagingStyle
 *  android.app.Notification$MessagingStyle$Message
 *  android.app.Notification$Style
 *  android.app.PendingIntent
 *  android.app.Person
 *  android.app.RemoteInput
 *  android.app.RemoteInput$Builder
 *  android.content.Context
 *  android.content.LocusId
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Icon
 *  android.media.AudioAttributes
 *  android.media.AudioAttributes$Builder
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.os.SystemClock
 *  android.text.SpannableStringBuilder
 *  android.text.TextUtils
 *  android.text.style.ForegroundColorSpan
 *  android.text.style.TextAppearanceSpan
 *  android.util.Log
 *  android.widget.RemoteViews
 */
package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.core.R;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompatBuilder;
import androidx.core.app.NotificationCompatJellybean;
import androidx.core.app.Person;
import androidx.core.app.RemoteInput;
import androidx.core.content.ContextCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.text.BidiFormatter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class NotificationCompat {
    public static final int BADGE_ICON_LARGE = 2;
    public static final int BADGE_ICON_NONE = 0;
    public static final int BADGE_ICON_SMALL = 1;
    public static final String CATEGORY_ALARM = "alarm";
    public static final String CATEGORY_CALL = "call";
    public static final String CATEGORY_EMAIL = "email";
    public static final String CATEGORY_ERROR = "err";
    public static final String CATEGORY_EVENT = "event";
    public static final String CATEGORY_LOCATION_SHARING = "location_sharing";
    public static final String CATEGORY_MESSAGE = "msg";
    public static final String CATEGORY_MISSED_CALL = "missed_call";
    public static final String CATEGORY_NAVIGATION = "navigation";
    public static final String CATEGORY_PROGRESS = "progress";
    public static final String CATEGORY_PROMO = "promo";
    public static final String CATEGORY_RECOMMENDATION = "recommendation";
    public static final String CATEGORY_REMINDER = "reminder";
    public static final String CATEGORY_SERVICE = "service";
    public static final String CATEGORY_SOCIAL = "social";
    public static final String CATEGORY_STATUS = "status";
    public static final String CATEGORY_STOPWATCH = "stopwatch";
    public static final String CATEGORY_SYSTEM = "sys";
    public static final String CATEGORY_TRANSPORT = "transport";
    public static final String CATEGORY_WORKOUT = "workout";
    public static final int COLOR_DEFAULT = 0;
    public static final int DEFAULT_ALL = -1;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;
    public static final String EXTRA_ANSWER_COLOR = "android.answerColor";
    public static final String EXTRA_ANSWER_INTENT = "android.answerIntent";
    public static final String EXTRA_AUDIO_CONTENTS_URI = "android.audioContents";
    public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
    public static final String EXTRA_BIG_TEXT = "android.bigText";
    public static final String EXTRA_CALL_IS_VIDEO = "android.callIsVideo";
    public static final String EXTRA_CALL_PERSON = "android.callPerson";
    public static final String EXTRA_CALL_PERSON_COMPAT = "android.callPersonCompat";
    public static final String EXTRA_CALL_TYPE = "android.callType";
    public static final String EXTRA_CHANNEL_GROUP_ID = "android.intent.extra.CHANNEL_GROUP_ID";
    public static final String EXTRA_CHANNEL_ID = "android.intent.extra.CHANNEL_ID";
    public static final String EXTRA_CHRONOMETER_COUNT_DOWN = "android.chronometerCountDown";
    public static final String EXTRA_COLORIZED = "android.colorized";
    public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
    public static final String EXTRA_COMPAT_TEMPLATE = "androidx.core.app.extra.COMPAT_TEMPLATE";
    public static final String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";
    public static final String EXTRA_DECLINE_COLOR = "android.declineColor";
    public static final String EXTRA_DECLINE_INTENT = "android.declineIntent";
    public static final String EXTRA_HANG_UP_INTENT = "android.hangUpIntent";
    public static final String EXTRA_HIDDEN_CONVERSATION_TITLE = "android.hiddenConversationTitle";
    public static final String EXTRA_HISTORIC_MESSAGES = "android.messages.historic";
    public static final String EXTRA_INFO_TEXT = "android.infoText";
    public static final String EXTRA_IS_GROUP_CONVERSATION = "android.isGroupConversation";
    public static final String EXTRA_LARGE_ICON = "android.largeIcon";
    public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
    public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
    public static final String EXTRA_MESSAGES = "android.messages";
    public static final String EXTRA_MESSAGING_STYLE_USER = "android.messagingStyleUser";
    public static final String EXTRA_NOTIFICATION_ID = "android.intent.extra.NOTIFICATION_ID";
    public static final String EXTRA_NOTIFICATION_TAG = "android.intent.extra.NOTIFICATION_TAG";
    @Deprecated
    public static final String EXTRA_PEOPLE = "android.people";
    public static final String EXTRA_PEOPLE_LIST = "android.people.list";
    public static final String EXTRA_PICTURE = "android.picture";
    public static final String EXTRA_PICTURE_CONTENT_DESCRIPTION = "android.pictureContentDescription";
    public static final String EXTRA_PICTURE_ICON = "android.pictureIcon";
    public static final String EXTRA_PROGRESS = "android.progress";
    public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
    public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
    public static final String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";
    public static final String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";
    public static final String EXTRA_SHOW_BIG_PICTURE_WHEN_COLLAPSED = "android.showBigPictureWhenCollapsed";
    public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
    public static final String EXTRA_SHOW_WHEN = "android.showWhen";
    public static final String EXTRA_SMALL_ICON = "android.icon";
    public static final String EXTRA_SUB_TEXT = "android.subText";
    public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
    public static final String EXTRA_TEMPLATE = "android.template";
    public static final String EXTRA_TEXT = "android.text";
    public static final String EXTRA_TEXT_LINES = "android.textLines";
    public static final String EXTRA_TITLE = "android.title";
    public static final String EXTRA_TITLE_BIG = "android.title.big";
    public static final String EXTRA_VERIFICATION_ICON = "android.verificationIcon";
    public static final String EXTRA_VERIFICATION_ICON_COMPAT = "android.verificationIconCompat";
    public static final String EXTRA_VERIFICATION_TEXT = "android.verificationText";
    public static final int FLAG_AUTO_CANCEL = 16;
    public static final int FLAG_BUBBLE = 4096;
    public static final int FLAG_FOREGROUND_SERVICE = 64;
    public static final int FLAG_GROUP_SUMMARY = 512;
    @Deprecated
    public static final int FLAG_HIGH_PRIORITY = 128;
    public static final int FLAG_INSISTENT = 4;
    public static final int FLAG_LOCAL_ONLY = 256;
    public static final int FLAG_NO_CLEAR = 32;
    public static final int FLAG_ONGOING_EVENT = 2;
    public static final int FLAG_ONLY_ALERT_ONCE = 8;
    public static final int FLAG_SHOW_LIGHTS = 1;
    public static final int FOREGROUND_SERVICE_DEFAULT = 0;
    public static final int FOREGROUND_SERVICE_DEFERRED = 2;
    public static final int FOREGROUND_SERVICE_IMMEDIATE = 1;
    public static final int GROUP_ALERT_ALL = 0;
    public static final int GROUP_ALERT_CHILDREN = 2;
    public static final int GROUP_ALERT_SUMMARY = 1;
    public static final String GROUP_KEY_SILENT = "silent";
    public static final String INTENT_CATEGORY_NOTIFICATION_PREFERENCES = "android.intent.category.NOTIFICATION_PREFERENCES";
    public static final int MAX_ACTION_BUTTONS = 3;
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = -2;
    public static final int STREAM_DEFAULT = -1;
    private static final String TAG = "NotifCompat";
    public static final int VISIBILITY_PRIVATE = 0;
    public static final int VISIBILITY_PUBLIC = 1;
    public static final int VISIBILITY_SECRET = -1;

    @Deprecated
    public NotificationCompat() {
    }

    public static Action getAction(Notification notification, int n) {
        return NotificationCompat.getActionCompatFromAction(notification.actions[n]);
    }

    static Action getActionCompatFromAction(Notification.Action action) {
        boolean bl;
        int n;
        Object object;
        RemoteInput[] remoteInputArray;
        android.app.RemoteInput[] remoteInputArray2 = Api20Impl.getRemoteInputs(action);
        boolean bl2 = false;
        if (remoteInputArray2 == null) {
            remoteInputArray = null;
        } else {
            object = new RemoteInput[remoteInputArray2.length];
            n = 0;
            while (true) {
                remoteInputArray = object;
                if (n >= remoteInputArray2.length) break;
                android.app.RemoteInput remoteInput = remoteInputArray2[n];
                String string2 = Api20Impl.getResultKey(remoteInput);
                remoteInputArray = Api20Impl.getLabel(remoteInput);
                CharSequence[] charSequenceArray = Api20Impl.getChoices(remoteInput);
                bl = Api20Impl.getAllowFreeFormInput(remoteInput);
                int n2 = Build.VERSION.SDK_INT >= 29 ? Api29Impl.getEditChoicesBeforeSending(remoteInput) : 0;
                object[n] = new RemoteInput(string2, (CharSequence)remoteInputArray, charSequenceArray, bl, n2, Api20Impl.getExtras(remoteInput), null);
                ++n;
            }
        }
        bl = Api20Impl.getExtras(action).getBoolean("android.support.allowGeneratedReplies") || Api24Impl.getAllowGeneratedReplies(action);
        boolean bl3 = Api20Impl.getExtras(action).getBoolean("android.support.action.showsUserInterface", true);
        n = Build.VERSION.SDK_INT >= 28 ? Api28Impl.getSemanticAction(action) : Api20Impl.getExtras(action).getInt("android.support.action.semanticAction", 0);
        boolean bl4 = Build.VERSION.SDK_INT >= 29 ? Api29Impl.isContextual(action) : false;
        if (Build.VERSION.SDK_INT >= 31) {
            bl2 = Api31Impl.isAuthenticationRequired(action);
        }
        if (Api23Impl.getIcon(action) == null && action.icon != 0) {
            return new Action(action.icon, action.title, action.actionIntent, Api20Impl.getExtras(action), remoteInputArray, null, bl, n, bl3, bl4, bl2);
        }
        object = Api23Impl.getIcon(action) == null ? null : IconCompat.createFromIconOrNullIfZeroResId(Api23Impl.getIcon(action));
        return new Action((IconCompat)object, action.title, action.actionIntent, Api20Impl.getExtras(action), remoteInputArray, null, bl, n, bl3, bl4, bl2);
    }

    public static int getActionCount(Notification notification) {
        int n = notification.actions != null ? notification.actions.length : 0;
        return n;
    }

    public static boolean getAllowSystemGeneratedContextualActions(Notification notification) {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.getAllowSystemGeneratedContextualActions(notification);
        }
        return false;
    }

    public static boolean getAutoCancel(Notification notification) {
        boolean bl = (notification.flags & 0x10) != 0;
        return bl;
    }

    public static int getBadgeIconType(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getBadgeIconType(notification);
        }
        return 0;
    }

    public static BubbleMetadata getBubbleMetadata(Notification notification) {
        if (Build.VERSION.SDK_INT >= 29) {
            return BubbleMetadata.fromPlatform(Api29Impl.getBubbleMetadata(notification));
        }
        return null;
    }

    public static String getCategory(Notification notification) {
        return notification.category;
    }

    public static String getChannelId(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getChannelId(notification);
        }
        return null;
    }

    public static int getColor(Notification notification) {
        return notification.color;
    }

    public static CharSequence getContentInfo(Notification notification) {
        return notification.extras.getCharSequence(EXTRA_INFO_TEXT);
    }

    public static CharSequence getContentText(Notification notification) {
        return notification.extras.getCharSequence(EXTRA_TEXT);
    }

    public static CharSequence getContentTitle(Notification notification) {
        return notification.extras.getCharSequence(EXTRA_TITLE);
    }

    public static Bundle getExtras(Notification notification) {
        return notification.extras;
    }

    public static String getGroup(Notification notification) {
        return Api20Impl.getGroup(notification);
    }

    public static int getGroupAlertBehavior(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getGroupAlertBehavior(notification);
        }
        return 0;
    }

    static boolean getHighPriority(Notification notification) {
        boolean bl = (notification.flags & 0x80) != 0;
        return bl;
    }

    public static List<Action> getInvisibleActions(Notification notification) {
        ArrayList<Action> arrayList = new ArrayList<Action>();
        notification = notification.extras.getBundle("android.car.EXTENSIONS");
        if (notification == null) {
            return arrayList;
        }
        if ((notification = notification.getBundle("invisible_actions")) != null) {
            for (int i = 0; i < notification.size(); ++i) {
                arrayList.add(NotificationCompatJellybean.getActionFromBundle(notification.getBundle(Integer.toString(i))));
            }
        }
        return arrayList;
    }

    public static boolean getLocalOnly(Notification notification) {
        boolean bl = (notification.flags & 0x100) != 0;
        return bl;
    }

    public static LocusIdCompat getLocusId(Notification object) {
        int n = Build.VERSION.SDK_INT;
        Object var2_2 = null;
        if (n >= 29) {
            object = (object = Api29Impl.getLocusId(object)) == null ? var2_2 : LocusIdCompat.toLocusIdCompat((LocusId)object);
            return object;
        }
        return null;
    }

    static Notification[] getNotificationArrayFromBundle(Bundle bundle, String string2) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(string2);
        if (!(parcelableArray instanceof Notification[]) && parcelableArray != null) {
            Notification[] notificationArray = new Notification[parcelableArray.length];
            for (int i = 0; i < parcelableArray.length; ++i) {
                notificationArray[i] = (Notification)parcelableArray[i];
            }
            bundle.putParcelableArray(string2, (Parcelable[])notificationArray);
            return notificationArray;
        }
        return (Notification[])parcelableArray;
    }

    public static boolean getOngoing(Notification notification) {
        boolean bl = (notification.flags & 2) != 0;
        return bl;
    }

    public static boolean getOnlyAlertOnce(Notification notification) {
        boolean bl = (notification.flags & 8) != 0;
        return bl;
    }

    public static List<Person> getPeople(Notification object) {
        ArrayList<Person> arrayList;
        block4: {
            block3: {
                arrayList = new ArrayList<Person>();
                if (Build.VERSION.SDK_INT < 28) break block3;
                object = ((Notification)object).extras.getParcelableArrayList(EXTRA_PEOPLE_LIST);
                if (object == null || ((ArrayList)object).isEmpty()) break block4;
                object = ((ArrayList)object).iterator();
                while (object.hasNext()) {
                    arrayList.add(Person.fromAndroidPerson((android.app.Person)object.next()));
                }
                break block4;
            }
            object = ((Notification)object).extras.getStringArray(EXTRA_PEOPLE);
            if (object != null && ((String[])object).length != 0) {
                for (Object object2 : object) {
                    arrayList.add(new Person.Builder().setUri((String)object2).build());
                }
            }
        }
        return arrayList;
    }

    public static Notification getPublicVersion(Notification notification) {
        return notification.publicVersion;
    }

    public static CharSequence getSettingsText(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getSettingsText(notification);
        }
        return null;
    }

    public static String getShortcutId(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getShortcutId(notification);
        }
        return null;
    }

    public static boolean getShowWhen(Notification notification) {
        return notification.extras.getBoolean(EXTRA_SHOW_WHEN);
    }

    public static String getSortKey(Notification notification) {
        return Api20Impl.getSortKey(notification);
    }

    public static CharSequence getSubText(Notification notification) {
        return notification.extras.getCharSequence(EXTRA_SUB_TEXT);
    }

    public static long getTimeoutAfter(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getTimeoutAfter(notification);
        }
        return 0L;
    }

    public static boolean getUsesChronometer(Notification notification) {
        return notification.extras.getBoolean(EXTRA_SHOW_CHRONOMETER);
    }

    public static int getVisibility(Notification notification) {
        return notification.visibility;
    }

    public static boolean isGroupSummary(Notification notification) {
        boolean bl = (notification.flags & 0x200) != 0;
        return bl;
    }

    public static Bitmap reduceLargeIconSize(Context context, Bitmap bitmap) {
        if (bitmap != null && Build.VERSION.SDK_INT < 27) {
            context = context.getResources();
            int n = context.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
            int n2 = context.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
            if (bitmap.getWidth() <= n && bitmap.getHeight() <= n2) {
                return bitmap;
            }
            double d = Math.min((double)n / (double)Math.max(1, bitmap.getWidth()), (double)n2 / (double)Math.max(1, bitmap.getHeight()));
            return Bitmap.createScaledBitmap((Bitmap)bitmap, (int)((int)Math.ceil((double)bitmap.getWidth() * d)), (int)((int)Math.ceil((double)bitmap.getHeight() * d)), (boolean)true);
        }
        return bitmap;
    }

    public static class Action {
        static final String EXTRA_SEMANTIC_ACTION = "android.support.action.semanticAction";
        static final String EXTRA_SHOWS_USER_INTERFACE = "android.support.action.showsUserInterface";
        public static final int SEMANTIC_ACTION_ARCHIVE = 5;
        public static final int SEMANTIC_ACTION_CALL = 10;
        public static final int SEMANTIC_ACTION_DELETE = 4;
        public static final int SEMANTIC_ACTION_MARK_AS_READ = 2;
        public static final int SEMANTIC_ACTION_MARK_AS_UNREAD = 3;
        public static final int SEMANTIC_ACTION_MUTE = 6;
        public static final int SEMANTIC_ACTION_NONE = 0;
        public static final int SEMANTIC_ACTION_REPLY = 1;
        public static final int SEMANTIC_ACTION_THUMBS_DOWN = 9;
        public static final int SEMANTIC_ACTION_THUMBS_UP = 8;
        public static final int SEMANTIC_ACTION_UNMUTE = 7;
        public PendingIntent actionIntent;
        @Deprecated
        public int icon;
        private boolean mAllowGeneratedReplies;
        private boolean mAuthenticationRequired;
        private final RemoteInput[] mDataOnlyRemoteInputs;
        final Bundle mExtras;
        private IconCompat mIcon;
        private final boolean mIsContextual;
        private final RemoteInput[] mRemoteInputs;
        private final int mSemanticAction;
        boolean mShowsUserInterface;
        public CharSequence title;

        public Action(int n, CharSequence charSequence, PendingIntent pendingIntent) {
            IconCompat iconCompat = null;
            if (n != 0) {
                iconCompat = IconCompat.createWithResource(null, "", n);
            }
            this(iconCompat, charSequence, pendingIntent);
        }

        Action(int n, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArray, RemoteInput[] remoteInputArray2, boolean bl, int n2, boolean bl2, boolean bl3, boolean bl4) {
            IconCompat iconCompat = null;
            if (n != 0) {
                iconCompat = IconCompat.createWithResource(null, "", n);
            }
            this(iconCompat, charSequence, pendingIntent, bundle, remoteInputArray, remoteInputArray2, bl, n2, bl2, bl3, bl4);
        }

        public Action(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false, false);
        }

        Action(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArray, RemoteInput[] remoteInputArray2, boolean bl, int n, boolean bl2, boolean bl3, boolean bl4) {
            this.mShowsUserInterface = true;
            this.mIcon = iconCompat;
            if (iconCompat != null && iconCompat.getType() == 2) {
                this.icon = iconCompat.getResId();
            }
            this.title = androidx.core.app.NotificationCompat$Builder.limitCharSequenceLength(charSequence);
            this.actionIntent = pendingIntent;
            iconCompat = bundle != null ? bundle : new Bundle();
            this.mExtras = iconCompat;
            this.mRemoteInputs = remoteInputArray;
            this.mDataOnlyRemoteInputs = remoteInputArray2;
            this.mAllowGeneratedReplies = bl;
            this.mSemanticAction = n;
            this.mShowsUserInterface = bl2;
            this.mIsContextual = bl3;
            this.mAuthenticationRequired = bl4;
        }

        public PendingIntent getActionIntent() {
            return this.actionIntent;
        }

        public boolean getAllowGeneratedReplies() {
            return this.mAllowGeneratedReplies;
        }

        public RemoteInput[] getDataOnlyRemoteInputs() {
            return this.mDataOnlyRemoteInputs;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        @Deprecated
        public int getIcon() {
            return this.icon;
        }

        public IconCompat getIconCompat() {
            if (this.mIcon == null && this.icon != 0) {
                this.mIcon = IconCompat.createWithResource(null, "", this.icon);
            }
            return this.mIcon;
        }

        public RemoteInput[] getRemoteInputs() {
            return this.mRemoteInputs;
        }

        public int getSemanticAction() {
            return this.mSemanticAction;
        }

        public boolean getShowsUserInterface() {
            return this.mShowsUserInterface;
        }

        public CharSequence getTitle() {
            return this.title;
        }

        public boolean isAuthenticationRequired() {
            return this.mAuthenticationRequired;
        }

        public boolean isContextual() {
            return this.mIsContextual;
        }

        public static final class Builder {
            private boolean mAllowGeneratedReplies;
            private boolean mAuthenticationRequired;
            private final Bundle mExtras;
            private final IconCompat mIcon;
            private final PendingIntent mIntent;
            private boolean mIsContextual;
            private ArrayList<RemoteInput> mRemoteInputs;
            private int mSemanticAction;
            private boolean mShowsUserInterface;
            private final CharSequence mTitle;

            public Builder(int n, CharSequence charSequence, PendingIntent pendingIntent) {
                IconCompat iconCompat = null;
                if (n != 0) {
                    iconCompat = IconCompat.createWithResource(null, "", n);
                }
                this(iconCompat, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false, false);
            }

            public Builder(Action action) {
                this(action.getIconCompat(), action.title, action.actionIntent, new Bundle(action.mExtras), action.getRemoteInputs(), action.getAllowGeneratedReplies(), action.getSemanticAction(), action.mShowsUserInterface, action.isContextual(), action.isAuthenticationRequired());
            }

            public Builder(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
                this(iconCompat, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false, false);
            }

            private Builder(IconCompat object, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArray, boolean bl, int n, boolean bl2, boolean bl3, boolean bl4) {
                this.mAllowGeneratedReplies = true;
                this.mShowsUserInterface = true;
                this.mIcon = object;
                this.mTitle = androidx.core.app.NotificationCompat$Builder.limitCharSequenceLength(charSequence);
                this.mIntent = pendingIntent;
                this.mExtras = bundle;
                object = remoteInputArray == null ? null : new ArrayList<RemoteInput>(Arrays.asList(remoteInputArray));
                this.mRemoteInputs = object;
                this.mAllowGeneratedReplies = bl;
                this.mSemanticAction = n;
                this.mShowsUserInterface = bl2;
                this.mIsContextual = bl3;
                this.mAuthenticationRequired = bl4;
            }

            private void checkContextualActionNullFields() {
                if (!this.mIsContextual) {
                    return;
                }
                if (this.mIntent != null) {
                    return;
                }
                throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
            }

            public static Builder fromAndroidAction(Notification.Action action) {
                Builder builder = Api23Impl.getIcon(action) != null ? new Builder(IconCompat.createFromIconOrNullIfZeroResId(Api23Impl.getIcon(action)), action.title, action.actionIntent) : new Builder(action.icon, action.title, action.actionIntent);
                android.app.RemoteInput[] remoteInputArray = Api20Impl.getRemoteInputs(action);
                if (remoteInputArray != null && remoteInputArray.length != 0) {
                    int n = remoteInputArray.length;
                    for (int i = 0; i < n; ++i) {
                        builder.addRemoteInput(RemoteInput.fromPlatform(remoteInputArray[i]));
                    }
                }
                builder.mAllowGeneratedReplies = Api24Impl.getAllowGeneratedReplies(action);
                if (Build.VERSION.SDK_INT >= 28) {
                    builder.setSemanticAction(Api28Impl.getSemanticAction(action));
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    builder.setContextual(Api29Impl.isContextual(action));
                }
                if (Build.VERSION.SDK_INT >= 31) {
                    builder.setAuthenticationRequired(Api31Impl.isAuthenticationRequired(action));
                }
                builder.addExtras(Api20Impl.getExtras(action));
                return builder;
            }

            public Builder addExtras(Bundle bundle) {
                if (bundle != null) {
                    this.mExtras.putAll(bundle);
                }
                return this;
            }

            public Builder addRemoteInput(RemoteInput remoteInput) {
                if (this.mRemoteInputs == null) {
                    this.mRemoteInputs = new ArrayList();
                }
                if (remoteInput != null) {
                    this.mRemoteInputs.add(remoteInput);
                }
                return this;
            }

            public Action build() {
                this.checkContextualActionNullFields();
                Object object = new ArrayList();
                ArrayList<RemoteInput> arrayList = new ArrayList<RemoteInput>();
                if (this.mRemoteInputs != null) {
                    for (RemoteInput remoteInput : this.mRemoteInputs) {
                        if (remoteInput.isDataOnly()) {
                            object.add(remoteInput);
                            continue;
                        }
                        arrayList.add(remoteInput);
                    }
                }
                boolean bl = object.isEmpty();
                RemoteInput[] remoteInputArray = null;
                object = bl ? null : object.toArray(new RemoteInput[object.size()]);
                if (!arrayList.isEmpty()) {
                    remoteInputArray = arrayList.toArray(new RemoteInput[arrayList.size()]);
                }
                return new Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, remoteInputArray, (RemoteInput[])object, this.mAllowGeneratedReplies, this.mSemanticAction, this.mShowsUserInterface, this.mIsContextual, this.mAuthenticationRequired);
            }

            public Builder extend(Extender extender) {
                extender.extend(this);
                return this;
            }

            public Bundle getExtras() {
                return this.mExtras;
            }

            public Builder setAllowGeneratedReplies(boolean bl) {
                this.mAllowGeneratedReplies = bl;
                return this;
            }

            public Builder setAuthenticationRequired(boolean bl) {
                this.mAuthenticationRequired = bl;
                return this;
            }

            public Builder setContextual(boolean bl) {
                this.mIsContextual = bl;
                return this;
            }

            public Builder setSemanticAction(int n) {
                this.mSemanticAction = n;
                return this;
            }

            public Builder setShowsUserInterface(boolean bl) {
                this.mShowsUserInterface = bl;
                return this;
            }

            static class Api20Impl {
                private Api20Impl() {
                }

                static Bundle getExtras(Notification.Action action) {
                    return action.getExtras();
                }

                static android.app.RemoteInput[] getRemoteInputs(Notification.Action action) {
                    return action.getRemoteInputs();
                }
            }

            static class Api23Impl {
                private Api23Impl() {
                }

                static Icon getIcon(Notification.Action action) {
                    return action.getIcon();
                }
            }

            static class Api24Impl {
                private Api24Impl() {
                }

                static boolean getAllowGeneratedReplies(Notification.Action action) {
                    return action.getAllowGeneratedReplies();
                }
            }

            static class Api28Impl {
                private Api28Impl() {
                }

                static int getSemanticAction(Notification.Action action) {
                    return action.getSemanticAction();
                }
            }

            static class Api29Impl {
                private Api29Impl() {
                }

                static boolean isContextual(Notification.Action action) {
                    return action.isContextual();
                }
            }

            static class Api31Impl {
                private Api31Impl() {
                }

                static boolean isAuthenticationRequired(Notification.Action action) {
                    return action.isAuthenticationRequired();
                }
            }
        }

        public static interface Extender {
            public Builder extend(Builder var1);
        }

        @Retention(value=RetentionPolicy.SOURCE)
        public static @interface SemanticAction {
        }

        public static final class WearableExtender
        implements Extender {
            private static final int DEFAULT_FLAGS = 1;
            private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
            private static final int FLAG_AVAILABLE_OFFLINE = 1;
            private static final int FLAG_HINT_DISPLAY_INLINE = 4;
            private static final int FLAG_HINT_LAUNCHES_ACTIVITY = 2;
            private static final String KEY_CANCEL_LABEL = "cancelLabel";
            private static final String KEY_CONFIRM_LABEL = "confirmLabel";
            private static final String KEY_FLAGS = "flags";
            private static final String KEY_IN_PROGRESS_LABEL = "inProgressLabel";
            private CharSequence mCancelLabel;
            private CharSequence mConfirmLabel;
            private int mFlags = 1;
            private CharSequence mInProgressLabel;

            public WearableExtender() {
            }

            public WearableExtender(Action action) {
                action = action.getExtras().getBundle(EXTRA_WEARABLE_EXTENSIONS);
                if (action != null) {
                    this.mFlags = action.getInt(KEY_FLAGS, 1);
                    this.mInProgressLabel = action.getCharSequence(KEY_IN_PROGRESS_LABEL);
                    this.mConfirmLabel = action.getCharSequence(KEY_CONFIRM_LABEL);
                    this.mCancelLabel = action.getCharSequence(KEY_CANCEL_LABEL);
                }
            }

            private void setFlag(int n, boolean bl) {
                this.mFlags = bl ? (this.mFlags |= n) : (this.mFlags &= ~n);
            }

            public WearableExtender clone() {
                WearableExtender wearableExtender = new WearableExtender();
                wearableExtender.mFlags = this.mFlags;
                wearableExtender.mInProgressLabel = this.mInProgressLabel;
                wearableExtender.mConfirmLabel = this.mConfirmLabel;
                wearableExtender.mCancelLabel = this.mCancelLabel;
                return wearableExtender;
            }

            @Override
            public Builder extend(Builder builder) {
                Bundle bundle = new Bundle();
                if (this.mFlags != 1) {
                    bundle.putInt(KEY_FLAGS, this.mFlags);
                }
                if (this.mInProgressLabel != null) {
                    bundle.putCharSequence(KEY_IN_PROGRESS_LABEL, this.mInProgressLabel);
                }
                if (this.mConfirmLabel != null) {
                    bundle.putCharSequence(KEY_CONFIRM_LABEL, this.mConfirmLabel);
                }
                if (this.mCancelLabel != null) {
                    bundle.putCharSequence(KEY_CANCEL_LABEL, this.mCancelLabel);
                }
                builder.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, bundle);
                return builder;
            }

            @Deprecated
            public CharSequence getCancelLabel() {
                return this.mCancelLabel;
            }

            @Deprecated
            public CharSequence getConfirmLabel() {
                return this.mConfirmLabel;
            }

            public boolean getHintDisplayActionInline() {
                boolean bl = (this.mFlags & 4) != 0;
                return bl;
            }

            public boolean getHintLaunchesActivity() {
                boolean bl = (this.mFlags & 2) != 0;
                return bl;
            }

            @Deprecated
            public CharSequence getInProgressLabel() {
                return this.mInProgressLabel;
            }

            public boolean isAvailableOffline() {
                int n = this.mFlags;
                boolean bl = true;
                if ((n & 1) == 0) {
                    bl = false;
                }
                return bl;
            }

            public WearableExtender setAvailableOffline(boolean bl) {
                this.setFlag(1, bl);
                return this;
            }

            @Deprecated
            public WearableExtender setCancelLabel(CharSequence charSequence) {
                this.mCancelLabel = charSequence;
                return this;
            }

            @Deprecated
            public WearableExtender setConfirmLabel(CharSequence charSequence) {
                this.mConfirmLabel = charSequence;
                return this;
            }

            public WearableExtender setHintDisplayActionInline(boolean bl) {
                this.setFlag(4, bl);
                return this;
            }

            public WearableExtender setHintLaunchesActivity(boolean bl) {
                this.setFlag(2, bl);
                return this;
            }

            @Deprecated
            public WearableExtender setInProgressLabel(CharSequence charSequence) {
                this.mInProgressLabel = charSequence;
                return this;
            }
        }
    }

    static class Api20Impl {
        private Api20Impl() {
        }

        static boolean getAllowFreeFormInput(android.app.RemoteInput remoteInput) {
            return remoteInput.getAllowFreeFormInput();
        }

        static CharSequence[] getChoices(android.app.RemoteInput remoteInput) {
            return remoteInput.getChoices();
        }

        static Bundle getExtras(Notification.Action action) {
            return action.getExtras();
        }

        static Bundle getExtras(android.app.RemoteInput remoteInput) {
            return remoteInput.getExtras();
        }

        static String getGroup(Notification notification) {
            return notification.getGroup();
        }

        static CharSequence getLabel(android.app.RemoteInput remoteInput) {
            return remoteInput.getLabel();
        }

        static android.app.RemoteInput[] getRemoteInputs(Notification.Action action) {
            return action.getRemoteInputs();
        }

        static String getResultKey(android.app.RemoteInput remoteInput) {
            return remoteInput.getResultKey();
        }

        static String getSortKey(Notification notification) {
            return notification.getSortKey();
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static Icon getIcon(Notification.Action action) {
            return action.getIcon();
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static boolean getAllowGeneratedReplies(Notification.Action action) {
            return action.getAllowGeneratedReplies();
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static int getBadgeIconType(Notification notification) {
            return notification.getBadgeIconType();
        }

        static String getChannelId(Notification notification) {
            return notification.getChannelId();
        }

        static int getGroupAlertBehavior(Notification notification) {
            return notification.getGroupAlertBehavior();
        }

        static CharSequence getSettingsText(Notification notification) {
            return notification.getSettingsText();
        }

        static String getShortcutId(Notification notification) {
            return notification.getShortcutId();
        }

        static long getTimeoutAfter(Notification notification) {
            return notification.getTimeoutAfter();
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static int getSemanticAction(Notification.Action action) {
            return action.getSemanticAction();
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static boolean getAllowSystemGeneratedContextualActions(Notification notification) {
            return notification.getAllowSystemGeneratedContextualActions();
        }

        static Notification.BubbleMetadata getBubbleMetadata(Notification notification) {
            return notification.getBubbleMetadata();
        }

        static int getEditChoicesBeforeSending(android.app.RemoteInput remoteInput) {
            return remoteInput.getEditChoicesBeforeSending();
        }

        static LocusId getLocusId(Notification notification) {
            return notification.getLocusId();
        }

        static boolean isContextual(Notification.Action action) {
            return action.isContextual();
        }
    }

    static class Api31Impl {
        private Api31Impl() {
        }

        static boolean isAuthenticationRequired(Notification.Action action) {
            return action.isAuthenticationRequired();
        }
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface BadgeIconType {
    }

    public static class BigPictureStyle
    extends Style {
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$BigPictureStyle";
        private IconCompat mBigLargeIcon;
        private boolean mBigLargeIconSet;
        private CharSequence mPictureContentDescription;
        private IconCompat mPictureIcon;
        private boolean mShowBigPictureWhenCollapsed;

        public BigPictureStyle() {
        }

        public BigPictureStyle(Builder builder) {
            this.setBuilder(builder);
        }

        private static IconCompat asIconCompat(Parcelable parcelable) {
            if (parcelable != null) {
                if (parcelable instanceof Icon) {
                    return IconCompat.createFromIcon((Icon)parcelable);
                }
                if (parcelable instanceof Bitmap) {
                    return IconCompat.createWithBitmap((Bitmap)parcelable);
                }
            }
            return null;
        }

        public static IconCompat getPictureIcon(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            Parcelable parcelable = bundle.getParcelable(NotificationCompat.EXTRA_PICTURE);
            if (parcelable != null) {
                return BigPictureStyle.asIconCompat(parcelable);
            }
            return BigPictureStyle.asIconCompat(bundle.getParcelable(NotificationCompat.EXTRA_PICTURE_ICON));
        }

        /*
         * Unable to fully structure code
         */
        @Override
        public void apply(NotificationBuilderWithBuilderAccessor var1_1) {
            block9: {
                block10: {
                    var2_3 = var3_2 = new Notification.BigPictureStyle(var1_1.getBuilder()).setBigContentTitle(this.mBigContentTitle);
                    if (this.mPictureIcon == null) break block9;
                    if (Build.VERSION.SDK_INT < 31) break block10;
                    var2_3 = null;
                    if (var1_1 instanceof NotificationCompatBuilder) {
                        var2_3 = ((NotificationCompatBuilder)var1_1).getContext();
                    }
                    Api31Impl.setBigPicture(var3_2, this.mPictureIcon.toIcon((Context)var2_3));
                    ** GOTO lbl-1000
                }
                if (this.mPictureIcon.getType() == 1) {
                    var2_3 = var3_2.bigPicture(this.mPictureIcon.getBitmap());
                } else lbl-1000:
                // 2 sources

                {
                    var2_3 = var3_2;
                }
            }
            if (this.mBigLargeIconSet) {
                if (this.mBigLargeIcon == null) {
                    var1_1 = null;
                    var2_3.bigLargeIcon(null);
                } else {
                    var3_2 = null;
                    if (var1_1 instanceof NotificationCompatBuilder) {
                        var3_2 = ((NotificationCompatBuilder)var1_1).getContext();
                    }
                    Api23Impl.setBigLargeIcon(var2_3, this.mBigLargeIcon.toIcon((Context)var3_2));
                }
            }
            if (this.mSummaryTextSet) {
                var2_3.setSummaryText(this.mSummaryText);
            }
            if (Build.VERSION.SDK_INT >= 31) {
                Api31Impl.showBigPictureWhenCollapsed(var2_3, this.mShowBigPictureWhenCollapsed);
                Api31Impl.setContentDescription(var2_3, this.mPictureContentDescription);
            }
        }

        public BigPictureStyle bigLargeIcon(Bitmap object) {
            object = object == null ? null : IconCompat.createWithBitmap(object);
            this.mBigLargeIcon = object;
            this.mBigLargeIconSet = true;
            return this;
        }

        public BigPictureStyle bigLargeIcon(Icon object) {
            object = object == null ? null : IconCompat.createFromIcon(object);
            this.mBigLargeIcon = object;
            this.mBigLargeIconSet = true;
            return this;
        }

        public BigPictureStyle bigPicture(Bitmap object) {
            object = object == null ? null : IconCompat.createWithBitmap(object);
            this.mPictureIcon = object;
            return this;
        }

        public BigPictureStyle bigPicture(Icon icon) {
            this.mPictureIcon = IconCompat.createFromIcon(icon);
            return this;
        }

        @Override
        protected void clearCompatExtraKeys(Bundle bundle) {
            super.clearCompatExtraKeys(bundle);
            bundle.remove(NotificationCompat.EXTRA_LARGE_ICON_BIG);
            bundle.remove(NotificationCompat.EXTRA_PICTURE);
            bundle.remove(NotificationCompat.EXTRA_PICTURE_ICON);
            bundle.remove(NotificationCompat.EXTRA_SHOW_BIG_PICTURE_WHEN_COLLAPSED);
        }

        @Override
        protected String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Override
        protected void restoreFromCompatExtras(Bundle bundle) {
            super.restoreFromCompatExtras(bundle);
            if (bundle.containsKey(NotificationCompat.EXTRA_LARGE_ICON_BIG)) {
                this.mBigLargeIcon = BigPictureStyle.asIconCompat(bundle.getParcelable(NotificationCompat.EXTRA_LARGE_ICON_BIG));
                this.mBigLargeIconSet = true;
            }
            this.mPictureIcon = BigPictureStyle.getPictureIcon(bundle);
            this.mShowBigPictureWhenCollapsed = bundle.getBoolean(NotificationCompat.EXTRA_SHOW_BIG_PICTURE_WHEN_COLLAPSED);
        }

        public BigPictureStyle setBigContentTitle(CharSequence charSequence) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        public BigPictureStyle setContentDescription(CharSequence charSequence) {
            this.mPictureContentDescription = charSequence;
            return this;
        }

        public BigPictureStyle setSummaryText(CharSequence charSequence) {
            this.mSummaryText = Builder.limitCharSequenceLength(charSequence);
            this.mSummaryTextSet = true;
            return this;
        }

        public BigPictureStyle showBigPictureWhenCollapsed(boolean bl) {
            this.mShowBigPictureWhenCollapsed = bl;
            return this;
        }

        private static class Api23Impl {
            private Api23Impl() {
            }

            static void setBigLargeIcon(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigLargeIcon(icon);
            }
        }

        private static class Api31Impl {
            private Api31Impl() {
            }

            static void setBigPicture(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigPicture(icon);
            }

            static void setContentDescription(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setContentDescription(charSequence);
            }

            static void showBigPictureWhenCollapsed(Notification.BigPictureStyle bigPictureStyle, boolean bl) {
                bigPictureStyle.showBigPictureWhenCollapsed(bl);
            }
        }
    }

    public static class BigTextStyle
    extends Style {
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$BigTextStyle";
        private CharSequence mBigText;

        public BigTextStyle() {
        }

        public BigTextStyle(Builder builder) {
            this.setBuilder(builder);
        }

        @Override
        public void addCompatExtras(Bundle bundle) {
            super.addCompatExtras(bundle);
        }

        @Override
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            notificationBuilderWithBuilderAccessor = new Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.mBigContentTitle).bigText(this.mBigText);
            if (this.mSummaryTextSet) {
                notificationBuilderWithBuilderAccessor.setSummaryText(this.mSummaryText);
            }
        }

        public BigTextStyle bigText(CharSequence charSequence) {
            this.mBigText = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        @Override
        protected void clearCompatExtraKeys(Bundle bundle) {
            super.clearCompatExtraKeys(bundle);
            bundle.remove(NotificationCompat.EXTRA_BIG_TEXT);
        }

        @Override
        protected String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Override
        protected void restoreFromCompatExtras(Bundle bundle) {
            super.restoreFromCompatExtras(bundle);
            this.mBigText = bundle.getCharSequence(NotificationCompat.EXTRA_BIG_TEXT);
        }

        public BigTextStyle setBigContentTitle(CharSequence charSequence) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        public BigTextStyle setSummaryText(CharSequence charSequence) {
            this.mSummaryText = Builder.limitCharSequenceLength(charSequence);
            this.mSummaryTextSet = true;
            return this;
        }
    }

    public static final class BubbleMetadata {
        private static final int FLAG_AUTO_EXPAND_BUBBLE = 1;
        private static final int FLAG_SUPPRESS_NOTIFICATION = 2;
        private PendingIntent mDeleteIntent;
        private int mDesiredHeight;
        private int mDesiredHeightResId;
        private int mFlags;
        private IconCompat mIcon;
        private PendingIntent mPendingIntent;
        private String mShortcutId;

        private BubbleMetadata(PendingIntent pendingIntent, PendingIntent pendingIntent2, IconCompat iconCompat, int n, int n2, int n3, String string2) {
            this.mPendingIntent = pendingIntent;
            this.mIcon = iconCompat;
            this.mDesiredHeight = n;
            this.mDesiredHeightResId = n2;
            this.mDeleteIntent = pendingIntent2;
            this.mFlags = n3;
            this.mShortcutId = string2;
        }

        public static BubbleMetadata fromPlatform(Notification.BubbleMetadata bubbleMetadata) {
            if (bubbleMetadata == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                return Api30Impl.fromPlatform(bubbleMetadata);
            }
            if (Build.VERSION.SDK_INT == 29) {
                return Api29Impl.fromPlatform(bubbleMetadata);
            }
            return null;
        }

        public static Notification.BubbleMetadata toPlatform(BubbleMetadata bubbleMetadata) {
            if (bubbleMetadata == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                return Api30Impl.toPlatform(bubbleMetadata);
            }
            if (Build.VERSION.SDK_INT == 29) {
                return Api29Impl.toPlatform(bubbleMetadata);
            }
            return null;
        }

        public boolean getAutoExpandBubble() {
            int n = this.mFlags;
            boolean bl = true;
            if ((n & 1) == 0) {
                bl = false;
            }
            return bl;
        }

        public PendingIntent getDeleteIntent() {
            return this.mDeleteIntent;
        }

        public int getDesiredHeight() {
            return this.mDesiredHeight;
        }

        public int getDesiredHeightResId() {
            return this.mDesiredHeightResId;
        }

        public IconCompat getIcon() {
            return this.mIcon;
        }

        public PendingIntent getIntent() {
            return this.mPendingIntent;
        }

        public String getShortcutId() {
            return this.mShortcutId;
        }

        public boolean isNotificationSuppressed() {
            boolean bl = (this.mFlags & 2) != 0;
            return bl;
        }

        public void setFlags(int n) {
            this.mFlags = n;
        }

        private static class Api29Impl {
            private Api29Impl() {
            }

            static BubbleMetadata fromPlatform(Notification.BubbleMetadata bubbleMetadata) {
                if (bubbleMetadata == null) {
                    return null;
                }
                if (bubbleMetadata.getIntent() == null) {
                    return null;
                }
                Builder builder = new Builder(bubbleMetadata.getIntent(), IconCompat.createFromIcon(bubbleMetadata.getIcon())).setAutoExpandBubble(bubbleMetadata.getAutoExpandBubble()).setDeleteIntent(bubbleMetadata.getDeleteIntent()).setSuppressNotification(bubbleMetadata.isNotificationSuppressed());
                if (bubbleMetadata.getDesiredHeight() != 0) {
                    builder.setDesiredHeight(bubbleMetadata.getDesiredHeight());
                }
                if (bubbleMetadata.getDesiredHeightResId() != 0) {
                    builder.setDesiredHeightResId(bubbleMetadata.getDesiredHeightResId());
                }
                return builder.build();
            }

            static Notification.BubbleMetadata toPlatform(BubbleMetadata bubbleMetadata) {
                if (bubbleMetadata == null) {
                    return null;
                }
                if (bubbleMetadata.getIntent() == null) {
                    return null;
                }
                Notification.BubbleMetadata.Builder builder = new Notification.BubbleMetadata.Builder().setIcon(bubbleMetadata.getIcon().toIcon()).setIntent(bubbleMetadata.getIntent()).setDeleteIntent(bubbleMetadata.getDeleteIntent()).setAutoExpandBubble(bubbleMetadata.getAutoExpandBubble()).setSuppressNotification(bubbleMetadata.isNotificationSuppressed());
                if (bubbleMetadata.getDesiredHeight() != 0) {
                    builder.setDesiredHeight(bubbleMetadata.getDesiredHeight());
                }
                if (bubbleMetadata.getDesiredHeightResId() != 0) {
                    builder.setDesiredHeightResId(bubbleMetadata.getDesiredHeightResId());
                }
                return builder.build();
            }
        }

        private static class Api30Impl {
            private Api30Impl() {
            }

            static BubbleMetadata fromPlatform(Notification.BubbleMetadata bubbleMetadata) {
                if (bubbleMetadata == null) {
                    return null;
                }
                Builder builder = bubbleMetadata.getShortcutId() != null ? new Builder(bubbleMetadata.getShortcutId()) : new Builder(bubbleMetadata.getIntent(), IconCompat.createFromIcon(bubbleMetadata.getIcon()));
                builder.setAutoExpandBubble(bubbleMetadata.getAutoExpandBubble()).setDeleteIntent(bubbleMetadata.getDeleteIntent()).setSuppressNotification(bubbleMetadata.isNotificationSuppressed());
                if (bubbleMetadata.getDesiredHeight() != 0) {
                    builder.setDesiredHeight(bubbleMetadata.getDesiredHeight());
                }
                if (bubbleMetadata.getDesiredHeightResId() != 0) {
                    builder.setDesiredHeightResId(bubbleMetadata.getDesiredHeightResId());
                }
                return builder.build();
            }

            static Notification.BubbleMetadata toPlatform(BubbleMetadata bubbleMetadata) {
                if (bubbleMetadata == null) {
                    return null;
                }
                Notification.BubbleMetadata.Builder builder = bubbleMetadata.getShortcutId() != null ? new Notification.BubbleMetadata.Builder(bubbleMetadata.getShortcutId()) : new Notification.BubbleMetadata.Builder(bubbleMetadata.getIntent(), bubbleMetadata.getIcon().toIcon());
                builder.setDeleteIntent(bubbleMetadata.getDeleteIntent()).setAutoExpandBubble(bubbleMetadata.getAutoExpandBubble()).setSuppressNotification(bubbleMetadata.isNotificationSuppressed());
                if (bubbleMetadata.getDesiredHeight() != 0) {
                    builder.setDesiredHeight(bubbleMetadata.getDesiredHeight());
                }
                if (bubbleMetadata.getDesiredHeightResId() != 0) {
                    builder.setDesiredHeightResId(bubbleMetadata.getDesiredHeightResId());
                }
                return builder.build();
            }
        }

        public static final class Builder {
            private PendingIntent mDeleteIntent;
            private int mDesiredHeight;
            private int mDesiredHeightResId;
            private int mFlags;
            private IconCompat mIcon;
            private PendingIntent mPendingIntent;
            private String mShortcutId;

            @Deprecated
            public Builder() {
            }

            public Builder(PendingIntent pendingIntent, IconCompat iconCompat) {
                if (pendingIntent != null) {
                    if (iconCompat != null) {
                        this.mPendingIntent = pendingIntent;
                        this.mIcon = iconCompat;
                        return;
                    }
                    throw new NullPointerException("Bubbles require non-null icon");
                }
                throw new NullPointerException("Bubble requires non-null pending intent");
            }

            public Builder(String string2) {
                if (!TextUtils.isEmpty((CharSequence)string2)) {
                    this.mShortcutId = string2;
                    return;
                }
                throw new NullPointerException("Bubble requires a non-null shortcut id");
            }

            private Builder setFlag(int n, boolean bl) {
                this.mFlags = bl ? (this.mFlags |= n) : (this.mFlags &= ~n);
                return this;
            }

            public BubbleMetadata build() {
                if (this.mShortcutId == null && this.mPendingIntent == null) {
                    throw new NullPointerException("Must supply pending intent or shortcut to bubble");
                }
                if (this.mShortcutId == null && this.mIcon == null) {
                    throw new NullPointerException("Must supply an icon or shortcut for the bubble");
                }
                BubbleMetadata bubbleMetadata = new BubbleMetadata(this.mPendingIntent, this.mDeleteIntent, this.mIcon, this.mDesiredHeight, this.mDesiredHeightResId, this.mFlags, this.mShortcutId);
                bubbleMetadata.setFlags(this.mFlags);
                return bubbleMetadata;
            }

            public Builder setAutoExpandBubble(boolean bl) {
                this.setFlag(1, bl);
                return this;
            }

            public Builder setDeleteIntent(PendingIntent pendingIntent) {
                this.mDeleteIntent = pendingIntent;
                return this;
            }

            public Builder setDesiredHeight(int n) {
                this.mDesiredHeight = Math.max(n, 0);
                this.mDesiredHeightResId = 0;
                return this;
            }

            public Builder setDesiredHeightResId(int n) {
                this.mDesiredHeightResId = n;
                this.mDesiredHeight = 0;
                return this;
            }

            public Builder setIcon(IconCompat iconCompat) {
                if (this.mShortcutId == null) {
                    if (iconCompat != null) {
                        this.mIcon = iconCompat;
                        return this;
                    }
                    throw new NullPointerException("Bubbles require non-null icon");
                }
                throw new IllegalStateException("Created as a shortcut bubble, cannot set an Icon. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
            }

            public Builder setIntent(PendingIntent pendingIntent) {
                if (this.mShortcutId == null) {
                    if (pendingIntent != null) {
                        this.mPendingIntent = pendingIntent;
                        return this;
                    }
                    throw new NullPointerException("Bubble requires non-null pending intent");
                }
                throw new IllegalStateException("Created as a shortcut bubble, cannot set a PendingIntent. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
            }

            public Builder setSuppressNotification(boolean bl) {
                this.setFlag(2, bl);
                return this;
            }
        }
    }

    public static class Builder {
        private static final int MAX_CHARSEQUENCE_LENGTH = 5120;
        public ArrayList<Action> mActions;
        boolean mAllowSystemGeneratedContextualActions;
        int mBadgeIcon;
        RemoteViews mBigContentView;
        BubbleMetadata mBubbleMetadata;
        String mCategory;
        String mChannelId;
        boolean mChronometerCountDown;
        int mColor;
        boolean mColorized;
        boolean mColorizedSet;
        CharSequence mContentInfo;
        PendingIntent mContentIntent;
        CharSequence mContentText;
        CharSequence mContentTitle;
        RemoteViews mContentView;
        public Context mContext;
        Bundle mExtras;
        int mFgsDeferBehavior;
        PendingIntent mFullScreenIntent;
        int mGroupAlertBehavior;
        String mGroupKey;
        boolean mGroupSummary;
        RemoteViews mHeadsUpContentView;
        ArrayList<Action> mInvisibleActions;
        IconCompat mLargeIcon;
        boolean mLocalOnly;
        LocusIdCompat mLocusId;
        Notification mNotification;
        int mNumber;
        @Deprecated
        public ArrayList<String> mPeople;
        public ArrayList<Person> mPersonList;
        int mPriority;
        int mProgress;
        boolean mProgressIndeterminate;
        int mProgressMax;
        Notification mPublicVersion;
        CharSequence[] mRemoteInputHistory;
        CharSequence mSettingsText;
        String mShortcutId;
        boolean mShowWhen;
        boolean mSilent;
        Object mSmallIcon;
        String mSortKey;
        Style mStyle;
        CharSequence mSubText;
        RemoteViews mTickerView;
        long mTimeout;
        boolean mUseChronometer;
        int mVisibility;

        @Deprecated
        public Builder(Context context) {
            String string2 = null;
            this(context, (String)null);
        }

        public Builder(Context context, Notification object) {
            this(context, NotificationCompat.getChannelId((Notification)object));
            int n;
            int n2;
            context = ((Notification)object).extras;
            Object object2 = Style.extractStyleFromNotification((Notification)object);
            this.setContentTitle(NotificationCompat.getContentTitle((Notification)object)).setContentText(NotificationCompat.getContentText((Notification)object)).setContentInfo(NotificationCompat.getContentInfo((Notification)object)).setSubText(NotificationCompat.getSubText((Notification)object)).setSettingsText(NotificationCompat.getSettingsText((Notification)object)).setStyle((Style)object2).setGroup(NotificationCompat.getGroup((Notification)object)).setGroupSummary(NotificationCompat.isGroupSummary((Notification)object)).setLocusId(NotificationCompat.getLocusId((Notification)object)).setWhen(((Notification)object).when).setShowWhen(NotificationCompat.getShowWhen((Notification)object)).setUsesChronometer(NotificationCompat.getUsesChronometer((Notification)object)).setAutoCancel(NotificationCompat.getAutoCancel((Notification)object)).setOnlyAlertOnce(NotificationCompat.getOnlyAlertOnce((Notification)object)).setOngoing(NotificationCompat.getOngoing((Notification)object)).setLocalOnly(NotificationCompat.getLocalOnly((Notification)object)).setLargeIcon(((Notification)object).largeIcon).setBadgeIconType(NotificationCompat.getBadgeIconType((Notification)object)).setCategory(NotificationCompat.getCategory((Notification)object)).setBubbleMetadata(NotificationCompat.getBubbleMetadata((Notification)object)).setNumber(((Notification)object).number).setTicker(((Notification)object).tickerText).setContentIntent(((Notification)object).contentIntent).setDeleteIntent(((Notification)object).deleteIntent).setFullScreenIntent(((Notification)object).fullScreenIntent, NotificationCompat.getHighPriority((Notification)object)).setSound(((Notification)object).sound, ((Notification)object).audioStreamType).setVibrate(((Notification)object).vibrate).setLights(((Notification)object).ledARGB, ((Notification)object).ledOnMS, ((Notification)object).ledOffMS).setDefaults(((Notification)object).defaults).setPriority(((Notification)object).priority).setColor(NotificationCompat.getColor((Notification)object)).setVisibility(NotificationCompat.getVisibility((Notification)object)).setPublicVersion(NotificationCompat.getPublicVersion((Notification)object)).setSortKey(NotificationCompat.getSortKey((Notification)object)).setTimeoutAfter(NotificationCompat.getTimeoutAfter((Notification)object)).setShortcutId(NotificationCompat.getShortcutId((Notification)object)).setProgress(context.getInt(NotificationCompat.EXTRA_PROGRESS_MAX), context.getInt(NotificationCompat.EXTRA_PROGRESS), context.getBoolean(NotificationCompat.EXTRA_PROGRESS_INDETERMINATE)).setAllowSystemGeneratedContextualActions(NotificationCompat.getAllowSystemGeneratedContextualActions((Notification)object)).setSmallIcon(((Notification)object).icon, ((Notification)object).iconLevel).addExtras(Builder.getExtrasWithoutDuplicateData((Notification)object, (Style)object2));
            this.mSmallIcon = Api23Impl.getSmallIcon((Notification)object);
            object2 = Api23Impl.getLargeIcon((Notification)object);
            if (object2 != null) {
                this.mLargeIcon = IconCompat.createFromIcon((Icon)object2);
            }
            object2 = ((Notification)object).actions;
            int n3 = 0;
            if (object2 != null && ((Notification)object).actions.length != 0) {
                object2 = ((Notification)object).actions;
                n2 = ((Object)object2).length;
                for (n = 0; n < n2; ++n) {
                    this.addAction(Action.Builder.fromAndroidAction((Notification.Action)object2[n]).build());
                }
            }
            if (!(object2 = NotificationCompat.getInvisibleActions((Notification)object)).isEmpty()) {
                object2 = object2.iterator();
                while (object2.hasNext()) {
                    this.addInvisibleAction((Action)object2.next());
                }
            }
            if ((object2 = ((Notification)object).extras.getStringArray(NotificationCompat.EXTRA_PEOPLE)) != null && ((Object)object2).length != 0) {
                n2 = ((Object)object2).length;
                for (n = n3; n < n2; ++n) {
                    this.addPerson((String)object2[n]);
                }
            }
            if (Build.VERSION.SDK_INT >= 28 && (object = ((Notification)object).extras.getParcelableArrayList(NotificationCompat.EXTRA_PEOPLE_LIST)) != null && !((ArrayList)object).isEmpty()) {
                object = ((ArrayList)object).iterator();
                while (object.hasNext()) {
                    this.addPerson(Person.fromAndroidPerson((android.app.Person)object.next()));
                }
            }
            if (context.containsKey(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN)) {
                this.setChronometerCountDown(context.getBoolean(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN));
            }
            if (Build.VERSION.SDK_INT >= 26 && context.containsKey(NotificationCompat.EXTRA_COLORIZED)) {
                this.setColorized(context.getBoolean(NotificationCompat.EXTRA_COLORIZED));
            }
        }

        public Builder(Context context, String string2) {
            this.mActions = new ArrayList();
            this.mPersonList = new ArrayList();
            this.mInvisibleActions = new ArrayList();
            this.mShowWhen = true;
            this.mLocalOnly = false;
            this.mColor = 0;
            this.mVisibility = 0;
            this.mBadgeIcon = 0;
            this.mGroupAlertBehavior = 0;
            this.mFgsDeferBehavior = 0;
            this.mNotification = new Notification();
            this.mContext = context;
            this.mChannelId = string2;
            this.mNotification.when = System.currentTimeMillis();
            this.mNotification.audioStreamType = -1;
            this.mPriority = 0;
            this.mPeople = new ArrayList();
            this.mAllowSystemGeneratedContextualActions = true;
        }

        private static Bundle getExtrasWithoutDuplicateData(Notification notification, Style style2) {
            if (notification.extras == null) {
                return null;
            }
            notification = new Bundle(notification.extras);
            notification.remove(NotificationCompat.EXTRA_TITLE);
            notification.remove(NotificationCompat.EXTRA_TEXT);
            notification.remove(NotificationCompat.EXTRA_INFO_TEXT);
            notification.remove(NotificationCompat.EXTRA_SUB_TEXT);
            notification.remove(NotificationCompat.EXTRA_CHANNEL_ID);
            notification.remove(NotificationCompat.EXTRA_CHANNEL_GROUP_ID);
            notification.remove(NotificationCompat.EXTRA_SHOW_WHEN);
            notification.remove(NotificationCompat.EXTRA_PROGRESS);
            notification.remove(NotificationCompat.EXTRA_PROGRESS_MAX);
            notification.remove(NotificationCompat.EXTRA_PROGRESS_INDETERMINATE);
            notification.remove(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN);
            notification.remove(NotificationCompat.EXTRA_COLORIZED);
            notification.remove(NotificationCompat.EXTRA_PEOPLE_LIST);
            notification.remove(NotificationCompat.EXTRA_PEOPLE);
            notification.remove("android.support.sortKey");
            notification.remove("android.support.groupKey");
            notification.remove("android.support.isGroupSummary");
            notification.remove("android.support.localOnly");
            notification.remove("android.support.actionExtras");
            Bundle bundle = notification.getBundle("android.car.EXTENSIONS");
            if (bundle != null) {
                bundle = new Bundle(bundle);
                bundle.remove("invisible_actions");
                notification.putBundle("android.car.EXTENSIONS", bundle);
            }
            if (style2 != null) {
                style2.clearCompatExtraKeys((Bundle)notification);
            }
            return notification;
        }

        protected static CharSequence limitCharSequenceLength(CharSequence charSequence) {
            if (charSequence == null) {
                return charSequence;
            }
            CharSequence charSequence2 = charSequence;
            if (charSequence.length() > 5120) {
                charSequence2 = charSequence.subSequence(0, 5120);
            }
            return charSequence2;
        }

        private void setFlag(int n, boolean bl) {
            if (bl) {
                Notification notification = this.mNotification;
                notification.flags |= n;
            } else {
                Notification notification = this.mNotification;
                notification.flags &= ~n;
            }
        }

        private boolean useExistingRemoteView() {
            boolean bl = this.mStyle == null || !this.mStyle.displayCustomViewInline();
            return bl;
        }

        public Builder addAction(int n, CharSequence charSequence, PendingIntent pendingIntent) {
            this.mActions.add(new Action(n, charSequence, pendingIntent));
            return this;
        }

        public Builder addAction(Action action) {
            if (action != null) {
                this.mActions.add(action);
            }
            return this;
        }

        public Builder addExtras(Bundle bundle) {
            if (bundle != null) {
                if (this.mExtras == null) {
                    this.mExtras = new Bundle(bundle);
                } else {
                    this.mExtras.putAll(bundle);
                }
            }
            return this;
        }

        public Builder addInvisibleAction(int n, CharSequence charSequence, PendingIntent pendingIntent) {
            this.mInvisibleActions.add(new Action(n, charSequence, pendingIntent));
            return this;
        }

        public Builder addInvisibleAction(Action action) {
            if (action != null) {
                this.mInvisibleActions.add(action);
            }
            return this;
        }

        public Builder addPerson(Person person) {
            if (person != null) {
                this.mPersonList.add(person);
            }
            return this;
        }

        @Deprecated
        public Builder addPerson(String string2) {
            if (string2 != null && !string2.isEmpty()) {
                this.mPeople.add(string2);
            }
            return this;
        }

        public Notification build() {
            return new NotificationCompatBuilder(this).build();
        }

        public Builder clearActions() {
            this.mActions.clear();
            return this;
        }

        public Builder clearInvisibleActions() {
            this.mInvisibleActions.clear();
            Bundle bundle = this.mExtras.getBundle("android.car.EXTENSIONS");
            if (bundle != null) {
                bundle = new Bundle(bundle);
                bundle.remove("invisible_actions");
                this.mExtras.putBundle("android.car.EXTENSIONS", bundle);
            }
            return this;
        }

        public Builder clearPeople() {
            this.mPersonList.clear();
            this.mPeople.clear();
            return this;
        }

        public RemoteViews createBigContentView() {
            Notification notification;
            if (this.mBigContentView != null && this.useExistingRemoteView()) {
                return this.mBigContentView;
            }
            NotificationCompatBuilder notificationCompatBuilder = new NotificationCompatBuilder(this);
            if (this.mStyle != null && (notification = this.mStyle.makeBigContentView(notificationCompatBuilder)) != null) {
                return notification;
            }
            notification = notificationCompatBuilder.build();
            return Api24Impl.createBigContentView(Api24Impl.recoverBuilder(this.mContext, notification));
        }

        public RemoteViews createContentView() {
            Notification notification;
            if (this.mContentView != null && this.useExistingRemoteView()) {
                return this.mContentView;
            }
            NotificationCompatBuilder notificationCompatBuilder = new NotificationCompatBuilder(this);
            if (this.mStyle != null && (notification = this.mStyle.makeContentView(notificationCompatBuilder)) != null) {
                return notification;
            }
            notification = notificationCompatBuilder.build();
            return Api24Impl.createContentView(Api24Impl.recoverBuilder(this.mContext, notification));
        }

        public RemoteViews createHeadsUpContentView() {
            Notification notification;
            if (this.mHeadsUpContentView != null && this.useExistingRemoteView()) {
                return this.mHeadsUpContentView;
            }
            NotificationCompatBuilder notificationCompatBuilder = new NotificationCompatBuilder(this);
            if (this.mStyle != null && (notification = this.mStyle.makeHeadsUpContentView(notificationCompatBuilder)) != null) {
                return notification;
            }
            notification = notificationCompatBuilder.build();
            return Api24Impl.createHeadsUpContentView(Api24Impl.recoverBuilder(this.mContext, notification));
        }

        public Builder extend(Extender extender) {
            extender.extend(this);
            return this;
        }

        public RemoteViews getBigContentView() {
            return this.mBigContentView;
        }

        public BubbleMetadata getBubbleMetadata() {
            return this.mBubbleMetadata;
        }

        public int getColor() {
            return this.mColor;
        }

        public RemoteViews getContentView() {
            return this.mContentView;
        }

        public Bundle getExtras() {
            if (this.mExtras == null) {
                this.mExtras = new Bundle();
            }
            return this.mExtras;
        }

        public int getForegroundServiceBehavior() {
            return this.mFgsDeferBehavior;
        }

        public RemoteViews getHeadsUpContentView() {
            return this.mHeadsUpContentView;
        }

        @Deprecated
        public Notification getNotification() {
            return this.build();
        }

        public int getPriority() {
            return this.mPriority;
        }

        public long getWhenIfShowing() {
            long l = this.mShowWhen ? this.mNotification.when : 0L;
            return l;
        }

        public Builder setAllowSystemGeneratedContextualActions(boolean bl) {
            this.mAllowSystemGeneratedContextualActions = bl;
            return this;
        }

        public Builder setAutoCancel(boolean bl) {
            this.setFlag(16, bl);
            return this;
        }

        public Builder setBadgeIconType(int n) {
            this.mBadgeIcon = n;
            return this;
        }

        public Builder setBubbleMetadata(BubbleMetadata bubbleMetadata) {
            this.mBubbleMetadata = bubbleMetadata;
            return this;
        }

        public Builder setCategory(String string2) {
            this.mCategory = string2;
            return this;
        }

        public Builder setChannelId(String string2) {
            this.mChannelId = string2;
            return this;
        }

        public Builder setChronometerCountDown(boolean bl) {
            this.mChronometerCountDown = bl;
            this.getExtras().putBoolean(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN, bl);
            return this;
        }

        public Builder setColor(int n) {
            this.mColor = n;
            return this;
        }

        public Builder setColorized(boolean bl) {
            this.mColorized = bl;
            this.mColorizedSet = true;
            return this;
        }

        public Builder setContent(RemoteViews remoteViews) {
            this.mNotification.contentView = remoteViews;
            return this;
        }

        public Builder setContentInfo(CharSequence charSequence) {
            this.mContentInfo = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        public Builder setContentIntent(PendingIntent pendingIntent) {
            this.mContentIntent = pendingIntent;
            return this;
        }

        public Builder setContentText(CharSequence charSequence) {
            this.mContentText = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        public Builder setContentTitle(CharSequence charSequence) {
            this.mContentTitle = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        public Builder setCustomBigContentView(RemoteViews remoteViews) {
            this.mBigContentView = remoteViews;
            return this;
        }

        public Builder setCustomContentView(RemoteViews remoteViews) {
            this.mContentView = remoteViews;
            return this;
        }

        public Builder setCustomHeadsUpContentView(RemoteViews remoteViews) {
            this.mHeadsUpContentView = remoteViews;
            return this;
        }

        public Builder setDefaults(int n) {
            this.mNotification.defaults = n;
            if ((n & 4) != 0) {
                Notification notification = this.mNotification;
                notification.flags |= 1;
            }
            return this;
        }

        public Builder setDeleteIntent(PendingIntent pendingIntent) {
            this.mNotification.deleteIntent = pendingIntent;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.mExtras = bundle;
            return this;
        }

        public Builder setForegroundServiceBehavior(int n) {
            this.mFgsDeferBehavior = n;
            return this;
        }

        public Builder setFullScreenIntent(PendingIntent pendingIntent, boolean bl) {
            this.mFullScreenIntent = pendingIntent;
            this.setFlag(128, bl);
            return this;
        }

        public Builder setGroup(String string2) {
            this.mGroupKey = string2;
            return this;
        }

        public Builder setGroupAlertBehavior(int n) {
            this.mGroupAlertBehavior = n;
            return this;
        }

        public Builder setGroupSummary(boolean bl) {
            this.mGroupSummary = bl;
            return this;
        }

        public Builder setLargeIcon(Bitmap object) {
            object = object == null ? null : IconCompat.createWithBitmap(NotificationCompat.reduceLargeIconSize(this.mContext, object));
            this.mLargeIcon = object;
            return this;
        }

        public Builder setLargeIcon(Icon object) {
            object = object == null ? null : IconCompat.createFromIcon(object);
            this.mLargeIcon = object;
            return this;
        }

        public Builder setLights(int n, int n2, int n3) {
            this.mNotification.ledARGB = n;
            this.mNotification.ledOnMS = n2;
            this.mNotification.ledOffMS = n3;
            n = this.mNotification.ledOnMS;
            n2 = 1;
            n = n != 0 && this.mNotification.ledOffMS != 0 ? 1 : 0;
            Notification notification = this.mNotification;
            n3 = this.mNotification.flags;
            n = n != 0 ? n2 : 0;
            notification.flags = n | n3 & 0xFFFFFFFE;
            return this;
        }

        public Builder setLocalOnly(boolean bl) {
            this.mLocalOnly = bl;
            return this;
        }

        public Builder setLocusId(LocusIdCompat locusIdCompat) {
            this.mLocusId = locusIdCompat;
            return this;
        }

        @Deprecated
        public Builder setNotificationSilent() {
            this.mSilent = true;
            return this;
        }

        public Builder setNumber(int n) {
            this.mNumber = n;
            return this;
        }

        public Builder setOngoing(boolean bl) {
            this.setFlag(2, bl);
            return this;
        }

        public Builder setOnlyAlertOnce(boolean bl) {
            this.setFlag(8, bl);
            return this;
        }

        public Builder setPriority(int n) {
            this.mPriority = n;
            return this;
        }

        public Builder setProgress(int n, int n2, boolean bl) {
            this.mProgressMax = n;
            this.mProgress = n2;
            this.mProgressIndeterminate = bl;
            return this;
        }

        public Builder setPublicVersion(Notification notification) {
            this.mPublicVersion = notification;
            return this;
        }

        public Builder setRemoteInputHistory(CharSequence[] charSequenceArray) {
            this.mRemoteInputHistory = charSequenceArray;
            return this;
        }

        public Builder setSettingsText(CharSequence charSequence) {
            this.mSettingsText = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        public Builder setShortcutId(String string2) {
            this.mShortcutId = string2;
            return this;
        }

        public Builder setShortcutInfo(ShortcutInfoCompat shortcutInfoCompat) {
            if (shortcutInfoCompat == null) {
                return this;
            }
            this.mShortcutId = shortcutInfoCompat.getId();
            if (this.mLocusId == null) {
                if (shortcutInfoCompat.getLocusId() != null) {
                    this.mLocusId = shortcutInfoCompat.getLocusId();
                } else if (shortcutInfoCompat.getId() != null) {
                    this.mLocusId = new LocusIdCompat(shortcutInfoCompat.getId());
                }
            }
            if (this.mContentTitle == null) {
                this.setContentTitle(shortcutInfoCompat.getShortLabel());
            }
            return this;
        }

        public Builder setShowWhen(boolean bl) {
            this.mShowWhen = bl;
            return this;
        }

        public Builder setSilent(boolean bl) {
            this.mSilent = bl;
            return this;
        }

        public Builder setSmallIcon(int n) {
            this.mNotification.icon = n;
            return this;
        }

        public Builder setSmallIcon(int n, int n2) {
            this.mNotification.icon = n;
            this.mNotification.iconLevel = n2;
            return this;
        }

        public Builder setSmallIcon(IconCompat iconCompat) {
            this.mSmallIcon = iconCompat.toIcon(this.mContext);
            return this;
        }

        public Builder setSortKey(String string2) {
            this.mSortKey = string2;
            return this;
        }

        public Builder setSound(Uri uri) {
            this.mNotification.sound = uri;
            this.mNotification.audioStreamType = -1;
            uri = Api21Impl.setUsage(Api21Impl.setContentType(Api21Impl.createBuilder(), 4), 5);
            this.mNotification.audioAttributes = Api21Impl.build((AudioAttributes.Builder)uri);
            return this;
        }

        public Builder setSound(Uri uri, int n) {
            this.mNotification.sound = uri;
            this.mNotification.audioStreamType = n;
            uri = Api21Impl.setLegacyStreamType(Api21Impl.setContentType(Api21Impl.createBuilder(), 4), n);
            this.mNotification.audioAttributes = Api21Impl.build((AudioAttributes.Builder)uri);
            return this;
        }

        public Builder setStyle(Style style2) {
            if (this.mStyle != style2) {
                this.mStyle = style2;
                if (this.mStyle != null) {
                    this.mStyle.setBuilder(this);
                }
            }
            return this;
        }

        public Builder setSubText(CharSequence charSequence) {
            this.mSubText = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        public Builder setTicker(CharSequence charSequence) {
            this.mNotification.tickerText = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        @Deprecated
        public Builder setTicker(CharSequence charSequence, RemoteViews remoteViews) {
            this.mNotification.tickerText = Builder.limitCharSequenceLength(charSequence);
            this.mTickerView = remoteViews;
            return this;
        }

        public Builder setTimeoutAfter(long l) {
            this.mTimeout = l;
            return this;
        }

        public Builder setUsesChronometer(boolean bl) {
            this.mUseChronometer = bl;
            return this;
        }

        public Builder setVibrate(long[] lArray) {
            this.mNotification.vibrate = lArray;
            return this;
        }

        public Builder setVisibility(int n) {
            this.mVisibility = n;
            return this;
        }

        public Builder setWhen(long l) {
            this.mNotification.when = l;
            return this;
        }

        static class Api21Impl {
            private Api21Impl() {
            }

            static AudioAttributes build(AudioAttributes.Builder builder) {
                return builder.build();
            }

            static AudioAttributes.Builder createBuilder() {
                return new AudioAttributes.Builder();
            }

            static AudioAttributes.Builder setContentType(AudioAttributes.Builder builder, int n) {
                return builder.setContentType(n);
            }

            static AudioAttributes.Builder setLegacyStreamType(AudioAttributes.Builder builder, int n) {
                return builder.setLegacyStreamType(n);
            }

            static AudioAttributes.Builder setUsage(AudioAttributes.Builder builder, int n) {
                return builder.setUsage(n);
            }
        }

        static class Api23Impl {
            private Api23Impl() {
            }

            static Icon getLargeIcon(Notification notification) {
                return notification.getLargeIcon();
            }

            static Icon getSmallIcon(Notification notification) {
                return notification.getSmallIcon();
            }
        }

        static class Api24Impl {
            private Api24Impl() {
            }

            static RemoteViews createBigContentView(Notification.Builder builder) {
                return builder.createHeadsUpContentView();
            }

            static RemoteViews createContentView(Notification.Builder builder) {
                return builder.createContentView();
            }

            static RemoteViews createHeadsUpContentView(Notification.Builder builder) {
                return builder.createHeadsUpContentView();
            }

            static Notification.Builder recoverBuilder(Context context, Notification notification) {
                return Notification.Builder.recoverBuilder((Context)context, (Notification)notification);
            }
        }
    }

    public static class CallStyle
    extends Style {
        public static final int CALL_TYPE_INCOMING = 1;
        public static final int CALL_TYPE_ONGOING = 2;
        public static final int CALL_TYPE_SCREENING = 3;
        public static final int CALL_TYPE_UNKNOWN = 0;
        private static final String KEY_ACTION_PRIORITY = "key_action_priority";
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$CallStyle";
        private Integer mAnswerButtonColor;
        private PendingIntent mAnswerIntent;
        private int mCallType;
        private Integer mDeclineButtonColor;
        private PendingIntent mDeclineIntent;
        private PendingIntent mHangUpIntent;
        private boolean mIsVideo;
        private Person mPerson;
        private IconCompat mVerificationIcon;
        private CharSequence mVerificationText;

        public CallStyle() {
        }

        private CallStyle(int n, Person person, PendingIntent pendingIntent, PendingIntent pendingIntent2, PendingIntent pendingIntent3) {
            if (person != null && !TextUtils.isEmpty((CharSequence)person.getName())) {
                this.mCallType = n;
                this.mPerson = person;
                this.mAnswerIntent = pendingIntent3;
                this.mDeclineIntent = pendingIntent2;
                this.mHangUpIntent = pendingIntent;
                return;
            }
            throw new IllegalArgumentException("person must have a non-empty a name");
        }

        public CallStyle(Builder builder) {
            this.setBuilder(builder);
        }

        public static CallStyle forIncomingCall(Person person, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
            return new CallStyle(1, person, null, Objects.requireNonNull(pendingIntent, "declineIntent is required"), Objects.requireNonNull(pendingIntent2, "answerIntent is required"));
        }

        public static CallStyle forOngoingCall(Person person, PendingIntent pendingIntent) {
            return new CallStyle(2, person, Objects.requireNonNull(pendingIntent, "hangUpIntent is required"), null, null);
        }

        public static CallStyle forScreeningCall(Person person, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
            return new CallStyle(3, person, Objects.requireNonNull(pendingIntent, "hangUpIntent is required"), null, Objects.requireNonNull(pendingIntent2, "answerIntent is required"));
        }

        private String getDefaultText() {
            switch (this.mCallType) {
                default: {
                    return null;
                }
                case 3: {
                    return this.mBuilder.mContext.getResources().getString(R.string.call_notification_screening_text);
                }
                case 2: {
                    return this.mBuilder.mContext.getResources().getString(R.string.call_notification_ongoing_text);
                }
                case 1: 
            }
            return this.mBuilder.mContext.getResources().getString(R.string.call_notification_incoming_text);
        }

        private boolean isActionAddedByCallStyle(Action action) {
            boolean bl = action != null && action.getExtras().getBoolean(KEY_ACTION_PRIORITY);
            return bl;
        }

        private Action makeAction(int n, int n2, Integer object, int n3, PendingIntent pendingIntent) {
            Integer n4 = object;
            if (object == null) {
                n4 = ContextCompat.getColor(this.mBuilder.mContext, n3);
            }
            object = new SpannableStringBuilder();
            object.append((CharSequence)this.mBuilder.mContext.getResources().getString(n2));
            object.setSpan((Object)new ForegroundColorSpan(n4.intValue()), 0, object.length(), 18);
            object = new Action.Builder(IconCompat.createWithResource(this.mBuilder.mContext, n), (CharSequence)object, pendingIntent).build();
            ((Action)object).getExtras().putBoolean(KEY_ACTION_PRIORITY, true);
            return object;
        }

        private Action makeAnswerAction() {
            Action action;
            int n = R.drawable.ic_call_answer_video_low;
            n = R.drawable.ic_call_answer_low;
            int n2 = R.drawable.ic_call_answer_video;
            n = R.drawable.ic_call_answer;
            if (this.mAnswerIntent == null) {
                action = null;
            } else {
                if (this.mIsVideo) {
                    n = n2;
                }
                n2 = this.mIsVideo ? R.string.call_notification_answer_video_action : R.string.call_notification_answer_action;
                action = this.makeAction(n, n2, this.mAnswerButtonColor, R.color.call_notification_answer_color, this.mAnswerIntent);
            }
            return action;
        }

        private Action makeNegativeAction() {
            int n = R.drawable.ic_call_decline_low;
            n = R.drawable.ic_call_decline;
            if (this.mDeclineIntent == null) {
                return this.makeAction(n, R.string.call_notification_hang_up_action, this.mDeclineButtonColor, R.color.call_notification_decline_color, this.mHangUpIntent);
            }
            return this.makeAction(n, R.string.call_notification_decline_action, this.mDeclineButtonColor, R.color.call_notification_decline_color, this.mDeclineIntent);
        }

        @Override
        public void addCompatExtras(Bundle bundle) {
            super.addCompatExtras(bundle);
            bundle.putInt(NotificationCompat.EXTRA_CALL_TYPE, this.mCallType);
            bundle.putBoolean(NotificationCompat.EXTRA_CALL_IS_VIDEO, this.mIsVideo);
            if (this.mPerson != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    bundle.putParcelable(NotificationCompat.EXTRA_CALL_PERSON, Api28Impl.castToParcelable(this.mPerson.toAndroidPerson()));
                } else {
                    bundle.putParcelable(NotificationCompat.EXTRA_CALL_PERSON_COMPAT, (Parcelable)this.mPerson.toBundle());
                }
            }
            if (this.mVerificationIcon != null) {
                bundle.putParcelable(NotificationCompat.EXTRA_VERIFICATION_ICON, Api23Impl.castToParcelable(this.mVerificationIcon.toIcon(this.mBuilder.mContext)));
            }
            bundle.putCharSequence(NotificationCompat.EXTRA_VERIFICATION_TEXT, this.mVerificationText);
            bundle.putParcelable(NotificationCompat.EXTRA_ANSWER_INTENT, (Parcelable)this.mAnswerIntent);
            bundle.putParcelable(NotificationCompat.EXTRA_DECLINE_INTENT, (Parcelable)this.mDeclineIntent);
            bundle.putParcelable(NotificationCompat.EXTRA_HANG_UP_INTENT, (Parcelable)this.mHangUpIntent);
            if (this.mAnswerButtonColor != null) {
                bundle.putInt(NotificationCompat.EXTRA_ANSWER_COLOR, this.mAnswerButtonColor.intValue());
            }
            if (this.mDeclineButtonColor != null) {
                bundle.putInt(NotificationCompat.EXTRA_DECLINE_COLOR, this.mDeclineButtonColor.intValue());
            }
        }

        @Override
        public void apply(NotificationBuilderWithBuilderAccessor object) {
            if (Build.VERSION.SDK_INT >= 31) {
                Notification.CallStyle callStyle;
                Notification.CallStyle callStyle2 = null;
                switch (this.mCallType) {
                    default: {
                        callStyle = callStyle2;
                        if (!Log.isLoggable((String)NotificationCompat.TAG, (int)3)) break;
                        Log.d((String)NotificationCompat.TAG, (String)("Unrecognized call type in CallStyle: " + String.valueOf(this.mCallType)));
                        callStyle = callStyle2;
                        break;
                    }
                    case 3: {
                        callStyle = Api31Impl.forScreeningCall(this.mPerson.toAndroidPerson(), this.mHangUpIntent, this.mAnswerIntent);
                        break;
                    }
                    case 2: {
                        callStyle = Api31Impl.forOngoingCall(this.mPerson.toAndroidPerson(), this.mHangUpIntent);
                        break;
                    }
                    case 1: {
                        callStyle = Api31Impl.forIncomingCall(this.mPerson.toAndroidPerson(), this.mDeclineIntent, this.mAnswerIntent);
                    }
                }
                if (callStyle != null) {
                    callStyle.setBuilder(object.getBuilder());
                    if (this.mAnswerButtonColor != null) {
                        Api31Impl.setAnswerButtonColorHint(callStyle, this.mAnswerButtonColor);
                    }
                    if (this.mDeclineButtonColor != null) {
                        Api31Impl.setDeclineButtonColorHint(callStyle, this.mDeclineButtonColor);
                    }
                    Api31Impl.setVerificationText(callStyle, this.mVerificationText);
                    if (this.mVerificationIcon != null) {
                        Api31Impl.setVerificationIcon(callStyle, this.mVerificationIcon.toIcon(this.mBuilder.mContext));
                    }
                    Api31Impl.setIsVideo(callStyle, this.mIsVideo);
                }
            } else {
                Notification.Builder builder = object.getBuilder();
                object = this.mPerson;
                Object object2 = null;
                object = object != null ? this.mPerson.getName() : null;
                builder.setContentTitle((CharSequence)object);
                object = this.mBuilder.mExtras != null && this.mBuilder.mExtras.containsKey(NotificationCompat.EXTRA_TEXT) ? this.mBuilder.mExtras.getCharSequence(NotificationCompat.EXTRA_TEXT) : object2;
                object2 = object;
                if (object == null) {
                    object2 = this.getDefaultText();
                }
                builder.setContentText((CharSequence)object2);
                if (this.mPerson != null) {
                    if (this.mPerson.getIcon() != null) {
                        Api23Impl.setLargeIcon(builder, this.mPerson.getIcon().toIcon(this.mBuilder.mContext));
                    }
                    if (Build.VERSION.SDK_INT >= 28) {
                        Api28Impl.addPerson(builder, this.mPerson.toAndroidPerson());
                    } else {
                        Api21Impl.addPerson(builder, this.mPerson.getUri());
                    }
                }
                Api21Impl.setCategory(builder, NotificationCompat.CATEGORY_CALL);
            }
        }

        @Override
        public boolean displayCustomViewInline() {
            return true;
        }

        public ArrayList<Action> getActionsListWithSystemActions() {
            Object object = this.makeNegativeAction();
            Action action = this.makeAnswerAction();
            int n = 3;
            ArrayList<Action> arrayList = new ArrayList<Action>(3);
            if (3 > 0) {
                arrayList.add((Action)object);
                n = 3 - 1;
            }
            object = this.mBuilder.mActions;
            int n2 = n;
            if (object != null) {
                Iterator iterator2 = object.iterator();
                while (true) {
                    n2 = n;
                    if (!iterator2.hasNext()) break;
                    object = (Action)iterator2.next();
                    if (((Action)object).isContextual()) {
                        arrayList.add((Action)object);
                        n2 = n;
                    } else if (this.isActionAddedByCallStyle((Action)object)) {
                        n2 = n;
                    } else {
                        n2 = n;
                        if (n > 1) {
                            arrayList.add((Action)object);
                            n2 = n - 1;
                        }
                    }
                    n = n2;
                    if (action == null) continue;
                    n = n2;
                    if (n2 != 1) continue;
                    arrayList.add(action);
                    n = n2 - 1;
                }
            }
            if (action != null && n2 >= 1) {
                arrayList.add(action);
            }
            return arrayList;
        }

        @Override
        protected String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Override
        protected void restoreFromCompatExtras(Bundle object) {
            super.restoreFromCompatExtras((Bundle)object);
            this.mCallType = object.getInt(NotificationCompat.EXTRA_CALL_TYPE);
            this.mIsVideo = object.getBoolean(NotificationCompat.EXTRA_CALL_IS_VIDEO);
            if (Build.VERSION.SDK_INT >= 28 && object.containsKey(NotificationCompat.EXTRA_CALL_PERSON)) {
                this.mPerson = Person.fromAndroidPerson((android.app.Person)object.getParcelable(NotificationCompat.EXTRA_CALL_PERSON));
            } else if (object.containsKey(NotificationCompat.EXTRA_CALL_PERSON_COMPAT)) {
                this.mPerson = Person.fromBundle(object.getBundle(NotificationCompat.EXTRA_CALL_PERSON_COMPAT));
            }
            if (object.containsKey(NotificationCompat.EXTRA_VERIFICATION_ICON)) {
                this.mVerificationIcon = IconCompat.createFromIcon((Icon)object.getParcelable(NotificationCompat.EXTRA_VERIFICATION_ICON));
            } else if (object.containsKey(NotificationCompat.EXTRA_VERIFICATION_ICON_COMPAT)) {
                this.mVerificationIcon = IconCompat.createFromBundle(object.getBundle(NotificationCompat.EXTRA_VERIFICATION_ICON_COMPAT));
            }
            this.mVerificationText = object.getCharSequence(NotificationCompat.EXTRA_VERIFICATION_TEXT);
            this.mAnswerIntent = (PendingIntent)object.getParcelable(NotificationCompat.EXTRA_ANSWER_INTENT);
            this.mDeclineIntent = (PendingIntent)object.getParcelable(NotificationCompat.EXTRA_DECLINE_INTENT);
            this.mHangUpIntent = (PendingIntent)object.getParcelable(NotificationCompat.EXTRA_HANG_UP_INTENT);
            boolean bl = object.containsKey(NotificationCompat.EXTRA_ANSWER_COLOR);
            Object var4_3 = null;
            Integer n = bl ? Integer.valueOf(object.getInt(NotificationCompat.EXTRA_ANSWER_COLOR)) : null;
            this.mAnswerButtonColor = n;
            object = object.containsKey(NotificationCompat.EXTRA_DECLINE_COLOR) ? Integer.valueOf(object.getInt(NotificationCompat.EXTRA_DECLINE_COLOR)) : var4_3;
            this.mDeclineButtonColor = object;
        }

        public CallStyle setAnswerButtonColorHint(int n) {
            this.mAnswerButtonColor = n;
            return this;
        }

        public CallStyle setDeclineButtonColorHint(int n) {
            this.mDeclineButtonColor = n;
            return this;
        }

        public CallStyle setIsVideo(boolean bl) {
            this.mIsVideo = bl;
            return this;
        }

        public CallStyle setVerificationIcon(Bitmap bitmap) {
            this.mVerificationIcon = IconCompat.createWithBitmap(bitmap);
            return this;
        }

        public CallStyle setVerificationIcon(Icon object) {
            object = object == null ? null : IconCompat.createFromIcon(object);
            this.mVerificationIcon = object;
            return this;
        }

        public CallStyle setVerificationText(CharSequence charSequence) {
            this.mVerificationText = charSequence;
            return this;
        }

        static class Api20Impl {
            private Api20Impl() {
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

            static Notification.Action.Builder createActionBuilder(int n, CharSequence charSequence, PendingIntent pendingIntent) {
                return new Notification.Action.Builder(n, charSequence, pendingIntent);
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
        }

        static class Api23Impl {
            private Api23Impl() {
            }

            static Parcelable castToParcelable(Icon icon) {
                return icon;
            }

            static Notification.Action.Builder createActionBuilder(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
                return new Notification.Action.Builder(icon, charSequence, pendingIntent);
            }

            static void setLargeIcon(Notification.Builder builder, Icon icon) {
                builder.setLargeIcon(icon);
            }
        }

        static class Api24Impl {
            private Api24Impl() {
            }

            static Notification.Action.Builder setAllowGeneratedReplies(Notification.Action.Builder builder, boolean bl) {
                return builder.setAllowGeneratedReplies(bl);
            }
        }

        static class Api28Impl {
            private Api28Impl() {
            }

            static Notification.Builder addPerson(Notification.Builder builder, android.app.Person person) {
                return builder.addPerson(person);
            }

            static Parcelable castToParcelable(android.app.Person person) {
                return person;
            }
        }

        static class Api31Impl {
            private Api31Impl() {
            }

            static Notification.CallStyle forIncomingCall(android.app.Person person, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
                return Notification.CallStyle.forIncomingCall((android.app.Person)person, (PendingIntent)pendingIntent, (PendingIntent)pendingIntent2);
            }

            static Notification.CallStyle forOngoingCall(android.app.Person person, PendingIntent pendingIntent) {
                return Notification.CallStyle.forOngoingCall((android.app.Person)person, (PendingIntent)pendingIntent);
            }

            static Notification.CallStyle forScreeningCall(android.app.Person person, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
                return Notification.CallStyle.forScreeningCall((android.app.Person)person, (PendingIntent)pendingIntent, (PendingIntent)pendingIntent2);
            }

            static Notification.CallStyle setAnswerButtonColorHint(Notification.CallStyle callStyle, int n) {
                return callStyle.setAnswerButtonColorHint(n);
            }

            static Notification.Action.Builder setAuthenticationRequired(Notification.Action.Builder builder, boolean bl) {
                return builder.setAuthenticationRequired(bl);
            }

            static Notification.CallStyle setDeclineButtonColorHint(Notification.CallStyle callStyle, int n) {
                return callStyle.setDeclineButtonColorHint(n);
            }

            static Notification.CallStyle setIsVideo(Notification.CallStyle callStyle, boolean bl) {
                return callStyle.setIsVideo(bl);
            }

            static Notification.CallStyle setVerificationIcon(Notification.CallStyle callStyle, Icon icon) {
                return callStyle.setVerificationIcon(icon);
            }

            static Notification.CallStyle setVerificationText(Notification.CallStyle callStyle, CharSequence charSequence) {
                return callStyle.setVerificationText(charSequence);
            }
        }

        @Retention(value=RetentionPolicy.SOURCE)
        public static @interface CallType {
        }
    }

    public static final class CarExtender
    implements Extender {
        static final String EXTRA_CAR_EXTENDER = "android.car.EXTENSIONS";
        private static final String EXTRA_COLOR = "app_color";
        private static final String EXTRA_CONVERSATION = "car_conversation";
        static final String EXTRA_INVISIBLE_ACTIONS = "invisible_actions";
        private static final String EXTRA_LARGE_ICON = "large_icon";
        private static final String KEY_AUTHOR = "author";
        private static final String KEY_MESSAGES = "messages";
        private static final String KEY_ON_READ = "on_read";
        private static final String KEY_ON_REPLY = "on_reply";
        private static final String KEY_PARTICIPANTS = "participants";
        private static final String KEY_REMOTE_INPUT = "remote_input";
        private static final String KEY_TEXT = "text";
        private static final String KEY_TIMESTAMP = "timestamp";
        private int mColor = 0;
        private Bitmap mLargeIcon;
        private UnreadConversation mUnreadConversation;

        public CarExtender() {
        }

        public CarExtender(Notification object) {
            object = NotificationCompat.getExtras(object) == null ? null : NotificationCompat.getExtras(object).getBundle(EXTRA_CAR_EXTENDER);
            if (object != null) {
                this.mLargeIcon = (Bitmap)object.getParcelable(EXTRA_LARGE_ICON);
                this.mColor = object.getInt(EXTRA_COLOR, 0);
                this.mUnreadConversation = CarExtender.getUnreadConversationFromBundle(object.getBundle(EXTRA_CONVERSATION));
            }
        }

        private static Bundle getBundleForUnreadConversation(UnreadConversation unreadConversation) {
            Bundle bundle = new Bundle();
            Object object = null;
            RemoteInput.Builder builder = object;
            if (unreadConversation.getParticipants() != null) {
                builder = object;
                if (unreadConversation.getParticipants().length > 1) {
                    builder = unreadConversation.getParticipants()[0];
                }
            }
            object = new Parcelable[unreadConversation.getMessages().length];
            for (int i = 0; i < ((Parcelable[])object).length; ++i) {
                Bundle bundle2 = new Bundle();
                bundle2.putString(KEY_TEXT, unreadConversation.getMessages()[i]);
                bundle2.putString(KEY_AUTHOR, (String)builder);
                object[i] = bundle2;
            }
            bundle.putParcelableArray(KEY_MESSAGES, (Parcelable[])object);
            object = unreadConversation.getRemoteInput();
            if (object != null) {
                builder = Api20Impl.createBuilder(((RemoteInput)object).getResultKey());
                Api20Impl.setLabel(builder, ((RemoteInput)object).getLabel());
                Api20Impl.setChoices(builder, ((RemoteInput)object).getChoices());
                Api20Impl.setAllowFreeFormInput(builder, ((RemoteInput)object).getAllowFreeFormInput());
                Api20Impl.addExtras(builder, ((RemoteInput)object).getExtras());
                bundle.putParcelable(KEY_REMOTE_INPUT, Api20Impl.castToParcelable(Api20Impl.build(builder)));
            }
            bundle.putParcelable(KEY_ON_REPLY, (Parcelable)unreadConversation.getReplyPendingIntent());
            bundle.putParcelable(KEY_ON_READ, (Parcelable)unreadConversation.getReadPendingIntent());
            bundle.putStringArray(KEY_PARTICIPANTS, unreadConversation.getParticipants());
            bundle.putLong(KEY_TIMESTAMP, unreadConversation.getLatestTimestamp());
            return bundle;
        }

        private static UnreadConversation getUnreadConversationFromBundle(Bundle bundle) {
            int n;
            if (bundle == null) {
                return null;
            }
            Object object = bundle.getParcelableArray(KEY_MESSAGES);
            String[] stringArray = null;
            if (object != null) {
                stringArray = new String[((Parcelable[])object).length];
                int n2 = 1;
                int n3 = 0;
                while (true) {
                    n = n2;
                    if (n3 >= stringArray.length) break;
                    if (!(object[n3] instanceof Bundle)) {
                        n = 0;
                        break;
                    }
                    stringArray[n3] = ((Bundle)object[n3]).getString(KEY_TEXT);
                    if (stringArray[n3] == null) {
                        n = 0;
                        break;
                    }
                    ++n3;
                }
                if (n == 0) {
                    return null;
                }
            }
            PendingIntent pendingIntent = (PendingIntent)bundle.getParcelable(KEY_ON_READ);
            PendingIntent pendingIntent2 = (PendingIntent)bundle.getParcelable(KEY_ON_REPLY);
            android.app.RemoteInput remoteInput = (android.app.RemoteInput)bundle.getParcelable(KEY_REMOTE_INPUT);
            String[] stringArray2 = bundle.getStringArray(KEY_PARTICIPANTS);
            if (stringArray2 != null && stringArray2.length == 1) {
                if (remoteInput != null) {
                    String string2 = Api20Impl.getResultKey(remoteInput);
                    CharSequence charSequence = Api20Impl.getLabel(remoteInput);
                    object = Api20Impl.getChoices(remoteInput);
                    boolean bl = Api20Impl.getAllowFreeFormInput(remoteInput);
                    n = Build.VERSION.SDK_INT >= 29 ? Api29Impl.getEditChoicesBeforeSending(remoteInput) : 0;
                    object = new RemoteInput(string2, charSequence, (CharSequence[])object, bl, n, Api20Impl.getExtras(remoteInput), null);
                } else {
                    object = null;
                }
                return new UnreadConversation(stringArray, (RemoteInput)object, pendingIntent2, pendingIntent, stringArray2, bundle.getLong(KEY_TIMESTAMP));
            }
            return null;
        }

        @Override
        public Builder extend(Builder builder) {
            Bundle bundle = new Bundle();
            if (this.mLargeIcon != null) {
                bundle.putParcelable(EXTRA_LARGE_ICON, (Parcelable)this.mLargeIcon);
            }
            if (this.mColor != 0) {
                bundle.putInt(EXTRA_COLOR, this.mColor);
            }
            if (this.mUnreadConversation != null) {
                bundle.putBundle(EXTRA_CONVERSATION, CarExtender.getBundleForUnreadConversation(this.mUnreadConversation));
            }
            builder.getExtras().putBundle(EXTRA_CAR_EXTENDER, bundle);
            return builder;
        }

        public int getColor() {
            return this.mColor;
        }

        public Bitmap getLargeIcon() {
            return this.mLargeIcon;
        }

        @Deprecated
        public UnreadConversation getUnreadConversation() {
            return this.mUnreadConversation;
        }

        public CarExtender setColor(int n) {
            this.mColor = n;
            return this;
        }

        public CarExtender setLargeIcon(Bitmap bitmap) {
            this.mLargeIcon = bitmap;
            return this;
        }

        @Deprecated
        public CarExtender setUnreadConversation(UnreadConversation unreadConversation) {
            this.mUnreadConversation = unreadConversation;
            return this;
        }

        static class Api20Impl {
            private Api20Impl() {
            }

            static RemoteInput.Builder addExtras(RemoteInput.Builder builder, Bundle bundle) {
                return builder.addExtras(bundle);
            }

            static android.app.RemoteInput build(RemoteInput.Builder builder) {
                return builder.build();
            }

            static Parcelable castToParcelable(android.app.RemoteInput remoteInput) {
                return remoteInput;
            }

            static RemoteInput.Builder createBuilder(String string2) {
                return new RemoteInput.Builder(string2);
            }

            static boolean getAllowFreeFormInput(android.app.RemoteInput remoteInput) {
                return remoteInput.getAllowFreeFormInput();
            }

            static CharSequence[] getChoices(android.app.RemoteInput remoteInput) {
                return remoteInput.getChoices();
            }

            static Bundle getExtras(android.app.RemoteInput remoteInput) {
                return remoteInput.getExtras();
            }

            static CharSequence getLabel(android.app.RemoteInput remoteInput) {
                return remoteInput.getLabel();
            }

            static String getResultKey(android.app.RemoteInput remoteInput) {
                return remoteInput.getResultKey();
            }

            static RemoteInput.Builder setAllowFreeFormInput(RemoteInput.Builder builder, boolean bl) {
                return builder.setAllowFreeFormInput(bl);
            }

            static RemoteInput.Builder setChoices(RemoteInput.Builder builder, CharSequence[] charSequenceArray) {
                return builder.setChoices(charSequenceArray);
            }

            static RemoteInput.Builder setLabel(RemoteInput.Builder builder, CharSequence charSequence) {
                return builder.setLabel(charSequence);
            }
        }

        static class Api29Impl {
            private Api29Impl() {
            }

            static int getEditChoicesBeforeSending(android.app.RemoteInput remoteInput) {
                return remoteInput.getEditChoicesBeforeSending();
            }
        }

        @Deprecated
        public static class UnreadConversation {
            private final long mLatestTimestamp;
            private final String[] mMessages;
            private final String[] mParticipants;
            private final PendingIntent mReadPendingIntent;
            private final RemoteInput mRemoteInput;
            private final PendingIntent mReplyPendingIntent;

            UnreadConversation(String[] stringArray, RemoteInput remoteInput, PendingIntent pendingIntent, PendingIntent pendingIntent2, String[] stringArray2, long l) {
                this.mMessages = stringArray;
                this.mRemoteInput = remoteInput;
                this.mReadPendingIntent = pendingIntent2;
                this.mReplyPendingIntent = pendingIntent;
                this.mParticipants = stringArray2;
                this.mLatestTimestamp = l;
            }

            public long getLatestTimestamp() {
                return this.mLatestTimestamp;
            }

            public String[] getMessages() {
                return this.mMessages;
            }

            public String getParticipant() {
                String string2 = this.mParticipants.length > 0 ? this.mParticipants[0] : null;
                return string2;
            }

            public String[] getParticipants() {
                return this.mParticipants;
            }

            public PendingIntent getReadPendingIntent() {
                return this.mReadPendingIntent;
            }

            public RemoteInput getRemoteInput() {
                return this.mRemoteInput;
            }

            public PendingIntent getReplyPendingIntent() {
                return this.mReplyPendingIntent;
            }

            public static class Builder {
                private long mLatestTimestamp;
                private final List<String> mMessages = new ArrayList<String>();
                private final String mParticipant;
                private PendingIntent mReadPendingIntent;
                private RemoteInput mRemoteInput;
                private PendingIntent mReplyPendingIntent;

                public Builder(String string2) {
                    this.mParticipant = string2;
                }

                public Builder addMessage(String string2) {
                    if (string2 != null) {
                        this.mMessages.add(string2);
                    }
                    return this;
                }

                public UnreadConversation build() {
                    String[] stringArray = this.mMessages.toArray(new String[this.mMessages.size()]);
                    String string2 = this.mParticipant;
                    RemoteInput remoteInput = this.mRemoteInput;
                    PendingIntent pendingIntent = this.mReplyPendingIntent;
                    PendingIntent pendingIntent2 = this.mReadPendingIntent;
                    long l = this.mLatestTimestamp;
                    return new UnreadConversation(stringArray, remoteInput, pendingIntent, pendingIntent2, new String[]{string2}, l);
                }

                public Builder setLatestTimestamp(long l) {
                    this.mLatestTimestamp = l;
                    return this;
                }

                public Builder setReadPendingIntent(PendingIntent pendingIntent) {
                    this.mReadPendingIntent = pendingIntent;
                    return this;
                }

                public Builder setReplyAction(PendingIntent pendingIntent, RemoteInput remoteInput) {
                    this.mRemoteInput = remoteInput;
                    this.mReplyPendingIntent = pendingIntent;
                    return this;
                }
            }
        }
    }

    public static class DecoratedCustomViewStyle
    extends Style {
        private static final int MAX_ACTION_BUTTONS = 3;
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";

        private RemoteViews createRemoteViews(RemoteViews remoteViews, boolean bl) {
            int n = R.layout.notification_template_custom_big;
            int n2 = 0;
            RemoteViews remoteViews2 = this.applyStandardTemplate(true, n, false);
            remoteViews2.removeAllViews(R.id.actions);
            int n3 = 0;
            List<Action> list = DecoratedCustomViewStyle.getNonContextualActions(this.mBuilder.mActions);
            n = n3;
            if (bl) {
                n = n3;
                if (list != null) {
                    int n4 = Math.min(list.size(), 3);
                    n = n3;
                    if (n4 > 0) {
                        int n5 = 1;
                        n3 = 0;
                        while (true) {
                            n = n5;
                            if (n3 >= n4) break;
                            RemoteViews remoteViews3 = this.generateActionButton(list.get(n3));
                            remoteViews2.addView(R.id.actions, remoteViews3);
                            ++n3;
                        }
                    }
                }
            }
            n = n != 0 ? n2 : 8;
            remoteViews2.setViewVisibility(R.id.actions, n);
            remoteViews2.setViewVisibility(R.id.action_divider, n);
            this.buildIntoRemoteViews(remoteViews2, remoteViews);
            return remoteViews2;
        }

        private RemoteViews generateActionButton(Action action) {
            boolean bl = action.actionIntent == null;
            String string2 = this.mBuilder.mContext.getPackageName();
            int n = bl ? R.layout.notification_action_tombstone : R.layout.notification_action;
            string2 = new RemoteViews(string2, n);
            IconCompat iconCompat = action.getIconCompat();
            if (iconCompat != null) {
                string2.setImageViewBitmap(R.id.action_image, this.createColoredBitmap(iconCompat, R.color.notification_action_color_filter));
            }
            string2.setTextViewText(R.id.action_text, action.title);
            if (!bl) {
                string2.setOnClickPendingIntent(R.id.action_container, action.actionIntent);
            }
            string2.setContentDescription(R.id.action_container, action.title);
            return string2;
        }

        private static List<Action> getNonContextualActions(List<Action> object) {
            if (object == null) {
                return null;
            }
            ArrayList<Action> arrayList = new ArrayList<Action>();
            Iterator<Action> iterator2 = object.iterator();
            while (iterator2.hasNext()) {
                object = iterator2.next();
                if (((Action)object).isContextual()) continue;
                arrayList.add((Action)object);
            }
            return arrayList;
        }

        @Override
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            notificationBuilderWithBuilderAccessor.getBuilder().setStyle(Api24Impl.createDecoratedCustomViewStyle());
        }

        @Override
        public boolean displayCustomViewInline() {
            return true;
        }

        @Override
        protected String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Override
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @Override
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @Override
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        static class Api24Impl {
            private Api24Impl() {
            }

            static Notification.Style createDecoratedCustomViewStyle() {
                return new Notification.DecoratedCustomViewStyle();
            }
        }
    }

    public static interface Extender {
        public Builder extend(Builder var1);
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface GroupAlertBehavior {
    }

    public static class InboxStyle
    extends Style {
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$InboxStyle";
        private ArrayList<CharSequence> mTexts = new ArrayList();

        public InboxStyle() {
        }

        public InboxStyle(Builder builder) {
            this.setBuilder(builder);
        }

        public InboxStyle addLine(CharSequence charSequence) {
            if (charSequence != null) {
                this.mTexts.add(Builder.limitCharSequenceLength(charSequence));
            }
            return this;
        }

        @Override
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            notificationBuilderWithBuilderAccessor = new Notification.InboxStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.mBigContentTitle);
            if (this.mSummaryTextSet) {
                notificationBuilderWithBuilderAccessor.setSummaryText(this.mSummaryText);
            }
            Iterator<CharSequence> iterator2 = this.mTexts.iterator();
            while (iterator2.hasNext()) {
                notificationBuilderWithBuilderAccessor.addLine(iterator2.next());
            }
        }

        @Override
        protected void clearCompatExtraKeys(Bundle bundle) {
            super.clearCompatExtraKeys(bundle);
            bundle.remove(NotificationCompat.EXTRA_TEXT_LINES);
        }

        @Override
        protected String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Override
        protected void restoreFromCompatExtras(Bundle bundle) {
            super.restoreFromCompatExtras(bundle);
            this.mTexts.clear();
            if (bundle.containsKey(NotificationCompat.EXTRA_TEXT_LINES)) {
                Collections.addAll(this.mTexts, bundle.getCharSequenceArray(NotificationCompat.EXTRA_TEXT_LINES));
            }
        }

        public InboxStyle setBigContentTitle(CharSequence charSequence) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        public InboxStyle setSummaryText(CharSequence charSequence) {
            this.mSummaryText = Builder.limitCharSequenceLength(charSequence);
            this.mSummaryTextSet = true;
            return this;
        }
    }

    public static class MessagingStyle
    extends Style {
        public static final int MAXIMUM_RETAINED_MESSAGES = 25;
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$MessagingStyle";
        private CharSequence mConversationTitle;
        private final List<Message> mHistoricMessages;
        private Boolean mIsGroupConversation;
        private final List<Message> mMessages = new ArrayList<Message>();
        private Person mUser;

        MessagingStyle() {
            this.mHistoricMessages = new ArrayList<Message>();
        }

        public MessagingStyle(Person person) {
            this.mHistoricMessages = new ArrayList<Message>();
            if (!TextUtils.isEmpty((CharSequence)person.getName())) {
                this.mUser = person;
                return;
            }
            throw new IllegalArgumentException("User's name must not be empty.");
        }

        @Deprecated
        public MessagingStyle(CharSequence charSequence) {
            this.mHistoricMessages = new ArrayList<Message>();
            this.mUser = new Person.Builder().setName(charSequence).build();
        }

        public static MessagingStyle extractMessagingStyleFromNotification(Notification object) {
            if ((object = Style.extractStyleFromNotification(object)) instanceof MessagingStyle) {
                return (MessagingStyle)object;
            }
            return null;
        }

        private Message findLatestIncomingMessage() {
            for (int i = this.mMessages.size() - 1; i >= 0; --i) {
                Message message = this.mMessages.get(i);
                if (message.getPerson() == null || TextUtils.isEmpty((CharSequence)message.getPerson().getName())) continue;
                return message;
            }
            if (!this.mMessages.isEmpty()) {
                return this.mMessages.get(this.mMessages.size() - 1);
            }
            return null;
        }

        private boolean hasMessagesWithoutSender() {
            for (int i = this.mMessages.size() - 1; i >= 0; --i) {
                Message message = this.mMessages.get(i);
                if (message.getPerson() == null || message.getPerson().getName() != null) continue;
                return true;
            }
            return false;
        }

        private TextAppearanceSpan makeFontColorSpan(int n) {
            return new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf((int)n), null);
        }

        private CharSequence makeMessageLine(Message object) {
            BidiFormatter bidiFormatter = BidiFormatter.getInstance();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            int n = true ? -16777216 : -1;
            Object object2 = ((Message)object).getPerson();
            String string2 = "";
            object2 = object2 == null ? "" : ((Message)object).getPerson().getName();
            int n2 = n;
            Object object3 = object2;
            if (TextUtils.isEmpty((CharSequence)object2)) {
                object3 = this.mUser.getName();
                if (true && this.mBuilder.getColor() != 0) {
                    n = this.mBuilder.getColor();
                }
                n2 = n;
            }
            object2 = bidiFormatter.unicodeWrap((CharSequence)object3);
            spannableStringBuilder.append((CharSequence)object2);
            spannableStringBuilder.setSpan((Object)this.makeFontColorSpan(n2), spannableStringBuilder.length() - object2.length(), spannableStringBuilder.length(), 33);
            object = ((Message)object).getText() == null ? string2 : ((Message)object).getText();
            spannableStringBuilder.append((CharSequence)"  ").append(bidiFormatter.unicodeWrap((CharSequence)object));
            return spannableStringBuilder;
        }

        @Override
        public void addCompatExtras(Bundle bundle) {
            super.addCompatExtras(bundle);
            bundle.putCharSequence(NotificationCompat.EXTRA_SELF_DISPLAY_NAME, this.mUser.getName());
            bundle.putBundle(NotificationCompat.EXTRA_MESSAGING_STYLE_USER, this.mUser.toBundle());
            bundle.putCharSequence(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE, this.mConversationTitle);
            if (this.mConversationTitle != null && this.mIsGroupConversation.booleanValue()) {
                bundle.putCharSequence(NotificationCompat.EXTRA_CONVERSATION_TITLE, this.mConversationTitle);
            }
            if (!this.mMessages.isEmpty()) {
                bundle.putParcelableArray(NotificationCompat.EXTRA_MESSAGES, (Parcelable[])Message.getBundleArrayForMessages(this.mMessages));
            }
            if (!this.mHistoricMessages.isEmpty()) {
                bundle.putParcelableArray(NotificationCompat.EXTRA_HISTORIC_MESSAGES, (Parcelable[])Message.getBundleArrayForMessages(this.mHistoricMessages));
            }
            if (this.mIsGroupConversation != null) {
                bundle.putBoolean(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION, this.mIsGroupConversation.booleanValue());
            }
        }

        public MessagingStyle addHistoricMessage(Message message) {
            if (message != null) {
                this.mHistoricMessages.add(message);
                if (this.mHistoricMessages.size() > 25) {
                    this.mHistoricMessages.remove(0);
                }
            }
            return this;
        }

        public MessagingStyle addMessage(Message message) {
            if (message != null) {
                this.mMessages.add(message);
                if (this.mMessages.size() > 25) {
                    this.mMessages.remove(0);
                }
            }
            return this;
        }

        public MessagingStyle addMessage(CharSequence charSequence, long l, Person person) {
            this.addMessage(new Message(charSequence, l, person));
            return this;
        }

        @Deprecated
        public MessagingStyle addMessage(CharSequence charSequence, long l, CharSequence charSequence2) {
            this.mMessages.add(new Message(charSequence, l, new Person.Builder().setName(charSequence2).build()));
            if (this.mMessages.size() > 25) {
                this.mMessages.remove(0);
            }
            return this;
        }

        @Override
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            this.setGroupConversation(this.isGroupConversation());
            Notification.MessagingStyle messagingStyle = Build.VERSION.SDK_INT >= 28 ? Api28Impl.createMessagingStyle(this.mUser.toAndroidPerson()) : Api24Impl.createMessagingStyle(this.mUser.getName());
            for (Message message : this.mMessages) {
                Api24Impl.addMessage(messagingStyle, message.toAndroidMessage());
            }
            if (Build.VERSION.SDK_INT >= 26) {
                for (Message message : this.mHistoricMessages) {
                    Api26Impl.addHistoricMessage(messagingStyle, message.toAndroidMessage());
                }
            }
            if (this.mIsGroupConversation.booleanValue() || Build.VERSION.SDK_INT >= 28) {
                Api24Impl.setConversationTitle(messagingStyle, this.mConversationTitle);
            }
            if (Build.VERSION.SDK_INT >= 28) {
                Api28Impl.setGroupConversation(messagingStyle, this.mIsGroupConversation);
            }
            notificationBuilderWithBuilderAccessor = notificationBuilderWithBuilderAccessor.getBuilder();
            ((Notification.Style)messagingStyle).setBuilder((Notification.Builder)notificationBuilderWithBuilderAccessor);
        }

        @Override
        protected void clearCompatExtraKeys(Bundle bundle) {
            super.clearCompatExtraKeys(bundle);
            bundle.remove(NotificationCompat.EXTRA_MESSAGING_STYLE_USER);
            bundle.remove(NotificationCompat.EXTRA_SELF_DISPLAY_NAME);
            bundle.remove(NotificationCompat.EXTRA_CONVERSATION_TITLE);
            bundle.remove(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE);
            bundle.remove(NotificationCompat.EXTRA_MESSAGES);
            bundle.remove(NotificationCompat.EXTRA_HISTORIC_MESSAGES);
            bundle.remove(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION);
        }

        @Override
        protected String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        public CharSequence getConversationTitle() {
            return this.mConversationTitle;
        }

        public List<Message> getHistoricMessages() {
            return this.mHistoricMessages;
        }

        public List<Message> getMessages() {
            return this.mMessages;
        }

        public Person getUser() {
            return this.mUser;
        }

        @Deprecated
        public CharSequence getUserDisplayName() {
            return this.mUser.getName();
        }

        public boolean isGroupConversation() {
            Builder builder = this.mBuilder;
            boolean bl = false;
            boolean bl2 = false;
            if (builder != null && this.mBuilder.mContext.getApplicationInfo().targetSdkVersion < 28 && this.mIsGroupConversation == null) {
                if (this.mConversationTitle != null) {
                    bl2 = true;
                }
                return bl2;
            }
            bl2 = bl;
            if (this.mIsGroupConversation != null) {
                bl2 = this.mIsGroupConversation;
            }
            return bl2;
        }

        @Override
        protected void restoreFromCompatExtras(Bundle bundle) {
            Parcelable[] parcelableArray;
            super.restoreFromCompatExtras(bundle);
            this.mMessages.clear();
            this.mUser = bundle.containsKey(NotificationCompat.EXTRA_MESSAGING_STYLE_USER) ? Person.fromBundle(bundle.getBundle(NotificationCompat.EXTRA_MESSAGING_STYLE_USER)) : new Person.Builder().setName(bundle.getString(NotificationCompat.EXTRA_SELF_DISPLAY_NAME)).build();
            this.mConversationTitle = bundle.getCharSequence(NotificationCompat.EXTRA_CONVERSATION_TITLE);
            if (this.mConversationTitle == null) {
                this.mConversationTitle = bundle.getCharSequence(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE);
            }
            if ((parcelableArray = bundle.getParcelableArray(NotificationCompat.EXTRA_MESSAGES)) != null) {
                this.mMessages.addAll(Message.getMessagesFromBundleArray(parcelableArray));
            }
            if ((parcelableArray = bundle.getParcelableArray(NotificationCompat.EXTRA_HISTORIC_MESSAGES)) != null) {
                this.mHistoricMessages.addAll(Message.getMessagesFromBundleArray(parcelableArray));
            }
            if (bundle.containsKey(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION)) {
                this.mIsGroupConversation = bundle.getBoolean(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION);
            }
        }

        public MessagingStyle setConversationTitle(CharSequence charSequence) {
            this.mConversationTitle = charSequence;
            return this;
        }

        public MessagingStyle setGroupConversation(boolean bl) {
            this.mIsGroupConversation = bl;
            return this;
        }

        static class Api24Impl {
            private Api24Impl() {
            }

            static Notification.MessagingStyle addMessage(Notification.MessagingStyle messagingStyle, Notification.MessagingStyle.Message message) {
                return messagingStyle.addMessage(message);
            }

            static Notification.MessagingStyle createMessagingStyle(CharSequence charSequence) {
                return new Notification.MessagingStyle(charSequence);
            }

            static Notification.MessagingStyle setConversationTitle(Notification.MessagingStyle messagingStyle, CharSequence charSequence) {
                return messagingStyle.setConversationTitle(charSequence);
            }
        }

        static class Api26Impl {
            private Api26Impl() {
            }

            static Notification.MessagingStyle addHistoricMessage(Notification.MessagingStyle messagingStyle, Notification.MessagingStyle.Message message) {
                return messagingStyle.addHistoricMessage(message);
            }
        }

        static class Api28Impl {
            private Api28Impl() {
            }

            static Notification.MessagingStyle createMessagingStyle(android.app.Person person) {
                return new Notification.MessagingStyle(person);
            }

            static Notification.MessagingStyle setGroupConversation(Notification.MessagingStyle messagingStyle, boolean bl) {
                return messagingStyle.setGroupConversation(bl);
            }
        }

        public static final class Message {
            static final String KEY_DATA_MIME_TYPE = "type";
            static final String KEY_DATA_URI = "uri";
            static final String KEY_EXTRAS_BUNDLE = "extras";
            static final String KEY_NOTIFICATION_PERSON = "sender_person";
            static final String KEY_PERSON = "person";
            static final String KEY_SENDER = "sender";
            static final String KEY_TEXT = "text";
            static final String KEY_TIMESTAMP = "time";
            private String mDataMimeType;
            private Uri mDataUri;
            private Bundle mExtras = new Bundle();
            private final Person mPerson;
            private final CharSequence mText;
            private final long mTimestamp;

            public Message(CharSequence charSequence, long l, Person person) {
                this.mText = charSequence;
                this.mTimestamp = l;
                this.mPerson = person;
            }

            @Deprecated
            public Message(CharSequence charSequence, long l, CharSequence charSequence2) {
                this(charSequence, l, new Person.Builder().setName(charSequence2).build());
            }

            static Bundle[] getBundleArrayForMessages(List<Message> list) {
                Bundle[] bundleArray = new Bundle[list.size()];
                int n = list.size();
                for (int i = 0; i < n; ++i) {
                    bundleArray[i] = list.get(i).toBundle();
                }
                return bundleArray;
            }

            static Message getMessageFromBundle(Bundle bundle) {
                block10: {
                    Object object;
                    try {
                        if (!bundle.containsKey(KEY_TEXT) || !bundle.containsKey(KEY_TIMESTAMP)) break block10;
                        object = null;
                    }
                    catch (ClassCastException classCastException) {
                        return null;
                    }
                    if (bundle.containsKey(KEY_PERSON)) {
                        object = Person.fromBundle(bundle.getBundle(KEY_PERSON));
                    } else if (bundle.containsKey(KEY_NOTIFICATION_PERSON) && Build.VERSION.SDK_INT >= 28) {
                        object = Person.fromAndroidPerson((android.app.Person)bundle.getParcelable(KEY_NOTIFICATION_PERSON));
                    } else if (bundle.containsKey(KEY_SENDER)) {
                        object = new Person.Builder();
                        object = ((Person.Builder)object).setName(bundle.getCharSequence(KEY_SENDER)).build();
                    }
                    Message message = new Message(bundle.getCharSequence(KEY_TEXT), bundle.getLong(KEY_TIMESTAMP), (Person)object);
                    if (bundle.containsKey(KEY_DATA_MIME_TYPE) && bundle.containsKey(KEY_DATA_URI)) {
                        message.setData(bundle.getString(KEY_DATA_MIME_TYPE), (Uri)bundle.getParcelable(KEY_DATA_URI));
                    }
                    if (bundle.containsKey(KEY_EXTRAS_BUNDLE)) {
                        message.getExtras().putAll(bundle.getBundle(KEY_EXTRAS_BUNDLE));
                    }
                    return message;
                }
                return null;
            }

            static List<Message> getMessagesFromBundleArray(Parcelable[] parcelableArray) {
                ArrayList<Message> arrayList = new ArrayList<Message>(parcelableArray.length);
                for (int i = 0; i < parcelableArray.length; ++i) {
                    Message message;
                    if (!(parcelableArray[i] instanceof Bundle) || (message = Message.getMessageFromBundle((Bundle)parcelableArray[i])) == null) continue;
                    arrayList.add(message);
                }
                return arrayList;
            }

            private Bundle toBundle() {
                Bundle bundle = new Bundle();
                if (this.mText != null) {
                    bundle.putCharSequence(KEY_TEXT, this.mText);
                }
                bundle.putLong(KEY_TIMESTAMP, this.mTimestamp);
                if (this.mPerson != null) {
                    bundle.putCharSequence(KEY_SENDER, this.mPerson.getName());
                    if (Build.VERSION.SDK_INT >= 28) {
                        bundle.putParcelable(KEY_NOTIFICATION_PERSON, Api28Impl.castToParcelable(this.mPerson.toAndroidPerson()));
                    } else {
                        bundle.putBundle(KEY_PERSON, this.mPerson.toBundle());
                    }
                }
                if (this.mDataMimeType != null) {
                    bundle.putString(KEY_DATA_MIME_TYPE, this.mDataMimeType);
                }
                if (this.mDataUri != null) {
                    bundle.putParcelable(KEY_DATA_URI, (Parcelable)this.mDataUri);
                }
                if (this.mExtras != null) {
                    bundle.putBundle(KEY_EXTRAS_BUNDLE, this.mExtras);
                }
                return bundle;
            }

            public String getDataMimeType() {
                return this.mDataMimeType;
            }

            public Uri getDataUri() {
                return this.mDataUri;
            }

            public Bundle getExtras() {
                return this.mExtras;
            }

            public Person getPerson() {
                return this.mPerson;
            }

            @Deprecated
            public CharSequence getSender() {
                CharSequence charSequence = this.mPerson == null ? null : this.mPerson.getName();
                return charSequence;
            }

            public CharSequence getText() {
                return this.mText;
            }

            public long getTimestamp() {
                return this.mTimestamp;
            }

            public Message setData(String string2, Uri uri) {
                this.mDataMimeType = string2;
                this.mDataUri = uri;
                return this;
            }

            Notification.MessagingStyle.Message toAndroidMessage() {
                Person person = this.getPerson();
                int n = Build.VERSION.SDK_INT;
                CharSequence charSequence = null;
                CharSequence charSequence2 = null;
                if (n >= 28) {
                    charSequence = this.getText();
                    long l = this.getTimestamp();
                    if (person != null) {
                        charSequence2 = person.toAndroidPerson();
                    }
                    charSequence2 = Api28Impl.createMessage(charSequence, l, (android.app.Person)charSequence2);
                } else {
                    CharSequence charSequence3 = this.getText();
                    long l = this.getTimestamp();
                    charSequence2 = person == null ? charSequence : person.getName();
                    charSequence2 = Api24Impl.createMessage(charSequence3, l, charSequence2);
                }
                if (this.getDataMimeType() != null) {
                    Api24Impl.setData((Notification.MessagingStyle.Message)charSequence2, this.getDataMimeType(), this.getDataUri());
                }
                return charSequence2;
            }

            static class Api24Impl {
                private Api24Impl() {
                }

                static Notification.MessagingStyle.Message createMessage(CharSequence charSequence, long l, CharSequence charSequence2) {
                    return new Notification.MessagingStyle.Message(charSequence, l, charSequence2);
                }

                static Notification.MessagingStyle.Message setData(Notification.MessagingStyle.Message message, String string2, Uri uri) {
                    return message.setData(string2, uri);
                }
            }

            static class Api28Impl {
                private Api28Impl() {
                }

                static Parcelable castToParcelable(android.app.Person person) {
                    return person;
                }

                static Notification.MessagingStyle.Message createMessage(CharSequence charSequence, long l, android.app.Person person) {
                    return new Notification.MessagingStyle.Message(charSequence, l, person);
                }
            }
        }
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface NotificationVisibility {
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface ServiceNotificationBehavior {
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface StreamType {
    }

    public static abstract class Style {
        CharSequence mBigContentTitle;
        protected Builder mBuilder;
        CharSequence mSummaryText;
        boolean mSummaryTextSet = false;

        private int calculateTopPadding() {
            Resources resources = this.mBuilder.mContext.getResources();
            int n = resources.getDimensionPixelSize(R.dimen.notification_top_pad);
            int n2 = resources.getDimensionPixelSize(R.dimen.notification_top_pad_large_text);
            float f = (Style.constrain(resources.getConfiguration().fontScale, 1.0f, 1.3f) - 1.0f) / 0.29999995f;
            return Math.round((1.0f - f) * (float)n + (float)n2 * f);
        }

        private static float constrain(float f, float f2, float f3) {
            block1: {
                block0: {
                    if (!(f < f2)) break block0;
                    f = f2;
                    break block1;
                }
                if (!(f > f3)) break block1;
                f = f3;
            }
            return f;
        }

        /*
         * Enabled aggressive block sorting
         */
        static Style constructCompatStyleByName(String string2) {
            int n;
            block16: {
                if (string2 == null) return null;
                switch (string2.hashCode()) {
                    case 2090799565: {
                        if (!string2.equals("androidx.core.app.NotificationCompat$MessagingStyle")) break;
                        n = 4;
                        break block16;
                    }
                    case 919595044: {
                        if (!string2.equals("androidx.core.app.NotificationCompat$BigTextStyle")) break;
                        n = 0;
                        break block16;
                    }
                    case 912942987: {
                        if (!string2.equals("androidx.core.app.NotificationCompat$InboxStyle")) break;
                        n = 2;
                        break block16;
                    }
                    case 714386739: {
                        if (!string2.equals("androidx.core.app.NotificationCompat$CallStyle")) break;
                        n = 5;
                        break block16;
                    }
                    case -171946061: {
                        if (!string2.equals("androidx.core.app.NotificationCompat$BigPictureStyle")) break;
                        n = 1;
                        break block16;
                    }
                    case -716705180: {
                        if (!string2.equals("androidx.core.app.NotificationCompat$DecoratedCustomViewStyle")) break;
                        n = 3;
                        break block16;
                    }
                }
                n = -1;
            }
            switch (n) {
                default: {
                    return null;
                }
                case 5: {
                    return new CallStyle();
                }
                case 4: {
                    return new MessagingStyle();
                }
                case 3: {
                    return new DecoratedCustomViewStyle();
                }
                case 2: {
                    return new InboxStyle();
                }
                case 1: {
                    return new BigPictureStyle();
                }
                case 0: 
            }
            return new BigTextStyle();
        }

        private static Style constructCompatStyleByPlatformName(String string2) {
            if (string2 == null) {
                return null;
            }
            if (string2.equals(Notification.BigPictureStyle.class.getName())) {
                return new BigPictureStyle();
            }
            if (string2.equals(Notification.BigTextStyle.class.getName())) {
                return new BigTextStyle();
            }
            if (string2.equals(Notification.InboxStyle.class.getName())) {
                return new InboxStyle();
            }
            if (string2.equals(Notification.MessagingStyle.class.getName())) {
                return new MessagingStyle();
            }
            if (string2.equals(Notification.DecoratedCustomViewStyle.class.getName())) {
                return new DecoratedCustomViewStyle();
            }
            return null;
        }

        static Style constructCompatStyleForBundle(Bundle bundle) {
            Style style2 = Style.constructCompatStyleByName(bundle.getString(NotificationCompat.EXTRA_COMPAT_TEMPLATE));
            if (style2 != null) {
                return style2;
            }
            if (!bundle.containsKey(NotificationCompat.EXTRA_SELF_DISPLAY_NAME) && !bundle.containsKey(NotificationCompat.EXTRA_MESSAGING_STYLE_USER)) {
                if (!bundle.containsKey(NotificationCompat.EXTRA_PICTURE) && !bundle.containsKey(NotificationCompat.EXTRA_PICTURE_ICON)) {
                    if (bundle.containsKey(NotificationCompat.EXTRA_BIG_TEXT)) {
                        return new BigTextStyle();
                    }
                    if (bundle.containsKey(NotificationCompat.EXTRA_TEXT_LINES)) {
                        return new InboxStyle();
                    }
                    if (bundle.containsKey(NotificationCompat.EXTRA_CALL_TYPE)) {
                        return new CallStyle();
                    }
                    return Style.constructCompatStyleByPlatformName(bundle.getString(NotificationCompat.EXTRA_TEMPLATE));
                }
                return new BigPictureStyle();
            }
            return new MessagingStyle();
        }

        static Style constructStyleForExtras(Bundle bundle) {
            Style style2 = Style.constructCompatStyleForBundle(bundle);
            if (style2 == null) {
                return null;
            }
            try {
                style2.restoreFromCompatExtras(bundle);
                return style2;
            }
            catch (ClassCastException classCastException) {
                return null;
            }
        }

        private Bitmap createColoredBitmap(int n, int n2, int n3) {
            return this.createColoredBitmap(IconCompat.createWithResource(this.mBuilder.mContext, n), n2, n3);
        }

        private Bitmap createColoredBitmap(IconCompat iconCompat, int n, int n2) {
            iconCompat = iconCompat.loadDrawable(this.mBuilder.mContext);
            int n3 = n2 == 0 ? iconCompat.getIntrinsicWidth() : n2;
            if (n2 == 0) {
                n2 = iconCompat.getIntrinsicHeight();
            }
            Bitmap bitmap = Bitmap.createBitmap((int)n3, (int)n2, (Bitmap.Config)Bitmap.Config.ARGB_8888);
            iconCompat.setBounds(0, 0, n3, n2);
            if (n != 0) {
                iconCompat.mutate().setColorFilter((ColorFilter)new PorterDuffColorFilter(n, PorterDuff.Mode.SRC_IN));
            }
            iconCompat.draw(new Canvas(bitmap));
            return bitmap;
        }

        private Bitmap createIconWithBackground(int n, int n2, int n3, int n4) {
            int n5 = R.drawable.notification_icon_background;
            if (n4 == 0) {
                n4 = 0;
            }
            Bitmap bitmap = this.createColoredBitmap(n5, n4, n2);
            Canvas canvas = new Canvas(bitmap);
            Drawable drawable2 = this.mBuilder.mContext.getResources().getDrawable(n).mutate();
            drawable2.setFilterBitmap(true);
            n = (n2 - n3) / 2;
            drawable2.setBounds(n, n, n3 + n, n3 + n);
            drawable2.setColorFilter((ColorFilter)new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
            drawable2.draw(canvas);
            return bitmap;
        }

        public static Style extractStyleFromNotification(Notification notification) {
            if ((notification = NotificationCompat.getExtras(notification)) == null) {
                return null;
            }
            return Style.constructStyleForExtras((Bundle)notification);
        }

        private void hideNormalContent(RemoteViews remoteViews) {
            remoteViews.setViewVisibility(R.id.title, 8);
            remoteViews.setViewVisibility(R.id.text2, 8);
            remoteViews.setViewVisibility(R.id.text, 8);
        }

        public void addCompatExtras(Bundle bundle) {
            String string2;
            if (this.mSummaryTextSet) {
                bundle.putCharSequence(NotificationCompat.EXTRA_SUMMARY_TEXT, this.mSummaryText);
            }
            if (this.mBigContentTitle != null) {
                bundle.putCharSequence(NotificationCompat.EXTRA_TITLE_BIG, this.mBigContentTitle);
            }
            if ((string2 = this.getClassName()) != null) {
                bundle.putString(NotificationCompat.EXTRA_COMPAT_TEMPLATE, string2);
            }
        }

        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        }

        /*
         * Unable to fully structure code
         */
        public RemoteViews applyStandardTemplate(boolean var1_1, int var2_2, boolean var3_3) {
            var11_4 = this.mBuilder.mContext.getResources();
            var10_5 = new RemoteViews(this.mBuilder.mContext.getPackageName(), var2_2);
            var5_6 = false;
            var2_2 = this.mBuilder.getPriority();
            var7_7 = 0;
            if (var2_2 < -1) {
                var9_8 = true;
            } else {
                var9_9 = false;
            }
            if (this.mBuilder.mLargeIcon != null) {
                var10_5.setViewVisibility(R.id.icon, 0);
                var10_5.setImageViewBitmap(R.id.icon, this.createColoredBitmap(this.mBuilder.mLargeIcon, 0));
                if (var1_1 && this.mBuilder.mNotification.icon != 0) {
                    var6_10 = var11_4.getDimensionPixelSize(R.dimen.notification_right_icon_size);
                    var2_2 = var11_4.getDimensionPixelSize(R.dimen.notification_small_icon_background_padding);
                    var12_11 = this.createIconWithBackground(this.mBuilder.mNotification.icon, var6_10, var6_10 - var2_2 * 2, this.mBuilder.getColor());
                    var10_5.setImageViewBitmap(R.id.right_icon, (Bitmap)var12_11);
                    var10_5.setViewVisibility(R.id.right_icon, 0);
                }
            } else if (var1_1 && this.mBuilder.mNotification.icon != 0) {
                var10_5.setViewVisibility(R.id.icon, 0);
                var8_12 = var11_4.getDimensionPixelSize(R.dimen.notification_large_icon_width);
                var6_10 = var11_4.getDimensionPixelSize(R.dimen.notification_big_circle_margin);
                var2_2 = var11_4.getDimensionPixelSize(R.dimen.notification_small_icon_size_as_large);
                var12_11 = this.createIconWithBackground(this.mBuilder.mNotification.icon, var8_12 - var6_10, var2_2, this.mBuilder.getColor());
                var10_5.setImageViewBitmap(R.id.icon, (Bitmap)var12_11);
            }
            if (this.mBuilder.mContentTitle != null) {
                var10_5.setTextViewText(R.id.title, this.mBuilder.mContentTitle);
            }
            if (this.mBuilder.mContentText != null) {
                var10_5.setTextViewText(R.id.text, this.mBuilder.mContentText);
                var5_6 = true;
            }
            if (this.mBuilder.mContentInfo != null) {
                var10_5.setTextViewText(R.id.info, this.mBuilder.mContentInfo);
                var10_5.setViewVisibility(R.id.info, 0);
                var5_6 = true;
                var2_2 = 1;
            } else if (this.mBuilder.mNumber > 0) {
                var2_2 = var11_4.getInteger(R.integer.status_bar_notification_info_maxnum);
                if (this.mBuilder.mNumber > var2_2) {
                    var10_5.setTextViewText(R.id.info, (CharSequence)var11_4.getString(R.string.status_bar_notification_info_overflow));
                } else {
                    var12_11 = NumberFormat.getIntegerInstance();
                    var10_5.setTextViewText(R.id.info, (CharSequence)var12_11.format(this.mBuilder.mNumber));
                }
                var10_5.setViewVisibility(R.id.info, 0);
                var5_6 = true;
                var2_2 = 1;
            } else {
                var10_5.setViewVisibility(R.id.info, 8);
                var2_2 = 0;
            }
            if (this.mBuilder.mSubText == null) ** GOTO lbl59
            var10_5.setTextViewText(R.id.text, this.mBuilder.mSubText);
            if (this.mBuilder.mContentText != null) {
                var10_5.setTextViewText(R.id.text2, this.mBuilder.mContentText);
                var10_5.setViewVisibility(R.id.text2, 0);
                var6_10 = 1;
            } else {
                var10_5.setViewVisibility(R.id.text2, 8);
lbl59:
                // 2 sources

                var6_10 = 0;
            }
            if (var6_10 != 0) {
                if (var3_3) {
                    var4_13 = var11_4.getDimensionPixelSize(R.dimen.notification_subtext_size);
                    var10_5.setTextViewTextSize(R.id.text, 0, var4_13);
                }
                var10_5.setViewPadding(R.id.line1, 0, 0, 0, 0);
            }
            if (this.mBuilder.getWhenIfShowing() != 0L) {
                if (this.mBuilder.mUseChronometer) {
                    var10_5.setViewVisibility(R.id.chronometer, 0);
                    var10_5.setLong(R.id.chronometer, "setBase", this.mBuilder.getWhenIfShowing() + (SystemClock.elapsedRealtime() - System.currentTimeMillis()));
                    var10_5.setBoolean(R.id.chronometer, "setStarted", true);
                    if (this.mBuilder.mChronometerCountDown) {
                        Api24Impl.setChronometerCountDown(var10_5, R.id.chronometer, this.mBuilder.mChronometerCountDown);
                    }
                } else {
                    var10_5.setViewVisibility(R.id.time, 0);
                    var10_5.setLong(R.id.time, "setTime", this.mBuilder.getWhenIfShowing());
                }
                var2_2 = 1;
            }
            var6_10 = R.id.right_side;
            var2_2 = var2_2 != 0 ? 0 : 8;
            var10_5.setViewVisibility(var6_10, var2_2);
            var6_10 = R.id.line3;
            var2_2 = var5_6 != false ? var7_7 : 8;
            var10_5.setViewVisibility(var6_10, var2_2);
            return var10_5;
        }

        public Notification build() {
            Notification notification = null;
            if (this.mBuilder != null) {
                notification = this.mBuilder.build();
            }
            return notification;
        }

        public void buildIntoRemoteViews(RemoteViews remoteViews, RemoteViews remoteViews2) {
            this.hideNormalContent(remoteViews);
            remoteViews.removeAllViews(R.id.notification_main_column);
            remoteViews.addView(R.id.notification_main_column, remoteViews2.clone());
            remoteViews.setViewVisibility(R.id.notification_main_column, 0);
            int n = this.calculateTopPadding();
            remoteViews.setViewPadding(R.id.notification_main_column_container, 0, n, 0, 0);
        }

        protected void clearCompatExtraKeys(Bundle bundle) {
            bundle.remove(NotificationCompat.EXTRA_SUMMARY_TEXT);
            bundle.remove(NotificationCompat.EXTRA_TITLE_BIG);
            bundle.remove(NotificationCompat.EXTRA_COMPAT_TEMPLATE);
        }

        public Bitmap createColoredBitmap(int n, int n2) {
            return this.createColoredBitmap(n, n2, 0);
        }

        Bitmap createColoredBitmap(IconCompat iconCompat, int n) {
            return this.createColoredBitmap(iconCompat, n, 0);
        }

        public boolean displayCustomViewInline() {
            return false;
        }

        protected String getClassName() {
            return null;
        }

        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        protected void restoreFromCompatExtras(Bundle bundle) {
            if (bundle.containsKey(NotificationCompat.EXTRA_SUMMARY_TEXT)) {
                this.mSummaryText = bundle.getCharSequence(NotificationCompat.EXTRA_SUMMARY_TEXT);
                this.mSummaryTextSet = true;
            }
            this.mBigContentTitle = bundle.getCharSequence(NotificationCompat.EXTRA_TITLE_BIG);
        }

        public void setBuilder(Builder builder) {
            if (this.mBuilder != builder) {
                this.mBuilder = builder;
                if (this.mBuilder != null) {
                    this.mBuilder.setStyle(this);
                }
            }
        }

        static class Api24Impl {
            private Api24Impl() {
            }

            static void setChronometerCountDown(RemoteViews remoteViews, int n, boolean bl) {
                remoteViews.setChronometerCountDown(n, bl);
            }
        }
    }

    public static final class TvExtender
    implements Extender {
        static final String EXTRA_CHANNEL_ID = "channel_id";
        static final String EXTRA_CONTENT_INTENT = "content_intent";
        static final String EXTRA_DELETE_INTENT = "delete_intent";
        private static final String EXTRA_FLAGS = "flags";
        static final String EXTRA_SUPPRESS_SHOW_OVER_APPS = "suppressShowOverApps";
        static final String EXTRA_TV_EXTENDER = "android.tv.EXTENSIONS";
        private static final int FLAG_AVAILABLE_ON_TV = 1;
        private static final String TAG = "TvExtender";
        private String mChannelId;
        private PendingIntent mContentIntent;
        private PendingIntent mDeleteIntent;
        private int mFlags;
        private boolean mSuppressShowOverApps;

        public TvExtender() {
            this.mFlags = 1;
        }

        public TvExtender(Notification object) {
            if (Build.VERSION.SDK_INT < 26) {
                return;
            }
            object = object.extras == null ? null : object.extras.getBundle(EXTRA_TV_EXTENDER);
            if (object != null) {
                this.mFlags = object.getInt(EXTRA_FLAGS);
                this.mChannelId = object.getString(EXTRA_CHANNEL_ID);
                this.mSuppressShowOverApps = object.getBoolean(EXTRA_SUPPRESS_SHOW_OVER_APPS);
                this.mContentIntent = (PendingIntent)object.getParcelable(EXTRA_CONTENT_INTENT);
                this.mDeleteIntent = (PendingIntent)object.getParcelable(EXTRA_DELETE_INTENT);
            }
        }

        @Override
        public Builder extend(Builder builder) {
            if (Build.VERSION.SDK_INT < 26) {
                return builder;
            }
            Bundle bundle = new Bundle();
            bundle.putInt(EXTRA_FLAGS, this.mFlags);
            bundle.putString(EXTRA_CHANNEL_ID, this.mChannelId);
            bundle.putBoolean(EXTRA_SUPPRESS_SHOW_OVER_APPS, this.mSuppressShowOverApps);
            if (this.mContentIntent != null) {
                bundle.putParcelable(EXTRA_CONTENT_INTENT, (Parcelable)this.mContentIntent);
            }
            if (this.mDeleteIntent != null) {
                bundle.putParcelable(EXTRA_DELETE_INTENT, (Parcelable)this.mDeleteIntent);
            }
            builder.getExtras().putBundle(EXTRA_TV_EXTENDER, bundle);
            return builder;
        }

        public String getChannelId() {
            return this.mChannelId;
        }

        public PendingIntent getContentIntent() {
            return this.mContentIntent;
        }

        public PendingIntent getDeleteIntent() {
            return this.mDeleteIntent;
        }

        public boolean isAvailableOnTv() {
            int n = this.mFlags;
            boolean bl = true;
            if ((n & 1) == 0) {
                bl = false;
            }
            return bl;
        }

        public boolean isSuppressShowOverApps() {
            return this.mSuppressShowOverApps;
        }

        public TvExtender setChannelId(String string2) {
            this.mChannelId = string2;
            return this;
        }

        public TvExtender setContentIntent(PendingIntent pendingIntent) {
            this.mContentIntent = pendingIntent;
            return this;
        }

        public TvExtender setDeleteIntent(PendingIntent pendingIntent) {
            this.mDeleteIntent = pendingIntent;
            return this;
        }

        public TvExtender setSuppressShowOverApps(boolean bl) {
            this.mSuppressShowOverApps = bl;
            return this;
        }
    }

    public static final class WearableExtender
    implements Extender {
        private static final int DEFAULT_CONTENT_ICON_GRAVITY = 0x800005;
        private static final int DEFAULT_FLAGS = 1;
        private static final int DEFAULT_GRAVITY = 80;
        private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
        private static final int FLAG_BIG_PICTURE_AMBIENT = 32;
        private static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
        private static final int FLAG_HINT_AVOID_BACKGROUND_CLIPPING = 16;
        private static final int FLAG_HINT_CONTENT_INTENT_LAUNCHES_ACTIVITY = 64;
        private static final int FLAG_HINT_HIDE_ICON = 2;
        private static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
        private static final int FLAG_START_SCROLL_BOTTOM = 8;
        private static final String KEY_ACTIONS = "actions";
        private static final String KEY_BACKGROUND = "background";
        private static final String KEY_BRIDGE_TAG = "bridgeTag";
        private static final String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
        private static final String KEY_CONTENT_ICON = "contentIcon";
        private static final String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
        private static final String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
        private static final String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
        private static final String KEY_DISMISSAL_ID = "dismissalId";
        private static final String KEY_DISPLAY_INTENT = "displayIntent";
        private static final String KEY_FLAGS = "flags";
        private static final String KEY_GRAVITY = "gravity";
        private static final String KEY_HINT_SCREEN_TIMEOUT = "hintScreenTimeout";
        private static final String KEY_PAGES = "pages";
        @Deprecated
        public static final int SCREEN_TIMEOUT_LONG = -1;
        @Deprecated
        public static final int SCREEN_TIMEOUT_SHORT = 0;
        @Deprecated
        public static final int SIZE_DEFAULT = 0;
        @Deprecated
        public static final int SIZE_FULL_SCREEN = 5;
        @Deprecated
        public static final int SIZE_LARGE = 4;
        @Deprecated
        public static final int SIZE_MEDIUM = 3;
        @Deprecated
        public static final int SIZE_SMALL = 2;
        @Deprecated
        public static final int SIZE_XSMALL = 1;
        public static final int UNSET_ACTION_INDEX = -1;
        private ArrayList<Action> mActions = new ArrayList();
        private Bitmap mBackground;
        private String mBridgeTag;
        private int mContentActionIndex = -1;
        private int mContentIcon;
        private int mContentIconGravity = 0x800005;
        private int mCustomContentHeight;
        private int mCustomSizePreset = 0;
        private String mDismissalId;
        private PendingIntent mDisplayIntent;
        private int mFlags = 1;
        private int mGravity = 80;
        private int mHintScreenTimeout;
        private ArrayList<Notification> mPages = new ArrayList();

        public WearableExtender() {
        }

        public WearableExtender(Notification object) {
            object = NotificationCompat.getExtras(object);
            object = object != null ? object.getBundle(EXTRA_WEARABLE_EXTENSIONS) : null;
            if (object != null) {
                Action[] actionArray;
                ArrayList arrayList = object.getParcelableArrayList(KEY_ACTIONS);
                if (arrayList != null) {
                    actionArray = new Action[arrayList.size()];
                    for (int i = 0; i < actionArray.length; ++i) {
                        actionArray[i] = Api20Impl.getActionCompatFromAction(arrayList, i);
                    }
                    Collections.addAll(this.mActions, actionArray);
                }
                this.mFlags = object.getInt(KEY_FLAGS, 1);
                this.mDisplayIntent = (PendingIntent)object.getParcelable(KEY_DISPLAY_INTENT);
                actionArray = NotificationCompat.getNotificationArrayFromBundle((Bundle)object, KEY_PAGES);
                if (actionArray != null) {
                    Collections.addAll(this.mPages, actionArray);
                }
                this.mBackground = (Bitmap)object.getParcelable(KEY_BACKGROUND);
                this.mContentIcon = object.getInt(KEY_CONTENT_ICON);
                this.mContentIconGravity = object.getInt(KEY_CONTENT_ICON_GRAVITY, 0x800005);
                this.mContentActionIndex = object.getInt(KEY_CONTENT_ACTION_INDEX, -1);
                this.mCustomSizePreset = object.getInt(KEY_CUSTOM_SIZE_PRESET, 0);
                this.mCustomContentHeight = object.getInt(KEY_CUSTOM_CONTENT_HEIGHT);
                this.mGravity = object.getInt(KEY_GRAVITY, 80);
                this.mHintScreenTimeout = object.getInt(KEY_HINT_SCREEN_TIMEOUT);
                this.mDismissalId = object.getString(KEY_DISMISSAL_ID);
                this.mBridgeTag = object.getString(KEY_BRIDGE_TAG);
            }
        }

        private static Notification.Action getActionFromActionCompat(Action remoteInputArray) {
            IconCompat iconCompat = remoteInputArray.getIconCompat();
            iconCompat = iconCompat == null ? null : iconCompat.toIcon();
            Notification.Action.Builder builder = Api23Impl.createBuilder((Icon)iconCompat, remoteInputArray.getTitle(), remoteInputArray.getActionIntent());
            iconCompat = remoteInputArray.getExtras() != null ? new Bundle(remoteInputArray.getExtras()) : new Bundle();
            iconCompat.putBoolean("android.support.allowGeneratedReplies", remoteInputArray.getAllowGeneratedReplies());
            Api24Impl.setAllowGeneratedReplies(builder, remoteInputArray.getAllowGeneratedReplies());
            if (Build.VERSION.SDK_INT >= 31) {
                Api31Impl.setAuthenticationRequired(builder, remoteInputArray.isAuthenticationRequired());
            }
            Api20Impl.addExtras(builder, (Bundle)iconCompat);
            remoteInputArray = remoteInputArray.getRemoteInputs();
            if (remoteInputArray != null) {
                remoteInputArray = RemoteInput.fromCompat(remoteInputArray);
                int n = remoteInputArray.length;
                for (int i = 0; i < n; ++i) {
                    Api20Impl.addRemoteInput(builder, (android.app.RemoteInput)remoteInputArray[i]);
                }
            }
            return Api20Impl.build(builder);
        }

        private void setFlag(int n, boolean bl) {
            this.mFlags = bl ? (this.mFlags |= n) : (this.mFlags &= ~n);
        }

        public WearableExtender addAction(Action action) {
            this.mActions.add(action);
            return this;
        }

        public WearableExtender addActions(List<Action> list) {
            this.mActions.addAll(list);
            return this;
        }

        @Deprecated
        public WearableExtender addPage(Notification notification) {
            this.mPages.add(notification);
            return this;
        }

        @Deprecated
        public WearableExtender addPages(List<Notification> list) {
            this.mPages.addAll(list);
            return this;
        }

        public WearableExtender clearActions() {
            this.mActions.clear();
            return this;
        }

        @Deprecated
        public WearableExtender clearPages() {
            this.mPages.clear();
            return this;
        }

        public WearableExtender clone() {
            WearableExtender wearableExtender = new WearableExtender();
            wearableExtender.mActions = new ArrayList<Action>(this.mActions);
            wearableExtender.mFlags = this.mFlags;
            wearableExtender.mDisplayIntent = this.mDisplayIntent;
            wearableExtender.mPages = new ArrayList<Notification>(this.mPages);
            wearableExtender.mBackground = this.mBackground;
            wearableExtender.mContentIcon = this.mContentIcon;
            wearableExtender.mContentIconGravity = this.mContentIconGravity;
            wearableExtender.mContentActionIndex = this.mContentActionIndex;
            wearableExtender.mCustomSizePreset = this.mCustomSizePreset;
            wearableExtender.mCustomContentHeight = this.mCustomContentHeight;
            wearableExtender.mGravity = this.mGravity;
            wearableExtender.mHintScreenTimeout = this.mHintScreenTimeout;
            wearableExtender.mDismissalId = this.mDismissalId;
            wearableExtender.mBridgeTag = this.mBridgeTag;
            return wearableExtender;
        }

        @Override
        public Builder extend(Builder builder) {
            Bundle bundle = new Bundle();
            if (!this.mActions.isEmpty()) {
                ArrayList<Notification.Action> arrayList = new ArrayList<Notification.Action>(this.mActions.size());
                for (Action action : this.mActions) {
                    arrayList.add(WearableExtender.getActionFromActionCompat(action));
                }
                bundle.putParcelableArrayList(KEY_ACTIONS, arrayList);
            }
            if (this.mFlags != 1) {
                bundle.putInt(KEY_FLAGS, this.mFlags);
            }
            if (this.mDisplayIntent != null) {
                bundle.putParcelable(KEY_DISPLAY_INTENT, (Parcelable)this.mDisplayIntent);
            }
            if (!this.mPages.isEmpty()) {
                bundle.putParcelableArray(KEY_PAGES, (Parcelable[])this.mPages.toArray(new Notification[this.mPages.size()]));
            }
            if (this.mBackground != null) {
                bundle.putParcelable(KEY_BACKGROUND, (Parcelable)this.mBackground);
            }
            if (this.mContentIcon != 0) {
                bundle.putInt(KEY_CONTENT_ICON, this.mContentIcon);
            }
            if (this.mContentIconGravity != 0x800005) {
                bundle.putInt(KEY_CONTENT_ICON_GRAVITY, this.mContentIconGravity);
            }
            if (this.mContentActionIndex != -1) {
                bundle.putInt(KEY_CONTENT_ACTION_INDEX, this.mContentActionIndex);
            }
            if (this.mCustomSizePreset != 0) {
                bundle.putInt(KEY_CUSTOM_SIZE_PRESET, this.mCustomSizePreset);
            }
            if (this.mCustomContentHeight != 0) {
                bundle.putInt(KEY_CUSTOM_CONTENT_HEIGHT, this.mCustomContentHeight);
            }
            if (this.mGravity != 80) {
                bundle.putInt(KEY_GRAVITY, this.mGravity);
            }
            if (this.mHintScreenTimeout != 0) {
                bundle.putInt(KEY_HINT_SCREEN_TIMEOUT, this.mHintScreenTimeout);
            }
            if (this.mDismissalId != null) {
                bundle.putString(KEY_DISMISSAL_ID, this.mDismissalId);
            }
            if (this.mBridgeTag != null) {
                bundle.putString(KEY_BRIDGE_TAG, this.mBridgeTag);
            }
            builder.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, bundle);
            return builder;
        }

        public List<Action> getActions() {
            return this.mActions;
        }

        @Deprecated
        public Bitmap getBackground() {
            return this.mBackground;
        }

        public String getBridgeTag() {
            return this.mBridgeTag;
        }

        public int getContentAction() {
            return this.mContentActionIndex;
        }

        @Deprecated
        public int getContentIcon() {
            return this.mContentIcon;
        }

        @Deprecated
        public int getContentIconGravity() {
            return this.mContentIconGravity;
        }

        public boolean getContentIntentAvailableOffline() {
            int n = this.mFlags;
            boolean bl = true;
            if ((n & 1) == 0) {
                bl = false;
            }
            return bl;
        }

        @Deprecated
        public int getCustomContentHeight() {
            return this.mCustomContentHeight;
        }

        @Deprecated
        public int getCustomSizePreset() {
            return this.mCustomSizePreset;
        }

        public String getDismissalId() {
            return this.mDismissalId;
        }

        @Deprecated
        public PendingIntent getDisplayIntent() {
            return this.mDisplayIntent;
        }

        @Deprecated
        public int getGravity() {
            return this.mGravity;
        }

        @Deprecated
        public boolean getHintAmbientBigPicture() {
            boolean bl = (this.mFlags & 0x20) != 0;
            return bl;
        }

        @Deprecated
        public boolean getHintAvoidBackgroundClipping() {
            boolean bl = (this.mFlags & 0x10) != 0;
            return bl;
        }

        public boolean getHintContentIntentLaunchesActivity() {
            boolean bl = (this.mFlags & 0x40) != 0;
            return bl;
        }

        @Deprecated
        public boolean getHintHideIcon() {
            boolean bl = (this.mFlags & 2) != 0;
            return bl;
        }

        @Deprecated
        public int getHintScreenTimeout() {
            return this.mHintScreenTimeout;
        }

        @Deprecated
        public boolean getHintShowBackgroundOnly() {
            boolean bl = (this.mFlags & 4) != 0;
            return bl;
        }

        @Deprecated
        public List<Notification> getPages() {
            return this.mPages;
        }

        public boolean getStartScrollBottom() {
            boolean bl = (this.mFlags & 8) != 0;
            return bl;
        }

        @Deprecated
        public WearableExtender setBackground(Bitmap bitmap) {
            this.mBackground = bitmap;
            return this;
        }

        public WearableExtender setBridgeTag(String string2) {
            this.mBridgeTag = string2;
            return this;
        }

        public WearableExtender setContentAction(int n) {
            this.mContentActionIndex = n;
            return this;
        }

        @Deprecated
        public WearableExtender setContentIcon(int n) {
            this.mContentIcon = n;
            return this;
        }

        @Deprecated
        public WearableExtender setContentIconGravity(int n) {
            this.mContentIconGravity = n;
            return this;
        }

        public WearableExtender setContentIntentAvailableOffline(boolean bl) {
            this.setFlag(1, bl);
            return this;
        }

        @Deprecated
        public WearableExtender setCustomContentHeight(int n) {
            this.mCustomContentHeight = n;
            return this;
        }

        @Deprecated
        public WearableExtender setCustomSizePreset(int n) {
            this.mCustomSizePreset = n;
            return this;
        }

        public WearableExtender setDismissalId(String string2) {
            this.mDismissalId = string2;
            return this;
        }

        @Deprecated
        public WearableExtender setDisplayIntent(PendingIntent pendingIntent) {
            this.mDisplayIntent = pendingIntent;
            return this;
        }

        @Deprecated
        public WearableExtender setGravity(int n) {
            this.mGravity = n;
            return this;
        }

        @Deprecated
        public WearableExtender setHintAmbientBigPicture(boolean bl) {
            this.setFlag(32, bl);
            return this;
        }

        @Deprecated
        public WearableExtender setHintAvoidBackgroundClipping(boolean bl) {
            this.setFlag(16, bl);
            return this;
        }

        public WearableExtender setHintContentIntentLaunchesActivity(boolean bl) {
            this.setFlag(64, bl);
            return this;
        }

        @Deprecated
        public WearableExtender setHintHideIcon(boolean bl) {
            this.setFlag(2, bl);
            return this;
        }

        @Deprecated
        public WearableExtender setHintScreenTimeout(int n) {
            this.mHintScreenTimeout = n;
            return this;
        }

        @Deprecated
        public WearableExtender setHintShowBackgroundOnly(boolean bl) {
            this.setFlag(4, bl);
            return this;
        }

        public WearableExtender setStartScrollBottom(boolean bl) {
            this.setFlag(8, bl);
            return this;
        }

        static class Api20Impl {
            private Api20Impl() {
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

            public static Action getActionCompatFromAction(ArrayList<Parcelable> arrayList, int n) {
                return NotificationCompat.getActionCompatFromAction((Notification.Action)arrayList.get(n));
            }
        }

        static class Api23Impl {
            private Api23Impl() {
            }

            static Notification.Action.Builder createBuilder(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
                return new Notification.Action.Builder(icon, charSequence, pendingIntent);
            }
        }

        static class Api24Impl {
            private Api24Impl() {
            }

            static Notification.Action.Builder setAllowGeneratedReplies(Notification.Action.Builder builder, boolean bl) {
                return builder.setAllowGeneratedReplies(bl);
            }
        }

        static class Api31Impl {
            private Api31Impl() {
            }

            static Notification.Action.Builder setAuthenticationRequired(Notification.Action.Builder builder, boolean bl) {
                return builder.setAuthenticationRequired(bl);
            }
        }
    }
}

