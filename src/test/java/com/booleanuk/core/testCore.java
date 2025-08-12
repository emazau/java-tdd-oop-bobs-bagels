package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

class testCore {
    @Test
    public void addBagelandCurrentStockTest() {
        Item bagel = new Bagel(0.49f,"Bagel", "Plain","BGLP");
        ArrayList<Item> list = new ArrayList<>();
        HashMap<Item, Integer> currentStock = new HashMap<>();
        currentStock.put(bagel, 2);
        Basket basket = new Basket(list);
        Manager manager = new Manager(currentStock, 4);
        Member member = new Member(basket);


        Assertions.assertEquals(true, member.addToBasket(bagel));

        Assertions.assertEquals(true, member.addToBasket(bagel));
        //scenario inventory is empty
        Assertions.assertEquals(false, member.addToBasket(bagel));


        //recreate to test capacity
        Manager.currentStock.put(bagel, 9);
        list = new ArrayList<>();
        basket = new Basket(list);
        member = new Member(basket);

        //add a test where the inventory is empty.
        Assertions.assertEquals(true, member.addToBasket(bagel));
        Assertions.assertEquals(true, member.addToBasket(bagel));
        Assertions.assertEquals(true, member.addToBasket(bagel));
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
        Manager manager = new Manager(currentStock, 4);

        Basket basket = new Basket(list);
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
        Manager manager = new Manager(currentStock, 4);

        Basket basket = new Basket(list);
        Member member = new Member(basket);

        //set the capacity;
        //QUESTION! is it better to have member.setcapacity than member.basket.setcapacity?
        Assertions.assertEquals(true, manager.setMaxCapacity(10));
        Assertions.assertEquals(true, manager.setMaxCapacity(50));
        Assertions.assertEquals(true, manager.setMaxCapacity(80));
        Assertions.assertEquals(false, manager.setMaxCapacity(-10));
        Assertions.assertEquals(false, manager.setMaxCapacity(120));

    }
    @Test
    public void getTotalCostTets(){
        Item bagel1 = new Bagel(0.49f,"Bagel", "Plain","BGLP");
        Item bagel2 = new Bagel(0.49f,"Bagel", "Onion","BGLO");


        ArrayList<Item> list = new ArrayList<>();
        HashMap<Item, Integer> currentStock = new HashMap<>();
        currentStock.put(bagel1, 4);
        currentStock.put(bagel2, 4);
        Manager manager = new Manager(currentStock, 4);

        Basket basket = new Basket(list);
        //how does extend work here?
        Customer customer = new Customer(basket);

        Assertions.assertEquals(0.00f, customer.getTotalCost());

        customer.addToBasket(bagel1);
        Assertions.assertEquals(0.49f, customer.getTotalCost());

        customer.addToBasket(bagel1);
        Assertions.assertEquals(0.49f*2, customer.getTotalCost());


        customer.addToBasket(bagel1);
        Assertions.assertEquals(0.49f*3, customer.getTotalCost());



    }
    @Test
    public void checkDiscountTest(){
        Item bagel1 = new Bagel(0.49f,"Bagel", "Plain","BGLP");
        Item filling1 = new Filling(0.12f,"Filling", "Egg","FILE");
        Item coffe1 = new Coffe(0.99f,"Coffee", "Black","COFB");
        ArrayList<Item> list = new ArrayList<>();
        HashMap<Item, Integer> currentStock = new HashMap<>();

        currentStock.put(bagel1, 80);
        currentStock.put(filling1, 80);
        currentStock.put(coffe1, 80);

        Manager manager = new Manager(currentStock, 80);
        Basket basket = new Basket(list);
        Customer customer1 = new Customer(basket);

        Customer customer2 = new Customer(basket);
        Customer customer3 = new Customer(basket);
        Customer customer4 = new Customer(basket);


        //No discount
        customer1.addToBasket(bagel1);
        customer1.addToBasket(bagel1);
        customer1.addToBasket(bagel1);
        customer1.addToBasket(bagel1);
        customer1.addToBasket(bagel1);
        Assertions.assertEquals(0.49f*5, customer1.getTotalCost());

        customer1.addToBasket(filling1);
        customer1.addToBasket(filling1);

        Assertions.assertEquals(0.49f*5+2*0.12f, customer1.getTotalCost());

        customer2.addToBasket(coffe1);

        customer2.addToBasket(coffe1);
        customer2.addToBasket(coffe1);
        customer2.addToBasket(coffe1);
        customer2.addToBasket(coffe1);
        customer2.addToBasket(coffe1);

        Assertions.assertEquals(0.99f*6, customer2.getTotalCost());

        //Discount 1

        customer3.addToBasket(bagel1);
        customer3.addToBasket(bagel1);
        customer3.addToBasket(bagel1);
        customer3.addToBasket(bagel1);
        customer3.addToBasket(bagel1);
        customer3.addToBasket(bagel1);

        Assertions.assertEquals(2.49f, customer3.getTotalCost());

        customer3.addToBasket(bagel1);
        customer3.addToBasket(bagel1);
        customer3.addToBasket(bagel1);
        customer3.addToBasket(bagel1);
        customer3.addToBasket(bagel1);


        Assertions.assertEquals(2.49f+0.49f*5, customer3.getTotalCost());

        customer3.addToBasket(filling1);
        customer3.addToBasket(filling1);

        Assertions.assertEquals(2.49f+0.49f*5+2*0.12f, customer3.getTotalCost());



        customer3.addToBasket(bagel1);
        Assertions.assertEquals(3.99f+2*0.12f, customer3.getTotalCost());

        customer3.addToBasket(bagel1);
        customer3.addToBasket(bagel1);
        customer3.addToBasket(bagel1);
        customer3.addToBasket(bagel1);
        customer3.addToBasket(bagel1);
        customer3.addToBasket(bagel1);
        Assertions.assertEquals(3.99f+2.49f+2*0.12f, customer3.getTotalCost());


        //Discount 4
        customer4.addToBasket(bagel1);
        customer4.addToBasket(coffe1);

        Assertions.assertEquals(0.99f, customer4.getTotalCost());

        customer4.addToBasket(bagel1);

        Assertions.assertEquals(0.99f+0.49f, customer4.getTotalCost());



        //Many Discounts

        customer3.addToBasket(coffe1);
        Assertions.assertEquals(3.99f+2.49f+2*0.12f+0.99f, customer3.getTotalCost());
        customer3.addToBasket(coffe1);
        Assertions.assertEquals(3.99f+2.49f+2*0.12f+0.99f*2, customer3.getTotalCost());
        customer3.addToBasket(bagel1);
        Assertions.assertEquals(3.99f+2.49f+2*0.12f+0.99f+1.25f, customer3.getTotalCost());



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

        Basket basket = new Basket(list);
        //how does extend work here?
        Customer customer = new Customer(basket);


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
        Manager manager = new Manager(currentStock, 4);

        Basket basket = new Basket(list);
        //how does extend work here?
        Customer customer = new Customer(basket);

        //item exists
        Assertions.assertEquals(true, Manager.setCurrentStock(coffe2,25));
        Assertions.assertEquals(true, Manager.setCurrentStock(coffe3,20));

        //item does not exist
        Assertions.assertEquals(false, Manager.setCurrentStock(null,20));

    }


}


