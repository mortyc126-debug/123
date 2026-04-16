/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.Editable
 *  android.text.Selection
 *  android.text.Spannable
 *  android.text.SpannableString
 *  android.text.Spanned
 *  android.text.method.MetaKeyKeyListener
 *  android.view.KeyEvent
 *  android.view.inputmethod.InputConnection
 */
package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.EmojiMetadata;
import androidx.emoji2.text.EmojiSpan;
import androidx.emoji2.text.MetadataRepo;
import androidx.emoji2.text.SpannableBuilder;
import androidx.emoji2.text.UnprecomputeTextOnModificationSpannable;
import java.util.Arrays;

final class EmojiProcessor {
    private static final int ACTION_ADVANCE_BOTH = 1;
    private static final int ACTION_ADVANCE_END = 2;
    private static final int ACTION_FLUSH = 3;
    private final int[] mEmojiAsDefaultStyleExceptions;
    private EmojiCompat.GlyphChecker mGlyphChecker;
    private final MetadataRepo mMetadataRepo;
    private final EmojiCompat.SpanFactory mSpanFactory;
    private final boolean mUseEmojiAsDefaultStyle;

    EmojiProcessor(MetadataRepo metadataRepo, EmojiCompat.SpanFactory spanFactory, EmojiCompat.GlyphChecker glyphChecker, boolean bl, int[] nArray) {
        this.mSpanFactory = spanFactory;
        this.mMetadataRepo = metadataRepo;
        this.mGlyphChecker = glyphChecker;
        this.mUseEmojiAsDefaultStyle = bl;
        this.mEmojiAsDefaultStyleExceptions = nArray;
    }

    private void addEmoji(Spannable spannable, EmojiMetadata emojiMetadata, int n, int n2) {
        spannable.setSpan((Object)this.mSpanFactory.createSpan(emojiMetadata), n, n2, 33);
    }

    /*
     * WARNING - void declaration
     */
    private static boolean delete(Editable editable, KeyEvent object2, boolean bl) {
        int n;
        if (EmojiProcessor.hasModifiers((KeyEvent)object2)) {
            return false;
        }
        int n2 = Selection.getSelectionStart((CharSequence)editable);
        if (EmojiProcessor.hasInvalidSelection(n2, n = Selection.getSelectionEnd((CharSequence)editable))) {
            return false;
        }
        EmojiSpan[] emojiSpanArray = (EmojiSpan[])editable.getSpans(n2, n, EmojiSpan.class);
        if (emojiSpanArray != null && emojiSpanArray.length > 0) {
            for (EmojiSpan emojiSpan : emojiSpanArray) {
                void var2_4;
                int n3 = editable.getSpanStart((Object)emojiSpan);
                int n4 = editable.getSpanEnd((Object)emojiSpan);
                if (!(var2_4 != false && n3 == n2 || var2_4 == false && n4 == n2) && (n2 <= n3 || n2 >= n4)) continue;
                editable.delete(n3, n4);
                return true;
            }
        }
        return false;
    }

