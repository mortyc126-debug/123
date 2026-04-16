/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package linker.resourcer.encoder;

import android.content.Context;
import java.io.File;
import java.util.HashSet;
import linker.resourcer.encoder.CustomFilesFilter;

public class FilesFinder {
    private static void collectFolders(File fileArray, HashSet<String> hashSet, CustomFilesFilter.FileType fileType) {
        if ((fileArray = fileArray.listFiles(new CustomFilesFilter(fileType, true))) != null) {
            for (File file : fileArray) {
                if (file.isFile()) {
                    hashSet.add(file.getParentFile().getAbsolutePath());
                    continue;
                }
                if (!file.isDirectory()) continue;
                FilesFinder.collectFolders(file, hashSet, fileType);
            }
        }
    }

    public static String[] searchFilesInDirectory(Context object, CustomFilesFilter.FileType object2, File object3) {
        block5: {
            try {
                if (!((File)object3).exists() || !((File)object3).isDirectory()) break block5;
                object = new HashSet();
                FilesFinder.collectFolders((File)object3, (HashSet<String>)object, (CustomFilesFilter.FileType)((Object)object2));
                if (!((HashSet)object).isEmpty()) {
                    object2 = new StringBuilder();
                    object = ((HashSet)object).iterator();
                    while (object.hasNext()) {
                        object3 = (String)object.next();
                        if (((StringBuilder)object2).length() > 0) {
                            ((StringBuilder)object2).append("<*P*>");
                        }
                        ((StringBuilder)object2).append((String)object3);
                    }
                    return new String[]{"1", ((StringBuilder)object2).toString()};
                }
                object = new StringBuilder();
                return new String[]{"-1", ((StringBuilder)object).append("No ").append(((Enum)object2).name()).append(" found.").toString()};
            }
            catch (Exception exception) {
                return new String[]{"-1", "Error: " + exception.getMessage()};
            }
        }
        return new String[]{"-1", "directory does not exist or is not a directory."};
    }
}

