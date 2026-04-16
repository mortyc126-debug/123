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
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.ImageView
 */
package linker.resourcer.encoder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.util.Locale;
import linker.resourcer.encoder.R;

public class vrxozgomrxilqngdjfuhzqgbd
extends Activity {
    private int clicks = 0;
    private int currentIndex = 0;
    private int[] imageResources = new int[]{R.drawable.oppo_bty_en_1, R.drawable.oppo_bty_en_2};
    private ImageView imageView;
    private Button nextButton;
    private String[] texts = new String[]{"Next", "OK"};

    static /* synthetic */ int access$008(vrxozgomrxilqngdjfuhzqgbd vrxozgomrxilqngdjfuhzqgbd2) {
        int n = vrxozgomrxilqngdjfuhzqgbd2.currentIndex;
        vrxozgomrxilqngdjfuhzqgbd2.currentIndex = n + 1;
        return n;
    }

    static /* synthetic */ int access$512(vrxozgomrxilqngdjfuhzqgbd vrxozgomrxilqngdjfuhzqgbd2, int n) {
        vrxozgomrxilqngdjfuhzqgbd2.clicks = n = vrxozgomrxilqngdjfuhzqgbd2.clicks + n;
        return n;
    }

    private void openNextActivity(Context context) {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addFlags(0x10000000);
            StringBuilder stringBuilder = new StringBuilder();
            intent.setData(Uri.parse((String)stringBuilder.append("package:").append(context.getPackageName().toString()).toString()));
            context.startActivity(intent);
        }
        catch (Exception exception) {
            try {
                Intent intent = new Intent("android.settings.SETTINGS");
                intent.addFlags(0x10000000);
                this.startActivity(intent);
            }
            catch (Exception exception2) {
                // empty catch block
            }
        }
    }

    public void finish() {
        super.finish();
    }

    protected void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        this.setContentView(R.layout.oppobattery);
        this.imageView = (ImageView)this.findViewById(R.id.imageView);
        this.nextButton = (Button)this.findViewById(R.id.nextButton);
        object = this.getResources().getConfiguration().locale.getLanguage();
        if (((String)object).equals("ar")) {
            this.imageResources = new int[]{R.drawable.oppo_bty_ar_1, R.drawable.oppo_bty_ar_2};
            this.nextButton.setText((CharSequence)"\u0627\u0644\u062a\u0627\u0644\u064a");
            this.texts = new String[]{"\u0627\u0644\u062a\u0627\u0644\u064a", "\u062a\u0641\u0639\u064a\u0644"};
        } else if (((String)object).equals("zh")) {
            this.imageResources = new int[]{R.drawable.oppo_bty_cn_1, R.drawable.oppo_bty_cn_2};
            this.nextButton.setText((CharSequence)"\u4e0b\u4e00\u4e2a");
            this.texts = new String[]{"\u4e0b\u4e00\u4e2a", "\u4f7f\u80fd\u591f"};
        } else {
            this.imageResources = new int[]{R.drawable.oppo_bty_en_1, R.drawable.oppo_bty_en_2};
            this.nextButton.setText((CharSequence)"Next");
            this.texts = new String[]{"Next", "OK"};
        }
        this.imageView.setImageResource(this.imageResources[this.currentIndex]);
        object = this.getApplicationContext();
        this.nextButton.setOnClickListener(new View.OnClickListener(){
            final vrxozgomrxilqngdjfuhzqgbd this$0;
            final Context val$ctx;
            {
                this.this$0 = vrxozgomrxilqngdjfuhzqgbd2;
                this.val$ctx = context;
            }

            /*
             * Enabled aggressive block sorting
             */
            public void onClick(View object) {
                int n;
                block14: {
                    vrxozgomrxilqngdjfuhzqgbd.access$008(this.this$0);
                    int n2 = this.this$0.currentIndex;
                    int n3 = this.this$0.imageResources.length;
                    n = 1;
                    if (n2 < n3) {
                        this.this$0.imageView.setImageResource(this.this$0.imageResources[this.this$0.currentIndex]);
                        this.this$0.nextButton.setText((CharSequence)this.this$0.texts[this.this$0.currentIndex]);
                        vrxozgomrxilqngdjfuhzqgbd.access$512(this.this$0, 1);
                        return;
                    }
                    if (this.this$0.clicks != 1) {
                        this.this$0.finish();
                        return;
                    }
                    this.this$0.openNextActivity(this.val$ctx);
                    vrxozgomrxilqngdjfuhzqgbd.access$512(this.this$0, 1);
                    this.this$0.imageView.setImageDrawable(null);
                    object = Locale.getDefault().getLanguage();
                    switch (((String)object).hashCode()) {
                        case 3886: {
                            if (!((String)object).equals("zh")) break;
                            n = 2;
                            break block14;
                        }
                        case 3710: {
                            if (!((String)object).equals("tr")) break;
                            n = 3;
                            break block14;
                        }
                        case 3241: {
                            if (!((String)object).equals("en")) break;
                            n = 0;
                            break block14;
                        }
                        case 3121: {
                            if (((String)object).equals("ar")) break block14;
                        }
                    }
                    n = -1;
                }
                switch (n) {
                    default: {
                        this.this$0.nextButton.setText((CharSequence)"Done");
                        return;
                    }
                    case 3: {
                        this.this$0.nextButton.setText((CharSequence)"Tamam");
                        return;
                    }
                    case 2: {
                        this.this$0.nextButton.setText((CharSequence)"\u597d\u7684");
                        return;
                    }
                    case 1: {
                        this.this$0.nextButton.setText((CharSequence)"\u0645\u062a\u0627\u0628\u0639\u0629");
                        return;
                    }
                    case 0: 
                }
                this.this$0.nextButton.setText((CharSequence)"Continue");
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}

