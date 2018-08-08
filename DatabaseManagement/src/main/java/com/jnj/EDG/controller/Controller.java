package com.jnj.EDG.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.jnj.EDG.model.Book;
import com.jnj.EDG.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @Autowired
    BookRepository bookRepository;

    @RequestMapping(value = "/books/insert", method = RequestMethod.POST)
    public String insertFromClien(@RequestParam(value = "bookName", required = true) String bookName,
                                  @RequestParam(value = "author", required = true) String author,
                                  @RequestParam(value = "Publisher", required = true) String publisher,
                                  @RequestParam(value = "ISBN",required = true) String ISBN,
                                  @RequestParam(value = "ASIN",required = true) String ASIN,
                                  @RequestParam(value = "Category",required = true) String category,
                                  @RequestParam(value = "vendor",required = true) String vendor) {
        //System.out.println(bookName);

        Book book = new Book(bookName,author,publisher,ISBN,ASIN,category,vendor);
        if(book.getId() == null){
            //缺无主键操作
            return "未发现主键,未添加书籍";
        }
        else {
            //System.out.println("#########=================book" + book);
            bookRepository.save(book);
            return book.toString();
        }
    }

    @RequestMapping(value = "/Books", method = RequestMethod.GET)
    public Collection<Book> findAllBooks(){
        return bookRepository.findAllBooks();
    }
}

/*

  @RequestMapping(value = "/Books", method = RequestMethod.GET)
    public Collection<Book> findAllBooks(){
        Book p1 = new Book(1, "Alice", 20, "Alice@hotmail.com");
        Book p2 = new Book(2,"Bob", 24,"Bob@gmail.com");
        List<Book> results = new ArrayList<Book>();
        results.add(p1);
        results.add(p2);
        return results;


    @RequestMapping(value = "/Book/add", method = RequestMethod.PUT)
    public String addBook(@RequestParam(value = "id", required = true) int id,
                          @RequestParam(value = "name", required = true) String name,
                          @RequestParam(value = "age", required = true) int age,
                          @RequestParam(value = "email", required = true) String email) {
        Book p = new Book(id,name,age,email);

        return p.toString();


    }*/

