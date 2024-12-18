package com.example.Spring.Example.Models;

public class ResponseObject {
    
    private boolean status;
    private String message;
    private Object data;

    public ResponseObject() {
    }

    public ResponseObject(boolean status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setProduct(Object data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "ResponseObject [status=" + status + ", message=" + message + ", data=" + data + "]";
    }

}
