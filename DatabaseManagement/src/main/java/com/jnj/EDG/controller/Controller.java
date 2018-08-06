package com.jnj.EDG.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.jnj.EDG.model.Book;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {



/*    @RequestMapping(value = "/Books", method = RequestMethod.GET)
    public Collection<Book> findAllBooks(){
        Book p1 = new Book(1, "Alice", 20, "Alice@hotmail.com");
        Book p2 = new Book(2,"Bob", 24,"Bob@gmail.com");
        List<Book> results = new ArrayList<Book>();
        results.add(p1);
        results.add(p2);
        return results;
    }

    @RequestMapping(value = "/Book/add", method = RequestMethod.PUT)
    public String addBook(@RequestParam(value = "id", required = true) int id,
                          @RequestParam(value = "name", required = true) String name,
                          @RequestParam(value = "age", required = true) int age,
                          @RequestParam(value = "email", required = true) String email) {
        Book p = new Book(id,name,age,email);

        return p.toString();
    }*/

}