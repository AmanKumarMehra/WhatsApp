package com.example.whatsapp.Models;

public class MessageModel {

    String uId, message, type;
    Long timestamp;

    public MessageModel(String uId, String message, String type, Long timestamp) {
        this.uId = uId;
        this.message = message;
        this.type = type;
        this.timestamp = timestamp;
    }

    public MessageModel(String uId, String message, String type) {
        this.uId = uId;
        this.message = message;
        this.type = type;
    }

    public MessageModel(String uId, String message) {
        this.uId = uId;
        this.message = message;
    }

    public MessageModel() {
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
