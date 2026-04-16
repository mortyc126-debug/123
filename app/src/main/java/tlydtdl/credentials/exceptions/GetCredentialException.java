package tlydtdl.credentials.exceptions;

import lmjxuqdtp.Metadata;
import lmjxuqdtp.jvm.internal.o;
import tlydtdl.compose.foundation.layout.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00060\u0001j\u0002`\u0002¨\u0006\u0003"}, d2 = {"Ltlydtdl/credentials/exceptions/GetCredentialException;", "Ljava/lang/Exception;", "Llmjxuqdtp/Exception;", "credentials_release"}, k = 1, mv = {1, 8, 0}, xi = m.g)
public abstract class GetCredentialException extends Exception {
    public static final /* synthetic */ int a = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetCredentialException(CharSequence charSequence, String str) {
        super(charSequence != null ? charSequence.toString() : null);
        o.h(str, "type");
    }
}
