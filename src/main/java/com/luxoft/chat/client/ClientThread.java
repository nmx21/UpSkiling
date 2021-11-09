package com.luxoft.chat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket;
    private BufferedReader input;

    public ClientThread(Socket s) throws IOException {
        this.socket = s;
        this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        try {
            while (true) {
                String textFromServer = input.readLine();
                System.out.println(textFromServer);
            }
        } catch (IOException e) {
            System.out.println("You are exiting from chat.");
        } finally {
            try {
                input.close();
            } catch (Exception e) {
                System.out.println("Error..." + e.getMessage());
            }
        }
    }
}
