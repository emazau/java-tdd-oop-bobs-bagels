package com.booleanuk.core;

import java.util.Map;

public class Manager {
    private String ID;

    public Manager(String ID) {
        this.ID = ID;
    }

    public static boolean setCurrentStock(Item item, Integer quantity){
        return true;
    }


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }


}
