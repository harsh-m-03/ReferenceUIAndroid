package com.example.shoppingapp.Models;

public class Items {
    String name;
    int quantity;
    String desc;
    float price;
    String note;
    Boolean bookmark;

    public Items(String name, float price, int quantity, String note) {
        this.name = name;
        this.quantity = quantity;
        this.note = note;
        this.price = price;
    }

    public Items(String name, float price, int quantity, String note, Boolean bookmark) {
        this.name = name;
        this.bookmark = bookmark;
        this.quantity = quantity;
        this.note = note;
        this.price = price;
    }

    public Boolean getBookmark() {
        return bookmark;
    }

    public void setBookmark(Boolean bookmark) {
        this.bookmark = bookmark;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
