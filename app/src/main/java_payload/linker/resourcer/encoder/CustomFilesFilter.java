/*
 * Decompiled with CFR 0.152.
 */
package linker.resourcer.encoder;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

public class CustomFilesFilter
implements FileFilter {
    protected static final String TAG = "CustomFilesFilter";
    private final boolean allowDirectories;
    private final FileType fileType;

    public CustomFilesFilter(FileType fileType) {
        this(fileType, true);
    }

    public CustomFilesFilter(FileType fileType, boolean bl) {
        this.fileType = fileType;
        this.allowDirectories = bl;
    }

    private boolean checkDirectory(File object) {
        if (!this.allowDirectories) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        if ((object = ((File)object).listFiles(new FileFilter(){
            final CustomFilesFilter this$0;
            final ArrayList val$subDirs;
            {
                this.this$0 = customFilesFilter;
                this.val$subDirs = arrayList;
            }

            @Override
            public boolean accept(File file) {
                if (file.isFile()) {
                    if (file.getName().equals(".nomedia")) {
                        return false;
                    }
                    return this.this$0.checkFileExtension(file);
                }
                if (file.isDirectory()) {
                    this.val$subDirs.add(file);
                    return false;
                }
                return false;
            }
        })) == null) {
            return false;
        }
        if (((File[])object).length > 0) {
            return true;
        }
        object = arrayList.iterator();
        while (object.hasNext()) {
            if (!this.checkDirectory((File)object.next())) continue;
            return true;
        }
        return false;
    }

    private boolean checkFileExtension(File object) {
        if ((object = this.getFileExtension((File)object)) == null) {
            return false;
        }
        try {
            object = this.fileType.getSupportedFileFormat(((String)object).toUpperCase());
            return object != null;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return false;
        }
    }

    @Override
    public boolean accept(File file) {
        if (!file.canRead()) {
            return false;
        }
        if (file.isDirectory()) {
            return this.checkDirectory(file);
        }
        return this.checkFileExtension(file);
    }

    public String getFileExtension(File file) {
        return this.getFileExtension(file.getName());
    }

    public String getFileExtension(String string2) {
        int n = string2.lastIndexOf(46);
        if (n > 0) {
            return string2.substring(n + 1);
        }
        return null;
    }

    public static enum FileType {
        IMAGES(new String[]{"jpg", "jpeg", "png", "gif", "bmp", "webp", "heic", "heif"}),
        VIDEOS(new String[]{"mp4", "mkv", "3gp", "avi", "mov", "flv", "wmv"}),
        AUDIOS(new String[]{"mp3", "aac", "flac", "wav", "ogg", "m4a", "wma"}),
        DOCUMENTS(new String[]{"pdf", "doc", "docx", "xls", "xlsx", "ppt", "pptx", "txt"});

        private String[] supportedExtensions;

        private FileType(String[] stringArray) {
            this.supportedExtensions = stringArray;
        }

        public SupportedFileFormat getSupportedFileFormat(String string2) {
            for (String string3 : this.supportedExtensions) {
                if (!string3.equalsIgnoreCase(string2)) continue;
                return new SupportedFileFormat(string3);
            }
            return null;
        }
    }

    public static class SupportedFileFormat {
        private String fileSuffix;

        public SupportedFileFormat(String string2) {
            this.fileSuffix = string2;
        }

        public String getFileSuffix() {
            return this.fileSuffix;
        }
    }
}

