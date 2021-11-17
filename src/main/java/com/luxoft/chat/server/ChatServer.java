package com.luxoft.chat.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.function.Consumer;

public class ChatServer {
    private static final int PORT = 3005;
    ArrayList<Socket> listOfClients;

    void start() throws IOException {
        listOfClients = new ArrayList<>();
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Accept clients...");
            while (true) {
                try {
                    Socket client = serverSocket.accept();
                    listOfClients.add(client);
                    System.out.println("New client accepted: " + client.getRemoteSocketAddress());
                    System.out.println("Total clients: " + listOfClients.size());
                    Consumer<ClientMessage> sendToClientsCallback = this::sendChatMessageToAll;

                    ChatMessagesHandler handler = new ChatMessagesHandler(client, sendToClientsCallback);
                    Thread t = new Thread(handler);
                    t.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void sendChatMessageToAll(ClientMessage clientMessage){
        if (clientMessage.isToClose) {
            listOfClients.remove(clientMessage.socket);
            System.out.println("Total clients: " + listOfClients.size());
        }
        for (Socket client : listOfClients) {

            if (client != clientMessage.socket) {
                PrintWriter printWriter = null;
                try {
                    printWriter = new PrintWriter(client.getOutputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                printWriter.println(clientMessage.msg);
                printWriter.flush();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new ChatServer().start();
    }

}
