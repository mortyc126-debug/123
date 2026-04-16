package tlydtdl.activity;

import a2.n3;
import amuvvoafs.annotation.SuppressLint;
import amuvvoafs.app.Application;
import amuvvoafs.content.Context;
import amuvvoafs.content.Intent;
import amuvvoafs.content.IntentSender;
import amuvvoafs.content.res.Configuration;
import amuvvoafs.os.Build;
import amuvvoafs.os.Bundle;
import amuvvoafs.os.Handler;
import amuvvoafs.os.Looper;
import amuvvoafs.os.Trace;
import amuvvoafs.view.Menu;
import amuvvoafs.view.MenuInflater;
import amuvvoafs.view.MenuItem;
import amuvvoafs.view.View;
import amuvvoafs.view.ViewGroup;
import amuvvoafs.view.Window;
import amuvvoafs.window.OnBackInvokedDispatcher;
import cc.f;
import cc.g;
import f.a0;
import f.b;
import f.c0;
import f.h;
import f.k;
import f.u;
import f6.e;
import i.c;
import i.i;
import i.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kb.d;
import lmjxuqdtp.Metadata;
import lmjxuqdtp.jvm.functions.Function0;
import okhttp3.HttpUrl;
import q6.a;
import r6.l;
import r6.n;
import r6.o;
import r6.p;
import tlydtdl.activity.ComponentActivity;
import tlydtdl.compose.foundation.layout.m;
import tlydtdl.core.app.p0;
import tlydtdl.core.app.q0;
import tlydtdl.core.app.s0;
import tlydtdl.fragment.app.z0;
import tlydtdl.lifecycle.b1;
import tlydtdl.lifecycle.d1;
import tlydtdl.lifecycle.e0;
import tlydtdl.lifecycle.g0;
import tlydtdl.lifecycle.i0;
import tlydtdl.lifecycle.i1;
import tlydtdl.lifecycle.l1;
import tlydtdl.lifecycle.q;
import tlydtdl.lifecycle.q1;
import tlydtdl.lifecycle.r1;
import tlydtdl.lifecycle.v1;
import tlydtdl.lifecycle.w1;
import tlydtdl.lifecycle.x;
import tlydtdl.lifecycle.y;
import tlydtdl.lifecycle.z;
import y10.r;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000â\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 Î\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\u00022\u00020\r2\u00020\u000e2\u00020\u00022\u00020\u000f2\u00020\u0002:\bÏ\u0001\u008e\u0001Ð\u0001Ñ\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0015¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0017¢\u0006\u0004\b\u0019\u0010\u0018J\u0019\u0010\u001c\u001a\u00020\u00142\b\b\u0001\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001c\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b\u001c\u0010 J#\u0010\u001c\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b\u001c\u0010#J#\u0010$\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b$\u0010#J\u000f\u0010%\u001a\u00020\u0014H\u0017¢\u0006\u0004\b%\u0010\u0011J\u0011\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b'\u0010(J\u0015\u0010+\u001a\u00020\u00142\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\u0015\u0010-\u001a\u00020\u00142\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b-\u0010,J)\u00102\u001a\u0002012\u0006\u0010.\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b2\u00103J\u001f\u00104\u001a\u0002012\u0006\u0010.\u001a\u00020\u001a2\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b4\u00105J\u001f\u00106\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u001a2\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b6\u00107J\u0017\u0010:\u001a\u00020\u00142\u0006\u00109\u001a\u000208H\u0016¢\u0006\u0004\b:\u0010;J\u001f\u0010:\u001a\u00020\u00142\u0006\u00109\u001a\u0002082\u0006\u0010<\u001a\u00020\u0003H\u0016¢\u0006\u0004\b:\u0010=J'\u0010:\u001a\u00020\u00142\u0006\u00109\u001a\u0002082\u0006\u0010<\u001a\u00020\u00032\u0006\u0010?\u001a\u00020>H\u0017¢\u0006\u0004\b:\u0010@J\u0017\u0010A\u001a\u00020\u00142\u0006\u00109\u001a\u000208H\u0016¢\u0006\u0004\bA\u0010;J\u000f\u0010B\u001a\u00020\u0014H\u0016¢\u0006\u0004\bB\u0010\u0011J\u000f\u0010C\u001a\u00020\u0014H\u0017¢\u0006\u0004\bC\u0010\u0011J\u001f\u0010G\u001a\u00020\u00142\u0006\u0010E\u001a\u00020D2\u0006\u0010F\u001a\u00020\u001aH\u0017¢\u0006\u0004\bG\u0010HJ)\u0010G\u001a\u00020\u00142\u0006\u0010E\u001a\u00020D2\u0006\u0010F\u001a\u00020\u001a2\b\u0010I\u001a\u0004\u0018\u00010\u0012H\u0017¢\u0006\u0004\bG\u0010JJA\u0010P\u001a\u00020\u00142\u0006\u0010E\u001a\u00020K2\u0006\u0010F\u001a\u00020\u001a2\b\u0010L\u001a\u0004\u0018\u00010D2\u0006\u0010M\u001a\u00020\u001a2\u0006\u0010N\u001a\u00020\u001a2\u0006\u0010O\u001a\u00020\u001aH\u0017¢\u0006\u0004\bP\u0010QJK\u0010P\u001a\u00020\u00142\u0006\u0010E\u001a\u00020K2\u0006\u0010F\u001a\u00020\u001a2\b\u0010L\u001a\u0004\u0018\u00010D2\u0006\u0010M\u001a\u00020\u001a2\u0006\u0010N\u001a\u00020\u001a2\u0006\u0010O\u001a\u00020\u001a2\b\u0010I\u001a\u0004\u0018\u00010\u0012H\u0017¢\u0006\u0004\bP\u0010RJI\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000[\"\u0004\b\u0000\u0010S\"\u0004\b\u0001\u0010T2\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010U2\u0006\u0010X\u001a\u00020W2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00010Y¢\u0006\u0004\b\\\u0010]JA\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000[\"\u0004\b\u0000\u0010S\"\u0004\b\u0001\u0010T2\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010U2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00010Y¢\u0006\u0004\b\\\u0010^J\u0017\u0010a\u001a\u00020\u00142\u0006\u0010`\u001a\u00020_H\u0017¢\u0006\u0004\ba\u0010bJ\u001b\u0010d\u001a\u00020\u00142\f\u0010*\u001a\b\u0012\u0004\u0012\u00020_0c¢\u0006\u0004\bd\u0010eJ\u001b\u0010f\u001a\u00020\u00142\f\u0010*\u001a\b\u0012\u0004\u0012\u00020_0c¢\u0006\u0004\bf\u0010eJ\u0017\u0010h\u001a\u00020\u00142\u0006\u0010g\u001a\u00020\u001aH\u0017¢\u0006\u0004\bh\u0010\u001dJ\u001b\u0010i\u001a\u00020\u00142\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001a0c¢\u0006\u0004\bi\u0010eJ\u001b\u0010j\u001a\u00020\u00142\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001a0c¢\u0006\u0004\bj\u0010eJ\u0017\u0010k\u001a\u00020\u00142\u0006\u0010E\u001a\u00020DH\u0015¢\u0006\u0004\bk\u0010lJ\u001b\u0010m\u001a\u00020\u00142\f\u0010*\u001a\b\u0012\u0004\u0012\u00020D0c¢\u0006\u0004\bm\u0010eJ\u001b\u0010n\u001a\u00020\u00142\f\u0010*\u001a\b\u0012\u0004\u0012\u00020D0c¢\u0006\u0004\bn\u0010eJ\u0017\u0010p\u001a\u00020\u00142\u0006\u0010o\u001a\u000201H\u0017¢\u0006\u0004\bp\u0010qJ\u001f\u0010p\u001a\u00020\u00142\u0006\u0010o\u001a\u0002012\u0006\u0010`\u001a\u00020_H\u0017¢\u0006\u0004\bp\u0010rJ\u001b\u0010t\u001a\u00020\u00142\f\u0010*\u001a\b\u0012\u0004\u0012\u00020s0c¢\u0006\u0004\bt\u0010eJ\u001b\u0010u\u001a\u00020\u00142\f\u0010*\u001a\b\u0012\u0004\u0012\u00020s0c¢\u0006\u0004\bu\u0010eJ\u0017\u0010w\u001a\u00020\u00142\u0006\u0010v\u001a\u000201H\u0017¢\u0006\u0004\bw\u0010qJ\u001f\u0010w\u001a\u00020\u00142\u0006\u0010v\u001a\u0002012\u0006\u0010`\u001a\u00020_H\u0017¢\u0006\u0004\bw\u0010rJ\u001b\u0010y\u001a\u00020\u00142\f\u0010*\u001a\b\u0012\u0004\u0012\u00020x0c¢\u0006\u0004\by\u0010eJ\u001b\u0010z\u001a\u00020\u00142\f\u0010*\u001a\b\u0012\u0004\u0012\u00020x0c¢\u0006\u0004\bz\u0010eJ\u000f\u0010{\u001a\u00020\u0014H\u0015¢\u0006\u0004\b{\u0010\u0011J\u0015\u0010}\u001a\u00020\u00142\u0006\u0010*\u001a\u00020|¢\u0006\u0004\b}\u0010~J\u0015\u0010\u007f\u001a\u00020\u00142\u0006\u0010*\u001a\u00020|¢\u0006\u0004\b\u007f\u0010~J\u0011\u0010\u0080\u0001\u001a\u00020\u0014H\u0016¢\u0006\u0005\b\u0080\u0001\u0010\u0011R\u0018\u0010\u0082\u0001\u001a\u00030\u0081\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0018\u0010\u0085\u0001\u001a\u00030\u0084\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001f\u0010\u0088\u0001\u001a\u00030\u0087\u00018\u0002X\u0082\u0004¢\u0006\u000f\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u0012\u0005\b\u008a\u0001\u0010\u0011R\u001c\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0018\u0010\u008f\u0001\u001a\u00030\u008e\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R!\u0010\u0096\u0001\u001a\u00030\u0091\u00018VX\u0096\u0084\u0002¢\u0006\u0010\n\u0006\b\u0092\u0001\u0010\u0093\u0001\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0018\u0010\u0097\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\u0097\u0001\u0010SR\u0018\u0010\u0099\u0001\u001a\u00030\u0098\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u001c\u0010\u009b\u0001\u001a\u00020W8\u0006¢\u0006\u0010\n\u0006\b\u009b\u0001\u0010\u009c\u0001\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R$\u0010 \u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020_0c0\u009f\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b \u0001\u0010¡\u0001R$\u0010¢\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0c0\u009f\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¢\u0001\u0010¡\u0001R$\u0010£\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0c0\u009f\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b£\u0001\u0010¡\u0001R$\u0010¤\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020s0c0\u009f\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¤\u0001\u0010¡\u0001R$\u0010¥\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020x0c0\u009f\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¥\u0001\u0010¡\u0001R\u001e\u0010¦\u0001\u001a\t\u0012\u0004\u0012\u00020|0\u009f\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¦\u0001\u0010¡\u0001R\u0019\u0010§\u0001\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R\u0019\u0010©\u0001\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0001\u0010¨\u0001R!\u0010®\u0001\u001a\u00030ª\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b«\u0001\u0010\u0093\u0001\u001a\u0006\b¬\u0001\u0010\u00ad\u0001R!\u0010³\u0001\u001a\u00030¯\u00018VX\u0096\u0084\u0002¢\u0006\u0010\n\u0006\b°\u0001\u0010\u0093\u0001\u001a\u0006\b±\u0001\u0010²\u0001R!\u0010¸\u0001\u001a\u00030´\u00018FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\bµ\u0001\u0010\u0093\u0001\u001a\u0006\b¶\u0001\u0010·\u0001R\u0018\u0010º\u0001\u001a\u0004\u0018\u00010\u00028WX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¹\u0001\u0010\u0018R\u0018\u0010¾\u0001\u001a\u00030»\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b¼\u0001\u0010½\u0001R\u0018\u0010Á\u0001\u001a\u00030\u008b\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b¿\u0001\u0010À\u0001R\u0018\u0010Å\u0001\u001a\u00030Â\u00018WX\u0096\u0004¢\u0006\b\u001a\u0006\bÃ\u0001\u0010Ä\u0001R\u0018\u0010É\u0001\u001a\u00030Æ\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bÇ\u0001\u0010È\u0001R\u0015\u0010Í\u0001\u001a\u00030Ê\u00018F¢\u0006\b\u001a\u0006\bË\u0001\u0010Ì\u0001¨\u0006Ò\u0001"}, d2 = {"Ltlydtdl/activity/ComponentActivity;", "Ltlydtdl/core/app/ComponentActivity;", HttpUrl.FRAGMENT_ENCODE_SET, "Ltlydtdl/lifecycle/g0;", "Ltlydtdl/lifecycle/w1;", "Ltlydtdl/lifecycle/q;", "Lcc/g;", "Lf/c0;", "Lkb/d;", "Li/j;", "Li/c;", "Lf6/d;", "Lf6/e;", "Ltlydtdl/core/app/p0;", "Ltlydtdl/core/app/q0;", "Lr6/l;", "<init>", "()V", "Lamuvvoafs/os/Bundle;", "outState", "Llx1/b0;", "onSaveInstanceState", "(Lamuvvoafs/os/Bundle;)V", "onRetainNonConfigurationInstance", "()Ljava/lang/Object;", "onRetainCustomNonConfigurationInstance", HttpUrl.FRAGMENT_ENCODE_SET, "layoutResID", "setContentView", "(I)V", "Lamuvvoafs/view/View;", "view", "(Lamuvvoafs/view/View;)V", "Lamuvvoafs/view/ViewGroup$LayoutParams;", "params", "(Lamuvvoafs/view/View;Lamuvvoafs/view/ViewGroup$LayoutParams;)V", "addContentView", "initializeViewTreeOwners", "Lamuvvoafs/content/Context;", "peekAvailableContext", "()Lamuvvoafs/content/Context;", "Lh/b;", "listener", "addOnContextAvailableListener", "(Lh/b;)V", "removeOnContextAvailableListener", "featureId", "Lamuvvoafs/view/Menu;", "menu", HttpUrl.FRAGMENT_ENCODE_SET, "onPreparePanel", "(ILamuvvoafs/view/View;Lamuvvoafs/view/Menu;)Z", "onCreatePanelMenu", "(ILamuvvoafs/view/Menu;)Z", "onPanelClosed", "(ILamuvvoafs/view/Menu;)V", "Lr6/p;", "provider", "addMenuProvider", "(Lr6/p;)V", "owner", "(Lr6/p;Ltlydtdl/lifecycle/g0;)V", "Ltlydtdl/lifecycle/y;", "state", "(Lr6/p;Ltlydtdl/lifecycle/g0;Ltlydtdl/lifecycle/y;)V", "removeMenuProvider", "invalidateMenu", "onBackPressed", "Lamuvvoafs/content/Intent;", "intent", "requestCode", "startActivityForResult", "(Lamuvvoafs/content/Intent;I)V", "options", "(Lamuvvoafs/content/Intent;ILamuvvoafs/os/Bundle;)V", "Lamuvvoafs/content/IntentSender;", "fillInIntent", "flagsMask", "flagsValues", "extraFlags", "startIntentSenderForResult", "(Lamuvvoafs/content/IntentSender;ILamuvvoafs/content/Intent;III)V", "(Lamuvvoafs/content/IntentSender;ILamuvvoafs/content/Intent;IIILamuvvoafs/os/Bundle;)V", "I", "O", "Lj/a;", "contract", "Li/i;", "registry", "Li/b;", "callback", "Li/d;", "registerForActivityResult", "(Lj/a;Li/i;Li/b;)Li/d;", "(Lj/a;Li/b;)Li/d;", "Lamuvvoafs/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Lamuvvoafs/content/res/Configuration;)V", "Lq6/a;", "addOnConfigurationChangedListener", "(Lq6/a;)V", "removeOnConfigurationChangedListener", "level", "onTrimMemory", "addOnTrimMemoryListener", "removeOnTrimMemoryListener", "onNewIntent", "(Lamuvvoafs/content/Intent;)V", "addOnNewIntentListener", "removeOnNewIntentListener", "isInMultiWindowMode", "onMultiWindowModeChanged", "(Z)V", "(ZLamuvvoafs/content/res/Configuration;)V", "Ltlydtdl/core/app/g;", "addOnMultiWindowModeChangedListener", "removeOnMultiWindowModeChangedListener", "isInPictureInPictureMode", "onPictureInPictureModeChanged", "Ltlydtdl/core/app/s0;", "addOnPictureInPictureModeChangedListener", "removeOnPictureInPictureModeChangedListener", "onUserLeaveHint", "Ljava/lang/Runnable;", "addOnUserLeaveHintListener", "(Ljava/lang/Runnable;)V", "removeOnUserLeaveHintListener", "reportFullyDrawn", "Lh/a;", "contextAwareHelper", "Lh/a;", "Lr6/o;", "menuHostHelper", "Lr6/o;", "Lcc/f;", "savedStateRegistryController", "Lcc/f;", "getSavedStateRegistryController$annotations", "Ltlydtdl/lifecycle/v1;", "_viewModelStore", "Ltlydtdl/lifecycle/v1;", "Lf/j;", "reportFullyDrawnExecutor", "Lf/j;", "Lf/u;", "fullyDrawnReporter$delegate", "Llx1/h;", "getFullyDrawnReporter", "()Lf/u;", "fullyDrawnReporter", "contentLayoutId", "Ljava/util/concurrent/atomic/AtomicInteger;", "nextLocalRequestCode", "Ljava/util/concurrent/atomic/AtomicInteger;", "activityResultRegistry", "Li/i;", "getActivityResultRegistry", "()Li/i;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "onConfigurationChangedListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "onTrimMemoryListeners", "onNewIntentListeners", "onMultiWindowModeChangedListeners", "onPictureInPictureModeChangedListeners", "onUserLeaveHintListeners", "dispatchingOnMultiWindowModeChanged", "Z", "dispatchingOnPictureInPictureModeChanged", "Lkb/a;", "onBackPressedInput$delegate", "getOnBackPressedInput", "()Lkb/a;", "onBackPressedInput", "Ltlydtdl/lifecycle/r1;", "defaultViewModelProviderFactory$delegate", "getDefaultViewModelProviderFactory", "()Ltlydtdl/lifecycle/r1;", "defaultViewModelProviderFactory", "Lf/a0;", "onBackPressedDispatcher$delegate", "getOnBackPressedDispatcher", "()Lf/a0;", "onBackPressedDispatcher", "getLastCustomNonConfigurationInstance", "lastCustomNonConfigurationInstance", "Ltlydtdl/lifecycle/z;", "getLifecycle", "()Ltlydtdl/lifecycle/z;", "lifecycle", "getViewModelStore", "()Ltlydtdl/lifecycle/v1;", "viewModelStore", "Lb8/c;", "getDefaultViewModelCreationExtras", "()Lb8/c;", "defaultViewModelCreationExtras", "Lkb/c;", "getNavigationEventDispatcher", "()Lkb/c;", "navigationEventDispatcher", "Lcc/e;", "getSavedStateRegistry", "()Lcc/e;", "savedStateRegistry", "Companion", "f/i", "f/k", "f/h", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
public class ComponentActivity extends tlydtdl.core.app.ComponentActivity implements w1, q, g, c0, d, j, c, f6.d, e, p0, q0, l {
    private static final String ACTIVITY_RESULT_TAG = "amuvvoafs:support:activity-result";
    private static final h Companion = new h();
    public static final /* synthetic */ int a = 0;
    private v1 _viewModelStore;
    private final i activityResultRegistry;
    private int contentLayoutId;
    private final lx1.h defaultViewModelProviderFactory$delegate;
    private boolean dispatchingOnMultiWindowModeChanged;
    private boolean dispatchingOnPictureInPictureModeChanged;
    private final lx1.h fullyDrawnReporter$delegate;
    private final AtomicInteger nextLocalRequestCode;
    private final lx1.h onBackPressedDispatcher$delegate;
    private final lx1.h onBackPressedInput$delegate;
    private final CopyOnWriteArrayList<a> onConfigurationChangedListeners;
    private final CopyOnWriteArrayList<a> onMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<a> onNewIntentListeners;
    private final CopyOnWriteArrayList<a> onPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<a> onTrimMemoryListeners;
    private final CopyOnWriteArrayList<Runnable> onUserLeaveHintListeners;
    private final f.j reportFullyDrawnExecutor;
    private final f savedStateRegistryController;
    private final h.a contextAwareHelper = new h.a();
    private final o menuHostHelper = new o(new b(this, 0));

