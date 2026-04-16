/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentProvider
 *  android.content.ContentValues
 *  android.content.Context
 *  android.database.Cursor
 *  android.net.Uri
 */
package androidx.startup;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.startup.AppInitializer;
import androidx.startup.StartupException;
import androidx.startup.StartupLogger;

public class InitializationProvider
extends ContentProvider {
    public final int delete(Uri uri, String string2, String[] stringArray) {
        throw new IllegalStateException("Not allowed.");
    }

    public final String getType(Uri uri) {
        throw new IllegalStateException("Not allowed.");
    }

    public final Uri insert(Uri uri, ContentValues contentValues) {
        throw new IllegalStateException("Not allowed.");
    }

    public final boolean onCreate() {
        Context context = this.getContext();
        if (context != null) {
            if (context.getApplicationContext() != null) {
                AppInitializer.getInstance(context).discoverAndInitialize();
            } else {
                StartupLogger.w("Deferring initialization because `applicationContext` is null.");
            }
            return true;
        }
        throw new StartupException("Context cannot be null");
    }

    public final Cursor query(Uri uri, String[] stringArray, String string2, String[] stringArray2, String string3) {
        throw new IllegalStateException("Not allowed.");
    }

    public final int update(Uri uri, ContentValues contentValues, String string2, String[] stringArray) {
        throw new IllegalStateException("Not allowed.");
    }
}

