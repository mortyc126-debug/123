package kotlin.collections;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import tlydtdl.compose.foundation.layout.m;

/* JADX INFO: compiled from: UArraySorting.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0014\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0016\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010\u0018\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"partition", HttpUrl.FRAGMENT_ENCODE_SET, "array", "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort", HttpUrl.FRAGMENT_ENCODE_SET, "quickSort-4UcCI2c", "([BII)V", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-oBK06Vg", "sortArray--nroSd4", "sortArray-Aa5vz7o", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = m.g)
public final class UArraySortingKt {
    /* JADX INFO: renamed from: partition-4UcCI2c, reason: not valid java name */
    private static final int m594partition4UcCI2c(byte[] array, int left, int right) {
        int i = left;
        int j2 = right;
        byte pivot = UByteArray.m214getw2LRezQ(array, (left + right) / 2);
        while (i <= j2) {
            while (Intrinsics.compare(UByteArray.m214getw2LRezQ(array, i) & UByte.MAX_VALUE, pivot & UByte.MAX_VALUE) < 0) {
                i++;
            }
            while (Intrinsics.compare(UByteArray.m214getw2LRezQ(array, j2) & UByte.MAX_VALUE, pivot & UByte.MAX_VALUE) > 0) {
                j2--;
            }
            if (i <= j2) {
                byte tmp = UByteArray.m214getw2LRezQ(array, i);
                UByteArray.m219setVurrAj0(array, i, UByteArray.m214getw2LRezQ(array, j2));
                UByteArray.m219setVurrAj0(array, j2, tmp);
                i++;
                j2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort-4UcCI2c, reason: not valid java name */
    private static final void m598quickSort4UcCI2c(byte[] array, int left, int right) {
        int index = m594partition4UcCI2c(array, left, right);
        if (left < index - 1) {
            m598quickSort4UcCI2c(array, left, index - 1);
        }
        if (index < right) {
            m598quickSort4UcCI2c(array, index, right);
        }
    }

    /* JADX INFO: renamed from: partition-Aa5vz7o, reason: not valid java name */
    private static final int m595partitionAa5vz7o(short[] array, int left, int right) {
        int i = left;
        int j2 = right;
        short pivot = UShortArray.m477getMh2AYeg(array, (left + right) / 2);
        while (i <= j2) {
            while (Intrinsics.compare(UShortArray.m477getMh2AYeg(array, i) & UShort.MAX_VALUE, pivot & UShort.MAX_VALUE) < 0) {
                i++;
            }
            while (Intrinsics.compare(UShortArray.m477getMh2AYeg(array, j2) & UShort.MAX_VALUE, pivot & UShort.MAX_VALUE) > 0) {
                j2--;
            }
            if (i <= j2) {
                short tmp = UShortArray.m477getMh2AYeg(array, i);
                UShortArray.m482set01HTLdE(array, i, UShortArray.m477getMh2AYeg(array, j2));
                UShortArray.m482set01HTLdE(array, j2, tmp);
                i++;
                j2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort-Aa5vz7o, reason: not valid java name */
    private static final void m599quickSortAa5vz7o(short[] array, int left, int right) {
        int index = m595partitionAa5vz7o(array, left, right);
        if (left < index - 1) {
            m599quickSortAa5vz7o(array, left, index - 1);
        }
        if (index < right) {
            m599quickSortAa5vz7o(array, index, right);
        }
    }

    /* JADX INFO: renamed from: partition-oBK06Vg, reason: not valid java name */
    private static final int m596partitionoBK06Vg(int[] array, int left, int right) {
        int i = left;
        int j2 = right;
        int pivot = UIntArray.m293getpVg5ArA(array, (left + right) / 2);
        while (i <= j2) {
            while (Integer.compare(UIntArray.m293getpVg5ArA(array, i) ^ IntCompanionObject.MIN_VALUE, pivot ^ IntCompanionObject.MIN_VALUE) < 0) {
                i++;
            }
            while (Integer.compare(UIntArray.m293getpVg5ArA(array, j2) ^ IntCompanionObject.MIN_VALUE, pivot ^ IntCompanionObject.MIN_VALUE) > 0) {
                j2--;
            }
            if (i <= j2) {
                int tmp = UIntArray.m293getpVg5ArA(array, i);
                UIntArray.m298setVXSXFK8(array, i, UIntArray.m293getpVg5ArA(array, j2));
                UIntArray.m298setVXSXFK8(array, j2, tmp);
                i++;
                j2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort-oBK06Vg, reason: not valid java name */
    private static final void m600quickSortoBK06Vg(int[] array, int left, int right) {
        int index = m596partitionoBK06Vg(array, left, right);
        if (left < index - 1) {
            m600quickSortoBK06Vg(array, left, index - 1);
        }
        if (index < right) {
            m600quickSortoBK06Vg(array, index, right);
        }
    }

    /* JADX INFO: renamed from: partition--nroSd4, reason: not valid java name */
    private static final int m593partitionnroSd4(long[] array, int left, int right) {
        int i = left;
        int j2 = right;
        long pivot = ULongArray.m372getsVKNKU(array, (left + right) / 2);
        while (i <= j2) {
            while (Long.compare(ULongArray.m372getsVKNKU(array, i) ^ Long.MIN_VALUE, pivot ^ Long.MIN_VALUE) < 0) {
                i++;
            }
            while (Long.compare(ULongArray.m372getsVKNKU(array, j2) ^ Long.MIN_VALUE, pivot ^ Long.MIN_VALUE) > 0) {
                j2--;
            }
            if (i <= j2) {
                long tmp = ULongArray.m372getsVKNKU(array, i);
                ULongArray.m377setk8EXiF4(array, i, ULongArray.m372getsVKNKU(array, j2));
                ULongArray.m377setk8EXiF4(array, j2, tmp);
                i++;
                j2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort--nroSd4, reason: not valid java name */
    private static final void m597quickSortnroSd4(long[] array, int left, int right) {
        int index = m593partitionnroSd4(array, left, right);
        if (left < index - 1) {
            m597quickSortnroSd4(array, left, index - 1);
        }
        if (index < right) {
            m597quickSortnroSd4(array, index, right);
        }
    }

    /* JADX INFO: renamed from: sortArray-4UcCI2c, reason: not valid java name */
    public static final void m602sortArray4UcCI2c(byte[] array, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter(array, "array");
        m598quickSort4UcCI2c(array, fromIndex, toIndex - 1);
    }

    /* JADX INFO: renamed from: sortArray-Aa5vz7o, reason: not valid java name */
    public static final void m603sortArrayAa5vz7o(short[] array, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter(array, "array");
        m599quickSortAa5vz7o(array, fromIndex, toIndex - 1);
    }

    /* JADX INFO: renamed from: sortArray-oBK06Vg, reason: not valid java name */
    public static final void m604sortArrayoBK06Vg(int[] array, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter(array, "array");
        m600quickSortoBK06Vg(array, fromIndex, toIndex - 1);
    }

    /* JADX INFO: renamed from: sortArray--nroSd4, reason: not valid java name */
    public static final void m601sortArraynroSd4(long[] array, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter(array, "array");
        m597quickSortnroSd4(array, fromIndex, toIndex - 1);
    }
}
