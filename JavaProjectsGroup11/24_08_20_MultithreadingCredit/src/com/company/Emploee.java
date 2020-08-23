package com.company;

import java.sql.Time;
import java.util.Map;

public class Emploee implements Runnable {


    String name;
    Rule rule;
    Map<String, Integer> timeResult;

    public Emploee(String name, Rule rule, Map timeResult) {
        this.name = name;
        this.rule = rule;
        this.timeResult = timeResult;
    }


    @Override
    public void run() {
        long startTime = System.currentTimeMillis();

        try {
            rule.timeOfLoanIssuance();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        long finishTime = System.currentTimeMillis();

        timeResult.put(name, (int) (finishTime - startTime));
    }
}
