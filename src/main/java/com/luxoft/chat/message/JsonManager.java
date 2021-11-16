package com.luxoft.chat.message;

import com.google.gson.JsonObject;

import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonManager {
    public static JsonObject Encode(String typeMessage, String incomingText, String userLogin, String userSocket) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("typeMessage", typeMessage);
        jsonObject.addProperty("clientTextOfMessage", incomingText);
        jsonObject.addProperty("dateOfMessageSend", formatter.format(currentTime));
        jsonObject.addProperty("clientName", userLogin);


        return jsonObject;
    }

}
