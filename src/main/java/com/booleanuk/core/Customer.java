package com.booleanuk.core;

public class Customer extends Member{
    private Float totalCost;

    public Customer(Float totalCost, Basket basket) {
        super(basket);
        this.totalCost = totalCost;
    }

    public Float getTotalCost(){
        return 0.00f;
    }

    public Float setTotalCost() {

        return 0.00f;
    }
    public Float getPrice(Item item){
        return 0.00f;
    }

    public Float getItemCost(Item item){
        return 0.00f;
    }

}
