package com.jnj.EDG;


import com.jnj.EDG.ReadFile.ClientTread;
import com.jnj.EDG.Transfer.PostBooks;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.*;
import java.util.concurrent.ExecutionException;


public class ClientRun {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        run();

    }

    public static void run() throws ExecutionException, InterruptedException {
        String filepath = "C:\\Users\\hli243\\Desktop\\mockUpDataForInterns - test.csv";
        ArrayList<ArrayList<String>> books = ClientTread.mulThreadReadFile(filepath);
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        ArrayList<String> bookIndex = books.get(0);
        //bookIndex.forEach((String)-> System.out.println(String));
        PostBooks postBooks = new PostBooks();
        for (int i = 1; i < books.size(); i++) {
            paramMap.clear();
            ArrayList<String> book = books.get(i);
            if (!book.isEmpty()) {
                //book.forEach((String)-> System.out.println(String));
                int count = 0;
                //if(book.get(3).isEmpty()){
                //    if(book.get(4).isEmpty()){
                //        System.out.println("Key is not found!");
                //        continue;
                //    }else {
                //        paramMap.add("id",book.get(4));
                //    }
                //}else {
                //    paramMap.add("id",book.get(3));
                //}
                paramMap.add("bookName",book.get(0));
                paramMap.add("author",book.get(1));
                paramMap.add("publisher", book.get(2));
                paramMap.add("ISBN",book.get(3));
                paramMap.add("ASIN",book.get(4));
                paramMap.add("category",book.get(5));
                paramMap.add("vendor", book.get(6));
                System.out.println("书本信息：" + paramMap);
                postBooks.postBooks(paramMap);
                System.out.println("第"+i+"本书输出完毕");
                //System.out.println(postBooks.getBooksForObject());
            }
        }
        //System.out.println(postBooks.getBooksForObject());
        System.out.println("##############传输完毕！");
    }
}

//{id=[12], bookName=[Java 9 Programming By Example: Your guide to software development], author=[Peter Verhas], Publisher=[Packt Publishing], ISBN=[978-1786468284], ASIN=[], Category=[Algorithms], vendor=[Amazon]}
//{id=[12], ﻿bookName=[Java 9 Programming By Example: Your guide to software development], author=[Peter Verhas], Publisher=[Packt Publishing], ISBN=[978-1786468284], ASIN=[], Category=[Algorithms], vendor=[Amazon]}