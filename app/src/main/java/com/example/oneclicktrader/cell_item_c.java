package com.example.oneclicktrader;

public class cell_item_c {
    public String cell_brand, cell_condition, cell_color, cell_model;
    public double cell_price;
    public int cell_imagesource;

    public cell_item_c(String brand, String model, String cond, String color, double price, int img) {
        cell_brand = brand;
        cell_model = model;
        cell_condition = cond;
        cell_color = color;
        cell_price = price;
        cell_imagesource = img;
    }
}
