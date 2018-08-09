
package com.jnj.EDG.controller;

import com.jnj.EDG.entity.BookF;
import com.jnj.EDG.service.BookFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

@RestController
//@Mapping("/")
public class FileController {
    @Autowired
    BookFileService bookFileRepository;

    @RequestMapping(value = "/books/insert", method = RequestMethod.POST)
    public String insertFromClient(@RequestParam(value = "bookName", required = true) String bookName,
                                  @RequestParam(value = "author", required = true) String author,
                                  @RequestParam(value = "publisher", required = true) String publisher,
                                  @RequestParam(value = "ISBN",required = true) String ISBN,
                                  @RequestParam(value = "ASIN",required = true) String ASIN,
                                  @RequestParam(value = "category",required = true) String category,
                                  @RequestParam(value = "vendor",required = true) String vendor) throws IOException, ClassNotFoundException {
        //System.out.println(bookName);

        BookF book = new BookF(bookName,author,publisher,ISBN,ASIN,category,vendor);
        if(book.getId() == null){
            //缺无主键操作
            return "未发现主键,未添加书籍";
        }
        else {
            //System.out.println("#########=================book" + book);


            bookFileRepository.addBook(book);
            //return book.toString();
            return book.toString();
        }
    }
    @RequestMapping(value = "/books/add", method = RequestMethod.GET)
    public String addBook(@RequestParam(value = "bookName", required = true) String bookName,
                                  @RequestParam(value = "author", required = true) String author,
                                  @RequestParam(value = "publisher", required = true) String publisher,
                                  @RequestParam(value = "ISBN",required = true) String ISBN,
                                  @RequestParam(value = "ASIN",required = true) String ASIN,
                                  @RequestParam(value = "category",required = true) String category,
                                  @RequestParam(value = "vendor",required = true) String vendor) throws IOException, ClassNotFoundException {
        //System.out.println(bookName);

        BookF book = new BookF(bookName,author,publisher,ISBN,ASIN,category,vendor);
        if(book.getId() == null){
            //缺无主键操作
            return "未发现主键,未添加书籍";
        }
        else {
            //System.out.println("#########=================book" + book);
            bookFileRepository.addBook(book);
            return book.toString();
        }
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public Collection<BookF> findAllBooks() throws IOException, ClassNotFoundException {
        return bookFileRepository.findAllBooks();
        //return bookRepository.findAllBooks();
    }
    @RequestMapping(value = "/BookFs/id/{id}", method = RequestMethod.GET)
    public BookF findBooksById(@PathVariable String id ) throws IOException, ClassNotFoundException {
        return bookFileRepository.findBookByid(id);
        //return bookRepository.findAllBooks();
    }
    @RequestMapping(value = "/books/bookName/{bookName}", method = RequestMethod.GET)
    public Collection<BookF> findBooksByBookName(@PathVariable String bookName ) throws IOException, ClassNotFoundException {
        System.out.println("11111111111111111111111111111111111");
        return bookFileRepository.findBookByBookName(bookName);
        //return bookRepository.findAllBooks();
    }
    //delete all object
    @RequestMapping(value = "/books/deleteAll", method = RequestMethod.GET)
    public String deleteAllBooks() throws IOException, ClassNotFoundException {
        return bookFileRepository.deleteAllBooks();
        //return bookRepository.findAllBooks();
    }
    //delete by id
    @RequestMapping(value = "/books/deleteby/id/{id}", method = RequestMethod.GET)
    public List<BookF> deleteBookById(@PathVariable String id) throws IOException, ClassNotFoundException {
        return bookFileRepository.deleteBookByid(id);
        //return bookRepository.findAllBooks();
    }
    @RequestMapping(value = "/books/update/id/{id}/bookName/{bookName}/{bookNameChanged}", method = RequestMethod.GET)
    public List<BookF> deleteBookById(@PathVariable String id,
                                     @PathVariable String bookName,
                                     @PathVariable String bookNameChanged) throws IOException, ClassNotFoundException {
        return bookFileRepository.updateBookWithBookName(id,bookName,bookNameChanged);
        //return bookRepository.findAllBooks();
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

