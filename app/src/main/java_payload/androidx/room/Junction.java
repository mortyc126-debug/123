/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.annotation.AnnotationRetention
 *  kotlin.annotation.Retention
 *  kotlin.annotation.Target
 */
package androidx.room;

import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;

@java.lang.annotation.Retention(value=RetentionPolicy.CLASS)
@java.lang.annotation.Target(value={})
@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087\u0002\u0018\u00002\u00020\u0001B \u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005R\u000f\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000f\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007R\u0013\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\b\u00a8\u0006\t"}, d2={"Landroidx/room/Junction;", "", "value", "Lkotlin/reflect/KClass;", "parentColumn", "", "entityColumn", "()Ljava/lang/String;", "()Ljava/lang/Class;", "room-common"}, k=1, mv={1, 7, 1}, xi=48)
@Retention(value=AnnotationRetention.BINARY)
@Target(allowedTargets={})
public @interface Junction {
    public String entityColumn() default "";

    public String parentColumn() default "";

    public Class<?> value();
}

