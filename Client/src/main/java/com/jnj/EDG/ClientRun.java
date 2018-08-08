package com.jnj.EDG;


import com.jnj.EDG.ReadFile.ClientTread;
import com.jnj.EDG.Transfer.PostBooks;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.*;
import java.util.concurrent.ExecutionException;


public class ClientRun {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //String a = "{id=[12], bookName=[Java 9 Programming By Example: Your guide to software development], author=[Peter Verhas], Publisher=[Packt Publishing], ISBN=[978-1786468284], ASIN=[], Category=[Algorithms], vendor=[Amazon]}";
        //String b = "{id=[12], bookName=[Java 9 Programming By Example: Your guide to software development], author=[Peter Verhas], Publisher=[Packt Publishing], ISBN=[978-1786468284], ASIN=[], Category=[Algorithms], vendor=[Amazon]}";
        //System.out.println("====="+a.equals(b));
        //bookName=1&author=2&publisher=3&ISBN=4&ASIN=5&category=6&vendor=7
        run();
        //PostBooks postBooks = new PostBooks();
        //MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        //String urlString = "";
        //paramMap.add("id",1);
        //paramMap.add("bookName","Java 9 Programming By Example: Your guide to software development");
        //paramMap.add("author","Peter Verhas");
        //paramMap.add("Publisher", "Packt Publishing");
        //paramMap.add("ISBN","978-1786468284");
        //paramMap.add("ASIN","");
        //paramMap.add("Category","Algorithms");
        //paramMap.add("vendor", "Amazon");
        //System.out.println("paramMap = "+paramMap);

        //paramMap.toString();
        //System.out.println("paramMap = "+paramMap);

        //System.out.println(postBooks.getBooksForObject());
        //postBooks.postBooks(paramMap);
        ////System.out.println(postBooks.sendBookToServer(urlString));
        //System.out.println(postBooks.getBooksForObject());


        /*PostBooks postBooks = new PostBooks();
        Book book1 = new Book(1,"2",3,"4");
        Book book2 = new Book(11,"22",33,"44");
        Person p1 = new Person(1,"2",3,"4");
        Person p2 = new Person(11,"22",33,"44");
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        paramMap.add("id", "1");
        paramMap.add("name", "2");
        paramMap.add("age", "3");
        paramMap.add("email", "4");

        Set<String> keySet = paramMap.keySet();
        System.out.println(keySet.toArray()[0]);
        Collection<Person> p12 = new ArrayList<>();
        p12.add(p1);
        p12.add(p2);
        System.out.println(paramMap.toString());

        System.out.println(postBooks.getBooksForObject());
        //postBooks.putBooks(p1);
        postBooks.postBooks(paramMap);
        System.out.println(postBooks.getBooksForObject());
        //System.out.println(postBooks.postBooksForLocation(p1));
        //System.out.println(postBooks.postBooksForLocation(p2));*/
    }

    public static void run() throws ExecutionException, InterruptedException {
        String filepath = "C:\\somethings\\EDG\\P1-databaseManagement\\data\\mockUpDataForInterns - test.csv";
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
                paramMap.add("Publisher", book.get(2));
                paramMap.add("ISBN",book.get(3));
                paramMap.add("ASIN",book.get(4));
                paramMap.add("Category",book.get(5));
                paramMap.add("vendor", book.get(6));
                //System.out.println("书本信息：" + paramMap);
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