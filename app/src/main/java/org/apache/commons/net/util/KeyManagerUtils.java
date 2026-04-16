package org.apache.commons.net.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.function.IntFunction;
import javax.net.ssl.KeyManager;
import javax.net.ssl.X509ExtendedKeyManager;
import org.apache.commons.net.io.Util;
import org.apache.commons.net.util.KeyManagerUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class KeyManagerUtils {
    private static final String DEFAULT_STORE_TYPE = KeyStore.getDefaultType();

    /* JADX INFO: Access modifiers changed from: private */
    static class ClientKeyStore {
        private final X509Certificate[] certChain;
        private final PrivateKey key;
        private final String keyAlias;

        ClientKeyStore(KeyStore ks, String keyAlias, String keyPass) throws GeneralSecurityException {
            this.keyAlias = keyAlias;
            this.key = (PrivateKey) ks.getKey(this.keyAlias, keyPass.toCharArray());
            final Certificate[] certs = ks.getCertificateChain(this.keyAlias);
            X509Certificate[] x509certs = new X509Certificate[certs.length];
            Arrays.setAll(x509certs, new IntFunction() { // from class: org.apache.commons.net.util.KeyManagerUtils$ClientKeyStore$$ExternalSyntheticLambda0
                @Override // java.util.function.IntFunction
                public final Object apply(int i) {
                    return KeyManagerUtils.ClientKeyStore.lambda$new$0(certs, i);
                }
            });
            this.certChain = x509certs;
        }

        static /* synthetic */ X509Certificate lambda$new$0(Certificate[] certs, int i) {
            return (X509Certificate) certs[i];
        }

        final String getAlias() {
            return this.keyAlias;
        }

        final X509Certificate[] getCertificateChain() {
            return this.certChain;
        }

        final PrivateKey getPrivateKey() {
            return this.key;
        }
    }

    private static class X509KeyManager extends X509ExtendedKeyManager {
        private final ClientKeyStore keyStore;

        X509KeyManager(ClientKeyStore keyStore) {
            this.keyStore = keyStore;
        }

        @Override // javax.net.ssl.X509KeyManager
        public String chooseClientAlias(String[] keyType, Principal[] issuers, Socket socket) {
            return this.keyStore.getAlias();
        }

        @Override // javax.net.ssl.X509KeyManager
        public String chooseServerAlias(String keyType, Principal[] issuers, Socket socket) {
            return null;
        }

        @Override // javax.net.ssl.X509KeyManager
        public X509Certificate[] getCertificateChain(String alias) {
            return this.keyStore.getCertificateChain();
        }

        @Override // javax.net.ssl.X509KeyManager
        public String[] getClientAliases(String keyType, Principal[] issuers) {
            return new String[]{this.keyStore.getAlias()};
        }

        @Override // javax.net.ssl.X509KeyManager
        public PrivateKey getPrivateKey(String alias) {
            return this.keyStore.getPrivateKey();
        }

        @Override // javax.net.ssl.X509KeyManager
        public String[] getServerAliases(String keyType, Principal[] issuers) {
            return null;
        }
    }

    public static KeyManager createClientKeyManager(File storePath, String storePass) throws GeneralSecurityException, IOException {
        return createClientKeyManager(DEFAULT_STORE_TYPE, storePath, storePass, null, storePass);
    }

    public static KeyManager createClientKeyManager(File storePath, String storePass, String keyAlias) throws GeneralSecurityException, IOException {
        return createClientKeyManager(DEFAULT_STORE_TYPE, storePath, storePass, keyAlias, storePass);
    }

    public static KeyManager createClientKeyManager(KeyStore ks, String keyAlias, String keyPass) throws GeneralSecurityException {
        ClientKeyStore cks = new ClientKeyStore(ks, keyAlias != null ? keyAlias : findAlias(ks), keyPass);
        return new X509KeyManager(cks);
    }

    public static KeyManager createClientKeyManager(String storeType, File storePath, String storePass, String keyAlias, String keyPass) throws GeneralSecurityException, IOException {
        KeyStore ks = loadStore(storeType, storePath, storePass);
        return createClientKeyManager(ks, keyAlias, keyPass);
    }

    private static String findAlias(KeyStore ks) throws KeyStoreException {
        Enumeration<String> e = ks.aliases();
        while (e.hasMoreElements()) {
            String entry = e.nextElement();
            if (ks.isKeyEntry(entry)) {
                return entry;
            }
        }
        throw new KeyStoreException("Cannot find a private key entry");
    }

    private static KeyStore loadStore(String storeType, File storePath, String storePass) throws GeneralSecurityException, IOException {
        KeyStore ks = KeyStore.getInstance(storeType);
        FileInputStream stream = null;
        try {
            stream = new FileInputStream(storePath);
            ks.load(stream, storePass.toCharArray());
            return ks;
        } finally {
            Util.closeQuietly(stream);
        }
    }

    private KeyManagerUtils() {
    }
}
