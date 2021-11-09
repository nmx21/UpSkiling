package com.luxoft.socket;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SocketClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 3002);
        byte[] buffer = new byte[50];
        System.out.println("Enter text: ");
        System.in.read(buffer);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(buffer, 0, buffer.length);

        InputStream inputStream = socket.getInputStream();
        int count = inputStream.read(buffer);
        System.out.println(new String(buffer, 0, count));
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
