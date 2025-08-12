package com.booleanuk.core;

public class Coffe implements Item {
    private Float price;
    private String name;
    private String type;
    private String SKU;

    public Coffe(Float price, String name, String type, String SKU) {
        this.price = price;
        this.name = name;
        this.type = type;
        this.SKU = SKU;
    }


    public Float getPrice() {
        return price;
    }

}
