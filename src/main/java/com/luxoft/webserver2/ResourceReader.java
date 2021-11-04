package com.luxoft.webserver2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ResourceReader {
    public ResourceReader(String staticResourcePath) {
        this.staticResourcePath = staticResourcePath;
    }

    String staticResourcePath;

    public Response readContent(String uri) {
        Response response = null;
        File file;
        try {
            file = new File(
                    getClass().getClassLoader().getResource(staticResourcePath + uri).getFile()
            );
            response = new Response("HTTP/1.1 200 OK", new String(Files.readAllBytes(file.toPath())));
        } catch (Exception e) {
            file = new File(
                    getClass().getClassLoader().getResource(staticResourcePath + "/404.html").getFile()
            );
            try {
                response = new Response("HTTP/1.1 404 Not Found", new String(Files.readAllBytes(file.toPath())));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return response;
    }
}
