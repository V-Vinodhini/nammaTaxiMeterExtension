package com.mycompany;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    private static HashMap<Integer, Integer> usage = new HashMap<Integer, Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        Integer previousValue = 1;
        do{
            input = reader.readLine();
            String[] split = input.split(",");
            Double totalDistance = Double.valueOf(split[0].trim());
            Integer mobile = Integer.valueOf(split[1].trim());

            Integer value = usage.get(mobile) != null ? ++previousValue : 1;
            usage.put(mobile, value);
            previousValue = usage.get(mobile);

            Vehicle mini = new Vehicle(Type.MINI);
            Vehicle sedan = new Vehicle(Type.SEDAN);
            Vehicle suv = new Vehicle(Type.SUV);

            System.out.println("Mini - " + mini.getCharges(totalDistance, usage.get(mobile)) + " , "
                    + "Sedan - " + sedan.getCharges(totalDistance, usage.get(mobile)) + " , "
                    + "SUV - " + suv.getCharges(totalDistance, usage.get(mobile)));

        }while(!input.equalsIgnoreCase("exit"));
    }
}
