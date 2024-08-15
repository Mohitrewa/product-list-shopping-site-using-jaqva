package com.springboot.exceptionhandling.exceptions;

public class ItemErrorResponse {
    private int status;
    private long timestamp;
    private String message;
    public ItemErrorResponse(int status, long timestamp, String message) {
        this.status = status;
        this.timestamp = timestamp;
        this.message = message;
    }
    public ItemErrorResponse() {
        //TODO Auto-generated constructor stub
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public long getTimeStamp() {
        return timestamp;
    }
    public void setTimeStamp(long timestamp) {
        this.timestamp = timestamp;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    
}
