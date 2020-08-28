package com.company.consumer.operation;

import com.company.consumer.IStringOperation;

public class Reverse implements IStringOperation {


    @Override
    public String operate(String line) {
        return  new StringBuilder(line).reverse().toString();
    }

    @Override
    public String getName() {
        return null;
    }
}
