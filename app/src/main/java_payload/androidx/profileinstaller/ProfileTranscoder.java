/*
 * Decompiled with CFR 0.152.
 */
package androidx.profileinstaller;

import androidx.profileinstaller.DexProfileData;
import androidx.profileinstaller.Encoding;
import androidx.profileinstaller.FileSectionType;
import androidx.profileinstaller.ProfileVersion;
import androidx.profileinstaller.WritableFileSection;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Map;
import java.util.TreeMap;

class ProfileTranscoder {
    private static final int HOT = 1;
    private static final int INLINE_CACHE_MEGAMORPHIC_ENCODING = 7;
    private static final int INLINE_CACHE_MISSING_TYPES_ENCODING = 6;
    static final byte[] MAGIC_PROF = new byte[]{112, 114, 111, 0};
    static final byte[] MAGIC_PROFM = new byte[]{112, 114, 109, 0};
    private static final int POST_STARTUP = 4;
    private static final int STARTUP = 2;

    private ProfileTranscoder() {
    }

    private static int computeMethodFlags(DexProfileData object) {
        int n = 0;
        object = ((DexProfileData)object).methods.entrySet().iterator();
        while (object.hasNext()) {
            n |= ((Integer)((Map.Entry)object.next()).getValue()).intValue();
        }
        return n;
    }

    private static byte[] createCompressibleBody(DexProfileData[] dexProfileDataArray, byte[] byArray) throws IOException {
        Object object2;
        int n;
        int n2 = 0;
        int n3 = dexProfileDataArray.length;
        int n4 = 0;
        int n5 = 0;
        for (n = 0; n < n3; ++n) {
            object2 = dexProfileDataArray[n];
            String object3 = ProfileTranscoder.generateDexKey(((DexProfileData)object2).apkName, ((DexProfileData)object2).dexName, byArray);
            n2 += Encoding.utf8Length(object3) + 16 + ((DexProfileData)object2).classSetSize * 2 + ((DexProfileData)object2).hotMethodRegionSize + ProfileTranscoder.getMethodBitmapStorageSize(((DexProfileData)object2).numMethodIds);
        }
        object2 = new ByteArrayOutputStream(n2);
        if (Arrays.equals(byArray, ProfileVersion.V009_O_MR1)) {
            n4 = dexProfileDataArray.length;
            for (n = n5; n < n4; ++n) {
                DexProfileData dexProfileData = dexProfileDataArray[n];
                ProfileTranscoder.writeLineHeader((OutputStream)object2, dexProfileData, ProfileTranscoder.generateDexKey(dexProfileData.apkName, dexProfileData.dexName, byArray));
                ProfileTranscoder.writeLineData((OutputStream)object2, dexProfileData);
            }
        } else {
            for (DexProfileData dexProfileData : dexProfileDataArray) {
                ProfileTranscoder.writeLineHeader((OutputStream)object2, dexProfileData, ProfileTranscoder.generateDexKey(dexProfileData.apkName, dexProfileData.dexName, byArray));
            }
            n5 = dexProfileDataArray.length;
            for (n = n4; n < n5; ++n) {
                ProfileTranscoder.writeLineData((OutputStream)object2, dexProfileDataArray[n]);
            }
        }
        if (((ByteArrayOutputStream)object2).size() == n2) {
            return ((ByteArrayOutputStream)object2).toByteArray();
        }
        throw Encoding.error("The bytes saved do not match expectation. actual=" + ((ByteArrayOutputStream)object2).size() + " expected=" + n2);
    }

    private static WritableFileSection createCompressibleClassSection(DexProfileData[] object) throws IOException {
        Object object2;
        int n = 0;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n2 = 0;
        while (true) {
            if (n2 >= ((DexProfileData[])object).length) break;
            object2 = object[n2];
            Encoding.writeUInt16(byteArrayOutputStream, n2);
            Encoding.writeUInt16(byteArrayOutputStream, ((DexProfileData)object2).classSetSize);
            n = n + 2 + 2 + ((DexProfileData)object2).classSetSize * 2;
            ProfileTranscoder.writeClasses(byteArrayOutputStream, (DexProfileData)object2);
            ++n2;
            continue;
            break;
        }
        try {
            object = byteArrayOutputStream.toByteArray();
            if (n == ((DexProfileData[])object).length) {
                object = new WritableFileSection(FileSectionType.CLASSES, n, (byte[])object, true);
                return object;
            }
            object2 = new StringBuilder();
            throw Encoding.error(((StringBuilder)object2).append("Expected size ").append(n).append(", does not match actual size ").append(((DexProfileData[])object).length).toString());
        }
        catch (Throwable throwable) {
            throw throwable;
        }
        finally {
            byteArrayOutputStream.close();
        }
    }

