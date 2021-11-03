package com.luxoft.webserver;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;

public class Server {
    private static int port;
    private static String webAppPath;
    private static int httpStatus;
    public static void main(String[] args) {

    }

    public void setPort(int i) {
        port = i;
    }

    public void setWebappPath(String s) {
        webAppPath = s;
    }

    public void start() throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                System.out.println(" === Server wait query === ");
                try (Socket socket = serverSocket.accept();
                     BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

                    String line;
                    String needFile = null;
                    Boolean isFirstLineWithUrl = false;
                    while (!(line = reader.readLine()).isEmpty()) {
                        if (!isFirstLineWithUrl) {
                            needFile = getUrlFromInputQuery(line);
                            isFirstLineWithUrl = true;
                        }
                    }
                    System.out.println(" === Ready to write response === ");
                    String answerOnQuery = readTextResource(webAppPath, needFile);
                    writer.write("HTTP/1.1 "+getHttpStatus()+" OK");
                    writer.newLine();
                    writer.newLine();
                    writer.write(answerOnQuery);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readTextResource(String webAppPath, String fileName) throws Exception {
        File file;
        try {
            file = new File(
                    getClass().getClassLoader().getResource(webAppPath + fileName).getFile()
            );
            setHttpStatus(200);
        } catch (Exception e) {
            file = new File(
                    getClass().getClassLoader().getResource(webAppPath + "/404.html").getFile()
            );
            setHttpStatus(404);
        }
        return new String(Files.readAllBytes(file.toPath()));
    }

    public String getUrlFromInputQuery(String line) {
        String[] tokens = line.split(" ");
        return tokens[1];
    }
    public static int getHttpStatus() {
        return httpStatus;
    }

    public static void setHttpStatus(int httpStatus) {
        Server.httpStatus = httpStatus;
    }


}
