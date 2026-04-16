/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work;

import androidx.work.InputMerger;
import androidx.work.InputMergerKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\b"}, d2={"Landroidx/work/InputMergerFactory;", "", "()V", "createInputMerger", "Landroidx/work/InputMerger;", "className", "", "createInputMergerWithDefaultFallback", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public abstract class InputMergerFactory {
    public abstract InputMerger createInputMerger(String var1);

    public final InputMerger createInputMergerWithDefaultFallback(String string2) {
        InputMerger inputMerger;
        Intrinsics.checkNotNullParameter((Object)string2, (String)"className");
        InputMerger inputMerger2 = inputMerger = this.createInputMerger(string2);
        if (inputMerger == null) {
            inputMerger2 = InputMergerKt.fromClassName(string2);
        }
        return inputMerger2;
    }
}

