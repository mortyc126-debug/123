/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.annotation.AnnotationTarget
 *  kotlin.annotation.Target
 */
package androidx.room;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Target;

@Retention(value=RetentionPolicy.RUNTIME)
@java.lang.annotation.Target(value={ElementType.TYPE, ElementType.METHOD})
@Metadata(d1={"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2={"Landroidx/room/ExperimentalRoomApi;", "", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
@Target(allowedTargets={AnnotationTarget.CLASS, AnnotationTarget.FUNCTION})
public @interface ExperimentalRoomApi {
}

