/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package androidx.work.impl.constraints;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J1\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\b\u00a8\u0006\u0014"}, d2={"Landroidx/work/impl/constraints/NetworkState;", "", "isConnected", "", "isValidated", "isMetered", "isNotRoaming", "(ZZZZ)V", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public final class NetworkState {
    private final boolean isConnected;
    private final boolean isMetered;
    private final boolean isNotRoaming;
    private final boolean isValidated;

    public NetworkState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.isConnected = bl;
        this.isValidated = bl2;
        this.isMetered = bl3;
        this.isNotRoaming = bl4;
    }

    public static /* synthetic */ NetworkState copy$default(NetworkState networkState, boolean bl, boolean bl2, boolean bl3, boolean bl4, int n, Object object) {
        if ((n & 1) != 0) {
            bl = networkState.isConnected;
        }
        if ((n & 2) != 0) {
            bl2 = networkState.isValidated;
        }
        if ((n & 4) != 0) {
            bl3 = networkState.isMetered;
        }
        if ((n & 8) != 0) {
            bl4 = networkState.isNotRoaming;
        }
        return networkState.copy(bl, bl2, bl3, bl4);
    }

    public final boolean component1() {
        return this.isConnected;
    }

    public final boolean component2() {
        return this.isValidated;
    }

    public final boolean component3() {
        return this.isMetered;
    }

    public final boolean component4() {
        return this.isNotRoaming;
    }

    public final NetworkState copy(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        return new NetworkState(bl, bl2, bl3, bl4);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof NetworkState)) {
            return false;
        }
        object = (NetworkState)object;
        if (this.isConnected != ((NetworkState)object).isConnected) {
            return false;
        }
        if (this.isValidated != ((NetworkState)object).isValidated) {
            return false;
        }
        if (this.isMetered != ((NetworkState)object).isMetered) {
            return false;
        }
        return this.isNotRoaming == ((NetworkState)object).isNotRoaming;
    }

    public int hashCode() {
        int n;
        int n2;
        int n3 = this.isConnected;
        int n4 = 1;
        int n5 = n3;
        if (n3 != 0) {
            n5 = 1;
        }
        n3 = n2 = this.isValidated;
        if (n2 != 0) {
            n3 = 1;
        }
        n2 = n = this.isMetered;
        if (n != 0) {
            n2 = 1;
        }
        if ((n = this.isNotRoaming) == 0) {
            n4 = n;
        }
        return ((n5 * 31 + n3) * 31 + n2) * 31 + n4;
    }

    public final boolean isConnected() {
        return this.isConnected;
    }

    public final boolean isMetered() {
        return this.isMetered;
    }

    public final boolean isNotRoaming() {
        return this.isNotRoaming;
    }

    public final boolean isValidated() {
        return this.isValidated;
    }

    public String toString() {
        return "NetworkState(isConnected=" + this.isConnected + ", isValidated=" + this.isValidated + ", isMetered=" + this.isMetered + ", isNotRoaming=" + this.isNotRoaming + ')';
    }
}

