package com.booleanuk.core;

public class Customer extends Member{

    public Customer(Basket basket) {
        super(basket);
    }

    public Float getTotalCost() {
        return basket.getTotalCost();
    }
    public Float getPrice(Item item){

        return item.getPrice();
    }


}
