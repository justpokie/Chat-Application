package com.pokie.pokichat.model;


public class Message {

    String user;
    String content;

    public Message() {

    }

    public Message(String content) {
        this.content = content;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
