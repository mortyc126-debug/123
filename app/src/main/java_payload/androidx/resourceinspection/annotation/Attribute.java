/*
 * Decompiled with CFR 0.152.
 */
package androidx.resourceinspection.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.SOURCE)
@Target(value={ElementType.METHOD})
public @interface Attribute {
    public IntMap[] intMapping() default {};

    public String value();

    @Retention(value=RetentionPolicy.SOURCE)
    @Target(value={})
    public static @interface IntMap {
        public int mask() default 0;

        public String name();

        public int value();
    }
}

