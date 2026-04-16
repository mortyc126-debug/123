/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work;

import androidx.work.InputMerger;
import androidx.work.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2={"TAG", "", "fromClassName", "Landroidx/work/InputMerger;", "className", "work-runtime_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class InputMergerKt {
    private static final String TAG;

    static {
        String string2 = Logger.tagWithPrefix("InputMerger");
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"tagWithPrefix(\"InputMerger\")");
        TAG = string2;
    }

    public static final InputMerger fromClassName(String string2) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"className");
        try {
            Object object = Class.forName(string2).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            Intrinsics.checkNotNull(object, (String)"null cannot be cast to non-null type androidx.work.InputMerger");
            object = (InputMerger)object;
            return object;
        }
        catch (Exception exception) {
            Logger.get().error(TAG, "Trouble instantiating " + string2, exception);
            return null;
        }
    }
}

