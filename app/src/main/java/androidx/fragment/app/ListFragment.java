/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Handler
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.animation.AnimationUtils
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.LinearLayout
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class ListFragment
extends Fragment {
    static final int INTERNAL_EMPTY_ID = 0xFF0001;
    static final int INTERNAL_LIST_CONTAINER_ID = 0xFF0003;
    static final int INTERNAL_PROGRESS_CONTAINER_ID = 0xFF0002;
    ListAdapter mAdapter;
    CharSequence mEmptyText;
    View mEmptyView;
    private final Handler mHandler = new Handler();
    ListView mList;
    View mListContainer;
    boolean mListShown;
    private final AdapterView.OnItemClickListener mOnClickListener;
    View mProgressContainer;
    private final Runnable mRequestFocus = new Runnable(this){
        final ListFragment this$0;
        {
            this.this$0 = listFragment;
        }

        @Override
        public void run() {
            this.this$0.mList.focusableViewAvailable((View)this.this$0.mList);
        }
    };
    TextView mStandardEmptyView;

    public ListFragment() {
        this.mOnClickListener = new AdapterView.OnItemClickListener(this){
            final ListFragment this$0;
            {
                this.this$0 = listFragment;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int n, long l) {
                this.this$0.onListItemClick((ListView)adapterView, view, n, l);
            }
        };
    }

    private void ensureList() {
        if (this.mList != null) {
            return;
        }
        View view = this.getView();
        if (view != null) {
            if (view instanceof ListView) {
                this.mList = (ListView)view;
            } else {
                this.mStandardEmptyView = (TextView)view.findViewById(0xFF0001);
                if (this.mStandardEmptyView == null) {
                    this.mEmptyView = view.findViewById(16908292);
                } else {
                    this.mStandardEmptyView.setVisibility(8);
                }
                this.mProgressContainer = view.findViewById(0xFF0002);
                this.mListContainer = view.findViewById(0xFF0003);
                view = view.findViewById(16908298);
                if (!(view instanceof ListView)) {
                    if (view == null) {
                        throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
                    }
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
                this.mList = (ListView)view;
                if (this.mEmptyView != null) {
                    this.mList.setEmptyView(this.mEmptyView);
                } else if (this.mEmptyText != null) {
                    this.mStandardEmptyView.setText(this.mEmptyText);
                    this.mList.setEmptyView((View)this.mStandardEmptyView);
                }
            }
            this.mListShown = true;
            this.mList.setOnItemClickListener(this.mOnClickListener);
            if (this.mAdapter != null) {
                view = this.mAdapter;
                this.mAdapter = null;
                this.setListAdapter((ListAdapter)view);
            } else if (this.mProgressContainer != null) {
                this.setListShown(false, false);
            }
            this.mHandler.post(this.mRequestFocus);
            return;
        }
        throw new IllegalStateException("Content view not yet created");
    }

    private void setListShown(boolean bl, boolean bl2) {
        this.ensureList();
        if (this.mProgressContainer != null) {
            if (this.mListShown == bl) {
                return;
            }
            this.mListShown = bl;
            if (bl) {
                if (bl2) {
                    this.mProgressContainer.startAnimation(AnimationUtils.loadAnimation((Context)this.getContext(), (int)0x10A0001));
                    this.mListContainer.startAnimation(AnimationUtils.loadAnimation((Context)this.getContext(), (int)0x10A0000));
                } else {
                    this.mProgressContainer.clearAnimation();
                    this.mListContainer.clearAnimation();
                }
                this.mProgressContainer.setVisibility(8);
                this.mListContainer.setVisibility(0);
            } else {
                if (bl2) {
                    this.mProgressContainer.startAnimation(AnimationUtils.loadAnimation((Context)this.getContext(), (int)0x10A0000));
                    this.mListContainer.startAnimation(AnimationUtils.loadAnimation((Context)this.getContext(), (int)0x10A0001));
                } else {
                    this.mProgressContainer.clearAnimation();
                    this.mListContainer.clearAnimation();
                }
                this.mProgressContainer.setVisibility(0);
                this.mListContainer.setVisibility(8);
            }
            return;
        }
        throw new IllegalStateException("Can't be used with a custom content view");
    }

    public ListAdapter getListAdapter() {
        return this.mAdapter;
    }

    public ListView getListView() {
        this.ensureList();
        return this.mList;
    }

    public long getSelectedItemId() {
        this.ensureList();
        return this.mList.getSelectedItemId();
    }

    public int getSelectedItemPosition() {
        this.ensureList();
        return this.mList.getSelectedItemPosition();
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        bundle = this.requireContext();
        layoutInflater = new FrameLayout((Context)bundle);
        viewGroup = new LinearLayout((Context)bundle);
        viewGroup.setId(0xFF0002);
        viewGroup.setOrientation(1);
        viewGroup.setVisibility(8);
        viewGroup.setGravity(17);
        viewGroup.addView((View)new ProgressBar((Context)bundle, null, 16842874), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
        layoutInflater.addView((View)viewGroup, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        viewGroup = new FrameLayout((Context)bundle);
        viewGroup.setId(0xFF0003);
        TextView textView = new TextView((Context)bundle);
        textView.setId(0xFF0001);
        textView.setGravity(17);
        viewGroup.addView((View)textView, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        bundle = new ListView((Context)bundle);
        bundle.setId(16908298);
        bundle.setDrawSelectorOnTop(false);
        viewGroup.addView((View)bundle, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        layoutInflater.addView((View)viewGroup, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        layoutInflater.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        return layoutInflater;
    }

    @Override
    public void onDestroyView() {
        this.mHandler.removeCallbacks(this.mRequestFocus);
        this.mList = null;
        this.mListShown = false;
        this.mListContainer = null;
        this.mProgressContainer = null;
        this.mEmptyView = null;
        this.mStandardEmptyView = null;
        super.onDestroyView();
    }

    public void onListItemClick(ListView listView, View view, int n, long l) {
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.ensureList();
    }

    public final ListAdapter requireListAdapter() {
        ListAdapter listAdapter = this.getListAdapter();
        if (listAdapter != null) {
            return listAdapter;
        }
        throw new IllegalStateException("ListFragment " + this + " does not have a ListAdapter.");
    }

    public void setEmptyText(CharSequence charSequence) {
        this.ensureList();
        if (this.mStandardEmptyView != null) {
            this.mStandardEmptyView.setText(charSequence);
            if (this.mEmptyText == null) {
                this.mList.setEmptyView((View)this.mStandardEmptyView);
            }
            this.mEmptyText = charSequence;
            return;
        }
        throw new IllegalStateException("Can't be used with a custom content view");
    }

    public void setListAdapter(ListAdapter listAdapter) {
        ListAdapter listAdapter2 = this.mAdapter;
        boolean bl = false;
        boolean bl2 = listAdapter2 != null;
        this.mAdapter = listAdapter;
        if (this.mList != null) {
            this.mList.setAdapter(listAdapter);
            if (!this.mListShown && !bl2) {
                if (this.requireView().getWindowToken() != null) {
                    bl = true;
                }
                this.setListShown(true, bl);
            }
        }
    }

    public void setListShown(boolean bl) {
        this.setListShown(bl, true);
    }

    public void setListShownNoAnimation(boolean bl) {
        this.setListShown(bl, false);
    }

    public void setSelection(int n) {
        this.ensureList();
        this.mList.setSelection(n);
    }
}

