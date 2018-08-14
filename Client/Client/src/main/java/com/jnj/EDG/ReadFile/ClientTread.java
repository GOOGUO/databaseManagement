package com.jnj.EDG.ReadFile;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.*;

public class ClientTread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        mulThreadReadFile("C:\\somethings\\EDG\\P1-databaseManagement\\data\\mockUpDataForInterns - test.csv");
    }
    public static ArrayList<ArrayList<String>> mulThreadReadFile(String filePath) throws ExecutionException, InterruptedException {
        //String filePath = "C:\\somethings\\EDG\\P1-databaseManagement\\data\\mockUpDataForInterns - test.csv";
        File file = new File(filePath);
        long fileLength = file.length();
        int countThread = 2;
        int avgLength = (int)fileLength / countThread;

        ExecutorService pool = Executors.newFixedThreadPool(2);
        Callable c1 = new MyThead(0, avgLength - 1,file);
        Callable c2 = new MyThead(avgLength,(int)fileLength-1,file);

        Future f1 = pool.submit(c1);
        Future f2 = pool.submit(c2);

        //System.out.println("f1.get():"+f1.get());
        //System.out.println("tostring:"+f1.get().toString());

        ArrayList<ArrayList<String>> books = (ArrayList<ArrayList<String>>) f1.get();
        ArrayList<ArrayList<String>> books2 = (ArrayList<ArrayList<String>>) f2.get();
        books.addAll(books2);
        //books.forEach((String) -> String.forEach((string)-> System.out.println(string)));
        //System.out.println(books);

        //System.out.println(f1.get().toString());
        //System.out.println(f2.get().toString());

        pool.shutdown();
        return books;
    }
}

