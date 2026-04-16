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
package androidx.room;

import androidx.room.Junction;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@Retention(value=RetentionPolicy.CLASS)
@Target(value={ElementType.FIELD, ElementType.METHOD})
@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B8\u0012\f\b\u0002\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nR\u000f\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u000bR\u0013\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\fR\u000f\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\rR\u000f\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\rR\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u000e\u00a8\u0006\u000f"}, d2={"Landroidx/room/Relation;", "", "entity", "Lkotlin/reflect/KClass;", "parentColumn", "", "entityColumn", "associateBy", "Landroidx/room/Junction;", "projection", "", "()Landroidx/room/Junction;", "()Ljava/lang/Class;", "()Ljava/lang/String;", "()[Ljava/lang/String;", "room-common"}, k=1, mv={1, 7, 1}, xi=48)
@kotlin.annotation.Retention(value=AnnotationRetention.BINARY)
@kotlin.annotation.Target(allowedTargets={AnnotationTarget.FIELD, AnnotationTarget.FUNCTION})
public @interface Relation {
    public Junction associateBy() default @Junction(value=Object.class);

    public Class<?> entity() default Object.class;

    public String entityColumn();

    public String parentColumn();

    public String[] projection() default {};
}

