package com.mycompany;

import java.util.HashMap;

import static com.mycompany.Constants.*;

public class Vehicle  {
    private Type type;

    Vehicle(Type type){
        this.type = type;
    }
    public Double getCharges(Double totalDistance, Integer count) {
        final HashMap<String, Fare> fare = type.getFare();
        final Fare total = fare.get(TOTAL);
        final Fare base = fare.get(BASE);
        final Fare next = fare.get(NEXT);
        final Fare additional = fare.get(ADDITIONAL);
        double charge = 0.0;
        if(total != null && totalDistance > total.getKm()){
            charge = totalDistance * total.getAmt();
        }else if(totalDistance <= base.getKm()){
            charge =  base.getAmt();
        }else if(totalDistance <= (base.getKm() + next.getKm())){
            charge = base.getAmt() +  (next.getAmt()*( totalDistance -base.getKm() )) ;
        }else if(totalDistance > (base.getKm() + next.getKm())){
            charge = base.getAmt() +  next.getAmt()*next.getKm() + additional.getAmt()*( totalDistance -base.getKm() -next.getKm()) ;
        }
        if (count ==1 ){
            charge = charge - (charge * 0.25);
        } else if (count % 2 != 0){
            charge = charge - (charge * 0.10);
        }
        return charge;
    }
}
