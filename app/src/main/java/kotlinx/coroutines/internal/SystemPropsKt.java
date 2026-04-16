/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlinx.coroutines.internal.SystemPropsKt__SystemPropsKt;
import kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt;

@Metadata(d1={"kotlinx/coroutines/internal/SystemPropsKt__SystemPropsKt", "kotlinx/coroutines/internal/SystemPropsKt__SystemProps_commonKt"}, k=4, mv={1, 8, 0}, xi=48)
public final class SystemPropsKt {
    public static final int getAVAILABLE_PROCESSORS() {
        return SystemPropsKt__SystemPropsKt.getAVAILABLE_PROCESSORS();
    }

    public static final int systemProp(String string2, int n, int n2, int n3) {
        return SystemPropsKt__SystemProps_commonKt.systemProp(string2, n, n2, n3);
    }

    public static final long systemProp(String string2, long l, long l2, long l3) {
        return SystemPropsKt__SystemProps_commonKt.systemProp(string2, l, l2, l3);
    }

    public static final String systemProp(String string2) {
        return SystemPropsKt__SystemPropsKt.systemProp(string2);
    }

    public static final String systemProp(String string2, String string3) {
        return SystemPropsKt__SystemProps_commonKt.systemProp(string2, string3);
    }

    public static final boolean systemProp(String string2, boolean bl) {
        return SystemPropsKt__SystemProps_commonKt.systemProp(string2, bl);
    }

    public static /* synthetic */ int systemProp$default(String string2, int n, int n2, int n3, int n4, Object object) {
        return SystemPropsKt__SystemProps_commonKt.systemProp$default(string2, n, n2, n3, n4, object);
    }

    public static /* synthetic */ long systemProp$default(String string2, long l, long l2, long l3, int n, Object object) {
        return SystemPropsKt__SystemProps_commonKt.systemProp$default(string2, l, l2, l3, n, object);
    }
}

