package com.luxoft.webserver2.request;

import com.luxoft.webserver2.enums.HttpCode;
import com.luxoft.webserver2.response.ResourceReader;
import com.luxoft.webserver2.response.Response;
import com.luxoft.webserver2.response.ResponseWriter;

import java.io.*;

public class RequestHandler {
    private final BufferedWriter writer;
    private final BufferedReader reader;
    private final String staticResourcesPath;

    public String getStaticResourcesPath() {
        return staticResourcesPath;
    }


    public RequestHandler(BufferedWriter writer, BufferedReader reader, String staticResourcesPath) {
        this.writer = writer;
        this.reader = reader;
        this.staticResourcesPath = staticResourcesPath;
    }


    public void handle() throws Exception {
        Response response = null;
        RequestParser requestParser = new RequestParser();
        Request request = requestParser.parse(reader);
        System.out.println(" === Ready to write response === ");
        ResourceReader resourceReader = new ResourceReader(getStaticResourcesPath());
        response = resourceReader.readContent(request.getUri());
        ResponseWriter responseWriter = new ResponseWriter();
        if (null != response) {

            responseWriter.writeResponse(writer, response);
        } else {

            responseWriter.writeResponse(writer, send404());
        }


    }

    private Response send404() throws IOException {
        ResourceReader resourceReader = new ResourceReader(getStaticResourcesPath());
        return resourceReader.readContent("/404.html", HttpCode.NOT_FOUND);
    }


}
