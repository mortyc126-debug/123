/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Color
 *  android.graphics.ColorSpace
 *  android.graphics.ColorSpace$Named
 *  kotlin.Metadata
 */
package androidx.core.graphics;

import android.graphics.Color;
import android.graphics.ColorSpace;
import androidx.core.graphics.ColorUtils;
import kotlin.Metadata;

@Metadata(d1={"\u0000>\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\r\u0010\u0018\u001a\u00020\u0004*\u00020\u0019H\u0087\n\u001a\r\u0010\u0018\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\r\u0010\u0018\u001a\u00020\u0004*\u00020\u0005H\u0087\n\u001a\r\u0010\u001a\u001a\u00020\u0004*\u00020\u0019H\u0087\n\u001a\r\u0010\u001a\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\r\u0010\u001a\u001a\u00020\u0004*\u00020\u0005H\u0087\n\u001a\r\u0010\u001b\u001a\u00020\u0004*\u00020\u0019H\u0087\n\u001a\r\u0010\u001b\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\r\u0010\u001b\u001a\u00020\u0004*\u00020\u0005H\u0087\n\u001a\r\u0010\u001c\u001a\u00020\u0004*\u00020\u0019H\u0087\n\u001a\r\u0010\u001c\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\r\u0010\u001c\u001a\u00020\u0004*\u00020\u0005H\u0087\n\u001a\u0015\u0010\u001d\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\t\u001a\u00020\nH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\t\u001a\u00020\u001eH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\t\u001a\u00020\u001eH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\t\u001a\u00020\u001eH\u0087\f\u001a\u0015\u0010\u001f\u001a\u00020\u0019*\u00020\u00192\u0006\u0010 \u001a\u00020\u0019H\u0087\u0002\u001a\r\u0010!\u001a\u00020\u0019*\u00020\u0001H\u0087\b\u001a\r\u0010!\u001a\u00020\u0019*\u00020\u0005H\u0087\b\u001a\r\u0010\"\u001a\u00020\u0001*\u00020\u0005H\u0087\b\u001a\r\u0010\"\u001a\u00020\u0001*\u00020#H\u0087\b\u001a\r\u0010$\u001a\u00020\u0005*\u00020\u0001H\u0087\b\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0000\u001a\u00020\u0004*\u00020\u00058\u00c7\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0006\"\u0016\u0010\u0007\u001a\u00020\u0001*\u00020\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0003\"\u0016\u0010\u0007\u001a\u00020\u0004*\u00020\u00058\u00c7\u0002\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0006\"\u0016\u0010\t\u001a\u00020\n*\u00020\u00058\u00c7\u0002\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0016\u0010\r\u001a\u00020\u0001*\u00020\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u0003\"\u0016\u0010\r\u001a\u00020\u0004*\u00020\u00058\u00c7\u0002\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006\"\u0016\u0010\u000f\u001a\u00020\u0010*\u00020\u00058\u00c7\u0002\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011\"\u0016\u0010\u0012\u001a\u00020\u0010*\u00020\u00058\u00c7\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011\"\u0016\u0010\u0013\u001a\u00020\u0004*\u00020\u00018\u00c7\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u0016\u0010\u0013\u001a\u00020\u0004*\u00020\u00058\u00c7\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0006\"\u0016\u0010\u0016\u001a\u00020\u0001*\u00020\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0003\"\u0016\u0010\u0016\u001a\u00020\u0004*\u00020\u00058\u00c7\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0006\u00a8\u0006%"}, d2={"alpha", "", "getAlpha", "(I)I", "", "", "(J)F", "blue", "getBlue", "colorSpace", "Landroid/graphics/ColorSpace;", "getColorSpace", "(J)Landroid/graphics/ColorSpace;", "green", "getGreen", "isSrgb", "", "(J)Z", "isWideGamut", "luminance", "getLuminance", "(I)F", "red", "getRed", "component1", "Landroid/graphics/Color;", "component2", "component3", "component4", "convertTo", "Landroid/graphics/ColorSpace$Named;", "plus", "c", "toColor", "toColorInt", "", "toColorLong", "core-ktx_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class ColorKt {
    public static final float component1(long l) {
        return Color.red((long)l);
    }

    public static final float component1(Color color2) {
        return color2.getComponent(0);
    }

    public static final int component1(int n) {
        return n >> 24 & 0xFF;
    }

    public static final float component2(long l) {
        return Color.green((long)l);
    }

    public static final float component2(Color color2) {
        return color2.getComponent(1);
    }

    public static final int component2(int n) {
        return n >> 16 & 0xFF;
    }

    public static final float component3(long l) {
        return Color.blue((long)l);
    }

    public static final float component3(Color color2) {
        return color2.getComponent(2);
    }

    public static final int component3(int n) {
        return n >> 8 & 0xFF;
    }

    public static final float component4(long l) {
        return Color.alpha((long)l);
    }

    public static final float component4(Color color2) {
        return color2.getComponent(3);
    }

    public static final int component4(int n) {
        return n & 0xFF;
    }

    public static final long convertTo(int n, ColorSpace.Named named) {
        return Color.convert((int)n, (ColorSpace)ColorSpace.get((ColorSpace.Named)named));
    }

    public static final long convertTo(int n, ColorSpace colorSpace) {
        return Color.convert((int)n, (ColorSpace)colorSpace);
    }

    public static final long convertTo(long l, ColorSpace.Named named) {
        return Color.convert((long)l, (ColorSpace)ColorSpace.get((ColorSpace.Named)named));
    }

    public static final long convertTo(long l, ColorSpace colorSpace) {
        return Color.convert((long)l, (ColorSpace)colorSpace);
    }

    public static final Color convertTo(Color color2, ColorSpace.Named named) {
        return color2.convert(ColorSpace.get((ColorSpace.Named)named));
    }

    public static final Color convertTo(Color color2, ColorSpace colorSpace) {
        return color2.convert(colorSpace);
    }

    public static final float getAlpha(long l) {
        return Color.alpha((long)l);
    }

    public static final int getAlpha(int n) {
        return n >> 24 & 0xFF;
    }

    public static final float getBlue(long l) {
        return Color.blue((long)l);
    }

    public static final int getBlue(int n) {
        return n & 0xFF;
    }

    public static final ColorSpace getColorSpace(long l) {
        return Color.colorSpace((long)l);
    }

    public static final float getGreen(long l) {
        return Color.green((long)l);
    }

    public static final int getGreen(int n) {
        return n >> 8 & 0xFF;
    }

    public static final float getLuminance(int n) {
        return Color.luminance((int)n);
    }

    public static final float getLuminance(long l) {
        return Color.luminance((long)l);
    }

    public static final float getRed(long l) {
        return Color.red((long)l);
    }

    public static final int getRed(int n) {
        return n >> 16 & 0xFF;
    }

    public static final boolean isSrgb(long l) {
        return Color.isSrgb((long)l);
    }

    public static final boolean isWideGamut(long l) {
        return Color.isWideGamut((long)l);
    }

    public static final Color plus(Color color2, Color color3) {
        return ColorUtils.compositeColors(color3, color2);
    }

    public static final Color toColor(int n) {
        return Color.valueOf((int)n);
    }

    public static final Color toColor(long l) {
        return Color.valueOf((long)l);
    }

    public static final int toColorInt(long l) {
        return Color.toArgb((long)l);
    }

    public static final int toColorInt(String string2) {
        return Color.parseColor((String)string2);
    }

    public static final long toColorLong(int n) {
        return Color.pack((int)n);
    }
}

