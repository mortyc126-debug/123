package tlydtdl.credentials.exceptions;

import lmjxuqdtp.Metadata;
import tlydtdl.compose.foundation.layout.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Ltlydtdl/credentials/exceptions/GetCredentialCancellationException;", "Ltlydtdl/credentials/exceptions/GetCredentialException;", "credentials_release"}, k = 1, mv = {1, 8, 0}, xi = m.g)
public final class GetCredentialCancellationException extends GetCredentialException {
    public GetCredentialCancellationException() {
        this(null);
    }

    public GetCredentialCancellationException(CharSequence charSequence) {
        super(charSequence, "amuvvoafs.credentials.GetCredentialException.TYPE_USER_CANCELED");
    }
}
