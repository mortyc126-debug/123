/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.util.Xml
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.appcompat.app;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.util.Xml;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.AppLocalesStorageHelper$SerialExecutor$$ExternalSyntheticLambda0;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import org.xmlpull.v1.XmlPullParserException;

class AppLocalesStorageHelper {
    static final String APPLICATION_LOCALES_RECORD_FILE = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file";
    static final String APP_LOCALES_META_DATA_HOLDER_SERVICE_NAME = "androidx.appcompat.app.AppLocalesMetadataHolderService";
    static final String LOCALE_RECORD_ATTRIBUTE_TAG = "application_locales";
    static final String LOCALE_RECORD_FILE_TAG = "locales";
    static final String TAG = "AppLocalesStorageHelper";

    private AppLocalesStorageHelper() {
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static void persistLocales(Context object, String string2) {
        Throwable throwable222222;
        if (string2.equals("")) {
            object.deleteFile(APPLICATION_LOCALES_RECORD_FILE);
            return;
        }
        object = object.openFileOutput(APPLICATION_LOCALES_RECORD_FILE, 0);
        Object object2 = Xml.newSerializer();
        object2.setOutput((OutputStream)object, null);
        object2.startDocument("UTF-8", Boolean.valueOf(true));
        object2.startTag(null, LOCALE_RECORD_FILE_TAG);
        object2.attribute(null, LOCALE_RECORD_ATTRIBUTE_TAG, string2);
        object2.endTag(null, LOCALE_RECORD_FILE_TAG);
        object2.endDocument();
        object2 = new StringBuilder();
        Log.d((String)TAG, (String)((StringBuilder)object2).append("Storing App Locales : app-locales: ").append(string2).append(" persisted successfully.").toString());
        if (object == null) return;
        ((FileOutputStream)object).close();
        return;
        {
            catch (IOException iOException) {
                return;
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
            Log.w((String)TAG, (String)String.format("Storing App Locales : FileNotFoundException: Cannot open file %s for writing ", APPLICATION_LOCALES_RECORD_FILE));
            return;
        }
        {
            catch (Throwable throwable222222) {
            }
            catch (Exception exception) {}
            {
                StringBuilder stringBuilder = new StringBuilder();
                Log.w((String)TAG, (String)stringBuilder.append("Storing App Locales : Failed to persist app-locales: ").append(string2).toString(), (Throwable)exception);
                if (object == null) return;
            }
            ((FileOutputStream)object).close();
            return;
        }
        if (object == null) throw throwable222222;
        try {
            ((FileOutputStream)object).close();
            throw throwable222222;
        }
        catch (IOException iOException) {
            // empty catch block
        }
        throw throwable222222;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static String readLocales(Context var0) {
        block18: {
            block17: {
                var4_3 = "";
                var6_4 = var0.openFileInput("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
                try {}
                catch (IOException var3_10) {}
                catch (XmlPullParserException var3_11) {
                    // empty catch block
                }
                finally {
                    break block17;
                }
lbl10:
                // 1 sources

                while (true) {
                    var5_5 /* !! */  = var3_8;
lbl12:
                    // 2 sources

                    while (true) {
                        if (!var5_5 /* !! */ .isEmpty()) {
                            Log.d((String)"AppLocalesStorageHelper", (String)("Reading app Locales : Locales read from file: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file , appLocales: " + (String)var5_5 /* !! */ ));
                            return var5_5 /* !! */ ;
                        }
                        var0.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
                        return var5_5 /* !! */ ;
                    }
                    break;
                }
                catch (FileNotFoundException var0_2) {
                    Log.w((String)"AppLocalesStorageHelper", (String)"Reading app Locales : Locales record file not found: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
                    return "";
                }
            }
            var5_5 /* !! */  = Xml.newPullParser();
            var5_5 /* !! */ .setInput((InputStream)var6_4, "UTF-8");
            var1_6 = var5_5 /* !! */ .getDepth();
            do {
                var2_7 = var5_5 /* !! */ .next();
                var3_8 = var4_3;
                if (var2_7 == 1) break block18;
                if (var2_7 != 3) continue;
                var3_8 = var4_3;
                if (var5_5 /* !! */ .getDepth() <= var1_6) break block18;
            } while (var2_7 == 3 || var2_7 == 4 || !var5_5 /* !! */ .getName().equals("locales"));
            var3_8 = var5_5 /* !! */ .getAttributeValue(null, "application_locales");
        }
        var5_5 /* !! */  = var3_8;
        ** while (var6_4 == null)
lbl40:
        // 1 sources

        var5_5 /* !! */  = var3_8;
        {
            var6_4.close();
            ** continue;
        }
    }

    static void syncLocalesToFramework(Context context) {
        if (Build.VERSION.SDK_INT >= 33) {
            ComponentName componentName = new ComponentName(context, APP_LOCALES_META_DATA_HOLDER_SERVICE_NAME);
            if (context.getPackageManager().getComponentEnabledSetting(componentName) != 1) {
                if (AppCompatDelegate.getApplicationLocales().isEmpty()) {
                    String string2 = AppLocalesStorageHelper.readLocales(context);
                    Object object = context.getSystemService("locale");
                    if (object != null) {
                        AppCompatDelegate.Api33Impl.localeManagerSetApplicationLocales(object, AppCompatDelegate.Api24Impl.localeListForLanguageTags(string2));
                    }
                }
                context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
            }
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    static class SerialExecutor
    implements Executor {
        Runnable mActive;
        final Executor mExecutor;
        private final Object mLock = new Object();
        final Queue<Runnable> mTasks = new ArrayDeque<Runnable>();

        SerialExecutor(Executor executor) {
            this.mExecutor = executor;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void execute(Runnable runnable2) {
            Object object = this.mLock;
            synchronized (object) {
                Queue<Runnable> queue = this.mTasks;
                AppLocalesStorageHelper$SerialExecutor$$ExternalSyntheticLambda0 appLocalesStorageHelper$SerialExecutor$$ExternalSyntheticLambda0 = new AppLocalesStorageHelper$SerialExecutor$$ExternalSyntheticLambda0(this, runnable2);
                queue.add(appLocalesStorageHelper$SerialExecutor$$ExternalSyntheticLambda0);
                if (this.mActive == null) {
                    this.scheduleNext();
                }
                return;
            }
        }

        /* synthetic */ void lambda$execute$0$androidx-appcompat-app-AppLocalesStorageHelper$SerialExecutor(Runnable runnable2) {
            try {
                runnable2.run();
                return;
            }
            finally {
                this.scheduleNext();
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        protected void scheduleNext() {
            Object object = this.mLock;
            synchronized (object) {
                Runnable runnable2;
                this.mActive = runnable2 = this.mTasks.poll();
                if (runnable2 != null) {
                    this.mExecutor.execute(this.mActive);
                }
                return;
            }
        }
    }

    static class ThreadPerTaskExecutor
    implements Executor {
        ThreadPerTaskExecutor() {
        }

        @Override
        public void execute(Runnable runnable2) {
            new Thread(runnable2).start();
        }
    }
}

