package com.datorium.Datorium.API.DTOs;

public class Message {

    private int id;
    private String content;
    private String sender;

    public Message() {}

    public Message(int id, String content, String sender) {
        this.id = id;
        this.content = content;
        this.sender = sender;
    }

}
