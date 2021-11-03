package com.luxoft.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    private static final int PORT = 3000;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        try {
            Socket socket = serverSocket.accept();

            byte[] array = new byte[50];
            BufferedInputStream inputStream = new BufferedInputStream(socket.getInputStream());
            BufferedOutputStream outputStream = new BufferedOutputStream(socket.getOutputStream());

            int count;
            while ((count = inputStream.read(array))!=-1){
                String reciveMessage = new String(array,0,count);
                outputStream.write(("Echo : "+reciveMessage).getBytes());
                outputStream.flush();
            }

            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
