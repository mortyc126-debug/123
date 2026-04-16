package gl;

import ak.v;
import com.bandlab.audiocore.generated.AudioInputDevice;
import com.bandlab.audiocore.generated.AudioOutputDevice;
import f3.f2;
import lmjxuqdtp.jvm.internal.d0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements jw1.e {
    public final /* synthetic */ int a;
    public final c b;

    public /* synthetic */ f(e eVar, c cVar, int i) {
        this.a = i;
        this.b = cVar;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                this.b.invoke();
                AudioInputDevice audioInputDeviceCreate = AudioInputDevice.create(2, false);
                if (audioInputDeviceCreate != null) {
                    return audioInputDeviceCreate;
                }
                throw new IllegalArgumentException(f2.C(d0.a(AudioInputDevice.class).f(), " from audio core API should not be null here: check if anything changed!").toString());
            default:
                AudioOutputDevice audioOutputDeviceCreate = AudioOutputDevice.create(((v) this.b.invoke()).a().a, 2);
                if (audioOutputDeviceCreate != null) {
                    return audioOutputDeviceCreate;
                }
                throw new IllegalArgumentException(f2.C(d0.a(AudioOutputDevice.class).f(), " from audio core API should not be null here: check if anything changed!").toString());
        }
    }
}
