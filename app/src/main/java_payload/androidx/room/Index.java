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
@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB8\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\tR\u000f\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\nR\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u000bR\u000f\u0010\b\u001a\u00020\t\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\fR\u0017\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\r\u00a8\u0006\u000f"}, d2={"Landroidx/room/Index;", "", "value", "", "", "orders", "Landroidx/room/Index$Order;", "name", "unique", "", "()Ljava/lang/String;", "()[Landroidx/room/Index$Order;", "()Z", "()[Ljava/lang/String;", "Order", "room-common"}, k=1, mv={1, 7, 1}, xi=48)
@Retention(value=AnnotationRetention.BINARY)
@Target(allowedTargets={})
public @interface Index {
    public String name() default "";

    public Order[] orders() default {};

    public boolean unique() default false;

    public String[] value();

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2={"Landroidx/room/Index$Order;", "", "(Ljava/lang/String;I)V", "ASC", "DESC", "room-common"}, k=1, mv={1, 7, 1}, xi=48)
    public static enum Order {
        ASC,
        DESC;

    }
}

