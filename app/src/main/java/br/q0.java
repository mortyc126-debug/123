package br;

import amuvvoafs.content.Context;
import eu0.k;
import js0.j0;
import lv0.c;
import lv0.e;
import p90.f;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class q0 implements e {
    public final /* synthetic */ int a;
    public final /* synthetic */ e b;

    public q0(k kVar, int i) {
        this.a = i;
        switch (i) {
            case 1:
                c cVar = c.b;
                this.b = k.n(kVar, "album_notifications", 2132017298);
                break;
            case 2:
                this.b = kVar.m("splitter_service", c.b, ((Context) kVar.b).getString(2132019482), new j0(1));
                break;
            case 3:
                c cVar2 = c.b;
                this.b = k.n(kVar, "reply_notifications", 2132019400);
                break;
            case 4:
                c cVar3 = c.b;
                this.b = k.n(kVar, "explore_notifications", 2132018358);
                break;
            case 5:
                this.b = kVar.m("media_notifications", c.b, ((Context) kVar.b).getString(2132019165), new f(17));
                break;
            case 6:
                this.b = kVar.m("file_upload_notification", c.b, ((Context) kVar.b).getString(2132018426), new f(19));
                break;
            case 7:
                c cVar4 = c.b;
                this.b = k.n(kVar, "invite_notifications", 2132018584);
                break;
            case 8:
                c cVar5 = c.b;
                this.b = k.n(kVar, "collection_notification", 2132017736);
                break;
            case 9:
                c cVar6 = c.b;
                this.b = k.n(kVar, "com_braze_default_notification_channel", 2132017919);
                break;
            case 10:
                c cVar7 = c.b;
                this.b = k.n(kVar, "feedback_and_surveys", 2132018422);
                break;
            case 11:
                c cVar8 = c.b;
                this.b = k.n(kVar, "marketing_updates", 2132018873);
                break;
            case 12:
                c cVar9 = c.b;
                this.b = k.n(kVar, "product_announcements_and_updates", 2132019800);
                break;
            case 13:
                c cVar10 = c.b;
                this.b = k.n(kVar, "new_post_notifications", 2132019398);
                break;
            case 14:
                c cVar11 = c.b;
                this.b = k.n(kVar, "post_notifications", 2132019758);
                break;
            case 15:
                c cVar12 = c.b;
                this.b = k.n(kVar, "project_updates", 2132019830);
                break;
            case 16:
                c cVar13 = c.b;
                this.b = k.n(kVar, "community_updates", 2132017800);
                break;
            default:
                c cVar14 = c.b;
                this.b = k.n(kVar, "bands_updates", 2132017490);
                break;
        }
    }

    public final e a() {
        switch (this.a) {
        }
        return this.b.a();
    }
}
