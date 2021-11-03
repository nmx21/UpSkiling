package com.luxoft.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketReaderServer {
    private static final int PORT = 3000;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started...");
        System.out.println("Wating for clients...");


        Socket clientSocket = serverSocket.accept();

        try (
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                Scanner in = new Scanner(clientSocket.getInputStream());
        ) {
            while (in.hasNextLine()) {
                String input = in.nextLine();
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.println("Received from client: " + input);

                input = "echo:" + input;
                out.println(input);
            }
        } catch (IOException e) {
        }


    }
}
