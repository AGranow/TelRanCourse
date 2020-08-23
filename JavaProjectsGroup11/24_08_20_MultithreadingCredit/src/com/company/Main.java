package com.company;


import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Map<String, Integer> time = new HashMap<>();
        Rule irM = new StabilityRule(20, 100, 200);
        Rule irP = new StabilityRule(20, 200, 300);
        Rule irV = new InspiredRules(20, 200, 300, 50, 100, 3, 20);


        Thread masha = new Thread(new Emploee("Masha", irM, time));
        Thread petja = new Thread(new Emploee("Petja", irP, time));
        Thread vasja = new Thread(new Emploee("Vasja", irV, time));

        masha.start();
        petja.start();
        vasja.start();

        masha.join();
        petja.join();
        vasja.join();

        for (Map.Entry entry: time.entrySet()) {

            System.out.println(entry.getKey()  + "  " + entry.getValue());

        }

    }
}
