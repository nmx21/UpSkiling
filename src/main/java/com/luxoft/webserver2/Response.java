package com.luxoft.webserver2;

public class Response {
    private String httpHeader;
    private String content;

    public Response(String httpHeader, String content) {
        this.httpHeader = httpHeader;
        this.content = content;
    }

    public String getHttpHeader() {
        return httpHeader;
    }

    public void setHttpHeader(String httpHeader) {
        this.httpHeader = httpHeader;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
