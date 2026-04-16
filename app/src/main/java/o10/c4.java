package o10;

import lmjxuqdtp.NoWhenBranchMatchedException;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c4 {
    public static final c4 a;
    public static final c4 b;
    public static final c4 c;
    public static final /* synthetic */ c4[] d;

    static {
        c4 c4Var = new c4("FollowingReacted", 0);
        a = c4Var;
        c4 c4Var2 = new c4("Network", 1);
        b = c4Var2;
        c4 c4Var3 = new c4("Boost", 2);
        c = c4Var3;
        c4[] c4VarArr = {c4Var, c4Var2, c4Var3, new c4("TopArtistInGenre", 3)};
        d = c4VarArr;
        qg.a.j(c4VarArr);
    }

    public static c4 valueOf(String str) {
        return (c4) Enum.valueOf(c4.class, str);
    }

    public static c4[] values() {
        return (c4[]) d.clone();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final String a() throws NoWhenBranchMatchedException {
        int i = b4.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return "following_reacted";
        }
        if (i == 2) {
            return "network";
        }
        if (i == 3) {
            return "boost";
        }
        if (i == 4) {
            return "top_artist_in_genre";
        }
        throw new NoWhenBranchMatchedException();
    }
}
