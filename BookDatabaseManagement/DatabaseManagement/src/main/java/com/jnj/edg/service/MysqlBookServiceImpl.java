package com.jnj.edg.service;
/*
Author;AlexLi
Description:bookService的实现类(mysql)
 */

import com.jnj.edg.entity.Book;
import com.jnj.edg.exception.BookNotFoundException;
import com.jnj.edg.repository.BookMysqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Service("MysqlBookServiceImpl")
@Transactional
public class MysqlBookServiceImpl implements BookService {
    @Autowired
    private BookMysqlRepository bookRepository;

    //增加书籍的方法
    public String addBook(
            @RequestParam(value = "bookName", required = true) String bookName,
            @RequestParam(value = "author", required = true) String author,
            @RequestParam(value = "publisher", required = true) String publisher,
            @RequestParam(value = "ISBN", required = true) String ISBN,
            @RequestParam(value = "ASIN", required = true) String ASIN,
            @RequestParam(value = "category", required = true) String category,
            @RequestParam(value = "vendor", required = true) String vendor
    ) {
        Book book = new Book(bookName, author, publisher, ISBN, ASIN, category, vendor);
        if (book.getId() == null || book.getAuthor() == "" || book.getPublisher() == "" || book.getBookName() == "") {
            throw new BookNotFoundException("add book error" + ISBN);
        } else {
            bookRepository.save(book);
            return "add book successful: \n" + book.toString();
        }
    }

    //通过id删除书籍的方法
    @Override
    public void deleteById(String id) {
        bookRepository.findById(id);
    }

    @Override
    //删除所有的书籍
    public void deleteAllBook() {
        bookRepository.deleteAll();
    }

    //更新书籍的方法
    @Override
    public String updateBook(@RequestParam(value = "bookName", required = true) String bookName,
                             @RequestParam(value = "author", required = true) String author,
                             @RequestParam(value = "publisher", required = true) String publisher,
                             @RequestParam(value = "ISBN", required = true) String ISBN,
                             @RequestParam(value = "ASIN", required = true) String ASIN,
                             @RequestParam(value = "category", required = true) String category,
                             @RequestParam(value = "vendor", required = true) String vendor) {
        Book book = new Book(bookName, author, publisher, ISBN, ASIN, category, vendor);
        bookRepository.saveAndFlush(book);
        return book.toString();

    }

    //查找所有书籍的方法
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
    //通过bookName查找书籍的方法

    public List<Book> findByBookName(String bookName) {
        return bookRepository.findByBookName(bookName);
    }

    //通过id查找书籍
    public String findById(String id) {
        return bookRepository.findById(id).toString();
    }
}

