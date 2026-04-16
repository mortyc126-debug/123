/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  android.util.Xml
 *  org.xmlpull.v1.XmlPullParserException
 *  org.xmlpull.v1.XmlSerializer
 */
package androidx.core.app;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public class AppLocalesStorageHelper {
    static final String APPLICATION_LOCALES_RECORD_FILE = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file";
    static final boolean DEBUG = false;
    static final String LOCALE_RECORD_ATTRIBUTE_TAG = "application_locales";
    static final String LOCALE_RECORD_FILE_TAG = "locales";
    static final String TAG = "AppLocalesStorageHelper";
    private static final Object sAppLocaleStorageSync = new Object();

    private AppLocalesStorageHelper() {
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void persistLocales(Context object, String string2) {
        Object object2 = sAppLocaleStorageSync;
        synchronized (object2) {
            Throwable throwable222222;
            block15: {
                if (string2.equals("")) {
                    object.deleteFile(APPLICATION_LOCALES_RECORD_FILE);
                    return;
                }
                object = object.openFileOutput(APPLICATION_LOCALES_RECORD_FILE, 0);
                XmlSerializer xmlSerializer = Xml.newSerializer();
                xmlSerializer.setOutput((OutputStream)object, null);
                xmlSerializer.startDocument("UTF-8", Boolean.valueOf(true));
                xmlSerializer.startTag(null, LOCALE_RECORD_FILE_TAG);
                xmlSerializer.attribute(null, LOCALE_RECORD_ATTRIBUTE_TAG, string2);
                xmlSerializer.endTag(null, LOCALE_RECORD_FILE_TAG);
                xmlSerializer.endDocument();
                if (object == null) return;
                ((FileOutputStream)object).close();
                {
                    catch (IOException iOException) {}
                }
                catch (FileNotFoundException fileNotFoundException) {
                    Log.w((String)TAG, (String)String.format("Storing App Locales : FileNotFoundException: Cannot open file %s for writing ", APPLICATION_LOCALES_RECORD_FILE));
                    return;
                }
                {
                    catch (Throwable throwable222222) {
                        break block15;
                    }
                    catch (Exception exception) {}
                    {
                        Log.w((String)TAG, (String)"Storing App Locales : Failed to persist app-locales in storage ", (Throwable)exception);
                        if (object == null) return;
                    }
                    ((FileOutputStream)object).close();
                }
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
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String readLocales(Context var0) {
        var6_3 = AppLocalesStorageHelper.sAppLocaleStorageSync;
        synchronized (var6_3) {
            block20: {
                block19: {
                    var4_4 = "";
                    var7_5 = var0.openFileInput("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
                    try {}
                    catch (IOException var3_11) {}
                    catch (XmlPullParserException var3_12) {
                        // empty catch block
                    }
                    finally {
                        break block19;
                    }
lbl12:
                    // 1 sources

                    while (true) {
                        var5_6 /* !! */  = var3_9;
                        while (true) {
                            if (var5_6 /* !! */ .isEmpty()) {
                                var0.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
                            }
                            return var5_6 /* !! */ ;
                        }
                        break;
                    }
                    catch (FileNotFoundException var0_2) {
                        return "";
                    }
                }
                var5_6 /* !! */  = Xml.newPullParser();
                var5_6 /* !! */ .setInput((InputStream)var7_5, "UTF-8");
                var2_7 = var5_6 /* !! */ .getDepth();
                do {
                    var1_8 = var5_6 /* !! */ .next();
                    var3_9 = var4_4;
                    if (var1_8 == 1) break block20;
                    if (var1_8 != 3) continue;
                    var3_9 = var4_4;
                    if (var5_6 /* !! */ .getDepth() <= var2_7) break block20;
                } while (var1_8 == 3 || var1_8 == 4 || !var5_6 /* !! */ .getName().equals("locales"));
                var3_9 = var5_6 /* !! */ .getAttributeValue(null, "application_locales");
            }
            var5_6 /* !! */  = var3_9;
            if (var7_5 == null) ** continue;
            var5_6 /* !! */  = var3_9;
            {
                var7_5.close();
                ** continue;
            }
        }
    }
}

