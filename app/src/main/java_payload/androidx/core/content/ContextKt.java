/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.core.content;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0086\b\u00a2\u0006\u0002\u0010\u0004\u001aN\u0010\u0005\u001a\u00020\u0006*\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0003\u0010\u000b\u001a\u00020\f2\b\b\u0003\u0010\r\u001a\u00020\f2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00060\u000f\u00a2\u0006\u0002\b\u0011H\u0086\b\u001a8\u0010\u0005\u001a\u00020\u0006*\u00020\u00032\b\b\u0001\u0010\u0012\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00060\u000f\u00a2\u0006\u0002\b\u0011H\u0086\b\u00a8\u0006\u0013"}, d2={"getSystemService", "T", "", "Landroid/content/Context;", "(Landroid/content/Context;)Ljava/lang/Object;", "withStyledAttributes", "", "set", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "", "defStyleRes", "block", "Lkotlin/Function1;", "Landroid/content/res/TypedArray;", "Lkotlin/ExtensionFunctionType;", "resourceId", "core-ktx_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class ContextKt {
    public static final /* synthetic */ <T> T getSystemService(Context context) {
        Intrinsics.reifiedOperationMarker((int)4, (String)"T");
        Class<Object> clazz = Object.class;
        return (T)ContextCompat.getSystemService(context, Object.class);
    }

    public static final void withStyledAttributes(Context context, int n, int[] nArray, Function1<? super TypedArray, Unit> function1) {
        context = context.obtainStyledAttributes(n, nArray);
        function1.invoke((Object)context);
        context.recycle();
    }

    public static final void withStyledAttributes(Context context, AttributeSet attributeSet, int[] nArray, int n, int n2, Function1<? super TypedArray, Unit> function1) {
        context = context.obtainStyledAttributes(attributeSet, nArray, n, n2);
        function1.invoke((Object)context);
        context.recycle();
    }

    public static /* synthetic */ void withStyledAttributes$default(Context context, AttributeSet attributeSet, int[] nArray, int n, int n2, Function1 function1, int n3, Object object) {
        if ((n3 & 1) != 0) {
            attributeSet = null;
        }
        if ((n3 & 4) != 0) {
            n = 0;
        }
        if ((n3 & 8) != 0) {
            n2 = 0;
        }
        context = context.obtainStyledAttributes(attributeSet, nArray, n, n2);
        function1.invoke((Object)context);
        context.recycle();
    }
}

