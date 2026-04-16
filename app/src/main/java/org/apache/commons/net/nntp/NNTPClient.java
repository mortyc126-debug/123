package org.apache.commons.net.nntp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Vector;
import org.apache.commons.net.MalformedServerReplyException;
import org.apache.commons.net.io.DotTerminatedMessageReader;
import org.apache.commons.net.io.DotTerminatedMessageWriter;
import org.apache.commons.net.io.Util;
import org.apache.commons.net.util.NetConstants;

/* JADX INFO: loaded from: classes2.dex */
public class NNTPClient extends NNTP {
    private static final NewsgroupInfo[] EMPTY_NEWSGROUP_INFO_ARRAY = new NewsgroupInfo[0];

    static Article parseArticleEntry(String line) {
        Article article = new Article();
        article.setSubject(line);
        String[] parts = line.split("\t");
        if (parts.length > 6) {
            int i = 0 + 1;
            try {
                article.setArticleNumber(Long.parseLong(parts[0]));
                int i2 = i + 1;
                try {
                    article.setSubject(parts[i]);
                    int i3 = i2 + 1;
                    article.setFrom(parts[i2]);
                    int i4 = i3 + 1;
                    article.setDate(parts[i3]);
                    int i6 = i4 + 1;
                    article.setArticleId(parts[i4]);
                    i2 = i6 + 1;
                    article.addReference(parts[i6]);
                } catch (NumberFormatException e) {
                }
            } catch (NumberFormatException e2) {
            }
        }
        return article;
    }

    private static void parseGroupReply(String reply, NewsgroupInfo info) throws MalformedServerReplyException {
        String[] tokens = reply.split(" ");
        if (tokens.length >= 5) {
            int i = 1 + 1;
            try {
                info.setArticleCount(Long.parseLong(tokens[1]));
                int i2 = i + 1;
                try {
                    info.setFirstArticle(Long.parseLong(tokens[i]));
                    int i3 = i2 + 1;
                    info.setLastArticle(Long.parseLong(tokens[i2]));
                    i2 = i3 + 1;
                    info.setNewsgroup(tokens[i3]);
                    info.setPostingPermission(0);
                    return;
                } catch (NumberFormatException e) {
                }
            } catch (NumberFormatException e2) {
            }
        }
        throw new MalformedServerReplyException("Could not parse newsgroup info.\nServer reply: " + reply);
    }

    static NewsgroupInfo parseNewsgroupListEntry(String entry) {
        long lastNum;
        int i;
        String[] tokens = entry.split(" ");
        if (tokens.length < 4) {
            return null;
        }
        NewsgroupInfo result = new NewsgroupInfo();
        int i2 = 0 + 1;
        result.setNewsgroup(tokens[0]);
        int i3 = i2 + 1;
        try {
            lastNum = Long.parseLong(tokens[i2]);
            i = i3 + 1;
        } catch (NumberFormatException e) {
        }
        try {
            long firstNum = Long.parseLong(tokens[i3]);
            result.setFirstArticle(firstNum);
            result.setLastArticle(lastNum);
            if (firstNum == 0 && lastNum == 0) {
                result.setArticleCount(0L);
            } else {
                result.setArticleCount((lastNum - firstNum) + 1);
            }
            int i4 = i + 1;
            switch (tokens[i].charAt(0)) {
                case 'M':
                case 'm':
                    result.setPostingPermission(1);
                    return result;
                case 'N':
                case 'n':
                    result.setPostingPermission(3);
                    return result;
                case 'Y':
                case 'y':
                    result.setPostingPermission(2);
                    return result;
                default:
                    result.setPostingPermission(0);
                    return result;
            }
        } catch (NumberFormatException e2) {
            return null;
        }
    }

    private void ai2ap(ArticleInfo ai, ArticlePointer ap) {
        if (ap != null) {
            ap.articleId = ai.articleId;
            ap.articleNumber = (int) ai.articleNumber;
        }
    }

    private ArticleInfo ap2ai(ArticlePointer ap) {
        if (ap == null) {
            return null;
        }
        ArticleInfo ai = new ArticleInfo();
        return ai;
    }

