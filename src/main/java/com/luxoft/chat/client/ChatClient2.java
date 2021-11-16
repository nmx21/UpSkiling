package com.luxoft.chat.client;

import com.google.gson.JsonObject;
import com.luxoft.chat.message.JsonManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


class ChatClient2 implements Runnable {
    private Socket socket;
    private PrintWriter outputStream;
    private Scanner scannerInputStream;
    private final int port = 3005;
    private String userLogin;
    private boolean stopWork;
    private Scanner readerFromUser;


    public ChatClient2() throws IOException {
        initialize();
    }

    private void initialize() throws IOException {

        readerFromUser = new Scanner(System.in);
        System.out.println("What is the chat server's ip address?");
        String ip_server = readerFromUser.next();


        System.out.println("What is your nick?");
        userLogin = readerFromUser.next();

        InetAddress host;
        try {
            host = InetAddress.getByName(ip_server);
            System.out.println("You are now connected to: " + host.getHostAddress());

            socket = null;
            try {
                socket = new Socket(host, port);
                socket.setReuseAddress(true);


                scannerInputStream = new Scanner(socket.getInputStream());
                outputStream = new PrintWriter(socket.getOutputStream());
                sendMessageToServer(JsonManager.Encode("enter", "", userLogin, ""));

                Thread t = new Thread(this::run);
                t.start();
                startScanUserInput();


            } catch (UnknownHostException e1) {
                System.out.println("Host not found");
            }

        } catch (UnknownHostException e1) {
            System.out.println("error");
        }
    }

    private void startScanUserInput() {
        while (readerFromUser.hasNextLine()) {
            String msg = readerFromUser.nextLine();
            if ("exit".equalsIgnoreCase(msg)) {
                sendMessageToServer(JsonManager.Encode("exit", msg, userLogin, ""));
                stopWork = true;
                break;
            } else if (!msg.equals("")) {
                sendMessageToServer(JsonManager.Encode("send", msg, userLogin, ""));
            }
        }
    }

    private void sendMessageToServer(JsonObject msgToServer) {
        outputStream.println(msgToServer);
        outputStream.flush();
    }

    public static void main(String[] args) throws Exception {
        new ChatClient2();
    }

    public void run() {
        while (!stopWork) {
            if (scannerInputStream.hasNextLine())
                System.out.println(scannerInputStream.nextLine());
        }

    }

}
