package org.apache.http.params;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class SyncBasicHttpParams extends BasicHttpParams {
    private static final long serialVersionUID = 5387834869062660642L;

    @Override // org.apache.http.params.BasicHttpParams, org.apache.http.params.HttpParams
    public synchronized boolean removeParameter(String name) {
        return super.removeParameter(name);
    }

    @Override // org.apache.http.params.BasicHttpParams, org.apache.http.params.HttpParams
    public synchronized HttpParams setParameter(String name, Object value) {
        return super.setParameter(name, value);
    }

    @Override // org.apache.http.params.BasicHttpParams, org.apache.http.params.HttpParams
    public synchronized Object getParameter(String name) {
        return super.getParameter(name);
    }

    @Override // org.apache.http.params.BasicHttpParams
    public synchronized boolean isParameterSet(String name) {
        return super.isParameterSet(name);
    }

    @Override // org.apache.http.params.BasicHttpParams
    public synchronized boolean isParameterSetLocally(String name) {
        return super.isParameterSetLocally(name);
    }

    @Override // org.apache.http.params.BasicHttpParams
    public synchronized void setParameters(String[] names, Object value) {
        super.setParameters(names, value);
    }

    @Override // org.apache.http.params.BasicHttpParams
    public synchronized void clear() {
        super.clear();
    }

    @Override // org.apache.http.params.BasicHttpParams
    public synchronized Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
