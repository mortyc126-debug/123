/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 */
package androidx.core.provider;

import android.util.Base64;
import androidx.core.util.Preconditions;
import java.util.List;

public final class FontRequest {
    private final List<List<byte[]>> mCertificates;
    private final int mCertificatesArray;
    private final String mIdentifier;
    private final String mProviderAuthority;
    private final String mProviderPackage;
    private final String mQuery;

    public FontRequest(String string2, String string3, String string4, int n) {
        this.mProviderAuthority = Preconditions.checkNotNull(string2);
        this.mProviderPackage = Preconditions.checkNotNull(string3);
        this.mQuery = Preconditions.checkNotNull(string4);
        this.mCertificates = null;
        boolean bl = n != 0;
        Preconditions.checkArgument(bl);
        this.mCertificatesArray = n;
        this.mIdentifier = this.createIdentifier(string2, string3, string4);
    }

    public FontRequest(String string2, String string3, String string4, List<List<byte[]>> list) {
        this.mProviderAuthority = Preconditions.checkNotNull(string2);
        this.mProviderPackage = Preconditions.checkNotNull(string3);
        this.mQuery = Preconditions.checkNotNull(string4);
        this.mCertificates = Preconditions.checkNotNull(list);
        this.mCertificatesArray = 0;
        this.mIdentifier = this.createIdentifier(string2, string3, string4);
    }

    private String createIdentifier(String string2, String string3, String string4) {
        return string2 + "-" + string3 + "-" + string4;
    }

    public List<List<byte[]>> getCertificates() {
        return this.mCertificates;
    }

    public int getCertificatesArrayResId() {
        return this.mCertificatesArray;
    }

    String getId() {
        return this.mIdentifier;
    }

    @Deprecated
    public String getIdentifier() {
        return this.mIdentifier;
    }

    public String getProviderAuthority() {
        return this.mProviderAuthority;
    }

    public String getProviderPackage() {
        return this.mProviderPackage;
    }

    public String getQuery() {
        return this.mQuery;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FontRequest {mProviderAuthority: " + this.mProviderAuthority + ", mProviderPackage: " + this.mProviderPackage + ", mQuery: " + this.mQuery + ", mCertificates:");
        for (int i = 0; i < this.mCertificates.size(); ++i) {
            stringBuilder.append(" [");
            List<byte[]> list = this.mCertificates.get(i);
            for (int j = 0; j < list.size(); ++j) {
                stringBuilder.append(" \"");
                stringBuilder.append(Base64.encodeToString((byte[])list.get(j), (int)0));
                stringBuilder.append("\"");
            }
            stringBuilder.append(" ]");
        }
        stringBuilder.append("}");
        stringBuilder.append("mCertificatesArray: " + this.mCertificatesArray);
        return stringBuilder.toString();
    }
}

