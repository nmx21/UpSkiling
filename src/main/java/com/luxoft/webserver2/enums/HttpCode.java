package com.luxoft.webserver2.enums;

public enum HttpCode {
    OK("200", "OK"),
    NOT_FOUND("404", "Not Found"),
    BAD_REQUEST("400", "Bad Request"),
    METHOD_NOT_ALLOWED("405", "Method Not Allowed"),
    INTERNAL_SERVER_ERROR("500", "Internal Server Error");


    private final String code;

    public String getDescription() {
        return description;
    }

    private final String description;


    HttpCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public static HttpCode getByNames(String value) {
        for (HttpCode httpCode : values()) {
            if (httpCode.code.equalsIgnoreCase(value)) {
                return httpCode;
            }
        }
        throw new IllegalArgumentException("No Http code:" + value);
    }


}
