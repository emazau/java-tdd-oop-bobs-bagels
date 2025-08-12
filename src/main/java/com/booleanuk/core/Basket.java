package com.booleanuk.core;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Basket {
        /// SHould this be List or ArrayList
    private ArrayList<Item> items;

    public Basket(Integer maxCapacity, ArrayList<Item> items, HashMap<Item, Integer> currentStock) {
        Manager.maxCapacity = maxCapacity;
        this.items = items;
        Manager.currentStock = currentStock;
    }
//should I use arraylist here or List<>
    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    //This is added for first test:
    public boolean addItems( Item item){
        if (checkStock(item) && getSize() < Manager.maxCapacity) {
            items.add(item);
            return true;
        }
        return false;
    }

    public Boolean checkStock(Item item) {
        //check the key item, and check if it has any integers left.
        if (Manager.currentStock.containsKey(item)){
            Integer stock = Manager.currentStock.get(item);
            System.out.println("the current stock: " + stock);
            if (stock > 0) {
                Manager.currentStock.put(item, stock-1);
                return true;

            }

        }
        return false;
    }
    public boolean removeItem(Item item){
        if (items.contains(item)) {
            items.remove(item);
            return true;
        }
        return false;
    }


    public Integer getSize() {
        return items.size();
    }

    public Integer getMaxCapacity() {
        return Manager.maxCapacity;
    }

    public boolean setMaxCapacity(Integer maxCapacity) {
        if (maxCapacity >0 && maxCapacity <= 100){
            Manager.maxCapacity = maxCapacity;
            return true;
        }
        return false;
    }

    public HashMap<Item, Integer> getCurrentStock() {
        return Manager.currentStock;
    }

    public boolean setCurrentStock(HashMap<Item, Integer> currentStock) {
        Manager.currentStock = currentStock;
        return false;
    }

    public Float getTotalCost(){
        Float sum = 0.00f;
        for (Item item : items){
            sum += item.getPrice();
        }
        return sum;
    }


}
