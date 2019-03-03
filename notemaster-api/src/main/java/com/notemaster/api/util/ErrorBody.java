package com.notemaster.api.util;

public class ErrorBody {
    public String message;
    public String detailMessage;

    public ErrorBody(String message, String detailMessage) {
        this.message = message;
        this.detailMessage = detailMessage;
    }
}
