/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ActivityInfo
 *  android.content.pm.ResolveInfo
 *  android.graphics.Bitmap
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.os.ext.SdkExtensions
 *  android.provider.MediaStore
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.ReplaceWith
 *  kotlin.TuplesKt
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.RangesKt
 */
package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.os.ext.SdkExtensions;
import android.provider.MediaStore;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\u0018\u00002\u00020\u0001:\u0011\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0014"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts;", "", "()V", "CaptureVideo", "CreateDocument", "GetContent", "GetMultipleContents", "OpenDocument", "OpenDocumentTree", "OpenMultipleDocuments", "PickContact", "PickMultipleVisualMedia", "PickVisualMedia", "RequestMultiplePermissions", "RequestPermission", "StartActivityForResult", "StartIntentSenderForResult", "TakePicture", "TakePicturePreview", "TakeVideo", "activity_release"}, k=1, mv={1, 8, 0}, xi=48)
public final class ActivityResultContracts {
    private ActivityResultContracts() {
    }

    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0017J\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002J\u001d\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0010\u00a8\u0006\u0011"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$CaptureVideo;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "(ILandroid/content/Intent;)Ljava/lang/Boolean;", "activity_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static class CaptureVideo
    extends ActivityResultContract<Uri, Boolean> {
        @Override
        public Intent createIntent(Context context, Uri uri) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            Intrinsics.checkNotNullParameter((Object)uri, (String)"input");
            context = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", (Parcelable)uri);
            Intrinsics.checkNotNullExpressionValue((Object)context, (String)"Intent(MediaStore.ACTION\u2026tore.EXTRA_OUTPUT, input)");
            return context;
        }

