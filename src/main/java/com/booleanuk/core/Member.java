package com.booleanuk.core;

public class Member {
    protected Basket basket;

    public Member(Basket basket) {
        this.basket = basket;
    }

    public boolean addToBasket(Item item){
        return basket.addItems(item);
    }

    public boolean removeFromBasket(Item item){
        return basket.removeItem(item);
    }

}
