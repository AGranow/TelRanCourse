package com.company;

import java.io.*;
//import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedDeque;

public class FileReadingThread extends Thread {

    ConcurrentLinkedDeque<String> queue;

    File fileSourche = new File("fileSource");
//    Scanner scanner = new Scanner(fileSourсe);

    public FileReadingThread(ConcurrentLinkedDeque<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

//        String separator = File.separator;
//        String path = "C:" + separator + "Users" + separator + "avrah" + separator + "Desktop" + separator + "TelRan" + separator + "JavaProgramm" + separator + "JavaProjectsGroup11" + separator + "20_08_25_string_operations" + separator + "src" + separator + "com" + separator + "company";
//        File file = new File(path);


//        while (scanner.hasNext()) {
//            queue.add(scanner.nextLine());
//            scanner.close();
//        }

        try (BufferedReader br = new BufferedReader(new FileReader(fileSourche))) {
            String line;
            while ((line=br.readLine()) != null)
                queue.add(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}