package org.apache.http.params;

import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public abstract class HttpAbstractParamBean {
    protected final HttpParams params;

    public HttpAbstractParamBean(HttpParams params) {
        this.params = (HttpParams) Args.notNull(params, "HTTP parameters");
    }
}
