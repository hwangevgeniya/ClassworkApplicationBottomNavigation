package com.geektech.classworkapplicationbottomnavigation.models;

public class Character {

    private String name;
    private int image;

    public Character(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }
}
