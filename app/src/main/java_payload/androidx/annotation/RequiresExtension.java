/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.annotation.AnnotationRetention
 *  kotlin.annotation.AnnotationTarget
 *  kotlin.annotation.MustBeDocumented
 *  kotlin.annotation.Repeatable
 *  kotlin.annotation.Retention
 *  kotlin.annotation.Target
 *  kotlin.jvm.internal.RepeatableContainer
 */
package androidx.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;
import kotlin.annotation.Repeatable;
import kotlin.jvm.internal.RepeatableContainer;

@Documented
@java.lang.annotation.Repeatable(value=Container.class)
@Retention(value=RetentionPolicy.CLASS)
@Target(value={ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PACKAGE})
@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0014\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005R\u000f\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2={"Landroidx/annotation/RequiresExtension;", "", "extension", "", "version", "()I", "annotation"}, k=1, mv={1, 8, 0}, xi=48)
@MustBeDocumented
@Repeatable
@kotlin.annotation.Retention(value=AnnotationRetention.BINARY)
@kotlin.annotation.Target(allowedTargets={AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.FIELD, AnnotationTarget.FILE})
public @interface RequiresExtension {
    public int extension();

    public int version();

    @Retention(value=RetentionPolicy.CLASS)
    @Target(value={ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE})
    @Metadata(k=3, mv={1, 8, 0}, xi=48)
    @kotlin.annotation.Retention(value=AnnotationRetention.BINARY)
    @kotlin.annotation.Target(allowedTargets={AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.FIELD, AnnotationTarget.FILE})
    @RepeatableContainer
    public static @interface Container {
        public RequiresExtension[] value();
    }
}

