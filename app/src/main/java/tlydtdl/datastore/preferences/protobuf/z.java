package tlydtdl.datastore.preferences.protobuf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class z {
    public static final z a;
    public static final z b;
    public static final z c;
    public static final z d;
    public static final z e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final z f580f;
    public static final z g;
    public static final z h;
    public static final z i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final z f581j;
    public static final /* synthetic */ z[] k;

    static {
        z zVar = new z("VOID", 0);
        a = zVar;
        z zVar2 = new z("INT", 1);
        b = zVar2;
        z zVar3 = new z("LONG", 2);
        c = zVar3;
        z zVar4 = new z("FLOAT", 3);
        d = zVar4;
        z zVar5 = new z("DOUBLE", 4);
        e = zVar5;
        z zVar6 = new z("BOOLEAN", 5);
        f580f = zVar6;
        z zVar7 = new z("STRING", 6);
        g = zVar7;
        g gVar = g.c;
        z zVar8 = new z("BYTE_STRING", 7);
        h = zVar8;
        z zVar9 = new z("ENUM", 8);
        i = zVar9;
        z zVar10 = new z("MESSAGE", 9);
        f581j = zVar10;
        k = new z[]{zVar, zVar2, zVar3, zVar4, zVar5, zVar6, zVar7, zVar8, zVar9, zVar10};
    }

    public static z valueOf(String str) {
        return (z) Enum.valueOf(z.class, str);
    }

    public static z[] values() {
        return (z[]) k.clone();
    }
}
