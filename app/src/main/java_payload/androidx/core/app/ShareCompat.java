/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ClipData
 *  android.content.ClipData$Item
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.Parcelable
 *  android.text.Html
 *  android.text.Spanned
 *  android.util.Log
 *  android.view.ActionProvider
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.widget.ShareActionProvider
 */
package androidx.core.app;

import android.app.Activity;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcelable;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import androidx.core.util.Preconditions;
import java.util.ArrayList;

public final class ShareCompat {
    public static final String EXTRA_CALLING_ACTIVITY = "androidx.core.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_ACTIVITY_INTEROP = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_PACKAGE = "androidx.core.app.EXTRA_CALLING_PACKAGE";
    public static final String EXTRA_CALLING_PACKAGE_INTEROP = "android.support.v4.app.EXTRA_CALLING_PACKAGE";
    private static final String HISTORY_FILENAME_PREFIX = ".sharecompat_";

    private ShareCompat() {
    }

    @Deprecated
    public static void configureMenuItem(Menu menu, int n, IntentBuilder intentBuilder) {
        if ((menu = menu.findItem(n)) != null) {
            ShareCompat.configureMenuItem((MenuItem)menu, intentBuilder);
            return;
        }
        throw new IllegalArgumentException("Could not find menu item with id " + n + " in the supplied menu");
    }

    @Deprecated
    public static void configureMenuItem(MenuItem menuItem, IntentBuilder intentBuilder) {
        ActionProvider actionProvider = menuItem.getActionProvider();
        actionProvider = !(actionProvider instanceof ShareActionProvider) ? new ShareActionProvider(intentBuilder.getContext()) : (ShareActionProvider)actionProvider;
        actionProvider.setShareHistoryFileName(HISTORY_FILENAME_PREFIX + intentBuilder.getContext().getClass().getName());
        actionProvider.setShareIntent(intentBuilder.getIntent());
        menuItem.setActionProvider(actionProvider);
    }

    public static ComponentName getCallingActivity(Activity activity) {
        Intent intent = activity.getIntent();
        ComponentName componentName = activity.getCallingActivity();
        activity = componentName;
        if (componentName == null) {
            activity = ShareCompat.getCallingActivity(intent);
        }
        return activity;
    }

    static ComponentName getCallingActivity(Intent intent) {
        ComponentName componentName;
        ComponentName componentName2 = componentName = (ComponentName)intent.getParcelableExtra(EXTRA_CALLING_ACTIVITY);
        if (componentName == null) {
            componentName2 = (ComponentName)intent.getParcelableExtra(EXTRA_CALLING_ACTIVITY_INTEROP);
        }
        return componentName2;
    }

    public static String getCallingPackage(Activity object) {
        Intent intent = object.getIntent();
        String string2 = object.getCallingPackage();
        object = string2;
        if (string2 == null) {
            object = string2;
            if (intent != null) {
                object = ShareCompat.getCallingPackage(intent);
            }
        }
        return object;
    }

    static String getCallingPackage(Intent intent) {
        String string2;
        String string3 = string2 = intent.getStringExtra(EXTRA_CALLING_PACKAGE);
        if (string2 == null) {
            string3 = intent.getStringExtra(EXTRA_CALLING_PACKAGE_INTEROP);
        }
        return string3;
    }

    static void migrateExtraStreamToClipData(Intent intent, ArrayList<Uri> arrayList) {
        CharSequence charSequence = intent.getCharSequenceExtra("android.intent.extra.TEXT");
        String string2 = intent.getStringExtra("android.intent.extra.HTML_TEXT");
        String string3 = intent.getType();
        string2 = new ClipData.Item(charSequence, string2, null, arrayList.get(0));
        string3 = new ClipData(null, new String[]{string3}, (ClipData.Item)string2);
        int n = arrayList.size();
        for (int i = 1; i < n; ++i) {
            string3.addItem(new ClipData.Item(arrayList.get(i)));
        }
        intent.setClipData((ClipData)string3);
        intent.addFlags(1);
    }

