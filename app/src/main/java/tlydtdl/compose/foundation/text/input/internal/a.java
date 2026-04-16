package tlydtdl.compose.foundation.text.input.internal;

import a3.v1;
import m2.n1;
import t3.p;
import w2.b;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static final p a(p pVar, b bVar, n1 n1Var, v1 v1Var) {
        return pVar.then(new LegacyAdaptingPlatformTextInputModifier(bVar, n1Var, v1Var));
    }
}
