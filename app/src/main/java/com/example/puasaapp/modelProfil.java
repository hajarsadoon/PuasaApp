package com.example.puasaapp;

public class modelProfil {

    // to firstname keyword in database
    private String password;
    private String email;
    String Avatar;
    String Nama;
    Integer SkorKuiz;
    String Key;


    public modelProfil() {
    }


    public modelProfil(String avatar,String name) {
        this.Avatar = avatar;
        Nama = name;

    }

    public Integer getSkorKuiz() {
        return SkorKuiz;
    }

    public void setSkorKuiz(Integer skorKuiz) {
        SkorKuiz = skorKuiz;
    }
    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String avatar) {
        this.Avatar = avatar;
    }

    public String getNama() {
        return Nama;
    }

    public void setName(String name) {
        this.Nama = name;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        this.Key = key;
    }
}
