/*
 * Decompiled with CFR 0.152.
 */
package androidx.collection;

public final class CircularIntArray {
    private int mCapacityBitmask;
    private int[] mElements;
    private int mHead;
    private int mTail;

    public CircularIntArray() {
        this(8);
    }

    public CircularIntArray(int n) {
        if (n >= 1) {
            if (n <= 0x40000000) {
                if (Integer.bitCount(n) != 1) {
                    n = Integer.highestOneBit(n - 1) << 1;
                }
                this.mCapacityBitmask = n - 1;
                this.mElements = new int[n];
                return;
            }
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
        throw new IllegalArgumentException("capacity must be >= 1");
    }

    private void doubleCapacity() {
        int n = this.mElements.length;
        int n2 = n - this.mHead;
        int n3 = n << 1;
        if (n3 >= 0) {
            int[] nArray = new int[n3];
            System.arraycopy(this.mElements, this.mHead, nArray, 0, n2);
            System.arraycopy(this.mElements, 0, nArray, n2, this.mHead);
            this.mElements = nArray;
            this.mHead = 0;
            this.mTail = n;
            this.mCapacityBitmask = n3 - 1;
            return;
        }
        throw new RuntimeException("Max array capacity exceeded");
    }

    public void addFirst(int n) {
        this.mHead = this.mHead - 1 & this.mCapacityBitmask;
        this.mElements[this.mHead] = n;
        if (this.mHead == this.mTail) {
            this.doubleCapacity();
        }
    }

    public void addLast(int n) {
        this.mElements[this.mTail] = n;
        this.mTail = this.mTail + 1 & this.mCapacityBitmask;
        if (this.mTail == this.mHead) {
            this.doubleCapacity();
        }
    }

    public void clear() {
        this.mTail = this.mHead;
    }

    public int get(int n) {
        if (n >= 0 && n < this.size()) {
            return this.mElements[this.mHead + n & this.mCapacityBitmask];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int getFirst() {
        if (this.mHead != this.mTail) {
            return this.mElements[this.mHead];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int getLast() {
        if (this.mHead != this.mTail) {
            return this.mElements[this.mTail - 1 & this.mCapacityBitmask];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean isEmpty() {
        boolean bl = this.mHead == this.mTail;
        return bl;
    }

    public int popFirst() {
        if (this.mHead != this.mTail) {
            int n = this.mElements[this.mHead];
            this.mHead = this.mHead + 1 & this.mCapacityBitmask;
            return n;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int popLast() {
        if (this.mHead != this.mTail) {
            int n = this.mTail - 1 & this.mCapacityBitmask;
            int n2 = this.mElements[n];
            this.mTail = n;
            return n2;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromEnd(int n) {
        if (n <= 0) {
            return;
        }
        if (n <= this.size()) {
            this.mTail = this.mTail - n & this.mCapacityBitmask;
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromStart(int n) {
        if (n <= 0) {
            return;
        }
        if (n <= this.size()) {
            this.mHead = this.mHead + n & this.mCapacityBitmask;
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int size() {
        return this.mTail - this.mHead & this.mCapacityBitmask;
    }
}

