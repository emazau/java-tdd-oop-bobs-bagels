package com.booleanuk.core;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Basket {
        /// SHould this be List or ArrayList
    private ArrayList<Item> items;
    private HashMap<Item, Integer> currentStock; //Should I use hashMap instead here maybe?
    private Integer maxCapacity;

    public Basket(Integer maxCapacity, ArrayList<Item> items, HashMap<Item, Integer> currentStock) {
        this.maxCapacity = maxCapacity;
        this.items = items;
        this.currentStock = currentStock;
    }
//should I use arraylist here or List<>
    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    //This is added for first test:
    public void addItems( Item item){
        if (checkStock(item) && getSize() < maxCapacity) {
            items.add(item);

        }
    }

    public Boolean checkStock(Item item) {
        //check the key item, and check if it has any integers left.
        if (currentStock.containsKey(item)){
            Integer stock = currentStock.get(item);
            System.out.println("the current stock: " + stock);
            if (stock > 0) {
                currentStock.put(item, stock-1);
                return true;

            }

        }
        return false;
    }

    public Integer getSize() {
        return items.size();
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public boolean setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
        return true;
    }

    public HashMap<Item, Integer> getCurrentStock() {
        return currentStock;
    }

    public boolean setCurrentStock(HashMap<Item, Integer> currentStock) {
        this.currentStock = currentStock;
        return false;
    }

}
