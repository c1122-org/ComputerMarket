package com.example.computermarket.Model;

public class Computer {
    private int idPc;
    private String name;
    private String price;
    private String producer;
    private String country;
    private String describe;
    private String img;
    private int idUser;

    public Computer() {
    }

    public Computer(int idPc, String name, String price, String producer, String country, String describe, String img, int idUser) {
        this.idPc = idPc;
        this.name = name;
        this.price = price;
        this.producer = producer;
        this.country = country;
        this.describe = describe;
        this.img = img;
        this.idUser = idUser;
    }

    public Computer(String name, String price, String producer, String country) {
        this.name = name;
        this.price = price;
        this.producer = producer;
        this.country = country;
    }

    public Computer(String name, String price, String producer, String country, String describe, String img, int idUser) {
        this.name = name;
        this.price = price;
        this.producer = producer;
        this.country = country;
        this.describe = describe;
        this.img = img;
        this.idUser = idUser;
    }

    public int getIdPc() {
        return idPc;
    }

    public void setIdPc(int idPc) {
        this.idPc = idPc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}