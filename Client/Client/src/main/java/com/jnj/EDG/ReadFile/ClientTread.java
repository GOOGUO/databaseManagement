package com.jnj.EDG.ReadFile;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.*;

public class ClientTread {

    public static ArrayList<ArrayList<String>> mulThreadReadFile(String filePath) throws ExecutionException, InterruptedException {
        File file = new File(filePath);
        long fileLength = file.length();
        int countThread = 2;
        int avgLength = (int) fileLength / countThread;

        ExecutorService pool = Executors.newFixedThreadPool(2);
        Callable c1 = new MyThead(0, avgLength - 1, file);
        Callable c2 = new MyThead(avgLength, (int) fileLength - 1, file);

        Future f1 = pool.submit(c1);
        Future f2 = pool.submit(c2);


        ArrayList<ArrayList<String>> books = (ArrayList<ArrayList<String>>) f1.get();
        ArrayList<ArrayList<String>> books2 = (ArrayList<ArrayList<String>>) f2.get();
        books.addAll(books2);

        pool.shutdown();
        return books;
    }
}

