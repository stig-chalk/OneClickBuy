package com.example.oneclicktrader;

public class phoneItem {
    private String brand, model, condition, color;
    private double price;
    private int RAMSize, storageSize;
    private int imageSource;

    public phoneItem(){};

    public phoneItem(String brand, String model, String condition, String color, double price, int RAMSize, int storageSize) {
        this.brand = brand;
        this.model = model;
        this.condition = condition;
        this.color = color;
        this.price = price;
        this.RAMSize = RAMSize;
        this.storageSize = storageSize;

        this.imageSource = R.drawable.ic_android;
//        if (this.brand == "Apple")
//            this.imageSource = R.drawable.ic_apple;

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRAMSize() {
        return RAMSize;
    }

    public void setRAMSize(int RAMSize) {
        this.RAMSize = RAMSize;
    }

    public int getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(int storageSize) {
        this.storageSize = storageSize;
    }

    public int getImageSource() {
        return imageSource;
    }
}
