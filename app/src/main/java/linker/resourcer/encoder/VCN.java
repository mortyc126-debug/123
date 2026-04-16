/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Bundle
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.TextView
 */
package linker.resourcer.encoder;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class VCN
extends Activity {
    private Button btnSend;
    private EditText etMessage;
    private String phoneNumber;
    private TextView tvPhone;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.finish();
    }
}

