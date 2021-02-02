package org.velosaurus.demo.rest;

public class CustomerErrorResponse {

    private int status;
    private String message;
    private long timeStamp;
    private String time;

    public CustomerErrorResponse() {
    }

    public CustomerErrorResponse(int status, String message, long timeStamp, String time) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
        this.time = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