    private static WritableFileSection createCompressibleMethodsSection(DexProfileData[] object) throws IOException {
        Object object2;
        int n = 0;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n2 = 0;
        while (true) {
            if (n2 >= ((DexProfileData[])object).length) break;
            Object object3 = object[n2];
            int n3 = ProfileTranscoder.computeMethodFlags((DexProfileData)object3);
            object2 = ProfileTranscoder.createMethodBitmapRegion((DexProfileData)object3);
            object3 = ProfileTranscoder.createMethodsWithInlineCaches((DexProfileData)object3);
            Encoding.writeUInt16(byteArrayOutputStream, n2);
            int n4 = ((Object)object2).length + 2 + ((Object)object3).length;
            Encoding.writeUInt32(byteArrayOutputStream, n4);
            Encoding.writeUInt16(byteArrayOutputStream, n3);
            byteArrayOutputStream.write((byte[])object2);
            byteArrayOutputStream.write((byte[])object3);
            n = n + 2 + 4 + n4;
            ++n2;
            continue;
            break;
        }
        try {
            object = byteArrayOutputStream.toByteArray();
            if (n == ((DexProfileData[])object).length) {
                object = new WritableFileSection(FileSectionType.METHODS, n, (byte[])object, true);
                return object;
            }
            object2 = new StringBuilder;
            ((StringBuilder)object2)();
            throw Encoding.error(((StringBuilder)object2).append("Expected size ").append(n).append(", does not match actual size ").append(((DexProfileData[])object).length).toString());
        }
        catch (Throwable throwable) {
            throw throwable;
        }
        finally {
            byteArrayOutputStream.close();
        }
    }

