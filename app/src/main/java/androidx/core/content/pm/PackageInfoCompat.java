/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.Signature
 *  android.content.pm.SigningInfo
 *  android.os.Build$VERSION
 */
package androidx.core.content.pm;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class PackageInfoCompat {
    private PackageInfoCompat() {
    }

    private static boolean byteArrayContains(byte[][] byArray, byte[] byArray2) {
        int n = byArray.length;
        for (int i = 0; i < n; ++i) {
            if (!Arrays.equals(byArray2, byArray[i])) continue;
            return true;
        }
        return false;
    }

    private static byte[] computeSHA256Digest(byte[] byArray) {
        try {
            byArray = MessageDigest.getInstance("SHA256").digest(byArray);
            return byArray;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new RuntimeException("Device doesn't support SHA256 cert checking", noSuchAlgorithmException);
        }
    }

    public static long getLongVersionCode(PackageInfo packageInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getLongVersionCode(packageInfo);
        }
        return packageInfo.versionCode;
    }

    public static List<Signature> getSignatures(PackageManager signatureArray, String string2) throws PackageManager.NameNotFoundException {
        signatureArray = Build.VERSION.SDK_INT >= 28 ? (Api28Impl.hasMultipleSigners((SigningInfo)(signatureArray = signatureArray.getPackageInfo((String)string2, (int)0x8000000).signingInfo)) ? Api28Impl.getApkContentsSigners((SigningInfo)signatureArray) : Api28Impl.getSigningCertificateHistory((SigningInfo)signatureArray)) : signatureArray.getPackageInfo((String)string2, (int)64).signatures;
        if (signatureArray == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(signatureArray);
    }

    public static boolean hasSignatures(PackageManager object, String object2, Map<byte[], Integer> object3, boolean bl) throws PackageManager.NameNotFoundException {
        if (object3.isEmpty()) {
            return false;
        }
        Object object4 = object3.keySet();
        Object object5 = object4.iterator();
        while (object5.hasNext()) {
            Object object6 = object5.next();
            if (object6 != null) {
                if ((object6 = (Object)object3.get(object6)) != null) {
                    switch (object6.intValue()) {
                        default: {
                            throw new IllegalArgumentException("Unsupported certificate type " + object6 + " when verifying " + (String)object2);
                        }
                        case 0: 
                        case 1: 
                    }
                    continue;
                }
                throw new IllegalArgumentException("Type must be specified for cert when verifying " + (String)object2);
            }
            throw new IllegalArgumentException("Cert byte array cannot be null when verifying " + (String)object2);
        }
        object5 = PackageInfoCompat.getSignatures(object, (String)object2);
        if (!bl && Build.VERSION.SDK_INT >= 28) {
            object4 = object4.iterator();
            while (object4.hasNext()) {
                object5 = (byte[])object4.next();
                if (Api28Impl.hasSigningCertificate(object, (String)object2, (byte[])object5, object3.get(object5))) continue;
                return false;
            }
            return true;
        }
        if (!(object5.size() == 0 || object3.size() > object5.size() || bl && object3.size() != object5.size())) {
            bl = object3.containsValue(1);
            object = null;
            if (bl) {
                object2 = new byte[object5.size()][];
                int n = 0;
                while (true) {
                    object = object2;
                    if (n >= object5.size()) break;
                    object2[n] = PackageInfoCompat.computeSHA256Digest(((Signature)object5.get(n)).toByteArray());
                    ++n;
                }
            }
            if ((object2 = object4.iterator()).hasNext()) {
                object2 = (byte[])object2.next();
                object3 = object3.get(object2);
                switch ((Integer)object3) {
                    default: {
                        throw new IllegalArgumentException("Unsupported certificate type " + object3);
                    }
                    case 1: {
                        if (PackageInfoCompat.byteArrayContains((byte[][])object, (byte[])object2)) break;
                        return false;
                    }
                    case 0: {
                        if (object5.contains(new Signature((byte[])object2))) break;
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private static class Api28Impl {
        private Api28Impl() {
        }

        static Signature[] getApkContentsSigners(SigningInfo signingInfo) {
            return signingInfo.getApkContentsSigners();
        }

        static long getLongVersionCode(PackageInfo packageInfo) {
            return packageInfo.getLongVersionCode();
        }

        static Signature[] getSigningCertificateHistory(SigningInfo signingInfo) {
            return signingInfo.getSigningCertificateHistory();
        }

        static boolean hasMultipleSigners(SigningInfo signingInfo) {
            return signingInfo.hasMultipleSigners();
        }

        static boolean hasSigningCertificate(PackageManager packageManager, String string2, byte[] byArray, int n) {
            return packageManager.hasSigningCertificate(string2, byArray, n);
        }
    }
}

