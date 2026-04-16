/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.util;

import androidx.core.util.Predicate$$ExternalSyntheticLambda0;
import androidx.core.util.Predicate$$ExternalSyntheticLambda1;
import androidx.core.util.Predicate$$ExternalSyntheticLambda2;
import androidx.core.util.Predicate$$ExternalSyntheticLambda3;
import androidx.core.util.Predicate$$ExternalSyntheticLambda4;
import java.util.Objects;

public interface Predicate<T> {
    public static <T> Predicate<T> isEqual(Object object) {
        object = object == null ? new Predicate$$ExternalSyntheticLambda1() : new Predicate$$ExternalSyntheticLambda2(object);
        return object;
    }

    public static /* synthetic */ boolean lambda$and$0(Predicate predicate, Predicate predicate2, Object object) {
        boolean bl = predicate.test(object) && predicate2.test(object);
        return bl;
    }

    public static /* synthetic */ boolean lambda$isEqual$3(Object object) {
        return Objects.isNull(object);
    }

    public static /* synthetic */ boolean lambda$isEqual$4(Object object, Object object2) {
        return object.equals(object2);
    }

    public static /* synthetic */ boolean lambda$negate$1(Predicate predicate, Object object) {
        return predicate.test(object) ^ true;
    }

    public static /* synthetic */ boolean lambda$or$2(Predicate predicate, Predicate predicate2, Object object) {
        boolean bl = predicate.test(object) || predicate2.test(object);
        return bl;
    }

    public static <T> Predicate<T> not(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return predicate.negate();
    }

    default public Predicate<T> and(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return new Predicate$$ExternalSyntheticLambda3(this, predicate);
    }

    default public Predicate<T> negate() {
        return new Predicate$$ExternalSyntheticLambda4(this);
    }

    default public Predicate<T> or(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return new Predicate$$ExternalSyntheticLambda0(this, predicate);
    }

    public boolean test(T var1);
}

