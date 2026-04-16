/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  android.util.Log
 */
package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

public final class PathParser {
    private static final String LOGTAG = "PathParser";

    private PathParser() {
    }

    private static void addNode(ArrayList<PathDataNode> arrayList, char c, float[] fArray) {
        arrayList.add(new PathDataNode(c, fArray));
    }

    public static boolean canMorph(PathDataNode[] pathDataNodeArray, PathDataNode[] pathDataNodeArray2) {
        if (pathDataNodeArray != null && pathDataNodeArray2 != null) {
            if (pathDataNodeArray.length != pathDataNodeArray2.length) {
                return false;
            }
            for (int i = 0; i < pathDataNodeArray.length; ++i) {
                if (pathDataNodeArray[i].mType == pathDataNodeArray2[i].mType && pathDataNodeArray[i].mParams.length == pathDataNodeArray2[i].mParams.length) {
                    continue;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    static float[] copyOfRange(float[] fArray, int n, int n2) {
        if (n <= n2) {
            int n3 = fArray.length;
            if (n >= 0 && n <= n3) {
                n3 = Math.min(n2 -= n, n3 - n);
                float[] fArray2 = new float[n2];
                System.arraycopy(fArray, n, fArray2, 0, n3);
                return fArray2;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new IllegalArgumentException();
    }

    public static PathDataNode[] createNodesFromPathData(String string2) {
        int n = 0;
        int n2 = 1;
        ArrayList<PathDataNode> arrayList = new ArrayList<PathDataNode>();
        while (n2 < string2.length()) {
            String string3 = string2.substring(n, n2 = PathParser.nextStart(string2, n2)).trim();
            if (!string3.isEmpty()) {
                float[] fArray = PathParser.getFloats(string3);
                PathParser.addNode(arrayList, string3.charAt(0), fArray);
            }
            n = n2++;
        }
        if (n2 - n == 1 && n < string2.length()) {
            PathParser.addNode(arrayList, string2.charAt(n), new float[0]);
        }
        return arrayList.toArray(new PathDataNode[0]);
    }

    public static Path createPathFromPathData(String string2) {
        Path path2 = new Path();
        PathDataNode[] pathDataNodeArray = PathParser.createNodesFromPathData(string2);
        try {
            PathDataNode.nodesToPath(pathDataNodeArray, path2);
            return path2;
        }
        catch (RuntimeException runtimeException) {
            throw new RuntimeException("Error in parsing " + string2, runtimeException);
        }
    }

    public static PathDataNode[] deepCopyNodes(PathDataNode[] pathDataNodeArray) {
        PathDataNode[] pathDataNodeArray2 = new PathDataNode[pathDataNodeArray.length];
        for (int i = 0; i < pathDataNodeArray.length; ++i) {
            pathDataNodeArray2[i] = new PathDataNode(pathDataNodeArray[i]);
        }
        return pathDataNodeArray2;
    }

    private static void extract(String string2, int n, ExtractFloatResult extractFloatResult) {
        int n2;
        boolean bl = false;
        extractFloatResult.mEndWithNegOrDot = false;
        boolean bl2 = false;
        boolean bl3 = false;
        for (n2 = n; n2 < string2.length(); ++n2) {
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7 = false;
            switch (string2.charAt(n2)) {
                default: {
                    bl6 = bl;
                    bl5 = bl2;
                    bl4 = bl7;
                    break;
                }
                case 'E': 
                case 'e': {
                    bl4 = true;
                    bl6 = bl;
                    bl5 = bl2;
                    break;
                }
                case '.': {
                    if (!bl2) {
                        bl5 = true;
                        bl6 = bl;
                        bl4 = bl7;
                        break;
                    }
                    bl6 = true;
                    extractFloatResult.mEndWithNegOrDot = true;
                    bl5 = bl2;
                    bl4 = bl7;
                    break;
                }
                case '-': {
                    bl6 = bl;
                    bl5 = bl2;
                    bl4 = bl7;
                    if (n2 == n) break;
                    bl6 = bl;
                    bl5 = bl2;
                    bl4 = bl7;
                    if (bl3) break;
                    bl6 = true;
                    extractFloatResult.mEndWithNegOrDot = true;
                    bl5 = bl2;
                    bl4 = bl7;
                    break;
                }
                case ' ': 
                case ',': {
                    bl6 = true;
                    bl4 = bl7;
                    bl5 = bl2;
                }
            }
            if (bl6) break;
            bl = bl6;
            bl2 = bl5;
            bl3 = bl4;
        }
        extractFloatResult.mEndPosition = n2;
    }

    private static float[] getFloats(String string2) {
        if (string2.charAt(0) != 'z' && string2.charAt(0) != 'Z') {
            float[] fArray = new float[string2.length()];
            int n = 0;
            int n2 = 1;
            ExtractFloatResult extractFloatResult = new ExtractFloatResult();
            int n3 = string2.length();
            while (n2 < n3) {
                int n4;
                int n5;
                block10: {
                    PathParser.extract(string2, n2, extractFloatResult);
                    n5 = extractFloatResult.mEndPosition;
                    n4 = n;
                    if (n2 >= n5) break block10;
                    fArray[n] = Float.parseFloat(string2.substring(n2, n5));
                    n4 = n + 1;
                }
                if (extractFloatResult.mEndWithNegOrDot) {
                    n2 = n5;
                    n = n4;
                    continue;
                }
                n2 = n5 + 1;
                n = n4;
            }
            try {
                fArray = PathParser.copyOfRange(fArray, 0, n);
                return fArray;
            }
            catch (NumberFormatException numberFormatException) {
                throw new RuntimeException("error in parsing \"" + string2 + "\"", numberFormatException);
            }
        }
        return new float[0];
    }

    public static void interpolatePathDataNodes(PathDataNode[] pathDataNodeArray, float f, PathDataNode[] pathDataNodeArray2, PathDataNode[] pathDataNodeArray3) {
        if (PathParser.interpolatePathDataNodes(pathDataNodeArray, pathDataNodeArray2, pathDataNodeArray3, f)) {
            return;
        }
        throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
    }

    @Deprecated
    public static boolean interpolatePathDataNodes(PathDataNode[] pathDataNodeArray, PathDataNode[] pathDataNodeArray2, PathDataNode[] pathDataNodeArray3, float f) {
        if (pathDataNodeArray.length == pathDataNodeArray2.length && pathDataNodeArray2.length == pathDataNodeArray3.length) {
            if (!PathParser.canMorph(pathDataNodeArray2, pathDataNodeArray3)) {
                return false;
            }
            for (int i = 0; i < pathDataNodeArray.length; ++i) {
                pathDataNodeArray[i].interpolatePathDataNode(pathDataNodeArray2[i], pathDataNodeArray3[i], f);
            }
            return true;
        }
        throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
    }

    private static int nextStart(String string2, int n) {
        while (n < string2.length()) {
            char c = string2.charAt(n);
            if (((c - 65) * (c - 90) <= 0 || (c - 97) * (c - 122) <= 0) && c != 'e' && c != 'E') {
                return n;
            }
            ++n;
        }
        return n;
    }

    public static void nodesToPath(PathDataNode[] pathDataNodeArray, Path path2) {
        float[] fArray = new float[6];
        char c = 'm';
        for (PathDataNode pathDataNode : pathDataNodeArray) {
            PathDataNode.addCommand(path2, fArray, c, pathDataNode.mType, pathDataNode.mParams);
            c = pathDataNode.mType;
        }
    }

    public static void updateNodes(PathDataNode[] pathDataNodeArray, PathDataNode[] pathDataNodeArray2) {
        for (int i = 0; i < pathDataNodeArray2.length; ++i) {
            PathDataNode.access$002(pathDataNodeArray[i], pathDataNodeArray2[i].mType);
            for (int j = 0; j < pathDataNodeArray2[i].mParams.length; ++j) {
                ((PathDataNode)pathDataNodeArray[i]).mParams[j] = pathDataNodeArray2[i].mParams[j];
            }
        }
    }

    private static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;

        ExtractFloatResult() {
        }
    }

    public static class PathDataNode {
        private final float[] mParams;
        private char mType;

        PathDataNode(char c, float[] fArray) {
            this.mType = c;
            this.mParams = fArray;
        }

        PathDataNode(PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            this.mParams = PathParser.copyOfRange(pathDataNode.mParams, 0, pathDataNode.mParams.length);
        }

        static /* synthetic */ char access$002(PathDataNode pathDataNode, char c) {
            pathDataNode.mType = c;
            return c;
        }

        private static void addCommand(Path path2, float[] fArray, char c, char c2, float[] fArray2) {
            int n;
            Path path3 = path2;
            float f = fArray[0];
            float f2 = fArray[1];
            float f3 = fArray[2];
            float f4 = fArray[3];
            float f5 = fArray[4];
            float f6 = fArray[5];
            switch (c2) {
                default: {
                    n = 2;
                    break;
                }
                case 'Z': 
                case 'z': {
                    path2.close();
                    f = f5;
                    f2 = f6;
                    f3 = f5;
                    f4 = f6;
                    path3.moveTo(f, f2);
                    n = 2;
                    break;
                }
                case 'Q': 
                case 'S': 
                case 'q': 
                case 's': {
                    n = 4;
                    break;
                }
                case 'L': 
                case 'M': 
                case 'T': 
                case 'l': 
                case 'm': 
                case 't': {
                    n = 2;
                    break;
                }
                case 'H': 
                case 'V': 
                case 'h': 
                case 'v': {
                    n = 1;
                    break;
                }
                case 'C': 
                case 'c': {
                    n = 6;
                    break;
                }
                case 'A': 
                case 'a': {
                    n = 7;
                }
            }
            float f7 = f3;
            float f8 = f4;
            f4 = f5;
            f5 = f2;
            f3 = f6;
            f6 = f;
            for (int i = 0; i < fArray2.length; i += n) {
                switch (c2) {
                    default: {
                        f2 = f7;
                        f = f8;
                        break;
                    }
                    case 'v': {
                        path3.rLineTo(0.0f, fArray2[i + 0]);
                        f5 += fArray2[i + 0];
                        f2 = f7;
                        f = f8;
                        break;
                    }
                    case 't': {
                        f = 0.0f;
                        f2 = 0.0f;
                        if (c == 'q' || c == 't' || c == 'Q' || c == 'T') {
                            f = f6 - f7;
                            f2 = f5 - f8;
                        }
                        path3.rQuadTo(f, f2, fArray2[i + 0], fArray2[i + 1]);
                        f8 = f6 + fArray2[i + 0];
                        f7 = f5 + fArray2[i + 1];
                        f = f6 + f;
                        float f9 = f5 + f2;
                        f5 = f7;
                        f6 = f8;
                        f2 = f;
                        f = f9;
                        break;
                    }
                    case 's': {
                        if (c != 'c' && c != 's' && c != 'C' && c != 'S') {
                            f2 = 0.0f;
                            f = 0.0f;
                        } else {
                            f2 = f6 - f7;
                            f = f5 - f8;
                        }
                        path2.rCubicTo(f2, f, fArray2[i + 0], fArray2[i + 1], fArray2[i + 2], fArray2[i + 3]);
                        f = fArray2[i + 0];
                        f8 = fArray2[i + 1];
                        f2 = f6 + fArray2[i + 2];
                        f7 = fArray2[i + 3];
                        f8 = f5 + f8;
                        f5 = f7 + f5;
                        f6 = f2;
                        f2 = f += f6;
                        f = f8;
                        break;
                    }
                    case 'q': {
                        path3.rQuadTo(fArray2[i + 0], fArray2[i + 1], fArray2[i + 2], fArray2[i + 3]);
                        f = fArray2[i + 0];
                        f8 = fArray2[i + 1];
                        f2 = f6 + fArray2[i + 2];
                        f7 = fArray2[i + 3];
                        f8 = f5 + f8;
                        f5 = f7 + f5;
                        f6 = f2;
                        f2 = f += f6;
                        f = f8;
                        break;
                    }
                    case 'm': {
                        f6 += fArray2[i + 0];
                        f5 += fArray2[i + 1];
                        if (i > 0) {
                            path3.rLineTo(fArray2[i + 0], fArray2[i + 1]);
                            f2 = f7;
                            f = f8;
                            break;
                        }
                        path3.rMoveTo(fArray2[i + 0], fArray2[i + 1]);
                        f4 = f6;
                        f3 = f5;
                        f2 = f7;
                        f = f8;
                        break;
                    }
                    case 'l': {
                        path3.rLineTo(fArray2[i + 0], fArray2[i + 1]);
                        f6 += fArray2[i + 0];
                        f5 += fArray2[i + 1];
                        f2 = f7;
                        f = f8;
                        break;
                    }
                    case 'h': {
                        path3.rLineTo(fArray2[i + 0], 0.0f);
                        f6 += fArray2[i + 0];
                        f2 = f7;
                        f = f8;
                        break;
                    }
                    case 'c': {
                        path2.rCubicTo(fArray2[i + 0], fArray2[i + 1], fArray2[i + 2], fArray2[i + 3], fArray2[i + 4], fArray2[i + 5]);
                        f8 = fArray2[i + 2];
                        f = fArray2[i + 3];
                        f2 = f6 + fArray2[i + 4];
                        f7 = fArray2[i + 5];
                        f = f5 + f;
                        f5 = f7 + f5;
                        f6 = f2;
                        f2 = f8 += f6;
                        break;
                    }
                    case 'a': {
                        float f9 = fArray2[i + 5];
                        f2 = fArray2[i + 6];
                        f7 = fArray2[i + 0];
                        f = fArray2[i + 1];
                        f8 = fArray2[i + 2];
                        boolean bl = fArray2[i + 3] != 0.0f;
                        boolean bl2 = fArray2[i + 4] != 0.0f;
                        PathDataNode.drawArc(path2, f6, f5, f9 + f6, f2 + f5, f7, f, f8, bl, bl2);
                        path3 = path2;
                        f2 = f6 += fArray2[i + 5];
                        f = f5 += fArray2[i + 6];
                        break;
                    }
                    case 'V': {
                        f5 = fArray2[i + 0];
                        path3 = path2;
                        path3.lineTo(f6, f5);
                        f5 = fArray2[i + 0];
                        f2 = f7;
                        f = f8;
                        break;
                    }
                    case 'T': {
                        f = f6;
                        f2 = f5;
                        if (c == 'q' || c == 't' || c == 'Q' || c == 'T') {
                            f = f6 * 2.0f - f7;
                            f2 = f5 * 2.0f - f8;
                        }
                        path3.quadTo(f, f2, fArray2[i + 0], fArray2[i + 1]);
                        f6 = fArray2[i + 0];
                        f5 = fArray2[i + 1];
                        f8 = f;
                        f = f2;
                        f2 = f8;
                        break;
                    }
                    case 'S': {
                        if (c == 'c' || c == 's' || c == 'C' || c == 'S') {
                            f6 = f6 * 2.0f - f7;
                            f5 = f5 * 2.0f - f8;
                        }
                        path2.cubicTo(f6, f5, fArray2[i + 0], fArray2[i + 1], fArray2[i + 2], fArray2[i + 3]);
                        f2 = fArray2[i + 0];
                        f = fArray2[i + 1];
                        f6 = fArray2[i + 2];
                        f5 = fArray2[i + 3];
                        break;
                    }
                    case 'Q': {
                        path3.quadTo(fArray2[i + 0], fArray2[i + 1], fArray2[i + 2], fArray2[i + 3]);
                        f2 = fArray2[i + 0];
                        f = fArray2[i + 1];
                        f6 = fArray2[i + 2];
                        f5 = fArray2[i + 3];
                        break;
                    }
                    case 'M': {
                        f5 = fArray2[i + 0];
                        f6 = fArray2[i + 1];
                        if (i > 0) {
                            path3.lineTo(fArray2[i + 0], fArray2[i + 1]);
                            f2 = f5;
                            f5 = f6;
                            f6 = f2;
                            f2 = f7;
                            f = f8;
                            break;
                        }
                        path3.moveTo(fArray2[i + 0], fArray2[i + 1]);
                        f2 = f5;
                        f = f6;
                        f4 = f5;
                        f3 = f6;
                        f5 = f;
                        f6 = f2;
                        f2 = f7;
                        f = f8;
                        break;
                    }
                    case 'L': {
                        path3.lineTo(fArray2[i + 0], fArray2[i + 1]);
                        f6 = fArray2[i + 0];
                        f5 = fArray2[i + 1];
                        f2 = f7;
                        f = f8;
                        break;
                    }
                    case 'H': {
                        path3.lineTo(fArray2[i + 0], f5);
                        f6 = fArray2[i + 0];
                        f2 = f7;
                        f = f8;
                        break;
                    }
                    case 'C': {
                        path2.cubicTo(fArray2[i + 0], fArray2[i + 1], fArray2[i + 2], fArray2[i + 3], fArray2[i + 4], fArray2[i + 5]);
                        f6 = fArray2[i + 4];
                        f5 = fArray2[i + 5];
                        f2 = fArray2[i + 2];
                        f = fArray2[i + 3];
                        break;
                    }
                    case 'A': {
                        f = fArray2[i + 5];
                        f7 = fArray2[i + 6];
                        f8 = fArray2[i + 0];
                        float f9 = fArray2[i + 1];
                        f2 = fArray2[i + 2];
                        boolean bl = fArray2[i + 3] != 0.0f;
                        boolean bl2 = fArray2[i + 4] != 0.0f;
                        PathDataNode.drawArc(path2, f6, f5, f, f7, f8, f9, f2, bl, bl2);
                        f2 = fArray2[i + 5];
                        f = fArray2[i + 6];
                        f6 = f2;
                        f5 = f;
                    }
                }
                c = c2;
                f7 = f2;
                f8 = f;
            }
            fArray[0] = f6;
            fArray[1] = f5;
            fArray[2] = f7;
            fArray[3] = f8;
            fArray[4] = f4;
            fArray[5] = f3;
        }

        private static void arcToBezier(Path path2, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            int n = (int)Math.ceil(Math.abs(d9 * 4.0 / Math.PI));
            double d10 = Math.cos(d7);
            double d11 = Math.sin(d7);
            d7 = Math.cos(d8);
            double d12 = Math.sin(d8);
            double d13 = -d3;
            double d14 = -d3 * d11 * d12 + d4 * d10 * d7;
            double d15 = d9 / (double)n;
            double d16 = d5;
            d13 = d13 * d10 * d12 - d4 * d11 * d7;
            double d17 = d8;
            d9 = d14;
            d14 = d6;
            d8 = d12;
            d5 = d11;
            d6 = d10;
            for (int i = 0; i < n; ++i) {
                double d18 = d17 + d15;
                d12 = Math.sin(d18);
                double d19 = Math.cos(d18);
                double d20 = d + d3 * d6 * d19 - d4 * d5 * d12;
                d11 = d2 + d3 * d5 * d19 + d4 * d6 * d12;
                d10 = -d3 * d6 * d12 - d4 * d5 * d19;
                d12 = -d3 * d5 * d12 + d4 * d6 * d19;
                d19 = Math.tan((d18 - d17) / 2.0);
                d17 = Math.sin(d18 - d17) * (Math.sqrt(d19 * 3.0 * d19 + 4.0) - 1.0) / 3.0;
                path2.rLineTo(0.0f, 0.0f);
                path2.cubicTo((float)(d16 + d17 * d13), (float)(d14 + d17 * d9), (float)(d20 - d17 * d10), (float)(d11 - d17 * d12), (float)d20, (float)d11);
                d17 = d18;
                d16 = d20;
                d14 = d11;
                d13 = d10;
                d9 = d12;
            }
        }

        private static void drawArc(Path path2, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean bl, boolean bl2) {
            double d = Math.toRadians(f7);
            double d2 = Math.cos(d);
            double d3 = Math.sin(d);
            double d4 = ((double)f * d2 + (double)f2 * d3) / (double)f5;
            double d5 = ((double)(-f) * d3 + (double)f2 * d2) / (double)f6;
            double d6 = ((double)f3 * d2 + (double)f4 * d3) / (double)f5;
            double d7 = ((double)(-f3) * d3 + (double)f4 * d2) / (double)f6;
            double d8 = d4 - d6;
            double d9 = d5 - d7;
            double d10 = (d4 + d6) / 2.0;
            double d11 = (d5 + d7) / 2.0;
            double d12 = d8 * d8 + d9 * d9;
            if (d12 == 0.0) {
                Log.w((String)PathParser.LOGTAG, (String)" Points are coincident");
                return;
            }
            double d13 = 1.0 / d12 - 0.25;
            if (d13 < 0.0) {
                Log.w((String)PathParser.LOGTAG, (String)("Points are too far apart " + d12));
                float f8 = (float)(Math.sqrt(d12) / 1.99999);
                PathDataNode.drawArc(path2, f, f2, f3, f4, f5 * f8, f6 * f8, f7, bl, bl2);
                return;
            }
            d12 = Math.sqrt(d13);
            d8 = d12 * d8;
            d9 = d12 * d9;
            if (bl == bl2) {
                d10 -= d9;
                d11 += d8;
            } else {
                d10 += d9;
                d11 -= d8;
            }
            d5 = Math.atan2(d5 - d11, d4 - d10);
            d6 = Math.atan2(d7 - d11, d6 - d10) - d5;
            bl = d6 >= 0.0;
            d7 = d6;
            if (bl2 != bl) {
                d7 = d6 > 0.0 ? d6 - Math.PI * 2 : d6 + Math.PI * 2;
            }
            d11 = (double)f6 * d11;
            PathDataNode.arcToBezier(path2, (d10 *= (double)f5) * d2 - d11 * d3, d10 * d3 + d11 * d2, f5, f6, f, f2, d, d5, d7);
        }

        @Deprecated
        public static void nodesToPath(PathDataNode[] pathDataNodeArray, Path path2) {
            PathParser.nodesToPath(pathDataNodeArray, path2);
        }

        public float[] getParams() {
            return this.mParams;
        }

        public char getType() {
            return this.mType;
        }

        public void interpolatePathDataNode(PathDataNode pathDataNode, PathDataNode pathDataNode2, float f) {
            this.mType = pathDataNode.mType;
            for (int i = 0; i < pathDataNode.mParams.length; ++i) {
                this.mParams[i] = pathDataNode.mParams[i] * (1.0f - f) + pathDataNode2.mParams[i] * f;
            }
        }
    }
}

