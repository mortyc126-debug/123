/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources$NotFoundException
 *  android.util.Log
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 */
package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.io.PrintStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Debug {
    public static void dumpLayoutParams(ViewGroup.LayoutParams layoutParams, String string2) {
        Field[] fieldArray = new Throwable().getStackTrace()[1];
        string2 = ".(" + fieldArray.getFileName() + ":" + fieldArray.getLineNumber() + ") " + string2 + "  ";
        System.out.println(" >>>>>>>>>>>>>>>>>>. dump " + string2 + "  " + layoutParams.getClass().getName());
        fieldArray = layoutParams.getClass().getFields();
        for (int i = 0; i < fieldArray.length; ++i) {
            Object object = fieldArray[i];
            try {
                Object object2 = ((Field)object).get(layoutParams);
                object = ((Field)object).getName();
                if (!((String)object).contains("To") || object2.toString().equals("-1")) continue;
                PrintStream printStream = System.out;
                StringBuilder stringBuilder = new StringBuilder();
                printStream.println(stringBuilder.append(string2).append("       ").append((String)object).append(" ").append(object2).toString());
                continue;
            }
            catch (IllegalAccessException illegalAccessException) {
                // empty catch block
            }
        }
        System.out.println(" <<<<<<<<<<<<<<<<< dump " + string2);
    }

    public static void dumpLayoutParams(ViewGroup viewGroup, String string2) {
        Object object = new Throwable().getStackTrace()[1];
        object = ".(" + ((StackTraceElement)object).getFileName() + ":" + ((StackTraceElement)object).getLineNumber() + ") " + string2 + "  ";
        int n = viewGroup.getChildCount();
        System.out.println(string2 + " children " + n);
        for (int i = 0; i < n; ++i) {
            string2 = viewGroup.getChildAt(i);
            System.out.println((String)object + "     " + Debug.getName((View)string2));
            string2 = string2.getLayoutParams();
            Field[] fieldArray = string2.getClass().getFields();
            for (int j = 0; j < fieldArray.length; ++j) {
                Field field = fieldArray[j];
                try {
                    Object object2 = field.get(string2);
                    if (!field.getName().contains("To") || object2.toString().equals("-1")) continue;
                    PrintStream printStream = System.out;
                    StringBuilder stringBuilder = new StringBuilder();
                    printStream.println(stringBuilder.append((String)object).append("       ").append(field.getName()).append(" ").append(object2).toString());
                    continue;
                }
                catch (IllegalAccessException illegalAccessException) {
                    // empty catch block
                }
            }
        }
    }

    public static void dumpPoc(Object object) {
        Serializable serializable = new Throwable().getStackTrace()[1];
        String string2 = ".(" + ((StackTraceElement)serializable).getFileName() + ":" + ((StackTraceElement)serializable).getLineNumber() + ")";
        serializable = object.getClass();
        System.out.println(string2 + "------------- " + ((Class)serializable).getName() + " --------------------");
        Field[] fieldArray = ((Class)serializable).getFields();
        for (int i = 0; i < fieldArray.length; ++i) {
            Field field = fieldArray[i];
            try {
                Object object2 = field.get(object);
                if (!field.getName().startsWith("layout_constraint") || object2 instanceof Integer && object2.toString().equals("-1") || object2 instanceof Integer && object2.toString().equals("0") || object2 instanceof Float && object2.toString().equals("1.0") || object2 instanceof Float && object2.toString().equals("0.5")) continue;
                PrintStream printStream = System.out;
                StringBuilder stringBuilder = new StringBuilder();
                printStream.println(stringBuilder.append(string2).append("    ").append(field.getName()).append(" ").append(object2).toString());
                continue;
            }
            catch (IllegalAccessException illegalAccessException) {
                // empty catch block
            }
        }
        System.out.println(string2 + "------------- " + ((Class)serializable).getSimpleName() + " --------------------");
    }

    public static String getActionType(MotionEvent fieldArray) {
        int n = fieldArray.getAction();
        fieldArray = MotionEvent.class.getFields();
        for (int i = 0; i < fieldArray.length; ++i) {
            Object object = fieldArray[i];
            try {
                if (!Modifier.isStatic(((Field)object).getModifiers()) || !((Field)object).getType().equals(Integer.TYPE) || ((Field)object).getInt(null) != n) continue;
                object = ((Field)object).getName();
                return object;
            }
            catch (IllegalAccessException illegalAccessException) {
                // empty catch block
            }
        }
        return "---";
    }

    public static String getCallFrom(int n) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[n + 2];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
    }

    public static String getLoc() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName() + "()";
    }

    public static String getLocation() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
    }

    public static String getLocation2() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String getName(Context context, int n) {
        if (n == -1) return "UNKNOWN";
        try {
            return context.getResources().getResourceEntryName(n);
        }
        catch (Exception exception) {
            return "?" + n;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String getName(Context object, int[] nArray) {
        CharSequence charSequence;
        try {
            charSequence = new StringBuilder();
            charSequence = ((StringBuilder)charSequence).append(nArray.length).append("[").toString();
            for (int i = 0; i < nArray.length; ++i) {
                CharSequence charSequence2 = new StringBuilder();
                charSequence2 = charSequence2.append((String)charSequence);
                charSequence = i == 0 ? "" : " ";
                charSequence2 = charSequence2.append((String)charSequence).toString();
                try {
                    charSequence = object.getResources().getResourceEntryName(nArray[i]);
                }
                catch (Resources.NotFoundException notFoundException) {
                    charSequence = new StringBuilder();
                    charSequence = ((StringBuilder)charSequence).append("? ").append(nArray[i]).append(" ").toString();
                }
                StringBuilder stringBuilder = new StringBuilder();
                charSequence = stringBuilder.append((String)charSequence2).append((String)charSequence).toString();
            }
        }
        catch (Exception exception) {
            Log.v((String)"DEBUG", (String)exception.toString());
            return "UNKNOWN";
        }
        {
            object = new StringBuilder();
            return ((StringBuilder)object).append((String)charSequence).append("]").toString();
        }
    }

    public static String getName(View object) {
        try {
            object = object.getContext().getResources().getResourceEntryName(object.getId());
            return object;
        }
        catch (Exception exception) {
            return "UNKNOWN";
        }
    }

    public static String getState(MotionLayout motionLayout, int n) {
        if (n == -1) {
            return "UNDEFINED";
        }
        return motionLayout.getContext().getResources().getResourceEntryName(n);
    }

    public static void logStack(String string2, String string3, int n) {
        StackTraceElement[] stackTraceElementArray = new Throwable().getStackTrace();
        String string4 = " ";
        int n2 = Math.min(n, stackTraceElementArray.length - 1);
        for (n = 1; n <= n2; ++n) {
            Object object = stackTraceElementArray[n];
            object = ".(" + stackTraceElementArray[n].getFileName() + ":" + stackTraceElementArray[n].getLineNumber() + ") " + stackTraceElementArray[n].getMethodName();
            string4 = string4 + " ";
            Log.v((String)string2, (String)(string3 + string4 + (String)object + string4));
        }
    }

    public static void printStack(String string2, int n) {
        StackTraceElement[] stackTraceElementArray = new Throwable().getStackTrace();
        String string3 = " ";
        int n2 = Math.min(n, stackTraceElementArray.length - 1);
        for (n = 1; n <= n2; ++n) {
            Object object = stackTraceElementArray[n];
            object = ".(" + stackTraceElementArray[n].getFileName() + ":" + stackTraceElementArray[n].getLineNumber() + ") ";
            string3 = string3 + " ";
            System.out.println(string2 + string3 + (String)object + string3);
        }
    }
}

