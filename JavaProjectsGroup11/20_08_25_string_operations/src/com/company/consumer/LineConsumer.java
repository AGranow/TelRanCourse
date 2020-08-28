package com.company.consumer;

import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

public class LineConsumer extends Thread {  //   Consumer - потребитель

    ConcurrentLinkedDeque<String> queue;
    Map<String, IStringOperation> operationByName;

    public LineConsumer(ConcurrentLinkedDeque<String> queue, Map<String, IStringOperation> operationByName) {
        this.queue = queue;
        this.operationByName = operationByName;
    }


    @Override
    public void run() {
        while (true) {
            String line = queue.removeLast(); // Получение с удалением элемента из очереди,
            // при необходимости ожидание пока элемент не станет доступным.

            //TODO  split the line on parts : the text to operate on and the name of the operation
            //TODO  разделить строку на части: текст, над которым нужно работать, и название операции
            String[] splitLine = line.split("#");
            String text = splitLine[0];
            String operationName = splitLine[1];

            IStringOperation operation = operationByName.get(operationName);
            String res = operation.operate(text);
            }


        }


    }

