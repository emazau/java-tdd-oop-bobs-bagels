package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    private String ID;
    public static HashMap<Item, Integer> currentStock; //Should I use hashMap instead here maybe?
    public static Integer maxCapacity;


    public Manager(String ID, HashMap<Item, Integer> currentStock) {

        this.ID = ID;
        Manager.currentStock = currentStock;
    }

    public static boolean setCurrentStock(Item item, Integer quantity){

        if (item!=null){
            Manager.currentStock.put(item, quantity);
            return true;
        }
        return false;
    }


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }


}