    static boolean handleDeleteSurroundingText(InputConnection inputConnection, Editable editable, int n, int n2, boolean bl) {
        block5: {
            block6: {
                EmojiSpan[] emojiSpanArray;
                block9: {
                    int n3;
                    int n4;
                    block7: {
                        block8: {
                            if (editable == null || inputConnection == null) break block5;
                            if (n < 0 || n2 < 0) break block6;
                            n4 = Selection.getSelectionStart((CharSequence)editable);
                            if (EmojiProcessor.hasInvalidSelection(n4, n3 = Selection.getSelectionEnd((CharSequence)editable))) {
                                return false;
                            }
                            if (!bl) break block7;
                            n = CodepointIndexFinder.findIndexBackward((CharSequence)editable, n4, Math.max(n, 0));
                            n3 = CodepointIndexFinder.findIndexForward((CharSequence)editable, n3, Math.max(n2, 0));
                            if (n == -1) break block8;
                            n2 = n3;
                            if (n3 != -1) break block9;
                        }
                        return false;
                    }
                    n = Math.max(n4 - n, 0);
                    n2 = Math.min(n3 + n2, editable.length());
                }
                if ((emojiSpanArray = (EmojiSpan[])editable.getSpans(n, n2, EmojiSpan.class)) != null && emojiSpanArray.length > 0) {
                    for (EmojiSpan emojiSpan : emojiSpanArray) {
                        int n5 = editable.getSpanStart((Object)emojiSpan);
                        int n6 = editable.getSpanEnd((Object)emojiSpan);
                        n = Math.min(n5, n);
                        n2 = Math.max(n6, n2);
                    }
                    n = Math.max(n, 0);
                    n2 = Math.min(n2, editable.length());
                    inputConnection.beginBatchEdit();
                    editable.delete(n, n2);
                    inputConnection.endBatchEdit();
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    static boolean handleOnKeyDown(Editable editable, int n, KeyEvent keyEvent) {
        boolean bl;
        switch (n) {
            default: {
                bl = false;
                break;
            }
            case 112: {
                bl = EmojiProcessor.delete(editable, keyEvent, true);
                break;
            }
            case 67: {
                bl = EmojiProcessor.delete(editable, keyEvent, false);
            }
        }
        if (bl) {
            MetaKeyKeyListener.adjustMetaAfterKeypress((Spannable)editable);
            return true;
        }
        return false;
    }

    private boolean hasGlyph(CharSequence charSequence, int n, int n2, EmojiMetadata emojiMetadata) {
        if (emojiMetadata.getHasGlyph() == 0) {
            emojiMetadata.setHasGlyph(this.mGlyphChecker.hasGlyph(charSequence, n, n2, emojiMetadata.getSdkAdded()));
        }
        boolean bl = emojiMetadata.getHasGlyph() == 2;
        return bl;
    }

    private static boolean hasInvalidSelection(int n, int n2) {
        boolean bl = n == -1 || n2 == -1 || n != n2;
        return bl;
    }

    private static boolean hasModifiers(KeyEvent keyEvent) {
        return KeyEvent.metaStateHasNoModifiers((int)keyEvent.getMetaState()) ^ true;
    }

    int getEmojiMatch(CharSequence charSequence) {
        return this.getEmojiMatch(charSequence, this.mMetadataRepo.getMetadataVersion());
    }

    int getEmojiMatch(CharSequence charSequence, int n) {
        ProcessorSm processorSm = new ProcessorSm(this.mMetadataRepo.getRootNode(), this.mUseEmojiAsDefaultStyle, this.mEmojiAsDefaultStyleExceptions);
        int n2 = charSequence.length();
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        while (n3 < n2) {
            int n6;
            int n7 = Character.codePointAt(charSequence, n3);
            int n8 = processorSm.check(n7);
            EmojiMetadata emojiMetadata = processorSm.getCurrentMetadata();
            switch (n8) {
                default: {
                    n8 = n3;
                    n7 = n4;
                    n6 = n5;
                    break;
                }
                case 3: {
                    EmojiMetadata emojiMetadata2 = processorSm.getFlushMetadata();
                    n8 = n3;
                    n7 = n4;
                    n6 = n5;
                    emojiMetadata = emojiMetadata2;
                    if (emojiMetadata2.getCompatAdded() > n) break;
                    n6 = n5 + 1;
                    n8 = n3;
                    n7 = n4;
                    emojiMetadata = emojiMetadata2;
                    break;
                }
                case 2: {
                    n8 = n3 + Character.charCount(n7);
                    n7 = n4;
                    n6 = n5;
                    break;
                }
                case 1: {
                    n8 = n3 + Character.charCount(n7);
                    n7 = 0;
                    n6 = n5;
                }
            }
            n4 = n7;
            if (emojiMetadata != null) {
                n4 = n7;
                if (emojiMetadata.getCompatAdded() <= n) {
                    n4 = n7 + 1;
                }
            }
            n3 = n8;
            n5 = n6;
        }
        if (n5 != 0) {
            return 2;
        }
        if (processorSm.isInFlushableState() && processorSm.getCurrentMetadata().getCompatAdded() <= n) {
            return 1;
        }
        if (n4 == 0) {
            return 0;
        }
        return 2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    CharSequence process(CharSequence var1_1, int var2_2, int var3_3, int var4_4, boolean var5_5) {
        block37: {
            block38: {
                block34: {
                    block36: {
                        block35: {
                            var12_6 = var1_1 instanceof SpannableBuilder;
                            if (var12_6) {
                                ((SpannableBuilder)var1_1).beginBatchEdit();
                            }
                            var14_7 /* !! */  = null;
                            if (var12_6) ** GOTO lbl15
                            if (var1_1 instanceof Spannable) break block35;
                            var13_8 = var14_7 /* !! */ ;
                            if (var1_1 instanceof Spanned) {
                                var13_8 = var14_7 /* !! */ ;
                                if (((Spanned)var1_1).nextSpanTransition(var2_2 - 1, var3_3 + 1, EmojiSpan.class) <= var3_3) {
                                    var13_8 = new UnprecomputeTextOnModificationSpannable(var1_1);
                                }
                            }
                            break block36;
                        }
                        var13_8 = new UnprecomputeTextOnModificationSpannable((Spannable)var1_1);
                    }
                    var6_10 = var2_2;
                    var7_11 = var3_3;
                    if (var13_8 == null) break block34;
                    var14_7 /* !! */  = var13_8.getSpans(var2_2, var3_3, EmojiSpan.class);
                    var6_10 = var2_2;
                    var7_11 = var3_3;
                    if (var14_7 /* !! */  == null) break block34;
                    var6_10 = var2_2;
                    var7_11 = var3_3;
                    if (((EmojiSpan[])var14_7 /* !! */ ).length <= 0) break block34;
                    var9_12 = ((EmojiSpan[])var14_7 /* !! */ ).length;
                    var8_13 = 0;
                    while (true) {
                        var6_10 = var2_2;
                        var7_11 = var3_3;
                        if (var8_13 >= var9_12) break;
                        var15_14 = var14_7 /* !! */ [var8_13];
                        {
                            var7_11 = var13_8.getSpanStart(var15_14);
                            var6_10 = var13_8.getSpanEnd(var15_14);
                            if (var7_11 != var3_3) {
                                var13_8.removeSpan(var15_14);
                            }
                            var2_2 = Math.min(var7_11, var2_2);
                            var3_3 = Math.max(var6_10, var3_3);
                            ++var8_13;
                            continue;
                        }
                        break;
                    }
                }
                if (var6_10 == var7_11) return var1_1;
                ** try [egrp 2[TRYBLOCK] [9 : 233->708)] { 
lbl49:
                // 1 sources

                if (var6_10 >= var1_1.length()) {
                    return var1_1;
                }
                var8_13 = var4_4;
                if (var4_4 != 0x7FFFFFFF) {
                    var8_13 = var4_4;
                    if (var13_8 != null) {
                        var8_13 = var4_4 - var13_8.getSpans(0, var13_8.length(), EmojiSpan.class).length;
                    }
                }
                var2_2 = 0;
                var15_14 = new ProcessorSm(this.mMetadataRepo.getRootNode(), this.mUseEmojiAsDefaultStyle, this.mEmojiAsDefaultStyleExceptions);
                var3_3 = var6_10;
                var4_4 = Character.codePointAt(var1_1, var3_3);
                var9_12 = var6_10;
                var6_10 = var4_4;
                while (var3_3 < var7_11 && var2_2 < var8_13) {
                    switch (var15_14.check(var6_10)) {
                        default: {
                            var14_7 /* !! */  = var13_8;
                            var10_15 = var2_2;
                            var4_4 = var9_12;
                            break;
                        }
                        case 3: {
                            if (var5_5) ** GOTO lbl74
                            var14_7 /* !! */  = var13_8;
                            var4_4 = var2_2;
                            if (this.hasGlyph(var1_1, var9_12, var3_3, var15_14.getFlushMetadata())) ** GOTO lbl80
lbl74:
                            // 2 sources

                            var14_7 /* !! */  = var13_8;
                            if (var13_8 == null) {
                                var13_8 = new SpannableString(var1_1);
                                var14_7 /* !! */  = new UnprecomputeTextOnModificationSpannable((Spannable)var13_8);
                            }
                            this.addEmoji((Spannable)var14_7 /* !! */ , var15_14.getFlushMetadata(), var9_12, var3_3);
                            var4_4 = var2_2 + 1;
lbl80:
                            // 2 sources

                            var2_2 = var3_3;
                            var10_15 = var4_4;
                            var4_4 = var2_2;
                            break;
                        }
                        case 2: {
                            var11_16 = var3_3 + Character.charCount(var6_10);
                            var14_7 /* !! */  = var13_8;
                            var10_15 = var2_2;
                            var3_3 = var11_16;
                            var4_4 = var9_12;
                            if (var11_16 >= var7_11) break;
                            var6_10 = Character.codePointAt(var1_1, var11_16);
                            var14_7 /* !! */  = var13_8;
                            var10_15 = var2_2;
                            var3_3 = var11_16;
                            var4_4 = var9_12;
                            break;
                        }
                        case 1: {
                            var9_12 += Character.charCount(Character.codePointAt(var1_1, var9_12));
                            var11_16 = var9_12;
                            var14_7 /* !! */  = var13_8;
                            var10_15 = var2_2;
                            var3_3 = var11_16;
                            var4_4 = var9_12;
                            if (var11_16 >= var7_11) break;
                            var6_10 = Character.codePointAt(var1_1, var11_16);
                            var4_4 = var9_12;
                            var3_3 = var11_16;
                            var10_15 = var2_2;
                            var14_7 /* !! */  = var13_8;
                        }
                    }
                    var13_8 = var14_7 /* !! */ ;
                    var2_2 = var10_15;
                    var9_12 = var4_4;
                }
                var14_7 /* !! */  = var13_8;
                if (!var15_14.isInFlushableState()) break block37;
                var14_7 /* !! */  = var13_8;
                if (var2_2 >= var8_13) break block37;
                if (var5_5) break block38;
                var14_7 /* !! */  = var13_8;
                if (this.hasGlyph(var1_1, var9_12, var3_3, var15_14.getCurrentMetadata())) break block37;
            }
            var14_7 /* !! */  = var13_8;
            if (var13_8 == null) {
                var14_7 /* !! */  = new UnprecomputeTextOnModificationSpannable(var1_1);
            }
            this.addEmoji((Spannable)var14_7 /* !! */ , var15_14.getCurrentMetadata(), var9_12, var3_3);
        }
        if (var14_7 /* !! */  == null) return var1_1;
        return var14_7 /* !! */ .getUnwrappedSpannable();
lbl129:
        // 1 sources

        finally {
            if (var12_6) {
                ((SpannableBuilder)var1_1).endBatchEdit();
            }
        }
    }

    private static final class CodepointIndexFinder {
        private static final int INVALID_INDEX = -1;

        private CodepointIndexFinder() {
        }

        static int findIndexBackward(CharSequence charSequence, int n, int n2) {
            int n3 = n;
            int n4 = 0;
            n = charSequence.length();
            if (n3 >= 0 && n >= n3) {
                if (n2 < 0) {
                    return -1;
                }
                n = n2;
                n2 = n4;
                while (true) {
                    if (n == 0) {
                        return n3;
                    }
                    if (--n3 < 0) {
                        if (n2 != 0) {
                            return -1;
                        }
                        return 0;
                    }
                    char c = charSequence.charAt(n3);
                    if (n2 != 0) {
                        if (!Character.isHighSurrogate(c)) {
                            return -1;
                        }
                        n2 = 0;
                        --n;
                        continue;
                    }
                    if (!Character.isSurrogate(c)) {
                        --n;
                        continue;
                    }
                    if (Character.isHighSurrogate(c)) {
                        return -1;
                    }
                    n2 = 1;
                }
            }
            return -1;
        }

        static int findIndexForward(CharSequence charSequence, int n, int n2) {
            int n3 = 0;
            int n4 = charSequence.length();
            if (n >= 0 && n4 >= n) {
                if (n2 < 0) {
                    return -1;
                }
                int n5 = n2;
                n2 = n3;
                while (true) {
                    if (n5 == 0) {
                        return n;
                    }
                    if (n >= n4) {
                        if (n2 != 0) {
                            return -1;
                        }
                        return n4;
                    }
                    char c = charSequence.charAt(n);
                    if (n2 != 0) {
                        if (!Character.isLowSurrogate(c)) {
                            return -1;
                        }
                        --n5;
                        n2 = 0;
                        ++n;
                        continue;
                    }
                    if (!Character.isSurrogate(c)) {
                        --n5;
                        ++n;
                        continue;
                    }
                    if (Character.isLowSurrogate(c)) {
                        return -1;
                    }
                    n2 = 1;
                    ++n;
                }
            }
            return -1;
        }
    }

    static final class ProcessorSm {
        private static final int STATE_DEFAULT = 1;
        private static final int STATE_WALKING = 2;
        private int mCurrentDepth;
        private MetadataRepo.Node mCurrentNode;
        private final int[] mEmojiAsDefaultStyleExceptions;
        private MetadataRepo.Node mFlushNode;
        private int mLastCodepoint;
        private final MetadataRepo.Node mRootNode;
        private int mState = 1;
        private final boolean mUseEmojiAsDefaultStyle;

        ProcessorSm(MetadataRepo.Node node, boolean bl, int[] nArray) {
            this.mRootNode = node;
            this.mCurrentNode = node;
            this.mUseEmojiAsDefaultStyle = bl;
            this.mEmojiAsDefaultStyleExceptions = nArray;
        }

        private static boolean isEmojiStyle(int n) {
            boolean bl = n == 65039;
            return bl;
        }

        private static boolean isTextStyle(int n) {
            boolean bl = n == 65038;
            return bl;
        }

        private int reset() {
            this.mState = 1;
            this.mCurrentNode = this.mRootNode;
            this.mCurrentDepth = 0;
            return 1;
        }

        private boolean shouldUseEmojiPresentationStyleForSingleCodepoint() {
            if (this.mCurrentNode.getData().isDefaultEmoji()) {
                return true;
            }
            if (ProcessorSm.isEmojiStyle(this.mLastCodepoint)) {
                return true;
            }
            if (this.mUseEmojiAsDefaultStyle) {
                if (this.mEmojiAsDefaultStyleExceptions == null) {
                    return true;
                }
                int n = this.mCurrentNode.getData().getCodepointAt(0);
                if (Arrays.binarySearch(this.mEmojiAsDefaultStyleExceptions, n) < 0) {
                    return true;
                }
            }
            return false;
        }

        int check(int n) {
            int n2;
            block15: {
                MetadataRepo.Node node = this.mCurrentNode.get(n);
                switch (this.mState) {
                    default: {
                        if (node != null) break;
                        n2 = this.reset();
                        break block15;
                    }
                    case 2: {
                        if (node != null) {
                            this.mCurrentNode = node;
                            ++this.mCurrentDepth;
                            n2 = 2;
                        } else if (ProcessorSm.isTextStyle(n)) {
                            n2 = this.reset();
                        } else if (ProcessorSm.isEmojiStyle(n)) {
                            n2 = 2;
                        } else if (this.mCurrentNode.getData() != null) {
                            if (this.mCurrentDepth == 1) {
                                if (this.shouldUseEmojiPresentationStyleForSingleCodepoint()) {
                                    this.mFlushNode = this.mCurrentNode;
                                    n2 = 3;
                                    this.reset();
                                } else {
                                    n2 = this.reset();
                                }
                            } else {
                                this.mFlushNode = this.mCurrentNode;
                                n2 = 3;
                                this.reset();
                            }
                        } else {
                            n2 = this.reset();
                        }
                        break block15;
                    }
                }
                this.mState = 2;
                this.mCurrentNode = node;
                this.mCurrentDepth = 1;
                n2 = 2;
            }
            this.mLastCodepoint = n;
            return n2;
        }

        EmojiMetadata getCurrentMetadata() {
            return this.mCurrentNode.getData();
        }

        EmojiMetadata getFlushMetadata() {
            return this.mFlushNode.getData();
        }

        boolean isInFlushableState() {
            boolean bl;
            block3: {
                block2: {
                    if (this.mState != 2 || this.mCurrentNode.getData() == null) break block2;
                    int n = this.mCurrentDepth;
                    bl = true;
                    if (n > 1 || this.shouldUseEmojiPresentationStyleForSingleCodepoint()) break block3;
                }
                bl = false;
            }
            return bl;
        }
    }
}

