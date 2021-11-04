package com.luxoft.webserver2;

import java.io.BufferedWriter;
import java.io.IOException;

public class ResponseWriter {
    public void writeResponse(BufferedWriter writer, Response response) {
        try {
            writer.write(response.getHttpHeader());
            writer.newLine();
            writer.newLine();
            writer.write(response.getContent());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
