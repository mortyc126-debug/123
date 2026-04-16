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

import androidx.room.AutoMigration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@Retention(value=RetentionPolicy.CLASS)
@Target(value={ElementType.TYPE})
@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001BJ\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003R\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0019\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\rR\u000f\u0010\b\u001a\u00020\t\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u000eR\u000f\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u000fR\u0019\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\r\u00a8\u0006\u0010"}, d2={"Landroidx/room/Database;", "", "entities", "", "Lkotlin/reflect/KClass;", "views", "version", "", "exportSchema", "", "autoMigrations", "Landroidx/room/AutoMigration;", "()[Landroidx/room/AutoMigration;", "()[Ljava/lang/Class;", "()Z", "()I", "room-common"}, k=1, mv={1, 7, 1}, xi=48)
@kotlin.annotation.Retention(value=AnnotationRetention.BINARY)
@kotlin.annotation.Target(allowedTargets={AnnotationTarget.CLASS})
public @interface Database {
    public AutoMigration[] autoMigrations() default {};

    public Class<?>[] entities() default {};

    public boolean exportSchema() default true;

    public int version();

    public Class<?>[] views() default {};
}

