package com.luxoft.webserver2.response;

import java.io.BufferedWriter;
import java.io.IOException;

public class ResponseWriter {
    public void writeResponse(BufferedWriter writer, Response response) {
        String s = System.lineSeparator();
        try {
            writer.write(response.getHttpHeader());
            writer.write(s);
            writer.write(s);

            if (response.getContent() != null) {
                writer.write(response.getContent());
            } else {
                writer.write("500 Internal Server Error");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
