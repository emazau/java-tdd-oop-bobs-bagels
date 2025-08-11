package com.booleanuk.core;

public class Bagel implements Item{
    private Float price;
    private String name;
    private String type;
    private String SKU;

    public Bagel(Float price, String name, String type, String SKU) {
        this.price = price;
        this.name = name;
        this.type = type;
        this.SKU = SKU;
    }

    @Override
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }
}
