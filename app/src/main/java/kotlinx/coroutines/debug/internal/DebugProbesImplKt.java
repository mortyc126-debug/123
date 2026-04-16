/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0002\u00a8\u0006\u0002"}, d2={"repr", "", "kotlinx-coroutines-core"}, k=2, mv={1, 8, 0}, xi=48)
public final class DebugProbesImplKt {
    public static final /* synthetic */ String access$repr(String string2) {
        return DebugProbesImplKt.repr(string2);
    }

    private static final String repr(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('\"');
        int n = string2.length();
        for (int i = 0; i < n; ++i) {
            char c = string2.charAt(i);
            if (c == '\"') {
                stringBuilder.append("\\\"");
                continue;
            }
            if (c == '\\') {
                stringBuilder.append("\\\\");
                continue;
            }
            if (c == '\b') {
                stringBuilder.append("\\b");
                continue;
            }
            if (c == '\n') {
                stringBuilder.append("\\n");
                continue;
            }
            if (c == '\r') {
                stringBuilder.append("\\r");
                continue;
            }
            if (c == '\t') {
                stringBuilder.append("\\t");
                continue;
            }
            stringBuilder.append(c);
        }
        stringBuilder.append('\"');
        string2 = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"StringBuilder().apply(builderAction).toString()");
        return string2;
    }
}

