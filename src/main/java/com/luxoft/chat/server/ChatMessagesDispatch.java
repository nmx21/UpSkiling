package com.luxoft.chat.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.luxoft.chat.message.Message;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class ChatMessagesDispatch implements Runnable {

    private Socket clientSocket;
    private ChatServer server;
    private Scanner inputStream;
    private String messageToClient;

    public ChatMessagesDispatch(Socket clientSocket, ChatServer server) {
        this.clientSocket = clientSocket;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            inputStream = new Scanner(clientSocket.getInputStream());
            while (true) {
                if (!inputStream.hasNext()) {
                    return;
                }
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                Message msg = gson.fromJson(inputStream.nextLine(), Message.class);

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
                server.sendChatMessageToAll(messageToClient, clientSocket, msg.getTypeMessage().equals("exit"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}