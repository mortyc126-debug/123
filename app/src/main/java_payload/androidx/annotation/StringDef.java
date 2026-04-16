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
@Metadata(d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001B \u0012\u0014\b\u0002\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006R\u000f\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0017\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\b\u00a8\u0006\t"}, d2={"Landroidx/annotation/StringDef;", "", "value", "", "", "open", "", "()Z", "()[Ljava/lang/String;", "annotation"}, k=1, mv={1, 8, 0}, xi=48)
@Retention(value=AnnotationRetention.SOURCE)
@Target(allowedTargets={AnnotationTarget.ANNOTATION_CLASS})
public @interface StringDef {
    public boolean open() default false;

    public String[] value() default {};
}