    public ComponentActivity() {
        ec.b bVar = new ec.b(this, new n3(8, this));
        this.savedStateRegistryController = new f(bVar);
        this.reportFullyDrawnExecutor = new k(this);
        final int i = 0;
        this.fullyDrawnReporter$delegate = hs1.d.F(new Function0(this) { // from class: f.d
            public final /* synthetic */ ComponentActivity b;

            {
                this.b = this;
            }

            public final Object invoke() {
                int i2 = i;
                ComponentActivity componentActivity = this.b;
                switch (i2) {
                    case 0:
                        return ComponentActivity.i(componentActivity);
                    case 1:
                        int i3 = ComponentActivity.a;
                        kb.a aVar = new kb.a();
                        componentActivity.getNavigationEventDispatcher().b(aVar);
                        return aVar;
                    case 2:
                        int i4 = ComponentActivity.a;
                        return new l1(componentActivity.getApplication(), componentActivity, componentActivity.getIntent() != null ? componentActivity.getIntent().getExtras() : null);
                    case 3:
                        int i6 = ComponentActivity.a;
                        a0 a0Var = new a0(new b(componentActivity, 1));
                        if (Build.VERSION.SDK_INT >= 33) {
                            if (lmjxuqdtp.jvm.internal.o.c(Looper.myLooper(), Looper.getMainLooper())) {
                                componentActivity.getLifecycle().a(new c(a0Var, componentActivity));
                            } else {
                                new Handler(Looper.getMainLooper()).post(new cn1.k(9, componentActivity, a0Var));
                            }
                        }
                        return a0Var;
                    default:
                        return componentActivity;
                }
            }
        });
        this.nextLocalRequestCode = new AtomicInteger();
        this.activityResultRegistry = new f.l(this);
        this.onConfigurationChangedListeners = new CopyOnWriteArrayList<>();
        this.onTrimMemoryListeners = new CopyOnWriteArrayList<>();
        this.onNewIntentListeners = new CopyOnWriteArrayList<>();
        this.onMultiWindowModeChangedListeners = new CopyOnWriteArrayList<>();
        this.onPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<>();
        this.onUserLeaveHintListeners = new CopyOnWriteArrayList<>();
        final int i2 = 1;
        this.onBackPressedInput$delegate = hs1.d.F(new Function0(this) { // from class: f.d
            public final /* synthetic */ ComponentActivity b;

            {
                this.b = this;
            }

            public final Object invoke() {
                int i22 = i2;
                ComponentActivity componentActivity = this.b;
                switch (i22) {
                    case 0:
                        return ComponentActivity.i(componentActivity);
                    case 1:
                        int i3 = ComponentActivity.a;
                        kb.a aVar = new kb.a();
                        componentActivity.getNavigationEventDispatcher().b(aVar);
                        return aVar;
                    case 2:
                        int i4 = ComponentActivity.a;
                        return new l1(componentActivity.getApplication(), componentActivity, componentActivity.getIntent() != null ? componentActivity.getIntent().getExtras() : null);
                    case 3:
                        int i6 = ComponentActivity.a;
                        a0 a0Var = new a0(new b(componentActivity, 1));
                        if (Build.VERSION.SDK_INT >= 33) {
                            if (lmjxuqdtp.jvm.internal.o.c(Looper.myLooper(), Looper.getMainLooper())) {
                                componentActivity.getLifecycle().a(new c(a0Var, componentActivity));
                            } else {
                                new Handler(Looper.getMainLooper()).post(new cn1.k(9, componentActivity, a0Var));
                            }
                        }
                        return a0Var;
                    default:
                        return componentActivity;
                }
            }
        });
        if (getLifecycle() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        final int i3 = 0;
        getLifecycle().a(new e0(this) { // from class: f.e
            public final /* synthetic */ ComponentActivity b;

            {
                this.b = this;
            }

            @Override // tlydtdl.lifecycle.e0
            public final void onStateChanged(g0 g0Var, tlydtdl.lifecycle.x xVar) {
                Window window;
                View viewPeekDecorView;
                int i4 = i3;
                ComponentActivity componentActivity = this.b;
                switch (i4) {
                    case 0:
                        int i6 = ComponentActivity.a;
                        if (xVar == tlydtdl.lifecycle.x.ON_STOP && (window = componentActivity.getWindow()) != null && (viewPeekDecorView = window.peekDecorView()) != null) {
                            viewPeekDecorView.cancelPendingInputEvents();
                            break;
                        }
                        break;
                    default:
                        ComponentActivity.j(componentActivity, g0Var, xVar);
                        break;
                }
            }
        });
        final int i4 = 1;
        getLifecycle().a(new e0(this) { // from class: f.e
            public final /* synthetic */ ComponentActivity b;

            {
                this.b = this;
            }

            @Override // tlydtdl.lifecycle.e0
            public final void onStateChanged(g0 g0Var, tlydtdl.lifecycle.x xVar) {
                Window window;
                View viewPeekDecorView;
                int i42 = i4;
                ComponentActivity componentActivity = this.b;
                switch (i42) {
                    case 0:
                        int i6 = ComponentActivity.a;
                        if (xVar == tlydtdl.lifecycle.x.ON_STOP && (window = componentActivity.getWindow()) != null && (viewPeekDecorView = window.peekDecorView()) != null) {
                            viewPeekDecorView.cancelPendingInputEvents();
                            break;
                        }
                        break;
                    default:
                        ComponentActivity.j(componentActivity, g0Var, xVar);
                        break;
                }
            }
        });
        getLifecycle().a(new cc.b(this, 1));
        bVar.a();
        i1.b(this);
        final int i6 = 0;
        getSavedStateRegistry().c(ACTIVITY_RESULT_TAG, new cc.d() { // from class: f.f
            public final Bundle b() {
                switch (i6) {
                    case 0:
                        return ComponentActivity.c((ComponentActivity) this);
                    default:
                        Map mapE = ((r3.h) this).e();
                        Bundle bundle = new Bundle();
                        for (Map.Entry entry : mapE.entrySet()) {
                            String str = (String) entry.getKey();
                            List list = (List) entry.getValue();
                            bundle.putParcelableArrayList(str, list instanceof ArrayList ? (ArrayList) list : new ArrayList(list));
                        }
                        return bundle;
                }
            }
        });
        addOnContextAvailableListener(new h.b() { // from class: f.g
            public final void a(ComponentActivity componentActivity) {
                ComponentActivity.f(this.a, componentActivity);
            }
        });
        final int i7 = 2;
        this.defaultViewModelProviderFactory$delegate = hs1.d.F(new Function0(this) { // from class: f.d
            public final /* synthetic */ ComponentActivity b;

            {
                this.b = this;
            }

            public final Object invoke() {
                int i22 = i7;
                ComponentActivity componentActivity = this.b;
                switch (i22) {
                    case 0:
                        return ComponentActivity.i(componentActivity);
                    case 1:
                        int i32 = ComponentActivity.a;
                        kb.a aVar = new kb.a();
                        componentActivity.getNavigationEventDispatcher().b(aVar);
                        return aVar;
                    case 2:
                        int i42 = ComponentActivity.a;
                        return new l1(componentActivity.getApplication(), componentActivity, componentActivity.getIntent() != null ? componentActivity.getIntent().getExtras() : null);
                    case 3:
                        int i62 = ComponentActivity.a;
                        a0 a0Var = new a0(new b(componentActivity, 1));
                        if (Build.VERSION.SDK_INT >= 33) {
                            if (lmjxuqdtp.jvm.internal.o.c(Looper.myLooper(), Looper.getMainLooper())) {
                                componentActivity.getLifecycle().a(new c(a0Var, componentActivity));
                            } else {
                                new Handler(Looper.getMainLooper()).post(new cn1.k(9, componentActivity, a0Var));
                            }
                        }
                        return a0Var;
                    default:
                        return componentActivity;
                }
            }
        });
        final int i8 = 3;
        this.onBackPressedDispatcher$delegate = hs1.d.F(new Function0(this) { // from class: f.d
            public final /* synthetic */ ComponentActivity b;

            {
                this.b = this;
            }

            public final Object invoke() {
                int i22 = i8;
                ComponentActivity componentActivity = this.b;
                switch (i22) {
                    case 0:
                        return ComponentActivity.i(componentActivity);
                    case 1:
                        int i32 = ComponentActivity.a;
                        kb.a aVar = new kb.a();
                        componentActivity.getNavigationEventDispatcher().b(aVar);
                        return aVar;
                    case 2:
                        int i42 = ComponentActivity.a;
                        return new l1(componentActivity.getApplication(), componentActivity, componentActivity.getIntent() != null ? componentActivity.getIntent().getExtras() : null);
                    case 3:
                        int i62 = ComponentActivity.a;
                        a0 a0Var = new a0(new b(componentActivity, 1));
                        if (Build.VERSION.SDK_INT >= 33) {
                            if (lmjxuqdtp.jvm.internal.o.c(Looper.myLooper(), Looper.getMainLooper())) {
                                componentActivity.getLifecycle().a(new c(a0Var, componentActivity));
                            } else {
                                new Handler(Looper.getMainLooper()).post(new cn1.k(9, componentActivity, a0Var));
                            }
                        }
                        return a0Var;
                    default:
                        return componentActivity;
                }
            }
        });
    }

    public static final void access$ensureViewModelStore(ComponentActivity componentActivity) {
        if (componentActivity._viewModelStore == null) {
            f.i iVar = (f.i) componentActivity.getLastNonConfigurationInstance();
            if (iVar != null) {
                componentActivity._viewModelStore = iVar.b;
            }
            if (componentActivity._viewModelStore == null) {
                componentActivity._viewModelStore = new v1();
            }
        }
    }

    public static Bundle c(ComponentActivity componentActivity) {
        Bundle bundle = new Bundle();
        i iVar = componentActivity.activityResultRegistry;
        iVar.getClass();
        LinkedHashMap linkedHashMap = iVar.b;
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList(linkedHashMap.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList(linkedHashMap.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList(iVar.d));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", new Bundle(iVar.g));
        return bundle;
    }

    public static void f(ComponentActivity componentActivity, Context context) {
        lmjxuqdtp.jvm.internal.o.h(context, "it");
        Bundle bundleA = componentActivity.getSavedStateRegistry().a(ACTIVITY_RESULT_TAG);
        if (bundleA != null) {
            i iVar = componentActivity.activityResultRegistry;
            LinkedHashMap linkedHashMap = iVar.b;
            LinkedHashMap linkedHashMap2 = iVar.a;
            Bundle bundle = iVar.g;
            ArrayList integerArrayList = bundleA.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
            ArrayList stringArrayList = bundleA.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            if (stringArrayList == null || integerArrayList == null) {
                return;
            }
            ArrayList stringArrayList2 = bundleA.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
            if (stringArrayList2 != null) {
                iVar.d.addAll(stringArrayList2);
            }
            Bundle bundle2 = bundleA.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
            if (bundle2 != null) {
                bundle.putAll(bundle2);
            }
            int size = stringArrayList.size();
            for (int i = 0; i < size; i++) {
                String str = (String) stringArrayList.get(i);
                if (linkedHashMap.containsKey(str)) {
                    Integer num = (Integer) linkedHashMap.remove(str);
                    if (!bundle.containsKey(str)) {
                        lmjxuqdtp.jvm.internal.g0.c(linkedHashMap2).remove(num);
                    }
                }
                Object obj = integerArrayList.get(i);
                lmjxuqdtp.jvm.internal.o.g(obj, "get(...)");
                int iIntValue = ((Number) obj).intValue();
                Object obj2 = stringArrayList.get(i);
                lmjxuqdtp.jvm.internal.o.g(obj2, "get(...)");
                String str2 = (String) obj2;
                linkedHashMap2.put(Integer.valueOf(iIntValue), str2);
                iVar.b.put(str2, Integer.valueOf(iIntValue));
            }
        }
    }

    public static void g(a0 a0Var, ComponentActivity componentActivity, g0 g0Var, x xVar) {
        if (xVar == x.ON_CREATE) {
            OnBackInvokedDispatcher onBackInvokedDispatcher = componentActivity.getOnBackInvokedDispatcher();
            lmjxuqdtp.jvm.internal.o.g(onBackInvokedDispatcher, "getOnBackInvokedDispatcher(...)");
            a0Var.c(onBackInvokedDispatcher);
        }
    }

    public static void h(ComponentActivity componentActivity) {
        try {
            super.onBackPressed();
        } catch (IllegalStateException e) {
            if (!lmjxuqdtp.jvm.internal.o.c(e.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                throw e;
            }
        } catch (NullPointerException e2) {
            if (!lmjxuqdtp.jvm.internal.o.c(e2.getMessage(), "Attempt to invoke virtual method 'amuvvoafs.os.Handler amuvvoafs.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                throw e2;
            }
        }
    }

    public static u i(ComponentActivity componentActivity) {
        return new u(componentActivity.reportFullyDrawnExecutor, new dx1.e(16, componentActivity));
    }

    public static void j(ComponentActivity componentActivity, g0 g0Var, x xVar) {
        if (xVar == x.ON_DESTROY) {
            componentActivity.contextAwareHelper.b = null;
            if (!componentActivity.isChangingConfigurations()) {
                componentActivity.getViewModelStore().a();
            }
            k kVar = (k) componentActivity.reportFullyDrawnExecutor;
            ComponentActivity componentActivity2 = kVar.d;
            componentActivity2.getWindow().getDecorView().removeCallbacks(kVar);
            componentActivity2.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(kVar);
        }
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        f.j jVar = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        lmjxuqdtp.jvm.internal.o.g(decorView, "getDecorView(...)");
        ((k) jVar).a(decorView);
        super.addContentView(view, layoutParams);
    }

    @Override // r6.l
    public void addMenuProvider(p pVar) {
        lmjxuqdtp.jvm.internal.o.h(pVar, "provider");
        o oVar = this.menuHostHelper;
        oVar.b.add(pVar);
        oVar.a.run();
    }

    @Override // f6.d
    public final void addOnConfigurationChangedListener(a aVar) {
        lmjxuqdtp.jvm.internal.o.h(aVar, "listener");
        this.onConfigurationChangedListeners.add(aVar);
    }

    public final void addOnContextAvailableListener(h.b bVar) {
        lmjxuqdtp.jvm.internal.o.h(bVar, "listener");
        h.a aVar = this.contextAwareHelper;
        aVar.getClass();
        ComponentActivity componentActivity = aVar.b;
        if (componentActivity != null) {
            bVar.a(componentActivity);
        }
        aVar.a.add(bVar);
    }

    @Override // tlydtdl.core.app.p0
    public final void addOnMultiWindowModeChangedListener(a aVar) {
        lmjxuqdtp.jvm.internal.o.h(aVar, "listener");
        this.onMultiWindowModeChangedListeners.add(aVar);
    }

    public final void addOnNewIntentListener(a aVar) {
        lmjxuqdtp.jvm.internal.o.h(aVar, "listener");
        this.onNewIntentListeners.add(aVar);
    }

    @Override // tlydtdl.core.app.q0
    public final void addOnPictureInPictureModeChangedListener(a aVar) {
        lmjxuqdtp.jvm.internal.o.h(aVar, "listener");
        this.onPictureInPictureModeChangedListeners.add(aVar);
    }

    @Override // f6.e
    public final void addOnTrimMemoryListener(a aVar) {
        lmjxuqdtp.jvm.internal.o.h(aVar, "listener");
        this.onTrimMemoryListeners.add(aVar);
    }

    public final void addOnUserLeaveHintListener(Runnable runnable) {
        lmjxuqdtp.jvm.internal.o.h(runnable, "listener");
        this.onUserLeaveHintListeners.add(runnable);
    }

    public final i getActivityResultRegistry() {
        return this.activityResultRegistry;
    }

    @Override // tlydtdl.lifecycle.q
    public b8.c getDefaultViewModelCreationExtras() {
        b8.f fVar = new b8.f(0);
        Application application = getApplication();
        LinkedHashMap linkedHashMap = fVar.a;
        if (application != null) {
            linkedHashMap.put(q1.d, getApplication());
        }
        linkedHashMap.put(i1.a, this);
        linkedHashMap.put(i1.b, this);
        Intent intent = getIntent();
        Bundle extras = intent != null ? intent.getExtras() : null;
        if (extras != null) {
            linkedHashMap.put(i1.c, extras);
        }
        return fVar;
    }

    @Override // tlydtdl.lifecycle.q
    public r1 getDefaultViewModelProviderFactory() {
        return (r1) this.defaultViewModelProviderFactory$delegate.getValue();
    }

    public u getFullyDrawnReporter() {
        return (u) this.fullyDrawnReporter$delegate.getValue();
    }

    @lx1.c
    public Object getLastCustomNonConfigurationInstance() {
        f.i iVar = (f.i) getLastNonConfigurationInstance();
        if (iVar != null) {
            return iVar.a;
        }
        return null;
    }

    @Override // tlydtdl.core.app.ComponentActivity, tlydtdl.lifecycle.g0
    public z getLifecycle() {
        return super.getLifecycle();
    }

    @Override // kb.d
    public kb.c getNavigationEventDispatcher() {
        return getOnBackPressedDispatcher().b;
    }

    @Override // f.c0
    public final a0 getOnBackPressedDispatcher() {
        return (a0) this.onBackPressedDispatcher$delegate.getValue();
    }

    public final cc.e getSavedStateRegistry() {
        return this.savedStateRegistryController.b;
    }

    @Override // tlydtdl.lifecycle.w1
    public v1 getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this._viewModelStore == null) {
            f.i iVar = (f.i) getLastNonConfigurationInstance();
            if (iVar != null) {
                this._viewModelStore = iVar.b;
            }
            if (this._viewModelStore == null) {
                this._viewModelStore = new v1();
            }
        }
        v1 v1Var = this._viewModelStore;
        lmjxuqdtp.jvm.internal.o.e(v1Var);
        return v1Var;
    }

    public void initializeViewTreeOwners() {
        View decorView = getWindow().getDecorView();
        lmjxuqdtp.jvm.internal.o.g(decorView, "getDecorView(...)");
        i1.j(decorView, this);
        View decorView2 = getWindow().getDecorView();
        lmjxuqdtp.jvm.internal.o.g(decorView2, "getDecorView(...)");
        i1.k(decorView2, this);
        View decorView3 = getWindow().getDecorView();
        lmjxuqdtp.jvm.internal.o.g(decorView3, "getDecorView(...)");
        r.n0(decorView3, this);
        View decorView4 = getWindow().getDecorView();
        lmjxuqdtp.jvm.internal.o.g(decorView4, "getDecorView(...)");
        decorView4.setTag(2131428735, this);
        View decorView5 = getWindow().getDecorView();
        lmjxuqdtp.jvm.internal.o.g(decorView5, "getDecorView(...)");
        decorView5.setTag(2131428426, this);
        View decorView6 = getWindow().getDecorView();
        lmjxuqdtp.jvm.internal.o.g(decorView6, "getDecorView(...)");
        decorView6.setTag(2131428734, this);
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.activityResultRegistry.a(i, i2, intent)) {
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    @lx1.c
    public void onBackPressed() {
        ((kb.a) this.onBackPressedInput$delegate.getValue()).a();
    }

    public void onConfigurationChanged(Configuration configuration) {
        lmjxuqdtp.jvm.internal.o.h(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        Iterator<a> it = this.onConfigurationChangedListeners.iterator();
        lmjxuqdtp.jvm.internal.o.g(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(configuration);
        }
    }

    @Override // tlydtdl.core.app.ComponentActivity
    public void onCreate(Bundle bundle) {
        this.savedStateRegistryController.a(bundle);
        h.a aVar = this.contextAwareHelper;
        aVar.getClass();
        aVar.b = this;
        Iterator it = aVar.a.iterator();
        while (it.hasNext()) {
            ((h.b) it.next()).a(this);
        }
        super.onCreate(bundle);
        int i = d1.b;
        b1.b(this);
        int i2 = this.contentLayoutId;
        if (i2 != 0) {
            setContentView(i2);
        }
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        lmjxuqdtp.jvm.internal.o.h(menu, "menu");
        if (i != 0) {
            return true;
        }
        super.onCreatePanelMenu(i, menu);
        o oVar = this.menuHostHelper;
        MenuInflater menuInflater = getMenuInflater();
        Iterator it = oVar.b.iterator();
        while (it.hasNext()) {
            ((z0) ((p) it.next())).a.l(menu, menuInflater);
        }
        return true;
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        lmjxuqdtp.jvm.internal.o.h(menuItem, "item");
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.menuHostHelper.a(menuItem);
        }
        return false;
    }

    @lx1.c
    public void onMultiWindowModeChanged(boolean z) {
        if (this.dispatchingOnMultiWindowModeChanged) {
            return;
        }
        Iterator<a> it = this.onMultiWindowModeChangedListeners.iterator();
        lmjxuqdtp.jvm.internal.o.g(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(new tlydtdl.core.app.g(z));
        }
    }

    public void onNewIntent(Intent intent) {
        lmjxuqdtp.jvm.internal.o.h(intent, "intent");
        super.onNewIntent(intent);
        Iterator<a> it = this.onNewIntentListeners.iterator();
        lmjxuqdtp.jvm.internal.o.g(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    public void onPanelClosed(int i, Menu menu) {
        lmjxuqdtp.jvm.internal.o.h(menu, "menu");
        Iterator it = this.menuHostHelper.b.iterator();
        while (it.hasNext()) {
            ((z0) ((p) it.next())).a.r(menu);
        }
        super.onPanelClosed(i, menu);
    }

    @lx1.c
    public void onPictureInPictureModeChanged(boolean z) {
        if (this.dispatchingOnPictureInPictureModeChanged) {
            return;
        }
        Iterator<a> it = this.onPictureInPictureModeChangedListeners.iterator();
        lmjxuqdtp.jvm.internal.o.g(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(new s0(z));
        }
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        lmjxuqdtp.jvm.internal.o.h(menu, "menu");
        if (i != 0) {
            return true;
        }
        super.onPreparePanel(i, view, menu);
        Iterator it = this.menuHostHelper.b.iterator();
        while (it.hasNext()) {
            ((z0) ((p) it.next())).a.u(menu);
        }
        return true;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        lmjxuqdtp.jvm.internal.o.h(strArr, "permissions");
        lmjxuqdtp.jvm.internal.o.h(iArr, "grantResults");
        if (this.activityResultRegistry.a(i, -1, new Intent().putExtra("tlydtdl.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("tlydtdl.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            return;
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @lx1.c
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public final Object onRetainNonConfigurationInstance() {
        f.i iVar;
        Object objOnRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        v1 v1Var = this._viewModelStore;
        if (v1Var == null && (iVar = (f.i) getLastNonConfigurationInstance()) != null) {
            v1Var = iVar.b;
        }
        if (v1Var == null && objOnRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        f.i iVar2 = new f.i();
        iVar2.a = objOnRetainCustomNonConfigurationInstance;
        iVar2.b = v1Var;
        return iVar2;
    }

    @Override // tlydtdl.core.app.ComponentActivity
    public void onSaveInstanceState(Bundle bundle) {
        lmjxuqdtp.jvm.internal.o.h(bundle, "outState");
        if (getLifecycle() instanceof i0) {
            z lifecycle = getLifecycle();
            lmjxuqdtp.jvm.internal.o.f(lifecycle, "null cannot be cast to non-null type tlydtdl.lifecycle.LifecycleRegistry");
            ((i0) lifecycle).i(y.c);
        }
        super.onSaveInstanceState(bundle);
        this.savedStateRegistryController.b(bundle);
    }

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        Iterator<a> it = this.onTrimMemoryListeners.iterator();
        lmjxuqdtp.jvm.internal.o.g(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(Integer.valueOf(i));
        }
    }

    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        Iterator<Runnable> it = this.onUserLeaveHintListeners.iterator();
        lmjxuqdtp.jvm.internal.o.g(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().run();
        }
    }

    public Context peekAvailableContext() {
        return this.contextAwareHelper.b;
    }

    public final <I, O> i.d registerForActivityResult(j.a aVar, i iVar, i.b bVar) {
        lmjxuqdtp.jvm.internal.o.h(aVar, "contract");
        lmjxuqdtp.jvm.internal.o.h(iVar, "registry");
        lmjxuqdtp.jvm.internal.o.h(bVar, "callback");
        return iVar.c("activity_rq#" + this.nextLocalRequestCode.getAndIncrement(), this, aVar, bVar);
    }

    @Override // r6.l
    public void removeMenuProvider(p pVar) {
        lmjxuqdtp.jvm.internal.o.h(pVar, "provider");
        this.menuHostHelper.b(pVar);
    }

    @Override // f6.d
    public final void removeOnConfigurationChangedListener(a aVar) {
        lmjxuqdtp.jvm.internal.o.h(aVar, "listener");
        this.onConfigurationChangedListeners.remove(aVar);
    }

    public final void removeOnContextAvailableListener(h.b bVar) {
        lmjxuqdtp.jvm.internal.o.h(bVar, "listener");
        h.a aVar = this.contextAwareHelper;
        aVar.getClass();
        aVar.a.remove(bVar);
    }

    @Override // tlydtdl.core.app.p0
    public final void removeOnMultiWindowModeChangedListener(a aVar) {
        lmjxuqdtp.jvm.internal.o.h(aVar, "listener");
        this.onMultiWindowModeChangedListeners.remove(aVar);
    }

    public final void removeOnNewIntentListener(a aVar) {
        lmjxuqdtp.jvm.internal.o.h(aVar, "listener");
        this.onNewIntentListeners.remove(aVar);
    }

    @Override // tlydtdl.core.app.q0
    public final void removeOnPictureInPictureModeChangedListener(a aVar) {
        lmjxuqdtp.jvm.internal.o.h(aVar, "listener");
        this.onPictureInPictureModeChangedListeners.remove(aVar);
    }

    @Override // f6.e
    public final void removeOnTrimMemoryListener(a aVar) {
        lmjxuqdtp.jvm.internal.o.h(aVar, "listener");
        this.onTrimMemoryListeners.remove(aVar);
    }

    public final void removeOnUserLeaveHintListener(Runnable runnable) {
        lmjxuqdtp.jvm.internal.o.h(runnable, "listener");
        this.onUserLeaveHintListeners.remove(runnable);
    }

    public void reportFullyDrawn() {
        try {
            if (com.facebook.appevents.h.s()) {
                Trace.beginSection(com.facebook.appevents.h.R("reportFullyDrawn() for ComponentActivity"));
            }
            super.reportFullyDrawn();
            getFullyDrawnReporter().a();
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public void setContentView(int i) {
        initializeViewTreeOwners();
        f.j jVar = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        lmjxuqdtp.jvm.internal.o.g(decorView, "getDecorView(...)");
        ((k) jVar).a(decorView);
        super.setContentView(i);
    }

    @lx1.c
    public void startActivityForResult(Intent intent, int i) {
        lmjxuqdtp.jvm.internal.o.h(intent, "intent");
        super.startActivityForResult(intent, i);
    }

    @lx1.c
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        lmjxuqdtp.jvm.internal.o.h(intentSender, "intent");
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @lx1.c
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        lmjxuqdtp.jvm.internal.o.h(intent, "intent");
        super.startActivityForResult(intent, i, bundle);
    }

    @lx1.c
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        lmjxuqdtp.jvm.internal.o.h(intentSender, "intent");
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    public final <I, O> i.d registerForActivityResult(j.a aVar, i.b bVar) {
        lmjxuqdtp.jvm.internal.o.h(aVar, "contract");
        lmjxuqdtp.jvm.internal.o.h(bVar, "callback");
        return registerForActivityResult(aVar, this.activityResultRegistry, bVar);
    }

    public void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        lmjxuqdtp.jvm.internal.o.h(configuration, "newConfig");
        this.dispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z, configuration);
            this.dispatchingOnMultiWindowModeChanged = false;
            Iterator<a> it = this.onMultiWindowModeChangedListeners.iterator();
            lmjxuqdtp.jvm.internal.o.g(it, "iterator(...)");
            while (it.hasNext()) {
                it.next().accept(new tlydtdl.core.app.g(z, configuration));
            }
        } catch (Throwable th) {
            this.dispatchingOnMultiWindowModeChanged = false;
            throw th;
        }
    }

    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        lmjxuqdtp.jvm.internal.o.h(configuration, "newConfig");
        this.dispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z, configuration);
            this.dispatchingOnPictureInPictureModeChanged = false;
            Iterator<a> it = this.onPictureInPictureModeChangedListeners.iterator();
            lmjxuqdtp.jvm.internal.o.g(it, "iterator(...)");
            while (it.hasNext()) {
                it.next().accept(new s0(z, configuration));
            }
        } catch (Throwable th) {
            this.dispatchingOnPictureInPictureModeChanged = false;
            throw th;
        }
    }

    public void setContentView(View view) {
        initializeViewTreeOwners();
        f.j jVar = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        lmjxuqdtp.jvm.internal.o.g(decorView, "getDecorView(...)");
        ((k) jVar).a(decorView);
        super.setContentView(view);
    }

    public void addMenuProvider(p pVar, g0 g0Var) {
        lmjxuqdtp.jvm.internal.o.h(pVar, "provider");
        lmjxuqdtp.jvm.internal.o.h(g0Var, "owner");
        o oVar = this.menuHostHelper;
        oVar.b.add(pVar);
        oVar.a.run();
        z lifecycle = g0Var.getLifecycle();
        HashMap map = oVar.c;
        n nVar = (n) map.remove(pVar);
        if (nVar != null) {
            nVar.a.d(nVar.b);
            nVar.b = null;
        }
        map.put(pVar, new n(lifecycle, new r6.m(oVar, pVar)));
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        f.j jVar = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        lmjxuqdtp.jvm.internal.o.g(decorView, "getDecorView(...)");
        ((k) jVar).a(decorView);
        super.setContentView(view, layoutParams);
    }

    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(p pVar, g0 g0Var, y yVar) {
        lmjxuqdtp.jvm.internal.o.h(pVar, "provider");
        lmjxuqdtp.jvm.internal.o.h(g0Var, "owner");
        lmjxuqdtp.jvm.internal.o.h(yVar, "state");
        o oVar = this.menuHostHelper;
        oVar.getClass();
        z lifecycle = g0Var.getLifecycle();
        HashMap map = oVar.c;
        n nVar = (n) map.remove(pVar);
        if (nVar != null) {
            nVar.a.d(nVar.b);
            nVar.b = null;
        }
        map.put(pVar, new n(lifecycle, new nl1.b(oVar, yVar, pVar, 1)));
    }
}
