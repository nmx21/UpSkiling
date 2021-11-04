package com.luxoft.webserver2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private Integer port;
    private String staticResourcesPath;

    private void start() {
        try (ServerSocket serverSocket = new ServerSocket(getPort())) {
            while (true) {
                System.out.println(" === Server Second Edition (SSE) wait query === ");
                try (Socket socket = serverSocket.accept();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
                    RequestHandler requestHandler = new RequestHandler(writer, reader, getStaticResourcesPath());
                    requestHandler.handle();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.setPort(3000);
        server.setStaticResourcesPath("webapp");
        server.start();
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getStaticResourcesPath() {
        return staticResourcesPath;
    }

    public void setStaticResourcesPath(String staticResourcesPath) {
        this.staticResourcesPath = staticResourcesPath;
    }

}
