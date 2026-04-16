/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.net.Uri
 *  android.provider.DocumentsContract
 */
package androidx.core.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import java.io.FileNotFoundException;

public final class DocumentsContractCompat {
    private static final String PATH_TREE = "tree";

    private DocumentsContractCompat() {
    }

    public static Uri buildChildDocumentsUri(String string2, String string3) {
        return DocumentsContractApi21Impl.buildChildDocumentsUri(string2, string3);
    }

    public static Uri buildChildDocumentsUriUsingTree(Uri uri, String string2) {
        return DocumentsContractApi21Impl.buildChildDocumentsUriUsingTree(uri, string2);
    }

    public static Uri buildDocumentUri(String string2, String string3) {
        return DocumentsContract.buildDocumentUri((String)string2, (String)string3);
    }

    public static Uri buildDocumentUriUsingTree(Uri uri, String string2) {
        return DocumentsContractApi21Impl.buildDocumentUriUsingTree(uri, string2);
    }

    public static Uri buildTreeDocumentUri(String string2, String string3) {
        return DocumentsContractApi21Impl.buildTreeDocumentUri(string2, string3);
    }

    public static Uri createDocument(ContentResolver contentResolver, Uri uri, String string2, String string3) throws FileNotFoundException {
        return DocumentsContractApi21Impl.createDocument(contentResolver, uri, string2, string3);
    }

    public static String getDocumentId(Uri uri) {
        return DocumentsContract.getDocumentId((Uri)uri);
    }

    public static String getTreeDocumentId(Uri uri) {
        return DocumentsContractApi21Impl.getTreeDocumentId(uri);
    }

    public static boolean isDocumentUri(Context context, Uri uri) {
        return DocumentsContract.isDocumentUri((Context)context, (Uri)uri);
    }

    public static boolean isTreeUri(Uri uri) {
        return DocumentsContractApi24Impl.isTreeUri(uri);
    }

    public static boolean removeDocument(ContentResolver contentResolver, Uri uri, Uri uri2) throws FileNotFoundException {
        return DocumentsContractApi24Impl.removeDocument(contentResolver, uri, uri2);
    }

    public static Uri renameDocument(ContentResolver contentResolver, Uri uri, String string2) throws FileNotFoundException {
        return DocumentsContractApi21Impl.renameDocument(contentResolver, uri, string2);
    }

    public static final class DocumentCompat {
        public static final int FLAG_VIRTUAL_DOCUMENT = 512;

        private DocumentCompat() {
        }
    }

    private static class DocumentsContractApi21Impl {
        private DocumentsContractApi21Impl() {
        }

        static Uri buildChildDocumentsUri(String string2, String string3) {
            return DocumentsContract.buildChildDocumentsUri((String)string2, (String)string3);
        }

        static Uri buildChildDocumentsUriUsingTree(Uri uri, String string2) {
            return DocumentsContract.buildChildDocumentsUriUsingTree((Uri)uri, (String)string2);
        }

        static Uri buildDocumentUriUsingTree(Uri uri, String string2) {
            return DocumentsContract.buildDocumentUriUsingTree((Uri)uri, (String)string2);
        }

        public static Uri buildTreeDocumentUri(String string2, String string3) {
            return DocumentsContract.buildTreeDocumentUri((String)string2, (String)string3);
        }

        static Uri createDocument(ContentResolver contentResolver, Uri uri, String string2, String string3) throws FileNotFoundException {
            return DocumentsContract.createDocument((ContentResolver)contentResolver, (Uri)uri, (String)string2, (String)string3);
        }

        static String getTreeDocumentId(Uri uri) {
            return DocumentsContract.getTreeDocumentId((Uri)uri);
        }

        static Uri renameDocument(ContentResolver contentResolver, Uri uri, String string2) throws FileNotFoundException {
            return DocumentsContract.renameDocument((ContentResolver)contentResolver, (Uri)uri, (String)string2);
        }
    }

    private static class DocumentsContractApi24Impl {
        private DocumentsContractApi24Impl() {
        }

        static boolean isTreeUri(Uri uri) {
            return DocumentsContract.isTreeUri((Uri)uri);
        }

        static boolean removeDocument(ContentResolver contentResolver, Uri uri, Uri uri2) throws FileNotFoundException {
            return DocumentsContract.removeDocument((ContentResolver)contentResolver, (Uri)uri, (Uri)uri2);
        }
    }
}

