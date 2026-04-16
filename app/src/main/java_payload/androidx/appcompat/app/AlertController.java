/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnClickListener
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.DialogInterface$OnKeyListener
 *  android.content.DialogInterface$OnMultiChoiceClickListener
 *  android.database.Cursor
 *  android.graphics.drawable.Drawable
 *  android.os.Handler
 *  android.os.Message
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.util.TypedValue
 *  android.view.KeyEvent
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.ViewStub
 *  android.view.Window
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.AdapterView$OnItemSelectedListener
 *  android.widget.ArrayAdapter
 *  android.widget.Button
 *  android.widget.CheckedTextView
 *  android.widget.CursorAdapter
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.SimpleCursorAdapter
 *  android.widget.TextView
 */
package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

class AlertController {
    ListAdapter mAdapter;
    private int mAlertDialogLayout;
    private final View.OnClickListener mButtonHandler = new View.OnClickListener(this){
        final AlertController this$0;
        {
            this.this$0 = alertController;
        }

        public void onClick(View object) {
            if ((object = object == this.this$0.mButtonPositive && this.this$0.mButtonPositiveMessage != null ? Message.obtain((Message)this.this$0.mButtonPositiveMessage) : (object == this.this$0.mButtonNegative && this.this$0.mButtonNegativeMessage != null ? Message.obtain((Message)this.this$0.mButtonNegativeMessage) : (object == this.this$0.mButtonNeutral && this.this$0.mButtonNeutralMessage != null ? Message.obtain((Message)this.this$0.mButtonNeutralMessage) : null))) != null) {
                object.sendToTarget();
            }
            this.this$0.mHandler.obtainMessage(1, (Object)this.this$0.mDialog).sendToTarget();
        }
    };
    private final int mButtonIconDimen;
    Button mButtonNegative;
    private Drawable mButtonNegativeIcon;
    Message mButtonNegativeMessage;
    private CharSequence mButtonNegativeText;
    Button mButtonNeutral;
    private Drawable mButtonNeutralIcon;
    Message mButtonNeutralMessage;
    private CharSequence mButtonNeutralText;
    private int mButtonPanelLayoutHint = 0;
    private int mButtonPanelSideLayout;
    Button mButtonPositive;
    private Drawable mButtonPositiveIcon;
    Message mButtonPositiveMessage;
    private CharSequence mButtonPositiveText;
    int mCheckedItem = -1;
    private final Context mContext;
    private View mCustomTitleView;
    final AppCompatDialog mDialog;
    Handler mHandler;
    private Drawable mIcon;
    private int mIconId = 0;
    private ImageView mIconView;
    int mListItemLayout;
    int mListLayout;
    ListView mListView;
    private CharSequence mMessage;
    private TextView mMessageView;
    int mMultiChoiceItemLayout;
    NestedScrollView mScrollView;
    private boolean mShowTitle;
    int mSingleChoiceItemLayout;
    private CharSequence mTitle;
    private TextView mTitleView;
    private View mView;
    private int mViewLayoutResId;
    private int mViewSpacingBottom;
    private int mViewSpacingLeft;
    private int mViewSpacingRight;
    private boolean mViewSpacingSpecified = false;
    private int mViewSpacingTop;
    private final Window mWindow;

