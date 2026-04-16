/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package androidx.work.impl;

import android.content.Context;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.work.impl.WorkDatabase;

public final class WorkDatabase$Companion$$ExternalSyntheticLambda0
implements SupportSQLiteOpenHelper.Factory {
    public final Context f$0;

    public /* synthetic */ WorkDatabase$Companion$$ExternalSyntheticLambda0(Context context) {
        this.f$0 = context;
    }

    @Override
    public final SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration2) {
        return WorkDatabase.Companion.$r8$lambda$ZkS5S0p_73DOI66Tm39UHOpqbt0(this.f$0, configuration2);
    }
}

