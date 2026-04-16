package org.apache.commons.net.imap;

import java.io.IOException;
import okhttp3.HttpUrl;
import org.apache.commons.net.imap.IMAP;

/* JADX INFO: loaded from: classes2.dex */
public class IMAPClient extends IMAP {
    private static final char DQUOTE = '\"';
    private static final String DQUOTE_S = "\"";

    public enum FETCH_ITEM_NAMES {
        ALL,
        FAST,
        FULL,
        BODY,
        BODYSTRUCTURE,
        ENVELOPE,
        FLAGS,
        INTERNALDATE,
        RFC822,
        UID
    }

    public enum SEARCH_CRITERIA {
        ALL,
        ANSWERED,
        BCC,
        BEFORE,
        BODY,
        CC,
        DELETED,
        DRAFT,
        FLAGGED,
        FROM,
        HEADER,
        KEYWORD,
        LARGER,
        NEW,
        NOT,
        OLD,
        ON,
        OR,
        RECENT,
        SEEN,
        SENTBEFORE,
        SENTON,
        SENTSINCE,
        SINCE,
        SMALLER,
        SUBJECT,
        TEXT,
        TO,
        UID,
        UNANSWERED,
        UNDELETED,
        UNDRAFT,
        UNFLAGGED,
        UNKEYWORD,
        UNSEEN
    }

    public enum STATUS_DATA_ITEMS {
        MESSAGES,
        RECENT,
        UIDNEXT,
        UIDVALIDITY,
        UNSEEN
    }

    @Deprecated
    public boolean append(String mailboxName) throws IOException {
        return append(mailboxName, null, null);
    }

    @Deprecated
    public boolean append(String mailboxName, String flags, String datetime) throws IOException {
        String args = mailboxName;
        if (flags != null) {
            args = args + " " + flags;
        }
        if (datetime != null) {
            if (datetime.charAt(0) == '{') {
                args = args + " " + datetime;
            } else {
                args = args + " {" + datetime + "}";
            }
        }
        return doCommand(IMAPCommand.APPEND, args);
    }

    public boolean append(String mailboxName, String flags, String datetime, String message) throws IOException {
        StringBuilder args = new StringBuilder(quoteMailboxName(mailboxName));
        if (flags != null) {
            args.append(" ").append(flags);
        }
        if (datetime != null) {
            args.append(" ");
            if (datetime.charAt(0) == '\"') {
                args.append(datetime);
            } else {
                args.append('\"').append(datetime).append('\"');
            }
        }
        args.append(" ");
        if (message.startsWith(DQUOTE_S) && message.endsWith(DQUOTE_S)) {
            args.append(message);
            return doCommand(IMAPCommand.APPEND, args.toString());
        }
        args.append('{').append(message.getBytes("ISO-8859-1").length).append('}');
        int status = sendCommand(IMAPCommand.APPEND, args.toString());
        return IMAPReply.isContinuation(status) && IMAPReply.isSuccess(sendData(message));
    }

    public boolean capability() throws IOException {
        return doCommand(IMAPCommand.CAPABILITY);
    }

    public boolean check() throws IOException {
        return doCommand(IMAPCommand.CHECK);
    }

    public boolean close() throws IOException {
        return doCommand(IMAPCommand.CLOSE);
    }

    public boolean copy(String sequenceSet, String mailboxName) throws IOException {
        return doCommand(IMAPCommand.COPY, sequenceSet + " " + quoteMailboxName(mailboxName));
    }

    public boolean create(String mailboxName) throws IOException {
        return doCommand(IMAPCommand.CREATE, quoteMailboxName(mailboxName));
    }

    public boolean delete(String mailboxName) throws IOException {
        return doCommand(IMAPCommand.DELETE, quoteMailboxName(mailboxName));
    }

    public boolean examine(String mailboxName) throws IOException {
        return doCommand(IMAPCommand.EXAMINE, quoteMailboxName(mailboxName));
    }

    public boolean expunge() throws IOException {
        return doCommand(IMAPCommand.EXPUNGE);
    }

    public boolean fetch(String sequenceSet, String itemNames) throws IOException {
        return doCommand(IMAPCommand.FETCH, sequenceSet + " " + itemNames);
    }

    public boolean list(String refName, String mailboxName) throws IOException {
        return doCommand(IMAPCommand.LIST, quoteMailboxName(refName) + " " + quoteMailboxName(mailboxName));
    }

    public boolean login(String username, String password) throws IOException {
        if (getState() != IMAP.IMAPState.NOT_AUTH_STATE || !doCommand(IMAPCommand.LOGIN, username + " " + password)) {
            return false;
        }
        setState(IMAP.IMAPState.AUTH_STATE);
        return true;
    }

    public boolean logout() throws IOException {
        return doCommand(IMAPCommand.LOGOUT);
    }

    public boolean lsub(String refName, String mailboxName) throws IOException {
        return doCommand(IMAPCommand.LSUB, quoteMailboxName(refName) + " " + quoteMailboxName(mailboxName));
    }

    public boolean noop() throws IOException {
        return doCommand(IMAPCommand.NOOP);
    }

    public boolean rename(String oldMailboxName, String newMailboxName) throws IOException {
        return doCommand(IMAPCommand.RENAME, quoteMailboxName(oldMailboxName) + " " + quoteMailboxName(newMailboxName));
    }

    public boolean search(String criteria) throws IOException {
        return search(null, criteria);
    }

    public boolean search(String charset, String criteria) throws IOException {
        String args = HttpUrl.FRAGMENT_ENCODE_SET;
        if (charset != null) {
            args = HttpUrl.FRAGMENT_ENCODE_SET + "CHARSET " + charset;
        }
        return doCommand(IMAPCommand.SEARCH, args + criteria);
    }

    public boolean select(String mailboxName) throws IOException {
        return doCommand(IMAPCommand.SELECT, quoteMailboxName(mailboxName));
    }

    public boolean status(String mailboxName, String[] itemNames) throws IOException {
        if (itemNames == null || itemNames.length < 1) {
            throw new IllegalArgumentException("STATUS command requires at least one data item name");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(quoteMailboxName(mailboxName));
        sb.append(" (");
        for (int i = 0; i < itemNames.length; i++) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(itemNames[i]);
        }
        sb.append(")");
        return doCommand(IMAPCommand.STATUS, sb.toString());
    }

    public boolean store(String sequenceSet, String itemNames, String itemValues) throws IOException {
        return doCommand(IMAPCommand.STORE, sequenceSet + " " + itemNames + " " + itemValues);
    }

    public boolean subscribe(String mailboxName) throws IOException {
        return doCommand(IMAPCommand.SUBSCRIBE, quoteMailboxName(mailboxName));
    }

    public boolean uid(String command, String commandArgs) throws IOException {
        return doCommand(IMAPCommand.UID, command + " " + commandArgs);
    }

    public boolean unsubscribe(String mailboxName) throws IOException {
        return doCommand(IMAPCommand.UNSUBSCRIBE, quoteMailboxName(mailboxName));
    }
}
