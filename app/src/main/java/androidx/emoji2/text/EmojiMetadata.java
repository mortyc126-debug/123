/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Typeface
 */
package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.emoji2.text.MetadataRepo;
import androidx.emoji2.text.flatbuffer.MetadataItem;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class EmojiMetadata {
    public static final int HAS_GLYPH_ABSENT = 1;
    public static final int HAS_GLYPH_EXISTS = 2;
    public static final int HAS_GLYPH_UNKNOWN = 0;
    private static final ThreadLocal<MetadataItem> sMetadataItem = new ThreadLocal();
    private volatile int mHasGlyph = 0;
    private final int mIndex;
    private final MetadataRepo mMetadataRepo;

    EmojiMetadata(MetadataRepo metadataRepo, int n) {
        this.mMetadataRepo = metadataRepo;
        this.mIndex = n;
    }

    private MetadataItem getMetadataItem() {
        MetadataItem metadataItem;
        MetadataItem metadataItem2 = metadataItem = sMetadataItem.get();
        if (metadataItem == null) {
            metadataItem2 = new MetadataItem();
            sMetadataItem.set(metadataItem2);
        }
        this.mMetadataRepo.getMetadataList().list(metadataItem2, this.mIndex);
        return metadataItem2;
    }

    public void draw(Canvas canvas, float f, float f2, Paint paint) {
        Typeface typeface = this.mMetadataRepo.getTypeface();
        Typeface typeface2 = paint.getTypeface();
        paint.setTypeface(typeface);
        int n = this.mIndex;
        canvas.drawText(this.mMetadataRepo.getEmojiCharArray(), n * 2, 2, f, f2, paint);
        paint.setTypeface(typeface2);
    }

    public int getCodepointAt(int n) {
        return this.getMetadataItem().codepoints(n);
    }

    public int getCodepointsLength() {
        return this.getMetadataItem().codepointsLength();
    }

    public short getCompatAdded() {
        return this.getMetadataItem().compatAdded();
    }

    public int getHasGlyph() {
        return this.mHasGlyph;
    }

    public short getHeight() {
        return this.getMetadataItem().height();
    }

    public int getId() {
        return this.getMetadataItem().id();
    }

    public short getSdkAdded() {
        return this.getMetadataItem().sdkAdded();
    }

    public Typeface getTypeface() {
        return this.mMetadataRepo.getTypeface();
    }

    public short getWidth() {
        return this.getMetadataItem().width();
    }

    public boolean isDefaultEmoji() {
        return this.getMetadataItem().emojiStyle();
    }

    public void resetHasGlyphCache() {
        this.mHasGlyph = 0;
    }

    public void setHasGlyph(boolean bl) {
        int n = bl ? 2 : 1;
        this.mHasGlyph = n;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append(", id:");
        stringBuilder.append(Integer.toHexString(this.getId()));
        stringBuilder.append(", codepoints:");
        int n = this.getCodepointsLength();
        for (int i = 0; i < n; ++i) {
            stringBuilder.append(Integer.toHexString(this.getCodepointAt(i)));
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface HasGlyph {
    }
}

