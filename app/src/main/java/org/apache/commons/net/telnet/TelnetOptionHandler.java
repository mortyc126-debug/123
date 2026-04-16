package org.apache.commons.net.telnet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TelnetOptionHandler {
    private boolean acceptLocal;
    private boolean acceptRemote;
    private boolean doFlag;
    private boolean initialLocal;
    private boolean initialRemote;
    private int optionCode;
    private boolean willFlag;

    public TelnetOptionHandler(int optcode, boolean initlocal, boolean initremote, boolean acceptlocal, boolean acceptremote) {
        this.optionCode = -1;
        this.optionCode = optcode;
        this.initialLocal = initlocal;
        this.initialRemote = initremote;
        this.acceptLocal = acceptlocal;
        this.acceptRemote = acceptremote;
    }

    public int[] answerSubnegotiation(int[] suboptionData, int suboptionLength) {
        return null;
    }

    public boolean getAcceptLocal() {
        return this.acceptLocal;
    }

    public boolean getAcceptRemote() {
        return this.acceptRemote;
    }

    boolean getDo() {
        return this.doFlag;
    }

    public boolean getInitLocal() {
        return this.initialLocal;
    }

    public boolean getInitRemote() {
        return this.initialRemote;
    }

    public int getOptionCode() {
        return this.optionCode;
    }

    boolean getWill() {
        return this.willFlag;
    }

    public void setAcceptLocal(boolean accept) {
        this.acceptLocal = accept;
    }

    public void setAcceptRemote(boolean accept) {
        this.acceptRemote = accept;
    }

    void setDo(boolean state) {
        this.doFlag = state;
    }

    public void setInitLocal(boolean init) {
        this.initialLocal = init;
    }

    public void setInitRemote(boolean init) {
        this.initialRemote = init;
    }

    void setWill(boolean state) {
        this.willFlag = state;
    }

    public int[] startSubnegotiationLocal() {
        return null;
    }

    public int[] startSubnegotiationRemote() {
        return null;
    }
}
