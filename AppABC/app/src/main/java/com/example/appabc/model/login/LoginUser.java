package com.example.appabc.model.login;

/**
 * @Autor Alan
 * @version 1.0
 */

public class LoginUser {

    private String code;
    private String message;
    private Response response;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