    public static class IntentBuilder {
        private ArrayList<String> mBccAddresses;
        private ArrayList<String> mCcAddresses;
        private CharSequence mChooserTitle;
        private final Context mContext;
        private final Intent mIntent;
        private ArrayList<Uri> mStreams;
        private ArrayList<String> mToAddresses;

        public IntentBuilder(Context context) {
            Activity activity;
            this.mContext = Preconditions.checkNotNull(context);
            this.mIntent = new Intent().setAction("android.intent.action.SEND");
            this.mIntent.putExtra(ShareCompat.EXTRA_CALLING_PACKAGE, context.getPackageName());
            this.mIntent.putExtra(ShareCompat.EXTRA_CALLING_PACKAGE_INTEROP, context.getPackageName());
            this.mIntent.addFlags(524288);
            Activity activity2 = null;
            while (true) {
                activity = activity2;
                if (!(context instanceof ContextWrapper)) break;
                if (context instanceof Activity) {
                    activity = (Activity)context;
                    break;
                }
                context = ((ContextWrapper)context).getBaseContext();
            }
            if (activity != null) {
                context = activity.getComponentName();
                this.mIntent.putExtra(ShareCompat.EXTRA_CALLING_ACTIVITY, (Parcelable)context);
                this.mIntent.putExtra(ShareCompat.EXTRA_CALLING_ACTIVITY_INTEROP, (Parcelable)context);
            }
        }

        private void combineArrayExtra(String string2, ArrayList<String> arrayList) {
            String[] stringArray = this.mIntent.getStringArrayExtra(string2);
            int n = stringArray != null ? stringArray.length : 0;
            String[] stringArray2 = new String[arrayList.size() + n];
            arrayList.toArray(stringArray2);
            if (stringArray != null) {
                System.arraycopy(stringArray, 0, stringArray2, arrayList.size(), n);
            }
            this.mIntent.putExtra(string2, stringArray2);
        }

        private void combineArrayExtra(String string2, String[] stringArray) {
            Intent intent = this.getIntent();
            String[] stringArray2 = intent.getStringArrayExtra(string2);
            int n = stringArray2 != null ? stringArray2.length : 0;
            String[] stringArray3 = new String[stringArray.length + n];
            if (stringArray2 != null) {
                System.arraycopy(stringArray2, 0, stringArray3, 0, n);
            }
            System.arraycopy(stringArray, 0, stringArray3, n, stringArray.length);
            intent.putExtra(string2, stringArray3);
        }

        @Deprecated
        public static IntentBuilder from(Activity activity) {
            return new IntentBuilder((Context)activity);
        }

        public IntentBuilder addEmailBcc(String string2) {
            if (this.mBccAddresses == null) {
                this.mBccAddresses = new ArrayList();
            }
            this.mBccAddresses.add(string2);
            return this;
        }

        public IntentBuilder addEmailBcc(String[] stringArray) {
            this.combineArrayExtra("android.intent.extra.BCC", stringArray);
            return this;
        }

        public IntentBuilder addEmailCc(String string2) {
            if (this.mCcAddresses == null) {
                this.mCcAddresses = new ArrayList();
            }
            this.mCcAddresses.add(string2);
            return this;
        }

        public IntentBuilder addEmailCc(String[] stringArray) {
            this.combineArrayExtra("android.intent.extra.CC", stringArray);
            return this;
        }

        public IntentBuilder addEmailTo(String string2) {
            if (this.mToAddresses == null) {
                this.mToAddresses = new ArrayList();
            }
            this.mToAddresses.add(string2);
            return this;
        }

        public IntentBuilder addEmailTo(String[] stringArray) {
            this.combineArrayExtra("android.intent.extra.EMAIL", stringArray);
            return this;
        }

        public IntentBuilder addStream(Uri uri) {
            if (this.mStreams == null) {
                this.mStreams = new ArrayList();
            }
            this.mStreams.add(uri);
            return this;
        }

