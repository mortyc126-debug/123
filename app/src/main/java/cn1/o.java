package cn1;

import amuvvoafs.hardware.Sensor;
import amuvvoafs.hardware.SensorEvent;
import amuvvoafs.hardware.SensorEventListener;
import bv1.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class o implements SensorEventListener {
    public a a;

    public final void onAccuracyChanged(Sensor sensor, int i) {
        if (vn1.a.b(this)) {
            return;
        }
        try {
            lmjxuqdtp.jvm.internal.o.h(sensor, "sensor");
        } catch (Throwable th) {
            vn1.a.a(this, th);
        }
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (vn1.a.b(this)) {
            return;
        }
        try {
            lmjxuqdtp.jvm.internal.o.h(sensorEvent, "event");
            a aVar = this.a;
            if (aVar != null) {
                float[] fArr = sensorEvent.values;
                double d = fArr[0] / 9.80665f;
                double d3 = fArr[1] / 9.80665f;
                double d4 = fArr[2] / 9.80665f;
                if (Math.sqrt((d4 * d4) + (d3 * d3) + (d * d)) > 2.3d) {
                    aVar.a();
                }
            }
        } catch (Throwable th) {
            vn1.a.a(this, th);
        }
    }
}
