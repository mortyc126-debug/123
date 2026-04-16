package vm;

import amuvvoafs.app.Application;
import amuvvoafs.media.AudioManager;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static int b = -1;
    public static int c = -1;
    public Application a;

    public static int a(Application application, String str, int i) {
        AudioManager audioManager = (AudioManager) application.getSystemService("audio");
        if (audioManager == null) {
            s02.d.a.n("IO:: null audio manager, use fallback value for %s (%d)", new Object[]{str, Integer.valueOf(i)});
            return i;
        }
        String property = audioManager.getProperty(str);
        if (property == null || property.isEmpty()) {
            s02.d.a.n("IO:: no value for %s, use fallback (%d)", new Object[]{str, Integer.valueOf(i)});
            return i;
        }
        int i2 = Integer.parseInt(property);
        if (i2 == 0) {
            s02.d.a.n("IO:: can't parse value for %s, use fallback (%d)", new Object[]{str, Integer.valueOf(i)});
            return i;
        }
        s02.d.a.h("IO:: retrieved property %s: %d", new Object[]{str, Integer.valueOf(i2)});
        return i2;
    }
}
