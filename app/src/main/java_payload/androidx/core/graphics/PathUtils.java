/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  android.graphics.PointF
 */
package androidx.core.graphics;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.core.graphics.PathSegment;
import java.util.ArrayList;
import java.util.Collection;

public final class PathUtils {
    private PathUtils() {
    }

    public static Collection<PathSegment> flatten(Path path2) {
        return PathUtils.flatten(path2, 0.5f);
    }

    public static Collection<PathSegment> flatten(Path object, float object2) {
        object = Api26Impl.approximate(object, object2);
        int n = ((Path)object).length / 3;
        ArrayList<PathSegment> arrayList = new ArrayList<PathSegment>(n);
        for (int i = 1; i < n; ++i) {
            int n2 = i * 3;
            int n3 = (i - 1) * 3;
            Path path2 = object[n2];
            Path path3 = object[n2 + 1];
            Path path4 = object[n2 + 2];
            Path path5 = object[n3];
            Path path6 = object[n3 + 1];
            object2 = object[n3 + 2];
            if (path2 == path5 || path3 == path6 && path4 == object2) continue;
            arrayList.add(new PathSegment(new PointF((float)path6, object2), (float)path5, new PointF((float)path3, (float)path4), (float)path2));
        }
        return arrayList;
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static float[] approximate(Path path2, float f) {
            return path2.approximate(f);
        }
    }
}

