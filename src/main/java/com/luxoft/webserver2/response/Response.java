package com.luxoft.webserver2.response;

public class Response {
    private String httpHeader;
    private String content;

    public Response(String StringOfHttpStatusResponse, String content) {
        this.httpHeader = StringOfHttpStatusResponse;
        this.content = content;
    }

    public Response(String httpHeader) {
        this.httpHeader = httpHeader;
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
