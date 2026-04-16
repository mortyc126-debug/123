package org.apache.commons.net.smtp;

import java.util.Enumeration;
import java.util.Vector;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public final class RelayPath {
    private final String emailAddress;
    private final Vector<String> path = new Vector<>();

    public RelayPath(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void addRelay(String hostname) {
        this.path.addElement(hostname);
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(Typography.less);
        Enumeration<String> hosts = this.path.elements();
        if (hosts.hasMoreElements()) {
            buffer.append('@');
            buffer.append(hosts.nextElement());
            while (hosts.hasMoreElements()) {
                buffer.append(",@");
                buffer.append(hosts.nextElement());
            }
            buffer.append(':');
        }
        buffer.append(this.emailAddress);
        buffer.append(Typography.greater);
        return buffer.toString();
    }
}