        public Intent createChooserIntent() {
            return Intent.createChooser((Intent)this.getIntent(), (CharSequence)this.mChooserTitle);
        }

        Context getContext() {
            return this.mContext;
        }

        public Intent getIntent() {
            boolean bl;
            block11: {
                block10: {
                    if (this.mToAddresses != null) {
                        this.combineArrayExtra("android.intent.extra.EMAIL", this.mToAddresses);
                        this.mToAddresses = null;
                    }
                    if (this.mCcAddresses != null) {
                        this.combineArrayExtra("android.intent.extra.CC", this.mCcAddresses);
                        this.mCcAddresses = null;
                    }
                    if (this.mBccAddresses != null) {
                        this.combineArrayExtra("android.intent.extra.BCC", this.mBccAddresses);
                        this.mBccAddresses = null;
                    }
                    if (this.mStreams == null) break block10;
                    int n = this.mStreams.size();
                    bl = true;
                    if (n > 1) break block11;
                }
                bl = false;
            }
            if (!bl) {
                this.mIntent.setAction("android.intent.action.SEND");
                if (this.mStreams != null && !this.mStreams.isEmpty()) {
                    this.mIntent.putExtra("android.intent.extra.STREAM", (Parcelable)this.mStreams.get(0));
                    ShareCompat.migrateExtraStreamToClipData(this.mIntent, this.mStreams);
                } else {
                    this.mIntent.removeExtra("android.intent.extra.STREAM");
                    this.mIntent.setClipData(null);
                    this.mIntent.setFlags(this.mIntent.getFlags() & 0xFFFFFFFE);
                }
            } else {
                this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
                this.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.mStreams);
                ShareCompat.migrateExtraStreamToClipData(this.mIntent, this.mStreams);
            }
            return this.mIntent;
        }

        public IntentBuilder setChooserTitle(int n) {
            return this.setChooserTitle(this.mContext.getText(n));
        }

        public IntentBuilder setChooserTitle(CharSequence charSequence) {
            this.mChooserTitle = charSequence;
            return this;
        }

        public IntentBuilder setEmailBcc(String[] stringArray) {
            this.mIntent.putExtra("android.intent.extra.BCC", stringArray);
            return this;
        }

        public IntentBuilder setEmailCc(String[] stringArray) {
            this.mIntent.putExtra("android.intent.extra.CC", stringArray);
            return this;
        }

        public IntentBuilder setEmailTo(String[] stringArray) {
            if (this.mToAddresses != null) {
                this.mToAddresses = null;
            }
            this.mIntent.putExtra("android.intent.extra.EMAIL", stringArray);
            return this;
        }

        public IntentBuilder setHtmlText(String string2) {
            this.mIntent.putExtra("android.intent.extra.HTML_TEXT", string2);
            if (!this.mIntent.hasExtra("android.intent.extra.TEXT")) {
                this.setText((CharSequence)Html.fromHtml((String)string2));
            }
            return this;
        }

        public IntentBuilder setStream(Uri uri) {
            this.mStreams = null;
            if (uri != null) {
                this.addStream(uri);
            }
            return this;
        }

        public IntentBuilder setSubject(String string2) {
            this.mIntent.putExtra("android.intent.extra.SUBJECT", string2);
            return this;
        }

        public IntentBuilder setText(CharSequence charSequence) {
            this.mIntent.putExtra("android.intent.extra.TEXT", charSequence);
            return this;
        }

        public IntentBuilder setType(String string2) {
            this.mIntent.setType(string2);
            return this;
        }

