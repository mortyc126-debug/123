/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.SharedPreferences
 *  android.graphics.Color
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.ScrollView
 *  android.widget.TextView
 *  org.json.JSONObject
 */
package linker.resourcer.encoder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import linker.resourcer.encoder.R;
import linker.resourcer.encoder.CommandExecutor;
import org.json.JSONObject;

public class ChatUIActivity
extends Activity {
    private static final String CHAT_KEY = "chat_key";
    private static final String CHAT_PREFS = "chat_prefs";
    private static ChatUIActivity instance;
    private LinearLayout chatLayout;
    private TextView chattitle;
    public boolean iskhkpbnqozqiffemrwsatOpen = false;
    private EditText messageEditText;
    private ScrollView scrollView2;
    private SharedPreferences sharedPreferences;

    public static ChatUIActivity getInstance() {
        return instance;
    }

    public void appendToChat(String string2, String string3) {
        if (this.iskhkpbnqozqiffemrwsatOpen) {
            this.runOnUiThread(new Runnable(){
                final ChatUIActivity this$0;
                final String val$message;
                final String val$sender;
                {
                    this.this$0 = khkpbnqozqiffemrwsat2;
                    this.val$sender = string2;
                    this.val$message = string3;
                }

                @Override
                public void run() {
                    LinearLayout linearLayout = new LinearLayout((Context)this.this$0);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = this.val$sender.equals("You") ? 0x800005 : 0x800003;
                    linearLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
                    linearLayout.setPadding(7, 7, 7, 7);
                    TextView textView = new TextView((Context)this.this$0);
                    textView.setText((CharSequence)this.val$message);
                    textView.setTextColor(-1);
                    textView.setPadding(16, 8, 16, 8);
                    layoutParams = new GradientDrawable();
                    layoutParams.setShape(0);
                    if (this.val$sender.equals("You")) {
                        layoutParams.setColor(Color.parseColor((String)"#2979FF"));
                    } else {
                        layoutParams.setColor(Color.parseColor((String)"#4CAF50"));
                    }
                    layoutParams.setCornerRadius(16.0f);
                    textView.setBackground((Drawable)layoutParams);
                    linearLayout.addView((View)textView);
                    ((LinearLayout)this.this$0.findViewById(R.id.chatLayout)).addView((View)linearLayout);
                    this.this$0.scrollView2.post(new Runnable(this){
                        final 2 this$1;
                        {
                            this.this$1 = var1_1;
                        }

                        @Override
                        public void run() {
                            this.this$1.this$0.scrollView2.fullScroll(130);
                        }
                    });
                }
            });
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.requestWindowFeature(1);
        this.getWindow().setFlags(1024, 1024);
        this.setContentView(R.layout.activity_chat);
        instance = this;
        this.messageEditText = (EditText)this.findViewById(R.id.messageEditText);
        this.chattitle = (TextView)this.findViewById(R.id.chattitle);
        this.scrollView2 = (ScrollView)this.findViewById(R.id.scrollView2);
        this.chatLayout = (LinearLayout)this.findViewById(R.id.chatLayout);
        bundle = (Button)this.findViewById(R.id.sendButton);
        Intent intent = this.getIntent();
        if (intent != null && intent.hasExtra("title")) {
            this.chattitle.setText((CharSequence)intent.getStringExtra("title"));
        }
        bundle.setOnClickListener(new View.OnClickListener(this){
            final ChatUIActivity this$0;
            {
                this.this$0 = khkpbnqozqiffemrwsat2;
            }

            public void onClick(View object) {
                object = this.this$0.messageEditText.getText().toString().trim();
                if (!((String)object).isEmpty()) {
                    this.this$0.appendToChat("You", (String)object);
                    this.this$0.messageEditText.setText((CharSequence)"");
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("type", (Object)"chat");
                        jSONObject.put("data", object);
                        object = jSONObject.toString();
                        CommandExecutor.instance(this.this$0.getApplicationContext()).Livemessage(this.this$0.getApplicationContext(), (String)object);
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }
            }
        });
    }

    protected void onStart() {
        super.onStart();
        this.iskhkpbnqozqiffemrwsatOpen = true;
    }

    protected void onStop() {
        super.onStop();
        this.iskhkpbnqozqiffemrwsatOpen = false;
    }
}

