/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.LayoutInflater$Factory2
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.ViewGroup
 */
package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStateManager;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.strictmode.FragmentStrictMode;

class FragmentLayoutInflaterFactory
implements LayoutInflater.Factory2 {
    private static final String TAG = "FragmentManager";
    final FragmentManager mFragmentManager;

    FragmentLayoutInflaterFactory(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
    }

    public View onCreateView(View view, String object, Context object2, AttributeSet object3) {
        block18: {
            int n;
            String string2;
            int n2;
            String string3;
            block21: {
                block20: {
                    Object object4;
                    block19: {
                        if (FragmentContainerView.class.getName().equals(object)) {
                            return new FragmentContainerView((Context)object2, (AttributeSet)object3, this.mFragmentManager);
                        }
                        boolean bl = "fragment".equals(object);
                        object = null;
                        if (!bl) {
                            return null;
                        }
                        object4 = object3.getAttributeValue(null, "class");
                        TypedArray typedArray = object2.obtainStyledAttributes(object3, R.styleable.Fragment);
                        string3 = object4;
                        if (object4 == null) {
                            string3 = typedArray.getString(R.styleable.Fragment_android_name);
                        }
                        n2 = typedArray.getResourceId(R.styleable.Fragment_android_id, -1);
                        string2 = typedArray.getString(R.styleable.Fragment_android_tag);
                        typedArray.recycle();
                        if (string3 == null || !FragmentFactory.isFragmentClass(object2.getClassLoader(), string3)) break block18;
                        n = view != null ? view.getId() : 0;
                        if (n == -1 && n2 == -1 && string2 == null) {
                            throw new IllegalArgumentException(object3.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string3);
                        }
                        if (n2 != -1) {
                            object = this.mFragmentManager.findFragmentById(n2);
                        }
                        object4 = object;
                        if (object == null) {
                            object4 = object;
                            if (string2 != null) {
                                object4 = this.mFragmentManager.findFragmentByTag(string2);
                            }
                        }
                        object = object4;
                        if (object4 == null) {
                            object = object4;
                            if (n != -1) {
                                object = this.mFragmentManager.findFragmentById(n);
                            }
                        }
                        if (object != null) break block19;
                        object = this.mFragmentManager.getFragmentFactory().instantiate(object2.getClassLoader(), string3);
                        ((Fragment)object).mFromLayout = true;
                        int n3 = n2 != 0 ? n2 : n;
                        ((Fragment)object).mFragmentId = n3;
                        ((Fragment)object).mContainerId = n;
                        ((Fragment)object).mTag = string2;
                        ((Fragment)object).mInLayout = true;
                        ((Fragment)object).mFragmentManager = this.mFragmentManager;
                        ((Fragment)object).mHost = this.mFragmentManager.getHost();
                        ((Fragment)object).onInflate(this.mFragmentManager.getHost().getContext(), (AttributeSet)object3, ((Fragment)object).mSavedFragmentState);
                        object4 = this.mFragmentManager.addFragment((Fragment)object);
                        object3 = object;
                        object2 = object4;
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v((String)TAG, (String)("Fragment " + object + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(n2)));
                            object3 = object;
                            object2 = object4;
                        }
                        break block20;
                    }
                    if (((Fragment)object).mInLayout) break block21;
                    ((Fragment)object).mInLayout = true;
                    ((Fragment)object).mFragmentManager = this.mFragmentManager;
                    ((Fragment)object).mHost = this.mFragmentManager.getHost();
                    ((Fragment)object).onInflate(this.mFragmentManager.getHost().getContext(), (AttributeSet)object3, ((Fragment)object).mSavedFragmentState);
                    object4 = this.mFragmentManager.createOrGetFragmentStateManager((Fragment)object);
                    object3 = object;
                    object2 = object4;
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v((String)TAG, (String)("Retained Fragment " + object + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(n2)));
                        object2 = object4;
                        object3 = object;
                    }
                }
                FragmentStrictMode.onFragmentTagUsage((Fragment)object3, (ViewGroup)view);
                object3.mContainer = (ViewGroup)view;
                ((FragmentStateManager)object2).moveToExpectedState();
                ((FragmentStateManager)object2).ensureInflatedView();
                if (object3.mView != null) {
                    if (n2 != 0) {
                        object3.mView.setId(n2);
                    }
                    if (object3.mView.getTag() == null) {
                        object3.mView.setTag((Object)string2);
                    }
                    object3.mView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener(this, (FragmentStateManager)object2){
                        final FragmentLayoutInflaterFactory this$0;
                        final FragmentStateManager val$fragmentStateManager;
                        {
                            this.this$0 = fragmentLayoutInflaterFactory;
                            this.val$fragmentStateManager = fragmentStateManager;
                        }

                        public void onViewAttachedToWindow(View object) {
                            object = this.val$fragmentStateManager.getFragment();
                            this.val$fragmentStateManager.moveToExpectedState();
                            SpecialEffectsController.getOrCreateController((ViewGroup)object.mView.getParent(), this.this$0.mFragmentManager).forceCompleteAllOperations();
                        }

                        public void onViewDetachedFromWindow(View view) {
                        }
                    });
                    return object3.mView;
                }
                throw new IllegalStateException("Fragment " + string3 + " did not create a view.");
            }
            throw new IllegalArgumentException(object3.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(n2) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(n) + " with another fragment for " + string3);
        }
        return null;
    }

    public View onCreateView(String string2, Context context, AttributeSet attributeSet) {
        return this.onCreateView(null, string2, context, attributeSet);
    }
}

