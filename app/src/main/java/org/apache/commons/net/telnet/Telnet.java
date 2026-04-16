package org.apache.commons.net.telnet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.net.SocketClient;

/* JADX INFO: loaded from: classes2.dex */
class Telnet extends SocketClient {
    static final int DEFAULT_PORT = 23;
    static final int DO_MASK = 2;
    static final int REQUESTED_DO_MASK = 8;
    static final int REQUESTED_WILL_MASK = 4;
    protected static final int TERMINAL_TYPE = 24;
    protected static final int TERMINAL_TYPE_IS = 0;
    protected static final int TERMINAL_TYPE_SEND = 1;
    static final int WILL_MASK = 1;
    static final boolean debug = false;
    static final boolean debugoptions = false;
    private final int[] doResponse;
    private TelnetNotificationHandler notifhand;
    private final TelnetOptionHandler[] optionHandlers;
    private final int[] options;
    private volatile OutputStream spyStream;
    private String terminalType;
    private final int[] willResponse;
    static final byte[] COMMAND_DO = {-1, -3};
    static final byte[] COMMAND_DONT = {-1, -2};
    static final byte[] COMMAND_WILL = {-1, -5};
    static final byte[] COMMAND_WONT = {-1, -4};
    static final byte[] COMMAND_SB = {-1, -6};
    static final byte[] COMMAND_SE = {-1, -16};
    static final byte[] COMMAND_IS = {24, 0};
    static final byte[] COMMAND_AYT = {-1, -10};
    private final Object aytMonitor = new Object();
    private volatile boolean aytFlag = true;

    Telnet() {
        setDefaultPort(23);
        this.doResponse = new int[256];
        this.willResponse = new int[256];
        this.options = new int[256];
        this.optionHandlers = new TelnetOptionHandler[256];
    }

    Telnet(String termtype) {
        setDefaultPort(23);
        this.doResponse = new int[256];
        this.willResponse = new int[256];
        this.options = new int[256];
        this.terminalType = termtype;
        this.optionHandlers = new TelnetOptionHandler[256];
    }

    @Override // org.apache.commons.net.SocketClient
    protected void _connectAction_() throws IOException {
        for (int ii = 0; ii < 256; ii++) {
            this.doResponse[ii] = 0;
            this.willResponse[ii] = 0;
            this.options[ii] = 0;
            if (this.optionHandlers[ii] != null) {
                this.optionHandlers[ii].setDo(false);
                this.optionHandlers[ii].setWill(false);
            }
        }
        super._connectAction_();
        this._input_ = new BufferedInputStream(this._input_);
        this._output_ = new BufferedOutputStream(this._output_);
        for (int ii2 = 0; ii2 < 256; ii2++) {
            if (this.optionHandlers[ii2] != null) {
                if (this.optionHandlers[ii2].getInitLocal()) {
                    requestWill(this.optionHandlers[ii2].getOptionCode());
                }
                if (this.optionHandlers[ii2].getInitRemote()) {
                    requestDo(this.optionHandlers[ii2].getOptionCode());
                }
            }
        }
    }

    void _registerSpyStream(OutputStream spystream) {
        this.spyStream = spystream;
    }

    final boolean _sendAYT(long timeout) throws InterruptedException, IOException, IllegalArgumentException {
        boolean retValue = false;
        synchronized (this.aytMonitor) {
            synchronized (this) {
                this.aytFlag = false;
                this._output_.write(COMMAND_AYT);
                this._output_.flush();
            }
            this.aytMonitor.wait(timeout);
            if (!this.aytFlag) {
                this.aytFlag = true;
            } else {
                retValue = true;
            }
        }
        return retValue;
    }

    final synchronized void _sendCommand(byte cmd) throws IOException {
        this._output_.write(255);
        this._output_.write(cmd);
        this._output_.flush();
    }

    final synchronized void _sendSubnegotiation(int[] subn) throws IOException {
        if (subn != null) {
            this._output_.write(COMMAND_SB);
            for (int element : subn) {
                byte b = (byte) element;
                if (b == -1) {
                    this._output_.write(b);
                }
                this._output_.write(b);
            }
            this._output_.write(COMMAND_SE);
            this._output_.flush();
        }
    }

    void _stopSpyStream() {
        this.spyStream = null;
    }

    void addOptionHandler(TelnetOptionHandler opthand) throws IOException, InvalidTelnetOptionException {
        int optcode = opthand.getOptionCode();
        if (!TelnetOption.isValidOption(optcode)) {
            throw new InvalidTelnetOptionException("Invalid Option Code", optcode);
        }
        if (this.optionHandlers[optcode] != null) {
            throw new InvalidTelnetOptionException("Already registered option", optcode);
        }
        this.optionHandlers[optcode] = opthand;
        if (isConnected()) {
            if (opthand.getInitLocal()) {
                requestWill(optcode);
            }
            if (opthand.getInitRemote()) {
                requestDo(optcode);
            }
        }
    }

