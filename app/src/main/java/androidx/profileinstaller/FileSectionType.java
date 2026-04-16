/*
 * Decompiled with CFR 0.152.
 */
package androidx.profileinstaller;

enum FileSectionType {
    DEX_FILES(0L),
    EXTRA_DESCRIPTORS(1L),
    CLASSES(2L),
    METHODS(3L),
    AGGREGATION_COUNT(4L);

    private final long mValue;

    private FileSectionType(long l) {
        this.mValue = l;
    }

    static FileSectionType fromValue(long l) {
        FileSectionType[] fileSectionTypeArray = FileSectionType.values();
        for (int i = 0; i < fileSectionTypeArray.length; ++i) {
            if (fileSectionTypeArray[i].getValue() != l) continue;
            return fileSectionTypeArray[i];
        }
        throw new IllegalArgumentException("Unsupported FileSection Type " + l);
    }

    public long getValue() {
        return this.mValue;
    }
}

