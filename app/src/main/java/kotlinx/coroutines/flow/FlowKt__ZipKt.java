/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.functions.Function5
 *  kotlin.jvm.functions.Function6
 *  kotlin.jvm.functions.Function7
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.flow;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ZipKt;
import kotlinx.coroutines.flow.FlowKt__ZipKt$combine$;
import kotlinx.coroutines.flow.FlowKt__ZipKt$combineUnsafe$;
import kotlinx.coroutines.flow.internal.CombineKt;

@Metadata(d1={"\u0000d\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aq\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0003\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u001e\u0010\u0004\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00010\u0005\"\b\u0012\u0004\u0012\u0002H\u00030\u00012*\b\u0004\u0010\u0006\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u001ae\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0003\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00010\u000b2*\b\u0004\u0010\u0006\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u001a\u00ba\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0010\"\u0004\b\u0004\u0010\u0011\"\u0004\b\u0005\u0010\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\r0\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00012:\u0010\u0006\u001a6\b\u0001\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0017\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018\u001a\u00a0\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0010\"\u0004\b\u0004\u0010\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\r0\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00100\u000124\u0010\u0006\u001a0\b\u0001\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0019\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001a\u001a\u0088\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\r0\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000120\b\u0001\u0010\u0006\u001a*\b\u0001\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u001b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001c\u001a\u008a\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\r0\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00012F\u0010\u0006\u001aB\b\u0001\u0012\u0013\u0012\u0011H\r\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u0011H\u000e\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(!\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u001d\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"\u001a\u0082\u0001\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0003\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u001e\u0010\u0004\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00010\u0005\"\b\u0012\u0004\u0012\u0002H\u00030\u00012;\b\u0005\u0010\u0006\u001a5\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u001d\u00a2\u0006\u0002\b&H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010'\u001av\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0003\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00010\u000b2;\b\u0005\u0010\u0006\u001a5\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u001d\u00a2\u0006\u0002\b&H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010(\u001a\u00cd\u0001\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0010\"\u0004\b\u0004\u0010\u0011\"\u0004\b\u0005\u0010\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\r0\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00012M\b\u0001\u0010\u0006\u001aG\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020$\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\b\u0012\u0006\u0012\u0004\u0018\u00010\t0)\u00a2\u0006\u0002\b&\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010*\u001a\u00b3\u0001\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0010\"\u0004\b\u0004\u0010\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\r0\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00012G\b\u0001\u0010\u0006\u001aA\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020$\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0017\u00a2\u0006\u0002\b&\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010+\u001a\u0099\u0001\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\r0\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00012A\b\u0001\u0010\u0006\u001a;\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020$\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0019\u00a2\u0006\u0002\b&\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010,\u001a\u009d\u0001\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\r0\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00012Y\b\u0001\u0010\u0006\u001aS\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020$\u0012\u0013\u0012\u0011H\r\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u0011H\u000e\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(!\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u001b\u00a2\u0006\u0002\b&\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010-\u001a\u0084\u0001\u0010.\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0003\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u001e\u0010\u0004\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00010\u0005\"\b\u0012\u0004\u0012\u0002H\u00030\u00012;\b\u0005\u0010\u0006\u001a5\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u001d\u00a2\u0006\u0002\b&H\u0082\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b/\u0010'\u001as\u00100\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0003\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u001e\u0010\u0004\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00010\u0005\"\b\u0012\u0004\u0012\u0002H\u00030\u00012*\b\u0004\u0010\u0006\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0082\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b1\u0010\n\u001a!\u00102\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u000503\"\u0004\b\u0000\u0010\u0003H\u0002\u00a2\u0006\u0002\b4\u001a\u008a\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u0002H\r0\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00012F\u0010\u0006\u001aB\b\u0001\u0012\u0013\u0012\u0011H\r\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u0011H\u000e\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(!\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u001dH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b5\u0010\"\u001a\u009d\u0001\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u0002H\r0\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00012Y\b\u0001\u0010\u0006\u001aS\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020$\u0012\u0013\u0012\u0011H\r\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u0011H\u000e\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(!\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u001b\u00a2\u0006\u0002\b&H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b6\u0010-\u001ah\u00107\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u0002H\r0\u00012\f\u00108\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00012(\u0010\u0006\u001a$\b\u0001\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u001d\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00069"}, d2={"combine", "Lkotlinx/coroutines/flow/Flow;", "R", "T", "flows", "", "transform", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "([Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "T1", "T2", "T3", "T4", "T5", "flow", "flow2", "flow3", "flow4", "flow5", "Lkotlin/Function6;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function6;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function5;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function5;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function4;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "a", "b", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "combineTransform", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/ExtensionFunctionType;", "([Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function7;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function7;)Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function6;)Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function5;)Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "combineTransformUnsafe", "combineTransformUnsafe$FlowKt__ZipKt", "combineUnsafe", "combineUnsafe$FlowKt__ZipKt", "nullArrayFactory", "Lkotlin/Function0;", "nullArrayFactory$FlowKt__ZipKt", "flowCombine", "flowCombineTransform", "zip", "other", "kotlinx-coroutines-core"}, k=5, mv={1, 8, 0}, xi=48, xs="kotlinx/coroutines/flow/FlowKt")
final class FlowKt__ZipKt {
    public static final /* synthetic */ Function0 access$nullArrayFactory() {
        return FlowKt__ZipKt.nullArrayFactory$FlowKt__ZipKt();
    }

