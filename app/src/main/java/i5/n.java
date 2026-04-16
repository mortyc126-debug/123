package i5;

import a4.b1;
import amuvvoafs.os.Bundle;
import amuvvoafs.os.Handler;
import amuvvoafs.view.KeyEvent;
import amuvvoafs.view.inputmethod.CompletionInfo;
import amuvvoafs.view.inputmethod.CorrectionInfo;
import amuvvoafs.view.inputmethod.ExtractedText;
import amuvvoafs.view.inputmethod.ExtractedTextRequest;
import amuvvoafs.view.inputmethod.InputConnection;
import amuvvoafs.view.inputmethod.InputContentInfo;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class n implements InputConnection {
    public final b1 a;
    public InputConnection b;

    public n(InputConnection inputConnection, b1 b1Var) {
        this.a = b1Var;
        this.b = inputConnection;
    }

    public final void a(InputConnection inputConnection) {
        inputConnection.closeConnection();
    }

    public final boolean beginBatchEdit() {
        InputConnection inputConnection = this.b;
        if (inputConnection != null) {
            return inputConnection.beginBatchEdit();
        }
        return false;
    }

    public final boolean clearMetaKeyStates(int i) {
        InputConnection inputConnection = this.b;
        if (inputConnection != null) {
            return inputConnection.clearMetaKeyStates(i);
        }
        return false;
    }

    public final void closeConnection() {
        InputConnection inputConnection = this.b;
        if (inputConnection != null) {
            if (inputConnection != null) {
                a(inputConnection);
                this.b = null;
            }
            this.a.invoke(this);
        }
    }

    public final boolean commitCompletion(CompletionInfo completionInfo) {
        InputConnection inputConnection = this.b;
        if (inputConnection != null) {
            return inputConnection.commitCompletion(completionInfo);
        }
        return false;
    }

    public final boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
        InputConnection inputConnection = this.b;
        if (inputConnection != null) {
            return inputConnection.commitContent(inputContentInfo, i, bundle);
        }
        return false;
    }

    public final boolean commitCorrection(CorrectionInfo correctionInfo) {
        InputConnection inputConnection = this.b;
        if (inputConnection != null) {
            return inputConnection.commitCorrection(correctionInfo);
        }
        return false;
    }

    public final boolean commitText(CharSequence charSequence, int i) {
        InputConnection inputConnection = this.b;
        if (inputConnection != null) {
            return inputConnection.commitText(charSequence, i);
        }
        return false;
    }

    public final boolean deleteSurroundingText(int i, int i2) {
        InputConnection inputConnection = this.b;
        if (inputConnection != null) {
            return inputConnection.deleteSurroundingText(i, i2);
        }
        return false;
    }

    public final boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        InputConnection inputConnection = this.b;
        if (inputConnection != null) {
            return inputConnection.deleteSurroundingTextInCodePoints(i, i2);
        }
        return false;
    }

    public final boolean endBatchEdit() {
        InputConnection inputConnection = this.b;
        if (inputConnection != null) {
            return inputConnection.endBatchEdit();
        }
        return false;
    }

    public final boolean finishComposingText() {
        InputConnection inputConnection = this.b;
        if (inputConnection != null) {
            return inputConnection.finishComposingText();
        }
        return false;
    }

    public final int getCursorCapsMode(int i) {
        InputConnection inputConnection = this.b;
        if (inputConnection != null) {
            return inputConnection.getCursorCapsMode(i);
        }
        return 0;
    }

    public final ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i) {
        InputConnection inputConnection = this.b;
        if (inputConnection != null) {
            return inputConnection.getExtractedText(extractedTextRequest, i);
        }
        return null;
    }

    public final Handler getHandler() {
        InputConnection inputConnection = this.b;
        if (inputConnection != null) {
            return inputConnection.getHandler();
        }
        return null;
    }

    public final CharSequence getSelectedText(int i) {
        InputConnection inputConnection = this.b;
        if (inputConnection != null) {
            return inputConnection.getSelectedText(i);
        }
        return null;
    }

    public final CharSequence getTextAfterCursor(int i, int i2) {
        InputConnection inputConnection = this.b;
        if (inputConnection != null) {
            return inputConnection.getTextAfterCursor(i, i2);
        }
        return null;
    }

    public final CharSequence getTextBeforeCursor(int i, int i2) {
        InputConnection inputConnection = this.b;
        if (inputConnection != null) {
            return inputConnection.getTextBeforeCursor(i, i2);
        }
        return null;
    }

    public final boolean performContextMenuAction(int i) {
        InputConnection inputConnection = this.b;
        if (inputConnection != null) {
            return inputConnection.performContextMenuAction(i);
        }
        return false;
    }

    public final boolean performEditorAction(int i) {
        InputConnection inputConnection = this.b;
        if (inputConnection != null) {
            return inputConnection.performEditorAction(i);
        }
        return false;
    }

    public final boolean performPrivateCommand(String str, Bundle bundle) {
        InputConnection inputConnection = this.b;
        if (inputConnection != null) {
            return inputConnection.performPrivateCommand(str, bundle);
        }
        return false;
    }

    public final boolean reportFullscreenMode(boolean z) {
        InputConnection inputConnection = this.b;
        if (inputConnection != null) {
            return inputConnection.reportFullscreenMode(z);
        }
        return false;
    }

    public final boolean requestCursorUpdates(int i) {
        InputConnection inputConnection = this.b;
        if (inputConnection != null) {
            return inputConnection.requestCursorUpdates(i);
        }
        return false;
    }

    public final boolean sendKeyEvent(KeyEvent keyEvent) {
        InputConnection inputConnection = this.b;
        if (inputConnection != null) {
            return inputConnection.sendKeyEvent(keyEvent);
        }
        return false;
    }

    public final boolean setComposingRegion(int i, int i2) {
        InputConnection inputConnection = this.b;
        if (inputConnection != null) {
            return inputConnection.setComposingRegion(i, i2);
        }
        return false;
    }

    public final boolean setComposingText(CharSequence charSequence, int i) {
        InputConnection inputConnection = this.b;
        if (inputConnection != null) {
            return inputConnection.setComposingText(charSequence, i);
        }
        return false;
    }

    public final boolean setSelection(int i, int i2) {
        InputConnection inputConnection = this.b;
        if (inputConnection != null) {
            return inputConnection.setSelection(i, i2);
        }
        return false;
    }
}
