package com.jonathan.user.controller;

public class CustomResponse {
    public String code;
    public String message;

    public CustomResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
