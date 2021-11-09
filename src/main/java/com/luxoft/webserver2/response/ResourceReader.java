package com.luxoft.webserver2.response;

import com.luxoft.webserver2.enums.HttpCode;

import java.io.File;
import java.nio.file.Files;

public class ResourceReader {
    String staticResourcePath;

    public ResourceReader(String staticResourcePath) {
        this.staticResourcePath = staticResourcePath;
    }

    public Response readContent(String uri) {
        Response response = null;
        File file;
        file = new File(staticResourcePath + uri);
        try {
            response = new Response("HTTP/1.1 200 OK", new String(Files.readAllBytes(file.toPath())));
        } catch (Exception e) {

        }
        return response;
    }

    public Response readContent(String uri, HttpCode httpCode) {
        Response response = null;
        File file;
        file = new File(staticResourcePath + uri);
        try {
            response = new Response("HTTP/1.1 " + httpCode.getCode() + " " + httpCode.getDescription(), new String(Files.readAllBytes(file.toPath())));
        } catch (Exception e) {
            response = new Response("HTTP/1.1 " + HttpCode.INTERNAL_SERVER_ERROR.getCode() + " " + HttpCode.INTERNAL_SERVER_ERROR.getDescription());
        }
        return response;
    }
}
