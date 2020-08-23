package com.company;

import java.util.Random;

public abstract class Rule {

    int numberOfCredits;

    public Rule(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    public abstract void timeOfLoanIssuance () throws InterruptedException;
}
