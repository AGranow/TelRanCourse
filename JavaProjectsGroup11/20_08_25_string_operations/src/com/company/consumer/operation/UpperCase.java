package com.company.consumer.operation;

import com.company.consumer.IStringOperation;

public class UpperCase implements IStringOperation {

    String name = "UpperCase";

    @Override
    public String operate(String line) {
        return line.toUpperCase();
    }

    @Override
    public String getName() {
        return name;
    }
}
