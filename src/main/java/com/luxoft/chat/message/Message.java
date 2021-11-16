package com.luxoft.chat.message;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {


    private String typeMessage;
    private String clientTextOfMessage;
    private Date dateOfMessageSend;
    private String clientName;


    @Override
    public String toString() {
        return "Message{" +
                "typeMessage='" + typeMessage + '\'' +
                ", clientTextOfMessage='" + clientTextOfMessage + '\'' +
                ", dateOfMessageSend=" + dateOfMessageSend +
                ", clientName='" + clientName + '\'' +
                '}';
    }


    public void setClientTextOfMessage(String clientTextOfMessage) {
        this.clientTextOfMessage = clientTextOfMessage;
        setDateOfMessageSend();
    }

    public String getClientName() {
        return clientName;
    }


    public String getTypeMessage() {

        return typeMessage;
    }

    public void setTypeMessage(String typeMessage) {

        this.typeMessage = typeMessage;
    }

    public String getClientTextOfMessage() {

        return clientTextOfMessage;
    }


    public Date getDateOfMessageSend() {

        return dateOfMessageSend;
    }

    public void setDateOfMessageSend() {

        this.dateOfMessageSend = new Date();
    }

    public void setClientName(String nextLine) {

        clientName = nextLine;
    }


}
