package com.company;

import java.util.Random;

public class StabilityRule extends Rule {

    int minTimes;
    int maxTimes;

    public StabilityRule(int numberOfCredits, int minTimes, int maxTimes) {
        super(numberOfCredits);
        this.minTimes = minTimes;
        this.maxTimes = maxTimes;
    }

    Random random = new Random();

    @Override
    public void timeOfLoanIssuance() throws InterruptedException {
        for (int i = 0; i < this.numberOfCredits; i++) {
            Thread.sleep(minTimes + random.nextInt(maxTimes -minTimes));
        }
    }
}
