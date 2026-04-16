/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package androidx.core.util;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AtomicFile {
    private static final String LOG_TAG = "AtomicFile";
    private final File mBaseName;
    private final File mLegacyBackupName;
    private final File mNewName;

    public AtomicFile(File file) {
        this.mBaseName = file;
        this.mNewName = new File(file.getPath() + ".new");
        this.mLegacyBackupName = new File(file.getPath() + ".bak");
    }

    private static void rename(File file, File file2) {
        if (file2.isDirectory() && !file2.delete()) {
            Log.e((String)LOG_TAG, (String)("Failed to delete file which is a directory " + file2));
        }
        if (!file.renameTo(file2)) {
            Log.e((String)LOG_TAG, (String)("Failed to rename " + file + " to " + file2));
        }
    }

    private static boolean sync(FileOutputStream fileOutputStream) {
        try {
            fileOutputStream.getFD().sync();
            return true;
        }
        catch (IOException iOException) {
            return false;
        }
    }

    public void delete() {
        this.mBaseName.delete();
        this.mNewName.delete();
        this.mLegacyBackupName.delete();
    }

    public void failWrite(FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return;
        }
        if (!AtomicFile.sync(fileOutputStream)) {
            Log.e((String)LOG_TAG, (String)"Failed to sync file output stream");
        }
        try {
            fileOutputStream.close();
        }
        catch (IOException iOException) {
            Log.e((String)LOG_TAG, (String)"Failed to close file output stream", (Throwable)iOException);
        }
        if (!this.mNewName.delete()) {
            Log.e((String)LOG_TAG, (String)("Failed to delete new file " + this.mNewName));
        }
    }

    public void finishWrite(FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return;
        }
        if (!AtomicFile.sync(fileOutputStream)) {
            Log.e((String)LOG_TAG, (String)"Failed to sync file output stream");
        }
        try {
            fileOutputStream.close();
        }
        catch (IOException iOException) {
            Log.e((String)LOG_TAG, (String)"Failed to close file output stream", (Throwable)iOException);
        }
        AtomicFile.rename(this.mNewName, this.mBaseName);
    }

    public File getBaseFile() {
        return this.mBaseName;
    }

    public FileInputStream openRead() throws FileNotFoundException {
        if (this.mLegacyBackupName.exists()) {
            AtomicFile.rename(this.mLegacyBackupName, this.mBaseName);
        }
        if (this.mNewName.exists() && this.mBaseName.exists() && !this.mNewName.delete()) {
            Log.e((String)LOG_TAG, (String)("Failed to delete outdated new file " + this.mNewName));
        }
        return new FileInputStream(this.mBaseName);
    }

    public byte[] readFully() throws IOException {
        int n;
        byte[] byArray;
        FileInputStream fileInputStream = this.openRead();
        int n2 = 0;
        try {
            byArray = new byte[fileInputStream.available()];
            while (true) {
                if ((n = fileInputStream.read(byArray, n2, byArray.length - n2)) > 0) break block6;
                break;
            }
        }
        catch (Throwable throwable) {
            fileInputStream.close();
            throw throwable;
        }
        {
            block6: {
                fileInputStream.close();
                return byArray;
            }
            n2 += n;
            n = fileInputStream.available();
            byte[] byArray2 = byArray;
            if (n > byArray.length - n2) {
                byArray2 = new byte[n2 + n];
                System.arraycopy(byArray, 0, byArray2, 0, n2);
            }
            byArray = byArray2;
            continue;
        }
    }

    public FileOutputStream startWrite() throws IOException {
        if (this.mLegacyBackupName.exists()) {
            AtomicFile.rename(this.mLegacyBackupName, this.mBaseName);
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.mNewName);
            return fileOutputStream;
        }
        catch (FileNotFoundException fileNotFoundException) {
            if (this.mNewName.getParentFile().mkdirs()) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.mNewName);
                    return fileOutputStream;
                }
                catch (FileNotFoundException fileNotFoundException2) {
                    throw new IOException("Failed to create new file " + this.mNewName, fileNotFoundException2);
                }
            }
            throw new IOException("Failed to create directory for " + this.mNewName);
        }
    }
}

