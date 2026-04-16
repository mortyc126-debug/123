package org.apache.commons.net.ftp;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class FTPFileFilters {
    public static final FTPFileFilter ALL = new FTPFileFilter() { // from class: org.apache.commons.net.ftp.FTPFileFilters$$ExternalSyntheticLambda0
        @Override // org.apache.commons.net.ftp.FTPFileFilter
        public final boolean accept(FTPFile fTPFile) {
            return FTPFileFilters.lambda$static$0(fTPFile);
        }
    };
    public static final FTPFileFilter NON_NULL = new FTPFileFilter() { // from class: org.apache.commons.net.ftp.FTPFileFilters$$ExternalSyntheticLambda1
        @Override // org.apache.commons.net.ftp.FTPFileFilter
        public final boolean accept(FTPFile fTPFile) {
            return Objects.nonNull(fTPFile);
        }
    };
    public static final FTPFileFilter DIRECTORIES = new FTPFileFilter() { // from class: org.apache.commons.net.ftp.FTPFileFilters$$ExternalSyntheticLambda2
        @Override // org.apache.commons.net.ftp.FTPFileFilter
        public final boolean accept(FTPFile fTPFile) {
            return FTPFileFilters.lambda$static$1(fTPFile);
        }
    };

    static /* synthetic */ boolean lambda$static$0(FTPFile file) {
        return true;
    }

    static /* synthetic */ boolean lambda$static$1(FTPFile file) {
        return file != null && file.isDirectory();
    }
}
