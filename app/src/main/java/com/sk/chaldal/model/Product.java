package com.sk.chaldal.model;

/**
 * Created by masud on 9/21/2017.
 */

public class Product {
    private String name;
    private String quantiy;
    private String prices;
    private String prices2;
    private int image;
    private int total = 0;

    public Product() {
    }

    public String getPrices2() {
        return prices2;
    }

    public void setPrices2(String prices2) {
        this.prices2 = prices2;
    }

    public Product(String name, String quantiy, String prices, String prices2 , int image) {
        this.name = name;
        this.quantiy = quantiy;
        this.prices = prices;
        this.prices2=prices2;

        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantiy() {
        return quantiy;
    }

    public void setQuantiy(String quantiy) {
        this.quantiy = quantiy;
    }

    public String getPrices() {
        return prices;
    }

    public void setPrices(String prices) {
        this.prices = prices;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int add(int number){
        return total = total +number;
    }

    public int sub(int number){
        return total = total -number;
    }
}
