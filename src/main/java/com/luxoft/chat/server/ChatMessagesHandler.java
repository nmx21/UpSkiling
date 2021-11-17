package com.luxoft.chat.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.luxoft.chat.message.Message;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.function.Consumer;


public class ChatMessagesHandler implements Runnable {
    private static final Gson GSON = new Gson();
    private Socket clientSocket;
    private Consumer<ClientMessage> sendToClientCallback;
    private Scanner inputStream;
    private String messageToClient;

    public ChatMessagesHandler(Socket clientSocket, Consumer<ClientMessage> sendToClientCallback) {
        this.clientSocket = clientSocket;
        this.sendToClientCallback = sendToClientCallback;
    }

    @Override
    public void run() {
        try {
            inputStream = new Scanner(clientSocket.getInputStream());
            while (true) {
                if (!inputStream.hasNext()) {
                    return;
                }
                Message msg = GSON.fromJson(inputStream.nextLine(), Message.class);

                switch (msg.getTypeMessage()) {
                    case "send":
                        messageToClient = "[ " + msg.getDateOfMessageSend() + " ] <" + msg.getClientName() + ">: " + msg.getClientTextOfMessage();
                        break;
                    case "exit":
                        messageToClient = "[ " + msg.getDateOfMessageSend() + " ] <" + msg.getClientName() + ">: Disconected";
                        break;
                    case "enter":
                        messageToClient = "[ " + msg.getDateOfMessageSend() + " ] <" + msg.getClientName() + ">: In chat";
                        break;
                }
                boolean isExit = msg.getTypeMessage().equals("exit");
                ClientMessage clientMessage = new ClientMessage(messageToClient,clientSocket,isExit);
                sendToClientCallback.accept(clientMessage);
             }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}