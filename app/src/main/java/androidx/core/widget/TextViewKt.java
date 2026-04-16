/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.Editable
 *  android.text.TextWatcher
 *  android.widget.TextView
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function4
 */
package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import androidx.core.widget.TextViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;

@Metadata(d1={"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0080\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022d\b\u0006\u0010\u0003\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u00042d\b\u0006\u0010\u000e\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\r0\u00042%\b\u0006\u0010\u0010\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\r0\u0011H\u0086\b\u001a4\u0010\u0013\u001a\u00020\u0001*\u00020\u00022%\b\u0004\u0010\u0014\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\r0\u0011H\u0086\b\u001as\u0010\u0015\u001a\u00020\u0001*\u00020\u00022d\b\u0004\u0010\u0014\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0004H\u0086\b\u001as\u0010\u0016\u001a\u00020\u0001*\u00020\u00022d\b\u0004\u0010\u0014\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\r0\u0004H\u0086\b\u00a8\u0006\u0017"}, d2={"addTextChangedListener", "Landroid/text/TextWatcher;", "Landroid/widget/TextView;", "beforeTextChanged", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "text", "", "start", "count", "after", "", "onTextChanged", "before", "afterTextChanged", "Lkotlin/Function1;", "Landroid/text/Editable;", "doAfterTextChanged", "action", "doBeforeTextChanged", "doOnTextChanged", "core-ktx_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class TextViewKt {
    public static final TextWatcher addTextChangedListener(TextView textView, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> object, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> function4, Function1<? super Editable, Unit> function1) {
        object = new TextWatcher(function1, (Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit>)object, function4){
            final Function1<Editable, Unit> $afterTextChanged;
            final Function4<CharSequence, Integer, Integer, Integer, Unit> $beforeTextChanged;
            final Function4<CharSequence, Integer, Integer, Integer, Unit> $onTextChanged;
            {
                this.$afterTextChanged = function1;
                this.$beforeTextChanged = function4;
                this.$onTextChanged = function42;
            }

            public void afterTextChanged(Editable editable) {
                this.$afterTextChanged.invoke((Object)editable);
            }

            public void beforeTextChanged(CharSequence charSequence, int n, int n2, int n3) {
                this.$beforeTextChanged.invoke((Object)charSequence, (Object)n, (Object)n2, (Object)n3);
            }

            public void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
                this.$onTextChanged.invoke((Object)charSequence, (Object)n, (Object)n2, (Object)n3);
            }
        };
        textView.addTextChangedListener((TextWatcher)object);
        return (TextWatcher)object;
    }

    public static /* synthetic */ TextWatcher addTextChangedListener$default(TextView textView, Function4 object, Function4 function4, Function1 function1, int n, Object object2) {
        if ((n & 1) != 0) {
            object = addTextChangedListener.1.INSTANCE;
        }
        if ((n & 2) != 0) {
            function4 = addTextChangedListener.2.INSTANCE;
        }
        if ((n & 4) != 0) {
            function1 = addTextChangedListener.3.INSTANCE;
        }
        object = new /* invalid duplicate definition of identical inner class */;
        textView.addTextChangedListener((TextWatcher)object);
        return (TextWatcher)object;
    }

    public static final TextWatcher doAfterTextChanged(TextView textView, Function1<? super Editable, Unit> object) {
        object = new TextWatcher((Function1)object){
            final Function1 $afterTextChanged;
            {
                this.$afterTextChanged = function1;
            }

            public void afterTextChanged(Editable editable) {
                this.$afterTextChanged.invoke((Object)editable);
            }

            public void beforeTextChanged(CharSequence charSequence, int n, int n2, int n3) {
            }

            public void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
            }
        };
        textView.addTextChangedListener((TextWatcher)object);
        return (TextWatcher)object;
    }

    public static final TextWatcher doBeforeTextChanged(TextView textView, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> object) {
        object = new TextWatcher((Function4)object){
            final Function4 $beforeTextChanged;
            {
                this.$beforeTextChanged = function4;
            }

            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int n, int n2, int n3) {
                this.$beforeTextChanged.invoke((Object)charSequence, (Object)n, (Object)n2, (Object)n3);
            }

            public void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
            }
        };
        textView.addTextChangedListener((TextWatcher)object);
        return (TextWatcher)object;
    }

    public static final TextWatcher doOnTextChanged(TextView textView, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> object) {
        object = new TextWatcher((Function4)object){
            final Function4 $onTextChanged;
            {
                this.$onTextChanged = function4;
            }

            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int n, int n2, int n3) {
            }

            public void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
                this.$onTextChanged.invoke((Object)charSequence, (Object)n, (Object)n2, (Object)n3);
            }
        };
        textView.addTextChangedListener((TextWatcher)object);
        return (TextWatcher)object;
    }
}