    private static byte[] createMethodBitmapRegion(DexProfileData object) throws IOException {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();){
            ProfileTranscoder.writeMethodBitmap(byteArrayOutputStream, (DexProfileData)object);
            object = byteArrayOutputStream.toByteArray();
            return object;
        }
    }

    private static byte[] createMethodsWithInlineCaches(DexProfileData object) throws IOException {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();){
            ProfileTranscoder.writeMethodsWithInlineCaches(byteArrayOutputStream, (DexProfileData)object);
            object = byteArrayOutputStream.toByteArray();
            return object;
        }
    }

    private static String enforceSeparator(String string2, String string3) {
        if ("!".equals(string3)) {
            return string2.replace(":", "!");
        }
        if (":".equals(string3)) {
            return string2.replace("!", ":");
        }
        return string2;
    }

    private static String extractKey(String string2) {
        int n;
        int n2 = n = string2.indexOf("!");
        if (n < 0) {
            n2 = string2.indexOf(":");
        }
        if (n2 > 0) {
            return string2.substring(n2 + 1);
        }
        return string2;
    }

    private static DexProfileData findByDexName(DexProfileData[] dexProfileDataArray, String string2) {
        if (dexProfileDataArray.length <= 0) {
            return null;
        }
        string2 = ProfileTranscoder.extractKey(string2);
        for (int i = 0; i < dexProfileDataArray.length; ++i) {
            if (!dexProfileDataArray[i].dexName.equals(string2)) continue;
            return dexProfileDataArray[i];
        }
        return null;
    }

    private static String generateDexKey(String string2, String string3, byte[] byArray) {
        String string4 = ProfileVersion.dexKeySeparator(byArray);
        if (string2.length() <= 0) {
            return ProfileTranscoder.enforceSeparator(string3, string4);
        }
        if (string3.equals("classes.dex")) {
            return string2;
        }
        if (!string3.contains("!") && !string3.contains(":")) {
            if (string3.endsWith(".apk")) {
                return string3;
            }
            return string2 + ProfileVersion.dexKeySeparator(byArray) + string3;
        }
        return ProfileTranscoder.enforceSeparator(string3, string4);
    }

    private static int getMethodBitmapStorageSize(int n) {
        return ProfileTranscoder.roundUpToByte(n * 2) / 8;
    }

    private static int methodFlagBitmapIndex(int n, int n2, int n3) {
        switch (n) {
            default: {
                throw Encoding.error("Unexpected flag: " + n);
            }
            case 4: {
                return n2 + n3;
            }
            case 2: {
                return n2;
            }
            case 1: 
        }
        throw Encoding.error("HOT methods are not stored in the bitmap");
    }

    private static int[] readClasses(InputStream inputStream, int n) throws IOException {
        int[] nArray = new int[n];
        int n2 = 0;
        for (int i = 0; i < n; ++i) {
            nArray[i] = n2 += Encoding.readUInt16(inputStream);
        }
        return nArray;
    }

    private static int readFlagsFromBitmap(BitSet bitSet, int n, int n2) {
        int n3 = 0;
        if (bitSet.get(ProfileTranscoder.methodFlagBitmapIndex(2, n, n2))) {
            n3 = 0 | 2;
        }
        int n4 = n3;
        if (bitSet.get(ProfileTranscoder.methodFlagBitmapIndex(4, n, n2))) {
            n4 = n3 | 4;
        }
        return n4;
    }

    static byte[] readHeader(InputStream inputStream, byte[] byArray) throws IOException {
        if (Arrays.equals(byArray, Encoding.read(inputStream, byArray.length))) {
            return Encoding.read(inputStream, ProfileVersion.V010_P.length);
        }
        throw Encoding.error("Invalid magic");
    }

    private static void readHotMethodRegion(InputStream inputStream, DexProfileData dexProfileData) throws IOException {
        int n = inputStream.available() - dexProfileData.hotMethodRegionSize;
        int n2 = 0;
        while (inputStream.available() > n) {
            int n3 = n2 + Encoding.readUInt16(inputStream);
            dexProfileData.methods.put(n3, 1);
            for (n2 = Encoding.readUInt16(inputStream); n2 > 0; --n2) {
                ProfileTranscoder.skipInlineCache(inputStream);
            }
            n2 = n3;
        }
        if (inputStream.available() == n) {
            return;
        }
        throw Encoding.error("Read too much data during profile line parse");
    }

    static DexProfileData[] readMeta(InputStream inputStream, byte[] byArray, byte[] byArray2, DexProfileData[] dexProfileDataArray) throws IOException {
        if (Arrays.equals(byArray, ProfileVersion.METADATA_V001_N)) {
            if (!Arrays.equals(ProfileVersion.V015_S, byArray2)) {
                return ProfileTranscoder.readMetadata001(inputStream, byArray, dexProfileDataArray);
            }
            throw Encoding.error("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
        }
        if (Arrays.equals(byArray, ProfileVersion.METADATA_V002)) {
            return ProfileTranscoder.readMetadataV002(inputStream, byArray2, dexProfileDataArray);
        }
        throw Encoding.error("Unsupported meta version");
    }

    static DexProfileData[] readMetadata001(InputStream inputStream, byte[] objectArray, DexProfileData[] dexProfileDataArray) throws IOException {
        if (Arrays.equals(objectArray, ProfileVersion.METADATA_V001_N)) {
            int n = Encoding.readUInt8(inputStream);
            long l = Encoding.readUInt32(inputStream);
            objectArray = Encoding.readCompressed(inputStream, (int)Encoding.readUInt32(inputStream), (int)l);
            if (inputStream.read() <= 0) {
                inputStream = new ByteArrayInputStream((byte[])objectArray);
                try {
                    objectArray = ProfileTranscoder.readMetadataForNBody(inputStream, n, dexProfileDataArray);
                    return objectArray;
                }
                finally {
                    inputStream.close();
                }
            }
            throw Encoding.error("Content found after the end of file");
        }
        throw Encoding.error("Unsupported meta version");
    }

    private static DexProfileData[] readMetadataForNBody(InputStream inputStream, int n, DexProfileData[] dexProfileDataArray) throws IOException {
        if (inputStream.available() == 0) {
            return new DexProfileData[0];
        }
        if (n == dexProfileDataArray.length) {
            int n2;
            String[] stringArray = new String[n];
            int[] nArray = new int[n];
            for (n2 = 0; n2 < n; ++n2) {
                int n3 = Encoding.readUInt16(inputStream);
                nArray[n2] = Encoding.readUInt16(inputStream);
                stringArray[n2] = Encoding.readString(inputStream, n3);
            }
            for (n2 = 0; n2 < n; ++n2) {
                DexProfileData dexProfileData = dexProfileDataArray[n2];
                if (dexProfileData.dexName.equals(stringArray[n2])) {
                    dexProfileData.classSetSize = nArray[n2];
                    dexProfileData.classes = ProfileTranscoder.readClasses(inputStream, dexProfileData.classSetSize);
                    continue;
                }
                throw Encoding.error("Order of dexfiles in metadata did not match baseline");
            }
            return dexProfileDataArray;
        }
        throw Encoding.error("Mismatched number of dex files found in metadata");
    }

    static DexProfileData[] readMetadataV002(InputStream inputStream, byte[] objectArray, DexProfileData[] dexProfileDataArray) throws IOException {
        int n = Encoding.readUInt16(inputStream);
        long l = Encoding.readUInt32(inputStream);
        byte[] byArray = Encoding.readCompressed(inputStream, (int)Encoding.readUInt32(inputStream), (int)l);
        if (inputStream.read() <= 0) {
            inputStream = new ByteArrayInputStream(byArray);
            try {
                objectArray = ProfileTranscoder.readMetadataV002Body(inputStream, objectArray, n, dexProfileDataArray);
                return objectArray;
            }
            finally {
                inputStream.close();
            }
        }
        throw Encoding.error("Content found after the end of file");
    }

    private static DexProfileData[] readMetadataV002Body(InputStream inputStream, byte[] byArray, int n, DexProfileData[] dexProfileDataArray) throws IOException {
        if (inputStream.available() == 0) {
            return new DexProfileData[0];
        }
        if (n == dexProfileDataArray.length) {
            for (int i = 0; i < n; ++i) {
                Encoding.readUInt16(inputStream);
                Object object = Encoding.readString(inputStream, Encoding.readUInt16(inputStream));
                long l = Encoding.readUInt32(inputStream);
                int n2 = Encoding.readUInt16(inputStream);
                DexProfileData dexProfileData = ProfileTranscoder.findByDexName(dexProfileDataArray, (String)object);
                if (dexProfileData != null) {
                    dexProfileData.mTypeIdCount = l;
                    object = ProfileTranscoder.readClasses(inputStream, n2);
                    if (!Arrays.equals(byArray, ProfileVersion.V001_N)) continue;
                    dexProfileData.classSetSize = n2;
                    dexProfileData.classes = (int[])object;
                    continue;
                }
                throw Encoding.error("Missing profile key: " + (String)object);
            }
            return dexProfileDataArray;
        }
        throw Encoding.error("Mismatched number of dex files found in metadata");
    }

    private static void readMethodBitmap(InputStream object, DexProfileData dexProfileData) throws IOException {
        BitSet bitSet = BitSet.valueOf(Encoding.read((InputStream)object, Encoding.bitsToBytes(dexProfileData.numMethodIds * 2)));
        for (int i = 0; i < dexProfileData.numMethodIds; ++i) {
            int n = ProfileTranscoder.readFlagsFromBitmap(bitSet, i, dexProfileData.numMethodIds);
            if (n == 0) continue;
            Integer n2 = dexProfileData.methods.get(i);
            object = n2;
            if (n2 == null) {
                object = 0;
            }
            dexProfileData.methods.put(i, (Integer)object | n);
        }
    }

    static DexProfileData[] readProfile(InputStream inputStream, byte[] objectArray, String string2) throws IOException {
        if (Arrays.equals(objectArray, ProfileVersion.V010_P)) {
            int n = Encoding.readUInt8(inputStream);
            long l = Encoding.readUInt32(inputStream);
            objectArray = Encoding.readCompressed(inputStream, (int)Encoding.readUInt32(inputStream), (int)l);
            if (inputStream.read() <= 0) {
                inputStream = new ByteArrayInputStream((byte[])objectArray);
                try {
                    objectArray = ProfileTranscoder.readUncompressedBody(inputStream, string2, n);
                    return objectArray;
                }
                finally {
                    inputStream.close();
                }
            }
            throw Encoding.error("Content found after the end of file");
        }
        throw Encoding.error("Unsupported version");
    }

    private static DexProfileData[] readUncompressedBody(InputStream inputStream, String object, int n) throws IOException {
        int n2 = inputStream.available();
        int n3 = 0;
        if (n2 == 0) {
            return new DexProfileData[0];
        }
        DexProfileData[] dexProfileDataArray = new DexProfileData[n];
        for (n2 = 0; n2 < n; ++n2) {
            int n4 = Encoding.readUInt16(inputStream);
            int n5 = Encoding.readUInt16(inputStream);
            long l = Encoding.readUInt32(inputStream);
            long l2 = Encoding.readUInt32(inputStream);
            long l3 = Encoding.readUInt32(inputStream);
            dexProfileDataArray[n2] = new DexProfileData((String)object, Encoding.readString(inputStream, n4), l2, 0L, n5, (int)l, (int)l3, new int[n5], new TreeMap<Integer, Integer>());
        }
        n2 = dexProfileDataArray.length;
        for (n = n3; n < n2; ++n) {
            object = dexProfileDataArray[n];
            ProfileTranscoder.readHotMethodRegion(inputStream, (DexProfileData)object);
            ((DexProfileData)object).classes = ProfileTranscoder.readClasses(inputStream, ((DexProfileData)object).classSetSize);
            ProfileTranscoder.readMethodBitmap(inputStream, (DexProfileData)object);
        }
        return dexProfileDataArray;
    }

    private static int roundUpToByte(int n) {
        return n + 8 - 1 & 0xFFFFFFF8;
    }

    private static void setMethodBitmapBit(byte[] byArray, int n, int n2, DexProfileData dexProfileData) {
        n2 = ProfileTranscoder.methodFlagBitmapIndex(n, n2, dexProfileData.numMethodIds);
        n = n2 / 8;
        byArray[n] = (byte)(byArray[n] | 1 << n2 % 8);
    }

    private static void skipInlineCache(InputStream inputStream) throws IOException {
        Encoding.readUInt16(inputStream);
        int n = Encoding.readUInt8(inputStream);
        if (n == 6) {
            return;
        }
        if (n == 7) {
            return;
        }
        for (int i = n; i > 0; --i) {
            Encoding.readUInt8(inputStream);
            for (n = Encoding.readUInt8(inputStream); n > 0; --n) {
                Encoding.readUInt16(inputStream);
            }
        }
    }

    static boolean transcodeAndWriteBody(OutputStream outputStream, byte[] byArray, DexProfileData[] dexProfileDataArray) throws IOException {
        if (Arrays.equals(byArray, ProfileVersion.V015_S)) {
            ProfileTranscoder.writeProfileForS(outputStream, dexProfileDataArray);
            return true;
        }
        if (Arrays.equals(byArray, ProfileVersion.V010_P)) {
            ProfileTranscoder.writeProfileForP(outputStream, dexProfileDataArray);
            return true;
        }
        if (Arrays.equals(byArray, ProfileVersion.V005_O)) {
            ProfileTranscoder.writeProfileForO(outputStream, dexProfileDataArray);
            return true;
        }
        if (Arrays.equals(byArray, ProfileVersion.V009_O_MR1)) {
            ProfileTranscoder.writeProfileForO_MR1(outputStream, dexProfileDataArray);
            return true;
        }
        if (Arrays.equals(byArray, ProfileVersion.V001_N)) {
            ProfileTranscoder.writeProfileForN(outputStream, dexProfileDataArray);
            return true;
        }
        return false;
    }

    private static void writeClasses(OutputStream outputStream, DexProfileData object) throws IOException {
        int n = 0;
        object = ((DexProfileData)object).classes;
        int n2 = ((Object)object).length;
        for (int i = 0; i < n2; ++i) {
            Integer n3 = (int)object[i];
            Encoding.writeUInt16(outputStream, n3 - n);
            n = n3;
        }
    }

    private static WritableFileSection writeDexFileSection(DexProfileData[] object) throws IOException {
        Object object2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n = 0 + 2;
        Encoding.writeUInt16(byteArrayOutputStream, ((DexProfileData[])object).length);
        int n2 = 0;
        while (true) {
            if (n2 >= ((DexProfileData[])object).length) break;
            object2 = object[n2];
            Encoding.writeUInt32(byteArrayOutputStream, ((DexProfileData)object2).dexChecksum);
            Encoding.writeUInt32(byteArrayOutputStream, ((DexProfileData)object2).mTypeIdCount);
            Encoding.writeUInt32(byteArrayOutputStream, ((DexProfileData)object2).numMethodIds);
            object2 = ProfileTranscoder.generateDexKey(((DexProfileData)object2).apkName, ((DexProfileData)object2).dexName, ProfileVersion.V015_S);
            int n3 = Encoding.utf8Length((String)object2);
            Encoding.writeUInt16(byteArrayOutputStream, n3);
            n = n + 4 + 4 + 4 + 2 + n3 * 1;
            Encoding.writeString(byteArrayOutputStream, (String)object2);
            ++n2;
            continue;
            break;
        }
        try {
            object2 = byteArrayOutputStream.toByteArray();
            if (n == ((Object)object2).length) {
                object = new WritableFileSection(FileSectionType.DEX_FILES, n, (byte[])object2, false);
                return object;
            }
            object = new StringBuilder();
            throw Encoding.error(object.append("Expected size ").append(n).append(", does not match actual size ").append(((Object)object2).length).toString());
        }
        catch (Throwable throwable) {
            throw throwable;
        }
        finally {
            byteArrayOutputStream.close();
        }
    }

    static void writeHeader(OutputStream outputStream, byte[] byArray) throws IOException {
        outputStream.write(MAGIC_PROF);
        outputStream.write(byArray);
    }

    private static void writeLineData(OutputStream outputStream, DexProfileData dexProfileData) throws IOException {
        ProfileTranscoder.writeMethodsWithInlineCaches(outputStream, dexProfileData);
        ProfileTranscoder.writeClasses(outputStream, dexProfileData);
        ProfileTranscoder.writeMethodBitmap(outputStream, dexProfileData);
    }

    private static void writeLineHeader(OutputStream outputStream, DexProfileData dexProfileData, String string2) throws IOException {
        Encoding.writeUInt16(outputStream, Encoding.utf8Length(string2));
        Encoding.writeUInt16(outputStream, dexProfileData.classSetSize);
        Encoding.writeUInt32(outputStream, dexProfileData.hotMethodRegionSize);
        Encoding.writeUInt32(outputStream, dexProfileData.dexChecksum);
        Encoding.writeUInt32(outputStream, dexProfileData.numMethodIds);
        Encoding.writeString(outputStream, string2);
    }

    private static void writeMethodBitmap(OutputStream outputStream, DexProfileData dexProfileData) throws IOException {
        byte[] byArray = new byte[ProfileTranscoder.getMethodBitmapStorageSize(dexProfileData.numMethodIds)];
        for (Map.Entry<Integer, Integer> entry : dexProfileData.methods.entrySet()) {
            int n = entry.getKey();
            int n2 = entry.getValue();
            if ((n2 & 2) != 0) {
                ProfileTranscoder.setMethodBitmapBit(byArray, 2, n, dexProfileData);
            }
            if ((n2 & 4) == 0) continue;
            ProfileTranscoder.setMethodBitmapBit(byArray, 4, n, dexProfileData);
        }
        outputStream.write(byArray);
    }

    private static void writeMethodsWithInlineCaches(OutputStream outputStream, DexProfileData object2) throws IOException {
        int n = 0;
        for (Map.Entry<Integer, Integer> entry : ((DexProfileData)object2).methods.entrySet()) {
            int n2 = entry.getKey();
            if ((entry.getValue() & 1) == 0) continue;
            Encoding.writeUInt16(outputStream, n2 - n);
            Encoding.writeUInt16(outputStream, 0);
            n = n2;
        }
    }

    private static void writeProfileForN(OutputStream outputStream, DexProfileData[] dexProfileDataArray) throws IOException {
        Encoding.writeUInt16(outputStream, dexProfileDataArray.length);
        for (DexProfileData dexProfileData : dexProfileDataArray) {
            Object object = ProfileTranscoder.generateDexKey(dexProfileData.apkName, dexProfileData.dexName, ProfileVersion.V001_N);
            Encoding.writeUInt16(outputStream, Encoding.utf8Length((String)object));
            Encoding.writeUInt16(outputStream, dexProfileData.methods.size());
            Encoding.writeUInt16(outputStream, dexProfileData.classes.length);
            Encoding.writeUInt32(outputStream, dexProfileData.dexChecksum);
            Encoding.writeString(outputStream, (String)object);
            object = dexProfileData.methods.keySet().iterator();
            while (object.hasNext()) {
                Encoding.writeUInt16(outputStream, (Integer)object.next());
            }
            int[] object2 = dexProfileData.classes;
            int n = object2.length;
            for (int i = 0; i < n; ++i) {
                Encoding.writeUInt16(outputStream, object2[i]);
            }
        }
    }

    private static void writeProfileForO(OutputStream outputStream, DexProfileData[] dexProfileDataArray) throws IOException {
        Encoding.writeUInt8(outputStream, dexProfileDataArray.length);
        for (DexProfileData dexProfileData : dexProfileDataArray) {
            int n = dexProfileData.methods.size();
            Object object = ProfileTranscoder.generateDexKey(dexProfileData.apkName, dexProfileData.dexName, ProfileVersion.V005_O);
            Encoding.writeUInt16(outputStream, Encoding.utf8Length((String)object));
            Encoding.writeUInt16(outputStream, dexProfileData.classes.length);
            Encoding.writeUInt32(outputStream, n * 4);
            Encoding.writeUInt32(outputStream, dexProfileData.dexChecksum);
            Encoding.writeString(outputStream, (String)object);
            object = dexProfileData.methods.keySet().iterator();
            while (object.hasNext()) {
                Encoding.writeUInt16(outputStream, (Integer)object.next());
                Encoding.writeUInt16(outputStream, 0);
            }
            int[] object2 = dexProfileData.classes;
            int n2 = object2.length;
            for (n = 0; n < n2; ++n) {
                Encoding.writeUInt16(outputStream, object2[n]);
            }
        }
    }

    private static void writeProfileForO_MR1(OutputStream outputStream, DexProfileData[] dexProfileDataArray) throws IOException {
        byte[] byArray = ProfileTranscoder.createCompressibleBody(dexProfileDataArray, ProfileVersion.V009_O_MR1);
        Encoding.writeUInt8(outputStream, dexProfileDataArray.length);
        Encoding.writeCompressed(outputStream, byArray);
    }

    private static void writeProfileForP(OutputStream outputStream, DexProfileData[] dexProfileDataArray) throws IOException {
        byte[] byArray = ProfileTranscoder.createCompressibleBody(dexProfileDataArray, ProfileVersion.V010_P);
        Encoding.writeUInt8(outputStream, dexProfileDataArray.length);
        Encoding.writeCompressed(outputStream, byArray);
    }

    private static void writeProfileForS(OutputStream outputStream, DexProfileData[] dexProfileDataArray) throws IOException {
        ProfileTranscoder.writeProfileSections(outputStream, dexProfileDataArray);
    }

    private static void writeProfileSections(OutputStream outputStream, DexProfileData[] object) throws IOException {
        int n;
        ArrayList<WritableFileSection> arrayList = new ArrayList<WritableFileSection>(3);
        ArrayList<Object[]> arrayList2 = new ArrayList<Object[]>(3);
        arrayList.add(ProfileTranscoder.writeDexFileSection(object));
        arrayList.add(ProfileTranscoder.createCompressibleClassSection(object));
        arrayList.add(ProfileTranscoder.createCompressibleMethodsSection(object));
        long l = (long)ProfileVersion.V015_S.length + (long)MAGIC_PROF.length + 4L + (long)(arrayList.size() * 16);
        Encoding.writeUInt32(outputStream, arrayList.size());
        for (n = 0; n < arrayList.size(); ++n) {
            object = (WritableFileSection)arrayList.get(n);
            Encoding.writeUInt32(outputStream, object.mType.getValue());
            Encoding.writeUInt32(outputStream, l);
            if (object.mNeedsCompression) {
                long l2 = object.mContents.length;
                object = Encoding.compress(object.mContents);
                arrayList2.add((Object[])object);
                Encoding.writeUInt32(outputStream, ((DexProfileData[])object).length);
                Encoding.writeUInt32(outputStream, l2);
                l += (long)((DexProfileData[])object).length;
                continue;
            }
            arrayList2.add(object.mContents);
            Encoding.writeUInt32(outputStream, object.mContents.length);
            Encoding.writeUInt32(outputStream, 0L);
            l += (long)object.mContents.length;
        }
        for (n = 0; n < arrayList2.size(); ++n) {
            outputStream.write((byte[])arrayList2.get(n));
        }
    }
}

