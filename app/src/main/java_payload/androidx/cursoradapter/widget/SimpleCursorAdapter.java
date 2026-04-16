/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.Cursor
 *  android.net.Uri
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cursoradapter.widget.ResourceCursorAdapter;

public class SimpleCursorAdapter
extends ResourceCursorAdapter {
    private CursorToStringConverter mCursorToStringConverter;
    protected int[] mFrom;
    String[] mOriginalFrom;
    private int mStringConversionColumn = -1;
    protected int[] mTo;
    private ViewBinder mViewBinder;

    @Deprecated
    public SimpleCursorAdapter(Context context, int n, Cursor cursor, String[] stringArray, int[] nArray) {
        super(context, n, cursor);
        this.mTo = nArray;
        this.mOriginalFrom = stringArray;
        this.findColumns(cursor, stringArray);
    }

    public SimpleCursorAdapter(Context context, int n, Cursor cursor, String[] stringArray, int[] nArray, int n2) {
        super(context, n, cursor, n2);
        this.mTo = nArray;
        this.mOriginalFrom = stringArray;
        this.findColumns(cursor, stringArray);
    }

    private void findColumns(Cursor cursor, String[] stringArray) {
        if (cursor != null) {
            int n = stringArray.length;
            if (this.mFrom == null || this.mFrom.length != n) {
                this.mFrom = new int[n];
            }
            for (int i = 0; i < n; ++i) {
                this.mFrom[i] = cursor.getColumnIndexOrThrow(stringArray[i]);
            }
        } else {
            this.mFrom = null;
        }
    }

    @Override
    public void bindView(View view, Context object, Cursor cursor) {
        ViewBinder viewBinder = this.mViewBinder;
        int n = this.mTo.length;
        int[] nArray = this.mFrom;
        int[] nArray2 = this.mTo;
        for (int i = 0; i < n; ++i) {
            View view2 = view.findViewById(nArray2[i]);
            if (view2 == null) continue;
            boolean bl = false;
            if (viewBinder != null) {
                bl = viewBinder.setViewValue(view2, cursor, nArray[i]);
            }
            if (bl) continue;
            String string2 = cursor.getString(nArray[i]);
            object = string2;
            if (string2 == null) {
                object = "";
            }
            if (view2 instanceof TextView) {
                this.setViewText((TextView)view2, (String)object);
                continue;
            }
            if (view2 instanceof ImageView) {
                this.setViewImage((ImageView)view2, (String)object);
                continue;
            }
            throw new IllegalStateException(view2.getClass().getName() + " is not a " + " view that can be bounds by this SimpleCursorAdapter");
        }
    }

    public void changeCursorAndColumns(Cursor cursor, String[] stringArray, int[] nArray) {
        this.mOriginalFrom = stringArray;
        this.mTo = nArray;
        this.findColumns(cursor, this.mOriginalFrom);
        super.changeCursor(cursor);
    }

    @Override
    public CharSequence convertToString(Cursor cursor) {
        if (this.mCursorToStringConverter != null) {
            return this.mCursorToStringConverter.convertToString(cursor);
        }
        if (this.mStringConversionColumn > -1) {
            return cursor.getString(this.mStringConversionColumn);
        }
        return super.convertToString(cursor);
    }

    public CursorToStringConverter getCursorToStringConverter() {
        return this.mCursorToStringConverter;
    }

    public int getStringConversionColumn() {
        return this.mStringConversionColumn;
    }

    public ViewBinder getViewBinder() {
        return this.mViewBinder;
    }

    public void setCursorToStringConverter(CursorToStringConverter cursorToStringConverter) {
        this.mCursorToStringConverter = cursorToStringConverter;
    }

    public void setStringConversionColumn(int n) {
        this.mStringConversionColumn = n;
    }

    public void setViewBinder(ViewBinder viewBinder) {
        this.mViewBinder = viewBinder;
    }

    public void setViewImage(ImageView imageView, String string2) {
        try {
            imageView.setImageResource(Integer.parseInt(string2));
        }
        catch (NumberFormatException numberFormatException) {
            imageView.setImageURI(Uri.parse((String)string2));
        }
    }

    public void setViewText(TextView textView, String string2) {
        textView.setText((CharSequence)string2);
    }

    @Override
    public Cursor swapCursor(Cursor cursor) {
        this.findColumns(cursor, this.mOriginalFrom);
        return super.swapCursor(cursor);
    }

    public static interface CursorToStringConverter {
        public CharSequence convertToString(Cursor var1);
    }

    public static interface ViewBinder {
        public boolean setViewValue(View var1, Cursor var2, int var3);
    }
}

