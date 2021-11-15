package com.luxoft.chat.client;

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
    private int port = 3005;
    private String userLogin;
    private boolean stopWork;


    public ChatClient2() throws IOException {
        initialize();
    }

    private void initialize() throws IOException {

        Scanner readerFromUser = new Scanner(System.in);
        System.out.println("What is the chat server's ip address?");
        String str = readerFromUser.next();

        System.out.println("What is your nick?");
        userLogin = readerFromUser.next();

        InetAddress host = null;
        try {
            host = InetAddress.getByName(str);
            System.out.println("You are now connected to: " + host.getHostAddress());

            socket = null;
            try {
                socket = new Socket(host, port);
                socket.setReuseAddress(true);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("not found");
            }

            scannerInputStream = new Scanner(socket.getInputStream());
            outputStream = new PrintWriter(socket.getOutputStream());

            Thread t = new Thread(this::run);
            t.start();

            while (readerFromUser.hasNextLine()) {
                String msg = readerFromUser.nextLine();
                if (!msg.equals("")) {
                    outputStream.println("<" + userLogin + "> " + " says: " + msg);
                    outputStream.flush();
                    if ("exit".equalsIgnoreCase(msg)) {
                        stopWork = true;
                        break;
                    }
                }
            }
            System.out.println("Global test exit");
        } catch (UnknownHostException e1) {
            System.out.println("Host not found");
        }

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
