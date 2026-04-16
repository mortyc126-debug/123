/*
 * Decompiled with CFR 0.152.
 */
package linker.resourcer.encoder;

public final class UtilityHelper$$ExternalSyntheticBackport0 {
    public static /* synthetic */ String m(CharSequence charSequence, Iterable object) {
        if (charSequence != null) {
            StringBuilder stringBuilder = new StringBuilder();
            if ((object = object.iterator()).hasNext()) {
                while (true) {
                    stringBuilder.append((CharSequence)object.next());
                    if (!object.hasNext()) break;
                    stringBuilder.append(charSequence);
                }
            }
            return stringBuilder.toString();
        }
        throw new NullPointerException("delimiter");
    }
}