    public static final /* synthetic */ <T, R> Flow<R> combine(Iterable<? extends Flow<? extends T>> flowArray, Function2<? super T[], ? super Continuation<? super R>, ? extends Object> function2) {
        flowArray = ((Collection)CollectionsKt.toList(flowArray)).toArray(new Flow[0]);
        Intrinsics.needClassReification();
        return new Flow<R>(flowArray, function2){
            final Flow[] $flowArray$inlined;
            final Function2 $transform$inlined;
            {
                this.$flowArray$inlined = flowArray;
                this.$transform$inlined = function2;
            }

            public Object collect(FlowCollector<? super R> object, Continuation<? super Unit> continuation) {
                Flow[] flowArray = this.$flowArray$inlined;
                Intrinsics.needClassReification();
                Function0 function0 = (Function0)new Function0<T[]>(this.$flowArray$inlined){
                    final Flow<T>[] $flowArray;
                    {
                        this.$flowArray = flowArray;
                        super(0);
                    }

                    public final T[] invoke() {
                        int n = this.$flowArray.length;
                        Intrinsics.reifiedOperationMarker((int)0, (String)"T?");
                        return new Object[n];
                    }
                };
                Intrinsics.needClassReification();
                object = CombineKt.combineInternal(object, flowArray, (Function0<T[]>)function0, (Function3)new Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object>(this.$transform$inlined, null){
                    final Function2<T[], Continuation<? super R>, Object> $transform;
                    private Object L$0;
                    Object L$1;
                    int label;
                    {
                        this.$transform = function2;
                        super(3, continuation);
                    }

                    public final Object invoke(FlowCollector<? super R> flowCollector, T[] TArray, Continuation<? super Unit> object) {
                        Intrinsics.needClassReification();
                        object = new /* invalid duplicate definition of identical inner class */;
                        object.L$0 = flowCollector;
                        object.L$1 = TArray;
                        return object.invokeSuspend(Unit.INSTANCE);
                    }

                    public final Object invokeSuspend(Object object) {
                        block6: {
                            Object[] objectArray;
                            FlowCollector flowCollector;
                            Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                default: {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                case 2: {
                                    ResultKt.throwOnFailure((Object)object);
                                    break block6;
                                }
                                case 1: {
                                    flowCollector = (FlowCollector)this.L$0;
                                    ResultKt.throwOnFailure((Object)object);
                                    break;
                                }
                                case 0: {
                                    ResultKt.throwOnFailure((Object)object);
                                    flowCollector = (FlowCollector)this.L$0;
                                    objectArray = (Object[])this.L$1;
                                    object = this.$transform;
                                    this.L$0 = flowCollector;
                                    this.label = 1;
                                    object = object.invoke((Object)objectArray, (Object)((Object)this));
                                    if (object != object2) break;
                                    return object2;
                                }
                            }
                            objectArray = (Object[])this;
                            this.L$0 = null;
                            this.label = 2;
                            if (flowCollector.emit(object, (Continuation<Unit>)objectArray) == object2) {
                                return object2;
                            }
                        }
                        return Unit.INSTANCE;
                    }

                    public final Object invokeSuspend$$forInline(Object object) {
                        object = (FlowCollector)this.L$0;
                        Object object2 = (Object[])this.L$1;
                        object2 = this.$transform.invoke(object2, (Object)((Object)this));
                        Continuation continuation = (Continuation)this;
                        InlineMarker.mark((int)0);
                        object.emit(object2, (Continuation<? super Unit>)continuation);
                        InlineMarker.mark((int)1);
                        return Unit.INSTANCE;
                    }
                }, continuation);
                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }

            public Object collect$$forInline(FlowCollector flowCollector, Continuation continuation) {
                InlineMarker.mark((int)4);
                new ContinuationImpl(this, continuation){
                    int label;
                    Object result;
                    final combine$$inlined$unsafeFlow$3 this$0;
                    {
                        this.this$0 = var1_1;
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object object) {
                        this.result = object;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.collect(null, (Continuation<? super Unit>)((Continuation)this));
                    }
                };
                InlineMarker.mark((int)5);
                Flow[] flowArray = this.$flowArray$inlined;
                Intrinsics.needClassReification();
                Function0 function0 = (Function0)new /* invalid duplicate definition of identical inner class */;
                Intrinsics.needClassReification();
                Function3 function3 = (Function3)new /* invalid duplicate definition of identical inner class */;
                InlineMarker.mark((int)0);
                CombineKt.combineInternal(flowCollector, flowArray, (Function0<T[]>)function0, function3, (Continuation<? super Unit>)continuation);
                InlineMarker.mark((int)1);
                return Unit.INSTANCE;
            }
        };
    }

    public static final <T1, T2, R> Flow<R> combine(Flow<? extends T1> flow2, Flow<? extends T2> flow3, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt.flowCombine(flow2, flow3, function3);
    }

