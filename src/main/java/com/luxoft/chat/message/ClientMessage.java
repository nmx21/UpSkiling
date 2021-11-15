package com.luxoft.chat.message;

import java.io.Serializable;
import java.util.Date;

public class ClientMessage implements Serializable {


    private String typeMessage;
    private String clientTextOfMessage;
    private Date dateOfMessageSend;
    private String clientName;


    public String getTypeMessage() {
        return typeMessage;
    }

    public void setTypeMessage(String typeMessage) {
        this.typeMessage = typeMessage;
    }
    public String getClientTextOfMessage() {
        return clientTextOfMessage;
    }

    public void setClientTextOfMessage(String clientTextOfMessage) {
        this.clientTextOfMessage = clientTextOfMessage;
        setDateOfMessageSend();
    }

    public Date getDateOfMessageSend() {
        return dateOfMessageSend;
    }

    public void setDateOfMessageSend() {
        this.dateOfMessageSend = new Date();
    }

    @Override
    public String toString() {
        return "ClientMessage{" +
                " clientTextOfMessage='" + clientTextOfMessage + '\'' +
                ", dateOfMessageSend=" + dateOfMessageSend +
                '}';
    }

    public void setClientName(String nextLine) {
        clientName = nextLine;
    }
}
