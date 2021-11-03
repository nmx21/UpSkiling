package com.luxoft.webserver;

public class Starter {
    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.setPort(3000);
        server.setWebappPath("webapp");
        server.start();

        // GET /index.html HTTP/1.1
        // path to resource = webappPath + URI =>
        // src/main/resources/webapp/index.html

        // // GET /css/styles.css HTTP/1.1
        // path to resource = webappPath + URI =>
        // src/main/resources/webapp/css/styles.css
    }

}