        @Override
        public final ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(Context context, Uri uri) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            Intrinsics.checkNotNullParameter((Object)uri, (String)"input");
            return null;
        }

        @Override
        public final Boolean parseResult(int n, Intent intent) {
            boolean bl = n == -1;
            return bl;
        }
    }

    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0017\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007\b\u0017\u00a2\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0017J \u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0005\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$CreateDocument;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "Landroid/net/Uri;", "()V", "mimeType", "(Ljava/lang/String;)V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static class CreateDocument
    extends ActivityResultContract<String, Uri> {
        private final String mimeType;

        @Deprecated(message="Using a wildcard mime type with CreateDocument is not recommended as it breaks the automatic handling of file extensions. Instead, specify the mime type by using the constructor that takes an concrete mime type (e.g.., CreateDocument(\"image/png\")).", replaceWith=@ReplaceWith(expression="CreateDocument(\"todo/todo\")", imports={}))
        public CreateDocument() {
            this("*/*");
        }

        public CreateDocument(String string2) {
            Intrinsics.checkNotNullParameter((Object)string2, (String)"mimeType");
            this.mimeType = string2;
        }

        @Override
        public Intent createIntent(Context context, String string2) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            Intrinsics.checkNotNullParameter((Object)string2, (String)"input");
            context = new Intent("android.intent.action.CREATE_DOCUMENT").setType(this.mimeType).putExtra("android.intent.extra.TITLE", string2);
            Intrinsics.checkNotNullExpressionValue((Object)context, (String)"Intent(Intent.ACTION_CRE\u2026ntent.EXTRA_TITLE, input)");
            return context;
        }

        @Override
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, String string2) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            Intrinsics.checkNotNullParameter((Object)string2, (String)"input");
            return null;
        }

        @Override
        public final Uri parseResult(int n, Intent intent) {
            n = n == -1 ? 1 : 0;
            Uri uri = null;
            if (n == 0) {
                intent = null;
            }
            if (intent != null) {
                uri = intent.getData();
            }
            return uri;
        }
    }

    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0017J \u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u0010"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$GetContent;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "Landroid/net/Uri;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static class GetContent
    extends ActivityResultContract<String, Uri> {
        @Override
        public Intent createIntent(Context context, String string2) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            Intrinsics.checkNotNullParameter((Object)string2, (String)"input");
            context = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(string2);
            Intrinsics.checkNotNullExpressionValue((Object)context, (String)"Intent(Intent.ACTION_GET\u2026          .setType(input)");
            return context;
        }

        @Override
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, String string2) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            Intrinsics.checkNotNullParameter((Object)string2, (String)"input");
            return null;
        }

        @Override
        public final Uri parseResult(int n, Intent intent) {
            n = n == -1 ? 1 : 0;
            Uri uri = null;
            if (n == 0) {
                intent = null;
            }
            if (intent != null) {
                uri = intent.getData();
            }
            return uri;
        }
    }

    @Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0017\u0018\u0000 \u00122\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0004\u00a2\u0006\u0002\b\u00050\u00030\u0001:\u0001\u0012B\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0017J$\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002J\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\b\u00a8\u0006\u0013"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$GetMultipleContents;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "Landroid/net/Uri;", "Lkotlin/jvm/JvmSuppressWildcards;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "Companion", "activity_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static class GetMultipleContents
    extends ActivityResultContract<String, List<Uri>> {
        public static final Companion Companion = new Companion(null);

        @Override
        public Intent createIntent(Context context, String string2) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            Intrinsics.checkNotNullParameter((Object)string2, (String)"input");
            context = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(string2).putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            Intrinsics.checkNotNullExpressionValue((Object)context, (String)"Intent(Intent.ACTION_GET\u2026TRA_ALLOW_MULTIPLE, true)");
            return context;
        }

        @Override
        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(Context context, String string2) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            Intrinsics.checkNotNullParameter((Object)string2, (String)"input");
            return null;
        }

        @Override
        public final List<Uri> parseResult(int n, Intent object) {
            Companion companion;
            if ((n = n == -1 ? 1 : 0) == 0) {
                object = null;
            }
            if (object == null || (object = (companion = Companion).getClipDataUris$activity_release((Intent)object)) == null) {
                object = CollectionsKt.emptyList();
            }
            return object;
        }

        @Metadata(d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u0006H\u0000\u00a2\u0006\u0002\b\u0007\u00a8\u0006\b"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$GetMultipleContents$Companion;", "", "()V", "getClipDataUris", "", "Landroid/net/Uri;", "Landroid/content/Intent;", "getClipDataUris$activity_release", "activity_release"}, k=1, mv={1, 8, 0}, xi=48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final List<Uri> getClipDataUris$activity_release(Intent intent) {
                Intrinsics.checkNotNullParameter((Object)intent, (String)"<this>");
                LinkedHashSet<Uri> linkedHashSet = new LinkedHashSet<Uri>();
                Uri uri = intent.getData();
                if (uri != null) {
                    linkedHashSet.add(uri);
                }
                if ((intent = intent.getClipData()) == null && linkedHashSet.isEmpty()) {
                    return CollectionsKt.emptyList();
                }
                if (intent != null) {
                    int n = intent.getItemCount();
                    for (int i = 0; i < n; ++i) {
                        uri = intent.getItemAt(i).getUri();
                        if (uri == null) continue;
                        linkedHashSet.add(uri);
                    }
                }
                return new ArrayList(linkedHashSet);
            }
        }
    }

    @Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0017\u0018\u00002\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001B\u0005\u00a2\u0006\u0002\u0010\u0005J#\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0017\u00a2\u0006\u0002\u0010\u000bJ+\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0002\u0010\u000eJ\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u00a8\u0006\u0013"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$OpenDocument;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "Landroid/net/Uri;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "(Landroid/content/Context;[Ljava/lang/String;)Landroid/content/Intent;", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "(Landroid/content/Context;[Ljava/lang/String;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static class OpenDocument
    extends ActivityResultContract<String[], Uri> {
        @Override
        public Intent createIntent(Context context, String[] stringArray) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            Intrinsics.checkNotNullParameter((Object)stringArray, (String)"input");
            context = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", stringArray).setType("*/*");
            Intrinsics.checkNotNullExpressionValue((Object)context, (String)"Intent(Intent.ACTION_OPE\u2026          .setType(\"*/*\")");
            return context;
        }

        @Override
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, String[] stringArray) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            Intrinsics.checkNotNullParameter((Object)stringArray, (String)"input");
            return null;
        }

        @Override
        public final Uri parseResult(int n, Intent intent) {
            n = n == -1 ? 1 : 0;
            Uri uri = null;
            if (n == 0) {
                intent = null;
            }
            if (intent != null) {
                uri = intent.getData();
            }
            return uri;
        }
    }

    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0017\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0017J\"\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u00a8\u0006\u000f"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$OpenDocumentTree;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static class OpenDocumentTree
    extends ActivityResultContract<Uri, Uri> {
        @Override
        public Intent createIntent(Context context, Uri uri) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            context = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            if (Build.VERSION.SDK_INT >= 26 && uri != null) {
                context.putExtra("android.provider.extra.INITIAL_URI", (Parcelable)uri);
            }
            return context;
        }

        @Override
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, Uri uri) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            return null;
        }

        @Override
        public final Uri parseResult(int n, Intent intent) {
            n = n == -1 ? 1 : 0;
            Uri uri = null;
            if (n == 0) {
                intent = null;
            }
            if (intent != null) {
                uri = intent.getData();
            }
            return uri;
        }
    }

    @Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0017\u0018\u00002\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0005\u00a2\u0006\u0002\b\u00060\u00040\u0001B\u0005\u00a2\u0006\u0002\u0010\u0007J#\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0017\u00a2\u0006\u0002\u0010\rJ/\u0010\u000e\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0002\u0010\u0010J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\t\u00a8\u0006\u0015"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$OpenMultipleDocuments;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "", "Landroid/net/Uri;", "Lkotlin/jvm/JvmSuppressWildcards;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "(Landroid/content/Context;[Ljava/lang/String;)Landroid/content/Intent;", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "(Landroid/content/Context;[Ljava/lang/String;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static class OpenMultipleDocuments
    extends ActivityResultContract<String[], List<Uri>> {
        @Override
        public Intent createIntent(Context context, String[] stringArray) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            Intrinsics.checkNotNullParameter((Object)stringArray, (String)"input");
            context = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", stringArray).putExtra("android.intent.extra.ALLOW_MULTIPLE", true).setType("*/*");
            Intrinsics.checkNotNullExpressionValue((Object)context, (String)"Intent(Intent.ACTION_OPE\u2026          .setType(\"*/*\")");
            return context;
        }

        @Override
        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(Context context, String[] stringArray) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            Intrinsics.checkNotNullParameter((Object)stringArray, (String)"input");
            return null;
        }

        @Override
        public final List<Uri> parseResult(int n, Intent object) {
            GetMultipleContents.Companion companion;
            if ((n = n == -1 ? 1 : 0) == 0) {
                object = null;
            }
            if (object == null || (object = (companion = GetMultipleContents.Companion).getClipDataUris$activity_release((Intent)object)) == null) {
                object = CollectionsKt.emptyList();
            }
            return object;
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000e"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$PickContact;", "Landroidx/activity/result/contract/ActivityResultContract;", "Ljava/lang/Void;", "Landroid/net/Uri;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "activity_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class PickContact
    extends ActivityResultContract<Void, Uri> {
        @Override
        public Intent createIntent(Context context, Void void_) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            context = new Intent("android.intent.action.PICK").setType("vnd.android.cursor.dir/contact");
            Intrinsics.checkNotNullExpressionValue((Object)context, (String)"Intent(Intent.ACTION_PIC\u2026ct.Contacts.CONTENT_TYPE)");
            return context;
        }

        @Override
        public Uri parseResult(int n, Intent intent) {
            n = n == -1 ? 1 : 0;
            Uri uri = null;
            if (n == 0) {
                intent = null;
            }
            if (intent != null) {
                uri = intent.getData();
            }
            return uri;
        }
    }

    @Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000 \u00132\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0004\u00a2\u0006\u0002\b\u00050\u00030\u0001:\u0001\u0013B\u000f\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0017J)\u0010\u000e\u001a\u0015\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0004\u00a2\u0006\u0002\b\u00050\u0003\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$PickMultipleVisualMedia;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroidx/activity/result/PickVisualMediaRequest;", "", "Landroid/net/Uri;", "Lkotlin/jvm/JvmSuppressWildcards;", "maxItems", "", "(I)V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "intent", "Companion", "activity_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static class PickMultipleVisualMedia
    extends ActivityResultContract<PickVisualMediaRequest, List<Uri>> {
        public static final Companion Companion = new Companion(null);
        private final int maxItems;

        public PickMultipleVisualMedia() {
            this(0, 1, null);
        }

        public PickMultipleVisualMedia(int n) {
            int n2 = this.maxItems = n;
            n = 1;
            if (n2 <= 1) {
                n = 0;
            }
            if (n != 0) {
                return;
            }
            throw new IllegalArgumentException("Max items must be higher than 1".toString());
        }

        public /* synthetic */ PickMultipleVisualMedia(int n, int n2, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n2 & 1) != 0) {
                n = Companion.getMaxItems$activity_release();
            }
            this(n);
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public Intent createIntent(Context context, PickVisualMediaRequest pickVisualMediaRequest) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            Intrinsics.checkNotNullParameter((Object)pickVisualMediaRequest, (String)"input");
            boolean bl = PickVisualMedia.Companion.isSystemPickerAvailable$activity_release();
            boolean bl2 = true;
            if (bl) {
                context = new Intent("android.provider.action.PICK_IMAGES");
                context.setType(PickVisualMedia.Companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                if (this.maxItems > MediaStore.getPickImagesMaxLimit()) {
                    bl2 = false;
                }
                if (!bl2) throw new IllegalArgumentException("Max items must be less or equals MediaStore.getPickImagesMaxLimit()".toString());
                context.putExtra("android.provider.extra.PICK_IMAGES_MAX", this.maxItems);
                return context;
            } else if (PickVisualMedia.Companion.isSystemFallbackPickerAvailable$activity_release(context)) {
                if ((context = PickVisualMedia.Companion.getSystemFallbackPicker$activity_release(context)) == null) throw new IllegalStateException("Required value was null.".toString());
                ActivityInfo activityInfo = context.activityInfo;
                context = new Intent("androidx.activity.result.contract.action.PICK_IMAGES");
                context.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
                context.setType(PickVisualMedia.Companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                context.putExtra("com.google.android.gms.provider.extra.PICK_IMAGES_MAX", this.maxItems);
                return context;
            } else if (PickVisualMedia.Companion.isGmsPickerAvailable$activity_release(context)) {
                if ((context = PickVisualMedia.Companion.getGmsPicker$activity_release(context)) == null) throw new IllegalStateException("Required value was null.".toString());
                pickVisualMediaRequest = context.activityInfo;
                context = new Intent("com.google.android.gms.provider.action.PICK_IMAGES");
                context.setClassName(((ActivityInfo)pickVisualMediaRequest).applicationInfo.packageName, ((ActivityInfo)pickVisualMediaRequest).name);
                context.putExtra("com.google.android.gms.provider.extra.PICK_IMAGES_MAX", this.maxItems);
                return context;
            } else {
                context = new Intent("android.intent.action.OPEN_DOCUMENT");
                context.setType(PickVisualMedia.Companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                context.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                if (context.getType() != null) return context;
                context.setType("*/*");
                context.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
            }
            return context;
        }

        @Override
        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(Context context, PickVisualMediaRequest pickVisualMediaRequest) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            Intrinsics.checkNotNullParameter((Object)pickVisualMediaRequest, (String)"input");
            return null;
        }

        @Override
        public final List<Uri> parseResult(int n, Intent object) {
            GetMultipleContents.Companion companion;
            if ((n = n == -1 ? 1 : 0) == 0) {
                object = null;
            }
            if (object == null || (object = (companion = GetMultipleContents.Companion).getClipDataUris$activity_release((Intent)object)) == null) {
                object = CollectionsKt.emptyList();
            }
            return object;
        }

        @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u00020\u0004H\u0001\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$PickMultipleVisualMedia$Companion;", "", "()V", "getMaxItems", "", "getMaxItems$activity_release", "activity_release"}, k=1, mv={1, 8, 0}, xi=48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int getMaxItems$activity_release() {
                int n = PickVisualMedia.Companion.isSystemPickerAvailable$activity_release() ? MediaStore.getPickImagesMaxLimit() : Integer.MAX_VALUE;
                return n;
            }
        }
    }

    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0017\u0018\u0000 \u00102\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0006\u0010\u0011\u0012\u0013\u0014\u0015B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0017J \u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u0016"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroidx/activity/result/PickVisualMediaRequest;", "Landroid/net/Uri;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "Companion", "ImageAndVideo", "ImageOnly", "SingleMimeType", "VideoOnly", "VisualMediaType", "activity_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static class PickVisualMedia
    extends ActivityResultContract<PickVisualMediaRequest, Uri> {
        public static final String ACTION_SYSTEM_FALLBACK_PICK_IMAGES = "androidx.activity.result.contract.action.PICK_IMAGES";
        public static final Companion Companion = new Companion(null);
        public static final String EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_MAX = "androidx.activity.result.contract.extra.PICK_IMAGES_MAX";
        public static final String GMS_ACTION_PICK_IMAGES = "com.google.android.gms.provider.action.PICK_IMAGES";
        public static final String GMS_EXTRA_PICK_IMAGES_MAX = "com.google.android.gms.provider.extra.PICK_IMAGES_MAX";

        @JvmStatic
        public static final ResolveInfo getGmsPicker$activity_release(Context context) {
            return Companion.getGmsPicker$activity_release(context);
        }

        @JvmStatic
        public static final ResolveInfo getSystemFallbackPicker$activity_release(Context context) {
            return Companion.getSystemFallbackPicker$activity_release(context);
        }

        @JvmStatic
        public static final boolean isGmsPickerAvailable$activity_release(Context context) {
            return Companion.isGmsPickerAvailable$activity_release(context);
        }

        @Deprecated(message="This method is deprecated in favor of isPhotoPickerAvailable(context) to support the picker provided by updatable system apps", replaceWith=@ReplaceWith(expression="isPhotoPickerAvailable(context)", imports={}))
        @JvmStatic
        public static final boolean isPhotoPickerAvailable() {
            return Companion.isPhotoPickerAvailable();
        }

        @JvmStatic
        public static final boolean isPhotoPickerAvailable(Context context) {
            return Companion.isPhotoPickerAvailable(context);
        }

        @JvmStatic
        public static final boolean isSystemFallbackPickerAvailable$activity_release(Context context) {
            return Companion.isSystemFallbackPickerAvailable$activity_release(context);
        }

        @JvmStatic
        public static final boolean isSystemPickerAvailable$activity_release() {
            return Companion.isSystemPickerAvailable$activity_release();
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public Intent createIntent(Context context, PickVisualMediaRequest pickVisualMediaRequest) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            Intrinsics.checkNotNullParameter((Object)pickVisualMediaRequest, (String)"input");
            if (Companion.isSystemPickerAvailable$activity_release()) {
                context = new Intent("android.provider.action.PICK_IMAGES");
                context.setType(Companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                return context;
            } else if (Companion.isSystemFallbackPickerAvailable$activity_release(context)) {
                if ((context = Companion.getSystemFallbackPicker$activity_release(context)) == null) throw new IllegalStateException("Required value was null.".toString());
                ActivityInfo activityInfo = context.activityInfo;
                context = new Intent(ACTION_SYSTEM_FALLBACK_PICK_IMAGES);
                context.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
                context.setType(Companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                return context;
            } else if (Companion.isGmsPickerAvailable$activity_release(context)) {
                if ((context = Companion.getGmsPicker$activity_release(context)) == null) throw new IllegalStateException("Required value was null.".toString());
                ActivityInfo activityInfo = context.activityInfo;
                context = new Intent(GMS_ACTION_PICK_IMAGES);
                context.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
                context.setType(Companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                return context;
            } else {
                context = new Intent("android.intent.action.OPEN_DOCUMENT");
                context.setType(Companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                if (context.getType() != null) return context;
                context.setType("*/*");
                context.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
            }
            return context;
        }

        @Override
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, PickVisualMediaRequest pickVisualMediaRequest) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            Intrinsics.checkNotNullParameter((Object)pickVisualMediaRequest, (String)"input");
            return null;
        }

        @Override
        public final Uri parseResult(int n, Intent intent) {
            n = n == -1 ? 1 : 0;
            Uri uri = null;
            Object object = n != 0 ? intent : null;
            intent = uri;
            if (object != null) {
                uri = object.getData();
                intent = uri;
                if (uri == null) {
                    intent = (Uri)CollectionsKt.firstOrNull(GetMultipleContents.Companion.getClipDataUris$activity_release((Intent)object));
                }
            }
            return intent;
        }

        @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0017\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0001\u00a2\u0006\u0002\b\u000eJ\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0001\u00a2\u0006\u0002\b\u0010J\u0017\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u00a2\u0006\u0002\b\u0014J\u0015\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\rH\u0001\u00a2\u0006\u0002\b\u0017J\b\u0010\u0018\u001a\u00020\u0016H\u0007J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\rH\u0007J\u0015\u0010\u0019\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\rH\u0001\u00a2\u0006\u0002\b\u001aJ\r\u0010\u001b\u001a\u00020\u0016H\u0001\u00a2\u0006\u0002\b\u001cR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0014\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u000e\u0010\b\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$Companion;", "", "()V", "ACTION_SYSTEM_FALLBACK_PICK_IMAGES", "", "getACTION_SYSTEM_FALLBACK_PICK_IMAGES$annotations", "EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_MAX", "getEXTRA_SYSTEM_FALLBACK_PICK_IMAGES_MAX$annotations", "GMS_ACTION_PICK_IMAGES", "GMS_EXTRA_PICK_IMAGES_MAX", "getGmsPicker", "Landroid/content/pm/ResolveInfo;", "context", "Landroid/content/Context;", "getGmsPicker$activity_release", "getSystemFallbackPicker", "getSystemFallbackPicker$activity_release", "getVisualMimeType", "input", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "getVisualMimeType$activity_release", "isGmsPickerAvailable", "", "isGmsPickerAvailable$activity_release", "isPhotoPickerAvailable", "isSystemFallbackPickerAvailable", "isSystemFallbackPickerAvailable$activity_release", "isSystemPickerAvailable", "isSystemPickerAvailable$activity_release", "activity_release"}, k=1, mv={1, 8, 0}, xi=48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public static /* synthetic */ void getACTION_SYSTEM_FALLBACK_PICK_IMAGES$annotations() {
            }

            public static /* synthetic */ void getEXTRA_SYSTEM_FALLBACK_PICK_IMAGES_MAX$annotations() {
            }

            @JvmStatic
            public final ResolveInfo getGmsPicker$activity_release(Context context) {
                Intrinsics.checkNotNullParameter((Object)context, (String)"context");
                context = context.getPackageManager();
                Intent intent = new Intent(PickVisualMedia.GMS_ACTION_PICK_IMAGES);
                return context.resolveActivity(intent, 0x110000);
            }

            @JvmStatic
            public final ResolveInfo getSystemFallbackPicker$activity_release(Context context) {
                Intrinsics.checkNotNullParameter((Object)context, (String)"context");
                context = context.getPackageManager();
                Intent intent = new Intent(PickVisualMedia.ACTION_SYSTEM_FALLBACK_PICK_IMAGES);
                return context.resolveActivity(intent, 0x110000);
            }

            public final String getVisualMimeType$activity_release(VisualMediaType object) {
                block6: {
                    block3: {
                        block5: {
                            block4: {
                                block2: {
                                    Intrinsics.checkNotNullParameter((Object)object, (String)"input");
                                    if (!(object instanceof ImageOnly)) break block2;
                                    object = "image/*";
                                    break block3;
                                }
                                if (!(object instanceof VideoOnly)) break block4;
                                object = "video/*";
                                break block3;
                            }
                            if (!(object instanceof SingleMimeType)) break block5;
                            object = ((SingleMimeType)object).getMimeType();
                            break block3;
                        }
                        if (!(object instanceof ImageAndVideo)) break block6;
                        object = null;
                    }
                    return object;
                }
                throw new NoWhenBranchMatchedException();
            }

            @JvmStatic
            public final boolean isGmsPickerAvailable$activity_release(Context context) {
                Intrinsics.checkNotNullParameter((Object)context, (String)"context");
                boolean bl = this.getGmsPicker$activity_release(context) != null;
                return bl;
            }

            @Deprecated(message="This method is deprecated in favor of isPhotoPickerAvailable(context) to support the picker provided by updatable system apps", replaceWith=@ReplaceWith(expression="isPhotoPickerAvailable(context)", imports={}))
            @JvmStatic
            public final boolean isPhotoPickerAvailable() {
                return this.isSystemPickerAvailable$activity_release();
            }

            @JvmStatic
            public final boolean isPhotoPickerAvailable(Context context) {
                Intrinsics.checkNotNullParameter((Object)context, (String)"context");
                boolean bl = this.isSystemPickerAvailable$activity_release() || this.isSystemFallbackPickerAvailable$activity_release(context) || this.isGmsPickerAvailable$activity_release(context);
                return bl;
            }

            @JvmStatic
            public final boolean isSystemFallbackPickerAvailable$activity_release(Context context) {
                Intrinsics.checkNotNullParameter((Object)context, (String)"context");
                boolean bl = this.getSystemFallbackPicker$activity_release(context) != null;
                return bl;
            }

            @JvmStatic
            public final boolean isSystemPickerAvailable$activity_release() {
                int n = Build.VERSION.SDK_INT;
                boolean bl = true;
                if (n < 33) {
                    if (Build.VERSION.SDK_INT >= 30) {
                        if (SdkExtensions.getExtensionVersion((int)30) < 2) {
                            bl = false;
                        }
                    } else {
                        bl = false;
                    }
                }
                return bl;
            }
        }

        @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$ImageAndVideo;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "()V", "activity_release"}, k=1, mv={1, 8, 0}, xi=48)
        public static final class ImageAndVideo
        implements VisualMediaType {
            public static final ImageAndVideo INSTANCE = new ImageAndVideo();

            private ImageAndVideo() {
            }
        }

        @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$ImageOnly;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "()V", "activity_release"}, k=1, mv={1, 8, 0}, xi=48)
        public static final class ImageOnly
        implements VisualMediaType {
            public static final ImageOnly INSTANCE = new ImageOnly();

            private ImageOnly() {
            }
        }

        @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$SingleMimeType;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "mimeType", "", "(Ljava/lang/String;)V", "getMimeType", "()Ljava/lang/String;", "activity_release"}, k=1, mv={1, 8, 0}, xi=48)
        public static final class SingleMimeType
        implements VisualMediaType {
            private final String mimeType;

            public SingleMimeType(String string2) {
                Intrinsics.checkNotNullParameter((Object)string2, (String)"mimeType");
                this.mimeType = string2;
            }

            public final String getMimeType() {
                return this.mimeType;
            }
        }

        @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VideoOnly;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "()V", "activity_release"}, k=1, mv={1, 8, 0}, xi=48)
        public static final class VideoOnly
        implements VisualMediaType {
            public static final VideoOnly INSTANCE = new VideoOnly();

            private VideoOnly() {
            }
        }

        @Metadata(d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001\u0082\u0001\u0004\u0002\u0003\u0004\u0005\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0006\u00c0\u0006\u0001"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$ImageAndVideo;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$ImageOnly;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$SingleMimeType;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VideoOnly;", "activity_release"}, k=1, mv={1, 8, 0}, xi=48)
        public static interface VisualMediaType {
        }
    }

    @Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00152%\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0003\u0012\t\u0012\u00070\u0005\u00a2\u0006\u0002\b\u00060\u00040\u0001:\u0001\u0015B\u0005\u00a2\u0006\u0002\u0010\u0007J#\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0002\u0010\rJ7\u0010\u000e\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0002\u0010\u0010J&\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\u0016"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$RequestMultiplePermissions;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "", "", "Lkotlin/jvm/JvmSuppressWildcards;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "(Landroid/content/Context;[Ljava/lang/String;)Landroid/content/Intent;", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "(Landroid/content/Context;[Ljava/lang/String;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "Companion", "activity_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class RequestMultiplePermissions
    extends ActivityResultContract<String[], Map<String, Boolean>> {
        public static final String ACTION_REQUEST_PERMISSIONS = "androidx.activity.result.contract.action.REQUEST_PERMISSIONS";
        public static final Companion Companion = new Companion(null);
        public static final String EXTRA_PERMISSIONS = "androidx.activity.result.contract.extra.PERMISSIONS";
        public static final String EXTRA_PERMISSION_GRANT_RESULTS = "androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS";

        @Override
        public Intent createIntent(Context context, String[] stringArray) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            Intrinsics.checkNotNullParameter((Object)stringArray, (String)"input");
            return Companion.createIntent$activity_release(stringArray);
        }

        @Override
        public ActivityResultContract.SynchronousResult<Map<String, Boolean>> getSynchronousResult(Context object, String[] stringArray) {
            int n;
            String string2;
            int n2;
            block5: {
                Intrinsics.checkNotNullParameter((Object)object, (String)"context");
                Intrinsics.checkNotNullParameter((Object)stringArray, (String)"input");
                n2 = stringArray.length;
                int n3 = 0;
                n2 = n2 == 0 ? 1 : 0;
                if (n2 != 0) {
                    return new ActivityResultContract.SynchronousResult<Map<String, Boolean>>(MapsKt.emptyMap());
                }
                int n4 = stringArray.length;
                for (n2 = 0; n2 < n4; ++n2) {
                    string2 = stringArray[n2];
                    n = ContextCompat.checkSelfPermission((Context)object, string2) == 0 ? 1 : 0;
                    if (n != 0) continue;
                    n2 = 0;
                    break block5;
                }
                n2 = 1;
            }
            if (n2 != 0) {
                object = new LinkedHashMap(RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)stringArray.length), (int)16));
                n = stringArray.length;
                for (n2 = n3; n2 < n; ++n2) {
                    string2 = TuplesKt.to((Object)stringArray[n2], (Object)true);
                    object.put(string2.getFirst(), string2.getSecond());
                }
                object = new ActivityResultContract.SynchronousResult<Context>((Context)object);
            } else {
                object = null;
            }
            return object;
        }

        @Override
        public Map<String, Boolean> parseResult(int n, Intent object) {
            if (n != -1) {
                return MapsKt.emptyMap();
            }
            if (object == null) {
                return MapsKt.emptyMap();
            }
            Object[] objectArray = object.getStringArrayExtra(EXTRA_PERMISSIONS);
            int[] nArray = object.getIntArrayExtra(EXTRA_PERMISSION_GRANT_RESULTS);
            if (nArray != null && objectArray != null) {
                object = new ArrayList(nArray.length);
                int n2 = nArray.length;
                for (n = 0; n < n2; ++n) {
                    boolean bl = nArray[n] == 0;
                    object.add(bl);
                }
                object = (List)object;
                return MapsKt.toMap((Iterable)CollectionsKt.zip((Iterable)ArraysKt.filterNotNull((Object[])objectArray), (Iterable)((Iterable)object)));
            }
            return MapsKt.emptyMap();
        }

        @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001d\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u0000\u00a2\u0006\u0004\b\u000b\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$RequestMultiplePermissions$Companion;", "", "()V", "ACTION_REQUEST_PERMISSIONS", "", "EXTRA_PERMISSIONS", "EXTRA_PERMISSION_GRANT_RESULTS", "createIntent", "Landroid/content/Intent;", "input", "", "createIntent$activity_release", "([Ljava/lang/String;)Landroid/content/Intent;", "activity_release"}, k=1, mv={1, 8, 0}, xi=48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Intent createIntent$activity_release(String[] intent) {
                Intrinsics.checkNotNullParameter((Object)intent, (String)"input");
                intent = new Intent(RequestMultiplePermissions.ACTION_REQUEST_PERMISSIONS).putExtra(RequestMultiplePermissions.EXTRA_PERMISSIONS, (String[])intent);
                Intrinsics.checkNotNullExpressionValue((Object)intent, (String)"Intent(ACTION_REQUEST_PE\u2026EXTRA_PERMISSIONS, input)");
                return intent;
            }
        }
    }

    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J \u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001f\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0002\u0010\u0010\u00a8\u0006\u0011"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$RequestPermission;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "(ILandroid/content/Intent;)Ljava/lang/Boolean;", "activity_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class RequestPermission
    extends ActivityResultContract<String, Boolean> {
        @Override
        public Intent createIntent(Context context, String string2) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            Intrinsics.checkNotNullParameter((Object)string2, (String)"input");
            return RequestMultiplePermissions.Companion.createIntent$activity_release(new String[]{string2});
        }

        @Override
        public ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(Context object, String string2) {
            Intrinsics.checkNotNullParameter((Object)object, (String)"context");
            Intrinsics.checkNotNullParameter((Object)string2, (String)"input");
            boolean bl = ContextCompat.checkSelfPermission(object, string2) == 0;
            object = bl ? new ActivityResultContract.SynchronousResult<Boolean>(true) : null;
            return object;
        }

        @Override
        public Boolean parseResult(int n, Intent object) {
            boolean bl = false;
            if (object != null && n == -1) {
                object = object.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                boolean bl2 = bl;
                if (object != null) {
                    block4: {
                        int n2 = ((Intent)object).length;
                        for (n = 0; n < n2; ++n) {
                            boolean bl3 = object[n] == false;
                            if (!bl3) continue;
                            n = 1;
                            break block4;
                        }
                        n = 0;
                    }
                    bl2 = bl;
                    if (n == 1) {
                        bl2 = true;
                    }
                }
                return bl2;
            }
            return false;
        }
    }

    @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/content/Intent;", "Landroidx/activity/result/ActivityResult;", "()V", "createIntent", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "Companion", "activity_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class StartActivityForResult
    extends ActivityResultContract<Intent, ActivityResult> {
        public static final Companion Companion = new Companion(null);
        public static final String EXTRA_ACTIVITY_OPTIONS_BUNDLE = "androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE";

        @Override
        public Intent createIntent(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            Intrinsics.checkNotNullParameter((Object)intent, (String)"input");
            return intent;
        }

        @Override
        public ActivityResult parseResult(int n, Intent intent) {
            return new ActivityResult(n, intent);
        }

        @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult$Companion;", "", "()V", "EXTRA_ACTIVITY_OPTIONS_BUNDLE", "", "activity_release"}, k=1, mv={1, 8, 0}, xi=48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u000e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$StartIntentSenderForResult;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroidx/activity/result/IntentSenderRequest;", "Landroidx/activity/result/ActivityResult;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "Companion", "activity_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class StartIntentSenderForResult
    extends ActivityResultContract<IntentSenderRequest, ActivityResult> {
        public static final String ACTION_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.action.INTENT_SENDER_REQUEST";
        public static final Companion Companion = new Companion(null);
        public static final String EXTRA_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST";
        public static final String EXTRA_SEND_INTENT_EXCEPTION = "androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION";

        @Override
        public Intent createIntent(Context context, IntentSenderRequest intentSenderRequest) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            Intrinsics.checkNotNullParameter((Object)intentSenderRequest, (String)"input");
            context = new Intent(ACTION_INTENT_SENDER_REQUEST).putExtra(EXTRA_INTENT_SENDER_REQUEST, (Parcelable)intentSenderRequest);
            Intrinsics.checkNotNullExpressionValue((Object)context, (String)"Intent(ACTION_INTENT_SEN\u2026NT_SENDER_REQUEST, input)");
            return context;
        }

        @Override
        public ActivityResult parseResult(int n, Intent intent) {
            return new ActivityResult(n, intent);
        }

        @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$StartIntentSenderForResult$Companion;", "", "()V", "ACTION_INTENT_SENDER_REQUEST", "", "EXTRA_INTENT_SENDER_REQUEST", "EXTRA_SEND_INTENT_EXCEPTION", "activity_release"}, k=1, mv={1, 8, 0}, xi=48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0017J\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002J\u001d\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0010\u00a8\u0006\u0011"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$TakePicture;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "(ILandroid/content/Intent;)Ljava/lang/Boolean;", "activity_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static class TakePicture
    extends ActivityResultContract<Uri, Boolean> {
        @Override
        public Intent createIntent(Context context, Uri uri) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            Intrinsics.checkNotNullParameter((Object)uri, (String)"input");
            context = new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", (Parcelable)uri);
            Intrinsics.checkNotNullExpressionValue((Object)context, (String)"Intent(MediaStore.ACTION\u2026tore.EXTRA_OUTPUT, input)");
            return context;
        }

        @Override
        public final ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(Context context, Uri uri) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            Intrinsics.checkNotNullParameter((Object)uri, (String)"input");
            return null;
        }

        @Override
        public final Boolean parseResult(int n, Intent intent) {
            boolean bl = n == -1;
            return bl;
        }
    }

    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0017J\"\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u0010"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$TakePicturePreview;", "Landroidx/activity/result/contract/ActivityResultContract;", "Ljava/lang/Void;", "Landroid/graphics/Bitmap;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static class TakePicturePreview
    extends ActivityResultContract<Void, Bitmap> {
        @Override
        public Intent createIntent(Context context, Void void_) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            return new Intent("android.media.action.IMAGE_CAPTURE");
        }

        @Override
        public final ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(Context context, Void void_) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            return null;
        }

        @Override
        public final Bitmap parseResult(int n, Intent intent) {
            n = n == -1 ? 1 : 0;
            Bitmap bitmap = null;
            if (n == 0) {
                intent = null;
            }
            if (intent != null) {
                bitmap = (Bitmap)intent.getParcelableExtra("data");
            }
            return bitmap;
        }
    }

    @Deprecated(message="The thumbnail bitmap is rarely returned and is not a good signal to determine\n      whether the video was actually successfully captured. Use {@link CaptureVideo} instead.")
    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0017\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0017J \u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u0010"}, d2={"Landroidx/activity/result/contract/ActivityResultContracts$TakeVideo;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "Landroid/graphics/Bitmap;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static class TakeVideo
    extends ActivityResultContract<Uri, Bitmap> {
        @Override
        public Intent createIntent(Context context, Uri uri) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            Intrinsics.checkNotNullParameter((Object)uri, (String)"input");
            context = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", (Parcelable)uri);
            Intrinsics.checkNotNullExpressionValue((Object)context, (String)"Intent(MediaStore.ACTION\u2026tore.EXTRA_OUTPUT, input)");
            return context;
        }

        @Override
        public final ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(Context context, Uri uri) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            Intrinsics.checkNotNullParameter((Object)uri, (String)"input");
            return null;
        }

        @Override
        public final Bitmap parseResult(int n, Intent intent) {
            n = n == -1 ? 1 : 0;
            Bitmap bitmap = null;
            if (n == 0) {
                intent = null;
            }
            if (intent != null) {
                bitmap = (Bitmap)intent.getParcelableExtra("data");
            }
            return bitmap;
        }
    }
}

