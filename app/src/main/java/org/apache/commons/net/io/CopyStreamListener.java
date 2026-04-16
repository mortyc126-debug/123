package org.apache.commons.net.io;

import java.util.EventListener;

/* JADX INFO: loaded from: classes2.dex */
public interface CopyStreamListener extends EventListener {
    void bytesTransferred(long j2, int i, long j3);

    void bytesTransferred(CopyStreamEvent copyStreamEvent);
}