    public static final <T1, T2, T3, R> Flow<R> combine(Flow<? extends T1> flow2, Flow<? extends T2> flow3, Flow<? extends T3> flow4, Function4<? super T1, ? super T2, ? super T3, ? super Continuation<? super R>, ? extends Object> function4) {
        flow2 = new Flow<R>(new Flow[]{flow2, flow3, flow4}, function4){
            final Flow[] $flows$inlined;
            final Function4 $transform$inlined$1;
            {
                this.$flows$inlined = flowArray;
                this.$transform$inlined$1 = function4;
            }

            public Object collect(FlowCollector object, Continuation continuation) {
                if ((object = CombineKt.combineInternal(object, this.$flows$inlined, (Function0<T[]>)FlowKt__ZipKt.access$nullArrayFactory(), (Function3)new Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object>(null, this.$transform$inlined$1){
                    final Function4 $transform$inlined;
                    private Object L$0;
                    Object L$1;
                    int label;
                    {
                        this.$transform$inlined = function4;
                        super(3, continuation);
                    }

                    public final Object invoke(FlowCollector<? super R> flowCollector, Object[] objectArray, Continuation<? super Unit> object) {
                        object = new /* invalid duplicate definition of identical inner class */;
                        object.L$0 = flowCollector;
                        object.L$1 = objectArray;
                        return object.invokeSuspend(Unit.INSTANCE);
                    }

                    public final Object invokeSuspend(Object object) {
                        block6: {
                            Continuation continuation;
                            FlowCollector flowCollector;
                            Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                default: {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                case 2: {
                                    ResultKt.throwOnFailure((Object)object);
                                    break block6;
                                }
                                case 1: {
                                    flowCollector = (FlowCollector)this.L$0;
                                    ResultKt.throwOnFailure((Object)object);
                                    break;
                                }
                                case 0: {
                                    ResultKt.throwOnFailure((Object)object);
                                    flowCollector = (FlowCollector)this.L$0;
                                    Object object3 = (Object[])this.L$1;
                                    object = (Continuation)this;
                                    continuation = this.$transform$inlined;
                                    object = object3[0];
                                    Object object4 = object3[1];
                                    object3 = object3[2];
                                    this.L$0 = flowCollector;
                                    this.label = 1;
                                    InlineMarker.mark((int)6);
                                    object = continuation.invoke(object, object4, object3, (Object)((Object)this));
                                    InlineMarker.mark((int)7);
                                    if (object != object2) break;
                                    return object2;
                                }
                            }
                            continuation = (Continuation)this;
                            this.L$0 = null;
                            this.label = 2;
                            if (flowCollector.emit(object, (Continuation<Unit>)continuation) == object2) {
                                return object2;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }, (Continuation<? super Unit>)continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        };
        return flow2;
    }

    public static final <T1, T2, T3, T4, R> Flow<R> combine(Flow<? extends T1> flow2, Flow<? extends T2> flow3, Flow<? extends T3> flow4, Flow<? extends T4> flow5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super R>, ? extends Object> function5) {
        flow2 = new Flow<R>(new Flow[]{flow2, flow3, flow4, flow5}, function5){
            final Flow[] $flows$inlined;
            final Function5 $transform$inlined$1;
            {
                this.$flows$inlined = flowArray;
                this.$transform$inlined$1 = function5;
            }

            public Object collect(FlowCollector object, Continuation continuation) {
                if ((object = CombineKt.combineInternal(object, this.$flows$inlined, (Function0<T[]>)FlowKt__ZipKt.access$nullArrayFactory(), (Function3)new Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object>(null, this.$transform$inlined$1){
                    final Function5 $transform$inlined;
                    private Object L$0;
                    Object L$1;
                    int label;
                    {
                        this.$transform$inlined = function5;
                        super(3, continuation);
                    }

                    public final Object invoke(FlowCollector<? super R> flowCollector, Object[] objectArray, Continuation<? super Unit> object) {
                        object = new /* invalid duplicate definition of identical inner class */;
                        object.L$0 = flowCollector;
                        object.L$1 = objectArray;
                        return object.invokeSuspend(Unit.INSTANCE);
                    }

                    public final Object invokeSuspend(Object object) {
                        block6: {
                            Object object2;
                            FlowCollector flowCollector;
                            Object object3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                default: {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                case 2: {
                                    ResultKt.throwOnFailure((Object)object);
                                    break block6;
                                }
                                case 1: {
                                    flowCollector = (FlowCollector)this.L$0;
                                    ResultKt.throwOnFailure((Object)object);
                                    break;
                                }
                                case 0: {
                                    ResultKt.throwOnFailure((Object)object);
                                    flowCollector = (FlowCollector)this.L$0;
                                    object = (Object[])this.L$1;
                                    object2 = (Continuation)this;
                                    Function5 function5 = this.$transform$inlined;
                                    Object object4 = object[0];
                                    Object object5 = object[1];
                                    object2 = object[2];
                                    object = object[3];
                                    this.L$0 = flowCollector;
                                    this.label = 1;
                                    InlineMarker.mark((int)6);
                                    object = function5.invoke(object4, object5, object2, object, (Object)((Object)this));
                                    InlineMarker.mark((int)7);
                                    if (object != object3) break;
                                    return object3;
                                }
                            }
                            object2 = (Continuation)this;
                            this.L$0 = null;
                            this.label = 2;
                            if (flowCollector.emit(object, (Continuation<Unit>)object2) == object3) {
                                return object3;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }, (Continuation<? super Unit>)continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        };
        return flow2;
    }

    public static final <T1, T2, T3, T4, T5, R> Flow<R> combine(Flow<? extends T1> flow2, Flow<? extends T2> flow3, Flow<? extends T3> flow4, Flow<? extends T4> flow5, Flow<? extends T5> flow6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super R>, ? extends Object> function6) {
        flow2 = new Flow<R>(new Flow[]{flow2, flow3, flow4, flow5, flow6}, function6){
            final Flow[] $flows$inlined;
            final Function6 $transform$inlined$1;
            {
                this.$flows$inlined = flowArray;
                this.$transform$inlined$1 = function6;
            }

            public Object collect(FlowCollector object, Continuation continuation) {
                if ((object = CombineKt.combineInternal(object, this.$flows$inlined, (Function0<T[]>)FlowKt__ZipKt.access$nullArrayFactory(), (Function3)new Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object>(null, this.$transform$inlined$1){
                    final Function6 $transform$inlined;
                    private Object L$0;
                    Object L$1;
                    int label;
                    {
                        this.$transform$inlined = function6;
                        super(3, continuation);
                    }

                    public final Object invoke(FlowCollector<? super R> flowCollector, Object[] objectArray, Continuation<? super Unit> object) {
                        object = new /* invalid duplicate definition of identical inner class */;
                        object.L$0 = flowCollector;
                        object.L$1 = objectArray;
                        return object.invokeSuspend(Unit.INSTANCE);
                    }

                    public final Object invokeSuspend(Object object) {
                        block6: {
                            Continuation continuation;
                            FlowCollector flowCollector;
                            Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                default: {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                case 2: {
                                    ResultKt.throwOnFailure((Object)object);
                                    break block6;
                                }
                                case 1: {
                                    flowCollector = (FlowCollector)this.L$0;
                                    ResultKt.throwOnFailure((Object)object);
                                    break;
                                }
                                case 0: {
                                    ResultKt.throwOnFailure((Object)object);
                                    flowCollector = (FlowCollector)this.L$0;
                                    Object object3 = (Object[])this.L$1;
                                    object = (Continuation)this;
                                    continuation = this.$transform$inlined;
                                    Object object4 = object3[0];
                                    Object object5 = object3[1];
                                    Object object6 = object3[2];
                                    object = object3[3];
                                    object3 = object3[4];
                                    this.L$0 = flowCollector;
                                    this.label = 1;
                                    InlineMarker.mark((int)6);
                                    object = continuation.invoke(object4, object5, object6, object, object3, (Object)((Object)this));
                                    InlineMarker.mark((int)7);
                                    if (object != object2) break;
                                    return object2;
                                }
                            }
                            continuation = (Continuation)this;
                            this.L$0 = null;
                            this.label = 2;
                            if (flowCollector.emit(object, (Continuation<Unit>)continuation) == object2) {
                                return object2;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }, (Continuation<? super Unit>)continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        };
        return flow2;
    }

    public static final /* synthetic */ <T, R> Flow<R> combine(Flow<? extends T>[] flowArray, Function2<? super T[], ? super Continuation<? super R>, ? extends Object> function2) {
        Intrinsics.needClassReification();
        return new Flow<R>(flowArray, function2){
            final Flow[] $flows$inlined;
            final Function2 $transform$inlined;
            {
                this.$flows$inlined = flowArray;
                this.$transform$inlined = function2;
            }

            public Object collect(FlowCollector<? super R> object, Continuation<? super Unit> continuation) {
                Flow[] flowArray = this.$flows$inlined;
                Intrinsics.needClassReification();
                Function0 function0 = (Function0)new Function0<T[]>(this.$flows$inlined){
                    final Flow<T>[] $flows;
                    {
                        this.$flows = flowArray;
                        super(0);
                    }

                    public final T[] invoke() {
                        int n = this.$flows.length;
                        Intrinsics.reifiedOperationMarker((int)0, (String)"T?");
                        return new Object[n];
                    }
                };
                Intrinsics.needClassReification();
                object = CombineKt.combineInternal(object, flowArray, (Function0<T[]>)function0, (Function3)new Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object>(this.$transform$inlined, null){
                    final Function2<T[], Continuation<? super R>, Object> $transform;
                    private Object L$0;
                    Object L$1;
                    int label;
                    {
                        this.$transform = function2;
                        super(3, continuation);
                    }

                    public final Object invoke(FlowCollector<? super R> flowCollector, T[] TArray, Continuation<? super Unit> object) {
                        Intrinsics.needClassReification();
                        object = new /* invalid duplicate definition of identical inner class */;
                        object.L$0 = flowCollector;
                        object.L$1 = TArray;
                        return object.invokeSuspend(Unit.INSTANCE);
                    }

                    public final Object invokeSuspend(Object object) {
                        block6: {
                            Object[] objectArray;
                            FlowCollector flowCollector;
                            Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                default: {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                case 2: {
                                    ResultKt.throwOnFailure((Object)object);
                                    break block6;
                                }
                                case 1: {
                                    flowCollector = (FlowCollector)this.L$0;
                                    ResultKt.throwOnFailure((Object)object);
                                    break;
                                }
                                case 0: {
                                    ResultKt.throwOnFailure((Object)object);
                                    flowCollector = (FlowCollector)this.L$0;
                                    objectArray = (Object[])this.L$1;
                                    object = this.$transform;
                                    this.L$0 = flowCollector;
                                    this.label = 1;
                                    object = object.invoke((Object)objectArray, (Object)((Object)this));
                                    if (object != object2) break;
                                    return object2;
                                }
                            }
                            objectArray = (Object[])this;
                            this.L$0 = null;
                            this.label = 2;
                            if (flowCollector.emit(object, (Continuation<Unit>)objectArray) == object2) {
                                return object2;
                            }
                        }
                        return Unit.INSTANCE;
                    }

                    public final Object invokeSuspend$$forInline(Object object) {
                        object = (FlowCollector)this.L$0;
                        Continuation continuation = (Continuation)this.L$1;
                        Object object2 = this.$transform.invoke((Object)continuation, (Object)((Object)this));
                        continuation = (Continuation)this;
                        InlineMarker.mark((int)0);
                        object.emit(object2, (Continuation<? super Unit>)continuation);
                        InlineMarker.mark((int)1);
                        return Unit.INSTANCE;
                    }
                }, continuation);
                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }

            public Object collect$$forInline(FlowCollector flowCollector, Continuation continuation) {
                InlineMarker.mark((int)4);
                new ContinuationImpl(this, continuation){
                    int label;
                    Object result;
                    final combine$$inlined$unsafeFlow$2 this$0;
                    {
                        this.this$0 = var1_1;
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object object) {
                        this.result = object;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.collect(null, (Continuation<? super Unit>)((Continuation)this));
                    }
                };
                InlineMarker.mark((int)5);
                Flow[] flowArray = this.$flows$inlined;
                Intrinsics.needClassReification();
                Function0 function0 = (Function0)new /* invalid duplicate definition of identical inner class */;
                Intrinsics.needClassReification();
                Function3 function3 = (Function3)new /* invalid duplicate definition of identical inner class */;
                InlineMarker.mark((int)0);
                CombineKt.combineInternal(flowCollector, flowArray, (Function0<T[]>)function0, function3, (Continuation<? super Unit>)continuation);
                InlineMarker.mark((int)1);
                return Unit.INSTANCE;
            }
        };
    }

    public static final /* synthetic */ <T, R> Flow<R> combineTransform(Iterable<? extends Flow<? extends T>> flowArray, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> function3) {
        flowArray = ((Collection)CollectionsKt.toList(flowArray)).toArray(new Flow[0]);
        Intrinsics.needClassReification();
        return FlowKt.flow((Function2)new Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object>(flowArray, function3, null){
            final Flow<T>[] $flowArray;
            final Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> $transform;
            private Object L$0;
            int label;
            {
                this.$flowArray = flowArray;
                this.$transform = function3;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(FlowCollector<? super R> flowCollector, Continuation<? super Unit> continuation) {
                return (this.create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object object) {
                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    default: {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)object);
                        break;
                    }
                    case 0: {
                        ResultKt.throwOnFailure((Object)object);
                        object = (FlowCollector)this.L$0;
                        Flow<T>[] flowArray = this.$flowArray;
                        Intrinsics.needClassReification();
                        Function0 function0 = (Function0)new Function0<T[]>(this.$flowArray){
                            final Flow<T>[] $flowArray;
                            {
                                this.$flowArray = flowArray;
                                super(0);
                            }

                            public final T[] invoke() {
                                int n = this.$flowArray.length;
                                Intrinsics.reifiedOperationMarker((int)0, (String)"T?");
                                return new Object[n];
                            }
                        };
                        Intrinsics.needClassReification();
                        Function3 function3 = (Function3)new Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object>(this.$transform, null){
                            final Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> $transform;
                            private Object L$0;
                            Object L$1;
                            int label;
                            {
                                this.$transform = function3;
                                super(3, continuation);
                            }

                            public final Object invoke(FlowCollector<? super R> flowCollector, T[] TArray, Continuation<? super Unit> object) {
                                Intrinsics.needClassReification();
                                object = new /* invalid duplicate definition of identical inner class */;
                                object.L$0 = flowCollector;
                                object.L$1 = TArray;
                                return object.invokeSuspend(Unit.INSTANCE);
                            }

                            public final Object invokeSuspend(Object object) {
                                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    default: {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    case 1: {
                                        ResultKt.throwOnFailure((Object)object);
                                        break;
                                    }
                                    case 0: {
                                        ResultKt.throwOnFailure((Object)object);
                                        object = (FlowCollector)this.L$0;
                                        Object[] objectArray = (Object[])this.L$1;
                                        Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> function3 = this.$transform;
                                        this.L$0 = null;
                                        this.label = 1;
                                        if (function3.invoke(object, (Object)objectArray, (Object)((Object)this)) != object2) break;
                                        return object2;
                                    }
                                }
                                return Unit.INSTANCE;
                            }

                            public final Object invokeSuspend$$forInline(Object objectArray) {
                                FlowCollector flowCollector = (FlowCollector)this.L$0;
                                objectArray = (Object[])this.L$1;
                                this.$transform.invoke((Object)flowCollector, (Object)objectArray, (Object)((Object)this));
                                return Unit.INSTANCE;
                            }
                        };
                        Continuation continuation = (Continuation)this;
                        this.label = 1;
                        if (CombineKt.combineInternal(object, flowArray, (Function0<T[]>)function0, function3, (Continuation<? super Unit>)continuation) != object2) break;
                        return object2;
                    }
                }
                return Unit.INSTANCE;
            }

            public final Object invokeSuspend$$forInline(Object object) {
                FlowCollector flowCollector = (FlowCollector)this.L$0;
                Flow<T>[] flowArray = this.$flowArray;
                Intrinsics.needClassReification();
                Function0 function0 = (Function0)new /* invalid duplicate definition of identical inner class */;
                Intrinsics.needClassReification();
                Function3 function3 = (Function3)new /* invalid duplicate definition of identical inner class */;
                object = (Continuation)this;
                InlineMarker.mark((int)0);
                CombineKt.combineInternal(flowCollector, flowArray, (Function0<T[]>)function0, function3, (Continuation<? super Unit>)object);
                InlineMarker.mark((int)1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final <T1, T2, R> Flow<R> combineTransform(Flow<? extends T1> flow2, Flow<? extends T2> flow3, Function4<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super Continuation<? super Unit>, ? extends Object> function4) {
        flow2 = FlowKt.flow((Function2)new Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object>(new Flow[]{flow2, flow3}, null, function4){
            final Flow[] $flows;
            final Function4 $transform$inlined;
            private Object L$0;
            int label;
            {
                this.$flows = flowArray;
                this.$transform$inlined = function4;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(FlowCollector<? super R> flowCollector, Continuation<? super Unit> continuation) {
                return (this.create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object object) {
                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    default: {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)object);
                        break;
                    }
                    case 0: {
                        ResultKt.throwOnFailure((Object)object);
                        FlowCollector flowCollector = (FlowCollector)this.L$0;
                        Flow[] flowArray = this.$flows;
                        Function0 function0 = FlowKt__ZipKt.access$nullArrayFactory();
                        Function3 function3 = (Function3)new Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object>(null, this.$transform$inlined){
                            final Function4 $transform$inlined;
                            private Object L$0;
                            Object L$1;
                            int label;
                            {
                                this.$transform$inlined = function4;
                                super(3, continuation);
                            }

                            public final Object invoke(FlowCollector<? super R> flowCollector, Object[] objectArray, Continuation<? super Unit> object) {
                                object = new /* invalid duplicate definition of identical inner class */;
                                object.L$0 = flowCollector;
                                object.L$1 = objectArray;
                                return object.invokeSuspend(Unit.INSTANCE);
                            }

                            public final Object invokeSuspend(Object object) {
                                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    default: {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    case 1: {
                                        ResultKt.throwOnFailure((Object)object);
                                        break;
                                    }
                                    case 0: {
                                        ResultKt.throwOnFailure((Object)object);
                                        object = (FlowCollector)this.L$0;
                                        Object object3 = (Object[])this.L$1;
                                        Continuation continuation = (Continuation)this;
                                        continuation = this.$transform$inlined;
                                        Object object4 = object3[0];
                                        object3 = object3[1];
                                        this.label = 1;
                                        InlineMarker.mark((int)6);
                                        object = continuation.invoke(object, object4, object3, (Object)((Object)this));
                                        InlineMarker.mark((int)7);
                                        if (object != object2) break;
                                        return object2;
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        object = (Continuation)this;
                        this.label = 1;
                        if (CombineKt.combineInternal(flowCollector, flowArray, (Function0<T[]>)function0, function3, (Continuation<? super Unit>)object) != object2) break;
                        return object2;
                    }
                }
                return Unit.INSTANCE;
            }
        });
        return flow2;
    }

    public static final <T1, T2, T3, R> Flow<R> combineTransform(Flow<? extends T1> flow2, Flow<? extends T2> flow3, Flow<? extends T3> flow4, Function5<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super Continuation<? super Unit>, ? extends Object> function5) {
        flow2 = FlowKt.flow((Function2)new Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object>(new Flow[]{flow2, flow3, flow4}, null, function5){
            final Flow[] $flows;
            final Function5 $transform$inlined;
            private Object L$0;
            int label;
            {
                this.$flows = flowArray;
                this.$transform$inlined = function5;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(FlowCollector<? super R> flowCollector, Continuation<? super Unit> continuation) {
                return (this.create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object flowArray) {
                Object object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    default: {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)flowArray);
                        break;
                    }
                    case 0: {
                        ResultKt.throwOnFailure((Object)flowArray);
                        FlowCollector flowCollector = (FlowCollector)this.L$0;
                        flowArray = this.$flows;
                        Function0 function0 = FlowKt__ZipKt.access$nullArrayFactory();
                        Function3 function3 = (Function3)new Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object>(null, this.$transform$inlined){
                            final Function5 $transform$inlined;
                            private Object L$0;
                            Object L$1;
                            int label;
                            {
                                this.$transform$inlined = function5;
                                super(3, continuation);
                            }

                            public final Object invoke(FlowCollector<? super R> flowCollector, Object[] objectArray, Continuation<? super Unit> object) {
                                object = new /* invalid duplicate definition of identical inner class */;
                                object.L$0 = flowCollector;
                                object.L$1 = objectArray;
                                return object.invokeSuspend(Unit.INSTANCE);
                            }

                            public final Object invokeSuspend(Object object) {
                                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    default: {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    case 1: {
                                        ResultKt.throwOnFailure((Object)object);
                                        break;
                                    }
                                    case 0: {
                                        ResultKt.throwOnFailure((Object)object);
                                        object = (FlowCollector)this.L$0;
                                        Object object3 = (Object[])this.L$1;
                                        Object object4 = (Continuation)this;
                                        Function5 function5 = this.$transform$inlined;
                                        object4 = object3[0];
                                        Object object5 = object3[1];
                                        object3 = object3[2];
                                        this.label = 1;
                                        InlineMarker.mark((int)6);
                                        object = function5.invoke(object, object4, object5, object3, (Object)((Object)this));
                                        InlineMarker.mark((int)7);
                                        if (object != object2) break;
                                        return object2;
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        Continuation continuation = (Continuation)this;
                        this.label = 1;
                        if (CombineKt.combineInternal(flowCollector, flowArray, (Function0<T[]>)function0, function3, (Continuation<? super Unit>)continuation) != object) break;
                        return object;
                    }
                }
                return Unit.INSTANCE;
            }
        });
        return flow2;
    }

    public static final <T1, T2, T3, T4, R> Flow<R> combineTransform(Flow<? extends T1> flow2, Flow<? extends T2> flow3, Flow<? extends T3> flow4, Flow<? extends T4> flow5, Function6<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super Unit>, ? extends Object> function6) {
        flow2 = FlowKt.flow((Function2)new Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object>(new Flow[]{flow2, flow3, flow4, flow5}, null, function6){
            final Flow[] $flows;
            final Function6 $transform$inlined;
            private Object L$0;
            int label;
            {
                this.$flows = flowArray;
                this.$transform$inlined = function6;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(FlowCollector<? super R> flowCollector, Continuation<? super Unit> continuation) {
                return (this.create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object object) {
                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    default: {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)object);
                        break;
                    }
                    case 0: {
                        ResultKt.throwOnFailure((Object)object);
                        FlowCollector flowCollector = (FlowCollector)this.L$0;
                        Flow[] flowArray = this.$flows;
                        Function0 function0 = FlowKt__ZipKt.access$nullArrayFactory();
                        Function3 function3 = (Function3)new Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object>(null, this.$transform$inlined){
                            final Function6 $transform$inlined;
                            private Object L$0;
                            Object L$1;
                            int label;
                            {
                                this.$transform$inlined = function6;
                                super(3, continuation);
                            }

                            public final Object invoke(FlowCollector<? super R> flowCollector, Object[] objectArray, Continuation<? super Unit> object) {
                                object = new /* invalid duplicate definition of identical inner class */;
                                object.L$0 = flowCollector;
                                object.L$1 = objectArray;
                                return object.invokeSuspend(Unit.INSTANCE);
                            }

                            public final Object invokeSuspend(Object object) {
                                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    default: {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    case 1: {
                                        ResultKt.throwOnFailure((Object)object);
                                        break;
                                    }
                                    case 0: {
                                        ResultKt.throwOnFailure((Object)object);
                                        object = (FlowCollector)this.L$0;
                                        Object object3 = (Object[])this.L$1;
                                        Object object4 = (Continuation)this;
                                        Function6 function6 = this.$transform$inlined;
                                        Object object5 = object3[0];
                                        object4 = object3[1];
                                        Object object6 = object3[2];
                                        object3 = object3[3];
                                        this.label = 1;
                                        InlineMarker.mark((int)6);
                                        object = function6.invoke(object, object5, object4, object6, object3, (Object)((Object)this));
                                        InlineMarker.mark((int)7);
                                        if (object != object2) break;
                                        return object2;
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        object = (Continuation)this;
                        this.label = 1;
                        if (CombineKt.combineInternal(flowCollector, flowArray, (Function0<T[]>)function0, function3, (Continuation<? super Unit>)object) != object2) break;
                        return object2;
                    }
                }
                return Unit.INSTANCE;
            }
        });
        return flow2;
    }

    public static final <T1, T2, T3, T4, T5, R> Flow<R> combineTransform(Flow<? extends T1> flow2, Flow<? extends T2> flow3, Flow<? extends T3> flow4, Flow<? extends T4> flow5, Flow<? extends T5> flow6, Function7<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super Unit>, ? extends Object> function7) {
        flow2 = FlowKt.flow((Function2)new Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object>(new Flow[]{flow2, flow3, flow4, flow5, flow6}, null, function7){
            final Flow[] $flows;
            final Function7 $transform$inlined;
            private Object L$0;
            int label;
            {
                this.$flows = flowArray;
                this.$transform$inlined = function7;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(FlowCollector<? super R> flowCollector, Continuation<? super Unit> continuation) {
                return (this.create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object object) {
                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    default: {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)object);
                        break;
                    }
                    case 0: {
                        ResultKt.throwOnFailure((Object)object);
                        object = (FlowCollector)this.L$0;
                        Flow[] flowArray = this.$flows;
                        Function0 function0 = FlowKt__ZipKt.access$nullArrayFactory();
                        Function3 function3 = (Function3)new Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object>(null, this.$transform$inlined){
                            final Function7 $transform$inlined;
                            private Object L$0;
                            Object L$1;
                            int label;
                            {
                                this.$transform$inlined = function7;
                                super(3, continuation);
                            }

                            public final Object invoke(FlowCollector<? super R> flowCollector, Object[] objectArray, Continuation<? super Unit> object) {
                                object = new /* invalid duplicate definition of identical inner class */;
                                object.L$0 = flowCollector;
                                object.L$1 = objectArray;
                                return object.invokeSuspend(Unit.INSTANCE);
                            }

                            public final Object invokeSuspend(Object object) {
                                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    default: {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    case 1: {
                                        ResultKt.throwOnFailure((Object)object);
                                        break;
                                    }
                                    case 0: {
                                        ResultKt.throwOnFailure((Object)object);
                                        object = (FlowCollector)this.L$0;
                                        Object object3 = (Object[])this.L$1;
                                        Object object4 = (Continuation)this;
                                        Function7 function7 = this.$transform$inlined;
                                        object4 = object3[0];
                                        Object object5 = object3[1];
                                        Object object6 = object3[2];
                                        Object object7 = object3[3];
                                        object3 = object3[4];
                                        this.label = 1;
                                        InlineMarker.mark((int)6);
                                        object = function7.invoke(object, object4, object5, object6, object7, object3, (Object)((Object)this));
                                        InlineMarker.mark((int)7);
                                        if (object != object2) break;
                                        return object2;
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        Continuation continuation = (Continuation)this;
                        this.label = 1;
                        if (CombineKt.combineInternal(object, flowArray, (Function0<T[]>)function0, function3, (Continuation<? super Unit>)continuation) != object2) break;
                        return object2;
                    }
                }
                return Unit.INSTANCE;
            }
        });
        return flow2;
    }

    public static final /* synthetic */ <T, R> Flow<R> combineTransform(Flow<? extends T>[] flowArray, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.needClassReification();
        return FlowKt.flow((Function2)new Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object>(flowArray, function3, null){
            final Flow<T>[] $flows;
            final Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> $transform;
            private Object L$0;
            int label;
            {
                this.$flows = flowArray;
                this.$transform = function3;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(FlowCollector<? super R> flowCollector, Continuation<? super Unit> continuation) {
                return (this.create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object object) {
                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    default: {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)object);
                        break;
                    }
                    case 0: {
                        ResultKt.throwOnFailure((Object)object);
                        object = (FlowCollector)this.L$0;
                        Flow<T>[] flowArray = this.$flows;
                        Intrinsics.needClassReification();
                        Function0 function0 = (Function0)new Function0<T[]>(this.$flows){
                            final Flow<T>[] $flows;
                            {
                                this.$flows = flowArray;
                                super(0);
                            }

                            public final T[] invoke() {
                                int n = this.$flows.length;
                                Intrinsics.reifiedOperationMarker((int)0, (String)"T?");
                                return new Object[n];
                            }
                        };
                        Intrinsics.needClassReification();
                        Function3 function3 = (Function3)new Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object>(this.$transform, null){
                            final Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> $transform;
                            private Object L$0;
                            Object L$1;
                            int label;
                            {
                                this.$transform = function3;
                                super(3, continuation);
                            }

                            public final Object invoke(FlowCollector<? super R> flowCollector, T[] TArray, Continuation<? super Unit> object) {
                                Intrinsics.needClassReification();
                                object = new /* invalid duplicate definition of identical inner class */;
                                object.L$0 = flowCollector;
                                object.L$1 = TArray;
                                return object.invokeSuspend(Unit.INSTANCE);
                            }

                            public final Object invokeSuspend(Object objectArray) {
                                Object object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    default: {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    case 1: {
                                        ResultKt.throwOnFailure((Object)objectArray);
                                        break;
                                    }
                                    case 0: {
                                        ResultKt.throwOnFailure((Object)objectArray);
                                        FlowCollector flowCollector = (FlowCollector)this.L$0;
                                        objectArray = (Object[])this.L$1;
                                        Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> function3 = this.$transform;
                                        this.L$0 = null;
                                        this.label = 1;
                                        if (function3.invoke((Object)flowCollector, (Object)objectArray, (Object)((Object)this)) != object) break;
                                        return object;
                                    }
                                }
                                return Unit.INSTANCE;
                            }

                            public final Object invokeSuspend$$forInline(Object objectArray) {
                                FlowCollector flowCollector = (FlowCollector)this.L$0;
                                objectArray = (Object[])this.L$1;
                                this.$transform.invoke((Object)flowCollector, (Object)objectArray, (Object)((Object)this));
                                return Unit.INSTANCE;
                            }
                        };
                        Continuation continuation = (Continuation)this;
                        this.label = 1;
                        if (CombineKt.combineInternal(object, flowArray, (Function0<T[]>)function0, function3, (Continuation<? super Unit>)continuation) != object2) break;
                        return object2;
                    }
                }
                return Unit.INSTANCE;
            }

            public final Object invokeSuspend$$forInline(Object object) {
                FlowCollector flowCollector = (FlowCollector)this.L$0;
                Flow<T>[] flowArray = this.$flows;
                Intrinsics.needClassReification();
                object = (Function0)new /* invalid duplicate definition of identical inner class */;
                Intrinsics.needClassReification();
                Function3 function3 = (Function3)new /* invalid duplicate definition of identical inner class */;
                Continuation continuation = (Continuation)this;
                InlineMarker.mark((int)0);
                CombineKt.combineInternal(flowCollector, flowArray, (Function0<T[]>)object, function3, (Continuation<? super Unit>)continuation);
                InlineMarker.mark((int)1);
                return Unit.INSTANCE;
            }
        });
    }

    private static final /* synthetic */ <T, R> Flow<R> combineTransformUnsafe$FlowKt__ZipKt(Flow<? extends T>[] flowArray, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.needClassReification();
        return FlowKt.flow((Function2)new Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object>(flowArray, function3, null){
            final Flow<T>[] $flows;
            final Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> $transform;
            private Object L$0;
            int label;
            {
                this.$flows = flowArray;
                this.$transform = function3;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(FlowCollector<? super R> flowCollector, Continuation<? super Unit> continuation) {
                return (this.create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object flowArray) {
                Object object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    default: {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)flowArray);
                        break;
                    }
                    case 0: {
                        ResultKt.throwOnFailure((Object)flowArray);
                        FlowCollector flowCollector = (FlowCollector)this.L$0;
                        flowArray = this.$flows;
                        Function0 function0 = FlowKt__ZipKt.access$nullArrayFactory();
                        Intrinsics.needClassReification();
                        Function3 function3 = (Function3)new Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object>(this.$transform, null){
                            final Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> $transform;
                            private Object L$0;
                            Object L$1;
                            int label;
                            {
                                this.$transform = function3;
                                super(3, continuation);
                            }

                            public final Object invoke(FlowCollector<? super R> flowCollector, T[] TArray, Continuation<? super Unit> object) {
                                Intrinsics.needClassReification();
                                object = new /* invalid duplicate definition of identical inner class */;
                                object.L$0 = flowCollector;
                                object.L$1 = TArray;
                                return object.invokeSuspend(Unit.INSTANCE);
                            }

                            public final Object invokeSuspend(Object object) {
                                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    default: {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    case 1: {
                                        ResultKt.throwOnFailure((Object)object);
                                        break;
                                    }
                                    case 0: {
                                        ResultKt.throwOnFailure((Object)object);
                                        object = (FlowCollector)this.L$0;
                                        Object[] objectArray = (Object[])this.L$1;
                                        Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> function3 = this.$transform;
                                        this.L$0 = null;
                                        this.label = 1;
                                        if (function3.invoke(object, (Object)objectArray, (Object)((Object)this)) != object2) break;
                                        return object2;
                                    }
                                }
                                return Unit.INSTANCE;
                            }

                            public final Object invokeSuspend$$forInline(Object object) {
                                object = (FlowCollector)this.L$0;
                                Object[] objectArray = (Object[])this.L$1;
                                this.$transform.invoke(object, (Object)objectArray, (Object)((Object)this));
                                return Unit.INSTANCE;
                            }
                        };
                        Continuation continuation = (Continuation)this;
                        this.label = 1;
                        if (CombineKt.combineInternal(flowCollector, flowArray, (Function0<T[]>)function0, function3, (Continuation<? super Unit>)continuation) != object) break;
                        return object;
                    }
                }
                return Unit.INSTANCE;
            }

            public final Object invokeSuspend$$forInline(Object object) {
                FlowCollector flowCollector = (FlowCollector)this.L$0;
                Flow<T>[] flowArray = this.$flows;
                object = FlowKt__ZipKt.access$nullArrayFactory();
                Intrinsics.needClassReification();
                Function3 function3 = (Function3)new /* invalid duplicate definition of identical inner class */;
                Continuation continuation = (Continuation)this;
                InlineMarker.mark((int)0);
                CombineKt.combineInternal(flowCollector, flowArray, (Function0<T[]>)object, function3, (Continuation<? super Unit>)continuation);
                InlineMarker.mark((int)1);
                return Unit.INSTANCE;
            }
        });
    }

    private static final /* synthetic */ <T, R> Flow<R> combineUnsafe$FlowKt__ZipKt(Flow<? extends T>[] flowArray, Function2<? super T[], ? super Continuation<? super R>, ? extends Object> function2) {
        Intrinsics.needClassReification();
        return new Flow<R>(flowArray, function2){
            final Flow[] $flows$inlined;
            final Function2 $transform$inlined;
            {
                this.$flows$inlined = flowArray;
                this.$transform$inlined = function2;
            }

            public Object collect(FlowCollector<? super R> object, Continuation<? super Unit> continuation) {
                Flow[] flowArray = this.$flows$inlined;
                Function0 function0 = FlowKt__ZipKt.access$nullArrayFactory();
                Intrinsics.needClassReification();
                object = CombineKt.combineInternal(object, flowArray, (Function0<T[]>)function0, (Function3)new Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object>(this.$transform$inlined, null){
                    final Function2<T[], Continuation<? super R>, Object> $transform;
                    private Object L$0;
                    Object L$1;
                    int label;
                    {
                        this.$transform = function2;
                        super(3, continuation);
                    }

                    public final Object invoke(FlowCollector<? super R> flowCollector, T[] TArray, Continuation<? super Unit> object) {
                        Intrinsics.needClassReification();
                        object = new /* invalid duplicate definition of identical inner class */;
                        object.L$0 = flowCollector;
                        object.L$1 = TArray;
                        return object.invokeSuspend(Unit.INSTANCE);
                    }

                    public final Object invokeSuspend(Object object) {
                        block6: {
                            Function2<T[], Continuation<? super R>, Object> function2;
                            FlowCollector flowCollector;
                            Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                default: {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                case 2: {
                                    ResultKt.throwOnFailure((Object)object);
                                    break block6;
                                }
                                case 1: {
                                    flowCollector = (FlowCollector)this.L$0;
                                    ResultKt.throwOnFailure((Object)object);
                                    break;
                                }
                                case 0: {
                                    ResultKt.throwOnFailure((Object)object);
                                    flowCollector = (FlowCollector)this.L$0;
                                    object = (Object[])this.L$1;
                                    function2 = this.$transform;
                                    this.L$0 = flowCollector;
                                    this.label = 1;
                                    object = function2.invoke(object, (Object)((Object)this));
                                    if (object != object2) break;
                                    return object2;
                                }
                            }
                            function2 = (Function2<T[], Continuation<? super R>, Object>)this;
                            this.L$0 = null;
                            this.label = 2;
                            if (flowCollector.emit(object, (Continuation<? super Unit>)function2) == object2) {
                                return object2;
                            }
                        }
                        return Unit.INSTANCE;
                    }

                    public final Object invokeSuspend$$forInline(Object object) {
                        object = (FlowCollector)this.L$0;
                        Object object2 = (Object[])this.L$1;
                        object2 = this.$transform.invoke(object2, (Object)((Object)this));
                        Continuation continuation = (Continuation)this;
                        InlineMarker.mark((int)0);
                        object.emit(object2, (Continuation<? super Unit>)continuation);
                        InlineMarker.mark((int)1);
                        return Unit.INSTANCE;
                    }
                }, continuation);
                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }

            public Object collect$$forInline(FlowCollector flowCollector, Continuation continuation) {
                InlineMarker.mark((int)4);
                new ContinuationImpl(this, continuation){
                    int label;
                    Object result;
                    final combineUnsafe$$inlined$unsafeFlow$1 this$0;
                    {
                        this.this$0 = var1_1;
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object object) {
                        this.result = object;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.collect(null, (Continuation<? super Unit>)((Continuation)this));
                    }
                };
                InlineMarker.mark((int)5);
                Flow[] flowArray = this.$flows$inlined;
                Function0 function0 = FlowKt__ZipKt.access$nullArrayFactory();
                Intrinsics.needClassReification();
                Function3 function3 = (Function3)new /* invalid duplicate definition of identical inner class */;
                InlineMarker.mark((int)0);
                CombineKt.combineInternal(flowCollector, flowArray, (Function0<T[]>)function0, function3, (Continuation<? super Unit>)continuation);
                InlineMarker.mark((int)1);
                return Unit.INSTANCE;
            }
        };
    }

    public static final <T1, T2, R> Flow<R> flowCombine(Flow<? extends T1> flow2, Flow<? extends T2> flow3, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return new Flow<R>(flow2, flow3, function3){
            final Flow $flow$inlined;
            final Flow $this_combine$inlined;
            final Function3 $transform$inlined;
            {
                this.$this_combine$inlined = flow2;
                this.$flow$inlined = flow3;
                this.$transform$inlined = function3;
            }

            public Object collect(FlowCollector<? super R> object, Continuation<? super Unit> continuation) {
                Flow flow2 = this.$this_combine$inlined;
                Flow flow3 = this.$flow$inlined;
                Function0 function0 = FlowKt__ZipKt.access$nullArrayFactory();
                Function3 function3 = (Function3)new Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object>(this.$transform$inlined, null){
                    final Function3<T1, T2, Continuation<? super R>, Object> $transform;
                    private Object L$0;
                    Object L$1;
                    int label;
                    {
                        this.$transform = function3;
                        super(3, continuation);
                    }

                    public final Object invoke(FlowCollector<? super R> flowCollector, Object[] objectArray, Continuation<? super Unit> object) {
                        object = new /* invalid duplicate definition of identical inner class */;
                        object.L$0 = flowCollector;
                        object.L$1 = objectArray;
                        return object.invokeSuspend(Unit.INSTANCE);
                    }

                    public final Object invokeSuspend(Object object) {
                        block6: {
                            Object object2;
                            FlowCollector flowCollector;
                            Object object3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                default: {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                case 2: {
                                    ResultKt.throwOnFailure((Object)object);
                                    break block6;
                                }
                                case 1: {
                                    flowCollector = (FlowCollector)this.L$0;
                                    ResultKt.throwOnFailure((Object)object);
                                    break;
                                }
                                case 0: {
                                    ResultKt.throwOnFailure((Object)object);
                                    flowCollector = (FlowCollector)this.L$0;
                                    Object object4 = (Object[])this.L$1;
                                    object = this.$transform;
                                    object2 = object4[0];
                                    object4 = object4[1];
                                    this.L$0 = flowCollector;
                                    this.label = 1;
                                    object = object.invoke(object2, object4, (Object)((Object)this));
                                    if (object != object3) break;
                                    return object3;
                                }
                            }
                            object2 = (Continuation)this;
                            this.L$0 = null;
                            this.label = 2;
                            if (flowCollector.emit(object, (Continuation<Unit>)object2) == object3) {
                                return object3;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                };
                if ((object = CombineKt.combineInternal(object, new Flow[]{flow2, flow3}, (Function0<T[]>)function0, function3, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        };
    }

    public static final <T1, T2, R> Flow<R> flowCombineTransform(Flow<? extends T1> flow2, Flow<? extends T2> flow3, Function4<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super Continuation<? super Unit>, ? extends Object> function4) {
        flow2 = FlowKt.flow((Function2)new Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object>(new Flow[]{flow2, flow3}, null, function4){
            final Flow[] $flows;
            final Function4 $transform$inlined;
            private Object L$0;
            int label;
            {
                this.$flows = flowArray;
                this.$transform$inlined = function4;
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object object, Continuation<?> object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(FlowCollector<? super R> flowCollector, Continuation<? super Unit> continuation) {
                return (this.create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object object) {
                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    default: {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)object);
                        break;
                    }
                    case 0: {
                        ResultKt.throwOnFailure((Object)object);
                        FlowCollector flowCollector = (FlowCollector)this.L$0;
                        Flow[] flowArray = this.$flows;
                        Function0 function0 = FlowKt__ZipKt.access$nullArrayFactory();
                        object = (Function3)new Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object>(null, this.$transform$inlined){
                            final Function4 $transform$inlined;
                            private Object L$0;
                            Object L$1;
                            int label;
                            {
                                this.$transform$inlined = function4;
                                super(3, continuation);
                            }

                            public final Object invoke(FlowCollector<? super R> flowCollector, Object[] objectArray, Continuation<? super Unit> object) {
                                object = new /* invalid duplicate definition of identical inner class */;
                                object.L$0 = flowCollector;
                                object.L$1 = objectArray;
                                return object.invokeSuspend(Unit.INSTANCE);
                            }

                            public final Object invokeSuspend(Object object) {
                                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    default: {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    case 1: {
                                        ResultKt.throwOnFailure((Object)object);
                                        break;
                                    }
                                    case 0: {
                                        ResultKt.throwOnFailure((Object)object);
                                        object = (FlowCollector)this.L$0;
                                        Object object3 = (Object[])this.L$1;
                                        Object object4 = (Continuation)this;
                                        Function4 function4 = this.$transform$inlined;
                                        object4 = object3[0];
                                        object3 = object3[1];
                                        this.label = 1;
                                        InlineMarker.mark((int)6);
                                        object = function4.invoke(object, object4, object3, (Object)((Object)this));
                                        InlineMarker.mark((int)7);
                                        if (object != object2) break;
                                        return object2;
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        Continuation continuation = (Continuation)this;
                        this.label = 1;
                        if (CombineKt.combineInternal(flowCollector, flowArray, (Function0<T[]>)function0, object, (Continuation<? super Unit>)continuation) != object2) break;
                        return object2;
                    }
                }
                return Unit.INSTANCE;
            }
        });
        return flow2;
    }

    private static final <T> Function0<T[]> nullArrayFactory$FlowKt__ZipKt() {
        return nullArrayFactory.1.INSTANCE;
    }

    public static final <T1, T2, R> Flow<R> zip(Flow<? extends T1> flow2, Flow<? extends T2> flow3, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return CombineKt.zipImpl(flow2, flow3, function3);
    }
}

