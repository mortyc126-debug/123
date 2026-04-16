/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.hardware.fingerprint.FingerprintManager
 *  android.hardware.fingerprint.FingerprintManager$AuthenticationCallback
 *  android.hardware.fingerprint.FingerprintManager$AuthenticationResult
 *  android.hardware.fingerprint.FingerprintManager$CryptoObject
 *  android.os.CancellationSignal
 *  android.os.Handler
 */
package androidx.core.hardware.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Handler;
import androidx.core.os.CancellationSignal;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@Deprecated
public class FingerprintManagerCompat {
    private final Context mContext;

    private FingerprintManagerCompat(Context context) {
        this.mContext = context;
    }

    public static FingerprintManagerCompat from(Context context) {
        return new FingerprintManagerCompat(context);
    }

    private static FingerprintManager getFingerprintManagerOrNull(Context context) {
        return Api23Impl.getFingerprintManagerOrNull(context);
    }

    static CryptoObject unwrapCryptoObject(FingerprintManager.CryptoObject cryptoObject) {
        return Api23Impl.unwrapCryptoObject(cryptoObject);
    }

    private static FingerprintManager.AuthenticationCallback wrapCallback(AuthenticationCallback authenticationCallback) {
        return new FingerprintManager.AuthenticationCallback(authenticationCallback){
            final AuthenticationCallback val$callback;
            {
                this.val$callback = authenticationCallback;
            }

            public void onAuthenticationError(int n, CharSequence charSequence) {
                this.val$callback.onAuthenticationError(n, charSequence);
            }

            public void onAuthenticationFailed() {
                this.val$callback.onAuthenticationFailed();
            }

            public void onAuthenticationHelp(int n, CharSequence charSequence) {
                this.val$callback.onAuthenticationHelp(n, charSequence);
            }

            public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
                this.val$callback.onAuthenticationSucceeded(new AuthenticationResult(FingerprintManagerCompat.unwrapCryptoObject(Api23Impl.getCryptoObject(authenticationResult))));
            }
        };
    }

    private static FingerprintManager.CryptoObject wrapCryptoObject(CryptoObject cryptoObject) {
        return Api23Impl.wrapCryptoObject(cryptoObject);
    }

    public void authenticate(CryptoObject cryptoObject, int n, android.os.CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler) {
        FingerprintManager fingerprintManager = FingerprintManagerCompat.getFingerprintManagerOrNull(this.mContext);
        if (fingerprintManager != null) {
            Api23Impl.authenticate(fingerprintManager, FingerprintManagerCompat.wrapCryptoObject(cryptoObject), cancellationSignal, n, FingerprintManagerCompat.wrapCallback(authenticationCallback), handler);
        }
    }

    @Deprecated
    public void authenticate(CryptoObject cryptoObject, int n, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler) {
        cancellationSignal = cancellationSignal != null ? (android.os.CancellationSignal)cancellationSignal.getCancellationSignalObject() : null;
        this.authenticate(cryptoObject, n, (android.os.CancellationSignal)cancellationSignal, authenticationCallback, handler);
    }

    public boolean hasEnrolledFingerprints() {
        FingerprintManager fingerprintManager = FingerprintManagerCompat.getFingerprintManagerOrNull(this.mContext);
        boolean bl = fingerprintManager != null && Api23Impl.hasEnrolledFingerprints(fingerprintManager);
        return bl;
    }

    public boolean isHardwareDetected() {
        FingerprintManager fingerprintManager = FingerprintManagerCompat.getFingerprintManagerOrNull(this.mContext);
        boolean bl = fingerprintManager != null && Api23Impl.isHardwareDetected(fingerprintManager);
        return bl;
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static void authenticate(Object object, Object object2, android.os.CancellationSignal cancellationSignal, int n, Object object3, Handler handler) {
            ((FingerprintManager)object).authenticate((FingerprintManager.CryptoObject)object2, cancellationSignal, n, (FingerprintManager.AuthenticationCallback)object3, handler);
        }

        static FingerprintManager.CryptoObject getCryptoObject(Object object) {
            return ((FingerprintManager.AuthenticationResult)object).getCryptoObject();
        }

        public static FingerprintManager getFingerprintManagerOrNull(Context context) {
            if (context.getPackageManager().hasSystemFeature("android.hardware.fingerprint")) {
                return (FingerprintManager)context.getSystemService(FingerprintManager.class);
            }
            return null;
        }

        static boolean hasEnrolledFingerprints(Object object) {
            return ((FingerprintManager)object).hasEnrolledFingerprints();
        }

        static boolean isHardwareDetected(Object object) {
            return ((FingerprintManager)object).isHardwareDetected();
        }

        public static CryptoObject unwrapCryptoObject(Object object) {
            if ((object = (FingerprintManager.CryptoObject)object) == null) {
                return null;
            }
            if (object.getCipher() != null) {
                return new CryptoObject(object.getCipher());
            }
            if (object.getSignature() != null) {
                return new CryptoObject(object.getSignature());
            }
            if (object.getMac() != null) {
                return new CryptoObject(object.getMac());
            }
            return null;
        }

        public static FingerprintManager.CryptoObject wrapCryptoObject(CryptoObject cryptoObject) {
            if (cryptoObject == null) {
                return null;
            }
            if (cryptoObject.getCipher() != null) {
                return new FingerprintManager.CryptoObject(cryptoObject.getCipher());
            }
            if (cryptoObject.getSignature() != null) {
                return new FingerprintManager.CryptoObject(cryptoObject.getSignature());
            }
            if (cryptoObject.getMac() != null) {
                return new FingerprintManager.CryptoObject(cryptoObject.getMac());
            }
            return null;
        }
    }

    public static abstract class AuthenticationCallback {
        public void onAuthenticationError(int n, CharSequence charSequence) {
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationHelp(int n, CharSequence charSequence) {
        }

        public void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
        }
    }

    public static final class AuthenticationResult {
        private final CryptoObject mCryptoObject;

        public AuthenticationResult(CryptoObject cryptoObject) {
            this.mCryptoObject = cryptoObject;
        }

        public CryptoObject getCryptoObject() {
            return this.mCryptoObject;
        }
    }

    public static class CryptoObject {
        private final Cipher mCipher;
        private final Mac mMac;
        private final Signature mSignature;

        public CryptoObject(Signature signature) {
            this.mSignature = signature;
            this.mCipher = null;
            this.mMac = null;
        }

        public CryptoObject(Cipher cipher) {
            this.mCipher = cipher;
            this.mSignature = null;
            this.mMac = null;
        }

        public CryptoObject(Mac mac) {
            this.mMac = mac;
            this.mCipher = null;
            this.mSignature = null;
        }

        public Cipher getCipher() {
            return this.mCipher;
        }

        public Mac getMac() {
            return this.mMac;
        }

        public Signature getSignature() {
            return this.mSignature;
        }
    }
}

