package com.jnj.EDG.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

import com.jnj.EDG.model.Book;
import com.jnj.EDG.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @Autowired
    BookRepository bookRepository;

    Date date = new Date();
    SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");

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

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public Collection<Book> findAllBooks(){
        Book b1 = new Book("java", "Alice", "javaPub", "ISBN1",null,"computer","vendor1");
        Book b2 = new Book("python","Bob", "pythonPub","ISBN","ASIN1","computer","vendor2");
        //List<Book> results = new ArrayList<Book>();
        bookRepository.save(b1);
        bookRepository.save(b2);
//        results.add(b1);
//        results.add(b2);
        return bookRepository.findAllBooks();
    }

    @RequestMapping(value = "/book/ISBN/{ISBN}", method = RequestMethod.GET)
    public Collection<Book> findBookByISBN(@PathVariable String ISBN){
        return bookRepository.findBookByISBN(ISBN);
    }

    @RequestMapping(value = "/book/ASIN/{ASIN}", method = RequestMethod.GET)
    public Collection<Book> findBookByASIN(@PathVariable String ASIN){
        return bookRepository.findBookByASIN(ASIN);
    }

    @RequestMapping(value = "/book/author/{author}", method = RequestMethod.GET)
    public Collection<Book> findBookByAuthor(@PathVariable String author){
        return bookRepository.findBookByAuthor(author);
    }

    @RequestMapping(value = "/book/bookname/{bookname}", method = RequestMethod.GET)
    public Collection<Book> findBookByBookname(@PathVariable String bookname){
        return bookRepository.findBookByBookName(bookname);
    }

    @RequestMapping(value = "/book/publisher/{publisher}", method = RequestMethod.GET)
    public Collection<Book> findBookByPublisher(@PathVariable String publisher){
        return bookRepository.findBookByPublisher(publisher);
    }

    @RequestMapping(value = "/book/update",method = RequestMethod.PUT)
    public String updateBookByName(@RequestParam(value = "bookName", required = true) String bookName,
                                   @RequestParam(value = "author", required = true) String author,
                                   @RequestParam(value = "publisher", required = true) String publisher,
                                   @RequestParam(value = "ISBN", required = true) String ISBN,
                                   @RequestParam(value = "ASIN", required = true) String ASIN,
                                   @RequestParam(value = "category", required = true) String category,
                                   @RequestParam(value = "vendor", required = true) String vendor){
        Book b = new Book(bookName,author,publisher,ISBN,ASIN,category,vendor);
        bookRepository.save(b);
        return "update book successful: \n" + b.toString();
    }

    @RequestMapping(value = "/book/deletebyBookname/{bookname}",method = RequestMethod.GET)
    public String deleteBookByNameBookname(@PathVariable String bookname){
        Collection<Book> bookDelete = findBookByBookname(bookname);
        bookRepository.deleteAll(bookDelete);
        return "delete by bookname successful: \n" + bookDelete.toString();
    }

    @RequestMapping(value = "/book/deletebooks",method = RequestMethod.GET)
    public String deletebooks(){
        bookRepository.deleteAll();
        return "delete all books successful: \n";
    }

    @RequestMapping(value = "/book/deletebyAuthor/{author}",method = RequestMethod.GET)
    public String deleteBookByNameISDN(@PathVariable String author){
        Collection<Book> bookDelete = findBookByAuthor(author);
        bookRepository.deleteAll(bookDelete);
        return "delete by author successful: \n" + bookDelete.toString();
    }

    @RequestMapping(value = "/book/deletebyISBN/{ISBN}",method = RequestMethod.GET)
    public String deleteBookByNameISBN(@PathVariable String ISBN){
        Collection<Book> bookDelete = findBookByISBN(ISBN);
        bookRepository.deleteAll(bookDelete);
        return "delete by ISBN successful: \n" + bookDelete.toString();
    }

    @RequestMapping(value = "/book/deletebyASIN/{ASIN}",method = RequestMethod.GET)
    public String deleteBookByNameASIN(@PathVariable String ASIN){
        Collection<Book> bookDelete = findBookByASIN(ASIN);
        bookRepository.deleteAll(bookDelete);
        return "delete by ASIN successful: \n" + bookDelete.toString();
    }

    @RequestMapping(value = "/book/deletebyPublisher/{publisher}",method = RequestMethod.GET)
    public String deleteBookByNamePublisher(@PathVariable String publisher){
        Collection<Book> bookDelete = findBookByPublisher(publisher);
        bookRepository.deleteAll(bookDelete);
        return "delete by publisher successful: \n" + bookDelete.toString();
    }

    @RequestMapping(value = "/book/add", method = RequestMethod.PUT)
    public String addBook(@RequestParam(value = "bookName", required = true) String bookName,
                          @RequestParam(value = "author", required = true) String author,
                          @RequestParam(value = "publisher", required = true) String publisher,
                          @RequestParam(value = "ISBN", required = true) String ISBN,
                          @RequestParam(value = "ASIN", required = true) String ASIN,
                          @RequestParam(value = "category", required = true) String category,
                          @RequestParam(value = "vendor", required = true) String vendor) {
        Book b = new Book(bookName,author,publisher,ISBN,ASIN,category,vendor);
        if(b.getId() == null||b.getAuthor()==""||b.getPublisher()==""||b.getBookName()==""){
            //缺必要字段内容
            return "未发现主键,未添加书籍"+"\"---timestamp\": " + dateFormat.format(date) +  " \"status\": 500\n";
        }
        else {
            bookRepository.save(b);
            return "add book successful: \n" + b.toString();
        }
    }

}