    void deleteOptionHandler(int optcode) throws IOException, InvalidTelnetOptionException {
        if (!TelnetOption.isValidOption(optcode)) {
            throw new InvalidTelnetOptionException("Invalid Option Code", optcode);
        }
        if (this.optionHandlers[optcode] == null) {
            throw new InvalidTelnetOptionException("Unregistered option", optcode);
        }
        TelnetOptionHandler opthand = this.optionHandlers[optcode];
        this.optionHandlers[optcode] = null;
        if (opthand.getWill()) {
            requestWont(optcode);
        }
        if (opthand.getDo()) {
            requestDont(optcode);
        }
    }

    final synchronized void processAYTResponse() {
        if (!this.aytFlag) {
            synchronized (this.aytMonitor) {
                try {
                    this.aytFlag = true;
                    this.aytMonitor.notifyAll();
                } finally {
                    th = th;
                    while (true) {
                        try {
                        } catch (Throwable th) {
                            th = th;
                        }
                    }
                }
            }
        }
    }

    void processCommand(int command) {
        if (this.notifhand != null) {
            this.notifhand.receivedNegotiation(5, command);
        }
    }

    void processDo(int option) throws IOException {
        if (this.notifhand != null) {
            this.notifhand.receivedNegotiation(1, option);
        }
        boolean acceptNewState = false;
        if (this.optionHandlers[option] != null) {
            acceptNewState = this.optionHandlers[option].getAcceptLocal();
        } else if (option == 24 && this.terminalType != null && !this.terminalType.isEmpty()) {
            acceptNewState = true;
        }
        if (this.willResponse[option] > 0) {
            int[] iArr = this.willResponse;
            iArr[option] = iArr[option] - 1;
            if (this.willResponse[option] > 0 && stateIsWill(option)) {
                int[] iArr2 = this.willResponse;
                iArr2[option] = iArr2[option] - 1;
            }
        }
        if (this.willResponse[option] == 0 && requestedWont(option)) {
            if (acceptNewState) {
                setWantWill(option);
                sendWill(option);
            } else {
                int[] iArr3 = this.willResponse;
                iArr3[option] = iArr3[option] + 1;
                sendWont(option);
            }
        }
        setWill(option);
    }

    void processDont(int option) throws IOException {
        if (this.notifhand != null) {
            this.notifhand.receivedNegotiation(2, option);
        }
        if (this.willResponse[option] > 0) {
            this.willResponse[option] = r0[option] - 1;
            if (this.willResponse[option] > 0 && stateIsWont(option)) {
                this.willResponse[option] = r0[option] - 1;
            }
        }
        if (this.willResponse[option] == 0 && requestedWill(option)) {
            if (stateIsWill(option) || requestedWill(option)) {
                sendWont(option);
            }
            setWantWont(option);
        }
        setWont(option);
    }

    void processSuboption(int[] suboption, int suboptionLength) throws IOException {
        if (suboptionLength > 0) {
            if (this.optionHandlers[suboption[0]] != null) {
                int[] responseSuboption = this.optionHandlers[suboption[0]].answerSubnegotiation(suboption, suboptionLength);
                _sendSubnegotiation(responseSuboption);
            } else if (suboptionLength > 1 && suboption[0] == 24 && suboption[1] == 1) {
                sendTerminalType();
            }
        }
    }

    void processWill(int option) throws IOException {
        if (this.notifhand != null) {
            this.notifhand.receivedNegotiation(3, option);
        }
        boolean acceptNewState = false;
        if (this.optionHandlers[option] != null) {
            acceptNewState = this.optionHandlers[option].getAcceptRemote();
        }
        if (this.doResponse[option] > 0) {
            this.doResponse[option] = r1[option] - 1;
            if (this.doResponse[option] > 0 && stateIsDo(option)) {
                this.doResponse[option] = r1[option] - 1;
            }
        }
        if (this.doResponse[option] == 0 && requestedDont(option)) {
            if (acceptNewState) {
                setWantDo(option);
                sendDo(option);
            } else {
                int[] iArr = this.doResponse;
                iArr[option] = iArr[option] + 1;
                sendDont(option);
            }
        }
        setDo(option);
    }

    void processWont(int option) throws IOException {
        if (this.notifhand != null) {
            this.notifhand.receivedNegotiation(4, option);
        }
        if (this.doResponse[option] > 0) {
            this.doResponse[option] = r0[option] - 1;
            if (this.doResponse[option] > 0 && stateIsDont(option)) {
                this.doResponse[option] = r0[option] - 1;
            }
        }
        if (this.doResponse[option] == 0 && requestedDo(option)) {
            if (stateIsDo(option) || requestedDo(option)) {
                sendDont(option);
            }
            setWantDont(option);
        }
        setDont(option);
    }

    public void registerNotifHandler(TelnetNotificationHandler notifhand) {
        this.notifhand = notifhand;
    }

    final synchronized void requestDo(int option) throws IOException {
        if ((this.doResponse[option] == 0 && stateIsDo(option)) || requestedDo(option)) {
            return;
        }
        setWantDo(option);
        int[] iArr = this.doResponse;
        iArr[option] = iArr[option] + 1;
        sendDo(option);
    }

