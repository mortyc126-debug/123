/*
 * Decompiled with CFR 0.152.
 */
package androidx.profileinstaller;

import androidx.profileinstaller.FileSectionType;

class WritableFileSection {
    final byte[] mContents;
    final int mExpectedInflateSize;
    final boolean mNeedsCompression;
    final FileSectionType mType;

    WritableFileSection(FileSectionType fileSectionType, int n, byte[] byArray, boolean bl) {
        this.mType = fileSectionType;
        this.mExpectedInflateSize = n;
        this.mContents = byArray;
        this.mNeedsCompression = bl;
    }
}

