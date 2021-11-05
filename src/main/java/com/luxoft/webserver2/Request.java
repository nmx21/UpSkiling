package com.luxoft.webserver2;

import java.util.Map;

public class Request {
    private String uri;
    private Map<String, String> headers;
    private HttpMethod method;

    @Override
    public String toString() {
        return "Request{" +
                "uri='" + uri + '\'' +
                ", headers=" + headers +
                ", method=" + method +
                '}';
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }
}

