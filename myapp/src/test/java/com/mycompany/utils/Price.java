package com.mycompany.utils;

public class Price {
    private String product;
    private String currency;
    private int price;

    public Price(String product, String currency, int price){
        this.product = product;
        this.currency = currency;
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public String getCurrency() {
        return currency;
    }

    public int getPrice() {
        return price;
    }
}
