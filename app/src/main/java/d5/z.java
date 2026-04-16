package d5;

import f3.f2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class z {
    public static final z b = new z(false, 0);
    public final boolean a;

    public z(boolean z) {
        this.a = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof z) {
            return this.a == ((z) obj).a;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(0) + (Boolean.hashCode(this.a) * 31);
    }

    public final String toString() {
        return f2.o(new StringBuilder("PlatformParagraphStyle(includeFontPadding="), this.a, ", emojiSupportMatch=EmojiSupportMatch.Default)");
    }

    public z(boolean z, int i) {
        this.a = z;
    }
}
