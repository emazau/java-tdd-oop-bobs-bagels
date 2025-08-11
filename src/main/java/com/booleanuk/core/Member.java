package com.booleanuk.core;

public class Member {
    private Basket basket;

    public Member(Basket basket) {
        this.basket = basket;
    }
// this is the start
//    public boolean addToBasket(Item item){
//
//        return true;
//    }
    public boolean addToBasket(Item item){
        int size = basket.getSize();
        basket.addItems(item);
        System.out.println("size before add " + size);

        System.out.println("actual size " + basket.getItems().size());

        return !(size + 1 == basket.getSize());
    }

    public boolean removeFromBasket(Item item){
        return true;
    }
    public boolean setMaxCapacity(Integer maxCapacity) {
        return basket.setMaxCapacity(maxCapacity);
    }

}
