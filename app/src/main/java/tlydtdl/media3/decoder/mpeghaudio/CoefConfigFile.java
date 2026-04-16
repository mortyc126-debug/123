package tlydtdl.media3.decoder.mpeghaudio;

import amuvvoafs.content.Context;
import f3.f2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import o8.b;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class CoefConfigFile {
    private static String TAG = "CoefConfigFile";
    private static String kCpConfigFileName = "com.sony.360ra.cp.config";
    private static String kHrtfConfigFileName = "com.sony.360ra.hrtf13.config";
    private static String kRelativeFileDir = "files/com.sony.immersive-audio/coef/";
    private String appRootpath;
    private String relativeRootPath = kRelativeFileDir;

    /* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
    public enum CoefType {
        Hrtf13("hrtf13"),
        Cp("cp");

        private final String str;

        CoefType(String str) {
            this.str = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.str;
        }
    }

    public CoefConfigFile(String str) {
        this.appRootpath = HttpUrl.FRAGMENT_ENCODE_SET;
        this.appRootpath = f2.C(str, "/");
        printInfo();
    }

    public static String getAppRootPath(Context context) {
        return context.getFilesDir().getParent();
    }

    public String getAbsoluteConfigFilePath(CoefType coefType) {
        return this.appRootpath + getRelativeConfigFilePath(coefType);
    }

    public String getConfigFileName(CoefType coefType) {
        int iOrdinal = coefType.ordinal();
        return iOrdinal != 0 ? iOrdinal != 1 ? HttpUrl.FRAGMENT_ENCODE_SET : kCpConfigFileName : kHrtfConfigFileName;
    }

    public String getRelativeConfigFilePath(CoefType coefType) {
        return this.relativeRootPath + getConfigFileName(coefType);
    }

    public String getRelativeRootPath() {
        return this.relativeRootPath;
    }

    public boolean isExistConfigFile(CoefType coefType) {
        return new File(getAbsoluteConfigFilePath(coefType)).exists();
    }

    public void printInfo() {
        b.l(TAG, "App root path: " + this.appRootpath);
        b.l(TAG, "Relative root path: " + this.relativeRootPath);
        String str = TAG;
        StringBuilder sb = new StringBuilder("Absolute HRTF config filepath: ");
        CoefType coefType = CoefType.Hrtf13;
        sb.append(getAbsoluteConfigFilePath(coefType));
        b.l(str, sb.toString());
        String str2 = TAG;
        StringBuilder sb2 = new StringBuilder("Absolute CP config filepath: ");
        CoefType coefType2 = CoefType.Cp;
        sb2.append(getAbsoluteConfigFilePath(coefType2));
        b.l(str2, sb2.toString());
        b.l(TAG, "Relative HRTF config filepath: " + getRelativeConfigFilePath(coefType));
        b.l(TAG, "Relative CP config filepath: " + getRelativeConfigFilePath(coefType2));
    }

    public String readAbsoluteCoefFilePath(CoefType coefType) {
        return i.p(new StringBuilder(), this.appRootpath, readConfigFile(getAbsoluteConfigFilePath(coefType)));
    }

    public String readConfigFile(String str) {
        String line = HttpUrl.FRAGMENT_ENCODE_SET;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(str)));
            line = bufferedReader.readLine();
            bufferedReader.close();
            return line;
        } catch (FileNotFoundException e) {
            System.out.println(e);
            return line;
        } catch (IOException e2) {
            System.out.println(e2);
            return line;
        }
    }

    public String readRelativeCoefFilePath(CoefType coefType) {
        return readConfigFile(getAbsoluteConfigFilePath(coefType));
    }
}
