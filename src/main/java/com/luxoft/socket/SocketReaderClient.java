package com.luxoft.socket;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SocketReaderClient {
    private static final int PORT = 3000;
    private static final String HOST = "localhost";

    public static void main(String[] args) throws IOException {
        PrintWriter out;
        Scanner in;
        try (Socket socket = new Socket(HOST, PORT)) {
            byte[] buffer = new byte[50];
            System.out.print("Enter text to Server: ");
            System.in.read(buffer);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new Scanner(socket.getInputStream());
            out.println(new String(buffer, StandardCharsets.UTF_8));
            System.out.print("From server: ");
            String input = in.nextLine();

            System.out.println(input);
        }
    }
}
