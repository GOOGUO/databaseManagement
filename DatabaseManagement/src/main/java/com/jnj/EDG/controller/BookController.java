package com.jnj.EDG.controller;
/*
Author;AlexLi
Description;BookController调用BookService，注意下这里的BookController使用@RestController注解来标注，另外URL路径命名按照RESTful风格来命名；


 */

import com.jnj.EDG.entity.Book;

import com.jnj.EDG.repository.BookRepository;
import com.jnj.EDG.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "MySQL/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;

    //client接口来插入书籍
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd :hh:mm:ss");

    @RequestMapping(value = "/books/insert", method = RequestMethod.POST)
    public String insertFormClient(//@RequestParam(value = "id", required = true) String id,
                                   @RequestParam(value = "bookName", required = true) String bookName,
                                   @RequestParam(value = "author", required = true) String author,
                                   @RequestParam(value = "publisher", required = true) String publisher,
                                   @RequestParam(value = "ISBN", required = true) String ISBN,
                                   @RequestParam(value = "ASIN", required = true) String ASIN,
                                   @RequestParam(value = "category", required = true) String category,
                                   @RequestParam(value = "vendor", required = true) String vendor
    ) {

        Book book = new Book(bookName, author, publisher, ISBN, ASIN, category, vendor);
        if (book.getId() == null) {
            return "未发现主键，未添加书籍";
        } else {
            bookRepository.save(book);
            return book.toString();
        }
    }

    //添加书籍信息
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addBook(@RequestParam  String author,String bookName,  String publisher, String ISBN, String ASIN, String category, String vendor) {
        bookService.addBook(bookName,author, publisher, ISBN, ASIN, category, vendor);
        return "书籍添加成功";
    }

    //通过id删除书籍信息
    @RequestMapping(value = "/delete/{id}")
    public String deleteBook(@PathVariable String id) {
        bookService.deleteById(id);
        return "第" + id + "条书籍信息已删除";
    }

    //批量删除书籍信息
    @RequestMapping(value = "/deleteAll")
    public String deleteAllBook() {
        bookService.deleteAllBook();
        return "所有书籍信息已删除";
    }

    //根据id更新书籍信息
    @RequestMapping(value = "/update/id", method = RequestMethod.GET)
    public String updateBook(@RequestParam  String bookName, String author, String publisher, String ISBN, String ASIN, String category, String vendor) {

        bookService.updateBook(bookName,author, publisher, ISBN, ASIN, category, vendor);
        return "更新成功";
    }


    //查询全部书籍信息
    @RequestMapping(value = "/")
    public List<Book> getBooks() {
        return bookService.findAll();
    }

    //通过id查询书籍信息
    @RequestMapping(value = "/search/id/{id}")
    public Optional<Book> getBookById(@PathVariable String id) {
        Optional<Book> book=bookService.findById(id);
        return book;
    }

    //通过bookName查询书籍信息
    @RequestMapping(value = "/search/bookName/{bookName}")
    public List<Book> getBookByBookName(@PathVariable String bookName) {
        List<Book> book = bookService.findByBookName(bookName);
        return book;
    }
}


