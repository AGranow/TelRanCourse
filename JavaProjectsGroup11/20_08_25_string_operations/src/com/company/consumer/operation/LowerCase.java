package com.company.consumer.operation;

import com.company.consumer.IStringOperation;

import java.io.BufferedReader;

public class LowerCase implements IStringOperation {

    String name = "LowerCase";

    @Override
    public String operate(String line) {
        return line.toLowerCase();
    }

    @Override
    public String getName() {
        return name;
    }
}
