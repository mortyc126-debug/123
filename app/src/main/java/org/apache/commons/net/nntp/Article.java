package org.apache.commons.net.nntp;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import okhttp3.HttpUrl;
import org.apache.commons.net.util.NetConstants;

/* JADX INFO: loaded from: classes2.dex */
public class Article implements Threadable {
    private String articleId;
    private long articleNumber = -1;
    private String date;
    private String from;
    private boolean isReply;
    public Article kid;
    public Article next;
    private ArrayList<String> references;
    private String simplifiedSubject;
    private String subject;

    public static void printThread(Article article) {
        printThread(article, 0, System.out);
    }

    public static void printThread(Article article, int depth) {
        printThread(article, depth, System.out);
    }

    public static void printThread(Article article, int depth, PrintStream ps) {
        for (int i = 0; i < depth; i++) {
            ps.print("==>");
        }
        ps.println(article.getSubject() + "\t" + article.getFrom() + "\t" + article.getArticleId());
        if (article.kid != null) {
            printThread(article.kid, depth + 1);
        }
        if (article.next != null) {
            printThread(article.next, depth);
        }
    }

    public static void printThread(Article article, PrintStream ps) {
        printThread(article, 0, ps);
    }

    @Deprecated
    public void addHeaderField(String name, String val) {
    }

    public void addReference(String msgId) {
        if (msgId == null || msgId.isEmpty()) {
            return;
        }
        if (this.references == null) {
            this.references = new ArrayList<>();
        }
        this.isReply = true;
        Collections.addAll(this.references, msgId.split(" "));
    }

    private void flushSubjectCache() {
        this.simplifiedSubject = null;
    }

    public String getArticleId() {
        return this.articleId;
    }

    @Deprecated
    public int getArticleNumber() {
        return (int) this.articleNumber;
    }

    public long getArticleNumberLong() {
        return this.articleNumber;
    }

    public String getDate() {
        return this.date;
    }

    public String getFrom() {
        return this.from;
    }

    public String[] getReferences() {
        if (this.references == null) {
            return NetConstants.EMPTY_STRING_ARRAY;
        }
        return (String[]) this.references.toArray(NetConstants.EMPTY_STRING_ARRAY);
    }

    public String getSubject() {
        return this.subject;
    }

    @Override // org.apache.commons.net.nntp.Threadable
    public boolean isDummy() {
        return this.articleNumber == -1;
    }

    @Override // org.apache.commons.net.nntp.Threadable
    public Threadable makeDummy() {
        return new Article();
    }

    @Override // org.apache.commons.net.nntp.Threadable
    public String messageThreadId() {
        return this.articleId;
    }

    @Override // org.apache.commons.net.nntp.Threadable
    public String[] messageThreadReferences() {
        return getReferences();
    }

    public void setArticleId(String string) {
        this.articleId = string;
    }

    @Deprecated
    public void setArticleNumber(int a) {
        this.articleNumber = a;
    }

    public void setArticleNumber(long l) {
        this.articleNumber = l;
    }

    @Override // org.apache.commons.net.nntp.Threadable
    public void setChild(Threadable child) {
        this.kid = (Article) child;
        flushSubjectCache();
    }

    public void setDate(String string) {
        this.date = string;
    }

    public void setFrom(String string) {
        this.from = string;
    }

    @Override // org.apache.commons.net.nntp.Threadable
    public void setNext(Threadable next) {
        this.next = (Article) next;
        flushSubjectCache();
    }

    public void setSubject(String string) {
        this.subject = string;
    }

    @Override // org.apache.commons.net.nntp.Threadable
    public String simplifiedSubject() {
        if (this.simplifiedSubject == null) {
            simplifySubject();
        }
        return this.simplifiedSubject;
    }

    private void simplifySubject() {
        int start = 0;
        String subject = getSubject();
        int len = subject.length();
        boolean done = false;
        while (!done) {
            done = true;
            while (start < len && subject.charAt(start) == ' ') {
                start++;
            }
            if (start < len - 2 && ((subject.charAt(start) == 'r' || subject.charAt(start) == 'R') && (subject.charAt(start + 1) == 'e' || subject.charAt(start + 1) == 'E'))) {
                if (subject.charAt(start + 2) == ':') {
                    start += 3;
                    done = false;
                } else if (start < len - 2 && (subject.charAt(start + 2) == '[' || subject.charAt(start + 2) == '(')) {
                    int i = start + 3;
                    while (i < len && subject.charAt(i) >= '0' && subject.charAt(i) <= '9') {
                        i++;
                    }
                    if (i < len - 1 && ((subject.charAt(i) == ']' || subject.charAt(i) == ')') && subject.charAt(i + 1) == ':')) {
                        start = i + 2;
                        done = false;
                    }
                }
            }
            if ("(no subject)".equals(this.simplifiedSubject)) {
                this.simplifiedSubject = HttpUrl.FRAGMENT_ENCODE_SET;
            }
            int end = len;
            while (end > start && subject.charAt(end - 1) < ' ') {
                end--;
            }
            if (start == 0 && end == len) {
                this.simplifiedSubject = subject;
            } else {
                this.simplifiedSubject = subject.substring(start, end);
            }
        }
    }

    @Override // org.apache.commons.net.nntp.Threadable
    public boolean subjectIsReply() {
        return this.isReply;
    }

    public String toString() {
        return this.articleNumber + " " + this.articleId + " " + this.subject;
    }
}
