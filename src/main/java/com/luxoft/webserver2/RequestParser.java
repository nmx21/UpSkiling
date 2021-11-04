package com.luxoft.webserver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;


public class RequestParser {

    public Request parse(BufferedReader reader) throws IOException {
        Request request = new Request();
        request.setHeaders(new HashMap<>());
        String line;

        boolean isFirstLineWithUrl = false;
        while (!(line = reader.readLine()).isEmpty()) {

            if (!isFirstLineWithUrl) {
                injectUriAndMethod(line, request);
                isFirstLineWithUrl = true;
            } else {
                injectHeaders(line, request);
            }
        }

        return request;
    }

    public void injectUriAndMethod(String requestLine, Request request) {
        String[] tokens = requestLine.split(" ");
        request.setUri(tokens[1]);
        request.setMethod(Enum.valueOf(HttpMethod.class, tokens[0]));
    }


    public void injectHeaders(String requestLine, Request request) {
        String[] tokens = requestLine.split(": ");
        request.getHeaders().put(tokens[0], tokens[1]);
    }


}
