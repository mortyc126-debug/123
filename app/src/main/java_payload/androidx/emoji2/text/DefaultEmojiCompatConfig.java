/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ProviderInfo
 *  android.content.pm.ResolveInfo
 *  android.content.pm.Signature
 *  android.os.Build$VERSION
 *  android.util.Log
 */
package androidx.emoji2.text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Log;
import androidx.core.provider.FontRequest;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.FontRequestEmojiCompatConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DefaultEmojiCompatConfig {
    private DefaultEmojiCompatConfig() {
    }

    public static FontRequestEmojiCompatConfig create(Context context) {
        return (FontRequestEmojiCompatConfig)new DefaultEmojiCompatConfigFactory(null).create(context);
    }

    public static class DefaultEmojiCompatConfigFactory {
        private static final String DEFAULT_EMOJI_QUERY = "emojicompat-emoji-font";
        private static final String INTENT_LOAD_EMOJI_FONT = "androidx.content.action.LOAD_EMOJI_FONT";
        private static final String TAG = "emoji2.text.DefaultEmojiConfig";
        private final DefaultEmojiCompatConfigHelper mHelper;

        public DefaultEmojiCompatConfigFactory(DefaultEmojiCompatConfigHelper defaultEmojiCompatConfigHelper) {
            if (defaultEmojiCompatConfigHelper == null) {
                defaultEmojiCompatConfigHelper = DefaultEmojiCompatConfigFactory.getHelperForApi();
            }
            this.mHelper = defaultEmojiCompatConfigHelper;
        }

        private EmojiCompat.Config configOrNull(Context context, FontRequest fontRequest) {
            if (fontRequest == null) {
                return null;
            }
            return new FontRequestEmojiCompatConfig(context, fontRequest);
        }

        private List<List<byte[]>> convertToByteArray(Signature[] signatureArray) {
            ArrayList<byte[]> arrayList = new ArrayList<byte[]>();
            int n = signatureArray.length;
            for (int i = 0; i < n; ++i) {
                arrayList.add(signatureArray[i].toByteArray());
            }
            return Collections.singletonList(arrayList);
        }

        private FontRequest generateFontRequestFrom(ProviderInfo object, PackageManager packageManager) throws PackageManager.NameNotFoundException {
            String string2 = object.authority;
            object = object.packageName;
            return new FontRequest(string2, (String)object, DEFAULT_EMOJI_QUERY, this.convertToByteArray(this.mHelper.getSigningSignatures(packageManager, (String)object)));
        }

        private static DefaultEmojiCompatConfigHelper getHelperForApi() {
            if (Build.VERSION.SDK_INT >= 28) {
                return new DefaultEmojiCompatConfigHelper_API28();
            }
            return new DefaultEmojiCompatConfigHelper_API19();
        }

        private boolean hasFlagSystem(ProviderInfo providerInfo) {
            boolean bl;
            block3: {
                block2: {
                    if (providerInfo == null || providerInfo.applicationInfo == null) break block2;
                    int n = providerInfo.applicationInfo.flags;
                    bl = true;
                    if ((n & 1) == 1) break block3;
                }
                bl = false;
            }
            return bl;
        }

        private ProviderInfo queryDefaultInstalledContentProvider(PackageManager object) {
            for (ResolveInfo resolveInfo : this.mHelper.queryIntentContentProviders((PackageManager)object, new Intent(INTENT_LOAD_EMOJI_FONT), 0)) {
                if (!this.hasFlagSystem((ProviderInfo)(resolveInfo = this.mHelper.getProviderInfo(resolveInfo)))) continue;
                return resolveInfo;
            }
            return null;
        }

        public EmojiCompat.Config create(Context context) {
            return this.configOrNull(context, this.queryForDefaultFontRequest(context));
        }

        FontRequest queryForDefaultFontRequest(Context object) {
            PackageManager packageManager = object.getPackageManager();
            Preconditions.checkNotNull(packageManager, "Package manager required to locate emoji font provider");
            object = this.queryDefaultInstalledContentProvider(packageManager);
            if (object == null) {
                return null;
            }
            try {
                object = this.generateFontRequestFrom((ProviderInfo)object, packageManager);
                return object;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                Log.wtf((String)TAG, (Throwable)nameNotFoundException);
                return null;
            }
        }
    }

    public static class DefaultEmojiCompatConfigHelper {
        public ProviderInfo getProviderInfo(ResolveInfo resolveInfo) {
            throw new IllegalStateException("Unable to get provider info prior to API 19");
        }

        public Signature[] getSigningSignatures(PackageManager packageManager, String string2) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo((String)string2, (int)64).signatures;
        }

        public List<ResolveInfo> queryIntentContentProviders(PackageManager packageManager, Intent intent, int n) {
            return Collections.emptyList();
        }
    }

    public static class DefaultEmojiCompatConfigHelper_API19
    extends DefaultEmojiCompatConfigHelper {
        @Override
        public ProviderInfo getProviderInfo(ResolveInfo resolveInfo) {
            return resolveInfo.providerInfo;
        }

        @Override
        public List<ResolveInfo> queryIntentContentProviders(PackageManager packageManager, Intent intent, int n) {
            return packageManager.queryIntentContentProviders(intent, n);
        }
    }

    public static class DefaultEmojiCompatConfigHelper_API28
    extends DefaultEmojiCompatConfigHelper_API19 {
        @Override
        public Signature[] getSigningSignatures(PackageManager packageManager, String string2) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo((String)string2, (int)64).signatures;
        }
    }
}

