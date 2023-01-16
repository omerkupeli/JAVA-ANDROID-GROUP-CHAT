package com.example.grupsms;

public class MessageModel {
    private String name, description, Uid;

    public MessageModel(String name, String description, String Uid) {
        this.name = name;
        this.description = description;
        this.Uid = Uid;

    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getUid() {
        return Uid;
    }
    public void setUid(String Uid) {
        this.Uid = Uid;
    }
}