    public boolean authenticate(String username, String password) throws IOException {
        int replyCode = authinfoUser(username);
        if (replyCode == 381) {
            int replyCode2 = authinfoPass(password);
            if (replyCode2 == 281) {
                this._isAllowedToPost = true;
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean completePendingCommand() throws IOException {
        return NNTPReply.isPositiveCompletion(getReply());
    }

    public Writer forwardArticle(String articleId) throws IOException {
        if (!NNTPReply.isPositiveIntermediate(ihave(articleId))) {
            return null;
        }
        return new DotTerminatedMessageWriter(this._writer_);
    }

    public Iterable<Article> iterateArticleInfo(long lowArticleNumber, long highArticleNumber) throws IOException {
        BufferedReader info = retrieveArticleInfo(lowArticleNumber, highArticleNumber);
        if (info == null) {
            throw new IOException("XOVER command failed: " + getReplyString());
        }
        return new ArticleIterator(new ReplyIterator(info, false));
    }

    public Iterable<String> iterateNewNews(NewGroupsOrNewsQuery query) throws IOException {
        if (NNTPReply.isPositiveCompletion(newnews(query.getNewsgroups(), query.getDate(), query.getTime(), query.isGMT(), query.getDistributions()))) {
            return new ReplyIterator(this._reader_);
        }
        throw new IOException("NEWNEWS command failed: " + getReplyString());
    }

    public Iterable<String> iterateNewNewsgroupListing(NewGroupsOrNewsQuery query) throws IOException {
        if (NNTPReply.isPositiveCompletion(newgroups(query.getDate(), query.getTime(), query.isGMT(), query.getDistributions()))) {
            return new ReplyIterator(this._reader_);
        }
        throw new IOException("NEWGROUPS command failed: " + getReplyString());
    }

    public Iterable<NewsgroupInfo> iterateNewNewsgroups(NewGroupsOrNewsQuery query) throws IOException {
        return new NewsgroupIterator(iterateNewNewsgroupListing(query));
    }

    public Iterable<String> iterateNewsgroupListing() throws IOException {
        if (NNTPReply.isPositiveCompletion(list())) {
            return new ReplyIterator(this._reader_);
        }
        throw new IOException("LIST command failed: " + getReplyString());
    }

    public Iterable<String> iterateNewsgroupListing(String wildmat) throws IOException {
        if (NNTPReply.isPositiveCompletion(listActive(wildmat))) {
            return new ReplyIterator(this._reader_);
        }
        throw new IOException("LIST ACTIVE " + wildmat + " command failed: " + getReplyString());
    }

    public Iterable<NewsgroupInfo> iterateNewsgroups() throws IOException {
        return new NewsgroupIterator(iterateNewsgroupListing());
    }

    public Iterable<NewsgroupInfo> iterateNewsgroups(String wildmat) throws IOException {
        return new NewsgroupIterator(iterateNewsgroupListing(wildmat));
    }

    public String listHelp() throws IOException {
        if (!NNTPReply.isInformational(help())) {
            return null;
        }
        StringWriter help = new StringWriter();
        try {
            BufferedReader reader = new DotTerminatedMessageReader(this._reader_);
            try {
                Util.copyReader(reader, help);
                String string = help.toString();
                reader.close();
                help.close();
                return string;
            } finally {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    help.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public String[] listNewNews(NewGroupsOrNewsQuery query) throws IOException {
        if (!NNTPReply.isPositiveCompletion(newnews(query.getNewsgroups(), query.getDate(), query.getTime(), query.isGMT(), query.getDistributions()))) {
            return null;
        }
        Vector<String> list = new Vector<>();
        BufferedReader reader = new DotTerminatedMessageReader(this._reader_);
        while (true) {
            try {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                list.addElement(line);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        reader.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
        reader.close();
        int size = list.size();
        if (size < 1) {
            return NetConstants.EMPTY_STRING_ARRAY;
        }
        String[] result = new String[size];
        list.copyInto(result);
        return result;
    }

    public NewsgroupInfo[] listNewNewsgroups(NewGroupsOrNewsQuery query) throws IOException {
        if (!NNTPReply.isPositiveCompletion(newgroups(query.getDate(), query.getTime(), query.isGMT(), query.getDistributions()))) {
            return null;
        }
        return readNewsgroupListing();
    }

    public NewsgroupInfo[] listNewsgroups() throws IOException {
        if (!NNTPReply.isPositiveCompletion(list())) {
            return null;
        }
        return readNewsgroupListing();
    }

    public NewsgroupInfo[] listNewsgroups(String wildmat) throws IOException {
        if (!NNTPReply.isPositiveCompletion(listActive(wildmat))) {
            return null;
        }
        return readNewsgroupListing();
    }

    public String[] listOverviewFmt() throws IOException {
        if (!NNTPReply.isPositiveCompletion(sendCommand("LIST", "OVERVIEW.FMT"))) {
            return null;
        }
        BufferedReader reader = new DotTerminatedMessageReader(this._reader_);
        try {
            ArrayList<String> list = new ArrayList<>();
            while (true) {
                String line = reader.readLine();
                if (line != null) {
                    list.add(line);
                } else {
                    String[] strArr = (String[]) list.toArray(NetConstants.EMPTY_STRING_ARRAY);
                    reader.close();
                    return strArr;
                }
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    reader.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public boolean logout() throws IOException {
        return NNTPReply.isPositiveCompletion(quit());
    }

    private void parseArticlePointer(String reply, ArticleInfo pointer) throws MalformedServerReplyException {
        String[] tokens = reply.split(" ");
        if (tokens.length >= 3) {
            int i = 1 + 1;
            try {
                pointer.articleNumber = Long.parseLong(tokens[1]);
                int i2 = i + 1;
                try {
                    pointer.articleId = tokens[i];
                    return;
                } catch (NumberFormatException e) {
                }
            } catch (NumberFormatException e2) {
            }
        }
        throw new MalformedServerReplyException("Could not parse article pointer.\nServer reply: " + reply);
    }

    public Writer postArticle() throws IOException {
        if (!NNTPReply.isPositiveIntermediate(post())) {
            return null;
        }
        return new DotTerminatedMessageWriter(this._writer_);
    }

    private NewsgroupInfo[] readNewsgroupListing() throws IOException {
        Vector<NewsgroupInfo> list = new Vector<>(2048);
        BufferedReader reader = new DotTerminatedMessageReader(this._reader_);
        while (true) {
            try {
                String line = reader.readLine();
                if (line != null) {
                    NewsgroupInfo tmp = parseNewsgroupListEntry(line);
                    if (tmp == null) {
                        throw new MalformedServerReplyException(line);
                    }
                    list.addElement(tmp);
                } else {
                    reader.close();
                    int size = list.size();
                    if (size < 1) {
                        return EMPTY_NEWSGROUP_INFO_ARRAY;
                    }
                    NewsgroupInfo[] info = new NewsgroupInfo[size];
                    list.copyInto(info);
                    return info;
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        reader.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
    }

    private BufferedReader retrieve(int command, long articleNumber, ArticleInfo pointer) throws IOException {
        if (!NNTPReply.isPositiveCompletion(sendCommand(command, Long.toString(articleNumber)))) {
            return null;
        }
        if (pointer != null) {
            parseArticlePointer(getReplyString(), pointer);
        }
        return new DotTerminatedMessageReader(this._reader_);
    }

    private BufferedReader retrieve(int command, String articleId, ArticleInfo pointer) throws IOException {
        if (articleId != null) {
            if (!NNTPReply.isPositiveCompletion(sendCommand(command, articleId))) {
                return null;
            }
        } else if (!NNTPReply.isPositiveCompletion(sendCommand(command))) {
            return null;
        }
        if (pointer != null) {
            parseArticlePointer(getReplyString(), pointer);
        }
        return new DotTerminatedMessageReader(this._reader_);
    }

    public Reader retrieveArticle() throws IOException {
        return retrieveArticle((String) null);
    }

    @Deprecated
    public Reader retrieveArticle(int articleNumber) throws IOException {
        return retrieveArticle(articleNumber);
    }

    @Deprecated
    public Reader retrieveArticle(int articleNumber, ArticlePointer pointer) throws IOException {
        ArticleInfo ai = ap2ai(pointer);
        Reader rdr = retrieveArticle(articleNumber, ai);
        ai2ap(ai, pointer);
        return rdr;
    }

    public BufferedReader retrieveArticle(long articleNumber) throws IOException {
        return retrieveArticle(articleNumber, (ArticleInfo) null);
    }

    public BufferedReader retrieveArticle(long articleNumber, ArticleInfo pointer) throws IOException {
        return retrieve(0, articleNumber, pointer);
    }

    public Reader retrieveArticle(String articleId) throws IOException {
        return retrieveArticle(articleId, (ArticleInfo) null);
    }

    public BufferedReader retrieveArticle(String articleId, ArticleInfo pointer) throws IOException {
        return retrieve(0, articleId, pointer);
    }

    @Deprecated
    public Reader retrieveArticle(String articleId, ArticlePointer pointer) throws IOException {
        ArticleInfo ai = ap2ai(pointer);
        Reader rdr = retrieveArticle(articleId, ai);
        ai2ap(ai, pointer);
        return rdr;
    }

    public Reader retrieveArticleBody() throws IOException {
        return retrieveArticleBody((String) null);
    }

    @Deprecated
    public Reader retrieveArticleBody(int a) throws IOException {
        return retrieveArticleBody(a);
    }

    @Deprecated
    public Reader retrieveArticleBody(int a, ArticlePointer ap) throws IOException {
        ArticleInfo ai = ap2ai(ap);
        Reader rdr = retrieveArticleBody(a, ai);
        ai2ap(ai, ap);
        return rdr;
    }

    public BufferedReader retrieveArticleBody(long articleNumber) throws IOException {
        return retrieveArticleBody(articleNumber, (ArticleInfo) null);
    }

    public BufferedReader retrieveArticleBody(long articleNumber, ArticleInfo pointer) throws IOException {
        return retrieve(1, articleNumber, pointer);
    }

    public Reader retrieveArticleBody(String articleId) throws IOException {
        return retrieveArticleBody(articleId, (ArticleInfo) null);
    }

    public BufferedReader retrieveArticleBody(String articleId, ArticleInfo pointer) throws IOException {
        return retrieve(1, articleId, pointer);
    }

    @Deprecated
    public Reader retrieveArticleBody(String articleId, ArticlePointer pointer) throws IOException {
        ArticleInfo ai = ap2ai(pointer);
        Reader rdr = retrieveArticleBody(articleId, ai);
        ai2ap(ai, pointer);
        return rdr;
    }

    public Reader retrieveArticleHeader() throws IOException {
        return retrieveArticleHeader((String) null);
    }

    @Deprecated
    public Reader retrieveArticleHeader(int a) throws IOException {
        return retrieveArticleHeader(a);
    }

    @Deprecated
    public Reader retrieveArticleHeader(int a, ArticlePointer ap) throws IOException {
        ArticleInfo ai = ap2ai(ap);
        Reader rdr = retrieveArticleHeader(a, ai);
        ai2ap(ai, ap);
        return rdr;
    }

    public BufferedReader retrieveArticleHeader(long articleNumber) throws IOException {
        return retrieveArticleHeader(articleNumber, (ArticleInfo) null);
    }

    public BufferedReader retrieveArticleHeader(long articleNumber, ArticleInfo pointer) throws IOException {
        return retrieve(3, articleNumber, pointer);
    }

    public Reader retrieveArticleHeader(String articleId) throws IOException {
        return retrieveArticleHeader(articleId, (ArticleInfo) null);
    }

    public BufferedReader retrieveArticleHeader(String articleId, ArticleInfo pointer) throws IOException {
        return retrieve(3, articleId, pointer);
    }

    @Deprecated
    public Reader retrieveArticleHeader(String articleId, ArticlePointer pointer) throws IOException {
        ArticleInfo ai = ap2ai(pointer);
        Reader rdr = retrieveArticleHeader(articleId, ai);
        ai2ap(ai, pointer);
        return rdr;
    }

    @Deprecated
    public Reader retrieveArticleInfo(int lowArticleNumber) throws IOException {
        return retrieveArticleInfo(lowArticleNumber);
    }

    @Deprecated
    public Reader retrieveArticleInfo(int lowArticleNumber, int highArticleNumber) throws IOException {
        return retrieveArticleInfo(lowArticleNumber, highArticleNumber);
    }

    public BufferedReader retrieveArticleInfo(long articleNumber) throws IOException {
        return retrieveArticleInfo(Long.toString(articleNumber));
    }

    public BufferedReader retrieveArticleInfo(long lowArticleNumber, long highArticleNumber) throws IOException {
        return retrieveArticleInfo(lowArticleNumber + "-" + highArticleNumber);
    }

    private BufferedReader retrieveArticleInfo(String articleRange) throws IOException {
        if (!NNTPReply.isPositiveCompletion(xover(articleRange))) {
            return null;
        }
        return new DotTerminatedMessageReader(this._reader_);
    }

    @Deprecated
    public Reader retrieveHeader(String a, int b) throws IOException {
        return retrieveHeader(a, b);
    }

    @Deprecated
    public Reader retrieveHeader(String header, int lowArticleNumber, int highArticleNumber) throws IOException {
        return retrieveHeader(header, lowArticleNumber, highArticleNumber);
    }

    public BufferedReader retrieveHeader(String header, long articleNumber) throws IOException {
        return retrieveHeader(header, Long.toString(articleNumber));
    }

    public BufferedReader retrieveHeader(String header, long lowArticleNumber, long highArticleNumber) throws IOException {
        return retrieveHeader(header, lowArticleNumber + "-" + highArticleNumber);
    }

    private BufferedReader retrieveHeader(String header, String articleRange) throws IOException {
        if (!NNTPReply.isPositiveCompletion(xhdr(header, articleRange))) {
            return null;
        }
        return new DotTerminatedMessageReader(this._reader_);
    }

    public boolean selectArticle(ArticleInfo pointer) throws IOException {
        return selectArticle((String) null, pointer);
    }

    @Deprecated
    public boolean selectArticle(ArticlePointer pointer) throws IOException {
        ArticleInfo ai = ap2ai(pointer);
        boolean b = selectArticle(ai);
        ai2ap(ai, pointer);
        return b;
    }

    @Deprecated
    public boolean selectArticle(int a) throws IOException {
        return selectArticle(a);
    }

    @Deprecated
    public boolean selectArticle(int a, ArticlePointer ap) throws IOException {
        ArticleInfo ai = ap2ai(ap);
        boolean b = selectArticle(a, ai);
        ai2ap(ai, ap);
        return b;
    }

    public boolean selectArticle(long articleNumber) throws IOException {
        return selectArticle(articleNumber, (ArticleInfo) null);
    }

    public boolean selectArticle(long articleNumber, ArticleInfo pointer) throws IOException {
        if (!NNTPReply.isPositiveCompletion(stat(articleNumber))) {
            return false;
        }
        if (pointer != null) {
            parseArticlePointer(getReplyString(), pointer);
            return true;
        }
        return true;
    }

    public boolean selectArticle(String articleId) throws IOException {
        return selectArticle(articleId, (ArticleInfo) null);
    }

    public boolean selectArticle(String articleId, ArticleInfo pointer) throws IOException {
        if (articleId != null) {
            if (!NNTPReply.isPositiveCompletion(stat(articleId))) {
                return false;
            }
        } else if (!NNTPReply.isPositiveCompletion(stat())) {
            return false;
        }
        if (pointer != null) {
            parseArticlePointer(getReplyString(), pointer);
            return true;
        }
        return true;
    }

    @Deprecated
    public boolean selectArticle(String articleId, ArticlePointer pointer) throws IOException {
        ArticleInfo ai = ap2ai(pointer);
        boolean b = selectArticle(articleId, ai);
        ai2ap(ai, pointer);
        return b;
    }

    public boolean selectNewsgroup(String newsgroup) throws IOException {
        return selectNewsgroup(newsgroup, null);
    }

    public boolean selectNewsgroup(String newsgroup, NewsgroupInfo info) throws IOException {
        if (!NNTPReply.isPositiveCompletion(group(newsgroup))) {
            return false;
        }
        if (info != null) {
            parseGroupReply(getReplyString(), info);
            return true;
        }
        return true;
    }

    public boolean selectNextArticle() throws IOException {
        return selectNextArticle((ArticleInfo) null);
    }

    public boolean selectNextArticle(ArticleInfo pointer) throws IOException {
        if (!NNTPReply.isPositiveCompletion(next())) {
            return false;
        }
        if (pointer != null) {
            parseArticlePointer(getReplyString(), pointer);
            return true;
        }
        return true;
    }

    @Deprecated
    public boolean selectNextArticle(ArticlePointer pointer) throws IOException {
        ArticleInfo ai = ap2ai(pointer);
        boolean b = selectNextArticle(ai);
        ai2ap(ai, pointer);
        return b;
    }

    public boolean selectPreviousArticle() throws IOException {
        return selectPreviousArticle((ArticleInfo) null);
    }

    public boolean selectPreviousArticle(ArticleInfo pointer) throws IOException {
        if (!NNTPReply.isPositiveCompletion(last())) {
            return false;
        }
        if (pointer != null) {
            parseArticlePointer(getReplyString(), pointer);
            return true;
        }
        return true;
    }

    @Deprecated
    public boolean selectPreviousArticle(ArticlePointer pointer) throws IOException {
        ArticleInfo ai = ap2ai(pointer);
        boolean b = selectPreviousArticle(ai);
        ai2ap(ai, pointer);
        return b;
    }
}
