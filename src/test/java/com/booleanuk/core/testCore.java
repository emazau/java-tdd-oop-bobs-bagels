package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class testCore {
    @Test
    public void addBagelandCurrentStockTest() {
        Item bagel = new Bagel(0.49f,"Bagel", "Plain","BGLP");
        ArrayList<Item> list = new ArrayList<>();
        HashMap<Item, Integer> currentStock = new HashMap<>();
        currentStock.put(bagel, 2);
        Basket basket = new Basket(4, list, currentStock );
        Member member = new Member(basket);


        Assertions.assertEquals(true, member.addToBasket(bagel));

        Assertions.assertEquals(true, member.addToBasket(bagel));
        //scenario inventory is empty
        Assertions.assertEquals(false, member.addToBasket(bagel));


        //recreate to test capacity
        currentStock = new HashMap<>();
        currentStock.put(bagel, 2);
        list = new ArrayList<>();
        basket = new Basket(1, list, currentStock );
        member = new Member(basket);

        //add a test where the inventory is empty.
        Assertions.assertEquals(true, member.addToBasket(bagel));
        Assertions.assertEquals(false, member.addToBasket(bagel));


        //How do I test something which would return a error?

        //member.addToBasket(bagel);
        //System.out.println(

    }
    @Test
    public void removeBagelTest(){

        //Set everything up
        Item bagel1 = new Bagel(0.49f,"Bagel", "Plain","BGLP");
        Item bagel2 = new Bagel(0.49f,"Bagel", "Onion","BGLO");


        ArrayList<Item> list = new ArrayList<>();
        HashMap<Item, Integer> currentStock = new HashMap<>();
        currentStock.put(bagel1, 2);
        currentStock.put(bagel2, 2);

        Basket basket = new Basket(4, list, currentStock );
        Member member = new Member(basket);

        //the tests

        //basket is empty
        Assertions.assertEquals(false, member.removeFromBasket(bagel1));
        Assertions.assertEquals(false, member.removeFromBasket(bagel2));


        member.addToBasket(bagel1);
        member.addToBasket(bagel1);

        member.addToBasket(bagel2);

        Assertions.assertEquals(true, member.removeFromBasket(bagel2));
        Assertions.assertEquals(true, member.removeFromBasket(bagel1));

        //does not exist
        Assertions.assertEquals(false, member.removeFromBasket(bagel2));

        //remove the last:
        Assertions.assertEquals(true, member.removeFromBasket(bagel1));

    }
    @Test
    public void setCapacityTest(){
        //Set everything up
        Item bagel1 = new Bagel(0.49f,"Bagel", "Plain","BGLP");
        Item bagel2 = new Bagel(0.49f,"Bagel", "Onion","BGLO");


        ArrayList<Item> list = new ArrayList<>();
        HashMap<Item, Integer> currentStock = new HashMap<>();
        currentStock.put(bagel1, 2);
        currentStock.put(bagel2, 2);

        Basket basket = new Basket(4, list, currentStock );
        Member member = new Member(basket);

        //set the capacity;
        //QUESTION! is it better to have member.setcapacity than member.basket.setcapacity?
        Assertions.assertEquals(true, member.setMaxCapacity(10));
        Assertions.assertEquals(true, member.setMaxCapacity(50));
        Assertions.assertEquals(true, member.setMaxCapacity(80));
        Assertions.assertEquals(false, member.setMaxCapacity(-10));
        Assertions.assertEquals(false, member.setMaxCapacity(120));

    }
    @Test
    public void getTotalCostTets(){
        Item bagel1 = new Bagel(0.49f,"Bagel", "Plain","BGLP");
        Item bagel2 = new Bagel(0.49f,"Bagel", "Onion","BGLO");


        ArrayList<Item> list = new ArrayList<>();
        HashMap<Item, Integer> currentStock = new HashMap<>();
        currentStock.put(bagel1, 4);
        currentStock.put(bagel2, 4);

        Basket basket = new Basket(4, list, currentStock );
        //how does extend work here?
        Customer customer = new Customer(0.00f,basket);

        Assertions.assertEquals(0.00f, customer.getTotalCost());

        customer.addToBasket(bagel1);

        Assertions.assertEquals(0.49f, customer.getTotalCost());

        customer.addToBasket(bagel1);
        Assertions.assertEquals(0.49f*2, customer.getTotalCost());


        customer.addToBasket(bagel1);
        Assertions.assertEquals(0.49f*3, customer.getTotalCost());



    }
    @Test
    public void getPriceTest(){
        Item bagel1 = new Bagel(0.49f,"Bagel", "Plain","BGLP");
        Item bagel2 = new Bagel(0.49f,"Bagel", "Onion","BGLO");
        Item filling1 = new Filling(0.12f,"Filling", "Egg","FILE");
        Item coffe1 = new Coffe(0.99f,"Coffee", "Black","COFB");
        Item coffe2 = new Coffe(1.19f,"Coffee", "White","COFW");
        Item coffe3 = new Coffe(1.29f,"Coffee", "Latte","COFL");



        ArrayList<Item> list = new ArrayList<>();
        HashMap<Item, Integer> currentStock = new HashMap<>();
//        currentStock.put(bagel1, 2);
//        currentStock.put(bagel2, 2);
//
//        currentStock.put(filling1, 10);

        Basket basket = new Basket(4, list, currentStock );
        //how does extend work here?
        Customer customer = new Customer(0.00f,basket);


        Assertions.assertEquals(0.12f, customer.getPrice(filling1));

        Assertions.assertEquals(0.49f, customer.getPrice(bagel1));

        Assertions.assertEquals(0.49f, customer.getPrice(bagel2));

        Assertions.assertEquals(0.99f, customer.getPrice(coffe1));

        Assertions.assertEquals(1.19f, customer.getPrice(coffe2));

        Assertions.assertEquals(1.29f, customer.getPrice(coffe3));


    }
    @Test
    public void setCurrentStock(){
        Item bagel1 = new Bagel(0.49f,"Bagel", "Plain","BGLP");
        Item bagel2 = new Bagel(0.49f,"Bagel", "Onion","BGLO");
        Item filling1 = new Filling(0.12f,"Filling", "Egg","FILE");
        Item coffe1 = new Coffe(0.99f,"Coffee", "Black","COFB");
        Item coffe2 = new Coffe(1.19f,"Coffee", "White","COFW");
        Item coffe3 = new Coffe(1.29f,"Coffee", "Latte","COFL");



        ArrayList<Item> list = new ArrayList<>();
        HashMap<Item, Integer> currentStock = new HashMap<>();
        currentStock.put(bagel1, 2);
        currentStock.put(bagel2, 2);
//
        currentStock.put(filling1, 10);
        currentStock.put(coffe2,20);

        Basket basket = new Basket(4, list, currentStock );
        //how does extend work here?
        Customer customer = new Customer(0.00f,basket);

        //item exists
        Assertions.assertEquals(true, Manager.setCurrentStock(coffe2,25));
        Assertions.assertEquals(true, Manager.setCurrentStock(coffe3,20));

        //item does not exist
        Assertions.assertEquals(false, Manager.setCurrentStock(null,20));

    }


}


