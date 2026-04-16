package ip1;

import i11.c;
import rp1.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class z {
    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    public static final d[] e;

    static {
        d dVar = new d("client_side_logging", 1L);
        d dVar2 = new d("cxless_client_minimal", 1L);
        a = dVar2;
        d dVar3 = new d("cxless_caf_control", 1L);
        d dVar4 = new d("module_flag_control", 1L);
        b = dVar4;
        d dVar5 = new d("discovery_hint_supply", 1L);
        d dVar6 = new d("relay_casting_set_active_account", 1L);
        d dVar7 = new d("analytics_proto_enum_translation", 1L);
        c = dVar7;
        d dVar8 = new d("integer_to_integer_map", 1L);
        d = dVar8;
        e = new d[]{dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7, dVar8, new d("relay_casting_set_remote_casting_mode", 1L), new d("get_relay_access_token", 1L), new d("get_cast_settings", 1L), new d("set_bundle_setting", 1L), new d("get_client_updated_info", 1L)};
    }

    public static String a(String str) {
        if (str != null) {
            return c.B(new c(1, str, (Object) null));
        }
        throw new IllegalArgumentException("applicationId cannot be null");
    }
}
