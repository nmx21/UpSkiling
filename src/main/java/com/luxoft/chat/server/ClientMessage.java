package com.luxoft.chat.server;

import java.net.Socket;

public class ClientMessage {
    Object msg;
    Socket socket;
    boolean isToClose;

    public ClientMessage(Object msg, Socket socket, boolean isToClose) {
        this.msg = msg;
        this.socket = socket;
        this.isToClose = isToClose;
    }

    public Object getMsg() {
        return msg;
    }

    public Socket getSocket() {
        return socket;
    }

    public boolean isToClose() {
        return isToClose;
    }
}
