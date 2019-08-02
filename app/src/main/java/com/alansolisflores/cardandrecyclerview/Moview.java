package com.alansolisflores.cardandrecyclerview;

public class Moview {

    private String name;

    private int image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Moview(String name, int image) {
        this.name = name;
        this.image = image;
    }
}
