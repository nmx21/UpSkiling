package com.luxoft.chat.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread {
    private final Socket socket;
    private final ArrayList<ServerThread> threadList;
    private PrintWriter output;

    public ServerThread(Socket socket, ArrayList<ServerThread> threads) {
        this.socket = socket;
        this.threadList = threads;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
            while (true) {
                String outputString = reader.readLine();
                if (outputString.equalsIgnoreCase("exit")) {
                    break;
                }
                printToClients(outputString);
                System.out.println("Server Received " + outputString);
            }
        } catch (Exception e) {
            System.out.println("Минус один в чате :)");
        }
    }

    private void printToClients(String outputString) {
        for (ServerThread serThread : threadList) {
            serThread.output.println(outputString);
        }
    }
}
