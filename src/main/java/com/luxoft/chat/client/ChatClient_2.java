package com.luxoft.chat.client;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient_2 {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 3005)) {
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanTextFromUser = new Scanner(System.in);
            String textFromClient;
            String clientName = "noname";
            ClientThread clientThread = new ClientThread(socket);
            clientThread.start();
            do {
                if (clientName.equals("noname")) {
                    System.out.print("Enter your name: ");
                    textFromClient = scanTextFromUser.nextLine();
                    clientName = textFromClient;
                    output.println("<User " + textFromClient + " entered in chat>");
                    if (textFromClient.equals("exit")) {
                        break;
                    }
                } else {
                    String message = (" Message from (" + clientName + ")" + " : ");

                    textFromClient = scanTextFromUser.nextLine();
                    output.println(message + " " + textFromClient);
                    if (textFromClient.equals("exit")) {
                        break;
                    }
                }
            } while (!textFromClient.equals("exit"));


        } catch (Exception e) {
            System.out.println("Chat client can`t start ..." + e.getMessage());
        }

    }
}
