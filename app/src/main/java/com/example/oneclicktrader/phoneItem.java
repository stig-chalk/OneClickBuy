package com.example.oneclicktrader;

public class phoneItem {
    public String brand, model, condition, color;
    public double price;
    public int RAMSize, storageSize;

    public phoneItem(String brand, String model, String condition, String color, double price, int RAMSize, int storageSize) {
        this.brand = brand;
        this.model = model;
        this.condition = condition;
        this.color = color;
        this.price = price;
        this.RAMSize = RAMSize;
        this.storageSize = storageSize;
    }
}
