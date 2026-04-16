/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentProvider
 *  android.content.ContentValues
 *  android.content.Context
 *  android.content.pm.ProviderInfo
 *  android.content.res.XmlResourceParser
 *  android.database.Cursor
 *  android.database.MatrixCursor
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.os.Bundle
 *  android.os.Environment
 *  android.os.ParcelFileDescriptor
 *  android.text.TextUtils
 *  android.webkit.MimeTypeMap
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.core.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.core.content.ContextCompat;
import androidx.core.util.ObjectsCompat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public class FileProvider
extends ContentProvider {
    private static final String ATTR_NAME = "name";
    private static final String ATTR_PATH = "path";
    private static final String[] COLUMNS = new String[]{"_display_name", "_size"};
    private static final File DEVICE_ROOT = new File("/");
    private static final String DISPLAYNAME_FIELD = "displayName";
    private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
    private static final String TAG_CACHE_PATH = "cache-path";
    private static final String TAG_EXTERNAL = "external-path";
    private static final String TAG_EXTERNAL_CACHE = "external-cache-path";
    private static final String TAG_EXTERNAL_FILES = "external-files-path";
    private static final String TAG_EXTERNAL_MEDIA = "external-media-path";
    private static final String TAG_FILES_PATH = "files-path";
    private static final String TAG_ROOT_PATH = "root-path";
    private static final HashMap<String, PathStrategy> sCache = new HashMap();
    private String mAuthority;
    private PathStrategy mLocalPathStrategy;
    private final Object mLock = new Object();
    private final int mResourceId;

    public FileProvider() {
        this(0);
    }

    protected FileProvider(int n) {
        this.mResourceId = n;
    }

    private static File buildPath(File file, String ... stringArray) {
        for (String string2 : stringArray) {
            File file2 = file;
            if (string2 != null) {
                file2 = new File(file, string2);
            }
            file = file2;
        }
        return file;
    }

    private static Object[] copyOf(Object[] objectArray, int n) {
        Object[] objectArray2 = new Object[n];
        System.arraycopy(objectArray, 0, objectArray2, 0, n);
        return objectArray2;
    }

    private static String[] copyOf(String[] stringArray, int n) {
        String[] stringArray2 = new String[n];
        System.arraycopy(stringArray, 0, stringArray2, 0, n);
        return stringArray2;
    }

    static XmlResourceParser getFileProviderPathsMetaData(Context context, String string2, ProviderInfo providerInfo, int n) {
        if (providerInfo != null) {
            if (providerInfo.metaData == null && n != 0) {
                providerInfo.metaData = new Bundle(1);
                providerInfo.metaData.putInt(META_DATA_FILE_PROVIDER_PATHS, n);
            }
            if ((context = providerInfo.loadXmlMetaData(context.getPackageManager(), META_DATA_FILE_PROVIDER_PATHS)) != null) {
                return context;
            }
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
        throw new IllegalArgumentException("Couldn't find meta-data for provider with authority " + string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private PathStrategy getLocalPathStrategy() {
        Object object = this.mLock;
        synchronized (object) {
            ObjectsCompat.requireNonNull(this.mAuthority, "mAuthority is null. Did you override attachInfo and did not call super.attachInfo()?");
            if (this.mLocalPathStrategy != null) return this.mLocalPathStrategy;
            this.mLocalPathStrategy = FileProvider.getPathStrategy(this.getContext(), this.mAuthority, this.mResourceId);
            return this.mLocalPathStrategy;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static PathStrategy getPathStrategy(Context object, String object2, int n) {
        HashMap<String, PathStrategy> hashMap = sCache;
        synchronized (hashMap) {
            PathStrategy pathStrategy;
            PathStrategy pathStrategy2 = pathStrategy = sCache.get(object2);
            if (pathStrategy == null) {
                try {
                    pathStrategy2 = FileProvider.parsePathStrategy(object, (String)object2, n);
                    sCache.put((String)object2, pathStrategy2);
                }
                catch (XmlPullParserException xmlPullParserException) {
                    object = new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", xmlPullParserException);
                    throw object;
                }
                catch (IOException iOException) {
                    object2 = new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", iOException);
                    throw object2;
                }
            }
            return pathStrategy2;
        }
    }

    public static Uri getUriForFile(Context context, String string2, File file) {
        return FileProvider.getPathStrategy(context, string2, 0).getUriForFile(file);
    }

    public static Uri getUriForFile(Context context, String string2, File file, String string3) {
        return FileProvider.getUriForFile(context, string2, file).buildUpon().appendQueryParameter(DISPLAYNAME_FIELD, string3).build();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static int modeToMode(String string2) {
        if ("r".equals(string2)) {
            return 0x10000000;
        }
        if ("w".equals(string2)) return 0x2C000000;
        if ("wt".equals(string2)) return 0x2C000000;
        if ("wa".equals(string2)) {
            return 0x2A000000;
        }
        if ("rw".equals(string2)) {
            return 0x38000000;
        }
        if (!"rwt".equals(string2)) throw new IllegalArgumentException("Invalid mode: " + string2);
        return 0x3C000000;
    }

    private static PathStrategy parsePathStrategy(Context context, String object, int n) throws IOException, XmlPullParserException {
        SimplePathStrategy simplePathStrategy = new SimplePathStrategy((String)object);
        XmlResourceParser xmlResourceParser = FileProvider.getFileProviderPathsMetaData(context, (String)object, context.getPackageManager().resolveContentProvider((String)object, 128), n);
        while ((n = xmlResourceParser.next()) != 1) {
            if (n != 2) continue;
            String string2 = xmlResourceParser.getName();
            String string3 = xmlResourceParser.getAttributeValue(null, ATTR_NAME);
            String string4 = xmlResourceParser.getAttributeValue(null, ATTR_PATH);
            File[] fileArray = null;
            File[] fileArray2 = null;
            object = null;
            if (TAG_ROOT_PATH.equals(string2)) {
                object = DEVICE_ROOT;
            } else if (TAG_FILES_PATH.equals(string2)) {
                object = context.getFilesDir();
            } else if (TAG_CACHE_PATH.equals(string2)) {
                object = context.getCacheDir();
            } else if (TAG_EXTERNAL.equals(string2)) {
                object = Environment.getExternalStorageDirectory();
            } else if (TAG_EXTERNAL_FILES.equals(string2)) {
                fileArray2 = ContextCompat.getExternalFilesDirs(context, null);
                if (fileArray2.length > 0) {
                    object = fileArray2[0];
                }
            } else if (TAG_EXTERNAL_CACHE.equals(string2)) {
                fileArray2 = ContextCompat.getExternalCacheDirs(context);
                object = fileArray;
                if (fileArray2.length > 0) {
                    object = fileArray2[0];
                }
            } else {
                object = fileArray2;
                if (TAG_EXTERNAL_MEDIA.equals(string2)) {
                    fileArray = Api21Impl.getExternalMediaDirs(context);
                    object = fileArray2;
                    if (fileArray.length > 0) {
                        object = fileArray[0];
                    }
                }
            }
            if (object == null) continue;
            simplePathStrategy.addRoot(string3, FileProvider.buildPath((File)object, string4));
        }
        return simplePathStrategy;
    }

    private static String removeTrailingSlash(String string2) {
        if (string2.length() > 0 && string2.charAt(string2.length() - 1) == '/') {
            return string2.substring(0, string2.length() - 1);
        }
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void attachInfo(Context object, ProviderInfo object2) {
        super.attachInfo(object, object2);
        if (object2.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if (object2.grantUriPermissions) {
            object2 = object2.authority.split(";")[0];
            object = this.mLock;
            synchronized (object) {
                this.mAuthority = object2;
            }
            object = sCache;
            synchronized (object) {
                sCache.remove(object2);
                return;
            }
        }
        throw new SecurityException("Provider must grant uri permissions");
    }

    public int delete(Uri uri, String string2, String[] stringArray) {
        return this.getLocalPathStrategy().getFileForUri(uri).delete() ? 1 : 0;
    }

    public String getType(Uri object) {
        object = this.getLocalPathStrategy().getFileForUri((Uri)object);
        int n = ((File)object).getName().lastIndexOf(46);
        if (n >= 0) {
            object = ((File)object).getName().substring(n + 1);
            object = MimeTypeMap.getSingleton().getMimeTypeFromExtension((String)object);
            if (object != null) {
                return object;
            }
        }
        return "application/octet-stream";
    }

    public String getTypeAnonymous(Uri uri) {
        return "application/octet-stream";
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    public boolean onCreate() {
        return true;
    }

    public ParcelFileDescriptor openFile(Uri uri, String string2) throws FileNotFoundException {
        return ParcelFileDescriptor.open((File)this.getLocalPathStrategy().getFileForUri(uri), (int)FileProvider.modeToMode(string2));
    }

    /*
     * WARNING - void declaration
     */
    public Cursor query(Uri stringArray, String[] object3, String string2, String[] object2, String objectArray) {
        File file = this.getLocalPathStrategy().getFileForUri((Uri)stringArray);
        String string3 = stringArray.getQueryParameter(DISPLAYNAME_FIELD);
        stringArray = object3 == null ? COLUMNS : object3;
        String[] stringArray2 = new String[((String[])stringArray).length];
        Object[] objectArray2 = new Object[((String[])stringArray).length];
        int n = 0;
        for (String string4 : stringArray) {
            int n2;
            if ("_display_name".equals(string4)) {
                void var2_7;
                stringArray2[n] = "_display_name";
                if (string3 == null) {
                    String string5 = file.getName();
                } else {
                    String string6 = string3;
                }
                objectArray2[n] = var2_7;
                n2 = n + 1;
            } else {
                n2 = n;
                if ("_size".equals(string4)) {
                    stringArray2[n] = "_size";
                    objectArray2[n] = file.length();
                    n2 = n + 1;
                }
            }
            n = n2;
        }
        stringArray = FileProvider.copyOf(stringArray2, n);
        Object[] objectArray3 = FileProvider.copyOf(objectArray2, n);
        stringArray = new MatrixCursor(stringArray, 1);
        stringArray.addRow(objectArray3);
        return stringArray;
    }

    public int update(Uri uri, ContentValues contentValues, String string2, String[] stringArray) {
        throw new UnsupportedOperationException("No external updates");
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static File[] getExternalMediaDirs(Context context) {
            return context.getExternalMediaDirs();
        }
    }

    static interface PathStrategy {
        public File getFileForUri(Uri var1);

        public Uri getUriForFile(File var1);
    }

    static class SimplePathStrategy
    implements PathStrategy {
        private final String mAuthority;
        private final HashMap<String, File> mRoots = new HashMap();

        SimplePathStrategy(String string2) {
            this.mAuthority = string2;
        }

        private boolean belongsToRoot(String string2, String string3) {
            boolean bl = (string2 = FileProvider.removeTrailingSlash(string2)).equals(string3 = FileProvider.removeTrailingSlash(string3)) || string2.startsWith(string3 + '/');
            return bl;
        }

        void addRoot(String string2, File file) {
            if (!TextUtils.isEmpty((CharSequence)string2)) {
                try {
                    File file2 = file.getCanonicalFile();
                    this.mRoots.put(string2, file2);
                }
                catch (IOException iOException) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for " + file, iOException);
                }
                return;
            }
            throw new IllegalArgumentException("Name must not be empty");
        }

        @Override
        public File getFileForUri(Uri object) {
            Object object2 = object.getEncodedPath();
            int n = ((String)object2).indexOf(47, 1);
            Object object3 = Uri.decode((String)((String)object2).substring(1, n));
            object2 = Uri.decode((String)((String)object2).substring(n + 1));
            if ((object3 = this.mRoots.get(object3)) != null) {
                object = new File((File)object3, (String)object2);
                try {
                    object2 = ((File)object).getCanonicalFile();
                    if (this.belongsToRoot(((File)object2).getPath(), ((File)object3).getPath())) {
                        return object2;
                    }
                    throw new SecurityException("Resolved path jumped beyond configured root");
                }
                catch (IOException iOException) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for " + object);
                }
            }
            throw new IllegalArgumentException("Unable to find configured root for " + object);
        }

        @Override
        public Uri getUriForFile(File object) {
            Object object2;
            String string2;
            try {
                string2 = ((File)object).getCanonicalPath();
                object = null;
            }
            catch (IOException iOException) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + object);
            }
            for (Map.Entry<String, File> entry : this.mRoots.entrySet()) {
                block7: {
                    block8: {
                        String string3 = entry.getValue().getPath();
                        object2 = object;
                        if (!this.belongsToRoot(string2, string3)) break block7;
                        if (object == null) break block8;
                        object2 = object;
                        if (string3.length() <= ((File)object.getValue()).getPath().length()) break block7;
                    }
                    object2 = entry;
                }
                object = object2;
            }
            if (object != null) {
                object2 = ((File)object.getValue()).getPath();
                object2 = ((String)object2).endsWith("/") ? string2.substring(((String)object2).length()) : string2.substring(((String)object2).length() + 1);
                object = Uri.encode((String)((String)object.getKey())) + '/' + Uri.encode(object2, (String)"/");
                return new Uri.Builder().scheme("content").authority(this.mAuthority).encodedPath((String)object).build();
            }
            throw new IllegalArgumentException("Failed to find configured root that contains " + string2);
        }
    }
}

