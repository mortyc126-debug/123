/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work;

import androidx.work.Data;
import androidx.work.InputMerger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0016\u00a8\u0006\u0007"}, d2={"Landroidx/work/OverwritingInputMerger;", "Landroidx/work/InputMerger;", "()V", "merge", "Landroidx/work/Data;", "inputs", "", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public final class OverwritingInputMerger
extends InputMerger {
    @Override
    public Data merge(List<Data> object) {
        Intrinsics.checkNotNullParameter(object, (String)"inputs");
        Data.Builder builder = new Data.Builder();
        Map map2 = new LinkedHashMap();
        Iterator<Data> iterator2 = object.iterator();
        while (iterator2.hasNext()) {
            object = iterator2.next().getKeyValueMap();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"input.keyValueMap");
            map2.putAll(object);
        }
        builder.putAll(map2);
        object = builder.build();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"output.build()");
        return object;
    }
}

