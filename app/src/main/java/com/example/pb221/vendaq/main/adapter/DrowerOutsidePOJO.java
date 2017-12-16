package com.example.pb221.vendaq.main.adapter;

/**
 * Created by pb221 on 28-10-2017.
 */

public class DrowerOutsidePOJO {
    private int img;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    private String name;

    public DrowerOutsidePOJO(int img, String name, boolean isOpen) {
        img = img;
        this.name = name;
        this.isOpen = isOpen;
    }

    private boolean isOpen;
}
