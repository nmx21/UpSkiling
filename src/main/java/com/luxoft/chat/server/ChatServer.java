package com.luxoft.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
    private static final int PORT = 3005;
    public static void main(String[] args) throws IOException {
        try {
        System.out.println("Server started...");
        System.out.println("Wating for clients...");
        ArrayList<ServerThread> threadList = new ArrayList<ServerThread>();
        ServerSocket serverSocket = new ServerSocket(PORT);
        while(true){
                Socket socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket, threadList);
                threadList.add(serverThread);
                serverThread.start();
        }
    }catch (Exception e){
            System.out.println("Chat server can`t start ..." + e.getMessage());
    }
}}
