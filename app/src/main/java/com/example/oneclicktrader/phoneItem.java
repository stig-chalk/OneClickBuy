package com.example.oneclicktrader;

import java.io.Serializable;

public class phoneItem implements Serializable {
    private String brand, model, condition, color, key;
// import android.os.Parcel;
// import android.os.Parcelable;

// public class phoneItem implements Parcelable {
//     private String brand, model, condition, color;
//     private double price;
//     private int RAMSize, storageSize, imageSource;

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
        if (this.brand.equals("Apple"))
            this.imageSource = R.drawable.ic_iphone;

    }

    protected phoneItem(Parcel in) {
        brand = in.readString();
        model = in.readString();
        condition = in.readString();
        color = in.readString();
        price = in.readDouble();
        RAMSize = in.readInt();
        storageSize = in.readInt();
        imageSource = in.readInt();
    }

    public static final Creator<phoneItem> CREATOR = new Creator<phoneItem>() {
        @Override
        public phoneItem createFromParcel(Parcel in) {
            return new phoneItem(in);
        }

        @Override
        public phoneItem[] newArray(int size) {
            return new phoneItem[size];
        }
    };

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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setImageSource() {
        this.imageSource = R.drawable.ic_android;
        if (this.brand.equals("Apple"))
            this.imageSource = R.drawable.ic_iphone;
//     @Override
//     public int describeContents() {
//         return 0;
//     }

//     @Override
//     public void writeToParcel(Parcel dest, int flags) {
//         dest.writeString(brand);
//         dest.writeString(model);
//         dest.writeString(condition);
//         dest.writeString(color);
//         dest.writeDouble(price);
//         dest.writeInt(RAMSize);
//         dest.writeInt(storageSize);
//         dest.writeInt(imageSource);
//     }
// }
