package com.luxoft.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    private static final int PORT = 3000;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        byte[] array = new byte[50];
        int count = inputStream.read(array);
        String inputStr = new String(array, 0, count);


        OutputStream outputStream = socket.getOutputStream();
        String testString = "Echo : " + inputStr;
        outputStream.write(testString.getBytes());
        inputStream.close();
        outputStream.close();
        socket.close();

    }
}
