/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.annotation.AnnotationRetention
 *  kotlin.annotation.AnnotationTarget
 *  kotlin.annotation.Retention
 *  kotlin.annotation.Target
 */
package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;

@java.lang.annotation.Retention(value=RetentionPolicy.SOURCE)
@java.lang.annotation.Target(value={ElementType.ANNOTATION_TYPE})
@Metadata(d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0016\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\u0002\u0018\u00002\u00020\u0001B\"\u0012\f\b\u0002\u0010\u0002\u001a\u00020\u0003\"\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006R\u000f\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\bR\u000f\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000f\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\t\u00a8\u0006\n"}, d2={"Landroidx/annotation/LongDef;", "", "value", "", "", "flag", "", "open", "()Z", "()[J", "annotation"}, k=1, mv={1, 8, 0}, xi=48)
@Retention(value=AnnotationRetention.SOURCE)
@Target(allowedTargets={AnnotationTarget.ANNOTATION_CLASS})
public @interface LongDef {
    public boolean flag() default false;

    public boolean open() default false;

    public long[] value() default {};
}

