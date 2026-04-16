/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.ActivityOptions
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.util.Pair
 *  android.view.View
 */
package androidx.core.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

public class ActivityOptionsCompat {
    public static final String EXTRA_USAGE_TIME_REPORT = "android.activity.usage_time";
    public static final String EXTRA_USAGE_TIME_REPORT_PACKAGES = "android.usage_time_packages";

    protected ActivityOptionsCompat() {
    }

    public static ActivityOptionsCompat makeBasic() {
        return new ActivityOptionsCompatImpl(Api23Impl.makeBasic());
    }

    public static ActivityOptionsCompat makeClipRevealAnimation(View view, int n, int n2, int n3, int n4) {
        return new ActivityOptionsCompatImpl(Api23Impl.makeClipRevealAnimation(view, n, n2, n3, n4));
    }

    public static ActivityOptionsCompat makeCustomAnimation(Context context, int n, int n2) {
        return new ActivityOptionsCompatImpl(ActivityOptions.makeCustomAnimation((Context)context, (int)n, (int)n2));
    }

    public static ActivityOptionsCompat makeScaleUpAnimation(View view, int n, int n2, int n3, int n4) {
        return new ActivityOptionsCompatImpl(ActivityOptions.makeScaleUpAnimation((View)view, (int)n, (int)n2, (int)n3, (int)n4));
    }

    public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity activity, View view, String string2) {
        return new ActivityOptionsCompatImpl(Api21Impl.makeSceneTransitionAnimation(activity, view, string2));
    }

    public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity activity, androidx.core.util.Pair<View, String> ... pairArray) {
        Pair[] pairArray2 = null;
        if (pairArray != null) {
            Pair[] pairArray3 = new Pair[pairArray.length];
            int n = 0;
            while (true) {
                pairArray2 = pairArray3;
                if (n >= pairArray.length) break;
                pairArray3[n] = Pair.create((Object)((View)pairArray[n].first), (Object)((String)pairArray[n].second));
                ++n;
            }
        }
        return new ActivityOptionsCompatImpl(Api21Impl.makeSceneTransitionAnimation(activity, pairArray2));
    }

    public static ActivityOptionsCompat makeTaskLaunchBehind() {
        return new ActivityOptionsCompatImpl(Api21Impl.makeTaskLaunchBehind());
    }

    public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(View view, Bitmap bitmap, int n, int n2) {
        return new ActivityOptionsCompatImpl(ActivityOptions.makeThumbnailScaleUpAnimation((View)view, (Bitmap)bitmap, (int)n, (int)n2));
    }

    public Rect getLaunchBounds() {
        return null;
    }

    public void requestUsageTimeReport(PendingIntent pendingIntent) {
    }

    public ActivityOptionsCompat setLaunchBounds(Rect rect) {
        return this;
    }

    public ActivityOptionsCompat setShareIdentityEnabled(boolean bl) {
        return this;
    }

    public Bundle toBundle() {
        return null;
    }

    public void update(ActivityOptionsCompat activityOptionsCompat) {
    }

    private static class ActivityOptionsCompatImpl
    extends ActivityOptionsCompat {
        private final ActivityOptions mActivityOptions;

        ActivityOptionsCompatImpl(ActivityOptions activityOptions) {
            this.mActivityOptions = activityOptions;
        }

        @Override
        public Rect getLaunchBounds() {
            return Api24Impl.getLaunchBounds(this.mActivityOptions);
        }

        @Override
        public void requestUsageTimeReport(PendingIntent pendingIntent) {
            Api23Impl.requestUsageTimeReport(this.mActivityOptions, pendingIntent);
        }

        @Override
        public ActivityOptionsCompat setLaunchBounds(Rect rect) {
            return new ActivityOptionsCompatImpl(Api24Impl.setLaunchBounds(this.mActivityOptions, rect));
        }

        @Override
        public ActivityOptionsCompat setShareIdentityEnabled(boolean bl) {
            if (Build.VERSION.SDK_INT < 34) {
                return this;
            }
            return new ActivityOptionsCompatImpl(Api34Impl.setShareIdentityEnabled(this.mActivityOptions, bl));
        }

        @Override
        public Bundle toBundle() {
            return this.mActivityOptions.toBundle();
        }

        @Override
        public void update(ActivityOptionsCompat activityOptionsCompat) {
            if (activityOptionsCompat instanceof ActivityOptionsCompatImpl) {
                activityOptionsCompat = (ActivityOptionsCompatImpl)activityOptionsCompat;
                this.mActivityOptions.update(((ActivityOptionsCompatImpl)activityOptionsCompat).mActivityOptions);
            }
        }
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static ActivityOptions makeSceneTransitionAnimation(Activity activity, View view, String string2) {
            return ActivityOptions.makeSceneTransitionAnimation((Activity)activity, (View)view, (String)string2);
        }

        @SafeVarargs
        static ActivityOptions makeSceneTransitionAnimation(Activity activity, Pair<View, String> ... pairArray) {
            return ActivityOptions.makeSceneTransitionAnimation((Activity)activity, pairArray);
        }

        static ActivityOptions makeTaskLaunchBehind() {
            return ActivityOptions.makeTaskLaunchBehind();
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static ActivityOptions makeBasic() {
            return ActivityOptions.makeBasic();
        }

        static ActivityOptions makeClipRevealAnimation(View view, int n, int n2, int n3, int n4) {
            return ActivityOptions.makeClipRevealAnimation((View)view, (int)n, (int)n2, (int)n3, (int)n4);
        }

        static void requestUsageTimeReport(ActivityOptions activityOptions, PendingIntent pendingIntent) {
            activityOptions.requestUsageTimeReport(pendingIntent);
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static Rect getLaunchBounds(ActivityOptions activityOptions) {
            return activityOptions.getLaunchBounds();
        }

        static ActivityOptions setLaunchBounds(ActivityOptions activityOptions, Rect rect) {
            return activityOptions.setLaunchBounds(rect);
        }
    }

    static class Api34Impl {
        private Api34Impl() {
        }

        static ActivityOptions setShareIdentityEnabled(ActivityOptions activityOptions, boolean bl) {
            return activityOptions.setShareIdentityEnabled(bl);
        }
    }
}

