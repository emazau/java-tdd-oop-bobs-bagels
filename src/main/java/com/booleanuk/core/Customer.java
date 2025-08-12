package com.booleanuk.core;

public class Customer extends Member{
    private Float totalCost;

    public Customer(Float totalCost, Basket basket) {
        super(basket);
        this.totalCost = totalCost;
    }


    public Float getTotalCost() {

        return basket.getTotalCost();
    }
    public Float getPrice(Item item){

        return item.getPrice();
    }

    public Float getItemCost(Item item){
        return 0.00f;
    }

}
