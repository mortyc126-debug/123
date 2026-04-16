package org.apache.commons.net.nntp;

/* JADX INFO: loaded from: classes2.dex */
public final class NewsgroupInfo {
    public static final int MODERATED_POSTING_PERMISSION = 1;
    public static final int PERMITTED_POSTING_PERMISSION = 2;
    public static final int PROHIBITED_POSTING_PERMISSION = 3;
    public static final int UNKNOWN_POSTING_PERMISSION = 0;
    private long estimatedArticleCount;
    private long firstArticle;
    private long lastArticle;
    private String newsgroup;
    private int postingPermission;

    @Deprecated
    public int getArticleCount() {
        return (int) this.estimatedArticleCount;
    }

    public long getArticleCountLong() {
        return this.estimatedArticleCount;
    }

    @Deprecated
    public int getFirstArticle() {
        return (int) this.firstArticle;
    }

    public long getFirstArticleLong() {
        return this.firstArticle;
    }

    @Deprecated
    public int getLastArticle() {
        return (int) this.lastArticle;
    }

    public long getLastArticleLong() {
        return this.lastArticle;
    }

    public String getNewsgroup() {
        return this.newsgroup;
    }

    public int getPostingPermission() {
        return this.postingPermission;
    }

    void setArticleCount(long count) {
        this.estimatedArticleCount = count;
    }

    void setFirstArticle(long first) {
        this.firstArticle = first;
    }

    void setLastArticle(long last) {
        this.lastArticle = last;
    }

    void setNewsgroup(String newsgroup) {
        this.newsgroup = newsgroup;
    }

    void setPostingPermission(int permission) {
        this.postingPermission = permission;
    }
}
