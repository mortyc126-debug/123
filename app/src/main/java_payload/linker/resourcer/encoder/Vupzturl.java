/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.speech.tts.TextToSpeech
 *  android.speech.tts.TextToSpeech$OnInitListener
 *  android.speech.tts.UtteranceProgressListener
 */
package linker.resourcer.encoder;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import java.util.Locale;
import linker.resourcer.encoder.Vupzturl$$ExternalSyntheticLambda0;
import linker.resourcer.encoder.Vupzturl$$ExternalSyntheticLambda1;
import linker.resourcer.encoder.Vupzturl$1$$ExternalSyntheticLambda0;
import linker.resourcer.encoder.Vupzturl$1$$ExternalSyntheticLambda1;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class Vupzturl
extends Activity
implements TextToSpeech.OnInitListener {
    private String messageToSpeak = "Hello";
    private String preferredLangCode = "en";
    private TextToSpeech tts;

    /*
     * Enabled aggressive block sorting
     */
    private Locale getLocaleFromCode(String string2) {
        int n;
        block16: {
            string2 = string2.toLowerCase();
            switch (string2.hashCode()) {
                case 3886: {
                    if (!string2.equals("zh")) break;
                    n = 1;
                    break block16;
                }
                case 3710: {
                    if (!string2.equals("tr")) break;
                    n = 3;
                    break block16;
                }
                case 3651: {
                    if (!string2.equals("ru")) break;
                    n = 2;
                    break block16;
                }
                case 3588: {
                    if (!string2.equals("pt")) break;
                    n = 5;
                    break block16;
                }
                case 3246: {
                    if (!string2.equals("es")) break;
                    n = 4;
                    break block16;
                }
                case 3121: {
                    if (!string2.equals("ar")) break;
                    n = 0;
                    break block16;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                return Locale.ENGLISH;
            }
            case 5: {
                return new Locale("pt");
            }
            case 4: {
                return new Locale("es");
            }
            case 3: {
                return new Locale("tr");
            }
            case 2: {
                return new Locale("ru");
            }
            case 1: {
                return Locale.CHINESE;
            }
            case 0: 
        }
        return new Locale("ar");
    }

    /* synthetic */ void lambda$onInit$0$com-icontrol-protector-Vupzturl() {
        this.finish();
    }

    /* synthetic */ void lambda$onInit$1$com-icontrol-protector-Vupzturl(Handler handler) {
        Locale locale = this.getLocaleFromCode(this.preferredLangCode);
        int n = this.tts.setLanguage(locale);
        if (n == -1 || n == -2) {
            this.tts.setLanguage(Locale.ENGLISH);
        }
        this.tts.speak(this.messageToSpeak, 0, null);
        handler.postDelayed((Runnable)new Vupzturl$$ExternalSyntheticLambda0(this), 100L);
        this.tts.setOnUtteranceProgressListener(new UtteranceProgressListener(this){
            final Vupzturl this$0;
            {
                this.this$0 = vupzturl;
            }

            /* synthetic */ void lambda$onDone$0$com-icontrol-protector-Vupzturl$1() {
                this.this$0.finish();
            }

            /* synthetic */ void lambda$onError$1$com-icontrol-protector-Vupzturl$1() {
                this.this$0.finish();
            }

            public void onDone(String string2) {
                this.this$0.runOnUiThread(new Vupzturl$1$$ExternalSyntheticLambda0(this));
            }

            public void onError(String string2) {
                this.this$0.runOnUiThread(new Vupzturl$1$$ExternalSyntheticLambda1(this));
            }

            public void onStart(String string2) {
            }
        });
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = this.getIntent();
        if (bundle != null) {
            this.messageToSpeak = bundle.getStringExtra("msg");
            this.preferredLangCode = bundle.getStringExtra("lang");
            if (this.preferredLangCode == null) {
                this.preferredLangCode = "en";
            }
            if (this.messageToSpeak == null) {
                this.messageToSpeak = "Hello";
            }
        }
        this.tts = new TextToSpeech((Context)this, (TextToSpeech.OnInitListener)this);
    }

    protected void onDestroy() {
        if (this.tts != null) {
            this.tts.stop();
            this.tts.shutdown();
        }
        super.onDestroy();
    }

    public void onInit(int n) {
        if (n == 0) {
            Handler handler = new Handler(Looper.getMainLooper());
            handler.postDelayed((Runnable)new Vupzturl$$ExternalSyntheticLambda1(this, handler), 1000L);
        } else {
            this.finish();
        }
    }
}

