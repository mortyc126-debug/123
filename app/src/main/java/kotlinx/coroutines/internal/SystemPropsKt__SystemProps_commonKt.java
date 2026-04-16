/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.text.StringsKt
 */
package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.text.StringsKt;
import kotlinx.coroutines.internal.SystemPropsKt;

@Metadata(d1={"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a,\u0010\u0000\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u0000\u001a,\u0010\u0000\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\b2\b\b\u0002\u0010\u0006\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u00a8\u0006\t"}, d2={"systemProp", "", "propertyName", "", "defaultValue", "", "minValue", "maxValue", "", "kotlinx-coroutines-core"}, k=5, mv={1, 8, 0}, xi=48, xs="kotlinx/coroutines/internal/SystemPropsKt")
final class SystemPropsKt__SystemProps_commonKt {
    public static final int systemProp(String string2, int n, int n2, int n3) {
        return (int)SystemPropsKt.systemProp(string2, (long)n, (long)n2, (long)n3);
    }

    public static final long systemProp(String string2, long l, long l2, long l3) {
        String string3 = SystemPropsKt.systemProp(string2);
        if (string3 == null) {
            return l;
        }
        Long l4 = StringsKt.toLongOrNull((String)string3);
        if (l4 != null) {
            boolean bl;
            l = l4;
            boolean bl2 = bl = false;
            if (l2 <= l) {
                bl2 = bl;
                if (l <= l3) {
                    bl2 = true;
                }
            }
            if (bl2) {
                return l;
            }
            throw new IllegalStateException(("System property '" + string2 + "' should be in range " + l2 + ".." + l3 + ", but is '" + l + '\'').toString());
        }
        throw new IllegalStateException(("System property '" + string2 + "' has unrecognized value '" + string3 + '\'').toString());
    }

    public static final String systemProp(String string2, String string3) {
        String string4;
        string2 = string4 = SystemPropsKt.systemProp(string2);
        if (string4 == null) {
            string2 = string3;
        }
        return string2;
    }

    public static final boolean systemProp(String string2, boolean bl) {
        block0: {
            if ((string2 = SystemPropsKt.systemProp(string2)) == null) break block0;
            bl = Boolean.parseBoolean(string2);
        }
        return bl;
    }

    public static /* synthetic */ int systemProp$default(String string2, int n, int n2, int n3, int n4, Object object) {
        if ((n4 & 4) != 0) {
            n2 = 1;
        }
        if ((n4 & 8) != 0) {
            n3 = Integer.MAX_VALUE;
        }
        return SystemPropsKt.systemProp(string2, n, n2, n3);
    }

    public static /* synthetic */ long systemProp$default(String string2, long l, long l2, long l3, int n, Object object) {
        block1: {
            if ((n & 4) != 0) {
                l2 = 1L;
            }
            if ((n & 8) == 0) break block1;
            l3 = Long.MAX_VALUE;
        }
        return SystemPropsKt.systemProp(string2, l, l2, l3);
    }
}

