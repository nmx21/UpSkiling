package com.luxoft.chat.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

public class ChatServer {
    private static final int PORT = 3005;
    private ServerSocket serverSocket;
    private final ArrayList<Socket> ListOfClient;


    private ChatServer() {
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.getStackTrace();
        }
        ListOfClient = new ArrayList<>();
    }

    private void StartServer() {
        System.out.println("Accept clients...");
        while (true) {
            try {
                Socket client = serverSocket.accept();
                ListOfClient.add(client);
                System.out.println("New client accepted: " + client.getRemoteSocketAddress());
                System.out.println("Total clients: " + ListOfClient.size());
                ChatMessagesDispatch handler = new ChatMessagesDispatch(client, this);
                Thread t = new Thread(handler);
                t.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void sendChatMessageToAll(Object msg, Socket socket, boolean isToClose) throws IOException {
        if (isToClose) {
            ListOfClient.remove(socket);
            System.out.println("Total clients: " + ListOfClient.size());
        }
        for (Socket client : ListOfClient) {

            if (client != socket) {
                PrintWriter printWriter = new PrintWriter(client.getOutputStream());
                printWriter.println(msg);
                printWriter.flush();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new ChatServer().StartServer();
    }

}
