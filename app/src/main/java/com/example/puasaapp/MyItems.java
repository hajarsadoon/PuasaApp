package com.example.puasaapp;

public class MyItems {

    private final String Name;
    private final String Avatar;

    public MyItems(String Name, String Avatar){
        this.Name = Name;
        this.Avatar = Avatar;
    }

    public String getName() {
        return Name;
    }

    public String getAvatar() {
        return Avatar;
    }
}
