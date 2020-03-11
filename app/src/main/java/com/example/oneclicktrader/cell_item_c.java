package com.example.oneclicktrader;

public class cell_item_c {
    public String cell_brand, cell_condition;
    public double cell_price;
    public int cell_imagesource;

    public cell_item_c(String brand, String cond, double price, int img) {
        cell_brand = brand;
        cell_condition = cond;
        cell_price = price;
        cell_imagesource = img;
    }
}
