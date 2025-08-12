package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    public static HashMap<Item, Integer> currentStock; //Should I use hashMap instead here maybe?
    public static Integer maxCapacity;


    public Manager(HashMap<Item, Integer> currentStock, Integer maxCapacity) {

        Manager.currentStock = currentStock;
        Manager.maxCapacity = maxCapacity;
    }

    public boolean setMaxCapacity(Integer maxCapacity) {
        if (maxCapacity >0 && maxCapacity <= 100){
            Manager.maxCapacity = maxCapacity;
            return true;
        }
        return false;
    }

    public static boolean setCurrentStock(Item item, Integer quantity){
        if (item!=null){
            Manager.currentStock.put(item, quantity);
            return true;
        }
        return false;
    }




}
