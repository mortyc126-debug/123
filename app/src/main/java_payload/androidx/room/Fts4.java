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

import androidx.room.FtsOptions;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@Retention(value=RetentionPolicy.CLASS)
@Target(value={ElementType.TYPE})
@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\u0002\u0018\u00002\u00020\u0001B`\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\f\b\u0002\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000fR\u0013\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0010R\u000f\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0011R\u000f\u0010\t\u001a\u00020\n\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0012R\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\u0013R\u000f\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u0014R\u000f\u0010\f\u001a\u00020\r\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u0015R\u000f\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0011R\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0013\u00a8\u0006\u0016"}, d2={"Landroidx/room/Fts4;", "", "tokenizer", "", "tokenizerArgs", "", "contentEntity", "Lkotlin/reflect/KClass;", "languageId", "matchInfo", "Landroidx/room/FtsOptions$MatchInfo;", "notIndexed", "prefix", "", "order", "Landroidx/room/FtsOptions$Order;", "()Ljava/lang/Class;", "()Ljava/lang/String;", "()Landroidx/room/FtsOptions$MatchInfo;", "()[Ljava/lang/String;", "()Landroidx/room/FtsOptions$Order;", "()[I", "room-common"}, k=1, mv={1, 7, 1}, xi=48)
@kotlin.annotation.Retention(value=AnnotationRetention.BINARY)
@kotlin.annotation.Target(allowedTargets={AnnotationTarget.CLASS})
public @interface Fts4 {
    public Class<?> contentEntity() default Object.class;

    public String languageId() default "";

    public FtsOptions.MatchInfo matchInfo() default FtsOptions.MatchInfo.FTS4;

    public String[] notIndexed() default {};

    public FtsOptions.Order order() default FtsOptions.Order.ASC;

    public int[] prefix() default {};

    public String tokenizer() default "simple";

    public String[] tokenizerArgs() default {};
}

