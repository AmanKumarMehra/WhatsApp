package com.example.whatsapp.Models;

public class Users {

    String profilepic, username, e_mail, password, userId, lastMessage, status;

    public Users(String profilepic, String username, String e_mail, String password, String userId, String lastMessage, String status) {
        this.profilepic = profilepic;
        this.username = username;
        this.e_mail = e_mail;
        this.password = password;
        this.userId = userId;
        this.lastMessage = lastMessage;
        this.status = status;
    }

    public Users(){

    }

    public Users(String username, String e_mail, String password) {
        this.username = username;
        this.e_mail = e_mail;
        this.password = password;
    }

    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getMail() {
        return e_mail;
    }

    public void setMail(String mail) {
        this.e_mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
