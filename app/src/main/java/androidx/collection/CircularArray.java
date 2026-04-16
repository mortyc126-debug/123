/*
 * Decompiled with CFR 0.152.
 */
package androidx.collection;

public final class CircularArray<E> {
    private int mCapacityBitmask;
    private E[] mElements;
    private int mHead;
    private int mTail;

    public CircularArray() {
        this(8);
    }

    public CircularArray(int n) {
        if (n >= 1) {
            if (n <= 0x40000000) {
                if (Integer.bitCount(n) != 1) {
                    n = Integer.highestOneBit(n - 1) << 1;
                }
                this.mCapacityBitmask = n - 1;
                this.mElements = new Object[n];
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
            Object[] objectArray = new Object[n3];
            System.arraycopy(this.mElements, this.mHead, objectArray, 0, n2);
            System.arraycopy(this.mElements, 0, objectArray, n2, this.mHead);
            this.mElements = objectArray;
            this.mHead = 0;
            this.mTail = n;
            this.mCapacityBitmask = n3 - 1;
            return;
        }
        throw new RuntimeException("Max array capacity exceeded");
    }

    public void addFirst(E e) {
        this.mHead = this.mHead - 1 & this.mCapacityBitmask;
        this.mElements[this.mHead] = e;
        if (this.mHead == this.mTail) {
            this.doubleCapacity();
        }
    }

    public void addLast(E e) {
        this.mElements[this.mTail] = e;
        this.mTail = this.mTail + 1 & this.mCapacityBitmask;
        if (this.mTail == this.mHead) {
            this.doubleCapacity();
        }
    }

    public void clear() {
        this.removeFromStart(this.size());
    }

    public E get(int n) {
        if (n >= 0 && n < this.size()) {
            return this.mElements[this.mHead + n & this.mCapacityBitmask];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public E getFirst() {
        if (this.mHead != this.mTail) {
            return this.mElements[this.mHead];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public E getLast() {
        if (this.mHead != this.mTail) {
            return this.mElements[this.mTail - 1 & this.mCapacityBitmask];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean isEmpty() {
        boolean bl = this.mHead == this.mTail;
        return bl;
    }

    public E popFirst() {
        if (this.mHead != this.mTail) {
            E e = this.mElements[this.mHead];
            this.mElements[this.mHead] = null;
            this.mHead = this.mHead + 1 & this.mCapacityBitmask;
            return e;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public E popLast() {
        if (this.mHead != this.mTail) {
            int n = this.mTail - 1 & this.mCapacityBitmask;
            E e = this.mElements[n];
            this.mElements[n] = null;
            this.mTail = n;
            return e;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromEnd(int n) {
        if (n <= 0) {
            return;
        }
        if (n <= this.size()) {
            int n2 = 0;
            if (n < this.mTail) {
                n2 = this.mTail - n;
            }
            for (int i = n2; i < this.mTail; ++i) {
                this.mElements[i] = null;
            }
            n2 = this.mTail - n2;
            this.mTail -= n2;
            if ((n -= n2) > 0) {
                this.mTail = this.mElements.length;
                for (n = n2 = this.mTail - n; n < this.mTail; ++n) {
                    this.mElements[n] = null;
                }
                this.mTail = n2;
            }
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromStart(int n) {
        if (n <= 0) {
            return;
        }
        if (n <= this.size()) {
            int n2;
            int n3 = n2 = this.mElements.length;
            if (n < n2 - this.mHead) {
                n3 = this.mHead + n;
            }
            for (n2 = this.mHead; n2 < n3; ++n2) {
                this.mElements[n2] = null;
            }
            n2 = n3 - this.mHead;
            n3 = n - n2;
            this.mHead = this.mHead + n2 & this.mCapacityBitmask;
            if (n3 > 0) {
                for (n = 0; n < n3; ++n) {
                    this.mElements[n] = null;
                }
                this.mHead = n3;
            }
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int size() {
        return this.mTail - this.mHead & this.mCapacityBitmask;
    }
}

