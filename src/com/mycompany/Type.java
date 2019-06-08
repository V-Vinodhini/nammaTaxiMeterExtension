package com.mycompany;

import java.util.HashMap;

import static com.mycompany.Constants.*;

public enum Type {
    MINI("mini"), SEDAN("sedan"), SUV("suv");

    private final HashMap<String, Fare> fare = new HashMap<>();

    Type(String type) {

        switch (type){
            case "mini":
                fare.put(BASE,new Fare(3,50));
                fare.put(NEXT,new Fare(15,10));
                fare.put(ADDITIONAL,new Fare(1,8));
                fare.put(TOTAL,new Fare(75,8));
                break;
            case "sedan":
                fare.put(BASE, new Fare(5, 80));
                fare.put(NEXT, new Fare(15, 12));
                fare.put(ADDITIONAL, new Fare(1, 10));
                fare.put(TOTAL, new Fare(100, 10));
                break;
            case "suv":
                fare.put(BASE, new Fare(5, 100));
                fare.put(NEXT, new Fare(15, 15));
                fare.put(ADDITIONAL, new Fare(1, 12));
                break;
        }
    }

    public HashMap<String, Fare> getFare(){
        return fare;
    }
}