    final synchronized void requestDont(int option) throws IOException {
        if ((this.doResponse[option] == 0 && stateIsDont(option)) || requestedDont(option)) {
            return;
        }
        setWantDont(option);
        int[] iArr = this.doResponse;
        iArr[option] = iArr[option] + 1;
        sendDont(option);
    }

    boolean requestedDo(int option) {
        return (this.options[option] & 8) != 0;
    }

    boolean requestedDont(int option) {
        return !requestedDo(option);
    }

    boolean requestedWill(int option) {
        return (this.options[option] & 4) != 0;
    }

    boolean requestedWont(int option) {
        return !requestedWill(option);
    }

    final synchronized void requestWill(int option) throws IOException {
        if ((this.willResponse[option] == 0 && stateIsWill(option)) || requestedWill(option)) {
            return;
        }
        setWantWill(option);
        int[] iArr = this.doResponse;
        iArr[option] = iArr[option] + 1;
        sendWill(option);
    }

    final synchronized void requestWont(int option) throws IOException {
        if ((this.willResponse[option] == 0 && stateIsWont(option)) || requestedWont(option)) {
            return;
        }
        setWantWont(option);
        int[] iArr = this.doResponse;
        iArr[option] = iArr[option] + 1;
        sendWont(option);
    }

    final synchronized void sendByte(int b) throws IOException {
        this._output_.write(b);
        spyWrite(b);
    }

    final synchronized void sendDo(int option) throws IOException {
        this._output_.write(COMMAND_DO);
        this._output_.write(option);
        this._output_.flush();
    }

    final synchronized void sendDont(int option) throws IOException {
        this._output_.write(COMMAND_DONT);
        this._output_.write(option);
        this._output_.flush();
    }

    final synchronized void sendTerminalType() throws IOException {
        if (this.terminalType != null) {
            this._output_.write(COMMAND_SB);
            this._output_.write(COMMAND_IS);
            this._output_.write(this.terminalType.getBytes(getCharset()));
            this._output_.write(COMMAND_SE);
            this._output_.flush();
        }
    }

    final synchronized void sendWill(int option) throws IOException {
        this._output_.write(COMMAND_WILL);
        this._output_.write(option);
        this._output_.flush();
    }

    final synchronized void sendWont(int option) throws IOException {
        this._output_.write(COMMAND_WONT);
        this._output_.write(option);
        this._output_.flush();
    }

    void setDo(int option) throws IOException {
        int[] iArr = this.options;
        iArr[option] = iArr[option] | 2;
        if (requestedDo(option) && this.optionHandlers[option] != null) {
            this.optionHandlers[option].setDo(true);
            int[] subneg = this.optionHandlers[option].startSubnegotiationRemote();
            if (subneg != null) {
                _sendSubnegotiation(subneg);
            }
        }
    }

    void setDont(int option) {
        int[] iArr = this.options;
        iArr[option] = iArr[option] & (-3);
        if (this.optionHandlers[option] != null) {
            this.optionHandlers[option].setDo(false);
        }
    }

    void setWantDo(int option) {
        int[] iArr = this.options;
        iArr[option] = iArr[option] | 8;
    }

    void setWantDont(int option) {
        int[] iArr = this.options;
        iArr[option] = iArr[option] & (-9);
    }

    void setWantWill(int option) {
        int[] iArr = this.options;
        iArr[option] = iArr[option] | 4;
    }

    void setWantWont(int option) {
        int[] iArr = this.options;
        iArr[option] = iArr[option] & (-5);
    }

    void setWill(int option) throws IOException {
        int[] iArr = this.options;
        iArr[option] = iArr[option] | 1;
        if (requestedWill(option) && this.optionHandlers[option] != null) {
            this.optionHandlers[option].setWill(true);
            int[] subneg = this.optionHandlers[option].startSubnegotiationLocal();
            if (subneg != null) {
                _sendSubnegotiation(subneg);
            }
        }
    }

    void setWont(int option) {
        int[] iArr = this.options;
        iArr[option] = iArr[option] & (-2);
        if (this.optionHandlers[option] != null) {
            this.optionHandlers[option].setWill(false);
        }
    }

    void spyRead(int ch) {
        OutputStream spy = this.spyStream;
        if (spy != null && ch != 13) {
            if (ch == 10) {
                try {
                    spy.write(13);
                } catch (IOException e) {
                    this.spyStream = null;
                    return;
                }
            }
            spy.write(ch);
            spy.flush();
        }
    }

    void spyWrite(int ch) {
        OutputStream spy;
        if ((!stateIsDo(1) || !requestedDo(1)) && (spy = this.spyStream) != null) {
            try {
                spy.write(ch);
                spy.flush();
            } catch (IOException e) {
                this.spyStream = null;
            }
        }
    }

    boolean stateIsDo(int option) {
        return (this.options[option] & 2) != 0;
    }

    boolean stateIsDont(int option) {
        return !stateIsDo(option);
    }

    boolean stateIsWill(int option) {
        return (this.options[option] & 1) != 0;
    }

    boolean stateIsWont(int option) {
        return !stateIsWill(option);
    }

    public void unregisterNotifHandler() {
        this.notifhand = null;
    }
}
