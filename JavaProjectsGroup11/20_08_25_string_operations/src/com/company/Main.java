package com.company;

import com.company.consumer.IStringOperation;
import com.company.consumer.LineConsumer;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;


public class Main {

    public static void main(String[] args) throws IOException {

        ConcurrentLinkedDeque<String> queue = new ConcurrentLinkedDeque<>();
        ConcurrentHashMap<String, IStringOperation> operationByName = new ConcurrentHashMap<>();


        FileReadingThread frt = new FileReadingThread(queue);
        LineConsumer lc = new LineConsumer(queue, operationByName);

        frt.start();
        lc.start();



    }
}
