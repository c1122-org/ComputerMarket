package com.example.computermarket.Model;

public class Computer {
    private int id;
    private String name;
    private double price;
    private String producer;
    private String country;
    private String describe;
    private String img;

    public Computer() {

    }

    public Computer(int id, String name, double price, String producer, String country, String describe, String img) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.producer = producer;
        this.country = country;
        this.describe = describe;
        this.img = img;
    }

    public Computer(String name, double price, String producer, String country, String describe, String img) {
        this.name = name;
        this.price = price;
        this.producer = producer;
        this.country = country;
        this.describe = describe;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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
    public String getImg(){
        return img;
    }
    public void setImg(String img){
        this.img = img;
    }
}
