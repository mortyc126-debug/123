/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.hardware.camera2.CameraAccessException
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraManager
 */
package linker.resourcer.encoder;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;

public class FlashlightController {
    private String cameraId;
    private final CameraManager cameraManager;

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public FlashlightController(Context object) {
        int n;
        int n2;
        String[] stringArray;
        this.cameraManager = (CameraManager)object.getSystemService("camera");
        try {
            stringArray = this.cameraManager.getCameraIdList();
            n2 = stringArray.length;
            n = 0;
        }
        catch (CameraAccessException cameraAccessException) {
            cameraAccessException.printStackTrace();
            return;
        }
        while (n < n2) {
            String string2 = stringArray[n];
            {
                if (((Boolean)this.cameraManager.getCameraCharacteristics(string2).get(CameraCharacteristics.FLASH_INFO_AVAILABLE)).booleanValue()) {
                    this.cameraId = string2;
                    return;
                }
                ++n;
            }
        }
    }

    public void toggleFlashlight(Boolean bl) {
        if (this.cameraId == null) {
            return;
        }
        try {
            this.cameraManager.setTorchMode(this.cameraId, bl.booleanValue());
        }
        catch (CameraAccessException cameraAccessException) {
            cameraAccessException.printStackTrace();
        }
    }
}

