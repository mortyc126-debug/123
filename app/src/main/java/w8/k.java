package w8;

import amuvvoafs.content.Context;
import amuvvoafs.os.Handler;
import amuvvoafs.os.Looper;
import aq1.c;
import java.util.ArrayList;
import l9.g;
import qu0.u;
import tlydtdl.media3.decoder.mpeghaudio.MpeghAudioRenderer;
import y8.c0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements n1 {
    public final Context a;
    public final c b;
    public int c = 0;
    public boolean d;

    public k(Context context) {
        this.a = context;
        this.b = new c(context, (byte) 0);
    }

    @Override // w8.n1
    public final void a(e eVar) {
        eVar.getTrackType();
    }

    @Override // w8.n1
    public final e[] b(Handler handler, a0 a0Var, a0 a0Var2, a0 a0Var3, a0 a0Var4) {
        c9.k kVar;
        int i;
        int i2;
        int i3;
        int i4;
        int i6;
        int i7;
        int i8;
        int i9;
        ArrayList arrayList = new ArrayList();
        int i10 = this.c;
        Class cls = Integer.TYPE;
        Class cls2 = Long.TYPE;
        Context context = this.a;
        l9.e eVar = new l9.e(context);
        c9.k kVar2 = this.b;
        eVar.c = kVar2;
        eVar.d = 5000L;
        eVar.e = handler;
        eVar.f = a0Var;
        eVar.g = 50;
        o8.b.h(!eVar.b);
        Handler handler2 = eVar.e;
        o8.b.h((handler2 == null && eVar.f == null) || !(handler2 == null || eVar.f == null));
        eVar.b = true;
        arrayList.add(new g(eVar));
        if (i10 == 0) {
            kVar = kVar2;
        } else {
            int size = arrayList.size();
            kVar = kVar2;
            if (i10 == 2) {
                size--;
            }
            int i11 = size;
            try {
                try {
                    i = i11 + 1;
                } catch (Exception e) {
                    throw new IllegalStateException("Error instantiating VP9 extension", e);
                }
            } catch (ClassNotFoundException unused) {
            }
            try {
                arrayList.add(i11, (e) Class.forName("tlydtdl.media3.decoder.vp9.LibvpxVideoRenderer").getConstructor(cls2, Handler.class, a0.class, cls).newInstance(5000L, handler, a0Var, 50));
                o8.b.p("DefaultRenderersFactory", "Loaded LibvpxVideoRenderer.");
            } catch (ClassNotFoundException unused2) {
                i11 = i;
                i = i11;
            }
            try {
                try {
                    i2 = i + 1;
                } catch (Exception e2) {
                    throw new IllegalStateException("Error instantiating AV1 extension", e2);
                }
            } catch (ClassNotFoundException unused3) {
            }
            try {
                arrayList.add(i, (e) Class.forName("tlydtdl.media3.decoder.av1.Libgav1VideoRenderer").getConstructor(cls2, Handler.class, a0.class, cls).newInstance(5000L, handler, a0Var, 50));
                o8.b.p("DefaultRenderersFactory", "Loaded Libgav1VideoRenderer.");
            } catch (ClassNotFoundException unused4) {
                i = i2;
                i2 = i;
            }
            try {
                arrayList.add(i2, (e) Class.forName("tlydtdl.media3.decoder.ffmpeg.ExperimentalFfmpegVideoRenderer").getConstructor(cls2, Handler.class, a0.class, cls).newInstance(5000L, handler, a0Var, 50));
                o8.b.p("DefaultRenderersFactory", "Loaded FfmpegVideoRenderer.");
            } catch (ClassNotFoundException unused5) {
            } catch (Exception e3) {
                throw new IllegalStateException("Error instantiating FFmpeg extension", e3);
            }
        }
        boolean z = this.d;
        b02.n nVar = new b02.n(context);
        nVar.b = z;
        o8.b.h(!nVar.c);
        nVar.c = true;
        if (((u) nVar.f) == null) {
            nVar.f = new u(new m8.g[0]);
        }
        if (((w2.j) nVar.i) == null) {
            nVar.i = new w2.j(context);
        }
        y8.a0 a0Var5 = new y8.a0(nVar);
        int i12 = this.c;
        Context context2 = this.a;
        arrayList.add(new c0(context2, kVar, handler, a0Var2, a0Var5));
        if (i12 != 0) {
            int size2 = arrayList.size();
            if (i12 == 2) {
                size2--;
            }
            try {
                try {
                    i3 = size2 + 1;
                    try {
                        arrayList.add(size2, (e) Class.forName("tlydtdl.media3.decoder.midi.MidiRenderer").getConstructor(Context.class, Handler.class, y8.j.class, y8.m.class).newInstance(context2, handler, a0Var2, a0Var5));
                        o8.b.p("DefaultRenderersFactory", "Loaded MidiRenderer.");
                    } catch (ClassNotFoundException unused6) {
                        size2 = i3;
                        i3 = size2;
                    }
                } catch (Exception e4) {
                    throw new IllegalStateException("Error instantiating MIDI extension", e4);
                }
            } catch (ClassNotFoundException unused7) {
            }
            try {
                try {
                    i4 = i3 + 1;
                } catch (ClassNotFoundException unused8) {
                }
                try {
                    arrayList.add(i3, (e) Class.forName("tlydtdl.media3.decoder.opus.LibopusAudioRenderer").getConstructor(Handler.class, y8.j.class, y8.m.class).newInstance(handler, a0Var2, a0Var5));
                    o8.b.p("DefaultRenderersFactory", "Loaded LibopusAudioRenderer.");
                } catch (ClassNotFoundException unused9) {
                    i3 = i4;
                    i4 = i3;
                }
                try {
                    try {
                        i6 = i4 + 1;
                    } catch (Exception e5) {
                        throw new IllegalStateException("Error instantiating FLAC extension", e5);
                    }
                } catch (ClassNotFoundException unused10) {
                }
                try {
                    arrayList.add(i4, (e) Class.forName("tlydtdl.media3.decoder.flac.LibflacAudioRenderer").getConstructor(Handler.class, y8.j.class, y8.m.class).newInstance(handler, a0Var2, a0Var5));
                    o8.b.p("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                } catch (ClassNotFoundException unused11) {
                    i4 = i6;
                    i6 = i4;
                }
                try {
                    try {
                        i7 = i6 + 1;
                    } catch (Exception e6) {
                        throw new IllegalStateException("Error instantiating FFmpeg extension", e6);
                    }
                } catch (ClassNotFoundException unused12) {
                }
                try {
                    arrayList.add(i6, (e) Class.forName("tlydtdl.media3.decoder.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, y8.j.class, y8.m.class).newInstance(handler, a0Var2, a0Var5));
                    o8.b.p("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                } catch (ClassNotFoundException unused13) {
                    i6 = i7;
                    i7 = i6;
                }
                try {
                    try {
                        i8 = i7 + 1;
                        try {
                            arrayList.add(i7, (e) Class.forName("tlydtdl.media3.decoder.iamf.LibiamfAudioRenderer").getConstructor(Context.class, Handler.class, y8.j.class, y8.m.class).newInstance(context2, handler, a0Var2, a0Var5));
                            o8.b.p("DefaultRenderersFactory", "Loaded LibiamfAudioRenderer.");
                        } catch (ClassNotFoundException unused14) {
                            i7 = i8;
                            i8 = i7;
                        }
                    } catch (Exception e7) {
                        throw new IllegalStateException("Error instantiating IAMF extension", e7);
                    }
                } catch (ClassNotFoundException unused15) {
                }
                try {
                    try {
                        i9 = i8 + 1;
                    } catch (ClassNotFoundException unused16) {
                    }
                    try {
                        arrayList.add(i8, (e) Class.forName("tlydtdl.media3.decoder.mpegh.MpeghAudioRenderer").getConstructor(Handler.class, y8.j.class, y8.m.class).newInstance(handler, a0Var2, a0Var5));
                        o8.b.p("DefaultRenderersFactory", "Loaded MpeghAudioRenderer.");
                    } catch (ClassNotFoundException unused17) {
                        i8 = i9;
                        i9 = i8;
                    }
                    try {
                        arrayList.add(i9, (e) MpeghAudioRenderer.class.getConstructor(Handler.class, y8.j.class, String.class, Boolean.TYPE).newInstance(handler, a0Var2, context2.getFilesDir().getParent(), Boolean.TRUE));
                        o8.b.p("DefaultRenderersFactory", "Loaded MpeghAudioRenderer.");
                    } catch (ClassNotFoundException unused18) {
                    } catch (Exception e8) {
                        throw new RuntimeException("Error instantiating Mpegh extension", e8);
                    }
                } catch (Exception e9) {
                    throw new IllegalStateException("Error instantiating MPEG-H extension", e9);
                }
            } catch (Exception e10) {
                throw new IllegalStateException("Error instantiating Opus extension", e10);
            }
        }
        arrayList.add(new h9.f(a0Var3, handler.getLooper()));
        Looper looper = handler.getLooper();
        arrayList.add(new d9.b(a0Var4, looper));
        arrayList.add(new d9.b(a0Var4, looper));
        arrayList.add(new m9.b());
        arrayList.add(new b9.g(b9.c.L0));
        return (e[]) arrayList.toArray(new e[0]);
    }
}