        public void startChooser() {
            this.mContext.startActivity(this.createChooserIntent());
        }
    }

    public static class IntentReader {
        private static final String TAG = "IntentReader";
        private final ComponentName mCallingActivity;
        private final String mCallingPackage;
        private final Context mContext;
        private final Intent mIntent;
        private ArrayList<Uri> mStreams;

        public IntentReader(Activity activity) {
            this((Context)Preconditions.checkNotNull(activity), activity.getIntent());
        }

        public IntentReader(Context context, Intent intent) {
            this.mContext = Preconditions.checkNotNull(context);
            this.mIntent = Preconditions.checkNotNull(intent);
            this.mCallingPackage = ShareCompat.getCallingPackage(intent);
            this.mCallingActivity = ShareCompat.getCallingActivity(intent);
        }

        @Deprecated
        public static IntentReader from(Activity activity) {
            return new IntentReader(activity);
        }

        public ComponentName getCallingActivity() {
            return this.mCallingActivity;
        }

        public Drawable getCallingActivityIcon() {
            if (this.mCallingActivity == null) {
                return null;
            }
            PackageManager packageManager = this.mContext.getPackageManager();
            try {
                packageManager = packageManager.getActivityIcon(this.mCallingActivity);
                return packageManager;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                Log.e((String)TAG, (String)"Could not retrieve icon for calling activity", (Throwable)nameNotFoundException);
                return null;
            }
        }

        public Drawable getCallingApplicationIcon() {
            if (this.mCallingPackage == null) {
                return null;
            }
            PackageManager packageManager = this.mContext.getPackageManager();
            try {
                packageManager = packageManager.getApplicationIcon(this.mCallingPackage);
                return packageManager;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                Log.e((String)TAG, (String)"Could not retrieve icon for calling application", (Throwable)nameNotFoundException);
                return null;
            }
        }

        public CharSequence getCallingApplicationLabel() {
            if (this.mCallingPackage == null) {
                return null;
            }
            Object object = this.mContext.getPackageManager();
            try {
                object = object.getApplicationLabel(object.getApplicationInfo(this.mCallingPackage, 0));
                return object;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                Log.e((String)TAG, (String)"Could not retrieve label for calling application", (Throwable)nameNotFoundException);
                return null;
            }
        }

        public String getCallingPackage() {
            return this.mCallingPackage;
        }

        public String[] getEmailBcc() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.BCC");
        }

        public String[] getEmailCc() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.CC");
        }

        public String[] getEmailTo() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.EMAIL");
        }

        public String getHtmlText() {
            String string2;
            String string3 = string2 = this.mIntent.getStringExtra("android.intent.extra.HTML_TEXT");
            if (string2 == null) {
                CharSequence charSequence = this.getText();
                if (charSequence instanceof Spanned) {
                    string3 = Html.toHtml((Spanned)((Spanned)charSequence));
                } else {
                    string3 = string2;
                    if (charSequence != null) {
                        string3 = Html.escapeHtml((CharSequence)charSequence);
                    }
                }
            }
            return string3;
        }

        public Uri getStream() {
            return (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
        }

        public Uri getStream(int n) {
            if (this.mStreams == null && this.isMultipleShare()) {
                this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
            }
            if (this.mStreams != null) {
                return this.mStreams.get(n);
            }
            if (n == 0) {
                return (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
            }
            throw new IndexOutOfBoundsException("Stream items available: " + this.getStreamCount() + " index requested: " + n);
        }

        public int getStreamCount() {
            if (this.mStreams == null && this.isMultipleShare()) {
                this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
            }
            if (this.mStreams != null) {
                return this.mStreams.size();
            }
            return this.mIntent.hasExtra("android.intent.extra.STREAM") ? 1 : 0;
        }

        public String getSubject() {
            return this.mIntent.getStringExtra("android.intent.extra.SUBJECT");
        }

        public CharSequence getText() {
            return this.mIntent.getCharSequenceExtra("android.intent.extra.TEXT");
        }

        public String getType() {
            return this.mIntent.getType();
        }

        public boolean isMultipleShare() {
            return "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
        }

        public boolean isShareIntent() {
            String string2 = this.mIntent.getAction();
            boolean bl = "android.intent.action.SEND".equals(string2) || "android.intent.action.SEND_MULTIPLE".equals(string2);
            return bl;
        }

        public boolean isSingleShare() {
            return "android.intent.action.SEND".equals(this.mIntent.getAction());
        }
    }
}

