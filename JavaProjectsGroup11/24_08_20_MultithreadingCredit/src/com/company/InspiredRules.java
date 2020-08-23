package com.company;

import java.util.Random;

public class InspiredRules extends Rule {

    int minTimes;
    int maxTimes;

    int inspirationMinTime;
    int inspirationMaxTime;

    int numberOfInspirationCredits;
    int probabilityOfInspirationalCredits;


    public InspiredRules(int numberOfCredits, int minTimes, int maxTimes,
                         int inspirationMinTime,
                         int inspirationMaxTime,
                         int numberOfInspirationCredits,
                         int probabilityOfInspirationalCredits) {

        super(numberOfCredits);
        this.minTimes = minTimes;
        this.maxTimes = maxTimes;
        this.inspirationMinTime = inspirationMinTime;
        this.inspirationMaxTime = inspirationMaxTime;
        this.numberOfInspirationCredits = numberOfInspirationCredits;
        this.probabilityOfInspirationalCredits = probabilityOfInspirationalCredits;
    }

    Random random = new Random();

    @Override
    public void timeOfLoanIssuance() throws InterruptedException {
        for (int i = 0; i < numberOfCredits - numberOfInspirationCredits; i++) {
            Thread.sleep(minTimes + random.nextInt(maxTimes - minTimes));
        }

        for (int i = 0; i < numberOfInspirationCredits; i++) {
            if(random.nextInt(10) < 2){
                Thread.sleep(inspirationMinTime + random.nextInt(inspirationMaxTime - inspirationMinTime));
            }else {
                Thread.sleep(minTimes + random.nextInt(maxTimes - minTimes));
            }

        }
    }
}
