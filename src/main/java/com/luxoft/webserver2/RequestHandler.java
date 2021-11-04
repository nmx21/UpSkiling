package com.luxoft.webserver2;

import java.io.*;

public class RequestHandler {
    BufferedWriter writer;
    BufferedReader reader;

    public String getStaticResourcesPath() {
        return staticResourcesPath;
    }

    String staticResourcesPath;

    public RequestHandler(BufferedWriter writer, BufferedReader reader, String staticResourcesPath) {
        this.writer = writer;
        this.reader = reader;
        this.staticResourcesPath = staticResourcesPath;
    }


    public void handle() throws IOException {
        RequestParser requestParser = new RequestParser();
        Request request = requestParser.parse(reader);
        System.out.println(" === Ready to write response === ");
        ResourceReader resourceReader = new ResourceReader(getStaticResourcesPath());
        Response response = resourceReader.readContent(request.getUri());
        if (response != null) {
            ResponseWriter responseWriter = new ResponseWriter();
            responseWriter.writeResponse(writer, response);
        }
    }


}