    public AlertController(Context context, AppCompatDialog appCompatDialog, Window window) {
        this.mContext = context;
        this.mDialog = appCompatDialog;
        this.mWindow = window;
        this.mHandler = new ButtonHandler((DialogInterface)appCompatDialog);
        context = context.obtainStyledAttributes(null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
        this.mAlertDialogLayout = context.getResourceId(R.styleable.AlertDialog_android_layout, 0);
        this.mButtonPanelSideLayout = context.getResourceId(R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.mListLayout = context.getResourceId(R.styleable.AlertDialog_listLayout, 0);
        this.mMultiChoiceItemLayout = context.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.mSingleChoiceItemLayout = context.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.mListItemLayout = context.getResourceId(R.styleable.AlertDialog_listItemLayout, 0);
        this.mShowTitle = context.getBoolean(R.styleable.AlertDialog_showTitle, true);
        this.mButtonIconDimen = context.getDimensionPixelSize(R.styleable.AlertDialog_buttonIconDimen, 0);
        context.recycle();
        appCompatDialog.supportRequestWindowFeature(1);
    }

    static boolean canTextInput(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        view = (ViewGroup)view;
        int n = view.getChildCount();
        while (n > 0) {
            int n2;
            n = n2 = n - 1;
            if (!AlertController.canTextInput(view.getChildAt(n2))) continue;
            return true;
        }
        return false;
    }

    private void centerButton(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    }

    static void manageScrollIndicators(View view, View view2, View view3) {
        int n;
        int n2 = 0;
        if (view2 != null) {
            n = view.canScrollVertically(-1) ? 0 : 4;
            view2.setVisibility(n);
        }
        if (view3 != null) {
            n = view.canScrollVertically(1) ? n2 : 4;
            view3.setVisibility(n);
        }
    }

    private ViewGroup resolvePanel(View view, View view2) {
        ViewParent viewParent;
        if (view == null) {
            view = view2;
            if (view2 instanceof ViewStub) {
                view = ((ViewStub)view2).inflate();
            }
            return (ViewGroup)view;
        }
        if (view2 != null && (viewParent = view2.getParent()) instanceof ViewGroup) {
            ((ViewGroup)viewParent).removeView(view2);
        }
        view2 = view;
        if (view instanceof ViewStub) {
            view2 = ((ViewStub)view).inflate();
        }
        return (ViewGroup)view2;
    }

    private int selectContentView() {
        if (this.mButtonPanelSideLayout == 0) {
            return this.mAlertDialogLayout;
        }
        if (this.mButtonPanelLayoutHint == 1) {
            return this.mButtonPanelSideLayout;
        }
        return this.mAlertDialogLayout;
    }

    private void setScrollIndicators(ViewGroup viewGroup, View view, int n, int n2) {
        View view2 = this.mWindow.findViewById(R.id.scrollIndicatorUp);
        View view3 = this.mWindow.findViewById(R.id.scrollIndicatorDown);
        ViewCompat.setScrollIndicators(view, n, n2);
        if (view2 != null) {
            viewGroup.removeView(view2);
        }
        if (view3 != null) {
            viewGroup.removeView(view3);
        }
    }

    private void setupButtons(ViewGroup viewGroup) {
        int n = 0;
        this.mButtonPositive = (Button)viewGroup.findViewById(16908313);
        this.mButtonPositive.setOnClickListener(this.mButtonHandler);
        boolean bl = TextUtils.isEmpty((CharSequence)this.mButtonPositiveText);
        boolean bl2 = false;
        if (bl && this.mButtonPositiveIcon == null) {
            this.mButtonPositive.setVisibility(8);
        } else {
            this.mButtonPositive.setText(this.mButtonPositiveText);
            if (this.mButtonPositiveIcon != null) {
                this.mButtonPositiveIcon.setBounds(0, 0, this.mButtonIconDimen, this.mButtonIconDimen);
                this.mButtonPositive.setCompoundDrawables(this.mButtonPositiveIcon, null, null, null);
            }
            this.mButtonPositive.setVisibility(0);
            n = 0 | 1;
        }
        this.mButtonNegative = (Button)viewGroup.findViewById(16908314);
        this.mButtonNegative.setOnClickListener(this.mButtonHandler);
        if (TextUtils.isEmpty((CharSequence)this.mButtonNegativeText) && this.mButtonNegativeIcon == null) {
            this.mButtonNegative.setVisibility(8);
        } else {
            this.mButtonNegative.setText(this.mButtonNegativeText);
            if (this.mButtonNegativeIcon != null) {
                this.mButtonNegativeIcon.setBounds(0, 0, this.mButtonIconDimen, this.mButtonIconDimen);
                this.mButtonNegative.setCompoundDrawables(this.mButtonNegativeIcon, null, null, null);
            }
            this.mButtonNegative.setVisibility(0);
            n |= 2;
        }
        this.mButtonNeutral = (Button)viewGroup.findViewById(16908315);
        this.mButtonNeutral.setOnClickListener(this.mButtonHandler);
        if (TextUtils.isEmpty((CharSequence)this.mButtonNeutralText) && this.mButtonNeutralIcon == null) {
            this.mButtonNeutral.setVisibility(8);
        } else {
            this.mButtonNeutral.setText(this.mButtonNeutralText);
            if (this.mButtonNeutralIcon != null) {
                this.mButtonNeutralIcon.setBounds(0, 0, this.mButtonIconDimen, this.mButtonIconDimen);
                this.mButtonNeutral.setCompoundDrawables(this.mButtonNeutralIcon, null, null, null);
            }
            this.mButtonNeutral.setVisibility(0);
            n |= 4;
        }
        if (AlertController.shouldCenterSingleButton(this.mContext)) {
            if (n == 1) {
                this.centerButton(this.mButtonPositive);
            } else if (n == 2) {
                this.centerButton(this.mButtonNegative);
            } else if (n == 4) {
                this.centerButton(this.mButtonNeutral);
            }
        }
        if (n != 0) {
            bl2 = true;
        }
        if (!bl2) {
            viewGroup.setVisibility(8);
        }
    }

    private void setupContent(ViewGroup viewGroup) {
        this.mScrollView = (NestedScrollView)this.mWindow.findViewById(R.id.scrollView);
        this.mScrollView.setFocusable(false);
        this.mScrollView.setNestedScrollingEnabled(false);
        this.mMessageView = (TextView)viewGroup.findViewById(16908299);
        if (this.mMessageView == null) {
            return;
        }
        if (this.mMessage != null) {
            this.mMessageView.setText(this.mMessage);
        } else {
            this.mMessageView.setVisibility(8);
            this.mScrollView.removeView((View)this.mMessageView);
            if (this.mListView != null) {
                viewGroup = (ViewGroup)this.mScrollView.getParent();
                int n = viewGroup.indexOfChild((View)this.mScrollView);
                viewGroup.removeViewAt(n);
                viewGroup.addView((View)this.mListView, n, new ViewGroup.LayoutParams(-1, -1));
            } else {
                viewGroup.setVisibility(8);
            }
        }
    }

    private void setupCustomContent(ViewGroup viewGroup) {
        Object object = this.mView;
        boolean bl = false;
        if ((object = object != null ? this.mView : (this.mViewLayoutResId != 0 ? LayoutInflater.from((Context)this.mContext).inflate(this.mViewLayoutResId, viewGroup, false) : null)) != null) {
            bl = true;
        }
        if (!bl || !AlertController.canTextInput(object)) {
            this.mWindow.setFlags(131072, 131072);
        }
        if (bl) {
            FrameLayout frameLayout = (FrameLayout)this.mWindow.findViewById(R.id.custom);
            frameLayout.addView(object, new ViewGroup.LayoutParams(-1, -1));
            if (this.mViewSpacingSpecified) {
                frameLayout.setPadding(this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
            }
            if (this.mListView != null) {
                ((LinearLayoutCompat.LayoutParams)viewGroup.getLayoutParams()).weight = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
    }

    private void setupTitle(ViewGroup viewGroup) {
        if (this.mCustomTitleView != null) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
            viewGroup.addView(this.mCustomTitleView, 0, layoutParams);
            this.mWindow.findViewById(R.id.title_template).setVisibility(8);
        } else {
            this.mIconView = (ImageView)this.mWindow.findViewById(16908294);
            if (TextUtils.isEmpty((CharSequence)this.mTitle) ^ true && this.mShowTitle) {
                this.mTitleView = (TextView)this.mWindow.findViewById(R.id.alertTitle);
                this.mTitleView.setText(this.mTitle);
                if (this.mIconId != 0) {
                    this.mIconView.setImageResource(this.mIconId);
                } else if (this.mIcon != null) {
                    this.mIconView.setImageDrawable(this.mIcon);
                } else {
                    this.mTitleView.setPadding(this.mIconView.getPaddingLeft(), this.mIconView.getPaddingTop(), this.mIconView.getPaddingRight(), this.mIconView.getPaddingBottom());
                    this.mIconView.setVisibility(8);
                }
            } else {
                this.mWindow.findViewById(R.id.title_template).setVisibility(8);
                this.mIconView.setVisibility(8);
                viewGroup.setVisibility(8);
            }
        }
    }

    private void setupView() {
        Object object = this.mWindow.findViewById(R.id.parentPanel);
        View view = object.findViewById(R.id.topPanel);
        View view2 = object.findViewById(R.id.contentPanel);
        View view3 = object.findViewById(R.id.buttonPanel);
        object = (ViewGroup)object.findViewById(R.id.customPanel);
        this.setupCustomContent((ViewGroup)object);
        View view4 = object.findViewById(R.id.topPanel);
        View view5 = object.findViewById(R.id.contentPanel);
        View view6 = object.findViewById(R.id.buttonPanel);
        view = this.resolvePanel(view4, view);
        view2 = this.resolvePanel(view5, view2);
        view3 = this.resolvePanel(view6, view3);
        this.setupContent((ViewGroup)view2);
        this.setupButtons((ViewGroup)view3);
        this.setupTitle((ViewGroup)view);
        int n = object != null && object.getVisibility() != 8 ? 1 : 0;
        boolean bl = view != null && view.getVisibility() != 8;
        boolean bl2 = view3 != null && view3.getVisibility() != 8;
        if (!bl2 && view2 != null && (object = view2.findViewById(R.id.textSpacerNoButtons)) != null) {
            object.setVisibility(0);
        }
        if (bl) {
            if (this.mScrollView != null) {
                this.mScrollView.setClipToPadding(true);
            }
            object = null;
            if (this.mMessage != null || this.mListView != null) {
                object = view.findViewById(R.id.titleDividerNoCustom);
            }
            if (object != null) {
                object.setVisibility(0);
            }
        } else if (view2 != null && (object = view2.findViewById(R.id.textSpacerNoTitle)) != null) {
            object.setVisibility(0);
        }
        int n2 = 0;
        if (this.mListView instanceof RecycleListView) {
            ((RecycleListView)this.mListView).setHasDecor(bl, bl2);
        }
        if (n == 0 && (object = this.mListView != null ? this.mListView : this.mScrollView) != null) {
            n = bl ? 1 : 0;
            if (bl2) {
                n2 = 2;
            }
            this.setScrollIndicators((ViewGroup)view2, (View)object, n | n2, 3);
        }
        if ((object = this.mListView) != null && this.mAdapter != null) {
            object.setAdapter(this.mAdapter);
            n = this.mCheckedItem;
            if (n > -1) {
                object.setItemChecked(n, true);
                object.setSelection(n);
            }
        }
    }

    private static boolean shouldCenterSingleButton(Context context) {
        TypedValue typedValue = new TypedValue();
        context = context.getTheme();
        int n = R.attr.alertDialogCenterButtons;
        boolean bl = true;
        context.resolveAttribute(n, typedValue, true);
        if (typedValue.data == 0) {
            bl = false;
        }
        return bl;
    }

    public Button getButton(int n) {
        switch (n) {
            default: {
                return null;
            }
            case -1: {
                return this.mButtonPositive;
            }
            case -2: {
                return this.mButtonNegative;
            }
            case -3: 
        }
        return this.mButtonNeutral;
    }

    public int getIconAttributeResId(int n) {
        TypedValue typedValue = new TypedValue();
        this.mContext.getTheme().resolveAttribute(n, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public void installContent() {
        int n = this.selectContentView();
        this.mDialog.setContentView(n);
        this.setupView();
    }

    public boolean onKeyDown(int n, KeyEvent keyEvent) {
        boolean bl = this.mScrollView != null && this.mScrollView.executeKeyEvent(keyEvent);
        return bl;
    }

    public boolean onKeyUp(int n, KeyEvent keyEvent) {
        boolean bl = this.mScrollView != null && this.mScrollView.executeKeyEvent(keyEvent);
        return bl;
    }

    public void setButton(int n, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable2) {
        Message message2 = message;
        if (message == null) {
            message2 = message;
            if (onClickListener != null) {
                message2 = this.mHandler.obtainMessage(n, (Object)onClickListener);
            }
        }
        switch (n) {
            default: {
                throw new IllegalArgumentException("Button does not exist");
            }
            case -1: {
                this.mButtonPositiveText = charSequence;
                this.mButtonPositiveMessage = message2;
                this.mButtonPositiveIcon = drawable2;
                break;
            }
            case -2: {
                this.mButtonNegativeText = charSequence;
                this.mButtonNegativeMessage = message2;
                this.mButtonNegativeIcon = drawable2;
                break;
            }
            case -3: {
                this.mButtonNeutralText = charSequence;
                this.mButtonNeutralMessage = message2;
                this.mButtonNeutralIcon = drawable2;
            }
        }
    }

    public void setButtonPanelLayoutHint(int n) {
        this.mButtonPanelLayoutHint = n;
    }

    public void setCustomTitle(View view) {
        this.mCustomTitleView = view;
    }

    public void setIcon(int n) {
        this.mIcon = null;
        this.mIconId = n;
        if (this.mIconView != null) {
            if (n != 0) {
                this.mIconView.setVisibility(0);
                this.mIconView.setImageResource(this.mIconId);
            } else {
                this.mIconView.setVisibility(8);
            }
        }
    }

    public void setIcon(Drawable drawable2) {
        this.mIcon = drawable2;
        this.mIconId = 0;
        if (this.mIconView != null) {
            if (drawable2 != null) {
                this.mIconView.setVisibility(0);
                this.mIconView.setImageDrawable(drawable2);
            } else {
                this.mIconView.setVisibility(8);
            }
        }
    }

    public void setMessage(CharSequence charSequence) {
        this.mMessage = charSequence;
        if (this.mMessageView != null) {
            this.mMessageView.setText(charSequence);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        if (this.mTitleView != null) {
            this.mTitleView.setText(charSequence);
        }
    }

    public void setView(int n) {
        this.mView = null;
        this.mViewLayoutResId = n;
        this.mViewSpacingSpecified = false;
    }

    public void setView(View view) {
        this.mView = view;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = false;
    }

    public void setView(View view, int n, int n2, int n3, int n4) {
        this.mView = view;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = true;
        this.mViewSpacingLeft = n;
        this.mViewSpacingTop = n2;
        this.mViewSpacingRight = n3;
        this.mViewSpacingBottom = n4;
    }

    public static class AlertParams {
        public ListAdapter mAdapter;
        public boolean mCancelable;
        public int mCheckedItem = -1;
        public boolean[] mCheckedItems;
        public final Context mContext;
        public Cursor mCursor;
        public View mCustomTitleView;
        public boolean mForceInverseBackground;
        public Drawable mIcon;
        public int mIconAttrId = 0;
        public int mIconId = 0;
        public final LayoutInflater mInflater;
        public String mIsCheckedColumn;
        public boolean mIsMultiChoice;
        public boolean mIsSingleChoice;
        public CharSequence[] mItems;
        public String mLabelColumn;
        public CharSequence mMessage;
        public Drawable mNegativeButtonIcon;
        public DialogInterface.OnClickListener mNegativeButtonListener;
        public CharSequence mNegativeButtonText;
        public Drawable mNeutralButtonIcon;
        public DialogInterface.OnClickListener mNeutralButtonListener;
        public CharSequence mNeutralButtonText;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnMultiChoiceClickListener mOnCheckboxClickListener;
        public DialogInterface.OnClickListener mOnClickListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public AdapterView.OnItemSelectedListener mOnItemSelectedListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public OnPrepareListViewListener mOnPrepareListViewListener;
        public Drawable mPositiveButtonIcon;
        public DialogInterface.OnClickListener mPositiveButtonListener;
        public CharSequence mPositiveButtonText;
        public boolean mRecycleOnMeasure = true;
        public CharSequence mTitle;
        public View mView;
        public int mViewLayoutResId;
        public int mViewSpacingBottom;
        public int mViewSpacingLeft;
        public int mViewSpacingRight;
        public boolean mViewSpacingSpecified = false;
        public int mViewSpacingTop;

        public AlertParams(Context context) {
            this.mContext = context;
            this.mCancelable = true;
            this.mInflater = (LayoutInflater)context.getSystemService("layout_inflater");
        }

        private void createListView(AlertController alertController) {
            Object object;
            RecycleListView recycleListView = (RecycleListView)this.mInflater.inflate(alertController.mListLayout, null);
            if (this.mIsMultiChoice) {
                object = this.mCursor == null ? new ArrayAdapter<CharSequence>(this, this.mContext, alertController.mMultiChoiceItemLayout, 16908308, this.mItems, recycleListView){
                    final AlertParams this$0;
                    final RecycleListView val$listView;
                    {
                        this.this$0 = alertParams;
                        this.val$listView = recycleListView;
                        super(context, n, n2, (Object[])charSequenceArray);
                    }

                    public View getView(int n, View view, ViewGroup viewGroup) {
                        view = super.getView(n, view, viewGroup);
                        if (this.this$0.mCheckedItems != null && this.this$0.mCheckedItems[n]) {
                            this.val$listView.setItemChecked(n, true);
                        }
                        return view;
                    }
                } : new CursorAdapter(this, this.mContext, this.mCursor, false, recycleListView, alertController){
                    private final int mIsCheckedIndex;
                    private final int mLabelIndex;
                    final AlertParams this$0;
                    final AlertController val$dialog;
                    final RecycleListView val$listView;
                    {
                        this.this$0 = alertParams;
                        this.val$listView = recycleListView;
                        this.val$dialog = alertController;
                        super(context, cursor, bl);
                        alertParams = this.getCursor();
                        this.mLabelIndex = alertParams.getColumnIndexOrThrow(this.this$0.mLabelColumn);
                        this.mIsCheckedIndex = alertParams.getColumnIndexOrThrow(this.this$0.mIsCheckedColumn);
                    }

                    public void bindView(View object, Context context, Cursor cursor) {
                        ((CheckedTextView)object.findViewById(16908308)).setText((CharSequence)cursor.getString(this.mLabelIndex));
                        object = this.val$listView;
                        int n = cursor.getPosition();
                        int n2 = cursor.getInt(this.mIsCheckedIndex);
                        boolean bl = true;
                        if (n2 != 1) {
                            bl = false;
                        }
                        object.setItemChecked(n, bl);
                    }

                    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                        return this.this$0.mInflater.inflate(this.val$dialog.mMultiChoiceItemLayout, viewGroup, false);
                    }
                };
            } else {
                int n = this.mIsSingleChoice ? alertController.mSingleChoiceItemLayout : alertController.mListItemLayout;
                object = this.mCursor != null ? new SimpleCursorAdapter(this.mContext, n, this.mCursor, new String[]{this.mLabelColumn}, new int[]{16908308}) : (this.mAdapter != null ? this.mAdapter : new CheckedItemAdapter(this.mContext, n, 16908308, this.mItems));
            }
            if (this.mOnPrepareListViewListener != null) {
                this.mOnPrepareListViewListener.onPrepareListView(recycleListView);
            }
            alertController.mAdapter = object;
            alertController.mCheckedItem = this.mCheckedItem;
            if (this.mOnClickListener != null) {
                recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener(this, alertController){
                    final AlertParams this$0;
                    final AlertController val$dialog;
                    {
                        this.this$0 = alertParams;
                        this.val$dialog = alertController;
                    }

                    public void onItemClick(AdapterView<?> adapterView, View view, int n, long l) {
                        this.this$0.mOnClickListener.onClick((DialogInterface)this.val$dialog.mDialog, n);
                        if (!this.this$0.mIsSingleChoice) {
                            this.val$dialog.mDialog.dismiss();
                        }
                    }
                });
            } else if (this.mOnCheckboxClickListener != null) {
                recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener(this, recycleListView, alertController){
                    final AlertParams this$0;
                    final AlertController val$dialog;
                    final RecycleListView val$listView;
                    {
                        this.this$0 = alertParams;
                        this.val$listView = recycleListView;
                        this.val$dialog = alertController;
                    }

                    public void onItemClick(AdapterView<?> adapterView, View view, int n, long l) {
                        if (this.this$0.mCheckedItems != null) {
                            this.this$0.mCheckedItems[n] = this.val$listView.isItemChecked(n);
                        }
                        this.this$0.mOnCheckboxClickListener.onClick((DialogInterface)this.val$dialog.mDialog, n, this.val$listView.isItemChecked(n));
                    }
                });
            }
            if (this.mOnItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(this.mOnItemSelectedListener);
            }
            if (this.mIsSingleChoice) {
                recycleListView.setChoiceMode(1);
            } else if (this.mIsMultiChoice) {
                recycleListView.setChoiceMode(2);
            }
            alertController.mListView = recycleListView;
        }

        public void apply(AlertController alertController) {
            if (this.mCustomTitleView != null) {
                alertController.setCustomTitle(this.mCustomTitleView);
            } else {
                if (this.mTitle != null) {
                    alertController.setTitle(this.mTitle);
                }
                if (this.mIcon != null) {
                    alertController.setIcon(this.mIcon);
                }
                if (this.mIconId != 0) {
                    alertController.setIcon(this.mIconId);
                }
                if (this.mIconAttrId != 0) {
                    alertController.setIcon(alertController.getIconAttributeResId(this.mIconAttrId));
                }
            }
            if (this.mMessage != null) {
                alertController.setMessage(this.mMessage);
            }
            if (this.mPositiveButtonText != null || this.mPositiveButtonIcon != null) {
                alertController.setButton(-1, this.mPositiveButtonText, this.mPositiveButtonListener, null, this.mPositiveButtonIcon);
            }
            if (this.mNegativeButtonText != null || this.mNegativeButtonIcon != null) {
                alertController.setButton(-2, this.mNegativeButtonText, this.mNegativeButtonListener, null, this.mNegativeButtonIcon);
            }
            if (this.mNeutralButtonText != null || this.mNeutralButtonIcon != null) {
                alertController.setButton(-3, this.mNeutralButtonText, this.mNeutralButtonListener, null, this.mNeutralButtonIcon);
            }
            if (this.mItems != null || this.mCursor != null || this.mAdapter != null) {
                this.createListView(alertController);
            }
            if (this.mView != null) {
                if (this.mViewSpacingSpecified) {
                    alertController.setView(this.mView, this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
                } else {
                    alertController.setView(this.mView);
                }
            } else if (this.mViewLayoutResId != 0) {
                alertController.setView(this.mViewLayoutResId);
            }
        }

        public static interface OnPrepareListViewListener {
            public void onPrepareListView(ListView var1);
        }
    }

    private static final class ButtonHandler
    extends Handler {
        private static final int MSG_DISMISS_DIALOG = 1;
        private WeakReference<DialogInterface> mDialog;

        public ButtonHandler(DialogInterface dialogInterface) {
            this.mDialog = new WeakReference<DialogInterface>(dialogInterface);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                default: {
                    break;
                }
                case 1: {
                    ((DialogInterface)message.obj).dismiss();
                    break;
                }
                case -3: 
                case -2: 
                case -1: {
                    ((DialogInterface.OnClickListener)message.obj).onClick((DialogInterface)this.mDialog.get(), message.what);
                }
            }
        }
    }

    private static class CheckedItemAdapter
    extends ArrayAdapter<CharSequence> {
        public CheckedItemAdapter(Context context, int n, int n2, CharSequence[] charSequenceArray) {
            super(context, n, n2, (Object[])charSequenceArray);
        }

        public long getItemId(int n) {
            return n;
        }

        public boolean hasStableIds() {
            return true;
        }
    }

    public static class RecycleListView
    extends ListView {
        private final int mPaddingBottomNoButtons;
        private final int mPaddingTopNoTitle;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            context = context.obtainStyledAttributes(attributeSet, R.styleable.RecycleListView);
            this.mPaddingBottomNoButtons = context.getDimensionPixelOffset(R.styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.mPaddingTopNoTitle = context.getDimensionPixelOffset(R.styleable.RecycleListView_paddingTopNoTitle, -1);
        }

        public void setHasDecor(boolean bl, boolean bl2) {
            if (!bl2 || !bl) {
                int n = this.getPaddingLeft();
                int n2 = bl ? this.getPaddingTop() : this.mPaddingTopNoTitle;
                int n3 = this.getPaddingRight();
                int n4 = bl2 ? this.getPaddingBottom() : this.mPaddingBottomNoButtons;
                this.setPadding(n, n2, n3, n4);
            }
        }
    }
}

