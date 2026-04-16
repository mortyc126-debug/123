/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Looper
 *  android.util.Log
 */
package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.collection.SparseArrayCompat;
import androidx.core.util.DebugUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class LoaderManagerImpl
extends LoaderManager {
    static boolean DEBUG = false;
    static final String TAG = "LoaderManager";
    private final LifecycleOwner mLifecycleOwner;
    private final LoaderViewModel mLoaderViewModel;

    static {
        DEBUG = false;
    }

    LoaderManagerImpl(LifecycleOwner lifecycleOwner, ViewModelStore viewModelStore) {
        this.mLifecycleOwner = lifecycleOwner;
        this.mLoaderViewModel = LoaderViewModel.getInstance(viewModelStore);
    }

    /*
     * WARNING - void declaration
     */
    private <D> Loader<D> createAndInstallLoader(int n, Bundle object, LoaderManager.LoaderCallbacks<D> object2, Loader<D> loader) {
        void var2_5;
        block9: {
            block8: {
                this.mLoaderViewModel.startCreatingLoader();
                Loader<D> loader2 = object2.onCreateLoader(n, (Bundle)object);
                if (loader2 == null) break block8;
                if (loader2.getClass().isMemberClass() && !Modifier.isStatic(loader2.getClass().getModifiers())) {
                    object2 = new StringBuilder();
                    object = new IllegalArgumentException(((StringBuilder)object2).append("Object returned from onCreateLoader must not be a non-static inner member class: ").append(loader2).toString());
                    throw object;
                }
                LoaderInfo<D> loaderInfo = new LoaderInfo<D>(n, (Bundle)object, loader2, loader);
                try {
                    if (DEBUG) {
                        object = new StringBuilder();
                        Log.v((String)TAG, (String)((StringBuilder)object).append("  Created new loader ").append(loaderInfo).toString());
                    }
                    this.mLoaderViewModel.putLoader(n, loaderInfo);
                    this.mLoaderViewModel.finishCreatingLoader();
                    return loaderInfo.setCallback(this.mLifecycleOwner, (LoaderManager.LoaderCallbacks<D>)object2);
                }
                catch (Throwable throwable) {}
                break block9;
            }
            try {
                object = new IllegalArgumentException("Object returned from onCreateLoader must not be null");
                throw object;
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        this.mLoaderViewModel.finishCreatingLoader();
        throw var2_5;
    }

    @Override
    public void destroyLoader(int n) {
        if (!this.mLoaderViewModel.isCreatingLoader()) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                LoaderInfo loaderInfo;
                if (DEBUG) {
                    Log.v((String)TAG, (String)("destroyLoader in " + this + " of " + n));
                }
                if ((loaderInfo = this.mLoaderViewModel.getLoader(n)) != null) {
                    loaderInfo.destroy(true);
                    this.mLoaderViewModel.removeLoader(n);
                }
                return;
            }
            throw new IllegalStateException("destroyLoader must be called on the main thread");
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    @Override
    @Deprecated
    public void dump(String string2, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
        this.mLoaderViewModel.dump(string2, fileDescriptor, printWriter, stringArray);
    }

    @Override
    public <D> Loader<D> getLoader(int n) {
        if (!this.mLoaderViewModel.isCreatingLoader()) {
            Object object = this.mLoaderViewModel.getLoader(n);
            object = object != null ? ((LoaderInfo)object).getLoader() : null;
            return object;
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    @Override
    public boolean hasRunningLoaders() {
        return this.mLoaderViewModel.hasRunningLoaders();
    }

    @Override
    public <D> Loader<D> initLoader(int n, Bundle bundle, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        if (!this.mLoaderViewModel.isCreatingLoader()) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                LoaderInfo<D> loaderInfo = this.mLoaderViewModel.getLoader(n);
                if (DEBUG) {
                    Log.v((String)TAG, (String)("initLoader in " + this + ": args=" + bundle));
                }
                if (loaderInfo == null) {
                    return this.createAndInstallLoader(n, bundle, loaderCallbacks, null);
                }
                if (DEBUG) {
                    Log.v((String)TAG, (String)("  Re-using existing loader " + loaderInfo));
                }
                return loaderInfo.setCallback(this.mLifecycleOwner, loaderCallbacks);
            }
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    @Override
    public void markForRedelivery() {
        this.mLoaderViewModel.markForRedelivery();
    }

    @Override
    public <D> Loader<D> restartLoader(int n, Bundle bundle, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        if (!this.mLoaderViewModel.isCreatingLoader()) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                if (DEBUG) {
                    Log.v((String)TAG, (String)("restartLoader in " + this + ": args=" + bundle));
                }
                LoaderInfo loaderInfo = this.mLoaderViewModel.getLoader(n);
                Loader loader = null;
                if (loaderInfo != null) {
                    loader = loaderInfo.destroy(false);
                }
                return this.createAndInstallLoader(n, bundle, loaderCallbacks, loader);
            }
            throw new IllegalStateException("restartLoader must be called on the main thread");
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        DebugUtils.buildShortClassTag(this.mLifecycleOwner, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public static class LoaderInfo<D>
    extends MutableLiveData<D>
    implements Loader.OnLoadCompleteListener<D> {
        private final Bundle mArgs;
        private final int mId;
        private LifecycleOwner mLifecycleOwner;
        private final Loader<D> mLoader;
        private LoaderObserver<D> mObserver;
        private Loader<D> mPriorLoader;

        LoaderInfo(int n, Bundle bundle, Loader<D> loader, Loader<D> loader2) {
            this.mId = n;
            this.mArgs = bundle;
            this.mLoader = loader;
            this.mPriorLoader = loader2;
            this.mLoader.registerListener(n, this);
        }

        Loader<D> destroy(boolean bl) {
            if (DEBUG) {
                Log.v((String)LoaderManagerImpl.TAG, (String)("  Destroying: " + this));
            }
            this.mLoader.cancelLoad();
            this.mLoader.abandon();
            LoaderObserver<D> loaderObserver = this.mObserver;
            if (loaderObserver != null) {
                this.removeObserver((Observer<? super D>)loaderObserver);
                if (bl) {
                    loaderObserver.reset();
                }
            }
            this.mLoader.unregisterListener(this);
            if (loaderObserver != null && !loaderObserver.hasDeliveredData() || bl) {
                this.mLoader.reset();
                return this.mPriorLoader;
            }
            return this.mLoader;
        }

        public void dump(String string2, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
            printWriter.print(string2);
            printWriter.print("mId=");
            printWriter.print(this.mId);
            printWriter.print(" mArgs=");
            printWriter.println(this.mArgs);
            printWriter.print(string2);
            printWriter.print("mLoader=");
            printWriter.println(this.mLoader);
            this.mLoader.dump(string2 + "  ", fileDescriptor, printWriter, stringArray);
            if (this.mObserver != null) {
                printWriter.print(string2);
                printWriter.print("mCallbacks=");
                printWriter.println(this.mObserver);
                this.mObserver.dump(string2 + "  ", printWriter);
            }
            printWriter.print(string2);
            printWriter.print("mData=");
            printWriter.println(this.getLoader().dataToString(this.getValue()));
            printWriter.print(string2);
            printWriter.print("mStarted=");
            printWriter.println(this.hasActiveObservers());
        }

        Loader<D> getLoader() {
            return this.mLoader;
        }

        boolean isCallbackWaitingForData() {
            boolean bl = this.hasActiveObservers();
            boolean bl2 = false;
            if (!bl) {
                return false;
            }
            bl = bl2;
            if (this.mObserver != null) {
                bl = bl2;
                if (!this.mObserver.hasDeliveredData()) {
                    bl = true;
                }
            }
            return bl;
        }

        void markForRedelivery() {
            LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
            LoaderObserver<D> loaderObserver = this.mObserver;
            if (lifecycleOwner != null && loaderObserver != null) {
                super.removeObserver(loaderObserver);
                this.observe(lifecycleOwner, loaderObserver);
            }
        }

        @Override
        protected void onActive() {
            if (DEBUG) {
                Log.v((String)LoaderManagerImpl.TAG, (String)("  Starting: " + this));
            }
            this.mLoader.startLoading();
        }

        @Override
        protected void onInactive() {
            if (DEBUG) {
                Log.v((String)LoaderManagerImpl.TAG, (String)("  Stopping: " + this));
            }
            this.mLoader.stopLoading();
        }

        @Override
        public void onLoadComplete(Loader<D> loader, D d) {
            if (DEBUG) {
                Log.v((String)LoaderManagerImpl.TAG, (String)("onLoadComplete: " + this));
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.setValue(d);
            } else {
                if (DEBUG) {
                    Log.w((String)LoaderManagerImpl.TAG, (String)"onLoadComplete was incorrectly called on a background thread");
                }
                this.postValue(d);
            }
        }

        @Override
        public void removeObserver(Observer<? super D> observer2) {
            super.removeObserver(observer2);
            this.mLifecycleOwner = null;
            this.mObserver = null;
        }

        Loader<D> setCallback(LifecycleOwner lifecycleOwner, LoaderManager.LoaderCallbacks<D> object) {
            object = new LoaderObserver<D>(this.mLoader, object);
            this.observe(lifecycleOwner, object);
            if (this.mObserver != null) {
                this.removeObserver((Observer<? super D>)this.mObserver);
            }
            this.mLifecycleOwner = lifecycleOwner;
            this.mObserver = object;
            return this.mLoader;
        }

        @Override
        public void setValue(D d) {
            super.setValue(d);
            if (this.mPriorLoader != null) {
                this.mPriorLoader.reset();
                this.mPriorLoader = null;
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append("LoaderInfo{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" #");
            stringBuilder.append(this.mId);
            stringBuilder.append(" : ");
            DebugUtils.buildShortClassTag(this.mLoader, stringBuilder);
            stringBuilder.append("}}");
            return stringBuilder.toString();
        }
    }

    static class LoaderObserver<D>
    implements Observer<D> {
        private final LoaderManager.LoaderCallbacks<D> mCallback;
        private boolean mDeliveredData = false;
        private final Loader<D> mLoader;

        LoaderObserver(Loader<D> loader, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
            this.mLoader = loader;
            this.mCallback = loaderCallbacks;
        }

        public void dump(String string2, PrintWriter printWriter) {
            printWriter.print(string2);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.mDeliveredData);
        }

        boolean hasDeliveredData() {
            return this.mDeliveredData;
        }

        @Override
        public void onChanged(D d) {
            if (DEBUG) {
                Log.v((String)LoaderManagerImpl.TAG, (String)("  onLoadFinished in " + this.mLoader + ": " + this.mLoader.dataToString(d)));
            }
            this.mCallback.onLoadFinished(this.mLoader, d);
            this.mDeliveredData = true;
        }

        void reset() {
            if (this.mDeliveredData) {
                if (DEBUG) {
                    Log.v((String)LoaderManagerImpl.TAG, (String)("  Resetting: " + this.mLoader));
                }
                this.mCallback.onLoaderReset(this.mLoader);
            }
        }

        public String toString() {
            return this.mCallback.toString();
        }
    }

    static class LoaderViewModel
    extends ViewModel {
        private static final ViewModelProvider.Factory FACTORY = new ViewModelProvider.Factory(){

            @Override
            public <T extends ViewModel> T create(Class<T> clazz) {
                return (T)new LoaderViewModel();
            }
        };
        private boolean mCreatingLoader = false;
        private SparseArrayCompat<LoaderInfo> mLoaders = new SparseArrayCompat();

        LoaderViewModel() {
        }

        static LoaderViewModel getInstance(ViewModelStore viewModelStore) {
            return new ViewModelProvider(viewModelStore, FACTORY).get(LoaderViewModel.class);
        }

        public void dump(String string2, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
            if (this.mLoaders.size() > 0) {
                printWriter.print(string2);
                printWriter.println("Loaders:");
                String string3 = string2 + "    ";
                for (int i = 0; i < this.mLoaders.size(); ++i) {
                    LoaderInfo loaderInfo = this.mLoaders.valueAt(i);
                    printWriter.print(string2);
                    printWriter.print("  #");
                    printWriter.print(this.mLoaders.keyAt(i));
                    printWriter.print(": ");
                    printWriter.println(loaderInfo.toString());
                    loaderInfo.dump(string3, fileDescriptor, printWriter, stringArray);
                }
            }
        }

        void finishCreatingLoader() {
            this.mCreatingLoader = false;
        }

        <D> LoaderInfo<D> getLoader(int n) {
            return this.mLoaders.get(n);
        }

        boolean hasRunningLoaders() {
            int n = this.mLoaders.size();
            for (int i = 0; i < n; ++i) {
                if (!this.mLoaders.valueAt(i).isCallbackWaitingForData()) continue;
                return true;
            }
            return false;
        }

        boolean isCreatingLoader() {
            return this.mCreatingLoader;
        }

        void markForRedelivery() {
            int n = this.mLoaders.size();
            for (int i = 0; i < n; ++i) {
                this.mLoaders.valueAt(i).markForRedelivery();
            }
        }

        @Override
        protected void onCleared() {
            super.onCleared();
            int n = this.mLoaders.size();
            for (int i = 0; i < n; ++i) {
                this.mLoaders.valueAt(i).destroy(true);
            }
            this.mLoaders.clear();
        }

        void putLoader(int n, LoaderInfo loaderInfo) {
            this.mLoaders.put(n, loaderInfo);
        }

        void removeLoader(int n) {
            this.mLoaders.remove(n);
        }

        void startCreatingLoader() {
            this.mCreatingLoader = true;
        }
    }
}

