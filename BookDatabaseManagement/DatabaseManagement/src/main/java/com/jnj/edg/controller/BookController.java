package com.jnj.edg.controller;
/*
/*
Author:
Description:公用的controller
 */

import com.jnj.edg.entity.Book;
import com.jnj.edg.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(value = "/books")
public class BookController {

    //切换数据源MySQL/gemfire/file
    private BookService bookService;

    public BookController(ControllerHelper controllerHelper) {
        bookService = (BookService) controllerHelper.getServiceMap();
    }


    //client接口来插入书籍
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd :hh:mm:ss");

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String insertFormClient(@RequestParam String bookName, String author, String publisher, String ISBN, String ASIN, String category, String vendor) throws IOException, ClassNotFoundException {
        bookService.addBook(bookName, author, publisher, ISBN, ASIN, category, vendor);

        return "书籍添加成功";

    }

    //添加书籍信息
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addBook(@RequestParam String bookName, String author, String publisher, String ISBN, String ASIN, String category, String vendor) throws IOException, ClassNotFoundException {
        bookService.addBook(bookName, author, publisher, ISBN, ASIN, category, vendor);
        return "书籍添加成功";
    }

    //通过id删除书籍信息
    @RequestMapping(value = "/delete/{id}")
    public String deleteBook(@PathVariable String id) throws IOException, ClassNotFoundException {
        bookService.deleteById(id);
        return "第" + id + "条书籍信息已删除";
    }

    //批量删除书籍信息
    @RequestMapping(value = "/deleteAll")
    public String deleteAllBook() throws IOException {
        bookService.deleteAllBook();
        return "所有书籍信息已删除";
    }

    //根据id更新书籍信息
    @RequestMapping(value = "/update/id", method = RequestMethod.GET)
    public String updateBook(@RequestParam String bookName, String author, String publisher, String ISBN, String ASIN, String category, String vendor) throws IOException, ClassNotFoundException {

        bookService.updateBook(bookName, author, publisher, ISBN, ASIN, category, vendor);
        return "更新成功";
    }


    //查询全部书籍信息
    @RequestMapping(value = "")
    public List<Book> getBooks() throws IOException, ClassNotFoundException {
        return bookService.findAll();
    }

    //通过id查询书籍信息
    @RequestMapping(value = "/search/id/{id}")
    public String getBookById(@PathVariable String id) throws IOException, ClassNotFoundException {
        return bookService.findById(id);
    }

    //通过bookName查询书籍信息
    @RequestMapping(value = "/search/bookName/{bookName}")
    public List<Book> getBookByBookName(@PathVariable String bookName) throws IOException, ClassNotFoundException {
        List<Book> book = bookService.findByBookName(bookName);
        return book;
    }
}


